package com.tencent.mm.plugin.report.service;

import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.e.i;
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

public final class e
{
  private static Map<Long, Long> Izm;
  private static a Izn;
  private static int Izo;
  private static boolean Izp;
  
  static
  {
    AppMethodBeat.i(143841);
    Izn = new a();
    Izo = -1;
    Izp = false;
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
        k.fBF();
        k.O(paramLong1, paramString);
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
        if (d.qW(20))
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
        k.fBF();
        k.O(paramLong, paramString);
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
        if (d.qW(20))
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
      if (c.acY((int)paramLong1))
      {
        Log.e("MicroMsg.KVEasyReport", "exception:%s", new Object[] { Util.stackTraceToString(new Exception("The IDKey has not applied yet, check your code, IDKey:(" + paramLong1 + "," + paramLong2 + ")")) });
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
          h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(195580);
              Toast.makeText(MMApplicationContext.getContext(), "The IDKey has not applied yet, check your code or contact with astrozhou", 1);
              AppMethodBeat.o(195580);
            }
          });
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
        if (Izp)
        {
          if (Izm == null) {
            fBz();
          }
          long l = Util.nullAs((Long)Izm.get(Long.valueOf(paramLong1)), 0L);
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
          if (!d.qW(20)) {
            break;
          }
          SmcLogic.reportIDKey(paramLong1, paramLong2, paramLong3, paramBoolean);
        }
        AppMethodBeat.o(143837);
        throw localThrowable;
      }
    }
  }
  
  public static void f(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(143838);
    if (paramArrayList != null)
    {
      int i = 0;
      int j = 0;
      while (i < paramArrayList.size())
      {
        if (c.acY((int)((IDKey)paramArrayList.get(i)).GetID()))
        {
          Log.e("MicroMsg.KVEasyReport", "exception:%s", new Object[] { Util.stackTraceToString(new Exception("The IDKey has not applied yet, check your code. IDKey:(" + ((IDKey)paramArrayList.get(i)).GetID() + "," + ((IDKey)paramArrayList.get(i)).GetKey() + ")")) });
          if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
            h.ZvG.bc(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(195519);
                Toast.makeText(MMApplicationContext.getContext(), "The IDKey has not applied yet, check your code or contact with astrozhou", 1);
                AppMethodBeat.o(195519);
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
        if (d.qW(20))
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
  public static void fBz()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 235
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 177	com/tencent/mm/plugin/report/service/e:Izm	Ljava/util/Map;
    //   11: ifnonnull +15 -> 26
    //   14: new 237	java/util/HashMap
    //   17: dup
    //   18: bipush 20
    //   20: invokespecial 239	java/util/HashMap:<init>	(I)V
    //   23: putstatic 177	com/tencent/mm/plugin/report/service/e:Izm	Ljava/util/Map;
    //   26: invokestatic 243	com/tencent/mm/plugin/report/b/a:fBu	()Lcom/tencent/mm/protocal/protobuf/cjl;
    //   29: astore_0
    //   30: aload_0
    //   31: ifnull +103 -> 134
    //   34: aload_0
    //   35: getfield 248	com/tencent/mm/protocal/protobuf/cjl:TqO	I
    //   38: getstatic 35	com/tencent/mm/plugin/report/service/e:Izo	I
    //   41: if_icmpeq +93 -> 134
    //   44: aload_0
    //   45: getfield 248	com/tencent/mm/protocal/protobuf/cjl:TqO	I
    //   48: putstatic 35	com/tencent/mm/plugin/report/service/e:Izo	I
    //   51: getstatic 177	com/tencent/mm/plugin/report/service/e:Izm	Ljava/util/Map;
    //   54: invokeinterface 251 1 0
    //   59: aload_0
    //   60: getfield 255	com/tencent/mm/protocal/protobuf/cjl:TqP	Ljava/util/LinkedList;
    //   63: astore_0
    //   64: aload_0
    //   65: ifnull +69 -> 134
    //   68: aload_0
    //   69: invokevirtual 261	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   72: astore_0
    //   73: aload_0
    //   74: invokeinterface 267 1 0
    //   79: ifeq +55 -> 134
    //   82: aload_0
    //   83: invokeinterface 271 1 0
    //   88: checkcast 273	com/tencent/mm/protocal/protobuf/czu
    //   91: astore_1
    //   92: getstatic 177	com/tencent/mm/plugin/report/service/e:Izm	Ljava/util/Map;
    //   95: new 182	java/lang/Long
    //   98: dup
    //   99: aload_1
    //   100: getfield 276	com/tencent/mm/protocal/protobuf/czu:THs	I
    //   103: i2l
    //   104: invokespecial 279	java/lang/Long:<init>	(J)V
    //   107: new 182	java/lang/Long
    //   110: dup
    //   111: aload_1
    //   112: getfield 282	com/tencent/mm/protocal/protobuf/czu:THt	I
    //   115: i2l
    //   116: invokespecial 279	java/lang/Long:<init>	(J)V
    //   119: invokeinterface 286 3 0
    //   124: pop
    //   125: goto -52 -> 73
    //   128: astore_0
    //   129: ldc 2
    //   131: monitorexit
    //   132: aload_0
    //   133: athrow
    //   134: ldc 66
    //   136: ldc_w 288
    //   139: iconst_4
    //   140: anewarray 4	java/lang/Object
    //   143: dup
    //   144: iconst_0
    //   145: getstatic 35	com/tencent/mm/plugin/report/service/e:Izo	I
    //   148: invokestatic 293	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   151: aastore
    //   152: dup
    //   153: iconst_1
    //   154: getstatic 177	com/tencent/mm/plugin/report/service/e:Izm	Ljava/util/Map;
    //   157: invokeinterface 294 1 0
    //   162: invokestatic 293	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: aastore
    //   166: dup
    //   167: iconst_2
    //   168: getstatic 177	com/tencent/mm/plugin/report/service/e:Izm	Ljava/util/Map;
    //   171: aastore
    //   172: dup
    //   173: iconst_3
    //   174: invokestatic 298	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   177: aastore
    //   178: invokestatic 300	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   181: ldc 235
    //   183: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: ldc 2
    //   188: monitorexit
    //   189: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	54	0	localObject1	Object
    //   128	5	0	localObject2	Object
    //   91	21	1	localczu	com.tencent.mm.protocal.protobuf.czu
    // Exception table:
    //   from	to	target	type
    //   3	26	128	finally
    //   26	30	128	finally
    //   34	64	128	finally
    //   68	73	128	finally
    //   73	125	128	finally
    //   134	186	128	finally
  }
  
  public static void xi(boolean paramBoolean)
  {
    AppMethodBeat.i(143839);
    Log.i("MicroMsg.KVEasyReport", "summerhv setHeavyUser [%b %b], stack[%s]", new Object[] { Boolean.valueOf(Izp), Boolean.valueOf(paramBoolean), Util.getStack() });
    Izp = paramBoolean;
    AppMethodBeat.o(143839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.e
 * JD-Core Version:    0.7.0.1
 */