package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Set;

final class WalletOrderInfoNewUI$5
  implements View.OnClickListener
{
  WalletOrderInfoNewUI$5(WalletOrderInfoNewUI paramWalletOrderInfoNewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(261286);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (!Util.isNullOrNil(WalletOrderInfoNewUI.p(this.Pah)))
    {
      if (!this.Pah.OZt.contains(WalletOrderInfoNewUI.p(this.Pah))) {
        break label118;
      }
      this.Pah.OZt.remove(WalletOrderInfoNewUI.p(this.Pah));
      WalletOrderInfoNewUI.q(this.Pah).setChecked(false);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(261286);
      return;
      label118:
      this.Pah.OZt.add(WalletOrderInfoNewUI.p(this.Pah));
      WalletOrderInfoNewUI.q(this.Pah).setChecked(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.5
 * JD-Core Version:    0.7.0.1
 */