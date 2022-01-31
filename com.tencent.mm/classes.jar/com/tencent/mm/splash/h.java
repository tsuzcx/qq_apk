package com.tencent.mm.splash;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class h
{
  static d bYM;
  private static HashSet<String> yvA;
  private static boolean yvB;
  @SuppressLint({"HandlerLeak"})
  private static Handler yvC;
  public static final ArrayList<i> yvj;
  public static final ArrayList<Message> yvk;
  static Application yvl;
  static String yvm;
  static e yvn;
  static b yvo;
  static f yvp;
  static Set<SplashActivity> yvq;
  private static boolean yvr;
  private static volatile boolean yvs;
  private static boolean yvt;
  private static o yvu;
  private static boolean yvv;
  static c yvw;
  private static Class<? extends SplashActivity> yvx;
  private static Class<? extends Activity> yvy;
  private static n yvz;
  
  static
  {
    AppMethodBeat.i(114859);
    yvj = new ArrayList();
    yvk = new ArrayList();
    yvq = new HashSet();
    yvr = false;
    yvs = false;
    yvt = false;
    yvv = false;
    yvz = new n();
    yvA = new HashSet();
    yvB = false;
    yvC = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(114833);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 0)
        {
          h.access$200();
          AppMethodBeat.o(114833);
          return;
        }
        a.hx(h.yvl);
        a.a(new a.a()
        {
          public final void cod()
          {
            AppMethodBeat.i(114831);
            h.c("WxSplash.Splash", "dexopt service return failed. kill self.", new Object[0]);
            h.caC();
            AppMethodBeat.o(114831);
          }
          
          public final void dvp()
          {
            AppMethodBeat.i(114830);
            h.access$200();
            AppMethodBeat.o(114830);
          }
          
          public final void dvq()
          {
            AppMethodBeat.i(114832);
            h.c("WxSplash.Splash", "dexopt service return timeout. kill self.", new Object[0]);
            h.caC();
            AppMethodBeat.o(114832);
          }
        });
        AppMethodBeat.o(114833);
      }
    };
    AppMethodBeat.o(114859);
  }
  
  static void a(SplashActivity paramSplashActivity)
  {
    AppMethodBeat.i(114838);
    yvq.add(paramSplashActivity);
    AppMethodBeat.o(114838);
  }
  
  public static void a(b paramb)
  {
    yvo = paramb;
  }
  
  public static void a(c paramc)
  {
    yvw = paramc;
  }
  
  public static void a(d paramd)
  {
    bYM = paramd;
  }
  
  public static void a(e parame)
  {
    yvn = parame;
  }
  
  public static void a(f paramf)
  {
    yvp = paramf;
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(114851);
    if (!dz(parami.yvL))
    {
      parami.recreate();
      c("WxSplash.Splash", "do recreate for %s", new Object[] { parami.yvL });
      AppMethodBeat.o(114851);
      return;
    }
    parami.finish();
    c("WxSplash.Splash", "eat activity, %s", new Object[] { parami.yvL });
    AppMethodBeat.o(114851);
  }
  
  public static void a(o paramo)
  {
    yvu = paramo;
  }
  
  public static void a(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(114854);
    if (yvw != null) {
      yvw.a(paramThrowable, paramString);
    }
    AppMethodBeat.o(114854);
  }
  
  public static void aqI(String paramString)
  {
    AppMethodBeat.i(114840);
    yvA.add(paramString);
    AppMethodBeat.o(114840);
  }
  
  public static void aqJ(String paramString)
  {
    yvm = paramString;
  }
  
  public static void as(Class<? extends SplashActivity> paramClass)
  {
    yvx = paramClass;
  }
  
  public static void at(Class<? extends Activity> paramClass)
  {
    yvy = paramClass;
  }
  
  public static String av(Activity paramActivity)
  {
    if ((paramActivity instanceof i)) {
      return ((i)paramActivity).yvL;
    }
    return "";
  }
  
  static void b(SplashActivity paramSplashActivity)
  {
    AppMethodBeat.i(114839);
    yvq.remove(paramSplashActivity);
    AppMethodBeat.o(114839);
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(114853);
    if (yvw != null) {
      yvw.c(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(114853);
  }
  
  private static Object cU(Context paramContext)
  {
    AppMethodBeat.i(114852);
    Object localObject = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
    ((Method)localObject).setAccessible(true);
    localObject = ((Method)localObject).invoke(null, new Object[0]);
    if (localObject != null)
    {
      AppMethodBeat.o(114852);
      return localObject;
    }
    localObject = paramContext.getClass().getField("mLoadedApk");
    ((Field)localObject).setAccessible(true);
    paramContext = ((Field)localObject).get(paramContext);
    localObject = paramContext.getClass().getDeclaredField("mActivityThread");
    ((Field)localObject).setAccessible(true);
    paramContext = ((Field)localObject).get(paramContext);
    AppMethodBeat.o(114852);
    return paramContext;
  }
  
  public static void caC()
  {
    AppMethodBeat.i(114844);
    Process.killProcess(Process.myPid());
    AppMethodBeat.o(114844);
  }
  
  public static Class<? extends Activity> dvA()
  {
    return yvx;
  }
  
  public static n dvB()
  {
    return yvz;
  }
  
  public static void dvs()
  {
    boolean bool = true;
    AppMethodBeat.i(114843);
    if (yvt) {
      try
      {
        Handler.Callback localCallback = (Handler.Callback)l.ywg.get(l.ywa);
        if (localCallback == l.ywf) {}
        for (;;)
        {
          c("WxSplash.Splash", "double check, callback %s %s", new Object[] { Boolean.valueOf(bool), localCallback });
          localObject = l.ywf;
          if (localCallback != localObject) {
            break;
          }
          AppMethodBeat.o(114843);
          return;
          bool = false;
        }
        c("WxSplash.Splash", "double check found problem!", new Object[0]);
        Object localObject = l.ywg;
        l.ywf.phM = localCallback;
        ((Field)localObject).setAccessible(true);
        ((Field)localObject).set(l.ywa, l.ywf);
        yvz.l(675L, 31L, 1L);
        l.ywa.sendEmptyMessage(987654321);
        AppMethodBeat.o(114843);
        return;
      }
      catch (Exception localException)
      {
        a(localException, "double check exception.");
      }
    }
    AppMethodBeat.o(114843);
  }
  
  public static boolean dvt()
  {
    return true;
  }
  
  public static boolean dvu()
  {
    return yvr;
  }
  
  public static boolean dvv()
  {
    return yvs;
  }
  
  public static void dvw()
  {
    AppMethodBeat.i(114845);
    if (!g.qd)
    {
      yvC.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114835);
          com.tencent.mm.sdk.g.d.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(114834);
              boolean bool = a.hv(h.yvl);
              Handler localHandler = h.dvC();
              if (bool) {}
              for (int i = 1;; i = 0)
              {
                localHandler.sendEmptyMessage(i);
                AppMethodBeat.o(114834);
                return;
              }
            }
          }, "checking-need-dexopt");
          AppMethodBeat.o(114835);
        }
      }, 150L);
      AppMethodBeat.o(114845);
      return;
    }
    yvC.sendEmptyMessage(0);
    AppMethodBeat.o(114845);
  }
  
  private static void dvx()
  {
    AppMethodBeat.i(114847);
    c("WxSplash.Splash", "Gonna replay %s pending message(s).", new Object[] { Integer.valueOf(yvk.size()) });
    Iterator localIterator = yvk.iterator();
    while (localIterator.hasNext()) {
      x((Message)localIterator.next());
    }
    yvk.clear();
    AppMethodBeat.o(114847);
  }
  
  private static void dvy()
  {
    AppMethodBeat.i(114848);
    c("WxSplash.Splash", "splash done, do finally things. ", new Object[0]);
    yvr = false;
    int i = yvq.size();
    Object localObject1 = yvq.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      SplashActivity localSplashActivity = (SplashActivity)((Iterator)localObject1).next();
      c("WxSplash.Splash", "iterate splash activity %s.", new Object[] { localSplashActivity });
      localSplashActivity.dvF();
    }
    if (i == 0)
    {
      c("WxSplash.Splash", "no splash activity found, so we terminate hacked activities manually.", new Object[0]);
      localObject1 = yvj.iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((i)((Iterator)localObject1).next());
      }
    }
    c("WxSplash.Splash", "resend all %s pending message. ", new Object[] { Integer.valueOf(yvk.size()) });
    if (!yvs) {
      dvx();
    }
    yvu = null;
    c("WxSplash.Splash", "we need splash no more.", new Object[0]);
    long l;
    try
    {
      yvv = false;
      localObject1 = yvz;
      if (((n)localObject1).mStartTimestamp <= 0L) {
        break label278;
      }
      l = System.currentTimeMillis() - ((n)localObject1).mStartTimestamp;
      if (g.qd)
      {
        ((n)localObject1).l(676L, 1L, 1L);
        ((n)localObject1).l(676L, 3L, l);
        AppMethodBeat.o(114848);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(114848);
    }
    localObject2.l(676L, 0L, 1L);
    localObject2.l(676L, 2L, l);
    label278:
    AppMethodBeat.o(114848);
  }
  
  /* Error */
  private static void dvz()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 461
    //   6: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 206	com/tencent/mm/splash/h:yvl	Landroid/app/Application;
    //   12: invokestatic 467	com/tencent/mm/splash/a:hw	(Landroid/content/Context;)V
    //   15: ldc 2
    //   17: monitorenter
    //   18: getstatic 94	com/tencent/mm/splash/h:yvv	Z
    //   21: ifeq +16 -> 37
    //   24: ldc 2
    //   26: monitorexit
    //   27: ldc_w 461
    //   30: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: ldc 2
    //   35: monitorexit
    //   36: return
    //   37: iconst_1
    //   38: putstatic 94	com/tencent/mm/splash/h:yvv	Z
    //   41: ldc 2
    //   43: monitorexit
    //   44: getstatic 92	com/tencent/mm/splash/h:yvt	Z
    //   47: ifne +51 -> 98
    //   50: ldc 123
    //   52: ldc_w 469
    //   55: iconst_0
    //   56: anewarray 4	java/lang/Object
    //   59: invokestatic 135	com/tencent/mm/splash/h:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: getstatic 188	com/tencent/mm/splash/h:yvu	Lcom/tencent/mm/splash/o;
    //   65: ifnonnull +257 -> 322
    //   68: invokestatic 199	com/tencent/mm/splash/h:dvy	()V
    //   71: ldc_w 461
    //   74: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: goto -44 -> 33
    //   80: astore_0
    //   81: ldc 2
    //   83: monitorexit
    //   84: aload_0
    //   85: athrow
    //   86: astore_0
    //   87: ldc 2
    //   89: monitorexit
    //   90: ldc_w 461
    //   93: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_0
    //   97: athrow
    //   98: getstatic 382	com/tencent/mm/splash/g:qd	Z
    //   101: ifeq +42 -> 143
    //   104: ldc 123
    //   106: ldc_w 471
    //   109: iconst_0
    //   110: anewarray 4	java/lang/Object
    //   113: invokestatic 135	com/tencent/mm/splash/h:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: goto -54 -> 62
    //   119: astore_0
    //   120: getstatic 99	com/tencent/mm/splash/h:yvz	Lcom/tencent/mm/splash/n;
    //   123: ldc2_w 358
    //   126: ldc2_w 472
    //   129: lconst_1
    //   130: invokevirtual 365	com/tencent/mm/splash/n:l	(JJJ)V
    //   133: aload_0
    //   134: ldc_w 475
    //   137: invokestatic 260	com/tencent/mm/splash/h:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   140: goto -78 -> 62
    //   143: getstatic 479	com/tencent/mm/splash/l:ywd	Ljava/util/List;
    //   146: ifnull -84 -> 62
    //   149: getstatic 479	com/tencent/mm/splash/l:ywd	Ljava/util/List;
    //   152: invokeinterface 482 1 0
    //   157: ifeq -95 -> 62
    //   160: getstatic 99	com/tencent/mm/splash/h:yvz	Lcom/tencent/mm/splash/n;
    //   163: ldc2_w 358
    //   166: ldc2_w 483
    //   169: lconst_1
    //   170: invokevirtual 365	com/tencent/mm/splash/n:l	(JJJ)V
    //   173: getstatic 216	com/tencent/mm/splash/l:bZm	Ljava/lang/Object;
    //   176: astore_2
    //   177: aload_2
    //   178: invokevirtual 222	java/lang/Object:getClass	()Ljava/lang/Class;
    //   181: ldc_w 486
    //   184: invokevirtual 230	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   187: astore_0
    //   188: aload_0
    //   189: iconst_1
    //   190: invokevirtual 236	java/lang/reflect/Field:setAccessible	(Z)V
    //   193: aload_0
    //   194: aload_2
    //   195: invokevirtual 240	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   198: astore_1
    //   199: aload_1
    //   200: checkcast 488	android/app/Application
    //   203: putstatic 491	com/tencent/mm/splash/l:ywc	Landroid/app/Application;
    //   206: aload_1
    //   207: astore_0
    //   208: aload_1
    //   209: ifnonnull +19 -> 228
    //   212: ldc 123
    //   214: ldc_w 493
    //   217: iconst_0
    //   218: anewarray 4	java/lang/Object
    //   221: invokestatic 135	com/tencent/mm/splash/h:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: getstatic 206	com/tencent/mm/splash/h:yvl	Landroid/app/Application;
    //   227: astore_0
    //   228: ldc_w 495
    //   231: invokestatic 300	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   234: pop
    //   235: ldc_w 497
    //   238: invokestatic 300	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   241: pop
    //   242: ldc 123
    //   244: ldc_w 499
    //   247: iconst_0
    //   248: anewarray 4	java/lang/Object
    //   251: invokestatic 135	com/tencent/mm/splash/h:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   254: ldc 123
    //   256: ldc_w 501
    //   259: iconst_0
    //   260: anewarray 4	java/lang/Object
    //   263: invokestatic 135	com/tencent/mm/splash/h:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: getstatic 505	com/tencent/mm/splash/l:ywe	Ljava/lang/reflect/Method;
    //   269: aload_2
    //   270: iconst_2
    //   271: anewarray 4	java/lang/Object
    //   274: dup
    //   275: iconst_0
    //   276: aload_0
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: getstatic 479	com/tencent/mm/splash/l:ywd	Ljava/util/List;
    //   283: aastore
    //   284: invokevirtual 313	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   287: pop
    //   288: ldc 123
    //   290: ldc_w 507
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 135	com/tencent/mm/splash/h:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: getstatic 479	com/tencent/mm/splash/l:ywd	Ljava/util/List;
    //   303: invokeinterface 508 1 0
    //   308: goto -246 -> 62
    //   311: astore_1
    //   312: aload_1
    //   313: ldc_w 510
    //   316: invokestatic 260	com/tencent/mm/splash/h:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   319: goto -65 -> 254
    //   322: getstatic 188	com/tencent/mm/splash/h:yvu	Lcom/tencent/mm/splash/o;
    //   325: new 18	com/tencent/mm/splash/h$5
    //   328: dup
    //   329: invokespecial 511	com/tencent/mm/splash/h$5:<init>	()V
    //   332: invokeinterface 517 2 0
    //   337: ldc_w 461
    //   340: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   343: goto -310 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   80	5	0	localObject1	Object
    //   86	11	0	localObject2	Object
    //   119	15	0	localException	Exception
    //   187	90	0	localObject3	Object
    //   198	11	1	localObject4	Object
    //   311	2	1	localThrowable	Throwable
    //   176	94	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   3	18	80	finally
    //   27	33	80	finally
    //   44	62	80	finally
    //   62	77	80	finally
    //   90	98	80	finally
    //   98	116	80	finally
    //   120	140	80	finally
    //   143	206	80	finally
    //   212	228	80	finally
    //   228	254	80	finally
    //   254	308	80	finally
    //   312	319	80	finally
    //   322	343	80	finally
    //   18	27	86	finally
    //   37	44	86	finally
    //   87	90	86	finally
    //   44	62	119	java/lang/Exception
    //   98	116	119	java/lang/Exception
    //   143	206	119	java/lang/Exception
    //   212	228	119	java/lang/Exception
    //   228	254	119	java/lang/Exception
    //   254	308	119	java/lang/Exception
    //   312	319	119	java/lang/Exception
    //   228	254	311	java/lang/Throwable
  }
  
  private static boolean dz(String paramString)
  {
    AppMethodBeat.i(114850);
    if (bYM != null)
    {
      boolean bool = bYM.dz(paramString);
      AppMethodBeat.o(114850);
      return bool;
    }
    AppMethodBeat.o(114850);
    return false;
  }
  
  public static void hA(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(114841);
    for (;;)
    {
      try
      {
        localObject = bo.hn(paramContext);
        if ((localObject != null) && (((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName())) && (yvm != null) && (((ComponentName)localObject).getClassName().equals(yvm)))
        {
          c("WxSplash.Splash", "it is LauncherUI", new Object[0]);
          if (i == 0)
          {
            c("WxSplash.Splash", "do nothing and return.", new Object[0]);
            AppMethodBeat.o(114841);
          }
        }
        else
        {
          if ((localObject == null) || (!((ComponentName)localObject).getPackageName().startsWith("com.excelliance"))) {
            break label249;
          }
          c("WxSplash.Splash", "it is dual open", new Object[0]);
          continue;
        }
        yvz.l(675L, 36L, 1L);
      }
      catch (IOException paramContext)
      {
        a(paramContext, "request fig leaf failed.");
        AppMethodBeat.o(114841);
        return;
      }
      Object localObject = a.dvl();
      File localFile = new File((String)localObject);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localObject = new File((String)localObject + "/main-process-blocking");
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      if (((File)localObject).createNewFile())
      {
        localObject = new Intent(paramContext, yvy);
        ((Intent)localObject).addFlags(268435456);
        paramContext.startActivity((Intent)localObject);
      }
      AppMethodBeat.o(114841);
      return;
      label249:
      i = 0;
    }
  }
  
  public static boolean j(Application paramApplication)
  {
    boolean bool;
    try
    {
      AppMethodBeat.i(114842);
      if (!yvt) {
        break label40;
      }
      c("WxSplash.Splash", "Splash has hacked before.", new Object[0]);
      bool = true;
      AppMethodBeat.o(114842);
    }
    finally
    {
      for (;;)
      {
        try
        {
          label40:
          localObject1 = Class.forName("android.app.ActivityManagerNative");
          localObject3 = ((Class)localObject1).getDeclaredMethod("getDefault", new Class[0]);
          ((Method)localObject3).setAccessible(true);
          localObject1 = ((Method)localObject3).invoke(localObject1, new Object[0]);
          if (localObject1 != null)
          {
            c("WxSplash.Splash", "getDefault %s", new Object[] { localObject1 });
            if (localObject1.getClass().getCanonicalName().startsWith("com.morgoo.droidplugin"))
            {
              yvz.l(675L, 33L, 1L);
              c("WxSplash.Splash", "found using droidplugin", new Object[0]);
            }
            if (Proxy.isProxyClass(localObject1.getClass())) {
              c("WxSplash.Splash", "found ActivityManager is a Proxy class, " + localObject1.getClass(), new Object[0]);
            }
          }
        }
        catch (Exception localException)
        {
          a(localException, "validateEnvironment found some thing.");
          continue;
        }
        try
        {
          localObject1 = cU(paramApplication);
          localObject4 = localObject1.getClass().getDeclaredField("mInstrumentation");
          ((Field)localObject4).setAccessible(true);
          localObject3 = (Instrumentation)((Field)localObject4).get(localObject1);
          if (Object.class == localObject3.getClass().getSuperclass()) {
            break label356;
          }
          localObject5 = localObject3.getClass().getCanonicalName();
          if ((!((String)localObject5).startsWith("android.support.test")) && (!((String)localObject5).startsWith("android.test"))) {
            break label356;
          }
          c("WxSplash.Splash", "android instrument test is running, do not need splash.", new Object[0]);
          i = 1;
          if (i == 0) {
            break label361;
          }
          bool = false;
          AppMethodBeat.o(114842);
        }
        catch (Exception paramApplication)
        {
          a(paramApplication, "splash hack error!");
          bool = false;
          AppMethodBeat.o(114842);
        }
      }
      paramApplication = finally;
    }
    return bool;
    long l = System.currentTimeMillis();
    yvl = paramApplication;
    yvz.l(675L, 4L, 1L);
    Object localObject3;
    for (;;)
    {
      Object localObject1;
      break;
      label356:
      int i = 0;
    }
    label361:
    if (localObject3 == null)
    {
      paramApplication = new NullPointerException("Instrumentation original should not be null.");
      AppMethodBeat.o(114842);
      throw paramApplication;
    }
    Object localObject2;
    if (Object.class != localObject3.getClass().getSuperclass())
    {
      yvz.l(675L, 7L, 1L);
      c("WxSplash.Splash", "Instrumentation original's super class is not Object, maybe hacked by others. orig: %s, super: %s.", new Object[] { localObject3.getClass(), localObject3.getClass().getSuperclass() });
      paramApplication = localObject3.getClass().getCanonicalName();
      localObject2 = new RuntimeException("invalid environment for hack, " + localObject3.getClass());
      if (paramApplication.startsWith(new String[] { "com.excelliance", "com.lbe", "com.beike", "com.lody", "com.doubleagent", "com.svm", "com.morgoo" }[0]))
      {
        yvz.l(675L, 30L, 1L);
        c("WxSplash.Splash", "invalid environment for hack, dual open.", new Object[0]);
      }
      yvz.l(675L, 0L, 1L);
      AppMethodBeat.o(114842);
      throw ((Throwable)localObject2);
    }
    if (!(localObject3 instanceof k)) {
      ((Field)localObject4).set(localObject2, new k((Instrumentation)localObject3));
    }
    for (;;)
    {
      l.bZm = localObject2;
      localObject3 = localObject2.getClass().getDeclaredField("mH");
      ((Field)localObject3).setAccessible(true);
      localObject3 = (Handler)((Field)localObject3).get(localObject2);
      if (localObject3 != null) {
        break;
      }
      paramApplication = new RuntimeException("mH is null!");
      AppMethodBeat.o(114842);
      throw paramApplication;
      c("WxSplash.Splash", "instrumentation is splash hacked, why? failed before?", new Object[0]);
    }
    l.ywa = (Handler)localObject3;
    Object localObject4 = Handler.class.getDeclaredField("mCallback");
    ((Field)localObject4).setAccessible(true);
    Object localObject5 = (Handler.Callback)((Field)localObject4).get(localObject3);
    l.ywg = (Field)localObject4;
    if (localObject5 != null)
    {
      c("WxSplash.Splash", "Handler.Callback original is not null, maybe hacked by others. orig: %s", new Object[] { localObject5 });
      yvz.l(675L, 8L, 1L);
    }
    if ((localObject5 == null) || (!(localObject5 instanceof j)))
    {
      paramApplication = new j(paramApplication, (Handler.Callback)localObject5);
      ((Field)localObject4).setAccessible(true);
      ((Field)localObject4).set(localObject3, paramApplication);
      l.ywf = paramApplication;
      label795:
      paramApplication = new Handler();
      j.au(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114828);
          h.Pt();
          this.yvD.removeCallbacksAndMessages(null);
          h.c("WxSplash.Splash", "verify mH callback hack, result ok.", new Object[0]);
          AppMethodBeat.o(114828);
        }
      });
      l.ywa.sendEmptyMessage(987654321);
      paramApplication.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114829);
          if (!h.yvB)
          {
            h.c("WxSplash.Splash", "verify mH callback hack, result failed!.", new Object[0]);
            h.dvB().l(675L, 32L, 1L);
            h.access$100();
          }
          AppMethodBeat.o(114829);
        }
      }, 2000L);
      if ((yvA.size() <= 0) && (g.qd)) {
        break label1090;
      }
      paramApplication = localObject2.getClass().getDeclaredMethod("installContentProviders", new Class[] { Context.class, List.class });
      paramApplication.setAccessible(true);
      l.ywe = paramApplication;
      paramApplication = localObject2.getClass().getDeclaredField("mBoundApplication");
      paramApplication.setAccessible(true);
      paramApplication = paramApplication.get(localObject2);
      l.ywb = paramApplication;
      localObject2 = paramApplication.getClass().getDeclaredField("restrictedBackupMode");
      ((Field)localObject2).setAccessible(true);
      if (!g.qd) {
        ((Field)localObject2).set(paramApplication, Boolean.TRUE);
      }
      localObject2 = paramApplication.getClass().getDeclaredField("providers");
      ((Field)localObject2).setAccessible(true);
      l.ywd = (List)((Field)localObject2).get(paramApplication);
      localObject2 = yvA.iterator();
      label990:
      if (!((Iterator)localObject2).hasNext()) {
        break label1090;
      }
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = l.ywd.iterator();
      do
      {
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        paramApplication = (ProviderInfo)((Iterator)localObject4).next();
      } while ((paramApplication.name == null) || (!paramApplication.name.equals(localObject3)));
    }
    for (;;)
    {
      l.ywd.remove(paramApplication);
      break label990;
      c("WxSplash.Splash", "callback is splash hacked, why? failed before?", new Object[0]);
      break label795;
      label1090:
      yvt = true;
      yvr = true;
      c("WxSplash.Splash", "splash hack success.", new Object[0]);
      c("WxSplash.Splash", "we need splash. time spent %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      bool = true;
      AppMethodBeat.o(114842);
      break;
      paramApplication = null;
    }
  }
  
  public static void x(Message paramMessage)
  {
    AppMethodBeat.i(114846);
    l.ywa.sendMessage(paramMessage);
    AppMethodBeat.o(114846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.h
 * JD-Core Version:    0.7.0.1
 */