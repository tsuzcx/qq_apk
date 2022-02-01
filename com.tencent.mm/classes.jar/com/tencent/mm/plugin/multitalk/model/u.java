package com.tencent.mm.plugin.multitalk.model;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.e;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.ui.base.w;

public final class u
{
  private boolean Fti;
  private boolean Ftj;
  
  public final void ay(Activity paramActivity)
  {
    AppMethodBeat.i(114574);
    if (!this.Fti)
    {
      this.Fti = true;
      e.a(paramActivity, a.h.multitalk_not_support_video_tip, null);
    }
    AppMethodBeat.o(114574);
  }
  
  public final void az(Activity paramActivity)
  {
    AppMethodBeat.i(114575);
    if (!this.Ftj)
    {
      this.Ftj = true;
      int i = a.h.voip_cellular_cost_tip;
      w.cQ(paramActivity, paramActivity.getResources().getText(i).toString());
    }
    AppMethodBeat.o(114575);
  }
  
  public final void reset()
  {
    this.Ftj = false;
    this.Fti = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.u
 * JD-Core Version:    0.7.0.1
 */