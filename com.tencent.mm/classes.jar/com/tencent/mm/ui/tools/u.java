package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import junit.framework.Assert;

public final class u
{
  private static u Qxc = null;
  private ColorStateList[] Pav;
  private boolean Qxd;
  
  private u(Context paramContext)
  {
    AppMethodBeat.i(143278);
    this.Pav = new ColorStateList[2];
    this.Qxd = false;
    this.Pav[0] = a.m(paramContext, 2131100814);
    this.Pav[1] = a.m(paramContext, 2131100815);
    AppMethodBeat.o(143278);
  }
  
  private static u kE(Context paramContext)
  {
    AppMethodBeat.i(143279);
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((Qxc == null) || (!Qxc.Qxd)) {
        Qxc = new u(paramContext);
      }
      paramContext = Qxc;
      AppMethodBeat.o(143279);
      return paramContext;
    }
  }
  
  public static ColorStateList kF(Context paramContext)
  {
    AppMethodBeat.i(143280);
    paramContext = kE(paramContext).Pav[0];
    AppMethodBeat.o(143280);
    return paramContext;
  }
  
  public static ColorStateList kG(Context paramContext)
  {
    AppMethodBeat.i(143281);
    paramContext = kE(paramContext).Pav[1];
    AppMethodBeat.o(143281);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.u
 * JD-Core Version:    0.7.0.1
 */