package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class bj
{
  private SensorManager Dmw;
  private bj.a Gup;
  
  public bj(Context paramContext)
  {
    AppMethodBeat.i(157832);
    this.Dmw = ((SensorManager)paramContext.getSystemService("sensor"));
    AppMethodBeat.o(157832);
  }
  
  public final boolean aE(Runnable paramRunnable)
  {
    AppMethodBeat.i(157833);
    if (this.Dmw == null)
    {
      AppMethodBeat.o(157833);
      return false;
    }
    List localList = this.Dmw.getSensorList(1);
    if ((localList != null) && (localList.size() > 0))
    {
      this.Gup = new bj.a(paramRunnable);
      this.Dmw.registerListener(this.Gup, 2, 3);
      AppMethodBeat.o(157833);
      return true;
    }
    AppMethodBeat.o(157833);
    return false;
  }
  
  public final void eVT()
  {
    AppMethodBeat.i(157834);
    if ((this.Dmw != null) && (this.Gup != null)) {
      this.Dmw.unregisterListener(this.Gup, 2);
    }
    AppMethodBeat.o(157834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bj
 * JD-Core Version:    0.7.0.1
 */