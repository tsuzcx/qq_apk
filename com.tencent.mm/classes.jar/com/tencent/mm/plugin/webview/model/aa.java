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
import com.tencent.mm.protocal.protobuf.bpf;
import com.tencent.mm.protocal.protobuf.bpg;

public final class aa
  extends m
  implements k
{
  private f eGj;
  public final b rr;
  
  public aa(String paramString)
  {
    AppMethodBeat.i(6637);
    b.a locala = new b.a();
    locala.fsX = new bpf();
    locala.fsY = new bpg();
    locala.uri = "/cgi-bin/mmbiz-bin/qrconnect_authorize";
    locala.funcId = 2543;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((bpf)this.rr.fsV.fta).xvQ = paramString;
    AppMethodBeat.o(6637);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6639);
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6639);
    return i;
  }
  
  public final int getType()
  {
    return 2543;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6638);
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(6638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aa
 * JD-Core Version:    0.7.0.1
 */