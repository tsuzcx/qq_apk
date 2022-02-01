package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.djy;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends com.tencent.mm.ak.c<djy>
{
  public c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(174503);
    djx localdjx = new djx();
    d.a locala = new d.a();
    localdjx.HQc = paramString2;
    localdjx.HVd = paramString3;
    localdjx.dNQ = paramString1;
    localdjx.IaW = paramString4;
    locala.iLN = localdjx;
    locala.iLO = new djy();
    locala.funcId = 2752;
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/realnameverifysms";
    locala.iLP = 0;
    locala.respCmdId = 0;
    c(locala.aXF());
    Log.i("MicroMsg.CgiRealnameVerifySms", "verify sms: %s, %s, reqkey: %s", new Object[] { paramString3, paramString2, paramString1 });
    AppMethodBeat.o(174503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.c
 * JD-Core Version:    0.7.0.1
 */