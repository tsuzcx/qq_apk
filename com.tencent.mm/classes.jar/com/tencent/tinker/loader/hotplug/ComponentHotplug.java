package com.tencent.tinker.loader.hotplug;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.hotplug.interceptor.HandlerMessageInterceptor;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor;
import com.tencent.tinker.loader.hotplug.interceptor.TinkerHackInstrumentation;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
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
  
  public static void ensureComponentHotplugInstalled(TinkerApplication paramTinkerApplication)
  {
    for (;;)
    {
      try
      {
        boolean bool = sInstalled;
        if (bool) {
          try
          {
            sAMSInterceptor.install();
            sPMSInterceptor.install();
            if (Build.VERSION.SDK_INT < 27)
            {
              sMHMessageInterceptor.install();
              return;
            }
            sTinkerHackInstrumentation.install();
            continue;
            paramTinkerApplication = finally;
          }
          catch (Throwable paramTinkerApplication)
          {
            uninstall();
            throw new UnsupportedEnvironmentException(paramTinkerApplication);
          }
        }
        ShareTinkerLog.i("Tinker.ComponentHotplug", "method install() is not invoked, ignore ensuring operations.", new Object[0]);
      }
      finally {}
    }
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
  public static void install(TinkerApplication paramTinkerApplication, com.tencent.tinker.loader.shareutil.ShareSecurityCheck paramShareSecurityCheck)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 21	com/tencent/tinker/loader/hotplug/ComponentHotplug:sInstalled	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +115 -> 123
    //   11: aload_0
    //   12: aload_1
    //   13: invokestatic 110	com/tencent/tinker/loader/hotplug/IncrementComponentManager:init	(Landroid/content/Context;Lcom/tencent/tinker/loader/shareutil/ShareSecurityCheck;)Z
    //   16: ifeq +107 -> 123
    //   19: new 36	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor
    //   22: dup
    //   23: aload_0
    //   24: ldc 112
    //   26: new 114	com/tencent/tinker/loader/hotplug/handler/AMSInterceptHandler
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 117	com/tencent/tinker/loader/hotplug/handler/AMSInterceptHandler:<init>	(Landroid/content/Context;)V
    //   34: invokespecial 120	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor$BinderInvocationHandler;)V
    //   37: putstatic 34	com/tencent/tinker/loader/hotplug/ComponentHotplug:sAMSInterceptor	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   40: new 36	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor
    //   43: dup
    //   44: aload_0
    //   45: ldc 122
    //   47: new 124	com/tencent/tinker/loader/hotplug/handler/PMSInterceptHandler
    //   50: dup
    //   51: invokespecial 125	com/tencent/tinker/loader/hotplug/handler/PMSInterceptHandler:<init>	()V
    //   54: invokespecial 120	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor$BinderInvocationHandler;)V
    //   57: putstatic 41	com/tencent/tinker/loader/hotplug/ComponentHotplug:sPMSInterceptor	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   60: getstatic 34	com/tencent/tinker/loader/hotplug/ComponentHotplug:sAMSInterceptor	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   63: invokevirtual 39	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:install	()V
    //   66: getstatic 41	com/tencent/tinker/loader/hotplug/ComponentHotplug:sPMSInterceptor	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   69: invokevirtual 39	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:install	()V
    //   72: getstatic 47	android/os/Build$VERSION:SDK_INT	I
    //   75: bipush 27
    //   77: if_icmpge +50 -> 127
    //   80: new 51	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor
    //   83: dup
    //   84: aload_0
    //   85: invokestatic 127	com/tencent/tinker/loader/hotplug/ComponentHotplug:fetchMHInstance	(Landroid/content/Context;)Landroid/os/Handler;
    //   88: new 129	com/tencent/tinker/loader/hotplug/handler/MHMessageHandler
    //   91: dup
    //   92: aload_0
    //   93: invokespecial 130	com/tencent/tinker/loader/hotplug/handler/MHMessageHandler:<init>	(Landroid/content/Context;)V
    //   96: invokespecial 133	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor:<init>	(Landroid/os/Handler;Lcom/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor$MessageHandler;)V
    //   99: astore_0
    //   100: aload_0
    //   101: putstatic 49	com/tencent/tinker/loader/hotplug/ComponentHotplug:sMHMessageInterceptor	Lcom/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor;
    //   104: aload_0
    //   105: invokevirtual 52	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor:install	()V
    //   108: iconst_1
    //   109: putstatic 21	com/tencent/tinker/loader/hotplug/ComponentHotplug:sInstalled	Z
    //   112: ldc 8
    //   114: ldc 135
    //   116: iconst_0
    //   117: anewarray 4	java/lang/Object
    //   120: invokestatic 73	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: ldc 2
    //   125: monitorexit
    //   126: return
    //   127: aload_0
    //   128: invokestatic 139	com/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation:create	(Landroid/content/Context;)Lcom/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation;
    //   131: astore_0
    //   132: aload_0
    //   133: putstatic 54	com/tencent/tinker/loader/hotplug/ComponentHotplug:sTinkerHackInstrumentation	Lcom/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation;
    //   136: aload_0
    //   137: invokevirtual 57	com/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation:install	()V
    //   140: goto -32 -> 108
    //   143: astore_0
    //   144: invokestatic 60	com/tencent/tinker/loader/hotplug/ComponentHotplug:uninstall	()V
    //   147: new 62	com/tencent/tinker/loader/hotplug/UnsupportedEnvironmentException
    //   150: dup
    //   151: aload_0
    //   152: invokespecial 65	com/tencent/tinker/loader/hotplug/UnsupportedEnvironmentException:<init>	(Ljava/lang/Throwable;)V
    //   155: athrow
    //   156: astore_0
    //   157: ldc 2
    //   159: monitorexit
    //   160: aload_0
    //   161: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramTinkerApplication	TinkerApplication
    //   0	162	1	paramShareSecurityCheck	com.tencent.tinker.loader.shareutil.ShareSecurityCheck
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	108	143	java/lang/Throwable
    //   108	123	143	java/lang/Throwable
    //   127	140	143	java/lang/Throwable
    //   3	7	156	finally
    //   11	108	156	finally
    //   108	123	156	finally
    //   127	140	156	finally
    //   144	156	156	finally
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
    //   14: invokevirtual 140	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:uninstall	()V
    //   17: getstatic 41	com/tencent/tinker/loader/hotplug/ComponentHotplug:sPMSInterceptor	Lcom/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor;
    //   20: invokevirtual 140	com/tencent/tinker/loader/hotplug/interceptor/ServiceBinderInterceptor:uninstall	()V
    //   23: getstatic 47	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 27
    //   28: if_icmpge +17 -> 45
    //   31: getstatic 49	com/tencent/tinker/loader/hotplug/ComponentHotplug:sMHMessageInterceptor	Lcom/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor;
    //   34: invokevirtual 141	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor:uninstall	()V
    //   37: iconst_0
    //   38: putstatic 21	com/tencent/tinker/loader/hotplug/ComponentHotplug:sInstalled	Z
    //   41: ldc 2
    //   43: monitorexit
    //   44: return
    //   45: getstatic 54	com/tencent/tinker/loader/hotplug/ComponentHotplug:sTinkerHackInstrumentation	Lcom/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation;
    //   48: invokevirtual 142	com/tencent/tinker/loader/hotplug/interceptor/TinkerHackInstrumentation:uninstall	()V
    //   51: goto -14 -> 37
    //   54: astore_1
    //   55: ldc 8
    //   57: ldc 144
    //   59: iconst_1
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload_1
    //   66: aastore
    //   67: invokestatic 147	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: goto -33 -> 37
    //   73: astore_1
    //   74: ldc 2
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   54	12	1	localThrowable	Throwable
    //   73	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	37	54	java/lang/Throwable
    //   45	51	54	java/lang/Throwable
    //   3	7	73	finally
    //   11	37	73	finally
    //   37	41	73	finally
    //   45	51	73	finally
    //   55	70	73	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.ComponentHotplug
 * JD-Core Version:    0.7.0.1
 */