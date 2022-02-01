package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.d.aq;
import com.tencent.mm.plugin.qqmail.d.ar;

public final class b
  extends q
  implements m
{
  private i callback;
  public d lKU;
  
  public b()
  {
    AppMethodBeat.i(249679);
    d.a locala = new d.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_getunreadcount";
    aq localaq = new aq();
    h.aHE();
    localaq.uin = com.tencent.mm.kernel.b.getUin();
    locala.lBU = localaq;
    locala.lBV = new ar();
    this.lKU = locala.bgN();
    AppMethodBeat.o(249679);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(249681);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(249681);
    return i;
  }
  
  public final int getType()
  {
    return 12213;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(249682);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(249682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.b
 * JD-Core Version:    0.7.0.1
 */