package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h.c;

final class WalletBankcardDetailUI$8
  implements h.c
{
  WalletBankcardDetailUI$8(WalletBankcardDetailUI paramWalletBankcardDetailUI) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(45748);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(45748);
      return;
      Intent localIntent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.tSV.getString(2131304853)));
      localIntent.addFlags(268435456);
      this.tSV.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.8
 * JD-Core Version:    0.7.0.1
 */