package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.model.ap;
import com.tencent.mm.plugin.qqmail.model.aq;

public final class b
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  public c oDw;
  
  public b()
  {
    AppMethodBeat.i(266890);
    c.a locala = new c.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_getunreadcount";
    ap localap = new ap();
    com.tencent.mm.kernel.h.baC();
    localap.uin = com.tencent.mm.kernel.b.getUin();
    locala.otE = localap;
    locala.otF = new aq();
    this.oDw = locala.bEF();
    AppMethodBeat.o(266890);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(266896);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(266896);
    return i;
  }
  
  public final int getType()
  {
    return 12213;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(266903);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(266903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.b
 * JD-Core Version:    0.7.0.1
 */