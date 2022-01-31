package com.tencent.mm.splash;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.bk;
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

public class i
{
  static d bwZ;
  public static final ArrayList<j> ulE = new ArrayList();
  public static final ArrayList<Message> ulF = new ArrayList();
  static Application ulG;
  static String ulH;
  static e ulI;
  static b ulJ;
  static f ulK;
  static Set<SplashActivity> ulL = new HashSet();
  private static boolean ulM = false;
  private static volatile boolean ulN = false;
  private static boolean ulO = false;
  private static p ulP;
  private static boolean ulQ = false;
  static c ulR;
  private static Class<? extends SplashActivity> ulS;
  private static Class<? extends Activity> ulT;
  private static o ulU = new o();
  private static boolean ulV = false;
  @SuppressLint({"HandlerLeak"})
  private static Handler ulW = new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if (paramAnonymousMessage.what == 0)
      {
        i.tf();
        return;
      }
      a.ge(i.ulG);
      a.a(new a.a()
      {
        public final void bCD()
        {
          i.c("WxSplash.Splash", "dexopt service return failed. kill self.", new Object[0]);
          i.csY();
        }
        
        public final void csR() {}
        
        public final void csS()
        {
          i.c("WxSplash.Splash", "dexopt service return timeout. kill self.", new Object[0]);
          i.csY();
        }
      });
    }
  };
  
  public static String W(Activity paramActivity)
  {
    if ((paramActivity instanceof j)) {
      return ((j)paramActivity).umf;
    }
    return "";
  }
  
  public static void W(Class<? extends SplashActivity> paramClass)
  {
    ulS = paramClass;
  }
  
  public static void X(Class<? extends Activity> paramClass)
  {
    ulT = paramClass;
  }
  
  static void a(SplashActivity paramSplashActivity)
  {
    ulL.add(paramSplashActivity);
  }
  
  public static void a(b paramb)
  {
    ulJ = paramb;
  }
  
  public static void a(c paramc)
  {
    ulR = paramc;
  }
  
  public static void a(d paramd)
  {
    bwZ = paramd;
  }
  
  public static void a(e parame)
  {
    ulI = parame;
  }
  
  public static void a(f paramf)
  {
    ulK = paramf;
  }
  
  public static void a(p paramp)
  {
    ulP = paramp;
  }
  
  public static void a(Throwable paramThrowable, String paramString)
  {
    if (ulR != null) {
      ulR.a(paramThrowable, paramString);
    }
  }
  
  public static void aay(String paramString)
  {
    ulH = paramString;
  }
  
  static void b(SplashActivity paramSplashActivity)
  {
    ulL.remove(paramSplashActivity);
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (ulR != null) {
      ulR.c(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void csU()
  {
    boolean bool = true;
    if (ulO) {}
    for (;;)
    {
      try
      {
        Handler.Callback localCallback = (Handler.Callback)m.umA.get(m.umu);
        if (localCallback != m.umz) {
          break label128;
        }
        c("WxSplash.Splash", "double check, callback %s %s", new Object[] { Boolean.valueOf(bool), localCallback });
        if (localCallback == m.umz) {
          return;
        }
        c("WxSplash.Splash", "double check found problem!", new Object[0]);
        Field localField = m.umA;
        m.umz.mHG = localCallback;
        localField.setAccessible(true);
        localField.set(m.umu, m.umz);
        ulU.j(675L, 31L, 1L);
        m.umu.sendEmptyMessage(987654321);
        return;
      }
      catch (Exception localException)
      {
        a(localException, "double check exception.");
      }
      return;
      label128:
      bool = false;
    }
  }
  
  public static boolean csV()
  {
    return true;
  }
  
  public static boolean csW()
  {
    return ulM;
  }
  
  public static boolean csX()
  {
    return ulN;
  }
  
  public static void csY()
  {
    Process.killProcess(Process.myPid());
  }
  
  public static void csZ()
  {
    if (!g.pg)
    {
      ulW.postDelayed(new Runnable()
      {
        public final void run()
        {
          com.tencent.mm.sdk.f.e.post(new Runnable()
          {
            public final void run()
            {
              boolean bool = a.gc(i.ulG);
              Handler localHandler = i.ctf();
              if (bool) {}
              for (int i = 1;; i = 0)
              {
                localHandler.sendEmptyMessage(i);
                return;
              }
            }
          }, "checking-need-dexopt");
        }
      }, 150L);
      return;
    }
    ulW.sendEmptyMessage(0);
  }
  
  private static Object ct(Context paramContext)
  {
    Object localObject = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
    ((Method)localObject).setAccessible(true);
    localObject = ((Method)localObject).invoke(null, new Object[0]);
    if (localObject != null) {
      return localObject;
    }
    localObject = paramContext.getClass().getField("mLoadedApk");
    ((Field)localObject).setAccessible(true);
    paramContext = ((Field)localObject).get(paramContext);
    localObject = paramContext.getClass().getDeclaredField("mActivityThread");
    ((Field)localObject).setAccessible(true);
    return ((Field)localObject).get(paramContext);
  }
  
  private static void cta()
  {
    c("WxSplash.Splash", "Gonna replay %s pending message(s).", new Object[] { Integer.valueOf(ulF.size()) });
    Iterator localIterator = ulF.iterator();
    while (localIterator.hasNext())
    {
      Message localMessage = (Message)localIterator.next();
      m.umu.sendMessage(localMessage);
    }
    ulF.clear();
  }
  
  private static void ctb()
  {
    c("WxSplash.Splash", "splash done, do finally things. ", new Object[0]);
    ulM = false;
    Object localObject1 = ulL.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      SplashActivity localSplashActivity = (SplashActivity)((Iterator)localObject1).next();
      c("WxSplash.Splash", "iterate splash activity %s.", new Object[] { localSplashActivity });
      localSplashActivity.cti();
    }
    c("WxSplash.Splash", "resend all %s pending message. ", new Object[] { Integer.valueOf(ulF.size()) });
    if (!ulN) {
      cta();
    }
    ulP = null;
    c("WxSplash.Splash", "we need splash no more.", new Object[0]);
    long l;
    try
    {
      ulQ = false;
      localObject1 = ulU;
      if (((o)localObject1).mStartTimestamp > 0L)
      {
        l = System.currentTimeMillis() - ((o)localObject1).mStartTimestamp;
        if (g.pg)
        {
          ((o)localObject1).j(676L, 1L, 1L);
          ((o)localObject1).j(676L, 3L, l);
        }
      }
      else
      {
        return;
      }
    }
    finally {}
    localObject2.j(676L, 0L, 1L);
    localObject2.j(676L, 2L, l);
  }
  
  /* Error */
  private static void ctc()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 165	com/tencent/mm/splash/i:ulG	Landroid/app/Application;
    //   6: invokestatic 404	com/tencent/mm/splash/a:gd	(Landroid/content/Context;)V
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 84	com/tencent/mm/splash/i:ulQ	Z
    //   15: ifeq +10 -> 25
    //   18: ldc 2
    //   20: monitorexit
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: iconst_1
    //   26: putstatic 84	com/tencent/mm/splash/i:ulQ	Z
    //   29: ldc 2
    //   31: monitorexit
    //   32: getstatic 82	com/tencent/mm/splash/i:ulO	Z
    //   35: ifne +39 -> 74
    //   38: ldc 177
    //   40: ldc_w 406
    //   43: iconst_0
    //   44: anewarray 4	java/lang/Object
    //   47: invokestatic 189	com/tencent/mm/splash/i:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: getstatic 150	com/tencent/mm/splash/i:ulP	Lcom/tencent/mm/splash/p;
    //   53: ifnonnull +245 -> 298
    //   56: invokestatic 241	com/tencent/mm/splash/i:ctb	()V
    //   59: goto -38 -> 21
    //   62: astore_0
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    //   68: astore_0
    //   69: ldc 2
    //   71: monitorexit
    //   72: aload_0
    //   73: athrow
    //   74: getstatic 300	com/tencent/mm/splash/g:pg	Z
    //   77: ifeq +42 -> 119
    //   80: ldc 177
    //   82: ldc_w 408
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 189	com/tencent/mm/splash/i:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: goto -42 -> 50
    //   95: astore_0
    //   96: getstatic 89	com/tencent/mm/splash/i:ulU	Lcom/tencent/mm/splash/o;
    //   99: ldc2_w 266
    //   102: ldc2_w 409
    //   105: lconst_1
    //   106: invokevirtual 273	com/tencent/mm/splash/o:j	(JJJ)V
    //   109: aload_0
    //   110: ldc_w 412
    //   113: invokestatic 231	com/tencent/mm/splash/i:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   116: goto -66 -> 50
    //   119: getstatic 416	com/tencent/mm/splash/m:umx	Ljava/util/List;
    //   122: ifnull -72 -> 50
    //   125: getstatic 416	com/tencent/mm/splash/m:umx	Ljava/util/List;
    //   128: invokeinterface 419 1 0
    //   133: ifeq -83 -> 50
    //   136: getstatic 89	com/tencent/mm/splash/i:ulU	Lcom/tencent/mm/splash/o;
    //   139: ldc2_w 266
    //   142: ldc2_w 420
    //   145: lconst_1
    //   146: invokevirtual 273	com/tencent/mm/splash/o:j	(JJJ)V
    //   149: getstatic 175	com/tencent/mm/splash/m:bxm	Ljava/lang/Object;
    //   152: astore_2
    //   153: aload_2
    //   154: invokevirtual 193	java/lang/Object:getClass	()Ljava/lang/Class;
    //   157: ldc_w 423
    //   160: invokevirtual 201	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   163: astore_0
    //   164: aload_0
    //   165: iconst_1
    //   166: invokevirtual 207	java/lang/reflect/Field:setAccessible	(Z)V
    //   169: aload_0
    //   170: aload_2
    //   171: invokevirtual 211	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   174: astore_1
    //   175: aload_1
    //   176: checkcast 425	android/app/Application
    //   179: putstatic 428	com/tencent/mm/splash/m:umw	Landroid/app/Application;
    //   182: aload_1
    //   183: astore_0
    //   184: aload_1
    //   185: ifnonnull +19 -> 204
    //   188: ldc 177
    //   190: ldc_w 430
    //   193: iconst_0
    //   194: anewarray 4	java/lang/Object
    //   197: invokestatic 189	com/tencent/mm/splash/i:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: getstatic 165	com/tencent/mm/splash/i:ulG	Landroid/app/Application;
    //   203: astore_0
    //   204: ldc_w 432
    //   207: invokestatic 313	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   210: pop
    //   211: ldc_w 434
    //   214: invokestatic 313	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   217: pop
    //   218: ldc 177
    //   220: ldc_w 436
    //   223: iconst_0
    //   224: anewarray 4	java/lang/Object
    //   227: invokestatic 189	com/tencent/mm/splash/i:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: ldc 177
    //   232: ldc_w 438
    //   235: iconst_0
    //   236: anewarray 4	java/lang/Object
    //   239: invokestatic 189	com/tencent/mm/splash/i:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   242: getstatic 442	com/tencent/mm/splash/m:umy	Ljava/lang/reflect/Method;
    //   245: aload_2
    //   246: iconst_2
    //   247: anewarray 4	java/lang/Object
    //   250: dup
    //   251: iconst_0
    //   252: aload_0
    //   253: aastore
    //   254: dup
    //   255: iconst_1
    //   256: getstatic 416	com/tencent/mm/splash/m:umx	Ljava/util/List;
    //   259: aastore
    //   260: invokevirtual 326	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   263: pop
    //   264: ldc 177
    //   266: ldc_w 444
    //   269: iconst_0
    //   270: anewarray 4	java/lang/Object
    //   273: invokestatic 189	com/tencent/mm/splash/i:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   276: getstatic 416	com/tencent/mm/splash/m:umx	Ljava/util/List;
    //   279: invokeinterface 445 1 0
    //   284: goto -234 -> 50
    //   287: astore_1
    //   288: aload_1
    //   289: ldc_w 447
    //   292: invokestatic 231	com/tencent/mm/splash/i:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   295: goto -65 -> 230
    //   298: getstatic 150	com/tencent/mm/splash/i:ulP	Lcom/tencent/mm/splash/p;
    //   301: new 18	com/tencent/mm/splash/i$5
    //   304: dup
    //   305: invokespecial 448	com/tencent/mm/splash/i$5:<init>	()V
    //   308: invokeinterface 454 2 0
    //   313: goto -292 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   62	5	0	localObject1	Object
    //   68	5	0	localObject2	Object
    //   95	15	0	localException	Exception
    //   163	90	0	localObject3	Object
    //   174	11	1	localObject4	Object
    //   287	2	1	localThrowable	Throwable
    //   152	94	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   3	12	62	finally
    //   32	50	62	finally
    //   50	59	62	finally
    //   72	74	62	finally
    //   74	92	62	finally
    //   96	116	62	finally
    //   119	182	62	finally
    //   188	204	62	finally
    //   204	230	62	finally
    //   230	284	62	finally
    //   288	295	62	finally
    //   298	313	62	finally
    //   12	21	68	finally
    //   25	32	68	finally
    //   69	72	68	finally
    //   32	50	95	java/lang/Exception
    //   74	92	95	java/lang/Exception
    //   119	182	95	java/lang/Exception
    //   188	204	95	java/lang/Exception
    //   204	230	95	java/lang/Exception
    //   230	284	95	java/lang/Exception
    //   288	295	95	java/lang/Exception
    //   204	230	287	java/lang/Throwable
  }
  
  public static Class<? extends Activity> ctd()
  {
    return ulS;
  }
  
  public static o cte()
  {
    return ulU;
  }
  
  public static boolean f(Application paramApplication)
  {
    for (;;)
    {
      boolean bool;
      long l;
      Object localObject3;
      int i;
      try
      {
        if (ulO)
        {
          c("WxSplash.Splash", "Splash has hacked before.", new Object[0]);
          bool = true;
          return bool;
        }
        l = System.currentTimeMillis();
        ulG = paramApplication;
        ulU.j(675L, 4L, 1L);
        try
        {
          localObject1 = Class.forName("android.app.ActivityManagerNative");
          localObject3 = ((Class)localObject1).getDeclaredMethod("getDefault", new Class[0]);
          ((Method)localObject3).setAccessible(true);
          localObject1 = ((Method)localObject3).invoke(localObject1, new Object[0]);
          if (localObject1 != null)
          {
            c("WxSplash.Splash", "getDefault %s", new Object[] { localObject1 });
            if (localObject1.getClass().getCanonicalName().startsWith("com.morgoo.droidplugin"))
            {
              ulU.j(675L, 33L, 1L);
              c("WxSplash.Splash", "found using droidplugin", new Object[0]);
            }
            if (Proxy.isProxyClass(localObject1.getClass())) {
              c("WxSplash.Splash", "found ActivityManager is a Proxy class, " + localObject1.getClass(), new Object[0]);
            }
          }
        }
        catch (Exception localException)
        {
          try
          {
            Object localObject1 = ct(paramApplication);
            localField = localObject1.getClass().getDeclaredField("mInstrumentation");
            localField.setAccessible(true);
            localObject3 = (Instrumentation)localField.get(localObject1);
            if (Object.class == localObject3.getClass().getSuperclass()) {
              continue;
            }
            localObject4 = localObject3.getClass().getCanonicalName();
            if ((!((String)localObject4).startsWith("android.support.test")) && (!((String)localObject4).startsWith("android.test"))) {
              continue;
            }
            c("WxSplash.Splash", "android instrument test is running, do not need splash.", new Object[0]);
            i = 1;
          }
          catch (Exception paramApplication)
          {
            a(paramApplication, "splash hack error!");
            bool = false;
          }
          localException = localException;
          a(localException, "validateEnvironment found some thing.");
          continue;
        }
        i = 0;
      }
      finally {}
      if (localObject3 == null) {
        throw new NullPointerException("Instrumentation original should not be null.");
      }
      Object localObject2;
      if (Object.class != localObject3.getClass().getSuperclass())
      {
        ulU.j(675L, 7L, 1L);
        c("WxSplash.Splash", "Instrumentation original's super class is not Object, maybe hacked by others. orig: %s, super: %s.", new Object[] { localObject3.getClass(), localObject3.getClass().getSuperclass() });
        paramApplication = localObject3.getClass().getCanonicalName();
        localObject2 = new RuntimeException("invalid environment for hack, " + localObject3.getClass());
        if (paramApplication.startsWith(new String[] { "com.excelliance", "com.lbe", "com.beike", "com.lody", "com.doubleagent", "com.svm", "com.morgoo" }[0]))
        {
          ulU.j(675L, 30L, 1L);
          c("WxSplash.Splash", "invalid environment for hack, dual open.", new Object[0]);
        }
        ulU.j(675L, 0L, 1L);
        throw ((Throwable)localObject2);
      }
      if (!(localObject3 instanceof l)) {
        localField.set(localObject2, new l((Instrumentation)localObject3));
      }
      for (;;)
      {
        m.bxm = localObject2;
        localObject3 = localObject2.getClass().getDeclaredField("mH");
        ((Field)localObject3).setAccessible(true);
        localObject3 = (Handler)((Field)localObject3).get(localObject2);
        if (localObject3 != null) {
          break;
        }
        throw new RuntimeException("mH is null!");
        c("WxSplash.Splash", "instrumentation is splash hacked, why? failed before?", new Object[0]);
      }
      m.umu = (Handler)localObject3;
      Field localField = Handler.class.getDeclaredField("mCallback");
      localField.setAccessible(true);
      Object localObject4 = (Handler.Callback)localField.get(localObject3);
      m.umA = localField;
      if (localObject4 != null)
      {
        c("WxSplash.Splash", "Handler.Callback original is not null, maybe hacked by others. orig: %s", new Object[] { localObject4 });
        ulU.j(675L, 8L, 1L);
      }
      if ((localObject4 == null) || (!(localObject4 instanceof k)))
      {
        paramApplication = new k(paramApplication, (Handler.Callback)localObject4);
        localField.setAccessible(true);
        localField.set(localObject3, paramApplication);
        m.umz = paramApplication;
      }
      for (;;)
      {
        paramApplication = new Handler();
        k.ag(new Runnable()
        {
          public final void run()
          {
            i.BF();
            this.ulX.removeCallbacksAndMessages(null);
            i.c("WxSplash.Splash", "verify mH callback hack, result ok.", new Object[0]);
          }
        });
        m.umu.sendEmptyMessage(987654321);
        paramApplication.postDelayed(new Runnable()
        {
          public final void run()
          {
            if (!i.ulV)
            {
              i.c("WxSplash.Splash", "verify mH callback hack, result failed!.", new Object[0]);
              i.cte().j(675L, 32L, 1L);
              i.access$100();
            }
          }
        }, 2000L);
        if (!g.pg)
        {
          paramApplication = localObject2.getClass().getDeclaredMethod("installContentProviders", new Class[] { Context.class, List.class });
          paramApplication.setAccessible(true);
          m.umy = paramApplication;
          paramApplication = localObject2.getClass().getDeclaredField("mBoundApplication");
          paramApplication.setAccessible(true);
          paramApplication = paramApplication.get(localObject2);
          m.umv = paramApplication;
          localObject2 = paramApplication.getClass().getDeclaredField("restrictedBackupMode");
          ((Field)localObject2).setAccessible(true);
          ((Field)localObject2).set(paramApplication, Boolean.valueOf(true));
          localObject2 = paramApplication.getClass().getDeclaredField("providers");
          ((Field)localObject2).setAccessible(true);
          m.umx = (List)((Field)localObject2).get(paramApplication);
        }
        ulO = true;
        ulM = true;
        c("WxSplash.Splash", "splash hack success.", new Object[0]);
        c("WxSplash.Splash", "we need splash. time spent %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        bool = true;
        break;
        c("WxSplash.Splash", "callback is splash hacked, why? failed before?", new Object[0]);
      }
      if (i != 0) {
        bool = false;
      }
    }
  }
  
  public static void gi(Context paramContext)
  {
    label225:
    for (int i = 1;; i = 0)
    {
      try
      {
        localObject = bk.fX(paramContext);
        if ((localObject != null) && (((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName())) && (ulH != null) && (((ComponentName)localObject).getClassName().equals(ulH))) {
          c("WxSplash.Splash", "it is LauncherUI", new Object[0]);
        }
        while (i == 0)
        {
          c("WxSplash.Splash", "do nothing and return.", new Object[0]);
          return;
          if ((localObject == null) || (!((ComponentName)localObject).getPackageName().startsWith("com.excelliance"))) {
            break label225;
          }
          c("WxSplash.Splash", "it is dual open", new Object[0]);
        }
        ulU.j(675L, 36L, 1L);
      }
      catch (IOException paramContext)
      {
        a(paramContext, "request fig leaf failed.");
        return;
      }
      Object localObject = a.csN();
      File localFile = new File((String)localObject);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localObject = new File((String)localObject + "/main-process-blocking");
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      if (!((File)localObject).createNewFile()) {
        break;
      }
      localObject = new Intent(paramContext, ulT);
      ((Intent)localObject).addFlags(268435456);
      paramContext.startActivity((Intent)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.i
 * JD-Core Version:    0.7.0.1
 */