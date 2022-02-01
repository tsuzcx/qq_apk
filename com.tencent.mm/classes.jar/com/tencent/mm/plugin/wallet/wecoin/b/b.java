package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.protocal.protobuf.adm;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiConsumeWecoinRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/ConsumeWecoinResponse;", "ctxBuff", "Lcom/tencent/mm/protobuf/ByteString;", "sessionID", "", "signBuff", "(Lcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "plugin-wxpay_release"})
public final class b
  extends l<adm>
{
  public b(com.tencent.mm.bw.b paramb1, String paramString, com.tencent.mm.bw.b paramb2)
  {
    AppMethodBeat.i(212688);
    adl localadl = new adl();
    localadl.LoA = paramb2;
    localadl.Loz = paramb1;
    localadl.LoB = paramString;
    adm localadm = new adm();
    a((dop)localadl, (dpc)localadm, 5994, "/cgi-bin/micromsg-bin/consumewecoin");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiConsumeWecoinRequest: ctxBuff: " + paramb1 + ", sign: " + paramb2 + ", sessionID: " + paramString);
    AppMethodBeat.o(212688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.b
 * JD-Core Version:    0.7.0.1
 */