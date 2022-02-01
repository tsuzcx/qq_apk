package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.clo;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetWecoinIncomePageInfoRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetIncomePageInfoResponse;", "()V", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends n<clp>
{
  public i()
  {
    AppMethodBeat.i(315695);
    clo localclo = new clo();
    clp localclp = new clp();
    a((erp)localclo, (esc)localclp, 5852, "/cgi-bin/micromsg-bin/getincomepageinfo");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetWecoinIncomePageInfoRequest: ");
    AppMethodBeat.o(315695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.i
 * JD-Core Version:    0.7.0.1
 */