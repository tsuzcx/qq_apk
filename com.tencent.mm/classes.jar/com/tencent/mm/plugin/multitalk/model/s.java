package com.tencent.mm.plugin.multitalk.model;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.e.d;
import com.tencent.mm.plugin.multitalk.e.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.pb.common.b.a.a.a.ar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/model/MultiTalkScreenCastManager;", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastEventHandler;", "()V", "canReceiveScreenCast", "", "dispatchToPauseEvent", "Lkotlin/Function1;", "", "", "dispatchToStartEvent", "dispatchToStopEvent", "dispatcher", "", "", "mCurrenScreenCastList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMCurrenScreenCastList", "()Ljava/util/ArrayList;", "setMCurrenScreenCastList", "(Ljava/util/ArrayList;)V", "uiCallback", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastUiCallback;", "userStateMap", "Landroid/util/ArrayMap;", "close", "getCurrenScreenCastList", "getUserState", "wxUserName", "isCanReceiveScreenCast", "onSwitchVideoScreenSharingRsp", "rsp", "onVideoGroupMemberChange", "memberList", "", "Lcom/tencent/pb/common/network/protocol/nano/ProtocolContacts$VideoGroupMember;", "pauseScreenCast", "refreshScreenList", "registerUiCallback", "callback", "restartScreenCast", "resumeScreenCast", "startScreenCast", "stopScreenCast", "switchScreenCastState", "state", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  implements h
{
  public static final s.a Lps;
  private final ArrayMap<String, Integer> Lmv;
  private i Lpt;
  public final boolean Lpu;
  public ArrayList<String> Lpv;
  private final b<String, ah> Lpw;
  private final b<String, ah> Lpx;
  private final b<String, ah> Lpy;
  private final Map<Integer, b<String, ah>> Lpz;
  
  static
  {
    AppMethodBeat.i(284767);
    Lps = new s.a((byte)0);
    AppMethodBeat.o(284767);
  }
  
  public s()
  {
    AppMethodBeat.i(284739);
    this.Lmv = new ArrayMap();
    f localf = f.LAR;
    this.Lpu = f.giZ();
    this.Lpw = ((b)new c(this));
    this.Lpx = ((b)new b(this));
    this.Lpy = ((b)new d(this));
    this.Lpz = ak.e(new r[] { v.Y(Integer.valueOf(101), this.Lpw), v.Y(Integer.valueOf(102), this.Lpx), v.Y(Integer.valueOf(103), this.Lpy) });
    AppMethodBeat.o(284739);
  }
  
  public static void ggz()
  {
    AppMethodBeat.i(284743);
    if (ac.ggS() != null) {
      p.abJ(103);
    }
    AppMethodBeat.o(284743);
  }
  
  public final void a(i parami)
  {
    if (!this.Lpu) {
      return;
    }
    this.Lpt = parami;
  }
  
  public final int aNq(String paramString)
  {
    AppMethodBeat.i(284795);
    kotlin.g.b.s.u(paramString, "wxUserName");
    paramString = (Integer)this.Lmv.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(284795);
      return 100;
    }
    int i = paramString.intValue();
    AppMethodBeat.o(284795);
    return i;
  }
  
  public final void aNr(String paramString)
  {
    AppMethodBeat.i(284799);
    i locali = this.Lpt;
    if (locali != null) {
      locali.aMK(paramString);
    }
    AppMethodBeat.o(284799);
  }
  
  public final void abC(int paramInt)
  {
    AppMethodBeat.i(284776);
    Log.i("MicroMsg.MultiTalkScreenCastManager", String.valueOf(paramInt));
    AppMethodBeat.o(284776);
  }
  
  public final void close()
  {
    AppMethodBeat.i(284807);
    this.Lmv.clear();
    this.Lpt = null;
    ArrayList localArrayList = this.Lpv;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    this.Lpv = null;
    AppMethodBeat.o(284807);
  }
  
  public final ArrayList<String> ggA()
  {
    AppMethodBeat.i(284790);
    if (this.Lpv != null)
    {
      localArrayList = this.Lpv;
      AppMethodBeat.o(284790);
      return localArrayList;
    }
    ArrayList localArrayList = new ArrayList();
    AppMethodBeat.o(284790);
    return localArrayList;
  }
  
  public final void iY(List<a.ar> paramList)
  {
    AppMethodBeat.i(284781);
    kotlin.g.b.s.u(paramList, "memberList");
    if (!this.Lpu)
    {
      AppMethodBeat.o(284781);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Log.i("MicroMsg.MultiTalkScreenCastManager", kotlin.g.b.s.X("memberList is ", paramList));
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    label130:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (!kotlin.g.b.s.p(((a.ar)localObject2).hJs, z.bAM())) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label130;
        }
        paramList.add(localObject2);
        break;
      }
    }
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      localObject1 = (a.ar)paramList.next();
      localObject2 = (b)this.Lpz.get(Integer.valueOf(((a.ar)localObject1).ahfs));
      if (localObject2 != null)
      {
        String str = ((a.ar)localObject1).hJs;
        kotlin.g.b.s.s(str, "it.wxUserName");
        ((b)localObject2).invoke(str);
      }
      if ((((a.ar)localObject1).ahfs == 101) || (((a.ar)localObject1).ahfs == 102)) {
        localArrayList.add(((a.ar)localObject1).hJs);
      }
    }
    this.Lpv = localArrayList;
    paramList = d.LAq;
    paramList = this.Lpv;
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      d.acd(i);
      AppMethodBeat.o(284781);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "wxUserName", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<String, ah>
  {
    b(s params)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "wxUserName", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<String, ah>
  {
    c(s params)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "wxUserName", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<String, ah>
  {
    d(s params)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.s
 * JD-Core Version:    0.7.0.1
 */