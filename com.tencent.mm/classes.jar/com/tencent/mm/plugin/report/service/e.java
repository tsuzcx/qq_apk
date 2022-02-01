package com.tencent.mm.plugin.report.service;

import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class e
{
  private static Map<Long, Long> OzT;
  private static a OzU;
  private static int OzV;
  private static boolean OzW;
  private static final Object OzX;
  private static ConcurrentHashMap<Long, Object> OzY;
  
  static
  {
    AppMethodBeat.i(143841);
    OzU = new a();
    OzV = -1;
    OzW = false;
    OzX = new Object();
    OzY = new ConcurrentHashMap();
    AppMethodBeat.o(143841);
  }
  
  public static void BJ(boolean paramBoolean)
  {
    AppMethodBeat.i(143839);
    Log.i("MicroMsg.KVEasyReport", "summerhv setHeavyUser [%b %b], stack[%s]", new Object[] { Boolean.valueOf(OzW), Boolean.valueOf(paramBoolean), Util.getStack() });
    OzW = paramBoolean;
    Object localObject2 = com.tencent.mm.plugin.expt.e.d.dNI();
    Object localObject1 = new HashSet();
    localObject2 = ((com.tencent.mm.plugin.expt.e.d)localObject2).hx("clicfg_ignore_freq_logid", "");
    if (!Util.isNullOrNil((String)localObject2))
    {
      localObject2 = ((String)localObject2).split(";");
      if (localObject2 != null)
      {
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          ((HashSet)localObject1).add(Long.valueOf(Util.getLong(localObject2[i], -1L)));
          i += 1;
        }
      }
    }
    OzY.clear();
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      OzY.put(localObject2, OzX);
    }
    Log.i("MicroMsg.KVEasyReport", "reset ignore freq limit logid [%s]", new Object[] { OzY });
    AppMethodBeat.o(143839);
  }
  
  private static boolean O(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(261708);
    if (paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = OzY.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(261708);
      return paramBoolean;
    }
  }
  
  public static void a(long paramLong1, long paramLong2, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(143835);
    paramBoolean3 = O(paramLong1, paramBoolean3);
    if (paramBoolean2) {}
    for (;;)
    {
      try
      {
        SmcLogic.writeImportKvDataWithType(paramLong1, paramLong2, paramString, paramBoolean1, paramBoolean3);
        k.gNY();
        k.ad(paramLong1, paramString);
        AppMethodBeat.o(143835);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { Util.stackTraceToString(localException) });
        continue;
      }
      try
      {
        SmcLogic.writeKvDataWithType(paramLong1, paramLong2, paramString, paramBoolean1, paramBoolean3);
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (com.tencent.mm.compatible.util.d.rc(20))
        {
          SmcLogic.writeKvDataWithType(paramLong1, paramLong2, paramString, paramBoolean1, paramBoolean3);
          continue;
        }
        AppMethodBeat.o(143835);
      }
    }
  }
  
  public static void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(143834);
    paramBoolean3 = O(paramLong, paramBoolean3);
    if (paramBoolean2) {}
    for (;;)
    {
      try
      {
        SmcLogic.writeImportKvData(paramLong, paramString, paramBoolean1, paramBoolean3);
        k.gNY();
        k.ad(paramLong, paramString);
        AppMethodBeat.o(143834);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { Util.stackTraceToString(localException) });
        continue;
      }
      try
      {
        SmcLogic.writeKvData(paramLong, paramString, paramBoolean1, paramBoolean3);
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (com.tencent.mm.compatible.util.d.rc(20))
        {
          SmcLogic.writeKvData(paramLong, paramString, paramBoolean1, paramBoolean3);
          continue;
        }
        AppMethodBeat.o(143834);
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
        Log.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
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
      if (c.aht((int)paramLong1))
      {
        Log.e("MicroMsg.KVEasyReport", "exception:%s", new Object[] { Util.stackTraceToString(new Exception("The IDKey has not applied yet, check your code, IDKey:(" + paramLong1 + "," + paramLong2 + ")")) });
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
          h.ahAA.bk(new e.1());
        }
        paramLong1 = 1566L;
        paramLong2 = 1L;
        paramLong3 = 1L;
        paramBoolean = false;
        continue;
      }
      try
      {
        SmcLogic.reportIDKey(paramLong1, paramLong2, paramLong3, paramBoolean);
        if (OzW)
        {
          if (OzT == null) {
            gNS();
          }
          long l = Util.nullAs((Long)OzT.get(Long.valueOf(paramLong1)), 0L);
          paramLong1 = l;
          if (l > 0L) {
            continue;
          }
        }
        AppMethodBeat.o(143837);
        return;
      }
      finally
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
          if (!com.tencent.mm.compatible.util.d.rc(20)) {
            break;
          }
          SmcLogic.reportIDKey(paramLong1, paramLong2, paramLong3, paramBoolean);
        }
        AppMethodBeat.o(143837);
      }
    }
  }
  
  public static void g(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(143838);
    if (paramArrayList != null)
    {
      int i = 0;
      int j = 0;
      while (i < paramArrayList.size())
      {
        if (c.aht((int)((IDKey)paramArrayList.get(i)).GetID()))
        {
          Log.e("MicroMsg.KVEasyReport", "exception:%s", new Object[] { Util.stackTraceToString(new Exception("The IDKey has not applied yet, check your code. IDKey:(" + ((IDKey)paramArrayList.get(i)).GetID() + "," + ((IDKey)paramArrayList.get(i)).GetKey() + ")")) });
          if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
            h.ahAA.bk(new e.2());
          }
          b(1566L, 1L, 1L, false);
          j = 1;
        }
        i += 1;
      }
      if (j != 0)
      {
        AppMethodBeat.o(143838);
        return;
      }
      try
      {
        SmcLogic.reportListIDKey((IDKey[])paramArrayList.toArray(new IDKey[paramArrayList.size()]), paramBoolean);
        AppMethodBeat.o(143838);
        return;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (com.tencent.mm.compatible.util.d.rc(20))
        {
          SmcLogic.reportListIDKey((IDKey[])paramArrayList.toArray(new IDKey[paramArrayList.size()]), paramBoolean);
          AppMethodBeat.o(143838);
          return;
        }
        AppMethodBeat.o(143838);
      }
    }
    AppMethodBeat.o(143838);
  }
  
  /* Error */
  public static void gNS()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 330
    //   6: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 276	com/tencent/mm/plugin/report/service/e:OzT	Ljava/util/Map;
    //   12: ifnonnull +15 -> 27
    //   15: new 332	java/util/HashMap
    //   18: dup
    //   19: bipush 20
    //   21: invokespecial 334	java/util/HashMap:<init>	(I)V
    //   24: putstatic 276	com/tencent/mm/plugin/report/service/e:OzT	Ljava/util/Map;
    //   27: invokestatic 338	com/tencent/mm/plugin/report/b/a:gNN	()Lcom/tencent/mm/protocal/protobuf/czq;
    //   30: astore_0
    //   31: aload_0
    //   32: ifnull +103 -> 135
    //   35: aload_0
    //   36: getfield 343	com/tencent/mm/protocal/protobuf/czq:aaEW	I
    //   39: getstatic 36	com/tencent/mm/plugin/report/service/e:OzV	I
    //   42: if_icmpeq +93 -> 135
    //   45: aload_0
    //   46: getfield 343	com/tencent/mm/protocal/protobuf/czq:aaEW	I
    //   49: putstatic 36	com/tencent/mm/plugin/report/service/e:OzV	I
    //   52: getstatic 276	com/tencent/mm/plugin/report/service/e:OzT	Ljava/util/Map;
    //   55: invokeinterface 344 1 0
    //   60: aload_0
    //   61: getfield 348	com/tencent/mm/protocal/protobuf/czq:aaEX	Ljava/util/LinkedList;
    //   64: astore_0
    //   65: aload_0
    //   66: ifnull +69 -> 135
    //   69: aload_0
    //   70: invokevirtual 351	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   73: astore_0
    //   74: aload_0
    //   75: invokeinterface 131 1 0
    //   80: ifeq +55 -> 135
    //   83: aload_0
    //   84: invokeinterface 135 1 0
    //   89: checkcast 353	com/tencent/mm/protocal/protobuf/drb
    //   92: astore_1
    //   93: getstatic 276	com/tencent/mm/plugin/report/service/e:OzT	Ljava/util/Map;
    //   96: new 111	java/lang/Long
    //   99: dup
    //   100: aload_1
    //   101: getfield 356	com/tencent/mm/protocal/protobuf/drb:aaXb	I
    //   104: i2l
    //   105: invokespecial 359	java/lang/Long:<init>	(J)V
    //   108: new 111	java/lang/Long
    //   111: dup
    //   112: aload_1
    //   113: getfield 362	com/tencent/mm/protocal/protobuf/drb:aaXc	I
    //   116: i2l
    //   117: invokespecial 359	java/lang/Long:<init>	(J)V
    //   120: invokeinterface 363 3 0
    //   125: pop
    //   126: goto -52 -> 74
    //   129: astore_0
    //   130: ldc 2
    //   132: monitorexit
    //   133: aload_0
    //   134: athrow
    //   135: ldc 55
    //   137: ldc_w 365
    //   140: iconst_4
    //   141: anewarray 4	java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: getstatic 36	com/tencent/mm/plugin/report/service/e:OzV	I
    //   149: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: aastore
    //   153: dup
    //   154: iconst_1
    //   155: getstatic 276	com/tencent/mm/plugin/report/service/e:OzT	Ljava/util/Map;
    //   158: invokeinterface 371 1 0
    //   163: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   166: aastore
    //   167: dup
    //   168: iconst_2
    //   169: getstatic 276	com/tencent/mm/plugin/report/service/e:OzT	Ljava/util/Map;
    //   172: aastore
    //   173: dup
    //   174: iconst_3
    //   175: invokestatic 69	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   178: aastore
    //   179: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: ldc_w 330
    //   185: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: ldc 2
    //   190: monitorexit
    //   191: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   30	54	0	localObject1	Object
    //   129	5	0	localObject2	Object
    //   92	21	1	localdrb	com.tencent.mm.protocal.protobuf.drb
    // Exception table:
    //   from	to	target	type
    //   3	27	129	finally
    //   27	31	129	finally
    //   35	65	129	finally
    //   69	74	129	finally
    //   74	126	129	finally
    //   135	188	129	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.e
 * JD-Core Version:    0.7.0.1
 */