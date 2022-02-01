package com.tencent.mm.plugin.multitalk.model;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.pb.common.b.a.a.a.ar;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/model/MultiTalkScreenCastManager;", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastEventHandler;", "()V", "canReceiveScreenCast", "", "dispatchToPauseEvent", "Lkotlin/Function1;", "", "", "dispatchToStartEvent", "dispatchToStopEvent", "dispatcher", "", "", "mCurrenScreenCastList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMCurrenScreenCastList", "()Ljava/util/ArrayList;", "setMCurrenScreenCastList", "(Ljava/util/ArrayList;)V", "uiCallback", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastUiCallback;", "userStateMap", "Landroid/util/ArrayMap;", "close", "getCurrenScreenCastList", "getUserState", "wxUserName", "isCanReceiveScreenCast", "onSwitchVideoScreenSharingRsp", "rsp", "onVideoGroupMemberChange", "memberList", "", "Lcom/tencent/pb/common/network/protocol/nano/ProtocolContacts$VideoGroupMember;", "pauseScreenCast", "refreshScreenList", "registerUiCallback", "callback", "restartScreenCast", "resumeScreenCast", "startScreenCast", "stopScreenCast", "switchScreenCastState", "state", "Companion", "plugin-multitalk_release"})
public final class t
  implements h
{
  public static final t.a Ftg;
  private final ArrayMap<String, Integer> Fqk;
  private i FsZ;
  public final boolean Fta;
  public ArrayList<String> Ftb;
  private final b<String, x> Ftc;
  private final b<String, x> Ftd;
  private final b<String, x> Fte;
  private final Map<Integer, b<String, x>> Ftf;
  
  static
  {
    AppMethodBeat.i(196423);
    Ftg = new t.a((byte)0);
    AppMethodBeat.o(196423);
  }
  
  public t()
  {
    AppMethodBeat.i(196422);
    this.Fqk = new ArrayMap();
    e locale = e.FEP;
    this.Fta = e.eZU();
    this.Ftc = ((b)new c(this));
    this.Ftd = ((b)new b(this));
    this.Fte = ((b)new d(this));
    this.Ftf = ae.e(new o[] { s.M(Integer.valueOf(101), this.Ftc), s.M(Integer.valueOf(102), this.Ftd), s.M(Integer.valueOf(103), this.Fte) });
    AppMethodBeat.o(196422);
  }
  
  public static void Xy(int paramInt)
  {
    AppMethodBeat.i(196407);
    if (ad.eYc() != null) {
      q.Xx(paramInt);
    }
    AppMethodBeat.o(196407);
  }
  
  public final void Xr(int paramInt)
  {
    AppMethodBeat.i(196408);
    Log.i("MicroMsg.MultiTalkScreenCastManager", String.valueOf(paramInt));
    AppMethodBeat.o(196408);
  }
  
  public final void a(i parami)
  {
    if (!this.Fta) {
      return;
    }
    this.FsZ = parami;
  }
  
  public final int aQx(String paramString)
  {
    AppMethodBeat.i(196413);
    p.k(paramString, "wxUserName");
    paramString = (Integer)this.Fqk.get(paramString);
    if (paramString != null)
    {
      int i = paramString.intValue();
      AppMethodBeat.o(196413);
      return i;
    }
    AppMethodBeat.o(196413);
    return 100;
  }
  
  public final void aQy(String paramString)
  {
    AppMethodBeat.i(196415);
    i locali = this.FsZ;
    if (locali != null)
    {
      locali.aPP(paramString);
      AppMethodBeat.o(196415);
      return;
    }
    AppMethodBeat.o(196415);
  }
  
  public final void close()
  {
    AppMethodBeat.i(196417);
    this.Fqk.clear();
    this.FsZ = null;
    ArrayList localArrayList = this.Ftb;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    this.Ftb = null;
    AppMethodBeat.o(196417);
  }
  
  public final ArrayList<String> eXL()
  {
    AppMethodBeat.i(196412);
    if (this.Ftb != null)
    {
      localArrayList = this.Ftb;
      AppMethodBeat.o(196412);
      return localArrayList;
    }
    ArrayList localArrayList = new ArrayList();
    AppMethodBeat.o(196412);
    return localArrayList;
  }
  
  public final void gb(List<a.ar> paramList)
  {
    AppMethodBeat.i(196411);
    p.k(paramList, "memberList");
    if (!this.Fta)
    {
      AppMethodBeat.o(196411);
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
      if ((p.h(((a.ar)localObject2).fEC, z.bcZ()) ^ true)) {
        paramList.add(localObject2);
      }
    }
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      localObject1 = (a.ar)paramList.next();
      localObject2 = (b)this.Ftf.get(Integer.valueOf(((a.ar)localObject1).ZgR));
      if (localObject2 != null)
      {
        String str = ((a.ar)localObject1).fEC;
        p.j(str, "it.wxUserName");
        ((b)localObject2).invoke(str);
      }
      if ((((a.ar)localObject1).ZgR == 101) || (((a.ar)localObject1).ZgR == 102)) {
        localArrayList.add(((a.ar)localObject1).fEC);
      }
    }
    this.Ftb = localArrayList;
    AppMethodBeat.o(196411);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements b<String, x>
  {
    b(t paramt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements b<String, x>
  {
    c(t paramt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "wxUserName", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.t
 * JD-Core Version:    0.7.0.1
 */