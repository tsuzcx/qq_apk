package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.auy;
import com.tencent.mm.protocal.c.auz;
import com.tencent.mm.sdk.platformtools.y;

public final class u
  extends m
  implements k
{
  private f dIJ;
  private final b dmK;
  public String iQS;
  public String iQT;
  public String rfx;
  public int rfy;
  public String sign;
  
  public u(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new auy();
    ((b.a)localObject).ecI = new auz();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_getuseropenid";
    ((b.a)localObject).ecG = 1177;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (auy)this.dmK.ecE.ecN;
    ((auy)localObject).app_id = paramString1;
    ((auy)localObject).taA = paramString2;
    ((auy)localObject).ipb = paramString3;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dIJ = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneMMBizGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (auz)this.dmK.ecF.ecN;
      this.rfx = paramq.rfx;
      this.sign = paramq.sign;
      this.iQT = paramq.iQT;
      this.iQS = paramq.iQS;
      this.rfy = paramq.rfy;
      y.d("MicroMsg.NetSceneMMBizGetUserOpenId", "openid:%s, sign:%s, head_img_url:%s, nick_name:%s, friend_relation:%d", new Object[] { this.rfx, this.sign, this.iQT, this.iQS, Integer.valueOf(this.rfy) });
    }
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1177;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.u
 * JD-Core Version:    0.7.0.1
 */