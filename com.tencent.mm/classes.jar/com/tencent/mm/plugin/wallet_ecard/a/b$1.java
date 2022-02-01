package com.tencent.mm.plugin.wallet_ecard.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dmr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;

final class b$1
  implements DialogInterface.OnClickListener
{
  b$1(dmr paramdmr, WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(71681);
    WalletBaseUI localWalletBaseUI;
    String str;
    Object localObject;
    if (!Util.isNullOrNil(this.Piw.Eyy))
    {
      localWalletBaseUI = this.Pix;
      str = this.Piw.Eyy;
      localObject = this.Piy;
      Log.i("MicroMsg.ECardUtil", "url: %s", new Object[] { str });
      if (!Util.isNullOrNil(str))
      {
        if (!str.startsWith("native.")) {
          break label146;
        }
        Log.i("MicroMsg.ECardUtil", "goto native");
        if (((localObject != null) && (((b.a)localObject).gMQ())) || (str.equals("native.qryacctdesc")) || (str.equals("native.openecardauth")) || (str.equals("native.cancloseecard")) || (!str.equals("native.withdraw"))) {}
      }
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      AppMethodBeat.o(71681);
      return;
      label146:
      Log.d("MicroMsg.ECardUtil", "url: %s", new Object[] { str });
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", str);
      ((Intent)localObject).putExtra("showShare", false);
      g.aJ(localWalletBaseUI, (Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.b.1
 * JD-Core Version:    0.7.0.1
 */