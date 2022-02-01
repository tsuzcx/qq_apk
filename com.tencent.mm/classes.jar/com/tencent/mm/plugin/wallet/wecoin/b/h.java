package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bwl;
import com.tencent.mm.protocal.protobuf.bwm;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetWecoinIncomePageInfoRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetIncomePageInfoResponse;", "()V", "plugin-wxpay_release"})
public final class h
  extends m<bwm>
{
  public h()
  {
    AppMethodBeat.i(250547);
    bwl localbwl = new bwl();
    bwm localbwm = new bwm();
    a((dyl)localbwl, (dyy)localbwm, 5852, "/cgi-bin/micromsg-bin/getincomepageinfo");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetWecoinIncomePageInfoRequest: ");
    AppMethodBeat.o(250547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.h
 * JD-Core Version:    0.7.0.1
 */