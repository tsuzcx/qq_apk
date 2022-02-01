package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.aki;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiEncashIncomeRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/EncashIncomeResponse;", "token", "", "ctxBuff", "Lcom/tencent/mm/protobuf/ByteString;", "sign", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;)V", "plugin-wxpay_release"})
public final class c
  extends m<akj>
{
  public c(String paramString, b paramb1, b paramb2)
  {
    AppMethodBeat.i(227623);
    aki localaki = new aki();
    localaki.SpV = paramb1;
    localaki.SpW = paramb2;
    localaki.token = paramString;
    paramString = new akj();
    a((dyl)localaki, (dyy)paramString, 5991, "/cgi-bin/micromsg-bin/encashincome");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiEncashIncomeRequest: ctx_buff: " + paramb1 + ", sign: " + paramb2);
    AppMethodBeat.o(227623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.c
 * JD-Core Version:    0.7.0.1
 */