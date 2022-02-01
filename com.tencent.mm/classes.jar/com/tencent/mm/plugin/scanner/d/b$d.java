package com.tencent.mm.plugin.scanner.d;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class b$d
  implements SensorEventListener
{
  b$d(b paramb) {}
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    AppMethodBeat.i(313394);
    Log.d("MicroMsg.ReIdAiScanImageDecodeQueue", "onAccuracyChanged:  accuracy=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(313394);
  }
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(313392);
    if ((paramSensorEvent == null) || (paramSensorEvent.values == null) || (paramSensorEvent.values.length < 3))
    {
      AppMethodBeat.o(313392);
      return;
    }
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    this.OPv.pxk = f1;
    this.OPv.pxl = f2;
    this.OPv.OPl = f3;
    this.OPv.OPq = System.currentTimeMillis();
    AppMethodBeat.o(313392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.d.b.d
 * JD-Core Version:    0.7.0.1
 */