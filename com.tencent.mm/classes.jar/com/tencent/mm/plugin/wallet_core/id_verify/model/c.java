package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.cmd;
import com.tencent.mm.protocal.protobuf.cme;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends com.tencent.mm.ak.c<cme>
{
  public c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(174503);
    cmd localcmd = new cmd();
    b.a locala = new b.a();
    localcmd.BoQ = paramString2;
    localcmd.BtP = paramString3;
    localcmd.djr = paramString1;
    localcmd.BzM = paramString4;
    locala.hvt = localcmd;
    locala.hvu = new cme();
    locala.funcId = 2752;
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/realnameverifysms";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ac.i("MicroMsg.CgiRealnameVerifySms", "verify sms: %s, %s, reqkey: %s", new Object[] { paramString3, paramString2, paramString1 });
    AppMethodBeat.o(174503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.c
 * JD-Core Version:    0.7.0.1
 */