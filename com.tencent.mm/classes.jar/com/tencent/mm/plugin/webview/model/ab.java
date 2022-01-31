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
import com.tencent.mm.plugin.webview.f.a;
import com.tencent.mm.protocal.protobuf.bpd;
import com.tencent.mm.protocal.protobuf.bpe;
import java.util.LinkedList;

public final class ab
  extends m
  implements k
{
  private f eGj;
  private final b rr;
  private long startTime;
  
  public ab(int paramInt1, String paramString, LinkedList<String> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(6640);
    this.startTime = 0L;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bpd();
    ((b.a)localObject).fsY = new bpe();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/qrconnect_authorize_confirm";
    ((b.a)localObject).funcId = 1137;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bpd)this.rr.fsV.fta;
    ((bpd)localObject).xvR = paramInt1;
    ((bpd)localObject).xvQ = paramString;
    ((bpd)localObject).xvS = paramLinkedList;
    ((bpd)localObject).wOS = paramInt2;
    AppMethodBeat.o(6640);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6642);
    this.startTime = System.currentTimeMillis();
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6642);
    return i;
  }
  
  public final int getType()
  {
    return 1137;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6641);
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    a.vtM.ap(4, (int)(System.currentTimeMillis() - this.startTime), paramInt3);
    AppMethodBeat.o(6641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ab
 * JD-Core Version:    0.7.0.1
 */