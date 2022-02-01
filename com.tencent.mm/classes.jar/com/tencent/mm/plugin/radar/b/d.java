package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.protobuf.dsq;
import com.tencent.mm.protocal.protobuf.dss;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.g;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/model/RadarManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "delayRadarRemove", "com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1;", "delayRadarSearch", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "encodeUserNameMap", "", "", "getEncodeUserNameMap", "()Ljava/util/Map;", "setEncodeUserNameMap", "(Ljava/util/Map;)V", "isCancel", "", "lastStateTable", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getLastStateTable", "setLastStateTable", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "locationGeo", "Lcom/tencent/mm/modelgeo/LocationGeo;", "mOnLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "members", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "radarMemberList", "Lcom/tencent/mm/protocal/protobuf/RadarMember;", "getRadarMemberList", "()Ljava/util/LinkedList;", "setRadarMemberList", "(Ljava/util/LinkedList;)V", "sceneRadarRelationChain", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarRelationChain;", "sceneRadarSearch", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "selectedStatusMap", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getSelectedStatusMap", "setSelectedStatusMap", "stateTable", "getStateTable", "setStateTable", "status", "Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "tempLatestChangeStatTable", "", "Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "getTempLatestChangeStatTable", "setTempLatestChangeStatTable", "ticket", "doRadarRelationChain", "", "memList", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "getChooseStatus", "member", "getState", "old", "username", "getStateImpl", "onCreate", "onDestroy", "onLocationGot", "isOk", "onPause", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "onResume", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "putState", "state", "radarRemove", "reset", "saveLastState", "name", "setChooseStatus", "startRadarSearch", "stop", "stopRadarSearch", "syncStateToLastState", "ChooseStatus", "Companion", "LatestChangeStat", "RadarDelegate", "RadarStatus", "Status", "plugin-radar_release"})
public final class d
  implements i
{
  private static final int Huq = 3000;
  private static final int Hur = 5000;
  private static final int Hus = 1;
  public static final d.b Hut;
  private static final String TAG = "MicroMsg.Radar.RadarManager";
  private Location Huf;
  private a Hug;
  private f Huh;
  public Map<String, String> Hui;
  private Map<String, b.e> Huj;
  private Map<String, b.e> Huk;
  public Map<Long, d.c> Hul;
  public Map<String, d.a> Hum;
  private final MTimerHandler Hun;
  private final g Huo;
  private final d Hup;
  private final Context context;
  private String fAo;
  public final b.a iQJ;
  private boolean kUn;
  public com.tencent.mm.modelgeo.d lEL;
  private final LinkedList<dsq> lWw;
  
  static
  {
    AppMethodBeat.i(138582);
    Hut = new d.b((byte)0);
    TAG = "MicroMsg.Radar.RadarManager";
    Huq = 3000;
    Hur = 5000;
    Hus = 1;
    AppMethodBeat.o(138582);
  }
  
  public d(d paramd, Context paramContext)
  {
    AppMethodBeat.i(138581);
    this.Hup = paramd;
    this.context = paramContext;
    this.Huh = f.HuF;
    this.lWw = new LinkedList();
    this.Hui = ((Map)new LinkedHashMap());
    this.Huj = ((Map)new LinkedHashMap());
    this.Huk = ((Map)new LinkedHashMap());
    this.Hul = ((Map)new LinkedHashMap());
    this.Hum = ((Map)new LinkedHashMap());
    this.Hun = new MTimerHandler((MTimerHandler.CallBack)new h(this), false);
    this.Huo = new g();
    this.iQJ = ((b.a)new i(this));
    AppMethodBeat.o(138581);
  }
  
  private final void a(int paramInt1, int paramInt2, LinkedList<dsq> paramLinkedList)
  {
    AppMethodBeat.i(138571);
    this.Hup.a(paramInt1, paramInt2, paramLinkedList);
    AppMethodBeat.o(138571);
  }
  
  private final b.e ch(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(138579);
    if (paramBoolean)
    {
      paramString = (b.e)this.Huk.get(paramString);
      AppMethodBeat.o(138579);
      return paramString;
    }
    paramString = (b.e)this.Huj.get(paramString);
    AppMethodBeat.o(138579);
    return paramString;
  }
  
  private final void ftp()
  {
    AppMethodBeat.i(138568);
    this.Huo.sendEmptyMessageDelayed(Hus, Hur);
    AppMethodBeat.o(138568);
  }
  
  public final b.e a(dsq paramdsq, boolean paramBoolean)
  {
    AppMethodBeat.i(138576);
    p.k(paramdsq, "member");
    Object localObject = paramdsq.UserName;
    p.j(localObject, "member.UserName");
    b.e locale = ch((String)localObject, paramBoolean);
    localObject = locale;
    if (locale == null)
    {
      paramdsq = paramdsq.Sxx;
      p.j(paramdsq, "member.EncodeUserName");
      localObject = ch(paramdsq, paramBoolean);
    }
    AppMethodBeat.o(138576);
    return localObject;
  }
  
  public final void a(String paramString, b.e parame)
  {
    AppMethodBeat.i(138574);
    b.e locale = (b.e)this.Huj.get(paramString);
    if ((locale != null) && (locale != parame)) {
      this.Huk.put(paramString, locale);
    }
    AppMethodBeat.o(138574);
  }
  
  public final b.e aVp(String paramString)
  {
    AppMethodBeat.i(138578);
    p.k(paramString, "username");
    paramString = ch(paramString, false);
    AppMethodBeat.o(138578);
    return paramString;
  }
  
  public final void b(String paramString, b.e parame)
  {
    AppMethodBeat.i(138575);
    p.k(paramString, "username");
    p.k(parame, "state");
    if (!kotlin.n.n.ba((CharSequence)paramString))
    {
      a(paramString, parame);
      this.Huj.put(paramString, parame);
    }
    AppMethodBeat.o(138575);
  }
  
  public final void ftn()
  {
    AppMethodBeat.i(138566);
    fto();
    this.kUn = false;
    this.Huf = null;
    this.Huh = f.HuF;
    this.Hun.stopTimer();
    Log.d(TAG, "start radar");
    if (this.lEL == null) {
      this.lEL = com.tencent.mm.modelgeo.d.blq();
    }
    this.Huh = f.HuG;
    com.tencent.mm.modelgeo.d locald = this.lEL;
    if (locald != null) {
      locald.a(this.iQJ);
    }
    Log.d(TAG, "status: %s", new Object[] { this.Huh });
    AppMethodBeat.o(138566);
  }
  
  public final void fto()
  {
    AppMethodBeat.i(138567);
    f localf = this.Huh;
    switch (e.$EnumSwitchMapping$0[localf.ordinal()])
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
      if (this.Hug != null)
      {
        stop();
        h.aGY().a((q)this.Hug);
        ftp();
        continue;
        stop();
        ftp();
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(138569);
    com.tencent.mm.modelgeo.d locald = this.lEL;
    if (locald != null)
    {
      locald.a(this.iQJ);
      AppMethodBeat.o(138569);
      return;
    }
    AppMethodBeat.o(138569);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Iterator localIterator = null;
    AppMethodBeat.i(138573);
    p.k(paramq, "scene");
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138573);
      return;
      if (this.Hug == paramq)
      {
        if (((a)paramq).fCN == 1)
        {
          this.Huh = f.HuI;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Log.d(TAG, "rader members count: %s ticket: %s", new Object[] { Integer.valueOf(((a)paramq).ftj()), this.fAo });
            this.Hun.startTimer(Huq);
            paramString = ((a)paramq).rr;
            if (paramString != null) {}
            for (paramString = paramString.bhY();; paramString = null)
            {
              Object localObject = (dss)paramString;
              paramString = localIterator;
              if (localObject != null) {
                paramString = ((dss)localObject).RIk;
              }
              if (paramString == null) {
                break;
              }
              localIterator = paramString.iterator();
              while (localIterator.hasNext())
              {
                localObject = (dsq)localIterator.next();
                com.tencent.mm.plugin.c.a locala = com.tencent.mm.plugin.c.a.bBt();
                p.j(locala, "PinAntispam.instance()");
                locala.bcn().nG(((dsq)localObject).UserName, ((dsq)localObject).Tav);
              }
            }
            if (paramString != null)
            {
              this.lWw.clear();
              this.lWw.addAll((Collection)paramString);
            }
            paramString = this.lWw;
            ((a)paramq).ftj();
            a(paramInt1, paramInt2, paramString);
            Log.d(TAG, "status: %s", new Object[] { this.Huh });
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
          AppMethodBeat.o(138573);
          throw null;
        }
        this.Hup.b(paramInt1, paramInt2, null);
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(138570);
    this.kUn = true;
    this.Huh = f.HuF;
    this.Hun.stopTimer();
    AppMethodBeat.o(138570);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "", "onLocationGot", "", "isOk", "", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "plugin-radar_release"})
  public static abstract interface d
  {
    public abstract void a(int paramInt1, int paramInt2, LinkedList<dsq> paramLinkedList);
    
    public abstract void b(int paramInt1, int paramInt2, LinkedList<Object> paramLinkedList);
    
    public abstract void wp(boolean paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "", "(Ljava/lang/String;I)V", "Stopped", "Locating", "RadarSearching", "Waiting", "plugin-radar_release"})
  static enum f
  {
    static
    {
      AppMethodBeat.i(138559);
      f localf1 = new f("Stopped", 0);
      HuF = localf1;
      f localf2 = new f("Locating", 1);
      HuG = localf2;
      f localf3 = new f("RadarSearching", 2);
      HuH = localf3;
      f localf4 = new f("Waiting", 3);
      HuI = localf4;
      HuJ = new f[] { localf1, localf2, localf3, localf4 };
      AppMethodBeat.o(138559);
    }
    
    private f() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class g
    extends MMHandler
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138563);
      p.k(paramMessage, "msg");
      if (paramMessage.what == d.ftq()) {
        h.aGY().b((q)new a());
      }
      AppMethodBeat.o(138563);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class h
    implements MTimerHandler.CallBack
  {
    h(d paramd) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(138564);
      if (!d.a(this.HuK))
      {
        d.a(this.HuK, d.f.HuH);
        Log.d(d.access$getTAG$cp(), "status: %s", new Object[] { d.b(this.HuK) });
        Object localObject = d.c(this.HuK);
        if (localObject != null)
        {
          if (((Location)localObject).hhP())
          {
            Log.e(d.access$getTAG$cp(), "error! location is null!");
            AppMethodBeat.o(138564);
            return false;
          }
          Log.d(d.access$getTAG$cp(), "do once search");
          d locald = this.HuK;
          float f1 = ((Location)localObject).lLr;
          float f2 = ((Location)localObject).lLs;
          int i = ((Location)localObject).zHu;
          int j = ((Location)localObject).fMG;
          String str = ((Location)localObject).mac;
          p.j(str, "it.mac");
          localObject = ((Location)localObject).fMI;
          p.j(localObject, "it.cellId");
          d.a(locald, new a(1, f1, f2, i, j, str, (String)localObject));
          h.aGY().b((q)d.d(this.HuK));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(138564);
        return false;
        Log.e(d.access$getTAG$cp(), "error! location is null!");
        AppMethodBeat.o(138564);
        return false;
        Log.d(d.access$getTAG$cp(), "cancel radar searching");
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "<anonymous parameter 4>", "", "maccuracy", "<anonymous parameter 6>", "onGetLocation"})
  static final class i
    implements b.a
  {
    i(d paramd) {}
    
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(138565);
      if (d.a(this.HuK))
      {
        Log.d(d.access$getTAG$cp(), "cancel location");
        AppMethodBeat.o(138565);
        return false;
      }
      if (d.c(this.HuK) != null)
      {
        AppMethodBeat.o(138565);
        return false;
      }
      d locald;
      if (paramBoolean)
      {
        locald = this.HuK;
        d.c(this.HuK);
        d.a(locald, true);
        com.tencent.mm.modelstat.n.a(2006, paramFloat1, paramFloat2, (int)paramDouble2);
        Log.d(d.access$getTAG$cp(), "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Double.valueOf(paramDouble2) });
        d.a(this.HuK, new Location(paramFloat2, paramFloat1, (int)paramDouble2, paramInt, "", ""));
        d.e(this.HuK).startTimer(0L);
      }
      for (;;)
      {
        AppMethodBeat.o(138565);
        return false;
        locald = this.HuK;
        d.c(this.HuK);
        d.a(locald, false);
        d.f(this.HuK);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.d
 * JD-Core Version:    0.7.0.1
 */