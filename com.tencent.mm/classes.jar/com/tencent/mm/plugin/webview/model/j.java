package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abk;
import com.tencent.mm.protocal.c.abl;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends m
  implements k
{
  private f dmL;
  public final b jvQ;
  
  public j(String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new abk();
    ((b.a)localObject).ecI = new abl();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/getappticket";
    ((b.a)localObject).ecG = 1097;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.jvQ = ((b.a)localObject).Kt();
    localObject = (abk)this.jvQ.ecE.ecN;
    ((abk)localObject).bOL = paramString1;
    ((abk)localObject).signature = paramString2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.jvQ, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetAppTicket", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1097;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.j
 * JD-Core Version:    0.7.0.1
 */