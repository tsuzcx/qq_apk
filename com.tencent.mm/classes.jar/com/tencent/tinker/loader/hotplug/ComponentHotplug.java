package com.tencent.tinker.loader.hotplug;

import android.content.Context;
import android.os.Handler;
import com.tencent.tinker.loader.hotplug.interceptor.HandlerMessageInterceptor;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor;
import com.tencent.tinker.loader.hotplug.interceptor.TinkerHackInstrumentation;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;

public final class ComponentHotplug
{
  private static volatile boolean BsL = false;
  private static ServiceBinderInterceptor Buo;
  private static ServiceBinderInterceptor Bup;
  private static HandlerMessageInterceptor Buq;
  private static TinkerHackInstrumentation Bur;
  
  private ComponentHotplug()
  {
    throw new UnsupportedOperationException();
  }
  
  /* Error */
  public static void a(com.tencent.tinker.loader.app.TinkerApplication paramTinkerApplication, com.tencent.tinker.loader.shareutil.ShareSecurityCheck paramShareSecurityCheck)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 17	com/tencent/tinker/loader/hotplug/ComponentHotplug:BsL	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +104 -> 112
    //   11: aload_0
    //   12: aload_1
    //   13: invokestatic 33	com/tencent/tinker/loader/hotplug/IncrementComponentManager:a	(Landroid/content/Context;Lcom/tencent/tinker/loader/shareutil/ShareSecurityCheck;)Z
    //   16: ifeq +96 -> 112
    //   19: new 35	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor
    //   22: dup
    //   23: aload_0
    //   24: ldc 37
    //   26: new 39	com/tencent/tinker/loader/hotplug/handler/AMSInterceptHandler
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 42	com/tencent/tinker/loader/hotplug/handler/AMSInterceptHandler:<init>	(Landroid/content/Context;)V
    //   34: invokespecial 45	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor$BinderInvocationHandler;)V
    //   37: putstatic 47	com/tencent/tinker/loader/hotplug/ComponentHotplug:Buo	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   40: new 35	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor
    //   43: dup
    //   44: aload_0
    //   45: ldc 49
    //   47: new 51	com/tencent/tinker/loader/hotplug/handler/PMSInterceptHandler
    //   50: dup
    //   51: invokespecial 52	com/tencent/tinker/loader/hotplug/handler/PMSInterceptHandler:<init>	()V
    //   54: invokespecial 45	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor$BinderInvocationHandler;)V
    //   57: putstatic 54	com/tencent/tinker/loader/hotplug/ComponentHotplug:Bup	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   60: getstatic 47	com/tencent/tinker/loader/hotplug/ComponentHotplug:Buo	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   63: invokevirtual 57	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:dWC	()V
    //   66: getstatic 54	com/tencent/tinker/loader/hotplug/ComponentHotplug:Bup	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   69: invokevirtual 57	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:dWC	()V
    //   72: getstatic 63	android/os/Build$VERSION:SDK_INT	I
    //   75: bipush 27
    //   77: if_icmpge +39 -> 116
    //   80: new 65	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor
    //   83: dup
    //   84: aload_0
    //   85: invokestatic 69	com/tencent/tinker/loader/hotplug/ComponentHotplug:jw	(Landroid/content/Context;)Landroid/os/Handler;
    //   88: new 71	com/tencent/tinker/loader/hotplug/handler/MHMessageHandler
    //   91: dup
    //   92: aload_0
    //   93: invokespecial 72	com/tencent/tinker/loader/hotplug/handler/MHMessageHandler:<init>	(Landroid/content/Context;)V
    //   96: invokespecial 75	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor:<init>	(Landroid/os/Handler;Lcom/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor$MessageHandler;)V
    //   99: astore_0
    //   100: aload_0
    //   101: putstatic 77	com/tencent/tinker/loader/hotplug/ComponentHotplug:Buq	Lcom/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor;
    //   104: aload_0
    //   105: invokevirtual 78	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor:dWC	()V
    //   108: iconst_1
    //   109: putstatic 17	com/tencent/tinker/loader/hotplug/ComponentHotplug:BsL	Z
    //   112: ldc 2
    //   114: monitorexit
    //   115: return
    //   116: aload_0
    //   117: invokestatic 84	com/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation:jx	(Landroid/content/Context;)Lcom/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation;
    //   120: astore_0
    //   121: aload_0
    //   122: putstatic 86	com/tencent/tinker/loader/hotplug/ComponentHotplug:Bur	Lcom/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation;
    //   125: aload_0
    //   126: invokevirtual 87	com/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation:dWC	()V
    //   129: goto -21 -> 108
    //   132: astore_0
    //   133: invokestatic 90	com/tencent/tinker/loader/hotplug/ComponentHotplug:uninstall	()V
    //   136: new 92	com/tencent/tinker/loader/hotplug/UnsupportedEnvironmentException
    //   139: dup
    //   140: aload_0
    //   141: invokespecial 95	com/tencent/tinker/loader/hotplug/UnsupportedEnvironmentException:<init>	(Ljava/lang/Throwable;)V
    //   144: athrow
    //   145: astore_0
    //   146: ldc 2
    //   148: monitorexit
    //   149: aload_0
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramTinkerApplication	com.tencent.tinker.loader.app.TinkerApplication
    //   0	151	1	paramShareSecurityCheck	com.tencent.tinker.loader.shareutil.ShareSecurityCheck
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	108	132	java/lang/Throwable
    //   108	112	132	java/lang/Throwable
    //   116	129	132	java/lang/Throwable
    //   3	7	145	finally
    //   11	108	145	finally
    //   108	112	145	finally
    //   116	129	145	finally
    //   133	145	145	finally
  }
  
  /* Error */
  public static void dWA()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 17	com/tencent/tinker/loader/hotplug/ComponentHotplug:BsL	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +29 -> 37
    //   11: getstatic 47	com/tencent/tinker/loader/hotplug/ComponentHotplug:Buo	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   14: invokevirtual 57	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:dWC	()V
    //   17: getstatic 54	com/tencent/tinker/loader/hotplug/ComponentHotplug:Bup	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   20: invokevirtual 57	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:dWC	()V
    //   23: getstatic 63	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 27
    //   28: if_icmpge +13 -> 41
    //   31: getstatic 77	com/tencent/tinker/loader/hotplug/ComponentHotplug:Buq	Lcom/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor;
    //   34: invokevirtual 78	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor:dWC	()V
    //   37: ldc 2
    //   39: monitorexit
    //   40: return
    //   41: getstatic 86	com/tencent/tinker/loader/hotplug/ComponentHotplug:Bur	Lcom/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation;
    //   44: invokevirtual 87	com/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation:dWC	()V
    //   47: goto -10 -> 37
    //   50: astore_1
    //   51: invokestatic 90	com/tencent/tinker/loader/hotplug/ComponentHotplug:uninstall	()V
    //   54: new 92	com/tencent/tinker/loader/hotplug/UnsupportedEnvironmentException
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 95	com/tencent/tinker/loader/hotplug/UnsupportedEnvironmentException:<init>	(Ljava/lang/Throwable;)V
    //   62: athrow
    //   63: astore_1
    //   64: ldc 2
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   50	9	1	localThrowable	Throwable
    //   63	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	37	50	java/lang/Throwable
    //   41	47	50	java/lang/Throwable
    //   3	7	63	finally
    //   11	37	63	finally
    //   41	47	63	finally
    //   51	63	63	finally
  }
  
  private static Handler jw(Context paramContext)
  {
    paramContext = ShareReflectUtil.d(paramContext, null);
    if (paramContext == null) {
      throw new IllegalStateException("failed to fetch instance of ActivityThread.");
    }
    try
    {
      paramContext = (Handler)ShareReflectUtil.b(paramContext, "mH").get(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw new IllegalStateException(paramContext);
    }
  }
  
  /* Error */
  private static void uninstall()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 17	com/tencent/tinker/loader/hotplug/ComponentHotplug:BsL	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +33 -> 41
    //   11: getstatic 47	com/tencent/tinker/loader/hotplug/ComponentHotplug:Buo	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   14: invokevirtual 125	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:uninstall	()V
    //   17: getstatic 54	com/tencent/tinker/loader/hotplug/ComponentHotplug:Bup	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   20: invokevirtual 125	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:uninstall	()V
    //   23: getstatic 63	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 27
    //   28: if_icmpge +17 -> 45
    //   31: getstatic 77	com/tencent/tinker/loader/hotplug/ComponentHotplug:Buq	Lcom/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor;
    //   34: invokevirtual 126	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor:uninstall	()V
    //   37: iconst_0
    //   38: putstatic 17	com/tencent/tinker/loader/hotplug/ComponentHotplug:BsL	Z
    //   41: ldc 2
    //   43: monitorexit
    //   44: return
    //   45: getstatic 86	com/tencent/tinker/loader/hotplug/ComponentHotplug:Bur	Lcom/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation;
    //   48: astore_1
    //   49: aload_1
    //   50: getfield 130	com/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation:BuN	Ljava/lang/reflect/Field;
    //   53: aload_1
    //   54: getfield 134	com/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation:BuM	Ljava/lang/Object;
    //   57: aload_1
    //   58: getfield 138	com/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation:BuL	Landroid/app/Instrumentation;
    //   61: invokevirtual 142	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   64: goto -27 -> 37
    //   67: astore_1
    //   68: goto -31 -> 37
    //   71: astore_1
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   48	10	1	localTinkerHackInstrumentation	TinkerHackInstrumentation
    //   67	1	1	localThrowable	Throwable
    //   71	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	37	67	java/lang/Throwable
    //   45	64	67	java/lang/Throwable
    //   3	7	71	finally
    //   11	37	71	finally
    //   37	41	71	finally
    //   45	64	71	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.ComponentHotplug
 * JD-Core Version:    0.7.0.1
 */