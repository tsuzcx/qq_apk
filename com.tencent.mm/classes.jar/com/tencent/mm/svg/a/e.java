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
import com.tencent.mm.sdk.platformtools.ad;
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
  private static Method HVK;
  private static Method HVL;
  private static boolean IQj;
  private static volatile c IQk;
  private static LongSparseArray<Drawable.ConstantState>[] IQl;
  private static LongSparseArray<Drawable.ConstantState> IQm;
  private static e<Drawable.ConstantState> IQn;
  private static e<Drawable.ConstantState> IQo;
  private static LongSparseArray<b> IQp;
  private static a IQq;
  protected static Class<d> IQr;
  private static volatile boolean IQs;
  private static Map<WeakReference<Resources>, Map<Long, Integer>> IQt;
  private static boolean IQu;
  private static ThreadLocal<Boolean> IQv;
  private static final boolean IQw;
  private static final byte[] IQx;
  private static TypedValue IQy;
  private static Class<?> cUV;
  protected static Application cUW;
  protected static String sPackageName;
  protected static Resources sResources;
  
  static
  {
    AppMethodBeat.i(148752);
    IQj = false;
    cUV = null;
    IQs = false;
    IQt = new HashMap();
    IQu = false;
    IQv = new ThreadLocal();
    IQw = "xiaomi".equalsIgnoreCase(Build.BRAND);
    IQx = new byte[0];
    IQy = new TypedValue();
    HVK = null;
    HVL = null;
    AppMethodBeat.o(148752);
  }
  
  public static void Y(Class<?> paramClass)
  {
    cUV = paramClass;
  }
  
  private static b a(long paramLong, d paramd)
  {
    AppMethodBeat.i(148746);
    int i;
    try
    {
      if ((IQp != null) && (IQp.indexOfKey(paramLong) >= 0))
      {
        paramd = (b)IQp.get(paramLong);
        AppMethodBeat.o(148746);
        return paramd;
      }
      localObject = fuf();
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
        if (IQq == null) {
          IQq = new a();
        }
        localObject = IQq.a(sResources.getAssets(), paramLong);
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
    catch (Throwable paramd)
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
    int j = d.b(paramd).getIdentifier((String)localObject, "raw", cUW.getPackageName());
    if (j == 0)
    {
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "Justified SVG failed, %s %s %s", new Object[] { Integer.valueOf(j), Long.valueOf(paramLong), localObject });
      AppMethodBeat.o(148746);
      return null;
    }
    if (IQp == null) {
      IQp = new LongSparseArray();
    }
    paramd = new b(new d(j, d.b(paramd), paramLong, i), false);
    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "Justified SVG done, %s %s %s", new Object[] { Integer.valueOf(j), Long.valueOf(paramLong), localObject });
    IQp.put(paramLong, paramd);
    AppMethodBeat.o(148746);
    return paramd;
  }
  
  public static void a(Application paramApplication, Resources paramResources, String paramString)
  {
    AppMethodBeat.i(148739);
    d(paramApplication, paramString);
    if (IQs)
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
        jC(paramApplication);
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
      IQs = true;
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
        IQs = true;
        AppMethodBeat.o(148739);
        return;
      }
    }
    finally
    {
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
      l = System.nanoTime();
      jC(paramApplication);
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
  
  @TargetApi(16)
  private static void a(Context paramContext, Object paramObject)
  {
    AppMethodBeat.i(148742);
    paramObject = new com.tencent.mm.svg.b.a(paramObject, "sPreloadedDrawables").get();
    if (paramObject != null)
    {
      int i;
      long l;
      if ((paramObject instanceof LongSparseArray[]))
      {
        IQl = (LongSparseArray[])paramObject;
        com.tencent.mm.svg.b.c.d("MicroMsg.SVGResourceLoader", "sPreloadDrawable content: %s ", new Object[] { IQl[0] });
        i = 0;
        while (i < IQl[0].size())
        {
          l = IQl[0].keyAt(i);
          IQn.put(l, IQl[0].get(l));
          i += 1;
        }
        i = 0;
        while (i < IQl[1].size())
        {
          l = IQl[1].keyAt(i);
          IQo.put(l, IQl[1].get(l));
          i += 1;
        }
        IQl[0] = IQn;
        IQl[1] = IQo;
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
          IQn.put(l, paramObject.get(l));
          i += 1;
        }
        paramObject = IQn;
        paramContext.prepare();
        if (paramContext.bMM == null)
        {
          paramContext = new NoSuchFieldException();
          AppMethodBeat.o(148742);
          throw paramContext;
        }
        paramContext.bMM.set(paramContext.obj, paramObject);
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
  
  public static void a(Resources paramResources, Map<Long, Integer> paramMap)
  {
    AppMethodBeat.i(148735);
    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "addFilterResources:".concat(String.valueOf(paramResources)), new Object[0]);
    Iterator localIterator = IQt.keySet().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((WeakReference)localIterator.next()).get() != paramResources);
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        IQt.put(new WeakReference(paramResources), paramMap);
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
  
  private static final void b(TypedValue paramTypedValue)
  {
    synchronized (IQx)
    {
      if (IQy == null) {
        IQy = paramTypedValue;
      }
      return;
    }
  }
  
  /* Error */
  private static boolean b(Application paramApplication, Resources paramResources)
  {
    // Byte code:
    //   0: ldc_w 434
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 436	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 437	java/lang/StringBuilder:<init>	()V
    //   13: getstatic 439	com/tencent/mm/svg/a/e:sPackageName	Ljava/lang/String;
    //   16: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 445
    //   22: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 448	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 4
    //   30: ldc 172
    //   32: ldc_w 450
    //   35: iconst_0
    //   36: anewarray 4	java/lang/Object
    //   39: invokestatic 218	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aload 4
    //   44: invokestatic 456	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   47: astore 5
    //   49: invokestatic 300	java/lang/System:nanoTime	()J
    //   52: lstore_2
    //   53: aload_0
    //   54: putstatic 237	com/tencent/mm/svg/a/e:cUW	Landroid/app/Application;
    //   57: aload 5
    //   59: putstatic 458	com/tencent/mm/svg/a/e:IQr	Ljava/lang/Class;
    //   62: aload_1
    //   63: putstatic 196	com/tencent/mm/svg/a/e:sResources	Landroid/content/res/Resources;
    //   66: getstatic 458	com/tencent/mm/svg/a/e:IQr	Ljava/lang/Class;
    //   69: astore_1
    //   70: aload_1
    //   71: ifnonnull +38 -> 109
    //   74: ldc 172
    //   76: ldc_w 460
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
    //   101: ldc_w 434
    //   104: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: iconst_1
    //   108: ireturn
    //   109: aload 5
    //   111: invokevirtual 463	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   114: checkcast 465	com/tencent/mm/svg/a/d
    //   117: aload_0
    //   118: getstatic 196	com/tencent/mm/svg/a/e:sResources	Landroid/content/res/Resources;
    //   121: invokestatic 468	com/tencent/mm/svg/a/e:c	(Landroid/app/Application;Landroid/content/res/Resources;)Lcom/tencent/mm/svg/a/e$c;
    //   124: invokeinterface 472 2 0
    //   129: ldc 172
    //   131: ldc_w 474
    //   134: iconst_1
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_0
    //   141: getstatic 196	com/tencent/mm/svg/a/e:sResources	Landroid/content/res/Resources;
    //   144: invokestatic 468	com/tencent/mm/svg/a/e:c	(Landroid/app/Application;Landroid/content/res/Resources;)Lcom/tencent/mm/svg/a/e$c;
    //   147: getfield 477	com/tencent/mm/svg/a/e$c:IPT	Ljava/util/Map;
    //   150: invokeinterface 478 1 0
    //   155: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   158: aastore
    //   159: invokestatic 218	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: iconst_1
    //   163: putstatic 75	com/tencent/mm/svg/a/e:IQj	Z
    //   166: goto -92 -> 74
    //   169: astore_0
    //   170: ldc 172
    //   172: ldc_w 480
    //   175: iconst_1
    //   176: anewarray 4	java/lang/Object
    //   179: dup
    //   180: iconst_0
    //   181: aload 4
    //   183: aastore
    //   184: invokestatic 265	com/tencent/mm/svg/b/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: ldc_w 434
    //   190: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: iconst_0
    //   194: ireturn
    //   195: astore_0
    //   196: ldc 172
    //   198: aload_0
    //   199: ldc_w 482
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 209	com/tencent/mm/svg/b/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: iconst_0
    //   210: putstatic 75	com/tencent/mm/svg/a/e:IQj	Z
    //   213: goto -139 -> 74
    //   216: astore_0
    //   217: ldc 172
    //   219: aload_0
    //   220: ldc 205
    //   222: iconst_0
    //   223: anewarray 4	java/lang/Object
    //   226: invokestatic 209	com/tencent/mm/svg/b/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: ldc 172
    //   231: ldc_w 484
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
    //   252: ldc_w 486
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
    AppMethodBeat.i(148740);
    if (IQk == null) {}
    try
    {
      if (IQk == null) {
        IQk = new c(a.ftZ(), paramApplication, paramResources);
      }
      paramApplication = IQk;
      AppMethodBeat.o(148740);
      return paramApplication;
    }
    finally
    {
      AppMethodBeat.o(148740);
    }
  }
  
  private static void d(Application paramApplication, Resources paramResources)
  {
    AppMethodBeat.i(148744);
    Object localObject = fue();
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
        if (locala.i(paramApplication.getResources(), j)) {
          paramResources.abn(j);
        }
        i += 1;
      }
      IQj = true;
    }
    catch (IllegalAccessException paramApplication)
    {
      IQj = false;
      AppMethodBeat.o(148744);
      return;
    }
    catch (IllegalArgumentException paramApplication)
    {
      IQj = false;
      AppMethodBeat.o(148744);
      return;
    }
    AppMethodBeat.o(148744);
  }
  
  public static void d(Application paramApplication, String paramString)
  {
    AppMethodBeat.i(148737);
    if (IQu)
    {
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "svg initiated.", new Object[0]);
      AppMethodBeat.o(148737);
      return;
    }
    sPackageName = paramString;
    a.ft(paramString);
    b.ft(paramString);
    cUW = paramApplication;
    jC(paramApplication);
    AppMethodBeat.o(148737);
  }
  
  public static Drawable e(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(148747);
    if (paramResources == null)
    {
      AppMethodBeat.o(148747);
      return null;
    }
    IQv.set(Boolean.TRUE);
    paramResources = paramResources.getDrawable(paramInt);
    IQv.set(Boolean.FALSE);
    AppMethodBeat.o(148747);
    return paramResources;
  }
  
  public static Drawable f(Resources paramResources, int paramInt)
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
      if (HVK == null) {}
      Object localObject2;
      try
      {
        localObject2 = Resources.class.getDeclaredMethod("loadXmlResourceParser", new Class[] { String.class, Integer.TYPE, Integer.TYPE, String.class });
        HVK = (Method)localObject2;
        ((Method)localObject2).setAccessible(true);
        if (HVL == null) {}
        localObject1 = ((TypedValue)localObject3).string.toString();
      }
      catch (NoSuchMethodException paramResources)
      {
        try
        {
          localObject2 = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[] { Integer.TYPE, String.class, Integer.TYPE });
          HVL = (Method)localObject2;
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
          ad.printErrStackTrace("MicroMsg.SVGResourceLoader", paramResources, "", new Object[0]);
          ad.printErrStackTrace("MicroMsg.SVGResourceLoader", paramResources, "", new Object[0]);
          AppMethodBeat.o(148748);
          return null;
        }
        paramResources = paramResources;
        ad.printErrStackTrace("MicroMsg.SVGResourceLoader", paramResources, "", new Object[0]);
        ad.printErrStackTrace("MicroMsg.SVGResourceLoader", paramResources, "", new Object[0]);
        AppMethodBeat.o(148748);
        return null;
      }
      label274:
      if (((String)localObject1).endsWith(".xml")) {}
      for (;;)
      {
        try
        {
          localObject3 = (XmlResourceParser)HVK.invoke(paramResources, new Object[] { localObject1, Integer.valueOf(paramInt), Integer.valueOf(((TypedValue)localObject3).assetCookie), "drawable" });
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
          InputStream localInputStream = (InputStream)HVL.invoke(paramResources.getAssets(), new Object[] { Integer.valueOf(((TypedValue)localObject3).assetCookie), localObject1, Integer.valueOf(2) });
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
  
  private static Class<?> fue()
  {
    AppMethodBeat.i(148743);
    Class localClass1;
    if (cUV != null)
    {
      localClass1 = cUV;
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
      Class localClass2 = b.fuj();
      if (localClass2 != null)
      {
        AppMethodBeat.o(148743);
        return localClass2;
      }
      AppMethodBeat.o(148743);
    }
    return null;
  }
  
  private static final TypedValue fuf()
  {
    TypedValue localTypedValue1 = null;
    AppMethodBeat.i(148745);
    synchronized (IQx)
    {
      if (IQy != null)
      {
        localTypedValue1 = IQy;
        IQy = null;
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
  
  @TargetApi(16)
  private static void jC(Context paramContext)
  {
    AppMethodBeat.i(148741);
    if (IQn == null) {
      try
      {
        IQm = new LongSparseArray();
        Object localObject = new e();
        IQn = (e)localObject;
        ((e)localObject).IQm = IQm;
        localObject = new e();
        IQo = (e)localObject;
        ((e)localObject).IQm = IQm;
        if (Build.VERSION.SDK_INT >= 23)
        {
          localObject = new com.tencent.mm.svg.b.a(paramContext.getResources(), "mResourcesImpl");
          if (((com.tencent.mm.svg.b.a)localObject).aaY()) {
            localObject = ((com.tencent.mm.svg.b.a)localObject).get();
          }
        }
        for (;;)
        {
          a(paramContext, localObject);
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
    private Method IQA;
    private Field IQz;
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
        this.IQz = AssetManager.class.getDeclaredField("mApkAssets");
        this.IQz.setAccessible(true);
        this.IQA = Class.forName("android.content.res.ApkAssets").getDeclaredMethod("getStringFromPool", new Class[] { Integer.TYPE });
        this.IQA.setAccessible(true);
        this.mInited = true;
        AppMethodBeat.o(148722);
        return;
      }
      catch (Throwable localThrowable)
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
        paramAssetManager = ((Object[])(Object[])this.IQz.get(paramAssetManager))[(i - 1)];
        paramAssetManager = (String)this.IQA.invoke(paramAssetManager, new Object[] { Integer.valueOf(j) });
        AppMethodBeat.o(148723);
        return paramAssetManager;
      }
      catch (Throwable paramAssetManager)
      {
        com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramAssetManager, "", new Object[0]);
        AppMethodBeat.o(148723);
      }
      return null;
    }
  }
  
  static final class b
  {
    Drawable.ConstantState IQB;
    boolean IQC;
    
    b(Drawable.ConstantState paramConstantState, boolean paramBoolean)
    {
      this.IQB = paramConstantState;
      this.IQC = paramBoolean;
    }
  }
  
  public static final class c
  {
    private TypedValue IPO;
    Map<Integer, com.tencent.mm.svg.c> IPT;
    private Application IQD;
    private Resources mResources;
    
    public c(Map<Integer, com.tencent.mm.svg.c> paramMap, Application paramApplication, Resources paramResources)
    {
      AppMethodBeat.i(148724);
      this.IPO = new TypedValue();
      this.IPT = paramMap;
      this.IQD = paramApplication;
      this.mResources = paramResources;
      AppMethodBeat.o(148724);
    }
    
    public final void a(Integer paramInteger, com.tencent.mm.svg.c paramc)
    {
      AppMethodBeat.i(148725);
      this.IPT.put(paramInteger, paramc);
      e.a(this.IQD, this.mResources, paramInteger.intValue(), this.IPO);
      AppMethodBeat.o(148725);
    }
    
    public final void abn(int paramInt)
    {
      AppMethodBeat.i(148726);
      e.a(this.IQD, this.mResources, paramInt, this.IPO);
      AppMethodBeat.o(148726);
    }
  }
  
  protected static final class d
    extends Drawable.ConstantState
  {
    private int BVB;
    private long IQE;
    private int IQF;
    private Resources mResources;
    
    public d(int paramInt1, Resources paramResources, long paramLong, int paramInt2)
    {
      AppMethodBeat.i(148727);
      this.BVB = 0;
      this.IQE = 0L;
      this.IQF = 0;
      if (paramInt1 == 0)
      {
        com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "SVGConstantState Why this id is %d. TypedValue %s", new Object[] { Integer.valueOf(paramInt1) });
        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
      }
      this.BVB = paramInt1;
      this.mResources = paramResources;
      this.IQE = paramLong;
      this.IQF = paramInt2;
      AppMethodBeat.o(148727);
    }
    
    public final int getChangingConfigurations()
    {
      return 0;
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(148728);
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "newDrawable mResources %s %s %s %s", new Object[] { this.mResources, Integer.valueOf(this.BVB), Long.valueOf(this.IQE), Integer.valueOf(this.IQF) });
      Drawable localDrawable = a.g(this.mResources, this.BVB);
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
          int i = ((Integer)localMap.get(Long.valueOf(this.IQE))).intValue();
          paramResources = e.f(paramResources, i);
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
  
  @TargetApi(16)
  public static final class e<T>
    extends LongSparseArray<T>
  {
    public static boolean IQG = false;
    LongSparseArray<T> IQm = null;
    
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
      if ((e.fug().get() == null) || (!((Boolean)e.fug().get()).booleanValue())) {}
      label168:
      for (;;)
      {
        synchronized (this.IQm)
        {
          if (this.IQm.indexOfKey(paramLong) >= 0)
          {
            Object localObject = this.IQm.get(paramLong, paramT);
            if (!e.bli()) {
              break label168;
            }
            e.b localb = e.b(paramLong, (e.d)localObject);
            if (localb == null) {
              break label168;
            }
            if (!localb.IQC)
            {
              localObject = localb.IQB;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.a.e
 * JD-Core Version:    0.7.0.1
 */