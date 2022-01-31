package com.tencent.mm.pluginsdk.ui.tools;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.sdk.platformtools.y;

final class e$1
  implements SensorEventListener
{
  e$1(e parame) {}
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    y.i("MicroMsg.HeadingPitchSensorMgr", "onAccuracyChanged");
  }
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 3)
    {
      e.a(this.smb)[0] = paramSensorEvent.values[0];
      e.a(this.smb)[1] = paramSensorEvent.values[1];
      e.a(this.smb)[2] = paramSensorEvent.values[2];
      if (this.smb.slX != -10000) {
        break label158;
      }
      this.smb.slX = ((int)e.a(this.smb)[0]);
    }
    for (;;)
    {
      if (this.smb.slX == 0) {
        this.smb.slX = 1;
      }
      if (this.smb.slX == 365) {
        this.smb.slX = 364;
      }
      if (this.smb.slY != -10000) {
        break;
      }
      this.smb.slY = ((int)e.a(this.smb)[1]);
      return;
      label158:
      if ((e.a(this.smb)[0] - this.smb.slX > 300.0F) || (e.a(this.smb)[0] - this.smb.slX < -300.0F)) {
        this.smb.slX = ((int)e.a(this.smb)[0]);
      } else {
        this.smb.slX = ((int)(this.smb.slX * 0.6D + e.a(this.smb)[0] * 0.4D));
      }
    }
    if (e.a(this.smb)[1] < -68.0F)
    {
      int j = (int)(-68.0D + (e.a(this.smb)[1] + 68.0F) / 1.5D);
      int i = j;
      if (j < -89) {
        i = -89;
      }
      this.smb.slY = i;
      return;
    }
    if (e.a(this.smb)[1] > 89.0F)
    {
      this.smb.slY = 89;
      return;
    }
    this.smb.slY = ((int)(this.smb.slY * 0.6D + e.a(this.smb)[1] * 0.4D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.e.1
 * JD-Core Version:    0.7.0.1
 */