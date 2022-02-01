package com.tencent.mm.plugin.recordvideo.background;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.io.Closeable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.f.b;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "cleanExpiredTask", "", "deleteByTaskId", "taskId", "", "droptable", "", "getByTaskId", "getLastDataIfNoMix", "limitTime", "", "updateByTaskId", "editorData", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends MAutoStorage<c>
{
  public static final d.a NDT;
  private static final String[] SQL_CREATE;
  private static final String TAG;
  static final String ptT;
  final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(75188);
    NDT = new d.a((byte)0);
    TAG = "MicroMsg.VideoEditDataStorage";
    Object localObject = c.NDN;
    localObject = c.chg();
    c.a locala = c.NDN;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs((IAutoDBItem.MAutoDBInfo)localObject, c.gGG()) };
    localObject = c.NDN;
    ptT = c.gGG();
    AppMethodBeat.o(75188);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, (IAutoDBItem.MAutoDBInfo)localObject1, (String)localObject2, c.gGH());
    AppMethodBeat.i(75187);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(75187);
  }
  
  public final int a(String paramString, c paramc)
  {
    AppMethodBeat.i(75184);
    s.u(paramString, "taskId");
    s.u(paramc, "editorData");
    paramc = paramc.convertTo();
    paramc.remove("rowid");
    int i = this.db.update(ptT, paramc, "taskId=?", new String[] { s.X("", paramString) });
    AppMethodBeat.o(75184);
    return i;
  }
  
  public final c aSO(String paramString)
  {
    AppMethodBeat.i(75183);
    s.u(paramString, "taskId");
    Object localObject1 = am.aixg;
    paramString = String.format("select * from %s where %s=\"%s\"", Arrays.copyOf(new Object[] { ptT, "taskId", paramString }, 3));
    s.s(paramString, "java.lang.String.format(format, *args)");
    paramString = rawQuery(paramString, new String[0]);
    if (paramString != null) {
      paramString = (Closeable)paramString;
    }
    try
    {
      localObject1 = (Cursor)paramString;
      if (((Cursor)localObject1).moveToFirst())
      {
        c localc = new c();
        localc.convertFrom((Cursor)localObject1);
        b.a(paramString, null);
        AppMethodBeat.o(75183);
        return localc;
      }
      localObject1 = ah.aiuX;
      b.a(paramString, null);
      AppMethodBeat.o(75183);
      return null;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(75183);
        throw localThrowable;
      }
      finally
      {
        b.a(paramString, localThrowable);
        AppMethodBeat.o(75183);
      }
    }
  }
  
  public final void gGK()
  {
    AppMethodBeat.i(75186);
    int i = this.db.delete(ptT, null, null);
    Log.i(TAG, s.X("dropTable ", Integer.valueOf(i)));
    AppMethodBeat.o(75186);
  }
  
  public final c tr(long paramLong)
  {
    AppMethodBeat.i(75185);
    Object localObject1 = am.aixg;
    localObject1 = ptT;
    Object localObject2 = c.b.NDQ;
    int i = c.b.cHj();
    localObject2 = c.b.NDQ;
    localObject1 = String.format("select * from %s where %s not in (%d, %d) and %s > %d - %s order by %s asc limit 1", Arrays.copyOf(new Object[] { localObject1, "status", Integer.valueOf(i), Integer.valueOf(c.b.gGJ()), "timeStamp", Long.valueOf(paramLong), "expiredTime", "timeStamp" }, 8));
    s.s(localObject1, "java.lang.String.format(format, *args)");
    localObject1 = rawQuery((String)localObject1, new String[0]);
    if (localObject1 != null) {
      localObject1 = (Closeable)localObject1;
    }
    try
    {
      localObject2 = (Cursor)localObject1;
      if (((Cursor)localObject2).moveToFirst())
      {
        c localc = new c();
        localc.convertFrom((Cursor)localObject2);
        b.a((Closeable)localObject1, null);
        AppMethodBeat.o(75185);
        return localc;
      }
      localObject2 = ah.aiuX;
      b.a((Closeable)localObject1, null);
      AppMethodBeat.o(75185);
      return null;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(75185);
        throw localThrowable;
      }
      finally
      {
        b.a((Closeable)localObject1, localThrowable);
        AppMethodBeat.o(75185);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.d
 * JD-Core Version:    0.7.0.1
 */