package com.tencent.mm.plugin.profile.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.amx;
import com.tencent.mm.protocal.c.amy;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class a
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  public String mVk;
  
  public a(String paramString1, String paramString2)
  {
    this.mVk = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new amx();
    ((b.a)localObject).ecI = new amy();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getwburl";
    ((b.a)localObject).ecG = 205;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (amx)this.dmK.ecE.ecN;
    ((amx)localObject).hPY = paramString2;
    au.Hx();
    paramString2 = bk.pm((String)c.Dz().get(46, null));
    ((amx)localObject).syq = new bmk().bs(bk.ZM(paramString2));
    au.Hx();
    String str = bk.pm((String)c.Dz().get(72, null));
    ((amx)localObject).sZN = new bmk().bs(bk.ZM(str));
    y.d("MicroMsg.NetSceneGetWeiboURL", "dkwt get weibo url with id=" + paramString1 + ", a2=" + paramString2 + " , newa2:" + str);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetWeiboURL", "dkwt onGYNetEnd:[%d,%d] get weibo url result:[%s] ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), getURL() });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 205;
  }
  
  public final String getURL()
  {
    return ((amy)this.dmK.ecF.ecN).URL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a
 * JD-Core Version:    0.7.0.1
 */