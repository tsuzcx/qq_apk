package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cwn;
import com.tencent.mm.protocal.protobuf.cwo;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetWecoinPriceListRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPriceListResponse;", "businessID", "", "(I)V", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends n<cwo>
{
  public k(int paramInt)
  {
    AppMethodBeat.i(315698);
    cwn localcwn = new cwn();
    localcwn.aarV = paramInt;
    cwo localcwo = new cwo();
    a((erp)localcwn, (esc)localcwo, 6299, "/cgi-bin/micromsg-bin/getwecoinpricelist");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetWecoinPriceListRequest: ");
    AppMethodBeat.o(315698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.k
 * JD-Core Version:    0.7.0.1
 */