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
import com.tencent.mm.sdk.platformtools.bt;
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
  static Application HUP;
  static e IkA;
  static b IkB;
  static f IkC;
  static Set<SplashActivity> IkD;
  private static boolean IkE;
  private static volatile boolean IkF;
  private static boolean IkG;
  private static o IkH;
  private static boolean IkI;
  static c IkJ;
  private static Class<? extends SplashActivity> IkK;
  private static Set<String> IkL;
  private static Class<? extends Activity> IkM;
  private static n IkN;
  private static HashSet<String> IkO;
  private static boolean IkP;
  @SuppressLint({"HandlerLeak"})
  private static Handler IkQ;
  public static final ArrayList<i> Ikx;
  public static final ArrayList<Message> Iky;
  static String Ikz;
  static d cUN;
  
  static
  {
    AppMethodBeat.i(40652);
    Ikx = new ArrayList();
    Iky = new ArrayList();
    IkD = new HashSet();
    IkE = false;
    IkF = false;
    IkG = false;
    IkI = false;
    IkL = new HashSet();
    IkN = new n();
    IkO = new HashSet();
    IkP = false;
    IkQ = new Handler(Looper.getMainLooper())
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
        a.jw(h.HUP);
        a.a(new a.a()
        {
          public final void dTk()
          {
            AppMethodBeat.i(40624);
            h.b("WxSplash.Splash", "dexopt service return failed. kill self.", new Object[0]);
            h.dyJ();
            AppMethodBeat.o(40624);
          }
          
          public final void fnl()
          {
            AppMethodBeat.i(40623);
            h.access$200();
            AppMethodBeat.o(40623);
          }
          
          public final void fnm()
          {
            AppMethodBeat.i(40625);
            h.b("WxSplash.Splash", "dexopt service return timeout. kill self.", new Object[0]);
            h.dyJ();
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
    IkD.add(paramSplashActivity);
    AppMethodBeat.o(40631);
  }
  
  public static void a(b paramb)
  {
    IkB = paramb;
  }
  
  public static void a(c paramc)
  {
    IkJ = paramc;
  }
  
  public static void a(d paramd)
  {
    cUN = paramd;
  }
  
  public static void a(e parame)
  {
    IkA = parame;
  }
  
  public static void a(f paramf)
  {
    IkC = paramf;
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(40644);
    if (!fo(parami.IkY))
    {
      parami.recreate();
      b("WxSplash.Splash", "do recreate for %s", new Object[] { parami.IkY });
      AppMethodBeat.o(40644);
      return;
    }
    parami.finish();
    b("WxSplash.Splash", "eat activity, %s", new Object[] { parami.IkY });
    AppMethodBeat.o(40644);
  }
  
  public static void a(o paramo)
  {
    IkH = paramo;
  }
  
  public static void a(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(40647);
    if (IkJ != null) {
      IkJ.a(paramThrowable, paramString);
    }
    AppMethodBeat.o(40647);
  }
  
  public static void aRT(String paramString)
  {
    AppMethodBeat.i(40633);
    IkO.add(paramString);
    AppMethodBeat.o(40633);
  }
  
  public static void aRU(String paramString)
  {
    Ikz = paramString;
  }
  
  public static boolean aRV(String paramString)
  {
    AppMethodBeat.i(194918);
    boolean bool = IkL.contains(paramString);
    b("WxSplash.Splash", "ignore activity %s ?, %s", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(194918);
    return bool;
  }
  
  public static String aW(Activity paramActivity)
  {
    if ((paramActivity instanceof i)) {
      return ((i)paramActivity).IkY;
    }
    return "";
  }
  
  static void b(SplashActivity paramSplashActivity)
  {
    AppMethodBeat.i(40632);
    IkD.remove(paramSplashActivity);
    AppMethodBeat.o(40632);
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(40646);
    if (IkJ != null) {
      IkJ.b(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(40646);
  }
  
  public static void bb(Class<? extends SplashActivity> paramClass)
  {
    IkK = paramClass;
  }
  
  public static void bc(Class<? extends Activity> paramClass)
  {
    IkM = paramClass;
  }
  
  public static void dyJ()
  {
    AppMethodBeat.i(40637);
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/splash/Splash", "killSelf", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)locala.mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/splash/Splash", "killSelf", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(40637);
  }
  
  public static void fno()
  {
    boolean bool = true;
    AppMethodBeat.i(40636);
    if (IkG) {
      try
      {
        Handler.Callback localCallback = (Handler.Callback)l.Ils.get(l.Ilm);
        if (localCallback == l.Ilr) {}
        for (;;)
        {
          b("WxSplash.Splash", "double check, callback %s %s", new Object[] { Boolean.valueOf(bool), localCallback });
          localObject = l.Ilr;
          if (localCallback != localObject) {
            break;
          }
          AppMethodBeat.o(40636);
          return;
          bool = false;
        }
        b("WxSplash.Splash", "double check found problem!", new Object[0]);
        Object localObject = l.Ils;
        l.Ilr.wuG = localCallback;
        ((Field)localObject).setAccessible(true);
        ((Field)localObject).set(l.Ilm, l.Ilr);
        IkN.idkey(675L, 31L, 1L);
        l.Ilm.sendEmptyMessage(987654321);
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
  
  public static boolean fnp()
  {
    return true;
  }
  
  public static boolean fnq()
  {
    return IkE;
  }
  
  public static boolean fnr()
  {
    return IkF;
  }
  
  public static void fns()
  {
    int i = 0;
    AppMethodBeat.i(40638);
    if (!g.zz)
    {
      boolean bool = a.ju(HUP);
      Handler localHandler = IkQ;
      if (bool) {
        i = 1;
      }
      localHandler.sendEmptyMessage(i);
      AppMethodBeat.o(40638);
      return;
    }
    IkQ.sendEmptyMessage(0);
    AppMethodBeat.o(40638);
  }
  
  private static void fnt()
  {
    AppMethodBeat.i(40640);
    b("WxSplash.Splash", "Gonna replay %s pending message(s).", new Object[] { Integer.valueOf(Iky.size()) });
    Iterator localIterator = Iky.iterator();
    while (localIterator.hasNext()) {
      t((Message)localIterator.next());
    }
    Iky.clear();
    AppMethodBeat.o(40640);
  }
  
  private static void fnu()
  {
    AppMethodBeat.i(40641);
    b("WxSplash.Splash", "splash done, do finally things. ", new Object[0]);
    IkE = false;
    int i = IkD.size();
    Object localObject1 = IkD.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      SplashActivity localSplashActivity = (SplashActivity)((Iterator)localObject1).next();
      b("WxSplash.Splash", "iterate splash activity %s.", new Object[] { localSplashActivity });
      localSplashActivity.fnA();
    }
    if (i == 0)
    {
      b("WxSplash.Splash", "no splash activity found, so we terminate hacked activities manually.", new Object[0]);
      localObject1 = Ikx.iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((i)((Iterator)localObject1).next());
      }
    }
    b("WxSplash.Splash", "resend all %s pending message. ", new Object[] { Integer.valueOf(Iky.size()) });
    if (!IkF) {
      fnt();
    }
    IkH = null;
    b("WxSplash.Splash", "we need splash no more.", new Object[0]);
    long l;
    try
    {
      IkI = false;
      localObject1 = IkN;
      if (((n)localObject1).mStartTimestamp <= 0L) {
        break label278;
      }
      l = System.currentTimeMillis() - ((n)localObject1).mStartTimestamp;
      if (g.zz)
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
  private static void fnv()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 469
    //   6: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 217	com/tencent/mm/splash/h:HUP	Landroid/app/Application;
    //   12: invokestatic 473	com/tencent/mm/splash/a:jv	(Landroid/content/Context;)V
    //   15: ldc 2
    //   17: monitorenter
    //   18: getstatic 92	com/tencent/mm/splash/h:IkI	Z
    //   21: ifeq +16 -> 37
    //   24: ldc 2
    //   26: monitorexit
    //   27: ldc_w 469
    //   30: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: ldc 2
    //   35: monitorexit
    //   36: return
    //   37: iconst_1
    //   38: putstatic 92	com/tencent/mm/splash/h:IkI	Z
    //   41: ldc 2
    //   43: monitorexit
    //   44: getstatic 90	com/tencent/mm/splash/h:IkG	Z
    //   47: ifne +51 -> 98
    //   50: ldc 166
    //   52: ldc_w 475
    //   55: iconst_0
    //   56: anewarray 4	java/lang/Object
    //   59: invokestatic 172	com/tencent/mm/splash/h:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: getstatic 180	com/tencent/mm/splash/h:IkH	Lcom/tencent/mm/splash/o;
    //   65: ifnonnull +257 -> 322
    //   68: invokestatic 126	com/tencent/mm/splash/h:fnu	()V
    //   71: ldc_w 469
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
    //   90: ldc_w 469
    //   93: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_0
    //   97: athrow
    //   98: getstatic 393	com/tencent/mm/splash/g:zz	Z
    //   101: ifeq +42 -> 143
    //   104: ldc 166
    //   106: ldc_w 477
    //   109: iconst_0
    //   110: anewarray 4	java/lang/Object
    //   113: invokestatic 172	com/tencent/mm/splash/h:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: goto -54 -> 62
    //   119: astore_0
    //   120: getstatic 99	com/tencent/mm/splash/h:IkN	Lcom/tencent/mm/splash/n;
    //   123: ldc2_w 369
    //   126: ldc2_w 478
    //   129: lconst_1
    //   130: invokevirtual 376	com/tencent/mm/splash/n:idkey	(JJJ)V
    //   133: aload_0
    //   134: ldc_w 481
    //   137: invokestatic 271	com/tencent/mm/splash/h:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   140: goto -78 -> 62
    //   143: getstatic 485	com/tencent/mm/splash/l:Ilp	Ljava/util/List;
    //   146: ifnull -84 -> 62
    //   149: getstatic 485	com/tencent/mm/splash/l:Ilp	Ljava/util/List;
    //   152: invokeinterface 488 1 0
    //   157: ifeq -95 -> 62
    //   160: getstatic 99	com/tencent/mm/splash/h:IkN	Lcom/tencent/mm/splash/n;
    //   163: ldc2_w 369
    //   166: ldc2_w 489
    //   169: lconst_1
    //   170: invokevirtual 376	com/tencent/mm/splash/n:idkey	(JJJ)V
    //   173: getstatic 227	com/tencent/mm/splash/l:cVn	Ljava/lang/Object;
    //   176: astore_2
    //   177: aload_2
    //   178: invokevirtual 233	java/lang/Object:getClass	()Ljava/lang/Class;
    //   181: ldc_w 492
    //   184: invokevirtual 241	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   187: astore_0
    //   188: aload_0
    //   189: iconst_1
    //   190: invokevirtual 247	java/lang/reflect/Field:setAccessible	(Z)V
    //   193: aload_0
    //   194: aload_2
    //   195: invokevirtual 251	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   198: astore_1
    //   199: aload_1
    //   200: checkcast 494	android/app/Application
    //   203: putstatic 497	com/tencent/mm/splash/l:Ilo	Landroid/app/Application;
    //   206: aload_1
    //   207: astore_0
    //   208: aload_1
    //   209: ifnonnull +19 -> 228
    //   212: ldc 166
    //   214: ldc_w 499
    //   217: iconst_0
    //   218: anewarray 4	java/lang/Object
    //   221: invokestatic 172	com/tencent/mm/splash/h:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: getstatic 217	com/tencent/mm/splash/h:HUP	Landroid/app/Application;
    //   227: astore_0
    //   228: ldc_w 501
    //   231: invokestatic 505	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   234: pop
    //   235: ldc_w 507
    //   238: invokestatic 505	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   241: pop
    //   242: ldc 166
    //   244: ldc_w 509
    //   247: iconst_0
    //   248: anewarray 4	java/lang/Object
    //   251: invokestatic 172	com/tencent/mm/splash/h:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   254: ldc 166
    //   256: ldc_w 511
    //   259: iconst_0
    //   260: anewarray 4	java/lang/Object
    //   263: invokestatic 172	com/tencent/mm/splash/h:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: getstatic 515	com/tencent/mm/splash/l:Ilq	Ljava/lang/reflect/Method;
    //   269: aload_2
    //   270: iconst_2
    //   271: anewarray 4	java/lang/Object
    //   274: dup
    //   275: iconst_0
    //   276: aload_0
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: getstatic 485	com/tencent/mm/splash/l:Ilp	Ljava/util/List;
    //   283: aastore
    //   284: invokevirtual 521	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   287: pop
    //   288: ldc 166
    //   290: ldc_w 523
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 172	com/tencent/mm/splash/h:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: getstatic 485	com/tencent/mm/splash/l:Ilp	Ljava/util/List;
    //   303: invokeinterface 524 1 0
    //   308: goto -246 -> 62
    //   311: astore_1
    //   312: aload_1
    //   313: ldc_w 526
    //   316: invokestatic 271	com/tencent/mm/splash/h:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   319: goto -65 -> 254
    //   322: getstatic 180	com/tencent/mm/splash/h:IkH	Lcom/tencent/mm/splash/o;
    //   325: new 14	com/tencent/mm/splash/h$4
    //   328: dup
    //   329: invokespecial 527	com/tencent/mm/splash/h$4:<init>	()V
    //   332: invokeinterface 533 2 0
    //   337: ldc_w 469
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
  
  public static Class<? extends Activity> fnw()
  {
    return IkK;
  }
  
  public static n fnx()
  {
    return IkN;
  }
  
  private static boolean fo(String paramString)
  {
    AppMethodBeat.i(40643);
    if (cUN != null)
    {
      boolean bool = cUN.fo(paramString);
      AppMethodBeat.o(40643);
      return bool;
    }
    AppMethodBeat.o(40643);
    return false;
  }
  
  private static Object jA(Context paramContext)
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
  
  public static void jz(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(40634);
    for (;;)
    {
      try
      {
        localObject = bt.jm(paramContext);
        if ((localObject != null) && (((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName())) && (Ikz != null) && (((ComponentName)localObject).getClassName().equals(Ikz)))
        {
          b("WxSplash.Splash", "it is LauncherUI", new Object[0]);
          if (i == 0)
          {
            b("WxSplash.Splash", "do nothing and return.", new Object[0]);
            AppMethodBeat.o(40634);
          }
        }
        else
        {
          if ((localObject == null) || (!((ComponentName)localObject).getPackageName().startsWith("com.excelliance"))) {
            break label316;
          }
          b("WxSplash.Splash", "it is dual open", new Object[0]);
          continue;
        }
        IkN.idkey(675L, 36L, 1L);
      }
      catch (IOException paramContext)
      {
        a(paramContext, "request fig leaf failed.");
        AppMethodBeat.o(40634);
        return;
      }
      Object localObject = a.fnh();
      com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e((String)localObject);
      if (!locale.exists()) {
        locale.mkdirs();
      }
      localObject = new com.tencent.mm.vfs.e((String)localObject + "/main-process-blocking");
      if (((com.tencent.mm.vfs.e)localObject).exists()) {
        ((com.tencent.mm.vfs.e)localObject).delete();
      }
      if (((com.tencent.mm.vfs.e)localObject).createNewFile())
      {
        localObject = new Intent(paramContext, IkM);
        ((Intent)localObject).addFlags(268435456);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/splash/Splash", "startFigLeafActivityIfNeed", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/splash/Splash", "startFigLeafActivityIfNeed", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(40634);
      return;
      label316:
      i = 0;
    }
  }
  
  public static boolean o(Application paramApplication)
  {
    boolean bool;
    try
    {
      AppMethodBeat.i(40635);
      if (!IkG) {
        break label40;
      }
      b("WxSplash.Splash", "Splash has hacked before.", new Object[0]);
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
            b("WxSplash.Splash", "getDefault %s", new Object[] { localObject1 });
            if (localObject1.getClass().getCanonicalName().startsWith("com.morgoo.droidplugin"))
            {
              IkN.idkey(675L, 33L, 1L);
              b("WxSplash.Splash", "found using droidplugin", new Object[0]);
            }
            if (Proxy.isProxyClass(localObject1.getClass())) {
              b("WxSplash.Splash", "found ActivityManager is a Proxy class, " + localObject1.getClass(), new Object[0]);
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
          localObject1 = jA(paramApplication);
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
          b("WxSplash.Splash", "android instrument test is running, do not need splash.", new Object[0]);
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
    HUP = paramApplication;
    IkN.idkey(675L, 4L, 1L);
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
      IkN.idkey(675L, 7L, 1L);
      b("WxSplash.Splash", "Instrumentation original's super class is not Object, maybe hacked by others. orig: %s, super: %s.", new Object[] { localObject3.getClass(), localObject3.getClass().getSuperclass() });
      paramApplication = localObject3.getClass().getCanonicalName();
      localObject2 = new RuntimeException("invalid environment for hack, " + localObject3.getClass());
      if (paramApplication.startsWith(new String[] { "com.excelliance", "com.lbe", "com.beike", "com.lody", "com.doubleagent", "com.svm", "com.morgoo" }[0]))
      {
        IkN.idkey(675L, 30L, 1L);
        b("WxSplash.Splash", "invalid environment for hack, dual open.", new Object[0]);
      }
      IkN.idkey(675L, 0L, 1L);
      AppMethodBeat.o(40635);
      throw ((Throwable)localObject2);
    }
    if (!(localObject3 instanceof k)) {
      ((Field)localObject4).set(localObject2, new k((Instrumentation)localObject3));
    }
    for (;;)
    {
      l.cVn = localObject2;
      localObject3 = localObject2.getClass().getDeclaredField("mH");
      ((Field)localObject3).setAccessible(true);
      localObject3 = (Handler)((Field)localObject3).get(localObject2);
      if (localObject3 != null) {
        break;
      }
      paramApplication = new RuntimeException("mH is null!");
      AppMethodBeat.o(40635);
      throw paramApplication;
      b("WxSplash.Splash", "instrumentation is splash hacked, why? failed before?", new Object[0]);
    }
    l.Ilm = (Handler)localObject3;
    Object localObject4 = Handler.class.getDeclaredField("mCallback");
    ((Field)localObject4).setAccessible(true);
    Object localObject5 = (Handler.Callback)((Field)localObject4).get(localObject3);
    l.Ils = (Field)localObject4;
    if (localObject5 != null)
    {
      b("WxSplash.Splash", "Handler.Callback original is not null, maybe hacked by others. orig: %s", new Object[] { localObject5 });
      IkN.idkey(675L, 8L, 1L);
    }
    if ((localObject5 == null) || (!(localObject5 instanceof j)))
    {
      paramApplication = new j(paramApplication, (Handler.Callback)localObject5);
      ((Field)localObject4).setAccessible(true);
      ((Field)localObject4).set(localObject3, paramApplication);
      l.Ilr = paramApplication;
      label796:
      paramApplication = new Handler();
      j.aE(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(40621);
          h.Jy();
          this.IkR.removeCallbacksAndMessages(null);
          h.b("WxSplash.Splash", "verify mH callback hack, result ok.", new Object[0]);
          AppMethodBeat.o(40621);
        }
      });
      l.Ilm.sendEmptyMessage(987654321);
      paramApplication.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(40622);
          if (!h.IkP)
          {
            h.b("WxSplash.Splash", "verify mH callback hack, result failed!.", new Object[0]);
            h.fnx().idkey(675L, 32L, 1L);
            h.access$100();
          }
          AppMethodBeat.o(40622);
        }
      }, 2000L);
      if ((IkO.size() <= 0) && (g.zz)) {
        break label1091;
      }
      paramApplication = localObject2.getClass().getDeclaredMethod("installContentProviders", new Class[] { Context.class, List.class });
      paramApplication.setAccessible(true);
      l.Ilq = paramApplication;
      paramApplication = localObject2.getClass().getDeclaredField("mBoundApplication");
      paramApplication.setAccessible(true);
      paramApplication = paramApplication.get(localObject2);
      l.Iln = paramApplication;
      localObject2 = paramApplication.getClass().getDeclaredField("restrictedBackupMode");
      ((Field)localObject2).setAccessible(true);
      if (!g.zz) {
        ((Field)localObject2).set(paramApplication, Boolean.TRUE);
      }
      localObject2 = paramApplication.getClass().getDeclaredField("providers");
      ((Field)localObject2).setAccessible(true);
      l.Ilp = (List)((Field)localObject2).get(paramApplication);
      localObject2 = IkO.iterator();
      label991:
      if (!((Iterator)localObject2).hasNext()) {
        break label1091;
      }
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = l.Ilp.iterator();
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
      l.Ilp.remove(paramApplication);
      break label991;
      b("WxSplash.Splash", "callback is splash hacked, why? failed before?", new Object[0]);
      break label796;
      label1091:
      IkG = true;
      IkE = true;
      b("WxSplash.Splash", "splash hack success.", new Object[0]);
      b("WxSplash.Splash", "we need splash. time spent %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      bool = true;
      AppMethodBeat.o(40635);
      break;
      paramApplication = null;
    }
  }
  
  public static void t(Message paramMessage)
  {
    AppMethodBeat.i(40639);
    l.Ilm.sendMessage(paramMessage);
    AppMethodBeat.o(40639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.h
 * JD-Core Version:    0.7.0.1
 */