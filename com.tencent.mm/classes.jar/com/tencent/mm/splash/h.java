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
import com.tencent.mm.sdk.platformtools.Util;
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
  public static final ArrayList<i> NLB;
  public static final ArrayList<Message> NLC;
  static String NLD;
  static e NLE;
  static b NLF;
  static f NLG;
  static Set<SplashActivity> NLH;
  private static boolean NLI;
  private static volatile boolean NLJ;
  private static boolean NLK;
  private static o NLL;
  private static boolean NLM;
  static c NLN;
  private static Class<? extends SplashActivity> NLO;
  private static Set<String> NLP;
  private static Class<? extends Activity> NLQ;
  private static n NLR;
  private static HashSet<String> NLS;
  private static boolean NLT;
  @SuppressLint({"HandlerLeak"})
  private static Handler NLU;
  static d dme;
  static Application gNz;
  
  static
  {
    AppMethodBeat.i(40652);
    NLB = new ArrayList();
    NLC = new ArrayList();
    NLH = new HashSet();
    NLI = false;
    NLJ = false;
    NLK = false;
    NLM = false;
    NLP = new HashSet();
    NLR = new n();
    NLS = new HashSet();
    NLT = false;
    NLU = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(40626);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 0)
        {
          h.access$200();
          AppMethodBeat.o(40626);
          return;
        }
        a.jy(h.gNz);
        a.a(new a.a()
        {
          public final void eZS()
          {
            AppMethodBeat.i(40624);
            h.c("WxSplash.Splash", "dexopt service return failed. kill self.", new Object[0]);
            h.eCp();
            AppMethodBeat.o(40624);
          }
          
          public final void gye()
          {
            AppMethodBeat.i(40623);
            h.access$200();
            AppMethodBeat.o(40623);
          }
          
          public final void gyf()
          {
            AppMethodBeat.i(40625);
            h.c("WxSplash.Splash", "dexopt service return timeout. kill self.", new Object[0]);
            h.eCp();
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
    NLH.add(paramSplashActivity);
    AppMethodBeat.o(40631);
  }
  
  public static void a(b paramb)
  {
    NLF = paramb;
  }
  
  public static void a(c paramc)
  {
    NLN = paramc;
  }
  
  public static void a(d paramd)
  {
    dme = paramd;
  }
  
  public static void a(e parame)
  {
    NLE = parame;
  }
  
  public static void a(f paramf)
  {
    NLG = paramf;
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(40644);
    if (!gh(parami.NMc))
    {
      parami.recreate();
      c("WxSplash.Splash", "do recreate for %s", new Object[] { parami.NMc });
      AppMethodBeat.o(40644);
      return;
    }
    parami.finish();
    c("WxSplash.Splash", "eat activity, %s", new Object[] { parami.NMc });
    AppMethodBeat.o(40644);
  }
  
  public static void a(o paramo)
  {
    NLL = paramo;
  }
  
  public static void a(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(40647);
    if (NLN != null) {
      NLN.a(paramThrowable, paramString);
    }
    AppMethodBeat.o(40647);
  }
  
  static void b(SplashActivity paramSplashActivity)
  {
    AppMethodBeat.i(40632);
    NLH.remove(paramSplashActivity);
    AppMethodBeat.o(40632);
  }
  
  public static String bb(Activity paramActivity)
  {
    if ((paramActivity instanceof i)) {
      return ((i)paramActivity).NMc;
    }
    return "";
  }
  
  public static void bb(Class<? extends SplashActivity> paramClass)
  {
    NLO = paramClass;
  }
  
  public static void bc(Class<? extends Activity> paramClass)
  {
    NLQ = paramClass;
  }
  
  public static void bik(String paramString)
  {
    AppMethodBeat.i(40633);
    NLS.add(paramString);
    AppMethodBeat.o(40633);
  }
  
  public static void bil(String paramString)
  {
    NLD = paramString;
  }
  
  public static boolean bim(String paramString)
  {
    AppMethodBeat.i(240221);
    boolean bool = NLP.contains(paramString);
    c("WxSplash.Splash", "ignore activity %s ?, %s", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(240221);
    return bool;
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(40646);
    if (NLN != null) {
      NLN.c(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(40646);
  }
  
  public static void eCp()
  {
    AppMethodBeat.i(40637);
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/splash/Splash", "killSelf", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/splash/Splash", "killSelf", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(40637);
  }
  
  private static boolean gh(String paramString)
  {
    AppMethodBeat.i(40643);
    if (dme != null)
    {
      boolean bool = dme.gh(paramString);
      AppMethodBeat.o(40643);
      return bool;
    }
    AppMethodBeat.o(40643);
    return false;
  }
  
  public static void gyh()
  {
    boolean bool = true;
    AppMethodBeat.i(40636);
    if (NLK) {
      try
      {
        Handler.Callback localCallback = (Handler.Callback)l.NMv.get(l.kHW);
        if (localCallback == l.NMu) {}
        for (;;)
        {
          c("WxSplash.Splash", "double check, callback %s %s", new Object[] { Boolean.valueOf(bool), localCallback });
          localObject = l.NMu;
          if (localCallback != localObject) {
            break;
          }
          AppMethodBeat.o(40636);
          return;
          bool = false;
        }
        c("WxSplash.Splash", "double check found problem!", new Object[0]);
        Object localObject = l.NMv;
        l.NMu.AFR = localCallback;
        ((Field)localObject).setAccessible(true);
        ((Field)localObject).set(l.kHW, l.NMu);
        NLR.idkey(675L, 31L, 1L);
        l.kHW.sendEmptyMessage(987654321);
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
  
  public static boolean gyi()
  {
    return true;
  }
  
  public static boolean gyj()
  {
    return NLI;
  }
  
  public static boolean gyk()
  {
    return NLJ;
  }
  
  public static void gyl()
  {
    int i = 0;
    AppMethodBeat.i(40638);
    if (!g.zF)
    {
      boolean bool = a.jw(gNz);
      Handler localHandler = NLU;
      if (bool) {
        i = 1;
      }
      localHandler.sendEmptyMessage(i);
      AppMethodBeat.o(40638);
      return;
    }
    NLU.sendEmptyMessage(0);
    AppMethodBeat.o(40638);
  }
  
  private static void gym()
  {
    AppMethodBeat.i(40640);
    c("WxSplash.Splash", "Gonna replay %s pending message(s).", new Object[] { Integer.valueOf(NLC.size()) });
    Iterator localIterator = NLC.iterator();
    while (localIterator.hasNext()) {
      p((Message)localIterator.next());
    }
    NLC.clear();
    AppMethodBeat.o(40640);
  }
  
  private static void gyn()
  {
    AppMethodBeat.i(40641);
    c("WxSplash.Splash", "splash done, do finally things. ", new Object[0]);
    NLI = false;
    int i = NLH.size();
    Object localObject1 = NLH.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      SplashActivity localSplashActivity = (SplashActivity)((Iterator)localObject1).next();
      c("WxSplash.Splash", "iterate splash activity %s.", new Object[] { localSplashActivity });
      localSplashActivity.gyt();
    }
    if (i == 0)
    {
      c("WxSplash.Splash", "no splash activity found, so we terminate hacked activities manually.", new Object[0]);
      localObject1 = NLB.iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((i)((Iterator)localObject1).next());
      }
    }
    c("WxSplash.Splash", "resend all %s pending message. ", new Object[] { Integer.valueOf(NLC.size()) });
    if (!NLJ) {
      gym();
    }
    NLL = null;
    c("WxSplash.Splash", "we need splash no more.", new Object[0]);
    long l;
    try
    {
      NLM = false;
      localObject1 = NLR;
      if (((n)localObject1).mStartTimestamp <= 0L) {
        break label278;
      }
      l = System.currentTimeMillis() - ((n)localObject1).mStartTimestamp;
      if (g.zF)
      {
        ((n)localObject1).idkey(676L, 1L, 1L);
        ((n)localObject1).idkey(676L, 3L, l);
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
  private static void gyo()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 473
    //   6: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 193	com/tencent/mm/splash/h:gNz	Landroid/app/Application;
    //   12: invokestatic 477	com/tencent/mm/splash/a:jx	(Landroid/content/Context;)V
    //   15: ldc 2
    //   17: monitorenter
    //   18: getstatic 92	com/tencent/mm/splash/h:NLM	Z
    //   21: ifeq +16 -> 37
    //   24: ldc 2
    //   26: monitorexit
    //   27: ldc_w 473
    //   30: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: ldc 2
    //   35: monitorexit
    //   36: return
    //   37: iconst_1
    //   38: putstatic 92	com/tencent/mm/splash/h:NLM	Z
    //   41: ldc 2
    //   43: monitorexit
    //   44: getstatic 90	com/tencent/mm/splash/h:NLK	Z
    //   47: ifne +51 -> 98
    //   50: ldc 166
    //   52: ldc_w 479
    //   55: iconst_0
    //   56: anewarray 4	java/lang/Object
    //   59: invokestatic 172	com/tencent/mm/splash/h:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: getstatic 180	com/tencent/mm/splash/h:NLL	Lcom/tencent/mm/splash/o;
    //   65: ifnonnull +257 -> 322
    //   68: invokestatic 126	com/tencent/mm/splash/h:gyn	()V
    //   71: ldc_w 473
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
    //   90: ldc_w 473
    //   93: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_0
    //   97: athrow
    //   98: getstatic 397	com/tencent/mm/splash/g:zF	Z
    //   101: ifeq +42 -> 143
    //   104: ldc 166
    //   106: ldc_w 481
    //   109: iconst_0
    //   110: anewarray 4	java/lang/Object
    //   113: invokestatic 172	com/tencent/mm/splash/h:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: goto -54 -> 62
    //   119: astore_0
    //   120: getstatic 99	com/tencent/mm/splash/h:NLR	Lcom/tencent/mm/splash/n;
    //   123: ldc2_w 373
    //   126: ldc2_w 482
    //   129: lconst_1
    //   130: invokevirtual 380	com/tencent/mm/splash/n:idkey	(JJJ)V
    //   133: aload_0
    //   134: ldc_w 485
    //   137: invokestatic 253	com/tencent/mm/splash/h:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   140: goto -78 -> 62
    //   143: getstatic 489	com/tencent/mm/splash/l:NMs	Ljava/util/List;
    //   146: ifnull -84 -> 62
    //   149: getstatic 489	com/tencent/mm/splash/l:NMs	Ljava/util/List;
    //   152: invokeinterface 492 1 0
    //   157: ifeq -95 -> 62
    //   160: getstatic 99	com/tencent/mm/splash/h:NLR	Lcom/tencent/mm/splash/n;
    //   163: ldc2_w 373
    //   166: ldc2_w 493
    //   169: lconst_1
    //   170: invokevirtual 380	com/tencent/mm/splash/n:idkey	(JJJ)V
    //   173: getstatic 203	com/tencent/mm/splash/l:dmH	Ljava/lang/Object;
    //   176: astore_2
    //   177: aload_2
    //   178: invokevirtual 215	java/lang/Object:getClass	()Ljava/lang/Class;
    //   181: ldc_w 496
    //   184: invokevirtual 223	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   187: astore_0
    //   188: aload_0
    //   189: iconst_1
    //   190: invokevirtual 229	java/lang/reflect/Field:setAccessible	(Z)V
    //   193: aload_0
    //   194: aload_2
    //   195: invokevirtual 233	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   198: astore_1
    //   199: aload_1
    //   200: checkcast 498	android/app/Application
    //   203: putstatic 501	com/tencent/mm/splash/l:NMr	Landroid/app/Application;
    //   206: aload_1
    //   207: astore_0
    //   208: aload_1
    //   209: ifnonnull +19 -> 228
    //   212: ldc 166
    //   214: ldc_w 503
    //   217: iconst_0
    //   218: anewarray 4	java/lang/Object
    //   221: invokestatic 172	com/tencent/mm/splash/h:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: getstatic 193	com/tencent/mm/splash/h:gNz	Landroid/app/Application;
    //   227: astore_0
    //   228: ldc_w 505
    //   231: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   234: pop
    //   235: ldc_w 511
    //   238: invokestatic 509	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   241: pop
    //   242: ldc 166
    //   244: ldc_w 513
    //   247: iconst_0
    //   248: anewarray 4	java/lang/Object
    //   251: invokestatic 172	com/tencent/mm/splash/h:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   254: ldc 166
    //   256: ldc_w 515
    //   259: iconst_0
    //   260: anewarray 4	java/lang/Object
    //   263: invokestatic 172	com/tencent/mm/splash/h:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: getstatic 519	com/tencent/mm/splash/l:NMt	Ljava/lang/reflect/Method;
    //   269: aload_2
    //   270: iconst_2
    //   271: anewarray 4	java/lang/Object
    //   274: dup
    //   275: iconst_0
    //   276: aload_0
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: getstatic 489	com/tencent/mm/splash/l:NMs	Ljava/util/List;
    //   283: aastore
    //   284: invokevirtual 525	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   287: pop
    //   288: ldc 166
    //   290: ldc_w 527
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 172	com/tencent/mm/splash/h:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: getstatic 489	com/tencent/mm/splash/l:NMs	Ljava/util/List;
    //   303: invokeinterface 528 1 0
    //   308: goto -246 -> 62
    //   311: astore_1
    //   312: aload_1
    //   313: ldc_w 530
    //   316: invokestatic 253	com/tencent/mm/splash/h:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   319: goto -65 -> 254
    //   322: getstatic 180	com/tencent/mm/splash/h:NLL	Lcom/tencent/mm/splash/o;
    //   325: new 14	com/tencent/mm/splash/h$4
    //   328: dup
    //   329: invokespecial 531	com/tencent/mm/splash/h$4:<init>	()V
    //   332: invokeinterface 537 2 0
    //   337: ldc_w 473
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
  
  public static Class<? extends Activity> gyp()
  {
    return NLO;
  }
  
  public static n gyq()
  {
    return NLR;
  }
  
  public static void jC(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(40634);
    for (;;)
    {
      try
      {
        localObject = Util.getTopActivity(paramContext);
        if ((localObject != null) && (((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName())) && (NLD != null) && (((ComponentName)localObject).getClassName().equals(NLD)))
        {
          c("WxSplash.Splash", "it is LauncherUI", new Object[0]);
          if (i == 0)
          {
            c("WxSplash.Splash", "do nothing and return.", new Object[0]);
            AppMethodBeat.o(40634);
          }
        }
        else
        {
          if ((localObject == null) || (!((ComponentName)localObject).getPackageName().startsWith("com.excelliance"))) {
            break label316;
          }
          c("WxSplash.Splash", "it is dual open", new Object[0]);
          continue;
        }
        NLR.idkey(675L, 36L, 1L);
      }
      catch (IOException paramContext)
      {
        a(paramContext, "request fig leaf failed.");
        AppMethodBeat.o(40634);
        return;
      }
      Object localObject = a.gya();
      com.tencent.mm.vfs.o localo = new com.tencent.mm.vfs.o((String)localObject);
      if (!localo.exists()) {
        localo.mkdirs();
      }
      localObject = new com.tencent.mm.vfs.o((String)localObject + "/main-process-blocking");
      if (((com.tencent.mm.vfs.o)localObject).exists()) {
        ((com.tencent.mm.vfs.o)localObject).delete();
      }
      if (((com.tencent.mm.vfs.o)localObject).createNewFile())
      {
        localObject = new Intent(paramContext, NLQ);
        ((Intent)localObject).addFlags(268435456);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/splash/Splash", "startFigLeafActivityIfNeed", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/splash/Splash", "startFigLeafActivityIfNeed", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(40634);
      return;
      label316:
      i = 0;
    }
  }
  
  private static Object jD(Context paramContext)
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
  
  public static boolean o(Application paramApplication)
  {
    boolean bool;
    try
    {
      AppMethodBeat.i(40635);
      if (!NLK) {
        break label40;
      }
      c("WxSplash.Splash", "Splash has hacked before.", new Object[0]);
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
            c("WxSplash.Splash", "getDefault %s", new Object[] { localObject1 });
            if (localObject1.getClass().getCanonicalName().startsWith("com.morgoo.droidplugin"))
            {
              NLR.idkey(675L, 33L, 1L);
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
          localObject1 = jD(paramApplication);
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
    gNz = paramApplication;
    NLR.idkey(675L, 4L, 1L);
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
      NLR.idkey(675L, 7L, 1L);
      c("WxSplash.Splash", "Instrumentation original's super class is not Object, maybe hacked by others. orig: %s, super: %s.", new Object[] { localObject3.getClass(), localObject3.getClass().getSuperclass() });
      paramApplication = localObject3.getClass().getCanonicalName();
      localObject2 = new RuntimeException("invalid environment for hack, " + localObject3.getClass());
      if (paramApplication.startsWith(new String[] { "com.excelliance", "com.lbe", "com.beike", "com.lody", "com.doubleagent", "com.svm", "com.morgoo" }[0]))
      {
        NLR.idkey(675L, 30L, 1L);
        c("WxSplash.Splash", "invalid environment for hack, dual open.", new Object[0]);
      }
      NLR.idkey(675L, 0L, 1L);
      AppMethodBeat.o(40635);
      throw ((Throwable)localObject2);
    }
    if (!(localObject3 instanceof k)) {
      ((Field)localObject4).set(localObject2, new k((Instrumentation)localObject3));
    }
    for (;;)
    {
      l.dmH = localObject2;
      localObject3 = localObject2.getClass().getDeclaredField("mH");
      ((Field)localObject3).setAccessible(true);
      localObject3 = (Handler)((Field)localObject3).get(localObject2);
      if (localObject3 != null) {
        break;
      }
      paramApplication = new RuntimeException("mH is null!");
      AppMethodBeat.o(40635);
      throw paramApplication;
      c("WxSplash.Splash", "instrumentation is splash hacked, why? failed before?", new Object[0]);
    }
    l.kHW = (Handler)localObject3;
    Object localObject4 = Handler.class.getDeclaredField("mCallback");
    ((Field)localObject4).setAccessible(true);
    Object localObject5 = (Handler.Callback)((Field)localObject4).get(localObject3);
    l.NMv = (Field)localObject4;
    if (localObject5 != null)
    {
      c("WxSplash.Splash", "Handler.Callback original is not null, maybe hacked by others. orig: %s", new Object[] { localObject5 });
      NLR.idkey(675L, 8L, 1L);
    }
    if ((localObject5 == null) || (!(localObject5 instanceof j)))
    {
      paramApplication = new j(paramApplication, (Handler.Callback)localObject5);
      ((Field)localObject4).setAccessible(true);
      ((Field)localObject4).set(localObject3, paramApplication);
      l.NMu = paramApplication;
      label795:
      paramApplication = new Handler();
      j.aH(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(40621);
          h.TT();
          this.NLV.removeCallbacksAndMessages(null);
          h.c("WxSplash.Splash", "verify mH callback hack, result ok.", new Object[0]);
          AppMethodBeat.o(40621);
        }
      });
      l.kHW.sendEmptyMessage(987654321);
      paramApplication.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(40622);
          if (!h.NLT)
          {
            h.c("WxSplash.Splash", "verify mH callback hack, result failed!.", new Object[0]);
            h.gyq().idkey(675L, 32L, 1L);
            h.access$100();
          }
          AppMethodBeat.o(40622);
        }
      }, 2000L);
      if ((NLS.size() <= 0) && (g.zF)) {
        break label1090;
      }
      paramApplication = localObject2.getClass().getDeclaredMethod("installContentProviders", new Class[] { Context.class, List.class });
      paramApplication.setAccessible(true);
      l.NMt = paramApplication;
      paramApplication = localObject2.getClass().getDeclaredField("mBoundApplication");
      paramApplication.setAccessible(true);
      paramApplication = paramApplication.get(localObject2);
      l.NMq = paramApplication;
      localObject2 = paramApplication.getClass().getDeclaredField("restrictedBackupMode");
      ((Field)localObject2).setAccessible(true);
      if (!g.zF) {
        ((Field)localObject2).set(paramApplication, Boolean.TRUE);
      }
      localObject2 = paramApplication.getClass().getDeclaredField("providers");
      ((Field)localObject2).setAccessible(true);
      l.NMs = (List)((Field)localObject2).get(paramApplication);
      localObject2 = NLS.iterator();
      label990:
      if (!((Iterator)localObject2).hasNext()) {
        break label1090;
      }
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = l.NMs.iterator();
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
      l.NMs.remove(paramApplication);
      break label990;
      c("WxSplash.Splash", "callback is splash hacked, why? failed before?", new Object[0]);
      break label795;
      label1090:
      NLK = true;
      NLI = true;
      c("WxSplash.Splash", "splash hack success.", new Object[0]);
      c("WxSplash.Splash", "we need splash. time spent %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      bool = true;
      AppMethodBeat.o(40635);
      break;
      paramApplication = null;
    }
  }
  
  public static void p(Message paramMessage)
  {
    AppMethodBeat.i(40639);
    l.kHW.sendMessage(paramMessage);
    AppMethodBeat.o(40639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.h
 * JD-Core Version:    0.7.0.1
 */