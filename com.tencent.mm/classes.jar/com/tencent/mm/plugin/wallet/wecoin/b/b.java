package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.agc;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiConsumeWecoinRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/ConsumeWecoinResponse;", "ctxBuff", "Lcom/tencent/mm/protobuf/ByteString;", "sessionID", "", "signBuff", "(Lcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends n<agc>
{
  public b(com.tencent.mm.bx.b paramb1, String paramString, com.tencent.mm.bx.b paramb2)
  {
    AppMethodBeat.i(315706);
    agb localagb = new agb();
    localagb.ZoS = paramb2;
    localagb.ZoR = paramb1;
    localagb.ZoT = paramString;
    agc localagc = new agc();
    a((erp)localagb, (esc)localagc, 5994, "/cgi-bin/micromsg-bin/consumewecoin");
    Log.i("MicroMsg.CommonWeCoinCgi", "CgiConsumeWecoinRequest: ctxBuff: " + paramb1 + ", sign: " + paramb2 + ", sessionID: " + paramString);
    AppMethodBeat.o(315706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.b.b
 * JD-Core Version:    0.7.0.1
 */