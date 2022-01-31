package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.protocal.protobuf.bqm;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends a<bqm>
{
  public c()
  {
    AppMethodBeat.i(46168);
    b.a locala = new b.a();
    locala.fsX = new bql();
    locala.fsY = new bqm();
    locala.funcId = 2904;
    locala.uri = "/cgi-bin/mmpay-bin/queryunipayorder";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ab.i("MicroMsg.CgiQueryUniPayOrder", "query uni pay order");
    AppMethodBeat.o(46168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.c
 * JD-Core Version:    0.7.0.1
 */