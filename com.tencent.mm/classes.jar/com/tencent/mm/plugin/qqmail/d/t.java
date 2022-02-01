package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;

public final class t
  extends n
  implements k
{
  private f callback;
  private b gPp;
  
  public t()
  {
    AppMethodBeat.i(215209);
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.hNM = new af();
    locala.hNN = new ag();
    locala.uri = "/cgi-bin/micromsg-bin/unbindxmail";
    this.gPp = locala.aDC();
    AppMethodBeat.o(215209);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215210);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
    AppMethodBeat.o(215210);
    return i;
  }
  
  public final int getType()
  {
    return 3889;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215211);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(215211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.t
 * JD-Core Version:    0.7.0.1
 */