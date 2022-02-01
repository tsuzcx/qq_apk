package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import junit.framework.Assert;

public final class t
{
  private static t Lid = null;
  private ColorStateList[] JPq;
  private boolean Lie;
  
  private t(Context paramContext)
  {
    AppMethodBeat.i(143278);
    this.JPq = new ColorStateList[2];
    this.Lie = false;
    this.JPq[0] = a.m(paramContext, 2131100644);
    this.JPq[1] = a.m(paramContext, 2131100645);
    AppMethodBeat.o(143278);
  }
  
  private static t kI(Context paramContext)
  {
    AppMethodBeat.i(143279);
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((Lid == null) || (!Lid.Lie)) {
        Lid = new t(paramContext);
      }
      paramContext = Lid;
      AppMethodBeat.o(143279);
      return paramContext;
    }
  }
  
  public static ColorStateList kJ(Context paramContext)
  {
    AppMethodBeat.i(143280);
    paramContext = kI(paramContext).JPq[0];
    AppMethodBeat.o(143280);
    return paramContext;
  }
  
  public static ColorStateList kK(Context paramContext)
  {
    AppMethodBeat.i(143281);
    paramContext = kI(paramContext).JPq[1];
    AppMethodBeat.o(143281);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.t
 * JD-Core Version:    0.7.0.1
 */