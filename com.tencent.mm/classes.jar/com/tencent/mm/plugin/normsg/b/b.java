package com.tencent.mm.plugin.normsg.b;

import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b
{
  private static final ClassLoader phd;
  private static final String phe;
  private static final String phf;
  private static final String phg;
  private static final String phh;
  private static final String phi;
  private static final String phj;
  private static final String phk;
  private static final String phl;
  private static final String phm;
  private static final String phn;
  private static final String pho;
  private static final String php;
  private static final String phq;
  private static final String phr;
  private static final String phs;
  private static final String pht;
  private static final String phu;
  private static final String phv;
  private static final String phw;
  private static final String phx;
  private static final String phy;
  private volatile boolean mInitialized;
  private final Map<Object, IBinder> phA;
  private final Map<IBinder, Integer> phB;
  private final Handler phC;
  private IInterface phD;
  public final Queue<g> phz;
  
  static
  {
    AppMethodBeat.i(10431);
    phd = b.class.getClassLoader();
    phe = d.Wd("");
    phf = d.Wd("\021p\036z\bg\016jD+Xv%@2D-N+f\007i\bo\nx");
    phg = d.Wd("\007t7V5]8");
    phh = d.Wd("\027v\005L\"V3A'F%@");
    phi = d.Wd("\ng$E)E'F%N");
    phj = d.Wd("\016c5\\9N\034s\034h!L<P");
    phk = d.Wd("Ñ°ÞºÈ§Îªòþ§Æ¥Æ£Ð£Ê¨Á­Ä°Éç®ïïùãèíà©Ç³Ö¤Å¦Ò»Ôºùøóäâ");
    phl = d.Wd("Ù¸Ü¸ùùïõþûö¿Ñ¥À²Ó°Ä­Â¬ïîåòô");
    phm = d.Wd("éëÞ½Þ»È»Ò°ÙµÜ¨ÑöçôãåÈ§É½Ï Ì Å·");
    phn = d.Wd("\032k\036{\tp<S0Q=t\032n\013y\037~\035x");
    pho = d.Wd("?Y0^:l\005`\027U,m\016m\b{\ba\003j\006o\033b+O");
    php = d.Wd("+M$J.o\fo\ny\nc\001h\004m\031`.A%@\tg\001n,U\024w\024q\002q\030z\023\026b\033R6");
    phq = d.Wd("");
    phr = d.Wd("÷ðÕ¶Õ°Ã°Ù»Ò¾×£Úûú³Ý»Ô§åÊ£Æ±ø");
    phs = d.Wd("±×¾Ð´õõãùò÷ú´Û¿ÚýôÅ¼èõ");
    pht = d.Wd("\rk\002l\bN!B7D");
    phu = d.Wd("\"D+H=N\035x\031k\b`");
    phv = d.Wd("m\035x\nl\003q\034]>]8K8Q3Z6_+R\023p\004m\002l");
    phw = d.Wd("Ì¿Ú®èïÊ©Ê¯Ü¯Æ¤Í¡È¼Åäå¬Â¤Ëüúâ");
    phx = d.Wd("¬ßºÎáëªÉªÏ¼Ï¦Ä­Á¨Ü¥ëàÌ¢Ä«Øïéñ");
    phy = d.Wd("îøÜ¹Ë­Â°Ýÿùùò÷êÒ±Å¬Ã­ÿéð");
    AppMethodBeat.o(10431);
  }
  
  private b()
  {
    AppMethodBeat.i(10423);
    this.phz = new ConcurrentLinkedQueue();
    this.phA = new WeakHashMap();
    this.phB = new ConcurrentHashMap();
    this.phC = new Handler(Looper.getMainLooper());
    this.phD = null;
    this.mInitialized = false;
    AppMethodBeat.o(10423);
  }
  
  private void b(int paramInt, View paramView, List<AccessibilityNodeInfo> paramList)
  {
    AppMethodBeat.i(10419);
    Iterator localIterator = this.phz.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).a(paramInt, paramView, paramList);
    }
    AppMethodBeat.o(10419);
  }
  
  private boolean b(int paramInt1, int paramInt2, View paramView)
  {
    AppMethodBeat.i(10420);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      boolean bool = c(paramInt1, paramInt2, paramView);
      AppMethodBeat.o(10420);
      return bool;
    }
    boolean[] arrayOfBoolean = new boolean[2];
    boolean[] tmp40_38 = arrayOfBoolean;
    tmp40_38[0] = 1;
    boolean[] tmp46_40 = tmp40_38;
    tmp46_40[1] = 0;
    tmp46_40;
    this.phC.post(new b.2(this, arrayOfBoolean, paramInt1, paramInt2, paramView));
    for (;;)
    {
      if (arrayOfBoolean[1] == 0) {}
      try
      {
        arrayOfBoolean.wait();
      }
      catch (InterruptedException paramView)
      {
        continue;
        int i = arrayOfBoolean[0];
        AppMethodBeat.o(10420);
        return i;
      }
      finally
      {
        AppMethodBeat.o(10420);
      }
    }
  }
  
  public static b bXA()
  {
    return b.h.phU;
  }
  
  private boolean c(int paramInt1, int paramInt2, View paramView)
  {
    AppMethodBeat.i(10421);
    Iterator localIterator = this.phz.iterator();
    while (localIterator.hasNext()) {
      if (!((g)localIterator.next()).a(paramInt1, paramInt2, paramView))
      {
        AppMethodBeat.o(10421);
        return false;
      }
    }
    AppMethodBeat.o(10421);
    return true;
  }
  
  private void k(Throwable paramThrowable)
  {
    AppMethodBeat.i(10422);
    Iterator localIterator = this.phz.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).onError(paramThrowable);
    }
    AppMethodBeat.o(10422);
  }
  
  public final void ensureInitialized()
  {
    try
    {
      AppMethodBeat.i(10418);
      if (!this.mInitialized)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("you must call initialize first.");
        AppMethodBeat.o(10418);
        throw localIllegalStateException;
      }
    }
    finally {}
    AppMethodBeat.o(10418);
  }
  
  /* Error */
  public final void initialize(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 10417
    //   5: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 208	com/tencent/mm/plugin/normsg/b/b:mInitialized	Z
    //   12: ifeq +12 -> 24
    //   15: sipush 10417
    //   18: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: getstatic 364	android/os/Build$VERSION:SDK_INT	I
    //   27: bipush 15
    //   29: if_icmpge +43 -> 72
    //   32: new 17	com/tencent/mm/plugin/normsg/b/b$f
    //   35: dup
    //   36: new 366	java/lang/StringBuilder
    //   39: dup
    //   40: ldc_w 368
    //   43: invokespecial 369	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: getstatic 364	android/os/Build$VERSION:SDK_INT	I
    //   49: invokevirtual 373	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 376	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 377	com/tencent/mm/plugin/normsg/b/b$f:<init>	(Ljava/lang/String;)V
    //   58: astore_1
    //   59: sipush 10417
    //   62: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: getstatic 93	com/tencent/mm/plugin/normsg/b/b:phf	Ljava/lang/String;
    //   75: ldc_w 379
    //   78: iconst_1
    //   79: anewarray 73	java/lang/Class
    //   82: dup
    //   83: iconst_0
    //   84: ldc_w 381
    //   87: aastore
    //   88: invokestatic 386	com/tencent/mm/plugin/normsg/b/h:b	([Ljava/lang/Class;)[Ljava/lang/Class;
    //   91: iconst_1
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: ldc_w 388
    //   100: aastore
    //   101: invokestatic 391	com/tencent/mm/plugin/normsg/b/h:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   104: checkcast 393	android/os/IBinder
    //   107: astore_2
    //   108: getstatic 89	com/tencent/mm/plugin/normsg/b/b:phe	Ljava/lang/String;
    //   111: getstatic 101	com/tencent/mm/plugin/normsg/b/b:phh	Ljava/lang/String;
    //   114: iconst_1
    //   115: anewarray 73	java/lang/Class
    //   118: dup
    //   119: iconst_0
    //   120: ldc_w 393
    //   123: aastore
    //   124: invokestatic 386	com/tencent/mm/plugin/normsg/b/h:b	([Ljava/lang/Class;)[Ljava/lang/Class;
    //   127: iconst_1
    //   128: anewarray 4	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: aload_2
    //   134: aastore
    //   135: invokestatic 391	com/tencent/mm/plugin/normsg/b/h:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   138: checkcast 395	android/os/IInterface
    //   141: astore_2
    //   142: aload_0
    //   143: getstatic 79	com/tencent/mm/plugin/normsg/b/b:phd	Ljava/lang/ClassLoader;
    //   146: aload_2
    //   147: invokevirtual 398	java/lang/Object:getClass	()Ljava/lang/Class;
    //   150: invokevirtual 402	java/lang/Class:getInterfaces	()[Ljava/lang/Class;
    //   153: new 10	com/tencent/mm/plugin/normsg/b/b$c
    //   156: dup
    //   157: aload_0
    //   158: aload_2
    //   159: invokespecial 405	com/tencent/mm/plugin/normsg/b/b$c:<init>	(Lcom/tencent/mm/plugin/normsg/b/b;Landroid/os/IInterface;)V
    //   162: invokestatic 411	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   165: checkcast 395	android/os/IInterface
    //   168: putfield 206	com/tencent/mm/plugin/normsg/b/b:phD	Landroid/os/IInterface;
    //   171: getstatic 93	com/tencent/mm/plugin/normsg/b/b:phf	Ljava/lang/String;
    //   174: getstatic 97	com/tencent/mm/plugin/normsg/b/b:phg	Ljava/lang/String;
    //   177: invokestatic 415	com/tencent/mm/plugin/normsg/b/h:fG	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   180: checkcast 417	java/util/Map
    //   183: ldc_w 388
    //   186: aload_0
    //   187: getfield 206	com/tencent/mm/plugin/normsg/b/b:phD	Landroid/os/IInterface;
    //   190: invokeinterface 421 1 0
    //   195: invokeinterface 425 3 0
    //   200: pop
    //   201: ldc_w 427
    //   204: ldc_w 429
    //   207: iconst_1
    //   208: anewarray 73	java/lang/Class
    //   211: dup
    //   212: iconst_0
    //   213: ldc_w 431
    //   216: aastore
    //   217: invokestatic 386	com/tencent/mm/plugin/normsg/b/h:b	([Ljava/lang/Class;)[Ljava/lang/Class;
    //   220: iconst_1
    //   221: anewarray 4	java/lang/Object
    //   224: dup
    //   225: iconst_0
    //   226: aload_1
    //   227: aastore
    //   228: invokestatic 434	com/tencent/mm/plugin/normsg/b/h:b	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   231: astore_2
    //   232: aload_2
    //   233: ldc_w 436
    //   236: invokestatic 439	com/tencent/mm/plugin/normsg/b/h:g	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   239: astore_1
    //   240: aload_1
    //   241: ifnull +85 -> 326
    //   244: aload_1
    //   245: monitorenter
    //   246: aload_2
    //   247: ldc_w 441
    //   250: aload_0
    //   251: getfield 206	com/tencent/mm/plugin/normsg/b/b:phD	Landroid/os/IInterface;
    //   254: invokestatic 444	com/tencent/mm/plugin/normsg/b/h:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V
    //   257: aload_1
    //   258: monitorexit
    //   259: aload_0
    //   260: iconst_1
    //   261: putfield 208	com/tencent/mm/plugin/normsg/b/b:mInitialized	Z
    //   264: sipush 10417
    //   267: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: goto -249 -> 21
    //   273: astore_1
    //   274: new 17	com/tencent/mm/plugin/normsg/b/b$f
    //   277: dup
    //   278: aload_1
    //   279: invokespecial 446	com/tencent/mm/plugin/normsg/b/b$f:<init>	(Ljava/lang/Throwable;)V
    //   282: astore_1
    //   283: sipush 10417
    //   286: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload_1
    //   290: athrow
    //   291: astore_1
    //   292: aconst_null
    //   293: astore_1
    //   294: goto -54 -> 240
    //   297: astore_2
    //   298: aload_1
    //   299: monitorexit
    //   300: sipush 10417
    //   303: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload_2
    //   307: athrow
    //   308: astore_1
    //   309: new 17	com/tencent/mm/plugin/normsg/b/b$f
    //   312: dup
    //   313: aload_1
    //   314: invokespecial 446	com/tencent/mm/plugin/normsg/b/b$f:<init>	(Ljava/lang/Throwable;)V
    //   317: astore_1
    //   318: sipush 10417
    //   321: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: aload_1
    //   325: athrow
    //   326: aload_2
    //   327: ldc_w 441
    //   330: aload_0
    //   331: getfield 206	com/tencent/mm/plugin/normsg/b/b:phD	Landroid/os/IInterface;
    //   334: invokestatic 444	com/tencent/mm/plugin/normsg/b/h:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V
    //   337: goto -78 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	this	b
    //   0	340	1	paramContext	android.content.Context
    //   107	140	2	localObject1	Object
    //   297	30	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	67	finally
    //   24	67	67	finally
    //   72	201	67	finally
    //   201	232	67	finally
    //   232	240	67	finally
    //   244	246	67	finally
    //   259	270	67	finally
    //   274	291	67	finally
    //   300	308	67	finally
    //   309	326	67	finally
    //   326	337	67	finally
    //   72	201	273	java/lang/Throwable
    //   232	240	291	java/lang/Throwable
    //   246	259	297	finally
    //   298	300	297	finally
    //   201	232	308	java/lang/Throwable
    //   244	246	308	java/lang/Throwable
    //   300	308	308	java/lang/Throwable
    //   326	337	308	java/lang/Throwable
  }
  
  class e
    implements InvocationHandler
  {
    protected final IInterface phT;
    
    e(IInterface paramIInterface)
    {
      this.phT = paramIInterface;
    }
    
    public IBinder asBinder()
    {
      AppMethodBeat.i(10411);
      IBinder localIBinder = this.phT.asBinder();
      AppMethodBeat.o(10411);
      return localIBinder;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(10410);
      paramObject = paramMethod.getName();
      try
      {
        if ("asBinder".equals(paramObject))
        {
          paramObject = asBinder();
          AppMethodBeat.o(10410);
          return paramObject;
        }
        paramObject = paramMethod.invoke(this.phT, paramArrayOfObject);
        AppMethodBeat.o(10410);
        return paramObject;
      }
      catch (InvocationTargetException paramObject)
      {
        paramObject = paramObject.getTargetException();
        if ((paramObject instanceof RuntimeException))
        {
          AppMethodBeat.o(10410);
          throw paramObject;
        }
        paramArrayOfObject = paramMethod.getExceptionTypes();
        if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
        {
          paramArrayOfObject = paramMethod.getExceptionTypes();
          int j = paramArrayOfObject.length;
          int i = 0;
          while (i < j)
          {
            if (paramArrayOfObject[i].isAssignableFrom(paramObject.getClass()))
            {
              AppMethodBeat.o(10410);
              throw paramObject;
            }
            i += 1;
          }
        }
        b.a(b.this, paramObject);
        paramObject = b.c(paramMethod);
        AppMethodBeat.o(10410);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        b.a(b.this, paramObject);
        paramObject = b.c(paramMethod);
        AppMethodBeat.o(10410);
      }
      return paramObject;
    }
  }
  
  public static final class f
    extends Exception
  {
    f(String paramString)
    {
      super();
    }
    
    f(Throwable paramThrowable)
    {
      super();
    }
  }
  
  public static abstract interface g
  {
    public abstract void a(int paramInt, View paramView, List<AccessibilityNodeInfo> paramList);
    
    public abstract boolean a(int paramInt1, int paramInt2, View paramView);
    
    public abstract void onError(Throwable paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b
 * JD-Core Version:    0.7.0.1
 */