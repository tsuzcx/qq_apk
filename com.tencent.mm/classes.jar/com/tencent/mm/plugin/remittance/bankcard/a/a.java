package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends b
{
  private final String TAG = "MicroMsg.NetSceneBankRemitAppointBank";
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  public ei nuQ;
  public String nuR;
  
  public a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new eh();
    ((b.a)localObject).ecI = new ei();
    ((b.a)localObject).ecG = 1348;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/appointbank_tsbc";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (eh)this.dmK.ecE.ecN;
    ((eh)localObject).nvy = paramString1;
    ((eh)localObject).sxT = paramString2;
    ((eh)localObject).mOb = paramString3;
    this.nuR = paramString1;
    y.i("MicroMsg.NetSceneBankRemitAppointBank", "seqno: %s, timing_id: %s, bankType: %s", new Object[] { paramString1, paramString2, paramString3 });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneBankRemitAppointBank", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nuQ = ((ei)((com.tencent.mm.ah.b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneBankRemitAppointBank", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.nuQ.iHq), this.nuQ.iHr });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
  }
  
  protected final void f(q paramq)
  {
    paramq = (ei)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    this.wAx = paramq.iHq;
    this.wAy = paramq.iHr;
  }
  
  public final int getType()
  {
    return 1348;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.a
 * JD-Core Version:    0.7.0.1
 */