package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class i
  implements SensorEventListener
{
  public static final i yQa;
  public SensorManager mSensorManager;
  public Sensor yPW;
  public float[] yPX;
  public int yPY;
  private long yPZ;
  
  static
  {
    AppMethodBeat.i(52061);
    yQa = new i();
    AppMethodBeat.o(52061);
  }
  
  private i()
  {
    AppMethodBeat.i(52059);
    this.yPX = new float[3];
    this.mSensorManager = ((SensorManager)ak.getContext().getSystemService("sensor"));
    this.yPW = this.mSensorManager.getDefaultSensor(1);
    AppMethodBeat.o(52059);
  }
  
  public final long dQi()
  {
    if (this.yPY >= 5) {
      return this.yPZ;
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
      ae.d("MicroMsg.ScanStableDetector", "x:%f,y:%f,z:%f", new Object[] { Float.valueOf(paramSensorEvent[0]), Float.valueOf(paramSensorEvent[1]), Float.valueOf(paramSensorEvent[2]) });
      if ((this.yPX[0] == 0.0F) && (this.yPX[1] == 0.0F) && (this.yPX[2] == 0.0F))
      {
        this.yPX[0] = paramSensorEvent[0];
        this.yPX[1] = paramSensorEvent[1];
        this.yPX[2] = paramSensorEvent[2];
        AppMethodBeat.o(52060);
        return;
      }
      if ((Math.abs(paramSensorEvent[0] - this.yPX[0]) <= 0.7F) && (Math.abs(paramSensorEvent[1] - this.yPX[1]) <= 0.7F) && (Math.abs(paramSensorEvent[2] - this.yPX[2]) <= 0.7F)) {
        break label227;
      }
      ae.d("MicroMsg.ScanStableDetector", "scan unstable");
      this.yPY = 0;
    }
    for (;;)
    {
      this.yPX[0] = paramSensorEvent[0];
      this.yPX[1] = paramSensorEvent[1];
      this.yPX[2] = paramSensorEvent[2];
      AppMethodBeat.o(52060);
      return;
      label227:
      if (this.yPY == 0) {
        this.yPZ = System.currentTimeMillis();
      }
      this.yPY += 1;
      if (this.yPY >= 5) {
        ae.d("MicroMsg.ScanStableDetector", "scan stable");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.i
 * JD-Core Version:    0.7.0.1
 */