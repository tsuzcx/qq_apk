package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import junit.framework.Assert;

public final class s
{
  private static s Ayb = null;
  private boolean Ayc;
  private ColorStateList[] ztd;
  
  private s(Context paramContext)
  {
    AppMethodBeat.i(107808);
    this.ztd = new ColorStateList[2];
    this.Ayc = false;
    this.ztd[0] = a.l(paramContext, 2131690774);
    this.ztd[1] = a.l(paramContext, 2131690775);
    AppMethodBeat.o(107808);
  }
  
  private static s iC(Context paramContext)
  {
    AppMethodBeat.i(107809);
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((Ayb == null) || (!Ayb.Ayc)) {
        Ayb = new s(paramContext);
      }
      paramContext = Ayb;
      AppMethodBeat.o(107809);
      return paramContext;
    }
  }
  
  public static ColorStateList iD(Context paramContext)
  {
    AppMethodBeat.i(107810);
    paramContext = iC(paramContext).ztd[0];
    AppMethodBeat.o(107810);
    return paramContext;
  }
  
  public static ColorStateList iE(Context paramContext)
  {
    AppMethodBeat.i(107811);
    paramContext = iC(paramContext).ztd[1];
    AppMethodBeat.o(107811);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.tools.s
 * JD-Core Version:    0.7.0.1
 */