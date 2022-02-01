package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.acn.a;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.voip.d.c;
import com.tencent.mm.plugin.voip.d.c.a;
import com.tencent.mm.plugin.voip.f.d;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.p.a;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.gaq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import java.io.IOException;
import java.nio.ByteBuffer;

public class VoipEventListener
  extends IListener<acn>
{
  public VoipEventListener()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(161652);
    this.__eventId = acn.class.getName().hashCode();
    AppMethodBeat.o(161652);
  }
  
  private static boolean a(acn paramacn)
  {
    boolean bool = true;
    int i = 1;
    int j = 1;
    AppMethodBeat.i(114811);
    if ((paramacn instanceof acn))
    {
      if (!com.tencent.mm.kernel.h.baz())
      {
        AppMethodBeat.o(114811);
        return false;
      }
      switch (paramacn.ifU.hId)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114811);
      return false;
      paramacn.ifV.calling = SubCoreVoip.hVp().huY;
      continue;
      if (a.aTe()) {
        k.s(paramacn.ifU.context, b.g.voip_multitalk_in_tip, b.g.app_tip);
      } else if (!a.c(paramacn.ifU.context, null)) {
        if (paramacn.ifU.ifQ == 2)
        {
          s.cd(paramacn.ifU.context, paramacn.ifU.talker);
        }
        else if (paramacn.ifU.ifQ == 3)
        {
          s.ce(paramacn.ifU.context, paramacn.ifU.talker);
        }
        else if (paramacn.ifU.ifQ == 4)
        {
          s.cf(paramacn.ifU.context, paramacn.ifU.talker);
          continue;
          Object localObject1 = SubCoreVoip.hVp();
          Object localObject2 = paramacn.ifU.ifP;
          if ((localObject2 != null) && (localObject2.length >= 10) && (localObject2[0] == 1))
          {
            paramacn = new byte[localObject2.length - 1];
            System.arraycopy(localObject2, 1, paramacn, 0, paramacn.length);
            localObject2 = ((u)localObject1).UBE.UvO.UyU.UFN;
            ((o)localObject2).UAN = System.currentTimeMillis();
            g.Logd("MicroMsg.VoipDailReport", "devin:recvInvite:" + ((o)localObject2).UAN);
            try
            {
              paramacn = (gaq)new gaq().parseFrom(paramacn);
              Log.i("MicroMsg.Voip.VoipService", "doTaskCallin in onInviteNotify, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(paramacn.Zvz), Long.valueOf(paramacn.ZvA), Integer.valueOf(paramacn.CreateTime) });
              if (!((u)localObject1).UBZ)
              {
                g.c(paramacn.Zvz, paramacn.ZvA, 1, 2);
                ((u)localObject1).UBZ = true;
              }
              if (((u)localObject1).UBE.hYK()) {
                break label531;
              }
              com.tencent.mm.plugin.report.service.h.OAn.a(11523, true, true, new Object[] { Integer.valueOf(paramacn.Zvz), Long.valueOf(paramacn.ZvA), Integer.valueOf(paramacn.abXQ), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
              ((u)localObject1).c(paramacn);
            }
            catch (IOException paramacn)
            {
              Log.printErrStackTrace("MicroMsg.Voip.VoipService", paramacn, "", new Object[0]);
            }
            continue;
            label531:
            com.tencent.mm.plugin.report.service.h.OAn.a(11523, true, true, new Object[] { Integer.valueOf(paramacn.Zvz), Long.valueOf(paramacn.ZvA), Integer.valueOf(paramacn.abXQ), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
            continue;
            SubCoreVoip.hVp();
            localObject1 = u.bfJ(paramacn.ifU.content);
            if (localObject1 != null) {
              if (((p.a)localObject1).hXi())
              {
                paramacn.ifV.type = 2;
              }
              else
              {
                if (((p.a)localObject1).UBb == p.a.UBi) {}
                for (i = j; i != 0; i = 0)
                {
                  paramacn.ifV.type = 3;
                  break;
                }
                paramacn = paramacn.ifV;
                localObject1 = SubCoreVoip.hVp();
                localObject2 = MMApplicationContext.getContext();
                if ((((u)localObject1).huY) && (((u)localObject1).UBU) && (!((u)localObject1).UBV))
                {
                  Log.d("MicroMsg.Voip.VoipService", "isVideoCalling " + ((u)localObject1).UBG + " isAudioCalling " + ((u)localObject1).UBH);
                  if ((!Util.isNullOrNil(((u)localObject1).talker)) && (((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(((u)localObject1).talker) != null)) {
                    ((u)localObject1).a((Context)localObject2, ((u)localObject1).talker, ((u)localObject1).UBE.UvO.UyU.Hnt, true, ((u)localObject1).UBG, true);
                  }
                }
                for (;;)
                {
                  paramacn.ifW = bool;
                  break;
                  bool = false;
                }
                localObject1 = SubCoreVoip.hVp();
                paramacn = paramacn.ifU.ifP;
                if (paramacn == null)
                {
                  Log.i("MicroMsg.Voip.VoipService", "sidney:notify content null");
                }
                else
                {
                  Log.i("MicroMsg.Voip.VoipService", "____voipNotify with data size:" + paramacn.length);
                  j = ByteBuffer.wrap(paramacn, 0, 4).getInt();
                  long l = ByteBuffer.wrap(paramacn, 4, 8).getLong();
                  Log.i("MicroMsg.Voip.VoipService", "voipNotify roomid:" + j + " roomkey:" + l);
                  if (((u)localObject1).UBX == null)
                  {
                    localObject2 = ((u)localObject1).UBE;
                    Log.i("MicroMsg.Voip.VoipServiceEx", "current roomid:%d, params roomid:%d", new Object[] { Integer.valueOf(((v)localObject2).UvO.UyU.roomId), Integer.valueOf(j) });
                    if ((j != 0) && (((v)localObject2).UvO.UyU.roomId == j)) {}
                    for (;;)
                    {
                      if (i != 0) {
                        break label1028;
                      }
                      Log.e("MicroMsg.Voip.VoipService", "voipSyncStatus ignored , not current roomid");
                      break;
                      i = 0;
                    }
                  }
                  label1028:
                  if (paramacn.length > 12) {
                    ((u)localObject1).b(u.af(paramacn, paramacn.length - 12), j, l);
                  }
                  paramacn = ((u)localObject1).UBE;
                  g.Logi("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.aPX() + " need doSync by notify, status:" + paramacn.UvO.mStatus);
                  paramacn.UvO.UyX.a(null, false, 7);
                  continue;
                  localObject1 = SubCoreVoip.hVp();
                  localObject2 = paramacn.ifU.ifP;
                  if ((!Util.isNullOrNil((byte[])localObject2)) && (localObject2[0] == 3))
                  {
                    for (;;)
                    {
                      try
                      {
                        Log.i("MicroMsg.Voip.VoipService", "onCancelNotify");
                        paramacn = new byte[localObject2.length - 1];
                        System.arraycopy(localObject2, 1, paramacn, 0, paramacn.length);
                        localObject2 = new gaq();
                        ((gaq)localObject2).parseFrom(paramacn);
                        ((u)localObject1).hYm();
                        if ((((u)localObject1).UBX != null) && (((gaq)localObject2).Zvz == ((u)localObject1).UBX.Zvz) && (!((u)localObject1).LoP.stopped()))
                        {
                          ((u)localObject1).UBX = null;
                          ((u)localObject1).UBY = 0L;
                          ((u)localObject1).LoP.stopTimer();
                        }
                        paramacn = ((u)localObject1).UBE;
                        Log.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteNotify, roomId: %s", new Object[] { Integer.valueOf(((gaq)localObject2).Zvz) });
                        if (paramacn.UvO.UyZ != null)
                        {
                          i = ((gaq)localObject2).Zvz;
                          j = paramacn.UvO.UyZ.Zvz;
                          if (i == j) {
                            continue;
                          }
                        }
                      }
                      catch (Exception paramacn)
                      {
                        Log.e("MicroMsg.Voip.VoipService", "onCancelNotify error: %s", new Object[] { paramacn.getMessage() });
                        continue;
                      }
                      if (((u)localObject1).UwR == null) {
                        break;
                      }
                      ((u)localObject1).UwR.hVY();
                      ((u)localObject1).UwR.ged();
                      ((u)localObject1).UwR = null;
                      break;
                      localObject2 = c.UGb;
                      c.a(c.a.UGG);
                      paramacn.hYO();
                      paramacn.UvO.shutdown();
                    }
                    localObject1 = SubCoreVoip.hVp();
                    localObject2 = paramacn.ifU.ifP;
                    if ((!Util.isNullOrNil((byte[])localObject2)) && (localObject2[0] == 2))
                    {
                      try
                      {
                        Log.i("MicroMsg.Voip.VoipService", "onAnswerNotify");
                        paramacn = new byte[localObject2.length - 1];
                        System.arraycopy(localObject2, 1, paramacn, 0, paramacn.length);
                        localObject2 = new gaq();
                        ((gaq)localObject2).parseFrom(paramacn);
                        paramacn = ((u)localObject1).UBE;
                        Log.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, roomId: %s", new Object[] { Integer.valueOf(((gaq)localObject2).Zvz) });
                        if (((gaq)localObject2).Zvz != paramacn.UvO.UyZ.Zvz) {
                          continue;
                        }
                        if (!paramacn.UvO.hWt) {
                          break label1556;
                        }
                        Log.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, already accept, ignore it");
                      }
                      catch (Exception paramacn)
                      {
                        Log.e("MicroMsg.Voip.VoipService", "onAnswerNotify error: %s", new Object[] { paramacn.getMessage() });
                      }
                      continue;
                      label1556:
                      Log.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, not accept, hangout");
                      localObject1 = c.UGb;
                      c.a(c.a.UGG);
                      paramacn.hYO();
                      paramacn.UvO.shutdown();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.VoipEventListener
 * JD-Core Version:    0.7.0.1
 */