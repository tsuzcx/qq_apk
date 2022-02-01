package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.qqmail.d.az;
import com.tencent.mm.plugin.qqmail.d.ba;

public final class e
  extends n
  implements k
{
  private f callback;
  public b hWL;
  public long xdD;
  
  public e(long paramLong)
  {
    AppMethodBeat.i(215260);
    this.xdD = paramLong;
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_syncconact";
    az localaz = new az();
    localaz.xdu = paramLong;
    g.ajA();
    localaz.uin = a.getUin();
    locala.hNM = localaz;
    locala.hNN = new ba();
    this.hWL = locala.aDC();
    AppMethodBeat.o(215260);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(215261);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
    AppMethodBeat.o(215261);
    return i;
  }
  
  public final int getType()
  {
    return 14418;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215262);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(215262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.e
 * JD-Core Version:    0.7.0.1
 */