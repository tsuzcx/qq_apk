package com.tencent.mm.ui.base;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$2
  implements n.d
{
  h$2(h.d paramd) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(106404);
    if (this.ziz != null) {
      this.ziz.ca(paramInt, paramMenuItem.getItemId());
    }
    AppMethodBeat.o(106404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.h.2
 * JD-Core Version:    0.7.0.1
 */