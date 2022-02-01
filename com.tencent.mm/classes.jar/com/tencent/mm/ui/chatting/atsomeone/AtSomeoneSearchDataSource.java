package com.tencent.mm.ui.chatting.atsomeone;

import androidx.lifecycle.h.a;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.livelist.a.c;
import com.tencent.mm.plugin.livelist.a.d;
import com.tencent.mm.plugin.livelist.i;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.b.e;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneSearchDataSource;", "Lcom/tencent/mm/plugin/livelist/datasource/BaseSearchDataSource;", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "", "Landroidx/lifecycle/LifecycleObserver;", "chatroom", "(Ljava/lang/String;)V", "getChatroom", "()Ljava/lang/String;", "currentSearchTask", "Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "resultListener", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneSearchDataSource$FTSResultListener;", "destroy", "", "getSearchData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/livelist/datasource/DataResponse;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dataRequest", "Lcom/tencent/mm/plugin/livelist/SearchDataRequest;", "stopSearch", "Companion", "FTSResultListener", "app_release"})
public final class AtSomeoneSearchDataSource
  extends com.tencent.mm.plugin.livelist.a.b<f, String>
  implements androidx.lifecycle.k
{
  public static final AtSomeoneSearchDataSource.a WGt;
  private com.tencent.mm.plugin.fts.a.a.a WGr;
  private b WGs;
  private final String fxT;
  private final kotlin.f ocu;
  
  static
  {
    AppMethodBeat.i(288291);
    WGt = new AtSomeoneSearchDataSource.a((byte)0);
    AppMethodBeat.o(288291);
  }
  
  public AtSomeoneSearchDataSource(String paramString)
  {
    AppMethodBeat.i(288290);
    this.fxT = paramString;
    this.ocu = kotlin.g.ar((kotlin.g.a.a)AtSomeoneSearchDataSource.c.WGv);
    AppMethodBeat.o(288290);
  }
  
  public final kotlinx.coroutines.b.b<d<f>> a(ak paramak, i<f, String> parami)
  {
    AppMethodBeat.i(288287);
    p.k(paramak, "scope");
    p.k(parami, "dataRequest");
    paramak = new kotlinx.coroutines.a.n();
    com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
    localj.BIN = this.fxT;
    localj.query = ((String)parami.EiA);
    localj.nRn = 12;
    localj.handler = ((MMHandler)this.ocu.getValue());
    this.WGs = new b((c)parami, paramak);
    localj.BIU = ((com.tencent.mm.plugin.fts.a.l)this.WGs);
    localj.BIS.add(z.bcZ());
    if (this.WGr != null) {
      ((com.tencent.mm.plugin.fts.a.n)h.ag(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.WGr);
    }
    this.WGr = ((com.tencent.mm.plugin.fts.a.n)h.ag(com.tencent.mm.plugin.fts.a.n.class)).search(2, localj);
    paramak = e.a((kotlinx.coroutines.a.f)paramak);
    AppMethodBeat.o(288287);
    return paramak;
  }
  
  @t(jl=h.a.ON_DESTROY)
  public final void destroy()
  {
    AppMethodBeat.i(288286);
    if (this.WGr != null) {
      ((com.tencent.mm.plugin.fts.a.n)h.ag(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.WGr);
    }
    this.WGr = null;
    this.WGs = null;
    AppMethodBeat.o(288286);
  }
  
  public final void erx()
  {
    AppMethodBeat.i(288288);
    if (this.WGr != null) {
      ((com.tencent.mm.plugin.fts.a.n)h.ag(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.WGr);
    }
    AppMethodBeat.o(288288);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneSearchDataSource$FTSResultListener;", "Lcom/tencent/mm/plugin/fts/api/IFTSResultListener;", "request", "Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "channel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "Lcom/tencent/mm/plugin/livelist/datasource/DataResponse;", "(Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneSearchDataSource;Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;)V", "getChannel", "()Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "getRequest", "()Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;", "onFTSSearchEnd", "", "result", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "app_release"})
  public final class b
    implements com.tencent.mm.plugin.fts.a.l
  {
    private final c<f> EiB;
    private final kotlinx.coroutines.a.n<d<f>> lDN;
    
    public b(kotlinx.coroutines.a.n<d<f>> paramn)
    {
      AppMethodBeat.i(274455);
      this.EiB = paramn;
      this.lDN = localObject;
      AppMethodBeat.o(274455);
    }
    
    public final void b(com.tencent.mm.plugin.fts.a.a.k paramk)
    {
      AppMethodBeat.i(274454);
      if (paramk != null)
      {
        Object localObject1;
        if (p.h(paramk.BIV, AtSomeoneSearchDataSource.a(AtSomeoneSearchDataSource.this))) {
          localObject1 = paramk;
        }
        while (localObject1 != null) {
          switch (paramk.resultCode)
          {
          default: 
            this.lDN.iSs();
            AppMethodBeat.o(274454);
            return;
            localObject1 = null;
            break;
          case 0: 
            d locald = new d(this.EiB);
            localObject1 = paramk.BIW;
            p.j(localObject1, "result.resultList");
            localObject1 = (m)kotlin.a.j.M((List)localObject1, 0);
            if (localObject1 != null) {
              ((m)localObject1).BHY = paramk.BHY;
            }
            while (localObject1 != null)
            {
              localObject1 = ((m)localObject1).BJg;
              if (localObject1 == null) {
                break;
              }
              localObject1 = ((Iterable)localObject1).iterator();
              int i = 0;
              while (((Iterator)localObject1).hasNext())
              {
                Object localObject2 = ((Iterator)localObject1).next();
                if (i < 0) {
                  kotlin.a.j.iBO();
                }
                localObject2 = (com.tencent.mm.plugin.fts.a.a.g)localObject2;
                Object localObject3 = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
                p.j(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
                Object localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject3).bbL().RG(((com.tencent.mm.plugin.fts.a.a.g)localObject2).username);
                localObject3 = locald.mXB;
                p.j(localObject4, "contact");
                localObject4 = new f(i, (as)localObject4, 1);
                ((f)localObject4).WGk = ((com.tencent.mm.plugin.fts.a.a.g)localObject2);
                ((f)localObject4).BHY = paramk.BHY;
                ((ArrayList)localObject3).add(localObject4);
                i += 1;
              }
              localObject1 = null;
            }
            this.lDN.offer(locald);
            AppMethodBeat.o(274454);
            return;
          }
        }
      }
      AppMethodBeat.o(274454);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.atsomeone.AtSomeoneSearchDataSource
 * JD-Core Version:    0.7.0.1
 */