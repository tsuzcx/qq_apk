package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.protocal.protobuf.bgr;

public final class y
  extends m
  implements k
{
  private f eGj;
  public final b rr;
  public Object tag;
  public String uVL;
  
  public y(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(6631);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bgq();
    ((b.a)localObject).fsY = new bgr();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_authorize";
    ((b.a)localObject).funcId = 1254;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.uVL = paramString1;
    this.rr = ((b.a)localObject).ado();
    localObject = (bgq)this.rr.fsV.fta;
    ((bgq)localObject).xvQ = paramString1;
    ((bgq)localObject).wyW = paramString2;
    ((bgq)localObject).scene = paramInt;
    AppMethodBeat.o(6631);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6633);
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6633);
    return i;
  }
  
  public final int getType()
  {
    return 1254;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6632);
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(6632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.y
 * JD-Core Version:    0.7.0.1
 */