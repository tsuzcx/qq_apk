package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;

public final class t
  extends q
  implements m
{
  private i callback;
  private d kwO;
  
  public t()
  {
    AppMethodBeat.i(250078);
    d.a locala = new d.a();
    locala.funcId = getType();
    locala.lBU = new af();
    locala.lBV = new ag();
    locala.uri = "/cgi-bin/micromsg-bin/unbindxmail";
    this.kwO = locala.bgN();
    AppMethodBeat.o(250078);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(250079);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(250079);
    return i;
  }
  
  public final int getType()
  {
    return 3889;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(250080);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(250080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.t
 * JD-Core Version:    0.7.0.1
 */