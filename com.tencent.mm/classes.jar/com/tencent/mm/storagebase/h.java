package com.tencent.mm.storagebase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
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
  private a JjI;
  public a JjJ;
  private String JjK;
  public c JjL;
  public String JjM;
  private final LinkedList<Object> JjN;
  private aq JjO;
  private String TAG;
  public int field_MARK_CURSOR_CHECK_IGNORE;
  protected f iQT;
  private long nzT;
  
  public h()
  {
    AppMethodBeat.i(133399);
    this.field_MARK_CURSOR_CHECK_IGNORE = 1;
    this.TAG = "MicroMsg.SqliteDB";
    this.iQT = null;
    this.JjI = null;
    this.JjJ = new a();
    this.JjK = "";
    this.JjL = null;
    this.JjM = "";
    this.JjN = new LinkedList();
    this.JjO = null;
    this.nzT = 0L;
    AppMethodBeat.o(133399);
  }
  
  public h(a parama)
  {
    AppMethodBeat.i(133398);
    this.field_MARK_CURSOR_CHECK_IGNORE = 1;
    this.TAG = "MicroMsg.SqliteDB";
    this.iQT = null;
    this.JjI = null;
    this.JjJ = new a();
    this.JjK = "";
    this.JjL = null;
    this.JjM = "";
    this.JjN = new LinkedList();
    this.JjO = null;
    this.nzT = 0L;
    this.JjI = parama;
    AppMethodBeat.o(133398);
  }
  
  private void aWB(String paramString)
  {
    AppMethodBeat.i(133404);
    String str1 = ak.getProcessName();
    String str2 = ak.getPackageName();
    ae.i(this.TAG, "check process :[%s] [%s] path[%s]", new Object[] { str1, str2, paramString });
    if ((str1 != null) && (str2 != null) && (!str2.equals(str1))) {
      Assert.assertTrue("processName:" + str1 + "  packagename:" + str2, false);
    }
    AppMethodBeat.o(133404);
  }
  
  private Cursor b(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(193624);
    if (!isOpen())
    {
      ae.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bu.fpN() });
      paramString1 = d.fxH();
      AppMethodBeat.o(193624);
      return paramString1;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayQuery;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (i = g.ajU().foN();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
      c.begin();
      try
      {
        paramArrayOfString1 = this.iQT.b(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramInt);
        c.a(paramString1, paramArrayOfString1, this.nzT);
        return paramArrayOfString1;
      }
      catch (Exception paramString1)
      {
        e.ywz.idkeyStat(181L, 10L, 1L, false);
        ae.e(this.TAG, "execSQL Error :" + paramString1.getMessage());
        c.p(paramString1);
        paramString1 = d.fxH();
        return paramString1;
      }
      finally
      {
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
        AppMethodBeat.o(193624);
      }
    }
  }
  
  public static String wX(String paramString)
  {
    AppMethodBeat.i(133410);
    if (bu.isNullOrNil(paramString))
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
      ae.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bu.fpN() });
      AppMethodBeat.o(133419);
      return -2L;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.ajU().foN();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      long l = this.iQT.insert(paramString1, paramString2, paramContentValues);
      c.a(paramString1, null, this.nzT);
      return l;
    }
    catch (Exception paramString1)
    {
      e.ywz.idkeyStat(181L, 11L, 1L, false);
      ae.e(this.TAG, "insert Error :" + paramString1.getMessage());
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
    if (!bu.isNullOrNil(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("sql is null ", bool);
      if (isOpen()) {
        break;
      }
      ae.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bu.fpN() });
      paramString = d.fxH();
      AppMethodBeat.o(133413);
      return paramString;
    }
    bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayQuery;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.ajU().foN();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
    c.begin();
    try
    {
      paramArrayOfString = this.iQT.a(paramString, paramArrayOfString, paramInt);
      c.a(paramString, paramArrayOfString, this.nzT);
      return paramArrayOfString;
    }
    catch (Exception paramString)
    {
      e.ywz.idkeyStat(181L, 10L, 1L, false);
      ae.e(this.TAG, "execSQL Error :" + paramString.getMessage());
      c.p(paramString);
      paramString = d.fxH();
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
    paramString1 = b(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramInt);
    AppMethodBeat.o(133412);
    return paramString1;
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
      ae.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bu.fpN() });
      AppMethodBeat.o(133415);
      return false;
    }
    boolean bool = DBDumpUtil.doRecoveryDb(this.iQT.Jjj, paramString1, paramString2, paramString3, paramList, null, paramExecuteSqlCallback, true);
    AppMethodBeat.o(133415);
    return bool;
  }
  
  public final boolean aWC(String paramString)
  {
    AppMethodBeat.i(133423);
    if (!isOpen())
    {
      ae.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bu.fpN() });
      AppMethodBeat.o(133423);
      return false;
    }
    try
    {
      this.iQT.execSQL("DROP TABLE ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(133423);
      return false;
    }
    catch (Exception paramString)
    {
      e.ywz.idkeyStat(181L, 11L, 1L, false);
      ae.e(this.TAG, "drop table Error :" + paramString.getMessage());
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
    aWB(paramString2);
    if ((this.JjJ.a(paramString1, paramString2, paramString3, paramLong, paramHashMap, paramBoolean)) && (this.JjJ.iQT != null))
    {
      this.JjM = this.JjJ.getError();
      this.iQT = this.JjJ.iQT;
      AppMethodBeat.o(133406);
      return true;
    }
    this.JjM = this.JjJ.getError();
    this.iQT = null;
    this.JjJ = null;
    ae.i(this.TAG, "initDB failed. %s", new Object[] { this.JjM });
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
    aWB(paramString);
    if ((this.JjJ.a(paramString, paramHashMap, paramBoolean)) && (this.JjJ.iQT != null))
    {
      this.iQT = this.JjJ.iQT;
      ae.i(this.TAG, "SqliteDB db %s", new Object[] { this.iQT });
      AppMethodBeat.o(133405);
      return true;
    }
    this.iQT = null;
    this.JjJ = null;
    ae.e(this.TAG, "initDB failed.");
    AppMethodBeat.o(133405);
    return false;
  }
  
  public final void close()
  {
    AppMethodBeat.i(133426);
    this.iQT.close();
    AppMethodBeat.o(133426);
  }
  
  public void closeDB()
  {
    AppMethodBeat.i(133401);
    uv(null);
    AppMethodBeat.o(133401);
  }
  
  public final int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    int i = 0;
    AppMethodBeat.i(133422);
    if (!isOpen())
    {
      ae.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bu.fpN() });
      AppMethodBeat.o(133422);
      return -2;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.ajU().foN();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      j = this.iQT.delete(paramString1, paramString2, paramArrayOfString);
      c.a(paramString1, null, this.nzT);
      return j;
    }
    catch (Exception paramString1)
    {
      e.ywz.idkeyStat(181L, 11L, 1L, false);
      ae.e(this.TAG, "delete Error :" + paramString1.getMessage());
      c.p(paramString1);
      return -1;
    }
    finally
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
      AppMethodBeat.o(133422);
    }
  }
  
  public final boolean execSQL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133417);
    if (!bu.isNullOrNil(paramString2)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("sql is null ", bool);
      if (isOpen()) {
        break;
      }
      ae.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bu.fpN() });
      AppMethodBeat.o(133417);
      return false;
    }
    bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (int i = g.ajU().foN();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
      c.begin();
      try
      {
        this.iQT.execSQL(paramString2);
        c.a(paramString2, null, this.nzT);
        return true;
      }
      catch (Exception paramString1)
      {
        e.ywz.idkeyStat(181L, 11L, 1L, false);
        paramString2 = paramString1.getMessage();
        ae.e(this.TAG, "execSQL Error :".concat(String.valueOf(paramString2)));
        if ((paramString2 == null) || (!paramString2.contains("no such table"))) {
          break label288;
        }
        paramString2 = this.JjJ;
        ae.d("MicroMsg.DBInit", "resetIniCache iniFilename:%s", new Object[] { paramString2.Jja });
        o.deleteFile(paramString2.Jja);
        if (this.JjL == null) {
          break;
        }
        this.JjL.ajK();
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
  
  protected void finalize()
  {
    AppMethodBeat.i(133400);
    uv(null);
    AppMethodBeat.o(133400);
  }
  
  public final boolean fqe()
  {
    AppMethodBeat.i(133403);
    if ((this.iQT == null) || (!this.iQT.isOpen()))
    {
      AppMethodBeat.o(133403);
      return true;
    }
    AppMethodBeat.o(133403);
    return false;
  }
  
  public final f fxT()
  {
    return this.iQT;
  }
  
  public final SQLiteDatabase fxU()
  {
    f localf = this.iQT;
    if (localf.Jjj != null) {
      return localf.Jjj;
    }
    return localf.Jjk;
  }
  
  public final String getKey()
  {
    if (this.JjJ == null) {
      return null;
    }
    return this.JjJ.key;
  }
  
  public final long getPageSize()
  {
    AppMethodBeat.i(133416);
    long l = this.iQT.Jjj.getPageSize();
    AppMethodBeat.o(133416);
    return l;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(133409);
    if (!isOpen())
    {
      ae.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bu.fpN() });
      AppMethodBeat.o(133409);
      return null;
    }
    String str = this.iQT.getPath();
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
    //   4: ldc_w 418
    //   7: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokevirtual 139	com/tencent/mm/storagebase/h:isOpen	()Z
    //   14: ifne +32 -> 46
    //   17: aload_0
    //   18: getfield 53	com/tencent/mm/storagebase/h:TAG	Ljava/lang/String;
    //   21: ldc 141
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: invokestatic 147	com/tencent/mm/sdk/platformtools/bu:fpN	()Lcom/tencent/mm/sdk/platformtools/au;
    //   32: aastore
    //   33: invokestatic 150	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: ldc_w 418
    //   39: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: monitorexit
    //   44: iload_1
    //   45: ireturn
    //   46: aload_0
    //   47: getfield 79	com/tencent/mm/storagebase/h:nzT	J
    //   50: lconst_0
    //   51: lcmp
    //   52: ifle +14 -> 66
    //   55: ldc_w 418
    //   58: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iconst_1
    //   62: istore_1
    //   63: goto -21 -> 42
    //   66: ldc_w 418
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
    AppMethodBeat.i(224427);
    long l = a(paramString1, paramString2, paramContentValues);
    AppMethodBeat.o(224427);
    return l;
  }
  
  public final boolean isOpen()
  {
    AppMethodBeat.i(133408);
    if ((this.iQT != null) && (this.iQT.isOpen()))
    {
      AppMethodBeat.o(133408);
      return true;
    }
    ae.e(this.TAG, "DB has been closed :[" + this.JjK + "]", new Object[] { Boolean.valueOf(bu.isNullOrNil(this.JjK)) });
    AppMethodBeat.o(133408);
    return false;
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
    AppMethodBeat.i(224426);
    paramString = a(paramString, paramArrayOfString, 0);
    AppMethodBeat.o(224426);
    return paramString;
  }
  
  public final long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    int i = 0;
    AppMethodBeat.i(133421);
    if (!isOpen())
    {
      ae.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bu.fpN() });
      AppMethodBeat.o(133421);
      return -2L;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.ajU().foN();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      long l = this.iQT.replace(paramString1, paramString2, paramContentValues);
      c.a(paramString1, null, this.nzT);
      return l;
    }
    catch (Exception paramString1)
    {
      e.ywz.idkeyStat(181L, 11L, 1L, false);
      ae.e(this.TAG, "repalce  Error :" + paramString1.getMessage());
      c.p(paramString1);
      return -1L;
    }
    finally
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
      AppMethodBeat.o(133421);
    }
  }
  
  public final int sW(long paramLong)
  {
    int i = 0;
    for (;;)
    {
      long l1;
      long l2;
      try
      {
        AppMethodBeat.i(133425);
        l1 = bu.fpO();
        l2 = Thread.currentThread().getId();
        ae.i(this.TAG, "endTransaction thr:%d ticket:(%d,%d) db:%b", new Object[] { Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(this.nzT), Boolean.valueOf(isOpen()) });
        if (!isOpen())
        {
          ae.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bu.fpN() });
          i = -4;
          AppMethodBeat.o(133425);
          return i;
        }
        if (paramLong != this.nzT)
        {
          ae.e(this.TAG, "ERROR endTransaction ticket:" + paramLong + " transactionTicket:" + this.nzT);
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
        ae.e(this.TAG, "FORBID: endTrans UNKNOW_THREAD ticket:%s ParamID:%d nowThr:%d", new Object[] { Long.toHexString(paramLong), Long.valueOf(l3), Long.valueOf(l2) });
        i = -2;
        AppMethodBeat.o(133425);
      }
      else
      {
        try
        {
          c.begin();
          this.iQT.endTransaction();
          ae.i(this.TAG, "endTransaction Succ Time:%d thr:%d ticket:(%d,%d) db:%b", new Object[] { Long.valueOf(bu.DD(l1)), Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(this.nzT), Boolean.valueOf(isOpen()) });
          c.a("endTrans", null, 0L);
          this.nzT = 0L;
          if (this.JjI != null) {
            this.JjI.ajJ();
          }
          AppMethodBeat.o(133425);
        }
        catch (Exception localException)
        {
          ae.e(this.TAG, "endTransaction Error :" + localException.getMessage());
          e.ywz.idkeyStat(181L, 9L, 1L, false);
          c.p(localException);
          i = -3;
          AppMethodBeat.o(133425);
        }
      }
    }
  }
  
  public final int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(133420);
    if (!isOpen())
    {
      ae.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bu.fpN() });
      AppMethodBeat.o(133420);
      return -2;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (i = g.ajU().foN();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
      c.begin();
      try
      {
        j = this.iQT.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
        c.a(paramString1, null, this.nzT);
        return j;
      }
      catch (Exception paramString1)
      {
        e.ywz.idkeyStat(181L, 11L, 1L, false);
        ae.e(this.TAG, "update Error :" + paramString1.getMessage());
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
  
  public void uv(String paramString)
  {
    AppMethodBeat.i(133402);
    if (this.iQT == null)
    {
      AppMethodBeat.o(133402);
      return;
    }
    if (this.JjI != null) {
      this.JjI.ajH();
    }
    ae.w(this.TAG, "begin close db, inTrans:%b ticket:%s  thr:%d {%s}", new Object[] { Boolean.valueOf(inTransaction()), Long.toHexString(this.nzT), Long.valueOf(Thread.currentThread().getId()), bu.fpN() });
    f.a locala = new f.a();
    if (paramString != null) {
      this.JjK = paramString;
    }
    this.iQT.close();
    this.iQT = null;
    ae.d(this.TAG, "end close db time:%d", new Object[] { Long.valueOf(locala.abs()) });
    AppMethodBeat.o(133402);
  }
  
  public final long yi(long paramLong)
  {
    long l1 = -1L;
    for (;;)
    {
      long l2;
      try
      {
        AppMethodBeat.i(133424);
        l2 = Thread.currentThread().getId();
        ae.i(this.TAG, "beginTransaction thr:(%d,%d) ticket:%d db:%b", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2), Long.valueOf(this.nzT), Boolean.valueOf(isOpen()) });
        if (!isOpen())
        {
          ae.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bu.fpN() });
          paramLong = -4L;
          AppMethodBeat.o(133424);
          return paramLong;
        }
        if (this.nzT > 0L)
        {
          ae.e(this.TAG, "ERROR beginTransaction transactionTicket:" + this.nzT);
          AppMethodBeat.o(133424);
          paramLong = l1;
          continue;
        }
        if (ar.isMainThread()) {
          break label219;
        }
      }
      finally {}
      if (paramLong == -1L)
      {
        ae.e(this.TAG, "FORBID: beginTrans UNKNOW_THREAD ParamID:%d nowThr:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2) });
        paramLong = -2L;
        AppMethodBeat.o(133424);
      }
      else
      {
        try
        {
          label219:
          c.begin();
          this.iQT.beginTransaction();
          c.a("beginTrans", null, 0L);
          this.nzT = (bu.fpO() & 0x7FFFFFFF);
          this.nzT |= (l2 & 0x7FFFFFFF) << 32;
          if (this.JjI != null) {
            this.JjI.ajI();
          }
          paramLong = this.nzT;
          AppMethodBeat.o(133424);
        }
        catch (Exception localException)
        {
          e.ywz.idkeyStat(181L, 8L, 1L, false);
          ae.e(this.TAG, "beginTransaction Error :" + localException.getMessage());
          c.p(localException);
          paramLong = -3L;
          AppMethodBeat.o(133424);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void ajH();
    
    public abstract void ajI();
    
    public abstract void ajJ();
  }
  
  public static abstract interface b
  {
    public abstract String[] getSQLs();
  }
  
  public static abstract interface c
  {
    public abstract void ajK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.h
 * JD-Core Version:    0.7.0.1
 */