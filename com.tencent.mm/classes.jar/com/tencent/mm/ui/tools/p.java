package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.mm.ac.a.d;
import com.tencent.mm.cb.a;
import junit.framework.Assert;

public final class p
{
  private static p wfl = null;
  private ColorStateList[] veE = new ColorStateList[2];
  private boolean wfm = false;
  
  private p(Context paramContext)
  {
    this.veE[0] = a.h(paramContext, a.d.mm_open_status);
    this.veE[1] = a.h(paramContext, a.d.mm_pref_summary);
  }
  
  private static p he(Context paramContext)
  {
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((wfl == null) || (!wfl.wfm)) {
        wfl = new p(paramContext);
      }
      return wfl;
    }
  }
  
  public static ColorStateList hf(Context paramContext)
  {
    return he(paramContext).veE[0];
  }
  
  public static ColorStateList hg(Context paramContext)
  {
    return he(paramContext).veE[1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.p
 * JD-Core Version:    0.7.0.1
 */