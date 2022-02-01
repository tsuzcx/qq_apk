package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnc;
import java.util.LinkedList;

public final class ac
  extends n
  implements k
{
  final LinkedList<String> AXq;
  private g gbr;
  private final com.tencent.mm.al.b rr;
  private long startTime;
  
  public ac(int paramInt, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList, String paramString4)
  {
    AppMethodBeat.i(187892);
    this.startTime = 0L;
    this.AXq = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cnb();
    ((b.a)localObject).gUV = new cnc();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
    ((b.a)localObject).funcId = 1346;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cnb)this.rr.gUS.gUX;
    ((cnb)localObject).DRi = paramInt;
    ((cnb)localObject).dlB = paramString1;
    ((cnb)localObject).DRj = paramLinkedList;
    ((cnb)localObject).state = paramString2;
    ((cnb)localObject).EhL = paramString4;
    ((cnb)localObject).EhK = paramString3;
    if (paramLinkedList != null) {
      this.AXq.addAll(paramLinkedList);
    }
    AppMethodBeat.o(187892);
  }
  
  public ac(String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList, int paramInt, String paramString4)
  {
    AppMethodBeat.i(187893);
    this.startTime = 0L;
    this.AXq = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cnb();
    ((b.a)localObject).gUV = new cnc();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
    ((b.a)localObject).funcId = 1346;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cnb)this.rr.gUS.gUX;
    ((cnb)localObject).DRi = 1;
    ((cnb)localObject).dlB = paramString1;
    ((cnb)localObject).DRj = paramLinkedList;
    ((cnb)localObject).state = paramString2;
    ((cnb)localObject).EhK = paramString3;
    ((cnb)localObject).Dbx = paramInt;
    ((cnb)localObject).EhL = paramString4;
    this.startTime = System.currentTimeMillis();
    if (paramLinkedList != null) {
      this.AXq.addAll(paramLinkedList);
    }
    AppMethodBeat.o(187893);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78933);
    this.startTime = System.currentTimeMillis();
    this.gbr = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78933);
    return i;
  }
  
  public final cnc elN()
  {
    return (cnc)this.rr.gUT.gUX;
  }
  
  public final int getType()
  {
    return 1346;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78932);
    this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    com.tencent.mm.plugin.webview.j.b.BwR.aC(4, (int)(System.currentTimeMillis() - this.startTime), paramInt3);
    AppMethodBeat.o(78932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ac
 * JD-Core Version:    0.7.0.1
 */