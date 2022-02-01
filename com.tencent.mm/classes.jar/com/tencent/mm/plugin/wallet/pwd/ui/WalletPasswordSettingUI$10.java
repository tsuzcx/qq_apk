package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;

final class WalletPasswordSettingUI$10
  extends Preference
{
  WalletPasswordSettingUI$10(WalletPasswordSettingUI paramWalletPasswordSettingUI, Context paramContext)
  {
    super(paramContext);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(207262);
    super.onBindView(paramView);
    if (this.HFD != null) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(207261);
          WalletPasswordSettingUI.10.this.HFD.dpE();
          AppMethodBeat.o(207261);
        }
      });
    }
    AppMethodBeat.o(207262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.10
 * JD-Core Version:    0.7.0.1
 */