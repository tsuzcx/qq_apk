package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;

public final class t
  extends q
  implements m
{
  private i callback;
  private d hJu;
  
  public t()
  {
    AppMethodBeat.i(198609);
    d.a locala = new d.a();
    locala.funcId = getType();
    locala.iLN = new af();
    locala.iLO = new ag();
    locala.uri = "/cgi-bin/micromsg-bin/unbindxmail";
    this.hJu = locala.aXF();
    AppMethodBeat.o(198609);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(198610);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(198610);
    return i;
  }
  
  public final int getType()
  {
    return 3889;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198611);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(198611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.t
 * JD-Core Version:    0.7.0.1
 */