package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

final class c
{
  ap caS;
  View view;
  
  public c(View paramView)
  {
    AppMethodBeat.i(24708);
    this.caS = new ap(new c.1(this), false);
    this.view = paramView;
    AppMethodBeat.o(24708);
  }
  
  public final void clU()
  {
    AppMethodBeat.i(24709);
    if (this.view != null) {
      this.view.setKeepScreenOn(false);
    }
    AppMethodBeat.o(24709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.c
 * JD-Core Version:    0.7.0.1
 */