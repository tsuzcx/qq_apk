package com.tencent.mm.storagebase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.vfs.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.repair.DBDumpUtil;
import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class h
  implements ISQLiteDatabaseEx
{
  private a OtA;
  public a OtB;
  private String OtC;
  public c OtD;
  public String OtE;
  private final LinkedList<Object> OtF;
  private MMHandler OtG;
  private String TAG;
  public int field_MARK_CURSOR_CHECK_IGNORE;
  protected f jNN;
  private long oKR;
  
  public h()
  {
    AppMethodBeat.i(133399);
    this.field_MARK_CURSOR_CHECK_IGNORE = 1;
    this.TAG = "MicroMsg.SqliteDB";
    this.jNN = null;
    this.OtA = null;
    this.OtB = new a();
    this.OtC = "";
    this.OtD = null;
    this.OtE = "";
    this.OtF = new LinkedList();
    this.OtG = null;
    this.oKR = 0L;
    AppMethodBeat.o(133399);
  }
  
  public h(a parama)
  {
    AppMethodBeat.i(133398);
    this.field_MARK_CURSOR_CHECK_IGNORE = 1;
    this.TAG = "MicroMsg.SqliteDB";
    this.jNN = null;
    this.OtA = null;
    this.OtB = new a();
    this.OtC = "";
    this.OtD = null;
    this.OtE = "";
    this.OtF = new LinkedList();
    this.OtG = null;
    this.oKR = 0L;
    this.OtA = parama;
    AppMethodBeat.o(133398);
  }
  
  public static String Fl(String paramString)
  {
    AppMethodBeat.i(133410);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133410);
      return "";
    }
    paramString = DatabaseUtils.sqlEscapeString(paramString);
    AppMethodBeat.o(133410);
    return paramString;
  }
  
  private void blA(String paramString)
  {
    AppMethodBeat.i(133404);
    String str1 = MMApplicationContext.getProcessName();
    String str2 = MMApplicationContext.getPackageName();
    Log.i(this.TAG, "check process :[%s] [%s] path[%s]", new Object[] { str1, str2, paramString });
    if ((str1 != null) && (str2 != null) && (!str2.equals(str1))) {
      Assert.assertTrue("processName:" + str1 + "  packagename:" + str2, false);
    }
    AppMethodBeat.o(133404);
  }
  
  public void CL(String paramString)
  {
    AppMethodBeat.i(133402);
    if (this.jNN == null)
    {
      AppMethodBeat.o(133402);
      return;
    }
    if (this.OtA != null) {
      this.OtA.azX();
    }
    Log.w(this.TAG, "begin close db, inTrans:%b ticket:%s  thr:%d {%s}", new Object[] { Boolean.valueOf(inTransaction()), Long.toHexString(this.oKR), Long.valueOf(Thread.currentThread().getId()), Util.getStack() });
    f.a locala = new f.a();
    if (paramString != null) {
      this.OtC = paramString;
    }
    this.jNN.close();
    this.jNN = null;
    Log.d(this.TAG, "end close db time:%d", new Object[] { Long.valueOf(locala.apr()) });
    AppMethodBeat.o(133402);
  }
  
  public final long a(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    int i = 0;
    AppMethodBeat.i(133419);
    if (!isOpen())
    {
      Log.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { Util.getStack() });
      AppMethodBeat.o(133419);
      return -2L;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.aAk().getProcessTid();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      long l = this.jNN.insert(paramString1, paramString2, paramContentValues);
      c.a(paramString1, null, this.oKR);
      return l;
    }
    catch (Exception paramString1)
    {
      e.Cxv.idkeyStat(181L, 11L, 1L, false);
      Log.e(this.TAG, "insert Error :" + paramString1.getMessage());
      c.p(paramString1);
      return -1L;
    }
    finally
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
      AppMethodBeat.o(133419);
    }
  }
  
  public final boolean a(String paramString1, String paramString2, long paramLong, HashMap<Integer, b> paramHashMap)
  {
    AppMethodBeat.i(133407);
    boolean bool = b(paramString1, paramString2, "", paramLong, paramHashMap, true);
    AppMethodBeat.o(133407);
    return bool;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, List<String> paramList, DBDumpUtil.ExecuteSqlCallback paramExecuteSqlCallback)
  {
    AppMethodBeat.i(133415);
    if (!isOpen())
    {
      Log.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { Util.getStack() });
      AppMethodBeat.o(133415);
      return false;
    }
    boolean bool = DBDumpUtil.doRecoveryDb(this.jNN.Otb, paramString1, paramString2, paramString3, paramList, null, paramExecuteSqlCallback, true);
    AppMethodBeat.o(133415);
    return bool;
  }
  
  public final boolean a(String paramString, HashMap<Integer, b> paramHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(133405);
    int i = paramString.lastIndexOf("/");
    if (i != -1) {
      this.TAG = (this.TAG + "." + paramString.substring(i + 1));
    }
    blA(paramString);
    if ((this.OtB.a(paramString, paramHashMap, true, paramBoolean)) && (this.OtB.jNN != null))
    {
      this.jNN = this.OtB.jNN;
      Log.i(this.TAG, "SqliteDB db %s", new Object[] { this.jNN });
      AppMethodBeat.o(133405);
      return true;
    }
    this.jNN = null;
    this.OtB = null;
    Log.e(this.TAG, "initDB failed.");
    AppMethodBeat.o(133405);
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2, String paramString3, long paramLong, HashMap<Integer, b> paramHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(133406);
    int i = paramString1.lastIndexOf("/");
    if (i != -1) {
      this.TAG = (this.TAG + "." + paramString1.substring(i + 1));
    }
    blA(paramString2);
    if ((this.OtB.a(paramString1, paramString2, paramString3, paramLong, paramHashMap, paramBoolean)) && (this.OtB.jNN != null))
    {
      this.OtE = this.OtB.getError();
      this.jNN = this.OtB.jNN;
      AppMethodBeat.o(133406);
      return true;
    }
    this.OtE = this.OtB.getError();
    this.jNN = null;
    this.OtB = null;
    Log.i(this.TAG, "initDB failed. %s", new Object[] { this.OtE });
    AppMethodBeat.o(133406);
    return false;
  }
  
  public long beginTransaction(long paramLong)
  {
    long l1 = -1L;
    for (;;)
    {
      long l2;
      try
      {
        AppMethodBeat.i(133424);
        l2 = Thread.currentThread().getId();
        Log.i(this.TAG, "beginTransaction thr:(%d,%d) ticket:%d db:%b", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2), Long.valueOf(this.oKR), Boolean.valueOf(isOpen()) });
        if (!isOpen())
        {
          Log.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { Util.getStack() });
          paramLong = -4L;
          AppMethodBeat.o(133424);
          return paramLong;
        }
        if (this.oKR > 0L)
        {
          Log.e(this.TAG, "ERROR beginTransaction transactionTicket:" + this.oKR);
          AppMethodBeat.o(133424);
          paramLong = l1;
          continue;
        }
        if (MMHandlerThread.isMainThread()) {
          break label219;
        }
      }
      finally {}
      if (paramLong == -1L)
      {
        Log.e(this.TAG, "FORBID: beginTrans UNKNOW_THREAD ParamID:%d nowThr:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2) });
        paramLong = -2L;
        AppMethodBeat.o(133424);
      }
      else
      {
        try
        {
          label219:
          c.begin();
          this.jNN.beginTransaction();
          c.a("beginTrans", null, 0L);
          this.oKR = (Util.nowMilliSecond() & 0x7FFFFFFF);
          this.oKR |= (l2 & 0x7FFFFFFF) << 32;
          if (this.OtA != null) {
            this.OtA.azY();
          }
          paramLong = this.oKR;
          AppMethodBeat.o(133424);
        }
        catch (Exception localException)
        {
          e.Cxv.idkeyStat(181L, 8L, 1L, false);
          Log.e(this.TAG, "beginTransaction Error :" + localException.getMessage());
          c.p(localException);
          paramLong = -3L;
          AppMethodBeat.o(133424);
        }
      }
    }
  }
  
  public final boolean blB(String paramString)
  {
    AppMethodBeat.i(133423);
    if (!isOpen())
    {
      Log.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { Util.getStack() });
      AppMethodBeat.o(133423);
      return false;
    }
    try
    {
      this.jNN.execSQL("DROP TABLE ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(133423);
      return false;
    }
    catch (Exception paramString)
    {
      e.Cxv.idkeyStat(181L, 11L, 1L, false);
      Log.e(this.TAG, "drop table Error :" + paramString.getMessage());
      c.p(paramString);
      AppMethodBeat.o(133423);
    }
    return false;
  }
  
  public void close()
  {
    AppMethodBeat.i(133426);
    this.jNN.close();
    AppMethodBeat.o(133426);
  }
  
  public void closeDB()
  {
    AppMethodBeat.i(133401);
    CL(null);
    AppMethodBeat.o(133401);
  }
  
  public int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    int i = 0;
    AppMethodBeat.i(133422);
    if (!isOpen())
    {
      Log.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { Util.getStack() });
      AppMethodBeat.o(133422);
      return -2;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.aAk().getProcessTid();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      j = this.jNN.delete(paramString1, paramString2, paramArrayOfString);
      c.a(paramString1, null, this.oKR);
      return j;
    }
    catch (Exception paramString1)
    {
      e.Cxv.idkeyStat(181L, 11L, 1L, false);
      Log.e(this.TAG, "delete Error :" + paramString1.getMessage());
      c.p(paramString1);
      return -1;
    }
    finally
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
      AppMethodBeat.o(133422);
    }
  }
  
  public int endTransaction(long paramLong)
  {
    int i = 0;
    for (;;)
    {
      long l1;
      long l2;
      try
      {
        AppMethodBeat.i(133425);
        l1 = Util.nowMilliSecond();
        l2 = Thread.currentThread().getId();
        Log.i(this.TAG, "endTransaction thr:%d ticket:(%d,%d) db:%b", new Object[] { Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(this.oKR), Boolean.valueOf(isOpen()) });
        if (!isOpen())
        {
          Log.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { Util.getStack() });
          i = -4;
          AppMethodBeat.o(133425);
          return i;
        }
        if (paramLong != this.oKR)
        {
          Log.e(this.TAG, "ERROR endTransaction ticket:" + paramLong + " transactionTicket:" + this.oKR);
          i = -1;
          AppMethodBeat.o(133425);
          continue;
        }
        l3 = paramLong >> 32 & 0x7FFFFFFF;
      }
      finally {}
      long l3;
      if (l3 != l2)
      {
        Log.e(this.TAG, "FORBID: endTrans UNKNOW_THREAD ticket:%s ParamID:%d nowThr:%d", new Object[] { Long.toHexString(paramLong), Long.valueOf(l3), Long.valueOf(l2) });
        i = -2;
        AppMethodBeat.o(133425);
      }
      else
      {
        try
        {
          c.begin();
          this.jNN.endTransaction();
          Log.i(this.TAG, "endTransaction Succ Time:%d thr:%d ticket:(%d,%d) db:%b", new Object[] { Long.valueOf(Util.milliSecondsToNow(l1)), Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(this.oKR), Boolean.valueOf(isOpen()) });
          c.a("endTrans", null, 0L);
          this.oKR = 0L;
          if (this.OtA != null) {
            this.OtA.azZ();
          }
          AppMethodBeat.o(133425);
        }
        catch (Exception localException)
        {
          Log.e(this.TAG, "endTransaction Error :" + localException.getMessage());
          e.Cxv.idkeyStat(181L, 9L, 1L, false);
          c.p(localException);
          i = -3;
          AppMethodBeat.o(133425);
        }
      }
    }
  }
  
  public boolean execSQL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133417);
    if (!Util.isNullOrNil(paramString2)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("sql is null ", bool);
      if (isOpen()) {
        break;
      }
      Log.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { Util.getStack() });
      AppMethodBeat.o(133417);
      return false;
    }
    bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (int i = g.aAk().getProcessTid();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
      c.begin();
      try
      {
        this.jNN.execSQL(paramString2);
        c.a(paramString2, null, this.oKR);
        return true;
      }
      catch (Exception paramString1)
      {
        e.Cxv.idkeyStat(181L, 11L, 1L, false);
        paramString2 = paramString1.getMessage();
        Log.e(this.TAG, "execSQL Error :".concat(String.valueOf(paramString2)));
        if ((paramString2 == null) || (!paramString2.contains("no such table"))) {
          break label289;
        }
        paramString2 = this.OtB;
        Log.d("MicroMsg.DBInit", "resetIniCache iniFilename:%s", new Object[] { paramString2.OsS });
        s.deleteFile(paramString2.OsS);
        if (this.OtD == null) {
          break;
        }
        this.OtD.aAa();
        AppMethodBeat.o(133417);
        throw paramString1;
      }
      finally
      {
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
        AppMethodBeat.o(133417);
      }
    }
    label289:
    c.p(paramString1);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
    AppMethodBeat.o(133417);
    return false;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(133400);
    CL(null);
    AppMethodBeat.o(133400);
  }
  
  public final f gFG()
  {
    return this.jNN;
  }
  
  public final SQLiteDatabase gFH()
  {
    f localf = this.jNN;
    if (localf.Otb != null) {
      return localf.Otb;
    }
    return localf.Otc;
  }
  
  public final String getKey()
  {
    if (this.OtB == null) {
      return null;
    }
    return this.OtB.key;
  }
  
  public final long getPageSize()
  {
    AppMethodBeat.i(133416);
    long l = this.jNN.Otb.getPageSize();
    AppMethodBeat.o(133416);
    return l;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(133409);
    if (!isOpen())
    {
      Log.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { Util.getStack() });
      AppMethodBeat.o(133409);
      return null;
    }
    String str = this.jNN.getPath();
    AppMethodBeat.o(133409);
    return str;
  }
  
  /* Error */
  public final boolean inTransaction()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 496
    //   7: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokevirtual 211	com/tencent/mm/storagebase/h:isOpen	()Z
    //   14: ifne +32 -> 46
    //   17: aload_0
    //   18: getfield 53	com/tencent/mm/storagebase/h:TAG	Ljava/lang/String;
    //   21: ldc 213
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: invokestatic 185	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   32: aastore
    //   33: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: ldc_w 496
    //   39: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: monitorexit
    //   44: iload_1
    //   45: ireturn
    //   46: aload_0
    //   47: getfield 79	com/tencent/mm/storagebase/h:oKR	J
    //   50: lconst_0
    //   51: lcmp
    //   52: ifle +14 -> 66
    //   55: ldc_w 496
    //   58: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iconst_1
    //   62: istore_1
    //   63: goto -21 -> 42
    //   66: ldc_w 496
    //   69: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: goto -30 -> 42
    //   75: astore_2
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_2
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	h
    //   1	62	1	bool	boolean
    //   75	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	42	75	finally
    //   46	61	75	finally
    //   66	72	75	finally
  }
  
  public long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    AppMethodBeat.i(186042);
    long l = a(paramString1, paramString2, paramContentValues);
    AppMethodBeat.o(186042);
    return l;
  }
  
  public boolean isClose()
  {
    AppMethodBeat.i(133403);
    if ((this.jNN == null) || (!this.jNN.isOpen()))
    {
      AppMethodBeat.o(133403);
      return true;
    }
    AppMethodBeat.o(133403);
    return false;
  }
  
  public final boolean isOpen()
  {
    AppMethodBeat.i(133408);
    if ((this.jNN != null) && (this.jNN.isOpen()))
    {
      AppMethodBeat.o(133408);
      return true;
    }
    Log.e(this.TAG, "DB has been closed :[" + this.OtC + "]", new Object[] { Boolean.valueOf(Util.isNullOrNil(this.OtC)) });
    AppMethodBeat.o(133408);
    return false;
  }
  
  public Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(133411);
    paramString1 = query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, 0);
    AppMethodBeat.o(133411);
    return paramString1;
  }
  
  public Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(133412);
    paramString1 = query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramInt, null);
    AppMethodBeat.o(133412);
    return paramString1;
  }
  
  public Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    AppMethodBeat.i(197185);
    if (!isOpen())
    {
      Log.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { Util.getStack() });
      paramString1 = d.gFu();
      AppMethodBeat.o(197185);
      return paramString1;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayQuery;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (i = g.aAk().getProcessTid();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
      c.begin();
      try
      {
        paramArrayOfString1 = this.jNN.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramInt, paramString6);
        c.a(paramString1, paramArrayOfString1, this.oKR);
        return paramArrayOfString1;
      }
      catch (Exception paramString1)
      {
        e.Cxv.idkeyStat(181L, 10L, 1L, false);
        Log.e(this.TAG, "execSQL Error :" + paramString1.getMessage());
        c.p(paramString1);
        paramString1 = d.gFu();
        return paramString1;
      }
      finally
      {
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
        AppMethodBeat.o(197185);
      }
    }
  }
  
  public Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(186041);
    paramString = rawQuery(paramString, paramArrayOfString, 0);
    AppMethodBeat.o(186041);
    return paramString;
  }
  
  public Cursor rawQuery(String paramString, String[] paramArrayOfString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(133413);
    if (!Util.isNullOrNil(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("sql is null ", bool);
      if (isOpen()) {
        break;
      }
      Log.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { Util.getStack() });
      paramString = d.gFu();
      AppMethodBeat.o(133413);
      return paramString;
    }
    bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayQuery;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.aAk().getProcessTid();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
    c.begin();
    try
    {
      paramArrayOfString = this.jNN.rawQuery(paramString, paramArrayOfString, paramInt);
      c.a(paramString, paramArrayOfString, this.oKR);
      return paramArrayOfString;
    }
    catch (Exception paramString)
    {
      e.Cxv.idkeyStat(181L, 10L, 1L, false);
      Log.e(this.TAG, "execSQL Error :" + paramString.getMessage());
      c.p(paramString);
      paramString = d.gFu();
      return paramString;
    }
    finally
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
      AppMethodBeat.o(133413);
    }
  }
  
  public long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    int i = 0;
    AppMethodBeat.i(133421);
    if (!isOpen())
    {
      Log.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { Util.getStack() });
      AppMethodBeat.o(133421);
      return -2L;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.aAk().getProcessTid();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      long l = this.jNN.replace(paramString1, paramString2, paramContentValues);
      c.a(paramString1, null, this.oKR);
      return l;
    }
    catch (Exception paramString1)
    {
      e.Cxv.idkeyStat(181L, 11L, 1L, false);
      Log.e(this.TAG, "repalce  Error :" + paramString1.getMessage());
      c.p(paramString1);
      return -1L;
    }
    finally
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
      AppMethodBeat.o(133421);
    }
  }
  
  public int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(133420);
    if (!isOpen())
    {
      Log.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { Util.getStack() });
      AppMethodBeat.o(133420);
      return -2;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (i = g.aAk().getProcessTid();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
      c.begin();
      try
      {
        j = this.jNN.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
        c.a(paramString1, null, this.oKR);
        return j;
      }
      catch (Exception paramString1)
      {
        e.Cxv.idkeyStat(181L, 11L, 1L, false);
        Log.e(this.TAG, "update Error :" + paramString1.getMessage());
        c.p(paramString1);
        return -1;
      }
      finally
      {
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
        AppMethodBeat.o(133420);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void azX();
    
    public abstract void azY();
    
    public abstract void azZ();
  }
  
  public static abstract interface b
  {
    public abstract String[] getSQLs();
  }
  
  public static abstract interface c
  {
    public abstract void aAa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.h
 * JD-Core Version:    0.7.0.1
 */