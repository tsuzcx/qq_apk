package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class i
  implements SensorEventListener
{
  public static final i xlZ;
  public SensorManager mSensorManager;
  public Sensor xlV;
  public float[] xlW;
  public int xlX;
  private long xlY;
  
  static
  {
    AppMethodBeat.i(52061);
    xlZ = new i();
    AppMethodBeat.o(52061);
  }
  
  private i()
  {
    AppMethodBeat.i(52059);
    this.xlW = new float[3];
    this.mSensorManager = ((SensorManager)ai.getContext().getSystemService("sensor"));
    this.xlV = this.mSensorManager.getDefaultSensor(1);
    AppMethodBeat.o(52059);
  }
  
  public final long dBr()
  {
    if (this.xlX >= 5) {
      return this.xlY;
    }
    return 0L;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(52060);
    if (paramSensorEvent.sensor.getType() == 1)
    {
      paramSensorEvent = paramSensorEvent.values;
      ac.d("MicroMsg.ScanStableDetector", "x:%f,y:%f,z:%f", new Object[] { Float.valueOf(paramSensorEvent[0]), Float.valueOf(paramSensorEvent[1]), Float.valueOf(paramSensorEvent[2]) });
      if ((this.xlW[0] == 0.0F) && (this.xlW[1] == 0.0F) && (this.xlW[2] == 0.0F))
      {
        this.xlW[0] = paramSensorEvent[0];
        this.xlW[1] = paramSensorEvent[1];
        this.xlW[2] = paramSensorEvent[2];
        AppMethodBeat.o(52060);
        return;
      }
      if ((Math.abs(paramSensorEvent[0] - this.xlW[0]) <= 0.7F) && (Math.abs(paramSensorEvent[1] - this.xlW[1]) <= 0.7F) && (Math.abs(paramSensorEvent[2] - this.xlW[2]) <= 0.7F)) {
        break label227;
      }
      ac.d("MicroMsg.ScanStableDetector", "scan unstable");
      this.xlX = 0;
    }
    for (;;)
    {
      this.xlW[0] = paramSensorEvent[0];
      this.xlW[1] = paramSensorEvent[1];
      this.xlW[2] = paramSensorEvent[2];
      AppMethodBeat.o(52060);
      return;
      label227:
      if (this.xlX == 0) {
        this.xlY = System.currentTimeMillis();
      }
      this.xlX += 1;
      if (this.xlX >= 5) {
        ac.d("MicroMsg.ScanStableDetector", "scan stable");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.i
 * JD-Core Version:    0.7.0.1
 */