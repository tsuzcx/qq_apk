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
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/executor/UpdateExecutor;", "", "item", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "event", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "observerOwner", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverOwner;", "logTag", "", "(Lcom/tencent/mm/sdk/storage/IAutoDBItem;Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;Lcom/tencent/mm/sdk/storage/observer/StorageObserverOwner;Ljava/lang/String;)V", "getItem", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "getLogTag", "()Ljava/lang/String;", "setLogTag", "(Ljava/lang/String;)V", "execute", "", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "Companion", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class UpdateExecutor
{
  public static final Companion Companion;
  public static final String TAG = "MicroMsg.Mvvm.UpdateExecutor";
  private final StorageObserverEvent<? extends IAutoDBItem> event;
  private final IAutoDBItem item;
  private String logTag;
  private final StorageObserverOwner<?> observerOwner;
  
  static
  {
    AppMethodBeat.i(244272);
    Companion = new Companion(null);
    AppMethodBeat.o(244272);
  }
  
  public UpdateExecutor(IAutoDBItem paramIAutoDBItem, StorageObserverEvent<? extends IAutoDBItem> paramStorageObserverEvent, StorageObserverOwner<?> paramStorageObserverOwner, String paramString)
  {
    AppMethodBeat.i(244259);
    this.item = paramIAutoDBItem;
    this.event = paramStorageObserverEvent;
    this.observerOwner = paramStorageObserverOwner;
    this.logTag = paramString;
    AppMethodBeat.o(244259);
  }
  
  public final int execute(ISQLiteDatabase paramISQLiteDatabase)
  {
    int j = 0;
    AppMethodBeat.i(244313);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = this.item.getDBInfo();
    Object localObject2 = this.item.convertTo();
    int i;
    if (((ContentValues)localObject2).size() > 0)
    {
      i = 1;
      if (i == 0) {
        break label309;
      }
      label39:
      if (localObject2 != null) {
        break label315;
      }
    }
    label309:
    label315:
    for (Object localObject1 = null;; localObject1 = ((ContentValues)localObject2).get(localMAutoDBInfo.primaryKey))
    {
      if ((paramISQLiteDatabase == null) || (localObject2 == null) || (localObject1 == null)) {
        break label330;
      }
      int k = paramISQLiteDatabase.update(getItem().getTableName(), (ContentValues)localObject2, s.X(localMAutoDBInfo.primaryKey, " = ?"), new String[] { localObject1.toString() });
      if (k > 0)
      {
        paramISQLiteDatabase = this.observerOwner;
        localObject2 = this.event;
        if ((paramISQLiteDatabase != null) && (localObject2 != null)) {
          paramISQLiteDatabase.notifyAny(localObject2);
        }
      }
      if (k > 0)
      {
        paramISQLiteDatabase = (CharSequence)getLogTag();
        if (paramISQLiteDatabase != null)
        {
          i = j;
          if (!n.bp(paramISQLiteDatabase)) {}
        }
        else
        {
          i = 1;
        }
        if (i == 0) {
          Log.i(getLogTag(), "update table:" + getItem().getTableName() + " success primaryKey:" + localMAutoDBInfo.primaryKey + " value:" + localObject1);
        }
      }
      if (k <= 0)
      {
        localObject2 = getLogTag();
        paramISQLiteDatabase = (ISQLiteDatabase)localObject2;
        if (localObject2 == null) {
          paramISQLiteDatabase = "MicroMsg.Mvvm.UpdateExecutor";
        }
        Log.e(paramISQLiteDatabase, "update effectRow:" + k + " table:" + getItem().getTableName() + " fail primaryKey:" + localMAutoDBInfo.primaryKey + " value:" + localObject1);
      }
      AppMethodBeat.o(244313);
      return k;
      i = 0;
      break;
      localObject2 = null;
      break label39;
    }
    label330:
    UpdateExecutor localUpdateExecutor = (UpdateExecutor)this;
    localObject2 = localUpdateExecutor.getLogTag();
    paramISQLiteDatabase = (ISQLiteDatabase)localObject2;
    if (localObject2 == null) {
      paramISQLiteDatabase = "MicroMsg.Mvvm.UpdateExecutor";
    }
    Log.i(paramISQLiteDatabase, "update table:" + localUpdateExecutor.getItem().getTableName() + " fail primaryKey:" + localMAutoDBInfo.primaryKey + " value:" + localObject1);
    AppMethodBeat.o(244313);
    return 0;
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/executor/UpdateExecutor$Companion;", "", "()V", "TAG", "", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.executor.UpdateExecutor
 * JD-Core Version:    0.7.0.1
 */