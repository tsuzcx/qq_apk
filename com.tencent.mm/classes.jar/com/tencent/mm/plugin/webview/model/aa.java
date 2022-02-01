package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.webview.k.b;
import com.tencent.mm.protocal.protobuf.dgq;
import com.tencent.mm.protocal.protobuf.dgr;
import java.util.LinkedList;

public final class aa
  extends q
  implements m
{
  private i heq;
  private final d rr;
  private long startTime;
  
  public aa(int paramInt1, String paramString, LinkedList<String> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(78924);
    this.startTime = 0L;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dgq();
    ((d.a)localObject).iLO = new dgr();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/qrconnect_authorize_confirm";
    ((d.a)localObject).funcId = 1137;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dgq)this.rr.iLK.iLR;
    ((dgq)localObject).Mzq = paramInt1;
    ((dgq)localObject).Mzp = paramString;
    ((dgq)localObject).Mzr = paramLinkedList;
    ((dgq)localObject).Lqj = paramInt2;
    AppMethodBeat.o(78924);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78926);
    this.startTime = System.currentTimeMillis();
    this.heq = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78926);
    return i;
  }
  
  public final int getType()
  {
    return 1137;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78925);
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    b.JBk.aO(4, (int)(System.currentTimeMillis() - this.startTime), paramInt3);
    AppMethodBeat.o(78925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aa
 * JD-Core Version:    0.7.0.1
 */