package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.qqmail.d.an;
import com.tencent.mm.plugin.qqmail.d.aw;
import com.tencent.mm.plugin.qqmail.d.ax;

public final class d
  extends n
  implements k
{
  private f callback;
  public String dwW;
  private b hWL;
  
  public d(String paramString, an paraman)
  {
    AppMethodBeat.i(215257);
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_sendmail";
    aw localaw = new aw();
    g.ajA();
    localaw.uin = a.getUin();
    localaw.xdp = paraman;
    locala.hNM = localaw;
    locala.hNN = new ax();
    this.hWL = locala.aDC();
    this.dwW = paramString;
    AppMethodBeat.o(215257);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(215258);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
    AppMethodBeat.o(215258);
    return i;
  }
  
  public final int getType()
  {
    return 11166;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215259);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(215259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.d
 * JD-Core Version:    0.7.0.1
 */