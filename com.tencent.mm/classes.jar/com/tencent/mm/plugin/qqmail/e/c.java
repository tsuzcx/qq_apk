package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.d.at;
import com.tencent.mm.plugin.qqmail.d.au;

public final class c
  extends q
  implements m
{
  public String BqZ;
  private i callback;
  public d iUB;
  
  public c(String paramString)
  {
    AppMethodBeat.i(198656);
    d.a locala = new d.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_readmail";
    at localat = new at();
    localat.BsL = paramString;
    com.tencent.mm.kernel.g.aAf();
    localat.uin = a.getUin();
    locala.iLN = localat;
    locala.iLO = new au();
    this.iUB = locala.aXF();
    this.BqZ = paramString;
    AppMethodBeat.o(198656);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(198657);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(198657);
    return i;
  }
  
  public final int getType()
  {
    return 11312;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198658);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(198658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.c
 * JD-Core Version:    0.7.0.1
 */