package com.tencent.mm.plugin.p.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.p.i;
import com.tencent.mm.sdk.event.pending.PendingEventHandler;
import com.tencent.mm.sdk.event.pending.PendingEventNotifier;
import com.tencent.mm.sdk.observer.ILifecycleObserver;
import com.tencent.mm.sdk.observer.ITypeLifecycleObserverOwner;
import com.tencent.mm.sdk.observer.ITypeLifecycleObserverOwner.DefaultImpls;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.sql.ISqlCondition;
import com.tencent.mm.sdk.storage.observer.IStorageObserver;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livestorage/contact/ContactLiveStorage;", "Lcom/tencent/mm/plugin/livestorage/BaseMMLiveStorage;", "Lcom/tencent/mm/sdk/observer/ITypeLifecycleObserverOwner;", "Lcom/tencent/mm/sdk/storage/observer/IStorageObserver;", "Lcom/tencent/mm/storage/Contact;", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "", "Lcom/tencent/mm/sdk/event/pending/PendingEventHandler;", "()V", "dbProvider", "Lcom/tencent/mm/plugin/livestorage/MainDBProvider;", "getDbProvider", "()Lcom/tencent/mm/plugin/livestorage/MainDBProvider;", "dbProvider$delegate", "Lkotlin/Lazy;", "notifier", "Lcom/tencent/mm/sdk/event/pending/PendingEventNotifier;", "getNotifier", "()Lcom/tencent/mm/sdk/event/pending/PendingEventNotifier;", "notifier$delegate", "owner", "com/tencent/mm/plugin/livestorage/contact/ContactLiveStorage$owner$2$1", "getOwner", "()Lcom/tencent/mm/plugin/livestorage/contact/ContactLiveStorage$owner$2$1;", "owner$delegate", "transactionCallback", "com/tencent/mm/plugin/livestorage/contact/ContactLiveStorage$transactionCallback$1", "Lcom/tencent/mm/plugin/livestorage/contact/ContactLiveStorage$transactionCallback$1;", "getAllKey", "getListContact", "", "usernameList", "handleEvent", "", "eventList", "hasObserver", "", "key", "observe", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "threadTag", "onCleared", "removeObserver", "Companion", "plugin-livestorage_release"})
public final class a
  extends com.tencent.mm.plugin.p.b
  implements PendingEventHandler<StorageObserverEvent<as>>, ITypeLifecycleObserverOwner<IStorageObserver<as>, StorageObserverEvent<as>, String>
{
  public static final a.a Ejf;
  private final kotlin.f EiY;
  private final kotlin.f Ejb;
  private final f Ejc;
  private final kotlin.f owner$delegate;
  
  static
  {
    AppMethodBeat.i(254460);
    Ejf = new a.a((byte)0);
    AppMethodBeat.o(254460);
  }
  
  public a()
  {
    AppMethodBeat.i(254457);
    this.Ejb = g.ar((kotlin.g.a.a)c.Ejh);
    this.Ejc = new f(this);
    h.aHE().aGH();
    Object localObject1 = h.ae(n.class);
    p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    localObject1 = ((n)localObject1).bbL();
    Object localObject2 = h.aHE();
    p.j(localObject2, "MMKernel.account()");
    localObject2 = ((com.tencent.mm.kernel.b)localObject2).aGT();
    p.j(localObject2, "MMKernel.account().accountModelOwner");
    ((bv)localObject1).observe((androidx.lifecycle.l)localObject2, (ILifecycleObserver)new IStorageObserver() {});
    h.aHG().a((h.a)this.Ejc);
    this.EiY = g.ar((kotlin.g.a.a)new d(this));
    this.owner$delegate = g.ar((kotlin.g.a.a)a.e.Eji);
    AppMethodBeat.o(254457);
  }
  
  private final a.e.1 eLV()
  {
    AppMethodBeat.i(254443);
    a.e.1 local1 = (a.e.1)this.owner$delegate.getValue();
    AppMethodBeat.o(254443);
    return local1;
  }
  
  public final List<as> fL(List<String> paramList)
  {
    AppMethodBeat.i(254455);
    p.k(paramList, "usernameList");
    Object localObject = as.TABLE.selectAll().where((ISqlCondition)as.C_USERNAME.inString(paramList)).log("MicroMsg.Mvvm.ContactLiveStorage").build();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Iterable)((SelectSql)localObject).multiQuery(((i)this.Ejb.getValue()).eLT(), as.class)).iterator();
    while (((Iterator)localObject).hasNext())
    {
      as localas = (as)((Iterator)localObject).next();
      Map localMap = (Map)localHashMap;
      String str = localas.getUsername();
      p.j(str, "contact.username");
      localMap.put(str, localas);
    }
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      localObject = (as)localHashMap.get((String)paramList.next());
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    paramList = (List)localArrayList;
    AppMethodBeat.o(254455);
    return paramList;
  }
  
  public final void handleEvent(List<? extends StorageObserverEvent<as>> paramList)
  {
    AppMethodBeat.i(254442);
    p.k(paramList, "eventList");
    Log.i("MicroMsg.Mvvm.ContactLiveStorage", "handleEvent: " + paramList.size());
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      StorageObserverEvent localStorageObserverEvent = (StorageObserverEvent)localIterator.next();
      eLV().notify(localStorageObserverEvent.getPendingKey(), localStorageObserverEvent, false);
    }
    eLV().notifyAll(paramList);
    AppMethodBeat.o(254442);
  }
  
  public final void notifyAll(List<? extends StorageObserverEvent<as>> paramList)
  {
    AppMethodBeat.i(254469);
    p.k(paramList, "eventList");
    ITypeLifecycleObserverOwner.DefaultImpls.notifyAll(this, paramList);
    AppMethodBeat.o(254469);
  }
  
  public final void observe(androidx.lifecycle.l paraml, IStorageObserver<as> paramIStorageObserver)
  {
    AppMethodBeat.i(254449);
    p.k(paraml, "lifecycleOwner");
    p.k(paramIStorageObserver, "observer");
    eLV().observe(paraml, (ILifecycleObserver)paramIStorageObserver);
    AppMethodBeat.o(254449);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(254440);
    h.aHG().b((h.a)this.Ejc);
    AppMethodBeat.o(254440);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/livestorage/MainDBProvider;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<i>
  {
    public static final c Ejh;
    
    static
    {
      AppMethodBeat.i(254387);
      Ejh = new c();
      AppMethodBeat.o(254387);
    }
    
    c()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/event/pending/PendingEventNotifier;", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "Lcom/tencent/mm/storage/Contact;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<PendingEventNotifier<StorageObserverEvent<as>>>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/livestorage/contact/ContactLiveStorage$transactionCallback$1", "Lcom/tencent/mm/storagebase/SqliteDB$Callbacks;", "postBeginTransCallback", "", "postEndTransCallback", "preCloseCallback", "plugin-livestorage_release"})
  public static final class f
    implements h.a
  {
    public final void aHw()
    {
      AppMethodBeat.i(254343);
      Log.i("MicroMsg.Mvvm.ContactLiveStorage", "preCloseCallback sqliteDB");
      a.a(this.Ejg).resumePendingNotify();
      AppMethodBeat.o(254343);
    }
    
    public final void aHx()
    {
      AppMethodBeat.i(254344);
      a.a(this.Ejg).pausePendingNotify();
      AppMethodBeat.o(254344);
    }
    
    public final void aHy()
    {
      AppMethodBeat.i(254345);
      a.a(this.Ejg).resumePendingNotify();
      AppMethodBeat.o(254345);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.p.a.a
 * JD-Core Version:    0.7.0.1
 */