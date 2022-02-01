package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.model.as;
import com.tencent.mm.plugin.qqmail.model.at;

public final class c
  extends p
  implements m
{
  public String Njg;
  private com.tencent.mm.am.h callback;
  public com.tencent.mm.am.c oDw;
  
  public c(String paramString)
  {
    AppMethodBeat.i(266887);
    c.a locala = new c.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_readmail";
    as localas = new as();
    localas.NkT = paramString;
    com.tencent.mm.kernel.h.baC();
    localas.uin = b.getUin();
    locala.otE = localas;
    locala.otF = new at();
    this.oDw = locala.bEF();
    this.Njg = paramString;
    AppMethodBeat.o(266887);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(266895);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(266895);
    return i;
  }
  
  public final int getType()
  {
    return 11312;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(266902);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(266902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.c
 * JD-Core Version:    0.7.0.1
 */