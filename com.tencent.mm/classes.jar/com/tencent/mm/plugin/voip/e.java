package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.a.zj.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.p.a;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.ett;
import com.tencent.mm.q.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class e
  extends IListener<zj>
{
  public e()
  {
    AppMethodBeat.i(161652);
    this.__eventId = zj.class.getName().hashCode();
    AppMethodBeat.o(161652);
  }
  
  private static boolean a(zj paramzj)
  {
    boolean bool = true;
    int i = 1;
    int j = 1;
    AppMethodBeat.i(114811);
    if ((paramzj instanceof zj))
    {
      if (!g.aAc())
      {
        AppMethodBeat.o(114811);
        return false;
      }
      switch (paramzj.efx.dKy)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114811);
      return false;
      paramzj.efy.calling = c.fFg().dya;
      continue;
      if (a.att()) {
        com.tencent.mm.ui.base.h.n(paramzj.efx.context, 2131767323, 2131755998);
      } else if (!a.cB(paramzj.efx.context)) {
        if (paramzj.efx.eft == 2)
        {
          s.bH(paramzj.efx.context, paramzj.efx.talker);
        }
        else if (paramzj.efx.eft == 3)
        {
          s.bI(paramzj.efx.context, paramzj.efx.talker);
        }
        else if (paramzj.efx.eft == 4)
        {
          s.bJ(paramzj.efx.context, paramzj.efx.talker);
          continue;
          Object localObject1 = c.fFg();
          Object localObject2 = paramzj.efx.efs;
          if ((localObject2 != null) && (localObject2.length >= 10) && (localObject2[0] == 1))
          {
            paramzj = new byte[localObject2.length - 1];
            System.arraycopy(localObject2, 1, paramzj, 0, paramzj.length);
            localObject2 = ((u)localObject1).GYS.GSZ.GVV.Hcw;
            ((o)localObject2).GXI = System.currentTimeMillis();
            com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.VoipDailReport", "devin:recvInvite:" + ((o)localObject2).GXI);
            try
            {
              paramzj = (ett)new ett().parseFrom(paramzj);
              Log.i("MicroMsg.Voip.VoipService", "doTaskCallin in onInviteNotify, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(paramzj.LsZ), Long.valueOf(paramzj.Lta), Integer.valueOf(paramzj.CreateTime) });
              if (!((u)localObject1).GZm)
              {
                com.tencent.mm.plugin.voip.b.e.c(paramzj.LsZ, paramzj.Lta, 1, 2);
                ((u)localObject1).GZm = true;
              }
              if (((u)localObject1).GYS.fIq()) {
                break label527;
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(11523, true, true, new Object[] { Integer.valueOf(paramzj.LsZ), Long.valueOf(paramzj.Lta), Integer.valueOf(paramzj.NqJ), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
              ((u)localObject1).c(paramzj);
            }
            catch (IOException paramzj)
            {
              Log.printErrStackTrace("MicroMsg.Voip.VoipService", paramzj, "", new Object[0]);
            }
            continue;
            label527:
            com.tencent.mm.plugin.report.service.h.CyF.a(11523, true, true, new Object[] { Integer.valueOf(paramzj.LsZ), Long.valueOf(paramzj.Lta), Integer.valueOf(paramzj.NqJ), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
            continue;
            c.fFg();
            localObject1 = u.aUy(paramzj.efx.content);
            if (localObject1 != null) {
              if (((p.a)localObject1).fGY())
              {
                paramzj.efy.type = 2;
              }
              else
              {
                if (((p.a)localObject1).GXQ == p.a.GXX) {}
                for (i = j; i != 0; i = 0)
                {
                  paramzj.efy.type = 3;
                  break;
                }
                paramzj = paramzj.efy;
                localObject1 = c.fFg();
                localObject2 = MMApplicationContext.getContext();
                if ((((u)localObject1).dya) && (((u)localObject1).GZh) && (!((u)localObject1).GZi))
                {
                  Log.d("MicroMsg.Voip.VoipService", "isVideoCalling " + ((u)localObject1).GYU + " isAudioCalling " + ((u)localObject1).GYV);
                  if ((!Util.isNullOrNil(((u)localObject1).talker)) && (((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(((u)localObject1).talker) != null)) {
                    ((u)localObject1).a((Context)localObject2, ((u)localObject1).talker, ((u)localObject1).GYS.GSZ.GVV.ypH, true, ((u)localObject1).GYU, true);
                  }
                }
                for (;;)
                {
                  paramzj.efz = bool;
                  break;
                  bool = false;
                }
                localObject1 = c.fFg();
                paramzj = paramzj.efx.efs;
                if (paramzj == null)
                {
                  Log.i("MicroMsg.Voip.VoipService", "sidney:notify content null");
                }
                else
                {
                  Log.i("MicroMsg.Voip.VoipService", "____voipNotify with data size:" + paramzj.length);
                  j = ByteBuffer.wrap(paramzj, 0, 4).getInt();
                  long l = ByteBuffer.wrap(paramzj, 4, 8).getLong();
                  Log.i("MicroMsg.Voip.VoipService", "voipNotify roomid:" + j + " roomkey:" + l);
                  if (((u)localObject1).GZk == null)
                  {
                    localObject2 = ((u)localObject1).GYS;
                    Log.i("MicroMsg.Voip.VoipServiceEx", "current roomid:%d, params roomid:%d", new Object[] { Integer.valueOf(((v)localObject2).GSZ.GVV.roomId), Integer.valueOf(j) });
                    if ((j != 0) && (((v)localObject2).GSZ.GVV.roomId == j)) {}
                    for (;;)
                    {
                      if (i != 0) {
                        break label1024;
                      }
                      Log.e("MicroMsg.Voip.VoipService", "voipSyncStatus ignored , not current roomid");
                      break;
                      i = 0;
                    }
                  }
                  label1024:
                  if (paramzj.length > 12) {
                    ((u)localObject1).b(u.ae(paramzj, paramzj.length - 12), j, l);
                  }
                  paramzj = ((u)localObject1).GYS;
                  com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipServiceEx", f.apq() + " need doSync by notify, status:" + paramzj.GSZ.mStatus);
                  paramzj.GSZ.GVY.a(null, false, 7);
                  continue;
                  localObject1 = c.fFg();
                  localObject2 = paramzj.efx.efs;
                  if ((!Util.isNullOrNil((byte[])localObject2)) && (localObject2[0] == 3))
                  {
                    try
                    {
                      Log.i("MicroMsg.Voip.VoipService", "onCancelNotify");
                      paramzj = new byte[localObject2.length - 1];
                      System.arraycopy(localObject2, 1, paramzj, 0, paramzj.length);
                      localObject2 = new ett();
                      ((ett)localObject2).parseFrom(paramzj);
                      ((u)localObject1).adm(((ett)localObject2).LsZ);
                      if ((((u)localObject1).GZk != null) && (((ett)localObject2).LsZ == ((u)localObject1).GZk.LsZ) && (!((u)localObject1).zNd.stopped()))
                      {
                        ((u)localObject1).GZk = null;
                        ((u)localObject1).GZl = 0L;
                        ((u)localObject1).zNd.stopTimer();
                      }
                      paramzj = ((u)localObject1).GYS;
                      Log.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteNotify, roomId: %s", new Object[] { Integer.valueOf(((ett)localObject2).LsZ) });
                      if ((paramzj.GSZ.GWa == null) || (((ett)localObject2).LsZ != paramzj.GSZ.GWa.LsZ)) {
                        continue;
                      }
                      paramzj.fIy();
                      paramzj.GSZ.shutdown();
                    }
                    catch (Exception paramzj)
                    {
                      Log.e("MicroMsg.Voip.VoipService", "onCancelNotify error: %s", new Object[] { paramzj.getMessage() });
                    }
                    continue;
                    localObject1 = c.fFg();
                    localObject2 = paramzj.efx.efs;
                    if ((!Util.isNullOrNil((byte[])localObject2)) && (localObject2[0] == 2))
                    {
                      try
                      {
                        Log.i("MicroMsg.Voip.VoipService", "onAnswerNotify");
                        paramzj = new byte[localObject2.length - 1];
                        System.arraycopy(localObject2, 1, paramzj, 0, paramzj.length);
                        localObject2 = new ett();
                        ((ett)localObject2).parseFrom(paramzj);
                        paramzj = ((u)localObject1).GYS;
                        Log.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, roomId: %s", new Object[] { Integer.valueOf(((ett)localObject2).LsZ) });
                        if (((ett)localObject2).LsZ != paramzj.GSZ.GWa.LsZ) {
                          continue;
                        }
                        if (!paramzj.GSZ.dWM) {
                          break label1509;
                        }
                        Log.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, already accept, ignore it");
                      }
                      catch (Exception paramzj)
                      {
                        Log.e("MicroMsg.Voip.VoipService", "onAnswerNotify error: %s", new Object[] { paramzj.getMessage() });
                      }
                      continue;
                      label1509:
                      Log.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, not accept, hangout");
                      paramzj.fIy();
                      paramzj.GSZ.shutdown();
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