package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.aaq.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.voip.b.a.a;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.p.a;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.fee;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class e
  extends IListener<aaq>
{
  public e()
  {
    AppMethodBeat.i(161652);
    this.__eventId = aaq.class.getName().hashCode();
    AppMethodBeat.o(161652);
  }
  
  private static boolean a(aaq paramaaq)
  {
    boolean bool = true;
    int i = 1;
    int j = 1;
    AppMethodBeat.i(114811);
    if ((paramaaq instanceof aaq))
    {
      if (!com.tencent.mm.kernel.h.aHB())
      {
        AppMethodBeat.o(114811);
        return false;
      }
      switch (paramaaq.fZM.fDn)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114811);
      return false;
      paramaaq.fZN.calling = c.gxs().fqP;
      continue;
      if (com.tencent.mm.q.a.aAj()) {
        com.tencent.mm.ui.base.h.p(paramaaq.fZM.context, b.g.voip_multitalk_in_tip, b.g.app_tip);
      } else if (!com.tencent.mm.q.a.cx(paramaaq.fZM.context)) {
        if (paramaaq.fZM.fZI == 2)
        {
          s.bS(paramaaq.fZM.context, paramaaq.fZM.talker);
        }
        else if (paramaaq.fZM.fZI == 3)
        {
          s.bT(paramaaq.fZM.context, paramaaq.fZM.talker);
        }
        else if (paramaaq.fZM.fZI == 4)
        {
          s.bU(paramaaq.fZM.context, paramaaq.fZM.talker);
          continue;
          Object localObject1 = c.gxs();
          Object localObject2 = paramaaq.fZM.fZH;
          if ((localObject2 != null) && (localObject2.length >= 10) && (localObject2[0] == 1))
          {
            paramaaq = new byte[localObject2.length - 1];
            System.arraycopy(localObject2, 1, paramaaq, 0, paramaaq.length);
            localObject2 = ((u)localObject1).NPf.NJk.NMi.NSI;
            ((o)localObject2).NNW = System.currentTimeMillis();
            com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.VoipDailReport", "devin:recvInvite:" + ((o)localObject2).NNW);
            try
            {
              paramaaq = (fee)new fee().parseFrom(paramaaq);
              Log.i("MicroMsg.Voip.VoipService", "doTaskCallin in onInviteNotify, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(paramaaq.Svu), Long.valueOf(paramaaq.Svv), Integer.valueOf(paramaaq.CreateTime) });
              if (!((u)localObject1).NPA)
              {
                com.tencent.mm.plugin.voip.c.e.c(paramaaq.Svu, paramaaq.Svv, 1, 2);
                ((u)localObject1).NPA = true;
              }
              if (((u)localObject1).NPf.gAK()) {
                break label530;
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(11523, true, true, new Object[] { Integer.valueOf(paramaaq.Svu), Long.valueOf(paramaaq.Svv), Integer.valueOf(paramaaq.UDF), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
              ((u)localObject1).c(paramaaq);
            }
            catch (IOException paramaaq)
            {
              Log.printErrStackTrace("MicroMsg.Voip.VoipService", paramaaq, "", new Object[0]);
            }
            continue;
            label530:
            com.tencent.mm.plugin.report.service.h.IzE.a(11523, true, true, new Object[] { Integer.valueOf(paramaaq.Svu), Long.valueOf(paramaaq.Svv), Integer.valueOf(paramaaq.UDF), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
            continue;
            c.gxs();
            localObject1 = u.bge(paramaaq.fZM.content);
            if (localObject1 != null) {
              if (((p.a)localObject1).gzm())
              {
                paramaaq.fZN.type = 2;
              }
              else
              {
                if (((p.a)localObject1).NOe == p.a.NOl) {}
                for (i = j; i != 0; i = 0)
                {
                  paramaaq.fZN.type = 3;
                  break;
                }
                paramaaq = paramaaq.fZN;
                localObject1 = c.gxs();
                localObject2 = MMApplicationContext.getContext();
                if ((((u)localObject1).fqP) && (((u)localObject1).NPv) && (!((u)localObject1).NPw))
                {
                  Log.d("MicroMsg.Voip.VoipService", "isVideoCalling " + ((u)localObject1).NPh + " isAudioCalling " + ((u)localObject1).NPi);
                  if ((!Util.isNullOrNil(((u)localObject1).talker)) && (((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(((u)localObject1).talker) != null)) {
                    ((u)localObject1).a((Context)localObject2, ((u)localObject1).talker, ((u)localObject1).NPf.NJk.NMi.DPJ, true, ((u)localObject1).NPh, true);
                  }
                }
                for (;;)
                {
                  paramaaq.fZO = bool;
                  break;
                  bool = false;
                }
                localObject1 = c.gxs();
                paramaaq = paramaaq.fZM.fZH;
                if (paramaaq == null)
                {
                  Log.i("MicroMsg.Voip.VoipService", "sidney:notify content null");
                }
                else
                {
                  Log.i("MicroMsg.Voip.VoipService", "____voipNotify with data size:" + paramaaq.length);
                  j = ByteBuffer.wrap(paramaaq, 0, 4).getInt();
                  long l = ByteBuffer.wrap(paramaaq, 4, 8).getLong();
                  Log.i("MicroMsg.Voip.VoipService", "voipNotify roomid:" + j + " roomkey:" + l);
                  if (((u)localObject1).NPy == null)
                  {
                    localObject2 = ((u)localObject1).NPf;
                    Log.i("MicroMsg.Voip.VoipServiceEx", "current roomid:%d, params roomid:%d", new Object[] { Integer.valueOf(((v)localObject2).NJk.NMi.roomId), Integer.valueOf(j) });
                    if ((j != 0) && (((v)localObject2).NJk.NMi.roomId == j)) {}
                    for (;;)
                    {
                      if (i != 0) {
                        break label1027;
                      }
                      Log.e("MicroMsg.Voip.VoipService", "voipSyncStatus ignored , not current roomid");
                      break;
                      i = 0;
                    }
                  }
                  label1027:
                  if (paramaaq.length > 12) {
                    ((u)localObject1).b(u.af(paramaaq, paramaaq.length - 12), j, l);
                  }
                  paramaaq = ((u)localObject1).NPf;
                  com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipServiceEx", f.avD() + " need doSync by notify, status:" + paramaaq.NJk.mStatus);
                  paramaaq.NJk.NMl.a(null, false, 7);
                  continue;
                  localObject1 = c.gxs();
                  localObject2 = paramaaq.fZM.fZH;
                  if ((!Util.isNullOrNil((byte[])localObject2)) && (localObject2[0] == 3))
                  {
                    try
                    {
                      Log.i("MicroMsg.Voip.VoipService", "onCancelNotify");
                      paramaaq = new byte[localObject2.length - 1];
                      System.arraycopy(localObject2, 1, paramaaq, 0, paramaaq.length);
                      localObject2 = new fee();
                      ((fee)localObject2).parseFrom(paramaaq);
                      ((u)localObject1).gAg();
                      if ((((u)localObject1).NPy != null) && (((fee)localObject2).Svu == ((u)localObject1).NPy.Svu) && (!((u)localObject1).Fsy.stopped()))
                      {
                        ((u)localObject1).NPy = null;
                        ((u)localObject1).NPz = 0L;
                        ((u)localObject1).Fsy.stopTimer();
                      }
                      paramaaq = ((u)localObject1).NPf;
                      Log.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteNotify, roomId: %s", new Object[] { Integer.valueOf(((fee)localObject2).Svu) });
                      if ((paramaaq.NJk.NMn == null) || (((fee)localObject2).Svu != paramaaq.NJk.NMn.Svu)) {
                        continue;
                      }
                      localObject1 = com.tencent.mm.plugin.voip.b.a.NTi;
                      com.tencent.mm.plugin.voip.b.a.a(a.a.NTl);
                      paramaaq.gAO();
                      paramaaq.NJk.shutdown();
                    }
                    catch (Exception paramaaq)
                    {
                      Log.e("MicroMsg.Voip.VoipService", "onCancelNotify error: %s", new Object[] { paramaaq.getMessage() });
                    }
                    continue;
                    localObject1 = c.gxs();
                    localObject2 = paramaaq.fZM.fZH;
                    if ((!Util.isNullOrNil((byte[])localObject2)) && (localObject2[0] == 2))
                    {
                      try
                      {
                        Log.i("MicroMsg.Voip.VoipService", "onAnswerNotify");
                        paramaaq = new byte[localObject2.length - 1];
                        System.arraycopy(localObject2, 1, paramaaq, 0, paramaaq.length);
                        localObject2 = new fee();
                        ((fee)localObject2).parseFrom(paramaaq);
                        paramaaq = ((u)localObject1).NPf;
                        Log.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, roomId: %s", new Object[] { Integer.valueOf(((fee)localObject2).Svu) });
                        if (((fee)localObject2).Svu != paramaaq.NJk.NMn.Svu) {
                          continue;
                        }
                        if (!paramaaq.NJk.fQy) {
                          break label1518;
                        }
                        Log.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, already accept, ignore it");
                      }
                      catch (Exception paramaaq)
                      {
                        Log.e("MicroMsg.Voip.VoipService", "onAnswerNotify error: %s", new Object[] { paramaaq.getMessage() });
                      }
                      continue;
                      label1518:
                      Log.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, not accept, hangout");
                      localObject1 = com.tencent.mm.plugin.voip.b.a.NTi;
                      com.tencent.mm.plugin.voip.b.a.a(a.a.NTl);
                      paramaaq.gAO();
                      paramaaq.NJk.shutdown();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.e
 * JD-Core Version:    0.7.0.1
 */