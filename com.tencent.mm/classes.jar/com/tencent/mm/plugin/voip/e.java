package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.a.yb.a;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.p.a;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.dxv;
import com.tencent.mm.s.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.h;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class e
  extends com.tencent.mm.sdk.b.c<yb>
{
  public e()
  {
    AppMethodBeat.i(161652);
    this.__eventId = yb.class.getName().hashCode();
    AppMethodBeat.o(161652);
  }
  
  private static boolean a(yb paramyb)
  {
    boolean bool = true;
    int i = 1;
    int j = 1;
    AppMethodBeat.i(114811);
    if ((paramyb instanceof yb))
    {
      if (!com.tencent.mm.kernel.g.ajx())
      {
        AppMethodBeat.o(114811);
        return false;
      }
      switch (paramyb.dMo.dsi)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114811);
      return false;
      paramyb.dMp.dMq = c.euM().dfP;
      continue;
      if (a.adC()) {
        h.l(paramyb.dMo.context, 2131764884, 2131755906);
      } else if (!a.ce(paramyb.dMo.context)) {
        if (paramyb.dMo.dMk == 2)
        {
          s.bm(paramyb.dMo.context, paramyb.dMo.talker);
        }
        else if (paramyb.dMo.dMk == 3)
        {
          s.bn(paramyb.dMo.context, paramyb.dMo.talker);
        }
        else if (paramyb.dMo.dMk == 4)
        {
          s.bo(paramyb.dMo.context, paramyb.dMo.talker);
          continue;
          Object localObject1 = c.euM();
          Object localObject2 = paramyb.dMo.dMj;
          if ((localObject2 != null) && (localObject2.length >= 10) && (localObject2[0] == 1))
          {
            paramyb = new byte[localObject2.length - 1];
            System.arraycopy(localObject2, 1, paramyb, 0, paramyb.length);
            localObject2 = ((u)localObject1).CdF.BXC.CaI.Chg;
            ((o)localObject2).Ccy = System.currentTimeMillis();
            com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.VoipDailReport", "devin:recvInvite:" + ((o)localObject2).Ccy);
            try
            {
              paramyb = (dxv)new dxv().parseFrom(paramyb);
              ad.i("MicroMsg.Voip.VoipService", "doTaskCallin in onInviteNotify, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(paramyb.GeI), Long.valueOf(paramyb.GeJ), Integer.valueOf(paramyb.CreateTime) });
              if (!((u)localObject1).CdZ)
              {
                com.tencent.mm.plugin.voip.b.f.c(paramyb.GeI, paramyb.GeJ, 1, 2);
                ((u)localObject1).CdZ = true;
              }
              if (((u)localObject1).CdF.exO()) {
                break label527;
              }
              com.tencent.mm.plugin.report.service.g.yhR.a(11523, true, true, new Object[] { Integer.valueOf(paramyb.GeI), Long.valueOf(paramyb.GeJ), Integer.valueOf(paramyb.HKd), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
              ((u)localObject1).c(paramyb);
            }
            catch (IOException paramyb)
            {
              ad.printErrStackTrace("MicroMsg.Voip.VoipService", paramyb, "", new Object[0]);
            }
            continue;
            label527:
            com.tencent.mm.plugin.report.service.g.yhR.a(11523, true, true, new Object[] { Integer.valueOf(paramyb.GeI), Long.valueOf(paramyb.GeJ), Integer.valueOf(paramyb.HKd), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
            continue;
            c.euM();
            localObject1 = u.aDF(paramyb.dMo.content);
            if (localObject1 != null) {
              if (((p.a)localObject1).ewB())
              {
                paramyb.dMp.type = 2;
              }
              else
              {
                if (((p.a)localObject1).CcG == p.a.CcN) {}
                for (i = j; i != 0; i = 0)
                {
                  paramyb.dMp.type = 3;
                  break;
                }
                paramyb = paramyb.dMp;
                localObject1 = c.euM();
                localObject2 = aj.getContext();
                if ((((u)localObject1).dfP) && (((u)localObject1).CdU) && (!((u)localObject1).CdV))
                {
                  ad.d("MicroMsg.Voip.VoipService", "isVideoCalling " + ((u)localObject1).CdH + " isAudioCalling " + ((u)localObject1).CdI);
                  if ((!bt.isNullOrNil(((u)localObject1).talker)) && (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(((u)localObject1).talker) != null)) {
                    ((u)localObject1).a((Context)localObject2, ((u)localObject1).talker, ((u)localObject1).CdF.BXC.CaI.uLt, true, ((u)localObject1).CdH, true);
                  }
                }
                for (;;)
                {
                  paramyb.dMr = bool;
                  break;
                  bool = false;
                }
                localObject1 = c.euM();
                paramyb = paramyb.dMo.dMj;
                if (paramyb == null)
                {
                  ad.i("MicroMsg.Voip.VoipService", "sidney:notify content null");
                }
                else
                {
                  ad.i("MicroMsg.Voip.VoipService", "____voipNotify with data size:" + paramyb.length);
                  j = ByteBuffer.wrap(paramyb, 0, 4).getInt();
                  long l = ByteBuffer.wrap(paramyb, 4, 8).getLong();
                  ad.i("MicroMsg.Voip.VoipService", "voipNotify roomid:" + j + " roomkey:" + l);
                  if (((u)localObject1).CdX == null)
                  {
                    localObject2 = ((u)localObject1).CdF;
                    ad.i("MicroMsg.Voip.VoipServiceEx", "current roomid:%d, params roomid:%d", new Object[] { Integer.valueOf(((v)localObject2).BXC.CaI.roomId), Integer.valueOf(j) });
                    if ((j != 0) && (((v)localObject2).BXC.CaI.roomId == j)) {}
                    for (;;)
                    {
                      if (i != 0) {
                        break label1024;
                      }
                      ad.e("MicroMsg.Voip.VoipService", "voipSyncStatus ignored , not current roomid");
                      break;
                      i = 0;
                    }
                  }
                  label1024:
                  if (paramyb.length > 12) {
                    ((u)localObject1).b(u.X(paramyb, paramyb.length - 12), j, l);
                  }
                  paramyb = ((u)localObject1).CdF;
                  com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.abi() + " need doSync by notify, status:" + paramyb.BXC.mStatus);
                  paramyb.BXC.CaL.a(null, false, 7);
                  continue;
                  localObject1 = c.euM();
                  localObject2 = paramyb.dMo.dMj;
                  if ((!bt.cC((byte[])localObject2)) && (localObject2[0] == 3))
                  {
                    try
                    {
                      ad.i("MicroMsg.Voip.VoipService", "onCancelNotify");
                      paramyb = new byte[localObject2.length - 1];
                      System.arraycopy(localObject2, 1, paramyb, 0, paramyb.length);
                      localObject2 = new dxv();
                      ((dxv)localObject2).parseFrom(paramyb);
                      ((u)localObject1).Ul(((dxv)localObject2).GeI);
                      if ((((u)localObject1).CdX != null) && (((dxv)localObject2).GeI == ((u)localObject1).CdX.GeI) && (!((u)localObject1).wbS.fkZ()))
                      {
                        ((u)localObject1).CdX = null;
                        ((u)localObject1).CdY = 0L;
                        ((u)localObject1).wbS.stopTimer();
                      }
                      paramyb = ((u)localObject1).CdF;
                      ad.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteNotify, roomId: %s", new Object[] { Integer.valueOf(((dxv)localObject2).GeI) });
                      if ((paramyb.BXC.CaN == null) || (((dxv)localObject2).GeI != paramyb.BXC.CaN.GeI)) {
                        continue;
                      }
                      paramyb.exW();
                      paramyb.BXC.shutdown();
                    }
                    catch (Exception paramyb)
                    {
                      ad.e("MicroMsg.Voip.VoipService", "onCancelNotify error: %s", new Object[] { paramyb.getMessage() });
                    }
                    continue;
                    localObject1 = c.euM();
                    localObject2 = paramyb.dMo.dMj;
                    if ((!bt.cC((byte[])localObject2)) && (localObject2[0] == 2))
                    {
                      try
                      {
                        ad.i("MicroMsg.Voip.VoipService", "onAnswerNotify");
                        paramyb = new byte[localObject2.length - 1];
                        System.arraycopy(localObject2, 1, paramyb, 0, paramyb.length);
                        localObject2 = new dxv();
                        ((dxv)localObject2).parseFrom(paramyb);
                        paramyb = ((u)localObject1).CdF;
                        ad.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, roomId: %s", new Object[] { Integer.valueOf(((dxv)localObject2).GeI) });
                        if (((dxv)localObject2).GeI != paramyb.BXC.CaN.GeI) {
                          continue;
                        }
                        if (!paramyb.BXC.dDV) {
                          break label1509;
                        }
                        ad.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, already accept, ignore it");
                      }
                      catch (Exception paramyb)
                      {
                        ad.e("MicroMsg.Voip.VoipService", "onAnswerNotify error: %s", new Object[] { paramyb.getMessage() });
                      }
                      continue;
                      label1509:
                      ad.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, not accept, hangout");
                      paramyb.exW();
                      paramyb.BXC.shutdown();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.e
 * JD-Core Version:    0.7.0.1
 */