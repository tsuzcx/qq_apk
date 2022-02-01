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
import com.tencent.mm.protocal.protobuf.btm;
import com.tencent.mm.protocal.protobuf.btn;

public final class p
  extends q
  implements m
{
  private i heq;
  public final d rr;
  
  public p(String paramString)
  {
    AppMethodBeat.i(78885);
    d.a locala = new d.a();
    locala.iLN = new btm();
    locala.iLO = new btn();
    locala.uri = "/cgi-bin/mmbiz-bin/oauth_getrandomavatar";
    locala.funcId = 2785;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((btm)this.rr.iLK.iLR).dNI = paramString;
    AppMethodBeat.o(78885);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78887);
    this.heq = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78887);
    return i;
  }
  
  public final int getType()
  {
    return 2785;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78886);
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.p
 * JD-Core Version:    0.7.0.1
 */