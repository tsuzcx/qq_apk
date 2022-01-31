package com.tencent.mm.plugin.order.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.vw;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;

public final class f
  extends s
{
  private b dmK;
  private com.tencent.mm.ah.f dmL;
  
  public f(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new vw();
    ((b.a)localObject).ecI = new vx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/evaluateorder";
    ((b.a)localObject).ecG = 583;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (vw)this.dmK.ecE.ecN;
    ((vw)localObject).sSZ = paramString1;
    ((vw)localObject).euK = paramString2;
    ((vw)localObject).nFj = paramInt;
    ((vw)localObject).sHl = i.bVj();
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.d("MicroMsg.NetSceneEvaluateOrder", "errType:" + paramInt1 + ",errCode:" + paramInt2 + ",errMsg" + paramString);
    this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
  }
  
  public final int getType()
  {
    return 583;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.f
 * JD-Core Version:    0.7.0.1
 */