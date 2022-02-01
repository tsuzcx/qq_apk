package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class i
  implements SensorEventListener
{
  public static final i waT;
  public SensorManager mSensorManager;
  public Sensor waP;
  public float[] waQ;
  public int waR;
  private long waS;
  
  static
  {
    AppMethodBeat.i(52061);
    waT = new i();
    AppMethodBeat.o(52061);
  }
  
  private i()
  {
    AppMethodBeat.i(52059);
    this.waQ = new float[3];
    this.mSensorManager = ((SensorManager)aj.getContext().getSystemService("sensor"));
    this.waP = this.mSensorManager.getDefaultSensor(1);
    AppMethodBeat.o(52059);
  }
  
  public final long dnj()
  {
    if (this.waR >= 5) {
      return this.waS;
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
      ad.d("MicroMsg.ScanStableDetector", "x:%f,y:%f,z:%f", new Object[] { Float.valueOf(paramSensorEvent[0]), Float.valueOf(paramSensorEvent[1]), Float.valueOf(paramSensorEvent[2]) });
      if ((this.waQ[0] == 0.0F) && (this.waQ[1] == 0.0F) && (this.waQ[2] == 0.0F))
      {
        this.waQ[0] = paramSensorEvent[0];
        this.waQ[1] = paramSensorEvent[1];
        this.waQ[2] = paramSensorEvent[2];
        AppMethodBeat.o(52060);
        return;
      }
      if ((Math.abs(paramSensorEvent[0] - this.waQ[0]) <= 0.7F) && (Math.abs(paramSensorEvent[1] - this.waQ[1]) <= 0.7F) && (Math.abs(paramSensorEvent[2] - this.waQ[2]) <= 0.7F)) {
        break label227;
      }
      ad.d("MicroMsg.ScanStableDetector", "scan unstable");
      this.waR = 0;
    }
    for (;;)
    {
      this.waQ[0] = paramSensorEvent[0];
      this.waQ[1] = paramSensorEvent[1];
      this.waQ[2] = paramSensorEvent[2];
      AppMethodBeat.o(52060);
      return;
      label227:
      if (this.waR == 0) {
        this.waS = System.currentTimeMillis();
      }
      this.waR += 1;
      if (this.waR >= 5) {
        ad.d("MicroMsg.ScanStableDetector", "scan stable");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.i
 * JD-Core Version:    0.7.0.1
 */