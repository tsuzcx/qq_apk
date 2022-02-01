package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
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
  public com.tencent.mm.ak.b hZD;
  
  public b()
  {
    AppMethodBeat.i(217997);
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_getunreadcount";
    aq localaq = new aq();
    g.ajP();
    localaq.uin = a.getUin();
    locala.hQF = localaq;
    locala.hQG = new ar();
    this.hZD = locala.aDS();
    AppMethodBeat.o(217997);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(217998);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(217998);
    return i;
  }
  
  public final int getType()
  {
    return 12213;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(217999);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(217999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.b
 * JD-Core Version:    0.7.0.1
 */