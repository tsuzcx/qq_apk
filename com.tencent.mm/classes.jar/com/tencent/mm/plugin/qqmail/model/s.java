package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;

public final class s
  extends p
  implements m
{
  private h callback;
  private c nao;
  
  public s()
  {
    AppMethodBeat.i(267058);
    c.a locala = new c.a();
    locala.funcId = getType();
    locala.otE = new ae();
    locala.otF = new af();
    locala.uri = "/cgi-bin/micromsg-bin/unbindxmail";
    this.nao = locala.bEF();
    AppMethodBeat.o(267058);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(267060);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(267060);
    return i;
  }
  
  public final int getType()
  {
    return 3889;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(267065);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(267065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.s
 * JD-Core Version:    0.7.0.1
 */