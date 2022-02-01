package com.tencent.mm.storagebase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.repair.DBDumpUtil;
import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class h
  implements com.tencent.mm.sdk.e.f
{
  private a HbK;
  public a HbL;
  private String HbM;
  public c HbN;
  public String HbO;
  private final LinkedList<Object> HbP;
  private ao HbQ;
  protected f Hbe;
  private String TAG;
  public int field_MARK_CURSOR_CHECK_IGNORE;
  private long mUa;
  
  public h()
  {
    AppMethodBeat.i(133399);
    this.field_MARK_CURSOR_CHECK_IGNORE = 1;
    this.TAG = "MicroMsg.SqliteDB";
    this.Hbe = null;
    this.HbK = null;
    this.HbL = new a();
    this.HbM = "";
    this.HbN = null;
    this.HbO = "";
    this.HbP = new LinkedList();
    this.HbQ = null;
    this.mUa = 0L;
    AppMethodBeat.o(133399);
  }
  
  public h(a parama)
  {
    AppMethodBeat.i(133398);
    this.field_MARK_CURSOR_CHECK_IGNORE = 1;
    this.TAG = "MicroMsg.SqliteDB";
    this.Hbe = null;
    this.HbK = null;
    this.HbL = new a();
    this.HbM = "";
    this.HbN = null;
    this.HbO = "";
    this.HbP = new LinkedList();
    this.HbQ = null;
    this.mUa = 0L;
    this.HbK = parama;
    AppMethodBeat.o(133398);
  }
  
  private void aPj(String paramString)
  {
    AppMethodBeat.i(133404);
    String str1 = ai.getProcessName();
    String str2 = ai.getPackageName();
    ac.i(this.TAG, "check process :[%s] [%s] path[%s]", new Object[] { str1, str2, paramString });
    if ((str1 != null) && (str2 != null) && (!str2.equals(str1))) {
      Assert.assertTrue("processName:" + str1 + "  packagename:" + str2, false);
    }
    AppMethodBeat.o(133404);
  }
  
  public static String ty(String paramString)
  {
    AppMethodBeat.i(133410);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133410);
      return "";
    }
    paramString = DatabaseUtils.sqlEscapeString(paramString);
    AppMethodBeat.o(133410);
    return paramString;
  }
  
  public final long a(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    int i = 0;
    AppMethodBeat.i(133419);
    if (!isOpen())
    {
      ac.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bs.eWi() });
      AppMethodBeat.o(133419);
      return -2L;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.agU().eVl();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      long l = this.Hbe.insert(paramString1, paramString2, paramContentValues);
      c.a(paramString1, null, this.mUa);
      return l;
    }
    catch (Exception paramString1)
    {
      e.wTc.idkeyStat(181L, 11L, 1L, false);
      ac.e(this.TAG, "insert Error :" + paramString1.getMessage());
      c.p(paramString1);
      return -1L;
    }
    finally
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
      AppMethodBeat.o(133419);
    }
  }
  
  public final Cursor a(String paramString, String[] paramArrayOfString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(133413);
    if (!bs.isNullOrNil(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("sql is null ", bool);
      if (isOpen()) {
        break;
      }
      ac.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bs.eWi() });
      paramString = d.fdy();
      AppMethodBeat.o(133413);
      return paramString;
    }
    bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayQuery;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.agU().eVl();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
    c.begin();
    try
    {
      paramArrayOfString = this.Hbe.a(paramString, paramArrayOfString, paramInt);
      c.a(paramString, paramArrayOfString, this.mUa);
      return paramArrayOfString;
    }
    catch (Exception paramString)
    {
      e.wTc.idkeyStat(181L, 10L, 1L, false);
      ac.e(this.TAG, "execSQL Error :" + paramString.getMessage());
      c.p(paramString);
      paramString = d.fdy();
      return paramString;
    }
    finally
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
      AppMethodBeat.o(133413);
    }
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(133412);
    if (!isOpen())
    {
      ac.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bs.eWi() });
      paramString1 = d.fdy();
      AppMethodBeat.o(133412);
      return paramString1;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayQuery;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (i = g.agU().eVl();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
      c.begin();
      try
      {
        paramArrayOfString1 = this.Hbe.a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramInt);
        c.a(paramString1, paramArrayOfString1, this.mUa);
        return paramArrayOfString1;
      }
      catch (Exception paramString1)
      {
        e.wTc.idkeyStat(181L, 10L, 1L, false);
        ac.e(this.TAG, "execSQL Error :" + paramString1.getMessage());
        c.p(paramString1);
        paramString1 = d.fdy();
        return paramString1;
      }
      finally
      {
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
        AppMethodBeat.o(133412);
      }
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
      ac.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bs.eWi() });
      AppMethodBeat.o(133415);
      return false;
    }
    boolean bool = DBDumpUtil.doRecoveryDb(this.Hbe.Hbo, paramString1, paramString2, paramString3, paramList, null, paramExecuteSqlCallback, true);
    AppMethodBeat.o(133415);
    return bool;
  }
  
  public final boolean aPk(String paramString)
  {
    AppMethodBeat.i(133423);
    if (!isOpen())
    {
      ac.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bs.eWi() });
      AppMethodBeat.o(133423);
      return false;
    }
    try
    {
      this.Hbe.execSQL("DROP TABLE ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(133423);
      return false;
    }
    catch (Exception paramString)
    {
      e.wTc.idkeyStat(181L, 11L, 1L, false);
      ac.e(this.TAG, "drop table Error :" + paramString.getMessage());
      c.p(paramString);
      AppMethodBeat.o(133423);
    }
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2, String paramString3, long paramLong, HashMap<Integer, b> paramHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(133406);
    int i = paramString1.lastIndexOf("/");
    if (i != -1) {
      this.TAG = (this.TAG + "." + paramString1.substring(i + 1));
    }
    aPj(paramString2);
    if ((this.HbL.a(paramString1, paramString2, paramString3, paramLong, paramHashMap, paramBoolean)) && (this.HbL.Hbe != null))
    {
      this.HbO = this.HbL.getError();
      this.Hbe = this.HbL.Hbe;
      AppMethodBeat.o(133406);
      return true;
    }
    this.HbO = this.HbL.getError();
    this.Hbe = null;
    this.HbL = null;
    ac.i(this.TAG, "initDB failed. %s", new Object[] { this.HbO });
    AppMethodBeat.o(133406);
    return false;
  }
  
  public final boolean b(String paramString, HashMap<Integer, b> paramHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(133405);
    int i = paramString.lastIndexOf("/");
    if (i != -1) {
      this.TAG = (this.TAG + "." + paramString.substring(i + 1));
    }
    aPj(paramString);
    if ((this.HbL.a(paramString, paramHashMap, paramBoolean)) && (this.HbL.Hbe != null))
    {
      this.Hbe = this.HbL.Hbe;
      ac.i(this.TAG, "SqliteDB db %s", new Object[] { this.Hbe });
      AppMethodBeat.o(133405);
      return true;
    }
    this.Hbe = null;
    this.HbL = null;
    ac.e(this.TAG, "initDB failed.");
    AppMethodBeat.o(133405);
    return false;
  }
  
  public final void close()
  {
    AppMethodBeat.i(133426);
    this.Hbe.close();
    AppMethodBeat.o(133426);
  }
  
  public void closeDB()
  {
    AppMethodBeat.i(133401);
    ro(null);
    AppMethodBeat.o(133401);
  }
  
  public final int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    int i = 0;
    AppMethodBeat.i(133422);
    if (!isOpen())
    {
      ac.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bs.eWi() });
      AppMethodBeat.o(133422);
      return -2;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.agU().eVl();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      j = this.Hbe.delete(paramString1, paramString2, paramArrayOfString);
      c.a(paramString1, null, this.mUa);
      return j;
    }
    catch (Exception paramString1)
    {
      e.wTc.idkeyStat(181L, 11L, 1L, false);
      ac.e(this.TAG, "delete Error :" + paramString1.getMessage());
      c.p(paramString1);
      return -1;
    }
    finally
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
      AppMethodBeat.o(133422);
    }
  }
  
  public final boolean eWz()
  {
    AppMethodBeat.i(133403);
    if ((this.Hbe == null) || (!this.Hbe.isOpen()))
    {
      AppMethodBeat.o(133403);
      return true;
    }
    AppMethodBeat.o(133403);
    return false;
  }
  
  public final boolean execSQL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133417);
    if (!bs.isNullOrNil(paramString2)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("sql is null ", bool);
      if (isOpen()) {
        break;
      }
      ac.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bs.eWi() });
      AppMethodBeat.o(133417);
      return false;
    }
    bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (int i = g.agU().eVl();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
      c.begin();
      try
      {
        this.Hbe.execSQL(paramString2);
        c.a(paramString2, null, this.mUa);
        return true;
      }
      catch (Exception paramString1)
      {
        e.wTc.idkeyStat(181L, 11L, 1L, false);
        paramString2 = paramString1.getMessage();
        ac.e(this.TAG, "execSQL Error :".concat(String.valueOf(paramString2)));
        if ((paramString2 == null) || (!paramString2.contains("no such table"))) {
          break label288;
        }
        paramString2 = this.HbL;
        ac.d("MicroMsg.DBInit", "resetIniCache iniFilename:%s", new Object[] { paramString2.Hbf });
        i.deleteFile(paramString2.Hbf);
        if (this.HbN == null) {
          break;
        }
        this.HbN.agK();
        AppMethodBeat.o(133417);
        throw paramString1;
      }
      finally
      {
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
        AppMethodBeat.o(133417);
      }
    }
    label288:
    c.p(paramString1);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
    AppMethodBeat.o(133417);
    return false;
  }
  
  public final f fdK()
  {
    return this.Hbe;
  }
  
  public final SQLiteDatabase fdL()
  {
    f localf = this.Hbe;
    if (localf.Hbo != null) {
      return localf.Hbo;
    }
    return localf.Hbp;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(133400);
    ro(null);
    AppMethodBeat.o(133400);
  }
  
  public final String getKey()
  {
    if (this.HbL == null) {
      return null;
    }
    return this.HbL.key;
  }
  
  public final long getPageSize()
  {
    AppMethodBeat.i(133416);
    long l = this.Hbe.Hbo.getPageSize();
    AppMethodBeat.o(133416);
    return l;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(133409);
    if (!isOpen())
    {
      ac.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bs.eWi() });
      AppMethodBeat.o(133409);
      return null;
    }
    String str = this.Hbe.getPath();
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
    //   4: ldc_w 416
    //   7: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokevirtual 153	com/tencent/mm/storagebase/h:isOpen	()Z
    //   14: ifne +32 -> 46
    //   17: aload_0
    //   18: getfield 53	com/tencent/mm/storagebase/h:TAG	Ljava/lang/String;
    //   21: ldc 155
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: invokestatic 159	com/tencent/mm/sdk/platformtools/bs:eWi	()Lcom/tencent/mm/sdk/platformtools/as;
    //   32: aastore
    //   33: invokestatic 162	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: ldc_w 416
    //   39: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: monitorexit
    //   44: iload_1
    //   45: ireturn
    //   46: aload_0
    //   47: getfield 79	com/tencent/mm/storagebase/h:mUa	J
    //   50: lconst_0
    //   51: lcmp
    //   52: ifle +14 -> 66
    //   55: ldc_w 416
    //   58: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iconst_1
    //   62: istore_1
    //   63: goto -21 -> 42
    //   66: ldc_w 416
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
  
  public final long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    AppMethodBeat.i(210312);
    long l = a(paramString1, paramString2, paramContentValues);
    AppMethodBeat.o(210312);
    return l;
  }
  
  public final boolean isOpen()
  {
    AppMethodBeat.i(133408);
    if ((this.Hbe != null) && (this.Hbe.isOpen()))
    {
      AppMethodBeat.o(133408);
      return true;
    }
    ac.e(this.TAG, "DB has been closed :[" + this.HbM + "]", new Object[] { Boolean.valueOf(bs.isNullOrNil(this.HbM)) });
    AppMethodBeat.o(133408);
    return false;
  }
  
  public final int qL(long paramLong)
  {
    int i = 0;
    for (;;)
    {
      long l1;
      long l2;
      try
      {
        AppMethodBeat.i(133425);
        l1 = bs.eWj();
        l2 = Thread.currentThread().getId();
        ac.i(this.TAG, "endTransaction thr:%d ticket:(%d,%d) db:%b", new Object[] { Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(this.mUa), Boolean.valueOf(isOpen()) });
        if (!isOpen())
        {
          ac.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bs.eWi() });
          i = -4;
          AppMethodBeat.o(133425);
          return i;
        }
        if (paramLong != this.mUa)
        {
          ac.e(this.TAG, "ERROR endTransaction ticket:" + paramLong + " transactionTicket:" + this.mUa);
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
        ac.e(this.TAG, "FORBID: endTrans UNKNOW_THREAD ticket:%s ParamID:%d nowThr:%d", new Object[] { Long.toHexString(paramLong), Long.valueOf(l3), Long.valueOf(l2) });
        i = -2;
        AppMethodBeat.o(133425);
      }
      else
      {
        try
        {
          c.begin();
          this.Hbe.endTransaction();
          ac.i(this.TAG, "endTransaction Succ Time:%d thr:%d ticket:(%d,%d) db:%b", new Object[] { Long.valueOf(bs.Ap(l1)), Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(this.mUa), Boolean.valueOf(isOpen()) });
          c.a("endTrans", null, 0L);
          this.mUa = 0L;
          if (this.HbK != null) {
            this.HbK.agJ();
          }
          AppMethodBeat.o(133425);
        }
        catch (Exception localException)
        {
          ac.e(this.TAG, "endTransaction Error :" + localException.getMessage());
          e.wTc.idkeyStat(181L, 9L, 1L, false);
          c.p(localException);
          i = -3;
          AppMethodBeat.o(133425);
        }
      }
    }
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(133411);
    paramString1 = a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, 0);
    AppMethodBeat.o(133411);
    return paramString1;
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(210311);
    paramString = a(paramString, paramArrayOfString, 0);
    AppMethodBeat.o(210311);
    return paramString;
  }
  
  public final long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    int i = 0;
    AppMethodBeat.i(133421);
    if (!isOpen())
    {
      ac.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bs.eWi() });
      AppMethodBeat.o(133421);
      return -2L;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.agU().eVl();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      long l = this.Hbe.replace(paramString1, paramString2, paramContentValues);
      c.a(paramString1, null, this.mUa);
      return l;
    }
    catch (Exception paramString1)
    {
      e.wTc.idkeyStat(181L, 11L, 1L, false);
      ac.e(this.TAG, "repalce  Error :" + paramString1.getMessage());
      c.p(paramString1);
      return -1L;
    }
    finally
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
      AppMethodBeat.o(133421);
    }
  }
  
  public void ro(String paramString)
  {
    AppMethodBeat.i(133402);
    if (this.Hbe == null)
    {
      AppMethodBeat.o(133402);
      return;
    }
    if (this.HbK != null) {
      this.HbK.agH();
    }
    ac.w(this.TAG, "begin close db, inTrans:%b ticket:%s  thr:%d {%s}", new Object[] { Boolean.valueOf(inTransaction()), Long.toHexString(this.mUa), Long.valueOf(Thread.currentThread().getId()), bs.eWi() });
    f.a locala = new f.a();
    if (paramString != null) {
      this.HbM = paramString;
    }
    this.Hbe.close();
    this.Hbe = null;
    ac.d(this.TAG, "end close db time:%d", new Object[] { Long.valueOf(locala.YH()) });
    AppMethodBeat.o(133402);
  }
  
  public final int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(133420);
    if (!isOpen())
    {
      ac.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bs.eWi() });
      AppMethodBeat.o(133420);
      return -2;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (i = g.agU().eVl();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
      c.begin();
      try
      {
        j = this.Hbe.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
        c.a(paramString1, null, this.mUa);
        return j;
      }
      catch (Exception paramString1)
      {
        e.wTc.idkeyStat(181L, 11L, 1L, false);
        ac.e(this.TAG, "update Error :" + paramString1.getMessage());
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
  
  public final long vE(long paramLong)
  {
    long l1 = -1L;
    for (;;)
    {
      long l2;
      try
      {
        AppMethodBeat.i(133424);
        l2 = Thread.currentThread().getId();
        ac.i(this.TAG, "beginTransaction thr:(%d,%d) ticket:%d db:%b", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2), Long.valueOf(this.mUa), Boolean.valueOf(isOpen()) });
        if (!isOpen())
        {
          ac.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bs.eWi() });
          paramLong = -4L;
          AppMethodBeat.o(133424);
          return paramLong;
        }
        if (this.mUa > 0L)
        {
          ac.e(this.TAG, "ERROR beginTransaction transactionTicket:" + this.mUa);
          AppMethodBeat.o(133424);
          paramLong = l1;
          continue;
        }
        if (ap.isMainThread()) {
          break label219;
        }
      }
      finally {}
      if (paramLong == -1L)
      {
        ac.e(this.TAG, "FORBID: beginTrans UNKNOW_THREAD ParamID:%d nowThr:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2) });
        paramLong = -2L;
        AppMethodBeat.o(133424);
      }
      else
      {
        try
        {
          label219:
          c.begin();
          this.Hbe.beginTransaction();
          c.a("beginTrans", null, 0L);
          this.mUa = (bs.eWj() & 0x7FFFFFFF);
          this.mUa |= (l2 & 0x7FFFFFFF) << 32;
          if (this.HbK != null) {
            this.HbK.agI();
          }
          paramLong = this.mUa;
          AppMethodBeat.o(133424);
        }
        catch (Exception localException)
        {
          e.wTc.idkeyStat(181L, 8L, 1L, false);
          ac.e(this.TAG, "beginTransaction Error :" + localException.getMessage());
          c.p(localException);
          paramLong = -3L;
          AppMethodBeat.o(133424);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void agH();
    
    public abstract void agI();
    
    public abstract void agJ();
  }
  
  public static abstract interface b
  {
    public abstract String[] getSQLs();
  }
  
  public static abstract interface c
  {
    public abstract void agK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.h
 * JD-Core Version:    0.7.0.1
 */