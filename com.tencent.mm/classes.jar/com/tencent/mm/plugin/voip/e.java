package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.g.a.ww.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.p.a;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class e
  extends com.tencent.mm.sdk.b.c<ww>
{
  public e()
  {
    AppMethodBeat.i(161652);
    this.__eventId = ww.class.getName().hashCode();
    AppMethodBeat.o(161652);
  }
  
  private static boolean a(ww paramww)
  {
    boolean bool = true;
    int i = 1;
    int j = 1;
    AppMethodBeat.i(114811);
    if ((paramww instanceof ww))
    {
      if (!g.afw())
      {
        AppMethodBeat.o(114811);
        return false;
      }
      switch (paramww.dCp.djq)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114811);
      return false;
      paramww.dCq.dCr = c.dRQ().cXd;
      continue;
      if (a.aad()) {
        com.tencent.mm.ui.base.h.j(paramww.dCp.context, 2131764884, 2131755906);
      } else if (!a.dV(paramww.dCp.context)) {
        if (paramww.dCp.dCj == 2)
        {
          s.bi(paramww.dCp.context, paramww.dCp.talker);
        }
        else if (paramww.dCp.dCj == 3)
        {
          s.bj(paramww.dCp.context, paramww.dCp.talker);
        }
        else if (paramww.dCp.dCj == 4)
        {
          s.bk(paramww.dCp.context, paramww.dCp.talker);
          continue;
          Object localObject1 = c.dRQ();
          Object localObject2 = paramww.dCp.dCi;
          if ((localObject2 != null) && (localObject2.length >= 10) && (localObject2[0] == 1))
          {
            paramww = new byte[localObject2.length - 1];
            System.arraycopy(localObject2, 1, paramww, 0, paramww.length);
            localObject2 = ((u)localObject1).zlR.zfA.ziZ.zpq;
            ((o)localObject2).zkN = System.currentTimeMillis();
            com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.VoipDailReport", "devin:recvInvite:" + ((o)localObject2).zkN);
            try
            {
              paramww = (dmk)new dmk().parseFrom(paramww);
              ad.i("MicroMsg.Voip.VoipService", "doTaskCallin in onInviteNotify, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(paramww.DdZ), Long.valueOf(paramww.Dea), Integer.valueOf(paramww.CreateTime) });
              if (!((u)localObject1).zml)
              {
                com.tencent.mm.plugin.voip.b.c.c(paramww.DdZ, paramww.Dea, 1, 2);
                ((u)localObject1).zml = true;
              }
              if (((u)localObject1).zlR.dUR()) {
                break label527;
              }
              com.tencent.mm.plugin.report.service.h.vKh.a(11523, true, true, new Object[] { Integer.valueOf(paramww.DdZ), Long.valueOf(paramww.Dea), Integer.valueOf(paramww.EBU), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
              ((u)localObject1).c(paramww);
            }
            catch (IOException paramww)
            {
              ad.printErrStackTrace("MicroMsg.Voip.VoipService", paramww, "", new Object[0]);
            }
            continue;
            label527:
            com.tencent.mm.plugin.report.service.h.vKh.a(11523, true, true, new Object[] { Integer.valueOf(paramww.DdZ), Long.valueOf(paramww.Dea), Integer.valueOf(paramww.EBU), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
            continue;
            c.dRQ();
            localObject1 = u.atf(paramww.dCp.content);
            if (localObject1 != null) {
              if (((p.a)localObject1).dTE())
              {
                paramww.dCq.type = 2;
              }
              else
              {
                if (((p.a)localObject1).zkV == p.a.zlc) {}
                for (i = j; i != 0; i = 0)
                {
                  paramww.dCq.type = 3;
                  break;
                }
                paramww = paramww.dCq;
                localObject1 = c.dRQ();
                localObject2 = aj.getContext();
                if ((((u)localObject1).cXd) && (((u)localObject1).zmg) && (!((u)localObject1).zmh))
                {
                  ad.d("MicroMsg.Voip.VoipService", "isVideoCalling " + ((u)localObject1).zlT + " isAudioCalling " + ((u)localObject1).zlU);
                  if ((!bt.isNullOrNil(((u)localObject1).talker)) && (((k)g.ab(k.class)).apM().aHY(((u)localObject1).talker) != null)) {
                    ((u)localObject1).a((Context)localObject2, ((u)localObject1).talker, true, ((u)localObject1).zlT, true);
                  }
                }
                for (;;)
                {
                  paramww.dCs = bool;
                  break;
                  bool = false;
                }
                localObject1 = c.dRQ();
                paramww = paramww.dCp.dCi;
                if (paramww == null)
                {
                  ad.i("MicroMsg.Voip.VoipService", "sidney:notify content null");
                }
                else
                {
                  ad.i("MicroMsg.Voip.VoipService", "____voipNotify with data size:" + paramww.length);
                  j = ByteBuffer.wrap(paramww, 0, 4).getInt();
                  long l = ByteBuffer.wrap(paramww, 4, 8).getLong();
                  ad.i("MicroMsg.Voip.VoipService", "voipNotify roomid:" + j + " roomkey:" + l);
                  if (((u)localObject1).zmj == null)
                  {
                    localObject2 = ((u)localObject1).zlR;
                    ad.i("MicroMsg.Voip.VoipServiceEx", "current roomid:%d, params roomid:%d", new Object[] { Integer.valueOf(((v)localObject2).zfA.ziZ.roomId), Integer.valueOf(j) });
                    if ((j != 0) && (((v)localObject2).zfA.ziZ.roomId == j)) {}
                    for (;;)
                    {
                      if (i != 0) {
                        break label1010;
                      }
                      ad.e("MicroMsg.Voip.VoipService", "voipSyncStatus ignored , not current roomid");
                      break;
                      i = 0;
                    }
                  }
                  label1010:
                  if (paramww.length > 12) {
                    ((u)localObject1).b(u.X(paramww, paramww.length - 12), j, l);
                  }
                  paramww = ((u)localObject1).zlR;
                  com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipServiceEx", f.XJ() + " need doSync by notify, status:" + paramww.zfA.mStatus);
                  paramww.zfA.zjc.a(null, false, 7);
                  continue;
                  localObject1 = c.dRQ();
                  localObject2 = paramww.dCp.dCi;
                  if ((!bt.cw((byte[])localObject2)) && (localObject2[0] == 3))
                  {
                    try
                    {
                      ad.i("MicroMsg.Voip.VoipService", "onCancelNotify");
                      paramww = new byte[localObject2.length - 1];
                      System.arraycopy(localObject2, 1, paramww, 0, paramww.length);
                      localObject2 = new dmk();
                      ((dmk)localObject2).parseFrom(paramww);
                      ((u)localObject1).Qk(((dmk)localObject2).DdZ);
                      if ((((u)localObject1).zmj != null) && (((dmk)localObject2).DdZ == ((u)localObject1).zmj.DdZ) && (!((u)localObject1).tPc.eFX()))
                      {
                        ((u)localObject1).zmj = null;
                        ((u)localObject1).zmk = 0L;
                        ((u)localObject1).tPc.stopTimer();
                      }
                      paramww = ((u)localObject1).zlR;
                      ad.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteNotify, roomId: %s", new Object[] { Integer.valueOf(((dmk)localObject2).DdZ) });
                      if ((paramww.zfA.zje == null) || (((dmk)localObject2).DdZ != paramww.zfA.zje.DdZ)) {
                        continue;
                      }
                      paramww.dUZ();
                      paramww.zfA.shutdown();
                    }
                    catch (Exception paramww)
                    {
                      ad.e("MicroMsg.Voip.VoipService", "onCancelNotify error: %s", new Object[] { paramww.getMessage() });
                    }
                    continue;
                    localObject1 = c.dRQ();
                    localObject2 = paramww.dCp.dCi;
                    if ((!bt.cw((byte[])localObject2)) && (localObject2[0] == 2))
                    {
                      try
                      {
                        ad.i("MicroMsg.Voip.VoipService", "onAnswerNotify");
                        paramww = new byte[localObject2.length - 1];
                        System.arraycopy(localObject2, 1, paramww, 0, paramww.length);
                        localObject2 = new dmk();
                        ((dmk)localObject2).parseFrom(paramww);
                        paramww = ((u)localObject1).zlR;
                        ad.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, roomId: %s", new Object[] { Integer.valueOf(((dmk)localObject2).DdZ) });
                        if (((dmk)localObject2).DdZ != paramww.zfA.zje.DdZ) {
                          continue;
                        }
                        if (!paramww.zfA.duq) {
                          break label1495;
                        }
                        ad.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, already accept, ignore it");
                      }
                      catch (Exception paramww)
                      {
                        ad.e("MicroMsg.Voip.VoipService", "onAnswerNotify error: %s", new Object[] { paramww.getMessage() });
                      }
                      continue;
                      label1495:
                      ad.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, not accept, hangout");
                      paramww.dUZ();
                      paramww.zfA.shutdown();
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