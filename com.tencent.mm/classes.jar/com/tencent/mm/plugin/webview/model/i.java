package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.auw;
import com.tencent.mm.protocal.c.aux;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  extends m
  implements k
{
  String appId;
  private f dIJ;
  final b dmK;
  String fNa;
  
  public i(String paramString1, String paramString2)
  {
    this.appId = paramString1;
    this.fNa = paramString2;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new auw();
    ((b.a)localObject).ecI = new aux();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_downloadcdninfo";
    ((b.a)localObject).ecG = 1035;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (auw)this.dmK.ecE.ecN;
    ((auw)localObject).bOL = paramString1;
    ((auw)localObject).tqG = paramString2;
    y.i("MicroMsg.NetSceneDownloadCdnInfo", "download cdn info, appid : %s, mediaId : %s", new Object[] { paramString1, paramString2 });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dIJ = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneDownloadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1035;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.i
 * JD-Core Version:    0.7.0.1
 */