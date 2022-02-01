package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Set;

final class WalletOrderInfoNewUI$2
  implements View.OnClickListener
{
  WalletOrderInfoNewUI$2(WalletOrderInfoNewUI paramWalletOrderInfoNewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(70989);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (!Util.isNullOrNil(WalletOrderInfoNewUI.o(this.IhU)))
    {
      if (!this.IhU.Ihn.contains(WalletOrderInfoNewUI.o(this.IhU))) {
        break label118;
      }
      this.IhU.Ihn.remove(WalletOrderInfoNewUI.o(this.IhU));
      WalletOrderInfoNewUI.p(this.IhU).setChecked(false);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(70989);
      return;
      label118:
      this.IhU.Ihn.add(WalletOrderInfoNewUI.o(this.IhU));
      WalletOrderInfoNewUI.p(this.IhU).setChecked(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.2
 * JD-Core Version:    0.7.0.1
 */