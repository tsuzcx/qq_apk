package com.tencent.mm.plugin.wallet_ecard.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bmu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$2
  implements DialogInterface.OnClickListener
{
  b$2(bmu parambmu, WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(48049);
    c localc;
    if (this.uzh.xij == a.uyF)
    {
      ab.i("MicroMsg.ECardUtil", "do end process");
      localc = this.uzi.getProcess();
      if (localc != null) {
        localc.b(this.uzi, new Bundle());
      }
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      AppMethodBeat.o(48049);
      return;
      this.uzi.finish();
      continue;
      if (this.uzh.xij == a.uyI)
      {
        ab.i("MicroMsg.ECardUtil", "back bank list");
        localc = this.uzi.getProcess();
        if (localc != null) {
          localc.e(this.uzi, 100);
        } else {
          this.uzi.finish();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.b.2
 * JD-Core Version:    0.7.0.1
 */