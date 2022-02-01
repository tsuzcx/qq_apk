package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.model.az;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class b
  extends n
  implements k
{
  private g callback;
  private final com.tencent.mm.al.b rr;
  public e wmn;
  
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
    ad.i("MicroMsg.NetSceneGetLbsCard", "onGYNetEnd, getType = " + getType() + " errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (avo)this.rr.gUT.gUX;
      if (paramq == null) {
        break label851;
      }
      paramInt1 = (int)(System.currentTimeMillis() / 1000L);
      if (paramq.DuT) {
        break label124;
      }
      ad.e("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is false, no card , don't handle");
    }
    label218:
    label757:
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28184);
      return;
      label124:
      if (paramq.DuX <= paramInt1)
      {
        ad.e("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + paramq.DuX + " is <= currentTime:" + paramInt1 + " , don't handle");
      }
      else if (TextUtils.isEmpty(paramq.nrr))
      {
        ad.e("MicroMsg.NetSceneGetLbsCard", "getlbscard card_tp_id is empty , don't handle");
      }
      else
      {
        ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is true");
        if (paramq.DuU)
        {
          ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is true");
          this.wmn = new e();
          this.wmn.ntg = 1;
          this.wmn.nrr = paramq.nrr;
          this.wmn.dyd = paramq.dyd;
          this.wmn.title = paramq.title;
          this.wmn.nrs = paramq.nrs;
          this.wmn.nrt = paramq.nrt;
          this.wmn.nsK = paramq.nsK;
          this.wmn.gGR = paramq.gGR;
          this.wmn.gHT = paramq.gHT;
          this.wmn.wmo = 0;
          this.wmn.wmr = paramq.wmr;
          this.wmn.wms = paramq.wms;
          this.wmn.wmt = paramq.wmt;
          this.wmn.wmu = paramq.wmu;
          this.wmn.wmv = "";
          this.wmn.nrv = paramq.nrv;
          this.wmn.wmw = paramq.wmw;
          this.wmn.wmx = paramq.wmx;
          m.dph().wmq = this.wmn.wmv;
          ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + paramq.DuX + " is <= currentTime:" + paramInt1);
          ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard activity_type: " + paramq.DuZ);
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.FfR, Integer.valueOf(paramInt1));
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.FfS, Integer.valueOf(paramq.DuX));
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.FfT, paramq.zRV);
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.FfW, paramq.DuY);
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.FfX, Integer.valueOf(paramq.DuZ));
          paramArrayOfByte = com.tencent.mm.plugin.shake.c.c.a.dpy();
          ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard msg reddotid is " + paramq.DuV);
          ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre reddotid is ".concat(String.valueOf(paramArrayOfByte)));
          if (TextUtils.isEmpty(paramq.DuV)) {
            ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard resp.red_dot_id is empty");
          }
          if (!TextUtils.isEmpty(paramArrayOfByte)) {
            break label757;
          }
          ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre_red_dot_id is empty, resp.red_dot_id is not empty");
          com.tencent.mm.z.c.adr().x(262155, true);
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.Fgb, paramq.DuV);
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.Fgc, paramq.DuW);
        }
        for (;;)
        {
          h.vKh.kvStat(11721, paramq.nrr);
          break;
          ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is false");
          break label218;
          if (!paramArrayOfByte.equals(paramq.DuV))
          {
            ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard redDotId and msg.reddotid is not empty, but no equals");
            com.tencent.mm.z.c.adr().x(262155, true);
            az.arV();
            com.tencent.mm.model.c.afk().set(ae.a.Fgb, paramq.DuV);
            az.arV();
            com.tencent.mm.model.c.afk().set(ae.a.Fgc, paramq.DuW);
          }
          else if (paramArrayOfByte.equals(paramq.DuV))
          {
            ad.i("MicroMsg.NetSceneGetLbsCard", "redDotId equals msg.reddotid");
          }
        }
        ad.e("MicroMsg.NetSceneGetLbsCard", "getlbscard resp is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.b
 * JD-Core Version:    0.7.0.1
 */