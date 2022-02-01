package com.tencent.mm.ui.chatting.atsomeone;

import androidx.lifecycle.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.mvvmlist.a.b;
import com.tencent.mm.plugin.mvvmlist.a.d;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.j;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.b.g;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneSearchDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseSearchDataSource;", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "", "Landroidx/lifecycle/LifecycleObserver;", "chatroom", "(Ljava/lang/String;)V", "getChatroom", "()Ljava/lang/String;", "currentSearchTask", "Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "resultListener", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneSearchDataSource$FTSResultListener;", "destroy", "", "getSearchData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "dataRequest", "Lcom/tencent/mm/plugin/mvvmlist/SearchDataRequest;", "stopSearch", "Companion", "FTSResultListener", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AtSomeoneSearchDataSource
  extends b<f, String>
  implements androidx.lifecycle.p
{
  public static final AtSomeoneSearchDataSource.a aenH;
  private com.tencent.mm.plugin.fts.a.a.c DHR;
  private b aenI;
  private final String hCy;
  private final j rdm;
  
  static
  {
    AppMethodBeat.i(254196);
    aenH = new AtSomeoneSearchDataSource.a((byte)0);
    AppMethodBeat.o(254196);
  }
  
  public AtSomeoneSearchDataSource(String paramString)
  {
    AppMethodBeat.i(254187);
    this.hCy = paramString;
    this.rdm = kotlin.k.cm((a)AtSomeoneSearchDataSource.c.aenK);
    AppMethodBeat.o(254187);
  }
  
  public final g<d<f>> a(LifecycleScope paramLifecycleScope, com.tencent.mm.plugin.mvvmlist.h<f, String> paramh)
  {
    AppMethodBeat.i(254211);
    s.u(paramLifecycleScope, "scope");
    s.u(paramh, "dataRequest");
    paramLifecycleScope = new q();
    com.tencent.mm.plugin.fts.a.a.l locall = new com.tencent.mm.plugin.fts.a.a.l();
    locall.Htv = this.hCy;
    locall.query = ((String)paramh.Mnu);
    locall.qRb = 12;
    locall.handler = ((MMHandler)this.rdm.getValue());
    this.aenI = new b((com.tencent.mm.plugin.mvvmlist.a.c)paramh, paramLifecycleScope);
    locall.HtC = ((com.tencent.mm.plugin.fts.a.l)this.aenI);
    locall.HtA.add(com.tencent.mm.model.z.bAM());
    if (this.DHR != null) {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.DHR);
    }
    this.DHR = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).search(2, locall);
    paramLifecycleScope = kotlinx.coroutines.b.k.a((kotlinx.coroutines.a.f)paramLifecycleScope);
    AppMethodBeat.o(254211);
    return paramLifecycleScope;
  }
  
  @androidx.lifecycle.z(Ho=j.a.ON_DESTROY)
  public final void destroy()
  {
    AppMethodBeat.i(254204);
    if (this.DHR != null) {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.DHR);
    }
    this.DHR = null;
    this.aenI = null;
    AppMethodBeat.o(254204);
  }
  
  public final void eui()
  {
    AppMethodBeat.i(254214);
    if (this.DHR != null) {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.DHR);
    }
    AppMethodBeat.o(254214);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneSearchDataSource$FTSResultListener;", "Lcom/tencent/mm/plugin/fts/api/IFTSResultListener;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "channel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "(Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneSearchDataSource;Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;)V", "getChannel", "()Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "getRequest", "()Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "onFTSSearchEnd", "", "result", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements com.tencent.mm.plugin.fts.a.l
  {
    private final com.tencent.mm.plugin.mvvmlist.a.c<f> DHT;
    private final q<d<f>> ovy;
    
    public b(q<d<f>> paramq)
    {
      AppMethodBeat.i(254185);
      this.DHT = paramq;
      this.ovy = localObject;
      AppMethodBeat.o(254185);
    }
    
    public final void b(m paramm)
    {
      AppMethodBeat.i(254195);
      if (paramm != null)
      {
        Object localObject1 = AtSomeoneSearchDataSource.this;
        d locald;
        if (s.p(paramm.HtE, AtSomeoneSearchDataSource.a((AtSomeoneSearchDataSource)localObject1)))
        {
          localObject1 = paramm;
          if (localObject1 == null) {
            break label268;
          }
          if (paramm.resultCode != 0) {
            break label256;
          }
          locald = new d(this.DHT);
          localObject1 = paramm.HtF;
          s.s(localObject1, "result.resultList");
          localObject1 = (o)kotlin.a.p.ae((List)localObject1, 0);
          if (localObject1 != null) {
            break label229;
          }
          localObject1 = null;
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label240;
          }
          localObject1 = ((o)localObject1).HtP;
          if (localObject1 == null) {
            break label240;
          }
          localObject1 = ((Iterable)localObject1).iterator();
          int i = 0;
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = ((Iterator)localObject1).next();
            if (i < 0) {
              kotlin.a.p.kkW();
            }
            Object localObject3 = (i)localObject2;
            Object localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(((i)localObject3).username);
            localObject2 = locald.pUj;
            s.s(localObject4, "contact");
            localObject4 = new f(i, (au)localObject4, 1);
            ((f)localObject4).aenF = ((i)localObject3);
            ((f)localObject4).FWt = paramm.FWt;
            localObject3 = ah.aiuX;
            ((ArrayList)localObject2).add(localObject4);
            i += 1;
          }
          localObject1 = null;
          break;
          label229:
          ((o)localObject1).FWt = paramm.FWt;
        }
        label240:
        this.ovy.offer(locald);
        AppMethodBeat.o(254195);
        return;
        label256:
        ((kotlinx.coroutines.a.f)this.ovy).kDk();
      }
      label268:
      AppMethodBeat.o(254195);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.atsomeone.AtSomeoneSearchDataSource
 * JD-Core Version:    0.7.0.1
 */