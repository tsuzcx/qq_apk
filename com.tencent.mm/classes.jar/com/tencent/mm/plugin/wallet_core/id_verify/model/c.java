package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends a<cry>
{
  public c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(174503);
    crx localcrx = new crx();
    b.a locala = new b.a();
    localcrx.DgJ = paramString2;
    localcrx.DlK = paramString3;
    localcrx.dwj = paramString1;
    localcrx.DrK = paramString4;
    locala.hQF = localcrx;
    locala.hQG = new cry();
    locala.funcId = 2752;
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/realnameverifysms";
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    ae.i("MicroMsg.CgiRealnameVerifySms", "verify sms: %s, %s, reqkey: %s", new Object[] { paramString3, paramString2, paramString1 });
    AppMethodBeat.o(174503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.c
 * JD-Core Version:    0.7.0.1
 */