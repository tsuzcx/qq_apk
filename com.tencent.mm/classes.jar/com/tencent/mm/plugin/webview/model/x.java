package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bne;
import com.tencent.mm.protocal.c.bnf;

public final class x
  extends m
  implements k
{
  private f dIJ;
  public final b dmK;
  
  public x(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bne();
    ((b.a)localObject).ecI = new bnf();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize";
    ((b.a)localObject).ecG = 1388;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bne)this.dmK.ecE.ecN;
    ((bne)localObject).bOL = paramString1;
    ((bne)localObject).scope = paramString2;
    ((bne)localObject).state = paramString3;
    ((bne)localObject).tGi = paramString4;
    ((bne)localObject).tGj = paramString5;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dIJ = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1388;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.x
 * JD-Core Version:    0.7.0.1
 */