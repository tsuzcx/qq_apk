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
    AppMethodBeat.i(187142);
    super.onBindView(paramView);
    if (this.GfO != null) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(187141);
          WalletPasswordSettingUI.10.this.GfO.dbW();
          AppMethodBeat.o(187141);
        }
      });
    }
    AppMethodBeat.o(187142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.10
 * JD-Core Version:    0.7.0.1
 */