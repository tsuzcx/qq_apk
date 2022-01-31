package com.tencent.mm.ui.bizchat;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizChatFavUI$7
  implements MenuItem.OnMenuItemClickListener
{
  BizChatFavUI$7(BizChatFavUI paramBizChatFavUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(30113);
    this.ztz.finish();
    AppMethodBeat.o(30113);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatFavUI.7
 * JD-Core Version:    0.7.0.1
 */