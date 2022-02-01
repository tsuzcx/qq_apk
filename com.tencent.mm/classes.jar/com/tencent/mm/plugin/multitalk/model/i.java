package com.tencent.mm.plugin.multitalk.model;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.e;

public final class i
{
  private boolean tPx;
  private boolean tPy;
  
  public final void ao(Activity paramActivity)
  {
    AppMethodBeat.i(114574);
    if (!this.tPx)
    {
      this.tPx = true;
      e.a(paramActivity, 2131761431, null);
    }
    AppMethodBeat.o(114574);
  }
  
  public final void ap(Activity paramActivity)
  {
    AppMethodBeat.i(114575);
    if (!this.tPy)
    {
      this.tPy = true;
      e.a(paramActivity, 2131764898, null);
    }
    AppMethodBeat.o(114575);
  }
  
  public final void reset()
  {
    this.tPy = false;
    this.tPx = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.i
 * JD-Core Version:    0.7.0.1
 */