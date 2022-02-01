package com.tencent.mm.plugin.taskbar;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/TaskBarStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteById", "", "id", "", "isNotify", "", "scene", "", "deleteOldestRecordByType", "type", "count", "getById", "getCurrentTabList", "", "getMultiTaskInfoByTabType", "getMultiTaskInfoList", "getTaskCountByType", "getTaskListByType", "insert", "item", "update", "keys", "", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;[Ljava/lang/String;)Z", "Companion", "TaskBarDeleteNotify", "plugin-taskbar_release"})
public final class h
  extends MAutoStorage<MultiTaskInfo>
{
  public static final h.a FSe;
  private static final String[] SQL_CREATE;
  final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(238431);
    FSe = new h.a((byte)0);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(MultiTaskInfo.info, "TaskBarInfo") };
    AppMethodBeat.o(238431);
  }
  
  public h(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, MultiTaskInfo.info, "TaskBarInfo", null);
    AppMethodBeat.i(238430);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(238430);
  }
  
  public final boolean a(MultiTaskInfo paramMultiTaskInfo, String... paramVarArgs)
  {
    Object localObject = null;
    AppMethodBeat.i(238427);
    p.h(paramVarArgs, "keys");
    StringBuilder localStringBuilder = new StringBuilder("update:");
    if (paramMultiTaskInfo != null)
    {
      paramVarArgs = Integer.valueOf(paramMultiTaskInfo.field_type);
      localStringBuilder = localStringBuilder.append(paramVarArgs).append(' ');
      if (paramMultiTaskInfo == null) {
        break label156;
      }
      paramVarArgs = paramMultiTaskInfo.field_id;
      label59:
      localStringBuilder = localStringBuilder.append(paramVarArgs).append(' ');
      paramVarArgs = localObject;
      if (paramMultiTaskInfo != null)
      {
        cru localcru = paramMultiTaskInfo.erh();
        paramVarArgs = localObject;
        if (localcru != null) {
          paramVarArgs = localcru.title;
        }
      }
      Log.i("MicroMsg.TaskBarStorage", paramVarArgs);
      if (paramMultiTaskInfo == null) {
        break label161;
      }
      paramVarArgs = paramMultiTaskInfo.field_data;
      if (paramVarArgs == null) {
        break label161;
      }
    }
    label156:
    label161:
    for (int i = paramVarArgs.length;; i = 0)
    {
      if (i <= 0) {
        Log.w("MicroMsg.TaskBarStorage", "empty data!");
      }
      if (paramMultiTaskInfo != null) {
        break label166;
      }
      AppMethodBeat.o(238427);
      return false;
      paramVarArgs = null;
      break;
      paramVarArgs = null;
      break label59;
    }
    label166:
    boolean bool = updateNotify((IAutoDBItem)paramMultiTaskInfo, false, new String[0]);
    doNotify("single", 3, paramMultiTaskInfo);
    AppMethodBeat.o(238427);
    return bool;
  }
  
  public final MultiTaskInfo aGM(String paramString)
  {
    AppMethodBeat.i(238429);
    p.h(paramString, "id");
    Cursor localCursor = this.db.rawQuery("SELECT * FROM TaskBarInfo WHERE id = ?;", new String[] { paramString });
    paramString = null;
    if (localCursor.moveToNext())
    {
      paramString = new MultiTaskInfo();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(238429);
    return paramString;
  }
  
  public final boolean h(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(238425);
    p.h(paramMultiTaskInfo, "item");
    Log.i("MicroMsg.TaskBarStorage", "insert:" + paramMultiTaskInfo.field_type + ' ' + paramMultiTaskInfo.field_id + ' ' + paramMultiTaskInfo.erh().title);
    byte[] arrayOfByte = paramMultiTaskInfo.field_data;
    if (arrayOfByte != null) {}
    for (int i = arrayOfByte.length;; i = 0)
    {
      if (i <= 0) {
        Log.w("MicroMsg.TaskBarStorage", "empty data!");
      }
      boolean bool = insertNotify((IAutoDBItem)paramMultiTaskInfo, false);
      doNotify("single", 2, paramMultiTaskInfo);
      AppMethodBeat.o(238425);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/TaskBarStorage$TaskBarDeleteNotify;", "", "()V", "deleteType", "", "getDeleteType", "()I", "setDeleteType", "(I)V", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getMultiTaskInfo", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "setMultiTaskInfo", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "plugin-taskbar_release"})
  public static final class b
  {
    public MultiTaskInfo Agu;
    public int FSf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.h
 * JD-Core Version:    0.7.0.1
 */