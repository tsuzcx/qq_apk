package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.a.xh.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.p.a;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.dsb;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class e
  extends com.tencent.mm.sdk.b.c<xh>
{
  public e()
  {
    AppMethodBeat.i(161652);
    this.__eventId = xh.class.getName().hashCode();
    AppMethodBeat.o(161652);
  }
  
  private static boolean a(xh paramxh)
  {
    boolean bool = true;
    int i = 1;
    int j = 1;
    AppMethodBeat.i(114811);
    if ((paramxh instanceof xh))
    {
      if (!g.agM())
      {
        AppMethodBeat.o(114811);
        return false;
      }
      switch (paramxh.dAb.dgL)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114811);
      return false;
      paramxh.dAc.dAd = c.ehb().cUz;
      continue;
      if (a.aaZ()) {
        com.tencent.mm.ui.base.h.l(paramxh.dAb.context, 2131764884, 2131755906);
      } else if (!a.ch(paramxh.dAb.context)) {
        if (paramxh.dAb.dzX == 2)
        {
          s.bj(paramxh.dAb.context, paramxh.dAb.talker);
        }
        else if (paramxh.dAb.dzX == 3)
        {
          s.bk(paramxh.dAb.context, paramxh.dAb.talker);
        }
        else if (paramxh.dAb.dzX == 4)
        {
          s.bl(paramxh.dAb.context, paramxh.dAb.talker);
          continue;
          Object localObject1 = c.ehb();
          Object localObject2 = paramxh.dAb.dzW;
          if ((localObject2 != null) && (localObject2.length >= 10) && (localObject2[0] == 1))
          {
            paramxh = new byte[localObject2.length - 1];
            System.arraycopy(localObject2, 1, paramxh, 0, paramxh.length);
            localObject2 = ((u)localObject1).AEF.Ayh.ABJ.AIf;
            ((o)localObject2).ADx = System.currentTimeMillis();
            d.Logd("MicroMsg.VoipDailReport", "devin:recvInvite:" + ((o)localObject2).ADx);
            try
            {
              paramxh = (dsb)new dsb().parseFrom(paramxh);
              ac.i("MicroMsg.Voip.VoipService", "doTaskCallin in onInviteNotify, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(paramxh.Exf), Long.valueOf(paramxh.Exg), Integer.valueOf(paramxh.CreateTime) });
              if (!((u)localObject1).AEZ)
              {
                d.c(paramxh.Exf, paramxh.Exg, 1, 2);
                ((u)localObject1).AEZ = true;
              }
              if (((u)localObject1).AEF.ekd()) {
                break label527;
              }
              com.tencent.mm.plugin.report.service.h.wUl.a(11523, true, true, new Object[] { Integer.valueOf(paramxh.Exf), Long.valueOf(paramxh.Exg), Integer.valueOf(paramxh.FZh), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
              ((u)localObject1).c(paramxh);
            }
            catch (IOException paramxh)
            {
              ac.printErrStackTrace("MicroMsg.Voip.VoipService", paramxh, "", new Object[0]);
            }
            continue;
            label527:
            com.tencent.mm.plugin.report.service.h.wUl.a(11523, true, true, new Object[] { Integer.valueOf(paramxh.Exf), Long.valueOf(paramxh.Exg), Integer.valueOf(paramxh.FZh), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
            continue;
            c.ehb();
            localObject1 = u.ayw(paramxh.dAb.content);
            if (localObject1 != null) {
              if (((p.a)localObject1).eiQ())
              {
                paramxh.dAc.type = 2;
              }
              else
              {
                if (((p.a)localObject1).ADG == p.a.ADN) {}
                for (i = j; i != 0; i = 0)
                {
                  paramxh.dAc.type = 3;
                  break;
                }
                paramxh = paramxh.dAc;
                localObject1 = c.ehb();
                localObject2 = ai.getContext();
                if ((((u)localObject1).cUz) && (((u)localObject1).AEU) && (!((u)localObject1).AEV))
                {
                  ac.d("MicroMsg.Voip.VoipService", "isVideoCalling " + ((u)localObject1).AEH + " isAudioCalling " + ((u)localObject1).AEI);
                  if ((!bs.isNullOrNil(((u)localObject1).talker)) && (((k)g.ab(k.class)).awB().aNt(((u)localObject1).talker) != null)) {
                    ((u)localObject1).a((Context)localObject2, ((u)localObject1).talker, true, ((u)localObject1).AEH, true);
                  }
                }
                for (;;)
                {
                  paramxh.dAe = bool;
                  break;
                  bool = false;
                }
                localObject1 = c.ehb();
                paramxh = paramxh.dAb.dzW;
                if (paramxh == null)
                {
                  ac.i("MicroMsg.Voip.VoipService", "sidney:notify content null");
                }
                else
                {
                  ac.i("MicroMsg.Voip.VoipService", "____voipNotify with data size:" + paramxh.length);
                  j = ByteBuffer.wrap(paramxh, 0, 4).getInt();
                  long l = ByteBuffer.wrap(paramxh, 4, 8).getLong();
                  ac.i("MicroMsg.Voip.VoipService", "voipNotify roomid:" + j + " roomkey:" + l);
                  if (((u)localObject1).AEX == null)
                  {
                    localObject2 = ((u)localObject1).AEF;
                    ac.i("MicroMsg.Voip.VoipServiceEx", "current roomid:%d, params roomid:%d", new Object[] { Integer.valueOf(((v)localObject2).Ayh.ABJ.roomId), Integer.valueOf(j) });
                    if ((j != 0) && (((v)localObject2).Ayh.ABJ.roomId == j)) {}
                    for (;;)
                    {
                      if (i != 0) {
                        break label1010;
                      }
                      ac.e("MicroMsg.Voip.VoipService", "voipSyncStatus ignored , not current roomid");
                      break;
                      i = 0;
                    }
                  }
                  label1010:
                  if (paramxh.length > 12) {
                    ((u)localObject1).b(u.W(paramxh, paramxh.length - 12), j, l);
                  }
                  paramxh = ((u)localObject1).AEF;
                  d.Logi("MicroMsg.Voip.VoipServiceEx", f.YG() + " need doSync by notify, status:" + paramxh.Ayh.mStatus);
                  paramxh.Ayh.ABM.a(null, false, 7);
                  continue;
                  localObject1 = c.ehb();
                  localObject2 = paramxh.dAb.dzW;
                  if ((!bs.cv((byte[])localObject2)) && (localObject2[0] == 3))
                  {
                    try
                    {
                      ac.i("MicroMsg.Voip.VoipService", "onCancelNotify");
                      paramxh = new byte[localObject2.length - 1];
                      System.arraycopy(localObject2, 1, paramxh, 0, paramxh.length);
                      localObject2 = new dsb();
                      ((dsb)localObject2).parseFrom(paramxh);
                      ((u)localObject1).St(((dsb)localObject2).Exf);
                      if ((((u)localObject1).AEX != null) && (((dsb)localObject2).Exf == ((u)localObject1).AEX.Exf) && (!((u)localObject1).uXE.eVs()))
                      {
                        ((u)localObject1).AEX = null;
                        ((u)localObject1).AEY = 0L;
                        ((u)localObject1).uXE.stopTimer();
                      }
                      paramxh = ((u)localObject1).AEF;
                      ac.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteNotify, roomId: %s", new Object[] { Integer.valueOf(((dsb)localObject2).Exf) });
                      if ((paramxh.Ayh.ABO == null) || (((dsb)localObject2).Exf != paramxh.Ayh.ABO.Exf)) {
                        continue;
                      }
                      paramxh.ekl();
                      paramxh.Ayh.shutdown();
                    }
                    catch (Exception paramxh)
                    {
                      ac.e("MicroMsg.Voip.VoipService", "onCancelNotify error: %s", new Object[] { paramxh.getMessage() });
                    }
                    continue;
                    localObject1 = c.ehb();
                    localObject2 = paramxh.dAb.dzW;
                    if ((!bs.cv((byte[])localObject2)) && (localObject2[0] == 2))
                    {
                      try
                      {
                        ac.i("MicroMsg.Voip.VoipService", "onAnswerNotify");
                        paramxh = new byte[localObject2.length - 1];
                        System.arraycopy(localObject2, 1, paramxh, 0, paramxh.length);
                        localObject2 = new dsb();
                        ((dsb)localObject2).parseFrom(paramxh);
                        paramxh = ((u)localObject1).AEF;
                        ac.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, roomId: %s", new Object[] { Integer.valueOf(((dsb)localObject2).Exf) });
                        if (((dsb)localObject2).Exf != paramxh.Ayh.ABO.Exf) {
                          continue;
                        }
                        if (!paramxh.Ayh.dsb) {
                          break label1495;
                        }
                        ac.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, already accept, ignore it");
                      }
                      catch (Exception paramxh)
                      {
                        ac.e("MicroMsg.Voip.VoipService", "onAnswerNotify error: %s", new Object[] { paramxh.getMessage() });
                      }
                      continue;
                      label1495:
                      ac.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, not accept, hangout");
                      paramxh.ekl();
                      paramxh.Ayh.shutdown();
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