package com.tencent.mm.plugin.setting.ui.qrcode;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareToQQUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ShareToQQUI$1(ShareToQQUI paramShareToQQUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(126916);
    this.qFA.hideVKB();
    this.qFA.finish();
    AppMethodBeat.o(126916);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI.1
 * JD-Core Version:    0.7.0.1
 */