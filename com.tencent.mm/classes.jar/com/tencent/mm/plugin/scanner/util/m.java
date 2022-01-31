package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class m
  implements SensorEventListener
{
  public static final m nPF = new m();
  public SensorManager aVT = (SensorManager)ae.getContext().getSystemService("sensor");
  public Sensor nPB = this.aVT.getDefaultSensor(1);
  public float[] nPC = new float[3];
  public int nPD;
  private long nPE;
  
  public final long byA()
  {
    if (this.nPD >= 5) {
      return this.nPE;
    }
    return 0L;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 1)
    {
      paramSensorEvent = paramSensorEvent.values;
      y.d("MicroMsg.ScanStableDetector", "x:%f,y:%f,z:%f", new Object[] { Float.valueOf(paramSensorEvent[0]), Float.valueOf(paramSensorEvent[1]), Float.valueOf(paramSensorEvent[2]) });
      if ((this.nPC[0] == 0.0F) && (this.nPC[1] == 0.0F) && (this.nPC[2] == 0.0F))
      {
        this.nPC[0] = paramSensorEvent[0];
        this.nPC[1] = paramSensorEvent[1];
        this.nPC[2] = paramSensorEvent[2];
      }
    }
    else
    {
      return;
    }
    if ((Math.abs(paramSensorEvent[0] - this.nPC[0]) > 0.7F) || (Math.abs(paramSensorEvent[1] - this.nPC[1]) > 0.7F) || (Math.abs(paramSensorEvent[2] - this.nPC[2]) > 0.7F))
    {
      y.d("MicroMsg.ScanStableDetector", "scan unstable");
      this.nPD = 0;
    }
    for (;;)
    {
      this.nPC[0] = paramSensorEvent[0];
      this.nPC[1] = paramSensorEvent[1];
      this.nPC[2] = paramSensorEvent[2];
      return;
      if (this.nPD == 0) {
        this.nPE = System.currentTimeMillis();
      }
      this.nPD += 1;
      if (this.nPD >= 5) {
        y.d("MicroMsg.ScanStableDetector", "scan stable");
      }
    }
  }
  
  public final void stop()
  {
    y.i("MicroMsg.ScanStableDetector", "stop detect scan stable");
    if (this.aVT != null)
    {
      y.i("MicroMsg.ScanStableDetector", "unregister accelerate listener");
      this.aVT.unregisterListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.m
 * JD-Core Version:    0.7.0.1
 */