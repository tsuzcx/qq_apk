package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class j
  implements SensorEventListener
{
  public static final j IZt;
  public Sensor IZp;
  public float[] IZq;
  public int IZr;
  private long IZs;
  public SensorManager mSensorManager;
  
  static
  {
    AppMethodBeat.i(52061);
    IZt = new j();
    AppMethodBeat.o(52061);
  }
  
  private j()
  {
    AppMethodBeat.i(52059);
    this.IZq = new float[3];
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    this.IZp = this.mSensorManager.getDefaultSensor(1);
    AppMethodBeat.o(52059);
  }
  
  public final long fEU()
  {
    if (this.IZr >= 5) {
      return this.IZs;
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
      if ((this.IZq[0] == 0.0F) && (this.IZq[1] == 0.0F) && (this.IZq[2] == 0.0F))
      {
        this.IZq[0] = paramSensorEvent[0];
        this.IZq[1] = paramSensorEvent[1];
        this.IZq[2] = paramSensorEvent[2];
        AppMethodBeat.o(52060);
        return;
      }
      if ((Math.abs(paramSensorEvent[0] - this.IZq[0]) <= 0.7F) && (Math.abs(paramSensorEvent[1] - this.IZq[1]) <= 0.7F) && (Math.abs(paramSensorEvent[2] - this.IZq[2]) <= 0.7F)) {
        break label227;
      }
      Log.d("MicroMsg.ScanStableDetector", "scan unstable");
      this.IZr = 0;
    }
    for (;;)
    {
      this.IZq[0] = paramSensorEvent[0];
      this.IZq[1] = paramSensorEvent[1];
      this.IZq[2] = paramSensorEvent[2];
      AppMethodBeat.o(52060);
      return;
      label227:
      if (this.IZr == 0) {
        this.IZs = System.currentTimeMillis();
      }
      this.IZr += 1;
      if (this.IZr >= 5) {
        Log.d("MicroMsg.ScanStableDetector", "scan stable");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.j
 * JD-Core Version:    0.7.0.1
 */