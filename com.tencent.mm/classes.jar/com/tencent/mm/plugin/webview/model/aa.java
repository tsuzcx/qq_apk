package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.webview.k.b;
import com.tencent.mm.protocal.protobuf.dql;
import com.tencent.mm.protocal.protobuf.dqm;
import java.util.LinkedList;

public final class aa
  extends q
  implements m
{
  private i jQg;
  private final d rr;
  private long startTime;
  
  public aa(int paramInt1, String paramString, LinkedList<String> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(78924);
    this.startTime = 0L;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dql();
    ((d.a)localObject).lBV = new dqm();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/qrconnect_authorize_confirm";
    ((d.a)localObject).funcId = 1137;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dql)d.b.b(this.rr.lBR);
    ((dql)localObject).TKW = paramInt1;
    ((dql)localObject).TKV = paramString;
    ((dql)localObject).TKX = paramLinkedList;
    ((dql)localObject).SrG = paramInt2;
    AppMethodBeat.o(78924);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78926);
    this.startTime = System.currentTimeMillis();
    this.jQg = parami;
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
    this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    b.QzJ.aS(4, (int)(System.currentTimeMillis() - this.startTime), paramInt3);
    AppMethodBeat.o(78925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aa
 * JD-Core Version:    0.7.0.1
 */