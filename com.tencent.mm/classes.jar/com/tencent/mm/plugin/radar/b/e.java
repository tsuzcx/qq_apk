package com.tencent.mm.plugin.radar.b;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.bri;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/model/RadarManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "delayRadarRemove", "com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1;", "delayRadarSearch", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "encodeUserNameMap", "", "", "getEncodeUserNameMap", "()Ljava/util/Map;", "setEncodeUserNameMap", "(Ljava/util/Map;)V", "isCancel", "", "lastStateTable", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getLastStateTable", "setLastStateTable", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "locationGeo", "Lcom/tencent/mm/modelgeo/LocationGeo;", "mOnLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "members", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "radarMemberList", "Lcom/tencent/mm/protocal/protobuf/RadarMember;", "getRadarMemberList", "()Ljava/util/LinkedList;", "setRadarMemberList", "(Ljava/util/LinkedList;)V", "sceneRadarRelationChain", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarRelationChain;", "sceneRadarSearch", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "selectedStatusMap", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getSelectedStatusMap", "setSelectedStatusMap", "stateTable", "getStateTable", "setStateTable", "status", "Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "tempLatestChangeStatTable", "", "Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "getTempLatestChangeStatTable", "setTempLatestChangeStatTable", "ticket", "doRadarRelationChain", "", "memList", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "getChooseStatus", "member", "getState", "old", "username", "getStateImpl", "onCreate", "onDestroy", "onLocationGot", "isOk", "onPause", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "onResume", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "putState", "state", "radarRemove", "reset", "saveLastState", "name", "setChooseStatus", "startRadarSearch", "stop", "stopRadarSearch", "syncStateToLastState", "ChooseStatus", "Companion", "LatestChangeStat", "RadarDelegate", "RadarStatus", "Status", "plugin-radar_release"})
public final class e
  implements f
{
  private static final String TAG = "MicroMsg.Radar.RadarManager";
  private static final int pQB = 3000;
  private static final int pQC = 5000;
  private static final int pQD = 1;
  public static final e.b pQE;
  private final Context context;
  private String crs;
  public final b.a dZA;
  private boolean eUJ;
  private final LinkedList<brg> fLA;
  public d fwu;
  private final e.d pQA;
  private Location pQp;
  private b pQq;
  private e.f pQr;
  public LinkedList<bre> pQs;
  public Map<String, String> pQt;
  private Map<String, c.e> pQu;
  private Map<String, c.e> pQv;
  public Map<Long, e.c> pQw;
  public Map<String, e.a> pQx;
  private final ap pQy;
  private final e.g pQz;
  
  static
  {
    AppMethodBeat.i(102937);
    pQE = new e.b((byte)0);
    TAG = "MicroMsg.Radar.RadarManager";
    pQB = 3000;
    pQC = 5000;
    pQD = 1;
    AppMethodBeat.o(102937);
  }
  
  public e(e.d paramd, Context paramContext)
  {
    AppMethodBeat.i(102936);
    this.pQA = paramd;
    this.context = paramContext;
    this.pQr = e.f.pQQ;
    this.fLA = new LinkedList();
    this.pQt = ((Map)new LinkedHashMap());
    this.pQu = ((Map)new LinkedHashMap());
    this.pQv = ((Map)new LinkedHashMap());
    this.pQw = ((Map)new LinkedHashMap());
    this.pQx = ((Map)new LinkedHashMap());
    this.pQy = new ap((ap.a)new e.h(this), false);
    this.pQz = new e.g();
    this.dZA = ((b.a)new e.i(this));
    AppMethodBeat.o(102936);
  }
  
  private final void a(int paramInt1, int paramInt2, LinkedList<brg> paramLinkedList)
  {
    AppMethodBeat.i(102926);
    this.pQA.a(paramInt1, paramInt2, paramLinkedList);
    AppMethodBeat.o(102926);
  }
  
  private final void b(int paramInt1, int paramInt2, LinkedList<brd> paramLinkedList)
  {
    AppMethodBeat.i(102927);
    this.pQA.b(paramInt1, paramInt2, paramLinkedList);
    AppMethodBeat.o(102927);
  }
  
  private final c.e bh(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102934);
    if (paramBoolean)
    {
      paramString = (c.e)this.pQv.get(paramString);
      AppMethodBeat.o(102934);
      return paramString;
    }
    paramString = (c.e)this.pQu.get(paramString);
    AppMethodBeat.o(102934);
    return paramString;
  }
  
  private final void ceO()
  {
    AppMethodBeat.i(102923);
    this.pQz.sendEmptyMessageDelayed(pQD, pQC);
    AppMethodBeat.o(102923);
  }
  
  public final c.e XI(String paramString)
  {
    AppMethodBeat.i(102933);
    j.q(paramString, "username");
    paramString = bh(paramString, false);
    AppMethodBeat.o(102933);
    return paramString;
  }
  
  public final c.e a(brg parambrg, boolean paramBoolean)
  {
    AppMethodBeat.i(102931);
    j.q(parambrg, "member");
    Object localObject = parambrg.jJA;
    j.p(localObject, "member.UserName");
    c.e locale = bh((String)localObject, paramBoolean);
    localObject = locale;
    if (locale == null)
    {
      parambrg = parambrg.wSo;
      j.p(parambrg, "member.EncodeUserName");
      localObject = bh(parambrg, paramBoolean);
    }
    AppMethodBeat.o(102931);
    return localObject;
  }
  
  public final void a(brg parambrg)
  {
    AppMethodBeat.i(102935);
    if (parambrg != null)
    {
      com.tencent.mm.plugin.radar.ui.g localg = com.tencent.mm.plugin.radar.ui.g.pSH;
      parambrg = com.tencent.mm.plugin.radar.ui.g.b(parambrg);
      if (this.pQx.containsKey(parambrg))
      {
        this.pQx.remove(parambrg);
        AppMethodBeat.o(102935);
        return;
      }
      this.pQx.put(parambrg, e.a.pQF);
    }
    AppMethodBeat.o(102935);
  }
  
  public final void a(String paramString, c.e parame)
  {
    AppMethodBeat.i(102929);
    c.e locale = (c.e)this.pQu.get(paramString);
    if ((locale != null) && (locale != parame)) {
      this.pQv.put(paramString, locale);
    }
    AppMethodBeat.o(102929);
  }
  
  public final void b(String paramString, c.e parame)
  {
    AppMethodBeat.i(102930);
    j.q(paramString, "username");
    j.q(parame, "state");
    if (!a.l.m.ap((CharSequence)paramString))
    {
      a(paramString, parame);
      this.pQu.put(paramString, parame);
    }
    AppMethodBeat.o(102930);
  }
  
  public final void ceM()
  {
    AppMethodBeat.i(102921);
    ceN();
    this.eUJ = false;
    this.pQp = null;
    this.pQr = e.f.pQQ;
    this.pQy.stopTimer();
    ab.d(TAG, "start radar");
    if (this.fwu == null) {
      this.fwu = d.agQ();
    }
    this.pQr = e.f.pQR;
    d locald = this.fwu;
    if (locald != null) {
      locald.b(this.dZA);
    }
    ab.d(TAG, "status: %s", new Object[] { this.pQr });
    AppMethodBeat.o(102921);
  }
  
  public final void ceN()
  {
    AppMethodBeat.i(102922);
    e.f localf = this.pQr;
    switch (f.bLo[localf.ordinal()])
    {
    }
    for (;;)
    {
      ab.d(TAG, "stop radar");
      AppMethodBeat.o(102922);
      return;
      AppMethodBeat.o(102922);
      return;
      stop();
      continue;
      if (this.pQq != null)
      {
        stop();
        com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)this.pQq);
        ceO();
        continue;
        stop();
        ceO();
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(102924);
    d locald = this.fwu;
    if (locald != null)
    {
      locald.b(this.dZA);
      AppMethodBeat.o(102924);
      return;
    }
    AppMethodBeat.o(102924);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    brg localbrg = null;
    AppMethodBeat.i(102928);
    j.q(paramm, "scene");
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(102928);
      return;
      if (this.pQq == paramm)
      {
        if (((b)paramm).ctW == 1)
        {
          this.pQr = e.f.pQT;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Object localObject = TAG;
            paramString = ((b)paramm).rr;
            int i;
            if (paramString != null)
            {
              paramString = paramString.adn();
              paramString = (bri)paramString;
              if (paramString == null) {
                break label276;
              }
              i = paramString.eeF;
              label129:
              ab.d((String)localObject, "rader members count: %s ticket: %s", new Object[] { Integer.valueOf(i), this.crs });
              this.pQy.nP(pQB);
              paramString = ((b)paramm).rr;
              if (paramString == null) {
                break label282;
              }
            }
            label276:
            label282:
            for (paramString = paramString.adn();; paramString = null)
            {
              paramm = (bri)paramString;
              paramString = localbrg;
              if (paramm != null) {
                paramString = paramm.wov;
              }
              if (paramString == null) {
                break label287;
              }
              paramm = paramString.iterator();
              while (paramm.hasNext())
              {
                localbrg = (brg)paramm.next();
                localObject = com.tencent.mm.plugin.c.a.asD();
                j.p(localObject, "PinAntispam.instance()");
                ((com.tencent.mm.plugin.c.a)localObject).Zb().in(localbrg.jJA, localbrg.wYu);
              }
              paramString = null;
              break;
              i = 0;
              break label129;
            }
            label287:
            if (paramString != null)
            {
              this.fLA.clear();
              this.fLA.addAll((Collection)paramString);
            }
            a(paramInt1, paramInt2, this.fLA);
            ab.d(TAG, "status: %s", new Object[] { this.pQr });
            AppMethodBeat.o(102928);
            return;
          }
          stop();
          a(paramInt1, paramInt2, null);
          AppMethodBeat.o(102928);
          return;
        }
        a(paramInt1, paramInt2, null);
        AppMethodBeat.o(102928);
        return;
        ab.d(TAG, " MMFunc_MMRadarRelationChain ");
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((a)paramm).rr.adn();
          if (paramString == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarRelationChainResponse");
            AppMethodBeat.o(102928);
            throw paramString;
          }
          paramString = (brf)paramString;
          this.crs = paramString.wQf;
          if (paramString.eeF > 0)
          {
            b(paramInt1, paramInt2, paramString.wov);
            AppMethodBeat.o(102928);
            return;
          }
          b(paramInt1, paramInt2, null);
          AppMethodBeat.o(102928);
          return;
        }
        b(paramInt1, paramInt2, null);
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(102925);
    this.eUJ = true;
    this.pQr = e.f.pQQ;
    this.pQy.stopTimer();
    AppMethodBeat.o(102925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e
 * JD-Core Version:    0.7.0.1
 */