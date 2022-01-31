package com.tencent.mm.ui.chatting.c;

import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t$2$1
  implements Runnable
{
  t$2$1(t.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(31474);
    if (this.zGE.ksX != null) {
      this.zGE.ksX.onMenuItemClick(null);
    }
    AppMethodBeat.o(31474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.t.2.1
 * JD-Core Version:    0.7.0.1
 */