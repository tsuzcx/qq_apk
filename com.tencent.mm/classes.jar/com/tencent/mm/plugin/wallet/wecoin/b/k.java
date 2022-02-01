package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiPrepareIncomeEncashRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/PrepareIncomeEncashResponse;", "requestID", "", "sessionID", "amount", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "plugin-wxpay_release"})
public final class k
  extends m<doa>
{
  public k(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(267390);
    dnz localdnz = new dnz();
    localdnz.request_id = paramString1;
    localdnz.gbJ = paramLong;
    localdnz.SpX = paramString2;
    paramString2 = new doa();
    a((dyl)localdnz, (dyy)paramString2, 5838, "/cgi-bin/micromsg-bin/prepareincomeencash");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiPrepareIncomeEncashRequest: requestID: " + paramString1 + ", amount: " + paramLong);
    AppMethodBeat.o(267390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.k
 * JD-Core Version:    0.7.0.1
 */