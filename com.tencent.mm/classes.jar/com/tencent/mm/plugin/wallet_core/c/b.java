package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.ate;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends a<atf>
{
  public b(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(69888);
    b.a locala = new b.a();
    ate localate = new ate();
    localate.FWL = paramString;
    localate.Grj = paramInt1;
    localate.Grk = paramInt2;
    locala.hNM = localate;
    locala.hNN = new atf();
    locala.uri = "/cgi-bin/mmpay-bin/mktfollowcardbdmch";
    locala.funcId = 2720;
    locala.hNO = 0;
    locala.respCmdId = 0;
    c(locala.aDC());
    ad.i("MicroMsg.CgiFollowCardBDMch", "CgiFollowCardBDMch: %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(69888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.b
 * JD-Core Version:    0.7.0.1
 */