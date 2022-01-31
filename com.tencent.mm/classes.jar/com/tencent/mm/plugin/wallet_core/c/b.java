package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends a<adx>
{
  public b(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142391);
    b.a locala = new b.a();
    adw localadw = new adw();
    localadw.wKD = paramString;
    localadw.wWO = paramInt1;
    localadw.wWP = paramInt2;
    locala.fsX = localadw;
    locala.fsY = new adx();
    locala.uri = "/cgi-bin/mmpay-bin/mktfollowcardbdmch";
    locala.funcId = 2720;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ab.i("MicroMsg.CgiFollowCardBDMch", "CgiFollowCardBDMch: %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(142391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.b
 * JD-Core Version:    0.7.0.1
 */