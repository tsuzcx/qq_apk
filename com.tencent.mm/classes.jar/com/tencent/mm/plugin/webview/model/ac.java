package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cxs;
import com.tencent.mm.protocal.protobuf.cxt;
import java.util.LinkedList;

public final class ac
  extends n
  implements k
{
  final LinkedList<String> DTb;
  private f gzH;
  private final com.tencent.mm.al.b rr;
  private long startTime;
  
  public ac(int paramInt, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList, String paramString4)
  {
    AppMethodBeat.i(207938);
    this.startTime = 0L;
    this.DTb = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cxs();
    ((b.a)localObject).hNN = new cxt();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
    ((b.a)localObject).funcId = 1346;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cxs)this.rr.hNK.hNQ;
    ((cxs)localObject).GXj = paramInt;
    ((cxs)localObject).duW = paramString1;
    ((cxs)localObject).GXk = paramLinkedList;
    ((cxs)localObject).state = paramString2;
    ((cxs)localObject).Hpd = paramString4;
    ((cxs)localObject).Hpc = paramString3;
    if (paramLinkedList != null) {
      this.DTb.addAll(paramLinkedList);
    }
    AppMethodBeat.o(207938);
  }
  
  public ac(String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList, int paramInt, String paramString4)
  {
    AppMethodBeat.i(207939);
    this.startTime = 0L;
    this.DTb = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cxs();
    ((b.a)localObject).hNN = new cxt();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
    ((b.a)localObject).funcId = 1346;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cxs)this.rr.hNK.hNQ;
    ((cxs)localObject).GXj = 1;
    ((cxs)localObject).duW = paramString1;
    ((cxs)localObject).GXk = paramLinkedList;
    ((cxs)localObject).state = paramString2;
    ((cxs)localObject).Hpc = paramString3;
    ((cxs)localObject).GbX = paramInt;
    ((cxs)localObject).Hpd = paramString4;
    this.startTime = System.currentTimeMillis();
    if (paramLinkedList != null) {
      this.DTb.addAll(paramLinkedList);
    }
    AppMethodBeat.o(207939);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78933);
    this.startTime = System.currentTimeMillis();
    this.gzH = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78933);
    return i;
  }
  
  public final cxt eQb()
  {
    return (cxt)this.rr.hNL.hNQ;
  }
  
  public final int getType()
  {
    return 1346;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78932);
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    com.tencent.mm.plugin.webview.j.b.EsZ.aF(4, (int)(System.currentTimeMillis() - this.startTime), paramInt3);
    AppMethodBeat.o(78932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ac
 * JD-Core Version:    0.7.0.1
 */