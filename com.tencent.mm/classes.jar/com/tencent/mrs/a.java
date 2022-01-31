package com.tencent.mrs;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.d.b;
import com.tencent.matrix.d.b.a;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.sqlitelint.c;
import com.tencent.sqlitelint.e;
import com.tencent.sqlitelint.e.b.a;
import com.tencent.sqlitelint.e.c;
import com.tencent.sqlitelint.h;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  public static com.tencent.mrs.b.a wDn;
  
  public static com.tencent.sqlitelint.a.a cNE()
  {
    try
    {
      com.tencent.sqlitelint.a.a locala = new com.tencent.sqlitelint.a.a(e.c.wRc);
      return locala;
    }
    catch (Throwable localThrowable) {}
    return new com.tencent.sqlitelint.a.a(e.c.wRc);
  }
  
  public static void onDestroy()
  {
    if (!MatrixReport.isInstalled())
    {
      b.e("Matrix.Manager", "onDestroy, matrix report is not installed, just return", new Object[0]);
      return;
    }
    MatrixReport.with().onDestroy();
  }
  
  private static final class a
    implements c
  {
    private final SQLiteDatabase mDb;
    
    a(SQLiteDatabase paramSQLiteDatabase)
    {
      this.mDb = paramSQLiteDatabase;
    }
    
    public final void execSQL(String paramString)
    {
      if (!this.mDb.isOpen())
      {
        y.w("Matrix.Manager", "rawQuery db close", new Object[0]);
        return;
      }
      this.mDb.execSQL(paramString);
    }
    
    public final Cursor rawQuery(String paramString, String... paramVarArgs)
    {
      if (!this.mDb.isOpen())
      {
        y.w("Matrix.Manager", "rawQuery db close", new Object[0]);
        return null;
      }
      return this.mDb.rawQuery(paramString, paramVarArgs);
    }
  }
  
  public static final class b
  {
    private static Map<String, Boolean> wDo = new HashMap();
    private static h wDp;
    
    public static void a(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong)
    {
      if (!com.tencent.matrix.a.isInstalled()) {}
      do
      {
        do
        {
          return;
          if (wDp != null) {
            break;
          }
          localObject1 = (h)com.tencent.matrix.a.qO().l(h.class);
          wDp = (h)localObject1;
        } while (localObject1 == null);
      } while (!wDp.re());
      y.v("Matrix.Manager", "onSQLExecuted  String sql:%s,  timeCost:%d", new Object[] { paramString, Long.valueOf(paramLong) });
      Object localObject1 = paramSQLiteDatabase.getPath();
      Object localObject2;
      if (!wDo.containsKey(localObject1))
      {
        paramSQLiteDatabase = new com.tencent.sqlitelint.e.a((String)localObject1, new a.a(paramSQLiteDatabase));
        localObject2 = new e.b.a();
        ((e.b.a)localObject2).wRa |= 0x2;
        ((e.b.a)localObject2).wRa &= 0xFFFFFFFE;
        paramSQLiteDatabase = new com.tencent.sqlitelint.a.a.a(paramSQLiteDatabase, ((e.b.a)localObject2).cPR());
        paramSQLiteDatabase.aga("AvoidAutoIncrementChecker");
        paramSQLiteDatabase.aga("AvoidSelectAllChecker");
        paramSQLiteDatabase.aga("ExplainQueryPlanChecker");
        paramSQLiteDatabase.aga("RedundantIndexChecker");
        paramSQLiteDatabase.aga("WithoutRowIdBetterChecker");
        paramSQLiteDatabase.aga("PreparedStatementBetterChecker");
        localObject2 = paramSQLiteDatabase.wRI.wQW;
        if (!((String)localObject2).endsWith("EnMicroMsg.db")) {
          break label286;
        }
        paramSQLiteDatabase.wRK = com.tencent.mm.plugin.report.e.a.enmicromsg_sqlite_lint_whitelist;
        localObject2 = wDp;
        if (((h)localObject2).re()) {
          break label326;
        }
        SLog.i("Matrix.SQLiteLintPlugin", "addConcernedDB isPluginStarted not", new Object[0]);
      }
      int i;
      for (;;)
      {
        wDo.put(localObject1, Boolean.valueOf(true));
        paramSQLiteDatabase = wDp;
        i = (int)paramLong;
        if (paramSQLiteDatabase.re()) {
          break label457;
        }
        SLog.i("Matrix.SQLiteLintPlugin", "notifySqlExecution isPluginStarted not", new Object[0]);
        return;
        label286:
        if (((String)localObject2).endsWith("AppBrandComm.db"))
        {
          paramSQLiteDatabase.wRK = com.tencent.mm.plugin.report.e.a.appbrandcomm_sqlite_lint_whitelist;
          break;
        }
        if (!((String)localObject2).endsWith("SnsMicroMsg.db")) {
          break;
        }
        paramSQLiteDatabase.wRK = com.tencent.mm.plugin.report.e.a.snsmicromsg_sqlite_lint_whitelist;
        break;
        label326:
        Object localObject3 = ((h)localObject2).wRi;
        if (com.tencent.sqlitelint.a.a.a.a(paramSQLiteDatabase) != null)
        {
          String str = com.tencent.sqlitelint.a.a.a.a(paramSQLiteDatabase).wQW;
          if (!TextUtils.isEmpty(str))
          {
            i = 0;
            while (i < ((com.tencent.sqlitelint.a.a)localObject3).wRH.size())
            {
              if (str.equals(com.tencent.sqlitelint.a.a.a.a(paramSQLiteDatabase).wQW)) {
                break label411;
              }
              i += 1;
            }
            ((com.tencent.sqlitelint.a.a)localObject3).wRH.add(paramSQLiteDatabase);
          }
        }
        label411:
        localObject3 = paramSQLiteDatabase.wRI.wQW;
        e.a(((h)localObject2).mContext, paramSQLiteDatabase.wRI, paramSQLiteDatabase.wRJ);
        e.dW((String)localObject3, paramSQLiteDatabase.wRK);
        e.z((String)localObject3, paramSQLiteDatabase.wRL);
      }
      label457:
      e.N((String)localObject1, paramString, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mrs.a
 * JD-Core Version:    0.7.0.1
 */