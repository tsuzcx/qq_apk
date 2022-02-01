package com.tencent.mm.plugin.report.service;

import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Map;

public class d
{
  private static Map<Long, Long> yxq;
  private static a yxr;
  private static int yxs;
  private static boolean yxt;
  
  static
  {
    AppMethodBeat.i(143841);
    yxr = new a();
    yxs = -1;
    yxt = false;
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
        j.dNK();
        j.A(paramLong1, paramString);
        AppMethodBeat.o(143835);
        return;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { bu.o(localException) });
        continue;
      }
      try
      {
        SmcLogic.writeKvDataWithType(paramLong1, paramLong2, paramString, paramBoolean1, paramBoolean3);
      }
      catch (Throwable localThrowable)
      {
        ae.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (com.tencent.mm.compatible.util.d.lB(20))
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
        j.dNK();
        j.A(paramLong, paramString);
        AppMethodBeat.o(143834);
        return;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { bu.o(localException) });
        continue;
      }
      try
      {
        SmcLogic.writeKvData(paramLong, paramString, paramBoolean1, paramBoolean3);
      }
      catch (Throwable localThrowable)
      {
        ae.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (com.tencent.mm.compatible.util.d.lB(20))
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
        ae.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { bu.o(paramArrayOfByte) });
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
        ae.i("MicroMsg.KVEasyReport", "SmcLogic.reportIDKey class loader %s, %s ", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      }
      try
      {
        SmcLogic.reportIDKey(paramLong1, paramLong2, paramLong3, paramBoolean);
        if (yxt)
        {
          if (yxq == null) {
            dNE();
          }
          long l = bu.a((Long)yxq.get(Long.valueOf(paramLong1)), 0L);
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
          ae.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
          if (!com.tencent.mm.compatible.util.d.lB(20)) {
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
        ae.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (com.tencent.mm.compatible.util.d.lB(20))
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
  public static void dNE()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 186
    //   5: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 142	com/tencent/mm/plugin/report/service/d:yxq	Ljava/util/Map;
    //   11: ifnonnull +15 -> 26
    //   14: new 188	java/util/HashMap
    //   17: dup
    //   18: bipush 20
    //   20: invokespecial 190	java/util/HashMap:<init>	(I)V
    //   23: putstatic 142	com/tencent/mm/plugin/report/service/d:yxq	Ljava/util/Map;
    //   26: invokestatic 194	com/tencent/mm/plugin/report/b/a:dNy	()Lcom/tencent/mm/protocal/protobuf/boq;
    //   29: astore_0
    //   30: aload_0
    //   31: ifnull +103 -> 134
    //   34: aload_0
    //   35: getfield 199	com/tencent/mm/protocal/protobuf/boq:HbX	I
    //   38: getstatic 31	com/tencent/mm/plugin/report/service/d:yxs	I
    //   41: if_icmpeq +93 -> 134
    //   44: aload_0
    //   45: getfield 199	com/tencent/mm/protocal/protobuf/boq:HbX	I
    //   48: putstatic 31	com/tencent/mm/plugin/report/service/d:yxs	I
    //   51: getstatic 142	com/tencent/mm/plugin/report/service/d:yxq	Ljava/util/Map;
    //   54: invokeinterface 202 1 0
    //   59: aload_0
    //   60: getfield 206	com/tencent/mm/protocal/protobuf/boq:HbY	Ljava/util/LinkedList;
    //   63: astore_0
    //   64: aload_0
    //   65: ifnull +69 -> 134
    //   68: aload_0
    //   69: invokevirtual 212	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   72: astore_0
    //   73: aload_0
    //   74: invokeinterface 218 1 0
    //   79: ifeq +55 -> 134
    //   82: aload_0
    //   83: invokeinterface 222 1 0
    //   88: checkcast 224	com/tencent/mm/protocal/protobuf/ccb
    //   91: astore_1
    //   92: getstatic 142	com/tencent/mm/plugin/report/service/d:yxq	Ljava/util/Map;
    //   95: new 147	java/lang/Long
    //   98: dup
    //   99: aload_1
    //   100: getfield 227	com/tencent/mm/protocal/protobuf/ccb:HoZ	I
    //   103: i2l
    //   104: invokespecial 230	java/lang/Long:<init>	(J)V
    //   107: new 147	java/lang/Long
    //   110: dup
    //   111: aload_1
    //   112: getfield 233	com/tencent/mm/protocal/protobuf/ccb:Hpa	I
    //   115: i2l
    //   116: invokespecial 230	java/lang/Long:<init>	(J)V
    //   119: invokeinterface 237 3 0
    //   124: pop
    //   125: goto -52 -> 73
    //   128: astore_0
    //   129: ldc 2
    //   131: monitorexit
    //   132: aload_0
    //   133: athrow
    //   134: ldc 63
    //   136: ldc 239
    //   138: iconst_4
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: getstatic 31	com/tencent/mm/plugin/report/service/d:yxs	I
    //   147: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   150: aastore
    //   151: dup
    //   152: iconst_1
    //   153: getstatic 142	com/tencent/mm/plugin/report/service/d:yxq	Ljava/util/Map;
    //   156: invokeinterface 240 1 0
    //   161: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   164: aastore
    //   165: dup
    //   166: iconst_2
    //   167: getstatic 142	com/tencent/mm/plugin/report/service/d:yxq	Ljava/util/Map;
    //   170: aastore
    //   171: dup
    //   172: iconst_3
    //   173: invokestatic 244	com/tencent/mm/sdk/platformtools/bu:fpN	()Lcom/tencent/mm/sdk/platformtools/au;
    //   176: aastore
    //   177: invokestatic 137	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: ldc 186
    //   182: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: ldc 2
    //   187: monitorexit
    //   188: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	54	0	localObject1	Object
    //   128	5	0	localObject2	Object
    //   91	21	1	localccb	com.tencent.mm.protocal.protobuf.ccb
    // Exception table:
    //   from	to	target	type
    //   3	26	128	finally
    //   26	30	128	finally
    //   34	64	128	finally
    //   68	73	128	finally
    //   73	125	128	finally
    //   134	185	128	finally
  }
  
  public static void qv(boolean paramBoolean)
  {
    AppMethodBeat.i(143839);
    ae.i("MicroMsg.KVEasyReport", "summerhv setHeavyUser [%b %b], stack[%s]", new Object[] { Boolean.valueOf(yxt), Boolean.valueOf(paramBoolean), bu.fpN() });
    yxt = paramBoolean;
    AppMethodBeat.o(143839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.d
 * JD-Core Version:    0.7.0.1
 */