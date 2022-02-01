package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.protocal.protobuf.cny;
import java.util.LinkedList;

public final class aa
  extends n
  implements k
{
  private f gzH;
  private final com.tencent.mm.al.b rr;
  private long startTime;
  
  public aa(int paramInt1, String paramString, LinkedList<String> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(78924);
    this.startTime = 0L;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cnx();
    ((b.a)localObject).hNN = new cny();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/qrconnect_authorize_confirm";
    ((b.a)localObject).funcId = 1137;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cnx)this.rr.hNK.hNQ;
    ((cnx)localObject).GXj = paramInt1;
    ((cnx)localObject).GXi = paramString;
    ((cnx)localObject).GXk = paramLinkedList;
    ((cnx)localObject).GbX = paramInt2;
    AppMethodBeat.o(78924);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78926);
    this.startTime = System.currentTimeMillis();
    this.gzH = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78926);
    return i;
  }
  
  public final int getType()
  {
    return 1137;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78925);
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    com.tencent.mm.plugin.webview.j.b.EsZ.aF(4, (int)(System.currentTimeMillis() - this.startTime), paramInt3);
    AppMethodBeat.o(78925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aa
 * JD-Core Version:    0.7.0.1
 */