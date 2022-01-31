package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.am.a;
import com.tencent.mm.pluginsdk.f.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.z;

final class x$1$1
  implements com.tencent.mm.vending.c.a<Void, Integer>
{
  x$1$1(x.1 param1) {}
  
  private Void j(Integer paramInteger)
  {
    AppMethodBeat.i(29650);
    this.zcT.zcS.zcL.qa(false);
    this.zcT.zcS.zcL.NW(paramInteger.intValue());
    if ((paramInteger.intValue() <= 0) && (com.tencent.mm.bo.a.dkM()) && (com.tencent.mm.bi.d.alj().bbZ() > 0)) {
      this.zcT.zcS.zcL.qa(true);
    }
    if ((paramInteger.intValue() <= 0) && ((r.Zy() & 0x8000) == 0))
    {
      aw.aaz();
      if (bo.a((Boolean)com.tencent.mm.model.c.Ru().get(68384, null), true))
      {
        aw.aaz();
        if (!bo.isNullOrNil((String)com.tencent.mm.model.c.Ru().get(68377, null)))
        {
          this.zcT.zcS.zcL.qa(true);
          paramInteger = AOo;
          AppMethodBeat.o(29650);
          return paramInteger;
        }
        aw.aaz();
        if (((Boolean)com.tencent.mm.model.c.Ru().get(589825, Boolean.FALSE)).booleanValue())
        {
          this.zcT.zcS.zcL.qa(true);
          paramInteger = AOo;
          AppMethodBeat.o(29650);
          return paramInteger;
        }
        localObject = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKn, null);
        if (localObject == null) {}
        for (long l = 0L; (l != 0L) && (((m)com.tencent.mm.kernel.g.E(m.class)).lh(l)); l = ((Long)localObject).longValue())
        {
          this.zcT.zcS.zcL.qa(true);
          paramInteger = AOo;
          AppMethodBeat.o(29650);
          return paramInteger;
        }
      }
    }
    Object localObject = ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr();
    if (com.tencent.mm.au.b.tM((String)com.tencent.mm.kernel.g.RL().Ru().get(274436, null)))
    {
      ab.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "checkLookVisibility EuropeanUnionCountry");
      if ((((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.welab.a.a.a.class)).ajx("labs_nearbylife")) && (((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.welab.a.a.a.class)).yi("labs_nearbylife")) && (((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKR, Boolean.TRUE)).booleanValue())) {
        this.zcT.zcS.zcL.qa(true);
      }
      if (paramInteger.intValue() > 0) {
        break label623;
      }
      if ((r.Zs() & 0x400000) == 0L) {
        break label610;
      }
      i = 1;
    }
    boolean bool;
    for (;;)
    {
      if ((i == 0) && (!com.tencent.mm.plugin.subapp.jdbiz.d.cGE().cGM()) && (f.vMG != null))
      {
        com.tencent.mm.plugin.subapp.jdbiz.d.cGE();
        bool = com.tencent.mm.plugin.subapp.jdbiz.d.cGG();
        ab.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jdshowFriend ".concat(String.valueOf(bool)));
        if (bool)
        {
          localObject = com.tencent.mm.plugin.subapp.jdbiz.d.cGE().cGJ();
          if ((((com.tencent.mm.plugin.subapp.jdbiz.c)localObject).isStart()) && (!((com.tencent.mm.plugin.subapp.jdbiz.c)localObject).bzK()))
          {
            this.zcT.zcS.zcL.qa(true);
            paramInteger = AOo;
            AppMethodBeat.o(29650);
            return paramInteger;
            if ((localObject == null) || (!((com.tencent.mm.plugin.topstory.a.e)localObject).cIs()) || (!((com.tencent.mm.plugin.topstory.a.e)localObject).cIt()) || (!((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cId())) {
              break;
            }
            this.zcT.zcS.zcL.qa(true);
            break;
            label610:
            i = 0;
            continue;
          }
          ab.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jd time is not start or jd time isExpire");
        }
      }
    }
    label623:
    if ((r.Zs() & 0x2000000) != 0L)
    {
      i = 1;
      if (!com.tencent.mm.plugin.ipcall.d.bIT()) {
        break label946;
      }
      if ((i == 0) && (!this.zcT.zcS.zcL.getShowFriendPoint()) && (paramInteger.intValue() <= 0))
      {
        aw.aaz();
        if (((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yAq, Integer.valueOf(0))).intValue() >= com.tencent.mm.m.g.Nq().getInt("WCOEntranceRedDot", 0))
        {
          aw.aaz();
          if (((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yAs, Boolean.FALSE)).booleanValue() != true) {}
        }
        else
        {
          this.zcT.zcS.zcL.qa(true);
        }
      }
      if ((r.Zs() & 0x200000) == 0L) {
        break label965;
      }
      i = 1;
      label764:
      if (i == 0)
      {
        paramInteger = am.cZF();
        if ((paramInteger.uKa == null) || (!paramInteger.uKa.isValid()) || (paramInteger.uKa.uKf != 1)) {
          break label970;
        }
        i = 1;
        if (i != 0) {
          this.zcT.zcS.zcL.qa(true);
        }
      }
      aw.aaz();
      if ((com.tencent.mm.model.c.Ru().getInt(40, 0) & 0x20000) != 0) {
        break label981;
      }
    }
    label750:
    for (int i = 1;; i = 0)
    {
      if (bo.getInt(com.tencent.mm.m.g.Nq().getValue("VoiceprintEntry"), 0) == 1) {
        aw.aaz();
      }
      for (bool = ((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yyq, Boolean.TRUE)).booleanValue();; bool = false)
      {
        if ((bool) && (i != 0))
        {
          ab.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "show voiceprint dot");
          this.zcT.zcS.zcL.qb(true);
        }
        this.zcT.zcS.zcM = false;
        paramInteger = AOo;
        AppMethodBeat.o(29650);
        return paramInteger;
        i = 0;
        break;
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(ac.a.yAp, Boolean.FALSE);
        break label750;
        i = 0;
        break label764;
        i = 0;
        break label802;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.x.1.1
 * JD-Core Version:    0.7.0.1
 */