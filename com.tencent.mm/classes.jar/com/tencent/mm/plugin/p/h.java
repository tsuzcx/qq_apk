package com.tencent.mm.plugin.p;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.pending.PendingEventHandler;
import com.tencent.mm.sdk.event.pending.PendingEventNotifier;
import com.tencent.mm.sdk.sql.ISqlCondition;
import com.tencent.mm.sdk.sql.MultiCondition;
import com.tencent.mm.sdk.sql.Sql.Equal;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ObservableStorage;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.b;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livestorage/MMLiveStorage;", "T", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "Lcom/tencent/mm/sdk/storage/ObservableStorage;", "dbProvider", "Lcom/tencent/mm/plugin/livestorage/ILiveDBProvider;", "(Lcom/tencent/mm/plugin/livestorage/ILiveDBProvider;)V", "getDbProvider", "()Lcom/tencent/mm/plugin/livestorage/ILiveDBProvider;", "createObserverOwner", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverOwner;", "delete", "", "item", "isNotify", "", "needLog", "(Lcom/tencent/mm/sdk/storage/IAutoDBItem;ZZ)I", "get", "cv", "Landroid/content/ContentValues;", "clazz", "Lkotlin/reflect/KClass;", "(Landroid/content/ContentValues;Lkotlin/reflect/KClass;)Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "getLogTag", "", "insert", "(Lcom/tencent/mm/sdk/storage/IAutoDBItem;ZZ)Z", "replace", "", "(Lcom/tencent/mm/sdk/storage/IAutoDBItem;ZZ)J", "update", "Companion", "LiveStorageObserverOwner", "plugin-livestorage_release"})
public abstract class h<T extends IAutoDBItem>
  extends ObservableStorage<T>
{
  public static final h.a EiX = new h.a((byte)0);
  public final c EiW;
  
  protected h(c paramc)
  {
    this.EiW = paramc;
  }
  
  public final T a(ContentValues paramContentValues, b<T> paramb)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    p.k(paramContentValues, "cv");
    p.k(paramb, "clazz");
    ISQLiteDatabase localISQLiteDatabase = this.EiW.eLT();
    if (localISQLiteDatabase != null)
    {
      localObject1 = paramContentValues.keySet();
      p.j(localObject1, "cv.keySet()");
      Iterator localIterator = ((Iterable)localObject1).iterator();
      localObject1 = localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        Object localObject3 = paramContentValues.get((String)localObject2);
        if (localObject3 != null) {
          if (localObject1 != null)
          {
            p.j(localObject2, "key");
            if (((MultiCondition)localObject1).and((ISqlCondition)new Sql.Equal((String)localObject2, localObject3.toString())) != null) {}
          }
          else
          {
            p.j(localObject2, "key");
            localObject1 = new MultiCondition((ISqlCondition)new Sql.Equal((String)localObject2, localObject3.toString()));
            localObject2 = x.aazN;
          }
        }
      }
      paramContentValues = kotlin.g.a.a(paramb).newInstance();
      p.j(paramContentValues, "clazz.java.newInstance()");
      paramContentValues = ((IAutoDBItem)paramContentValues).getTableName();
      p.j(paramContentValues, "item.tableName");
      localObject1 = new SingleTable(paramContentValues).selectAll().log(getLogTag()).where((ISqlCondition)localObject1).limit(0, 1).build().singleQuery(localISQLiteDatabase, kotlin.g.a.a(paramb));
    }
    return localObject1;
  }
  
  public StorageObserverOwner<T> createObserverOwner()
  {
    return (StorageObserverOwner)new b();
  }
  
  public String getLogTag()
  {
    return "MicroMsg.Mvvm.MMLiveStorage";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livestorage/MMLiveStorage$LiveStorageObserverOwner;", "T", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverOwner;", "Lcom/tencent/mm/sdk/event/pending/PendingEventHandler;", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "(Lcom/tencent/mm/plugin/livestorage/MMLiveStorage;)V", "notifier", "Lcom/tencent/mm/sdk/event/pending/PendingEventNotifier;", "getNotifier", "()Lcom/tencent/mm/sdk/event/pending/PendingEventNotifier;", "notifier$delegate", "Lkotlin/Lazy;", "handleEvent", "", "eventList", "", "notify", "event", "superNotify", "plugin-livestorage_release"})
  public final class b<T>
    extends StorageObserverOwner<T>
    implements PendingEventHandler<StorageObserverEvent<T>>
  {
    private final f EiY;
    
    public b()
    {
      AppMethodBeat.i(254412);
      this.EiY = g.ar((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(254412);
    }
    
    public final void handleEvent(List<? extends StorageObserverEvent<T>> paramList)
    {
      AppMethodBeat.i(254411);
      p.k(paramList, "eventList");
      super.notify(paramList);
      AppMethodBeat.o(254411);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/event/pending/PendingEventNotifier;", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "T", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<PendingEventNotifier<StorageObserverEvent<T>>>
    {
      a(h.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.p.h
 * JD-Core Version:    0.7.0.1
 */