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
import com.tencent.mm.plugin.qqmail.d.at;
import com.tencent.mm.plugin.qqmail.d.au;

public final class c
  extends n
  implements k
{
  private f callback;
  public b hZD;
  public String xqW;
  
  public c(String paramString)
  {
    AppMethodBeat.i(218000);
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_readmail";
    at localat = new at();
    localat.xsI = paramString;
    g.ajP();
    localat.uin = a.getUin();
    locala.hQF = localat;
    locala.hQG = new au();
    this.hZD = locala.aDS();
    this.xqW = paramString;
    AppMethodBeat.o(218000);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(218001);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(218001);
    return i;
  }
  
  public final int getType()
  {
    return 11312;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218002);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(218002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.c
 * JD-Core Version:    0.7.0.1
 */