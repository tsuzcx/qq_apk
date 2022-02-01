package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bym;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetWecoinBalanceRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetWecoinBalanceResponse;", "()V", "plugin-wxpay_release"})
public final class f
  extends l<byn>
{
  public f()
  {
    AppMethodBeat.i(212692);
    bym localbym = new bym();
    byn localbyn = new byn();
    a((dop)localbym, (dpc)localbyn, 6401, "/cgi-bin/micromsg-bin/getwecoinbalance");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetWecoinBalanceRequest: ");
    AppMethodBeat.o(212692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.f
 * JD-Core Version:    0.7.0.1
 */