package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
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
  public String dPI;
  private com.tencent.mm.ak.d iUB;
  
  public d(String paramString, an paraman)
  {
    AppMethodBeat.i(198659);
    d.a locala = new d.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_sendmail";
    aw localaw = new aw();
    com.tencent.mm.kernel.g.aAf();
    localaw.uin = a.getUin();
    localaw.Btj = paraman;
    locala.iLN = localaw;
    locala.iLO = new ax();
    this.iUB = locala.aXF();
    this.dPI = paramString;
    AppMethodBeat.o(198659);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(198660);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(198660);
    return i;
  }
  
  public final int getType()
  {
    return 11166;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198661);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(198661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.d
 * JD-Core Version:    0.7.0.1
 */