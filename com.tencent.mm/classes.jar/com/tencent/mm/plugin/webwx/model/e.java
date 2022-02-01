package com.tencent.mm.plugin.webwx.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.apj;
import com.tencent.mm.protocal.protobuf.apk;

public final class e
  extends p
  implements m
{
  public boolean JTq;
  private h callback;
  public final c oDw;
  
  public e(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(265378);
    this.JTq = paramBoolean1;
    c.a locala = new c.a();
    apj localapj = new apj();
    apk localapk = new apk();
    locala.otE = localapj;
    locala.otF = localapk;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
    locala.funcId = 972;
    locala.otG = 0;
    locala.respCmdId = 0;
    localapj.Zwg = paramString1;
    localapj.Zws = paramString2;
    localapj.Zwu = paramBoolean1;
    localapj.Zwx = paramBoolean2;
    this.oDw = locala.bEF();
    AppMethodBeat.o(265378);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(30179);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(30179);
    return i;
  }
  
  public final int getType()
  {
    return 972;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30180);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(30180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.model.e
 * JD-Core Version:    0.7.0.1
 */