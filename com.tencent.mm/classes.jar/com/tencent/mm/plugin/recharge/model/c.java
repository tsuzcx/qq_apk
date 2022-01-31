package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zf;
import com.tencent.mm.protocal.c.zg;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends m
  implements k
{
  public String bSe;
  public b dmK;
  private f dmL;
  public String jfG;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.bSe = paramString2;
    this.jfG = paramString3;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new zf();
    ((b.a)localObject).ecI = new zg();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/flowdatarechargepreinquery";
    ((b.a)localObject).ecG = 1555;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (zf)this.dmK.ecE.ecN;
    ((zf)localObject).sYz = paramString1;
    ((zf)localObject).sBm = paramString2;
    ((zf)localObject).mQq = paramString3;
    ((zf)localObject).sYA = paramString4;
    ((zf)localObject).sYB = paramString5;
    ((zf)localObject).sRr = com.tencent.mm.plugin.wallet_core.model.mall.c.bWg().Qw(paramString1);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneFlowDataRechargePreinQuery", "errCode " + paramInt3 + ", errMsg " + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1555;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.c
 * JD-Core Version:    0.7.0.1
 */