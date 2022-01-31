package com.tencent.mm.plugin.normsg.b;

import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
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
  private static final ClassLoader mGX = b.class.getClassLoader();
  private static final String mGY = d.Kd("");
  private static final String mGZ = d.Kd("\021p\036z\bg\016jD+Xv%@2D-N+f\007i\bo\nx");
  private static final String mHa = d.Kd("\007t7V5]8");
  private static final String mHb = d.Kd("\027v\005L\"V3A'F%@");
  private static final String mHc = d.Kd("\ng$E)E'F%N");
  private static final String mHd = d.Kd("\016c5\\9N\034s\034h!L<P");
  private static final String mHe = d.Kd("Ñ°ÞºÈ§Îªòþ§Æ¥Æ£Ð£Ê¨Á­Ä°Éç®ïïùãèíà©Ç³Ö¤Å¦Ò»Ôºùøóäâ");
  private static final String mHf = d.Kd("Ù¸Ü¸ùùïõþûö¿Ñ¥À²Ó°Ä­Â¬ïîåòô");
  private static final String mHg = d.Kd("éëÞ½Þ»È»Ò°ÙµÜ¨ÑöçôãåÈ§É½Ï Ì Å·");
  private static final String mHh = d.Kd("\032k\036{\tp<S0Q=t\032n\013y\037~\035x");
  private static final String mHi = d.Kd("?Y0^:l\005`\027U,m\016m\b{\ba\003j\006o\033b+O");
  private static final String mHj = d.Kd("+M$J.o\fo\ny\nc\001h\004m\031`.A%@\tg\001n,U\024w\024q\002q\030z\023\026b\033R6");
  private static final String mHk = d.Kd("");
  private static final String mHl = d.Kd("÷ðÕ¶Õ°Ã°Ù»Ò¾×£Úûú³Ý»Ô§åÊ£Æ±ø");
  private static final String mHm = d.Kd("±×¾Ð´õõãùò÷ú´Û¿ÚýôÅ¼èõ");
  private static final String mHn = d.Kd("\rk\002l\bN!B7D");
  private static final String mHo = d.Kd("\"D+H=N\035x\031k\b`");
  private static final String mHp = d.Kd("m\035x\nl\003q\034]>]8K8Q3Z6_+R\023p\004m\002l");
  private static final String mHq = d.Kd("Ì¿Ú®èïÊ©Ê¯Ü¯Æ¤Í¡È¼Åäå¬Â¤Ëüúâ");
  private static final String mHr = d.Kd("¬ßºÎáëªÉªÏ¼Ï¦Ä­Á¨Ü¥ëàÌ¢Ä«Øïéñ");
  private static final String mHs = d.Kd("îøÜ¹Ë­Â°Ýÿùùò÷êÒ±Å¬Ã­ÿéð");
  private volatile boolean dNk = false;
  public final Queue<g> mHt = new ConcurrentLinkedQueue();
  private final Map<Object, IBinder> mHu = new WeakHashMap();
  private final Map<IBinder, Integer> mHv = new ConcurrentHashMap();
  private final Handler mHw = new Handler(Looper.getMainLooper());
  private IInterface mHx = null;
  
  private void b(int paramInt, View paramView, List<AccessibilityNodeInfo> paramList)
  {
    Iterator localIterator = this.mHt.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).a(paramInt, paramView, paramList);
    }
  }
  
  private boolean b(int paramInt1, int paramInt2, View paramView)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      return c(paramInt1, paramInt2, paramView);
    }
    boolean[] arrayOfBoolean = new boolean[2];
    boolean[] tmp24_22 = arrayOfBoolean;
    tmp24_22[0] = 1;
    boolean[] tmp30_24 = tmp24_22;
    tmp30_24[1] = 0;
    tmp30_24;
    this.mHw.post(new b.2(this, arrayOfBoolean, paramInt1, paramInt2, paramView));
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
        return arrayOfBoolean[0];
      }
      finally {}
    }
  }
  
  public static b boY()
  {
    return b.h.mHO;
  }
  
  private boolean c(int paramInt1, int paramInt2, View paramView)
  {
    Iterator localIterator = this.mHt.iterator();
    while (localIterator.hasNext()) {
      if (!((g)localIterator.next()).a(paramInt1, paramInt2, paramView)) {
        return false;
      }
    }
    return true;
  }
  
  private void i(Throwable paramThrowable)
  {
    Iterator localIterator = this.mHt.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).g(paramThrowable);
    }
  }
  
  public final void ensureInitialized()
  {
    try
    {
      if (!this.dNk) {
        throw new IllegalStateException("you must call initialize first.");
      }
    }
    finally {}
  }
  
  /* Error */
  public final void initialize(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 199	com/tencent/mm/plugin/normsg/b/b:dNk	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: getstatic 353	android/os/Build$VERSION:SDK_INT	I
    //   17: bipush 15
    //   19: if_icmpge +35 -> 54
    //   22: new 17	com/tencent/mm/plugin/normsg/b/b$f
    //   25: dup
    //   26: new 355	java/lang/StringBuilder
    //   29: dup
    //   30: ldc_w 357
    //   33: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: getstatic 353	android/os/Build$VERSION:SDK_INT	I
    //   39: invokevirtual 362	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: invokevirtual 365	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 366	com/tencent/mm/plugin/normsg/b/b$f:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    //   54: getstatic 87	com/tencent/mm/plugin/normsg/b/b:mGZ	Ljava/lang/String;
    //   57: ldc_w 368
    //   60: iconst_1
    //   61: anewarray 67	java/lang/Class
    //   64: dup
    //   65: iconst_0
    //   66: ldc_w 370
    //   69: aastore
    //   70: invokestatic 375	com/tencent/mm/plugin/normsg/b/h:b	([Ljava/lang/Class;)[Ljava/lang/Class;
    //   73: iconst_1
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: ldc_w 377
    //   82: aastore
    //   83: invokestatic 380	com/tencent/mm/plugin/normsg/b/h:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   86: checkcast 382	android/os/IBinder
    //   89: astore_3
    //   90: getstatic 83	com/tencent/mm/plugin/normsg/b/b:mGY	Ljava/lang/String;
    //   93: getstatic 95	com/tencent/mm/plugin/normsg/b/b:mHb	Ljava/lang/String;
    //   96: iconst_1
    //   97: anewarray 67	java/lang/Class
    //   100: dup
    //   101: iconst_0
    //   102: ldc_w 382
    //   105: aastore
    //   106: invokestatic 375	com/tencent/mm/plugin/normsg/b/h:b	([Ljava/lang/Class;)[Ljava/lang/Class;
    //   109: iconst_1
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: aload_3
    //   116: aastore
    //   117: invokestatic 380	com/tencent/mm/plugin/normsg/b/h:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   120: checkcast 384	android/os/IInterface
    //   123: astore_3
    //   124: aload_0
    //   125: getstatic 73	com/tencent/mm/plugin/normsg/b/b:mGX	Ljava/lang/ClassLoader;
    //   128: aload_3
    //   129: invokevirtual 387	java/lang/Object:getClass	()Ljava/lang/Class;
    //   132: invokevirtual 391	java/lang/Class:getInterfaces	()[Ljava/lang/Class;
    //   135: new 10	com/tencent/mm/plugin/normsg/b/b$c
    //   138: dup
    //   139: aload_0
    //   140: aload_3
    //   141: invokespecial 394	com/tencent/mm/plugin/normsg/b/b$c:<init>	(Lcom/tencent/mm/plugin/normsg/b/b;Landroid/os/IInterface;)V
    //   144: invokestatic 400	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   147: checkcast 384	android/os/IInterface
    //   150: putfield 197	com/tencent/mm/plugin/normsg/b/b:mHx	Landroid/os/IInterface;
    //   153: getstatic 87	com/tencent/mm/plugin/normsg/b/b:mGZ	Ljava/lang/String;
    //   156: getstatic 91	com/tencent/mm/plugin/normsg/b/b:mHa	Ljava/lang/String;
    //   159: invokestatic 404	com/tencent/mm/plugin/normsg/b/h:el	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   162: checkcast 406	java/util/Map
    //   165: ldc_w 377
    //   168: aload_0
    //   169: getfield 197	com/tencent/mm/plugin/normsg/b/b:mHx	Landroid/os/IInterface;
    //   172: invokeinterface 410 1 0
    //   177: invokeinterface 414 3 0
    //   182: pop
    //   183: ldc_w 416
    //   186: ldc_w 418
    //   189: iconst_1
    //   190: anewarray 67	java/lang/Class
    //   193: dup
    //   194: iconst_0
    //   195: ldc_w 420
    //   198: aastore
    //   199: invokestatic 375	com/tencent/mm/plugin/normsg/b/h:b	([Ljava/lang/Class;)[Ljava/lang/Class;
    //   202: iconst_1
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload_1
    //   209: aastore
    //   210: invokestatic 423	com/tencent/mm/plugin/normsg/b/h:b	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   213: astore_3
    //   214: aload_3
    //   215: ldc_w 425
    //   218: invokestatic 428	com/tencent/mm/plugin/normsg/b/h:f	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   221: astore_1
    //   222: aload_1
    //   223: ifnull +57 -> 280
    //   226: aload_1
    //   227: monitorenter
    //   228: aload_3
    //   229: ldc_w 430
    //   232: aload_0
    //   233: getfield 197	com/tencent/mm/plugin/normsg/b/b:mHx	Landroid/os/IInterface;
    //   236: invokestatic 433	com/tencent/mm/plugin/normsg/b/h:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V
    //   239: aload_1
    //   240: monitorexit
    //   241: aload_0
    //   242: iconst_1
    //   243: putfield 199	com/tencent/mm/plugin/normsg/b/b:dNk	Z
    //   246: goto -235 -> 11
    //   249: astore_1
    //   250: new 17	com/tencent/mm/plugin/normsg/b/b$f
    //   253: dup
    //   254: aload_1
    //   255: invokespecial 435	com/tencent/mm/plugin/normsg/b/b$f:<init>	(Ljava/lang/Throwable;)V
    //   258: athrow
    //   259: astore_1
    //   260: aconst_null
    //   261: astore_1
    //   262: goto -40 -> 222
    //   265: astore_3
    //   266: aload_1
    //   267: monitorexit
    //   268: aload_3
    //   269: athrow
    //   270: astore_1
    //   271: new 17	com/tencent/mm/plugin/normsg/b/b$f
    //   274: dup
    //   275: aload_1
    //   276: invokespecial 435	com/tencent/mm/plugin/normsg/b/b$f:<init>	(Ljava/lang/Throwable;)V
    //   279: athrow
    //   280: aload_3
    //   281: ldc_w 430
    //   284: aload_0
    //   285: getfield 197	com/tencent/mm/plugin/normsg/b/b:mHx	Landroid/os/IInterface;
    //   288: invokestatic 433	com/tencent/mm/plugin/normsg/b/h:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V
    //   291: goto -50 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	b
    //   0	294	1	paramContext	android.content.Context
    //   6	2	2	bool	boolean
    //   89	140	3	localObject1	Object
    //   265	16	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	49	finally
    //   14	49	49	finally
    //   54	183	49	finally
    //   183	214	49	finally
    //   214	222	49	finally
    //   226	228	49	finally
    //   241	246	49	finally
    //   250	259	49	finally
    //   268	270	49	finally
    //   271	280	49	finally
    //   280	291	49	finally
    //   54	183	249	java/lang/Throwable
    //   214	222	259	java/lang/Throwable
    //   228	241	265	finally
    //   266	268	265	finally
    //   183	214	270	java/lang/Throwable
    //   226	228	270	java/lang/Throwable
    //   268	270	270	java/lang/Throwable
    //   280	291	270	java/lang/Throwable
  }
  
  private class e
    implements InvocationHandler
  {
    protected final IInterface mHN;
    
    e(IInterface paramIInterface)
    {
      this.mHN = paramIInterface;
    }
    
    public IBinder asBinder()
    {
      return this.mHN.asBinder();
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      paramObject = paramMethod.getName();
      try
      {
        if ("asBinder".equals(paramObject)) {
          return asBinder();
        }
        paramObject = paramMethod.invoke(this.mHN, paramArrayOfObject);
        return paramObject;
      }
      catch (InvocationTargetException paramObject)
      {
        paramObject = paramObject.getTargetException();
        if ((paramObject instanceof RuntimeException)) {
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
            if (paramArrayOfObject[i].isAssignableFrom(paramObject.getClass())) {
              throw paramObject;
            }
            i += 1;
          }
        }
        b.a(b.this, paramObject);
        return b.b(paramMethod);
      }
      catch (Throwable paramObject)
      {
        b.a(b.this, paramObject);
      }
      return b.b(paramMethod);
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
    
    public abstract void g(Throwable paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b
 * JD-Core Version:    0.7.0.1
 */