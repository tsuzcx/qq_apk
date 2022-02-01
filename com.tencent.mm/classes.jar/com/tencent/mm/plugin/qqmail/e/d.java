package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.d.an;
import com.tencent.mm.plugin.qqmail.d.aw;
import com.tencent.mm.plugin.qqmail.d.ax;

public final class d
  extends q
  implements m
{
  private i callback;
  public String fIY;
  private com.tencent.mm.an.d lKU;
  
  public d(String paramString, an paraman)
  {
    AppMethodBeat.i(250175);
    d.a locala = new d.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_sendmail";
    aw localaw = new aw();
    h.aHE();
    localaw.uin = b.getUin();
    localaw.HnD = paraman;
    locala.lBU = localaw;
    locala.lBV = new ax();
    this.lKU = locala.bgN();
    this.fIY = paramString;
    AppMethodBeat.o(250175);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(250177);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(250177);
    return i;
  }
  
  public final int getType()
  {
    return 11166;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(250178);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(250178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.d
 * JD-Core Version:    0.7.0.1
 */