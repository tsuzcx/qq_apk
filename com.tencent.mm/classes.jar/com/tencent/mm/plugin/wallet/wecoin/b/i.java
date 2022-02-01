package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cgi;
import com.tencent.mm.protocal.protobuf.cgj;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetWecoinPageInfoRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPageInfoResponse;", "()V", "plugin-wxpay_release"})
public final class i
  extends m<cgj>
{
  public i()
  {
    AppMethodBeat.i(270699);
    cgi localcgi = new cgi();
    cgj localcgj = new cgj();
    a((dyl)localcgi, (dyy)localcgj, 6633, "/cgi-bin/micromsg-bin/getwecoinpageinfo");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetWecoinPageInfoRequest: ");
    AppMethodBeat.o(270699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.i
 * JD-Core Version:    0.7.0.1
 */