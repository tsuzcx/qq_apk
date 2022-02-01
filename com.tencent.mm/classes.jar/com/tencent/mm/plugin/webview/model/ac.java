package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.cyn;
import java.util.LinkedList;

public final class ac
  extends n
  implements k
{
  final LinkedList<String> Elb;
  private f gCo;
  private final com.tencent.mm.ak.b rr;
  private long startTime;
  
  public ac(int paramInt, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList, String paramString4)
  {
    AppMethodBeat.i(198118);
    this.startTime = 0L;
    this.Elb = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cym();
    ((b.a)localObject).hQG = new cyn();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
    ((b.a)localObject).funcId = 1346;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cym)this.rr.hQD.hQJ;
    ((cym)localObject).HqJ = paramInt;
    ((cym)localObject).dwb = paramString1;
    ((cym)localObject).HqK = paramLinkedList;
    ((cym)localObject).state = paramString2;
    ((cym)localObject).HIF = paramString4;
    ((cym)localObject).HIE = paramString3;
    if (paramLinkedList != null) {
      this.Elb.addAll(paramLinkedList);
    }
    AppMethodBeat.o(198118);
  }
  
  public ac(String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList, int paramInt, String paramString4)
  {
    AppMethodBeat.i(198119);
    this.startTime = 0L;
    this.Elb = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cym();
    ((b.a)localObject).hQG = new cyn();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
    ((b.a)localObject).funcId = 1346;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cym)this.rr.hQD.hQJ;
    ((cym)localObject).HqJ = 1;
    ((cym)localObject).dwb = paramString1;
    ((cym)localObject).HqK = paramLinkedList;
    ((cym)localObject).state = paramString2;
    ((cym)localObject).HIE = paramString3;
    ((cym)localObject).GuE = paramInt;
    ((cym)localObject).HIF = paramString4;
    this.startTime = System.currentTimeMillis();
    if (paramLinkedList != null) {
      this.Elb.addAll(paramLinkedList);
    }
    AppMethodBeat.o(198119);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78933);
    this.startTime = System.currentTimeMillis();
    this.gCo = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78933);
    return i;
  }
  
  public final cyn eTN()
  {
    return (cyn)this.rr.hQE.hQJ;
  }
  
  public final int getType()
  {
    return 1346;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78932);
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    com.tencent.mm.plugin.webview.j.b.ELt.aG(4, (int)(System.currentTimeMillis() - this.startTime), paramInt3);
    AppMethodBeat.o(78932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ac
 * JD-Core Version:    0.7.0.1
 */