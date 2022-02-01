package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.ajh;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiEncashIncomeRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/EncashIncomeResponse;", "token", "", "ctxBuff", "Lcom/tencent/mm/protobuf/ByteString;", "sign", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;)V", "plugin-wxpay_release"})
public final class c
  extends l<aji>
{
  public c(String paramString, b paramb1, b paramb2)
  {
    AppMethodBeat.i(212689);
    ajh localajh = new ajh();
    localajh.Loz = paramb1;
    localajh.LoA = paramb2;
    localajh.token = paramString;
    paramString = new aji();
    a((dop)localajh, (dpc)paramString, 5991, "/cgi-bin/micromsg-bin/encashincome");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiEncashIncomeRequest: ctx_buff: " + paramb1 + ", sign: " + paramb2);
    AppMethodBeat.o(212689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.c
 * JD-Core Version:    0.7.0.1
 */