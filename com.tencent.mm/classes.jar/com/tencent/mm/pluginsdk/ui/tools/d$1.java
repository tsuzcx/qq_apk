package com.tencent.mm.pluginsdk.ui.tools;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class d$1
  implements SensorEventListener
{
  d$1(d paramd) {}
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    AppMethodBeat.i(79917);
    ab.i("MicroMsg.HeadingPitchSensorMgr", "onAccuracyChanged");
    AppMethodBeat.o(79917);
  }
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(79916);
    if (paramSensorEvent.sensor.getType() == 3)
    {
      d.a(this.weD)[0] = paramSensorEvent.values[0];
      d.a(this.weD)[1] = paramSensorEvent.values[1];
      d.a(this.weD)[2] = paramSensorEvent.values[2];
      if (this.weD.wez == -10000) {
        this.weD.wez = ((int)d.a(this.weD)[0]);
      }
      for (;;)
      {
        if (this.weD.wez == 0) {
          this.weD.wez = 1;
        }
        if (this.weD.wez == 365) {
          this.weD.wez = 364;
        }
        if (this.weD.weA != -10000) {
          break;
        }
        this.weD.weA = ((int)d.a(this.weD)[1]);
        AppMethodBeat.o(79916);
        return;
        if ((d.a(this.weD)[0] - this.weD.wez > 300.0F) || (d.a(this.weD)[0] - this.weD.wez < -300.0F)) {
          this.weD.wez = ((int)d.a(this.weD)[0]);
        } else {
          this.weD.wez = ((int)(this.weD.wez * 0.6D + d.a(this.weD)[0] * 0.4D));
        }
      }
      if (d.a(this.weD)[1] < -68.0F)
      {
        int j = (int)(-68.0D + (d.a(this.weD)[1] + 68.0F) / 1.5D);
        int i = j;
        if (j < -89) {
          i = -89;
        }
        this.weD.weA = i;
        AppMethodBeat.o(79916);
        return;
      }
      if (d.a(this.weD)[1] > 89.0F)
      {
        this.weD.weA = 89;
        AppMethodBeat.o(79916);
        return;
      }
      this.weD.weA = ((int)(this.weD.weA * 0.6D + d.a(this.weD)[1] * 0.4D));
    }
    AppMethodBeat.o(79916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.d.1
 * JD-Core Version:    0.7.0.1
 */