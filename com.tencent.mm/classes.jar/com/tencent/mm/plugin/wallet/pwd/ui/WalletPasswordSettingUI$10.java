package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
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
    AppMethodBeat.i(199290);
    super.onBindView(paramView);
    if (this.Jtu != null) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(199289);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI$18$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          WalletPasswordSettingUI.10.this.Jtu.dAh();
          a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI$18$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(199289);
        }
      });
    }
    AppMethodBeat.o(199290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.10
 * JD-Core Version:    0.7.0.1
 */