package com.tencent.mm.plugin.radar.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.protocal.protobuf.eln;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.storage.g;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/model/RadarManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "delayRadarRemove", "com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1;", "delayRadarSearch", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "encodeUserNameMap", "", "", "getEncodeUserNameMap", "()Ljava/util/Map;", "setEncodeUserNameMap", "(Ljava/util/Map;)V", "isCancel", "", "lastStateTable", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getLastStateTable", "setLastStateTable", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "locationGeo", "Lcom/tencent/mm/modelgeo/LocationGeo;", "mOnLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "members", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "radarMemberList", "Lcom/tencent/mm/protocal/protobuf/RadarMember;", "getRadarMemberList", "()Ljava/util/LinkedList;", "setRadarMemberList", "(Ljava/util/LinkedList;)V", "sceneRadarRelationChain", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarRelationChain;", "sceneRadarSearch", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "selectedStatusMap", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getSelectedStatusMap", "setSelectedStatusMap", "stateTable", "getStateTable", "setStateTable", "status", "Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "tempLatestChangeStatTable", "", "Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "getTempLatestChangeStatTable", "setTempLatestChangeStatTable", "ticket", "doRadarRelationChain", "", "memList", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "getChooseStatus", "member", "getState", "old", "username", "getStateImpl", "onCreate", "onDestroy", "onLocationGot", "isOk", "onPause", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "onResume", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "putState", "state", "radarRemove", "reset", "saveLastState", "name", "setChooseStatus", "startRadarSearch", "stop", "stopRadarSearch", "syncStateToLastState", "ChooseStatus", "Companion", "LatestChangeStat", "RadarDelegate", "RadarStatus", "Status", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements com.tencent.mm.am.h
{
  public static final d.b NrT;
  private static final int Nsf;
  private static final int Nsg;
  private static final int Nsh;
  private static final String TAG;
  private final d NrU;
  private Location NrV;
  private a NrW;
  private f NrX;
  public Map<String, String> NrY;
  private Map<String, b.e> NrZ;
  private Map<String, b.e> Nsa;
  public Map<Long, d.c> Nsb;
  public Map<String, a> Nsc;
  private final MTimerHandler Nsd;
  private final d.h Nse;
  private final Context context;
  private String hFb;
  public final b.a lsF;
  private boolean nzW;
  private final LinkedList<ell> oPy;
  public com.tencent.mm.modelgeo.d owr;
  
  static
  {
    AppMethodBeat.i(138582);
    NrT = new d.b((byte)0);
    TAG = "MicroMsg.Radar.RadarManager";
    Nsf = 3000;
    Nsg = 5000;
    Nsh = 1;
    AppMethodBeat.o(138582);
  }
  
  public d(d paramd, Context paramContext)
  {
    AppMethodBeat.i(138581);
    this.NrU = paramd;
    this.context = paramContext;
    this.NrX = f.Nst;
    this.oPy = new LinkedList();
    this.NrY = ((Map)new LinkedHashMap());
    this.NrZ = ((Map)new LinkedHashMap());
    this.Nsa = ((Map)new LinkedHashMap());
    this.Nsb = ((Map)new LinkedHashMap());
    this.Nsc = ((Map)new LinkedHashMap());
    this.Nsd = new MTimerHandler(new d..ExternalSyntheticLambda1(this), false);
    this.Nse = new d.h();
    this.lsF = new d..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(138581);
  }
  
  private final void AP(boolean paramBoolean)
  {
    AppMethodBeat.i(267196);
    this.NrU.AP(paramBoolean);
    AppMethodBeat.o(267196);
  }
  
  private final void a(int paramInt1, int paramInt2, LinkedList<ell> paramLinkedList)
  {
    AppMethodBeat.i(138571);
    this.NrU.a(paramInt1, paramInt2, paramLinkedList);
    AppMethodBeat.o(138571);
  }
  
  private static final boolean a(d paramd)
  {
    AppMethodBeat.i(267212);
    kotlin.g.b.s.u(paramd, "this$0");
    if (!paramd.nzW)
    {
      paramd.NrX = f.Nsv;
      Log.d(TAG, "status: %s", new Object[] { paramd.NrX });
      Object localObject = paramd.NrV;
      if (localObject == null) {}
      for (paramd = null; paramd == null; paramd = Boolean.valueOf(com.tencent.mm.kernel.h.aZW().a((p)paramd.NrW, 0)))
      {
        Log.e(TAG, "error! location is null!");
        AppMethodBeat.o(267212);
        return false;
        if (((Location)localObject).iIQ())
        {
          Log.e(TAG, "error! location is null!");
          AppMethodBeat.o(267212);
          return false;
        }
        Log.d(TAG, "do once search");
        float f1 = ((Location)localObject).oDT;
        float f2 = ((Location)localObject).oDU;
        int i = ((Location)localObject).EOW;
        int j = ((Location)localObject).hSq;
        String str = ((Location)localObject).mac;
        kotlin.g.b.s.s(str, "it.mac");
        localObject = ((Location)localObject).hSs;
        kotlin.g.b.s.s(localObject, "it.cellId");
        paramd.NrW = new a(1, f1, f2, i, j, str, (String)localObject);
      }
      paramd.booleanValue();
    }
    for (;;)
    {
      AppMethodBeat.o(267212);
      return false;
      Log.d(TAG, "cancel radar searching");
    }
  }
  
  private static final boolean a(d paramd, boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(267213);
    kotlin.g.b.s.u(paramd, "this$0");
    if (paramd.nzW)
    {
      Log.d(TAG, "cancel location");
      AppMethodBeat.o(267213);
      return false;
    }
    if (paramd.NrV != null)
    {
      AppMethodBeat.o(267213);
      return false;
    }
    if (paramBoolean)
    {
      paramd.AP(true);
      com.tencent.mm.modelstat.n.a(2006, paramFloat1, paramFloat2, (int)paramDouble2);
      Log.d(TAG, "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Double.valueOf(paramDouble2) });
      paramd.NrV = new Location(paramFloat2, paramFloat1, (int)paramDouble2, paramInt, "", "");
      paramd.Nsd.startTimer(0L);
    }
    for (;;)
    {
      AppMethodBeat.o(267213);
      return false;
      paramd.AP(false);
      paramd.stop();
    }
  }
  
  private final b.e cG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(138579);
    if (paramBoolean)
    {
      paramString = (b.e)this.Nsa.get(paramString);
      AppMethodBeat.o(138579);
      return paramString;
    }
    paramString = (b.e)this.NrZ.get(paramString);
    AppMethodBeat.o(138579);
    return paramString;
  }
  
  private final void gFb()
  {
    AppMethodBeat.i(138568);
    this.Nse.sendEmptyMessageDelayed(Nsh, Nsg);
    AppMethodBeat.o(138568);
  }
  
  public final b.e a(ell paramell, boolean paramBoolean)
  {
    AppMethodBeat.i(138576);
    kotlin.g.b.s.u(paramell, "member");
    Object localObject = paramell.UserName;
    kotlin.g.b.s.s(localObject, "member.UserName");
    localObject = cG((String)localObject, paramBoolean);
    if (localObject == null)
    {
      paramell = paramell.Zyp;
      kotlin.g.b.s.s(paramell, "member.EncodeUserName");
      paramell = cG(paramell, paramBoolean);
      AppMethodBeat.o(138576);
      return paramell;
    }
    AppMethodBeat.o(138576);
    return localObject;
  }
  
  public final void a(String paramString, b.e parame)
  {
    AppMethodBeat.i(138574);
    b.e locale = (b.e)this.NrZ.get(paramString);
    if ((locale != null) && (locale != parame)) {
      this.Nsa.put(paramString, locale);
    }
    AppMethodBeat.o(138574);
  }
  
  public final b.e aSx(String paramString)
  {
    AppMethodBeat.i(138578);
    kotlin.g.b.s.u(paramString, "username");
    paramString = cG(paramString, false);
    AppMethodBeat.o(138578);
    return paramString;
  }
  
  public final void b(String paramString, b.e parame)
  {
    AppMethodBeat.i(138575);
    kotlin.g.b.s.u(paramString, "username");
    kotlin.g.b.s.u(parame, "state");
    if (!kotlin.n.n.bp((CharSequence)paramString))
    {
      a(paramString, parame);
      this.NrZ.put(paramString, parame);
    }
    AppMethodBeat.o(138575);
  }
  
  public final void gEZ()
  {
    AppMethodBeat.i(138566);
    gFa();
    this.nzW = false;
    this.NrV = null;
    this.NrX = f.Nst;
    this.Nsd.stopTimer();
    Log.d(TAG, "start radar");
    if (this.owr == null) {
      this.owr = com.tencent.mm.modelgeo.d.bJl();
    }
    this.NrX = f.Nsu;
    com.tencent.mm.modelgeo.d locald = this.owr;
    if (locald != null) {
      locald.a(this.lsF, true, true);
    }
    Log.d(TAG, "status: %s", new Object[] { this.NrX });
    AppMethodBeat.o(138566);
  }
  
  public final void gFa()
  {
    AppMethodBeat.i(138567);
    f localf = this.NrX;
    switch (g.$EnumSwitchMapping$0[localf.ordinal()])
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
      if (this.NrW != null)
      {
        stop();
        com.tencent.mm.kernel.h.aZW().a((p)this.NrW);
        gFb();
        continue;
        stop();
        gFb();
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(138569);
    com.tencent.mm.modelgeo.d locald = this.owr;
    if (locald != null) {
      locald.a(this.lsF, true, true);
    }
    AppMethodBeat.o(138569);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Iterator localIterator = null;
    AppMethodBeat.i(138573);
    kotlin.g.b.s.u(paramp, "scene");
    switch (paramp.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138573);
      return;
      if (this.NrW == paramp)
      {
        if (((a)paramp).hHC == 1)
        {
          this.NrX = f.Nsw;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Log.d(TAG, "rader members count: %s ticket: %s", new Object[] { Integer.valueOf(((a)paramp).gEV()), this.hFb });
            this.Nsd.startTimer(Nsf);
            paramString = ((a)paramp).rr;
            if (paramString == null)
            {
              paramString = null;
              paramString = (eln)paramString;
              if (paramString != null) {
                break label228;
              }
            }
            label228:
            for (paramString = localIterator;; paramString = paramString.YFm)
            {
              if (paramString == null) {
                break label236;
              }
              localIterator = paramString.iterator();
              while (localIterator.hasNext())
              {
                ell localell = (ell)localIterator.next();
                com.tencent.mm.plugin.c.a.caJ().bAc().pE(localell.UserName, localell.aant);
              }
              paramString = c.c.b(paramString.otC);
              break;
            }
            label236:
            if (paramString != null)
            {
              this.oPy.clear();
              this.oPy.addAll((Collection)paramString);
            }
            paramString = this.oPy;
            ((a)paramp).gEV();
            a(paramInt1, paramInt2, paramString);
            Log.d(TAG, "status: %s", new Object[] { this.NrX });
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
        this.NrU.b(paramInt1, paramInt2, null);
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(138570);
    this.nzW = true;
    this.NrX = f.Nst;
    this.Nsd.stopTimer();
    AppMethodBeat.o(138570);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "", "(Ljava/lang/String;I)V", "Selected", "UnSelected", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(138549);
      Nsi = new a("Selected", 0);
      Nsj = new a("UnSelected", 1);
      Nsk = new a[] { Nsi, Nsj };
      AppMethodBeat.o(138549);
    }
    
    private a() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "", "onLocationGot", "", "isOk", "", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void AP(boolean paramBoolean);
    
    public abstract void a(int paramInt1, int paramInt2, LinkedList<ell> paramLinkedList);
    
    public abstract void b(int paramInt1, int paramInt2, LinkedList<Object> paramLinkedList);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "", "(Ljava/lang/String;I)V", "SEARCHING", "SEARCH_RETRUN", "RALATIONCHAIN", "RALATIONCHAIN_RETRUN", "CREATING_CHAT", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum e
  {
    static
    {
      AppMethodBeat.i(138556);
      Nsn = new e("SEARCHING", 0);
      Nso = new e("SEARCH_RETRUN", 1);
      Nsp = new e("RALATIONCHAIN", 2);
      Nsq = new e("RALATIONCHAIN_RETRUN", 3);
      Nsr = new e("CREATING_CHAT", 4);
      Nss = new e[] { Nsn, Nso, Nsp, Nsq, Nsr };
      AppMethodBeat.o(138556);
    }
    
    private e() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "", "(Ljava/lang/String;I)V", "Stopped", "Locating", "RadarSearching", "Waiting", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  static enum f
  {
    static
    {
      AppMethodBeat.i(138559);
      Nst = new f("Stopped", 0);
      Nsu = new f("Locating", 1);
      Nsv = new f("RadarSearching", 2);
      Nsw = new f("Waiting", 3);
      Nsx = new f[] { Nst, Nsu, Nsv, Nsw };
      AppMethodBeat.o(138559);
    }
    
    private f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.model.d
 * JD-Core Version:    0.7.0.1
 */