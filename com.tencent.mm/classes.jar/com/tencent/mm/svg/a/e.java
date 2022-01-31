package com.tencent.mm.svg.a;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.svg.b.b;
import com.tencent.mm.svg.b.c.a;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

public class e
{
  private static Class<?> bYU;
  protected static Application bYV;
  protected static String sPackageName;
  protected static Resources sResources;
  private static boolean ySg;
  private static volatile c ySh;
  private static LongSparseArray<Drawable.ConstantState>[] ySi;
  private static LongSparseArray<Drawable.ConstantState> ySj;
  private static e<Drawable.ConstantState> ySk;
  private static e<Drawable.ConstantState> ySl;
  private static LongSparseArray<b> ySm;
  private static a ySn;
  protected static Class<d> ySo;
  private static volatile boolean ySp;
  private static Map<WeakReference<Resources>, Map<Long, Integer>> ySq;
  private static boolean ySr;
  private static ThreadLocal<Boolean> ySs;
  private static final boolean ySt;
  private static final byte[] ySu;
  private static TypedValue ySv;
  private static Method yjk;
  private static Method yjl;
  
  static
  {
    AppMethodBeat.i(70118);
    ySg = false;
    bYU = null;
    ySp = false;
    ySq = new HashMap();
    ySr = false;
    ySs = new ThreadLocal();
    ySt = "xiaomi".equalsIgnoreCase(Build.BRAND);
    ySu = new byte[0];
    ySv = new TypedValue();
    yjk = null;
    yjl = null;
    AppMethodBeat.o(70118);
  }
  
  public static void A(Class<?> paramClass)
  {
    bYU = paramClass;
  }
  
  private static b a(long paramLong, d paramd)
  {
    AppMethodBeat.i(156018);
    int i;
    try
    {
      if ((ySm != null) && (ySm.indexOfKey(paramLong) >= 0))
      {
        paramd = (b)ySm.get(paramLong);
        AppMethodBeat.o(156018);
        return paramd;
      }
      localObject = dAh();
      try
      {
        d.b(paramd).getValue(d.a(paramd), (TypedValue)localObject, true);
        long l = ((TypedValue)localObject).assetCookie;
        i = ((TypedValue)localObject).data;
        if (paramLong == (l << 32 | i)) {
          return null;
        }
        i = ((TypedValue)localObject).data;
        b((TypedValue)localObject);
        com.tencent.mm.svg.b.c.w("MicroMsg.SVGResourceLoader", "Found a res need justify, %s %s %s", new Object[] { Integer.valueOf(d.a(paramd)), Long.valueOf(paramLong), Integer.valueOf(i) });
        if (ySn == null) {
          ySn = new a();
        }
        localObject = ySn.a(sResources.getAssets(), paramLong);
        if (localObject == null)
        {
          AppMethodBeat.o(156018);
          return null;
        }
      }
      finally
      {
        b((TypedValue)localObject);
        AppMethodBeat.o(156018);
      }
      if (((String)localObject).endsWith(".svg")) {
        break label269;
      }
    }
    catch (Throwable paramd)
    {
      com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramd, "", new Object[0]);
      AppMethodBeat.o(156018);
      return null;
    }
    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "Found a res not SVG, %s %s", new Object[] { Long.valueOf(paramLong), localObject });
    paramd = new b(null, true);
    AppMethodBeat.o(156018);
    return paramd;
    label269:
    Object localObject = ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1, ((String)localObject).lastIndexOf("."));
    int j = d.b(paramd).getIdentifier((String)localObject, "raw", bYV.getPackageName());
    if (j == 0)
    {
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "Justified SVG failed, %s %s %s", new Object[] { Integer.valueOf(j), Long.valueOf(paramLong), localObject });
      AppMethodBeat.o(156018);
      return null;
    }
    if (ySm == null) {
      ySm = new LongSparseArray();
    }
    paramd = new b(new d(j, d.b(paramd), paramLong, i), false);
    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "Justified SVG done, %s %s %s", new Object[] { Integer.valueOf(j), Long.valueOf(paramLong), localObject });
    ySm.put(paramLong, paramd);
    AppMethodBeat.o(156018);
    return paramd;
  }
  
  public static void a(Application paramApplication, Resources paramResources, String paramString)
  {
    AppMethodBeat.i(70107);
    d(paramApplication, paramString);
    if (ySp)
    {
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "svg loaded, skip this time.", new Object[0]);
      AppMethodBeat.o(70107);
      return;
    }
    long l;
    try
    {
      bool = b(paramApplication, paramResources);
      if (!bool)
      {
        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
        l = System.nanoTime();
        hE(paramApplication);
        try
        {
          d(paramApplication, paramResources);
          com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
          AppMethodBeat.o(70107);
          return;
        }
        catch (ClassNotFoundException paramApplication)
        {
          for (;;)
          {
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramApplication, "", new Object[0]);
          }
        }
      }
      ySp = true;
      AppMethodBeat.o(70107);
      return;
    }
    catch (StackOverflowError paramString)
    {
      boolean bool;
      com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramString, "", new Object[0]);
      try
      {
        bool = b(paramApplication, paramResources);
        if (bool) {}
      }
      catch (StackOverflowError paramString)
      {
        try
        {
          d(paramApplication, paramResources);
          com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
          AppMethodBeat.o(70107);
          return;
          paramString = paramString;
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "StackOverflowError again.", new Object[0]);
          bool = false;
        }
        catch (ClassNotFoundException paramApplication)
        {
          for (;;)
          {
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramApplication, "", new Object[0]);
          }
        }
        ySp = true;
        AppMethodBeat.o(70107);
        return;
      }
    }
    finally
    {
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
      l = System.nanoTime();
      hE(paramApplication);
    }
    try
    {
      d(paramApplication, paramResources);
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
      AppMethodBeat.o(70107);
      throw paramString;
    }
    catch (ClassNotFoundException paramApplication)
    {
      for (;;)
      {
        com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramApplication, "", new Object[0]);
      }
    }
  }
  
  @TargetApi(16)
  private static void a(Context paramContext, Object paramObject)
  {
    AppMethodBeat.i(70110);
    paramObject = new com.tencent.mm.svg.b.a(paramObject, "sPreloadedDrawables").get();
    if (paramObject != null)
    {
      int i;
      long l;
      if ((paramObject instanceof LongSparseArray[]))
      {
        ySi = (LongSparseArray[])paramObject;
        com.tencent.mm.svg.b.c.d("MicroMsg.SVGResourceLoader", "sPreloadDrawable content: %s ", new Object[] { ySi[0] });
        i = 0;
        while (i < ySi[0].size())
        {
          l = ySi[0].keyAt(i);
          ySk.put(l, ySi[0].get(l));
          i += 1;
        }
        i = 0;
        while (i < ySi[1].size())
        {
          l = ySi[1].keyAt(i);
          ySl.put(l, ySi[1].get(l));
          i += 1;
        }
        ySi[0] = ySk;
        ySi[1] = ySl;
        AppMethodBeat.o(70110);
        return;
      }
      if ((paramObject instanceof LongSparseArray))
      {
        paramContext = new com.tencent.mm.svg.b.a(paramContext.getResources(), "sPreloadedDrawables");
        paramObject = (LongSparseArray)paramContext.get();
        i = 0;
        while (i < paramObject.size())
        {
          l = paramObject.keyAt(i);
          ySk.put(l, paramObject.get(l));
          i += 1;
        }
        paramObject = ySk;
        paramContext.prepare();
        if (paramContext.erN == null)
        {
          paramContext = new NoSuchFieldException();
          AppMethodBeat.o(70110);
          throw paramContext;
        }
        paramContext.erN.set(paramContext.obj, paramObject);
        if (paramContext.get() == null) {
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "resourcePreloadDrawable is null!! OMG!!", new Object[0]);
        }
        AppMethodBeat.o(70110);
        return;
      }
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is others!! OMG!", new Object[0]);
      AppMethodBeat.o(70110);
      return;
    }
    com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is null!! OMG!!!", new Object[0]);
    AppMethodBeat.o(70110);
  }
  
  public static void a(Resources paramResources, Map<Long, Integer> paramMap)
  {
    AppMethodBeat.i(70104);
    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "addFilterResources:".concat(String.valueOf(paramResources)), new Object[0]);
    Iterator localIterator = ySq.keySet().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((WeakReference)localIterator.next()).get() != paramResources);
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        ySq.put(new WeakReference(paramResources), paramMap);
      }
      AppMethodBeat.o(70104);
      return;
    }
  }
  
  public static void a(c.a parama)
  {
    AppMethodBeat.i(70105);
    com.tencent.mm.svg.b.c.b(parama);
    AppMethodBeat.o(70105);
  }
  
  private static final void b(TypedValue paramTypedValue)
  {
    synchronized (ySu)
    {
      if (ySv == null) {
        ySv = paramTypedValue;
      }
      return;
    }
  }
  
  /* Error */
  private static boolean b(Application paramApplication, Resources paramResources)
  {
    // Byte code:
    //   0: ldc_w 440
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 442	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 443	java/lang/StringBuilder:<init>	()V
    //   13: getstatic 445	com/tencent/mm/svg/a/e:sPackageName	Ljava/lang/String;
    //   16: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 451
    //   22: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 454	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 4
    //   30: ldc 172
    //   32: ldc_w 456
    //   35: iconst_0
    //   36: anewarray 4	java/lang/Object
    //   39: invokestatic 218	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aload 4
    //   44: invokestatic 462	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   47: astore 5
    //   49: invokestatic 300	java/lang/System:nanoTime	()J
    //   52: lstore_2
    //   53: aload_0
    //   54: putstatic 237	com/tencent/mm/svg/a/e:bYV	Landroid/app/Application;
    //   57: aload 5
    //   59: putstatic 464	com/tencent/mm/svg/a/e:ySo	Ljava/lang/Class;
    //   62: aload_1
    //   63: putstatic 196	com/tencent/mm/svg/a/e:sResources	Landroid/content/res/Resources;
    //   66: getstatic 464	com/tencent/mm/svg/a/e:ySo	Ljava/lang/Class;
    //   69: astore_1
    //   70: aload_1
    //   71: ifnonnull +38 -> 109
    //   74: ldc 172
    //   76: ldc_w 466
    //   79: iconst_1
    //   80: anewarray 4	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: invokestatic 300	java/lang/System:nanoTime	()J
    //   88: lload_2
    //   89: lsub
    //   90: ldc2_w 310
    //   93: ldiv
    //   94: invokestatic 185	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   97: aastore
    //   98: invokestatic 218	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: ldc_w 440
    //   104: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: iconst_1
    //   108: ireturn
    //   109: aload 5
    //   111: invokevirtual 469	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   114: checkcast 471	com/tencent/mm/svg/a/d
    //   117: aload_0
    //   118: getstatic 196	com/tencent/mm/svg/a/e:sResources	Landroid/content/res/Resources;
    //   121: invokestatic 474	com/tencent/mm/svg/a/e:c	(Landroid/app/Application;Landroid/content/res/Resources;)Lcom/tencent/mm/svg/a/e$c;
    //   124: invokeinterface 478 2 0
    //   129: ldc 172
    //   131: ldc_w 480
    //   134: iconst_1
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_0
    //   141: getstatic 196	com/tencent/mm/svg/a/e:sResources	Landroid/content/res/Resources;
    //   144: invokestatic 474	com/tencent/mm/svg/a/e:c	(Landroid/app/Application;Landroid/content/res/Resources;)Lcom/tencent/mm/svg/a/e$c;
    //   147: getfield 483	com/tencent/mm/svg/a/e$c:yRQ	Ljava/util/Map;
    //   150: invokeinterface 484 1 0
    //   155: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   158: aastore
    //   159: invokestatic 218	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: iconst_1
    //   163: putstatic 75	com/tencent/mm/svg/a/e:ySg	Z
    //   166: goto -92 -> 74
    //   169: astore_0
    //   170: ldc 172
    //   172: ldc_w 486
    //   175: iconst_1
    //   176: anewarray 4	java/lang/Object
    //   179: dup
    //   180: iconst_0
    //   181: aload 4
    //   183: aastore
    //   184: invokestatic 265	com/tencent/mm/svg/b/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: ldc_w 440
    //   190: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: iconst_0
    //   194: ireturn
    //   195: astore_0
    //   196: ldc 172
    //   198: aload_0
    //   199: ldc_w 488
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 209	com/tencent/mm/svg/b/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: iconst_0
    //   210: putstatic 75	com/tencent/mm/svg/a/e:ySg	Z
    //   213: goto -139 -> 74
    //   216: astore_0
    //   217: ldc 172
    //   219: aload_0
    //   220: ldc 205
    //   222: iconst_0
    //   223: anewarray 4	java/lang/Object
    //   226: invokestatic 209	com/tencent/mm/svg/b/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: ldc 172
    //   231: ldc_w 490
    //   234: iconst_1
    //   235: anewarray 4	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload 4
    //   242: aastore
    //   243: invokestatic 265	com/tencent/mm/svg/b/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: goto -59 -> 187
    //   249: astore_0
    //   250: ldc 172
    //   252: ldc_w 492
    //   255: iconst_1
    //   256: anewarray 4	java/lang/Object
    //   259: dup
    //   260: iconst_0
    //   261: aload 4
    //   263: aastore
    //   264: invokestatic 265	com/tencent/mm/svg/b/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   267: ldc 172
    //   269: aload_0
    //   270: ldc 205
    //   272: iconst_0
    //   273: anewarray 4	java/lang/Object
    //   276: invokestatic 209	com/tencent/mm/svg/b/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: goto -92 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramApplication	Application
    //   0	282	1	paramResources	Resources
    //   52	37	2	l	long
    //   28	234	4	str	String
    //   47	63	5	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   30	66	169	java/lang/ClassNotFoundException
    //   66	70	169	java/lang/ClassNotFoundException
    //   74	101	169	java/lang/ClassNotFoundException
    //   109	162	169	java/lang/ClassNotFoundException
    //   162	166	169	java/lang/ClassNotFoundException
    //   196	213	169	java/lang/ClassNotFoundException
    //   66	70	195	android/content/res/Resources$NotFoundException
    //   109	162	195	android/content/res/Resources$NotFoundException
    //   30	66	216	java/lang/InstantiationException
    //   66	70	216	java/lang/InstantiationException
    //   74	101	216	java/lang/InstantiationException
    //   109	162	216	java/lang/InstantiationException
    //   162	166	216	java/lang/InstantiationException
    //   196	213	216	java/lang/InstantiationException
    //   30	66	249	java/lang/IllegalAccessException
    //   66	70	249	java/lang/IllegalAccessException
    //   74	101	249	java/lang/IllegalAccessException
    //   109	162	249	java/lang/IllegalAccessException
    //   162	166	249	java/lang/IllegalAccessException
    //   196	213	249	java/lang/IllegalAccessException
  }
  
  private static c c(Application paramApplication, Resources paramResources)
  {
    AppMethodBeat.i(70108);
    if (ySh == null) {}
    try
    {
      if (ySh == null) {
        ySh = new c(a.dAb(), paramApplication, paramResources);
      }
      paramApplication = ySh;
      AppMethodBeat.o(70108);
      return paramApplication;
    }
    finally
    {
      AppMethodBeat.o(70108);
    }
  }
  
  private static void d(Application paramApplication, Resources paramResources)
  {
    AppMethodBeat.i(70113);
    Object localObject = dAg();
    if (localObject == null)
    {
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "Raw class is null!", new Object[0]);
      AppMethodBeat.o(70113);
      return;
    }
    localObject = ((Class)localObject).getDeclaredFields();
    paramResources = c(paramApplication, paramResources);
    try
    {
      a locala = new a();
      int i = 0;
      while (i < localObject.length)
      {
        int j = localObject[i].getInt(null);
        if (locala.h(paramApplication.getResources(), j)) {
          paramResources.NQ(j);
        }
        i += 1;
      }
      ySg = true;
    }
    catch (IllegalAccessException paramApplication)
    {
      ySg = false;
      AppMethodBeat.o(70113);
      return;
    }
    catch (IllegalArgumentException paramApplication)
    {
      ySg = false;
      AppMethodBeat.o(70113);
      return;
    }
    AppMethodBeat.o(70113);
  }
  
  public static void d(Application paramApplication, String paramString)
  {
    AppMethodBeat.i(70106);
    if (ySr)
    {
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "svg initiated.", new Object[0]);
      AppMethodBeat.o(70106);
      return;
    }
    sPackageName = paramString;
    a.dC(paramString);
    b.dC(paramString);
    bYV = paramApplication;
    hE(paramApplication);
    AppMethodBeat.o(70106);
  }
  
  private static Class<?> dAg()
  {
    AppMethodBeat.i(70112);
    Class localClass1;
    if (bYU != null)
    {
      localClass1 = bYU;
      AppMethodBeat.o(70112);
      return localClass1;
    }
    try
    {
      localClass1 = Class.forName(sPackageName + ".R$raw");
      if (localClass1 != null)
      {
        AppMethodBeat.o(70112);
        return localClass1;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass2 = b.dAl();
      if (localClass2 != null)
      {
        AppMethodBeat.o(70112);
        return localClass2;
      }
      AppMethodBeat.o(70112);
    }
    return null;
  }
  
  private static final TypedValue dAh()
  {
    TypedValue localTypedValue1 = null;
    AppMethodBeat.i(156017);
    synchronized (ySu)
    {
      if (ySv != null)
      {
        localTypedValue1 = ySv;
        ySv = null;
      }
      if (localTypedValue1 == null)
      {
        localTypedValue1 = new TypedValue();
        AppMethodBeat.o(156017);
        return localTypedValue1;
      }
    }
    AppMethodBeat.o(156017);
    return localTypedValue2;
  }
  
  public static Drawable e(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(70114);
    ySs.set(Boolean.TRUE);
    paramResources = paramResources.getDrawable(paramInt);
    ySs.set(Boolean.FALSE);
    AppMethodBeat.o(70114);
    return paramResources;
  }
  
  public static Drawable f(Resources paramResources, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(70115);
    Object localObject3 = new TypedValue();
    paramResources.getValue(paramInt, (TypedValue)localObject3, true);
    Object localObject1 = null;
    if ((((TypedValue)localObject3).type >= 28) && (((TypedValue)localObject3).type <= 31)) {}
    for (;;)
    {
      if (i != 0) {
        localObject1 = new ColorDrawable(((TypedValue)localObject3).data);
      }
      if (yjk == null) {}
      Object localObject2;
      try
      {
        localObject2 = Resources.class.getDeclaredMethod("loadXmlResourceParser", new Class[] { String.class, Integer.TYPE, Integer.TYPE, String.class });
        yjk = (Method)localObject2;
        ((Method)localObject2).setAccessible(true);
        if (yjl == null) {}
        localObject1 = ((TypedValue)localObject3).string.toString();
      }
      catch (NoSuchMethodException paramResources)
      {
        try
        {
          localObject2 = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[] { Integer.TYPE, String.class, Integer.TYPE });
          yjl = (Method)localObject2;
          ((Method)localObject2).setAccessible(true);
          localObject2 = localObject1;
          if (localObject1 != null) {
            break label354;
          }
          if (((TypedValue)localObject3).string != null) {
            break label274;
          }
          paramResources = new Resources.NotFoundException("Resource is not a Drawable (color or path): ".concat(String.valueOf(localObject3)));
          AppMethodBeat.o(70115);
          throw paramResources;
        }
        catch (NoSuchMethodException paramResources)
        {
          ab.printErrStackTrace("MicroMsg.SVGResourceLoader", paramResources, "", new Object[0]);
          ab.printErrStackTrace("MicroMsg.SVGResourceLoader", paramResources, "", new Object[0]);
          AppMethodBeat.o(70115);
          return null;
        }
        paramResources = paramResources;
        ab.printErrStackTrace("MicroMsg.SVGResourceLoader", paramResources, "", new Object[0]);
        ab.printErrStackTrace("MicroMsg.SVGResourceLoader", paramResources, "", new Object[0]);
        AppMethodBeat.o(70115);
        return null;
      }
      label274:
      if (((String)localObject1).endsWith(".xml")) {}
      for (;;)
      {
        try
        {
          localObject3 = (XmlResourceParser)yjk.invoke(paramResources, new Object[] { localObject1, Integer.valueOf(paramInt), Integer.valueOf(((TypedValue)localObject3).assetCookie), "drawable" });
          localObject2 = Drawable.createFromXml(paramResources, (XmlPullParser)localObject3);
          ((XmlResourceParser)localObject3).close();
          label354:
          AppMethodBeat.o(70115);
          return localObject2;
        }
        catch (Exception paramResources)
        {
          localObject1 = new Resources.NotFoundException("File " + (String)localObject1 + " from drawable resource ID #0x" + Integer.toHexString(paramInt));
          ((Resources.NotFoundException)localObject1).initCause(paramResources);
          AppMethodBeat.o(70115);
          throw ((Throwable)localObject1);
        }
        try
        {
          InputStream localInputStream = (InputStream)yjl.invoke(paramResources.getAssets(), new Object[] { Integer.valueOf(((TypedValue)localObject3).assetCookie), localObject1, Integer.valueOf(2) });
          localObject2 = Drawable.createFromResourceStream(paramResources, (TypedValue)localObject3, localInputStream, (String)localObject1, null);
          localInputStream.close();
        }
        catch (Exception paramResources)
        {
          localObject1 = new Resources.NotFoundException("File " + (String)localObject1 + " from drawable resource ID #0x" + Integer.toHexString(paramInt));
          ((Resources.NotFoundException)localObject1).initCause(paramResources);
          AppMethodBeat.o(70115);
          throw ((Throwable)localObject1);
        }
      }
      i = 0;
    }
  }
  
  @TargetApi(16)
  private static void hE(Context paramContext)
  {
    AppMethodBeat.i(70109);
    if (ySk == null) {
      try
      {
        ySj = new LongSparseArray();
        Object localObject = new e();
        ySk = (e)localObject;
        ((e)localObject).ySj = ySj;
        localObject = new e();
        ySl = (e)localObject;
        ((e)localObject).ySj = ySj;
        if (Build.VERSION.SDK_INT >= 23)
        {
          localObject = new com.tencent.mm.svg.b.a(paramContext.getResources(), "mResourcesImpl");
          if (((com.tencent.mm.svg.b.a)localObject).Mb()) {
            localObject = ((com.tencent.mm.svg.b.a)localObject).get();
          }
        }
        for (;;)
        {
          a(paramContext, localObject);
          com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG this resources %s", new Object[] { paramContext.getResources() });
          AppMethodBeat.o(70109);
          return;
          localObject = paramContext.getResources();
          continue;
          localObject = paramContext.getResources();
        }
        AppMethodBeat.o(70109);
      }
      catch (NoSuchFieldException paramContext)
      {
        com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramContext, "Call reflectPreloadCache failed. Reason : NoSuchFieldException.", new Object[0]);
        AppMethodBeat.o(70109);
        return;
      }
      catch (IllegalAccessException paramContext)
      {
        com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramContext, "Call reflectPreloadCache failed. Reason : IllegalAccessException.", new Object[0]);
        AppMethodBeat.o(70109);
        return;
      }
      catch (IllegalArgumentException paramContext)
      {
        com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramContext, "Call reflectPreloadCache failed. Reason : IllegalArgumentException.", new Object[0]);
      }
    }
  }
  
  protected static final class a
  {
    private boolean mInited;
    private Field ySw;
    private Method ySx;
    
    public a()
    {
      AppMethodBeat.i(156014);
      this.mInited = false;
      try
      {
        this.ySw = AssetManager.class.getDeclaredField("mApkAssets");
        this.ySw.setAccessible(true);
        this.ySx = Class.forName("android.content.res.ApkAssets").getDeclaredMethod("getStringFromPool", new Class[] { Integer.TYPE });
        this.ySx.setAccessible(true);
        this.mInited = true;
        AppMethodBeat.o(156014);
        return;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", localThrowable, "", new Object[0]);
        AppMethodBeat.o(156014);
      }
    }
    
    public final String a(AssetManager paramAssetManager, long paramLong)
    {
      AppMethodBeat.i(156015);
      if (!this.mInited)
      {
        AppMethodBeat.o(156015);
        return null;
      }
      int i = (int)(paramLong >> 32);
      int j = (int)(0xFFFFFFFF & paramLong);
      try
      {
        paramAssetManager = ((Object[])(Object[])this.ySw.get(paramAssetManager))[(i - 1)];
        paramAssetManager = (String)this.ySx.invoke(paramAssetManager, new Object[] { Integer.valueOf(j) });
        AppMethodBeat.o(156015);
        return paramAssetManager;
      }
      catch (Throwable paramAssetManager)
      {
        com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramAssetManager, "", new Object[0]);
        AppMethodBeat.o(156015);
      }
      return null;
    }
  }
  
  static final class b
  {
    Drawable.ConstantState ySy;
    boolean ySz;
    
    b(Drawable.ConstantState paramConstantState, boolean paramBoolean)
    {
      this.ySy = paramConstantState;
      this.ySz = paramBoolean;
    }
  }
  
  public static final class c
  {
    private Resources mResources;
    private TypedValue yRL;
    Map<Integer, com.tencent.mm.svg.c> yRQ;
    private Application ySA;
    
    public c(Map<Integer, com.tencent.mm.svg.c> paramMap, Application paramApplication, Resources paramResources)
    {
      AppMethodBeat.i(70094);
      this.yRL = new TypedValue();
      this.yRQ = paramMap;
      this.ySA = paramApplication;
      this.mResources = paramResources;
      AppMethodBeat.o(70094);
    }
    
    public final void NQ(int paramInt)
    {
      AppMethodBeat.i(145988);
      e.a(this.ySA, this.mResources, paramInt, this.yRL);
      AppMethodBeat.o(145988);
    }
    
    public final void a(Integer paramInteger, com.tencent.mm.svg.c paramc)
    {
      AppMethodBeat.i(70095);
      this.yRQ.put(paramInteger, paramc);
      e.a(this.ySA, this.mResources, paramInteger.intValue(), this.yRL);
      AppMethodBeat.o(70095);
    }
  }
  
  protected static final class d
    extends Drawable.ConstantState
  {
    private Resources mResources;
    private int trq;
    private long ySB;
    private int ySC;
    
    public d(int paramInt1, Resources paramResources, long paramLong, int paramInt2)
    {
      AppMethodBeat.i(156016);
      this.trq = 0;
      this.ySB = 0L;
      this.ySC = 0;
      if (paramInt1 == 0)
      {
        com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "SVGConstantState Why this id is %d. TypedValue %s", new Object[] { Integer.valueOf(paramInt1) });
        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
      }
      this.trq = paramInt1;
      this.mResources = paramResources;
      this.ySB = paramLong;
      this.ySC = paramInt2;
      AppMethodBeat.o(156016);
    }
    
    public final int getChangingConfigurations()
    {
      return 0;
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(70097);
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "newDrawable mResources %s %s %s %s", new Object[] { this.mResources, Integer.valueOf(this.trq), Long.valueOf(this.ySB), Integer.valueOf(this.ySC) });
      Drawable localDrawable = a.g(this.mResources, this.trq);
      AppMethodBeat.o(70097);
      return localDrawable;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      AppMethodBeat.i(70098);
      try
      {
        Map localMap = e.i(paramResources);
        if (localMap != null)
        {
          int i = ((Integer)localMap.get(Long.valueOf(this.ySB))).intValue();
          paramResources = e.f(paramResources, i);
          com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "loadDrawableSkipCache id:" + Integer.toHexString(i) + ",drawable:" + paramResources, new Object[0]);
          AppMethodBeat.o(70098);
          return paramResources;
        }
      }
      catch (Exception paramResources)
      {
        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "newDrawable loadDrawableSkipCache error:" + paramResources.getMessage(), new Object[0]);
        paramResources = newDrawable();
        AppMethodBeat.o(70098);
      }
      return paramResources;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      AppMethodBeat.i(70099);
      paramResources = newDrawable(paramResources);
      AppMethodBeat.o(70099);
      return paramResources;
    }
  }
  
  @TargetApi(16)
  public static final class e<T>
    extends LongSparseArray<T>
  {
    public static boolean ySD = false;
    LongSparseArray<T> ySj = null;
    
    public final void clear()
    {
      AppMethodBeat.i(70103);
      super.clear();
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! clear.", new Object[0]);
      AppMethodBeat.o(70103);
    }
    
    public final void delete(long paramLong)
    {
      AppMethodBeat.i(70101);
      super.delete(paramLong);
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! delete key %s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(70101);
    }
    
    public final T get(long paramLong, T paramT)
    {
      AppMethodBeat.i(70100);
      if ((e.dAi().get() == null) || (!((Boolean)e.dAi().get()).booleanValue())) {}
      label168:
      for (;;)
      {
        synchronized (this.ySj)
        {
          if (this.ySj.indexOfKey(paramLong) >= 0)
          {
            Object localObject = this.ySj.get(paramLong, paramT);
            if (!e.aTJ()) {
              break label168;
            }
            e.b localb = e.b(paramLong, (e.d)localObject);
            if (localb == null) {
              break label168;
            }
            if (!localb.ySz)
            {
              localObject = localb.ySy;
              if (localObject != null)
              {
                AppMethodBeat.o(70100);
                return localObject;
              }
            }
            else
            {
              localObject = null;
              continue;
            }
          }
          paramT = super.get(paramLong, paramT);
          AppMethodBeat.o(70100);
          return paramT;
        }
        com.tencent.mm.svg.b.c.d("MicroMsg.SVGLongSparseArray", "Skip svg this time for key %s", new Object[] { Long.valueOf(paramLong) });
      }
    }
    
    public final void remove(long paramLong)
    {
      AppMethodBeat.i(70102);
      super.remove(paramLong);
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! remove key %s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(70102);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.a.e
 * JD-Core Version:    0.7.0.1
 */