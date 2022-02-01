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
import com.tencent.mm.plugin.qqmail.d.at;
import com.tencent.mm.plugin.qqmail.d.au;

public final class c
  extends q
  implements m
{
  public String Hls;
  private i callback;
  public d lKU;
  
  public c(String paramString)
  {
    AppMethodBeat.i(250628);
    d.a locala = new d.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/xmmailbroker/mb_readmail";
    at localat = new at();
    localat.Hnf = paramString;
    h.aHE();
    localat.uin = b.getUin();
    locala.lBU = localat;
    locala.lBV = new au();
    this.lKU = locala.bgN();
    this.Hls = paramString;
    AppMethodBeat.o(250628);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(250630);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(250630);
    return i;
  }
  
  public final int getType()
  {
    return 11312;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(250632);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(250632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.e.c
 * JD-Core Version:    0.7.0.1
 */