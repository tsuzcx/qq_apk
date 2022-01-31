package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdy;
import com.tencent.mm.protocal.c.bdz;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;

public final class a
  extends s
{
  public b dmK;
  private f dmL;
  
  public a(int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bdy();
    ((b.a)localObject).ecI = new bdz();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payubatchuserroll";
    ((b.a)localObject).ecG = 1519;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bdy)this.dmK.ecE.ecN;
    ((bdy)localObject).kUU = 10;
    ((bdy)localObject).sDT = paramInt;
    y.d("MicroMsg.NetScenePayUPayQueryUserRoll", "limit:10,offset:" + paramInt);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final int bXI()
  {
    return ((bdz)this.dmK.ecF.ecN).tzj;
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.w("MicroMsg.NetScenePayUPayQueryUserRoll", "errType = " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString);
    this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      y.d("MicroMsg.NetScenePayUPayQueryUserRoll", "rr" + ((bdz)((b)paramq).ecF.ecN).tzj);
    }
  }
  
  public final int getType()
  {
    return 1519;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.a.a
 * JD-Core Version:    0.7.0.1
 */