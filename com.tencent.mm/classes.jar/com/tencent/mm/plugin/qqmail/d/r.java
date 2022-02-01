package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ad;

public final class r
  extends n
  implements k
{
  private f callback;
  public b gPp;
  
  public r(String paramString)
  {
    AppMethodBeat.i(215206);
    b.a locala = new b.a();
    locala.funcId = getType();
    w localw = new w();
    localw.xck = paramString;
    locala.hNM = localw;
    locala.hNN = new x();
    locala.uri = "/cgi-bin/micromsg-bin/preparebindxmail";
    ad.i("MicroMsg.NetScenePrepareBindXmail", "bindQQMail %s", new Object[] { paramString });
    this.gPp = locala.aDC();
    AppMethodBeat.o(215206);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215207);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
    AppMethodBeat.o(215207);
    return i;
  }
  
  public final int getType()
  {
    return 3848;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215208);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(215208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.r
 * JD-Core Version:    0.7.0.1
 */