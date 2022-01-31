package com.tencent.mm.plugin.remittance.model;

import b.a.a.c;
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
import com.tencent.mm.protocal.c.kf;
import com.tencent.mm.protocal.c.kg;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class j
  extends m
  implements k
{
  private f dmL;
  private b eWr;
  public kg nyk;
  
  public j(co paramco, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new kf();
    ((b.a)localObject).ecI = new kg();
    ((b.a)localObject).ecG = 2504;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2fsucpage";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.eWr = ((b.a)localObject).Kt();
    localObject = (kf)this.eWr.ecE.ecN;
    ((kf)localObject).sEQ = paramco;
    ((kf)localObject).sFc = paramString;
    y.i("MicroMsg.NetSceneBusiF2fSucpage", "NetSceneBusiF2fSucpage suc_page_extend %s req %s", new Object[] { paramString, a.a(paramco) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneBusiF2fSucpage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.nyk = ((kg)((b)paramq).ecF.ecN);
    paramq = new StringBuffer();
    if (this.nyk.qxJ != null)
    {
      paramq.append("response: " + this.nyk.sFp);
      paramq.append("is_show_btn: " + this.nyk.qxJ.sTg);
      if (this.nyk.qxJ.sTf != null) {
        paramq.append("single_exposure_info_list " + this.nyk.qxJ.sTf.size());
      }
    }
    y.i("MicroMsg.NetSceneBusiF2fSucpage", "ret_code: %s, ret_msg: %s %s", new Object[] { Integer.valueOf(this.nyk.ino), this.nyk.inp, paramq.toString() });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 2504;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.j
 * JD-Core Version:    0.7.0.1
 */