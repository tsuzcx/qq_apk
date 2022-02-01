package com.tencent.mm.plugin.report.service;

import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Map;

public class e
{
  private static Map<Long, Long> Cyn;
  private static a Cyo;
  private static int Cyp;
  private static boolean Cyq;
  
  static
  {
    AppMethodBeat.i(143841);
    Cyo = new a();
    Cyp = -1;
    Cyq = false;
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
        k.eOK();
        k.G(paramLong1, paramString);
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
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (d.oE(20))
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
        k.eOK();
        k.G(paramLong, paramString);
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
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (d.oE(20))
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
      int i;
      if (e.class.getClassLoader() == null)
      {
        i = -1;
        label16:
        if (Thread.currentThread().getContextClassLoader() != null) {
          break label179;
        }
      }
      label179:
      for (int j = -1;; j = Thread.currentThread().getContextClassLoader().hashCode())
      {
        Log.i("MicroMsg.KVEasyReport", "SmcLogic.reportIDKey class loader %s, %s ", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (!c.Wj((int)paramLong1)) {
          break label193;
        }
        Log.e("MicroMsg.KVEasyReport", "exception:%s", new Object[] { Util.stackTraceToString(new Exception("The IDKey has not applied yet, check your code, IDKey:(" + paramLong1 + "," + paramLong2 + ")")) });
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
          h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(224155);
              Toast.makeText(MMApplicationContext.getContext(), "The IDKey has not applied yet, check your code or contact with astrozhou", 1);
              AppMethodBeat.o(224155);
            }
          });
        }
        paramLong1 = 1566L;
        paramLong2 = 1L;
        paramLong3 = 1L;
        paramBoolean = false;
        break;
        i = e.class.getClassLoader().hashCode();
        break label16;
      }
      try
      {
        label193:
        SmcLogic.reportIDKey(paramLong1, paramLong2, paramLong3, paramBoolean);
        if (Cyq)
        {
          if (Cyn == null) {
            eOE();
          }
          long l = Util.nullAs((Long)Cyn.get(Long.valueOf(paramLong1)), 0L);
          paramLong1 = l;
          if (l > 0L) {
            continue;
          }
        }
        AppMethodBeat.o(143837);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
          if (!d.oE(20)) {
            break;
          }
          SmcLogic.reportIDKey(paramLong1, paramLong2, paramLong3, paramBoolean);
        }
        AppMethodBeat.o(143837);
        throw localThrowable;
      }
    }
  }
  
  public static void e(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(143838);
    if (paramArrayList != null)
    {
      int i = 0;
      int j = 0;
      while (i < paramArrayList.size())
      {
        if (c.Wj((int)((IDKey)paramArrayList.get(i)).GetID()))
        {
          Log.e("MicroMsg.KVEasyReport", "exception:%s", new Object[] { Util.stackTraceToString(new Exception("The IDKey has not applied yet, check your code. IDKey:(" + ((IDKey)paramArrayList.get(i)).GetID() + "," + ((IDKey)paramArrayList.get(i)).GetKey() + ")")) });
          if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
            h.RTc.aV(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(224156);
                Toast.makeText(MMApplicationContext.getContext(), "The IDKey has not applied yet, check your code or contact with astrozhou", 1);
                AppMethodBeat.o(224156);
              }
            });
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
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.KVEasyReport", localThrowable, "", new Object[0]);
        if (d.oE(20))
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
  public static void eOE()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 262
    //   6: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 207	com/tencent/mm/plugin/report/service/e:Cyn	Ljava/util/Map;
    //   12: ifnonnull +15 -> 27
    //   15: new 264	java/util/HashMap
    //   18: dup
    //   19: bipush 20
    //   21: invokespecial 266	java/util/HashMap:<init>	(I)V
    //   24: putstatic 207	com/tencent/mm/plugin/report/service/e:Cyn	Ljava/util/Map;
    //   27: invokestatic 270	com/tencent/mm/plugin/report/b/a:eOy	()Lcom/tencent/mm/protocal/protobuf/cbi;
    //   30: astore_0
    //   31: aload_0
    //   32: ifnull +103 -> 135
    //   35: aload_0
    //   36: getfield 275	com/tencent/mm/protocal/protobuf/cbi:Mha	I
    //   39: getstatic 35	com/tencent/mm/plugin/report/service/e:Cyp	I
    //   42: if_icmpeq +93 -> 135
    //   45: aload_0
    //   46: getfield 275	com/tencent/mm/protocal/protobuf/cbi:Mha	I
    //   49: putstatic 35	com/tencent/mm/plugin/report/service/e:Cyp	I
    //   52: getstatic 207	com/tencent/mm/plugin/report/service/e:Cyn	Ljava/util/Map;
    //   55: invokeinterface 278 1 0
    //   60: aload_0
    //   61: getfield 282	com/tencent/mm/protocal/protobuf/cbi:Mhb	Ljava/util/LinkedList;
    //   64: astore_0
    //   65: aload_0
    //   66: ifnull +69 -> 135
    //   69: aload_0
    //   70: invokevirtual 288	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   73: astore_0
    //   74: aload_0
    //   75: invokeinterface 294 1 0
    //   80: ifeq +55 -> 135
    //   83: aload_0
    //   84: invokeinterface 298 1 0
    //   89: checkcast 300	com/tencent/mm/protocal/protobuf/crd
    //   92: astore_1
    //   93: getstatic 207	com/tencent/mm/plugin/report/service/e:Cyn	Ljava/util/Map;
    //   96: new 212	java/lang/Long
    //   99: dup
    //   100: aload_1
    //   101: getfield 303	com/tencent/mm/protocal/protobuf/crd:Mwu	I
    //   104: i2l
    //   105: invokespecial 306	java/lang/Long:<init>	(J)V
    //   108: new 212	java/lang/Long
    //   111: dup
    //   112: aload_1
    //   113: getfield 309	com/tencent/mm/protocal/protobuf/crd:Mwv	I
    //   116: i2l
    //   117: invokespecial 306	java/lang/Long:<init>	(J)V
    //   120: invokeinterface 313 3 0
    //   125: pop
    //   126: goto -52 -> 74
    //   129: astore_0
    //   130: ldc 2
    //   132: monitorexit
    //   133: aload_0
    //   134: athrow
    //   135: ldc 67
    //   137: ldc_w 315
    //   140: iconst_4
    //   141: anewarray 4	java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: getstatic 35	com/tencent/mm/plugin/report/service/e:Cyp	I
    //   149: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: aastore
    //   153: dup
    //   154: iconst_1
    //   155: getstatic 207	com/tencent/mm/plugin/report/service/e:Cyn	Ljava/util/Map;
    //   158: invokeinterface 316 1 0
    //   163: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   166: aastore
    //   167: dup
    //   168: iconst_2
    //   169: getstatic 207	com/tencent/mm/plugin/report/service/e:Cyn	Ljava/util/Map;
    //   172: aastore
    //   173: dup
    //   174: iconst_3
    //   175: invokestatic 320	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   178: aastore
    //   179: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: ldc_w 262
    //   185: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: ldc 2
    //   190: monitorexit
    //   191: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   30	54	0	localObject1	Object
    //   129	5	0	localObject2	Object
    //   92	21	1	localcrd	com.tencent.mm.protocal.protobuf.crd
    // Exception table:
    //   from	to	target	type
    //   3	27	129	finally
    //   27	31	129	finally
    //   35	65	129	finally
    //   69	74	129	finally
    //   74	126	129	finally
    //   135	188	129	finally
  }
  
  public static void tM(boolean paramBoolean)
  {
    AppMethodBeat.i(143839);
    Log.i("MicroMsg.KVEasyReport", "summerhv setHeavyUser [%b %b], stack[%s]", new Object[] { Boolean.valueOf(Cyq), Boolean.valueOf(paramBoolean), Util.getStack() });
    Cyq = paramBoolean;
    AppMethodBeat.o(143839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.e
 * JD-Core Version:    0.7.0.1
 */