package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

final class SettingCheckUnProcessWalletConvUI$4$2
  implements n.d
{
  SettingCheckUnProcessWalletConvUI$4$2(SettingCheckUnProcessWalletConvUI.4 param4, String paramString, ak paramak) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(34615);
    if (paramMenuItem.getItemId() == 1) {
      c.a(this.euc, this.Ama.AlZ, this.yMy, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34614);
          SettingCheckUnProcessWalletConvUI.d(SettingCheckUnProcessWalletConvUI.4.2.this.Ama.AlZ).remove(SettingCheckUnProcessWalletConvUI.4.2.this.euc);
          SettingCheckUnProcessWalletConvUI.b(SettingCheckUnProcessWalletConvUI.4.2.this.Ama.AlZ).notifyDataSetChanged();
          AppMethodBeat.o(34614);
        }
      }, false, true);
    }
    AppMethodBeat.o(34615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.4.2
 * JD-Core Version:    0.7.0.1
 */