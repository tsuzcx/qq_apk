package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.csi;
import com.tencent.mm.protocal.protobuf.csj;
import java.util.LinkedList;

public final class ac
  extends n
  implements k
{
  final LinkedList<String> CpD;
  private g gfX;
  private final com.tencent.mm.ak.b rr;
  private long startTime;
  
  public ac(int paramInt, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList, String paramString4)
  {
    AppMethodBeat.i(188319);
    this.startTime = 0L;
    this.CpD = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new csi();
    ((b.a)localObject).hvu = new csj();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
    ((b.a)localObject).funcId = 1346;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (csi)this.rr.hvr.hvw;
    ((csi)localObject).FnA = paramInt;
    ((csi)localObject).djj = paramString1;
    ((csi)localObject).FnB = paramLinkedList;
    ((csi)localObject).state = paramString2;
    ((csi)localObject).FEJ = paramString4;
    ((csi)localObject).FEI = paramString3;
    if (paramLinkedList != null) {
      this.CpD.addAll(paramLinkedList);
    }
    AppMethodBeat.o(188319);
  }
  
  public ac(String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList, int paramInt, String paramString4)
  {
    AppMethodBeat.i(188320);
    this.startTime = 0L;
    this.CpD = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new csi();
    ((b.a)localObject).hvu = new csj();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
    ((b.a)localObject).funcId = 1346;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (csi)this.rr.hvr.hvw;
    ((csi)localObject).FnA = 1;
    ((csi)localObject).djj = paramString1;
    ((csi)localObject).FnB = paramLinkedList;
    ((csi)localObject).state = paramString2;
    ((csi)localObject).FEI = paramString3;
    ((csi)localObject).EuD = paramInt;
    ((csi)localObject).FEJ = paramString4;
    this.startTime = System.currentTimeMillis();
    if (paramLinkedList != null) {
      this.CpD.addAll(paramLinkedList);
    }
    AppMethodBeat.o(188320);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78933);
    this.startTime = System.currentTimeMillis();
    this.gfX = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78933);
    return i;
  }
  
  public final csj eBj()
  {
    return (csj)this.rr.hvs.hvw;
  }
  
  public final int getType()
  {
    return 1346;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78932);
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    com.tencent.mm.plugin.webview.j.b.COZ.aD(4, (int)(System.currentTimeMillis() - this.startTime), paramInt3);
    AppMethodBeat.o(78932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ac
 * JD-Core Version:    0.7.0.1
 */