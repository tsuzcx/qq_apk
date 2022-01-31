package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.media.AudioManager;
import android.telephony.PhoneStateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.voip.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

final class VoipMgr$5
  extends PhoneStateListener
{
  VoipMgr$5(VoipMgr paramVoipMgr) {}
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    int i = 1;
    AppMethodBeat.i(140144);
    super.onCallStateChanged(paramInt, paramString);
    ab.i("MicroMsg.Voip.VoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(VoipMgr.w(this.tyo)), Integer.valueOf(VoipMgr.x(this.tyo)) });
    if (!VoipMgr.w(this.tyo))
    {
      AppMethodBeat.o(140144);
      return;
    }
    if (((VoipMgr.x(this.tyo) == 0) && (paramInt == 1)) || ((VoipMgr.x(this.tyo) == 0) && (paramInt == 2))) {
      VoipMgr.y(this.tyo);
    }
    if (paramInt == 1)
    {
      VoipMgr.d(this.tyo, true);
      if (VoipMgr.x(this.tyo) == 0) {
        VoipMgr.c(this.tyo, System.currentTimeMillis());
      }
      VoipMgr.e(this.tyo, 1);
      com.tencent.mm.plugin.voip.b.cLC().Hm(1);
      VoipMgr.e(this.tyo, true);
      AppMethodBeat.o(140144);
      return;
    }
    if (paramInt == 2)
    {
      VoipMgr.d(this.tyo, false);
      if (VoipMgr.x(this.tyo) == 1) {
        VoipMgr.d(this.tyo, System.currentTimeMillis());
      }
      VoipMgr.e(this.tyo, 2);
      ab.i("MicroMsg.Voip.VoipMgr", "phone call coming now!");
      if ((VoipMgr.b(this.tyo)) && (!com.tencent.mm.plugin.voip.a.b.HQ(VoipMgr.a(this.tyo).mState)))
      {
        paramString = com.tencent.mm.plugin.voip.b.cLC().tyR;
        ab.i("MicroMsg.Voip.VoipServiceEx", "cancelCallByPhoneInter, roomId:" + paramString.ttm.tvj.nMZ);
        if (paramString.ttm.tvj.nMZ != 0)
        {
          paramString.ttm.tvj.tBN.twb = 102;
          paramString.ttm.tvj.tBN.twn = 6;
          if (com.tencent.mm.plugin.voip.b.cLC().tyS != null)
          {
            paramString.ttm.tvj.tBN.twO = com.tencent.mm.plugin.voip.b.cLC().tyS.txR;
            paramString.ttm.tvj.tBN.twM = (com.tencent.mm.plugin.voip.b.cLC().tyS.twM / 1000L);
            paramString.ttm.tvj.tBN.twN = (com.tencent.mm.plugin.voip.b.cLC().tyS.twN / 1000L);
          }
          com.tencent.mm.plugin.report.service.h.qsU.a(11521, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nMZ), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.tvj.nNa), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().tyR.ttm.cMb()), Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
          paramString.cOg();
        }
      }
      Object localObject;
      label614:
      String str;
      if (com.tencent.mm.plugin.voip.a.b.HQ(VoipMgr.a(this.tyo).mState))
      {
        paramString = ah.getContext().getString(2131304627, new Object[] { VoipMgr.nf(bo.gz(VoipMgr.z(this.tyo))) });
        localObject = com.tencent.mm.plugin.voip.b.cLC().tyR;
        ab.i("MicroMsg.Voip.VoipServiceEx", "hangUpByPhoneInter");
        if (((u)localObject).ttm.tvj.nMZ != 0) {
          break label885;
        }
        ((u)localObject).ttm.tvl.cMp();
        ((u)localObject).reset();
        str = VoipMgr.A(this.tyo).field_username;
        if (!VoipMgr.e(this.tyo)) {
          break label925;
        }
        localObject = bi.yOc;
        label641:
        if (!VoipMgr.b(this.tyo)) {
          break label933;
        }
      }
      label925:
      label933:
      for (paramInt = i;; paramInt = 0)
      {
        r.a(str, (String)localObject, paramInt, 6, paramString);
        VoipMgr.f(this.tyo, 4107);
        VoipMgr.B(this.tyo);
        paramString = new bi();
        paramString.setType(10000);
        paramString.fQ(System.currentTimeMillis());
        paramString.setStatus(6);
        paramString.setContent(ah.getContext().getString(2131304625) + ", <a href=\"weixin://voip/callagain/?username=" + VoipMgr.d(this.tyo) + "&isvideocall=" + VoipMgr.e(this.tyo) + "\">" + ah.getContext().getString(2131304620) + "</a>");
        if ((VoipMgr.d(this.tyo) != null) && (!VoipMgr.d(this.tyo).equals("")))
        {
          paramString.kj(VoipMgr.d(this.tyo));
          ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().Z(paramString);
        }
        com.tencent.mm.plugin.voip.b.cLC().Hm(2);
        VoipMgr.e(this.tyo, false);
        AppMethodBeat.o(140144);
        return;
        paramString = ah.getContext().getString(2131304623);
        break;
        label885:
        ((u)localObject).ttm.tvj.tBN.twb = 109;
        ((u)localObject).ttm.tvj.tBN.twt = 4;
        ((u)localObject).cOj();
        break label614;
        localObject = bi.yOb;
        break label641;
      }
    }
    if (paramInt == 0)
    {
      if ((VoipMgr.x(this.tyo) == 1) || (VoipMgr.x(this.tyo) == 2)) {
        VoipMgr.d(this.tyo, System.currentTimeMillis());
      }
      VoipMgr.e(this.tyo, 0);
      com.tencent.mm.plugin.voip.b.cLC().Hm(2);
      if ((1 == VoipMgr.f(this.tyo)) && (com.tencent.mm.plugin.voip.a.b.HQ(VoipMgr.a(this.tyo).mState)) && (VoipMgr.C(this.tyo))) {
        al.d(new VoipMgr.5.1(this));
      }
      if ((4 == VoipMgr.f(this.tyo)) && (VoipMgr.C(this.tyo))) {
        al.d(new VoipMgr.5.2(this));
      }
      VoipMgr.d(this.tyo, false);
      if ((com.tencent.mm.compatible.b.g.KC() != null) && (com.tencent.mm.compatible.b.g.KC().elW.isBluetoothScoOn()))
      {
        ab.i("MicroMsg.Voip.VoipMgr", "is bluetooth can use and start bluetooth");
        al.d(new VoipMgr.5.3(this));
      }
      VoipMgr.e(this.tyo, false);
    }
    AppMethodBeat.o(140144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.5
 * JD-Core Version:    0.7.0.1
 */