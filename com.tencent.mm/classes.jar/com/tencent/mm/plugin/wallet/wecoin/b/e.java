package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetMidasSdkInfoRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMidasSdkInfoResponse;", "()V", "plugin-wxpay_release"})
public final class e
  extends m<byg>
{
  public e()
  {
    AppMethodBeat.i(267928);
    byf localbyf = new byf();
    byg localbyg = new byg();
    a((dyl)localbyf, (dyy)localbyg, 6684, "/cgi-bin/micromsg-bin/getmidassdkinfo");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetMidasSdkInfoRequest: ");
    AppMethodBeat.o(267928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.e
 * JD-Core Version:    0.7.0.1
 */