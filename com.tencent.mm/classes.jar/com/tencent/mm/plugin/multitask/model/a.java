package com.tencent.mm.plugin.multitask.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/model/MultiTaskStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "checkAndMove", "", "item", "deleteById", "id", "", "getById", "getMultiTaskInfoList", "", "getTaskListByType", "type", "", "insert", "update", "keys", "", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;[Ljava/lang/String;)Z", "Companion", "plugin-multitask_release"})
public final class a
  extends MAutoStorage<MultiTaskInfo>
{
  public static final a.a AbX;
  private static final String[] SQL_CREATE;
  private static final String TAG = "MicroMsg.MultiTask.MultiTaskStorage";
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(200629);
    AbX = new a.a((byte)0);
    TAG = "MicroMsg.MultiTask.MultiTaskStorage";
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(MultiTaskInfo.info, "MultiTaskInfo") };
    AppMethodBeat.o(200629);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, MultiTaskInfo.info, "MultiTaskInfo", null);
    AppMethodBeat.i(200628);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(200628);
  }
  
  public final boolean a(MultiTaskInfo paramMultiTaskInfo, String... paramVarArgs)
  {
    AppMethodBeat.i(200624);
    p.h(paramVarArgs, "keys");
    boolean bool = updateNotify((IAutoDBItem)paramMultiTaskInfo, false, new String[0]);
    if (bool) {
      doNotify("single", 3, paramMultiTaskInfo);
    }
    paramVarArgs = TAG;
    StringBuilder localStringBuilder = new StringBuilder("update ");
    if (paramMultiTaskInfo != null) {}
    for (paramMultiTaskInfo = paramMultiTaskInfo.field_id;; paramMultiTaskInfo = null)
    {
      b.i(paramVarArgs, paramMultiTaskInfo + ' ' + bool, new Object[0]);
      AppMethodBeat.o(200624);
      return bool;
    }
  }
  
  public final MultiTaskInfo aGM(String paramString)
  {
    AppMethodBeat.i(200626);
    p.h(paramString, "id");
    Cursor localCursor = this.db.rawQuery("SELECT * FROM MultiTaskInfo WHERE id = ?;", new String[] { paramString });
    paramString = null;
    if (localCursor.moveToNext())
    {
      paramString = new MultiTaskInfo();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(200626);
    return paramString;
  }
  
  public final List<MultiTaskInfo> eri()
  {
    AppMethodBeat.i(200627);
    Object localObject = this.db.rawQuery("SELECT * FROM MultiTaskInfo ORDER BY createTime DESC;", null);
    ArrayList localArrayList = new ArrayList();
    while (((Cursor)localObject).moveToNext())
    {
      MultiTaskInfo localMultiTaskInfo = new MultiTaskInfo();
      localMultiTaskInfo.convertFrom((Cursor)localObject);
      localArrayList.add(localMultiTaskInfo);
    }
    ((Cursor)localObject).close();
    localObject = (List)localArrayList;
    AppMethodBeat.o(200627);
    return localObject;
  }
  
  public final boolean h(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(200622);
    p.h(paramMultiTaskInfo, "item");
    boolean bool = insertNotify((IAutoDBItem)paramMultiTaskInfo, false);
    if (bool) {
      doNotify("single", 2, paramMultiTaskInfo);
    }
    b.i(TAG, "insert " + paramMultiTaskInfo.field_id + ' ' + bool, new Object[0]);
    AppMethodBeat.o(200622);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.model.a
 * JD-Core Version:    0.7.0.1
 */