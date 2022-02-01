package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.cha;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends com.tencent.mm.al.c<chb>
{
  public c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(174503);
    cha localcha = new cha();
    b.a locala = new b.a();
    localcha.zWw = paramString2;
    localcha.Abv = paramString3;
    localcha.dlJ = paramString1;
    localcha.Ahs = paramString4;
    locala.gUU = localcha;
    locala.gUV = new chb();
    locala.funcId = 2752;
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/realnameverifysms";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ad.i("MicroMsg.CgiRealnameVerifySms", "verify sms: %s, %s, reqkey: %s", new Object[] { paramString3, paramString2, paramString1 });
    AppMethodBeat.o(174503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.c
 * JD-Core Version:    0.7.0.1
 */