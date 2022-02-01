package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.gik;
import com.tencent.mm.protocal.protobuf.gil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetRealNameAuthRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/WecoinRealNameAuthResponse;", "token", "", "requestID", "businessID", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends n<gil>
{
  public g(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(315707);
    gik localgik = new gik();
    localgik.token = paramString1;
    localgik.request_id = paramString2;
    localgik.aarV = paramInt;
    paramString1 = new gil();
    a((erp)localgik, (esc)paramString1, 6280, "/cgi-bin/micromsg-bin/wecoinrealnameauth");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetRealNameAuthRequest: ");
    AppMethodBeat.o(315707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.g
 * JD-Core Version:    0.7.0.1
 */