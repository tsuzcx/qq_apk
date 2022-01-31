package com.tencent.mm.plugin.multitalk.model;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.e;

public final class i
{
  private boolean oUb;
  private boolean oUc;
  
  public final void W(Activity paramActivity)
  {
    AppMethodBeat.i(54043);
    if (!this.oUb)
    {
      this.oUb = true;
      e.a(paramActivity, 2131301692, null);
    }
    AppMethodBeat.o(54043);
  }
  
  public final void X(Activity paramActivity)
  {
    AppMethodBeat.i(54044);
    if (!this.oUc)
    {
      this.oUc = true;
      e.a(paramActivity, 2131304716, null);
    }
    AppMethodBeat.o(54044);
  }
  
  public final void reset()
  {
    this.oUc = false;
    this.oUb = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.i
 * JD-Core Version:    0.7.0.1
 */