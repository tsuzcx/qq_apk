package com.tencent.mm.plugin.wallet_ecard.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.protocal.c.bez;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$3
  implements DialogInterface.OnClickListener
{
  b$3(bez parambez, WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    c localc;
    if (this.qKo.tjw == a.qJN)
    {
      y.i("MicroMsg.ECardUtil", "do end process");
      localc = this.qKp.cNj();
      if (localc != null) {
        localc.b(this.qKp, new Bundle());
      }
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      this.qKp.finish();
      continue;
      if (this.qKo.tjw == a.qJQ)
      {
        y.i("MicroMsg.ECardUtil", "back bank list");
        localc = this.qKp.cNj();
        if (localc != null) {
          localc.b(this.qKp, 100);
        } else {
          this.qKp.finish();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.b.3
 * JD-Core Version:    0.7.0.1
 */