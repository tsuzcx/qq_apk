package com.tencent.mm.splash;

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
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
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
  public static final ArrayList<j> acAD;
  public static final ArrayList<Message> acAE;
  static String acAF;
  static e acAG;
  static b acAH;
  static f acAI;
  static Set<SplashActivity> acAJ;
  private static boolean acAK;
  private static volatile boolean acAL;
  private static boolean acAM;
  private static p acAN;
  private static boolean acAO;
  static c acAP;
  private static Class<? extends SplashActivity> acAQ;
  private static Set<String> acAR;
  private static Class<? extends Activity> acAS;
  private static o acAT;
  private static HashSet<String> acAU;
  private static boolean acAV;
  private static Handler acAW;
  static Application fgz;
  static d hhy;
  
  static
  {
    AppMethodBeat.i(40652);
    acAD = new ArrayList();
    acAE = new ArrayList();
    acAJ = new HashSet();
    acAK = false;
    acAL = false;
    acAM = false;
    acAO = false;
    acAR = new HashSet();
    acAT = new o();
    acAU = new HashSet();
    acAV = false;
    acAW = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(40626);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 0)
        {
          i.access$200();
          AppMethodBeat.o(40626);
          return;
        }
        a.mA(i.fgz);
        a.a(new a.a()
        {
          public final void hfu()
          {
            AppMethodBeat.i(40624);
            i.g("WxSplash.Splash", "dexopt service return failed. kill self.", new Object[0]);
            i.gyU();
            AppMethodBeat.o(40624);
          }
          
          public final void iVH()
          {
            AppMethodBeat.i(40623);
            i.access$200();
            AppMethodBeat.o(40623);
          }
          
          public final void iVI()
          {
            AppMethodBeat.i(40625);
            i.g("WxSplash.Splash", "dexopt service return timeout. kill self.", new Object[0]);
            i.gyU();
            AppMethodBeat.o(40625);
          }
        });
        AppMethodBeat.o(40626);
      }
    };
    AppMethodBeat.o(40652);
  }
  
  static void a(SplashActivity paramSplashActivity)
  {
    AppMethodBeat.i(40631);
    acAJ.add(paramSplashActivity);
    AppMethodBeat.o(40631);
  }
  
  public static void a(b paramb)
  {
    acAH = paramb;
  }
  
  public static void a(c paramc)
  {
    acAP = paramc;
  }
  
  public static void a(d paramd)
  {
    hhy = paramd;
  }
  
  public static void a(e parame)
  {
    acAG = parame;
  }
  
  public static void a(f paramf)
  {
    acAI = paramf;
  }
  
  public static void a(j paramj)
  {
    AppMethodBeat.i(40644);
    if (!ir(paramj.acBe))
    {
      paramj.recreate();
      g("WxSplash.Splash", "do recreate for %s", new Object[] { paramj.acBe });
      AppMethodBeat.o(40644);
      return;
    }
    paramj.finish();
    g("WxSplash.Splash", "eat activity, %s", new Object[] { paramj.acBe });
    AppMethodBeat.o(40644);
  }
  
  public static void a(p paramp)
  {
    acAN = paramp;
  }
  
  public static void a(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(40647);
    if (acAP != null) {
      acAP.a(paramThrowable, paramString);
    }
    AppMethodBeat.o(40647);
  }
  
  static void b(SplashActivity paramSplashActivity)
  {
    AppMethodBeat.i(40632);
    acAJ.remove(paramSplashActivity);
    AppMethodBeat.o(40632);
  }
  
  public static String bL(Activity paramActivity)
  {
    if ((paramActivity instanceof j)) {
      return ((j)paramActivity).acBe;
    }
    return "";
  }
  
  public static void buH(String paramString)
  {
    AppMethodBeat.i(40633);
    acAU.add(paramString);
    AppMethodBeat.o(40633);
  }
  
  public static void buI(String paramString)
  {
    acAF = paramString;
  }
  
  public static boolean buJ(String paramString)
  {
    AppMethodBeat.i(233940);
    boolean bool = acAR.contains(paramString);
    g("WxSplash.Splash", "ignore activity %s ?, %s", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(233940);
    return bool;
  }
  
  public static void cg(Class<? extends SplashActivity> paramClass)
  {
    acAQ = paramClass;
  }
  
  public static void ch(Class<? extends Activity> paramClass)
  {
    acAS = paramClass;
  }
  
  public static void g(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(40646);
    if (acAP != null) {
      acAP.g(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(40646);
  }
  
  public static void gyU()
  {
    AppMethodBeat.i(40637);
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/splash/Splash", "killSelf", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/splash/Splash", "killSelf", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(40637);
  }
  
  public static void iVK()
  {
    boolean bool = true;
    AppMethodBeat.i(40636);
    if (acAM) {
      try
      {
        Handler.Callback localCallback = (Handler.Callback)m.acBz.get(m.qBf);
        if (localCallback == m.acBy) {}
        for (;;)
        {
          g("WxSplash.Splash", "double check, callback %s %s", new Object[] { Boolean.valueOf(bool), localCallback });
          localObject = m.acBy;
          if (localCallback != localObject) {
            break;
          }
          AppMethodBeat.o(40636);
          return;
          bool = false;
        }
        g("WxSplash.Splash", "double check found problem!", new Object[0]);
        Object localObject = m.acBz;
        m.acBy.Mvi = localCallback;
        ((Field)localObject).setAccessible(true);
        ((Field)localObject).set(m.qBf, m.acBy);
        acAT.idkey(675L, 31L, 1L);
        m.qBf.sendEmptyMessage(987654321);
        AppMethodBeat.o(40636);
        return;
      }
      catch (Exception localException)
      {
        a(localException, "double check exception.");
      }
    }
    AppMethodBeat.o(40636);
  }
  
  public static boolean iVL()
  {
    return true;
  }
  
  public static boolean iVM()
  {
    return acAK;
  }
  
  public static boolean iVN()
  {
    return acAL;
  }
  
  public static void iVO()
  {
    int i = 0;
    AppMethodBeat.i(40638);
    if (!g.bKk)
    {
      boolean bool = a.iVC();
      Handler localHandler = acAW;
      if (bool) {
        i = 1;
      }
      localHandler.sendEmptyMessage(i);
      AppMethodBeat.o(40638);
      return;
    }
    acAW.sendEmptyMessage(0);
    AppMethodBeat.o(40638);
  }
  
  private static void iVP()
  {
    AppMethodBeat.i(40640);
    g("WxSplash.Splash", "Gonna replay %s pending message(s).", new Object[] { Integer.valueOf(acAE.size()) });
    Iterator localIterator = acAE.iterator();
    while (localIterator.hasNext()) {
      x((Message)localIterator.next());
    }
    acAE.clear();
    AppMethodBeat.o(40640);
  }
  
  private static void iVQ()
  {
    AppMethodBeat.i(40641);
    g("WxSplash.Splash", "splash done, do finally things. ", new Object[0]);
    acAK = false;
    int i = acAJ.size();
    Object localObject1 = acAJ.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      SplashActivity localSplashActivity = (SplashActivity)((Iterator)localObject1).next();
      g("WxSplash.Splash", "iterate splash activity %s.", new Object[] { localSplashActivity });
      localSplashActivity.iVW();
    }
    if (i == 0)
    {
      g("WxSplash.Splash", "no splash activity found, so we terminate hacked activities manually.", new Object[0]);
      localObject1 = acAD.iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((j)((Iterator)localObject1).next());
      }
    }
    g("WxSplash.Splash", "resend all %s pending message. ", new Object[] { Integer.valueOf(acAE.size()) });
    if (!acAL) {
      iVP();
    }
    acAN = null;
    g("WxSplash.Splash", "we need splash no more.", new Object[0]);
    long l;
    try
    {
      acAO = false;
      localObject1 = acAT;
      if (((o)localObject1).mStartTimestamp <= 0L) {
        break label278;
      }
      l = System.currentTimeMillis() - ((o)localObject1).mStartTimestamp;
      if (g.bKk)
      {
        ((o)localObject1).idkey(676L, 1L, 1L);
        ((o)localObject1).idkey(676L, 3L, l);
        AppMethodBeat.o(40641);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(40641);
    }
    localObject2.idkey(676L, 0L, 1L);
    localObject2.idkey(676L, 2L, l);
    label278:
    AppMethodBeat.o(40641);
  }
  
  /* Error */
  private static void iVR()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 465
    //   6: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 468	com/tencent/mm/splash/a:iVD	()V
    //   12: ldc 2
    //   14: monitorenter
    //   15: getstatic 89	com/tencent/mm/splash/i:acAO	Z
    //   18: ifeq +16 -> 34
    //   21: ldc 2
    //   23: monitorexit
    //   24: ldc_w 465
    //   27: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: ldc 2
    //   32: monitorexit
    //   33: return
    //   34: iconst_1
    //   35: putstatic 89	com/tencent/mm/splash/i:acAO	Z
    //   38: ldc 2
    //   40: monitorexit
    //   41: getstatic 87	com/tencent/mm/splash/i:acAM	Z
    //   44: ifne +51 -> 95
    //   47: ldc 156
    //   49: ldc_w 470
    //   52: iconst_0
    //   53: anewarray 4	java/lang/Object
    //   56: invokestatic 162	com/tencent/mm/splash/i:g	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: getstatic 170	com/tencent/mm/splash/i:acAN	Lcom/tencent/mm/splash/p;
    //   62: ifnonnull +257 -> 319
    //   65: invokestatic 262	com/tencent/mm/splash/i:iVQ	()V
    //   68: ldc_w 465
    //   71: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: goto -44 -> 30
    //   77: astore_0
    //   78: ldc 2
    //   80: monitorexit
    //   81: aload_0
    //   82: athrow
    //   83: astore_0
    //   84: ldc 2
    //   86: monitorexit
    //   87: ldc_w 465
    //   90: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_0
    //   94: athrow
    //   95: getstatic 392	com/tencent/mm/splash/g:bKk	Z
    //   98: ifeq +42 -> 140
    //   101: ldc 156
    //   103: ldc_w 472
    //   106: iconst_0
    //   107: anewarray 4	java/lang/Object
    //   110: invokestatic 162	com/tencent/mm/splash/i:g	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   113: goto -54 -> 59
    //   116: astore_0
    //   117: getstatic 96	com/tencent/mm/splash/i:acAT	Lcom/tencent/mm/splash/o;
    //   120: ldc2_w 368
    //   123: ldc2_w 473
    //   126: lconst_1
    //   127: invokevirtual 375	com/tencent/mm/splash/o:idkey	(JJJ)V
    //   130: aload_0
    //   131: ldc_w 476
    //   134: invokestatic 245	com/tencent/mm/splash/i:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   137: goto -78 -> 59
    //   140: getstatic 480	com/tencent/mm/splash/m:acBw	Ljava/util/List;
    //   143: ifnull -84 -> 59
    //   146: getstatic 480	com/tencent/mm/splash/m:acBw	Ljava/util/List;
    //   149: invokeinterface 483 1 0
    //   154: ifeq -95 -> 59
    //   157: getstatic 96	com/tencent/mm/splash/i:acAT	Lcom/tencent/mm/splash/o;
    //   160: ldc2_w 368
    //   163: ldc2_w 484
    //   166: lconst_1
    //   167: invokevirtual 375	com/tencent/mm/splash/o:idkey	(JJJ)V
    //   170: getstatic 195	com/tencent/mm/splash/m:hjc	Ljava/lang/Object;
    //   173: astore_2
    //   174: aload_2
    //   175: invokevirtual 207	java/lang/Object:getClass	()Ljava/lang/Class;
    //   178: ldc_w 487
    //   181: invokevirtual 215	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   184: astore_0
    //   185: aload_0
    //   186: iconst_1
    //   187: invokevirtual 221	java/lang/reflect/Field:setAccessible	(Z)V
    //   190: aload_0
    //   191: aload_2
    //   192: invokevirtual 225	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   195: astore_1
    //   196: aload_1
    //   197: checkcast 489	android/app/Application
    //   200: putstatic 492	com/tencent/mm/splash/m:acBv	Landroid/app/Application;
    //   203: aload_1
    //   204: astore_0
    //   205: aload_1
    //   206: ifnonnull +19 -> 225
    //   209: ldc 156
    //   211: ldc_w 494
    //   214: iconst_0
    //   215: anewarray 4	java/lang/Object
    //   218: invokestatic 162	com/tencent/mm/splash/i:g	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   221: getstatic 185	com/tencent/mm/splash/i:fgz	Landroid/app/Application;
    //   224: astore_0
    //   225: ldc_w 496
    //   228: invokestatic 500	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   231: pop
    //   232: ldc_w 502
    //   235: invokestatic 500	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   238: pop
    //   239: ldc 156
    //   241: ldc_w 504
    //   244: iconst_0
    //   245: anewarray 4	java/lang/Object
    //   248: invokestatic 162	com/tencent/mm/splash/i:g	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   251: ldc 156
    //   253: ldc_w 506
    //   256: iconst_0
    //   257: anewarray 4	java/lang/Object
    //   260: invokestatic 162	com/tencent/mm/splash/i:g	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: getstatic 510	com/tencent/mm/splash/m:acBx	Ljava/lang/reflect/Method;
    //   266: aload_2
    //   267: iconst_2
    //   268: anewarray 4	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: aload_0
    //   274: aastore
    //   275: dup
    //   276: iconst_1
    //   277: getstatic 480	com/tencent/mm/splash/m:acBw	Ljava/util/List;
    //   280: aastore
    //   281: invokevirtual 516	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   284: pop
    //   285: ldc 156
    //   287: ldc_w 518
    //   290: iconst_0
    //   291: anewarray 4	java/lang/Object
    //   294: invokestatic 162	com/tencent/mm/splash/i:g	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   297: getstatic 480	com/tencent/mm/splash/m:acBw	Ljava/util/List;
    //   300: invokeinterface 519 1 0
    //   305: goto -246 -> 59
    //   308: astore_1
    //   309: aload_1
    //   310: ldc_w 521
    //   313: invokestatic 245	com/tencent/mm/splash/i:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   316: goto -65 -> 251
    //   319: getstatic 170	com/tencent/mm/splash/i:acAN	Lcom/tencent/mm/splash/p;
    //   322: new 14	com/tencent/mm/splash/i$4
    //   325: dup
    //   326: invokespecial 522	com/tencent/mm/splash/i$4:<init>	()V
    //   329: invokeinterface 528 2 0
    //   334: ldc_w 465
    //   337: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: goto -310 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   77	5	0	localObject1	Object
    //   83	11	0	localObject2	Object
    //   116	15	0	localException	Exception
    //   184	90	0	localObject3	Object
    //   195	11	1	localObject4	Object
    //   308	2	1	localThrowable	Throwable
    //   173	94	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   3	15	77	finally
    //   24	30	77	finally
    //   41	59	77	finally
    //   59	74	77	finally
    //   84	95	77	finally
    //   95	113	77	finally
    //   117	137	77	finally
    //   140	203	77	finally
    //   209	225	77	finally
    //   251	305	77	finally
    //   309	316	77	finally
    //   319	340	77	finally
    //   15	24	83	finally
    //   34	41	83	finally
    //   41	59	116	java/lang/Exception
    //   95	113	116	java/lang/Exception
    //   140	203	116	java/lang/Exception
    //   209	225	116	java/lang/Exception
    //   251	305	116	java/lang/Exception
    //   309	316	116	java/lang/Exception
    //   225	251	308	finally
  }
  
  public static Class<? extends Activity> iVS()
  {
    return acAQ;
  }
  
  public static o iVT()
  {
    return acAT;
  }
  
  private static boolean ir(String paramString)
  {
    AppMethodBeat.i(40643);
    if (hhy != null)
    {
      boolean bool = hhy.ir(paramString);
      AppMethodBeat.o(40643);
      return bool;
    }
    AppMethodBeat.o(40643);
    return false;
  }
  
  public static void mE(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(40634);
    for (;;)
    {
      try
      {
        localObject = Util.getTopActivity(paramContext);
        if ((localObject != null) && (((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName())) && (acAF != null) && (((ComponentName)localObject).getClassName().equals(acAF)))
        {
          g("WxSplash.Splash", "it is LauncherUI", new Object[0]);
          if (i == 0)
          {
            g("WxSplash.Splash", "do nothing and return.", new Object[0]);
            AppMethodBeat.o(40634);
          }
        }
        else
        {
          if ((localObject == null) || (!((ComponentName)localObject).getPackageName().startsWith("com.excelliance"))) {
            break label316;
          }
          g("WxSplash.Splash", "it is dual open", new Object[0]);
          continue;
        }
        acAT.idkey(675L, 36L, 1L);
      }
      catch (IOException paramContext)
      {
        a(paramContext, "request fig leaf failed.");
        AppMethodBeat.o(40634);
        return;
      }
      Object localObject = a.iVB();
      u localu = new u((String)localObject);
      if (!localu.jKS()) {
        localu.jKY();
      }
      localObject = new u((String)localObject + "/main-process-blocking");
      if (((u)localObject).jKS()) {
        ((u)localObject).diJ();
      }
      if (((u)localObject).jKZ())
      {
        localObject = new Intent(paramContext, acAS);
        ((Intent)localObject).addFlags(268435456);
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/splash/Splash", "startFigLeafActivityIfNeed", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/splash/Splash", "startFigLeafActivityIfNeed", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(40634);
      return;
      label316:
      i = 0;
    }
  }
  
  private static Object mF(Context paramContext)
  {
    AppMethodBeat.i(40645);
    Object localObject = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
    ((Method)localObject).setAccessible(true);
    localObject = ((Method)localObject).invoke(null, new Object[0]);
    if (localObject != null)
    {
      AppMethodBeat.o(40645);
      return localObject;
    }
    localObject = paramContext.getClass().getField("mLoadedApk");
    ((Field)localObject).setAccessible(true);
    paramContext = ((Field)localObject).get(paramContext);
    localObject = paramContext.getClass().getDeclaredField("mActivityThread");
    ((Field)localObject).setAccessible(true);
    paramContext = ((Field)localObject).get(paramContext);
    AppMethodBeat.o(40645);
    return paramContext;
  }
  
  public static boolean q(Application paramApplication)
  {
    boolean bool;
    try
    {
      AppMethodBeat.i(40635);
      if (!acAM) {
        break label40;
      }
      g("WxSplash.Splash", "Splash has hacked before.", new Object[0]);
      bool = true;
      AppMethodBeat.o(40635);
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
            g("WxSplash.Splash", "getDefault %s", new Object[] { localObject1 });
            if (localObject1.getClass().getCanonicalName().startsWith("com.morgoo.droidplugin"))
            {
              acAT.idkey(675L, 33L, 1L);
              g("WxSplash.Splash", "found using droidplugin", new Object[0]);
            }
            if (Proxy.isProxyClass(localObject1.getClass())) {
              g("WxSplash.Splash", "found ActivityManager is a Proxy class, " + localObject1.getClass(), new Object[0]);
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
          localObject1 = mF(paramApplication);
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
          g("WxSplash.Splash", "android instrument test is running, do not need splash.", new Object[0]);
          i = 1;
          if (i == 0) {
            break label361;
          }
          bool = false;
          AppMethodBeat.o(40635);
        }
        catch (Exception paramApplication)
        {
          a(paramApplication, "splash hack error!");
          bool = false;
          AppMethodBeat.o(40635);
        }
      }
      paramApplication = finally;
    }
    return bool;
    long l = System.currentTimeMillis();
    fgz = paramApplication;
    acAT.idkey(675L, 4L, 1L);
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
      AppMethodBeat.o(40635);
      throw paramApplication;
    }
    Object localObject2;
    if (Object.class != localObject3.getClass().getSuperclass())
    {
      acAT.idkey(675L, 7L, 1L);
      g("WxSplash.Splash", "Instrumentation original's super class is not Object, maybe hacked by others. orig: %s, super: %s.", new Object[] { localObject3.getClass(), localObject3.getClass().getSuperclass() });
      paramApplication = localObject3.getClass().getCanonicalName();
      localObject2 = new RuntimeException("invalid environment for hack, " + localObject3.getClass());
      if (paramApplication.startsWith(new String[] { "com.excelliance", "com.lbe", "com.beike", "com.lody", "com.doubleagent", "com.svm", "com.morgoo" }[0]))
      {
        acAT.idkey(675L, 30L, 1L);
        g("WxSplash.Splash", "invalid environment for hack, dual open.", new Object[0]);
      }
      acAT.idkey(675L, 0L, 1L);
      AppMethodBeat.o(40635);
      throw ((Throwable)localObject2);
    }
    if (!(localObject3 instanceof l)) {
      ((Field)localObject4).set(localObject2, new l((Instrumentation)localObject3));
    }
    for (;;)
    {
      m.hjc = localObject2;
      localObject3 = localObject2.getClass().getDeclaredField("mH");
      ((Field)localObject3).setAccessible(true);
      localObject3 = (Handler)((Field)localObject3).get(localObject2);
      if (localObject3 != null) {
        break;
      }
      paramApplication = new RuntimeException("mH is null!");
      AppMethodBeat.o(40635);
      throw paramApplication;
      g("WxSplash.Splash", "instrumentation is splash hacked, why? failed before?", new Object[0]);
    }
    m.qBf = (Handler)localObject3;
    Object localObject4 = Handler.class.getDeclaredField("mCallback");
    ((Field)localObject4).setAccessible(true);
    Object localObject5 = (Handler.Callback)((Field)localObject4).get(localObject3);
    m.acBz = (Field)localObject4;
    if (localObject5 != null)
    {
      g("WxSplash.Splash", "Handler.Callback original is not null, maybe hacked by others. orig: %s", new Object[] { localObject5 });
      acAT.idkey(675L, 8L, 1L);
    }
    if ((localObject5 == null) || (!(localObject5 instanceof k)))
    {
      paramApplication = new k(paramApplication, (Handler.Callback)localObject5);
      ((Field)localObject4).setAccessible(true);
      ((Field)localObject4).set(localObject3, paramApplication);
      m.acBy = paramApplication;
      label795:
      paramApplication = new Handler();
      k.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(40621);
          i.aAs();
          i.this.removeCallbacksAndMessages(null);
          i.g("WxSplash.Splash", "verify mH callback hack, result ok.", new Object[0]);
          AppMethodBeat.o(40621);
        }
      });
      m.qBf.sendEmptyMessage(987654321);
      paramApplication.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(40622);
          if (!i.acAV)
          {
            i.g("WxSplash.Splash", "verify mH callback hack, result failed!.", new Object[0]);
            i.iVT().idkey(675L, 32L, 1L);
            i.access$100();
          }
          AppMethodBeat.o(40622);
        }
      }, 2000L);
      if ((acAU.size() <= 0) && (g.bKk)) {
        break label1090;
      }
      paramApplication = localObject2.getClass().getDeclaredMethod("installContentProviders", new Class[] { Context.class, List.class });
      paramApplication.setAccessible(true);
      m.acBx = paramApplication;
      paramApplication = localObject2.getClass().getDeclaredField("mBoundApplication");
      paramApplication.setAccessible(true);
      paramApplication = paramApplication.get(localObject2);
      m.acBu = paramApplication;
      localObject2 = paramApplication.getClass().getDeclaredField("restrictedBackupMode");
      ((Field)localObject2).setAccessible(true);
      if (!g.bKk) {
        ((Field)localObject2).set(paramApplication, Boolean.TRUE);
      }
      localObject2 = paramApplication.getClass().getDeclaredField("providers");
      ((Field)localObject2).setAccessible(true);
      m.acBw = (List)((Field)localObject2).get(paramApplication);
      localObject2 = acAU.iterator();
      label990:
      if (!((Iterator)localObject2).hasNext()) {
        break label1090;
      }
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = m.acBw.iterator();
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
      m.acBw.remove(paramApplication);
      break label990;
      g("WxSplash.Splash", "callback is splash hacked, why? failed before?", new Object[0]);
      break label795;
      label1090:
      acAM = true;
      acAK = true;
      g("WxSplash.Splash", "splash hack success.", new Object[0]);
      g("WxSplash.Splash", "we need splash. time spent %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      bool = true;
      AppMethodBeat.o(40635);
      break;
      paramApplication = null;
    }
  }
  
  public static void x(Message paramMessage)
  {
    AppMethodBeat.i(40639);
    m.qBf.sendMessage(paramMessage);
    AppMethodBeat.o(40639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.splash.i
 * JD-Core Version:    0.7.0.1
 */