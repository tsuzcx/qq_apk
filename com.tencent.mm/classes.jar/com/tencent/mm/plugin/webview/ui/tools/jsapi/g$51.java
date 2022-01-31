package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$51
  implements SensorEventListener
{
  g$51(g paramg)
  {
    AppMethodBeat.i(9110);
    AppMethodBeat.o(9110);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(154975);
    if (paramSensorEvent.sensor.getType() == 3) {
      g.a(this.vqm, paramSensorEvent.values[0]);
    }
    AppMethodBeat.o(154975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.51
 * JD-Core Version:    0.7.0.1
 */