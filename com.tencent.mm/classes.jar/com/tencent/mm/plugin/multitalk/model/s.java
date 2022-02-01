package com.tencent.mm.plugin.multitalk.model;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.e;

public final class s
{
  private boolean wcv;
  private boolean wcw;
  
  public final void as(Activity paramActivity)
  {
    AppMethodBeat.i(114574);
    if (!this.wcv)
    {
      this.wcv = true;
      e.a(paramActivity, 2131761431, null);
    }
    AppMethodBeat.o(114574);
  }
  
  public final void at(Activity paramActivity)
  {
    AppMethodBeat.i(114575);
    if (!this.wcw)
    {
      this.wcw = true;
      e.a(paramActivity, 2131764898, null);
    }
    AppMethodBeat.o(114575);
  }
  
  public final void reset()
  {
    this.wcw = false;
    this.wcv = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.s
 * JD-Core Version:    0.7.0.1
 */