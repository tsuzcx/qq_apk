package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eji;
import com.tencent.mm.protocal.protobuf.ejj;

public final class z
  extends p
  implements m
{
  private h mAY;
  public final c rr;
  
  public z(String paramString)
  {
    AppMethodBeat.i(78921);
    c.a locala = new c.a();
    locala.otE = new eji();
    locala.otF = new ejj();
    locala.uri = "/cgi-bin/mmbiz-bin/qrconnect_authorize";
    locala.funcId = 2543;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((eji)c.b.b(this.rr.otB)).abaO = paramString;
    AppMethodBeat.o(78921);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(78923);
    this.mAY = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78923);
    return i;
  }
  
  public final int getType()
  {
    return 2543;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78922);
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.z
 * JD-Core Version:    0.7.0.1
 */