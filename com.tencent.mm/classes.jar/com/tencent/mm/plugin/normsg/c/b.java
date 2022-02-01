package com.tencent.mm.plugin.normsg.c;

import android.graphics.Region;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b
{
  private static final ClassLoader ufH;
  private static final String ufI;
  private static final String ufJ;
  private static final String ufK;
  private static final String ufL;
  private static final String ufM;
  private static final String ufN;
  private static final String ufO;
  private static final String ufP;
  private static final String ufQ;
  private static final String ufR;
  private static final String ufS;
  private static final String ufT;
  private static final String ufU;
  private static final String ufV;
  private static final String ufW;
  private static final String ufX;
  private static final String ufY;
  private static final String ufZ;
  private static final String uga;
  private static final String ugb;
  private static final String ugc;
  private volatile boolean mInitialized;
  public final Queue<g> ugd;
  private final Map<Object, IBinder> uge;
  private final Map<IBinder, Integer> ugf;
  private final Handler ugg;
  private IInterface ugh;
  
  static
  {
    AppMethodBeat.i(149084);
    ufH = b.class.getClassLoader();
    ufI = d.ajp("");
    ufJ = d.ajp("\021p\036z\bg\016jD+Xv%@2D-N+f\007i\bo\nx");
    ufK = d.ajp("\007t7V5]8");
    ufL = d.ajp("\027v\005L\"V3A'F%@");
    ufM = d.ajp("\ng$E)E'F%N");
    ufN = d.ajp("\016c5\\9N\034s\034h!L<P");
    ufO = d.ajp("Ñ°ÞºÈ§Îªòþ§Æ¥Æ£Ð£Ê¨Á­Ä°Éç®ïïùãèíà©Ç³Ö¤Å¦Ò»Ôºùøóäâ");
    ufP = d.ajp("Ù¸Ü¸ùùïõþûö¿Ñ¥À²Ó°Ä­Â¬ïîåòô");
    ufQ = d.ajp("éëÞ½Þ»È»Ò°ÙµÜ¨ÑöçôãåÈ§É½Ï Ì Å·");
    ufR = d.ajp("\032k\036{\tp<S0Q=t\032n\013y\037~\035x");
    ufS = d.ajp("?Y0^:l\005`\027U,m\016m\b{\ba\003j\006o\033b+O");
    ufT = d.ajp("+M$J.o\fo\ny\nc\001h\004m\031`.A%@\tg\001n,U\024w\024q\002q\030z\023\026b\033R6");
    ufU = d.ajp("");
    ufV = d.ajp("÷ðÕ¶Õ°Ã°Ù»Ò¾×£Úûú³Ý»Ô§åÊ£Æ±ø");
    ufW = d.ajp("±×¾Ð´õõãùò÷ú´Û¿ÚýôÅ¼èõ");
    ufX = d.ajp("\rk\002l\bN!B7D");
    ufY = d.ajp("\"D+H=N\035x\031k\b`");
    ufZ = d.ajp("m\035x\nl\003q\034]>]8K8Q3Z6_+R\023p\004m\002l");
    uga = d.ajp("Ì¿Ú®èïÊ©Ê¯Ü¯Æ¤Í¡È¼Åäå¬Â¤Ëüúâ");
    ugb = d.ajp("¬ßºÎáëªÉªÏ¼Ï¦Ä­Á¨Ü¥ëàÌ¢Ä«Øïéñ");
    ugc = d.ajp("îøÜ¹Ë­Â°Ýÿùùò÷êÒ±Å¬Ã­ÿéð");
    AppMethodBeat.o(149084);
  }
  
  private b()
  {
    AppMethodBeat.i(149076);
    this.ugd = new ConcurrentLinkedQueue();
    this.uge = new WeakHashMap();
    this.ugf = new ConcurrentHashMap();
    this.ugg = new Handler(Looper.getMainLooper());
    this.ugh = null;
    this.mInitialized = false;
    AppMethodBeat.o(149076);
  }
  
  private void b(int paramInt, View paramView, List<AccessibilityNodeInfo> paramList)
  {
    AppMethodBeat.i(149072);
    Iterator localIterator = this.ugd.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).a(paramInt, paramView, paramList);
    }
    AppMethodBeat.o(149072);
  }
  
  private boolean b(final int paramInt1, final int paramInt2, final View paramView)
  {
    AppMethodBeat.i(149073);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      boolean bool = c(paramInt1, paramInt2, paramView);
      AppMethodBeat.o(149073);
      return bool;
    }
    final boolean[] arrayOfBoolean = new boolean[2];
    boolean[] tmp40_38 = arrayOfBoolean;
    tmp40_38[0] = 1;
    boolean[] tmp46_40 = tmp40_38;
    tmp46_40[1] = 0;
    tmp46_40;
    this.ugg.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(149043);
        arrayOfBoolean[0] = b.b(b.this, paramInt1, paramInt2, paramView);
        synchronized (arrayOfBoolean)
        {
          arrayOfBoolean[1] = true;
          arrayOfBoolean.notifyAll();
          AppMethodBeat.o(149043);
          return;
        }
      }
    });
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
        AppMethodBeat.o(149073);
        return i;
      }
      finally
      {
        AppMethodBeat.o(149073);
      }
    }
  }
  
  private boolean c(int paramInt1, int paramInt2, View paramView)
  {
    AppMethodBeat.i(149074);
    Iterator localIterator = this.ugd.iterator();
    while (localIterator.hasNext()) {
      if (!((g)localIterator.next()).a(paramInt1, paramInt2, paramView))
      {
        AppMethodBeat.o(149074);
        return false;
      }
    }
    AppMethodBeat.o(149074);
    return true;
  }
  
  public static b cXi()
  {
    return h.ugx;
  }
  
  private void l(Throwable paramThrowable)
  {
    AppMethodBeat.i(149075);
    Iterator localIterator = this.ugd.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).onError(paramThrowable);
    }
    AppMethodBeat.o(149075);
  }
  
  public final void ensureInitialized()
  {
    try
    {
      AppMethodBeat.i(149071);
      if (!this.mInitialized)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("you must call initialize first.");
        AppMethodBeat.o(149071);
        throw localIllegalStateException;
      }
    }
    finally {}
    AppMethodBeat.o(149071);
  }
  
  /* Error */
  public final void initialize(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 381
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 227	com/tencent/mm/plugin/normsg/c/b:mInitialized	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 381
    //   18: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: getstatic 387	android/os/Build$VERSION:SDK_INT	I
    //   27: bipush 15
    //   29: if_icmpge +43 -> 72
    //   32: new 31	com/tencent/mm/plugin/normsg/c/b$f
    //   35: dup
    //   36: new 389	java/lang/StringBuilder
    //   39: dup
    //   40: ldc_w 391
    //   43: invokespecial 392	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: getstatic 387	android/os/Build$VERSION:SDK_INT	I
    //   49: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 400	com/tencent/mm/plugin/normsg/c/b$f:<init>	(Ljava/lang/String;)V
    //   58: astore_1
    //   59: ldc_w 381
    //   62: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: getstatic 111	com/tencent/mm/plugin/normsg/c/b:ufJ	Ljava/lang/String;
    //   75: ldc_w 402
    //   78: iconst_1
    //   79: anewarray 91	java/lang/Class
    //   82: dup
    //   83: iconst_0
    //   84: ldc_w 404
    //   87: aastore
    //   88: invokestatic 409	com/tencent/mm/plugin/normsg/c/h:b	([Ljava/lang/Class;)[Ljava/lang/Class;
    //   91: iconst_1
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: ldc_w 411
    //   100: aastore
    //   101: invokestatic 414	com/tencent/mm/plugin/normsg/c/h:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   104: checkcast 416	android/os/IBinder
    //   107: astore_2
    //   108: getstatic 107	com/tencent/mm/plugin/normsg/c/b:ufI	Ljava/lang/String;
    //   111: getstatic 119	com/tencent/mm/plugin/normsg/c/b:ufL	Ljava/lang/String;
    //   114: iconst_1
    //   115: anewarray 91	java/lang/Class
    //   118: dup
    //   119: iconst_0
    //   120: ldc_w 416
    //   123: aastore
    //   124: invokestatic 409	com/tencent/mm/plugin/normsg/c/h:b	([Ljava/lang/Class;)[Ljava/lang/Class;
    //   127: iconst_1
    //   128: anewarray 4	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: aload_2
    //   134: aastore
    //   135: invokestatic 414	com/tencent/mm/plugin/normsg/c/h:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   138: checkcast 418	android/os/IInterface
    //   141: astore_2
    //   142: aload_0
    //   143: getstatic 97	com/tencent/mm/plugin/normsg/c/b:ufH	Ljava/lang/ClassLoader;
    //   146: aload_2
    //   147: invokevirtual 421	java/lang/Object:getClass	()Ljava/lang/Class;
    //   150: invokevirtual 425	java/lang/Class:getInterfaces	()[Ljava/lang/Class;
    //   153: new 20	com/tencent/mm/plugin/normsg/c/b$c
    //   156: dup
    //   157: aload_0
    //   158: aload_2
    //   159: invokespecial 428	com/tencent/mm/plugin/normsg/c/b$c:<init>	(Lcom/tencent/mm/plugin/normsg/c/b;Landroid/os/IInterface;)V
    //   162: invokestatic 434	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   165: checkcast 418	android/os/IInterface
    //   168: putfield 225	com/tencent/mm/plugin/normsg/c/b:ugh	Landroid/os/IInterface;
    //   171: getstatic 111	com/tencent/mm/plugin/normsg/c/b:ufJ	Ljava/lang/String;
    //   174: getstatic 115	com/tencent/mm/plugin/normsg/c/b:ufK	Ljava/lang/String;
    //   177: invokestatic 438	com/tencent/mm/plugin/normsg/c/h:hM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   180: checkcast 440	java/util/Map
    //   183: ldc_w 411
    //   186: aload_0
    //   187: getfield 225	com/tencent/mm/plugin/normsg/c/b:ugh	Landroid/os/IInterface;
    //   190: invokeinterface 444 1 0
    //   195: invokeinterface 448 3 0
    //   200: pop
    //   201: ldc_w 450
    //   204: ldc_w 452
    //   207: iconst_1
    //   208: anewarray 91	java/lang/Class
    //   211: dup
    //   212: iconst_0
    //   213: ldc_w 454
    //   216: aastore
    //   217: invokestatic 409	com/tencent/mm/plugin/normsg/c/h:b	([Ljava/lang/Class;)[Ljava/lang/Class;
    //   220: iconst_1
    //   221: anewarray 4	java/lang/Object
    //   224: dup
    //   225: iconst_0
    //   226: aload_1
    //   227: aastore
    //   228: invokestatic 457	com/tencent/mm/plugin/normsg/c/h:b	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   231: astore_2
    //   232: aload_2
    //   233: ldc_w 459
    //   236: invokestatic 462	com/tencent/mm/plugin/normsg/c/h:d	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   239: astore_1
    //   240: aload_1
    //   241: ifnull +85 -> 326
    //   244: aload_1
    //   245: monitorenter
    //   246: aload_2
    //   247: ldc_w 464
    //   250: aload_0
    //   251: getfield 225	com/tencent/mm/plugin/normsg/c/b:ugh	Landroid/os/IInterface;
    //   254: invokestatic 467	com/tencent/mm/plugin/normsg/c/h:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V
    //   257: aload_1
    //   258: monitorexit
    //   259: aload_0
    //   260: iconst_1
    //   261: putfield 227	com/tencent/mm/plugin/normsg/c/b:mInitialized	Z
    //   264: ldc_w 381
    //   267: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: goto -249 -> 21
    //   273: astore_1
    //   274: new 31	com/tencent/mm/plugin/normsg/c/b$f
    //   277: dup
    //   278: aload_1
    //   279: invokespecial 469	com/tencent/mm/plugin/normsg/c/b$f:<init>	(Ljava/lang/Throwable;)V
    //   282: astore_1
    //   283: ldc_w 381
    //   286: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload_1
    //   290: athrow
    //   291: astore_1
    //   292: aconst_null
    //   293: astore_1
    //   294: goto -54 -> 240
    //   297: astore_2
    //   298: aload_1
    //   299: monitorexit
    //   300: ldc_w 381
    //   303: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload_2
    //   307: athrow
    //   308: astore_1
    //   309: new 31	com/tencent/mm/plugin/normsg/c/b$f
    //   312: dup
    //   313: aload_1
    //   314: invokespecial 469	com/tencent/mm/plugin/normsg/c/b$f:<init>	(Ljava/lang/Throwable;)V
    //   317: astore_1
    //   318: ldc_w 381
    //   321: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: aload_1
    //   325: athrow
    //   326: aload_2
    //   327: ldc_w 464
    //   330: aload_0
    //   331: getfield 225	com/tencent/mm/plugin/normsg/c/b:ugh	Landroid/os/IInterface;
    //   334: invokestatic 467	com/tencent/mm/plugin/normsg/c/h:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V
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
  
  final class a
    extends b.d
  {
    private b.i ugn;
    private WeakReference<Object> ugo;
    
    a(Object paramObject, IBinder paramIBinder)
    {
      super(paramIBinder);
      AppMethodBeat.i(149045);
      this.ugn = null;
      this.ugo = null;
      try
      {
        this.ugo = new WeakReference(paramObject);
        this.ugn = new b.i(b.this, h.findClass(b.ufO + "$Stub"));
        AppMethodBeat.o(149045);
        return;
      }
      catch (Throwable paramObject)
      {
        b.a(b.this, paramObject);
        AppMethodBeat.o(149045);
      }
    }
    
    protected final boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      AppMethodBeat.i(149046);
      boolean bool;
      if ((paramInt1 <= 0) || (paramInt1 > 16777215))
      {
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        AppMethodBeat.o(149046);
        return bool;
      }
      if (this.ugn == null)
      {
        ad.e("MicroMsg.AED", "init failed, give up intercepting.");
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        AppMethodBeat.o(149046);
        return bool;
      }
      if (this.ugo.get() == null)
      {
        ad.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        AppMethodBeat.o(149046);
        return bool;
      }
      Object localObject = (String)this.ugn.cXu().get(paramInt1);
      int i;
      IBinder localIBinder;
      for (;;)
      {
        try
        {
          paramParcel1.enforceInterface(b.ufO);
          if (!b.cXk().equals(localObject)) {
            continue;
          }
          i = Build.VERSION.SDK_INT;
          if (i >= 16) {
            continue;
          }
          paramParcel1.readInt();
          if ((i < 16) || (i >= 17)) {
            continue;
          }
          paramParcel1.readInt();
          paramParcel1.readInt();
        }
        catch (Throwable localThrowable)
        {
          ad.printErrStackTrace("MicroMsg.AED", localThrowable, "unexpected exception.", new Object[0]);
          b.a(b.this, localThrowable);
          continue;
          if ((i < 21) || (paramParcel1.readInt() == 0)) {
            continue;
          }
          Region.CREATOR.createFromParcel(paramParcel1);
          continue;
          if (!b.cXl().equals(localThrowable)) {
            continue;
          }
          i = Build.VERSION.SDK_INT;
          if (i >= 16) {
            continue;
          }
          paramParcel1.readInt();
          if (i < 16) {
            continue;
          }
          paramParcel1.readInt();
          if (i >= 17) {
            continue;
          }
          paramParcel1.readInt();
          paramParcel1.readInt();
          paramParcel1.readInt();
          localIBinder = paramParcel1.readStrongBinder();
          if (i < 16) {
            continue;
          }
          paramParcel1.readInt();
          i = paramParcel1.readInt();
          b.c(b.this).put(localIBinder, Integer.valueOf(i));
          continue;
          paramParcel1.readLong();
          continue;
          if (!b.cXm().equals(localIBinder)) {
            continue;
          }
          i = Build.VERSION.SDK_INT;
          paramParcel1.readLong();
          paramParcel1.readString();
          if ((i < 21) || (paramParcel1.readInt() == 0)) {
            continue;
          }
          Region.CREATOR.createFromParcel(paramParcel1);
          paramParcel1.readInt();
          localIBinder = paramParcel1.readStrongBinder();
          paramParcel1.readInt();
          i = paramParcel1.readInt();
          b.c(b.this).put(localIBinder, Integer.valueOf(i));
          continue;
          if (!b.cXn().equals(localIBinder)) {
            continue;
          }
          i = Build.VERSION.SDK_INT;
          paramParcel1.readLong();
          paramParcel1.readString();
          if ((i < 16) || (i >= 17)) {
            continue;
          }
          paramParcel1.readInt();
          paramParcel1.readInt();
          paramParcel1.readInt();
          localIBinder = paramParcel1.readStrongBinder();
          paramParcel1.readInt();
          i = paramParcel1.readInt();
          b.c(b.this).put(localIBinder, Integer.valueOf(i));
          continue;
          if ((i < 21) || (paramParcel1.readInt() == 0)) {
            continue;
          }
          Region.CREATOR.createFromParcel(paramParcel1);
          continue;
          if (!b.cXo().equals(localIBinder)) {
            continue;
          }
          i = Build.VERSION.SDK_INT;
          paramParcel1.readLong();
          paramParcel1.readInt();
          if ((i < 16) || (i >= 17)) {
            continue;
          }
          paramParcel1.readInt();
          paramParcel1.readInt();
          paramParcel1.readInt();
          localIBinder = paramParcel1.readStrongBinder();
          paramParcel1.readInt();
          i = paramParcel1.readInt();
          b.c(b.this).put(localIBinder, Integer.valueOf(i));
          continue;
          if ((i < 21) || (paramParcel1.readInt() == 0)) {
            continue;
          }
          Region.CREATOR.createFromParcel(paramParcel1);
          continue;
          if (!b.cXp().equals(localIBinder)) {
            continue;
          }
          i = Build.VERSION.SDK_INT;
          paramParcel1.readLong();
          paramParcel1.readInt();
          if ((i < 16) || (i >= 17)) {
            continue;
          }
          paramParcel1.readInt();
          paramParcel1.readInt();
          paramParcel1.readInt();
          localIBinder = paramParcel1.readStrongBinder();
          paramParcel1.readInt();
          i = paramParcel1.readInt();
          b.c(b.this).put(localIBinder, Integer.valueOf(i));
          continue;
          if ((i < 21) || (paramParcel1.readInt() == 0)) {
            continue;
          }
          Region.CREATOR.createFromParcel(paramParcel1);
          continue;
          if (!b.aud().equals(localIBinder)) {
            continue;
          }
          i = Build.VERSION.SDK_INT;
          if (i >= 16) {
            break;
          }
        }
        paramParcel1.readInt();
        localObject = paramParcel1.readStrongBinder();
        if (i >= 16) {
          paramParcel1.readInt();
        }
        i = paramParcel1.readInt();
        b.c(b.this).put(localObject, Integer.valueOf(i));
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        AppMethodBeat.o(149046);
        return bool;
        paramParcel1.readLong();
        continue;
        paramParcel1.readInt();
      }
      for (;;)
      {
        paramParcel1.readInt();
        if ((i >= 16) && (paramParcel1.readInt() != 0)) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1.readInt();
        localIBinder = paramParcel1.readStrongBinder();
        if (i >= 16) {
          paramParcel1.readInt();
        }
        i = paramParcel1.readInt();
        b.c(b.this).put(localIBinder, Integer.valueOf(i));
        break;
        paramParcel1.readLong();
      }
    }
  }
  
  final class b
    implements Handler.Callback
  {
    private final WeakReference<Object> ugo;
    private final Handler.Callback ugp;
    
    b(Object paramObject, Handler.Callback paramCallback)
    {
      AppMethodBeat.i(149048);
      this.ugo = new WeakReference(paramObject);
      this.ugp = paramCallback;
      AppMethodBeat.o(149048);
    }
    
    private boolean q(Message paramMessage)
    {
      AppMethodBeat.i(149050);
      if (this.ugp != null)
      {
        boolean bool = this.ugp.handleMessage(paramMessage);
        AppMethodBeat.o(149050);
        return bool;
      }
      AppMethodBeat.o(149050);
      return false;
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(149049);
      Object localObject1 = this.ugo.get();
      boolean bool;
      if (localObject1 == null)
      {
        ad.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
        bool = q(paramMessage);
        AppMethodBeat.o(149049);
        return bool;
      }
      for (;;)
      {
        try
        {
          localView = (View)h.b(localObject1, "getView", null, new Object[0]);
          if (localView == null)
          {
            ad.e("MicroMsg.AED", "cannot find root view, give up intercepting.");
            bool = q(paramMessage);
            AppMethodBeat.o(149049);
            return bool;
          }
          switch (paramMessage.what)
          {
          }
        }
        catch (Throwable localThrowable)
        {
          final Integer localInteger;
          b.a(b.this, localThrowable);
          continue;
          h.c(paramMessage.obj, "arg2", localThrowable);
          continue;
          paramMessage.obj = localThrowable;
          continue;
          Object localObject2 = null;
          continue;
          final View localView = null;
          continue;
          int i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          int j = 0;
          continue;
          continue;
        }
        if (localObject1 != null) {
          continue;
        }
        ad.w("MicroMsg.AED", "callback is null, give up intercepting, op: %s", new Object[] { Integer.valueOf(paramMessage.what) });
        bool = q(paramMessage);
        AppMethodBeat.o(149049);
        return bool;
        localObject1 = (IInterface)h.d(paramMessage.obj, "arg1");
        continue;
        localObject1 = (IInterface)h.d(paramMessage.obj, "arg2");
        continue;
        localObject1 = (IInterface)paramMessage.obj;
      }
      if ((Proxy.isProxyClass(localObject1.getClass())) && ((Proxy.getInvocationHandler(localObject1) instanceof b.e)))
      {
        ad.w("MicroMsg.AED", "reused callback, skip rest works.");
        bool = q(paramMessage);
        AppMethodBeat.o(149049);
        return bool;
      }
      switch (paramMessage.what)
      {
      case 1022: 
        switch (paramMessage.what)
        {
        }
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 1020: 
      case 1021: 
      case 1023: 
        for (;;)
        {
          localInteger = (Integer)b.c(b.this).remove(((IInterface)localObject1).asBinder());
          if (localInteger != null) {
            break label839;
          }
          ad.w("MicroMsg.AED", "callback %s's binder is unmarked, give up intercept.", new Object[] { localObject1.getClass().getName() });
          bool = q(paramMessage);
          AppMethodBeat.o(149049);
          return bool;
          if (paramMessage.what != 1022) {
            break label1264;
          }
          i = paramMessage.arg1;
          localView = localView.findViewById(i);
          break;
          switch (paramMessage.what)
          {
          case 2: 
          case 4: 
          case 1020: 
          case 1023: 
          case 1: 
          case 3: 
          case 6: 
          case 5: 
          case 1021: 
            for (;;)
            {
              localView = (View)h.b(localView, b.cXq(), h.b(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(i) });
              break;
              i = ((Integer)h.d(paramMessage.obj, "argi1")).intValue();
              continue;
              i = paramMessage.arg2;
              continue;
              i = ((Integer)h.d(paramMessage.obj, "argi2")).intValue();
              continue;
              i = paramMessage.arg1;
            }
            i = ((Integer)h.d(paramMessage.obj, "argi3")).intValue();
            continue;
            i = ((Integer)h.d(paramMessage.obj, "argi1")).intValue();
            continue;
            i = paramMessage.arg2;
            continue;
            i = ((Integer)h.d(paramMessage.obj, "argi2")).intValue();
          }
        }
        label839:
        j = paramMessage.what;
        switch (j)
        {
        }
        for (;;)
        {
          bool = q(paramMessage);
          AppMethodBeat.o(149049);
          return bool;
          switch (paramMessage.what)
          {
          case 1: 
          case 1020: 
            while (!b.a(b.this, j, localInteger.intValue(), localView))
            {
              h.b(localObject1, b.cXr(), h.b(new Class[] { Boolean.TYPE, Integer.TYPE }), new Object[] { Boolean.FALSE, Integer.valueOf(i) });
              AppMethodBeat.o(149049);
              return true;
              j = ((Integer)h.d(paramMessage.obj, "argi2")).intValue();
            }
            localObject1 = (IInterface)Proxy.newProxyInstance(b.cXj(), localObject1.getClass().getInterfaces(), new b.e((IInterface)localObject1, localInteger)
            {
              public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
              {
                AppMethodBeat.i(149047);
                Object localObject = paramAnonymousMethod.getName();
                if (b.cXs().equals(localObject))
                {
                  localObject = new ArrayList();
                  if (paramAnonymousArrayOfObject[0] != null) {
                    ((List)localObject).add((AccessibilityNodeInfo)paramAnonymousArrayOfObject[0]);
                  }
                  b.a(b.this, localInteger.intValue(), localView, (List)localObject);
                  if (((List)localObject).isEmpty()) {
                    paramAnonymousArrayOfObject[0] = null;
                  }
                }
                for (;;)
                {
                  paramAnonymousObject = super.invoke(paramAnonymousObject, paramAnonymousMethod, paramAnonymousArrayOfObject);
                  AppMethodBeat.o(149047);
                  return paramAnonymousObject;
                  paramAnonymousArrayOfObject[0] = ((List)localObject).get(0);
                  continue;
                  if (b.cXt().equals(localObject))
                  {
                    List localList = (List)paramAnonymousArrayOfObject[0];
                    localObject = localList;
                    if (localList == null) {
                      localObject = new ArrayList();
                    }
                    b.a(b.this, localInteger.intValue(), localView, (List)localObject);
                  }
                }
              }
            });
            switch (paramMessage.what)
            {
            case 1: 
            case 2: 
            case 3: 
            case 5: 
            case 6: 
            case 1020: 
              h.c(paramMessage.obj, "arg1", localObject1);
            }
            break;
          }
        }
      }
    }
  }
  
  final class c
    extends b.e
  {
    private InvocationHandler ugt;
    
    c(IInterface paramIInterface)
    {
      super(paramIInterface);
      AppMethodBeat.i(149052);
      this.ugt = new InvocationHandler()
      {
        public final Object invoke(Object arg1, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        {
          AppMethodBeat.i(149051);
          Object localObject;
          synchronized (b.this)
          {
            localObject = paramAnonymousMethod.getName();
            if (b.bQU().equals(localObject))
            {
              paramAnonymousMethod = b.b(b.this);
              AppMethodBeat.o(149051);
              return paramAnonymousMethod;
            }
          }
          try
          {
            paramAnonymousArrayOfObject = paramAnonymousMethod.invoke(b.c.this.ugw.asBinder(), paramAnonymousArrayOfObject);
            AppMethodBeat.o(149051);
            return paramAnonymousArrayOfObject;
          }
          catch (InvocationTargetException paramAnonymousArrayOfObject)
          {
            paramAnonymousArrayOfObject = paramAnonymousArrayOfObject.getTargetException();
            localObject = paramAnonymousMethod.getExceptionTypes();
            if ((localObject != null) && (localObject.length > 0))
            {
              localObject = paramAnonymousMethod.getExceptionTypes();
              int j = localObject.length;
              int i = 0;
              while (i < j)
              {
                if (localObject[i].isAssignableFrom(paramAnonymousArrayOfObject.getClass()))
                {
                  AppMethodBeat.o(149051);
                  throw paramAnonymousArrayOfObject;
                  paramAnonymousMethod = finally;
                  AppMethodBeat.o(149051);
                  throw paramAnonymousMethod;
                }
                i += 1;
              }
            }
            b.a(b.this, paramAnonymousArrayOfObject);
            paramAnonymousMethod = b.b(paramAnonymousMethod);
            AppMethodBeat.o(149051);
            return paramAnonymousMethod;
          }
          catch (Throwable paramAnonymousArrayOfObject)
          {
            b.a(b.this, paramAnonymousArrayOfObject);
            paramAnonymousMethod = b.b(paramAnonymousMethod);
            AppMethodBeat.o(149051);
          }
          return paramAnonymousMethod;
        }
      };
      AppMethodBeat.o(149052);
    }
    
    public final IBinder asBinder()
    {
      AppMethodBeat.i(149054);
      Object localObject = b.cXj();
      InvocationHandler localInvocationHandler = this.ugt;
      localObject = (IBinder)Proxy.newProxyInstance((ClassLoader)localObject, new Class[] { IBinder.class }, localInvocationHandler);
      AppMethodBeat.o(149054);
      return localObject;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(149053);
      Object localObject6;
      if ((b.ufP.equals(paramMethod.getName())) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
      {
        localObject6 = paramArrayOfObject[1];
        try
        {
          if (!h.findClass(b.ufO).isAssignableFrom(localObject6.getClass()))
          {
            IllegalStateException localIllegalStateException = new IllegalStateException("mismatched conn class: " + localObject6.getClass() + ", give up intercepting.");
            AppMethodBeat.o(149053);
            throw localIllegalStateException;
          }
        }
        catch (Throwable localThrowable)
        {
          ad.printErrStackTrace("MicroMsg.AED", localThrowable, "unexpected exception.", new Object[0]);
          b.a(b.this, localThrowable);
          paramArrayOfObject[1] = localObject6;
        }
      }
      WeakReference localWeakReference;
      Object localObject4;
      for (;;)
      {
        paramObject = super.invoke(paramObject, paramMethod, paramArrayOfObject);
        AppMethodBeat.o(149053);
        return paramObject;
        localWeakReference = (WeakReference)h.d(localObject6, b.ufN);
        localObject4 = localWeakReference.get();
        if (localObject4 != null) {
          break;
        }
        ad.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
      }
      if (Build.VERSION.SDK_INT < 16) {}
      Object localObject3;
      for (Object localObject1 = localObject4;; localObject3 = h.d(h.b(localObject4, b.cPj(), null, new Object[0]), "mHandler")) {
        for (;;)
        {
          Object localObject5 = (Handler.Callback)h.d(localObject1, b.ufM);
          if (!(localObject5 instanceof b.b)) {
            h.c(localObject1, b.ufM, new b.b(b.this, localObject4, (Handler.Callback)localObject5));
          }
          synchronized (b.a(b.this))
          {
            localObject5 = (IBinder)b.a(b.this).get(localObject4);
            localObject1 = localObject5;
            if (localObject5 == null)
            {
              localObject1 = ((IInterface)localObject6).asBinder();
              localObject1 = new b.a(b.this, localWeakReference.get(), (IBinder)localObject1);
              b.a(b.this).put(localObject4, localObject1);
            }
            paramArrayOfObject[1] = ((IInterface)h.a(b.ufO + "$Stub", "asInterface", h.b(new Class[] { IBinder.class }), new Object[] { localObject1 }));
          }
        }
      }
    }
  }
  
  class d
    extends Binder
  {
    protected final IBinder ugv;
    
    d(IBinder paramIBinder)
    {
      this.ugv = paramIBinder;
    }
    
    public void dump(FileDescriptor paramFileDescriptor, String[] paramArrayOfString)
    {
      AppMethodBeat.i(149058);
      try
      {
        this.ugv.dump(paramFileDescriptor, paramArrayOfString);
        AppMethodBeat.o(149058);
        return;
      }
      catch (RemoteException paramFileDescriptor)
      {
        AppMethodBeat.o(149058);
      }
    }
    
    public void dumpAsync(FileDescriptor paramFileDescriptor, String[] paramArrayOfString)
    {
      AppMethodBeat.i(149059);
      try
      {
        this.ugv.dumpAsync(paramFileDescriptor, paramArrayOfString);
        AppMethodBeat.o(149059);
        return;
      }
      catch (RemoteException paramFileDescriptor)
      {
        AppMethodBeat.o(149059);
      }
    }
    
    public String getInterfaceDescriptor()
    {
      AppMethodBeat.i(149055);
      try
      {
        String str = this.ugv.getInterfaceDescriptor();
        AppMethodBeat.o(149055);
        return str;
      }
      catch (RemoteException localRemoteException)
      {
        AppMethodBeat.o(149055);
      }
      return "<failure>";
    }
    
    public boolean isBinderAlive()
    {
      AppMethodBeat.i(149057);
      boolean bool = this.ugv.isBinderAlive();
      AppMethodBeat.o(149057);
      return bool;
    }
    
    public void linkToDeath(IBinder.DeathRecipient paramDeathRecipient, int paramInt)
    {
      AppMethodBeat.i(149061);
      try
      {
        this.ugv.linkToDeath(paramDeathRecipient, paramInt);
        AppMethodBeat.o(149061);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        paramDeathRecipient.binderDied();
        AppMethodBeat.o(149061);
      }
    }
    
    protected boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      AppMethodBeat.i(149060);
      try
      {
        if (this.ugv.isBinderAlive())
        {
          boolean bool = this.ugv.transact(paramInt1, paramParcel1, paramParcel2, paramInt2);
          AppMethodBeat.o(149060);
          return bool;
        }
        AppMethodBeat.o(149060);
        return false;
      }
      catch (RemoteException paramParcel1)
      {
        AppMethodBeat.o(149060);
        throw paramParcel1;
      }
      catch (Throwable paramParcel1)
      {
        b.a(b.this, paramParcel1);
        AppMethodBeat.o(149060);
      }
      return false;
    }
    
    public boolean pingBinder()
    {
      AppMethodBeat.i(149056);
      boolean bool = this.ugv.pingBinder();
      AppMethodBeat.o(149056);
      return bool;
    }
    
    public IInterface queryLocalInterface(String paramString)
    {
      return null;
    }
    
    public boolean unlinkToDeath(IBinder.DeathRecipient paramDeathRecipient, int paramInt)
    {
      AppMethodBeat.i(149062);
      boolean bool = this.ugv.unlinkToDeath(paramDeathRecipient, paramInt);
      AppMethodBeat.o(149062);
      return bool;
    }
  }
  
  class e
    implements InvocationHandler
  {
    protected final IInterface ugw;
    
    e(IInterface paramIInterface)
    {
      this.ugw = paramIInterface;
    }
    
    public IBinder asBinder()
    {
      AppMethodBeat.i(149064);
      IBinder localIBinder = this.ugw.asBinder();
      AppMethodBeat.o(149064);
      return localIBinder;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(149063);
      paramObject = paramMethod.getName();
      try
      {
        if ("asBinder".equals(paramObject))
        {
          paramObject = asBinder();
          AppMethodBeat.o(149063);
          return paramObject;
        }
        paramObject = paramMethod.invoke(this.ugw, paramArrayOfObject);
        AppMethodBeat.o(149063);
        return paramObject;
      }
      catch (InvocationTargetException paramObject)
      {
        paramObject = paramObject.getTargetException();
        if ((paramObject instanceof RuntimeException))
        {
          AppMethodBeat.o(149063);
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
              AppMethodBeat.o(149063);
              throw paramObject;
            }
            i += 1;
          }
        }
        b.a(b.this, paramObject);
        paramObject = b.b(paramMethod);
        AppMethodBeat.o(149063);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        b.a(b.this, paramObject);
        paramObject = b.b(paramMethod);
        AppMethodBeat.o(149063);
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
  
  static final class h
  {
    static final b ugx;
    
    static
    {
      AppMethodBeat.i(149065);
      ugx = new b((byte)0);
      AppMethodBeat.o(149065);
    }
  }
  
  final class i
    implements IBinder
  {
    private String ugA = null;
    private final Class<?> ugy;
    private a<String> ugz = null;
    
    i()
    {
      Object localObject;
      this.ugy = localObject;
    }
    
    public final SparseArray<String> cXu()
    {
      Object[] arrayOfObject;
      int k;
      for (;;)
      {
        int i;
        int j;
        Object localObject4;
        Class localClass;
        try
        {
          AppMethodBeat.i(149068);
          Object localObject1;
          if (this.ugz != null)
          {
            localObject1 = this.ugz;
            AppMethodBeat.o(149068);
            return localObject1;
          }
          this.ugz = new a((byte)0);
          try
          {
            localObject1 = (IInterface)h.b(this.ugy, "asInterface", h.b(new Class[] { IBinder.class }), new Object[] { this });
            Class[] arrayOfClass1 = this.ugy.getInterfaces();
            int m = arrayOfClass1.length;
            i = 0;
            if (i < m)
            {
              Object localObject3 = arrayOfClass1[i];
              if (!IInterface.class.isAssignableFrom((Class)localObject3)) {
                break label381;
              }
              localObject3 = ((Class)localObject3).getDeclaredMethods();
              int n = localObject3.length;
              j = 0;
              if (j >= n) {
                break label381;
              }
              localObject4 = localObject3[j];
              if ("asBinder".equals(localObject4.getName())) {
                break label374;
              }
              this.ugA = localObject4.getName();
              if (!localObject4.isAccessible()) {
                localObject4.setAccessible(true);
              }
              Class[] arrayOfClass2 = localObject4.getParameterTypes();
              int i1 = arrayOfClass2.length;
              arrayOfObject = new Object[i1];
              k = 0;
              if (k >= i1) {
                break label364;
              }
              localClass = arrayOfClass2[k];
              if (!localClass.isPrimitive()) {
                break label302;
              }
              if (Boolean.TYPE.isAssignableFrom(localClass)) {
                arrayOfObject[k] = Boolean.FALSE;
              } else {
                arrayOfObject[k] = Integer.valueOf(0);
              }
            }
          }
          catch (Throwable localThrowable)
          {
            ad.printErrStackTrace("MicroMsg.AED", localThrowable, "unexpected exception.", new Object[0]);
            b.a(b.this, localThrowable);
            this.ugz.clear();
            a locala = this.ugz;
            AppMethodBeat.o(149068);
          }
          continue;
          if (!Number.class.isAssignableFrom(localClass)) {
            break label323;
          }
        }
        finally {}
        label302:
        arrayOfObject[k] = Integer.valueOf(0);
        break;
        label323:
        if (Character.class.isAssignableFrom(localClass))
        {
          arrayOfObject[k] = Character.valueOf('\000');
          break;
        }
        if (!Boolean.class.isAssignableFrom(localClass)) {
          break label395;
        }
        arrayOfObject[k] = Boolean.FALSE;
        break;
        label364:
        localObject4.invoke(localObject2, arrayOfObject);
        label374:
        j += 1;
        continue;
        label381:
        i += 1;
      }
      for (;;)
      {
        k += 1;
        break;
        label395:
        arrayOfObject[k] = null;
      }
    }
    
    public final void dump(FileDescriptor paramFileDescriptor, String[] paramArrayOfString) {}
    
    public final void dumpAsync(FileDescriptor paramFileDescriptor, String[] paramArrayOfString) {}
    
    public final String getInterfaceDescriptor()
    {
      return null;
    }
    
    public final boolean isBinderAlive()
    {
      return false;
    }
    
    public final void linkToDeath(IBinder.DeathRecipient paramDeathRecipient, int paramInt) {}
    
    public final boolean pingBinder()
    {
      return false;
    }
    
    public final IInterface queryLocalInterface(String paramString)
    {
      return null;
    }
    
    public final boolean transact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      AppMethodBeat.i(149069);
      try
      {
        if (this.ugz != null) {
          this.ugz.put(paramInt1, this.ugA);
        }
        return false;
      }
      finally
      {
        AppMethodBeat.o(149069);
      }
    }
    
    public final boolean unlinkToDeath(IBinder.DeathRecipient paramDeathRecipient, int paramInt)
    {
      return false;
    }
    
    final class a<T>
      extends SparseArray<T>
    {
      private a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(149066);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(149066);
        throw localUnsupportedOperationException;
      }
      
      public final void put(int paramInt, T paramT)
      {
        AppMethodBeat.i(149067);
        if (get(paramInt) != null)
        {
          paramT = new UnsupportedOperationException();
          AppMethodBeat.o(149067);
          throw paramT;
        }
        super.put(paramInt, paramT);
        AppMethodBeat.o(149067);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.b
 * JD-Core Version:    0.7.0.1
 */