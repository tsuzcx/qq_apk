package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bfm;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.protocal.c.bsy;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.bte;
import com.tencent.mm.protocal.c.btf;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.btw;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Locale;

public final class o
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  public com.tencent.mm.ah.f dmL;
  private String opK;
  private bsy opL;
  private int type;
  
  public o(bsy parambsy, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bte();
    ((b.a)localObject).ecI = new btf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnscomment";
    ((b.a)localObject).ecG = 213;
    ((b.a)localObject).ecJ = 100;
    ((b.a)localObject).ecK = 1000000100;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bte)this.dmK.ecE.ecN;
    ((bte)localObject).tJf = parambsy;
    this.type = parambsy.tJB.hQR;
    this.opL = parambsy;
    ((bte)localObject).nde = paramString;
    this.opK = paramString;
    y.d("MicroMsg.NetSceneSnsComment", parambsy.tJB.tAY + " " + parambsy.tJB.sSS);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    Object localObject2 = af.bDF().gt(this.opL.sGd);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.sns.storage.e locale = af.bDI().gk(this.opL.sGd);
      localObject1 = localObject2;
      if (locale != null) {
        localObject1 = locale.bGl();
      }
    }
    if (localObject1 != null) {}
    try
    {
      localObject1 = (bto)new bto().aH(((n)localObject1).field_attrBuf);
      if ((((bto)localObject1).tKl != null) && (((bto)localObject1).tKl.tFN))
      {
        localObject2 = (btw)new btw().aH(((bto)localObject1).tKl.tFM.oY);
        localObject1 = (bte)this.dmK.ecE.ecN;
        if (((btw)localObject2).tKA != null)
        {
          localObject2 = String.format(Locale.US, "preloadLayerId=%d&preloadExpId=%d", new Object[] { Integer.valueOf(((btw)localObject2).tKA.sQC), Integer.valueOf(((btw)localObject2).tKA.sQD) });
          y.i("MicroMsg.NetSceneSnsComment", "doScene(sight_autodownload) snsStatExt:%s", new Object[] { localObject2 });
          ((bte)localObject1).tJg = new bml().YI((String)localObject2);
        }
      }
      this.dmL = paramf;
      return a(parame, this.dmK, this);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.NetSceneSnsComment", localException, "", new Object[0]);
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneSnsComment", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
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
    if ((paramq.hQR == 1) || (paramq.hQR == 2) || (paramq.hQR == 3) || (paramq.hQR == 5))
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
        paramArrayOfByte = ((btf)this.dmK.ecF.ecN).tJi;
        if ((paramq.hQR != 1) && (paramq.hQR != 5)) {
          continue;
        }
        y.i("MicroMsg.NetSceneSnsComment", "snsComment:" + paramArrayOfByte.sGd + " " + aa.b(paramArrayOfByte.tJU) + " " + paramArrayOfByte.tJY.size() + " " + paramArrayOfByte.tKb.size());
        aj.d(paramArrayOfByte);
      }
      catch (Exception paramq)
      {
        y.printErrStackTrace("MicroMsg.NetSceneSnsComment", paramq, "", new Object[0]);
        continue;
      }
      af.bDE().bDg();
      break;
      y.i("MicroMsg.NetSceneSnsComment", "snsComment:" + paramArrayOfByte.sGd + " " + paramArrayOfByte.tJY.size() + " " + paramArrayOfByte.tKb.size());
    }
  }
  
  public final int getType()
  {
    return 213;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.o
 * JD-Core Version:    0.7.0.1
 */