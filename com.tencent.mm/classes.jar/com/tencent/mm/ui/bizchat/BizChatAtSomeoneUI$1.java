package com.tencent.mm.ui.bizchat;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizChatAtSomeoneUI$1
  implements MenuItem.OnMenuItemClickListener
{
  BizChatAtSomeoneUI$1(BizChatAtSomeoneUI paramBizChatAtSomeoneUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(30027);
    this.zsQ.setResult(0);
    this.zsQ.finish();
    AppMethodBeat.o(30027);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI.1
 * JD-Core Version:    0.7.0.1
 */