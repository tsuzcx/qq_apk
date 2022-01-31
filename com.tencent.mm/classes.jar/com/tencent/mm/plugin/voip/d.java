package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.ux.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.plugin.voip.model.o.a;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class d
  extends c<ux>
{
  public d()
  {
    AppMethodBeat.i(4318);
    this.__eventId = ux.class.getName().hashCode();
    AppMethodBeat.o(4318);
  }
  
  private static boolean a(ux paramux)
  {
    boolean bool = true;
    int i = 1;
    int j = 1;
    AppMethodBeat.i(4319);
    if ((paramux instanceof ux))
    {
      if (!com.tencent.mm.kernel.g.RG())
      {
        AppMethodBeat.o(4319);
        return false;
      }
      switch (paramux.cLs.cut)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(4319);
      return false;
      paramux.cLt.cLu = b.cLC().cif;
      continue;
      if (com.tencent.mm.r.a.Ok())
      {
        com.tencent.mm.ui.base.h.h(paramux.cLs.context, 2131304703, 2131297087);
      }
      else if (paramux.cLs.cLm == 2)
      {
        r.aV(paramux.cLs.context, paramux.cLs.talker);
      }
      else if (paramux.cLs.cLm == 3)
      {
        r.aW(paramux.cLs.context, paramux.cLs.talker);
      }
      else if (paramux.cLs.cLm == 4)
      {
        r.aX(paramux.cLs.context, paramux.cLs.talker);
        continue;
        Object localObject1 = b.cLC();
        Object localObject2 = paramux.cLs.cLl;
        if ((localObject2 != null) && (localObject2.length >= 10) && (localObject2[0] == 1))
        {
          paramux = new byte[localObject2.length - 1];
          System.arraycopy(localObject2, 1, paramux, 0, paramux.length);
          localObject2 = ((t)localObject1).tyR.ttm.tvj.tBN;
          ((n)localObject2).twH = System.currentTimeMillis();
          com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.VoipDailReport", "devin:recvInvite:" + ((n)localObject2).twH);
          try
          {
            paramux = (csp)new csp().parseFrom(paramux);
            ab.d("MicroMsg.Voip.VoipService", "doTaskCallin in onInviteNotify");
            if (!((t)localObject1).tzg)
            {
              com.tencent.mm.plugin.voip.a.a.c(paramux.wQP, paramux.wQQ, 1, 2);
              ((t)localObject1).tzg = true;
            }
            if (((t)localObject1).tyR.cOc()) {
              break label485;
            }
            com.tencent.mm.plugin.report.service.h.qsU.a(11523, true, true, new Object[] { Integer.valueOf(paramux.wQP), Long.valueOf(paramux.wQQ), Integer.valueOf(paramux.yaX), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
            ((t)localObject1).b(paramux);
          }
          catch (IOException paramux)
          {
            ab.printErrStackTrace("MicroMsg.Voip.VoipService", paramux, "", new Object[0]);
          }
          continue;
          label485:
          com.tencent.mm.plugin.report.service.h.qsU.a(11523, true, true, new Object[] { Integer.valueOf(paramux.wQP), Long.valueOf(paramux.wQQ), Integer.valueOf(paramux.yaX), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
          continue;
          b.cLC();
          localObject1 = t.aeF(paramux.cLs.content);
          if (localObject1 != null) {
            if (((o.a)localObject1).cMy())
            {
              paramux.cLt.type = 2;
            }
            else
            {
              if (((o.a)localObject1).twR == o.a.twY) {}
              for (i = j; i != 0; i = 0)
              {
                paramux.cLt.type = 3;
                break;
              }
              paramux = paramux.cLt;
              localObject1 = b.cLC();
              localObject2 = ah.getContext();
              if ((((t)localObject1).cif) && (((t)localObject1).tzc) && (!((t)localObject1).tzd))
              {
                ab.d("MicroMsg.Voip.VoipService", "isVideoCalling " + ((t)localObject1).tyT + " isAudioCalling " + ((t)localObject1).tyU);
                if ((!bo.isNullOrNil(((t)localObject1).talker)) && (((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(((t)localObject1).talker) != null)) {
                  ((t)localObject1).a((Context)localObject2, ((t)localObject1).talker, true, ((t)localObject1).tyT, true);
                }
              }
              for (;;)
              {
                paramux.cLv = bool;
                break;
                bool = false;
              }
              localObject1 = b.cLC();
              paramux = paramux.cLs.cLl;
              if (paramux == null)
              {
                ab.i("MicroMsg.Voip.VoipService", "sidney:notify content null");
              }
              else
              {
                ab.i("MicroMsg.Voip.VoipService", "____voipNotify with data size:" + paramux.length);
                j = ByteBuffer.wrap(paramux, 0, 4).getInt();
                long l = ByteBuffer.wrap(paramux, 4, 8).getLong();
                ab.i("MicroMsg.Voip.VoipService", "voipNotify roomid:" + j + " roomkey:" + l);
                if (((t)localObject1).tze == null)
                {
                  localObject2 = ((t)localObject1).tyR;
                  ab.i("MicroMsg.Voip.VoipServiceEx", "current roomid:%d, params roomid:%d", new Object[] { Integer.valueOf(((u)localObject2).ttm.tvj.nMZ), Integer.valueOf(j) });
                  if ((j != 0) && (((u)localObject2).ttm.tvj.nMZ == j)) {}
                  for (;;)
                  {
                    if (i != 0) {
                      break label968;
                    }
                    ab.e("MicroMsg.Voip.VoipService", "voipSyncStatus ignored , not current roomid");
                    break;
                    i = 0;
                  }
                }
                label968:
                if (paramux.length > 12) {
                  ((t)localObject1).b(t.T(paramux, paramux.length - 12), j, l);
                }
                paramux = ((t)localObject1).tyR;
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.Ml() + " need doSync by notify, status:" + paramux.ttm.mStatus);
                paramux.ttm.tvm.a(null, false, 7);
                continue;
                localObject1 = b.cLC();
                localObject2 = paramux.cLs.cLl;
                if ((!bo.ce((byte[])localObject2)) && (localObject2[0] == 3))
                {
                  try
                  {
                    ab.i("MicroMsg.Voip.VoipService", "onCancelNotify");
                    paramux = new byte[localObject2.length - 1];
                    System.arraycopy(localObject2, 1, paramux, 0, paramux.length);
                    localObject2 = new csp();
                    ((csp)localObject2).parseFrom(paramux);
                    ((t)localObject1).Hy(((csp)localObject2).wQP);
                    if ((((t)localObject1).tze != null) && (((csp)localObject2).wQP == ((t)localObject1).tze.wQP) && (!((t)localObject1).oTJ.dtj()))
                    {
                      ((t)localObject1).tze = null;
                      ((t)localObject1).tzf = 0L;
                      ((t)localObject1).oTJ.stopTimer();
                    }
                    paramux = ((t)localObject1).tyR;
                    ab.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteNotify, roomId: %s", new Object[] { Integer.valueOf(((csp)localObject2).wQP) });
                    if ((paramux.ttm.tvo == null) || (((csp)localObject2).wQP != paramux.ttm.tvo.wQP)) {
                      continue;
                    }
                    paramux.cOj();
                    paramux.ttm.shutdown();
                  }
                  catch (Exception paramux)
                  {
                    ab.e("MicroMsg.Voip.VoipService", "onCancelNotify error: %s", new Object[] { paramux.getMessage() });
                  }
                  continue;
                  localObject1 = b.cLC();
                  localObject2 = paramux.cLs.cLl;
                  if ((!bo.ce((byte[])localObject2)) && (localObject2[0] == 2))
                  {
                    try
                    {
                      ab.i("MicroMsg.Voip.VoipService", "onAnswerNotify");
                      paramux = new byte[localObject2.length - 1];
                      System.arraycopy(localObject2, 1, paramux, 0, paramux.length);
                      localObject2 = new csp();
                      ((csp)localObject2).parseFrom(paramux);
                      paramux = ((t)localObject1).tyR;
                      ab.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, roomId: %s", new Object[] { Integer.valueOf(((csp)localObject2).wQP) });
                      if (((csp)localObject2).wQP != paramux.ttm.tvo.wQP) {
                        continue;
                      }
                      if (!paramux.ttm.cDO) {
                        break label1453;
                      }
                      ab.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, already accept, ignore it");
                    }
                    catch (Exception paramux)
                    {
                      ab.e("MicroMsg.Voip.VoipService", "onAnswerNotify error: %s", new Object[] { paramux.getMessage() });
                    }
                    continue;
                    label1453:
                    ab.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, not accept, hangout");
                    paramux.cOj();
                    paramux.ttm.shutdown();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.d
 * JD-Core Version:    0.7.0.1
 */