package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.webview.f.a;
import com.tencent.mm.protocal.protobuf.bwx;
import com.tencent.mm.protocal.protobuf.bwy;
import java.util.LinkedList;

public final class ad
  extends m
  implements k
{
  private f eGj;
  private final b rr;
  private long startTime;
  
  public ad(int paramInt, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(6646);
    this.startTime = 0L;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bwx();
    ((b.a)localObject).fsY = new bwy();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
    ((b.a)localObject).funcId = 1346;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bwx)this.rr.fsV.fta;
    ((bwx)localObject).xvR = paramInt;
    ((bwx)localObject).cwc = paramString1;
    ((bwx)localObject).xvS = paramLinkedList;
    ((bwx)localObject).state = paramString2;
    ((bwx)localObject).xKa = paramString3;
    AppMethodBeat.o(6646);
  }
  
  public ad(String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(6647);
    this.startTime = 0L;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bwx();
    ((b.a)localObject).fsY = new bwy();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
    ((b.a)localObject).funcId = 1346;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bwx)this.rr.fsV.fta;
    ((bwx)localObject).xvR = 1;
    ((bwx)localObject).cwc = paramString1;
    ((bwx)localObject).xvS = paramLinkedList;
    ((bwx)localObject).state = paramString2;
    ((bwx)localObject).xKa = paramString3;
    ((bwx)localObject).wOS = paramInt;
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(6647);
  }
  
  public final bwy dbQ()
  {
    return (bwy)this.rr.fsW.fta;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6649);
    this.startTime = System.currentTimeMillis();
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6649);
    return i;
  }
  
  public final int getType()
  {
    return 1346;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6648);
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    a.vtM.ap(4, (int)(System.currentTimeMillis() - this.startTime), paramInt3);
    AppMethodBeat.o(6648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ad
 * JD-Core Version:    0.7.0.1
 */