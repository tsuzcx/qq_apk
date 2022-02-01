package com.tencent.mm.plugin.multitalk.model;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.e;

public final class u
{
  private boolean zNL;
  private boolean zNM;
  
  public final void as(Activity paramActivity)
  {
    AppMethodBeat.i(114574);
    if (!this.zNL)
    {
      this.zNL = true;
      e.a(paramActivity, 2131763287, null);
    }
    AppMethodBeat.o(114574);
  }
  
  public final void at(Activity paramActivity)
  {
    AppMethodBeat.i(114575);
    if (!this.zNM)
    {
      this.zNM = true;
      com.tencent.mm.ui.base.u.cF(paramActivity, paramActivity.getResources().getText(2131767252).toString());
    }
    AppMethodBeat.o(114575);
  }
  
  public final void reset()
  {
    this.zNM = false;
    this.zNL = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.u
 * JD-Core Version:    0.7.0.1
 */