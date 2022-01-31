package com.tencent.tinker.loader.hotplug;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import com.tencent.tinker.loader.a.h;
import com.tencent.tinker.loader.hotplug.b.a;
import com.tencent.tinker.loader.hotplug.b.g;
import com.tencent.tinker.loader.hotplug.b.k;
import java.lang.reflect.Field;

public final class b
{
  private static volatile boolean ajT = false;
  private static g alm;
  private static g aln;
  private static a alo;
  private static k alp;
  
  private static Handler K(Context paramContext)
  {
    paramContext = h.b(paramContext, null);
    if (paramContext == null) {
      throw new IllegalStateException("failed to fetch instance of ActivityThread.");
    }
    try
    {
      paramContext = (Handler)h.a(paramContext, "mH").get(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw new IllegalStateException(paramContext);
    }
  }
  
  /* Error */
  public static void a(com.tencent.tinker.loader.app.TinkerApplication paramTinkerApplication, com.tencent.tinker.loader.a.j paramj)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 17	com/tencent/tinker/loader/hotplug/b:ajT	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +112 -> 120
    //   11: aload_0
    //   12: aload_1
    //   13: invokestatic 59	com/tencent/tinker/loader/hotplug/c:a	(Landroid/content/Context;Lcom/tencent/tinker/loader/a/j;)Z
    //   16: ifeq +104 -> 120
    //   19: new 61	com/tencent/tinker/loader/hotplug/b/g
    //   22: dup
    //   23: aload_0
    //   24: ldc 63
    //   26: new 65	com/tencent/tinker/loader/hotplug/a/a
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 68	com/tencent/tinker/loader/hotplug/a/a:<init>	(Landroid/content/Context;)V
    //   34: invokespecial 71	com/tencent/tinker/loader/hotplug/b/g:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/tinker/loader/hotplug/b/h;)V
    //   37: putstatic 73	com/tencent/tinker/loader/hotplug/b:alm	Lcom/tencent/tinker/loader/hotplug/b/g;
    //   40: new 61	com/tencent/tinker/loader/hotplug/b/g
    //   43: dup
    //   44: aload_0
    //   45: ldc 75
    //   47: new 77	com/tencent/tinker/loader/hotplug/a/c
    //   50: dup
    //   51: invokespecial 79	com/tencent/tinker/loader/hotplug/a/c:<init>	()V
    //   54: invokespecial 71	com/tencent/tinker/loader/hotplug/b/g:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/tinker/loader/hotplug/b/h;)V
    //   57: putstatic 81	com/tencent/tinker/loader/hotplug/b:aln	Lcom/tencent/tinker/loader/hotplug/b/g;
    //   60: getstatic 73	com/tencent/tinker/loader/hotplug/b:alm	Lcom/tencent/tinker/loader/hotplug/b/g;
    //   63: invokevirtual 84	com/tencent/tinker/loader/hotplug/b/g:ok	()V
    //   66: getstatic 81	com/tencent/tinker/loader/hotplug/b:aln	Lcom/tencent/tinker/loader/hotplug/b/g;
    //   69: invokevirtual 84	com/tencent/tinker/loader/hotplug/b/g:ok	()V
    //   72: getstatic 90	android/os/Build$VERSION:SDK_INT	I
    //   75: bipush 27
    //   77: if_icmpge +47 -> 124
    //   80: new 92	com/tencent/tinker/loader/hotplug/b/a
    //   83: dup
    //   84: aload_0
    //   85: invokestatic 94	com/tencent/tinker/loader/hotplug/b:K	(Landroid/content/Context;)Landroid/os/Handler;
    //   88: new 96	com/tencent/tinker/loader/hotplug/a/b
    //   91: dup
    //   92: aload_0
    //   93: invokespecial 97	com/tencent/tinker/loader/hotplug/a/b:<init>	(Landroid/content/Context;)V
    //   96: invokespecial 100	com/tencent/tinker/loader/hotplug/b/a:<init>	(Landroid/os/Handler;Lcom/tencent/tinker/loader/hotplug/b/c;)V
    //   99: astore_0
    //   100: aload_0
    //   101: putstatic 102	com/tencent/tinker/loader/hotplug/b:alo	Lcom/tencent/tinker/loader/hotplug/b/a;
    //   104: aload_0
    //   105: invokevirtual 103	com/tencent/tinker/loader/hotplug/b/a:ok	()V
    //   108: iconst_1
    //   109: putstatic 17	com/tencent/tinker/loader/hotplug/b:ajT	Z
    //   112: ldc 105
    //   114: ldc 107
    //   116: invokestatic 113	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   119: pop
    //   120: ldc 2
    //   122: monitorexit
    //   123: return
    //   124: aload_0
    //   125: invokestatic 119	com/tencent/tinker/loader/hotplug/b/k:L	(Landroid/content/Context;)Lcom/tencent/tinker/loader/hotplug/b/k;
    //   128: astore_0
    //   129: aload_0
    //   130: putstatic 121	com/tencent/tinker/loader/hotplug/b:alp	Lcom/tencent/tinker/loader/hotplug/b/k;
    //   133: aload_0
    //   134: invokevirtual 122	com/tencent/tinker/loader/hotplug/b/k:ok	()V
    //   137: goto -29 -> 108
    //   140: astore_0
    //   141: invokestatic 125	com/tencent/tinker/loader/hotplug/b:og	()V
    //   144: new 127	com/tencent/tinker/loader/hotplug/e
    //   147: dup
    //   148: aload_0
    //   149: invokespecial 128	com/tencent/tinker/loader/hotplug/e:<init>	(Ljava/lang/Throwable;)V
    //   152: athrow
    //   153: astore_0
    //   154: ldc 2
    //   156: monitorexit
    //   157: aload_0
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramTinkerApplication	com.tencent.tinker.loader.app.TinkerApplication
    //   0	159	1	paramj	com.tencent.tinker.loader.a.j
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	108	140	java/lang/Throwable
    //   108	120	140	java/lang/Throwable
    //   124	137	140	java/lang/Throwable
    //   3	7	153	finally
    //   11	108	153	finally
    //   108	120	153	finally
    //   124	137	153	finally
    //   141	153	153	finally
  }
  
  public static void of()
  {
    for (;;)
    {
      try
      {
        boolean bool = ajT;
        if (bool) {
          try
          {
            alm.ok();
            aln.ok();
            if (Build.VERSION.SDK_INT < 27)
            {
              alo.ok();
              return;
            }
            alp.ok();
            continue;
            localObject = finally;
          }
          catch (Throwable localThrowable)
          {
            og();
            throw new e(localThrowable);
          }
        }
        Log.i("Tinker.ComponentHotplug", "method install() is not invoked, ignore ensuring operations.");
      }
      finally {}
    }
  }
  
  /* Error */
  private static void og()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 17	com/tencent/tinker/loader/hotplug/b:ajT	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +33 -> 41
    //   11: getstatic 73	com/tencent/tinker/loader/hotplug/b:alm	Lcom/tencent/tinker/loader/hotplug/b/g;
    //   14: invokevirtual 132	com/tencent/tinker/loader/hotplug/b/g:og	()V
    //   17: getstatic 81	com/tencent/tinker/loader/hotplug/b:aln	Lcom/tencent/tinker/loader/hotplug/b/g;
    //   20: invokevirtual 132	com/tencent/tinker/loader/hotplug/b/g:og	()V
    //   23: getstatic 90	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 27
    //   28: if_icmpge +17 -> 45
    //   31: getstatic 102	com/tencent/tinker/loader/hotplug/b:alo	Lcom/tencent/tinker/loader/hotplug/b/a;
    //   34: invokevirtual 133	com/tencent/tinker/loader/hotplug/b/a:og	()V
    //   37: iconst_0
    //   38: putstatic 17	com/tencent/tinker/loader/hotplug/b:ajT	Z
    //   41: ldc 2
    //   43: monitorexit
    //   44: return
    //   45: getstatic 121	com/tencent/tinker/loader/hotplug/b:alp	Lcom/tencent/tinker/loader/hotplug/b/k;
    //   48: invokevirtual 134	com/tencent/tinker/loader/hotplug/b/k:og	()V
    //   51: goto -14 -> 37
    //   54: astore_1
    //   55: ldc 105
    //   57: ldc 136
    //   59: aload_1
    //   60: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   63: pop
    //   64: goto -27 -> 37
    //   67: astore_1
    //   68: ldc 2
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   54	6	1	localThrowable	Throwable
    //   67	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	37	54	java/lang/Throwable
    //   45	51	54	java/lang/Throwable
    //   3	7	67	finally
    //   11	37	67	finally
    //   37	41	67	finally
    //   45	51	67	finally
    //   55	64	67	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.b
 * JD-Core Version:    0.7.0.1
 */