package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.alw;
import com.tencent.mm.protocal.protobuf.alx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class b
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  public e qNx;
  private final com.tencent.mm.ai.b rr;
  
  public b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(24511);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new alw();
    ((b.a)localObject).fsY = new alx();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/getlbscard";
    ((b.a)localObject).funcId = 1251;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (alw)this.rr.fsV.fta;
    ((alw)localObject).cyV = paramFloat2;
    ((alw)localObject).cAH = paramFloat1;
    AppMethodBeat.o(24511);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(24512);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(24512);
    return i;
  }
  
  public final int getType()
  {
    return 1251;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24513);
    ab.i("MicroMsg.NetSceneGetLbsCard", "onGYNetEnd, getType = " + getType() + " errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (alx)this.rr.fsW.fta;
      if (paramq == null) {
        break label852;
      }
      paramInt1 = (int)(System.currentTimeMillis() / 1000L);
      if (paramq.xcx) {
        break label124;
      }
      ab.e("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is false, no card , don't handle");
    }
    label218:
    label758:
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(24513);
      return;
      label124:
      if (paramq.xcB <= paramInt1)
      {
        ab.e("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + paramq.xcB + " is <= currentTime:" + paramInt1 + " , don't handle");
      }
      else if (TextUtils.isEmpty(paramq.kml))
      {
        ab.e("MicroMsg.NetSceneGetLbsCard", "getlbscard card_tp_id is empty , don't handle");
      }
      else
      {
        ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is true");
        if (paramq.xcy)
        {
          ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is true");
          this.qNx = new e();
          this.qNx.knS = 1;
          this.qNx.kml = paramq.kml;
          this.qNx.cHo = paramq.cHo;
          this.qNx.title = paramq.title;
          this.qNx.kmn = paramq.kmn;
          this.qNx.kmo = paramq.kmo;
          this.qNx.knw = paramq.knw;
          this.qNx.kmm = paramq.kmm;
          this.qNx.color = paramq.color;
          this.qNx.qNy = 0;
          this.qNx.qNB = paramq.qNB;
          this.qNx.qNC = paramq.qNC;
          this.qNx.qND = paramq.qND;
          this.qNx.qNE = paramq.qNE;
          this.qNx.qNF = "";
          this.qNx.kmq = paramq.kmq;
          this.qNx.qNG = paramq.qNG;
          this.qNx.qNH = paramq.qNH;
          com.tencent.mm.plugin.shake.b.m.clt().qNA = this.qNx.qNF;
          ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + paramq.xcB + " is <= currentTime:" + paramInt1);
          ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard activity_type: " + paramq.xcD);
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yxx, Integer.valueOf(paramInt1));
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yxy, Integer.valueOf(paramq.xcB));
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yxz, paramq.tXI);
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yxC, paramq.xcC);
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yxD, Integer.valueOf(paramq.xcD));
          paramArrayOfByte = com.tencent.mm.plugin.shake.c.c.a.clL();
          ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard msg reddotid is " + paramq.xcz);
          ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre reddotid is ".concat(String.valueOf(paramArrayOfByte)));
          if (TextUtils.isEmpty(paramq.xcz)) {
            ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard resp.red_dot_id is empty");
          }
          if (!TextUtils.isEmpty(paramArrayOfByte)) {
            break label758;
          }
          ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre_red_dot_id is empty, resp.red_dot_id is not empty");
          com.tencent.mm.x.c.PJ().y(262155, true);
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yxH, paramq.xcz);
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yxI, paramq.xcA);
        }
        for (;;)
        {
          h.qsU.kvStat(11721, paramq.kml);
          break;
          ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is false");
          break label218;
          if (!paramArrayOfByte.equals(paramq.xcz))
          {
            ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard redDotId and msg.reddotid is not empty, but no equals");
            com.tencent.mm.x.c.PJ().y(262155, true);
            aw.aaz();
            com.tencent.mm.model.c.Ru().set(ac.a.yxH, paramq.xcz);
            aw.aaz();
            com.tencent.mm.model.c.Ru().set(ac.a.yxI, paramq.xcA);
          }
          else if (paramArrayOfByte.equals(paramq.xcz))
          {
            ab.i("MicroMsg.NetSceneGetLbsCard", "redDotId equals msg.reddotid");
          }
        }
        ab.e("MicroMsg.NetSceneGetLbsCard", "getlbscard resp is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.b
 * JD-Core Version:    0.7.0.1
 */