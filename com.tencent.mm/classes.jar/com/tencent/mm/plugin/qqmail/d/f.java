package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.model.ba;
import com.tencent.mm.plugin.qqmail.model.bb;
import java.util.LinkedList;

public final class f
  extends p
  implements m
{
  public String Njg;
  private com.tencent.mm.am.h callback;
  private c oDw;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(266885);
    c.a locala = new c.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_updatemailstatus";
    ba localba = new ba();
    localba.NlC.add(paramString);
    com.tencent.mm.kernel.h.baC();
    localba.uin = b.getUin();
    localba.NlD = paramInt;
    locala.otE = localba;
    locala.otF = new bb();
    this.oDw = locala.bEF();
    this.Njg = paramString;
    AppMethodBeat.o(266885);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(266893);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(266893);
    return i;
  }
  
  public final int getType()
  {
    return 11480;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(266899);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(266899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.f
 * JD-Core Version:    0.7.0.1
 */