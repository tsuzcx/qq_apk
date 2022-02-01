package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.amh;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends c<ami>
{
  public b(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(69888);
    b.a locala = new b.a();
    amh localamh = new amh();
    localamh.CWQ = paramString;
    localamh.Dns = paramInt1;
    localamh.Dnt = paramInt2;
    locala.gUU = localamh;
    locala.gUV = new ami();
    locala.uri = "/cgi-bin/mmpay-bin/mktfollowcardbdmch";
    locala.funcId = 2720;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ad.i("MicroMsg.CgiFollowCardBDMch", "CgiFollowCardBDMch: %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(69888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.b
 * JD-Core Version:    0.7.0.1
 */