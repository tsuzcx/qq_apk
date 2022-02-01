package com.tencent.mm.plugin.report.service;

import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Map;

public class e
{
  private static boolean vIQ;
  private static Map<Long, Long> vJP;
  private static a vJQ;
  private static int vJR;
  private static boolean vJS;
  
  static
  {
    AppMethodBeat.i(143841);
    vJQ = new a();
    vJR = -1;
    vJS = false;
    vIQ = false;
    AppMethodBeat.o(143841);
  }
  
  public static void a(long paramLong1, long paramLong2, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(143835);
    if (paramBoolean2) {}
    for (;;)
    {
      try
      {
        SmcLogic.writeImportKvDataWithType(paramLong1, paramLong2, paramString, paramBoolean1, paramBoolean3);
        if (vIQ) {
          k.dkR().y(paramLong1, paramString);
        }
        AppMethodBeat.o(143835);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { bt.m(localException) });
        continue;
      }
      try
      {
        SmcLogic.writeKvDataWithType(paramLong1, paramLong2, paramString, paramBoolean1, paramBoolean3);
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (d.lg(20))
        {
          SmcLogic.writeKvDataWithType(paramLong1, paramLong2, paramString, paramBoolean1, paramBoolean3);
          continue;
        }
        AppMethodBeat.o(143835);
        throw localThrowable;
      }
    }
  }
  
  public static void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(143834);
    if (paramBoolean2) {}
    for (;;)
    {
      try
      {
        SmcLogic.writeImportKvData(paramLong, paramString, paramBoolean1, paramBoolean3);
        if (vIQ) {
          k.dkR().y(paramLong, paramString);
        }
        AppMethodBeat.o(143834);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { bt.m(localException) });
        continue;
      }
      try
      {
        SmcLogic.writeKvData(paramLong, paramString, paramBoolean1, paramBoolean3);
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (d.lg(20))
        {
          SmcLogic.writeKvData(paramLong, paramString, paramBoolean1, paramBoolean3);
          continue;
        }
        AppMethodBeat.o(143834);
        throw localThrowable;
      }
    }
  }
  
  public static void a(long paramLong, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143836);
    if (paramBoolean2) {
      try
      {
        SmcLogic.writeImportKvPbData(paramLong, paramArrayOfByte, paramBoolean1);
        AppMethodBeat.o(143836);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        ad.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { bt.m(paramArrayOfByte) });
        AppMethodBeat.o(143836);
        return;
      }
    }
    SmcLogic.writeKvPbData(paramLong, paramArrayOfByte, paramBoolean1);
    AppMethodBeat.o(143836);
  }
  
  public static void b(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(143837);
    for (;;)
    {
      int i;
      label16:
      int j;
      if (e.class.getClassLoader() == null)
      {
        i = -1;
        if (Thread.currentThread().getContextClassLoader() != null) {
          break label129;
        }
        j = -1;
        ad.i("MicroMsg.KVEasyReport", "SmcLogic.reportIDKey class loader %s, %s ", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      }
      try
      {
        SmcLogic.reportIDKey(paramLong1, paramLong2, paramLong3, paramBoolean);
        if (vJS)
        {
          if (vJP == null) {
            dkL();
          }
          long l = bt.a((Long)vJP.get(Long.valueOf(paramLong1)), 0L);
          paramLong1 = l;
          if (l > 0L) {
            continue;
          }
        }
        AppMethodBeat.o(143837);
        return;
        i = e.class.getClassLoader().hashCode();
        break label16;
        label129:
        j = Thread.currentThread().getContextClassLoader().hashCode();
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
          if (!d.lg(20)) {
            break;
          }
          SmcLogic.reportIDKey(paramLong1, paramLong2, paramLong3, paramBoolean);
        }
        AppMethodBeat.o(143837);
        throw localThrowable;
      }
    }
  }
  
  public static void d(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(143838);
    if (paramArrayList != null) {
      try
      {
        SmcLogic.reportListIDKey((IDKey[])paramArrayList.toArray(new IDKey[paramArrayList.size()]), paramBoolean);
        AppMethodBeat.o(143838);
        return;
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (d.lg(20))
        {
          SmcLogic.reportListIDKey((IDKey[])paramArrayList.toArray(new IDKey[paramArrayList.size()]), paramBoolean);
          AppMethodBeat.o(143838);
          return;
        }
        AppMethodBeat.o(143838);
        throw localThrowable;
      }
    }
    AppMethodBeat.o(143838);
  }
  
  /* Error */
  public static void dkL()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 190
    //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 146	com/tencent/mm/plugin/report/service/e:vJP	Ljava/util/Map;
    //   11: ifnonnull +15 -> 26
    //   14: new 192	java/util/HashMap
    //   17: dup
    //   18: bipush 20
    //   20: invokespecial 194	java/util/HashMap:<init>	(I)V
    //   23: putstatic 146	com/tencent/mm/plugin/report/service/e:vJP	Ljava/util/Map;
    //   26: invokestatic 198	com/tencent/mm/plugin/report/b/a:dkF	()Lcom/tencent/mm/protocal/protobuf/bfy;
    //   29: astore_0
    //   30: aload_0
    //   31: ifnull +103 -> 134
    //   34: aload_0
    //   35: getfield 203	com/tencent/mm/protocal/protobuf/bfy:DDD	I
    //   38: getstatic 32	com/tencent/mm/plugin/report/service/e:vJR	I
    //   41: if_icmpeq +93 -> 134
    //   44: aload_0
    //   45: getfield 203	com/tencent/mm/protocal/protobuf/bfy:DDD	I
    //   48: putstatic 32	com/tencent/mm/plugin/report/service/e:vJR	I
    //   51: getstatic 146	com/tencent/mm/plugin/report/service/e:vJP	Ljava/util/Map;
    //   54: invokeinterface 206 1 0
    //   59: aload_0
    //   60: getfield 210	com/tencent/mm/protocal/protobuf/bfy:DDE	Ljava/util/LinkedList;
    //   63: astore_0
    //   64: aload_0
    //   65: ifnull +69 -> 134
    //   68: aload_0
    //   69: invokevirtual 216	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   72: astore_0
    //   73: aload_0
    //   74: invokeinterface 222 1 0
    //   79: ifeq +55 -> 134
    //   82: aload_0
    //   83: invokeinterface 226 1 0
    //   88: checkcast 228	com/tencent/mm/protocal/protobuf/bsa
    //   91: astore_1
    //   92: getstatic 146	com/tencent/mm/plugin/report/service/e:vJP	Ljava/util/Map;
    //   95: new 151	java/lang/Long
    //   98: dup
    //   99: aload_1
    //   100: getfield 231	com/tencent/mm/protocal/protobuf/bsa:DPy	I
    //   103: i2l
    //   104: invokespecial 234	java/lang/Long:<init>	(J)V
    //   107: new 151	java/lang/Long
    //   110: dup
    //   111: aload_1
    //   112: getfield 237	com/tencent/mm/protocal/protobuf/bsa:DPz	I
    //   115: i2l
    //   116: invokespecial 234	java/lang/Long:<init>	(J)V
    //   119: invokeinterface 241 3 0
    //   124: pop
    //   125: goto -52 -> 73
    //   128: astore_0
    //   129: ldc 2
    //   131: monitorexit
    //   132: aload_0
    //   133: athrow
    //   134: ldc 66
    //   136: ldc 243
    //   138: iconst_4
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: getstatic 32	com/tencent/mm/plugin/report/service/e:vJR	I
    //   147: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   150: aastore
    //   151: dup
    //   152: iconst_1
    //   153: getstatic 146	com/tencent/mm/plugin/report/service/e:vJP	Ljava/util/Map;
    //   156: invokeinterface 244 1 0
    //   161: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   164: aastore
    //   165: dup
    //   166: iconst_2
    //   167: getstatic 146	com/tencent/mm/plugin/report/service/e:vJP	Ljava/util/Map;
    //   170: aastore
    //   171: dup
    //   172: iconst_3
    //   173: invokestatic 248	com/tencent/mm/sdk/platformtools/bt:eGN	()Lcom/tencent/mm/sdk/platformtools/at;
    //   176: aastore
    //   177: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: ldc 190
    //   182: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: ldc 2
    //   187: monitorexit
    //   188: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	54	0	localObject1	Object
    //   128	5	0	localObject2	Object
    //   91	21	1	localbsa	com.tencent.mm.protocal.protobuf.bsa
    // Exception table:
    //   from	to	target	type
    //   3	26	128	finally
    //   26	30	128	finally
    //   34	64	128	finally
    //   68	73	128	finally
    //   73	125	128	finally
    //   134	185	128	finally
  }
  
  public static void oQ(boolean paramBoolean)
  {
    vIQ = paramBoolean;
  }
  
  public static void oR(boolean paramBoolean)
  {
    AppMethodBeat.i(143839);
    ad.i("MicroMsg.KVEasyReport", "summerhv setHeavyUser [%b %b], stack[%s]", new Object[] { Boolean.valueOf(vJS), Boolean.valueOf(paramBoolean), bt.eGN() });
    vJS = paramBoolean;
    AppMethodBeat.o(143839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.e
 * JD-Core Version:    0.7.0.1
 */