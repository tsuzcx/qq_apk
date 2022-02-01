package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.cd.a;
import junit.framework.Assert;

public final class u
{
  private static u afLx = null;
  private ColorStateList[] aebb;
  private boolean afLy;
  
  private u(Context paramContext)
  {
    AppMethodBeat.i(143278);
    this.aebb = new ColorStateList[2];
    this.afLy = false;
    this.aebb[0] = a.l(paramContext, a.d.mm_open_status);
    this.aebb[1] = a.l(paramContext, a.d.mm_pref_summary);
    AppMethodBeat.o(143278);
  }
  
  private static u nE(Context paramContext)
  {
    AppMethodBeat.i(143279);
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((afLx == null) || (!afLx.afLy)) {
        afLx = new u(paramContext);
      }
      paramContext = afLx;
      AppMethodBeat.o(143279);
      return paramContext;
    }
  }
  
  public static ColorStateList nF(Context paramContext)
  {
    AppMethodBeat.i(143280);
    paramContext = nE(paramContext).aebb[0];
    AppMethodBeat.o(143280);
    return paramContext;
  }
  
  public static ColorStateList nG(Context paramContext)
  {
    AppMethodBeat.i(143281);
    paramContext = nE(paramContext).aebb[1];
    AppMethodBeat.o(143281);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.u
 * JD-Core Version:    0.7.0.1
 */