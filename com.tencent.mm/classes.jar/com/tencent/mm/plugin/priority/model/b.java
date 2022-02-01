package com.tencent.mm.plugin.priority.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;

public class b
{
  public SQLiteDatabase GSi;
  public SQLiteStatement GSj;
  public SQLiteStatement GSk;
  public SQLiteStatement GSl;
  
  public b(String paramString)
  {
    AppMethodBeat.i(87799);
    if (this.GSi != null)
    {
      Log.w("MicroMsg.Priority.PriorityDB", "before initDB, pre DB is not close, why?");
      this.GSi.close();
    }
    paramString = new com.tencent.mm.vfs.q(paramString, "MicroMsgPriority.db").bOF();
    long l1 = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    h.aHE();
    this.GSi = SQLiteDatabase.openOrCreateDatabase(paramString, g.getMessageDigest((com.tencent.mm.kernel.b.aGq() + z.bcZ() + com.tencent.mm.compatible.deviceinfo.q.dR(true)).getBytes()).substring(0, 7).getBytes(), null, null);
    localObject = this.GSi;
    long l2 = ((SQLiteDatabase)localObject).acquireNativeConnectionHandle("initPriority", false, false);
    PriorityJni.nativeInit(l2);
    ((SQLiteDatabase)localObject).releaseNativeConnection(l2, null);
    this.GSi.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", new Object[] { "PriorityConfig" }));
    this.GSj = this.GSi.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", new Object[] { "PriorityConfig" }));
    this.GSk = this.GSi.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", new Object[] { "PriorityConfig" }));
    this.GSl = this.GSi.compileStatement(String.format("DELETE FROM %s WHERE type=?", new Object[] { "PriorityConfig" }));
    Log.i("MicroMsg.Priority.PriorityDB", "initDB index params %d %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1), Util.getSizeMB(u.bBQ(paramString), 100.0D) });
    AppMethodBeat.o(87799);
  }
  
  public final boolean aHB(String paramString)
  {
    AppMethodBeat.i(87805);
    paramString = this.GSi.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[] { paramString });
    boolean bool = paramString.moveToNext();
    paramString.close();
    AppMethodBeat.o(87805);
    return bool;
  }
  
  public final void aUA(String paramString)
  {
    AppMethodBeat.i(87806);
    Log.v("MicroMsg.Priority.PriorityDB", "dropTable: %s", new Object[] { paramString });
    this.GSi.execSQL(String.format("DROP TABLE %s", new Object[] { paramString }));
    AppMethodBeat.o(87806);
  }
  
  public final int aUz(String paramString)
  {
    AppMethodBeat.i(87804);
    paramString = this.GSi.rawQuery(String.format("SELECT count(*) FROM %s;", new Object[] { paramString }), null);
    try
    {
      if (paramString.moveToNext())
      {
        int i = paramString.getInt(0);
        return i;
      }
      return 0;
    }
    finally
    {
      paramString.close();
      AppMethodBeat.o(87804);
    }
  }
  
  public final long ao(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87800);
    this.GSj.bindLong(1, paramLong1);
    try
    {
      paramLong1 = this.GSj.simpleQueryForLong();
      AppMethodBeat.o(87800);
      return paramLong1;
    }
    catch (SQLiteDoneException localSQLiteDoneException)
    {
      AppMethodBeat.o(87800);
    }
    return paramLong2;
  }
  
  public final void ap(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87801);
    this.GSk.bindLong(1, paramLong1);
    this.GSk.bindLong(2, paramLong2);
    this.GSk.execute();
    AppMethodBeat.o(87801);
  }
  
  public final SQLiteStatement compileStatement(String paramString)
  {
    AppMethodBeat.i(87803);
    Log.v("MicroMsg.Priority.PriorityDB", "compileStatement sql = %s", new Object[] { paramString });
    paramString = this.GSi.compileStatement(paramString);
    AppMethodBeat.o(87803);
    return paramString;
  }
  
  public final void execSQL(String paramString)
  {
    AppMethodBeat.i(87807);
    Log.v("MicroMsg.Priority.PriorityDB", "execSQL: execute sql = %s", new Object[] { paramString });
    this.GSi.execSQL(paramString);
    AppMethodBeat.o(87807);
  }
  
  public final void execSQL(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(87808);
    Log.v("MicroMsg.Priority.PriorityDB", "execSQL: execute sql = %s", new Object[] { paramString });
    this.GSi.execSQL(paramString, paramArrayOfObject);
    AppMethodBeat.o(87808);
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(87802);
    Log.v("MicroMsg.Priority.PriorityDB", "rawQuery: execute sql = %s", new Object[] { paramString });
    paramString = this.GSi.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, paramString, paramArrayOfString, null);
    AppMethodBeat.o(87802);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.b
 * JD-Core Version:    0.7.0.1
 */