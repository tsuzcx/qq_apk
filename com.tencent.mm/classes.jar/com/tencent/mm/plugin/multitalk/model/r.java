package com.tencent.mm.plugin.multitalk.model;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.multitalk.d.e;
import com.tencent.pb.common.b.a.a.a.ap;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/model/MultiTalkScreenCastManager;", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastEventHandler;", "()V", "canReceiveScreenCast", "", "dispatchToPauseEvent", "Lkotlin/Function1;", "", "", "dispatchToStartEvent", "dispatchToStopEvent", "dispatcher", "", "", "uiCallback", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastUiCallback;", "userStateMap", "Landroid/util/ArrayMap;", "close", "getUserState", "wxUserName", "onSwitchVideoScreenSharingRsp", "rsp", "onVideoGroupMemberChange", "memberList", "", "Lcom/tencent/pb/common/network/protocol/nano/ProtocolContacts$VideoGroupMember;", "pauseScreenCast", "registerUiCallback", "callback", "restartScreenCast", "resumeScreenCast", "startScreenCast", "stopScreenCast", "switchScreenCastState", "state", "Companion", "plugin-multitalk_release"})
public final class r
  implements h
{
  public static final r.a wrV;
  private final ArrayMap<String, Integer> wpH;
  private i wrP;
  private final boolean wrQ;
  private final b<String, d.z> wrR;
  private final b<String, d.z> wrS;
  private final b<String, d.z> wrT;
  private final Map<Integer, b<String, d.z>> wrU;
  
  static
  {
    AppMethodBeat.i(190938);
    wrV = new r.a((byte)0);
    AppMethodBeat.o(190938);
  }
  
  public r()
  {
    AppMethodBeat.i(190937);
    this.wpH = new ArrayMap();
    e locale = e.wxn;
    this.wrQ = e.duC();
    this.wrR = ((b)new c(this));
    this.wrS = ((b)new b(this));
    this.wrT = ((b)new d(this));
    this.wrU = d.a.ae.a(new d.o[] { u.R(Integer.valueOf(101), this.wrR), u.R(Integer.valueOf(102), this.wrS), u.R(Integer.valueOf(103), this.wrT) });
    AppMethodBeat.o(190937);
  }
  
  public static void Ll(int paramInt)
  {
    AppMethodBeat.i(190932);
    if (z.dtK() != null) {
      o.Lk(paramInt);
    }
    AppMethodBeat.o(190932);
  }
  
  public final void Ld(int paramInt)
  {
    AppMethodBeat.i(190933);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MultiTalkScreenCastManager", String.valueOf(paramInt));
    AppMethodBeat.o(190933);
  }
  
  public final void a(i parami)
  {
    if (!this.wrQ) {
      return;
    }
    this.wrP = parami;
  }
  
  public final int asL(String paramString)
  {
    AppMethodBeat.i(190935);
    p.h(paramString, "wxUserName");
    paramString = (Integer)this.wpH.get(paramString);
    if (paramString != null)
    {
      int i = paramString.intValue();
      AppMethodBeat.o(190935);
      return i;
    }
    AppMethodBeat.o(190935);
    return 100;
  }
  
  public final void close()
  {
    AppMethodBeat.i(190936);
    this.wpH.clear();
    this.wrP = null;
    AppMethodBeat.o(190936);
  }
  
  public final void eE(List<a.ap> paramList)
  {
    AppMethodBeat.i(190934);
    p.h(paramList, "memberList");
    if (!this.wrQ)
    {
      AppMethodBeat.o(190934);
      return;
    }
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if ((p.i(((a.ap)localObject2).duC, v.aAC()) ^ true)) {
        paramList.add(localObject2);
      }
    }
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      localObject2 = (a.ap)paramList.next();
      localObject1 = (b)this.wrU.get(Integer.valueOf(((a.ap)localObject2).MeU));
      if (localObject1 != null)
      {
        localObject2 = ((a.ap)localObject2).duC;
        p.g(localObject2, "it.wxUserName");
        ((b)localObject1).invoke(localObject2);
      }
    }
    AppMethodBeat.o(190934);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class b
    extends q
    implements b<String, d.z>
  {
    b(r paramr)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class c
    extends q
    implements b<String, d.z>
  {
    c(r paramr)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class d
    extends q
    implements b<String, d.z>
  {
    d(r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.r
 * JD-Core Version:    0.7.0.1
 */