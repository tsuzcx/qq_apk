package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.diz;
import com.tencent.mm.protocal.protobuf.dja;
import com.tencent.mm.protocal.protobuf.djb;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/model/RadarManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "delayRadarRemove", "com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1;", "delayRadarSearch", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "encodeUserNameMap", "", "", "getEncodeUserNameMap", "()Ljava/util/Map;", "setEncodeUserNameMap", "(Ljava/util/Map;)V", "isCancel", "", "lastStateTable", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getLastStateTable", "setLastStateTable", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "locationGeo", "Lcom/tencent/mm/modelgeo/LocationGeo;", "mOnLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "members", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "radarMemberList", "Lcom/tencent/mm/protocal/protobuf/RadarMember;", "getRadarMemberList", "()Ljava/util/LinkedList;", "setRadarMemberList", "(Ljava/util/LinkedList;)V", "sceneRadarRelationChain", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarRelationChain;", "sceneRadarSearch", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "selectedStatusMap", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getSelectedStatusMap", "setSelectedStatusMap", "stateTable", "getStateTable", "setStateTable", "status", "Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "tempLatestChangeStatTable", "", "Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "getTempLatestChangeStatTable", "setTempLatestChangeStatTable", "ticket", "doRadarRelationChain", "", "memList", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "getChooseStatus", "member", "getState", "old", "username", "getStateImpl", "onCreate", "onDestroy", "onLocationGot", "isOk", "onPause", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "onResume", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "putState", "state", "radarRemove", "reset", "saveLastState", "name", "setChooseStatus", "startRadarSearch", "stop", "stopRadarSearch", "syncStateToLastState", "ChooseStatus", "Companion", "LatestChangeStat", "RadarDelegate", "RadarStatus", "Status", "plugin-radar_release"})
public final class e
  implements i
{
  private static final int ByU = 3000;
  private static final int ByV = 5000;
  private static final int ByW = 1;
  public static final e.b ByX;
  private static final String TAG = "MicroMsg.Radar.RadarManager";
  private Location ByI;
  private b ByJ;
  private f ByK;
  public LinkedList<diz> ByL;
  public Map<String, String> ByM;
  private Map<String, c.e> ByN;
  private Map<String, c.e> ByO;
  public Map<Long, c> ByP;
  public Map<String, e.a> ByQ;
  private final MTimerHandler ByR;
  private final e.g ByS;
  private final d ByT;
  private final Context context;
  private String dHx;
  public final b.a gmA;
  public com.tencent.mm.modelgeo.d iOv;
  private boolean ifz;
  private final LinkedList<djb> jfV;
  
  static
  {
    AppMethodBeat.i(138582);
    ByX = new e.b((byte)0);
    TAG = "MicroMsg.Radar.RadarManager";
    ByU = 3000;
    ByV = 5000;
    ByW = 1;
    AppMethodBeat.o(138582);
  }
  
  public e(d paramd, Context paramContext)
  {
    AppMethodBeat.i(138581);
    this.ByT = paramd;
    this.context = paramContext;
    this.ByK = f.Bzj;
    this.jfV = new LinkedList();
    this.ByM = ((Map)new LinkedHashMap());
    this.ByN = ((Map)new LinkedHashMap());
    this.ByO = ((Map)new LinkedHashMap());
    this.ByP = ((Map)new LinkedHashMap());
    this.ByQ = ((Map)new LinkedHashMap());
    this.ByR = new MTimerHandler((MTimerHandler.CallBack)new h(this), false);
    this.ByS = new e.g();
    this.gmA = ((b.a)new i(this));
    AppMethodBeat.o(138581);
  }
  
  private final void a(int paramInt1, int paramInt2, LinkedList<djb> paramLinkedList)
  {
    AppMethodBeat.i(138571);
    this.ByT.a(paramInt1, paramInt2, paramLinkedList);
    AppMethodBeat.o(138571);
  }
  
  private final void b(int paramInt1, int paramInt2, LinkedList<diy> paramLinkedList)
  {
    AppMethodBeat.i(138572);
    this.ByT.b(paramInt1, paramInt2, paramLinkedList);
    AppMethodBeat.o(138572);
  }
  
  private final c.e bX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(138579);
    if (paramBoolean)
    {
      paramString = (c.e)this.ByO.get(paramString);
      AppMethodBeat.o(138579);
      return paramString;
    }
    paramString = (c.e)this.ByN.get(paramString);
    AppMethodBeat.o(138579);
    return paramString;
  }
  
  private final void eHl()
  {
    AppMethodBeat.i(138568);
    this.ByS.sendEmptyMessageDelayed(ByW, ByV);
    AppMethodBeat.o(138568);
  }
  
  public final c.e a(djb paramdjb, boolean paramBoolean)
  {
    AppMethodBeat.i(138576);
    p.h(paramdjb, "member");
    Object localObject = paramdjb.UserName;
    p.g(localObject, "member.UserName");
    c.e locale = bX((String)localObject, paramBoolean);
    localObject = locale;
    if (locale == null)
    {
      paramdjb = paramdjb.LuX;
      p.g(paramdjb, "member.EncodeUserName");
      localObject = bX(paramdjb, paramBoolean);
    }
    AppMethodBeat.o(138576);
    return localObject;
  }
  
  public final void a(djb paramdjb)
  {
    AppMethodBeat.i(138580);
    if (paramdjb != null)
    {
      com.tencent.mm.plugin.radar.ui.g localg = com.tencent.mm.plugin.radar.ui.g.BAY;
      paramdjb = com.tencent.mm.plugin.radar.ui.g.b(paramdjb);
      if (this.ByQ.containsKey(paramdjb))
      {
        this.ByQ.remove(paramdjb);
        AppMethodBeat.o(138580);
        return;
      }
      this.ByQ.put(paramdjb, e.a.ByY);
    }
    AppMethodBeat.o(138580);
  }
  
  public final void a(String paramString, c.e parame)
  {
    AppMethodBeat.i(138574);
    c.e locale = (c.e)this.ByN.get(paramString);
    if ((locale != null) && (locale != parame)) {
      this.ByO.put(paramString, locale);
    }
    AppMethodBeat.o(138574);
  }
  
  public final c.e aKO(String paramString)
  {
    AppMethodBeat.i(138578);
    p.h(paramString, "username");
    paramString = bX(paramString, false);
    AppMethodBeat.o(138578);
    return paramString;
  }
  
  public final void b(String paramString, c.e parame)
  {
    AppMethodBeat.i(138575);
    p.h(paramString, "username");
    p.h(parame, "state");
    if (!n.aL((CharSequence)paramString))
    {
      a(paramString, parame);
      this.ByN.put(paramString, parame);
    }
    AppMethodBeat.o(138575);
  }
  
  public final void eHj()
  {
    AppMethodBeat.i(138566);
    eHk();
    this.ifz = false;
    this.ByI = null;
    this.ByK = f.Bzj;
    this.ByR.stopTimer();
    Log.d(TAG, "start radar");
    if (this.iOv == null) {
      this.iOv = com.tencent.mm.modelgeo.d.bca();
    }
    this.ByK = f.Bzk;
    com.tencent.mm.modelgeo.d locald = this.iOv;
    if (locald != null) {
      locald.b(this.gmA);
    }
    Log.d(TAG, "status: %s", new Object[] { this.ByK });
    AppMethodBeat.o(138566);
  }
  
  public final void eHk()
  {
    AppMethodBeat.i(138567);
    f localf = this.ByK;
    switch (f.$EnumSwitchMapping$0[localf.ordinal()])
    {
    }
    for (;;)
    {
      Log.d(TAG, "stop radar");
      AppMethodBeat.o(138567);
      return;
      AppMethodBeat.o(138567);
      return;
      stop();
      continue;
      if (this.ByJ != null)
      {
        stop();
        com.tencent.mm.kernel.g.azz().a((q)this.ByJ);
        eHl();
        continue;
        stop();
        eHl();
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(138569);
    com.tencent.mm.modelgeo.d locald = this.iOv;
    if (locald != null)
    {
      locald.b(this.gmA);
      AppMethodBeat.o(138569);
      return;
    }
    AppMethodBeat.o(138569);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    djb localdjb = null;
    AppMethodBeat.i(138573);
    p.h(paramq, "scene");
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138573);
      return;
      if (this.ByJ == paramq)
      {
        if (((b)paramq).dJY == 1)
        {
          this.ByK = f.Bzm;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Object localObject = TAG;
            paramString = ((b)paramq).rr;
            int i;
            if (paramString != null)
            {
              paramString = paramString.aYK();
              paramString = (djd)paramString;
              if (paramString == null) {
                break label276;
              }
              i = paramString.gsq;
              label129:
              Log.d((String)localObject, "rader members count: %s ticket: %s", new Object[] { Integer.valueOf(i), this.dHx });
              this.ByR.startTimer(ByU);
              paramString = ((b)paramq).rr;
              if (paramString == null) {
                break label282;
              }
            }
            label276:
            label282:
            for (paramString = paramString.aYK();; paramString = null)
            {
              paramq = (djd)paramString;
              paramString = localdjb;
              if (paramq != null) {
                paramString = paramq.KGQ;
              }
              if (paramString == null) {
                break label287;
              }
              paramq = paramString.iterator();
              while (paramq.hasNext())
              {
                localdjb = (djb)paramq.next();
                localObject = com.tencent.mm.plugin.c.a.bqE();
                p.g(localObject, "PinAntispam.instance()");
                ((com.tencent.mm.plugin.c.a)localObject).aTp().mP(localdjb.UserName, localdjb.LRO);
              }
              paramString = null;
              break;
              i = 0;
              break label129;
            }
            label287:
            if (paramString != null)
            {
              this.jfV.clear();
              this.jfV.addAll((Collection)paramString);
            }
            a(paramInt1, paramInt2, this.jfV);
            Log.d(TAG, "status: %s", new Object[] { this.ByK });
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
        Log.d(TAG, " MMFunc_MMRadarRelationChain ");
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((a)paramq).rr.aYK();
          if (paramString == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarRelationChainResponse");
            AppMethodBeat.o(138573);
            throw paramString;
          }
          paramString = (dja)paramString;
          this.dHx = paramString.Bri;
          if (paramString.gsq > 0)
          {
            b(paramInt1, paramInt2, paramString.KGQ);
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
    this.ifz = true;
    this.ByK = f.Bzj;
    this.ByR.stopTimer();
    AppMethodBeat.o(138570);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-radar_release"})
  public static final class c
  {
    public final djb Bzb;
    public final c.e Bzc;
    
    public c(djb paramdjb, c.e parame)
    {
      AppMethodBeat.i(138552);
      this.Bzb = paramdjb;
      this.Bzc = parame;
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
          if ((!p.j(this.Bzb, paramObject.Bzb)) || (!p.j(this.Bzc, paramObject.Bzc))) {}
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
      Object localObject = this.Bzb;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.Bzc;
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
      String str = "LatestChangeStat(member=" + this.Bzb + ", state=" + this.Bzc + ")";
      AppMethodBeat.o(138553);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "", "onLocationGot", "", "isOk", "", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "plugin-radar_release"})
  public static abstract interface d
  {
    public abstract void a(int paramInt1, int paramInt2, LinkedList<djb> paramLinkedList);
    
    public abstract void b(int paramInt1, int paramInt2, LinkedList<diy> paramLinkedList);
    
    public abstract void sV(boolean paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "", "(Ljava/lang/String;I)V", "SEARCHING", "SEARCH_RETRUN", "RALATIONCHAIN", "RALATIONCHAIN_RETRUN", "CREATING_CHAT", "plugin-radar_release"})
  public static enum e
  {
    static
    {
      AppMethodBeat.i(138556);
      e locale1 = new e("SEARCHING", 0);
      Bzd = locale1;
      e locale2 = new e("SEARCH_RETRUN", 1);
      Bze = locale2;
      e locale3 = new e("RALATIONCHAIN", 2);
      Bzf = locale3;
      e locale4 = new e("RALATIONCHAIN_RETRUN", 3);
      Bzg = locale4;
      e locale5 = new e("CREATING_CHAT", 4);
      Bzh = locale5;
      Bzi = new e[] { locale1, locale2, locale3, locale4, locale5 };
      AppMethodBeat.o(138556);
    }
    
    private e() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "", "(Ljava/lang/String;I)V", "Stopped", "Locating", "RadarSearching", "Waiting", "plugin-radar_release"})
  static enum f
  {
    static
    {
      AppMethodBeat.i(138559);
      f localf1 = new f("Stopped", 0);
      Bzj = localf1;
      f localf2 = new f("Locating", 1);
      Bzk = localf2;
      f localf3 = new f("RadarSearching", 2);
      Bzl = localf3;
      f localf4 = new f("Waiting", 3);
      Bzm = localf4;
      Bzn = new f[] { localf1, localf2, localf3, localf4 };
      AppMethodBeat.o(138559);
    }
    
    private f() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class h
    implements MTimerHandler.CallBack
  {
    h(e parame) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(138564);
      if (!e.a(this.Bzo))
      {
        e.a(this.Bzo, e.f.Bzl);
        Log.d(e.access$getTAG$cp(), "status: %s", new Object[] { e.b(this.Bzo) });
        Object localObject = e.c(this.Bzo);
        if (localObject != null)
        {
          if (((Location)localObject).gnj())
          {
            Log.e(e.access$getTAG$cp(), "error! location is null!");
            AppMethodBeat.o(138564);
            return false;
          }
          Log.d(e.access$getTAG$cp(), "do once search");
          e locale = this.Bzo;
          float f1 = ((Location)localObject).iUY;
          float f2 = ((Location)localObject).iUZ;
          int i = ((Location)localObject).accuracy;
          int j = ((Location)localObject).dTl;
          String str = ((Location)localObject).mac;
          p.g(str, "it.mac");
          localObject = ((Location)localObject).dTn;
          p.g(localObject, "it.cellId");
          e.a(locale, new b(1, f1, f2, i, j, str, (String)localObject));
          com.tencent.mm.kernel.g.azz().b((q)e.d(this.Bzo));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(138564);
        return false;
        Log.e(e.access$getTAG$cp(), "error! location is null!");
        AppMethodBeat.o(138564);
        return false;
        Log.d(e.access$getTAG$cp(), "cancel radar searching");
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "<anonymous parameter 4>", "", "maccuracy", "<anonymous parameter 6>", "onGetLocation"})
  static final class i
    implements b.a
  {
    i(e parame) {}
    
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(138565);
      if (e.a(this.Bzo))
      {
        Log.d(e.access$getTAG$cp(), "cancel location");
        AppMethodBeat.o(138565);
        return false;
      }
      if (e.c(this.Bzo) != null)
      {
        AppMethodBeat.o(138565);
        return false;
      }
      e locale;
      if (paramBoolean)
      {
        locale = this.Bzo;
        e.c(this.Bzo);
        e.a(locale, true);
        o.a(2006, paramFloat1, paramFloat2, (int)paramDouble2);
        Log.d(e.access$getTAG$cp(), "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Double.valueOf(paramDouble2) });
        e.a(this.Bzo, new Location(paramFloat2, paramFloat1, (int)paramDouble2, paramInt, "", ""));
        e.e(this.Bzo).startTimer(0L);
      }
      for (;;)
      {
        AppMethodBeat.o(138565);
        return false;
        locale = this.Bzo;
        e.c(this.Bzo);
        e.a(locale, false);
        e.f(this.Bzo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e
 * JD-Core Version:    0.7.0.1
 */