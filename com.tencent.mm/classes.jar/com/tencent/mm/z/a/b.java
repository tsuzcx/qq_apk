package com.tencent.mm.z.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.protocal.protobuf.axr;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class b
  extends m
  implements k
{
  private f eGj;
  private b.a<b> eGl;
  private final com.tencent.mm.ai.b rr;
  
  private b(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(77757);
    ab.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "NetSceneJSLogin doScene appId [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new com.tencent.mm.ai.b.a();
    ((com.tencent.mm.ai.b.a)localObject).fsX = new axq();
    ((com.tencent.mm.ai.b.a)localObject).fsY = new axr();
    ((com.tencent.mm.ai.b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
    ((com.tencent.mm.ai.b.a)localObject).funcId = 1158;
    ((com.tencent.mm.ai.b.a)localObject).reqCmdId = 0;
    ((com.tencent.mm.ai.b.a)localObject).respCmdId = 0;
    this.rr = ((com.tencent.mm.ai.b.a)localObject).ado();
    localObject = (axq)this.rr.fsV.fta;
    if (paramInt3 > 0)
    {
      ((axq)localObject).xmR = new dam();
      ((axq)localObject).xmR.scene = paramInt3;
    }
    ((axq)localObject).fKw = paramString;
    ((axq)localObject).xmO = paramLinkedList;
    ((axq)localObject).xmQ = paramInt1;
    ((axq)localObject).xmP = paramInt2;
    AppMethodBeat.o(77757);
  }
  
  public b(String paramString, LinkedList<String> paramLinkedList, int paramInt1, int paramInt2, int paramInt3, b.a<b> parama)
  {
    this(paramString, paramLinkedList, paramInt1, paramInt2, paramInt3);
    this.eGl = parama;
  }
  
  public b(String paramString, LinkedList<String> paramLinkedList, int paramInt, b.a<b> parama)
  {
    this(paramString, paramLinkedList, 0, paramInt, -1, parama);
  }
  
  public final axq Qq()
  {
    if (this.rr == null) {
      return null;
    }
    return (axq)this.rr.fsV.fta;
  }
  
  public final axr Qr()
  {
    return (axr)this.rr.fsW.fta;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(77759);
    ab.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "doScene");
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(77759);
    return i;
  }
  
  public final int getType()
  {
    return 1158;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77758);
    ab.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.eGj != null) {
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.eGl != null) {
      this.eGl.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(77758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.z.a.b
 * JD-Core Version:    0.7.0.1
 */