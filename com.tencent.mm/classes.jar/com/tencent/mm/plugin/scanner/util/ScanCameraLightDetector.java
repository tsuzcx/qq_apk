package com.tencent.mm.plugin.scanner.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public class ScanCameraLightDetector
  implements SensorEventListener
{
  public static final ScanCameraLightDetector nPf = new ScanCameraLightDetector();
  public ah handler;
  public long nPg = -1L;
  public Sensor nPh;
  public boolean nPi = false;
  private float nPj = -1.0F;
  public HandlerThread nPk;
  public SensorManager sensorManager;
  
  private static native int calcLumNative(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    y.d("MicroMsg.ScanCameraLightDetector", "onAccuracyChanged");
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    paramSensorEvent = paramSensorEvent.values;
    if ((paramSensorEvent != null) && (paramSensorEvent.length > 0)) {
      this.nPj = paramSensorEvent[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector
 * JD-Core Version:    0.7.0.1
 */