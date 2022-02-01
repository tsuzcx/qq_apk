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
  public static final j CUb;
  public Sensor CTX;
  public float[] CTY;
  public int CTZ;
  private long CUa;
  public SensorManager mSensorManager;
  
  static
  {
    AppMethodBeat.i(52061);
    CUb = new j();
    AppMethodBeat.o(52061);
  }
  
  private j()
  {
    AppMethodBeat.i(52059);
    this.CTY = new float[3];
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    this.CTX = this.mSensorManager.getDefaultSensor(1);
    AppMethodBeat.o(52059);
  }
  
  public final long eRV()
  {
    if (this.CTZ >= 5) {
      return this.CUa;
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
      if ((this.CTY[0] == 0.0F) && (this.CTY[1] == 0.0F) && (this.CTY[2] == 0.0F))
      {
        this.CTY[0] = paramSensorEvent[0];
        this.CTY[1] = paramSensorEvent[1];
        this.CTY[2] = paramSensorEvent[2];
        AppMethodBeat.o(52060);
        return;
      }
      if ((Math.abs(paramSensorEvent[0] - this.CTY[0]) <= 0.7F) && (Math.abs(paramSensorEvent[1] - this.CTY[1]) <= 0.7F) && (Math.abs(paramSensorEvent[2] - this.CTY[2]) <= 0.7F)) {
        break label227;
      }
      Log.d("MicroMsg.ScanStableDetector", "scan unstable");
      this.CTZ = 0;
    }
    for (;;)
    {
      this.CTY[0] = paramSensorEvent[0];
      this.CTY[1] = paramSensorEvent[1];
      this.CTY[2] = paramSensorEvent[2];
      AppMethodBeat.o(52060);
      return;
      label227:
      if (this.CTZ == 0) {
        this.CUa = System.currentTimeMillis();
      }
      this.CTZ += 1;
      if (this.CTZ >= 5) {
        Log.d("MicroMsg.ScanStableDetector", "scan stable");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.j
 * JD-Core Version:    0.7.0.1
 */