package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetWecoinPageInfoRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPageInfoResponse;", "()V", "plugin-wxpay_release"})
public final class h
  extends l<byp>
{
  public h()
  {
    AppMethodBeat.i(212694);
    byo localbyo = new byo();
    byp localbyp = new byp();
    a((dop)localbyo, (dpc)localbyp, 6633, "/cgi-bin/micromsg-bin/getwecoinpageinfo");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetWecoinPageInfoRequest: ");
    AppMethodBeat.o(212694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.h
 * JD-Core Version:    0.7.0.1
 */