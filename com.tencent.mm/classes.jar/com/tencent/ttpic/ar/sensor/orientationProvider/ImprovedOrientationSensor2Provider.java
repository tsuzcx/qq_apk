package com.tencent.ttpic.ar.sensor.orientationProvider;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.tencent.ttpic.ar.sensor.representation.MatrixF4x4;
import com.tencent.ttpic.ar.sensor.representation.Quaternion;
import java.util.List;

public class ImprovedOrientationSensor2Provider
  extends OrientationProvider
{
  private static final double EPSILON = 0.1000000014901161D;
  private static final float INDIRECT_INTERPOLATION_WEIGHT = 0.01F;
  private static final float NS2S = 1.0E-009F;
  private static final float OUTLIER_PANIC_THRESHOLD = 0.75F;
  private static final float OUTLIER_THRESHOLD = 0.85F;
  private static final int PANIC_THRESHOLD = 60;
  private final Quaternion correctedQuaternion = new Quaternion();
  private final Quaternion deltaQuaternion = new Quaternion();
  private double gyroscopeRotationVelocity = 0.0D;
  private final Quaternion interpolatedQuaternion = new Quaternion();
  private int panicCounter;
  private boolean positionInitialised = false;
  private Quaternion quaternionGyroscope = new Quaternion();
  private Quaternion quaternionRotationVector = new Quaternion();
  private final float[] temporaryQuaternion = new float[4];
  private long timestamp;
  
  public ImprovedOrientationSensor2Provider(SensorManager paramSensorManager)
  {
    super(paramSensorManager);
    this.sensorList.add(paramSensorManager.getDefaultSensor(4));
    this.sensorList.add(paramSensorManager.getDefaultSensor(11));
  }
  
  private void setOrientationQuaternionAndMatrix(Quaternion paramQuaternion)
  {
    this.correctedQuaternion.set(paramQuaternion);
    this.correctedQuaternion.w(-this.correctedQuaternion.w());
    synchronized (this.synchronizationToken)
    {
      this.currentOrientationQuaternion.copyVec4(paramQuaternion);
      SensorManager.getRotationMatrixFromVector(this.currentOrientationRotationMatrix.matrix, this.correctedQuaternion.array());
      return;
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 11)
    {
      SensorManager.getQuaternionFromVector(this.temporaryQuaternion, paramSensorEvent.values);
      this.quaternionRotationVector.setXYZW(this.temporaryQuaternion[1], this.temporaryQuaternion[2], this.temporaryQuaternion[3], -this.temporaryQuaternion[0]);
      if (!this.positionInitialised)
      {
        this.quaternionGyroscope.set(this.quaternionRotationVector);
        this.positionInitialised = true;
      }
    }
    while (paramSensorEvent.sensor.getType() != 4) {
      return;
    }
    if (this.timestamp != 0L)
    {
      float f7 = (float)(paramSensorEvent.timestamp - this.timestamp);
      float f6 = paramSensorEvent.values[0];
      float f5 = paramSensorEvent.values[1];
      float f4 = paramSensorEvent.values[2];
      this.gyroscopeRotationVelocity = Math.sqrt(f6 * f6 + f5 * f5 + f4 * f4);
      float f3 = f4;
      float f2 = f5;
      float f1 = f6;
      if (this.gyroscopeRotationVelocity > 0.1000000014901161D)
      {
        f1 = (float)(f6 / this.gyroscopeRotationVelocity);
        f2 = (float)(f5 / this.gyroscopeRotationVelocity);
        f3 = (float)(f4 / this.gyroscopeRotationVelocity);
      }
      double d2 = this.gyroscopeRotationVelocity * (f7 * 1.0E-009F) / 2.0D;
      double d1 = Math.sin(d2);
      d2 = Math.cos(d2);
      this.deltaQuaternion.setX((float)(f1 * d1));
      this.deltaQuaternion.setY((float)(f2 * d1));
      this.deltaQuaternion.setZ((float)(f3 * d1));
      this.deltaQuaternion.setW(-(float)d2);
      this.deltaQuaternion.multiplyByQuat(this.quaternionGyroscope, this.quaternionGyroscope);
      f1 = this.quaternionGyroscope.dotProduct(this.quaternionRotationVector);
      if (Math.abs(f1) >= 0.85F) {
        break label417;
      }
      if (Math.abs(f1) < 0.75F) {
        this.panicCounter += 1;
      }
      setOrientationQuaternionAndMatrix(this.quaternionGyroscope);
      if (this.panicCounter > 60)
      {
        if (this.gyroscopeRotationVelocity >= 3.0D) {
          break label468;
        }
        setOrientationQuaternionAndMatrix(this.quaternionRotationVector);
        this.quaternionGyroscope.copyVec4(this.quaternionRotationVector);
        this.panicCounter = 0;
      }
    }
    for (;;)
    {
      this.timestamp = paramSensorEvent.timestamp;
      return;
      label417:
      this.quaternionGyroscope.slerp(this.quaternionRotationVector, this.interpolatedQuaternion, (float)(0.009999999776482582D * this.gyroscopeRotationVelocity));
      setOrientationQuaternionAndMatrix(this.interpolatedQuaternion);
      this.quaternionGyroscope.copyVec4(this.interpolatedQuaternion);
      this.panicCounter = 0;
      break;
      label468:
      String.format("Panic reset delayed due to ongoing motion (user is still shaking the device). Gyroscope Velocity: %.2f > 3", new Object[] { Double.valueOf(this.gyroscopeRotationVelocity) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.ar.sensor.orientationProvider.ImprovedOrientationSensor2Provider
 * JD-Core Version:    0.7.0.1
 */