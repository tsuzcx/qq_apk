package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.vc;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.b.a;

final class f$1
  implements DialogInterface.OnClickListener
{
  f$1(WalletBaseUI paramWalletBaseUI, m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(49329);
    f.c(this.AYK);
    if ((this.ckS != null) && (this.ckS.getReqResp() != null))
    {
      paramDialogInterface = new vc();
      paramDialogInterface.cLD.uri = this.ckS.getReqResp().getUri();
      a.ymk.l(paramDialogInterface);
    }
    AppMethodBeat.o(49329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.f.1
 * JD-Core Version:    0.7.0.1
 */