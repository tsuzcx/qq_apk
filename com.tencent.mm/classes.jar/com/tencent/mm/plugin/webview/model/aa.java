package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.auv;
import com.tencent.mm.protocal.c.ava;
import com.tencent.mm.protocal.c.avb;
import com.tencent.mm.sdk.platformtools.y;

public final class aa
  extends m
  implements k
{
  String appId;
  String bMB;
  private f dIJ;
  final b dmK;
  
  public aa(String paramString1, String paramString2, auv paramauv)
  {
    this.appId = paramString1;
    this.bMB = paramString2;
    paramString2 = new b.a();
    paramString2.ecH = new ava();
    paramString2.ecI = new avb();
    paramString2.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_uploadcdninfo";
    paramString2.ecG = 1034;
    paramString2.ecJ = 0;
    paramString2.ecK = 0;
    this.dmK = paramString2.Kt();
    paramString2 = (ava)this.dmK.ecE.ecN;
    paramString2.bOL = paramString1;
    paramString2.tqH = paramauv;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dIJ = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneUploadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1034;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.aa
 * JD-Core Version:    0.7.0.1
 */