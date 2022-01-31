package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.e;

final class SwitchRealnameVerifyModeUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SwitchRealnameVerifyModeUI$2(SwitchRealnameVerifyModeUI paramSwitchRealnameVerifyModeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = this.qrR.cNj();
    if (paramMenuItem != null)
    {
      e.a(14, bk.UX(), SwitchRealnameVerifyModeUI.a(this.qrR));
      paramMenuItem.b(this.qrR, 0);
      return true;
    }
    this.qrR.finish();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI.2
 * JD-Core Version:    0.7.0.1
 */