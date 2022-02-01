package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;

final class c
{
  aw cYd;
  View view;
  
  public c(View paramView)
  {
    AppMethodBeat.i(28378);
    this.cYd = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(28377);
        c.this.dSR();
        AppMethodBeat.o(28377);
        return false;
      }
    }, false);
    this.view = paramView;
    AppMethodBeat.o(28378);
  }
  
  public final void dSR()
  {
    AppMethodBeat.i(28379);
    if (this.view != null) {
      this.view.setKeepScreenOn(false);
    }
    AppMethodBeat.o(28379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.c
 * JD-Core Version:    0.7.0.1
 */