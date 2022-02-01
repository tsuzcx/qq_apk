package com.tencent.mm.plugin.multitalk.model;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.c.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.pb.common.b.a.a.a.ap;
import d.a.ae;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/multitalk/model/MultiTalkScreenCastManager;", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastEventHandler;", "()V", "canReceiveScreenCast", "", "dispatchToPauseEvent", "Lkotlin/Function1;", "", "", "dispatchToStartEvent", "dispatchToStopEvent", "dispatcher", "", "", "uiCallback", "Lcom/tencent/mm/plugin/multitalk/model/IScreenCastUiCallback;", "userStateMap", "Landroid/util/ArrayMap;", "close", "getUserState", "wxUserName", "onSwitchVideoScreenSharingRsp", "rsp", "onVideoGroupMemberChange", "memberList", "", "Lcom/tencent/pb/common/network/protocol/nano/ProtocolContacts$VideoGroupMember;", "pauseScreenCast", "registerUiCallback", "callback", "restartScreenCast", "resumeScreenCast", "startScreenCast", "stopScreenCast", "switchScreenCastState", "state", "Companion", "plugin-multitalk_release"})
public final class r
  implements h
{
  public static final r.a wct;
  private final ArrayMap<String, Integer> wai;
  private i wcn;
  private final boolean wco;
  private final b<String, d.z> wcp;
  private final b<String, d.z> wcq;
  private final b<String, d.z> wcr;
  private final Map<Integer, b<String, d.z>> wcs;
  
  static
  {
    AppMethodBeat.i(206668);
    wct = new r.a((byte)0);
    AppMethodBeat.o(206668);
  }
  
  public r()
  {
    AppMethodBeat.i(206667);
    this.wai = new ArrayMap();
    e locale = e.whJ;
    this.wco = e.drq();
    this.wcp = ((b)new c(this));
    this.wcq = ((b)new b(this));
    this.wcr = ((b)new d(this));
    this.wcs = ae.a(new d.o[] { d.u.S(Integer.valueOf(101), this.wcp), d.u.S(Integer.valueOf(102), this.wcq), d.u.S(Integer.valueOf(103), this.wcr) });
    AppMethodBeat.o(206667);
  }
  
  public static void KG(int paramInt)
  {
    AppMethodBeat.i(206662);
    if (z.dqx() != null) {
      o.KF(paramInt);
    }
    AppMethodBeat.o(206662);
  }
  
  public final void Ky(int paramInt)
  {
    AppMethodBeat.i(206663);
    ad.i("MicroMsg.MultiTalkScreenCastManager", String.valueOf(paramInt));
    AppMethodBeat.o(206663);
  }
  
  public final void a(i parami)
  {
    if (!this.wco) {
      return;
    }
    this.wcn = parami;
  }
  
  public final int arA(String paramString)
  {
    AppMethodBeat.i(206665);
    p.h(paramString, "wxUserName");
    paramString = (Integer)this.wai.get(paramString);
    if (paramString != null)
    {
      int i = paramString.intValue();
      AppMethodBeat.o(206665);
      return i;
    }
    AppMethodBeat.o(206665);
    return 100;
  }
  
  public final void close()
  {
    AppMethodBeat.i(206666);
    this.wai.clear();
    this.wcn = null;
    AppMethodBeat.o(206666);
  }
  
  public final void ez(List<a.ap> paramList)
  {
    AppMethodBeat.i(206664);
    p.h(paramList, "memberList");
    if (!this.wco)
    {
      AppMethodBeat.o(206664);
      return;
    }
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if ((p.i(((a.ap)localObject2).dtx, com.tencent.mm.model.u.aAm()) ^ true)) {
        paramList.add(localObject2);
      }
    }
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      localObject2 = (a.ap)paramList.next();
      localObject1 = (b)this.wcs.get(Integer.valueOf(((a.ap)localObject2).LHQ));
      if (localObject1 != null)
      {
        localObject2 = ((a.ap)localObject2).dtx;
        p.g(localObject2, "it.wxUserName");
        ((b)localObject1).invoke(localObject2);
      }
    }
    AppMethodBeat.o(206664);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class b
    extends q
    implements b<String, d.z>
  {
    b(r paramr)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "wxUserName", "", "invoke"})
  static final class c
    extends q
    implements b<String, d.z>
  {
    c(r paramr)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "wxUserName", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.r
 * JD-Core Version:    0.7.0.1
 */