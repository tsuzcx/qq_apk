package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.model.am;
import com.tencent.mm.plugin.qqmail.model.av;
import com.tencent.mm.plugin.qqmail.model.aw;

public final class d
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  public String hOG;
  private c oDw;
  
  public d(String paramString, am paramam)
  {
    AppMethodBeat.i(266889);
    c.a locala = new c.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_sendmail";
    av localav = new av();
    com.tencent.mm.kernel.h.baC();
    localav.uin = b.getUin();
    localav.Nlr = paramam;
    locala.otE = localav;
    locala.otF = new aw();
    this.oDw = locala.bEF();
    this.hOG = paramString;
    AppMethodBeat.o(266889);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(266897);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(266897);
    return i;
  }
  
  public final int getType()
  {
    return 11166;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(266904);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(266904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.d
 * JD-Core Version:    0.7.0.1
 */