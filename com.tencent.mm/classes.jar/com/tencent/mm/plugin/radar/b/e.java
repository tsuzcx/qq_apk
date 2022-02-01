package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.protocal.protobuf.cqh;
import com.tencent.mm.protocal.protobuf.cqi;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/model/RadarManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "delayRadarRemove", "com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1;", "delayRadarSearch", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "encodeUserNameMap", "", "", "getEncodeUserNameMap", "()Ljava/util/Map;", "setEncodeUserNameMap", "(Ljava/util/Map;)V", "isCancel", "", "lastStateTable", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getLastStateTable", "setLastStateTable", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "locationGeo", "Lcom/tencent/mm/modelgeo/LocationGeo;", "mOnLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "members", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "radarMemberList", "Lcom/tencent/mm/protocal/protobuf/RadarMember;", "getRadarMemberList", "()Ljava/util/LinkedList;", "setRadarMemberList", "(Ljava/util/LinkedList;)V", "sceneRadarRelationChain", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarRelationChain;", "sceneRadarSearch", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "selectedStatusMap", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getSelectedStatusMap", "setSelectedStatusMap", "stateTable", "getStateTable", "setStateTable", "status", "Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "tempLatestChangeStatTable", "", "Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "getTempLatestChangeStatTable", "setTempLatestChangeStatTable", "ticket", "doRadarRelationChain", "", "memList", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "getChooseStatus", "member", "getState", "old", "username", "getStateImpl", "onCreate", "onDestroy", "onLocationGot", "isOk", "onPause", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "onResume", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "putState", "state", "radarRemove", "reset", "saveLastState", "name", "setChooseStatus", "startRadarSearch", "stop", "stopRadarSearch", "syncStateToLastState", "ChooseStatus", "Companion", "LatestChangeStat", "RadarDelegate", "RadarStatus", "Status", "plugin-radar_release"})
public final class e
  implements f
{
  private static final String TAG = "MicroMsg.Radar.RadarManager";
  private static final int xiW = 3000;
  private static final int xiX = 5000;
  private static final int xiY = 1;
  public static final e.b xiZ;
  private final Context context;
  private String dpf;
  public final b.a fFl;
  public d hQo;
  private boolean hjP;
  private final LinkedList<cqi> iid;
  private Location xiK;
  private b xiL;
  private f xiM;
  public LinkedList<cqg> xiN;
  public Map<String, String> xiO;
  private Map<String, c.e> xiP;
  private Map<String, c.e> xiQ;
  public Map<Long, e.c> xiR;
  public Map<String, e.a> xiS;
  private final av xiT;
  private final g xiU;
  private final d xiV;
  
  static
  {
    AppMethodBeat.i(138582);
    xiZ = new e.b((byte)0);
    TAG = "MicroMsg.Radar.RadarManager";
    xiW = 3000;
    xiX = 5000;
    xiY = 1;
    AppMethodBeat.o(138582);
  }
  
  public e(d paramd, Context paramContext)
  {
    AppMethodBeat.i(138581);
    this.xiV = paramd;
    this.context = paramContext;
    this.xiM = f.xjl;
    this.iid = new LinkedList();
    this.xiO = ((Map)new LinkedHashMap());
    this.xiP = ((Map)new LinkedHashMap());
    this.xiQ = ((Map)new LinkedHashMap());
    this.xiR = ((Map)new LinkedHashMap());
    this.xiS = ((Map)new LinkedHashMap());
    this.xiT = new av((av.a)new h(this), false);
    this.xiU = new g();
    this.fFl = ((b.a)new i(this));
    AppMethodBeat.o(138581);
  }
  
  private final void a(int paramInt1, int paramInt2, LinkedList<cqi> paramLinkedList)
  {
    AppMethodBeat.i(138571);
    this.xiV.a(paramInt1, paramInt2, paramLinkedList);
    AppMethodBeat.o(138571);
  }
  
  private final void b(int paramInt1, int paramInt2, LinkedList<cqf> paramLinkedList)
  {
    AppMethodBeat.i(138572);
    this.xiV.b(paramInt1, paramInt2, paramLinkedList);
    AppMethodBeat.o(138572);
  }
  
  private final c.e bD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(138579);
    if (paramBoolean)
    {
      paramString = (c.e)this.xiQ.get(paramString);
      AppMethodBeat.o(138579);
      return paramString;
    }
    paramString = (c.e)this.xiP.get(paramString);
    AppMethodBeat.o(138579);
    return paramString;
  }
  
  private final void dDg()
  {
    AppMethodBeat.i(138568);
    this.xiU.sendEmptyMessageDelayed(xiY, xiX);
    AppMethodBeat.o(138568);
  }
  
  public final c.e a(cqi paramcqi, boolean paramBoolean)
  {
    AppMethodBeat.i(138576);
    p.h(paramcqi, "member");
    Object localObject = paramcqi.nDo;
    p.g(localObject, "member.UserName");
    c.e locale = bD((String)localObject, paramBoolean);
    localObject = locale;
    if (locale == null)
    {
      paramcqi = paramcqi.GgA;
      p.g(paramcqi, "member.EncodeUserName");
      localObject = bD(paramcqi, paramBoolean);
    }
    AppMethodBeat.o(138576);
    return localObject;
  }
  
  public final void a(cqi paramcqi)
  {
    AppMethodBeat.i(138580);
    if (paramcqi != null)
    {
      com.tencent.mm.plugin.radar.ui.g localg = com.tencent.mm.plugin.radar.ui.g.xla;
      paramcqi = com.tencent.mm.plugin.radar.ui.g.b(paramcqi);
      if (this.xiS.containsKey(paramcqi))
      {
        this.xiS.remove(paramcqi);
        AppMethodBeat.o(138580);
        return;
      }
      this.xiS.put(paramcqi, e.a.xja);
    }
    AppMethodBeat.o(138580);
  }
  
  public final void a(String paramString, c.e parame)
  {
    AppMethodBeat.i(138574);
    c.e locale = (c.e)this.xiP.get(paramString);
    if ((locale != null) && (locale != parame)) {
      this.xiQ.put(paramString, locale);
    }
    AppMethodBeat.o(138574);
  }
  
  public final c.e avh(String paramString)
  {
    AppMethodBeat.i(138578);
    p.h(paramString, "username");
    paramString = bD(paramString, false);
    AppMethodBeat.o(138578);
    return paramString;
  }
  
  public final void b(String paramString, c.e parame)
  {
    AppMethodBeat.i(138575);
    p.h(paramString, "username");
    p.h(parame, "state");
    if (!d.n.n.aE((CharSequence)paramString))
    {
      a(paramString, parame);
      this.xiP.put(paramString, parame);
    }
    AppMethodBeat.o(138575);
  }
  
  public final void dDe()
  {
    AppMethodBeat.i(138566);
    dDf();
    this.hjP = false;
    this.xiK = null;
    this.xiM = f.xjl;
    this.xiT.stopTimer();
    ad.d(TAG, "start radar");
    if (this.hQo == null) {
      this.hQo = d.aHQ();
    }
    this.xiM = f.xjm;
    d locald = this.hQo;
    if (locald != null) {
      locald.b(this.fFl);
    }
    ad.d(TAG, "status: %s", new Object[] { this.xiM });
    AppMethodBeat.o(138566);
  }
  
  public final void dDf()
  {
    AppMethodBeat.i(138567);
    f localf = this.xiM;
    switch (f.cpQ[localf.ordinal()])
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
      if (this.xiL != null)
      {
        stop();
        com.tencent.mm.kernel.g.aiU().a((com.tencent.mm.al.n)this.xiL);
        dDg();
        continue;
        stop();
        dDg();
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(138569);
    d locald = this.hQo;
    if (locald != null)
    {
      locald.b(this.fFl);
      AppMethodBeat.o(138569);
      return;
    }
    AppMethodBeat.o(138569);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    cqi localcqi = null;
    AppMethodBeat.i(138573);
    p.h(paramn, "scene");
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138573);
      return;
      if (this.xiL == paramn)
      {
        if (((b)paramn).drI == 1)
        {
          this.xiM = f.xjo;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Object localObject = TAG;
            paramString = ((b)paramn).rr;
            int i;
            if (paramString != null)
            {
              paramString = paramString.aEF();
              paramString = (cqk)paramString;
              if (paramString == null) {
                break label276;
              }
              i = paramString.fLb;
              label129:
              ad.d((String)localObject, "rader members count: %s ticket: %s", new Object[] { Integer.valueOf(i), this.dpf });
              this.xiT.CX(xiW);
              paramString = ((b)paramn).rr;
              if (paramString == null) {
                break label282;
              }
            }
            label276:
            label282:
            for (paramString = paramString.aEF();; paramString = null)
            {
              paramn = (cqk)paramString;
              paramString = localcqi;
              if (paramn != null) {
                paramString = paramn.FuN;
              }
              if (paramString == null) {
                break label287;
              }
              paramn = paramString.iterator();
              while (paramn.hasNext())
              {
                localcqi = (cqi)paramn.next();
                localObject = com.tencent.mm.plugin.c.a.aVi();
                p.g(localObject, "PinAntispam.instance()");
                ((com.tencent.mm.plugin.c.a)localObject).azR().lU(localcqi.nDo, localcqi.Guj);
              }
              paramString = null;
              break;
              i = 0;
              break label129;
            }
            label287:
            if (paramString != null)
            {
              this.iid.clear();
              this.iid.addAll((Collection)paramString);
            }
            a(paramInt1, paramInt2, this.iid);
            ad.d(TAG, "status: %s", new Object[] { this.xiM });
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
          paramString = ((a)paramn).rr.aEF();
          if (paramString == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarRelationChainResponse");
            AppMethodBeat.o(138573);
            throw paramString;
          }
          paramString = (cqh)paramString;
          this.dpf = paramString.xbo;
          if (paramString.fLb > 0)
          {
            b(paramInt1, paramInt2, paramString.FuN);
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
    this.hjP = true;
    this.xiM = f.xjl;
    this.xiT.stopTimer();
    AppMethodBeat.o(138570);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "", "onLocationGot", "", "isOk", "", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "plugin-radar_release"})
  public static abstract interface d
  {
    public abstract void a(int paramInt1, int paramInt2, LinkedList<cqi> paramLinkedList);
    
    public abstract void b(int paramInt1, int paramInt2, LinkedList<cqf> paramLinkedList);
    
    public abstract void pC(boolean paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "", "(Ljava/lang/String;I)V", "Stopped", "Locating", "RadarSearching", "Waiting", "plugin-radar_release"})
  static enum f
  {
    static
    {
      AppMethodBeat.i(138559);
      f localf1 = new f("Stopped", 0);
      xjl = localf1;
      f localf2 = new f("Locating", 1);
      xjm = localf2;
      f localf3 = new f("RadarSearching", 2);
      xjn = localf3;
      f localf4 = new f("Waiting", 3);
      xjo = localf4;
      xjp = new f[] { localf1, localf2, localf3, localf4 };
      AppMethodBeat.o(138559);
    }
    
    private f() {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class g
    extends ap
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138563);
      p.h(paramMessage, "msg");
      if (paramMessage.what == e.dDh()) {
        com.tencent.mm.kernel.g.aiU().b((com.tencent.mm.al.n)new b());
      }
      AppMethodBeat.o(138563);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onTimerExpired"})
  static final class h
    implements av.a
  {
    h(e parame) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(138564);
      if (!e.a(this.xjq))
      {
        e.a(this.xjq, e.f.xjn);
        ad.d(e.access$getTAG$cp(), "status: %s", new Object[] { e.b(this.xjq) });
        Object localObject = e.c(this.xjq);
        if (localObject != null)
        {
          if (((Location)localObject).fak())
          {
            ad.e(e.access$getTAG$cp(), "error! location is null!");
            AppMethodBeat.o(138564);
            return false;
          }
          ad.d(e.access$getTAG$cp(), "do once search");
          e locale = this.xjq;
          float f1 = ((Location)localObject).hXj;
          float f2 = ((Location)localObject).hXk;
          int i = ((Location)localObject).accuracy;
          int j = ((Location)localObject).dAr;
          String str = ((Location)localObject).mac;
          p.g(str, "it.mac");
          localObject = ((Location)localObject).dAt;
          p.g(localObject, "it.cellId");
          e.a(locale, new b(1, f1, f2, i, j, str, (String)localObject));
          com.tencent.mm.kernel.g.aiU().b((com.tencent.mm.al.n)e.d(this.xjq));
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "<anonymous parameter 4>", "", "maccuracy", "<anonymous parameter 6>", "onGetLocation"})
  static final class i
    implements b.a
  {
    i(e parame) {}
    
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(138565);
      if (e.a(this.xjq))
      {
        ad.d(e.access$getTAG$cp(), "cancel location");
        AppMethodBeat.o(138565);
        return false;
      }
      if (e.c(this.xjq) != null)
      {
        AppMethodBeat.o(138565);
        return false;
      }
      e locale;
      if (paramBoolean)
      {
        locale = this.xjq;
        e.c(this.xjq);
        e.a(locale, true);
        o.a(2006, paramFloat1, paramFloat2, (int)paramDouble2);
        ad.d(e.access$getTAG$cp(), "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Double.valueOf(paramDouble2) });
        e.a(this.xjq, new Location(paramFloat2, paramFloat1, (int)paramDouble2, paramInt, "", ""));
        e.e(this.xjq).CX(0L);
      }
      for (;;)
      {
        AppMethodBeat.o(138565);
        return false;
        locale = this.xjq;
        e.c(this.xjq);
        e.a(locale, false);
        e.f(this.xjq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e
 * JD-Core Version:    0.7.0.1
 */