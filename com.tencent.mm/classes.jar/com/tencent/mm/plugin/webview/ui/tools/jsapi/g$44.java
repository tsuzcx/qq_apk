package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

final class g$44
  implements SensorEventListener
{
  g$44(g paramg) {}
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 3) {
      g.a(this.rzi, paramSensorEvent.values[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.44
 * JD-Core Version:    0.7.0.1
 */