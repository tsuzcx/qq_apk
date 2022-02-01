package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import junit.framework.Assert;

public final class t
{
  private static t Hui = null;
  private ColorStateList[] GgV;
  private boolean Huj;
  
  private t(Context paramContext)
  {
    AppMethodBeat.i(143278);
    this.GgV = new ColorStateList[2];
    this.Huj = false;
    this.GgV[0] = a.m(paramContext, 2131100644);
    this.GgV[1] = a.m(paramContext, 2131100645);
    AppMethodBeat.o(143278);
  }
  
  private static t ke(Context paramContext)
  {
    AppMethodBeat.i(143279);
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((Hui == null) || (!Hui.Huj)) {
        Hui = new t(paramContext);
      }
      paramContext = Hui;
      AppMethodBeat.o(143279);
      return paramContext;
    }
  }
  
  public static ColorStateList kf(Context paramContext)
  {
    AppMethodBeat.i(143280);
    paramContext = ke(paramContext).GgV[0];
    AppMethodBeat.o(143280);
    return paramContext;
  }
  
  public static ColorStateList kg(Context paramContext)
  {
    AppMethodBeat.i(143281);
    paramContext = ke(paramContext).GgV[1];
    AppMethodBeat.o(143281);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.t
 * JD-Core Version:    0.7.0.1
 */