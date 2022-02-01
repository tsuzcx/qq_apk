package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.atu;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends a<atv>
{
  public b(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(69888);
    b.a locala = new b.a();
    atu localatu = new atu();
    localatu.Gpk = paramString;
    localatu.GKH = paramInt1;
    localatu.GKI = paramInt2;
    locala.hQF = localatu;
    locala.hQG = new atv();
    locala.uri = "/cgi-bin/mmpay-bin/mktfollowcardbdmch";
    locala.funcId = 2720;
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    ae.i("MicroMsg.CgiFollowCardBDMch", "CgiFollowCardBDMch: %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(69888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.b
 * JD-Core Version:    0.7.0.1
 */