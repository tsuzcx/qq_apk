package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.akr;
import com.tencent.mm.protocal.protobuf.aks;

public final class c
  extends q
  implements m
{
  private i callback;
  private final d iUB;
  
  public c(String paramString)
  {
    AppMethodBeat.i(30172);
    d.a locala = new d.a();
    akr localakr = new akr();
    aks localaks = new aks();
    locala.iLN = localakr;
    locala.iLO = localaks;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmcancel";
    locala.funcId = 973;
    locala.iLP = 0;
    locala.respCmdId = 0;
    localakr.LtA = paramString;
    this.iUB = locala.aXF();
    AppMethodBeat.o(30172);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(30173);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(30173);
    return i;
  }
  
  public final int getType()
  {
    return 973;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30174);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.c
 * JD-Core Version:    0.7.0.1
 */