package com.tencent.mm.plugin.multitalk.model;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.pb.common.b.a.a.a.as;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/model/MultiTalkScreenCastManager;", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastEventHandler;", "()V", "canReceiveScreenCast", "", "dispatchToPauseEvent", "Lkotlin/Function1;", "", "", "dispatchToStartEvent", "dispatchToStopEvent", "dispatcher", "", "", "mCurrenScreenCastList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMCurrenScreenCastList", "()Ljava/util/ArrayList;", "setMCurrenScreenCastList", "(Ljava/util/ArrayList;)V", "uiCallback", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastUiCallback;", "userStateMap", "Landroid/util/ArrayMap;", "close", "getCurrenScreenCastList", "getUserState", "wxUserName", "isCanReceiveScreenCast", "onSwitchVideoScreenSharingRsp", "rsp", "onVideoGroupMemberChange", "memberList", "", "Lcom/tencent/pb/common/network/protocol/nano/ProtocolContacts$VideoGroupMember;", "pauseScreenCast", "refreshScreenList", "registerUiCallback", "callback", "restartScreenCast", "resumeScreenCast", "startScreenCast", "stopScreenCast", "switchScreenCastState", "state", "Companion", "plugin-multitalk_release"})
public final class t
  implements h
{
  public static final t.a zNJ;
  private final ArrayMap<String, Integer> zKT;
  private i zNC;
  public final boolean zND;
  public ArrayList<String> zNE;
  private final b<String, x> zNF;
  private final b<String, x> zNG;
  private final b<String, x> zNH;
  private final Map<Integer, b<String, x>> zNI;
  
  static
  {
    AppMethodBeat.i(239633);
    zNJ = new t.a((byte)0);
    AppMethodBeat.o(239633);
  }
  
  public t()
  {
    AppMethodBeat.i(239632);
    this.zKT = new ArrayMap();
    e locale = e.zZc;
    this.zND = e.eqd();
    this.zNF = ((b)new c(this));
    this.zNG = ((b)new b(this));
    this.zNH = ((b)new d(this));
    this.zNI = ae.e(new o[] { s.U(Integer.valueOf(101), this.zNF), s.U(Integer.valueOf(102), this.zNG), s.U(Integer.valueOf(103), this.zNH) });
    AppMethodBeat.o(239632);
  }
  
  public static void Rk(int paramInt)
  {
    AppMethodBeat.i(239625);
    if (ac.eom() != null) {
      q.Rj(paramInt);
    }
    AppMethodBeat.o(239625);
  }
  
  public final void Rd(int paramInt)
  {
    AppMethodBeat.i(239626);
    Log.i("MicroMsg.MultiTalkScreenCastManager", String.valueOf(paramInt));
    AppMethodBeat.o(239626);
  }
  
  public final void a(i parami)
  {
    if (!this.zND) {
      return;
    }
    this.zNC = parami;
  }
  
  public final int aGj(String paramString)
  {
    AppMethodBeat.i(239629);
    p.h(paramString, "wxUserName");
    paramString = (Integer)this.zKT.get(paramString);
    if (paramString != null)
    {
      int i = paramString.intValue();
      AppMethodBeat.o(239629);
      return i;
    }
    AppMethodBeat.o(239629);
    return 100;
  }
  
  public final void aGk(String paramString)
  {
    AppMethodBeat.i(239630);
    i locali = this.zNC;
    if (locali != null)
    {
      locali.aFD(paramString);
      AppMethodBeat.o(239630);
      return;
    }
    AppMethodBeat.o(239630);
  }
  
  public final void close()
  {
    AppMethodBeat.i(239631);
    this.zKT.clear();
    this.zNC = null;
    ArrayList localArrayList = this.zNE;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    this.zNE = null;
    AppMethodBeat.o(239631);
  }
  
  public final ArrayList<String> enV()
  {
    AppMethodBeat.i(239628);
    if (this.zNE != null)
    {
      localArrayList = this.zNE;
      AppMethodBeat.o(239628);
      return localArrayList;
    }
    ArrayList localArrayList = new ArrayList();
    AppMethodBeat.o(239628);
    return localArrayList;
  }
  
  public final void fz(List<a.as> paramList)
  {
    AppMethodBeat.i(239627);
    p.h(paramList, "memberList");
    if (!this.zND)
    {
      AppMethodBeat.o(239627);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Log.i("MicroMsg.MultiTalkScreenCastManager", "memberList is ".concat(String.valueOf(paramList)));
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if ((p.j(((a.as)localObject2).dLN, z.aTY()) ^ true)) {
        paramList.add(localObject2);
      }
    }
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      localObject1 = (a.as)paramList.next();
      localObject2 = (b)this.zNI.get(Integer.valueOf(((a.as)localObject1).RFm));
      if (localObject2 != null)
      {
        String str = ((a.as)localObject1).dLN;
        p.g(str, "it.wxUserName");
        ((b)localObject2).invoke(str);
      }
      if ((((a.as)localObject1).RFm == 101) || (((a.as)localObject1).RFm == 102)) {
        localArrayList.add(((a.as)localObject1).dLN);
      }
    }
    this.zNE = localArrayList;
    AppMethodBeat.o(239627);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements b<String, x>
  {
    b(t paramt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements b<String, x>
  {
    c(t paramt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements b<String, x>
  {
    d(t paramt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.t
 * JD-Core Version:    0.7.0.1
 */