package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.protobuf.cgc;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.protocal.protobuf.cge;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import d.g.b.k;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/model/RadarManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "delayRadarRemove", "com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1;", "delayRadarSearch", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "encodeUserNameMap", "", "", "getEncodeUserNameMap", "()Ljava/util/Map;", "setEncodeUserNameMap", "(Ljava/util/Map;)V", "isCancel", "", "lastStateTable", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getLastStateTable", "setLastStateTable", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "locationGeo", "Lcom/tencent/mm/modelgeo/LocationGeo;", "mOnLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "members", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "radarMemberList", "Lcom/tencent/mm/protocal/protobuf/RadarMember;", "getRadarMemberList", "()Ljava/util/LinkedList;", "setRadarMemberList", "(Ljava/util/LinkedList;)V", "sceneRadarRelationChain", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarRelationChain;", "sceneRadarSearch", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "selectedStatusMap", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getSelectedStatusMap", "setSelectedStatusMap", "stateTable", "getStateTable", "setStateTable", "status", "Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "tempLatestChangeStatTable", "", "Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "getTempLatestChangeStatTable", "setTempLatestChangeStatTable", "ticket", "doRadarRelationChain", "", "memList", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "getChooseStatus", "member", "getState", "old", "username", "getStateImpl", "onCreate", "onDestroy", "onLocationGot", "isOk", "onPause", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "onResume", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "putState", "state", "radarRemove", "reset", "saveLastState", "name", "setChooseStatus", "startRadarSearch", "stop", "stopRadarSearch", "syncStateToLastState", "ChooseStatus", "Companion", "LatestChangeStat", "RadarDelegate", "RadarStatus", "Status", "plugin-radar_release"})
public final class e
  implements com.tencent.mm.al.g
{
  private static final String TAG = "MicroMsg.Radar.RadarManager";
  private static final int uSA = 1;
  public static final e.b uSB;
  private static final int uSy = 3000;
  private static final int uSz = 5000;
  private final Context context;
  private String dgo;
  public final b.a fjJ;
  public d gXu;
  private boolean gqP;
  private final LinkedList<cgf> hom;
  private Location uSm;
  private b uSn;
  private f uSo;
  public LinkedList<cgd> uSp;
  public Map<String, String> uSq;
  private Map<String, c.e> uSr;
  private Map<String, c.e> uSs;
  public Map<Long, c> uSt;
  public Map<String, e.a> uSu;
  private final av uSv;
  private final e.g uSw;
  private final d uSx;
  
  static
  {
    AppMethodBeat.i(138582);
    uSB = new e.b((byte)0);
    TAG = "MicroMsg.Radar.RadarManager";
    uSy = 3000;
    uSz = 5000;
    uSA = 1;
    AppMethodBeat.o(138582);
  }
  
  public e(d paramd, Context paramContext)
  {
    AppMethodBeat.i(138581);
    this.uSx = paramd;
    this.context = paramContext;
    this.uSo = f.uSN;
    this.hom = new LinkedList();
    this.uSq = ((Map)new LinkedHashMap());
    this.uSr = ((Map)new LinkedHashMap());
    this.uSs = ((Map)new LinkedHashMap());
    this.uSt = ((Map)new LinkedHashMap());
    this.uSu = ((Map)new LinkedHashMap());
    this.uSv = new av((av.a)new h(this), false);
    this.uSw = new e.g();
    this.fjJ = ((b.a)new i(this));
    AppMethodBeat.o(138581);
  }
  
  private final void a(int paramInt1, int paramInt2, LinkedList<cgf> paramLinkedList)
  {
    AppMethodBeat.i(138571);
    this.uSx.a(paramInt1, paramInt2, paramLinkedList);
    AppMethodBeat.o(138571);
  }
  
  private final void b(int paramInt1, int paramInt2, LinkedList<cgc> paramLinkedList)
  {
    AppMethodBeat.i(138572);
    this.uSx.b(paramInt1, paramInt2, paramLinkedList);
    AppMethodBeat.o(138572);
  }
  
  private final c.e bp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(138579);
    if (paramBoolean)
    {
      paramString = (c.e)this.uSs.get(paramString);
      AppMethodBeat.o(138579);
      return paramString;
    }
    paramString = (c.e)this.uSr.get(paramString);
    AppMethodBeat.o(138579);
    return paramString;
  }
  
  private final void dfc()
  {
    AppMethodBeat.i(138568);
    this.uSw.sendEmptyMessageDelayed(uSA, uSz);
    AppMethodBeat.o(138568);
  }
  
  public final c.e a(cgf paramcgf, boolean paramBoolean)
  {
    AppMethodBeat.i(138576);
    k.h(paramcgf, "member");
    Object localObject = paramcgf.mAQ;
    k.g(localObject, "member.UserName");
    c.e locale = bp((String)localObject, paramBoolean);
    localObject = locale;
    if (locale == null)
    {
      paramcgf = paramcgf.DfI;
      k.g(paramcgf, "member.EncodeUserName");
      localObject = bp(paramcgf, paramBoolean);
    }
    AppMethodBeat.o(138576);
    return localObject;
  }
  
  public final void a(cgf paramcgf)
  {
    AppMethodBeat.i(138580);
    if (paramcgf != null)
    {
      com.tencent.mm.plugin.radar.ui.g localg = com.tencent.mm.plugin.radar.ui.g.uUC;
      paramcgf = com.tencent.mm.plugin.radar.ui.g.b(paramcgf);
      if (this.uSu.containsKey(paramcgf))
      {
        this.uSu.remove(paramcgf);
        AppMethodBeat.o(138580);
        return;
      }
      this.uSu.put(paramcgf, e.a.uSC);
    }
    AppMethodBeat.o(138580);
  }
  
  public final void a(String paramString, c.e parame)
  {
    AppMethodBeat.i(138574);
    c.e locale = (c.e)this.uSr.get(paramString);
    if ((locale != null) && (locale != parame)) {
      this.uSs.put(paramString, locale);
    }
    AppMethodBeat.o(138574);
  }
  
  public final c.e alj(String paramString)
  {
    AppMethodBeat.i(138578);
    k.h(paramString, "username");
    paramString = bp(paramString, false);
    AppMethodBeat.o(138578);
    return paramString;
  }
  
  public final void b(String paramString, c.e parame)
  {
    AppMethodBeat.i(138575);
    k.h(paramString, "username");
    k.h(parame, "state");
    if (!d.n.n.aC((CharSequence)paramString))
    {
      a(paramString, parame);
      this.uSr.put(paramString, parame);
    }
    AppMethodBeat.o(138575);
  }
  
  public final void dfa()
  {
    AppMethodBeat.i(138566);
    dfb();
    this.gqP = false;
    this.uSm = null;
    this.uSo = f.uSN;
    this.uSv.stopTimer();
    ad.d(TAG, "start radar");
    if (this.gXu == null) {
      this.gXu = d.axT();
    }
    this.uSo = f.uSO;
    d locald = this.gXu;
    if (locald != null) {
      locald.b(this.fjJ);
    }
    ad.d(TAG, "status: %s", new Object[] { this.uSo });
    AppMethodBeat.o(138566);
  }
  
  public final void dfb()
  {
    AppMethodBeat.i(138567);
    f localf = this.uSo;
    switch (f.ciE[localf.ordinal()])
    {
    }
    for (;;)
    {
      ad.d(TAG, "stop radar");
      AppMethodBeat.o(138567);
      return;
      AppMethodBeat.o(138567);
      return;
      stop();
      continue;
      if (this.uSn != null)
      {
        stop();
        com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)this.uSn);
        dfc();
        continue;
        stop();
        dfc();
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(138569);
    d locald = this.gXu;
    if (locald != null)
    {
      locald.b(this.fjJ);
      AppMethodBeat.o(138569);
      return;
    }
    AppMethodBeat.o(138569);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    cgf localcgf = null;
    AppMethodBeat.i(138573);
    k.h(paramn, "scene");
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138573);
      return;
      if (this.uSn == paramn)
      {
        if (((b)paramn).diR == 1)
        {
          this.uSo = f.uSQ;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Object localObject = TAG;
            paramString = ((b)paramn).rr;
            int i;
            if (paramString != null)
            {
              paramString = paramString.auM();
              paramString = (cgh)paramString;
              if (paramString == null) {
                break label276;
              }
              i = paramString.fpb;
              label129:
              ad.d((String)localObject, "rader members count: %s ticket: %s", new Object[] { Integer.valueOf(i), this.dgo });
              this.uSv.vE(uSy);
              paramString = ((b)paramn).rr;
              if (paramString == null) {
                break label282;
              }
            }
            label276:
            label282:
            for (paramString = paramString.auM();; paramString = null)
            {
              paramn = (cgh)paramString;
              paramString = localcgf;
              if (paramn != null) {
                paramString = paramn.Cxd;
              }
              if (paramString == null) {
                break label287;
              }
              paramn = paramString.iterator();
              while (paramn.hasNext())
              {
                localcgf = (cgf)paramn.next();
                localObject = com.tencent.mm.plugin.c.a.aLf();
                k.g(localObject, "PinAntispam.instance()");
                ((com.tencent.mm.plugin.c.a)localObject).aqn().kY(localcgf.mAQ, localcgf.Dqd);
              }
              paramString = null;
              break;
              i = 0;
              break label129;
            }
            label287:
            if (paramString != null)
            {
              this.hom.clear();
              this.hom.addAll((Collection)paramString);
            }
            a(paramInt1, paramInt2, this.hom);
            ad.d(TAG, "status: %s", new Object[] { this.uSo });
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
        ad.d(TAG, " MMFunc_MMRadarRelationChain ");
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((a)paramn).rr.auM();
          if (paramString == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarRelationChainResponse");
            AppMethodBeat.o(138573);
            throw paramString;
          }
          paramString = (cge)paramString;
          this.dgo = paramString.Ddo;
          if (paramString.fpb > 0)
          {
            b(paramInt1, paramInt2, paramString.Cxd);
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
    this.gqP = true;
    this.uSo = f.uSN;
    this.uSv.stopTimer();
    AppMethodBeat.o(138570);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-radar_release"})
  public static final class c
  {
    public final cgf uSF;
    public final c.e uSG;
    
    public c(cgf paramcgf, c.e parame)
    {
      AppMethodBeat.i(138552);
      this.uSF = paramcgf;
      this.uSG = parame;
      AppMethodBeat.o(138552);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(138555);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!k.g(this.uSF, paramObject.uSF)) || (!k.g(this.uSG, paramObject.uSG))) {}
        }
      }
      else
      {
        AppMethodBeat.o(138555);
        return true;
      }
      AppMethodBeat.o(138555);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(138554);
      Object localObject = this.uSF;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.uSG;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(138554);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(138553);
      String str = "LatestChangeStat(member=" + this.uSF + ", state=" + this.uSG + ")";
      AppMethodBeat.o(138553);
      return str;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "", "onLocationGot", "", "isOk", "", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "plugin-radar_release"})
  public static abstract interface d
  {
    public abstract void a(int paramInt1, int paramInt2, LinkedList<cgf> paramLinkedList);
    
    public abstract void b(int paramInt1, int paramInt2, LinkedList<cgc> paramLinkedList);
    
    public abstract void ol(boolean paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "", "(Ljava/lang/String;I)V", "SEARCHING", "SEARCH_RETRUN", "RALATIONCHAIN", "RALATIONCHAIN_RETRUN", "CREATING_CHAT", "plugin-radar_release"})
  public static enum e
  {
    static
    {
      AppMethodBeat.i(138556);
      e locale1 = new e("SEARCHING", 0);
      uSH = locale1;
      e locale2 = new e("SEARCH_RETRUN", 1);
      uSI = locale2;
      e locale3 = new e("RALATIONCHAIN", 2);
      uSJ = locale3;
      e locale4 = new e("RALATIONCHAIN_RETRUN", 3);
      uSK = locale4;
      e locale5 = new e("CREATING_CHAT", 4);
      uSL = locale5;
      uSM = new e[] { locale1, locale2, locale3, locale4, locale5 };
      AppMethodBeat.o(138556);
    }
    
    private e() {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "", "(Ljava/lang/String;I)V", "Stopped", "Locating", "RadarSearching", "Waiting", "plugin-radar_release"})
  static enum f
  {
    static
    {
      AppMethodBeat.i(138559);
      f localf1 = new f("Stopped", 0);
      uSN = localf1;
      f localf2 = new f("Locating", 1);
      uSO = localf2;
      f localf3 = new f("RadarSearching", 2);
      uSP = localf3;
      f localf4 = new f("Waiting", 3);
      uSQ = localf4;
      uSR = new f[] { localf1, localf2, localf3, localf4 };
      AppMethodBeat.o(138559);
    }
    
    private f() {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTimerExpired"})
  static final class h
    implements av.a
  {
    h(e parame) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(138564);
      if (!e.a(this.uSS))
      {
        e.a(this.uSS, e.f.uSP);
        ad.d(e.access$getTAG$cp(), "status: %s", new Object[] { e.b(this.uSS) });
        Object localObject = e.c(this.uSS);
        if (localObject != null)
        {
          if (((Location)localObject).evV())
          {
            ad.e(e.access$getTAG$cp(), "error! location is null!");
            AppMethodBeat.o(138564);
            return false;
          }
          ad.d(e.access$getTAG$cp(), "do once search");
          e locale = this.uSS;
          float f1 = ((Location)localObject).heb;
          float f2 = ((Location)localObject).hec;
          int i = ((Location)localObject).accuracy;
          int j = ((Location)localObject).dqS;
          String str = ((Location)localObject).mac;
          k.g(str, "it.mac");
          localObject = ((Location)localObject).dqU;
          k.g(localObject, "it.cellId");
          e.a(locale, new b(1, f1, f2, i, j, str, (String)localObject));
          com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)e.d(this.uSS));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(138564);
        return false;
        ad.e(e.access$getTAG$cp(), "error! location is null!");
        AppMethodBeat.o(138564);
        return false;
        ad.d(e.access$getTAG$cp(), "cancel radar searching");
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "<anonymous parameter 4>", "", "maccuracy", "<anonymous parameter 6>", "onGetLocation"})
  static final class i
    implements b.a
  {
    i(e parame) {}
    
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(138565);
      if (e.a(this.uSS))
      {
        ad.d(e.access$getTAG$cp(), "cancel location");
        AppMethodBeat.o(138565);
        return false;
      }
      if (e.c(this.uSS) != null)
      {
        AppMethodBeat.o(138565);
        return false;
      }
      e locale;
      if (paramBoolean)
      {
        locale = this.uSS;
        e.c(this.uSS);
        e.a(locale, true);
        o.a(2006, paramFloat1, paramFloat2, (int)paramDouble2);
        ad.d(e.access$getTAG$cp(), "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Double.valueOf(paramDouble2) });
        e.a(this.uSS, new Location(paramFloat2, paramFloat1, (int)paramDouble2, paramInt, "", ""));
        e.e(this.uSS).vE(0L);
      }
      for (;;)
      {
        AppMethodBeat.o(138565);
        return false;
        locale = this.uSS;
        e.c(this.uSS);
        e.a(locale, false);
        e.f(this.uSS);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e
 * JD-Core Version:    0.7.0.1
 */