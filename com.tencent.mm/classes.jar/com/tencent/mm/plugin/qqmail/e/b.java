package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.qqmail.d.aq;
import com.tencent.mm.plugin.qqmail.d.ar;

public final class b
  extends n
  implements k
{
  private f callback;
  public com.tencent.mm.al.b hWL;
  
  public b()
  {
    AppMethodBeat.i(215251);
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_getunreadcount";
    aq localaq = new aq();
    g.ajA();
    localaq.uin = a.getUin();
    locala.hNM = localaq;
    locala.hNN = new ar();
    this.hWL = locala.aDC();
    AppMethodBeat.o(215251);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215252);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
    AppMethodBeat.o(215252);
    return i;
  }
  
  public final int getType()
  {
    return 12213;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215253);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(215253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.b
 * JD-Core Version:    0.7.0.1
 */