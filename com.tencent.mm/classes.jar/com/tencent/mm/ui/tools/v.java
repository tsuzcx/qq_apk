package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ci.a;
import junit.framework.Assert;

public final class v
{
  private static v XVi = null;
  private ColorStateList[] WtI;
  private boolean XVj;
  
  private v(Context paramContext)
  {
    AppMethodBeat.i(143278);
    this.WtI = new ColorStateList[2];
    this.XVj = false;
    this.WtI[0] = a.l(paramContext, a.d.mm_open_status);
    this.WtI[1] = a.l(paramContext, a.d.mm_pref_summary);
    AppMethodBeat.o(143278);
  }
  
  private static v lB(Context paramContext)
  {
    AppMethodBeat.i(143279);
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((XVi == null) || (!XVi.XVj)) {
        XVi = new v(paramContext);
      }
      paramContext = XVi;
      AppMethodBeat.o(143279);
      return paramContext;
    }
  }
  
  public static ColorStateList lC(Context paramContext)
  {
    AppMethodBeat.i(143280);
    paramContext = lB(paramContext).WtI[0];
    AppMethodBeat.o(143280);
    return paramContext;
  }
  
  public static ColorStateList lD(Context paramContext)
  {
    AppMethodBeat.i(143281);
    paramContext = lB(paramContext).WtI[1];
    AppMethodBeat.o(143281);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.v
 * JD-Core Version:    0.7.0.1
 */