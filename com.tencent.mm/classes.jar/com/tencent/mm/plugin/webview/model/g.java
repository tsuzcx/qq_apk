package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bo;
import com.tencent.mm.protocal.c.bp;

public final class g
  extends m
  implements k
{
  private f dIJ;
  public final com.tencent.mm.ah.b dmK;
  
  public g(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bo();
    ((b.a)localObject).ecI = new bp();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
    ((b.a)localObject).ecG = 2500;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bo)this.dmK.ecE.ecN;
    ((bo)localObject).bOL = paramString1;
    ((bo)localObject).nickname = paramString2;
    ((bo)localObject).fileid = paramString3;
    ((bo)localObject).svk = 1;
  }
  
  public g(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bo();
    ((b.a)localObject).ecI = new bp();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
    ((b.a)localObject).ecG = 2500;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bo)this.dmK.ecE.ecN;
    ((bo)localObject).bOL = paramString1;
    ((bo)localObject).nickname = paramString2;
    ((bo)localObject).svj = new com.tencent.mm.bv.b(paramArrayOfByte);
    ((bo)localObject).svk = 0;
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
    return 2500;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.g
 * JD-Core Version:    0.7.0.1
 */