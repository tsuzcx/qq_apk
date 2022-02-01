package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.flt;
import com.tencent.mm.protocal.protobuf.flu;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetRealNameAuthRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/WecoinRealNameAuthResponse;", "token", "", "requestID", "(Ljava/lang/String;Ljava/lang/String;)V", "plugin-wxpay_release"})
public final class f
  extends m<flu>
{
  public f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(270820);
    flt localflt = new flt();
    localflt.token = paramString1;
    localflt.request_id = paramString2;
    paramString1 = new flu();
    a((dyl)localflt, (dyy)paramString1, 6280, "/cgi-bin/micromsg-bin/wecoinrealnameauth");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetRealNameAuthRequest: ");
    AppMethodBeat.o(270820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.f
 * JD-Core Version:    0.7.0.1
 */