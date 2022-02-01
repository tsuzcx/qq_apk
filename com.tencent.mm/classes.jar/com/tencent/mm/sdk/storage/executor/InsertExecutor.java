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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/executor/InsertExecutor;", "", "item", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "noCatch", "", "event", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "observerOwner", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverOwner;", "logTag", "", "(Lcom/tencent/mm/sdk/storage/IAutoDBItem;ZLcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;Lcom/tencent/mm/sdk/storage/observer/StorageObserverOwner;Ljava/lang/String;)V", "getEvent", "()Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "getItem", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "getLogTag", "()Ljava/lang/String;", "setLogTag", "(Ljava/lang/String;)V", "getNoCatch", "()Z", "getObserverOwner", "()Lcom/tencent/mm/sdk/storage/observer/StorageObserverOwner;", "execute", "", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "Companion", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class InsertExecutor
{
  public static final Companion Companion;
  public static final String TAG = "MicroMsg.Mvvm.InsertExecutor";
  private final StorageObserverEvent<? extends IAutoDBItem> event;
  private final IAutoDBItem item;
  private String logTag;
  private final boolean noCatch;
  private final StorageObserverOwner<?> observerOwner;
  
  static
  {
    AppMethodBeat.i(244273);
    Companion = new Companion(null);
    AppMethodBeat.o(244273);
  }
  
  public InsertExecutor(IAutoDBItem paramIAutoDBItem, boolean paramBoolean, StorageObserverEvent<? extends IAutoDBItem> paramStorageObserverEvent, StorageObserverOwner<?> paramStorageObserverOwner, String paramString)
  {
    AppMethodBeat.i(244258);
    this.item = paramIAutoDBItem;
    this.noCatch = paramBoolean;
    this.event = paramStorageObserverEvent;
    this.observerOwner = paramStorageObserverOwner;
    this.logTag = paramString;
    AppMethodBeat.o(244258);
  }
  
  public final long execute(ISQLiteDatabase paramISQLiteDatabase)
  {
    AppMethodBeat.i(244334);
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
        break label298;
      }
      if (localObject2 != null) {
        break label304;
      }
      localObject1 = null;
      if ((paramISQLiteDatabase == null) || (localObject2 == null)) {
        break label348;
      }
      if (!getNoCatch()) {
        break label319;
      }
      l = paramISQLiteDatabase.insertOrThrow(getItem().getTableName(), localMAutoDBInfo.primaryKey, (ContentValues)localObject2);
      label82:
      if (l > 0L)
      {
        getItem().systemRowid = l;
        paramISQLiteDatabase = getObserverOwner();
        localObject2 = getEvent();
        if ((paramISQLiteDatabase != null) && (localObject2 != null)) {
          paramISQLiteDatabase.notifyAny(localObject2);
        }
      }
      if (l > 0L)
      {
        paramISQLiteDatabase = (CharSequence)getLogTag();
        if ((paramISQLiteDatabase != null) && (!n.bp(paramISQLiteDatabase))) {
          break label343;
        }
      }
    }
    label298:
    label304:
    label319:
    label343:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        Log.i(getLogTag(), "insert table:" + getItem().getTableName() + " success primaryKey:" + localMAutoDBInfo.primaryKey + " value:" + localObject1);
      }
      if (l <= 0L)
      {
        localObject2 = getLogTag();
        paramISQLiteDatabase = (ISQLiteDatabase)localObject2;
        if (localObject2 == null) {
          paramISQLiteDatabase = "MicroMsg.Mvvm.InsertExecutor";
        }
        Log.e(paramISQLiteDatabase, "insert resultRowId" + l + " table:" + getItem().getTableName() + " fail primaryKey:" + localMAutoDBInfo.primaryKey + " value:" + localObject1);
      }
      AppMethodBeat.o(244334);
      return l;
      i = 0;
      break;
      localObject2 = null;
      break label37;
      localObject1 = ((ContentValues)localObject2).get(localMAutoDBInfo.primaryKey);
      break label45;
      l = paramISQLiteDatabase.insert(getItem().getTableName(), localMAutoDBInfo.primaryKey, (ContentValues)localObject2);
      break label82;
    }
    label348:
    InsertExecutor localInsertExecutor = (InsertExecutor)this;
    localObject2 = localInsertExecutor.getLogTag();
    paramISQLiteDatabase = (ISQLiteDatabase)localObject2;
    if (localObject2 == null) {
      paramISQLiteDatabase = "MicroMsg.Mvvm.InsertExecutor";
    }
    Log.i(paramISQLiteDatabase, "insert table:" + localInsertExecutor.getItem().getTableName() + " fail primaryKey:" + localMAutoDBInfo.primaryKey + " value:" + localObject1);
    AppMethodBeat.o(244334);
    return -1L;
  }
  
  public final StorageObserverEvent<? extends IAutoDBItem> getEvent()
  {
    return this.event;
  }
  
  public final IAutoDBItem getItem()
  {
    return this.item;
  }
  
  public final String getLogTag()
  {
    return this.logTag;
  }
  
  public final boolean getNoCatch()
  {
    return this.noCatch;
  }
  
  public final StorageObserverOwner<?> getObserverOwner()
  {
    return this.observerOwner;
  }
  
  public final void setLogTag(String paramString)
  {
    this.logTag = paramString;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/executor/InsertExecutor$Companion;", "", "()V", "TAG", "", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.executor.InsertExecutor
 * JD-Core Version:    0.7.0.1
 */