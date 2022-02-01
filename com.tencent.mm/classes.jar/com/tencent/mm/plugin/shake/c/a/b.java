package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.model.ba;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.bcy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class b
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.al.b rr;
  public e yMo;
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(28183);
    this.callback = paramf;
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
      paramq = (bcy)this.rr.hNL.hNQ;
      if (paramq == null) {
        break label851;
      }
      paramInt1 = (int)(System.currentTimeMillis() / 1000L);
      if (paramq.Gzt) {
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
      if (paramq.Gzx <= paramInt1)
      {
        ad.e("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + paramq.Gzx + " is <= currentTime:" + paramInt1 + " , don't handle");
      }
      else if (TextUtils.isEmpty(paramq.oxM))
      {
        ad.e("MicroMsg.NetSceneGetLbsCard", "getlbscard card_tp_id is empty , don't handle");
      }
      else
      {
        ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is true");
        if (paramq.Gzu)
        {
          ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is true");
          this.yMo = new e();
          this.yMo.ozA = 1;
          this.yMo.oxM = paramq.oxM;
          this.yMo.dHY = paramq.dHY;
          this.yMo.title = paramq.title;
          this.yMo.oxN = paramq.oxN;
          this.yMo.oxO = paramq.oxO;
          this.yMo.oze = paramq.oze;
          this.yMo.hzB = paramq.hzB;
          this.yMo.hAD = paramq.hAD;
          this.yMo.yMp = 0;
          this.yMo.yMs = paramq.yMs;
          this.yMo.yMt = paramq.yMt;
          this.yMo.yMu = paramq.yMu;
          this.yMo.yMv = paramq.yMv;
          this.yMo.yMw = "";
          this.yMo.oxQ = paramq.oxQ;
          this.yMo.yMx = paramq.yMx;
          this.yMo.yMy = paramq.yMy;
          m.dOU().yMr = this.yMo.yMw;
          ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + paramq.Gzx + " is <= currentTime:" + paramInt1);
          ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard activity_type: " + paramq.Gzz);
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(al.a.IpY, Integer.valueOf(paramInt1));
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(al.a.IpZ, Integer.valueOf(paramq.Gzx));
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(al.a.Iqa, paramq.CKD);
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(al.a.Iqd, paramq.Gzy);
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(al.a.Iqe, Integer.valueOf(paramq.Gzz));
          paramArrayOfByte = com.tencent.mm.plugin.shake.c.c.a.dPl();
          ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard msg reddotid is " + paramq.Gzv);
          ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre reddotid is ".concat(String.valueOf(paramArrayOfByte)));
          if (TextUtils.isEmpty(paramq.Gzv)) {
            ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard resp.red_dot_id is empty");
          }
          if (!TextUtils.isEmpty(paramArrayOfByte)) {
            break label757;
          }
          ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre_red_dot_id is empty, resp.red_dot_id is not empty");
          com.tencent.mm.z.c.aht().x(262155, true);
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(al.a.Iqi, paramq.Gzv);
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(al.a.Iqj, paramq.Gzw);
        }
        for (;;)
        {
          g.yhR.kvStat(11721, paramq.oxM);
          break;
          ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is false");
          break label218;
          if (!paramArrayOfByte.equals(paramq.Gzv))
          {
            ad.i("MicroMsg.NetSceneGetLbsCard", "getlbscard redDotId and msg.reddotid is not empty, but no equals");
            com.tencent.mm.z.c.aht().x(262155, true);
            ba.aBQ();
            com.tencent.mm.model.c.ajl().set(al.a.Iqi, paramq.Gzv);
            ba.aBQ();
            com.tencent.mm.model.c.ajl().set(al.a.Iqj, paramq.Gzw);
          }
          else if (paramArrayOfByte.equals(paramq.Gzv))
          {
            ad.i("MicroMsg.NetSceneGetLbsCard", "redDotId equals msg.reddotid");
          }
        }
        ad.e("MicroMsg.NetSceneGetLbsCard", "getlbscard resp is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.b
 * JD-Core Version:    0.7.0.1
 */