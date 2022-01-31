package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.protocal.protobuf.bx;

public final class g
  extends m
  implements k
{
  private f eGj;
  public final com.tencent.mm.ai.b rr;
  
  public g(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(6583);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bw();
    ((b.a)localObject).fsY = new bx();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
    ((b.a)localObject).funcId = 2500;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bw)this.rr.fsV.fta;
    ((bw)localObject).cwc = paramString1;
    ((bw)localObject).nickname = paramString2;
    ((bw)localObject).fileid = paramString3;
    ((bw)localObject).wor = 1;
    AppMethodBeat.o(6583);
  }
  
  public g(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6582);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bw();
    ((b.a)localObject).fsY = new bx();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
    ((b.a)localObject).funcId = 2500;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bw)this.rr.fsV.fta;
    ((bw)localObject).cwc = paramString1;
    ((bw)localObject).nickname = paramString2;
    ((bw)localObject).woq = new com.tencent.mm.bv.b(paramArrayOfByte);
    ((bw)localObject).wor = 0;
    AppMethodBeat.o(6582);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6585);
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6585);
    return i;
  }
  
  public final int getType()
  {
    return 2500;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6584);
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(6584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.g
 * JD-Core Version:    0.7.0.1
 */