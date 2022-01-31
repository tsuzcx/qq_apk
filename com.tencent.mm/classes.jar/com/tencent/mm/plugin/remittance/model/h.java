package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.co;
import com.tencent.mm.protocal.c.kb;
import com.tencent.mm.protocal.c.kc;
import com.tencent.mm.sdk.platformtools.y;

public final class h
  extends m
  implements k
{
  private f dmL;
  private b eWr;
  public kc nyg;
  
  public h(co paramco, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new kb();
    ((b.a)localObject).ecI = new kc();
    ((b.a)localObject).ecG = 1241;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2fpaycheck";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.eWr = ((b.a)localObject).Kt();
    localObject = (kb)this.eWr.ecE.ecN;
    ((kb)localObject).sEQ = paramco;
    ((kb)localObject).sER = paramString;
    y.i("MicroMsg.NetSceneBusiF2fPayCheck", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s req: %s", new Object[] { paramco.swc, paramco.swd, Integer.valueOf(paramco.swh), a.a(paramco) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneBusiF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.nyg = ((kc)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneBusiF2fPayCheck", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.nyg.ino), this.nyg.inp });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1241;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.h
 * JD-Core Version:    0.7.0.1
 */