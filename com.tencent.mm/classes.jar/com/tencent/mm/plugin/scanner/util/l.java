package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class l
  implements SensorEventListener
{
  public static final l Pjm;
  public Sensor Pji;
  public float[] Pjj;
  public int Pjk;
  private long Pjl;
  public SensorManager mSensorManager;
  
  static
  {
    AppMethodBeat.i(52061);
    Pjm = new l();
    AppMethodBeat.o(52061);
  }
  
  private l()
  {
    AppMethodBeat.i(52059);
    this.Pjj = new float[3];
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    this.Pji = this.mSensorManager.getDefaultSensor(1);
    AppMethodBeat.o(52059);
  }
  
  public final long gUd()
  {
    if (this.Pjk >= 5) {
      return this.Pjl;
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
      Log.d("MicroMsg.ScanStableDetector", "x:%f,y:%f,z:%f", new Object[] { Float.valueOf(paramSensorEvent[0]), Float.valueOf(paramSensorEvent[1]), Float.valueOf(paramSensorEvent[2]) });
      if ((this.Pjj[0] == 0.0F) && (this.Pjj[1] == 0.0F) && (this.Pjj[2] == 0.0F))
      {
        this.Pjj[0] = paramSensorEvent[0];
        this.Pjj[1] = paramSensorEvent[1];
        this.Pjj[2] = paramSensorEvent[2];
        AppMethodBeat.o(52060);
        return;
      }
      if ((Math.abs(paramSensorEvent[0] - this.Pjj[0]) <= 0.7F) && (Math.abs(paramSensorEvent[1] - this.Pjj[1]) <= 0.7F) && (Math.abs(paramSensorEvent[2] - this.Pjj[2]) <= 0.7F)) {
        break label227;
      }
      Log.d("MicroMsg.ScanStableDetector", "scan unstable");
      this.Pjk = 0;
    }
    for (;;)
    {
      this.Pjj[0] = paramSensorEvent[0];
      this.Pjj[1] = paramSensorEvent[1];
      this.Pjj[2] = paramSensorEvent[2];
      AppMethodBeat.o(52060);
      return;
      label227:
      if (this.Pjk == 0) {
        this.Pjl = System.currentTimeMillis();
      }
      this.Pjk += 1;
      if (this.Pjk >= 5) {
        Log.d("MicroMsg.ScanStableDetector", "scan stable");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.l
 * JD-Core Version:    0.7.0.1
 */