package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.crd;
import com.tencent.mm.protocal.protobuf.cre;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends a<cre>
{
  public c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(174503);
    crd localcrd = new crd();
    b.a locala = new b.a();
    localcrd.CPf = paramString2;
    localcrd.CUe = paramString3;
    localcrd.dve = paramString1;
    localcrd.Daf = paramString4;
    locala.hNM = localcrd;
    locala.hNN = new cre();
    locala.funcId = 2752;
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/realnameverifysms";
    locala.hNO = 0;
    locala.respCmdId = 0;
    c(locala.aDC());
    ad.i("MicroMsg.CgiRealnameVerifySms", "verify sms: %s, %s, reqkey: %s", new Object[] { paramString3, paramString2, paramString1 });
    AppMethodBeat.o(174503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.c
 * JD-Core Version:    0.7.0.1
 */