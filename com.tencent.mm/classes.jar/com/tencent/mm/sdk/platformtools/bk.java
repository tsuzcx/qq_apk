package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class bk
{
  private SensorManager BUg;
  private bk.a EXd;
  
  public bk(Context paramContext)
  {
    AppMethodBeat.i(157832);
    this.BUg = ((SensorManager)paramContext.getSystemService("sensor"));
    AppMethodBeat.o(157832);
  }
  
  public final boolean aC(Runnable paramRunnable)
  {
    AppMethodBeat.i(157833);
    if (this.BUg == null)
    {
      AppMethodBeat.o(157833);
      return false;
    }
    List localList = this.BUg.getSensorList(1);
    if ((localList != null) && (localList.size() > 0))
    {
      this.EXd = new bk.a(paramRunnable);
      this.BUg.registerListener(this.EXd, 2, 3);
      AppMethodBeat.o(157833);
      return true;
    }
    AppMethodBeat.o(157833);
    return false;
  }
  
  public final void eGy()
  {
    AppMethodBeat.i(157834);
    if ((this.BUg != null) && (this.EXd != null)) {
      this.BUg.unregisterListener(this.EXd, 2);
    }
    AppMethodBeat.o(157834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bk
 * JD-Core Version:    0.7.0.1
 */