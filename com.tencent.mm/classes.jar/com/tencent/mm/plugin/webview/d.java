package com.tencent.mm.plugin.webview;

import androidx.lifecycle.j;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.ctw;
import com.tencent.mm.protocal.protobuf.fqj;
import com.tencent.mm.protocal.protobuf.fqk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/WebTransCgiLogic;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "hasSendCgiNum", "", "getHasSendCgiNum", "()I", "setHasSendCgiNum", "(I)V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "liveTransTextRes", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/webview/WebTransData$WebTransPack;", "getLiveTransTextRes", "()Landroidx/lifecycle/MutableLiveData;", "setLiveTransTextRes", "(Landroidx/lifecycle/MutableLiveData;)V", "requestingQueue", "Ljava/util/LinkedList;", "getRequestingQueue", "()Ljava/util/LinkedList;", "setRequestingQueue", "(Ljava/util/LinkedList;)V", "sendPackHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "waitingQueue", "getWaitingQueue", "setWaitingQueue", "doCgiReq", "pack", "(Lcom/tencent/mm/plugin/webview/WebTransData$WebTransPack;)Ljava/lang/Integer;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "handleResp", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sendPack", "onDestroy", "onStart", "slicePack", "wholePack", "startCgiTransTask", "updateRequestQueueAndSend", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements q
{
  public static final a Wum;
  x<f.b> Wun;
  final HashSet<Integer> Wuo;
  private LinkedList<f.b> Wup;
  private int Wuq;
  androidx.lifecycle.s nvu;
  private LinkedList<f.b> yhX;
  
  static
  {
    AppMethodBeat.i(294703);
    Wum = new a((byte)0);
    AppMethodBeat.o(294703);
  }
  
  public d()
  {
    AppMethodBeat.i(294668);
    this.nvu = new androidx.lifecycle.s((q)this);
    this.Wun = new x();
    this.Wuo = new HashSet();
    this.yhX = new LinkedList();
    this.Wup = new LinkedList();
    AppMethodBeat.o(294668);
  }
  
  private static final void a(d paramd, final f.b paramb, int paramInt1, int paramInt2, int paramInt3, String paramString, c paramc)
  {
    AppMethodBeat.i(294695);
    kotlin.g.b.s.u(paramd, "this$0");
    kotlin.g.b.s.u(paramb, "$pack");
    paramd.Wup.remove(paramb);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.i("MicroMsg.WebTransCgiLogic", "translate: onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      AppMethodBeat.o(294695);
      return;
    }
    if (!paramd.Wuo.contains(Integer.valueOf(paramInt1)))
    {
      Log.w("MicroMsg.WebTransCgiLogic", "translate: hashCode has been erased, lifecycle is end!");
      paramd.Wuo.remove(Integer.valueOf(paramInt1));
      AppMethodBeat.o(294695);
      return;
    }
    kotlin.g.b.s.s(paramc, "rr");
    paramString = c.c.b(paramc.otC);
    if (paramString == null)
    {
      paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetTransTextResponse");
      AppMethodBeat.o(294695);
      throw paramd;
    }
    paramc = (ctw)paramString;
    Iterator localIterator = ((Iterable)paramb.WuC).iterator();
    paramInt1 = 0;
    if (localIterator.hasNext())
    {
      paramString = localIterator.next();
      if (paramInt1 < 0) {
        p.kkW();
      }
      f.a locala = (f.a)paramString;
      paramString = (fqk)paramc.aazx.get(paramInt1);
      if (paramString == null)
      {
        paramString = null;
        label228:
        locala.WuB = paramString;
        paramString = (fqk)paramc.aazx.get(paramInt1);
        if (paramString != null) {
          break label281;
        }
      }
      label281:
      for (paramString = null;; paramString = paramString.aaZO)
      {
        locala.brand = paramString;
        paramInt1 += 1;
        break;
        paramString = paramString.TSI;
        break label228;
      }
    }
    paramd.irs();
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramd, paramb));
    AppMethodBeat.o(294695);
  }
  
  private final Integer b(f.b paramb)
  {
    AppMethodBeat.i(294682);
    Object localObject1;
    try
    {
      LinkedList localLinkedList = new LinkedList();
      localObject1 = ((Iterable)paramb.WuC).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (f.a)((Iterator)localObject1).next();
        fqj localfqj = new fqj();
        localfqj.abQm = 1;
        localfqj.abQn = ((f.a)localObject2).WuA;
        localfqj.IJG = 17;
        localLinkedList.add(localfqj);
      }
      localObject1 = new ctv();
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WebTransCgiLogic", "translate: do cgi failed！！！");
      this.Wup.remove(paramb);
      AppMethodBeat.o(294682);
      return null;
    }
    ((ctv)localObject1).aazx = localException;
    ((ctv)localObject1).vgM = localException.size();
    Object localObject2 = new c.a();
    ((c.a)localObject2).otE = ((com.tencent.mm.bx.a)localObject1);
    ((c.a)localObject2).otF = ((com.tencent.mm.bx.a)new ctw());
    ((c.a)localObject2).uri = "/cgi-bin/micromsg-bin/gettranstext";
    ((c.a)localObject2).funcId = 631;
    ((c.a)localObject2).otG = 0;
    ((c.a)localObject2).respCmdId = 0;
    localObject2 = ((c.a)localObject2).bEF();
    int i = ((ctv)localObject1).hashCode();
    this.Wuo.add(Integer.valueOf(i));
    Log.i("MicroMsg.WebTransCgiLogic", "translate: reqStringList size = " + localException.size() + " hashcode = " + i);
    IPCRunCgi.a((c)localObject2, new d..ExternalSyntheticLambda0(this, paramb, i));
    AppMethodBeat.o(294682);
    return Integer.valueOf(i);
  }
  
  private final void irs()
  {
    AppMethodBeat.i(294672);
    while ((((Collection)this.Wup).size() < 8) && (!this.yhX.isEmpty()))
    {
      f.b localb = (f.b)p.oK((List)this.yhX);
      if (((Collection)this.yhX).size() > 0) {
        this.yhX.remove(0);
      }
      this.Wup.add(localb);
      this.Wuq += 1;
      if (this.Wuq > 2000)
      {
        this.yhX.clear();
        Log.e("MicroMsg.WebTransCgiLogic", "cgi num over limit! %d", new Object[] { Integer.valueOf(2000) });
        AppMethodBeat.o(294672);
        return;
      }
      b(localb);
    }
    AppMethodBeat.o(294672);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(294717);
    kotlin.g.b.s.u(paramb, "wholePack");
    kotlin.g.b.s.u(paramb, "wholePack");
    LinkedList localLinkedList = new LinkedList();
    if (((Collection)paramb.WuC).size() == 0)
    {
      Log.w("MicroMsg.WebTransCgiLogic", "slicePack parameters are wrong!");
      this.yhX.addAll((Collection)localLinkedList);
      irs();
      AppMethodBeat.o(294717);
      return;
    }
    int i = ((Collection)paramb.WuC).size() / 20;
    if (((Collection)paramb.WuC).size() % 20 > 0) {
      i += 1;
    }
    for (;;)
    {
      int j = 0;
      if (i <= 0) {
        break;
      }
      for (;;)
      {
        int k = j + 1;
        j *= 20;
        int m = Math.min(20, ((Collection)paramb.WuC).size() - j);
        f.b localb = new f.b();
        localb.h(paramb.WuC, j, m + j);
        localLinkedList.add(localb);
        if (k >= i) {
          break;
        }
        j = k;
      }
    }
  }
  
  public final j getLifecycle()
  {
    return (j)this.nvu;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/WebTransCgiLogic$Companion;", "", "()V", "TAG", "", "WEBTRANS_MAX_REQUEST_CGI_NUM", "", "WEBTRANS_MAX_REQUEST_CHANNEL_NUM", "WEBTRANS_MAX_REQUEST_PER_PACK_NODE_NUM", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(d paramd, f.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d
 * JD-Core Version:    0.7.0.1
 */