package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.d.az;
import com.tencent.mm.plugin.qqmail.d.ba;

public final class e
  extends q
  implements m
{
  public long Btx;
  private i callback;
  public d iUB;
  
  public e(long paramLong)
  {
    AppMethodBeat.i(198662);
    this.Btx = paramLong;
    d.a locala = new d.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_syncconact";
    az localaz = new az();
    localaz.Bto = paramLong;
    com.tencent.mm.kernel.g.aAf();
    localaz.uin = a.getUin();
    locala.iLN = localaz;
    locala.iLO = new ba();
    this.iUB = locala.aXF();
    AppMethodBeat.o(198662);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(198663);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(198663);
    return i;
  }
  
  public final int getType()
  {
    return 14418;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198664);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(198664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.e
 * JD-Core Version:    0.7.0.1
 */