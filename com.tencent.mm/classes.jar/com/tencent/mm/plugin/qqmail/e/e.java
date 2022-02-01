package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
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
  public b hZD;
  public long xtu;
  
  public e(long paramLong)
  {
    AppMethodBeat.i(218006);
    this.xtu = paramLong;
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_syncconact";
    az localaz = new az();
    localaz.xtl = paramLong;
    g.ajP();
    localaz.uin = a.getUin();
    locala.hQF = localaz;
    locala.hQG = new ba();
    this.hZD = locala.aDS();
    AppMethodBeat.o(218006);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(218007);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(218007);
    return i;
  }
  
  public final int getType()
  {
    return 14418;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218008);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(218008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.e
 * JD-Core Version:    0.7.0.1
 */