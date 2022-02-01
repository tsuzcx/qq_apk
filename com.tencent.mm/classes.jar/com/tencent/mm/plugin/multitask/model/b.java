package com.tencent.mm.plugin.multitask.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ac.g;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.mvvm.IMvvmDBProvider;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/model/MultiTaskLiveStorage;", "Lcom/tencent/mm/plugin/mvvmstorage/MvvmStorage;", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "dbProvider", "Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;", "(Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;)V", "checkAndMove", "", "item", "createObserverOwner", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverOwner;", "deleteById", "id", "", "getById", "getMultiTaskInfoList", "", "getTaskListByType", "type", "", "Companion", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends g<MultiTaskInfo>
{
  public static final b.a LDg;
  
  static
  {
    AppMethodBeat.i(303820);
    LDg = new b.a((byte)0);
    AppMethodBeat.o(303820);
  }
  
  public b(IMvvmDBProvider paramIMvvmDBProvider)
  {
    super(paramIMvvmDBProvider);
    AppMethodBeat.i(303805);
    AppMethodBeat.o(303805);
  }
  
  public final MultiTaskInfo aNT(String paramString)
  {
    AppMethodBeat.i(303833);
    s.u(paramString, "id");
    Object localObject1 = this.MnQ.getDB();
    if (localObject1 != null)
    {
      paramString = ((ISQLiteDatabase)localObject1).rawQuery("SELECT * FROM MultiTaskInfo WHERE id = ?;", new String[] { paramString });
      if (paramString != null) {
        paramString = (Closeable)paramString;
      }
    }
    try
    {
      localObject1 = (Cursor)paramString;
      if (((Cursor)localObject1).moveToNext())
      {
        MultiTaskInfo localMultiTaskInfo = new MultiTaskInfo();
        localMultiTaskInfo.convertFrom((Cursor)localObject1);
        kotlin.f.b.a(paramString, null);
        AppMethodBeat.o(303833);
        return localMultiTaskInfo;
      }
      localObject1 = ah.aiuX;
      kotlin.f.b.a(paramString, null);
      AppMethodBeat.o(303833);
      return null;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(303833);
        throw localThrowable;
      }
      finally
      {
        kotlin.f.b.a(paramString, localThrowable);
        AppMethodBeat.o(303833);
      }
    }
  }
  
  public final List<MultiTaskInfo> acp(int paramInt)
  {
    AppMethodBeat.i(303858);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.MnQ.getDB();
    if (localObject1 != null)
    {
      localObject1 = ((ISQLiteDatabase)localObject1).rawQuery("SELECT * FROM MultiTaskInfo WHERE type = ? ORDER BY createTime DESC;", new String[] { String.valueOf(paramInt) });
      if (localObject1 != null)
      {
        localObject1 = (Closeable)localObject1;
        try
        {
          Cursor localCursor = (Cursor)localObject1;
          while (localCursor.moveToNext())
          {
            MultiTaskInfo localMultiTaskInfo = new MultiTaskInfo();
            localMultiTaskInfo.convertFrom(localCursor);
            ah localah2 = ah.aiuX;
            localArrayList.add(localMultiTaskInfo);
          }
          ah localah1;
          localList = (List)localThrowable;
        }
        finally
        {
          try
          {
            AppMethodBeat.o(303858);
            throw localThrowable;
          }
          finally
          {
            kotlin.f.b.a((Closeable)localObject1, localThrowable);
            AppMethodBeat.o(303858);
          }
          localah1 = ah.aiuX;
          kotlin.f.b.a((Closeable)localObject1, null);
        }
      }
    }
    List localList;
    AppMethodBeat.o(303858);
    return localList;
  }
  
  public final StorageObserverOwner<MultiTaskInfo> createObserverOwner()
  {
    AppMethodBeat.i(303882);
    StorageObserverOwner localStorageObserverOwner = new StorageObserverOwner();
    AppMethodBeat.o(303882);
    return localStorageObserverOwner;
  }
  
  public final List<MultiTaskInfo> gki()
  {
    AppMethodBeat.i(303872);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.MnQ.getDB();
    if (localObject1 != null)
    {
      localObject1 = ((ISQLiteDatabase)localObject1).rawQuery("SELECT * FROM MultiTaskInfo ORDER BY createTime DESC;", null);
      if (localObject1 != null)
      {
        localObject1 = (Closeable)localObject1;
        try
        {
          Cursor localCursor = (Cursor)localObject1;
          while (localCursor.moveToNext())
          {
            MultiTaskInfo localMultiTaskInfo = new MultiTaskInfo();
            localMultiTaskInfo.convertFrom(localCursor);
            ah localah2 = ah.aiuX;
            localArrayList.add(localMultiTaskInfo);
          }
          ah localah1;
          localList = (List)localThrowable;
        }
        finally
        {
          try
          {
            AppMethodBeat.o(303872);
            throw localThrowable;
          }
          finally
          {
            kotlin.f.b.a((Closeable)localObject1, localThrowable);
            AppMethodBeat.o(303872);
          }
          localah1 = ah.aiuX;
          kotlin.f.b.a((Closeable)localObject1, null);
        }
      }
    }
    List localList;
    AppMethodBeat.o(303872);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.model.b
 * JD-Core Version:    0.7.0.1
 */