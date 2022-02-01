package com.tencent.xweb.util;

import android.content.Context;
import android.os.SystemClock;
import android.view.accessibility.AccessibilityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static c aimx;
  private static AccessibilityManager bYO;
  private boolean adLl;
  private long adLm;
  
  private c(Context paramContext)
  {
    AppMethodBeat.i(212592);
    bYO = (AccessibilityManager)paramContext.getSystemService("accessibility");
    AppMethodBeat.o(212592);
  }
  
  public static c oY(Context paramContext)
  {
    AppMethodBeat.i(212596);
    if (aimx == null) {
      aimx = new c(paramContext);
    }
    paramContext = aimx;
    AppMethodBeat.o(212596);
    return paramContext;
  }
  
  public final boolean jls()
  {
    AppMethodBeat.i(212602);
    if (SystemClock.uptimeMillis() - this.adLm > 2000L)
    {
      bool1 = bYO.isEnabled();
      boolean bool2 = bYO.isTouchExplorationEnabled();
      if ((!bool1) || (!bool2)) {
        break label68;
      }
    }
    label68:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.adLl = bool1;
      this.adLm = SystemClock.uptimeMillis();
      bool1 = this.adLl;
      AppMethodBeat.o(212602);
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.xweb.util.c
 * JD-Core Version:    0.7.0.1
 */