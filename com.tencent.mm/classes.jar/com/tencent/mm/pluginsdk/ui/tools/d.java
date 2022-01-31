package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class d
  implements t.a
{
  public static d weC = null;
  public boolean hasInit;
  private SensorEventListener vpT;
  int weA;
  private SensorManager weB;
  private float[] wey;
  int wez;
  
  public d()
  {
    AppMethodBeat.i(79918);
    this.hasInit = false;
    this.wey = new float[3];
    this.wez = -10000;
    this.weA = -10000;
    AppMethodBeat.o(79918);
  }
  
  private void dpx()
  {
    AppMethodBeat.i(79922);
    ab.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
    if ((this.weB != null) && (this.vpT != null))
    {
      ab.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
      this.weB.unregisterListener(this.vpT);
      this.weB = null;
      this.vpT = null;
    }
    this.hasInit = false;
    AppMethodBeat.o(79922);
  }
  
  public final void dfr()
  {
    AppMethodBeat.i(79923);
    weC = null;
    dpx();
    AppMethodBeat.o(79923);
  }
  
  public final void dfs()
  {
    AppMethodBeat.i(79925);
    dpx();
    AppMethodBeat.o(79925);
  }
  
  public final int dpw()
  {
    AppMethodBeat.i(79919);
    ab.d("MicroMsg.HeadingPitchSensorMgr", "getHeading() " + this.wez);
    int i = this.wez;
    AppMethodBeat.o(79919);
    return i;
  }
  
  public final void fX(Context paramContext)
  {
    AppMethodBeat.i(79921);
    ab.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() ");
    if (paramContext == null)
    {
      ab.e("MicroMsg.HeadingPitchSensorMgr", "initSensor() context == null");
      AppMethodBeat.o(79921);
      return;
    }
    if (this.weB == null) {
      this.weB = ((SensorManager)ah.getContext().getSystemService("sensor"));
    }
    if (this.vpT == null) {
      this.vpT = new d.1(this);
    }
    boolean bool = this.weB.registerListener(this.vpT, this.weB.getDefaultSensor(3), 3);
    this.hasInit = true;
    ab.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() finish, %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(79921);
  }
  
  public final void fz(Context paramContext)
  {
    AppMethodBeat.i(79924);
    fX(paramContext);
    AppMethodBeat.o(79924);
  }
  
  public final String getName()
  {
    return "HeadingPitchSensorMgr";
  }
  
  public final int getPitch()
  {
    AppMethodBeat.i(79920);
    ab.d("MicroMsg.HeadingPitchSensorMgr", "getPitch() " + this.weA);
    int i = this.weA;
    AppMethodBeat.o(79920);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.d
 * JD-Core Version:    0.7.0.1
 */