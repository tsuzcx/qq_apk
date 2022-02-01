package com.tencent.mm.ui.base;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$6
  implements q.g
{
  h$6(h.d paramd) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(200793);
    if (this.Wix != null) {
      this.Wix.qy(paramMenuItem.getItemId());
    }
    AppMethodBeat.o(200793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.h.6
 * JD-Core Version:    0.7.0.1
 */