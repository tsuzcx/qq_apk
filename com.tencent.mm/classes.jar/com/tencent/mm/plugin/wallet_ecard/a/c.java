package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.hq;
import com.tencent.mm.protocal.c.hr;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  public hr qKr;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new hq();
    ((b.a)localObject).ecI = new hr();
    ((b.a)localObject).ecG = 1986;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/bindecard";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (hq)this.dmK.ecE.ecN;
    ((hq)localObject).sAT = paramString1;
    ((hq)localObject).sAU = paramString2;
    ((hq)localObject).qyu = paramString3;
    ((hq)localObject).sAV = paramString4;
    ((hq)localObject).bUx = paramInt;
    y.i("MicroMsg.NetSceneBindECard", "cardType: %s, reqSerial: %s, openScene: %s, verifyCode: %s, bindToken: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), paramString3, paramString4 });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneBindECard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.qKr = ((hr)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneBindECard", "ret_code: %d, ret_msg: %s", new Object[] { Integer.valueOf(this.qKr.ino), this.qKr.inp });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1986;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.c
 * JD-Core Version:    0.7.0.1
 */