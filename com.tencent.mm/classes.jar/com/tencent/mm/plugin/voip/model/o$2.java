package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.telephony.PhoneStateListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.plugin.voip.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

final class o$2
  extends PhoneStateListener
{
  o$2(o paramo) {}
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    int i = 1;
    super.onCallStateChanged(paramInt, paramString);
    y.i("MicroMsg.Voip.VoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(o.o(this.pSP)), Integer.valueOf(o.p(this.pSP)) });
    if (!o.o(this.pSP)) {}
    label585:
    label612:
    label882:
    label890:
    do
    {
      return;
      if (((o.p(this.pSP) == 0) && (paramInt == 1)) || ((o.p(this.pSP) == 0) && (paramInt == 2))) {
        o.q(this.pSP);
      }
      if (paramInt == 1)
      {
        o.d(this.pSP, true);
        if (o.p(this.pSP) == 0) {
          o.a(this.pSP, System.currentTimeMillis());
        }
        o.c(this.pSP, 1);
        com.tencent.mm.plugin.voip.b.bPx().Am(1);
        return;
      }
      if (paramInt == 2)
      {
        o.d(this.pSP, false);
        if (o.p(this.pSP) == 1) {
          o.b(this.pSP, System.currentTimeMillis());
        }
        o.c(this.pSP, 2);
        y.i("MicroMsg.Voip.VoipMgr", "phone call coming now!");
        if ((o.b(this.pSP)) && (!com.tencent.mm.plugin.voip.a.b.Aw(o.a(this.pSP).mState)))
        {
          paramString = com.tencent.mm.plugin.voip.b.bPx().pTq;
          y.i("MicroMsg.Voip.VoipServiceEx", "cancelCallByPhoneInter, roomId:" + paramString.pNq.pQe.lpD);
          if (paramString.pNq.pQe.lpD != 0)
          {
            paramString.pNq.pQe.pWi.pQU = 102;
            paramString.pNq.pQe.pWi.pRg = 6;
            if (com.tencent.mm.plugin.voip.b.bPx().pTr != null)
            {
              paramString.pNq.pQe.pWi.pRH = com.tencent.mm.plugin.voip.b.bPx().pTr.pSI;
              paramString.pNq.pQe.pWi.pRF = (com.tencent.mm.plugin.voip.b.bPx().pTr.pRF / 1000L);
              paramString.pNq.pQe.pWi.pRG = (com.tencent.mm.plugin.voip.b.bPx().pTr.pRG / 1000L);
            }
            h.nFQ.a(11521, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpD), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().pTq.pNq.pQe.lpE), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
            paramString.bRs();
          }
        }
        Object localObject;
        String str;
        if (com.tencent.mm.plugin.voip.a.b.Aw(o.a(this.pSP).mState))
        {
          paramString = ae.getContext().getString(a.e.voip_call_msg_chat_time, new Object[] { o.gJ(bk.cn(o.r(this.pSP))) });
          localObject = com.tencent.mm.plugin.voip.b.bPx().pTq;
          y.i("MicroMsg.Voip.VoipServiceEx", "hangUpByPhoneInter");
          if (((s)localObject).pNq.pQe.lpD != 0) {
            break label842;
          }
          ((s)localObject).pNq.pQg.bQl();
          ((s)localObject).reset();
          str = o.s(this.pSP).field_username;
          if (!o.e(this.pSP)) {
            break label882;
          }
          localObject = bi.uBQ;
          if (!o.b(this.pSP)) {
            break label890;
          }
        }
        for (paramInt = i;; paramInt = 0)
        {
          q.a(str, (String)localObject, paramInt, 6, paramString);
          o.d(this.pSP, 4107);
          o.t(this.pSP);
          paramString = new bi();
          paramString.setType(10000);
          paramString.bg(System.currentTimeMillis());
          paramString.setStatus(6);
          paramString.setContent(ae.getContext().getString(a.e.voip_call_interrupted_by_other_app) + ", <a href=\"weixin://voip/callagain/?username=" + o.d(this.pSP) + "&isvideocall=" + o.e(this.pSP) + "\">" + ae.getContext().getString(a.e.voip_call_again) + "</a>");
          if ((o.d(this.pSP) != null) && (!o.d(this.pSP).equals("")))
          {
            paramString.ec(o.d(this.pSP));
            ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().T(paramString);
          }
          com.tencent.mm.plugin.voip.b.bPx().Am(2);
          return;
          paramString = ae.getContext().getString(a.e.voip_call_connection_failed);
          break;
          ((s)localObject).pNq.pQe.pWi.pQU = 109;
          ((s)localObject).pNq.pQe.pWi.pRm = 4;
          ((s)localObject).bRu();
          break label585;
          localObject = bi.uBP;
          break label612;
        }
      }
    } while (paramInt != 0);
    label842:
    if ((o.p(this.pSP) == 1) || (o.p(this.pSP) == 2)) {
      o.b(this.pSP, System.currentTimeMillis());
    }
    o.c(this.pSP, 0);
    com.tencent.mm.plugin.voip.b.bPx().Am(2);
    if ((1 == o.f(this.pSP)) && (com.tencent.mm.plugin.voip.a.b.Aw(o.a(this.pSP).mState)) && (o.u(this.pSP))) {
      o.b(this.pSP, true);
    }
    o.d(this.pSP, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.o.2
 * JD-Core Version:    0.7.0.1
 */