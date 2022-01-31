package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

final class SettingCheckUnProcessWalletConvUI$4$2
  implements n.d
{
  SettingCheckUnProcessWalletConvUI$4$2(SettingCheckUnProcessWalletConvUI.4 param4, String paramString, ak paramak) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (paramMenuItem.getItemId() == 1) {
      c.a(this.dAA, this.vUe.vUd, this.uAp, new Runnable()
      {
        public final void run()
        {
          SettingCheckUnProcessWalletConvUI.d(SettingCheckUnProcessWalletConvUI.4.2.this.vUe.vUd).remove(SettingCheckUnProcessWalletConvUI.4.2.this.dAA);
          SettingCheckUnProcessWalletConvUI.b(SettingCheckUnProcessWalletConvUI.4.2.this.vUe.vUd).notifyDataSetChanged();
        }
      }, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.4.2
 * JD-Core Version:    0.7.0.1
 */