package com.tencent.tinker.loader.hotplug.b;

import android.os.Handler;
import android.os.Handler.Callback;
import java.lang.reflect.Field;

public class a
  extends e<Handler.Callback>
{
  private static Field apb = null;
  private final Handler aoZ;
  private final c apa;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: aconst_null
    //   1: putstatic 17	com/tencent/tinker/loader/hotplug/b/a:apb	Ljava/lang/reflect/Field;
    //   4: ldc 2
    //   6: monitorenter
    //   7: getstatic 17	com/tencent/tinker/loader/hotplug/b/a:apb	Ljava/lang/reflect/Field;
    //   10: astore_0
    //   11: aload_0
    //   12: ifnonnull +13 -> 25
    //   15: ldc 19
    //   17: ldc 21
    //   19: invokestatic 27	com/tencent/tinker/loader/a/h:a	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   22: putstatic 17	com/tencent/tinker/loader/hotplug/b/a:apb	Ljava/lang/reflect/Field;
    //   25: ldc 2
    //   27: monitorexit
    //   28: return
    //   29: astore_0
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    //   35: astore_0
    //   36: goto -11 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   10	2	0	localField	Field
    //   29	5	0	localObject	java.lang.Object
    //   35	1	0	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   7	11	29	finally
    //   15	25	29	finally
    //   25	28	29	finally
    //   30	33	29	finally
    //   15	25	35	java/lang/Throwable
  }
  
  public a(Handler paramHandler, c paramc)
  {
    this.aoZ = paramHandler;
    this.apa = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.b.a
 * JD-Core Version:    0.7.0.1
 */