package com.tencent.mm.sdk.storage.executor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/executor/DeleteExecutor;", "", "item", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "event", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "observerOwner", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverOwner;", "logTag", "", "(Lcom/tencent/mm/sdk/storage/IAutoDBItem;Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;Lcom/tencent/mm/sdk/storage/observer/StorageObserverOwner;Ljava/lang/String;)V", "getItem", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "getLogTag", "()Ljava/lang/String;", "setLogTag", "(Ljava/lang/String;)V", "execute", "", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "Companion", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DeleteExecutor
{
  public static final Companion Companion;
  public static final String TAG = "MicroMsg.Mvvm.DeleteExecutor";
  private final StorageObserverEvent<? extends IAutoDBItem> event;
  private final IAutoDBItem item;
  private String logTag;
  private final StorageObserverOwner<?> observerOwner;
  
  static
  {
    AppMethodBeat.i(244260);
    Companion = new Companion(null);
    AppMethodBeat.o(244260);
  }
  
  public DeleteExecutor(IAutoDBItem paramIAutoDBItem, StorageObserverEvent<? extends IAutoDBItem> paramStorageObserverEvent, StorageObserverOwner<?> paramStorageObserverOwner, String paramString)
  {
    AppMethodBeat.i(244252);
    this.item = paramIAutoDBItem;
    this.event = paramStorageObserverEvent;
    this.observerOwner = paramStorageObserverOwner;
    this.logTag = paramString;
    AppMethodBeat.o(244252);
  }
  
  public final int execute(ISQLiteDatabase paramISQLiteDatabase)
  {
    AppMethodBeat.i(244277);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = this.item.getDBInfo();
    Object localObject2 = this.item.getPrimaryKeyValue();
    if ((paramISQLiteDatabase != null) && (localObject2 != null))
    {
      int j = paramISQLiteDatabase.delete(getItem().getTableName(), s.X(localMAutoDBInfo.primaryKey, " = ?"), new String[] { localObject2.toString() });
      if (j > 0)
      {
        paramISQLiteDatabase = this.observerOwner;
        localObject1 = this.event;
        if ((paramISQLiteDatabase != null) && (localObject1 != null)) {
          paramISQLiteDatabase.notifyAny(localObject1);
        }
      }
      if (j > 0)
      {
        paramISQLiteDatabase = (CharSequence)getLogTag();
        if ((paramISQLiteDatabase != null) && (!n.bp(paramISQLiteDatabase))) {
          break label265;
        }
      }
      label265:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          Log.i(getLogTag(), "delete table:" + getItem().getTableName() + " success primaryKey:" + localMAutoDBInfo.primaryKey + " value:" + localObject2);
        }
        if (j <= 0)
        {
          localObject1 = getLogTag();
          paramISQLiteDatabase = (ISQLiteDatabase)localObject1;
          if (localObject1 == null) {
            paramISQLiteDatabase = "MicroMsg.Mvvm.DeleteExecutor";
          }
          Log.e(paramISQLiteDatabase, "delete effectRow:" + j + " table:" + getItem().getTableName() + " fail primaryKey:" + localMAutoDBInfo.primaryKey + " value:" + localObject2);
        }
        AppMethodBeat.o(244277);
        return j;
      }
    }
    DeleteExecutor localDeleteExecutor = (DeleteExecutor)this;
    Object localObject1 = localDeleteExecutor.getLogTag();
    paramISQLiteDatabase = (ISQLiteDatabase)localObject1;
    if (localObject1 == null) {
      paramISQLiteDatabase = "MicroMsg.Mvvm.DeleteExecutor";
    }
    Log.i(paramISQLiteDatabase, "delete table:" + localDeleteExecutor.getItem().getTableName() + " fail primaryKey:" + localMAutoDBInfo.primaryKey + " value:" + localObject2);
    AppMethodBeat.o(244277);
    return -1;
  }
  
  public final IAutoDBItem getItem()
  {
    return this.item;
  }
  
  public final String getLogTag()
  {
    return this.logTag;
  }
  
  public final void setLogTag(String paramString)
  {
    this.logTag = paramString;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/executor/DeleteExecutor$Companion;", "", "()V", "TAG", "", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.executor.DeleteExecutor
 * JD-Core Version:    0.7.0.1
 */