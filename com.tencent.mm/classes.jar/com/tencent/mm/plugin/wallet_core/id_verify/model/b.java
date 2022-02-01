package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.cgz;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends c<cgz>
{
  public b(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(174502);
    che localche = new che();
    b.a locala = new b.a();
    localche.zWw = paramString1;
    localche.Abv = paramString2;
    localche.EcF = paramInt;
    localche.dlJ = paramString3;
    locala.gUU = localche;
    locala.gUV = new cgz();
    locala.funcId = 1923;
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/realnamesendsms";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ad.i("MicroMsg.CgiRealnameSendSms", "send sms: %s, %s, isRetry: %s", new Object[] { paramString2, paramString1, Integer.valueOf(paramInt) });
    AppMethodBeat.o(174502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.b
 * JD-Core Version:    0.7.0.1
 */