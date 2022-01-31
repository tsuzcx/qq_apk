package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ns;
import com.tencent.mm.protocal.c.nt;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n;

public final class e
  extends n
{
  private final String TAG = "MicroMsg.NetSceneBeforeTransfer";
  public nt nxW;
  
  public e(String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ns();
    ((b.a)localObject).ecI = new nt();
    ((b.a)localObject).ecG = 2783;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/beforetransfer";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ns)this.dmK.ecE.ecN;
    ((ns)localObject).swg = paramString;
    if (!com.tencent.mm.pluginsdk.wallet.f.cow()) {
      ((ns)localObject).sLl = com.tencent.mm.pluginsdk.wallet.f.cox();
    }
    y.d("MicroMsg.NetSceneBeforeTransfer", "rcver name: %s", new Object[] { paramString });
  }
  
  protected final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneBeforeTransfer", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nxW = ((nt)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneBeforeTransfer", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.nxW.iHq), this.nxW.iHr });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (nt)((b)paramq).ecF.ecN;
    this.wAx = paramq.iHq;
    this.wAy = paramq.iHr;
  }
  
  public final int getType()
  {
    return 2783;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.e
 * JD-Core Version:    0.7.0.1
 */