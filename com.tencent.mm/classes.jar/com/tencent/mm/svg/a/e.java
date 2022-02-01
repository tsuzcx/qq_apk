package com.tencent.mm.svg.a;

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
import android.util.LongSparseArray;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private static Method acmb;
  private static Method acmc;
  private static boolean adoM;
  private static volatile c adoN;
  private static LongSparseArray<Drawable.ConstantState>[] adoO;
  private static LongSparseArray<Drawable.ConstantState> adoP;
  private static e<Drawable.ConstantState> adoQ;
  private static e<Drawable.ConstantState> adoR;
  private static LongSparseArray<b> adoS;
  private static a adoT;
  protected static Class<d> adoU;
  private static volatile boolean adoV;
  private static Map<WeakReference<Resources>, Map<Long, Integer>> adoW;
  private static boolean adoX;
  private static ThreadLocal<Boolean> adoY;
  private static final boolean adoZ;
  private static final byte[] adpa;
  private static TypedValue adpb;
  private static Class<?> hhL;
  protected static Application hhM;
  protected static String sPackageName;
  protected static Resources sResources;
  
  static
  {
    AppMethodBeat.i(148752);
    adoM = false;
    hhL = null;
    adoV = false;
    adoW = new HashMap();
    adoX = false;
    adoY = new ThreadLocal();
    adoZ = "xiaomi".equalsIgnoreCase(Build.BRAND);
    adpa = new byte[0];
    adpb = new TypedValue();
    acmb = null;
    acmc = null;
    AppMethodBeat.o(148752);
  }
  
  private static b a(long paramLong, d paramd)
  {
    AppMethodBeat.i(148746);
    int i;
    try
    {
      if ((adoS != null) && (adoS.indexOfKey(paramLong) >= 0))
      {
        paramd = (b)adoS.get(paramLong);
        AppMethodBeat.o(148746);
        return paramd;
      }
      localObject = jes();
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
        if (adoT == null) {
          adoT = new a();
        }
        localObject = adoT.a(sResources.getAssets(), paramLong);
        if (localObject == null)
        {
          AppMethodBeat.o(148746);
          return null;
        }
      }
      finally
      {
        b((TypedValue)localObject);
        AppMethodBeat.o(148746);
      }
      if (((String)localObject).endsWith(".svg")) {
        break label269;
      }
    }
    finally
    {
      com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramd, "", new Object[0]);
      AppMethodBeat.o(148746);
      return null;
    }
    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "Found a res not SVG, %s %s", new Object[] { Long.valueOf(paramLong), localObject });
    paramd = new b(null, true);
    AppMethodBeat.o(148746);
    return paramd;
    label269:
    Object localObject = ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1, ((String)localObject).lastIndexOf("."));
    int j = d.b(paramd).getIdentifier((String)localObject, "raw", hhM.getPackageName());
    if (j == 0)
    {
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "Justified SVG failed, %s %s %s", new Object[] { Integer.valueOf(j), Long.valueOf(paramLong), localObject });
      AppMethodBeat.o(148746);
      return null;
    }
    if (adoS == null) {
      adoS = new LongSparseArray();
    }
    paramd = new b(new d(j, d.b(paramd), paramLong, i), false);
    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "Justified SVG done, %s %s %s", new Object[] { Integer.valueOf(j), Long.valueOf(paramLong), localObject });
    adoS.put(paramLong, paramd);
    AppMethodBeat.o(148746);
    return paramd;
  }
  
  public static void a(Application paramApplication, Resources paramResources, String paramString)
  {
    AppMethodBeat.i(148739);
    c(paramApplication, paramString);
    if (adoV)
    {
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "svg loaded, skip this time.", new Object[0]);
      AppMethodBeat.o(148739);
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
        mH(paramApplication);
        try
        {
          d(paramApplication, paramResources);
          com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
          AppMethodBeat.o(148739);
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
      adoV = true;
      AppMethodBeat.o(148739);
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
          AppMethodBeat.o(148739);
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
        adoV = true;
        AppMethodBeat.o(148739);
        return;
      }
    }
    finally
    {
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
      l = System.nanoTime();
      mH(paramApplication);
    }
    try
    {
      d(paramApplication, paramResources);
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
      AppMethodBeat.o(148739);
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
  
  public static void a(Resources paramResources, Map<Long, Integer> paramMap)
  {
    AppMethodBeat.i(148735);
    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "addFilterResources:".concat(String.valueOf(paramResources)), new Object[0]);
    Iterator localIterator = adoW.keySet().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((WeakReference)localIterator.next()).get() != paramResources);
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        adoW.put(new WeakReference(paramResources), paramMap);
      }
      AppMethodBeat.o(148735);
      return;
    }
  }
  
  public static void a(c.a parama)
  {
    AppMethodBeat.i(148736);
    com.tencent.mm.svg.b.c.b(parama);
    AppMethodBeat.o(148736);
  }
  
  public static void at(Class<?> paramClass)
  {
    hhL = paramClass;
  }
  
  private static void b(Context paramContext, Object paramObject)
  {
    AppMethodBeat.i(148742);
    paramObject = new com.tencent.mm.svg.b.a(paramObject, "sPreloadedDrawables").get();
    if (paramObject != null)
    {
      int i;
      long l;
      if ((paramObject instanceof LongSparseArray[]))
      {
        adoO = (LongSparseArray[])paramObject;
        com.tencent.mm.svg.b.c.d("MicroMsg.SVGResourceLoader", "sPreloadDrawable content: %s ", new Object[] { adoO[0] });
        i = 0;
        while (i < adoO[0].size())
        {
          l = adoO[0].keyAt(i);
          adoQ.put(l, (Drawable.ConstantState)adoO[0].get(l));
          i += 1;
        }
        i = 0;
        while (i < adoO[1].size())
        {
          l = adoO[1].keyAt(i);
          adoR.put(l, (Drawable.ConstantState)adoO[1].get(l));
          i += 1;
        }
        adoO[0] = adoQ;
        adoO[1] = adoR;
        AppMethodBeat.o(148742);
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
          adoQ.put(l, (Drawable.ConstantState)paramObject.get(l));
          i += 1;
        }
        paramObject = adoQ;
        paramContext.prepare();
        if (paramContext.dEn == null)
        {
          paramContext = new NoSuchFieldException();
          AppMethodBeat.o(148742);
          throw paramContext;
        }
        paramContext.dEn.set(paramContext.obj, paramObject);
        if (paramContext.get() == null) {
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "resourcePreloadDrawable is null!! OMG!!", new Object[0]);
        }
        AppMethodBeat.o(148742);
        return;
      }
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is others!! OMG!", new Object[0]);
      AppMethodBeat.o(148742);
      return;
    }
    com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is null!! OMG!!!", new Object[0]);
    AppMethodBeat.o(148742);
  }
  
  private static final void b(TypedValue paramTypedValue)
  {
    synchronized (adpa)
    {
      if (adpb == null) {
        adpb = paramTypedValue;
      }
      return;
    }
  }
  
  /* Error */
  private static boolean b(Application paramApplication, Resources paramResources)
  {
    // Byte code:
    //   0: ldc_w 438
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 440	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 441	java/lang/StringBuilder:<init>	()V
    //   13: getstatic 443	com/tencent/mm/svg/a/e:sPackageName	Ljava/lang/String;
    //   16: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 449
    //   22: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 452	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 8
    //   30: ldc 173
    //   32: ldc_w 454
    //   35: iconst_0
    //   36: anewarray 4	java/lang/Object
    //   39: invokestatic 219	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aload 8
    //   44: invokestatic 460	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   47: astore 9
    //   49: invokestatic 303	java/lang/System:nanoTime	()J
    //   52: lstore_2
    //   53: aload_0
    //   54: putstatic 238	com/tencent/mm/svg/a/e:hhM	Landroid/app/Application;
    //   57: aload 9
    //   59: putstatic 462	com/tencent/mm/svg/a/e:adoU	Ljava/lang/Class;
    //   62: aload_1
    //   63: putstatic 197	com/tencent/mm/svg/a/e:sResources	Landroid/content/res/Resources;
    //   66: getstatic 462	com/tencent/mm/svg/a/e:adoU	Ljava/lang/Class;
    //   69: astore_1
    //   70: aload_1
    //   71: ifnonnull +38 -> 109
    //   74: ldc 173
    //   76: ldc_w 464
    //   79: iconst_1
    //   80: anewarray 4	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: invokestatic 303	java/lang/System:nanoTime	()J
    //   88: lload_2
    //   89: lsub
    //   90: ldc2_w 313
    //   93: ldiv
    //   94: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   97: aastore
    //   98: invokestatic 219	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: ldc_w 438
    //   104: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: iconst_1
    //   108: ireturn
    //   109: invokestatic 467	java/lang/System:currentTimeMillis	()J
    //   112: lstore 4
    //   114: aload 9
    //   116: invokevirtual 470	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   119: checkcast 472	com/tencent/mm/svg/a/d
    //   122: aload_0
    //   123: getstatic 197	com/tencent/mm/svg/a/e:sResources	Landroid/content/res/Resources;
    //   126: invokestatic 475	com/tencent/mm/svg/a/e:c	(Landroid/app/Application;Landroid/content/res/Resources;)Lcom/tencent/mm/svg/a/e$c;
    //   129: invokeinterface 479 2 0
    //   134: invokestatic 467	java/lang/System:currentTimeMillis	()J
    //   137: lstore 6
    //   139: ldc 173
    //   141: ldc_w 481
    //   144: iconst_2
    //   145: anewarray 4	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload_0
    //   151: getstatic 197	com/tencent/mm/svg/a/e:sResources	Landroid/content/res/Resources;
    //   154: invokestatic 475	com/tencent/mm/svg/a/e:c	(Landroid/app/Application;Landroid/content/res/Resources;)Lcom/tencent/mm/svg/a/e$c;
    //   157: getfield 484	com/tencent/mm/svg/a/e$c:adow	Ljava/util/Map;
    //   160: invokeinterface 485 1 0
    //   165: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: aastore
    //   169: dup
    //   170: iconst_1
    //   171: lload 6
    //   173: lload 4
    //   175: lsub
    //   176: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   179: aastore
    //   180: invokestatic 219	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: iconst_1
    //   184: putstatic 75	com/tencent/mm/svg/a/e:adoM	Z
    //   187: goto -113 -> 74
    //   190: astore_0
    //   191: ldc 173
    //   193: ldc_w 487
    //   196: iconst_1
    //   197: anewarray 4	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: aload 8
    //   204: aastore
    //   205: invokestatic 266	com/tencent/mm/svg/b/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: ldc_w 438
    //   211: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: iconst_0
    //   215: ireturn
    //   216: astore_0
    //   217: ldc 173
    //   219: aload_0
    //   220: ldc_w 489
    //   223: iconst_0
    //   224: anewarray 4	java/lang/Object
    //   227: invokestatic 210	com/tencent/mm/svg/b/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: iconst_0
    //   231: putstatic 75	com/tencent/mm/svg/a/e:adoM	Z
    //   234: goto -160 -> 74
    //   237: astore_0
    //   238: ldc 173
    //   240: aload_0
    //   241: ldc 206
    //   243: iconst_0
    //   244: anewarray 4	java/lang/Object
    //   247: invokestatic 210	com/tencent/mm/svg/b/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: ldc 173
    //   252: ldc_w 491
    //   255: iconst_1
    //   256: anewarray 4	java/lang/Object
    //   259: dup
    //   260: iconst_0
    //   261: aload 8
    //   263: aastore
    //   264: invokestatic 266	com/tencent/mm/svg/b/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   267: goto -59 -> 208
    //   270: astore_0
    //   271: ldc 173
    //   273: ldc_w 493
    //   276: iconst_1
    //   277: anewarray 4	java/lang/Object
    //   280: dup
    //   281: iconst_0
    //   282: aload 8
    //   284: aastore
    //   285: invokestatic 266	com/tencent/mm/svg/b/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   288: ldc 173
    //   290: aload_0
    //   291: ldc 206
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 210	com/tencent/mm/svg/b/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: goto -92 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramApplication	Application
    //   0	303	1	paramResources	Resources
    //   52	37	2	l1	long
    //   112	62	4	l2	long
    //   137	35	6	l3	long
    //   28	255	8	str	String
    //   47	68	9	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   30	66	190	java/lang/ClassNotFoundException
    //   66	70	190	java/lang/ClassNotFoundException
    //   74	101	190	java/lang/ClassNotFoundException
    //   109	183	190	java/lang/ClassNotFoundException
    //   183	187	190	java/lang/ClassNotFoundException
    //   217	234	190	java/lang/ClassNotFoundException
    //   66	70	216	android/content/res/Resources$NotFoundException
    //   109	183	216	android/content/res/Resources$NotFoundException
    //   30	66	237	java/lang/InstantiationException
    //   66	70	237	java/lang/InstantiationException
    //   74	101	237	java/lang/InstantiationException
    //   109	183	237	java/lang/InstantiationException
    //   183	187	237	java/lang/InstantiationException
    //   217	234	237	java/lang/InstantiationException
    //   30	66	270	java/lang/IllegalAccessException
    //   66	70	270	java/lang/IllegalAccessException
    //   74	101	270	java/lang/IllegalAccessException
    //   109	183	270	java/lang/IllegalAccessException
    //   183	187	270	java/lang/IllegalAccessException
    //   217	234	270	java/lang/IllegalAccessException
  }
  
  private static c c(Application paramApplication, Resources paramResources)
  {
    AppMethodBeat.i(148740);
    if (adoN == null) {}
    try
    {
      if (adoN == null) {
        adoN = new c(a.jel(), paramApplication, paramResources);
      }
      paramApplication = adoN;
      AppMethodBeat.o(148740);
      return paramApplication;
    }
    finally
    {
      AppMethodBeat.o(148740);
    }
  }
  
  public static void c(Application paramApplication, String paramString)
  {
    AppMethodBeat.i(148737);
    if (adoX)
    {
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "svg initiated.", new Object[0]);
      AppMethodBeat.o(148737);
      return;
    }
    sPackageName = paramString;
    a.setPackageName(paramString);
    b.setPackageName(paramString);
    hhM = paramApplication;
    mH(paramApplication);
    AppMethodBeat.o(148737);
  }
  
  private static void d(Application paramApplication, Resources paramResources)
  {
    AppMethodBeat.i(148744);
    Object localObject = jer();
    if (localObject == null)
    {
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "Raw class is null!", new Object[0]);
      AppMethodBeat.o(148744);
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
        if (locala.k(paramApplication.getResources(), j)) {
          paramResources.azq(j);
        }
        i += 1;
      }
      adoM = true;
    }
    catch (IllegalAccessException paramApplication)
    {
      adoM = false;
      AppMethodBeat.o(148744);
      return;
    }
    catch (IllegalArgumentException paramApplication)
    {
      adoM = false;
      AppMethodBeat.o(148744);
      return;
    }
    AppMethodBeat.o(148744);
  }
  
  public static Drawable g(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(148747);
    if (paramResources == null)
    {
      AppMethodBeat.o(148747);
      return null;
    }
    adoY.set(Boolean.TRUE);
    paramResources = paramResources.getDrawable(paramInt);
    adoY.set(Boolean.FALSE);
    AppMethodBeat.o(148747);
    return paramResources;
  }
  
  public static Drawable h(Resources paramResources, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(148748);
    Object localObject3 = new TypedValue();
    paramResources.getValue(paramInt, (TypedValue)localObject3, true);
    Object localObject1 = null;
    if ((((TypedValue)localObject3).type >= 28) && (((TypedValue)localObject3).type <= 31)) {}
    for (;;)
    {
      if (i != 0) {
        localObject1 = new ColorDrawable(((TypedValue)localObject3).data);
      }
      if (acmb == null) {}
      Object localObject2;
      try
      {
        localObject2 = Resources.class.getDeclaredMethod("loadXmlResourceParser", new Class[] { String.class, Integer.TYPE, Integer.TYPE, String.class });
        acmb = (Method)localObject2;
        ((Method)localObject2).setAccessible(true);
        if (acmc == null) {}
        localObject1 = ((TypedValue)localObject3).string.toString();
      }
      catch (NoSuchMethodException paramResources)
      {
        try
        {
          localObject2 = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[] { Integer.TYPE, String.class, Integer.TYPE });
          acmc = (Method)localObject2;
          ((Method)localObject2).setAccessible(true);
          localObject2 = localObject1;
          if (localObject1 != null) {
            break label354;
          }
          if (((TypedValue)localObject3).string != null) {
            break label274;
          }
          paramResources = new Resources.NotFoundException("Resource is not a Drawable (color or path): ".concat(String.valueOf(localObject3)));
          AppMethodBeat.o(148748);
          throw paramResources;
        }
        catch (NoSuchMethodException paramResources)
        {
          com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.SVGResourceLoader", paramResources, "", new Object[0]);
          com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.SVGResourceLoader", paramResources, "", new Object[0]);
          AppMethodBeat.o(148748);
          return null;
        }
        paramResources = paramResources;
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.SVGResourceLoader", paramResources, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.SVGResourceLoader", paramResources, "", new Object[0]);
        AppMethodBeat.o(148748);
        return null;
      }
      label274:
      if (((String)localObject1).endsWith(".xml")) {}
      for (;;)
      {
        try
        {
          localObject3 = (XmlResourceParser)acmb.invoke(paramResources, new Object[] { localObject1, Integer.valueOf(paramInt), Integer.valueOf(((TypedValue)localObject3).assetCookie), "drawable" });
          localObject2 = Drawable.createFromXml(paramResources, (XmlPullParser)localObject3);
          ((XmlResourceParser)localObject3).close();
          label354:
          AppMethodBeat.o(148748);
          return localObject2;
        }
        catch (Exception paramResources)
        {
          localObject1 = new Resources.NotFoundException("File " + (String)localObject1 + " from drawable resource ID #0x" + Integer.toHexString(paramInt));
          ((Resources.NotFoundException)localObject1).initCause(paramResources);
          AppMethodBeat.o(148748);
          throw ((Throwable)localObject1);
        }
        try
        {
          InputStream localInputStream = (InputStream)acmc.invoke(paramResources.getAssets(), new Object[] { Integer.valueOf(((TypedValue)localObject3).assetCookie), localObject1, Integer.valueOf(2) });
          localObject2 = Drawable.createFromResourceStream(paramResources, (TypedValue)localObject3, localInputStream, (String)localObject1, null);
          localInputStream.close();
        }
        catch (Exception paramResources)
        {
          localObject1 = new Resources.NotFoundException("File " + (String)localObject1 + " from drawable resource ID #0x" + Integer.toHexString(paramInt));
          ((Resources.NotFoundException)localObject1).initCause(paramResources);
          AppMethodBeat.o(148748);
          throw ((Throwable)localObject1);
        }
      }
      i = 0;
    }
  }
  
  private static Class<?> jer()
  {
    AppMethodBeat.i(148743);
    Class localClass1;
    if (hhL != null)
    {
      localClass1 = hhL;
      AppMethodBeat.o(148743);
      return localClass1;
    }
    try
    {
      localClass1 = Class.forName(sPackageName + ".R$raw");
      if (localClass1 != null)
      {
        AppMethodBeat.o(148743);
        return localClass1;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass2 = b.jew();
      if (localClass2 != null)
      {
        AppMethodBeat.o(148743);
        return localClass2;
      }
      AppMethodBeat.o(148743);
    }
    return null;
  }
  
  private static final TypedValue jes()
  {
    TypedValue localTypedValue1 = null;
    AppMethodBeat.i(148745);
    synchronized (adpa)
    {
      if (adpb != null)
      {
        localTypedValue1 = adpb;
        adpb = null;
      }
      if (localTypedValue1 == null)
      {
        localTypedValue1 = new TypedValue();
        AppMethodBeat.o(148745);
        return localTypedValue1;
      }
    }
    AppMethodBeat.o(148745);
    return localTypedValue2;
  }
  
  private static void mH(Context paramContext)
  {
    AppMethodBeat.i(148741);
    if (adoQ == null) {
      try
      {
        adoP = new LongSparseArray();
        Object localObject = new e();
        adoQ = (e)localObject;
        ((e)localObject).adoP = adoP;
        localObject = new e();
        adoR = (e)localObject;
        ((e)localObject).adoP = adoP;
        if (Build.VERSION.SDK_INT >= 23)
        {
          localObject = new com.tencent.mm.svg.b.a(paramContext.getResources(), "mResourcesImpl");
          if (((com.tencent.mm.svg.b.a)localObject).aPM()) {
            localObject = ((com.tencent.mm.svg.b.a)localObject).get();
          }
        }
        for (;;)
        {
          b(paramContext, localObject);
          com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG this resources %s", new Object[] { paramContext.getResources() });
          AppMethodBeat.o(148741);
          return;
          localObject = paramContext.getResources();
          continue;
          localObject = paramContext.getResources();
        }
        AppMethodBeat.o(148741);
      }
      catch (NoSuchFieldException paramContext)
      {
        com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramContext, "Call reflectPreloadCache failed. Reason : NoSuchFieldException.", new Object[0]);
        AppMethodBeat.o(148741);
        return;
      }
      catch (IllegalAccessException paramContext)
      {
        com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramContext, "Call reflectPreloadCache failed. Reason : IllegalAccessException.", new Object[0]);
        AppMethodBeat.o(148741);
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
    private Field adpc;
    private Method adpd;
    private boolean mInited;
    
    public a()
    {
      AppMethodBeat.i(148722);
      this.mInited = false;
      try
      {
        if ((Build.VERSION.SDK_INT > 28) || ((Build.VERSION.SDK_INT == 28) && (Build.VERSION.PREVIEW_SDK_INT != 0)))
        {
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "below 28", new Object[0]);
          AppMethodBeat.o(148722);
          return;
        }
        this.adpc = AssetManager.class.getDeclaredField("mApkAssets");
        this.adpc.setAccessible(true);
        this.adpd = Class.forName("android.content.res.ApkAssets").getDeclaredMethod("getStringFromPool", new Class[] { Integer.TYPE });
        this.adpd.setAccessible(true);
        this.mInited = true;
        AppMethodBeat.o(148722);
        return;
      }
      finally
      {
        com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", localThrowable, "", new Object[0]);
        AppMethodBeat.o(148722);
      }
    }
    
    public final String a(AssetManager paramAssetManager, long paramLong)
    {
      AppMethodBeat.i(148723);
      if (!this.mInited)
      {
        AppMethodBeat.o(148723);
        return null;
      }
      int i = (int)(paramLong >> 32);
      int j = (int)(0xFFFFFFFF & paramLong);
      try
      {
        paramAssetManager = ((Object[])this.adpc.get(paramAssetManager))[(i - 1)];
        paramAssetManager = (String)this.adpd.invoke(paramAssetManager, new Object[] { Integer.valueOf(j) });
        AppMethodBeat.o(148723);
        return paramAssetManager;
      }
      finally
      {
        com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramAssetManager, "", new Object[0]);
        AppMethodBeat.o(148723);
      }
      return null;
    }
  }
  
  static final class b
  {
    Drawable.ConstantState adpe;
    boolean adpf;
    
    b(Drawable.ConstantState paramConstantState, boolean paramBoolean)
    {
      this.adpe = paramConstantState;
      this.adpf = paramBoolean;
    }
  }
  
  public static class c
  {
    private TypedValue ador;
    Map<Integer, com.tencent.mm.svg.c> adow;
    private Application adpg;
    private Resources mResources;
    
    public c(Map<Integer, com.tencent.mm.svg.c> paramMap, Application paramApplication, Resources paramResources)
    {
      AppMethodBeat.i(148724);
      this.ador = new TypedValue();
      this.adow = paramMap;
      this.adpg = paramApplication;
      this.mResources = paramResources;
      AppMethodBeat.o(148724);
    }
    
    public final void E(Integer paramInteger)
    {
      AppMethodBeat.i(231810);
      e.a(this.adpg, this.mResources, paramInteger.intValue(), this.ador);
      AppMethodBeat.o(231810);
    }
    
    public final void azq(int paramInt)
    {
      AppMethodBeat.i(148726);
      e.a(this.adpg, this.mResources, paramInt, this.ador);
      AppMethodBeat.o(148726);
    }
  }
  
  protected static final class d
    extends Drawable.ConstantState
  {
    private int Utm;
    private long adph;
    private int adpi;
    private Resources mResources;
    
    public d(int paramInt1, Resources paramResources, long paramLong, int paramInt2)
    {
      AppMethodBeat.i(148727);
      this.Utm = 0;
      this.adph = 0L;
      this.adpi = 0;
      if (paramInt1 == 0)
      {
        com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "SVGConstantState Why this id is %d. TypedValue %s", new Object[] { Integer.valueOf(paramInt1) });
        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", android.util.Log.getStackTraceString(new Throwable()), new Object[0]);
      }
      this.Utm = paramInt1;
      this.mResources = paramResources;
      this.adph = paramLong;
      this.adpi = paramInt2;
      AppMethodBeat.o(148727);
    }
    
    public final int getChangingConfigurations()
    {
      return 0;
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(148728);
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "newDrawable mResources %s %s %s %s", new Object[] { this.mResources, Integer.valueOf(this.Utm), Long.valueOf(this.adph), Integer.valueOf(this.adpi) });
      Drawable localDrawable = a.i(this.mResources, this.Utm);
      AppMethodBeat.o(148728);
      return localDrawable;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      AppMethodBeat.i(148729);
      try
      {
        Map localMap = e.i(paramResources);
        if (localMap != null)
        {
          int i = ((Integer)localMap.get(Long.valueOf(this.adph))).intValue();
          paramResources = e.h(paramResources, i);
          com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "loadDrawableSkipCache id:" + Integer.toHexString(i) + ",drawable:" + paramResources, new Object[0]);
          AppMethodBeat.o(148729);
          return paramResources;
        }
      }
      catch (Exception paramResources)
      {
        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "newDrawable loadDrawableSkipCache error:" + paramResources.getMessage(), new Object[0]);
        paramResources = newDrawable();
        AppMethodBeat.o(148729);
      }
      return paramResources;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      AppMethodBeat.i(148730);
      paramResources = newDrawable(paramResources);
      AppMethodBeat.o(148730);
      return paramResources;
    }
  }
  
  public static final class e<T>
    extends LongSparseArray<T>
  {
    public static boolean adpj = false;
    LongSparseArray<T> adoP = null;
    
    public final void clear()
    {
      AppMethodBeat.i(148734);
      super.clear();
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! clear.", new Object[0]);
      AppMethodBeat.o(148734);
    }
    
    public final void delete(long paramLong)
    {
      AppMethodBeat.i(148732);
      super.delete(paramLong);
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! delete key %s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(148732);
    }
    
    public final T get(long paramLong, T paramT)
    {
      AppMethodBeat.i(148731);
      if ((e.jet().get() == null) || (!((Boolean)e.jet().get()).booleanValue())) {}
      label168:
      for (;;)
      {
        synchronized (this.adoP)
        {
          if (this.adoP.indexOfKey(paramLong) >= 0)
          {
            Object localObject = this.adoP.get(paramLong, paramT);
            if (!e.XU()) {
              break label168;
            }
            e.b localb = e.b(paramLong, (e.d)localObject);
            if (localb == null) {
              break label168;
            }
            if (!localb.adpf)
            {
              localObject = localb.adpe;
              if (localObject != null)
              {
                AppMethodBeat.o(148731);
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
          AppMethodBeat.o(148731);
          return paramT;
        }
        com.tencent.mm.svg.b.c.d("MicroMsg.SVGLongSparseArray", "Skip svg this time for key %s", new Object[] { Long.valueOf(paramLong) });
      }
    }
    
    public final void remove(long paramLong)
    {
      AppMethodBeat.i(148733);
      super.remove(paramLong);
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! remove key %s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(148733);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.svg.a.e
 * JD-Core Version:    0.7.0.1
 */