package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.adt;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiConsumeWecoinRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/ConsumeWecoinResponse;", "ctxBuff", "Lcom/tencent/mm/protobuf/ByteString;", "sessionID", "", "signBuff", "(Lcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "plugin-wxpay_release"})
public final class b
  extends m<adt>
{
  public b(com.tencent.mm.cd.b paramb1, String paramString, com.tencent.mm.cd.b paramb2)
  {
    AppMethodBeat.i(250669);
    ads localads = new ads();
    localads.SpW = paramb2;
    localads.SpV = paramb1;
    localads.SpX = paramString;
    adt localadt = new adt();
    a((dyl)localads, (dyy)localadt, 5994, "/cgi-bin/micromsg-bin/consumewecoin");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiConsumeWecoinRequest: ctxBuff: " + paramb1 + ", sign: " + paramb2 + ", sessionID: " + paramString);
    AppMethodBeat.o(250669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.b
 * JD-Core Version:    0.7.0.1
 */