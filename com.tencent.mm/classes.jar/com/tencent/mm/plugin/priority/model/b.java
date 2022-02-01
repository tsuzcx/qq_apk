package com.tencent.mm.plugin.priority.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;

public class b
{
  public SQLiteDatabase MPM;
  public SQLiteStatement MPN;
  public SQLiteStatement MPO;
  public SQLiteStatement MPP;
  
  public b(String paramString)
  {
    AppMethodBeat.i(87799);
    if (this.MPM != null)
    {
      Log.w("MicroMsg.Priority.PriorityDB", "before initDB, pre DB is not close, why?");
      this.MPM.close();
    }
    paramString = ah.v(new u(paramString, "MicroMsgPriority.db").jKT());
    long l1 = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    h.baC();
    this.MPM = SQLiteDatabase.openOrCreateDatabase(paramString, g.getMessageDigest((com.tencent.mm.kernel.b.aZs() + z.bAM() + q.eD(true)).getBytes()).substring(0, 7).getBytes(), null, null);
    localObject = this.MPM;
    long l2 = ((SQLiteDatabase)localObject).acquireNativeConnectionHandle("initPriority", false, false);
    PriorityJni.nativeInit(l2);
    ((SQLiteDatabase)localObject).releaseNativeConnection(l2, null);
    this.MPM.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", new Object[] { "PriorityConfig" }));
    this.MPN = this.MPM.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", new Object[] { "PriorityConfig" }));
    this.MPO = this.MPM.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", new Object[] { "PriorityConfig" }));
    this.MPP = this.MPM.compileStatement(String.format("DELETE FROM %s WHERE type=?", new Object[] { "PriorityConfig" }));
    Log.i("MicroMsg.Priority.PriorityDB", "initDB index params %d %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1), Util.getSizeMB(y.bEl(paramString), 100.0D) });
    AppMethodBeat.o(87799);
  }
  
  public final boolean aDZ(String paramString)
  {
    AppMethodBeat.i(87805);
    paramString = this.MPM.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[] { paramString });
    boolean bool = paramString.moveToNext();
    paramString.close();
    AppMethodBeat.o(87805);
    return bool;
  }
  
  public final int aRH(String paramString)
  {
    AppMethodBeat.i(87804);
    paramString = this.MPM.rawQuery(String.format("SELECT count(*) FROM %s;", new Object[] { paramString }), null);
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
  
  public final void aRI(String paramString)
  {
    AppMethodBeat.i(87806);
    Log.v("MicroMsg.Priority.PriorityDB", "dropTable: %s", new Object[] { paramString });
    this.MPM.execSQL(String.format("DROP TABLE %s", new Object[] { paramString }));
    AppMethodBeat.o(87806);
  }
  
  public final long aY(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87800);
    this.MPN.bindLong(1, paramLong1);
    try
    {
      paramLong1 = this.MPN.simpleQueryForLong();
      AppMethodBeat.o(87800);
      return paramLong1;
    }
    catch (SQLiteDoneException localSQLiteDoneException)
    {
      AppMethodBeat.o(87800);
    }
    return paramLong2;
  }
  
  public final void aZ(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87801);
    this.MPO.bindLong(1, paramLong1);
    this.MPO.bindLong(2, paramLong2);
    this.MPO.execute();
    AppMethodBeat.o(87801);
  }
  
  public final SQLiteStatement compileStatement(String paramString)
  {
    AppMethodBeat.i(87803);
    Log.v("MicroMsg.Priority.PriorityDB", "compileStatement sql = %s", new Object[] { paramString });
    paramString = this.MPM.compileStatement(paramString);
    AppMethodBeat.o(87803);
    return paramString;
  }
  
  public final void execSQL(String paramString)
  {
    AppMethodBeat.i(87807);
    Log.v("MicroMsg.Priority.PriorityDB", "execSQL: execute sql = %s", new Object[] { paramString });
    this.MPM.execSQL(paramString);
    AppMethodBeat.o(87807);
  }
  
  public final void execSQL(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(87808);
    Log.v("MicroMsg.Priority.PriorityDB", "execSQL: execute sql = %s", new Object[] { paramString });
    this.MPM.execSQL(paramString, paramArrayOfObject);
    AppMethodBeat.o(87808);
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(87802);
    Log.v("MicroMsg.Priority.PriorityDB", "rawQuery: execute sql = %s", new Object[] { paramString });
    paramString = this.MPM.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, paramString, paramArrayOfString, null);
    AppMethodBeat.o(87802);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.b
 * JD-Core Version:    0.7.0.1
 */