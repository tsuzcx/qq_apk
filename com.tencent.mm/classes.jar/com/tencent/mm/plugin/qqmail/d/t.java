package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;

public final class t
  extends n
  implements k
{
  private f callback;
  private b gRX;
  
  public t()
  {
    AppMethodBeat.i(217955);
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.hQF = new af();
    locala.hQG = new ag();
    locala.uri = "/cgi-bin/micromsg-bin/unbindxmail";
    this.gRX = locala.aDS();
    AppMethodBeat.o(217955);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(217956);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(217956);
    return i;
  }
  
  public final int getType()
  {
    return 3889;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(217957);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(217957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.t
 * JD-Core Version:    0.7.0.1
 */