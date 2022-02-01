package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.d.az;
import com.tencent.mm.plugin.qqmail.d.ba;

public final class e
  extends q
  implements m
{
  public long HnR;
  private i callback;
  public d lKU;
  
  public e(long paramLong)
  {
    AppMethodBeat.i(249786);
    this.HnR = paramLong;
    d.a locala = new d.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_syncconact";
    az localaz = new az();
    localaz.HnI = paramLong;
    h.aHE();
    localaz.uin = b.getUin();
    locala.lBU = localaz;
    locala.lBV = new ba();
    this.lKU = locala.bgN();
    AppMethodBeat.o(249786);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(249788);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(249788);
    return i;
  }
  
  public final int getType()
  {
    return 14418;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(249790);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(249790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.e
 * JD-Core Version:    0.7.0.1
 */