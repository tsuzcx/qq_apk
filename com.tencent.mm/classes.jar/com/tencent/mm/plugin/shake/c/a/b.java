package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bc;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class b
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.ak.b rr;
  public e zcy;
  
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
    ae.i("MicroMsg.NetSceneGetLbsCard", "onGYNetEnd, getType = " + getType() + " errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bdo)this.rr.hQE.hQJ;
      if (paramq == null) {
        break label851;
      }
      paramInt1 = (int)(System.currentTimeMillis() / 1000L);
      if (paramq.GST) {
        break label124;
      }
      ae.e("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is false, no card , don't handle");
    }
    label218:
    label757:
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28184);
      return;
      label124:
      if (paramq.GSX <= paramInt1)
      {
        ae.e("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + paramq.GSX + " is <= currentTime:" + paramInt1 + " , don't handle");
      }
      else if (TextUtils.isEmpty(paramq.oEo))
      {
        ae.e("MicroMsg.NetSceneGetLbsCard", "getlbscard card_tp_id is empty , don't handle");
      }
      else
      {
        ae.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is true");
        if (paramq.GSU)
        {
          ae.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is true");
          this.zcy = new e();
          this.zcy.oGc = 1;
          this.zcy.oEo = paramq.oEo;
          this.zcy.dJc = paramq.dJc;
          this.zcy.title = paramq.title;
          this.zcy.oEp = paramq.oEp;
          this.zcy.oEq = paramq.oEq;
          this.zcy.oFG = paramq.oFG;
          this.zcy.hCp = paramq.hCp;
          this.zcy.hDr = paramq.hDr;
          this.zcy.zcz = 0;
          this.zcy.zcC = paramq.zcC;
          this.zcy.zcD = paramq.zcD;
          this.zcy.zcE = paramq.zcE;
          this.zcy.zcF = paramq.zcF;
          this.zcy.zcG = "";
          this.zcy.oEs = paramq.oEs;
          this.zcy.zcH = paramq.zcH;
          this.zcy.zcI = paramq.zcI;
          m.dSr().zcB = this.zcy.zcG;
          ae.i("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + paramq.GSX + " is <= currentTime:" + paramInt1);
          ae.i("MicroMsg.NetSceneGetLbsCard", "getlbscard activity_type: " + paramq.GSZ);
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(am.a.IKs, Integer.valueOf(paramInt1));
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(am.a.IKt, Integer.valueOf(paramq.GSX));
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(am.a.IKu, paramq.Dcj);
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(am.a.IKx, paramq.GSY);
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(am.a.IKy, Integer.valueOf(paramq.GSZ));
          paramArrayOfByte = com.tencent.mm.plugin.shake.c.c.a.dSI();
          ae.i("MicroMsg.NetSceneGetLbsCard", "getlbscard msg reddotid is " + paramq.GSV);
          ae.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre reddotid is ".concat(String.valueOf(paramArrayOfByte)));
          if (TextUtils.isEmpty(paramq.GSV)) {
            ae.i("MicroMsg.NetSceneGetLbsCard", "getlbscard resp.red_dot_id is empty");
          }
          if (!TextUtils.isEmpty(paramArrayOfByte)) {
            break label757;
          }
          ae.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre_red_dot_id is empty, resp.red_dot_id is not empty");
          com.tencent.mm.y.c.ahI().x(262155, true);
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(am.a.IKC, paramq.GSV);
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(am.a.IKD, paramq.GSW);
        }
        for (;;)
        {
          g.yxI.kvStat(11721, paramq.oEo);
          break;
          ae.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is false");
          break label218;
          if (!paramArrayOfByte.equals(paramq.GSV))
          {
            ae.i("MicroMsg.NetSceneGetLbsCard", "getlbscard redDotId and msg.reddotid is not empty, but no equals");
            com.tencent.mm.y.c.ahI().x(262155, true);
            bc.aCg();
            com.tencent.mm.model.c.ajA().set(am.a.IKC, paramq.GSV);
            bc.aCg();
            com.tencent.mm.model.c.ajA().set(am.a.IKD, paramq.GSW);
          }
          else if (paramArrayOfByte.equals(paramq.GSV))
          {
            ae.i("MicroMsg.NetSceneGetLbsCard", "redDotId equals msg.reddotid");
          }
        }
        ae.e("MicroMsg.NetSceneGetLbsCard", "getlbscard resp is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.b
 * JD-Core Version:    0.7.0.1
 */