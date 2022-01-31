package com.tencent.mm.ui.transmit;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.sdk.platformtools.y;

final class MMCreateChatroomUI$1
  implements MenuItem.OnMenuItemClickListener
{
  MMCreateChatroomUI$1(MMCreateChatroomUI paramMMCreateChatroomUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (!MMCreateChatroomUI.a(this.wgf))
    {
      MMCreateChatroomUI.a(this.wgf, true);
      MMCreateChatroomUI.b(this.wgf);
      if (MMCreateChatroomUI.c(this.wgf) == 3)
      {
        MMCreateChatroomUI.d(this.wgf);
        k.go(true);
      }
    }
    y.i("MicroMsg.MMCreateChatroomUI", "Create the chatroom");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MMCreateChatroomUI.1
 * JD-Core Version:    0.7.0.1
 */