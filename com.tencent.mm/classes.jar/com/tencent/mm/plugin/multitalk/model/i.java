package com.tencent.mm.plugin.multitalk.model;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.e;

public final class i
{
  private boolean uXY;
  private boolean uXZ;
  
  public final void as(Activity paramActivity)
  {
    AppMethodBeat.i(114574);
    if (!this.uXY)
    {
      this.uXY = true;
      e.a(paramActivity, 2131761431, null);
    }
    AppMethodBeat.o(114574);
  }
  
  public final void at(Activity paramActivity)
  {
    AppMethodBeat.i(114575);
    if (!this.uXZ)
    {
      this.uXZ = true;
      e.a(paramActivity, 2131764898, null);
    }
    AppMethodBeat.o(114575);
  }
  
  public final void reset()
  {
    this.uXZ = false;
    this.uXY = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.i
 * JD-Core Version:    0.7.0.1
 */