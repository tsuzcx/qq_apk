package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bsp;
import com.tencent.mm.protocal.c.bsq;
import com.tencent.mm.protocal.c.bss;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.protocal.c.bsy;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.buc;
import com.tencent.mm.protocal.c.bvp;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  private b dmK;
  public com.tencent.mm.ah.f dmL;
  private String opK;
  private bsy opL;
  private int type;
  
  public k(bsy parambsy, String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bsp();
    ((b.a)localObject).ecI = new bsq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsadcomment";
    ((b.a)localObject).ecG = 682;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bsp)this.dmK.ecE.ecN;
    ((bsp)localObject).tJf = parambsy;
    this.type = parambsy.tJB.hQR;
    this.opL = parambsy;
    ((bsp)localObject).nde = paramString1;
    this.opK = paramString1;
    long l = parambsy.sGd;
    paramString1 = af.bDI().gk(l);
    if (paramString1 != null)
    {
      paramString1 = paramString1.bGe();
      if (paramString1 != null)
      {
        paramString1 = p.nu(paramString1.oPO);
        if (paramString1 != null)
        {
          ((bsp)localObject).tJg = aa.pj(p.a(paramString1));
          ((bsp)localObject).swS = paramString1.source;
        }
        ((bsp)localObject).tJe = aa.pj(bk.aM(paramString2, ""));
        y.i("MicroMsg.NetSceneSnsAdComment", parambsy.tJB.tAY + " " + parambsy.tJB.sSS + " type " + parambsy.tJB.hQR + " aduxinfo " + paramString2 + ", SnsStat=" + ((bsp)localObject).tJg + ", source=" + ((bsp)localObject).swS);
        return;
      }
      y.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      paramString1 = null;
      break;
      y.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[] { Long.valueOf(l) });
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneSnsAdComment", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4) {
        af.bDE().e(this.opL.sGd, this.type, this.opK);
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    af.bDE().e(this.opL.sGd, this.type, this.opK);
    paramq = this.opL.tJB;
    if ((paramq.hQR == 1) || (paramq.hQR == 2) || (paramq.hQR == 3) || (paramq.hQR == 5) || (paramq.hQR == 7) || (paramq.hQR == 8) || (paramq.hQR == 16))
    {
      paramArrayOfByte = new btd();
      paramArrayOfByte.mPL = paramq.mPL;
      paramArrayOfByte.hQR = paramq.hQR;
      paramArrayOfByte.swS = paramq.swS;
      paramArrayOfByte.sxM = paramq.tAY;
      paramArrayOfByte.tqh = paramq.tJr;
      paramArrayOfByte.kVs = paramq.kVs;
      paramArrayOfByte.tJz = paramq.tJz;
    }
    for (;;)
    {
      try
      {
        paramq = (bsp)this.dmK.ecE.ecN;
        paramArrayOfByte = (bsq)this.dmK.ecF.ecN;
        if ((paramq.swS != 1) && (paramq.swS != 2)) {
          continue;
        }
        paramArrayOfByte = paramArrayOfByte.tDk;
        paramq = paramArrayOfByte.tJi;
        a.a(paramArrayOfByte);
        y.d("MicroMsg.NetSceneSnsAdComment", "snsComment:" + paramq.toString() + " " + paramq.tJY.size() + " " + paramq.tKb.size());
      }
      catch (Exception paramq)
      {
        y.printErrStackTrace("MicroMsg.NetSceneSnsAdComment", paramq, "", new Object[0]);
        continue;
      }
      af.bDE().bDg();
      break;
      paramArrayOfByte = paramArrayOfByte.svY;
      paramq = paramArrayOfByte.tJi;
      a.a(paramArrayOfByte);
    }
  }
  
  public final int getType()
  {
    return 682;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.k
 * JD-Core Version:    0.7.0.1
 */