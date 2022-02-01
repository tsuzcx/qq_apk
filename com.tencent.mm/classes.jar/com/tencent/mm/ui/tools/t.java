package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import junit.framework.Assert;

public final class t
{
  private static t IUF = null;
  private ColorStateList[] HGK;
  private boolean IUG;
  
  private t(Context paramContext)
  {
    AppMethodBeat.i(143278);
    this.HGK = new ColorStateList[2];
    this.IUG = false;
    this.HGK[0] = a.m(paramContext, 2131100644);
    this.HGK[1] = a.m(paramContext, 2131100645);
    AppMethodBeat.o(143278);
  }
  
  private static t kp(Context paramContext)
  {
    AppMethodBeat.i(143279);
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((IUF == null) || (!IUF.IUG)) {
        IUF = new t(paramContext);
      }
      paramContext = IUF;
      AppMethodBeat.o(143279);
      return paramContext;
    }
  }
  
  public static ColorStateList kq(Context paramContext)
  {
    AppMethodBeat.i(143280);
    paramContext = kp(paramContext).HGK[0];
    AppMethodBeat.o(143280);
    return paramContext;
  }
  
  public static ColorStateList kr(Context paramContext)
  {
    AppMethodBeat.i(143281);
    paramContext = kp(paramContext).HGK[1];
    AppMethodBeat.o(143281);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.t
 * JD-Core Version:    0.7.0.1
 */