package com.tencent.mm.ui.transmit;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.sdk.platformtools.ab;

final class MMCreateChatroomUI$1
  implements MenuItem.OnMenuItemClickListener
{
  MMCreateChatroomUI$1(MMCreateChatroomUI paramMMCreateChatroomUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35040);
    if (!MMCreateChatroomUI.a(this.AyW))
    {
      MMCreateChatroomUI.a(this.AyW, true);
      MMCreateChatroomUI.b(this.AyW);
      if (MMCreateChatroomUI.c(this.AyW) == 3)
      {
        MMCreateChatroomUI.d(this.AyW);
        k.hR(true);
      }
    }
    ab.i("MicroMsg.MMCreateChatroomUI", "Create the chatroom");
    AppMethodBeat.o(35040);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MMCreateChatroomUI.1
 * JD-Core Version:    0.7.0.1
 */