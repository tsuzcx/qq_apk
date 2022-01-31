package com.tencent.mm.plugin.wallet_ecard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.d.g;

final class WalletECardElementInputUI$2
  implements View.OnClickListener
{
  WalletECardElementInputUI$2(WalletECardElementInputUI paramWalletECardElementInputUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48139);
    ab.i("MicroMsg.WalletECardElementInputUI", "goto next: %s", new Object[] { WalletECardElementInputUI.b(this.uzK).poq });
    this.uzK.getNetController().p(new Object[] { WalletECardElementInputUI.b(this.uzK) });
    AppMethodBeat.o(48139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI.2
 * JD-Core Version:    0.7.0.1
 */