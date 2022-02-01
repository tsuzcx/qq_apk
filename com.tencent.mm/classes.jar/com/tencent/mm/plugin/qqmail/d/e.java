package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.model.ay;
import com.tencent.mm.plugin.qqmail.model.az;

public final class e
  extends p
  implements m
{
  public long NlE;
  private com.tencent.mm.am.h callback;
  public c oDw;
  
  public e(long paramLong)
  {
    AppMethodBeat.i(266888);
    this.NlE = paramLong;
    c.a locala = new c.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_syncconact";
    ay localay = new ay();
    localay.Nlw = paramLong;
    com.tencent.mm.kernel.h.baC();
    localay.uin = b.getUin();
    locala.otE = localay;
    locala.otF = new az();
    this.oDw = locala.bEF();
    AppMethodBeat.o(266888);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(266898);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(266898);
    return i;
  }
  
  public final int getType()
  {
    return 14418;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(266906);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(266906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.e
 * JD-Core Version:    0.7.0.1
 */