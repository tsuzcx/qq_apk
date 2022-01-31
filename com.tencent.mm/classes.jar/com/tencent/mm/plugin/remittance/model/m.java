package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mr;
import com.tencent.mm.protocal.c.ms;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n;
import java.net.URLDecoder;

public final class m
  extends n
{
  private final String TAG = "MicroMsg.NetSceneF2fDynamicCode";
  public ms nyp;
  
  public m(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new mr();
    ((b.a)localObject).ecI = new ms();
    ((b.a)localObject).ecG = 2736;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/f2fdynamiccode";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (mr)this.dmK.ecE.ecN;
    ((mr)localObject).amount = paramInt;
    ((mr)localObject).ipb = paramString1;
    ((mr)localObject).nzl = paramString2;
    ((mr)localObject).sKn = URLDecoder.decode(paramString3);
    ((mr)localObject).nyV = paramString4;
    ((mr)localObject).nyW = paramString5;
    ((mr)localObject).nzo = paramString6;
    ((mr)localObject).nickname = paramString7;
    ((mr)localObject).nyK = paramString8;
    y.i("MicroMsg.NetSceneF2fDynamicCode", "amount: %s, username: %s, transfer_code_id: %s", new Object[] { Integer.valueOf(paramInt), paramString1, URLDecoder.decode(paramString3) });
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneF2fDynamicCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nyp = ((ms)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneF2fDynamicCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.nyp.iHq), this.nyp.iHr });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (ms)((b)paramq).ecF.ecN;
    this.wAx = paramq.iHq;
    this.wAy = paramq.iHr;
  }
  
  public final int getType()
  {
    return 2736;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.m
 * JD-Core Version:    0.7.0.1
 */