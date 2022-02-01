package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends c<apl>
{
  public b(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(69888);
    b.a locala = new b.a();
    apk localapk = new apk();
    localapk.Epz = paramString;
    localapk.EIs = paramInt1;
    localapk.EIt = paramInt2;
    locala.hvt = localapk;
    locala.hvu = new apl();
    locala.uri = "/cgi-bin/mmpay-bin/mktfollowcardbdmch";
    locala.funcId = 2720;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ac.i("MicroMsg.CgiFollowCardBDMch", "CgiFollowCardBDMch: %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(69888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.b
 * JD-Core Version:    0.7.0.1
 */