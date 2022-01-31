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
import com.tencent.mm.protocal.protobuf.bwz;
import com.tencent.mm.protocal.protobuf.bxa;

public final class ac
  extends m
  implements k
{
  private f eGj;
  public final b rr;
  
  public ac(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(6643);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bwz();
    ((b.a)localObject).fsY = new bxa();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize";
    ((b.a)localObject).funcId = 1388;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bwz)this.rr.fsV.fta;
    ((bwz)localObject).cwc = paramString1;
    ((bwz)localObject).scope = paramString2;
    ((bwz)localObject).state = paramString3;
    ((bwz)localObject).xKb = paramString4;
    ((bwz)localObject).xKc = paramString5;
    AppMethodBeat.o(6643);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6645);
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6645);
    return i;
  }
  
  public final int getType()
  {
    return 1388;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6644);
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(6644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ac
 * JD-Core Version:    0.7.0.1
 */