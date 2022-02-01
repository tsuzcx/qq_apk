package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ae;

public final class r
  extends n
  implements k
{
  private f callback;
  public b gRX;
  
  public r(String paramString)
  {
    AppMethodBeat.i(217952);
    b.a locala = new b.a();
    locala.funcId = getType();
    w localw = new w();
    localw.xsb = paramString;
    locala.hQF = localw;
    locala.hQG = new x();
    locala.uri = "/cgi-bin/micromsg-bin/preparebindxmail";
    ae.i("MicroMsg.NetScenePrepareBindXmail", "bindQQMail %s", new Object[] { paramString });
    this.gRX = locala.aDS();
    AppMethodBeat.o(217952);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(217953);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(217953);
    return i;
  }
  
  public final int getType()
  {
    return 3848;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(217954);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(217954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.r
 * JD-Core Version:    0.7.0.1
 */