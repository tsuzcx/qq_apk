package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.egq;
import com.tencent.mm.protocal.protobuf.egr;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiPrepareIncomeEncashRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/PrepareIncomeEncashResponse;", "requestID", "", "sessionID", "businessID", "", "amount", "", "(Ljava/lang/String;Ljava/lang/String;IJ)V", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends n<egr>
{
  public l(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(315699);
    egq localegq = new egq();
    localegq.request_id = paramString1;
    localegq.aarV = paramInt;
    localegq.ihV = paramLong;
    localegq.ZoT = paramString2;
    paramString2 = new egr();
    a((erp)localegq, (esc)paramString2, 5838, "/cgi-bin/micromsg-bin/prepareincomeencash");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiPrepareIncomeEncashRequest: requestID: " + paramString1 + ", amount: " + paramLong + " businessID:" + paramInt);
    AppMethodBeat.o(315699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.l
 * JD-Core Version:    0.7.0.1
 */