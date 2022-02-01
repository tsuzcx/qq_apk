package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class bk
{
  private SensorManager ERy;
  private bk.a Igk;
  
  public bk(Context paramContext)
  {
    AppMethodBeat.i(157832);
    this.ERy = ((SensorManager)paramContext.getSystemService("sensor"));
    AppMethodBeat.o(157832);
  }
  
  public final boolean aD(Runnable paramRunnable)
  {
    AppMethodBeat.i(157833);
    if (this.ERy == null)
    {
      AppMethodBeat.o(157833);
      return false;
    }
    List localList = this.ERy.getSensorList(1);
    if ((localList != null) && (localList.size() > 0))
    {
      this.Igk = new bk.a(paramRunnable);
      this.ERy.registerListener(this.Igk, 2, 3);
      AppMethodBeat.o(157833);
      return true;
    }
    AppMethodBeat.o(157833);
    return false;
  }
  
  public final void flD()
  {
    AppMethodBeat.i(157834);
    if ((this.ERy != null) && (this.Igk != null)) {
      this.ERy.unregisterListener(this.Igk, 2);
    }
    AppMethodBeat.o(157834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bk
 * JD-Core Version:    0.7.0.1
 */