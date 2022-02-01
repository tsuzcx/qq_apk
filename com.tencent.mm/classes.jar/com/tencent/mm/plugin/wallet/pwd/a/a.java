package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.zq;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends com.tencent.mm.al.a<zr>
{
  public a()
  {
    AppMethodBeat.i(69522);
    b.a locala = new b.a();
    locala.hNM = new zq();
    locala.hNN = new zr();
    locala.funcId = 2913;
    locala.uri = "/cgi-bin/mmpay-bin/closeunipayorder";
    locala.hNO = 0;
    locala.respCmdId = 0;
    c(locala.aDC());
    ad.i("MicroMsg.CgiCloseUniPayOrder", "close uni pay order");
    AppMethodBeat.o(69522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.a
 * JD-Core Version:    0.7.0.1
 */