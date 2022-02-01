package com.tencent.mm.plugin.webview;

import androidx.lifecycle.h;
import androidx.lifecycle.m;
import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.cdw;
import com.tencent.mm.protocal.protobuf.euw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/WebTransCgiLogic;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "liveTransTextRes", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/webview/WebTransData$WebTransPack;", "getLiveTransTextRes", "()Landroidx/lifecycle/MutableLiveData;", "setLiveTransTextRes", "(Landroidx/lifecycle/MutableLiveData;)V", "requestingQueue", "Ljava/util/LinkedList;", "getRequestingQueue", "()Ljava/util/LinkedList;", "setRequestingQueue", "(Ljava/util/LinkedList;)V", "sendPackHashSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "waitingQueue", "getWaitingQueue", "setWaitingQueue", "doCgiReq", "pack", "(Lcom/tencent/mm/plugin/webview/WebTransData$WebTransPack;)Ljava/lang/Integer;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "handleResp", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sendPack", "onDestroy", "onStart", "slicePack", "wholePack", "startCgiTransTask", "updateRequestQueueAndSend", "Companion", "plugin-webview_release"})
public final class d
  implements androidx.lifecycle.l
{
  public static final a PDL;
  m PDH;
  r<f.b> PDI;
  final HashSet<Integer> PDJ;
  private LinkedList<f.b> PDK;
  private LinkedList<f.b> uVu;
  
  static
  {
    AppMethodBeat.i(221452);
    PDL = new a((byte)0);
    AppMethodBeat.o(221452);
  }
  
  public d()
  {
    AppMethodBeat.i(221451);
    this.PDH = new m((androidx.lifecycle.l)this);
    this.PDI = new r();
    this.PDJ = new HashSet();
    this.uVu = new LinkedList();
    this.PDK = new LinkedList();
    AppMethodBeat.o(221451);
  }
  
  private final Integer b(final f.b paramb)
  {
    AppMethodBeat.i(221448);
    LinkedList localLinkedList;
    Object localObject1;
    try
    {
      localLinkedList = new LinkedList();
      localObject1 = ((Iterable)paramb.PDZ).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (f.a)((Iterator)localObject1).next();
        euw localeuw = new euw();
        localeuw.UwE = 1;
        localeuw.UwF = ((f.a)localObject2).PDX;
        localeuw.CPw = 17;
        localLinkedList.add(localeuw);
      }
      localObject1 = new cdv();
    }
    catch (Exception paramb)
    {
      Log.e("MicroMsg.WebTransCgiLogic", "translate: do cgi failed！！！");
      AppMethodBeat.o(221448);
      return null;
    }
    ((cdv)localObject1).TlE = localLinkedList;
    ((cdv)localObject1).rVw = localLinkedList.size();
    Object localObject2 = new com.tencent.mm.an.d.a();
    ((com.tencent.mm.an.d.a)localObject2).c((com.tencent.mm.cd.a)localObject1);
    ((com.tencent.mm.an.d.a)localObject2).d((com.tencent.mm.cd.a)new cdw());
    ((com.tencent.mm.an.d.a)localObject2).TW("/cgi-bin/micromsg-bin/gettranstext");
    ((com.tencent.mm.an.d.a)localObject2).vD(631);
    ((com.tencent.mm.an.d.a)localObject2).vF(0);
    ((com.tencent.mm.an.d.a)localObject2).vG(0);
    localObject2 = ((com.tencent.mm.an.d.a)localObject2).bgN();
    final int i = ((cdv)localObject1).hashCode();
    this.PDJ.add(Integer.valueOf(i));
    Log.i("MicroMsg.WebTransCgiLogic", "translate: reqStringList size = " + localLinkedList.size() + " hashcode = " + i);
    IPCRunCgi.a((com.tencent.mm.an.d)localObject2, (IPCRunCgi.a)new b(this, i, paramb));
    AppMethodBeat.o(221448);
    return Integer.valueOf(i);
  }
  
  private final void gSb()
  {
    AppMethodBeat.i(221439);
    while ((((Collection)this.PDK).size() < 8) && (!this.uVu.isEmpty()))
    {
      f.b localb = (f.b)j.lo((List)this.uVu);
      if (((Collection)this.uVu).size() > 0) {
        this.uVu.remove(0);
      }
      this.PDK.add(localb);
      b(localb);
    }
    AppMethodBeat.o(221439);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(221436);
    p.k(paramb, "wholePack");
    p.k(paramb, "wholePack");
    LinkedList localLinkedList = new LinkedList();
    if (((Collection)paramb.PDZ).size() == 0) {
      Log.w("MicroMsg.WebTransCgiLogic", "slicePack parameters are wrong!");
    }
    for (;;)
    {
      this.uVu.addAll((Collection)localLinkedList);
      gSb();
      AppMethodBeat.o(221436);
      return;
      int j = ((Collection)paramb.PDZ).size() / 20;
      int i = j;
      if (((Collection)paramb.PDZ).size() % 20 > 0) {
        i = j + 1;
      }
      j = 0;
      while (j < i)
      {
        int k = j * 20;
        int m = Math.min(20, ((Collection)paramb.PDZ).size() - k);
        f.b localb = new f.b();
        localb.e(paramb.PDZ, k, m + k);
        localLinkedList.add(localb);
        j += 1;
      }
    }
  }
  
  public final h getLifecycle()
  {
    return (h)this.PDH;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/WebTransCgiLogic$Companion;", "", "()V", "TAG", "", "WEBTRANS_MAX_REQUEST_CHANNEL_NUM", "", "WEBTRANS_MAX_REQUEST_PER_PACK_NODE_NUM", "plugin-webview_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class b
    implements IPCRunCgi.a
  {
    b(d paramd, int paramInt, f.b paramb) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd)
    {
      AppMethodBeat.i(266195);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i("MicroMsg.WebTransCgiLogic", "translate: onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(266195);
        return;
      }
      if (!d.a(this.PDM).contains(Integer.valueOf(i)))
      {
        Log.w("MicroMsg.WebTransCgiLogic", "translate: hashCode has been erased, lifecycle is end!");
        d.a(this.PDM).remove(Integer.valueOf(i));
        AppMethodBeat.o(266195);
        return;
      }
      paramString = this.PDM;
      p.j(paramd, "rr");
      d.a(paramString, paramd, paramb);
      AppMethodBeat.o(266195);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(d paramd, f.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d
 * JD-Core Version:    0.7.0.1
 */