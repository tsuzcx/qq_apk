package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajm;
import com.tencent.mm.protocal.c.ajn;

public final class m
  extends com.tencent.mm.ah.m
  implements k
{
  private f dIJ;
  public final b dmK;
  
  public m(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new ajm();
    locala.ecI = new ajn();
    locala.uri = "/cgi-bin/mmbiz-bin/oauth_getrandomavatar";
    locala.ecG = 2785;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((ajm)this.dmK.ecE.ecN).bOL = paramString;
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
    return 2785;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.m
 * JD-Core Version:    0.7.0.1
 */