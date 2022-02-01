package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.xe;
import com.tencent.mm.protocal.protobuf.xf;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends com.tencent.mm.an.c<xf>
{
  public c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(191413);
    xe localxe = new xe();
    localxe.llO = paramString1;
    localxe.Sji = paramString2;
    localxe.Inf = paramString3;
    d.a locala = new d.a();
    locala.lBU = localxe;
    locala.lBV = new xf();
    locala.funcId = 4969;
    locala.uri = "/cgi-bin/mmpay-bin/recalltransfer";
    locala.lBW = 0;
    locala.respCmdId = 0;
    c(locala.bgN());
    Log.i("MicroMsg.CgiTransferRecall", "recall: %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(191413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.c
 * JD-Core Version:    0.7.0.1
 */