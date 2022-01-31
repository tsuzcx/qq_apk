package com.tencent.mm.sdk.platformtools;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
{
  public static void cn(View paramView)
  {
    AppMethodBeat.i(51990);
    if (paramView == null)
    {
      AppMethodBeat.o(51990);
      return;
    }
    ab.a("MicroMsg.ForceGpuUtil", "setLayerType, view: %s", new Object[] { Integer.valueOf(paramView.hashCode()) });
    if (Build.VERSION.SDK_INT >= 11)
    {
      new p();
      p.cn(paramView);
    }
    AppMethodBeat.o(51990);
  }
  
  public static void x(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51991);
    if (paramView == null)
    {
      AppMethodBeat.o(51991);
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      new p();
      p.x(paramView, paramInt1, paramInt2);
    }
    AppMethodBeat.o(51991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.n
 * JD-Core Version:    0.7.0.1
 */