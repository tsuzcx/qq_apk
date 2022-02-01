package com.tencent.mm.plugin.webwx.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.apd;
import com.tencent.mm.protocal.protobuf.ape;

public final class c
  extends p
  implements m
{
  private h callback;
  private final com.tencent.mm.am.c oDw;
  
  public c(String paramString)
  {
    AppMethodBeat.i(30172);
    c.a locala = new c.a();
    apd localapd = new apd();
    ape localape = new ape();
    locala.otE = localapd;
    locala.otF = localape;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmcancel";
    locala.funcId = 973;
    locala.otG = 0;
    locala.respCmdId = 0;
    localapd.Zwg = paramString;
    this.oDw = locala.bEF();
    AppMethodBeat.o(30172);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(30173);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.model.c
 * JD-Core Version:    0.7.0.1
 */