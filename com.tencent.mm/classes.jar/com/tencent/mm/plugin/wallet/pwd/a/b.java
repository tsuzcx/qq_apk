package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.cgc;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends a<cgd>
{
  public b()
  {
    AppMethodBeat.i(69523);
    b.a locala = new b.a();
    locala.hNM = new cgc();
    locala.hNN = new cgd();
    locala.funcId = 2513;
    locala.uri = "/cgi-bin/mmpay-bin/openunipayorder";
    locala.hNO = 0;
    locala.respCmdId = 0;
    c(locala.aDC());
    ad.i("MicroMsg.CgiOpenUniPayOrder", "open uni pay order");
    AppMethodBeat.o(69523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.b
 * JD-Core Version:    0.7.0.1
 */