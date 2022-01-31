package com.tencent.mm.plugin.report.service;

import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Map;

public class e
{
  private static boolean nEB = false;
  private static int nFA;
  private static boolean nFB;
  private static Map<Long, Long> nFy;
  private static a nFz = new a();
  
  static
  {
    nFA = -1;
    nFB = false;
  }
  
  public static void a(long paramLong1, long paramLong2, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {}
    for (;;)
    {
      try
      {
        SmcLogic.writeImportKvDataWithType(paramLong1, paramLong2, paramString, paramBoolean1, false);
        if (nEB) {
          j.bxa().s(paramLong1, paramString);
        }
        return;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { bk.j(localException) });
        continue;
      }
      try
      {
        SmcLogic.writeKvDataWithType(paramLong1, paramLong2, paramString, paramBoolean1, false);
      }
      catch (Throwable localThrowable)
      {
        y.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (d.gG(20))
        {
          SmcLogic.writeKvDataWithType(paramLong1, paramLong2, paramString, paramBoolean1, false);
          continue;
        }
        throw localThrowable;
      }
    }
  }
  
  public static void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {}
    for (;;)
    {
      try
      {
        SmcLogic.writeImportKvData(paramLong, paramString, paramBoolean1, false);
        if (nEB) {
          j.bxa().s(paramLong, paramString);
        }
        return;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { bk.j(localException) });
        continue;
      }
      try
      {
        SmcLogic.writeKvData(paramLong, paramString, paramBoolean1, false);
      }
      catch (Throwable localThrowable)
      {
        y.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (d.gG(20))
        {
          SmcLogic.writeKvData(paramLong, paramString, paramBoolean1, false);
          continue;
        }
        throw localThrowable;
      }
    }
  }
  
  public static void a(long paramLong, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      try
      {
        SmcLogic.writeImportKvPbData(paramLong, paramArrayOfByte, paramBoolean1);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        y.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { bk.j(paramArrayOfByte) });
        return;
      }
    }
    SmcLogic.writeKvPbData(paramLong, paramArrayOfByte, paramBoolean1);
  }
  
  public static void b(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    int i;
    if (e.class.getClassLoader() == null) {
      i = -1;
    }
    for (;;)
    {
      int j;
      if (Thread.currentThread().getContextClassLoader() == null)
      {
        j = -1;
        y.i("MicroMsg.KVEasyReport", "SmcLogic.reportIDKey class loader %s, %s ", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      }
      try
      {
        SmcLogic.reportIDKey(paramLong1, paramLong2, paramLong3, paramBoolean);
        if (nFB)
        {
          if (nFy == null) {
            bwV();
          }
          paramLong1 = bk.a((Long)nFy.get(Long.valueOf(paramLong1)), 0L);
          if (paramLong1 > 0L) {
            b(paramLong1, paramLong2, paramLong3, paramBoolean);
          }
        }
        if (ae.cqV()) {
          an.crn();
        }
        return;
        i = e.class.getClassLoader().hashCode();
        continue;
        j = Thread.currentThread().getContextClassLoader().hashCode();
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
          if (!d.gG(20)) {
            break;
          }
          SmcLogic.reportIDKey(paramLong1, paramLong2, paramLong3, paramBoolean);
        }
        throw localThrowable;
      }
    }
  }
  
  /* Error */
  public static void bwV()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 131	com/tencent/mm/plugin/report/service/e:nFy	Ljava/util/Map;
    //   6: ifnonnull +15 -> 21
    //   9: new 167	java/util/HashMap
    //   12: dup
    //   13: bipush 20
    //   15: invokespecial 170	java/util/HashMap:<init>	(I)V
    //   18: putstatic 131	com/tencent/mm/plugin/report/service/e:nFy	Ljava/util/Map;
    //   21: invokestatic 174	com/tencent/mm/plugin/report/b/a:bwN	()Lcom/tencent/mm/protocal/c/apb;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +103 -> 129
    //   29: aload_0
    //   30: getfield 179	com/tencent/mm/protocal/c/apb:tkU	I
    //   33: getstatic 25	com/tencent/mm/plugin/report/service/e:nFA	I
    //   36: if_icmpeq +93 -> 129
    //   39: aload_0
    //   40: getfield 179	com/tencent/mm/protocal/c/apb:tkU	I
    //   43: putstatic 25	com/tencent/mm/plugin/report/service/e:nFA	I
    //   46: getstatic 131	com/tencent/mm/plugin/report/service/e:nFy	Ljava/util/Map;
    //   49: invokeinterface 182 1 0
    //   54: aload_0
    //   55: getfield 186	com/tencent/mm/protocal/c/apb:tkV	Ljava/util/LinkedList;
    //   58: astore_0
    //   59: aload_0
    //   60: ifnull +69 -> 129
    //   63: aload_0
    //   64: invokevirtual 192	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   67: astore_0
    //   68: aload_0
    //   69: invokeinterface 197 1 0
    //   74: ifeq +55 -> 129
    //   77: aload_0
    //   78: invokeinterface 201 1 0
    //   83: checkcast 203	com/tencent/mm/protocal/c/ayi
    //   86: astore_1
    //   87: getstatic 131	com/tencent/mm/plugin/report/service/e:nFy	Ljava/util/Map;
    //   90: new 136	java/lang/Long
    //   93: dup
    //   94: aload_1
    //   95: getfield 206	com/tencent/mm/protocal/c/ayi:tus	I
    //   98: i2l
    //   99: invokespecial 209	java/lang/Long:<init>	(J)V
    //   102: new 136	java/lang/Long
    //   105: dup
    //   106: aload_1
    //   107: getfield 212	com/tencent/mm/protocal/c/ayi:tut	I
    //   110: i2l
    //   111: invokespecial 209	java/lang/Long:<init>	(J)V
    //   114: invokeinterface 216 3 0
    //   119: pop
    //   120: goto -52 -> 68
    //   123: astore_0
    //   124: ldc 2
    //   126: monitorexit
    //   127: aload_0
    //   128: athrow
    //   129: ldc 54
    //   131: ldc 218
    //   133: iconst_4
    //   134: anewarray 4	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: getstatic 25	com/tencent/mm/plugin/report/service/e:nFA	I
    //   142: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   145: aastore
    //   146: dup
    //   147: iconst_1
    //   148: getstatic 131	com/tencent/mm/plugin/report/service/e:nFy	Ljava/util/Map;
    //   151: invokeinterface 221 1 0
    //   156: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: dup
    //   161: iconst_2
    //   162: getstatic 131	com/tencent/mm/plugin/report/service/e:nFy	Ljava/util/Map;
    //   165: aastore
    //   166: dup
    //   167: iconst_3
    //   168: invokestatic 225	com/tencent/mm/sdk/platformtools/bk:csb	()Lcom/tencent/mm/sdk/platformtools/ak;
    //   171: aastore
    //   172: invokestatic 126	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: ldc 2
    //   177: monitorexit
    //   178: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   24	54	0	localObject1	Object
    //   123	5	0	localObject2	Object
    //   86	21	1	localayi	com.tencent.mm.protocal.c.ayi
    // Exception table:
    //   from	to	target	type
    //   3	21	123	finally
    //   21	25	123	finally
    //   29	59	123	finally
    //   63	68	123	finally
    //   68	120	123	finally
    //   129	175	123	finally
  }
  
  public static void c(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList != null) {}
    try
    {
      SmcLogic.reportListIDKey((IDKey[])paramArrayList.toArray(new IDKey[paramArrayList.size()]), paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      y.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
      if (d.gG(20))
      {
        SmcLogic.reportListIDKey((IDKey[])paramArrayList.toArray(new IDKey[paramArrayList.size()]), paramBoolean);
        return;
      }
      throw localThrowable;
    }
  }
  
  public static void iu(boolean paramBoolean)
  {
    nEB = paramBoolean;
  }
  
  public static void iw(boolean paramBoolean)
  {
    y.i("MicroMsg.KVEasyReport", "summerhv setHeavyUser [%b %b], stack[%s]", new Object[] { Boolean.valueOf(nFB), Boolean.valueOf(paramBoolean), bk.csb() });
    nFB = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.e
 * JD-Core Version:    0.7.0.1
 */