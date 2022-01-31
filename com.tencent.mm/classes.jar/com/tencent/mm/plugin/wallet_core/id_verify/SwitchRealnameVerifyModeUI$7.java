package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class SwitchRealnameVerifyModeUI$7
  implements MenuItem.OnMenuItemClickListener
{
  SwitchRealnameVerifyModeUI$7(SwitchRealnameVerifyModeUI paramSwitchRealnameVerifyModeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    e.a(18, bk.UX(), SwitchRealnameVerifyModeUI.a(this.qrR));
    e.l(this.qrR.mController.uMN, SwitchRealnameVerifyModeUI.d(this.qrR), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI.7
 * JD-Core Version:    0.7.0.1
 */