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
  private static final String TAG = "Tinker.ComponentHotplug";
  private static ServiceBinderInterceptor sAMSInterceptor;
  private static volatile boolean sInstalled = false;
  private static HandlerMessageInterceptor sMHMessageInterceptor;
  private static ServiceBinderInterceptor sPMSInterceptor;
  private static TinkerHackInstrumentation sTinkerHackInstrumentation;
  
  private ComponentHotplug()
  {
    throw new UnsupportedOperationException();
  }
  
  /* Error */
  public static void ensureComponentHotplugInstalled(com.tencent.tinker.loader.app.TinkerApplication paramTinkerApplication)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 21	com/tencent/tinker/loader/hotplug/ComponentHotplug:sInstalled	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +29 -> 37
    //   11: getstatic 34	com/tencent/tinker/loader/hotplug/ComponentHotplug:sAMSInterceptor	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   14: invokevirtual 39	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:install	()V
    //   17: getstatic 41	com/tencent/tinker/loader/hotplug/ComponentHotplug:sPMSInterceptor	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   20: invokevirtual 39	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:install	()V
    //   23: getstatic 47	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 27
    //   28: if_icmpge +13 -> 41
    //   31: getstatic 49	com/tencent/tinker/loader/hotplug/ComponentHotplug:sMHMessageInterceptor	Lcom/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor;
    //   34: invokevirtual 52	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor:install	()V
    //   37: ldc 2
    //   39: monitorexit
    //   40: return
    //   41: getstatic 54	com/tencent/tinker/loader/hotplug/ComponentHotplug:sTinkerHackInstrumentation	Lcom/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation;
    //   44: invokevirtual 57	com/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation:install	()V
    //   47: goto -10 -> 37
    //   50: astore_0
    //   51: invokestatic 60	com/tencent/tinker/loader/hotplug/ComponentHotplug:uninstall	()V
    //   54: new 62	com/tencent/tinker/loader/hotplug/UnsupportedEnvironmentException
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 65	com/tencent/tinker/loader/hotplug/UnsupportedEnvironmentException:<init>	(Ljava/lang/Throwable;)V
    //   62: athrow
    //   63: astore_0
    //   64: ldc 2
    //   66: monitorexit
    //   67: aload_0
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	paramTinkerApplication	com.tencent.tinker.loader.app.TinkerApplication
    //   6	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	37	50	java/lang/Throwable
    //   41	47	50	java/lang/Throwable
    //   3	7	63	finally
    //   11	37	63	finally
    //   41	47	63	finally
    //   51	63	63	finally
  }
  
  private static Handler fetchMHInstance(Context paramContext)
  {
    paramContext = ShareReflectUtil.getActivityThread(paramContext, null);
    if (paramContext == null) {
      throw new IllegalStateException("failed to fetch instance of ActivityThread.");
    }
    try
    {
      paramContext = (Handler)ShareReflectUtil.findField(paramContext, "mH").get(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw new IllegalStateException(paramContext);
    }
  }
  
  /* Error */
  public static void install(com.tencent.tinker.loader.app.TinkerApplication paramTinkerApplication, com.tencent.tinker.loader.shareutil.ShareSecurityCheck paramShareSecurityCheck)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 21	com/tencent/tinker/loader/hotplug/ComponentHotplug:sInstalled	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +104 -> 112
    //   11: aload_0
    //   12: aload_1
    //   13: invokestatic 102	com/tencent/tinker/loader/hotplug/IncrementComponentManager:init	(Landroid/content/Context;Lcom/tencent/tinker/loader/shareutil/ShareSecurityCheck;)Z
    //   16: ifeq +96 -> 112
    //   19: new 36	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor
    //   22: dup
    //   23: aload_0
    //   24: ldc 104
    //   26: new 106	com/tencent/tinker/loader/hotplug/handler/AMSInterceptHandler
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 109	com/tencent/tinker/loader/hotplug/handler/AMSInterceptHandler:<init>	(Landroid/content/Context;)V
    //   34: invokespecial 112	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor$BinderInvocationHandler;)V
    //   37: putstatic 34	com/tencent/tinker/loader/hotplug/ComponentHotplug:sAMSInterceptor	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   40: new 36	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor
    //   43: dup
    //   44: aload_0
    //   45: ldc 114
    //   47: new 116	com/tencent/tinker/loader/hotplug/handler/PMSInterceptHandler
    //   50: dup
    //   51: invokespecial 117	com/tencent/tinker/loader/hotplug/handler/PMSInterceptHandler:<init>	()V
    //   54: invokespecial 112	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor$BinderInvocationHandler;)V
    //   57: putstatic 41	com/tencent/tinker/loader/hotplug/ComponentHotplug:sPMSInterceptor	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   60: getstatic 34	com/tencent/tinker/loader/hotplug/ComponentHotplug:sAMSInterceptor	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   63: invokevirtual 39	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:install	()V
    //   66: getstatic 41	com/tencent/tinker/loader/hotplug/ComponentHotplug:sPMSInterceptor	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   69: invokevirtual 39	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:install	()V
    //   72: getstatic 47	android/os/Build$VERSION:SDK_INT	I
    //   75: bipush 27
    //   77: if_icmpge +39 -> 116
    //   80: new 51	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor
    //   83: dup
    //   84: aload_0
    //   85: invokestatic 119	com/tencent/tinker/loader/hotplug/ComponentHotplug:fetchMHInstance	(Landroid/content/Context;)Landroid/os/Handler;
    //   88: new 121	com/tencent/tinker/loader/hotplug/handler/MHMessageHandler
    //   91: dup
    //   92: aload_0
    //   93: invokespecial 122	com/tencent/tinker/loader/hotplug/handler/MHMessageHandler:<init>	(Landroid/content/Context;)V
    //   96: invokespecial 125	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor:<init>	(Landroid/os/Handler;Lcom/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor$MessageHandler;)V
    //   99: astore_0
    //   100: aload_0
    //   101: putstatic 49	com/tencent/tinker/loader/hotplug/ComponentHotplug:sMHMessageInterceptor	Lcom/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor;
    //   104: aload_0
    //   105: invokevirtual 52	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor:install	()V
    //   108: iconst_1
    //   109: putstatic 21	com/tencent/tinker/loader/hotplug/ComponentHotplug:sInstalled	Z
    //   112: ldc 2
    //   114: monitorexit
    //   115: return
    //   116: aload_0
    //   117: invokestatic 129	com/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation:create	(Landroid/content/Context;)Lcom/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation;
    //   120: astore_0
    //   121: aload_0
    //   122: putstatic 54	com/tencent/tinker/loader/hotplug/ComponentHotplug:sTinkerHackInstrumentation	Lcom/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation;
    //   125: aload_0
    //   126: invokevirtual 57	com/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation:install	()V
    //   129: goto -21 -> 108
    //   132: astore_0
    //   133: invokestatic 60	com/tencent/tinker/loader/hotplug/ComponentHotplug:uninstall	()V
    //   136: new 62	com/tencent/tinker/loader/hotplug/UnsupportedEnvironmentException
    //   139: dup
    //   140: aload_0
    //   141: invokespecial 65	com/tencent/tinker/loader/hotplug/UnsupportedEnvironmentException:<init>	(Ljava/lang/Throwable;)V
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
  public static void uninstall()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 21	com/tencent/tinker/loader/hotplug/ComponentHotplug:sInstalled	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +33 -> 41
    //   11: getstatic 34	com/tencent/tinker/loader/hotplug/ComponentHotplug:sAMSInterceptor	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   14: invokevirtual 130	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:uninstall	()V
    //   17: getstatic 41	com/tencent/tinker/loader/hotplug/ComponentHotplug:sPMSInterceptor	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   20: invokevirtual 130	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:uninstall	()V
    //   23: getstatic 47	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 27
    //   28: if_icmpge +17 -> 45
    //   31: getstatic 49	com/tencent/tinker/loader/hotplug/ComponentHotplug:sMHMessageInterceptor	Lcom/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor;
    //   34: invokevirtual 131	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor:uninstall	()V
    //   37: iconst_0
    //   38: putstatic 21	com/tencent/tinker/loader/hotplug/ComponentHotplug:sInstalled	Z
    //   41: ldc 2
    //   43: monitorexit
    //   44: return
    //   45: getstatic 54	com/tencent/tinker/loader/hotplug/ComponentHotplug:sTinkerHackInstrumentation	Lcom/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation;
    //   48: invokevirtual 132	com/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation:uninstall	()V
    //   51: goto -14 -> 37
    //   54: astore_1
    //   55: goto -18 -> 37
    //   58: astore_1
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   54	1	1	localThrowable	Throwable
    //   58	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	37	54	java/lang/Throwable
    //   45	51	54	java/lang/Throwable
    //   3	7	58	finally
    //   11	37	58	finally
    //   37	41	58	finally
    //   45	51	58	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.ComponentHotplug
 * JD-Core Version:    0.7.0.1
 */