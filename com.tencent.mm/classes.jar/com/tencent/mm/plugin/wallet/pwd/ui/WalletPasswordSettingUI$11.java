package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.wallet_core.ui.k;

final class WalletPasswordSettingUI$11
  extends Preference
{
  WalletPasswordSettingUI$11(WalletPasswordSettingUI paramWalletPasswordSettingUI, Context paramContext)
  {
    super(paramContext);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(315664);
    super.onBindView(paramView);
    if (this.adZO != null) {
      paramView.setOnClickListener(new k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(315642);
          WalletPasswordSettingUI.11.this.adZO.gAW();
          AppMethodBeat.o(315642);
        }
      });
    }
    AppMethodBeat.o(315664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.11
 * JD-Core Version:    0.7.0.1
 */