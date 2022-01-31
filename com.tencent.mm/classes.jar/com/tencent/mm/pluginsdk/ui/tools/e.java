package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  implements r.a
{
  public static e sma = null;
  public boolean hasInit = false;
  private SensorEventListener ryR;
  private float[] slW = new float[3];
  int slX = -10000;
  int slY = -10000;
  private SensorManager slZ;
  
  private void coi()
  {
    y.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
    if ((this.slZ != null) && (this.ryR != null))
    {
      y.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
      this.slZ.unregisterListener(this.ryR);
      this.slZ = null;
      this.ryR = null;
    }
    this.hasInit = false;
  }
  
  public final void cfi()
  {
    sma = null;
    coi();
  }
  
  public final void cfj()
  {
    coi();
  }
  
  public final int coh()
  {
    y.d("MicroMsg.HeadingPitchSensorMgr", "getHeading() " + this.slX);
    return this.slX;
  }
  
  public final void eA(Context paramContext)
  {
    eZ(paramContext);
  }
  
  public final void eZ(Context paramContext)
  {
    y.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() ");
    if (paramContext == null)
    {
      y.e("MicroMsg.HeadingPitchSensorMgr", "initSensor() context == null");
      return;
    }
    if (this.slZ == null) {
      this.slZ = ((SensorManager)paramContext.getSystemService("sensor"));
    }
    if (this.ryR == null) {
      this.ryR = new e.1(this);
    }
    boolean bool = this.slZ.registerListener(this.ryR, this.slZ.getDefaultSensor(3), 3);
    this.hasInit = true;
    y.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() finish, %s", new Object[] { Boolean.valueOf(bool) });
  }
  
  public final String getName()
  {
    return "HeadingPitchSensorMgr";
  }
  
  public final int getPitch()
  {
    y.d("MicroMsg.HeadingPitchSensorMgr", "getPitch() " + this.slY);
    return this.slY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.e
 * JD-Core Version:    0.7.0.1
 */