package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.mm.h.a.td;
import com.tencent.mm.h.a.td.a;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.model.n.a;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.cfe;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class d
  extends c<td>
{
  public d()
  {
    this.udX = td.class.getName().hashCode();
  }
  
  private static boolean a(td paramtd)
  {
    int i = 1;
    int j = 1;
    if ((!(paramtd instanceof td)) || (!com.tencent.mm.kernel.g.DK())) {}
    for (;;)
    {
      return false;
      Object localObject1;
      Object localObject2;
      switch (paramtd.ccJ.bNb)
      {
      case 7: 
      case 8: 
      default: 
        return false;
      case 1: 
        b.bPx();
        localObject1 = r.PZ(paramtd.ccJ.content);
        if (localObject1 != null) {
          if (((n.a)localObject1).bQp())
          {
            paramtd.ccK.type = 2;
            return false;
          }
        }
        break;
      case 2: 
        paramtd.ccK.ccL = b.bPx().bBq;
        return false;
      case 5: 
        if (com.tencent.mm.r.a.Bv())
        {
          com.tencent.mm.ui.base.h.h(paramtd.ccJ.context, a.e.voip_multitalk_in_tip, a.e.app_tip);
          return false;
        }
        if (paramtd.ccJ.ccE == 2)
        {
          q.aL(paramtd.ccJ.context, paramtd.ccJ.talker);
          return false;
        }
        if (paramtd.ccJ.ccE == 3)
        {
          q.aM(paramtd.ccJ.context, paramtd.ccJ.talker);
          return false;
        }
        if (paramtd.ccJ.ccE == 4)
        {
          q.aN(paramtd.ccJ.context, paramtd.ccJ.talker);
          return false;
        }
        break;
      case 3: 
        localObject1 = b.bPx();
        localObject2 = paramtd.ccJ.ccD;
        if ((localObject2 != null) && (localObject2.length >= 10) && (localObject2[0] == 1))
        {
          paramtd = new byte[localObject2.length - 1];
          System.arraycopy(localObject2, 1, paramtd, 0, paramtd.length);
          localObject2 = ((r)localObject1).pTq.pNq.pQe.pWi;
          ((m)localObject2).pRA = System.currentTimeMillis();
          com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.VoipDailReport", "devin:recvInvite:" + ((m)localObject2).pRA);
          try
          {
            paramtd = (cfe)new cfe().aH(paramtd);
            y.d("MicroMsg.Voip.VoipService", "doTaskCallin in onInviteNotify");
            if (!((r)localObject1).pTq.bRp())
            {
              com.tencent.mm.plugin.report.service.h.nFQ.a(11523, true, true, new Object[] { Integer.valueOf(paramtd.sST), Long.valueOf(paramtd.sSU), Integer.valueOf(paramtd.tTG), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
              ((r)localObject1).a(paramtd);
              return false;
            }
          }
          catch (IOException paramtd)
          {
            y.printErrStackTrace("MicroMsg.Voip.VoipService", paramtd, "", new Object[0]);
            return false;
          }
          com.tencent.mm.plugin.report.service.h.nFQ.a(11523, true, true, new Object[] { Integer.valueOf(paramtd.sST), Long.valueOf(paramtd.sSU), Integer.valueOf(paramtd.tTG), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
          return false;
          if (((n.a)localObject1).pRK == n.a.pRR) {}
          for (i = j; i != 0; i = 0)
          {
            paramtd.ccK.type = 3;
            return false;
          }
        }
        break;
      case 4: 
        paramtd = paramtd.ccK;
        localObject1 = b.bPx();
        localObject2 = ae.getContext();
        if ((((r)localObject1).bBq) && (((r)localObject1).pTB) && (!((r)localObject1).pTC))
        {
          y.d("MicroMsg.Voip.VoipService", "isVideoCalling " + ((r)localObject1).pTs + " isAudioCalling " + ((r)localObject1).pTt);
          if ((!bk.bl(((r)localObject1).talker)) && (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(((r)localObject1).talker) != null)) {
            r.a((Context)localObject2, ((r)localObject1).talker, true, ((r)localObject1).pTs, true);
          }
        }
        for (boolean bool = true;; bool = false)
        {
          paramtd.ccM = bool;
          return false;
        }
      case 6: 
        localObject1 = b.bPx();
        paramtd = paramtd.ccJ.ccD;
        if (paramtd == null)
        {
          y.i("MicroMsg.Voip.VoipService", "sidney:notify content null");
          return false;
        }
        y.i("MicroMsg.Voip.VoipService", "____voipNotify with data size:" + paramtd.length);
        j = ByteBuffer.wrap(paramtd, 0, 4).getInt();
        long l = ByteBuffer.wrap(paramtd, 4, 8).getLong();
        y.i("MicroMsg.Voip.VoipService", "voipNotify roomid:" + j + " roomkey:" + l);
        if (((r)localObject1).pTD == null)
        {
          localObject2 = ((r)localObject1).pTq;
          y.i("MicroMsg.Voip.VoipServiceEx", "current roomid:%d, params roomid:%d", new Object[] { Integer.valueOf(((s)localObject2).pNq.pQe.lpD), Integer.valueOf(j) });
          if ((j != 0) && (((s)localObject2).pNq.pQe.lpD == j)) {}
          while (i == 0)
          {
            y.e("MicroMsg.Voip.VoipService", "voipSyncStatus ignored , not current roomid");
            return false;
            i = 0;
          }
        }
        if (paramtd.length > 12) {
          ((r)localObject1).b(r.S(paramtd, paramtd.length - 12), j, l);
        }
        paramtd = ((r)localObject1).pTq;
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.zI() + " need doSync by notify, status:" + paramtd.pNq.mStatus);
        paramtd.pNq.pQh.a(null, false, 7);
        return false;
      case 9: 
        localObject1 = b.bPx();
        localObject2 = paramtd.ccJ.ccD;
        if ((!bk.bE((byte[])localObject2)) && (localObject2[0] == 3)) {
          try
          {
            y.i("MicroMsg.Voip.VoipService", "onCancelNotify");
            paramtd = new byte[localObject2.length - 1];
            System.arraycopy(localObject2, 1, paramtd, 0, paramtd.length);
            localObject2 = new cfe();
            ((cfe)localObject2).aH(paramtd);
            ((r)localObject1).Aj(((cfe)localObject2).sST);
            if ((((r)localObject1).pTD != null) && (((cfe)localObject2).sST == ((r)localObject1).pTD.sST) && (!((r)localObject1).mtV.crl()))
            {
              ((r)localObject1).pTD = null;
              ((r)localObject1).pTE = 0L;
              ((r)localObject1).mtV.stopTimer();
            }
            paramtd = ((r)localObject1).pTq;
            y.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteNotify, roomId: %s", new Object[] { Integer.valueOf(((cfe)localObject2).sST) });
            if ((paramtd.pNq.pQj != null) && (((cfe)localObject2).sST == paramtd.pNq.pQj.sST))
            {
              paramtd.bRu();
              paramtd.pNq.shutdown();
              return false;
            }
          }
          catch (Exception paramtd)
          {
            y.e("MicroMsg.Voip.VoipService", "onCancelNotify error: %s", new Object[] { paramtd.getMessage() });
            return false;
          }
        }
        break;
      case 10: 
        localObject1 = b.bPx();
        localObject2 = paramtd.ccJ.ccD;
        if ((!bk.bE((byte[])localObject2)) && (localObject2[0] == 2)) {
          try
          {
            y.i("MicroMsg.Voip.VoipService", "onAnswerNotify");
            paramtd = new byte[localObject2.length - 1];
            System.arraycopy(localObject2, 1, paramtd, 0, paramtd.length);
            localObject2 = new cfe();
            ((cfe)localObject2).aH(paramtd);
            paramtd = ((r)localObject1).pTq;
            y.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, roomId: %s", new Object[] { Integer.valueOf(((cfe)localObject2).sST) });
            if (((cfe)localObject2).sST == paramtd.pNq.pQj.sST) {
              if (paramtd.pNq.bWb)
              {
                y.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, already accept, ignore it");
                return false;
              }
            }
          }
          catch (Exception paramtd)
          {
            y.e("MicroMsg.Voip.VoipService", "onAnswerNotify error: %s", new Object[] { paramtd.getMessage() });
            return false;
          }
        }
        break;
      }
    }
    y.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, not accept, hangout");
    paramtd.bRu();
    paramtd.pNq.shutdown();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.d
 * JD-Core Version:    0.7.0.1
 */