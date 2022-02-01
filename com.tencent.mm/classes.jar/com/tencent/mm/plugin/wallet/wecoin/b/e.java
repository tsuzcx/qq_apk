package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.fba;
import com.tencent.mm.protocal.protobuf.fbb;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetRealNameAuthRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/WecoinRealNameAuthResponse;", "token", "", "requestID", "(Ljava/lang/String;Ljava/lang/String;)V", "plugin-wxpay_release"})
public final class e
  extends l<fbb>
{
  public e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212691);
    fba localfba = new fba();
    localfba.token = paramString1;
    localfba.request_id = paramString2;
    paramString1 = new fbb();
    a((dop)localfba, (dpc)paramString1, 6280, "/cgi-bin/micromsg-bin/wecoinrealnameauth");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetRealNameAuthRequest: ");
    AppMethodBeat.o(212691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.e
 * JD-Core Version:    0.7.0.1
 */