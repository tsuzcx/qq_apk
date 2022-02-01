package com.tencent.mm.plugin.report.service;

import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Map;

public class d
{
  private static a yhA;
  private static int yhB;
  private static boolean yhC;
  private static Map<Long, Long> yhz;
  
  static
  {
    AppMethodBeat.i(143841);
    yhA = new a();
    yhB = -1;
    yhC = false;
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
        j.dKs();
        j.z(paramLong1, paramString);
        AppMethodBeat.o(143835);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { bt.n(localException) });
        continue;
      }
      try
      {
        SmcLogic.writeKvDataWithType(paramLong1, paramLong2, paramString, paramBoolean1, paramBoolean3);
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (com.tencent.mm.compatible.util.d.lz(20))
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
        j.dKs();
        j.z(paramLong, paramString);
        AppMethodBeat.o(143834);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { bt.n(localException) });
        continue;
      }
      try
      {
        SmcLogic.writeKvData(paramLong, paramString, paramBoolean1, paramBoolean3);
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (com.tencent.mm.compatible.util.d.lz(20))
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
        ad.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { bt.n(paramArrayOfByte) });
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
      if (d.class.getClassLoader() == null)
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
        if (yhC)
        {
          if (yhz == null) {
            dKm();
          }
          long l = bt.a((Long)yhz.get(Long.valueOf(paramLong1)), 0L);
          paramLong1 = l;
          if (l > 0L) {
            continue;
          }
        }
        AppMethodBeat.o(143837);
        return;
        i = d.class.getClassLoader().hashCode();
        break label16;
        label129:
        j = Thread.currentThread().getContextClassLoader().hashCode();
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
          if (!com.tencent.mm.compatible.util.d.lz(20)) {
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
        if (com.tencent.mm.compatible.util.d.lz(20))
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
  public static void dKm()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 187
    //   5: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 143	com/tencent/mm/plugin/report/service/d:yhz	Ljava/util/Map;
    //   11: ifnonnull +15 -> 26
    //   14: new 189	java/util/HashMap
    //   17: dup
    //   18: bipush 20
    //   20: invokespecial 191	java/util/HashMap:<init>	(I)V
    //   23: putstatic 143	com/tencent/mm/plugin/report/service/d:yhz	Ljava/util/Map;
    //   26: invokestatic 195	com/tencent/mm/plugin/report/b/a:dKg	()Lcom/tencent/mm/protocal/protobuf/bny;
    //   29: astore_0
    //   30: aload_0
    //   31: ifnull +103 -> 134
    //   34: aload_0
    //   35: getfield 200	com/tencent/mm/protocal/protobuf/bny:GIv	I
    //   38: getstatic 31	com/tencent/mm/plugin/report/service/d:yhB	I
    //   41: if_icmpeq +93 -> 134
    //   44: aload_0
    //   45: getfield 200	com/tencent/mm/protocal/protobuf/bny:GIv	I
    //   48: putstatic 31	com/tencent/mm/plugin/report/service/d:yhB	I
    //   51: getstatic 143	com/tencent/mm/plugin/report/service/d:yhz	Ljava/util/Map;
    //   54: invokeinterface 203 1 0
    //   59: aload_0
    //   60: getfield 207	com/tencent/mm/protocal/protobuf/bny:GIw	Ljava/util/LinkedList;
    //   63: astore_0
    //   64: aload_0
    //   65: ifnull +69 -> 134
    //   68: aload_0
    //   69: invokevirtual 213	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   72: astore_0
    //   73: aload_0
    //   74: invokeinterface 219 1 0
    //   79: ifeq +55 -> 134
    //   82: aload_0
    //   83: invokeinterface 223 1 0
    //   88: checkcast 225	com/tencent/mm/protocal/protobuf/cbh
    //   91: astore_1
    //   92: getstatic 143	com/tencent/mm/plugin/report/service/d:yhz	Ljava/util/Map;
    //   95: new 148	java/lang/Long
    //   98: dup
    //   99: aload_1
    //   100: getfield 228	com/tencent/mm/protocal/protobuf/cbh:GVy	I
    //   103: i2l
    //   104: invokespecial 231	java/lang/Long:<init>	(J)V
    //   107: new 148	java/lang/Long
    //   110: dup
    //   111: aload_1
    //   112: getfield 234	com/tencent/mm/protocal/protobuf/cbh:GVz	I
    //   115: i2l
    //   116: invokespecial 231	java/lang/Long:<init>	(J)V
    //   119: invokeinterface 238 3 0
    //   124: pop
    //   125: goto -52 -> 73
    //   128: astore_0
    //   129: ldc 2
    //   131: monitorexit
    //   132: aload_0
    //   133: athrow
    //   134: ldc 63
    //   136: ldc 240
    //   138: iconst_4
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: getstatic 31	com/tencent/mm/plugin/report/service/d:yhB	I
    //   147: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   150: aastore
    //   151: dup
    //   152: iconst_1
    //   153: getstatic 143	com/tencent/mm/plugin/report/service/d:yhz	Ljava/util/Map;
    //   156: invokeinterface 241 1 0
    //   161: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   164: aastore
    //   165: dup
    //   166: iconst_2
    //   167: getstatic 143	com/tencent/mm/plugin/report/service/d:yhz	Ljava/util/Map;
    //   170: aastore
    //   171: dup
    //   172: iconst_3
    //   173: invokestatic 245	com/tencent/mm/sdk/platformtools/bt:flS	()Lcom/tencent/mm/sdk/platformtools/at;
    //   176: aastore
    //   177: invokestatic 138	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: ldc 187
    //   182: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: ldc 2
    //   187: monitorexit
    //   188: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	54	0	localObject1	Object
    //   128	5	0	localObject2	Object
    //   91	21	1	localcbh	com.tencent.mm.protocal.protobuf.cbh
    // Exception table:
    //   from	to	target	type
    //   3	26	128	finally
    //   26	30	128	finally
    //   34	64	128	finally
    //   68	73	128	finally
    //   73	125	128	finally
    //   134	185	128	finally
  }
  
  public static void qo(boolean paramBoolean)
  {
    AppMethodBeat.i(143839);
    ad.i("MicroMsg.KVEasyReport", "summerhv setHeavyUser [%b %b], stack[%s]", new Object[] { Boolean.valueOf(yhC), Boolean.valueOf(paramBoolean), bt.flS() });
    yhC = paramBoolean;
    AppMethodBeat.o(143839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.d
 * JD-Core Version:    0.7.0.1
 */