package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.cpn;
import com.tencent.mm.protocal.protobuf.cpo;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends a<cpo>
{
  public c()
  {
    AppMethodBeat.i(69524);
    b.a locala = new b.a();
    locala.hNM = new cpn();
    locala.hNN = new cpo();
    locala.funcId = 2904;
    locala.uri = "/cgi-bin/mmpay-bin/queryunipayorder";
    locala.hNO = 0;
    locala.respCmdId = 0;
    c(locala.aDC());
    ad.i("MicroMsg.CgiQueryUniPayOrder", "query uni pay order");
    AppMethodBeat.o(69524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.c
 * JD-Core Version:    0.7.0.1
 */