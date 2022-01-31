package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.sk;
import com.tencent.mm.protocal.c.sl;

public final class h
  extends m
  implements k
{
  private f dIJ;
  private final b dmK;
  
  public h(int paramInt)
  {
    b.a locala = new b.a();
    locala.ecH = new sk();
    locala.ecI = new sl();
    locala.uri = "/cgi-bin/mmbiz-bin/oauth_delavatar";
    locala.ecG = 2700;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((sk)this.dmK.ecE.ecN).sQr = paramInt;
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
    return 2700;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.h
 * JD-Core Version:    0.7.0.1
 */