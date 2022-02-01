package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.vk;
import com.tencent.mm.protocal.protobuf.vl;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiCancelWecoinRechargeRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/CancelWecoinRechargeResponse;", "billNo", "", "(Ljava/lang/String;)V", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends n<vl>
{
  public a(String paramString)
  {
    AppMethodBeat.i(315705);
    vk localvk = new vk();
    localvk.YzL = paramString;
    vl localvl = new vl();
    a((erp)localvk, (esc)localvl, 6233, "/cgi-bin/micromsg-bin/cancelwecoinrecharge");
    Log.i("MicroMsg.CommonWeCoinCgi", s.X("CgiCancelWecoinRechargeRequest: billNo: ", paramString));
    AppMethodBeat.o(315705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.a
 * JD-Core Version:    0.7.0.1
 */