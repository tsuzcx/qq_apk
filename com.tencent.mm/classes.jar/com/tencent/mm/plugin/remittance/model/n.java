package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ng;
import com.tencent.mm.protocal.c.nh;
import com.tencent.mm.sdk.platformtools.y;

public final class n
  extends m
  implements k
{
  private f dmL;
  private b eWr;
  private ng nyq;
  
  public n(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    b.a locala = new b.a();
    locala.ecH = new ng();
    locala.ecI = new nh();
    locala.ecG = 1273;
    locala.uri = "/cgi-bin/mmpay-bin/f2fpaycheck";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eWr = locala.Kt();
    this.nyq = ((ng)this.eWr.ecE.ecN);
    this.nyq.swc = paramString1;
    this.nyq.swd = paramString2;
    this.nyq.sKU = paramString3;
    this.nyq.sKV = paramString4;
    this.nyq.amount = paramInt;
    y.d("MicroMsg.NetSceneF2fPayCheck", "NetSceneF2fPayCheck, f2fId: %s, transId: %s, extendStr: %s, amount: %s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1273;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.n
 * JD-Core Version:    0.7.0.1
 */