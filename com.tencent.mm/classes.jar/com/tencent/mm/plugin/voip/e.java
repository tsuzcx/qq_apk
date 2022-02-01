package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.a.yh.a;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.p.a;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class e
  extends com.tencent.mm.sdk.b.c<yh>
{
  public e()
  {
    AppMethodBeat.i(161652);
    this.__eventId = yh.class.getName().hashCode();
    AppMethodBeat.o(161652);
  }
  
  private static boolean a(yh paramyh)
  {
    boolean bool = true;
    int i = 1;
    int j = 1;
    AppMethodBeat.i(114811);
    if ((paramyh instanceof yh))
    {
      if (!com.tencent.mm.kernel.g.ajM())
      {
        AppMethodBeat.o(114811);
        return false;
      }
      switch (paramyh.dNE.dto)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114811);
      return false;
      paramyh.dNF.dNG = c.eys().dgR;
      continue;
      if (a.adO()) {
        h.l(paramyh.dNE.context, 2131764884, 2131755906);
      } else if (!a.cg(paramyh.dNE.context)) {
        if (paramyh.dNE.dNA == 2)
        {
          s.bo(paramyh.dNE.context, paramyh.dNE.talker);
        }
        else if (paramyh.dNE.dNA == 3)
        {
          s.bp(paramyh.dNE.context, paramyh.dNE.talker);
        }
        else if (paramyh.dNE.dNA == 4)
        {
          s.bq(paramyh.dNE.context, paramyh.dNE.talker);
          continue;
          Object localObject1 = c.eys();
          Object localObject2 = paramyh.dNE.dNz;
          if ((localObject2 != null) && (localObject2.length >= 10) && (localObject2[0] == 1))
          {
            paramyh = new byte[localObject2.length - 1];
            System.arraycopy(localObject2, 1, paramyh, 0, paramyh.length);
            localObject2 = ((u)localObject1).Cvg.Cpd.Csj.CyH;
            ((o)localObject2).CtZ = System.currentTimeMillis();
            com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.VoipDailReport", "devin:recvInvite:" + ((o)localObject2).CtZ);
            try
            {
              paramyh = (dzm)new dzm().parseFrom(paramyh);
              ae.i("MicroMsg.Voip.VoipService", "doTaskCallin in onInviteNotify, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(paramyh.Gxq), Long.valueOf(paramyh.Gxr), Integer.valueOf(paramyh.CreateTime) });
              if (!((u)localObject1).CvA)
              {
                com.tencent.mm.plugin.voip.b.f.c(paramyh.Gxq, paramyh.Gxr, 1, 2);
                ((u)localObject1).CvA = true;
              }
              if (((u)localObject1).Cvg.eBw()) {
                break label527;
              }
              com.tencent.mm.plugin.report.service.g.yxI.a(11523, true, true, new Object[] { Integer.valueOf(paramyh.Gxq), Long.valueOf(paramyh.Gxr), Integer.valueOf(paramyh.Iel), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
              ((u)localObject1).c(paramyh);
            }
            catch (IOException paramyh)
            {
              ae.printErrStackTrace("MicroMsg.Voip.VoipService", paramyh, "", new Object[0]);
            }
            continue;
            label527:
            com.tencent.mm.plugin.report.service.g.yxI.a(11523, true, true, new Object[] { Integer.valueOf(paramyh.Gxq), Long.valueOf(paramyh.Gxr), Integer.valueOf(paramyh.Iel), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
            continue;
            c.eys();
            localObject1 = u.aEY(paramyh.dNE.content);
            if (localObject1 != null) {
              if (((p.a)localObject1).eAi())
              {
                paramyh.dNF.type = 2;
              }
              else
              {
                if (((p.a)localObject1).Cuh == p.a.Cuo) {}
                for (i = j; i != 0; i = 0)
                {
                  paramyh.dNF.type = 3;
                  break;
                }
                paramyh = paramyh.dNF;
                localObject1 = c.eys();
                localObject2 = ak.getContext();
                if ((((u)localObject1).dgR) && (((u)localObject1).Cvv) && (!((u)localObject1).Cvw))
                {
                  ae.d("MicroMsg.Voip.VoipService", "isVideoCalling " + ((u)localObject1).Cvi + " isAudioCalling " + ((u)localObject1).Cvj);
                  if ((!bu.isNullOrNil(((u)localObject1).talker)) && (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(((u)localObject1).talker) != null)) {
                    ((u)localObject1).a((Context)localObject2, ((u)localObject1).talker, ((u)localObject1).Cvg.Cpd.Csj.uXg, true, ((u)localObject1).Cvi, true);
                  }
                }
                for (;;)
                {
                  paramyh.dNH = bool;
                  break;
                  bool = false;
                }
                localObject1 = c.eys();
                paramyh = paramyh.dNE.dNz;
                if (paramyh == null)
                {
                  ae.i("MicroMsg.Voip.VoipService", "sidney:notify content null");
                }
                else
                {
                  ae.i("MicroMsg.Voip.VoipService", "____voipNotify with data size:" + paramyh.length);
                  j = ByteBuffer.wrap(paramyh, 0, 4).getInt();
                  long l = ByteBuffer.wrap(paramyh, 4, 8).getLong();
                  ae.i("MicroMsg.Voip.VoipService", "voipNotify roomid:" + j + " roomkey:" + l);
                  if (((u)localObject1).Cvy == null)
                  {
                    localObject2 = ((u)localObject1).Cvg;
                    ae.i("MicroMsg.Voip.VoipServiceEx", "current roomid:%d, params roomid:%d", new Object[] { Integer.valueOf(((v)localObject2).Cpd.Csj.roomId), Integer.valueOf(j) });
                    if ((j != 0) && (((v)localObject2).Cpd.Csj.roomId == j)) {}
                    for (;;)
                    {
                      if (i != 0) {
                        break label1024;
                      }
                      ae.e("MicroMsg.Voip.VoipService", "voipSyncStatus ignored , not current roomid");
                      break;
                      i = 0;
                    }
                  }
                  label1024:
                  if (paramyh.length > 12) {
                    ((u)localObject1).b(u.ab(paramyh, paramyh.length - 12), j, l);
                  }
                  paramyh = ((u)localObject1).Cvg;
                  com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.abr() + " need doSync by notify, status:" + paramyh.Cpd.mStatus);
                  paramyh.Cpd.Csm.a(null, false, 7);
                  continue;
                  localObject1 = c.eys();
                  localObject2 = paramyh.dNE.dNz;
                  if ((!bu.cF((byte[])localObject2)) && (localObject2[0] == 3))
                  {
                    try
                    {
                      ae.i("MicroMsg.Voip.VoipService", "onCancelNotify");
                      paramyh = new byte[localObject2.length - 1];
                      System.arraycopy(localObject2, 1, paramyh, 0, paramyh.length);
                      localObject2 = new dzm();
                      ((dzm)localObject2).parseFrom(paramyh);
                      ((u)localObject1).US(((dzm)localObject2).Gxq);
                      if ((((u)localObject1).Cvy != null) && (((dzm)localObject2).Gxq == ((u)localObject1).Cvy.Gxq) && (!((u)localObject1).wrr.foU()))
                      {
                        ((u)localObject1).Cvy = null;
                        ((u)localObject1).Cvz = 0L;
                        ((u)localObject1).wrr.stopTimer();
                      }
                      paramyh = ((u)localObject1).Cvg;
                      ae.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteNotify, roomId: %s", new Object[] { Integer.valueOf(((dzm)localObject2).Gxq) });
                      if ((paramyh.Cpd.Cso == null) || (((dzm)localObject2).Gxq != paramyh.Cpd.Cso.Gxq)) {
                        continue;
                      }
                      paramyh.eBE();
                      paramyh.Cpd.shutdown();
                    }
                    catch (Exception paramyh)
                    {
                      ae.e("MicroMsg.Voip.VoipService", "onCancelNotify error: %s", new Object[] { paramyh.getMessage() });
                    }
                    continue;
                    localObject1 = c.eys();
                    localObject2 = paramyh.dNE.dNz;
                    if ((!bu.cF((byte[])localObject2)) && (localObject2[0] == 2))
                    {
                      try
                      {
                        ae.i("MicroMsg.Voip.VoipService", "onAnswerNotify");
                        paramyh = new byte[localObject2.length - 1];
                        System.arraycopy(localObject2, 1, paramyh, 0, paramyh.length);
                        localObject2 = new dzm();
                        ((dzm)localObject2).parseFrom(paramyh);
                        paramyh = ((u)localObject1).Cvg;
                        ae.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, roomId: %s", new Object[] { Integer.valueOf(((dzm)localObject2).Gxq) });
                        if (((dzm)localObject2).Gxq != paramyh.Cpd.Cso.Gxq) {
                          continue;
                        }
                        if (!paramyh.Cpd.dFa) {
                          break label1509;
                        }
                        ae.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, already accept, ignore it");
                      }
                      catch (Exception paramyh)
                      {
                        ae.e("MicroMsg.Voip.VoipService", "onAnswerNotify error: %s", new Object[] { paramyh.getMessage() });
                      }
                      continue;
                      label1509:
                      ae.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, not accept, hangout");
                      paramyh.eBE();
                      paramyh.Cpd.shutdown();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.e
 * JD-Core Version:    0.7.0.1
 */