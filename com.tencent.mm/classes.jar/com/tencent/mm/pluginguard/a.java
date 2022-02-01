package com.tencent.mm.pluginguard;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginguard/ActivityHook;", "", "()V", "TAG", "", "hack", "", "application", "Landroid/app/Application;", "init", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfileImpl;", "initInternal", "processName", "reflectActivityThread", "context", "Landroid/content/Context;", "safetyToHack", "compat_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a XMT;
  
  static
  {
    AppMethodBeat.i(231885);
    XMT = new a();
    AppMethodBeat.o(231885);
  }
  
  public static final void b(h paramh)
  {
    AppMethodBeat.i(231866);
    s.u(paramh, "profile");
    a locala = XMT;
    Application localApplication = paramh.bGP;
    s.s(localApplication, "profile.application()");
    s.s(paramh.mProcessName, "profile.processName");
    if (iGi())
    {
      locala.q(localApplication);
      Log.i("MicroMsg.ActivityHook", "ActivityHook hack success");
    }
    for (;;)
    {
      paramh = b.XMX;
      b.init();
      AppMethodBeat.o(231866);
      return;
      Log.e("MicroMsg.ActivityHook", "ActivityHook dont hack, it's not safe");
    }
  }
  
  private static boolean iGi()
  {
    AppMethodBeat.i(231879);
    if (MultiProcessMMKV.getMMKV("activity_hook").getInt("has_error", 0) != 0)
    {
      long l = MultiProcessMMKV.getMMKV("activity_hook").decodeLong("has_error", 0L);
      b localb1 = b.XMX;
      b.avw((int)l);
      localb1 = b.XMX;
      b.xW(1L);
      AppMethodBeat.o(231879);
      return false;
    }
    try
    {
      Instrumentation.class.getDeclaredMethod("execStartActivity", new Class[] { Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, Integer.TYPE, Bundle.class });
      AppMethodBeat.o(231879);
      return true;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.ActivityHook", localThrowable, "catch throw in check hack", new Object[0]);
      MultiProcessMMKV.getMMKV("activity_hook").encode("has_error", 1L);
      b localb2 = b.XMX;
      b.avw(1);
      localb2 = b.XMX;
      b.xW(1L);
      AppMethodBeat.o(231879);
    }
    return false;
  }
  
  /* Error */
  private boolean q(Application paramApplication)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 172
    //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 173
    //   10: invokestatic 61	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: invokestatic 179	java/lang/System:currentTimeMillis	()J
    //   16: pop2
    //   17: aload_1
    //   18: checkcast 141	android/content/Context
    //   21: astore_3
    //   22: ldc 181
    //   24: invokestatic 185	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   27: ldc 187
    //   29: iconst_0
    //   30: anewarray 139	java/lang/Class
    //   33: invokevirtual 190	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   36: astore_1
    //   37: aload_1
    //   38: iconst_1
    //   39: invokevirtual 196	java/lang/reflect/Method:setAccessible	(Z)V
    //   42: aload_1
    //   43: aconst_null
    //   44: iconst_0
    //   45: anewarray 4	java/lang/Object
    //   48: invokevirtual 200	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   51: astore_1
    //   52: aload_1
    //   53: ifnull +74 -> 127
    //   56: aload_1
    //   57: invokevirtual 204	java/lang/Object:getClass	()Ljava/lang/Class;
    //   60: ldc 206
    //   62: invokevirtual 210	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   65: astore_3
    //   66: aload_3
    //   67: iconst_1
    //   68: invokevirtual 213	java/lang/reflect/Field:setAccessible	(Z)V
    //   71: aload_3
    //   72: aload_1
    //   73: invokevirtual 217	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   76: astore 4
    //   78: aload 4
    //   80: ifnonnull +98 -> 178
    //   83: new 219	java/lang/NullPointerException
    //   86: dup
    //   87: ldc 221
    //   89: invokespecial 224	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   92: astore_1
    //   93: ldc 172
    //   95: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_1
    //   99: athrow
    //   100: astore_1
    //   101: ldc 87
    //   103: aload_1
    //   104: checkcast 226	java/lang/Throwable
    //   107: ldc 228
    //   109: iconst_0
    //   110: anewarray 4	java/lang/Object
    //   113: invokestatic 165	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: ldc 172
    //   118: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iconst_0
    //   122: istore_2
    //   123: aload_0
    //   124: monitorexit
    //   125: iload_2
    //   126: ireturn
    //   127: aload_3
    //   128: invokevirtual 204	java/lang/Object:getClass	()Ljava/lang/Class;
    //   131: ldc 230
    //   133: invokevirtual 233	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   136: astore_1
    //   137: aload_1
    //   138: iconst_1
    //   139: invokevirtual 213	java/lang/reflect/Field:setAccessible	(Z)V
    //   142: aload_1
    //   143: aload_3
    //   144: invokevirtual 217	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   147: astore_1
    //   148: aload_1
    //   149: invokevirtual 204	java/lang/Object:getClass	()Ljava/lang/Class;
    //   152: ldc 235
    //   154: invokevirtual 210	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   157: astore_3
    //   158: aload_3
    //   159: iconst_1
    //   160: invokevirtual 213	java/lang/reflect/Field:setAccessible	(Z)V
    //   163: aload_3
    //   164: aload_1
    //   165: invokevirtual 217	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   168: astore_1
    //   169: aload_1
    //   170: ldc 237
    //   172: invokestatic 71	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   175: goto -119 -> 56
    //   178: aload 4
    //   180: checkcast 135	android/app/Instrumentation
    //   183: astore 4
    //   185: aload 4
    //   187: instanceof 239
    //   190: ifne +34 -> 224
    //   193: aload_3
    //   194: aload_1
    //   195: new 239	com/tencent/mm/pluginguard/ActivityHookInstrumentation
    //   198: dup
    //   199: aload 4
    //   201: invokespecial 242	com/tencent/mm/pluginguard/ActivityHookInstrumentation:<init>	(Landroid/app/Instrumentation;)V
    //   204: invokevirtual 246	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   207: ldc 87
    //   209: ldc 248
    //   211: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: ldc 172
    //   216: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: iconst_1
    //   220: istore_2
    //   221: goto -98 -> 123
    //   224: ldc 87
    //   226: ldc 250
    //   228: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: goto -24 -> 207
    //   234: astore_1
    //   235: aload_0
    //   236: monitorexit
    //   237: aload_1
    //   238: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	a
    //   0	239	1	paramApplication	Application
    //   122	99	2	bool	boolean
    //   21	173	3	localObject1	Object
    //   76	124	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   17	52	100	java/lang/Exception
    //   56	78	100	java/lang/Exception
    //   83	100	100	java/lang/Exception
    //   127	175	100	java/lang/Exception
    //   178	207	100	java/lang/Exception
    //   224	231	100	java/lang/Exception
    //   2	17	234	finally
    //   17	52	234	finally
    //   56	78	234	finally
    //   83	100	234	finally
    //   101	121	234	finally
    //   127	175	234	finally
    //   178	207	234	finally
    //   207	219	234	finally
    //   224	231	234	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginguard.a
 * JD-Core Version:    0.7.0.1
 */