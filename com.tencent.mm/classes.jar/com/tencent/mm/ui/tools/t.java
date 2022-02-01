package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import junit.framework.Assert;

public final class t
{
  private static t KLJ = null;
  private ColorStateList[] JuB;
  private boolean KLK;
  
  private t(Context paramContext)
  {
    AppMethodBeat.i(143278);
    this.JuB = new ColorStateList[2];
    this.KLK = false;
    this.JuB[0] = a.m(paramContext, 2131100644);
    this.JuB[1] = a.m(paramContext, 2131100645);
    AppMethodBeat.o(143278);
  }
  
  private static t kB(Context paramContext)
  {
    AppMethodBeat.i(143279);
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((KLJ == null) || (!KLJ.KLK)) {
        KLJ = new t(paramContext);
      }
      paramContext = KLJ;
      AppMethodBeat.o(143279);
      return paramContext;
    }
  }
  
  public static ColorStateList kC(Context paramContext)
  {
    AppMethodBeat.i(143280);
    paramContext = kB(paramContext).JuB[0];
    AppMethodBeat.o(143280);
    return paramContext;
  }
  
  public static ColorStateList kD(Context paramContext)
  {
    AppMethodBeat.i(143281);
    paramContext = kB(paramContext).JuB[1];
    AppMethodBeat.o(143281);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.t
 * JD-Core Version:    0.7.0.1
 */