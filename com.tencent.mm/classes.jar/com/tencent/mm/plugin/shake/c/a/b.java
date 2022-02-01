package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.az;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.ayu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class b
  extends n
  implements k
{
  private g callback;
  private final com.tencent.mm.ak.b rr;
  public e xxD;
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(28183);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(28183);
    return i;
  }
  
  public final int getType()
  {
    return 1251;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28184);
    ac.i("MicroMsg.NetSceneGetLbsCard", "onGYNetEnd, getType = " + getType() + " errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ayu)this.rr.hvs.hvw;
      if (paramq == null) {
        break label851;
      }
      paramInt1 = (int)(System.currentTimeMillis() / 1000L);
      if (paramq.EQc) {
        break label124;
      }
      ac.e("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is false, no card , don't handle");
    }
    label218:
    label757:
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28184);
      return;
      label124:
      if (paramq.EQg <= paramInt1)
      {
        ac.e("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + paramq.EQg + " is <= currentTime:" + paramInt1 + " , don't handle");
      }
      else if (TextUtils.isEmpty(paramq.nUr))
      {
        ac.e("MicroMsg.NetSceneGetLbsCard", "getlbscard card_tp_id is empty , don't handle");
      }
      else
      {
        ac.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is true");
        if (paramq.EQd)
        {
          ac.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is true");
          this.xxD = new e();
          this.xxD.nWg = 1;
          this.xxD.nUr = paramq.nUr;
          this.xxD.dvP = paramq.dvP;
          this.xxD.title = paramq.title;
          this.xxD.nUs = paramq.nUs;
          this.xxD.nUt = paramq.nUt;
          this.xxD.nVK = paramq.nVK;
          this.xxD.hhs = paramq.hhs;
          this.xxD.hiu = paramq.hiu;
          this.xxD.xxE = 0;
          this.xxD.xxH = paramq.xxH;
          this.xxD.xxI = paramq.xxI;
          this.xxD.xxJ = paramq.xxJ;
          this.xxD.xxK = paramq.xxK;
          this.xxD.xxL = "";
          this.xxD.nUv = paramq.nUv;
          this.xxD.xxM = paramq.xxM;
          this.xxD.xxN = paramq.xxN;
          m.dDr().xxG = this.xxD.xxL;
          ac.i("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + paramq.EQg + " is <= currentTime:" + paramInt1);
          ac.i("MicroMsg.NetSceneGetLbsCard", "getlbscard activity_type: " + paramq.EQi);
          az.ayM();
          com.tencent.mm.model.c.agA().set(ah.a.GDF, Integer.valueOf(paramInt1));
          az.ayM();
          com.tencent.mm.model.c.agA().set(ah.a.GDG, Integer.valueOf(paramq.EQg));
          az.ayM();
          com.tencent.mm.model.c.agA().set(ah.a.GDH, paramq.Bkp);
          az.ayM();
          com.tencent.mm.model.c.agA().set(ah.a.GDK, paramq.EQh);
          az.ayM();
          com.tencent.mm.model.c.agA().set(ah.a.GDL, Integer.valueOf(paramq.EQi));
          paramArrayOfByte = com.tencent.mm.plugin.shake.c.c.a.dDI();
          ac.i("MicroMsg.NetSceneGetLbsCard", "getlbscard msg reddotid is " + paramq.EQe);
          ac.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre reddotid is ".concat(String.valueOf(paramArrayOfByte)));
          if (TextUtils.isEmpty(paramq.EQe)) {
            ac.i("MicroMsg.NetSceneGetLbsCard", "getlbscard resp.red_dot_id is empty");
          }
          if (!TextUtils.isEmpty(paramArrayOfByte)) {
            break label757;
          }
          ac.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre_red_dot_id is empty, resp.red_dot_id is not empty");
          com.tencent.mm.y.c.aeH().x(262155, true);
          az.ayM();
          com.tencent.mm.model.c.agA().set(ah.a.GDP, paramq.EQe);
          az.ayM();
          com.tencent.mm.model.c.agA().set(ah.a.GDQ, paramq.EQf);
        }
        for (;;)
        {
          h.wUl.kvStat(11721, paramq.nUr);
          break;
          ac.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is false");
          break label218;
          if (!paramArrayOfByte.equals(paramq.EQe))
          {
            ac.i("MicroMsg.NetSceneGetLbsCard", "getlbscard redDotId and msg.reddotid is not empty, but no equals");
            com.tencent.mm.y.c.aeH().x(262155, true);
            az.ayM();
            com.tencent.mm.model.c.agA().set(ah.a.GDP, paramq.EQe);
            az.ayM();
            com.tencent.mm.model.c.agA().set(ah.a.GDQ, paramq.EQf);
          }
          else if (paramArrayOfByte.equals(paramq.EQe))
          {
            ac.i("MicroMsg.NetSceneGetLbsCard", "redDotId equals msg.reddotid");
          }
        }
        ac.e("MicroMsg.NetSceneGetLbsCard", "getlbscard resp is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.b
 * JD-Core Version:    0.7.0.1
 */