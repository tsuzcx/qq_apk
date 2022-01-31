package com.tencent.mm.ui.base;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$8
  implements n.d
{
  h$8(h.c paramc) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(106410);
    if (this.ziB != null) {
      this.ziB.iA(paramMenuItem.getItemId());
    }
    AppMethodBeat.o(106410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.h.8
 * JD-Core Version:    0.7.0.1
 */