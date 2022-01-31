package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.cmh;
import com.tencent.mm.protocal.protobuf.cmi;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends a<cmi>
{
  public c(String paramString)
  {
    AppMethodBeat.i(142392);
    b.a locala = new b.a();
    cmh localcmh = new cmh();
    localcmh.wKD = paramString;
    localcmh.timestamp = System.currentTimeMillis();
    locala.fsX = localcmh;
    locala.fsY = new cmi();
    locala.uri = "/cgi-bin/mmpay-bin/mktuncheckmchservicepos";
    locala.funcId = 2595;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ab.i("MicroMsg.CgiUnCheckMchServicePos", "CgiUnCheckMchServicePos: %s", new Object[] { paramString });
    AppMethodBeat.o(142392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.c
 * JD-Core Version:    0.7.0.1
 */