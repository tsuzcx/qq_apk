package com.tencent.mm.ui;

import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.sns.c.p;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.ar.a;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.g.b.s;

final class ah$1$1
  implements com.tencent.mm.vending.c.a<Void, Integer>
{
  ah$1$1(ah.1 param1) {}
  
  private Void F(Integer paramInteger)
  {
    AppMethodBeat.i(33487);
    Object localObject1 = l.ARA;
    localObject1 = (l.a)l.dZB().getValue();
    if ((localObject1 != null) && (((l.a)localObject1).hBY)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "[FinderDiscoveryTab] result=%s isShow=%s", new Object[] { localObject1, Boolean.valueOf(bool) });
      if ((localObject1 == null) || (((l.a)localObject1).ASg == null) || ((!((l.a)localObject1).hBY) && (((l.a)localObject1).ASg.show_type == 26)))
      {
        Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "result dismiss FinderTextPoint!");
        ah.a(this.adHt.adHs).aX(false, "");
      }
      ah.a(this.adHt.adHs).KT(false);
      ah.a(this.adHt.adHs).azU(paramInteger.intValue());
      if ((paramInteger.intValue() > 0) || ((z.bBf() & 0x8000) != 0)) {
        break label385;
      }
      bh.bCz();
      if (!Util.nullAs((Boolean)com.tencent.mm.model.c.ban().d(68384, null), true)) {
        break label385;
      }
      bh.bCz();
      if (Util.isNullOrNil((String)com.tencent.mm.model.c.ban().d(68377, null))) {
        break;
      }
      ah.a(this.adHt.adHs).KT(true);
      paramInteger = aguz;
      AppMethodBeat.o(33487);
      return paramInteger;
    }
    bh.bCz();
    if (((Boolean)com.tencent.mm.model.c.ban().d(589825, Boolean.FALSE)).booleanValue())
    {
      ah.a(this.adHt.adHs).KT(true);
      paramInteger = aguz;
      AppMethodBeat.o(33487);
      return paramInteger;
    }
    Object localObject2 = h.baE().ban().get(at.a.acWS, null);
    if (localObject2 == null) {}
    for (long l = 0L; (l != 0L) && (((p)h.ax(p.class)).ul(l)); l = ((Long)localObject2).longValue())
    {
      ah.a(this.adHt.adHs).KT(true);
      paramInteger = aguz;
      AppMethodBeat.o(33487);
      return paramInteger;
    }
    label385:
    if (paramInteger.intValue() <= 0)
    {
      if ((z.bAR() & 0x400000) != 0L) {
        i = 1;
      }
      while ((i == 0) && (!com.tencent.mm.plugin.subapp.jdbiz.d.hAI().hAQ()) && (com.tencent.mm.pluginsdk.platformtools.d.XUQ != null))
      {
        com.tencent.mm.plugin.subapp.jdbiz.d.hAI();
        bool = com.tencent.mm.plugin.subapp.jdbiz.d.hAK();
        Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jdshowFriend ".concat(String.valueOf(bool)));
        if (bool)
        {
          paramInteger = com.tencent.mm.plugin.subapp.jdbiz.d.hAI().hAN();
          if ((paramInteger.isStart()) && (!paramInteger.dgl()))
          {
            ah.a(this.adHt.adHs).KT(true);
            paramInteger = aguz;
            AppMethodBeat.o(33487);
            return paramInteger;
            i = 0;
          }
          else
          {
            Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jd time is not start or jd time isExpire");
          }
        }
      }
      paramInteger = ((com.tencent.mm.plugin.topstory.a.b)h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr();
      if (!com.tencent.mm.au.b.OE((String)h.baE().ban().d(274436, null))) {
        break label1030;
      }
      Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "checkLookVisibility EuropeanUnionCountry");
      if ((((com.tencent.mm.plugin.welab.a.a.a)h.ax(com.tencent.mm.plugin.welab.a.a.a.class)).bns("labs_nearbylife")) && (((com.tencent.mm.plugin.welab.a.a.a)h.ax(com.tencent.mm.plugin.welab.a.a.a.class)).UG("labs_nearbylife")) && (((Boolean)h.baE().ban().get(at.a.acXy, Boolean.TRUE)).booleanValue())) {
        ah.a(this.adHt.adHs).KT(true);
      }
      if ((z.bAR() & 0x200000) == 0L) {
        break label1083;
      }
      i = 1;
      label649:
      if (i == 0)
      {
        paramInteger = ar.iqh();
        if ((paramInteger.WpK == null) || (!paramInteger.WpK.isValid()) || (paramInteger.WpK.WpP != 1)) {
          break label1088;
        }
        i = 1;
        label687:
        if (i != 0) {
          ah.a(this.adHt.adHs).KT(true);
        }
      }
      if ((localObject1 != null) && (((l.a)localObject1).hBY) && (!ah.a(this.adHt.adHs).getShowFriendPoint()) && (ah.c(this.adHt.adHs) != null))
      {
        paramInteger = ah.c(this.adHt.adHs);
        s.u(localObject1, "result");
        if (paramInteger.f(((l.a)localObject1).ASh)) {
          paramInteger.ARx.onChanged(localObject1);
        }
      }
      if ((z.bAR() & 0x2000000) == 0L) {
        break label1093;
      }
      i = 1;
      label807:
      if (!com.tencent.mm.plugin.ipcall.d.fQV()) {
        break label1098;
      }
      if ((i == 0) && (!ah.a(this.adHt.adHs).getShowFriendPoint()))
      {
        bh.bCz();
        if (((Integer)com.tencent.mm.model.c.ban().get(at.a.acKM, Integer.valueOf(0))).intValue() >= i.aRC().getInt("WCOEntranceRedDot", 0))
        {
          bh.bCz();
          if (((Boolean)com.tencent.mm.model.c.ban().get(at.a.acKO, Boolean.FALSE)).booleanValue() != true) {}
        }
        else
        {
          ah.a(this.adHt.adHs).KT(true);
        }
      }
    }
    label913:
    bh.bCz();
    if ((com.tencent.mm.model.c.ban().getInt(40, 0) & 0x20000) == 0) {}
    for (int i = 1;; i = 0)
    {
      if (Util.getInt(i.aRC().getValue("VoiceprintEntry"), 0) == 1) {
        bh.bCz();
      }
      for (bool = ((Boolean)com.tencent.mm.model.c.ban().get(at.a.acIJ, Boolean.FALSE)).booleanValue();; bool = false)
      {
        if ((bool) && (i != 0))
        {
          Log.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "show voiceprint dot");
          ah.a(this.adHt.adHs).KU(true);
        }
        ah.a(this.adHt.adHs, false);
        paramInteger = aguz;
        AppMethodBeat.o(33487);
        return paramInteger;
        label1030:
        if ((paramInteger == null) || (!paramInteger.hMx()) || (!((com.tencent.mm.plugin.topstory.a.b)h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMe())) {
          break;
        }
        ah.a(this.adHt.adHs).KT(true);
        break;
        label1083:
        i = 0;
        break label649;
        label1088:
        i = 0;
        break label687;
        label1093:
        i = 0;
        break label807;
        label1098:
        bh.bCz();
        com.tencent.mm.model.c.ban().set(at.a.acKL, Boolean.FALSE);
        break label913;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.ah.1.1
 * JD-Core Version:    0.7.0.1
 */