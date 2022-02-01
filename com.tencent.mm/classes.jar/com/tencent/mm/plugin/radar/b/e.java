package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.protobuf.clf;
import com.tencent.mm.protocal.protobuf.clg;
import com.tencent.mm.protocal.protobuf.clh;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.clk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import d.g.b.k;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/model/RadarManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "delayRadarRemove", "com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1;", "delayRadarSearch", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "encodeUserNameMap", "", "", "getEncodeUserNameMap", "()Ljava/util/Map;", "setEncodeUserNameMap", "(Ljava/util/Map;)V", "isCancel", "", "lastStateTable", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getLastStateTable", "setLastStateTable", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "locationGeo", "Lcom/tencent/mm/modelgeo/LocationGeo;", "mOnLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "members", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "radarMemberList", "Lcom/tencent/mm/protocal/protobuf/RadarMember;", "getRadarMemberList", "()Ljava/util/LinkedList;", "setRadarMemberList", "(Ljava/util/LinkedList;)V", "sceneRadarRelationChain", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarRelationChain;", "sceneRadarSearch", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "selectedStatusMap", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getSelectedStatusMap", "setSelectedStatusMap", "stateTable", "getStateTable", "setStateTable", "status", "Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "tempLatestChangeStatTable", "", "Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "getTempLatestChangeStatTable", "setTempLatestChangeStatTable", "ticket", "doRadarRelationChain", "", "memList", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "getChooseStatus", "member", "getState", "old", "username", "getStateImpl", "onCreate", "onDestroy", "onLocationGot", "isOk", "onPause", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "onResume", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "putState", "state", "radarRemove", "reset", "saveLastState", "name", "setChooseStatus", "startRadarSearch", "stop", "stopRadarSearch", "syncStateToLastState", "ChooseStatus", "Companion", "LatestChangeStat", "RadarDelegate", "RadarStatus", "Status", "plugin-radar_release"})
public final class e
  implements com.tencent.mm.ak.g
{
  private static final String TAG = "MicroMsg.Radar.RadarManager";
  private static final int wbn = 3000;
  private static final int wbo = 5000;
  private static final int wbp = 1;
  public static final e.b wbq;
  private final Context context;
  private String ddJ;
  public final b.a fnd;
  private boolean gRx;
  private final LinkedList<cli> hOP;
  public d hxT;
  private Location wbb;
  private b wbc;
  private f wbd;
  public LinkedList<clg> wbe;
  public Map<String, String> wbf;
  private Map<String, c.e> wbg;
  private Map<String, c.e> wbh;
  public Map<Long, e.c> wbi;
  public Map<String, e.a> wbj;
  private final au wbk;
  private final e.g wbl;
  private final d wbm;
  
  static
  {
    AppMethodBeat.i(138582);
    wbq = new e.b((byte)0);
    TAG = "MicroMsg.Radar.RadarManager";
    wbn = 3000;
    wbo = 5000;
    wbp = 1;
    AppMethodBeat.o(138582);
  }
  
  public e(d paramd, Context paramContext)
  {
    AppMethodBeat.i(138581);
    this.wbm = paramd;
    this.context = paramContext;
    this.wbd = f.wbC;
    this.hOP = new LinkedList();
    this.wbf = ((Map)new LinkedHashMap());
    this.wbg = ((Map)new LinkedHashMap());
    this.wbh = ((Map)new LinkedHashMap());
    this.wbi = ((Map)new LinkedHashMap());
    this.wbj = ((Map)new LinkedHashMap());
    this.wbk = new au((au.a)new h(this), false);
    this.wbl = new e.g();
    this.fnd = ((b.a)new i(this));
    AppMethodBeat.o(138581);
  }
  
  private final void a(int paramInt1, int paramInt2, LinkedList<cli> paramLinkedList)
  {
    AppMethodBeat.i(138571);
    this.wbm.a(paramInt1, paramInt2, paramLinkedList);
    AppMethodBeat.o(138571);
  }
  
  private final void b(int paramInt1, int paramInt2, LinkedList<clf> paramLinkedList)
  {
    AppMethodBeat.i(138572);
    this.wbm.b(paramInt1, paramInt2, paramLinkedList);
    AppMethodBeat.o(138572);
  }
  
  private final c.e bw(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(138579);
    if (paramBoolean)
    {
      paramString = (c.e)this.wbh.get(paramString);
      AppMethodBeat.o(138579);
      return paramString;
    }
    paramString = (c.e)this.wbg.get(paramString);
    AppMethodBeat.o(138579);
    return paramString;
  }
  
  private final void dsJ()
  {
    AppMethodBeat.i(138568);
    this.wbl.sendEmptyMessageDelayed(wbp, wbo);
    AppMethodBeat.o(138568);
  }
  
  public final c.e a(cli paramcli, boolean paramBoolean)
  {
    AppMethodBeat.i(138576);
    k.h(paramcli, "member");
    Object localObject = paramcli.ncR;
    k.g(localObject, "member.UserName");
    c.e locale = bw((String)localObject, paramBoolean);
    localObject = locale;
    if (locale == null)
    {
      paramcli = paramcli.EyO;
      k.g(paramcli, "member.EncodeUserName");
      localObject = bw(paramcli, paramBoolean);
    }
    AppMethodBeat.o(138576);
    return localObject;
  }
  
  public final void a(cli paramcli)
  {
    AppMethodBeat.i(138580);
    if (paramcli != null)
    {
      com.tencent.mm.plugin.radar.ui.g localg = com.tencent.mm.plugin.radar.ui.g.wdr;
      paramcli = com.tencent.mm.plugin.radar.ui.g.b(paramcli);
      if (this.wbj.containsKey(paramcli))
      {
        this.wbj.remove(paramcli);
        AppMethodBeat.o(138580);
        return;
      }
      this.wbj.put(paramcli, e.a.wbr);
    }
    AppMethodBeat.o(138580);
  }
  
  public final void a(String paramString, c.e parame)
  {
    AppMethodBeat.i(138574);
    c.e locale = (c.e)this.wbg.get(paramString);
    if ((locale != null) && (locale != parame)) {
      this.wbh.put(paramString, locale);
    }
    AppMethodBeat.o(138574);
  }
  
  public final c.e aqi(String paramString)
  {
    AppMethodBeat.i(138578);
    k.h(paramString, "username");
    paramString = bw(paramString, false);
    AppMethodBeat.o(138578);
    return paramString;
  }
  
  public final void b(String paramString, c.e parame)
  {
    AppMethodBeat.i(138575);
    k.h(paramString, "username");
    k.h(parame, "state");
    if (!d.n.n.aD((CharSequence)paramString))
    {
      a(paramString, parame);
      this.wbg.put(paramString, parame);
    }
    AppMethodBeat.o(138575);
  }
  
  public final void dsH()
  {
    AppMethodBeat.i(138566);
    dsI();
    this.gRx = false;
    this.wbb = null;
    this.wbd = f.wbC;
    this.wbk.stopTimer();
    ac.d(TAG, "start radar");
    if (this.hxT == null) {
      this.hxT = d.aEL();
    }
    this.wbd = f.wbD;
    d locald = this.hxT;
    if (locald != null) {
      locald.b(this.fnd);
    }
    ac.d(TAG, "status: %s", new Object[] { this.wbd });
    AppMethodBeat.o(138566);
  }
  
  public final void dsI()
  {
    AppMethodBeat.i(138567);
    f localf = this.wbd;
    switch (f.cfA[localf.ordinal()])
    {
    }
    for (;;)
    {
      ac.d(TAG, "stop radar");
      AppMethodBeat.o(138567);
      return;
      AppMethodBeat.o(138567);
      return;
      stop();
      continue;
      if (this.wbc != null)
      {
        stop();
        com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)this.wbc);
        dsJ();
        continue;
        stop();
        dsJ();
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(138569);
    d locald = this.hxT;
    if (locald != null)
    {
      locald.b(this.fnd);
      AppMethodBeat.o(138569);
      return;
    }
    AppMethodBeat.o(138569);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    cli localcli = null;
    AppMethodBeat.i(138573);
    k.h(paramn, "scene");
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138573);
      return;
      if (this.wbc == paramn)
      {
        if (((b)paramn).dgm == 1)
        {
          this.wbd = f.wbF;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Object localObject = TAG;
            paramString = ((b)paramn).rr;
            int i;
            if (paramString != null)
            {
              paramString = paramString.aBD();
              paramString = (clk)paramString;
              if (paramString == null) {
                break label276;
              }
              i = paramString.fsB;
              label129:
              ac.d((String)localObject, "rader members count: %s ticket: %s", new Object[] { Integer.valueOf(i), this.ddJ });
              this.wbk.Ah(wbn);
              paramString = ((b)paramn).rr;
              if (paramString == null) {
                break label282;
              }
            }
            label276:
            label282:
            for (paramString = paramString.aBD();; paramString = null)
            {
              paramn = (clk)paramString;
              paramString = localcli;
              if (paramn != null) {
                paramString = paramn.DPz;
              }
              if (paramString == null) {
                break label287;
              }
              paramn = paramString.iterator();
              while (paramn.hasNext())
              {
                localcli = (cli)paramn.next();
                localObject = com.tencent.mm.plugin.c.a.aRW();
                k.g(localObject, "PinAntispam.instance()");
                ((com.tencent.mm.plugin.c.a)localObject).axc().lv(localcli.ncR, localcli.ELg);
              }
              paramString = null;
              break;
              i = 0;
              break label129;
            }
            label287:
            if (paramString != null)
            {
              this.hOP.clear();
              this.hOP.addAll((Collection)paramString);
            }
            a(paramInt1, paramInt2, this.hOP);
            ac.d(TAG, "status: %s", new Object[] { this.wbd });
            AppMethodBeat.o(138573);
            return;
          }
          stop();
          a(paramInt1, paramInt2, null);
          AppMethodBeat.o(138573);
          return;
        }
        a(paramInt1, paramInt2, null);
        AppMethodBeat.o(138573);
        return;
        ac.d(TAG, " MMFunc_MMRadarRelationChain ");
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((a)paramn).rr.aBD();
          if (paramString == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarRelationChainResponse");
            AppMethodBeat.o(138573);
            throw paramString;
          }
          paramString = (clh)paramString;
          this.ddJ = paramString.Ewu;
          if (paramString.fsB > 0)
          {
            b(paramInt1, paramInt2, paramString.DPz);
            AppMethodBeat.o(138573);
            return;
          }
          b(paramInt1, paramInt2, null);
          AppMethodBeat.o(138573);
          return;
        }
        b(paramInt1, paramInt2, null);
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(138570);
    this.gRx = true;
    this.wbd = f.wbC;
    this.wbk.stopTimer();
    AppMethodBeat.o(138570);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "", "onLocationGot", "", "isOk", "", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "plugin-radar_release"})
  public static abstract interface d
  {
    public abstract void a(int paramInt1, int paramInt2, LinkedList<cli> paramLinkedList);
    
    public abstract void b(int paramInt1, int paramInt2, LinkedList<clf> paramLinkedList);
    
    public abstract void pf(boolean paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "", "(Ljava/lang/String;I)V", "SEARCHING", "SEARCH_RETRUN", "RALATIONCHAIN", "RALATIONCHAIN_RETRUN", "CREATING_CHAT", "plugin-radar_release"})
  public static enum e
  {
    static
    {
      AppMethodBeat.i(138556);
      e locale1 = new e("SEARCHING", 0);
      wbw = locale1;
      e locale2 = new e("SEARCH_RETRUN", 1);
      wbx = locale2;
      e locale3 = new e("RALATIONCHAIN", 2);
      wby = locale3;
      e locale4 = new e("RALATIONCHAIN_RETRUN", 3);
      wbz = locale4;
      e locale5 = new e("CREATING_CHAT", 4);
      wbA = locale5;
      wbB = new e[] { locale1, locale2, locale3, locale4, locale5 };
      AppMethodBeat.o(138556);
    }
    
    private e() {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "", "(Ljava/lang/String;I)V", "Stopped", "Locating", "RadarSearching", "Waiting", "plugin-radar_release"})
  static enum f
  {
    static
    {
      AppMethodBeat.i(138559);
      f localf1 = new f("Stopped", 0);
      wbC = localf1;
      f localf2 = new f("Locating", 1);
      wbD = localf2;
      f localf3 = new f("RadarSearching", 2);
      wbE = localf3;
      f localf4 = new f("Waiting", 3);
      wbF = localf4;
      wbG = new f[] { localf1, localf2, localf3, localf4 };
      AppMethodBeat.o(138559);
    }
    
    private f() {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class h
    implements au.a
  {
    h(e parame) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(138564);
      if (!e.a(this.wbH))
      {
        e.a(this.wbH, e.f.wbE);
        ac.d(e.access$getTAG$cp(), "status: %s", new Object[] { e.b(this.wbH) });
        Object localObject = e.c(this.wbH);
        if (localObject != null)
        {
          if (((Location)localObject).eLp())
          {
            ac.e(e.access$getTAG$cp(), "error! location is null!");
            AppMethodBeat.o(138564);
            return false;
          }
          ac.d(e.access$getTAG$cp(), "do once search");
          e locale = this.wbH;
          float f1 = ((Location)localObject).hEE;
          float f2 = ((Location)localObject).hEF;
          int i = ((Location)localObject).accuracy;
          int j = ((Location)localObject).doD;
          String str = ((Location)localObject).mac;
          k.g(str, "it.mac");
          localObject = ((Location)localObject).doF;
          k.g(localObject, "it.cellId");
          e.a(locale, new b(1, f1, f2, i, j, str, (String)localObject));
          com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)e.d(this.wbH));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(138564);
        return false;
        ac.e(e.access$getTAG$cp(), "error! location is null!");
        AppMethodBeat.o(138564);
        return false;
        ac.d(e.access$getTAG$cp(), "cancel radar searching");
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "<anonymous parameter 4>", "", "maccuracy", "<anonymous parameter 6>", "onGetLocation"})
  static final class i
    implements b.a
  {
    i(e parame) {}
    
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(138565);
      if (e.a(this.wbH))
      {
        ac.d(e.access$getTAG$cp(), "cancel location");
        AppMethodBeat.o(138565);
        return false;
      }
      if (e.c(this.wbH) != null)
      {
        AppMethodBeat.o(138565);
        return false;
      }
      e locale;
      if (paramBoolean)
      {
        locale = this.wbH;
        e.c(this.wbH);
        e.a(locale, true);
        o.a(2006, paramFloat1, paramFloat2, (int)paramDouble2);
        ac.d(e.access$getTAG$cp(), "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Double.valueOf(paramDouble2) });
        e.a(this.wbH, new Location(paramFloat2, paramFloat1, (int)paramDouble2, paramInt, "", ""));
        e.e(this.wbH).Ah(0L);
      }
      for (;;)
      {
        AppMethodBeat.o(138565);
        return false;
        locale = this.wbH;
        e.c(this.wbH);
        e.a(locale, false);
        e.f(this.wbH);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e
 * JD-Core Version:    0.7.0.1
 */