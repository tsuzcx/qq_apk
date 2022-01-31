package com.tencent.mm.plugin.report.service;

import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Map;

public class e
{
  private static boolean qrC;
  private static Map<Long, Long> qsB;
  private static a qsC;
  private static int qsD;
  private static boolean qsE;
  
  static
  {
    AppMethodBeat.i(72728);
    qsC = new a();
    qsD = -1;
    qsE = false;
    qrC = false;
    AppMethodBeat.o(72728);
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(72724);
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
        ab.i("MicroMsg.KVEasyReport", "SmcLogic.reportIDKey class loader %s, %s ", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      }
      try
      {
        SmcLogic.reportIDKey(paramLong1, paramLong2, paramLong3, paramBoolean);
        if (qsE)
        {
          if (qsB == null) {
            chO();
          }
          long l = bo.a((Long)qsB.get(Long.valueOf(paramLong1)), 0L);
          paramLong1 = l;
          if (l > 0L) {
            continue;
          }
        }
        AppMethodBeat.o(72724);
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
          ab.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
          if (!d.fw(20)) {
            break;
          }
          SmcLogic.reportIDKey(paramLong1, paramLong2, paramLong3, paramBoolean);
        }
        AppMethodBeat.o(72724);
        throw localThrowable;
      }
    }
  }
  
  public static void a(long paramLong1, long paramLong2, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(72722);
    if (paramBoolean2) {}
    for (;;)
    {
      try
      {
        SmcLogic.writeImportKvDataWithType(paramLong1, paramLong2, paramString, paramBoolean1, paramBoolean3);
        if (qrC) {
          j.chT().t(paramLong1, paramString);
        }
        AppMethodBeat.o(72722);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { bo.l(localException) });
        continue;
      }
      try
      {
        SmcLogic.writeKvDataWithType(paramLong1, paramLong2, paramString, paramBoolean1, paramBoolean3);
      }
      catch (Throwable localThrowable)
      {
        ab.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (d.fw(20))
        {
          SmcLogic.writeKvDataWithType(paramLong1, paramLong2, paramString, paramBoolean1, paramBoolean3);
          continue;
        }
        AppMethodBeat.o(72722);
        throw localThrowable;
      }
    }
  }
  
  public static void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(72721);
    if (paramBoolean2) {}
    for (;;)
    {
      try
      {
        SmcLogic.writeImportKvData(paramLong, paramString, paramBoolean1, paramBoolean3);
        if (qrC) {
          j.chT().t(paramLong, paramString);
        }
        AppMethodBeat.o(72721);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { bo.l(localException) });
        continue;
      }
      try
      {
        SmcLogic.writeKvData(paramLong, paramString, paramBoolean1, paramBoolean3);
      }
      catch (Throwable localThrowable)
      {
        ab.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (d.fw(20))
        {
          SmcLogic.writeKvData(paramLong, paramString, paramBoolean1, paramBoolean3);
          continue;
        }
        AppMethodBeat.o(72721);
        throw localThrowable;
      }
    }
  }
  
  public static void a(long paramLong, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(72723);
    if (paramBoolean2) {
      try
      {
        SmcLogic.writeImportKvPbData(paramLong, paramArrayOfByte, paramBoolean1);
        AppMethodBeat.o(72723);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        ab.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { bo.l(paramArrayOfByte) });
        AppMethodBeat.o(72723);
        return;
      }
    }
    SmcLogic.writeKvPbData(paramLong, paramArrayOfByte, paramBoolean1);
    AppMethodBeat.o(72723);
  }
  
  /* Error */
  public static void chO()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 167
    //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 83	com/tencent/mm/plugin/report/service/e:qsB	Ljava/util/Map;
    //   11: ifnonnull +15 -> 26
    //   14: new 169	java/util/HashMap
    //   17: dup
    //   18: bipush 20
    //   20: invokespecial 171	java/util/HashMap:<init>	(I)V
    //   23: putstatic 83	com/tencent/mm/plugin/report/service/e:qsB	Ljava/util/Map;
    //   26: invokestatic 175	com/tencent/mm/plugin/report/b/a:chH	()Lcom/tencent/mm/protocal/protobuf/auw;
    //   29: astore_0
    //   30: aload_0
    //   31: ifnull +103 -> 134
    //   34: aload_0
    //   35: getfield 180	com/tencent/mm/protocal/protobuf/auw:xkc	I
    //   38: getstatic 32	com/tencent/mm/plugin/report/service/e:qsD	I
    //   41: if_icmpeq +93 -> 134
    //   44: aload_0
    //   45: getfield 180	com/tencent/mm/protocal/protobuf/auw:xkc	I
    //   48: putstatic 32	com/tencent/mm/plugin/report/service/e:qsD	I
    //   51: getstatic 83	com/tencent/mm/plugin/report/service/e:qsB	Ljava/util/Map;
    //   54: invokeinterface 183 1 0
    //   59: aload_0
    //   60: getfield 187	com/tencent/mm/protocal/protobuf/auw:xkd	Ljava/util/LinkedList;
    //   63: astore_0
    //   64: aload_0
    //   65: ifnull +69 -> 134
    //   68: aload_0
    //   69: invokevirtual 193	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   72: astore_0
    //   73: aload_0
    //   74: invokeinterface 199 1 0
    //   79: ifeq +55 -> 134
    //   82: aload_0
    //   83: invokeinterface 203 1 0
    //   88: checkcast 205	com/tencent/mm/protocal/protobuf/bfe
    //   91: astore_1
    //   92: getstatic 83	com/tencent/mm/plugin/report/service/e:qsB	Ljava/util/Map;
    //   95: new 88	java/lang/Long
    //   98: dup
    //   99: aload_1
    //   100: getfield 208	com/tencent/mm/protocal/protobuf/bfe:xuu	I
    //   103: i2l
    //   104: invokespecial 211	java/lang/Long:<init>	(J)V
    //   107: new 88	java/lang/Long
    //   110: dup
    //   111: aload_1
    //   112: getfield 214	com/tencent/mm/protocal/protobuf/bfe:xuv	I
    //   115: i2l
    //   116: invokespecial 211	java/lang/Long:<init>	(J)V
    //   119: invokeinterface 218 3 0
    //   124: pop
    //   125: goto -52 -> 73
    //   128: astore_0
    //   129: ldc 2
    //   131: monitorexit
    //   132: aload_0
    //   133: athrow
    //   134: ldc 63
    //   136: ldc 220
    //   138: iconst_4
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: getstatic 32	com/tencent/mm/plugin/report/service/e:qsD	I
    //   147: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   150: aastore
    //   151: dup
    //   152: iconst_1
    //   153: getstatic 83	com/tencent/mm/plugin/report/service/e:qsB	Ljava/util/Map;
    //   156: invokeinterface 223 1 0
    //   161: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   164: aastore
    //   165: dup
    //   166: iconst_2
    //   167: getstatic 83	com/tencent/mm/plugin/report/service/e:qsB	Ljava/util/Map;
    //   170: aastore
    //   171: dup
    //   172: iconst_3
    //   173: invokestatic 227	com/tencent/mm/sdk/platformtools/bo:dtY	()Lcom/tencent/mm/sdk/platformtools/an;
    //   176: aastore
    //   177: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: ldc 167
    //   182: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: ldc 2
    //   187: monitorexit
    //   188: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	54	0	localObject1	Object
    //   128	5	0	localObject2	Object
    //   91	21	1	localbfe	com.tencent.mm.protocal.protobuf.bfe
    // Exception table:
    //   from	to	target	type
    //   3	26	128	finally
    //   26	30	128	finally
    //   34	64	128	finally
    //   68	73	128	finally
    //   73	125	128	finally
    //   134	185	128	finally
  }
  
  public static void e(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(72725);
    if (paramArrayList != null) {
      try
      {
        SmcLogic.reportListIDKey((IDKey[])paramArrayList.toArray(new IDKey[paramArrayList.size()]), paramBoolean);
        AppMethodBeat.o(72725);
        return;
      }
      catch (Throwable localThrowable)
      {
        ab.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (d.fw(20))
        {
          SmcLogic.reportListIDKey((IDKey[])paramArrayList.toArray(new IDKey[paramArrayList.size()]), paramBoolean);
          AppMethodBeat.o(72725);
          return;
        }
        AppMethodBeat.o(72725);
        throw localThrowable;
      }
    }
    AppMethodBeat.o(72725);
  }
  
  public static void ky(boolean paramBoolean)
  {
    qrC = paramBoolean;
  }
  
  public static void kz(boolean paramBoolean)
  {
    AppMethodBeat.i(72726);
    ab.i("MicroMsg.KVEasyReport", "summerhv setHeavyUser [%b %b], stack[%s]", new Object[] { Boolean.valueOf(qsE), Boolean.valueOf(paramBoolean), bo.dtY() });
    qsE = paramBoolean;
    AppMethodBeat.o(72726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.e
 * JD-Core Version:    0.7.0.1
 */