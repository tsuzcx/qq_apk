package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cgk;
import com.tencent.mm.protocal.protobuf.cgl;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetWecoinPriceListRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPriceListResponse;", "()V", "plugin-wxpay_release"})
public final class j
  extends m<cgl>
{
  public j()
  {
    AppMethodBeat.i(277904);
    cgk localcgk = new cgk();
    cgl localcgl = new cgl();
    a((dyl)localcgk, (dyy)localcgl, 6299, "/cgi-bin/micromsg-bin/getwecoinpricelist");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetWecoinPriceListRequest: ");
    AppMethodBeat.o(277904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.j
 * JD-Core Version:    0.7.0.1
 */