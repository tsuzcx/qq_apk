package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
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
  private com.tencent.mm.ak.f callback;
  private b hZD;
  public String xqW;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(218009);
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_updatemailstatus";
    bb localbb = new bb();
    localbb.xtr.add(paramString);
    g.ajP();
    localbb.uin = a.getUin();
    localbb.xts = paramInt;
    locala.hQF = localbb;
    locala.hQG = new bc();
    this.hZD = locala.aDS();
    this.xqW = paramString;
    AppMethodBeat.o(218009);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(218010);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(218010);
    return i;
  }
  
  public final int getType()
  {
    return 11480;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218011);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(218011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.f
 * JD-Core Version:    0.7.0.1
 */