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
  private static final String GyA;
  private static final String GyB;
  private static final String GyC;
  private static final String GyD;
  private static final String GyE;
  private static final String GyF;
  private static final String GyG;
  private static final String GyH;
  private static final String GyI;
  private static final String GyJ;
  private static final String GyK;
  private static final String GyL;
  private static final String GyM;
  private static final String GyN;
  private static final String GyO;
  private static final String GyP;
  private static final ClassLoader Gyu;
  private static final String Gyv;
  private static final String Gyw;
  private static final String Gyx;
  private static final String Gyy;
  private static final String Gyz;
  public final Queue<g> GyQ;
  private final Map<Object, IBinder> GyR;
  private final Map<IBinder, Integer> GyS;
  private IInterface GyT;
  private volatile boolean mInitialized;
  private final Handler mMainThreadHandler;
  
  static
  {
    AppMethodBeat.i(149084);
    Gyu = b.class.getClassLoader();
    Gyv = d.aTf("");
    Gyw = d.aTf("\021p\036z\bg\016jD+Xv%@2D-N+f\007i\bo\nx");
    Gyx = d.aTf("\007t7V5]8");
    Gyy = d.aTf("\027v\005L\"V3A'F%@");
    Gyz = d.aTf("\ng$E)E'F%N");
    GyA = d.aTf("\016c5\\9N\034s\034h!L<P");
    GyB = d.aTf("Ñ°ÞºÈ§Îªòþ§Æ¥Æ£Ð£Ê¨Á­Ä°Éç®ïïùãèíà©Ç³Ö¤Å¦Ò»Ôºùøóäâ");
    GyC = d.aTf("Ù¸Ü¸ùùïõþûö¿Ñ¥À²Ó°Ä­Â¬ïîåòô");
    GyD = d.aTf("éëÞ½Þ»È»Ò°ÙµÜ¨ÑöçôãåÈ§É½Ï Ì Å·");
    GyE = d.aTf("\032k\036{\tp<S0Q=t\032n\013y\037~\035x");
    GyF = d.aTf("?Y0^:l\005`\027U,m\016m\b{\ba\003j\006o\033b+O");
    GyG = d.aTf("+M$J.o\fo\ny\nc\001h\004m\031`.A%@\tg\001n,U\024w\024q\002q\030z\023\026b\033R6");
    GyH = d.aTf("");
    GyI = d.aTf("÷ðÕ¶Õ°Ã°Ù»Ò¾×£Úûú³Ý»Ô§åÊ£Æ±ø");
    GyJ = d.aTf("±×¾Ð´õõãùò÷ú´Û¿ÚýôÅ¼èõ");
    GyK = d.aTf("\rk\002l\bN!B7D");
    GyL = d.aTf("\"D+H=N\035x\031k\b`");
    GyM = d.aTf("m\035x\nl\003q\034]>]8K8Q3Z6_+R\023p\004m\002l");
    GyN = d.aTf("Ì¿Ú®èïÊ©Ê¯Ü¯Æ¤Í¡È¼Åäå¬Â¤Ëüúâ");
    GyO = d.aTf("¬ßºÎáëªÉªÏ¼Ï¦Ä­Á¨Ü¥ëàÌ¢Ä«Øïéñ");
    GyP = d.aTf("îøÜ¹Ë­Â°Ýÿùùò÷êÒ±Å¬Ã­ÿéð");
    AppMethodBeat.o(149084);
  }
  
  private b()
  {
    AppMethodBeat.i(149076);
    this.GyQ = new ConcurrentLinkedQueue();
    this.GyR = new WeakHashMap();
    this.GyS = new ConcurrentHashMap();
    this.mMainThreadHandler = new Handler(Looper.getMainLooper());
    this.GyT = null;
    this.mInitialized = false;
    AppMethodBeat.o(149076);
  }
  
  private void b(int paramInt, View paramView, List<AccessibilityNodeInfo> paramList)
  {
    AppMethodBeat.i(149072);
    Iterator localIterator = this.GyQ.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).a(paramInt, paramView, paramList);
    }
    AppMethodBeat.o(149072);
  }
  
  private boolean b(int paramInt1, int paramInt2, View paramView)
  {
    AppMethodBeat.i(149073);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      boolean bool = c(paramInt1, paramInt2, paramView);
      AppMethodBeat.o(149073);
      return bool;
    }
    boolean[] arrayOfBoolean = new boolean[2];
    boolean[] tmp40_38 = arrayOfBoolean;
    tmp40_38[0] = 1;
    boolean[] tmp46_40 = tmp40_38;
    tmp46_40[1] = 0;
    tmp46_40;
    this.mMainThreadHandler.post(new b.2(this, arrayOfBoolean, paramInt1, paramInt2, paramView));
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
    Iterator localIterator = this.GyQ.iterator();
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
  
  public static b fjJ()
  {
    return b.h.Gzi;
  }
  
  private void o(Throwable paramThrowable)
  {
    AppMethodBeat.i(149075);
    Iterator localIterator = this.GyQ.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).c(paramThrowable);
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
    //   2: ldc_w 377
    //   5: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 219	com/tencent/mm/plugin/normsg/d/b:mInitialized	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 377
    //   18: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: getstatic 383	android/os/Build$VERSION:SDK_INT	I
    //   27: bipush 15
    //   29: if_icmpge +43 -> 72
    //   32: new 25	com/tencent/mm/plugin/normsg/d/b$f
    //   35: dup
    //   36: new 385	java/lang/StringBuilder
    //   39: dup
    //   40: ldc_w 387
    //   43: invokespecial 388	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: getstatic 383	android/os/Build$VERSION:SDK_INT	I
    //   49: invokevirtual 392	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 395	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 396	com/tencent/mm/plugin/normsg/d/b$f:<init>	(Ljava/lang/String;)V
    //   58: astore_1
    //   59: ldc_w 377
    //   62: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: getstatic 103	com/tencent/mm/plugin/normsg/d/b:Gyw	Ljava/lang/String;
    //   75: ldc_w 398
    //   78: iconst_1
    //   79: anewarray 83	java/lang/Class
    //   82: dup
    //   83: iconst_0
    //   84: ldc_w 400
    //   87: aastore
    //   88: invokestatic 405	com/tencent/mm/plugin/normsg/d/i:c	([Ljava/lang/Class;)[Ljava/lang/Class;
    //   91: iconst_1
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: ldc_w 407
    //   100: aastore
    //   101: invokestatic 410	com/tencent/mm/plugin/normsg/d/i:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   104: checkcast 412	android/os/IBinder
    //   107: astore_2
    //   108: getstatic 99	com/tencent/mm/plugin/normsg/d/b:Gyv	Ljava/lang/String;
    //   111: getstatic 111	com/tencent/mm/plugin/normsg/d/b:Gyy	Ljava/lang/String;
    //   114: iconst_1
    //   115: anewarray 83	java/lang/Class
    //   118: dup
    //   119: iconst_0
    //   120: ldc_w 412
    //   123: aastore
    //   124: invokestatic 405	com/tencent/mm/plugin/normsg/d/i:c	([Ljava/lang/Class;)[Ljava/lang/Class;
    //   127: iconst_1
    //   128: anewarray 4	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: aload_2
    //   134: aastore
    //   135: invokestatic 410	com/tencent/mm/plugin/normsg/d/i:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   138: checkcast 414	android/os/IInterface
    //   141: astore_2
    //   142: aload_0
    //   143: getstatic 89	com/tencent/mm/plugin/normsg/d/b:Gyu	Ljava/lang/ClassLoader;
    //   146: aload_2
    //   147: invokevirtual 417	java/lang/Object:getClass	()Ljava/lang/Class;
    //   150: invokevirtual 421	java/lang/Class:getInterfaces	()[Ljava/lang/Class;
    //   153: new 14	com/tencent/mm/plugin/normsg/d/b$c
    //   156: dup
    //   157: aload_0
    //   158: aload_2
    //   159: invokespecial 424	com/tencent/mm/plugin/normsg/d/b$c:<init>	(Lcom/tencent/mm/plugin/normsg/d/b;Landroid/os/IInterface;)V
    //   162: invokestatic 430	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   165: checkcast 414	android/os/IInterface
    //   168: putfield 217	com/tencent/mm/plugin/normsg/d/b:GyT	Landroid/os/IInterface;
    //   171: getstatic 103	com/tencent/mm/plugin/normsg/d/b:Gyw	Ljava/lang/String;
    //   174: getstatic 107	com/tencent/mm/plugin/normsg/d/b:Gyx	Ljava/lang/String;
    //   177: invokestatic 434	com/tencent/mm/plugin/normsg/d/i:js	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   180: checkcast 436	java/util/Map
    //   183: ldc_w 407
    //   186: aload_0
    //   187: getfield 217	com/tencent/mm/plugin/normsg/d/b:GyT	Landroid/os/IInterface;
    //   190: invokeinterface 440 1 0
    //   195: invokeinterface 444 3 0
    //   200: pop
    //   201: ldc_w 446
    //   204: ldc_w 448
    //   207: iconst_1
    //   208: anewarray 83	java/lang/Class
    //   211: dup
    //   212: iconst_0
    //   213: ldc_w 450
    //   216: aastore
    //   217: invokestatic 405	com/tencent/mm/plugin/normsg/d/i:c	([Ljava/lang/Class;)[Ljava/lang/Class;
    //   220: iconst_1
    //   221: anewarray 4	java/lang/Object
    //   224: dup
    //   225: iconst_0
    //   226: aload_1
    //   227: aastore
    //   228: invokestatic 453	com/tencent/mm/plugin/normsg/d/i:b	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   231: astore_2
    //   232: aload_2
    //   233: ldc_w 455
    //   236: invokestatic 458	com/tencent/mm/plugin/normsg/d/i:g	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   239: astore_1
    //   240: aload_1
    //   241: ifnull +85 -> 326
    //   244: aload_1
    //   245: monitorenter
    //   246: aload_2
    //   247: ldc_w 460
    //   250: aload_0
    //   251: getfield 217	com/tencent/mm/plugin/normsg/d/b:GyT	Landroid/os/IInterface;
    //   254: invokestatic 463	com/tencent/mm/plugin/normsg/d/i:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V
    //   257: aload_1
    //   258: monitorexit
    //   259: aload_0
    //   260: iconst_1
    //   261: putfield 219	com/tencent/mm/plugin/normsg/d/b:mInitialized	Z
    //   264: ldc_w 377
    //   267: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: goto -249 -> 21
    //   273: astore_1
    //   274: new 25	com/tencent/mm/plugin/normsg/d/b$f
    //   277: dup
    //   278: aload_1
    //   279: invokespecial 465	com/tencent/mm/plugin/normsg/d/b$f:<init>	(Ljava/lang/Throwable;)V
    //   282: astore_1
    //   283: ldc_w 377
    //   286: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload_1
    //   290: athrow
    //   291: astore_1
    //   292: aconst_null
    //   293: astore_1
    //   294: goto -54 -> 240
    //   297: astore_2
    //   298: aload_1
    //   299: monitorexit
    //   300: ldc_w 377
    //   303: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload_2
    //   307: athrow
    //   308: astore_1
    //   309: new 25	com/tencent/mm/plugin/normsg/d/b$f
    //   312: dup
    //   313: aload_1
    //   314: invokespecial 465	com/tencent/mm/plugin/normsg/d/b$f:<init>	(Ljava/lang/Throwable;)V
    //   317: astore_1
    //   318: ldc_w 377
    //   321: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: aload_1
    //   325: athrow
    //   326: aload_2
    //   327: ldc_w 460
    //   330: aload_0
    //   331: getfield 217	com/tencent/mm/plugin/normsg/d/b:GyT	Landroid/os/IInterface;
    //   334: invokestatic 463	com/tencent/mm/plugin/normsg/d/i:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V
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
    //   298	308	67	finally
    //   309	326	67	finally
    //   326	337	67	finally
    //   72	201	273	java/lang/Throwable
    //   232	240	291	java/lang/Throwable
    //   246	259	297	finally
    //   201	232	308	java/lang/Throwable
    //   244	246	308	java/lang/Throwable
    //   298	308	308	java/lang/Throwable
    //   326	337	308	java/lang/Throwable
  }
  
  final class a
    extends b.d
  {
    private b.i GyY;
    private WeakReference<Object> GyZ;
    
    a(Object paramObject, IBinder paramIBinder)
    {
      super(paramIBinder);
      AppMethodBeat.i(149045);
      this.GyY = null;
      this.GyZ = null;
      try
      {
        this.GyZ = new WeakReference(paramObject);
        this.GyY = new b.i(b.this, i.findClass(b.GyB + "$Stub"));
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
      if (this.GyY == null)
      {
        Log.e("MicroMsg.AED", "init failed, give up intercepting.");
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        AppMethodBeat.o(149046);
        return bool;
      }
      if (this.GyZ.get() == null)
      {
        Log.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        AppMethodBeat.o(149046);
        return bool;
      }
      Object localObject = (String)this.GyY.fjU().get(paramInt1);
      int i;
      IBinder localIBinder;
      for (;;)
      {
        try
        {
          paramParcel1.enforceInterface(b.GyB);
          if (!b.fjL().equals(localObject)) {
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
          if (!b.fjM().equals(localThrowable)) {
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
          if (!b.fjN().equals(localIBinder)) {
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
          if (!b.fjO().equals(localIBinder)) {
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
          if (!b.fjP().equals(localIBinder)) {
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
          if (!b.bhj().equals(localIBinder)) {
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
          if (!b.fjQ().equals(localIBinder)) {
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
    private final WeakReference<Object> GyZ;
    private final Handler.Callback Gza;
    
    b(Object paramObject, Handler.Callback paramCallback)
    {
      AppMethodBeat.i(149048);
      this.GyZ = new WeakReference(paramObject);
      this.Gza = paramCallback;
      AppMethodBeat.o(149048);
    }
    
    private boolean o(Message paramMessage)
    {
      AppMethodBeat.i(149050);
      if (this.Gza != null)
      {
        boolean bool = this.Gza.handleMessage(paramMessage);
        AppMethodBeat.o(149050);
        return bool;
      }
      AppMethodBeat.o(149050);
      return false;
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(149049);
      Object localObject1 = this.GyZ.get();
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
        localObject1 = (IInterface)i.g(paramMessage.obj, "arg1");
        continue;
        localObject1 = (IInterface)i.g(paramMessage.obj, "arg2");
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
              localView = (View)i.b(localView, b.fjR(), i.c(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(i) });
              break;
              i = ((Integer)i.g(paramMessage.obj, "argi1")).intValue();
              continue;
              i = paramMessage.arg2;
              continue;
              i = ((Integer)i.g(paramMessage.obj, "argi2")).intValue();
              continue;
              i = paramMessage.arg1;
            }
            i = ((Integer)i.g(paramMessage.obj, "argi3")).intValue();
            continue;
            i = ((Integer)i.g(paramMessage.obj, "argi1")).intValue();
            continue;
            i = paramMessage.arg2;
            continue;
            i = ((Integer)i.g(paramMessage.obj, "argi2")).intValue();
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
              i.b(localObject1, b.GyP, i.c(new Class[] { Boolean.TYPE, Integer.TYPE }), new Object[] { Boolean.FALSE, Integer.valueOf(i) });
              AppMethodBeat.o(149049);
              return true;
              j = ((Integer)i.g(paramMessage.obj, "argi2")).intValue();
            }
            localObject1 = (IInterface)Proxy.newProxyInstance(b.fjK(), localObject1.getClass().getInterfaces(), new b.e((IInterface)localObject1, localInteger)
            {
              public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
              {
                AppMethodBeat.i(149047);
                Object localObject = paramAnonymousMethod.getName();
                if (b.fjS().equals(localObject))
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
                  if (b.fjT().equals(localObject))
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
    private InvocationHandler Gze;
    
    c(IInterface paramIInterface)
    {
      super(paramIInterface);
      AppMethodBeat.i(149052);
      this.Gze = new InvocationHandler()
      {
        public final Object invoke(Object arg1, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        {
          AppMethodBeat.i(149051);
          Object localObject;
          synchronized (b.this)
          {
            localObject = paramAnonymousMethod.getName();
            if (b.chp().equals(localObject))
            {
              paramAnonymousMethod = b.b(b.this);
              AppMethodBeat.o(149051);
              return paramAnonymousMethod;
            }
          }
          try
          {
            paramAnonymousArrayOfObject = paramAnonymousMethod.invoke(b.c.this.Gzh.asBinder(), paramAnonymousArrayOfObject);
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
      Object localObject = b.fjK();
      InvocationHandler localInvocationHandler = this.Gze;
      localObject = (IBinder)Proxy.newProxyInstance((ClassLoader)localObject, new Class[] { IBinder.class }, localInvocationHandler);
      AppMethodBeat.o(149054);
      return localObject;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(149053);
      Object localObject6;
      if ((b.GyC.equals(paramMethod.getName())) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
      {
        localObject6 = paramArrayOfObject[1];
        try
        {
          if (!i.findClass(b.GyB).isAssignableFrom(localObject6.getClass()))
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
        localWeakReference = (WeakReference)i.g(localObject6, b.GyA);
        localObject4 = localWeakReference.get();
        if (localObject4 != null) {
          break;
        }
        Log.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
      }
      if (Build.VERSION.SDK_INT < 16) {}
      Object localObject3;
      for (Object localObject1 = localObject4;; localObject3 = i.g(i.b(localObject4, b.bzf(), null, new Object[0]), "mHandler")) {
        for (;;)
        {
          Object localObject5 = (Handler.Callback)i.g(localObject1, b.Gyz);
          if (!(localObject5 instanceof b.b)) {
            i.c(localObject1, b.Gyz, new b.b(b.this, localObject4, (Handler.Callback)localObject5));
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
            paramArrayOfObject[1] = ((IInterface)i.a(b.GyB + "$Stub", "asInterface", i.c(new Class[] { IBinder.class }), new Object[] { localObject1 }));
          }
        }
      }
    }
  }
  
  class d
    extends Binder
  {
    protected final IBinder Gzg;
    
    d(IBinder paramIBinder)
    {
      this.Gzg = paramIBinder;
    }
    
    public void dump(FileDescriptor paramFileDescriptor, String[] paramArrayOfString)
    {
      AppMethodBeat.i(149058);
      try
      {
        this.Gzg.dump(paramFileDescriptor, paramArrayOfString);
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
        this.Gzg.dumpAsync(paramFileDescriptor, paramArrayOfString);
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
        String str = this.Gzg.getInterfaceDescriptor();
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
      boolean bool = this.Gzg.isBinderAlive();
      AppMethodBeat.o(149057);
      return bool;
    }
    
    public void linkToDeath(IBinder.DeathRecipient paramDeathRecipient, int paramInt)
    {
      AppMethodBeat.i(149061);
      try
      {
        this.Gzg.linkToDeath(paramDeathRecipient, paramInt);
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
        if (this.Gzg.isBinderAlive())
        {
          boolean bool = this.Gzg.transact(paramInt1, paramParcel1, paramParcel2, paramInt2);
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
      boolean bool = this.Gzg.pingBinder();
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
      boolean bool = this.Gzg.unlinkToDeath(paramDeathRecipient, paramInt);
      AppMethodBeat.o(149062);
      return bool;
    }
  }
  
  class e
    implements InvocationHandler
  {
    protected final IInterface Gzh;
    
    e(IInterface paramIInterface)
    {
      this.Gzh = paramIInterface;
    }
    
    public IBinder asBinder()
    {
      AppMethodBeat.i(149064);
      IBinder localIBinder = this.Gzh.asBinder();
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
        paramObject = paramMethod.invoke(this.Gzh, paramArrayOfObject);
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
    
    public abstract void c(Throwable paramThrowable);
  }
  
  final class i
    implements IBinder
  {
    private final Class<?> Gzj;
    private a<String> Gzk = null;
    private String Gzl = null;
    
    i()
    {
      Object localObject;
      this.Gzj = localObject;
    }
    
    public final void dump(FileDescriptor paramFileDescriptor, String[] paramArrayOfString) {}
    
    public final void dumpAsync(FileDescriptor paramFileDescriptor, String[] paramArrayOfString) {}
    
    public final SparseArray<String> fjU()
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
          if (this.Gzk != null)
          {
            localObject1 = this.Gzk;
            AppMethodBeat.o(149068);
            return localObject1;
          }
          this.Gzk = new a((byte)0);
          try
          {
            localObject1 = (IInterface)i.b(this.Gzj, "asInterface", i.c(new Class[] { IBinder.class }), new Object[] { this });
            Class[] arrayOfClass1 = this.Gzj.getInterfaces();
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
              this.Gzl = localObject4.getName();
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
            this.Gzk.clear();
            a locala = this.Gzk;
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
        if (this.Gzk != null) {
          this.Gzk.put(paramInt1, this.Gzl);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.b
 * JD-Core Version:    0.7.0.1
 */