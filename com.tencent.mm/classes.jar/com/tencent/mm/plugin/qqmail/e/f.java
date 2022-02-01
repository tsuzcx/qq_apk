package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.qqmail.d.bb;
import com.tencent.mm.plugin.qqmail.d.bc;
import java.util.LinkedList;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  private b hWL;
  public String xbf;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(215263);
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_updatemailstatus";
    bb localbb = new bb();
    localbb.xdA.add(paramString);
    g.ajA();
    localbb.uin = a.getUin();
    localbb.xdB = paramInt;
    locala.hNM = localbb;
    locala.hNN = new bc();
    this.hWL = locala.aDC();
    this.xbf = paramString;
    AppMethodBeat.o(215263);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(215264);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
    AppMethodBeat.o(215264);
    return i;
  }
  
  public final int getType()
  {
    return 11480;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215265);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(215265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.f
 * JD-Core Version:    0.7.0.1
 */