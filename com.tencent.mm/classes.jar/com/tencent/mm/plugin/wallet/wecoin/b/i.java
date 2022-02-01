package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.protocal.protobuf.byr;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetWecoinPriceListRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPriceListResponse;", "()V", "plugin-wxpay_release"})
public final class i
  extends l<byr>
{
  public i()
  {
    AppMethodBeat.i(212695);
    byq localbyq = new byq();
    byr localbyr = new byr();
    a((dop)localbyq, (dpc)localbyr, 6299, "/cgi-bin/micromsg-bin/getwecoinpricelist");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetWecoinPriceListRequest: ");
    AppMethodBeat.o(212695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.i
 * JD-Core Version:    0.7.0.1
 */