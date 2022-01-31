package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.azn;
import com.tencent.mm.protocal.c.azo;

public final class v
  extends m
  implements k
{
  private f dIJ;
  public final b dmK;
  public String rfz;
  public Object tag;
  
  public v(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new azn();
    ((b.a)localObject).ecI = new azo();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/oauth_authorize";
    ((b.a)localObject).ecG = 1254;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.rfz = paramString1;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (azn)this.dmK.ecE.ecN;
    ((azn)localObject).tvF = paramString1;
    ((azn)localObject).sDq = paramString2;
    ((azn)localObject).scene = paramInt;
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
    return 1254;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.v
 * JD-Core Version:    0.7.0.1
 */