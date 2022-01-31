package com.tencent.mm.vending.g;

import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class h
{
  private static boolean YK;
  private static Map<Looper, d> YN;
  private static Map<String, d> aai = new ConcurrentHashMap();
  
  static
  {
    YN = new HashMap();
    YK = false;
    lx();
  }
  
  public static d F(String paramString)
  {
    Assert.assertNotNull("Scheduler type is null", paramString);
    d locald = (d)aai.get(paramString.toUpperCase());
    Assert.assertNotNull("Scheduler type not found: " + paramString.toUpperCase(), locald);
    return locald;
  }
  
  private static void a(String paramString, d paramd)
  {
    Assert.assertNotNull("Scheduler type is null", paramString);
    String str = paramString.toUpperCase();
    if (aai.containsKey(str)) {
      new IllegalStateException("Fatal error! Duplicate scheduler type " + paramString.toUpperCase());
    }
    aai.put(str, paramd);
    if ((paramd instanceof i)) {
      try
      {
        YN.put(((i)paramd).getLooper(), paramd);
        return;
      }
      finally {}
    }
  }
  
  /* Error */
  public static d lG()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 98	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +20 -> 28
    //   11: invokestatic 104	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   14: pop
    //   15: new 106	com/tencent/mm/vending/g/c
    //   18: dup
    //   19: invokespecial 107	com/tencent/mm/vending/g/c:<init>	()V
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: getstatic 25	com/tencent/mm/vending/g/h:YN	Ljava/util/Map;
    //   31: aload_2
    //   32: invokeinterface 54 2 0
    //   37: checkcast 56	com/tencent/mm/vending/g/d
    //   40: astore_1
    //   41: aload_1
    //   42: astore_0
    //   43: aload_1
    //   44: ifnonnull -21 -> 23
    //   47: new 87	com/tencent/mm/vending/g/i
    //   50: dup
    //   51: aload_2
    //   52: aload_2
    //   53: invokevirtual 108	android/os/Looper:toString	()Ljava/lang/String;
    //   56: invokespecial 111	com/tencent/mm/vending/g/i:<init>	(Landroid/os/Looper;Ljava/lang/String;)V
    //   59: astore_0
    //   60: getstatic 25	com/tencent/mm/vending/g/h:YN	Ljava/util/Map;
    //   63: aload_2
    //   64: aload_0
    //   65: invokeinterface 85 3 0
    //   70: pop
    //   71: goto -48 -> 23
    //   74: astore_0
    //   75: ldc 2
    //   77: monitorexit
    //   78: aload_0
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	43	0	localObject1	Object
    //   74	5	0	localObject2	Object
    //   40	4	1	locald	d
    //   6	58	2	localLooper	Looper
    // Exception table:
    //   from	to	target	type
    //   3	7	74	finally
    //   11	23	74	finally
    //   28	41	74	finally
    //   47	71	74	finally
  }
  
  /* Error */
  static void lx()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	com/tencent/mm/vending/g/h:YK	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 27	com/tencent/mm/vending/g/h:YK	Z
    //   19: ldc 113
    //   21: getstatic 117	com/tencent/mm/vending/g/d:aaa	Lcom/tencent/mm/vending/g/i;
    //   24: invokestatic 119	com/tencent/mm/vending/g/h:a	(Ljava/lang/String;Lcom/tencent/mm/vending/g/d;)V
    //   27: ldc 121
    //   29: getstatic 124	com/tencent/mm/vending/g/d:aab	Lcom/tencent/mm/vending/g/i;
    //   32: invokestatic 119	com/tencent/mm/vending/g/h:a	(Ljava/lang/String;Lcom/tencent/mm/vending/g/d;)V
    //   35: ldc 126
    //   37: getstatic 129	com/tencent/mm/vending/g/d:aac	Lcom/tencent/mm/vending/g/i;
    //   40: invokestatic 119	com/tencent/mm/vending/g/h:a	(Ljava/lang/String;Lcom/tencent/mm/vending/g/d;)V
    //   43: goto -32 -> 11
    //   46: astore_1
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   46	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	46	finally
    //   15	43	46	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.g.h
 * JD-Core Version:    0.7.0.1
 */