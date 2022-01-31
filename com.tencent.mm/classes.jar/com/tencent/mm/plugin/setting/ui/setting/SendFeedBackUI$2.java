package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SendFeedBackUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SendFeedBackUI$2(SendFeedBackUI paramSendFeedBackUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127044);
    this.qGG.hideVKB();
    this.qGG.finish();
    AppMethodBeat.o(127044);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI.2
 * JD-Core Version:    0.7.0.1
 */