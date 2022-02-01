package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetWecoinIncomePageInfoRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetIncomePageInfoResponse;", "()V", "plugin-wxpay_release"})
public final class g
  extends l<bop>
{
  public g()
  {
    AppMethodBeat.i(212693);
    boo localboo = new boo();
    bop localbop = new bop();
    a((dop)localboo, (dpc)localbop, 5852, "/cgi-bin/micromsg-bin/getincomepageinfo");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetWecoinIncomePageInfoRequest: ");
    AppMethodBeat.o(212693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.g
 * JD-Core Version:    0.7.0.1
 */