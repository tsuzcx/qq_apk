package com.tencent.mm.plugin.multitalk.model;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.e;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.ui.base.aa;

public final class t
{
  private boolean LpB;
  private boolean LpC;
  
  public final void aZ(Activity paramActivity)
  {
    AppMethodBeat.i(114574);
    if (!this.LpB)
    {
      this.LpB = true;
      e.a(paramActivity, a.h.multitalk_not_support_video_tip, null);
    }
    AppMethodBeat.o(114574);
  }
  
  public final void ba(Activity paramActivity)
  {
    AppMethodBeat.i(114575);
    if (!this.LpC)
    {
      this.LpC = true;
      int i = a.h.voip_cellular_cost_tip;
      aa.da(paramActivity, paramActivity.getResources().getText(i).toString());
    }
    AppMethodBeat.o(114575);
  }
  
  public final void reset()
  {
    this.LpC = false;
    this.LpB = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.t
 * JD-Core Version:    0.7.0.1
 */