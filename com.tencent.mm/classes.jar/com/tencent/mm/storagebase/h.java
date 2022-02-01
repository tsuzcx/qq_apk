package com.tencent.mm.storagebase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  private a IPa;
  public a IPb;
  private String IPc;
  public c IPd;
  public String IPe;
  private final LinkedList<Object> IPf;
  private ap IPg;
  private String TAG;
  public int field_MARK_CURSOR_CHECK_IGNORE;
  protected f iNZ;
  private long nuy;
  
  public h()
  {
    AppMethodBeat.i(133399);
    this.field_MARK_CURSOR_CHECK_IGNORE = 1;
    this.TAG = "MicroMsg.SqliteDB";
    this.iNZ = null;
    this.IPa = null;
    this.IPb = new a();
    this.IPc = "";
    this.IPd = null;
    this.IPe = "";
    this.IPf = new LinkedList();
    this.IPg = null;
    this.nuy = 0L;
    AppMethodBeat.o(133399);
  }
  
  public h(a parama)
  {
    AppMethodBeat.i(133398);
    this.field_MARK_CURSOR_CHECK_IGNORE = 1;
    this.TAG = "MicroMsg.SqliteDB";
    this.iNZ = null;
    this.IPa = null;
    this.IPb = new a();
    this.IPc = "";
    this.IPd = null;
    this.IPe = "";
    this.IPf = new LinkedList();
    this.IPg = null;
    this.nuy = 0L;
    this.IPa = parama;
    AppMethodBeat.o(133398);
  }
  
  private void aVa(String paramString)
  {
    AppMethodBeat.i(133404);
    String str1 = aj.getProcessName();
    String str2 = aj.getPackageName();
    ad.i(this.TAG, "check process :[%s] [%s] path[%s]", new Object[] { str1, str2, paramString });
    if ((str1 != null) && (str2 != null) && (!str2.equals(str1))) {
      Assert.assertTrue("processName:" + str1 + "  packagename:" + str2, false);
    }
    AppMethodBeat.o(133404);
  }
  
  public static String wo(String paramString)
  {
    AppMethodBeat.i(133410);
    if (bt.isNullOrNil(paramString))
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
      ad.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bt.flS() });
      AppMethodBeat.o(133419);
      return -2L;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.ajF().fkS();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      long l = this.iNZ.insert(paramString1, paramString2, paramContentValues);
      c.a(paramString1, null, this.nuy);
      return l;
    }
    catch (Exception paramString1)
    {
      e.ygI.idkeyStat(181L, 11L, 1L, false);
      ad.e(this.TAG, "insert Error :" + paramString1.getMessage());
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
    if (!bt.isNullOrNil(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("sql is null ", bool);
      if (isOpen()) {
        break;
      }
      ad.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bt.flS() });
      paramString = d.ftG();
      AppMethodBeat.o(133413);
      return paramString;
    }
    bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayQuery;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.ajF().fkS();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
    c.begin();
    try
    {
      paramArrayOfString = this.iNZ.a(paramString, paramArrayOfString, paramInt);
      c.a(paramString, paramArrayOfString, this.nuy);
      return paramArrayOfString;
    }
    catch (Exception paramString)
    {
      e.ygI.idkeyStat(181L, 10L, 1L, false);
      ad.e(this.TAG, "execSQL Error :" + paramString.getMessage());
      c.p(paramString);
      paramString = d.ftG();
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
      ad.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bt.flS() });
      paramString1 = d.ftG();
      AppMethodBeat.o(133412);
      return paramString1;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayQuery;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (i = g.ajF().fkS();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
      c.begin();
      try
      {
        paramArrayOfString1 = this.iNZ.a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramInt);
        c.a(paramString1, paramArrayOfString1, this.nuy);
        return paramArrayOfString1;
      }
      catch (Exception paramString1)
      {
        e.ygI.idkeyStat(181L, 10L, 1L, false);
        ad.e(this.TAG, "execSQL Error :" + paramString1.getMessage());
        c.p(paramString1);
        paramString1 = d.ftG();
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
      ad.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bt.flS() });
      AppMethodBeat.o(133415);
      return false;
    }
    boolean bool = DBDumpUtil.doRecoveryDb(this.iNZ.IOD, paramString1, paramString2, paramString3, paramList, null, paramExecuteSqlCallback, true);
    AppMethodBeat.o(133415);
    return bool;
  }
  
  public final boolean aVb(String paramString)
  {
    AppMethodBeat.i(133423);
    if (!isOpen())
    {
      ad.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bt.flS() });
      AppMethodBeat.o(133423);
      return false;
    }
    try
    {
      this.iNZ.execSQL("DROP TABLE ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(133423);
      return false;
    }
    catch (Exception paramString)
    {
      e.ygI.idkeyStat(181L, 11L, 1L, false);
      ad.e(this.TAG, "drop table Error :" + paramString.getMessage());
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
    aVa(paramString2);
    if ((this.IPb.a(paramString1, paramString2, paramString3, paramLong, paramHashMap, paramBoolean)) && (this.IPb.iNZ != null))
    {
      this.IPe = this.IPb.getError();
      this.iNZ = this.IPb.iNZ;
      AppMethodBeat.o(133406);
      return true;
    }
    this.IPe = this.IPb.getError();
    this.iNZ = null;
    this.IPb = null;
    ad.i(this.TAG, "initDB failed. %s", new Object[] { this.IPe });
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
    aVa(paramString);
    if ((this.IPb.a(paramString, paramHashMap, paramBoolean)) && (this.IPb.iNZ != null))
    {
      this.iNZ = this.IPb.iNZ;
      ad.i(this.TAG, "SqliteDB db %s", new Object[] { this.iNZ });
      AppMethodBeat.o(133405);
      return true;
    }
    this.iNZ = null;
    this.IPb = null;
    ad.e(this.TAG, "initDB failed.");
    AppMethodBeat.o(133405);
    return false;
  }
  
  public final void close()
  {
    AppMethodBeat.i(133426);
    this.iNZ.close();
    AppMethodBeat.o(133426);
  }
  
  public void closeDB()
  {
    AppMethodBeat.i(133401);
    ua(null);
    AppMethodBeat.o(133401);
  }
  
  public final int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    int i = 0;
    AppMethodBeat.i(133422);
    if (!isOpen())
    {
      ad.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bt.flS() });
      AppMethodBeat.o(133422);
      return -2;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.ajF().fkS();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      j = this.iNZ.delete(paramString1, paramString2, paramArrayOfString);
      c.a(paramString1, null, this.nuy);
      return j;
    }
    catch (Exception paramString1)
    {
      e.ygI.idkeyStat(181L, 11L, 1L, false);
      ad.e(this.TAG, "delete Error :" + paramString1.getMessage());
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
    if (!bt.isNullOrNil(paramString2)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("sql is null ", bool);
      if (isOpen()) {
        break;
      }
      ad.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bt.flS() });
      AppMethodBeat.o(133417);
      return false;
    }
    bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (int i = g.ajF().fkS();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
      c.begin();
      try
      {
        this.iNZ.execSQL(paramString2);
        c.a(paramString2, null, this.nuy);
        return true;
      }
      catch (Exception paramString1)
      {
        e.ygI.idkeyStat(181L, 11L, 1L, false);
        paramString2 = paramString1.getMessage();
        ad.e(this.TAG, "execSQL Error :".concat(String.valueOf(paramString2)));
        if ((paramString2 == null) || (!paramString2.contains("no such table"))) {
          break label288;
        }
        paramString2 = this.IPb;
        ad.d("MicroMsg.DBInit", "resetIniCache iniFilename:%s", new Object[] { paramString2.IOu });
        i.deleteFile(paramString2.IOu);
        if (this.IPd == null) {
          break;
        }
        this.IPd.ajv();
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
    ua(null);
    AppMethodBeat.o(133400);
  }
  
  public final boolean fmj()
  {
    AppMethodBeat.i(133403);
    if ((this.iNZ == null) || (!this.iNZ.isOpen()))
    {
      AppMethodBeat.o(133403);
      return true;
    }
    AppMethodBeat.o(133403);
    return false;
  }
  
  public final f ftS()
  {
    return this.iNZ;
  }
  
  public final SQLiteDatabase ftT()
  {
    f localf = this.iNZ;
    if (localf.IOD != null) {
      return localf.IOD;
    }
    return localf.IOE;
  }
  
  public final String getKey()
  {
    if (this.IPb == null) {
      return null;
    }
    return this.IPb.key;
  }
  
  public final long getPageSize()
  {
    AppMethodBeat.i(133416);
    long l = this.iNZ.IOD.getPageSize();
    AppMethodBeat.o(133416);
    return l;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(133409);
    if (!isOpen())
    {
      ad.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bt.flS() });
      AppMethodBeat.o(133409);
      return null;
    }
    String str = this.iNZ.getPath();
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
    //   29: invokestatic 159	com/tencent/mm/sdk/platformtools/bt:flS	()Lcom/tencent/mm/sdk/platformtools/at;
    //   32: aastore
    //   33: invokestatic 162	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: ldc_w 416
    //   39: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: monitorexit
    //   44: iload_1
    //   45: ireturn
    //   46: aload_0
    //   47: getfield 79	com/tencent/mm/storagebase/h:nuy	J
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
    AppMethodBeat.i(221718);
    long l = a(paramString1, paramString2, paramContentValues);
    AppMethodBeat.o(221718);
    return l;
  }
  
  public final boolean isOpen()
  {
    AppMethodBeat.i(133408);
    if ((this.iNZ != null) && (this.iNZ.isOpen()))
    {
      AppMethodBeat.o(133408);
      return true;
    }
    ad.e(this.TAG, "DB has been closed :[" + this.IPc + "]", new Object[] { Boolean.valueOf(bt.isNullOrNil(this.IPc)) });
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
    AppMethodBeat.i(221717);
    paramString = a(paramString, paramArrayOfString, 0);
    AppMethodBeat.o(221717);
    return paramString;
  }
  
  public final long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    int i = 0;
    AppMethodBeat.i(133421);
    if (!isOpen())
    {
      ad.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bt.flS() });
      AppMethodBeat.o(133421);
      return -2L;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {
      i = g.ajF().fkS();
    }
    i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
    c.begin();
    try
    {
      long l = this.iNZ.replace(paramString1, paramString2, paramContentValues);
      c.a(paramString1, null, this.nuy);
      return l;
    }
    catch (Exception paramString1)
    {
      e.ygI.idkeyStat(181L, 11L, 1L, false);
      ad.e(this.TAG, "repalce  Error :" + paramString1.getMessage());
      c.p(paramString1);
      return -1L;
    }
    finally
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, i);
      AppMethodBeat.o(133421);
    }
  }
  
  public final int sJ(long paramLong)
  {
    int i = 0;
    for (;;)
    {
      long l1;
      long l2;
      try
      {
        AppMethodBeat.i(133425);
        l1 = bt.flT();
        l2 = Thread.currentThread().getId();
        ad.i(this.TAG, "endTransaction thr:%d ticket:(%d,%d) db:%b", new Object[] { Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(this.nuy), Boolean.valueOf(isOpen()) });
        if (!isOpen())
        {
          ad.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bt.flS() });
          i = -4;
          AppMethodBeat.o(133425);
          return i;
        }
        if (paramLong != this.nuy)
        {
          ad.e(this.TAG, "ERROR endTransaction ticket:" + paramLong + " transactionTicket:" + this.nuy);
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
        ad.e(this.TAG, "FORBID: endTrans UNKNOW_THREAD ticket:%s ParamID:%d nowThr:%d", new Object[] { Long.toHexString(paramLong), Long.valueOf(l3), Long.valueOf(l2) });
        i = -2;
        AppMethodBeat.o(133425);
      }
      else
      {
        try
        {
          c.begin();
          this.iNZ.endTransaction();
          ad.i(this.TAG, "endTransaction Succ Time:%d thr:%d ticket:(%d,%d) db:%b", new Object[] { Long.valueOf(bt.Df(l1)), Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(this.nuy), Boolean.valueOf(isOpen()) });
          c.a("endTrans", null, 0L);
          this.nuy = 0L;
          if (this.IPa != null) {
            this.IPa.aju();
          }
          AppMethodBeat.o(133425);
        }
        catch (Exception localException)
        {
          ad.e(this.TAG, "endTransaction Error :" + localException.getMessage());
          e.ygI.idkeyStat(181L, 9L, 1L, false);
          c.p(localException);
          i = -3;
          AppMethodBeat.o(133425);
        }
      }
    }
  }
  
  public void ua(String paramString)
  {
    AppMethodBeat.i(133402);
    if (this.iNZ == null)
    {
      AppMethodBeat.o(133402);
      return;
    }
    if (this.IPa != null) {
      this.IPa.ajs();
    }
    ad.w(this.TAG, "begin close db, inTrans:%b ticket:%s  thr:%d {%s}", new Object[] { Boolean.valueOf(inTransaction()), Long.toHexString(this.nuy), Long.valueOf(Thread.currentThread().getId()), bt.flS() });
    f.a locala = new f.a();
    if (paramString != null) {
      this.IPc = paramString;
    }
    this.iNZ.close();
    this.iNZ = null;
    ad.d(this.TAG, "end close db time:%d", new Object[] { Long.valueOf(locala.abj()) });
    AppMethodBeat.o(133402);
  }
  
  public final int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(133420);
    if (!isOpen())
    {
      ad.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bt.flS() });
      AppMethodBeat.o(133420);
      return -2;
    }
    boolean bool = WXHardCoderJNI.hcDBEnable;
    int j = WXHardCoderJNI.hcDBDelayWrite;
    int k = WXHardCoderJNI.hcDBCPU;
    int m = WXHardCoderJNI.hcDBIO;
    if (WXHardCoderJNI.hcDBThr) {}
    for (i = g.ajF().fkS();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
      c.begin();
      try
      {
        j = this.iNZ.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
        c.a(paramString1, null, this.nuy);
        return j;
      }
      catch (Exception paramString1)
      {
        e.ygI.idkeyStat(181L, 11L, 1L, false);
        ad.e(this.TAG, "update Error :" + paramString1.getMessage());
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
  
  public final long xO(long paramLong)
  {
    long l1 = -1L;
    for (;;)
    {
      long l2;
      try
      {
        AppMethodBeat.i(133424);
        l2 = Thread.currentThread().getId();
        ad.i(this.TAG, "beginTransaction thr:(%d,%d) ticket:%d db:%b", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2), Long.valueOf(this.nuy), Boolean.valueOf(isOpen()) });
        if (!isOpen())
        {
          ad.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bt.flS() });
          paramLong = -4L;
          AppMethodBeat.o(133424);
          return paramLong;
        }
        if (this.nuy > 0L)
        {
          ad.e(this.TAG, "ERROR beginTransaction transactionTicket:" + this.nuy);
          AppMethodBeat.o(133424);
          paramLong = l1;
          continue;
        }
        if (aq.isMainThread()) {
          break label219;
        }
      }
      finally {}
      if (paramLong == -1L)
      {
        ad.e(this.TAG, "FORBID: beginTrans UNKNOW_THREAD ParamID:%d nowThr:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2) });
        paramLong = -2L;
        AppMethodBeat.o(133424);
      }
      else
      {
        try
        {
          label219:
          c.begin();
          this.iNZ.beginTransaction();
          c.a("beginTrans", null, 0L);
          this.nuy = (bt.flT() & 0x7FFFFFFF);
          this.nuy |= (l2 & 0x7FFFFFFF) << 32;
          if (this.IPa != null) {
            this.IPa.ajt();
          }
          paramLong = this.nuy;
          AppMethodBeat.o(133424);
        }
        catch (Exception localException)
        {
          e.ygI.idkeyStat(181L, 8L, 1L, false);
          ad.e(this.TAG, "beginTransaction Error :" + localException.getMessage());
          c.p(localException);
          paramLong = -3L;
          AppMethodBeat.o(133424);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void ajs();
    
    public abstract void ajt();
    
    public abstract void aju();
  }
  
  public static abstract interface b
  {
    public abstract String[] getSQLs();
  }
  
  public static abstract interface c
  {
    public abstract void ajv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.h
 * JD-Core Version:    0.7.0.1
 */