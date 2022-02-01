package com.tencent.mm.plugin.normsg.d;

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
import com.tencent.mm.sdk.platformtools.Log;
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
  private static final String AFA;
  private static final String AFB;
  private static final String AFC;
  private static final String AFD;
  private static final String AFE;
  private static final String AFF;
  private static final ClassLoader AFk;
  private static final String AFl;
  private static final String AFm;
  private static final String AFn;
  private static final String AFo;
  private static final String AFp;
  private static final String AFq;
  private static final String AFr;
  private static final String AFs;
  private static final String AFt;
  private static final String AFu;
  private static final String AFv;
  private static final String AFw;
  private static final String AFx;
  private static final String AFy;
  private static final String AFz;
  public final Queue<g> AFG;
  private final Map<Object, IBinder> AFH;
  private final Map<IBinder, Integer> AFI;
  private final Handler AFJ;
  private IInterface AFK;
  private volatile boolean mInitialized;
  
  static
  {
    AppMethodBeat.i(149084);
    AFk = b.class.getClassLoader();
    AFl = d.aIJ("");
    AFm = d.aIJ("\021p\036z\bg\016jD+Xv%@2D-N+f\007i\bo\nx");
    AFn = d.aIJ("\007t7V5]8");
    AFo = d.aIJ("\027v\005L\"V3A'F%@");
    AFp = d.aIJ("\ng$E)E'F%N");
    AFq = d.aIJ("\016c5\\9N\034s\034h!L<P");
    AFr = d.aIJ("Ñ°ÞºÈ§Îªòþ§Æ¥Æ£Ð£Ê¨Á­Ä°Éç®ïïùãèíà©Ç³Ö¤Å¦Ò»Ôºùøóäâ");
    AFs = d.aIJ("Ù¸Ü¸ùùïõþûö¿Ñ¥À²Ó°Ä­Â¬ïîåòô");
    AFt = d.aIJ("éëÞ½Þ»È»Ò°ÙµÜ¨ÑöçôãåÈ§É½Ï Ì Å·");
    AFu = d.aIJ("\032k\036{\tp<S0Q=t\032n\013y\037~\035x");
    AFv = d.aIJ("?Y0^:l\005`\027U,m\016m\b{\ba\003j\006o\033b+O");
    AFw = d.aIJ("+M$J.o\fo\ny\nc\001h\004m\031`.A%@\tg\001n,U\024w\024q\002q\030z\023\026b\033R6");
    AFx = d.aIJ("");
    AFy = d.aIJ("÷ðÕ¶Õ°Ã°Ù»Ò¾×£Úûú³Ý»Ô§åÊ£Æ±ø");
    AFz = d.aIJ("±×¾Ð´õõãùò÷ú´Û¿ÚýôÅ¼èõ");
    AFA = d.aIJ("\rk\002l\bN!B7D");
    AFB = d.aIJ("\"D+H=N\035x\031k\b`");
    AFC = d.aIJ("m\035x\nl\003q\034]>]8K8Q3Z6_+R\023p\004m\002l");
    AFD = d.aIJ("Ì¿Ú®èïÊ©Ê¯Ü¯Æ¤Í¡È¼Åäå¬Â¤Ëüúâ");
    AFE = d.aIJ("¬ßºÎáëªÉªÏ¼Ï¦Ä­Á¨Ü¥ëàÌ¢Ä«Øïéñ");
    AFF = d.aIJ("îøÜ¹Ë­Â°Ýÿùùò÷êÒ±Å¬Ã­ÿéð");
    AppMethodBeat.o(149084);
  }
  
  private b()
  {
    AppMethodBeat.i(149076);
    this.AFG = new ConcurrentLinkedQueue();
    this.AFH = new WeakHashMap();
    this.AFI = new ConcurrentHashMap();
    this.AFJ = new Handler(Looper.getMainLooper());
    this.AFK = null;
    this.mInitialized = false;
    AppMethodBeat.o(149076);
  }
  
  private void b(int paramInt, View paramView, List<AccessibilityNodeInfo> paramList)
  {
    AppMethodBeat.i(149072);
    Iterator localIterator = this.AFG.iterator();
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
    this.AFJ.post(new Runnable()
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
    Iterator localIterator = this.AFG.iterator();
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
  
  public static b eye()
  {
    return h.AFZ;
  }
  
  private void o(Throwable paramThrowable)
  {
    AppMethodBeat.i(149075);
    Iterator localIterator = this.AFG.iterator();
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
    //   2: ldc_w 379
    //   5: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 226	com/tencent/mm/plugin/normsg/d/b:mInitialized	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 379
    //   18: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: getstatic 385	android/os/Build$VERSION:SDK_INT	I
    //   27: bipush 15
    //   29: if_icmpge +43 -> 72
    //   32: new 31	com/tencent/mm/plugin/normsg/d/b$f
    //   35: dup
    //   36: new 387	java/lang/StringBuilder
    //   39: dup
    //   40: ldc_w 389
    //   43: invokespecial 390	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: getstatic 385	android/os/Build$VERSION:SDK_INT	I
    //   49: invokevirtual 394	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 397	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 398	com/tencent/mm/plugin/normsg/d/b$f:<init>	(Ljava/lang/String;)V
    //   58: astore_1
    //   59: ldc_w 379
    //   62: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: getstatic 110	com/tencent/mm/plugin/normsg/d/b:AFm	Ljava/lang/String;
    //   75: ldc_w 400
    //   78: iconst_1
    //   79: anewarray 90	java/lang/Class
    //   82: dup
    //   83: iconst_0
    //   84: ldc_w 402
    //   87: aastore
    //   88: invokestatic 407	com/tencent/mm/plugin/normsg/d/i:b	([Ljava/lang/Class;)[Ljava/lang/Class;
    //   91: iconst_1
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: ldc_w 409
    //   100: aastore
    //   101: invokestatic 412	com/tencent/mm/plugin/normsg/d/i:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   104: checkcast 414	android/os/IBinder
    //   107: astore_2
    //   108: getstatic 106	com/tencent/mm/plugin/normsg/d/b:AFl	Ljava/lang/String;
    //   111: getstatic 118	com/tencent/mm/plugin/normsg/d/b:AFo	Ljava/lang/String;
    //   114: iconst_1
    //   115: anewarray 90	java/lang/Class
    //   118: dup
    //   119: iconst_0
    //   120: ldc_w 414
    //   123: aastore
    //   124: invokestatic 407	com/tencent/mm/plugin/normsg/d/i:b	([Ljava/lang/Class;)[Ljava/lang/Class;
    //   127: iconst_1
    //   128: anewarray 4	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: aload_2
    //   134: aastore
    //   135: invokestatic 412	com/tencent/mm/plugin/normsg/d/i:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   138: checkcast 416	android/os/IInterface
    //   141: astore_2
    //   142: aload_0
    //   143: getstatic 96	com/tencent/mm/plugin/normsg/d/b:AFk	Ljava/lang/ClassLoader;
    //   146: aload_2
    //   147: invokevirtual 419	java/lang/Object:getClass	()Ljava/lang/Class;
    //   150: invokevirtual 423	java/lang/Class:getInterfaces	()[Ljava/lang/Class;
    //   153: new 20	com/tencent/mm/plugin/normsg/d/b$c
    //   156: dup
    //   157: aload_0
    //   158: aload_2
    //   159: invokespecial 426	com/tencent/mm/plugin/normsg/d/b$c:<init>	(Lcom/tencent/mm/plugin/normsg/d/b;Landroid/os/IInterface;)V
    //   162: invokestatic 432	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   165: checkcast 416	android/os/IInterface
    //   168: putfield 224	com/tencent/mm/plugin/normsg/d/b:AFK	Landroid/os/IInterface;
    //   171: getstatic 110	com/tencent/mm/plugin/normsg/d/b:AFm	Ljava/lang/String;
    //   174: getstatic 114	com/tencent/mm/plugin/normsg/d/b:AFn	Ljava/lang/String;
    //   177: invokestatic 436	com/tencent/mm/plugin/normsg/d/i:jh	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   180: checkcast 438	java/util/Map
    //   183: ldc_w 409
    //   186: aload_0
    //   187: getfield 224	com/tencent/mm/plugin/normsg/d/b:AFK	Landroid/os/IInterface;
    //   190: invokeinterface 442 1 0
    //   195: invokeinterface 446 3 0
    //   200: pop
    //   201: ldc_w 448
    //   204: ldc_w 450
    //   207: iconst_1
    //   208: anewarray 90	java/lang/Class
    //   211: dup
    //   212: iconst_0
    //   213: ldc_w 452
    //   216: aastore
    //   217: invokestatic 407	com/tencent/mm/plugin/normsg/d/i:b	([Ljava/lang/Class;)[Ljava/lang/Class;
    //   220: iconst_1
    //   221: anewarray 4	java/lang/Object
    //   224: dup
    //   225: iconst_0
    //   226: aload_1
    //   227: aastore
    //   228: invokestatic 455	com/tencent/mm/plugin/normsg/d/i:b	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   231: astore_2
    //   232: aload_2
    //   233: ldc_w 457
    //   236: invokestatic 460	com/tencent/mm/plugin/normsg/d/i:d	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   239: astore_1
    //   240: aload_1
    //   241: ifnull +85 -> 326
    //   244: aload_1
    //   245: monitorenter
    //   246: aload_2
    //   247: ldc_w 462
    //   250: aload_0
    //   251: getfield 224	com/tencent/mm/plugin/normsg/d/b:AFK	Landroid/os/IInterface;
    //   254: invokestatic 465	com/tencent/mm/plugin/normsg/d/i:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V
    //   257: aload_1
    //   258: monitorexit
    //   259: aload_0
    //   260: iconst_1
    //   261: putfield 226	com/tencent/mm/plugin/normsg/d/b:mInitialized	Z
    //   264: ldc_w 379
    //   267: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: goto -249 -> 21
    //   273: astore_1
    //   274: new 31	com/tencent/mm/plugin/normsg/d/b$f
    //   277: dup
    //   278: aload_1
    //   279: invokespecial 467	com/tencent/mm/plugin/normsg/d/b$f:<init>	(Ljava/lang/Throwable;)V
    //   282: astore_1
    //   283: ldc_w 379
    //   286: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload_1
    //   290: athrow
    //   291: astore_1
    //   292: aconst_null
    //   293: astore_1
    //   294: goto -54 -> 240
    //   297: astore_2
    //   298: aload_1
    //   299: monitorexit
    //   300: ldc_w 379
    //   303: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload_2
    //   307: athrow
    //   308: astore_1
    //   309: new 31	com/tencent/mm/plugin/normsg/d/b$f
    //   312: dup
    //   313: aload_1
    //   314: invokespecial 467	com/tencent/mm/plugin/normsg/d/b$f:<init>	(Ljava/lang/Throwable;)V
    //   317: astore_1
    //   318: ldc_w 379
    //   321: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: aload_1
    //   325: athrow
    //   326: aload_2
    //   327: ldc_w 462
    //   330: aload_0
    //   331: getfield 224	com/tencent/mm/plugin/normsg/d/b:AFK	Landroid/os/IInterface;
    //   334: invokestatic 465	com/tencent/mm/plugin/normsg/d/i:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V
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
    private b.i AFP;
    private WeakReference<Object> AFQ;
    
    a(Object paramObject, IBinder paramIBinder)
    {
      super(paramIBinder);
      AppMethodBeat.i(149045);
      this.AFP = null;
      this.AFQ = null;
      try
      {
        this.AFQ = new WeakReference(paramObject);
        this.AFP = new b.i(b.this, i.findClass(b.AFr + "$Stub"));
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
      if (this.AFP == null)
      {
        Log.e("MicroMsg.AED", "init failed, give up intercepting.");
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        AppMethodBeat.o(149046);
        return bool;
      }
      if (this.AFQ.get() == null)
      {
        Log.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        AppMethodBeat.o(149046);
        return bool;
      }
      Object localObject = (String)this.AFP.eyp().get(paramInt1);
      int i;
      IBinder localIBinder;
      for (;;)
      {
        try
        {
          paramParcel1.enforceInterface(b.AFr);
          if (!b.eyg().equals(localObject)) {
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
          Log.printErrStackTrace("MicroMsg.AED", localThrowable, "unexpected exception.", new Object[0]);
          b.a(b.this, localThrowable);
          continue;
          if ((i < 21) || (paramParcel1.readInt() == 0)) {
            continue;
          }
          Region.CREATOR.createFromParcel(paramParcel1);
          continue;
          if (!b.eyh().equals(localThrowable)) {
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
          if (!b.eyi().equals(localIBinder)) {
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
          if (!b.eyj().equals(localIBinder)) {
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
          if (!b.eyk().equals(localIBinder)) {
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
          if (!b.aYa().equals(localIBinder)) {
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
          if (!b.eyl().equals(localIBinder)) {
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
    private final WeakReference<Object> AFQ;
    private final Handler.Callback AFR;
    
    b(Object paramObject, Handler.Callback paramCallback)
    {
      AppMethodBeat.i(149048);
      this.AFQ = new WeakReference(paramObject);
      this.AFR = paramCallback;
      AppMethodBeat.o(149048);
    }
    
    private boolean o(Message paramMessage)
    {
      AppMethodBeat.i(149050);
      if (this.AFR != null)
      {
        boolean bool = this.AFR.handleMessage(paramMessage);
        AppMethodBeat.o(149050);
        return bool;
      }
      AppMethodBeat.o(149050);
      return false;
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(149049);
      Object localObject1 = this.AFQ.get();
      boolean bool;
      if (localObject1 == null)
      {
        Log.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
        bool = o(paramMessage);
        AppMethodBeat.o(149049);
        return bool;
      }
      for (;;)
      {
        try
        {
          localView = (View)i.b(localObject1, "getView", null, new Object[0]);
          if (localView == null)
          {
            Log.e("MicroMsg.AED", "cannot find root view, give up intercepting.");
            bool = o(paramMessage);
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
          i.c(paramMessage.obj, "arg2", localThrowable);
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
        Log.w("MicroMsg.AED", "callback is null, give up intercepting, op: %s", new Object[] { Integer.valueOf(paramMessage.what) });
        bool = o(paramMessage);
        AppMethodBeat.o(149049);
        return bool;
        localObject1 = (IInterface)i.d(paramMessage.obj, "arg1");
        continue;
        localObject1 = (IInterface)i.d(paramMessage.obj, "arg2");
        continue;
        localObject1 = (IInterface)paramMessage.obj;
      }
      if ((Proxy.isProxyClass(localObject1.getClass())) && ((Proxy.getInvocationHandler(localObject1) instanceof b.e)))
      {
        Log.w("MicroMsg.AED", "reused callback, skip rest works.");
        bool = o(paramMessage);
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
          Log.w("MicroMsg.AED", "callback %s's binder is unmarked, give up intercept.", new Object[] { localObject1.getClass().getName() });
          bool = o(paramMessage);
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
              localView = (View)i.b(localView, b.eym(), i.b(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(i) });
              break;
              i = ((Integer)i.d(paramMessage.obj, "argi1")).intValue();
              continue;
              i = paramMessage.arg2;
              continue;
              i = ((Integer)i.d(paramMessage.obj, "argi2")).intValue();
              continue;
              i = paramMessage.arg1;
            }
            i = ((Integer)i.d(paramMessage.obj, "argi3")).intValue();
            continue;
            i = ((Integer)i.d(paramMessage.obj, "argi1")).intValue();
            continue;
            i = paramMessage.arg2;
            continue;
            i = ((Integer)i.d(paramMessage.obj, "argi2")).intValue();
          }
        }
        label839:
        j = paramMessage.what;
        switch (j)
        {
        }
        for (;;)
        {
          bool = o(paramMessage);
          AppMethodBeat.o(149049);
          return bool;
          switch (paramMessage.what)
          {
          case 1: 
          case 1020: 
            while (!b.a(b.this, j, localInteger.intValue(), localView))
            {
              i.b(localObject1, b.eyn(), i.b(new Class[] { Boolean.TYPE, Integer.TYPE }), new Object[] { Boolean.FALSE, Integer.valueOf(i) });
              AppMethodBeat.o(149049);
              return true;
              j = ((Integer)i.d(paramMessage.obj, "argi2")).intValue();
            }
            localObject1 = (IInterface)Proxy.newProxyInstance(b.eyf(), localObject1.getClass().getInterfaces(), new b.e((IInterface)localObject1, localInteger)
            {
              public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
              {
                AppMethodBeat.i(149047);
                Object localObject = paramAnonymousMethod.getName();
                if (b.AFD.equals(localObject))
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
                  if (b.eyo().equals(localObject))
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
              i.c(paramMessage.obj, "arg1", localObject1);
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
    private InvocationHandler AFV;
    
    c(IInterface paramIInterface)
    {
      super(paramIInterface);
      AppMethodBeat.i(149052);
      this.AFV = new InvocationHandler()
      {
        public final Object invoke(Object arg1, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        {
          AppMethodBeat.i(149051);
          Object localObject;
          synchronized (b.this)
          {
            localObject = paramAnonymousMethod.getName();
            if (b.bUk().equals(localObject))
            {
              paramAnonymousMethod = b.b(b.this);
              AppMethodBeat.o(149051);
              return paramAnonymousMethod;
            }
          }
          try
          {
            paramAnonymousArrayOfObject = paramAnonymousMethod.invoke(b.c.this.AFY.asBinder(), paramAnonymousArrayOfObject);
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
      Object localObject = b.eyf();
      InvocationHandler localInvocationHandler = this.AFV;
      localObject = (IBinder)Proxy.newProxyInstance((ClassLoader)localObject, new Class[] { IBinder.class }, localInvocationHandler);
      AppMethodBeat.o(149054);
      return localObject;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(149053);
      Object localObject6;
      if ((b.AFs.equals(paramMethod.getName())) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
      {
        localObject6 = paramArrayOfObject[1];
        try
        {
          if (!i.findClass(b.AFr).isAssignableFrom(localObject6.getClass()))
          {
            IllegalStateException localIllegalStateException = new IllegalStateException("mismatched conn class: " + localObject6.getClass() + ", give up intercepting.");
            AppMethodBeat.o(149053);
            throw localIllegalStateException;
          }
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.AED", localThrowable, "unexpected exception.", new Object[0]);
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
        localWeakReference = (WeakReference)i.d(localObject6, b.AFq);
        localObject4 = localWeakReference.get();
        if (localObject4 != null) {
          break;
        }
        Log.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
      }
      if (Build.VERSION.SDK_INT < 16) {}
      Object localObject3;
      for (Object localObject1 = localObject4;; localObject3 = i.d(i.b(localObject4, b.boU(), null, new Object[0]), "mHandler")) {
        for (;;)
        {
          Object localObject5 = (Handler.Callback)i.d(localObject1, b.AFp);
          if (!(localObject5 instanceof b.b)) {
            i.c(localObject1, b.AFp, new b.b(b.this, localObject4, (Handler.Callback)localObject5));
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
            paramArrayOfObject[1] = ((IInterface)i.a(b.AFr + "$Stub", "asInterface", i.b(new Class[] { IBinder.class }), new Object[] { localObject1 }));
          }
        }
      }
    }
  }
  
  class d
    extends Binder
  {
    protected final IBinder AFX;
    
    d(IBinder paramIBinder)
    {
      this.AFX = paramIBinder;
    }
    
    public void dump(FileDescriptor paramFileDescriptor, String[] paramArrayOfString)
    {
      AppMethodBeat.i(149058);
      try
      {
        this.AFX.dump(paramFileDescriptor, paramArrayOfString);
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
        this.AFX.dumpAsync(paramFileDescriptor, paramArrayOfString);
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
        String str = this.AFX.getInterfaceDescriptor();
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
      boolean bool = this.AFX.isBinderAlive();
      AppMethodBeat.o(149057);
      return bool;
    }
    
    public void linkToDeath(IBinder.DeathRecipient paramDeathRecipient, int paramInt)
    {
      AppMethodBeat.i(149061);
      try
      {
        this.AFX.linkToDeath(paramDeathRecipient, paramInt);
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
        if (this.AFX.isBinderAlive())
        {
          boolean bool = this.AFX.transact(paramInt1, paramParcel1, paramParcel2, paramInt2);
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
      boolean bool = this.AFX.pingBinder();
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
      boolean bool = this.AFX.unlinkToDeath(paramDeathRecipient, paramInt);
      AppMethodBeat.o(149062);
      return bool;
    }
  }
  
  class e
    implements InvocationHandler
  {
    protected final IInterface AFY;
    
    e(IInterface paramIInterface)
    {
      this.AFY = paramIInterface;
    }
    
    public IBinder asBinder()
    {
      AppMethodBeat.i(149064);
      IBinder localIBinder = this.AFY.asBinder();
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
        paramObject = paramMethod.invoke(this.AFY, paramArrayOfObject);
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
  
  public static abstract interface g
  {
    public abstract void a(int paramInt, View paramView, List<AccessibilityNodeInfo> paramList);
    
    public abstract boolean a(int paramInt1, int paramInt2, View paramView);
    
    public abstract void onError(Throwable paramThrowable);
  }
  
  static final class h
  {
    static final b AFZ;
    
    static
    {
      AppMethodBeat.i(149065);
      AFZ = new b((byte)0);
      AppMethodBeat.o(149065);
    }
  }
  
  final class i
    implements IBinder
  {
    private final Class<?> AGa;
    private a<String> AGb = null;
    private String AGc = null;
    
    i()
    {
      Object localObject;
      this.AGa = localObject;
    }
    
    public final void dump(FileDescriptor paramFileDescriptor, String[] paramArrayOfString) {}
    
    public final void dumpAsync(FileDescriptor paramFileDescriptor, String[] paramArrayOfString) {}
    
    public final SparseArray<String> eyp()
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
          if (this.AGb != null)
          {
            localObject1 = this.AGb;
            AppMethodBeat.o(149068);
            return localObject1;
          }
          this.AGb = new a((byte)0);
          try
          {
            localObject1 = (IInterface)i.b(this.AGa, "asInterface", i.b(new Class[] { IBinder.class }), new Object[] { this });
            Class[] arrayOfClass1 = this.AGa.getInterfaces();
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
              this.AGc = localObject4.getName();
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
            Log.printErrStackTrace("MicroMsg.AED", localThrowable, "unexpected exception.", new Object[0]);
            b.a(b.this, localThrowable);
            this.AGb.clear();
            a locala = this.AGb;
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
        if (this.AGb != null) {
          this.AGb.put(paramInt1, this.AGc);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.b
 * JD-Core Version:    0.7.0.1
 */