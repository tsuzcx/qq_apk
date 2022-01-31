package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c;

final class WalletECardFinishUI$2
  implements View.OnClickListener
{
  WalletECardFinishUI$2(WalletECardFinishUI paramWalletECardFinishUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48145);
    ab.i("MicroMsg.WalletECardFinishUI", "click finish");
    paramView = new lz();
    a.ymk.l(paramView);
    paramView = this.uzL.getProcess();
    if (paramView != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_process_result_code", -1);
      paramView.b(this.uzL.getContext(), localBundle);
      AppMethodBeat.o(48145);
      return;
    }
    ab.w("MicroMsg.WalletECardFinishUI", "process is null");
    this.uzL.finish();
    AppMethodBeat.o(48145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI.2
 * JD-Core Version:    0.7.0.1
 */