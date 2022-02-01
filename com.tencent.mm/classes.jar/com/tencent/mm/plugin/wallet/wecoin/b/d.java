package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.protocal.protobuf.bqm;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetMidasSdkInfoRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMidasSdkInfoResponse;", "()V", "plugin-wxpay_release"})
public final class d
  extends l<bqm>
{
  public d()
  {
    AppMethodBeat.i(212690);
    bql localbql = new bql();
    bqm localbqm = new bqm();
    a((dop)localbql, (dpc)localbqm, 6684, "/cgi-bin/micromsg-bin/getmidassdkinfo");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetMidasSdkInfoRequest: ");
    AppMethodBeat.o(212690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.d
 * JD-Core Version:    0.7.0.1
 */