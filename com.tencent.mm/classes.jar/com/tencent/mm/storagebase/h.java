package com.tencent.mm.storagebase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.vfs.u;
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
  private String TAG;
  private a VJB;
  public a VJC;
  private String VJD;
  public c VJE;
  public String VJF;
  private final LinkedList<Object> VJG;
  private MMHandler VJH;
  public int field_MARK_CURSOR_CHECK_IGNORE;
  protected f mEV;
  private long rMI;
  
  public h()
  {
    AppMethodBeat.i(133399);
    this.field_MARK_CURSOR_CHECK_IGNORE = 1;
    this.TAG = "MicroMsg.SqliteDB";
    this.mEV = null;
    this.VJB = null;
    this.VJC = new a();
    this.VJD = "";
    this.VJE = null;
    this.VJF = "";
    this.VJG = new LinkedList();
    this.VJH = null;
    this.rMI = 0L;
    AppMethodBeat.o(133399);
  }
  
  public h(a parama)
  {
    AppMethodBeat.i(133398);
    this.field_MARK_CURSOR_CHECK_IGNORE = 1;
    this.TAG = "MicroMsg.SqliteDB";
    this.mEV = null;
    this.VJB = null;
    this.VJC = new a();
    this.VJD = "";
    this.VJE = null;
    this.VJF = "";
    this.VJG = new LinkedList();
    this.VJH = null;
    this.rMI = 0L;
    this.VJB = parama;
    AppMethodBeat.o(133398);
  }
  
  public static String Mi(String paramString)
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
  
  private void bxZ(String paramString)
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
  
  public void JA(String paramString)
  {
    AppMethodBeat.i(133402);
    if (this.mEV == null)
    {
      AppMethodBeat.o(133402);
      return;
    }
    if (this.VJB != null) {
      this.VJB.aHw();
    }
    Log.w(this.TAG, "begin close db, inTrans:%b ticket:%s  thr:%d {%s}", new Object[] { Boolean.valueOf(inTransaction()), Long.toHexString(this.rMI), Long.valueOf(Thread.currentThread().getId()), Util.getStack() });
    f.a locala = new f.a();
    if (paramString != null) {
      this.VJD = paramString;
    }
    this.mEV.close();
    this.mEV = null;
    Log.d(this.TAG, "end close db time:%d", new Object[] { Long.valueOf(locala.avE()) });
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
      i = com.tencent.mm.kernel.h.aHJ().getProcessTid();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      long l = this.mEV.insert(paramString1, paramString2, paramContentValues);
      c.a(paramString1, null, this.rMI);
      return l;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(181L, 11L, 1L, false);
      Log.e(this.TAG, "insert Error :" + paramString1.getMessage());
      c.l(paramString1);
      return -1L;
    }
    finally
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
      AppMethodBeat.o(133419);
    }
  }
  
  public final boolean a(String paramString1, String paramString2, long paramLong, HashMap<Integer, h.b> paramHashMap)
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
    boolean bool = DBDumpUtil.doRecoveryDb(this.mEV.VJf, paramString1, paramString2, paramString3, paramList, null, paramExecuteSqlCallback, true);
    AppMethodBeat.o(133415);
    return bool;
  }
  
  public final boolean a(String paramString, HashMap<Integer, h.b> paramHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(133405);
    int i = paramString.lastIndexOf("/");
    if (i != -1) {
      this.TAG = (this.TAG + "." + paramString.substring(i + 1));
    }
    bxZ(paramString);
    if ((this.VJC.a(paramString, paramHashMap, true, paramBoolean)) && (this.VJC.mEV != null))
    {
      this.mEV = this.VJC.mEV;
      Log.i(this.TAG, "SqliteDB db %s", new Object[] { this.mEV });
      AppMethodBeat.o(133405);
      return true;
    }
    this.mEV = null;
    this.VJC = null;
    Log.e(this.TAG, "initDB failed.");
    AppMethodBeat.o(133405);
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2, String paramString3, long paramLong, HashMap<Integer, h.b> paramHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(133406);
    int i = paramString1.lastIndexOf("/");
    if (i != -1) {
      this.TAG = (this.TAG + "." + paramString1.substring(i + 1));
    }
    bxZ(paramString2);
    if ((this.VJC.a(paramString1, paramString2, paramString3, paramLong, paramHashMap, paramBoolean)) && (this.VJC.mEV != null))
    {
      this.VJF = this.VJC.getError();
      this.mEV = this.VJC.mEV;
      AppMethodBeat.o(133406);
      return true;
    }
    this.VJF = this.VJC.getError();
    this.mEV = null;
    this.VJC = null;
    Log.i(this.TAG, "initDB failed. %s", new Object[] { this.VJF });
    AppMethodBeat.o(133406);
    return false;
  }
  
  public final long bLA()
  {
    AppMethodBeat.i(292947);
    long l = beginTransaction(-1L);
    AppMethodBeat.o(292947);
    return l;
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
        Log.i(this.TAG, "beginTransaction thr:(%d,%d) ticket:%d db:%b", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2), Long.valueOf(this.rMI), Boolean.valueOf(isOpen()) });
        if (!isOpen())
        {
          Log.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { Util.getStack() });
          paramLong = -4L;
          AppMethodBeat.o(133424);
          return paramLong;
        }
        if (this.rMI > 0L)
        {
          Log.e(this.TAG, "ERROR beginTransaction transactionTicket:" + this.rMI);
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
          this.mEV.beginTransaction();
          c.a("beginTrans", null, 0L);
          this.rMI = (Util.nowMilliSecond() & 0x7FFFFFFF);
          this.rMI |= (l2 & 0x7FFFFFFF) << 32;
          if (this.VJB != null) {
            this.VJB.aHx();
          }
          paramLong = this.rMI;
          AppMethodBeat.o(133424);
        }
        catch (Exception localException)
        {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(181L, 8L, 1L, false);
          Log.e(this.TAG, "beginTransaction Error :" + localException.getMessage());
          c.l(localException);
          paramLong = -3L;
          AppMethodBeat.o(133424);
        }
      }
    }
  }
  
  public final boolean bya(String paramString)
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
      this.mEV.execSQL("DROP TABLE ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(133423);
      return false;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(181L, 11L, 1L, false);
      Log.e(this.TAG, "drop table Error :" + paramString.getMessage());
      c.l(paramString);
      AppMethodBeat.o(133423);
    }
    return false;
  }
  
  public void close()
  {
    AppMethodBeat.i(133426);
    this.mEV.close();
    AppMethodBeat.o(133426);
  }
  
  public void closeDB()
  {
    AppMethodBeat.i(133401);
    JA(null);
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
      i = com.tencent.mm.kernel.h.aHJ().getProcessTid();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      j = this.mEV.delete(paramString1, paramString2, paramArrayOfString);
      c.a(paramString1, null, this.rMI);
      return j;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(181L, 11L, 1L, false);
      Log.e(this.TAG, "delete Error :" + paramString1.getMessage());
      c.l(paramString1);
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
        Log.i(this.TAG, "endTransaction thr:%d ticket:(%d,%d) db:%b", new Object[] { Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(this.rMI), Boolean.valueOf(isOpen()) });
        if (!isOpen())
        {
          Log.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { Util.getStack() });
          i = -4;
          AppMethodBeat.o(133425);
          return i;
        }
        if (paramLong != this.rMI)
        {
          Log.e(this.TAG, "ERROR endTransaction ticket:" + paramLong + " transactionTicket:" + this.rMI);
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
          this.mEV.endTransaction();
          Log.i(this.TAG, "endTransaction Succ Time:%d thr:%d ticket:(%d,%d) db:%b", new Object[] { Long.valueOf(Util.milliSecondsToNow(l1)), Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(this.rMI), Boolean.valueOf(isOpen()) });
          c.a("endTrans", null, 0L);
          this.rMI = 0L;
          if (this.VJB != null) {
            this.VJB.aHy();
          }
          AppMethodBeat.o(133425);
        }
        catch (Exception localException)
        {
          Log.e(this.TAG, "endTransaction Error :" + localException.getMessage());
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(181L, 9L, 1L, false);
          c.l(localException);
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
    for (int i = com.tencent.mm.kernel.h.aHJ().getProcessTid();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
      c.begin();
      try
      {
        this.mEV.execSQL(paramString2);
        c.a(paramString2, null, this.rMI);
        return true;
      }
      catch (Exception paramString1)
      {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(181L, 11L, 1L, false);
        paramString2 = paramString1.getMessage();
        Log.e(this.TAG, "execSQL Error :".concat(String.valueOf(paramString2)));
        if ((paramString2 == null) || (!paramString2.contains("no such table"))) {
          break label289;
        }
        paramString2 = this.VJC;
        Log.d("MicroMsg.DBInit", "resetIniCache iniFilename:%s", new Object[] { paramString2.VIV });
        u.deleteFile(paramString2.VIV);
        if (this.VJE == null) {
          break;
        }
        this.VJE.aHz();
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
    c.l(paramString1);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
    AppMethodBeat.o(133417);
    return false;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(133400);
    JA(null);
    AppMethodBeat.o(133400);
  }
  
  public final String getKey()
  {
    if (this.VJC == null) {
      return null;
    }
    return this.VJC.key;
  }
  
  public final long getPageSize()
  {
    AppMethodBeat.i(133416);
    long l = this.mEV.VJf.getPageSize();
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
    String str = this.mEV.getPath();
    AppMethodBeat.o(133409);
    return str;
  }
  
  public final f hBY()
  {
    return this.mEV;
  }
  
  public final SQLiteDatabase hBZ()
  {
    f localf = this.mEV;
    if (localf.VJf != null) {
      return localf.VJf;
    }
    return localf.VJg;
  }
  
  /* Error */
  public final boolean inTransaction()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 500
    //   7: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokevirtual 210	com/tencent/mm/storagebase/h:isOpen	()Z
    //   14: ifne +32 -> 46
    //   17: aload_0
    //   18: getfield 52	com/tencent/mm/storagebase/h:TAG	Ljava/lang/String;
    //   21: ldc 212
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: invokestatic 184	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   32: aastore
    //   33: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: ldc_w 500
    //   39: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: monitorexit
    //   44: iload_1
    //   45: ireturn
    //   46: aload_0
    //   47: getfield 78	com/tencent/mm/storagebase/h:rMI	J
    //   50: lconst_0
    //   51: lcmp
    //   52: ifle +14 -> 66
    //   55: ldc_w 500
    //   58: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iconst_1
    //   62: istore_1
    //   63: goto -21 -> 42
    //   66: ldc_w 500
    //   69: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    if ((this.mEV == null) || (!this.mEV.isOpen()))
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
    if ((this.mEV != null) && (this.mEV.isOpen()))
    {
      AppMethodBeat.o(133408);
      return true;
    }
    Log.e(this.TAG, "DB has been closed :[" + this.VJD + "]", new Object[] { Boolean.valueOf(Util.isNullOrNil(this.VJD)) });
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
    AppMethodBeat.i(214075);
    if (!isOpen())
    {
      Log.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { Util.getStack() });
      paramString1 = d.hBM();
      AppMethodBeat.o(214075);
      return paramString1;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayQuery;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (i = com.tencent.mm.kernel.h.aHJ().getProcessTid();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
      c.begin();
      try
      {
        paramArrayOfString1 = this.mEV.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramInt, paramString6);
        c.a(paramString1, paramArrayOfString1, this.rMI);
        return paramArrayOfString1;
      }
      catch (Exception paramString1)
      {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(181L, 10L, 1L, false);
        Log.e(this.TAG, "execSQL Error :" + paramString1.getMessage());
        c.l(paramString1);
        paramString1 = d.hBM();
        return paramString1;
      }
      finally
      {
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
        AppMethodBeat.o(214075);
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
      paramString = d.hBM();
      AppMethodBeat.o(133413);
      return paramString;
    }
    bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayQuery;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = com.tencent.mm.kernel.h.aHJ().getProcessTid();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
    c.begin();
    try
    {
      paramArrayOfString = this.mEV.rawQuery(paramString, paramArrayOfString, paramInt);
      c.a(paramString, paramArrayOfString, this.rMI);
      return paramArrayOfString;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(181L, 10L, 1L, false);
      Log.e(this.TAG, "execSQL Error :" + paramString.getMessage());
      c.l(paramString);
      paramString = d.hBM();
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
      i = com.tencent.mm.kernel.h.aHJ().getProcessTid();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      long l = this.mEV.replace(paramString1, paramString2, paramContentValues);
      c.a(paramString1, null, this.rMI);
      return l;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(181L, 11L, 1L, false);
      Log.e(this.TAG, "repalce  Error :" + paramString1.getMessage());
      c.l(paramString1);
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
    for (i = com.tencent.mm.kernel.h.aHJ().getProcessTid();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
      c.begin();
      try
      {
        j = this.mEV.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
        c.a(paramString1, null, this.rMI);
        return j;
      }
      catch (Exception paramString1)
      {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(181L, 11L, 1L, false);
        Log.e(this.TAG, "update Error :" + paramString1.getMessage());
        c.l(paramString1);
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
    public abstract void aHw();
    
    public abstract void aHx();
    
    public abstract void aHy();
  }
  
  public static abstract interface c
  {
    public abstract void aHz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storagebase.h
 * JD-Core Version:    0.7.0.1
 */