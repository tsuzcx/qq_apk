package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.cqh;
import com.tencent.mm.protocal.protobuf.cqi;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends a<cqi>
{
  public c()
  {
    AppMethodBeat.i(69524);
    b.a locala = new b.a();
    locala.hQF = new cqh();
    locala.hQG = new cqi();
    locala.funcId = 2904;
    locala.uri = "/cgi-bin/mmpay-bin/queryunipayorder";
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    ae.i("MicroMsg.CgiQueryUniPayOrder", "query uni pay order");
    AppMethodBeat.o(69524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.c
 * JD-Core Version:    0.7.0.1
 */