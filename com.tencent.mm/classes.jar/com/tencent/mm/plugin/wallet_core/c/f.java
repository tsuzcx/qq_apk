package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.protocal.c.ait;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends m
  implements k
{
  private b dmK;
  private com.tencent.mm.ah.f dmL;
  public boolean qqA = false;
  public String qqz = "";
  
  public f()
  {
    b.a locala = new b.a();
    locala.ecH = new ais();
    locala.ecI = new ait();
    locala.uri = "/cgi-bin/mmpay-bin/getpayuserduty";
    locala.ecG = 2541;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MircoMsg.NetSceneGetPayUserDuty", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = (ait)((b)paramq).ecF.ecN;
    this.qqz = paramq.qqz;
    this.qqA = paramq.qqA;
    y.i("MircoMsg.NetSceneGetPayUserDuty", "duty_info %s need_agree_duty %s", new Object[] { this.qqz, Boolean.valueOf(this.qqA) });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 2541;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.f
 * JD-Core Version:    0.7.0.1
 */