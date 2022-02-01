package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.csy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/emotion/GetEmotionStoreRecListCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/storage/emotion/GetEmotionStoreRecListCacheInfo;", "Lcom/tencent/mm/storagebase/MemoryStorage$IOnAttachTable;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "table", "", "indexCreate", "", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V", "TAG", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "setDb", "deleteCache", "", "reqType", "", "get", "", "type", "getCache", "Lcom/tencent/mm/protocal/protobuf/GetStoreRecListResponse;", "insertCache", "getStoreRecListResponse", "onAttachTable", "memDB", "Lcom/tencent/mm/storagebase/MemoryStorage;", "set", "", "content", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends MAutoStorage<t>
{
  private static final String[] SQL_CREATE;
  public static final a admJ;
  private final String TAG;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(248984);
    admJ = new a((byte)0);
    Object localObject = t.admI;
    localObject = t.access$getInfo$cp();
    t.a locala = t.admI;
    localObject = MAutoStorage.getCreateSQLs((IAutoDBItem.MAutoDBInfo)localObject, "GetEmotionStoreRecListCache");
    s.s(localObject, "getCreateSQLs(GetEmotion…eRecListCacheTableName())");
    SQL_CREATE = new String[] { localObject };
    AppMethodBeat.o(248984);
  }
  
  public u(ISQLiteDatabase paramISQLiteDatabase)
  {
    this(paramISQLiteDatabase, t.access$getInfo$cp(), "GetEmotionStoreRecListCache");
    AppMethodBeat.i(248981);
    AppMethodBeat.o(248981);
  }
  
  private u(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, null);
    this.db = paramISQLiteDatabase;
    this.TAG = "MicroMsg.GetEmotionStoreRecListCacheStorage";
  }
  
  public static final String[] bSc()
  {
    return SQL_CREATE;
  }
  
  public final boolean a(int paramInt, csy paramcsy)
  {
    AppMethodBeat.i(248986);
    if (paramcsy == null)
    {
      AppMethodBeat.o(248986);
      return false;
    }
    for (;;)
    {
      try
      {
        localObject = this.db;
        if (localObject == null)
        {
          localObject = null;
          if (localObject != null) {
            ((Integer)localObject).intValue();
          }
          paramcsy = new t(String.valueOf(paramInt), paramcsy.toByteArray());
          Log.d(this.TAG, "insert cache: %d", new Object[] { Integer.valueOf(paramInt) });
          boolean bool = insert((IAutoDBItem)paramcsy);
          AppMethodBeat.o(248986);
          return bool;
        }
      }
      catch (Exception paramcsy)
      {
        Log.e(this.TAG, "exception:%s", new Object[] { Util.stackTraceToString((Throwable)paramcsy) });
        AppMethodBeat.o(248986);
        return false;
      }
      int i = ((ISQLiteDatabase)localObject).delete("GetEmotionStoreRecListCache", "reqType=?", new String[] { String.valueOf(paramInt) });
      Object localObject = Integer.valueOf(i);
    }
  }
  
  public final csy jdL()
  {
    Object localObject4 = null;
    AppMethodBeat.i(248990);
    Object localObject1 = this.db;
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = localObject4;
      t localt;
      if (localObject1 != null)
      {
        localObject2 = localObject4;
        if (((Cursor)localObject1).moveToFirst()) {
          localt = new t((Cursor)localObject1);
        }
      }
      try
      {
        localObject2 = new csy();
        ((csy)localObject2).parseFrom(localt.field_cache);
        Log.d(this.TAG, "succeed get cache: %d", new Object[] { Integer.valueOf(1) });
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        AppMethodBeat.o(248990);
        return localObject2;
        localObject1 = ((ISQLiteDatabase)localObject1).query("GetEmotionStoreRecListCache", null, "reqType=?", new String[] { "1" }, null, null, null, 2);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e(this.TAG, "exception:%s", new Object[] { Util.stackTraceToString((Throwable)localIOException) });
          Object localObject3 = localObject4;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/emotion/GetEmotionStoreRecListCacheStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "getSQL_CREATE$annotations", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.u
 * JD-Core Version:    0.7.0.1
 */