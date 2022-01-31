package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.jw;
import com.tencent.mm.protocal.c.jx;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ah.f dmL;
  private com.tencent.mm.ah.b eWr;
  public jx nxX;
  
  public f(String paramString1, String paramString2, String paramString3, int paramInt, com.tencent.mm.bv.b paramb, String paramString4)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new jw();
    ((b.a)localObject).ecI = new jx();
    ((b.a)localObject).ecG = 1680;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2factqry";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.eWr = ((b.a)localObject).Kt();
    localObject = (jw)this.eWr.ecE.ecN;
    ((jw)localObject).nzl = paramString3;
    ((jw)localObject).swc = paramString1;
    ((jw)localObject).swd = paramString2;
    ((jw)localObject).swh = paramInt;
    ((jw)localObject).sEH = paramb;
    ((jw)localObject).swe = paramString4;
    y.i("MicroMsg.NetSceneBusiF2fActQry", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneBusiF2fActQry", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.nxX = ((jx)((com.tencent.mm.ah.b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneBusiF2fActQry", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.nxX.ino), this.nxX.inp });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1680;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.f
 * JD-Core Version:    0.7.0.1
 */