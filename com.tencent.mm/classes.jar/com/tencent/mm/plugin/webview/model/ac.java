package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.webview.k.b;
import com.tencent.mm.protocal.protobuf.drh;
import com.tencent.mm.protocal.protobuf.dri;
import java.util.LinkedList;

public final class ac
  extends q
  implements m
{
  final LinkedList<String> IXZ;
  private i heq;
  private final d rr;
  private long startTime;
  
  public ac(int paramInt, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList, String paramString4)
  {
    AppMethodBeat.i(210978);
    this.startTime = 0L;
    this.IXZ = new LinkedList();
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new drh();
    ((d.a)localObject).iLO = new dri();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
    ((d.a)localObject).funcId = 1346;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (drh)this.rr.iLK.iLR;
    ((drh)localObject).Mzq = paramInt;
    ((drh)localObject).dNI = paramString1;
    ((drh)localObject).Mzr = paramLinkedList;
    ((drh)localObject).state = paramString2;
    ((drh)localObject).MTR = paramString4;
    ((drh)localObject).MTQ = paramString3;
    if (paramLinkedList != null) {
      this.IXZ.addAll(paramLinkedList);
    }
    AppMethodBeat.o(210978);
  }
  
  public ac(String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList, int paramInt, String paramString4)
  {
    AppMethodBeat.i(210979);
    this.startTime = 0L;
    this.IXZ = new LinkedList();
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new drh();
    ((d.a)localObject).iLO = new dri();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
    ((d.a)localObject).funcId = 1346;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (drh)this.rr.iLK.iLR;
    ((drh)localObject).Mzq = 1;
    ((drh)localObject).dNI = paramString1;
    ((drh)localObject).Mzr = paramLinkedList;
    ((drh)localObject).state = paramString2;
    ((drh)localObject).MTQ = paramString3;
    ((drh)localObject).Lqj = paramInt;
    ((drh)localObject).MTR = paramString4;
    this.startTime = System.currentTimeMillis();
    if (paramLinkedList != null) {
      this.IXZ.addAll(paramLinkedList);
    }
    AppMethodBeat.o(210979);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78933);
    this.startTime = System.currentTimeMillis();
    this.heq = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78933);
    return i;
  }
  
  public final dri gcA()
  {
    return (dri)this.rr.iLL.iLR;
  }
  
  public final int getType()
  {
    return 1346;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78932);
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    b.JBk.aO(4, (int)(System.currentTimeMillis() - this.startTime), paramInt3);
    AppMethodBeat.o(78932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ac
 * JD-Core Version:    0.7.0.1
 */