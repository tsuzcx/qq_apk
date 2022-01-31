package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.d;

final class m$4$8
  implements n.d
{
  m$4$8(m.4 param4, String paramString) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(30601);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30601);
      return;
      m.dGo().zyC = true;
      m.a(this.fwC, this.zyA.zyx, this.zyA.zym);
      AppMethodBeat.o(30601);
      return;
      m.dGo().zyC = false;
      m.a(this.fwC, this.zyA.zyx, this.zyA.zym);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.4.8
 * JD-Core Version:    0.7.0.1
 */