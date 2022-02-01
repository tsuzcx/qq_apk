package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dgs;
import com.tencent.mm.protocal.protobuf.dgt;

public final class z
  extends q
  implements m
{
  private i heq;
  public final d rr;
  
  public z(String paramString)
  {
    AppMethodBeat.i(78921);
    d.a locala = new d.a();
    locala.iLN = new dgs();
    locala.iLO = new dgt();
    locala.uri = "/cgi-bin/mmbiz-bin/qrconnect_authorize";
    locala.funcId = 2543;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((dgs)this.rr.iLK.iLR).Mzp = paramString;
    AppMethodBeat.o(78921);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78923);
    this.heq = parami;
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
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.z
 * JD-Core Version:    0.7.0.1
 */