package com.tencent.mm.plugin.wallet_core.c.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdg;
import com.tencent.mm.protocal.c.bdh;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bdg();
    ((b.a)localObject).ecI = new bdh();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payibgcheckjsapisign";
    ((b.a)localObject).ecG = 1767;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bdg)this.dmK.ecE.ecN;
    ((bdg)localObject).euK = paramString1;
    ((bdg)localObject).sNg = paramString4;
    ((bdg)localObject).sNf = paramString2;
    ((bdg)localObject).sNh = paramString5;
    ((bdg)localObject).sNi = paramString6;
    ((bdg)localObject).sBi = paramString3;
    ((bdg)localObject).sMg = paramString7;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneIbgCheckJsapi", "check jsapi: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramArrayOfByte = (bdh)((b)paramq).ecF.ecN;
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramInt2 == 0)
      {
        paramInt1 = paramArrayOfByte.jxl;
        paramq = paramArrayOfByte.jxm;
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt1, paramq, this);
  }
  
  public final int getType()
  {
    return 1767;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a.a
 * JD-Core Version:    0.7.0.1
 */