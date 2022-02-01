package com.tencent.youtu.ytagreflectlivecheck.worker;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;

public class SensorManagerWorker
{
  private static final String TAG = "MicroMsg.LightSensor";
  private boolean mHasStarted = false;
  private LightSensorListener mLightSensorListener;
  private OnGetValue mOnGetValue;
  private SensorManager mSensorManager;
  
  public static SensorManagerWorker getInstance()
  {
    AppMethodBeat.i(43414);
    SensorManagerWorker localSensorManagerWorker = Singleton.instance;
    AppMethodBeat.o(43414);
    return localSensorManagerWorker;
  }
  
  public float getLux()
  {
    AppMethodBeat.i(43416);
    if (this.mLightSensorListener != null)
    {
      new StringBuilder("Light lux: ").append(this.mLightSensorListener.lux);
      float f = this.mLightSensorListener.lux;
      AppMethodBeat.o(43416);
      return f;
    }
    AppMethodBeat.o(43416);
    return -1.0F;
  }
  
  public int start(Context paramContext, OnGetValue paramOnGetValue)
  {
    AppMethodBeat.i(43415);
    if (this.mHasStarted)
    {
      YTAGReflectLiveCheckJNIInterface.nativeLog("MicroMsg.LightSensor", "[SensorManagerWorker.start] light sensor has started");
      AppMethodBeat.o(43415);
      return 2;
    }
    this.mHasStarted = true;
    this.mSensorManager = ((SensorManager)paramContext.getApplicationContext().getSystemService("sensor"));
    paramContext = this.mSensorManager.getDefaultSensor(5);
    if (paramContext != null)
    {
      this.mLightSensorListener = new LightSensorListener(null);
      this.mSensorManager.registerListener(this.mLightSensorListener, paramContext, 3);
      this.mOnGetValue = paramOnGetValue;
      AppMethodBeat.o(43415);
      return 0;
    }
    YTAGReflectLiveCheckJNIInterface.nativeLog("MicroMsg.LightSensor", "[SensorManagerWorker.start] System do not have lightSensor");
    AppMethodBeat.o(43415);
    return 1;
  }
  
  public void stop()
  {
    AppMethodBeat.i(43417);
    if ((!this.mHasStarted) || (this.mSensorManager == null))
    {
      AppMethodBeat.o(43417);
      return;
    }
    this.mHasStarted = false;
    this.mSensorManager.unregisterListener(this.mLightSensorListener);
    AppMethodBeat.o(43417);
  }
  
  class LightSensorListener
    implements SensorEventListener
  {
    private float lux;
    
    private LightSensorListener() {}
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      AppMethodBeat.i(43412);
      if (paramSensorEvent.sensor.getType() == 5)
      {
        this.lux = paramSensorEvent.values[0];
        if (SensorManagerWorker.this.mOnGetValue != null) {
          SensorManagerWorker.this.mOnGetValue.onGetValue(this.lux);
        }
      }
      AppMethodBeat.o(43412);
    }
  }
  
  public static abstract interface OnGetValue
  {
    public abstract void onGetValue(float paramFloat);
  }
  
  static class Singleton
  {
    private static SensorManagerWorker instance;
    
    static
    {
      AppMethodBeat.i(43413);
      instance = new SensorManagerWorker(null);
      AppMethodBeat.o(43413);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.worker.SensorManagerWorker
 * JD-Core Version:    0.7.0.1
 */