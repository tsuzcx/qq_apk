package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
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
  public String dyb;
  private b hZD;
  
  public d(String paramString, an paraman)
  {
    AppMethodBeat.i(218003);
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_sendmail";
    aw localaw = new aw();
    g.ajP();
    localaw.uin = a.getUin();
    localaw.xtg = paraman;
    locala.hQF = localaw;
    locala.hQG = new ax();
    this.hZD = locala.aDS();
    this.dyb = paramString;
    AppMethodBeat.o(218003);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(218004);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(218004);
    return i;
  }
  
  public final int getType()
  {
    return 11166;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218005);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(218005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.d
 * JD-Core Version:    0.7.0.1
 */