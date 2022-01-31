package com.tencent.mm.plugin.setting.ui.qrcode;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareMicroMsgChoiceUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ShareMicroMsgChoiceUI$1(ShareMicroMsgChoiceUI paramShareMicroMsgChoiceUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(126912);
    this.qFw.hideVKB();
    this.qFw.finish();
    AppMethodBeat.o(126912);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShareMicroMsgChoiceUI.1
 * JD-Core Version:    0.7.0.1
 */