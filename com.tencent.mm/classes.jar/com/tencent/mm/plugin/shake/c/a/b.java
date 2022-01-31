package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.model.au;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ahb;
import com.tencent.mm.protocal.c.ahc;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class b
  extends com.tencent.mm.ah.m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  public e nZn;
  
  public b(float paramFloat1, float paramFloat2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ahb();
    ((b.a)localObject).ecI = new ahc();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/getlbscard";
    ((b.a)localObject).ecG = 1251;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ahb)this.dmK.ecE.ecN;
    ((ahb)localObject).bRt = paramFloat2;
    ((ahb)localObject).bTc = paramFloat1;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetLbsCard", "onGYNetEnd, getType = 1251 errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ahc)this.dmK.ecF.ecN;
      if (paramq == null) {
        break label834;
      }
      paramInt1 = (int)(System.currentTimeMillis() / 1000L);
      if (paramq.tez) {
        break label100;
      }
      y.e("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is false, no card , don't handle");
    }
    label194:
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      label100:
      if (paramq.teD <= paramInt1)
      {
        y.e("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + paramq.teD + " is <= currentTime:" + paramInt1 + " , don't handle");
      }
      else if (TextUtils.isEmpty(paramq.iln))
      {
        y.e("MicroMsg.NetSceneGetLbsCard", "getlbscard card_tp_id is empty , don't handle");
      }
      else
      {
        y.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is true");
        if (paramq.teA)
        {
          y.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is true");
          this.nZn = new e();
          this.nZn.imX = 1;
          this.nZn.iln = paramq.iln;
          this.nZn.bZd = paramq.bZd;
          this.nZn.title = paramq.title;
          this.nZn.ilq = paramq.ilq;
          this.nZn.ilr = paramq.ilr;
          this.nZn.imA = paramq.imA;
          this.nZn.ilp = paramq.ilp;
          this.nZn.color = paramq.color;
          this.nZn.nZo = 0;
          this.nZn.nZr = paramq.nZr;
          this.nZn.nZs = paramq.nZs;
          this.nZn.nZt = paramq.nZt;
          this.nZn.nZu = paramq.nZu;
          this.nZn.nZv = "";
          this.nZn.end_time = paramq.end_time;
          this.nZn.nZw = paramq.nZw;
          this.nZn.nZx = paramq.nZx;
          com.tencent.mm.plugin.shake.b.m.bAa().nZq = this.nZn.nZv;
          y.i("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + paramq.teD + " is <= currentTime:" + paramInt1);
          y.i("MicroMsg.NetSceneGetLbsCard", "getlbscard activity_type: " + paramq.teF);
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.unG, Integer.valueOf(paramInt1));
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.unH, Integer.valueOf(paramq.teD));
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.unI, paramq.teG);
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.unL, paramq.teE);
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.unM, Integer.valueOf(paramq.teF));
          paramArrayOfByte = com.tencent.mm.plugin.shake.c.c.a.bAr();
          y.i("MicroMsg.NetSceneGetLbsCard", "getlbscard msg reddotid is " + paramq.teB);
          y.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre reddotid is " + paramArrayOfByte);
          if (TextUtils.isEmpty(paramq.teB)) {
            y.i("MicroMsg.NetSceneGetLbsCard", "getlbscard resp.red_dot_id is empty");
          }
          if (!TextUtils.isEmpty(paramArrayOfByte)) {
            break label740;
          }
          y.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre_red_dot_id is empty, resp.red_dot_id is not empty");
          com.tencent.mm.y.c.BS().w(262155, true);
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.unQ, paramq.teB);
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.unR, paramq.teC);
        }
        for (;;)
        {
          h.nFQ.aC(11721, paramq.iln);
          break;
          y.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is false");
          break label194;
          label740:
          if (!paramArrayOfByte.equals(paramq.teB))
          {
            y.i("MicroMsg.NetSceneGetLbsCard", "getlbscard redDotId and msg.reddotid is not empty, but no equals");
            com.tencent.mm.y.c.BS().w(262155, true);
            au.Hx();
            com.tencent.mm.model.c.Dz().c(ac.a.unQ, paramq.teB);
            au.Hx();
            com.tencent.mm.model.c.Dz().c(ac.a.unR, paramq.teC);
          }
          else if (paramArrayOfByte.equals(paramq.teB))
          {
            y.i("MicroMsg.NetSceneGetLbsCard", "redDotId equals msg.reddotid");
          }
        }
        y.e("MicroMsg.NetSceneGetLbsCard", "getlbscard resp is null");
      }
    }
  }
  
  public final int getType()
  {
    return 1251;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.b
 * JD-Core Version:    0.7.0.1
 */