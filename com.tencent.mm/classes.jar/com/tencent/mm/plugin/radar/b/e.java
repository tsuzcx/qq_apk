package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.protobuf.cqz;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.protocal.protobuf.crb;
import com.tencent.mm.protocal.protobuf.crc;
import com.tencent.mm.protocal.protobuf.cre;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/model/RadarManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "delayRadarRemove", "com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1;", "delayRadarSearch", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "encodeUserNameMap", "", "", "getEncodeUserNameMap", "()Ljava/util/Map;", "setEncodeUserNameMap", "(Ljava/util/Map;)V", "isCancel", "", "lastStateTable", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getLastStateTable", "setLastStateTable", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "locationGeo", "Lcom/tencent/mm/modelgeo/LocationGeo;", "mOnLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "members", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "radarMemberList", "Lcom/tencent/mm/protocal/protobuf/RadarMember;", "getRadarMemberList", "()Ljava/util/LinkedList;", "setRadarMemberList", "(Ljava/util/LinkedList;)V", "sceneRadarRelationChain", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarRelationChain;", "sceneRadarSearch", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "selectedStatusMap", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getSelectedStatusMap", "setSelectedStatusMap", "stateTable", "getStateTable", "setStateTable", "status", "Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "tempLatestChangeStatTable", "", "Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "getTempLatestChangeStatTable", "setTempLatestChangeStatTable", "ticket", "doRadarRelationChain", "", "memList", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "getChooseStatus", "member", "getState", "old", "username", "getStateImpl", "onCreate", "onDestroy", "onLocationGot", "isOk", "onPause", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "onResume", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "putState", "state", "radarRemove", "reset", "saveLastState", "name", "setChooseStatus", "startRadarSearch", "stop", "stopRadarSearch", "syncStateToLastState", "ChooseStatus", "Companion", "LatestChangeStat", "RadarDelegate", "RadarStatus", "Status", "plugin-radar_release"})
public final class e
  implements f
{
  private static final String TAG = "MicroMsg.Radar.RadarManager";
  private static final int xyT = 3000;
  private static final int xyU = 5000;
  private static final int xyV = 1;
  public static final e.b xyW;
  private final Context context;
  private String dqk;
  public final b.a fHp;
  public d hTg;
  private boolean hmD;
  private final LinkedList<crc> ikW;
  private Location xyH;
  private b xyI;
  private f xyJ;
  public LinkedList<cra> xyK;
  public Map<String, String> xyL;
  private Map<String, c.e> xyM;
  private Map<String, c.e> xyN;
  public Map<Long, e.c> xyO;
  public Map<String, e.a> xyP;
  private final aw xyQ;
  private final g xyR;
  private final d xyS;
  
  static
  {
    AppMethodBeat.i(138582);
    xyW = new e.b((byte)0);
    TAG = "MicroMsg.Radar.RadarManager";
    xyT = 3000;
    xyU = 5000;
    xyV = 1;
    AppMethodBeat.o(138582);
  }
  
  public e(d paramd, Context paramContext)
  {
    AppMethodBeat.i(138581);
    this.xyS = paramd;
    this.context = paramContext;
    this.xyJ = f.xzi;
    this.ikW = new LinkedList();
    this.xyL = ((Map)new LinkedHashMap());
    this.xyM = ((Map)new LinkedHashMap());
    this.xyN = ((Map)new LinkedHashMap());
    this.xyO = ((Map)new LinkedHashMap());
    this.xyP = ((Map)new LinkedHashMap());
    this.xyQ = new aw((aw.a)new h(this), false);
    this.xyR = new g();
    this.fHp = ((b.a)new i(this));
    AppMethodBeat.o(138581);
  }
  
  private final void a(int paramInt1, int paramInt2, LinkedList<crc> paramLinkedList)
  {
    AppMethodBeat.i(138571);
    this.xyS.a(paramInt1, paramInt2, paramLinkedList);
    AppMethodBeat.o(138571);
  }
  
  private final void b(int paramInt1, int paramInt2, LinkedList<cqz> paramLinkedList)
  {
    AppMethodBeat.i(138572);
    this.xyS.b(paramInt1, paramInt2, paramLinkedList);
    AppMethodBeat.o(138572);
  }
  
  private final c.e bH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(138579);
    if (paramBoolean)
    {
      paramString = (c.e)this.xyN.get(paramString);
      AppMethodBeat.o(138579);
      return paramString;
    }
    paramString = (c.e)this.xyM.get(paramString);
    AppMethodBeat.o(138579);
    return paramString;
  }
  
  private final void dGx()
  {
    AppMethodBeat.i(138568);
    this.xyR.sendEmptyMessageDelayed(xyV, xyU);
    AppMethodBeat.o(138568);
  }
  
  public final c.e a(crc paramcrc, boolean paramBoolean)
  {
    AppMethodBeat.i(138576);
    p.h(paramcrc, "member");
    Object localObject = paramcrc.nIJ;
    p.g(localObject, "member.UserName");
    c.e locale = bH((String)localObject, paramBoolean);
    localObject = locale;
    if (locale == null)
    {
      paramcrc = paramcrc.Gzj;
      p.g(paramcrc, "member.EncodeUserName");
      localObject = bH(paramcrc, paramBoolean);
    }
    AppMethodBeat.o(138576);
    return localObject;
  }
  
  public final void a(crc paramcrc)
  {
    AppMethodBeat.i(138580);
    if (paramcrc != null)
    {
      com.tencent.mm.plugin.radar.ui.g localg = com.tencent.mm.plugin.radar.ui.g.xAX;
      paramcrc = com.tencent.mm.plugin.radar.ui.g.b(paramcrc);
      if (this.xyP.containsKey(paramcrc))
      {
        this.xyP.remove(paramcrc);
        AppMethodBeat.o(138580);
        return;
      }
      this.xyP.put(paramcrc, e.a.xyX);
    }
    AppMethodBeat.o(138580);
  }
  
  public final void a(String paramString, c.e parame)
  {
    AppMethodBeat.i(138574);
    c.e locale = (c.e)this.xyM.get(paramString);
    if ((locale != null) && (locale != parame)) {
      this.xyN.put(paramString, locale);
    }
    AppMethodBeat.o(138574);
  }
  
  public final c.e aww(String paramString)
  {
    AppMethodBeat.i(138578);
    p.h(paramString, "username");
    paramString = bH(paramString, false);
    AppMethodBeat.o(138578);
    return paramString;
  }
  
  public final void b(String paramString, c.e parame)
  {
    AppMethodBeat.i(138575);
    p.h(paramString, "username");
    p.h(parame, "state");
    if (!d.n.n.aD((CharSequence)paramString))
    {
      a(paramString, parame);
      this.xyM.put(paramString, parame);
    }
    AppMethodBeat.o(138575);
  }
  
  public final void dGv()
  {
    AppMethodBeat.i(138566);
    dGw();
    this.hmD = false;
    this.xyH = null;
    this.xyJ = f.xzi;
    this.xyQ.stopTimer();
    ae.d(TAG, "start radar");
    if (this.hTg == null) {
      this.hTg = d.aIh();
    }
    this.xyJ = f.xzj;
    d locald = this.hTg;
    if (locald != null) {
      locald.b(this.fHp);
    }
    ae.d(TAG, "status: %s", new Object[] { this.xyJ });
    AppMethodBeat.o(138566);
  }
  
  public final void dGw()
  {
    AppMethodBeat.i(138567);
    f localf = this.xyJ;
    switch (f.cqt[localf.ordinal()])
    {
    }
    for (;;)
    {
      ae.d(TAG, "stop radar");
      AppMethodBeat.o(138567);
      return;
      AppMethodBeat.o(138567);
      return;
      stop();
      continue;
      if (this.xyI != null)
      {
        stop();
        com.tencent.mm.kernel.g.ajj().a((com.tencent.mm.ak.n)this.xyI);
        dGx();
        continue;
        stop();
        dGx();
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(138569);
    d locald = this.hTg;
    if (locald != null)
    {
      locald.b(this.fHp);
      AppMethodBeat.o(138569);
      return;
    }
    AppMethodBeat.o(138569);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    crc localcrc = null;
    AppMethodBeat.i(138573);
    p.h(paramn, "scene");
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138573);
      return;
      if (this.xyI == paramn)
      {
        if (((b)paramn).dsO == 1)
        {
          this.xyJ = f.xzl;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Object localObject = TAG;
            paramString = ((b)paramn).rr;
            int i;
            if (paramString != null)
            {
              paramString = paramString.aEV();
              paramString = (cre)paramString;
              if (paramString == null) {
                break label276;
              }
              i = paramString.fNf;
              label129:
              ae.d((String)localObject, "rader members count: %s ticket: %s", new Object[] { Integer.valueOf(i), this.dqk });
              this.xyQ.Dv(xyT);
              paramString = ((b)paramn).rr;
              if (paramString == null) {
                break label282;
              }
            }
            label276:
            label282:
            for (paramString = paramString.aEV();; paramString = null)
            {
              paramn = (cre)paramString;
              paramString = localcrc;
              if (paramn != null) {
                paramString = paramn.FNl;
              }
              if (paramString == null) {
                break label287;
              }
              paramn = paramString.iterator();
              while (paramn.hasNext())
              {
                localcrc = (crc)paramn.next();
                localObject = com.tencent.mm.plugin.c.a.aVH();
                p.g(localObject, "PinAntispam.instance()");
                ((com.tencent.mm.plugin.c.a)localObject).aAh().mb(localcrc.nIJ, localcrc.GNI);
              }
              paramString = null;
              break;
              i = 0;
              break label129;
            }
            label287:
            if (paramString != null)
            {
              this.ikW.clear();
              this.ikW.addAll((Collection)paramString);
            }
            a(paramInt1, paramInt2, this.ikW);
            ae.d(TAG, "status: %s", new Object[] { this.xyJ });
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
        ae.d(TAG, " MMFunc_MMRadarRelationChain ");
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((a)paramn).rr.aEV();
          if (paramString == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarRelationChainResponse");
            AppMethodBeat.o(138573);
            throw paramString;
          }
          paramString = (crb)paramString;
          this.dqk = paramString.xrf;
          if (paramString.fNf > 0)
          {
            b(paramInt1, paramInt2, paramString.FNl);
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
    this.hmD = true;
    this.xyJ = f.xzi;
    this.xyQ.stopTimer();
    AppMethodBeat.o(138570);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "", "onLocationGot", "", "isOk", "", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "plugin-radar_release"})
  public static abstract interface d
  {
    public abstract void a(int paramInt1, int paramInt2, LinkedList<crc> paramLinkedList);
    
    public abstract void b(int paramInt1, int paramInt2, LinkedList<cqz> paramLinkedList);
    
    public abstract void pK(boolean paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "", "(Ljava/lang/String;I)V", "SEARCHING", "SEARCH_RETRUN", "RALATIONCHAIN", "RALATIONCHAIN_RETRUN", "CREATING_CHAT", "plugin-radar_release"})
  public static enum e
  {
    static
    {
      AppMethodBeat.i(138556);
      e locale1 = new e("SEARCHING", 0);
      xzc = locale1;
      e locale2 = new e("SEARCH_RETRUN", 1);
      xzd = locale2;
      e locale3 = new e("RALATIONCHAIN", 2);
      xze = locale3;
      e locale4 = new e("RALATIONCHAIN_RETRUN", 3);
      xzf = locale4;
      e locale5 = new e("CREATING_CHAT", 4);
      xzg = locale5;
      xzh = new e[] { locale1, locale2, locale3, locale4, locale5 };
      AppMethodBeat.o(138556);
    }
    
    private e() {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "", "(Ljava/lang/String;I)V", "Stopped", "Locating", "RadarSearching", "Waiting", "plugin-radar_release"})
  static enum f
  {
    static
    {
      AppMethodBeat.i(138559);
      f localf1 = new f("Stopped", 0);
      xzi = localf1;
      f localf2 = new f("Locating", 1);
      xzj = localf2;
      f localf3 = new f("RadarSearching", 2);
      xzk = localf3;
      f localf4 = new f("Waiting", 3);
      xzl = localf4;
      xzm = new f[] { localf1, localf2, localf3, localf4 };
      AppMethodBeat.o(138559);
    }
    
    private f() {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class g
    extends aq
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138563);
      p.h(paramMessage, "msg");
      if (paramMessage.what == e.dGy()) {
        com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)new b());
      }
      AppMethodBeat.o(138563);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
  static final class h
    implements aw.a
  {
    h(e parame) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(138564);
      if (!e.a(this.xzn))
      {
        e.a(this.xzn, e.f.xzk);
        ae.d(e.access$getTAG$cp(), "status: %s", new Object[] { e.b(this.xzn) });
        Object localObject = e.c(this.xzn);
        if (localObject != null)
        {
          if (((Location)localObject).fdY())
          {
            ae.e(e.access$getTAG$cp(), "error! location is null!");
            AppMethodBeat.o(138564);
            return false;
          }
          ae.d(e.access$getTAG$cp(), "do once search");
          e locale = this.xzn;
          float f1 = ((Location)localObject).iab;
          float f2 = ((Location)localObject).iac;
          int i = ((Location)localObject).accuracy;
          int j = ((Location)localObject).dBw;
          String str = ((Location)localObject).mac;
          p.g(str, "it.mac");
          localObject = ((Location)localObject).dBy;
          p.g(localObject, "it.cellId");
          e.a(locale, new b(1, f1, f2, i, j, str, (String)localObject));
          com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)e.d(this.xzn));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(138564);
        return false;
        ae.e(e.access$getTAG$cp(), "error! location is null!");
        AppMethodBeat.o(138564);
        return false;
        ae.d(e.access$getTAG$cp(), "cancel radar searching");
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "<anonymous parameter 4>", "", "maccuracy", "<anonymous parameter 6>", "onGetLocation"})
  static final class i
    implements b.a
  {
    i(e parame) {}
    
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(138565);
      if (e.a(this.xzn))
      {
        ae.d(e.access$getTAG$cp(), "cancel location");
        AppMethodBeat.o(138565);
        return false;
      }
      if (e.c(this.xzn) != null)
      {
        AppMethodBeat.o(138565);
        return false;
      }
      e locale;
      if (paramBoolean)
      {
        locale = this.xzn;
        e.c(this.xzn);
        e.a(locale, true);
        o.a(2006, paramFloat1, paramFloat2, (int)paramDouble2);
        ae.d(e.access$getTAG$cp(), "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Double.valueOf(paramDouble2) });
        e.a(this.xzn, new Location(paramFloat2, paramFloat1, (int)paramDouble2, paramInt, "", ""));
        e.e(this.xzn).Dv(0L);
      }
      for (;;)
      {
        AppMethodBeat.o(138565);
        return false;
        locale = this.xzn;
        e.c(this.xzn);
        e.a(locale, false);
        e.f(this.xzn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e
 * JD-Core Version:    0.7.0.1
 */