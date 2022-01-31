package com.tencent.mm.plugin.order.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.g.a.vd.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class MallOrderRecordListUI$4
  implements Runnable
{
  MallOrderRecordListUI$4(MallOrderRecordListUI paramMallOrderRecordListUI, vd paramvd) {}
  
  public final void run()
  {
    AppMethodBeat.i(43853);
    if (!bo.isNullOrNil(this.kSA.cLF.cLG))
    {
      e.a((TextView)this.prh.findViewById(2131821672), this.kSA.cLF.cLG, this.kSA.cLF.content, this.kSA.cLF.url);
      AppMethodBeat.o(43853);
      return;
    }
    ab.i("MicroMsg.WalletOrderListUI", "no bulletin data");
    AppMethodBeat.o(43853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.4
 * JD-Core Version:    0.7.0.1
 */