package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class bl
{
  private SensorManager FjT;
  private bl.a IAv;
  
  public bl(Context paramContext)
  {
    AppMethodBeat.i(157832);
    this.FjT = ((SensorManager)paramContext.getSystemService("sensor"));
    AppMethodBeat.o(157832);
  }
  
  public final boolean aB(Runnable paramRunnable)
  {
    AppMethodBeat.i(157833);
    if (this.FjT == null)
    {
      AppMethodBeat.o(157833);
      return false;
    }
    List localList = this.FjT.getSensorList(1);
    if ((localList != null) && (localList.size() > 0))
    {
      this.IAv = new bl.a(paramRunnable);
      this.FjT.registerListener(this.IAv, 2, 3);
      AppMethodBeat.o(157833);
      return true;
    }
    AppMethodBeat.o(157833);
    return false;
  }
  
  public final void fpy()
  {
    AppMethodBeat.i(157834);
    if ((this.FjT != null) && (this.IAv != null)) {
      this.FjT.unregisterListener(this.IAv, 2);
    }
    AppMethodBeat.o(157834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bl
 * JD-Core Version:    0.7.0.1
 */