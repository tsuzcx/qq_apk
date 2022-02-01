package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiEncashIncomeRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/EncashIncomeResponse;", "token", "", "ctxBuff", "Lcom/tencent/mm/protobuf/ByteString;", "sign", "agentId", "action", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;I)V", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends n<ans>
{
  public c(String paramString1, b paramb1, b paramb2, String paramString2, int paramInt)
  {
    AppMethodBeat.i(315712);
    anr localanr = new anr();
    localanr.ZoR = paramb1;
    localanr.ZoS = paramb2;
    localanr.token = paramString1;
    localanr.Zvp = paramString2;
    localanr.action = paramInt;
    paramString1 = new ans();
    a((erp)localanr, (esc)paramString1, 5991, "/cgi-bin/micromsg-bin/encashincome");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiEncashIncomeRequest: ctx_buff: " + paramb1 + ", sign: " + paramb2);
    AppMethodBeat.o(315712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.c
 * JD-Core Version:    0.7.0.1
 */