package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.d.aq;
import com.tencent.mm.plugin.qqmail.d.ar;

public final class b
  extends q
  implements m
{
  private i callback;
  public d iUB;
  
  public b()
  {
    AppMethodBeat.i(198653);
    d.a locala = new d.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_getunreadcount";
    aq localaq = new aq();
    com.tencent.mm.kernel.g.aAf();
    localaq.uin = a.getUin();
    locala.iLN = localaq;
    locala.iLO = new ar();
    this.iUB = locala.aXF();
    AppMethodBeat.o(198653);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(198654);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(198654);
    return i;
  }
  
  public final int getType()
  {
    return 12213;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198655);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(198655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.b
 * JD-Core Version:    0.7.0.1
 */