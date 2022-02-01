package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class b
  extends q
  implements com.tencent.mm.network.m
{
  public e Dhq;
  private i callback;
  private final d rr;
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(28183);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(28183);
    return i;
  }
  
  public final int getType()
  {
    return 1251;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28184);
    Log.i("MicroMsg.NetSceneGetLbsCard", "onGYNetEnd, getType = " + getType() + " errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (bpc)this.rr.iLL.iLR;
      if (params == null) {
        break label851;
      }
      paramInt1 = (int)(System.currentTimeMillis() / 1000L);
      if (params.LXf) {
        break label124;
      }
      Log.e("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is false, no card , don't handle");
    }
    label218:
    label757:
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28184);
      return;
      label124:
      if (params.LXj <= paramInt1)
      {
        Log.e("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + params.LXj + " is <= currentTime:" + paramInt1 + " , don't handle");
      }
      else if (TextUtils.isEmpty(params.pRX))
      {
        Log.e("MicroMsg.NetSceneGetLbsCard", "getlbscard card_tp_id is empty , don't handle");
      }
      else
      {
        Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is true");
        if (params.LXg)
        {
          Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is true");
          this.Dhq = new e();
          this.Dhq.pTI = 1;
          this.Dhq.pRX = params.pRX;
          this.Dhq.eaP = params.eaP;
          this.Dhq.title = params.title;
          this.Dhq.pRY = params.pRY;
          this.Dhq.pRZ = params.pRZ;
          this.Dhq.gTG = params.gTG;
          this.Dhq.iwv = params.iwv;
          this.Dhq.ixw = params.ixw;
          this.Dhq.Dhr = 0;
          this.Dhq.Dhu = params.Dhu;
          this.Dhq.Dhv = params.Dhv;
          this.Dhq.Dhw = params.Dhw;
          this.Dhq.Dhx = params.Dhx;
          this.Dhq.Dhy = "";
          this.Dhq.pSb = params.pSb;
          this.Dhq.Dhz = params.Dhz;
          this.Dhq.DhA = params.DhA;
          com.tencent.mm.plugin.shake.b.m.eUs().Dht = this.Dhq.Dhy;
          Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + params.LXj + " is <= currentTime:" + paramInt1);
          Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard activity_type: " + params.LXl);
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(ar.a.NSq, Integer.valueOf(paramInt1));
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(ar.a.NSr, Integer.valueOf(params.LXj));
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(ar.a.NSs, params.HHX);
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(ar.a.NSv, params.LXk);
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(ar.a.NSw, Integer.valueOf(params.LXl));
          paramArrayOfByte = com.tencent.mm.plugin.shake.c.c.a.eUJ();
          Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard msg reddotid is " + params.LXh);
          Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre reddotid is ".concat(String.valueOf(paramArrayOfByte)));
          if (TextUtils.isEmpty(params.LXh)) {
            Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard resp.red_dot_id is empty");
          }
          if (!TextUtils.isEmpty(paramArrayOfByte)) {
            break label757;
          }
          Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre_red_dot_id is empty, resp.red_dot_id is not empty");
          com.tencent.mm.y.c.axV().B(262155, true);
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(ar.a.NSA, params.LXh);
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(ar.a.NSB, params.LXi);
        }
        for (;;)
        {
          h.CyF.kvStat(11721, params.pRX);
          break;
          Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is false");
          break label218;
          if (!paramArrayOfByte.equals(params.LXh))
          {
            Log.i("MicroMsg.NetSceneGetLbsCard", "getlbscard redDotId and msg.reddotid is not empty, but no equals");
            com.tencent.mm.y.c.axV().B(262155, true);
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.NSA, params.LXh);
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.NSB, params.LXi);
          }
          else if (paramArrayOfByte.equals(params.LXh))
          {
            Log.i("MicroMsg.NetSceneGetLbsCard", "redDotId equals msg.reddotid");
          }
        }
        Log.e("MicroMsg.NetSceneGetLbsCard", "getlbscard resp is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.b
 * JD-Core Version:    0.7.0.1
 */