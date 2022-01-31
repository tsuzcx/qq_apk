package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Set;

final class WalletOrderInfoNewUI$2
  implements View.OnClickListener
{
  WalletOrderInfoNewUI$2(WalletOrderInfoNewUI paramWalletOrderInfoNewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47427);
    if (!bo.isNullOrNil(WalletOrderInfoNewUI.n(this.ury)))
    {
      if (this.ury.uqP.contains(WalletOrderInfoNewUI.n(this.ury)))
      {
        this.ury.uqP.remove(WalletOrderInfoNewUI.n(this.ury));
        WalletOrderInfoNewUI.o(this.ury).setChecked(false);
        AppMethodBeat.o(47427);
        return;
      }
      this.ury.uqP.add(WalletOrderInfoNewUI.n(this.ury));
      WalletOrderInfoNewUI.o(this.ury).setChecked(true);
    }
    AppMethodBeat.o(47427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.2
 * JD-Core Version:    0.7.0.1
 */