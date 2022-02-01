package com.tencent.mm.plugin.taskbar;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/TaskBarStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteById", "", "id", "", "isNotify", "", "scene", "", "deleteOldestRecordByType", "type", "count", "getById", "getCurrentTabList", "", "getMultiTaskInfoByTabType", "getMultiTaskInfoList", "getTaskCountByType", "getTaskListByType", "insert", "item", "update", "keys", "", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;[Ljava/lang/String;)Z", "Companion", "TaskBarDeleteNotify", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends MAutoStorage<MultiTaskInfo>
{
  public static final h.a SQC;
  private static final String[] SQL_CREATE;
  final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(263992);
    SQC = new h.a((byte)0);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(MultiTaskInfo.info, "TaskBarInfo") };
    AppMethodBeat.o(263992);
  }
  
  public h(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, MultiTaskInfo.info, "TaskBarInfo", null);
    AppMethodBeat.i(263978);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(263978);
  }
  
  public final boolean a(MultiTaskInfo paramMultiTaskInfo, String... paramVarArgs)
  {
    Object localObject = null;
    AppMethodBeat.i(264003);
    s.u(paramVarArgs, "keys");
    StringBuilder localStringBuilder = new StringBuilder("update:");
    label50:
    label70:
    int i;
    if (paramMultiTaskInfo == null)
    {
      paramVarArgs = null;
      localStringBuilder = localStringBuilder.append(paramVarArgs).append(' ');
      if (paramMultiTaskInfo != null) {
        break label123;
      }
      paramVarArgs = null;
      localStringBuilder = localStringBuilder.append(paramVarArgs).append(' ');
      if (paramMultiTaskInfo != null) {
        break label131;
      }
      paramVarArgs = localObject;
      Log.i("MicroMsg.TaskBarStorage", paramVarArgs);
      if (paramMultiTaskInfo != null) {
        break label154;
      }
      i = 0;
    }
    for (;;)
    {
      if (i <= 0) {
        Log.w("MicroMsg.TaskBarStorage", "empty data!");
      }
      if (paramMultiTaskInfo != null) {
        break label174;
      }
      AppMethodBeat.o(264003);
      return false;
      paramVarArgs = Integer.valueOf(paramMultiTaskInfo.field_type);
      break;
      label123:
      paramVarArgs = paramMultiTaskInfo.field_id;
      break label50;
      label131:
      drz localdrz = paramMultiTaskInfo.gkh();
      paramVarArgs = localObject;
      if (localdrz == null) {
        break label70;
      }
      paramVarArgs = localdrz.title;
      break label70;
      label154:
      paramVarArgs = paramMultiTaskInfo.field_data;
      if (paramVarArgs == null) {
        i = 0;
      } else {
        i = paramVarArgs.length;
      }
    }
    label174:
    boolean bool = updateNotify((IAutoDBItem)paramMultiTaskInfo, false, new String[0]);
    doNotify("single", 3, paramMultiTaskInfo);
    AppMethodBeat.o(264003);
    return bool;
  }
  
  public final MultiTaskInfo aNT(String paramString)
  {
    AppMethodBeat.i(264009);
    s.u(paramString, "id");
    Cursor localCursor = this.db.rawQuery("SELECT * FROM TaskBarInfo WHERE id = ?;", new String[] { paramString });
    paramString = null;
    if (localCursor.moveToNext())
    {
      paramString = new MultiTaskInfo();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(264009);
    return paramString;
  }
  
  public final boolean m(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(263997);
    s.u(paramMultiTaskInfo, "item");
    Log.i("MicroMsg.TaskBarStorage", "insert:" + paramMultiTaskInfo.field_type + ' ' + paramMultiTaskInfo.field_id + ' ' + paramMultiTaskInfo.gkh().title);
    byte[] arrayOfByte = paramMultiTaskInfo.field_data;
    if (arrayOfByte == null) {}
    for (int i = 0;; i = arrayOfByte.length)
    {
      if (i <= 0) {
        Log.w("MicroMsg.TaskBarStorage", "empty data!");
      }
      boolean bool = insertNotify((IAutoDBItem)paramMultiTaskInfo, false);
      doNotify("single", 2, paramMultiTaskInfo);
      AppMethodBeat.o(263997);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/TaskBarStorage$TaskBarDeleteNotify;", "", "()V", "deleteType", "", "getDeleteType", "()I", "setDeleteType", "(I)V", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getMultiTaskInfo", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "setMultiTaskInfo", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public int Jrn;
    public MultiTaskInfo LIj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.h
 * JD-Core Version:    0.7.0.1
 */