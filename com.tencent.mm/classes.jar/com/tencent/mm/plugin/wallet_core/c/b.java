package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.beu;
import com.tencent.mm.protocal.protobuf.bev;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends c<bev>
{
  public b(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(69888);
    d.a locala = new d.a();
    beu localbeu = new beu();
    localbeu.LjW = paramString;
    localbeu.LOB = paramInt1;
    localbeu.LOC = paramInt2;
    locala.iLN = localbeu;
    locala.iLO = new bev();
    locala.uri = "/cgi-bin/mmpay-bin/mktfollowcardbdmch";
    locala.funcId = 2720;
    locala.iLP = 0;
    locala.respCmdId = 0;
    c(locala.aXF());
    Log.i("MicroMsg.CgiFollowCardBDMch", "CgiFollowCardBDMch: %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(69888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.b
 * JD-Core Version:    0.7.0.1
 */