package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.tr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiCancelWecoinRechargeRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/CancelWecoinRechargeResponse;", "billNo", "", "(Ljava/lang/String;)V", "plugin-wxpay_release"})
public final class a
  extends l<ts>
{
  public a(String paramString)
  {
    AppMethodBeat.i(212687);
    tr localtr = new tr();
    localtr.KBs = paramString;
    ts localts = new ts();
    a((dop)localtr, (dpc)localts, 6233, "/cgi-bin/micromsg-bin/cancelwecoinrecharge");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiCancelWecoinRechargeRequest: billNo: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(212687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.a
 * JD-Core Version:    0.7.0.1
 */