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
import com.tencent.mm.protocal.c.nu;
import com.tencent.mm.protocal.c.nv;
import com.tencent.mm.sdk.platformtools.y;

public final class s
  extends m
  implements k
{
  private f dmL;
  private b eWr;
  public nv nyx;
  
  public s(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new nu();
    ((b.a)localObject).ecI = new nv();
    ((b.a)localObject).ecG = 1779;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/transferoldpaycheck";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.eWr = ((b.a)localObject).Kt();
    localObject = (nu)this.eWr.ecE.ecN;
    ((nu)localObject).bOT = paramString1;
    ((nu)localObject).sLn = paramString2;
    ((nu)localObject).nzq = paramString3;
    ((nu)localObject).nzl = paramString4;
    ((nu)localObject).nAM = paramLong;
    ((nu)localObject).sKU = paramString5;
    y.i("MicroMsg.NetSceneRemittancePayCheck", "reqKey: %s, transfer: %s, fee: %s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneRemittancePayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.nyx = ((nv)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneRemittancePayCheck", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.nyx.iHq), this.nyx.iHr });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1779;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.s
 * JD-Core Version:    0.7.0.1
 */