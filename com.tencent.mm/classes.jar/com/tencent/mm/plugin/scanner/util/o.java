package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class o
  implements SensorEventListener
{
  public static final o qDy;
  public SensorManager bmB;
  public Sensor qDu;
  public float[] qDv;
  public int qDw;
  private long qDx;
  
  static
  {
    AppMethodBeat.i(81465);
    qDy = new o();
    AppMethodBeat.o(81465);
  }
  
  private o()
  {
    AppMethodBeat.i(81462);
    this.qDv = new float[3];
    this.bmB = ((SensorManager)ah.getContext().getSystemService("sensor"));
    this.qDu = this.bmB.getDefaultSensor(1);
    AppMethodBeat.o(81462);
  }
  
  public final long cjL()
  {
    if (this.qDw >= 5) {
      return this.qDx;
    }
    return 0L;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(81463);
    if (paramSensorEvent.sensor.getType() == 1)
    {
      paramSensorEvent = paramSensorEvent.values;
      ab.d("MicroMsg.ScanStableDetector", "x:%f,y:%f,z:%f", new Object[] { Float.valueOf(paramSensorEvent[0]), Float.valueOf(paramSensorEvent[1]), Float.valueOf(paramSensorEvent[2]) });
      if ((this.qDv[0] == 0.0F) && (this.qDv[1] == 0.0F) && (this.qDv[2] == 0.0F))
      {
        this.qDv[0] = paramSensorEvent[0];
        this.qDv[1] = paramSensorEvent[1];
        this.qDv[2] = paramSensorEvent[2];
        AppMethodBeat.o(81463);
        return;
      }
      if ((Math.abs(paramSensorEvent[0] - this.qDv[0]) <= 0.7F) && (Math.abs(paramSensorEvent[1] - this.qDv[1]) <= 0.7F) && (Math.abs(paramSensorEvent[2] - this.qDv[2]) <= 0.7F)) {
        break label227;
      }
      ab.d("MicroMsg.ScanStableDetector", "scan unstable");
      this.qDw = 0;
    }
    for (;;)
    {
      this.qDv[0] = paramSensorEvent[0];
      this.qDv[1] = paramSensorEvent[1];
      this.qDv[2] = paramSensorEvent[2];
      AppMethodBeat.o(81463);
      return;
      label227:
      if (this.qDw == 0) {
        this.qDx = System.currentTimeMillis();
      }
      this.qDw += 1;
      if (this.qDw >= 5) {
        ab.d("MicroMsg.ScanStableDetector", "scan stable");
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(81464);
    ab.i("MicroMsg.ScanStableDetector", "stop detect scan stable");
    if (this.bmB != null)
    {
      ab.i("MicroMsg.ScanStableDetector", "unregister accelerate listener");
      this.bmB.unregisterListener(this);
    }
    AppMethodBeat.o(81464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.o
 * JD-Core Version:    0.7.0.1
 */