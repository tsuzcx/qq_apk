package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dej;
import com.tencent.mm.protocal.protobuf.dek;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiPrepareIncomeEncashRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/PrepareIncomeEncashResponse;", "requestID", "", "sessionID", "amount", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "plugin-wxpay_release"})
public final class j
  extends l<dek>
{
  public j(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(212696);
    dej localdej = new dej();
    localdej.request_id = paramString1;
    localdej.eht = paramLong;
    localdej.LoB = paramString2;
    paramString2 = new dek();
    a((dop)localdej, (dpc)paramString2, 5838, "/cgi-bin/micromsg-bin/prepareincomeencash");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiPrepareIncomeEncashRequest: requestID: " + paramString1 + ", amount: " + paramLong);
    AppMethodBeat.o(212696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.j
 * JD-Core Version:    0.7.0.1
 */