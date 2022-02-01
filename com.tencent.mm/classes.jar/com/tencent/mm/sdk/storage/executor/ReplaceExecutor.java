package com.tencent.mm.sdk.storage.executor;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/executor/ReplaceExecutor;", "", "item", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "event", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "observerOwner", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverOwner;", "logTag", "", "(Lcom/tencent/mm/sdk/storage/IAutoDBItem;Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;Lcom/tencent/mm/sdk/storage/observer/StorageObserverOwner;Ljava/lang/String;)V", "getItem", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "getLogTag", "()Ljava/lang/String;", "setLogTag", "(Ljava/lang/String;)V", "execute", "", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "Companion", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ReplaceExecutor
{
  public static final Companion Companion;
  public static final String TAG = "MicroMsg.Mvvm.ReplaceExecutor";
  private final StorageObserverEvent<? extends IAutoDBItem> event;
  private final IAutoDBItem item;
  private String logTag;
  private final StorageObserverOwner<?> observerOwner;
  
  static
  {
    AppMethodBeat.i(244261);
    Companion = new Companion(null);
    AppMethodBeat.o(244261);
  }
  
  public ReplaceExecutor(IAutoDBItem paramIAutoDBItem, StorageObserverEvent<? extends IAutoDBItem> paramStorageObserverEvent, StorageObserverOwner<?> paramStorageObserverOwner, String paramString)
  {
    AppMethodBeat.i(244251);
    this.item = paramIAutoDBItem;
    this.event = paramStorageObserverEvent;
    this.observerOwner = paramStorageObserverOwner;
    this.logTag = paramString;
    AppMethodBeat.o(244251);
  }
  
  public final long execute(ISQLiteDatabase paramISQLiteDatabase)
  {
    AppMethodBeat.i(244278);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = this.item.getDBInfo();
    Object localObject2 = this.item.convertTo();
    label37:
    Object localObject1;
    label45:
    long l;
    if (((ContentValues)localObject2).size() > 0)
    {
      i = 1;
      if (i == 0) {
        break label288;
      }
      if (localObject2 != null) {
        break label294;
      }
      localObject1 = null;
      if ((paramISQLiteDatabase == null) || (localObject2 == null) || (localObject1 == null)) {
        break label314;
      }
      l = paramISQLiteDatabase.replace(getItem().getTableName(), localMAutoDBInfo.primaryKey, (ContentValues)localObject2);
      if (l > 0L)
      {
        paramISQLiteDatabase = this.observerOwner;
        localObject2 = this.event;
        if ((paramISQLiteDatabase != null) && (localObject2 != null)) {
          paramISQLiteDatabase.notifyAny(localObject2);
        }
      }
      if (l > 0L)
      {
        paramISQLiteDatabase = (CharSequence)getLogTag();
        if ((paramISQLiteDatabase != null) && (!n.bp(paramISQLiteDatabase))) {
          break label309;
        }
      }
    }
    label288:
    label294:
    label309:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        Log.i(getLogTag(), "replace table:" + getItem().getTableName() + " success primaryKey:" + localMAutoDBInfo.primaryKey + " value:" + localObject1);
      }
      if (l <= 0L)
      {
        localObject2 = getLogTag();
        paramISQLiteDatabase = (ISQLiteDatabase)localObject2;
        if (localObject2 == null) {
          paramISQLiteDatabase = "MicroMsg.Mvvm.ReplaceExecutor";
        }
        Log.e(paramISQLiteDatabase, "replace effectRow:" + l + " table:" + getItem().getTableName() + " fail primaryKey:" + localMAutoDBInfo.primaryKey + " value:" + localObject1);
      }
      AppMethodBeat.o(244278);
      return l;
      i = 0;
      break;
      localObject2 = null;
      break label37;
      localObject1 = ((ContentValues)localObject2).get(localMAutoDBInfo.primaryKey);
      break label45;
    }
    label314:
    ReplaceExecutor localReplaceExecutor = (ReplaceExecutor)this;
    localObject2 = localReplaceExecutor.getLogTag();
    paramISQLiteDatabase = (ISQLiteDatabase)localObject2;
    if (localObject2 == null) {
      paramISQLiteDatabase = "MicroMsg.Mvvm.ReplaceExecutor";
    }
    Log.i(paramISQLiteDatabase, "replace table:" + localReplaceExecutor.getItem().getTableName() + " fail primaryKey:" + localMAutoDBInfo.primaryKey + " value:" + localObject1);
    AppMethodBeat.o(244278);
    return -1L;
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/executor/ReplaceExecutor$Companion;", "", "()V", "TAG", "", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.executor.ReplaceExecutor
 * JD-Core Version:    0.7.0.1
 */