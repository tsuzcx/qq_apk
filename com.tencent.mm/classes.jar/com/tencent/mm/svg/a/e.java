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
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import com.tencent.mm.sdk.platformtools.y;
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
  protected static String bnW;
  private static Class<?> bxe = null;
  protected static Application bxf;
  protected static Resources bxg;
  private static LongSparseArray<Drawable.ConstantState> uFA;
  private static c<Drawable.ConstantState> uFB;
  private static c<Drawable.ConstantState> uFC;
  protected static Class<d> uFD;
  private static volatile boolean uFE = false;
  private static Map<WeakReference<Resources>, Map<Long, Integer>> uFF = new HashMap();
  private static boolean uFG = false;
  private static ThreadLocal<Boolean> uFH = new ThreadLocal();
  private static boolean uFx = false;
  private static volatile a uFy;
  private static LongSparseArray<Drawable.ConstantState>[] uFz;
  private static Method uaU = null;
  private static Method uaV = null;
  
  /* Error */
  public static void a(Application paramApplication, Resources paramResources, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokestatic 151	com/tencent/mm/svg/a/e:d	(Landroid/app/Application;Ljava/lang/String;)V
    //   5: getstatic 57	com/tencent/mm/svg/a/e:uFE	Z
    //   8: ifeq +15 -> 23
    //   11: ldc 80
    //   13: ldc 153
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 106	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: return
    //   23: new 155	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   30: getstatic 158	com/tencent/mm/svg/a/e:bnW	Ljava/lang/String;
    //   33: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 164
    //   38: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: astore 7
    //   46: ldc 80
    //   48: ldc 170
    //   50: iconst_0
    //   51: anewarray 4	java/lang/Object
    //   54: invokestatic 106	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: aload 7
    //   59: invokestatic 176	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   62: astore_2
    //   63: invokestatic 182	java/lang/System:nanoTime	()J
    //   66: lstore 5
    //   68: aload_0
    //   69: putstatic 184	com/tencent/mm/svg/a/e:bxf	Landroid/app/Application;
    //   72: aload_2
    //   73: putstatic 186	com/tencent/mm/svg/a/e:uFD	Ljava/lang/Class;
    //   76: aload_1
    //   77: putstatic 188	com/tencent/mm/svg/a/e:bxg	Landroid/content/res/Resources;
    //   80: getstatic 186	com/tencent/mm/svg/a/e:uFD	Ljava/lang/Class;
    //   83: astore 8
    //   85: aload 8
    //   87: ifnonnull +35 -> 122
    //   90: ldc 80
    //   92: ldc 190
    //   94: iconst_1
    //   95: anewarray 4	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: invokestatic 182	java/lang/System:nanoTime	()J
    //   103: lload 5
    //   105: lsub
    //   106: ldc2_w 191
    //   109: ldiv
    //   110: invokestatic 197	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   113: aastore
    //   114: invokestatic 106	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: iconst_1
    //   118: putstatic 57	com/tencent/mm/svg/a/e:uFE	Z
    //   121: return
    //   122: aload_2
    //   123: invokevirtual 201	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   126: checkcast 203	com/tencent/mm/svg/a/d
    //   129: aload_0
    //   130: getstatic 188	com/tencent/mm/svg/a/e:bxg	Landroid/content/res/Resources;
    //   133: invokestatic 206	com/tencent/mm/svg/a/e:b	(Landroid/app/Application;Landroid/content/res/Resources;)Lcom/tencent/mm/svg/a/e$a;
    //   136: invokeinterface 210 2 0
    //   141: ldc 80
    //   143: ldc 212
    //   145: iconst_1
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload_0
    //   152: getstatic 188	com/tencent/mm/svg/a/e:bxg	Landroid/content/res/Resources;
    //   155: invokestatic 206	com/tencent/mm/svg/a/e:b	(Landroid/app/Application;Landroid/content/res/Resources;)Lcom/tencent/mm/svg/a/e$a;
    //   158: getfield 215	com/tencent/mm/svg/a/e$a:uFi	Ljava/util/Map;
    //   161: invokeinterface 221 1 0
    //   166: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: aastore
    //   170: invokestatic 106	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: iconst_1
    //   174: putstatic 53	com/tencent/mm/svg/a/e:uFx	Z
    //   177: goto -87 -> 90
    //   180: astore_2
    //   181: iconst_0
    //   182: istore_3
    //   183: ldc 80
    //   185: ldc 223
    //   187: iconst_1
    //   188: anewarray 4	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: aload 7
    //   195: aastore
    //   196: invokestatic 94	com/tencent/mm/svg/b/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: iload_3
    //   200: ifne +172 -> 372
    //   203: ldc 80
    //   205: ldc 225
    //   207: iconst_0
    //   208: anewarray 4	java/lang/Object
    //   211: invokestatic 106	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: invokestatic 182	java/lang/System:nanoTime	()J
    //   217: lstore 5
    //   219: aload_0
    //   220: invokestatic 229	com/tencent/mm/svg/a/e:gn	(Landroid/content/Context;)V
    //   223: aload_0
    //   224: aload_1
    //   225: invokestatic 232	com/tencent/mm/svg/a/e:c	(Landroid/app/Application;Landroid/content/res/Resources;)V
    //   228: ldc 80
    //   230: ldc 234
    //   232: iconst_1
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: invokestatic 182	java/lang/System:nanoTime	()J
    //   241: lload 5
    //   243: lsub
    //   244: ldc2_w 191
    //   247: ldiv
    //   248: invokestatic 197	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   251: aastore
    //   252: invokestatic 106	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: return
    //   256: astore_2
    //   257: ldc 80
    //   259: aload_2
    //   260: ldc 236
    //   262: iconst_0
    //   263: anewarray 4	java/lang/Object
    //   266: invokestatic 240	com/tencent/mm/svg/b/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: iconst_0
    //   270: putstatic 53	com/tencent/mm/svg/a/e:uFx	Z
    //   273: goto -183 -> 90
    //   276: astore_2
    //   277: iconst_0
    //   278: istore 4
    //   280: iload 4
    //   282: istore_3
    //   283: ldc 80
    //   285: aload_2
    //   286: ldc 242
    //   288: iconst_0
    //   289: anewarray 4	java/lang/Object
    //   292: invokestatic 240	com/tencent/mm/svg/b/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   295: iload 4
    //   297: istore_3
    //   298: ldc 80
    //   300: ldc 244
    //   302: iconst_1
    //   303: anewarray 4	java/lang/Object
    //   306: dup
    //   307: iconst_0
    //   308: aload 7
    //   310: aastore
    //   311: invokestatic 94	com/tencent/mm/svg/b/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   314: iload 4
    //   316: ifne +61 -> 377
    //   319: ldc 80
    //   321: ldc 225
    //   323: iconst_0
    //   324: anewarray 4	java/lang/Object
    //   327: invokestatic 106	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   330: invokestatic 182	java/lang/System:nanoTime	()J
    //   333: lstore 5
    //   335: aload_0
    //   336: invokestatic 229	com/tencent/mm/svg/a/e:gn	(Landroid/content/Context;)V
    //   339: aload_0
    //   340: aload_1
    //   341: invokestatic 232	com/tencent/mm/svg/a/e:c	(Landroid/app/Application;Landroid/content/res/Resources;)V
    //   344: ldc 80
    //   346: ldc 234
    //   348: iconst_1
    //   349: anewarray 4	java/lang/Object
    //   352: dup
    //   353: iconst_0
    //   354: invokestatic 182	java/lang/System:nanoTime	()J
    //   357: lload 5
    //   359: lsub
    //   360: ldc2_w 191
    //   363: ldiv
    //   364: invokestatic 197	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   367: aastore
    //   368: invokestatic 106	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   371: return
    //   372: iconst_1
    //   373: putstatic 57	com/tencent/mm/svg/a/e:uFE	Z
    //   376: return
    //   377: iconst_1
    //   378: putstatic 57	com/tencent/mm/svg/a/e:uFE	Z
    //   381: return
    //   382: astore_2
    //   383: iconst_0
    //   384: istore 4
    //   386: iload 4
    //   388: istore_3
    //   389: ldc 80
    //   391: ldc 246
    //   393: iconst_1
    //   394: anewarray 4	java/lang/Object
    //   397: dup
    //   398: iconst_0
    //   399: aload 7
    //   401: aastore
    //   402: invokestatic 94	com/tencent/mm/svg/b/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   405: iload 4
    //   407: istore_3
    //   408: ldc 80
    //   410: aload_2
    //   411: ldc 242
    //   413: iconst_0
    //   414: anewarray 4	java/lang/Object
    //   417: invokestatic 240	com/tencent/mm/svg/b/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   420: iload 4
    //   422: ifne +56 -> 478
    //   425: ldc 80
    //   427: ldc 225
    //   429: iconst_0
    //   430: anewarray 4	java/lang/Object
    //   433: invokestatic 106	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   436: invokestatic 182	java/lang/System:nanoTime	()J
    //   439: lstore 5
    //   441: aload_0
    //   442: invokestatic 229	com/tencent/mm/svg/a/e:gn	(Landroid/content/Context;)V
    //   445: aload_0
    //   446: aload_1
    //   447: invokestatic 232	com/tencent/mm/svg/a/e:c	(Landroid/app/Application;Landroid/content/res/Resources;)V
    //   450: ldc 80
    //   452: ldc 234
    //   454: iconst_1
    //   455: anewarray 4	java/lang/Object
    //   458: dup
    //   459: iconst_0
    //   460: invokestatic 182	java/lang/System:nanoTime	()J
    //   463: lload 5
    //   465: lsub
    //   466: ldc2_w 191
    //   469: ldiv
    //   470: invokestatic 197	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   473: aastore
    //   474: invokestatic 106	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   477: return
    //   478: iconst_1
    //   479: putstatic 57	com/tencent/mm/svg/a/e:uFE	Z
    //   482: return
    //   483: astore_2
    //   484: iconst_0
    //   485: istore_3
    //   486: iload_3
    //   487: ifne +57 -> 544
    //   490: ldc 80
    //   492: ldc 225
    //   494: iconst_0
    //   495: anewarray 4	java/lang/Object
    //   498: invokestatic 106	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   501: invokestatic 182	java/lang/System:nanoTime	()J
    //   504: lstore 5
    //   506: aload_0
    //   507: invokestatic 229	com/tencent/mm/svg/a/e:gn	(Landroid/content/Context;)V
    //   510: aload_0
    //   511: aload_1
    //   512: invokestatic 232	com/tencent/mm/svg/a/e:c	(Landroid/app/Application;Landroid/content/res/Resources;)V
    //   515: ldc 80
    //   517: ldc 234
    //   519: iconst_1
    //   520: anewarray 4	java/lang/Object
    //   523: dup
    //   524: iconst_0
    //   525: invokestatic 182	java/lang/System:nanoTime	()J
    //   528: lload 5
    //   530: lsub
    //   531: ldc2_w 191
    //   534: ldiv
    //   535: invokestatic 197	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   538: aastore
    //   539: invokestatic 106	com/tencent/mm/svg/b/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   542: aload_2
    //   543: athrow
    //   544: iconst_1
    //   545: putstatic 57	com/tencent/mm/svg/a/e:uFE	Z
    //   548: goto -6 -> 542
    //   551: astore_0
    //   552: goto -324 -> 228
    //   555: astore_0
    //   556: goto -212 -> 344
    //   559: astore_0
    //   560: goto -110 -> 450
    //   563: astore_0
    //   564: goto -49 -> 515
    //   567: astore_2
    //   568: iconst_1
    //   569: istore_3
    //   570: goto -84 -> 486
    //   573: astore_2
    //   574: goto -88 -> 486
    //   577: astore_2
    //   578: goto -92 -> 486
    //   581: astore_2
    //   582: iconst_1
    //   583: istore 4
    //   585: goto -199 -> 386
    //   588: astore_2
    //   589: iconst_1
    //   590: istore 4
    //   592: goto -312 -> 280
    //   595: astore_2
    //   596: iconst_1
    //   597: istore_3
    //   598: goto -415 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	601	0	paramApplication	Application
    //   0	601	1	paramResources	Resources
    //   0	601	2	paramString	String
    //   182	416	3	i	int
    //   278	313	4	j	int
    //   66	463	5	l	long
    //   44	356	7	str	String
    //   83	3	8	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   46	80	180	java/lang/ClassNotFoundException
    //   80	85	180	java/lang/ClassNotFoundException
    //   122	173	180	java/lang/ClassNotFoundException
    //   173	177	180	java/lang/ClassNotFoundException
    //   257	273	180	java/lang/ClassNotFoundException
    //   80	85	256	android/content/res/Resources$NotFoundException
    //   122	173	256	android/content/res/Resources$NotFoundException
    //   46	80	276	java/lang/InstantiationException
    //   80	85	276	java/lang/InstantiationException
    //   122	173	276	java/lang/InstantiationException
    //   173	177	276	java/lang/InstantiationException
    //   257	273	276	java/lang/InstantiationException
    //   46	80	382	java/lang/IllegalAccessException
    //   80	85	382	java/lang/IllegalAccessException
    //   122	173	382	java/lang/IllegalAccessException
    //   173	177	382	java/lang/IllegalAccessException
    //   257	273	382	java/lang/IllegalAccessException
    //   46	80	483	finally
    //   80	85	483	finally
    //   122	173	483	finally
    //   173	177	483	finally
    //   257	273	483	finally
    //   223	228	551	java/lang/ClassNotFoundException
    //   339	344	555	java/lang/ClassNotFoundException
    //   445	450	559	java/lang/ClassNotFoundException
    //   510	515	563	java/lang/ClassNotFoundException
    //   90	117	567	finally
    //   183	199	573	finally
    //   283	295	577	finally
    //   298	314	577	finally
    //   389	405	577	finally
    //   408	420	577	finally
    //   90	117	581	java/lang/IllegalAccessException
    //   90	117	588	java/lang/InstantiationException
    //   90	117	595	java/lang/ClassNotFoundException
  }
  
  @TargetApi(16)
  private static void a(Context paramContext, Object paramObject)
  {
    paramObject = new com.tencent.mm.svg.b.a(paramObject, "sPreloadedDrawables").get();
    if (paramObject != null)
    {
      int i;
      long l;
      if ((paramObject instanceof LongSparseArray[]))
      {
        uFz = (LongSparseArray[])paramObject;
        com.tencent.mm.svg.b.c.d("MicroMsg.SVGResourceLoader", "sPreloadDrawable content: %s ", new Object[] { uFz[0] });
        i = 0;
        while (i < uFz[0].size())
        {
          l = uFz[0].keyAt(i);
          uFB.put(l, uFz[0].get(l));
          i += 1;
        }
        i = 0;
        while (i < uFz[1].size())
        {
          l = uFz[1].keyAt(i);
          uFC.put(l, uFz[1].get(l));
          i += 1;
        }
        uFz[0] = uFB;
        uFz[1] = uFC;
      }
      do
      {
        return;
        if (!(paramObject instanceof LongSparseArray)) {
          break;
        }
        paramContext = new com.tencent.mm.svg.b.a(paramContext.getResources(), "sPreloadedDrawables");
        paramObject = (LongSparseArray)paramContext.get();
        i = 0;
        while (i < paramObject.size())
        {
          l = paramObject.keyAt(i);
          uFB.put(l, paramObject.get(l));
          i += 1;
        }
        paramObject = uFB;
        paramContext.prepare();
        if (paramContext.dyY == null) {
          throw new NoSuchFieldException();
        }
        paramContext.dyY.set(paramContext.obj, paramObject);
      } while (paramContext.get() != null);
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "resourcePreloadDrawable is null!! OMG!!", new Object[0]);
      return;
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is others!! OMG!", new Object[0]);
      return;
    }
    com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is null!! OMG!!!", new Object[0]);
  }
  
  public static void a(Resources paramResources, Map<Long, Integer> paramMap)
  {
    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "addFilterResources:" + paramResources, new Object[0]);
    Iterator localIterator = uFF.keySet().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((WeakReference)localIterator.next()).get() != paramResources);
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        uFF.put(new WeakReference(paramResources), paramMap);
      }
      return;
    }
  }
  
  public static void a(c.a parama)
  {
    com.tencent.mm.svg.b.c.b(parama);
  }
  
  private static a b(Application paramApplication, Resources paramResources)
  {
    if (uFy == null) {}
    try
    {
      if (uFy == null) {
        uFy = new a(a.cxm(), paramApplication, paramResources);
      }
      return uFy;
    }
    finally {}
  }
  
  public static Drawable c(Resources paramResources, int paramInt)
  {
    uFH.set(Boolean.valueOf(true));
    paramResources = paramResources.getDrawable(paramInt);
    uFH.set(Boolean.valueOf(false));
    return paramResources;
  }
  
  private static void c(Application paramApplication, Resources paramResources)
  {
    Object localObject = cxq();
    if (localObject == null)
    {
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "Raw class is null!", new Object[0]);
      return;
    }
    localObject = ((Class)localObject).getDeclaredFields();
    paramResources = b(paramApplication, paramResources);
    try
    {
      a locala = new a();
      int i = 0;
      while (i < localObject.length)
      {
        int j = localObject[i].getInt(null);
        if (locala.f(paramApplication.getResources(), j)) {
          a(paramResources.uFI, paramResources.mResources, j, paramResources.uFd);
        }
        i += 1;
      }
      uFx = true;
    }
    catch (IllegalAccessException paramApplication)
    {
      uFx = false;
      return;
    }
    catch (IllegalArgumentException paramApplication)
    {
      uFx = false;
      return;
    }
  }
  
  private static Class<?> cxq()
  {
    Object localObject;
    if (bxe != null) {
      localObject = bxe;
    }
    label44:
    do
    {
      for (;;)
      {
        return localObject;
        try
        {
          localClass = Class.forName(bnW + ".R$raw");
          localObject = localClass;
          if (localClass != null) {}
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          Class localClass;
          break label44;
        }
      }
      localClass = b.cxt();
      localObject = localClass;
    } while (localClass != null);
    return null;
  }
  
  public static Drawable d(Resources paramResources, int paramInt)
  {
    int i = 1;
    Object localObject3 = new TypedValue();
    paramResources.getValue(paramInt, (TypedValue)localObject3, true);
    if ((((TypedValue)localObject3).type >= 28) && (((TypedValue)localObject3).type <= 31)) {}
    for (;;)
    {
      if (i != 0) {}
      for (Object localObject1 = new ColorDrawable(((TypedValue)localObject3).data);; localObject1 = null)
      {
        if (uaU == null) {}
        Object localObject2;
        try
        {
          localObject2 = Resources.class.getDeclaredMethod("loadXmlResourceParser", new Class[] { String.class, Integer.TYPE, Integer.TYPE, String.class });
          uaU = (Method)localObject2;
          ((Method)localObject2).setAccessible(true);
          if (uaV == null) {}
          localObject1 = ((TypedValue)localObject3).string.toString();
        }
        catch (NoSuchMethodException paramResources)
        {
          try
          {
            localObject2 = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[] { Integer.TYPE, String.class, Integer.TYPE });
            uaV = (Method)localObject2;
            ((Method)localObject2).setAccessible(true);
            localObject2 = localObject1;
            if (localObject1 != null) {
              break label336;
            }
            if (((TypedValue)localObject3).string != null) {
              break label256;
            }
            throw new Resources.NotFoundException("Resource is not a Drawable (color or path): " + localObject3);
          }
          catch (NoSuchMethodException paramResources)
          {
            y.printErrStackTrace("MicroMsg.SVGResourceLoader", paramResources, "", new Object[0]);
            y.printErrStackTrace("MicroMsg.SVGResourceLoader", paramResources, "", new Object[0]);
            return null;
          }
          paramResources = paramResources;
          y.printErrStackTrace("MicroMsg.SVGResourceLoader", paramResources, "", new Object[0]);
          y.printErrStackTrace("MicroMsg.SVGResourceLoader", paramResources, "", new Object[0]);
          return null;
        }
        label256:
        if (((String)localObject1).endsWith(".xml")) {}
        for (;;)
        {
          try
          {
            localObject3 = (XmlResourceParser)uaU.invoke(paramResources, new Object[] { localObject1, Integer.valueOf(paramInt), Integer.valueOf(((TypedValue)localObject3).assetCookie), "drawable" });
            localObject2 = Drawable.createFromXml(paramResources, (XmlPullParser)localObject3);
            ((XmlResourceParser)localObject3).close();
            label336:
            return localObject2;
          }
          catch (Exception paramResources)
          {
            localObject1 = new Resources.NotFoundException("File " + (String)localObject1 + " from drawable resource ID #0x" + Integer.toHexString(paramInt));
            ((Resources.NotFoundException)localObject1).initCause(paramResources);
            throw ((Throwable)localObject1);
          }
          try
          {
            InputStream localInputStream = (InputStream)uaV.invoke(paramResources.getAssets(), new Object[] { Integer.valueOf(((TypedValue)localObject3).assetCookie), localObject1, Integer.valueOf(2) });
            localObject2 = Drawable.createFromResourceStream(paramResources, (TypedValue)localObject3, localInputStream, (String)localObject1, null);
            localInputStream.close();
          }
          catch (Exception paramResources)
          {
            localObject1 = new Resources.NotFoundException("File " + (String)localObject1 + " from drawable resource ID #0x" + Integer.toHexString(paramInt));
            ((Resources.NotFoundException)localObject1).initCause(paramResources);
            throw ((Throwable)localObject1);
          }
        }
      }
      i = 0;
    }
  }
  
  public static void d(Application paramApplication, String paramString)
  {
    if (uFG)
    {
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "svg initiated.", new Object[0]);
      return;
    }
    bnW = paramString;
    a.cq(paramString);
    b.cq(paramString);
    bxf = paramApplication;
    gn(paramApplication);
  }
  
  @TargetApi(16)
  private static void gn(Context paramContext)
  {
    int i = 1;
    if (uFB == null) {}
    for (;;)
    {
      try
      {
        uFA = new LongSparseArray();
        Object localObject = new c();
        uFB = (c)localObject;
        ((c)localObject).uFA = uFA;
        localObject = new c();
        uFC = (c)localObject;
        ((c)localObject).uFA = uFA;
        if (Build.VERSION.SDK_INT >= 23)
        {
          localObject = new com.tencent.mm.svg.b.a(paramContext.getResources(), "mResourcesImpl");
          ((com.tencent.mm.svg.b.a)localObject).prepare();
          if (((com.tencent.mm.svg.b.a)localObject).dyY != null)
          {
            if (i != 0)
            {
              localObject = ((com.tencent.mm.svg.b.a)localObject).get();
              a(paramContext, localObject);
              com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG this resources %s", new Object[] { paramContext.getResources() });
              return;
            }
            localObject = paramContext.getResources();
            continue;
          }
        }
        else
        {
          localObject = paramContext.getResources();
          continue;
          return;
        }
      }
      catch (NoSuchFieldException paramContext)
      {
        com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramContext, "Call reflectPreloadCache failed. Reason : NoSuchFieldException.", new Object[0]);
        return;
      }
      catch (IllegalAccessException paramContext)
      {
        com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramContext, "Call reflectPreloadCache failed. Reason : IllegalAccessException.", new Object[0]);
        return;
      }
      catch (IllegalArgumentException paramContext)
      {
        com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", paramContext, "Call reflectPreloadCache failed. Reason : IllegalArgumentException.", new Object[0]);
      }
      i = 0;
    }
  }
  
  public static void n(Class<?> paramClass)
  {
    bxe = paramClass;
  }
  
  public static final class a
  {
    Resources mResources;
    Application uFI;
    TypedValue uFd = new TypedValue();
    Map<Integer, com.tencent.mm.svg.c> uFi;
    
    public a(Map<Integer, com.tencent.mm.svg.c> paramMap, Application paramApplication, Resources paramResources)
    {
      this.uFi = paramMap;
      this.uFI = paramApplication;
      this.mResources = paramResources;
    }
    
    public final void a(Integer paramInteger, com.tencent.mm.svg.c paramc)
    {
      this.uFi.put(paramInteger, paramc);
      e.a(this.uFI, this.mResources, paramInteger.intValue(), this.uFd);
    }
  }
  
  protected static final class b
    extends Drawable.ConstantState
  {
    private Resources mResources;
    private int pLu = 0;
    private long uFJ = 0L;
    
    public b(int paramInt, Resources paramResources, long paramLong)
    {
      if (paramInt == 0)
      {
        com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "SVGConstantState Why this id is %d. TypedValue %s", new Object[] { Integer.valueOf(paramInt) });
        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
      }
      this.pLu = paramInt;
      this.mResources = paramResources;
      this.uFJ = paramLong;
    }
    
    public final int getChangingConfigurations()
    {
      return 0;
    }
    
    public final Drawable newDrawable()
    {
      com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "newDrawable mResources %s %s", new Object[] { this.mResources, Integer.valueOf(this.pLu) });
      return a.e(this.mResources, this.pLu);
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      try
      {
        Map localMap = e.e(paramResources);
        if (localMap != null)
        {
          int i = ((Integer)localMap.get(Long.valueOf(this.uFJ))).intValue();
          paramResources = e.d(paramResources, i);
          com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "loadDrawableSkipCache id:" + Integer.toHexString(i) + ",drawable:" + paramResources, new Object[0]);
          return paramResources;
        }
      }
      catch (Exception paramResources)
      {
        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "newDrawable loadDrawableSkipCache error:" + paramResources.getMessage(), new Object[0]);
      }
      return newDrawable();
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      return newDrawable(paramResources);
    }
  }
  
  @TargetApi(16)
  public static final class c<T>
    extends LongSparseArray<T>
  {
    public static boolean uFK = false;
    LongSparseArray<T> uFA = null;
    
    public final void clear()
    {
      super.clear();
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! clear.", new Object[0]);
    }
    
    public final void delete(long paramLong)
    {
      super.delete(paramLong);
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! delete key %s", new Object[] { Long.valueOf(paramLong) });
    }
    
    public final T get(long paramLong, T paramT)
    {
      if ((e.csi().get() == null) || (!((Boolean)e.csi().get()).booleanValue())) {}
      for (;;)
      {
        synchronized (this.uFA)
        {
          if (this.uFA.indexOfKey(paramLong) >= 0)
          {
            paramT = this.uFA.get(paramLong, paramT);
            return paramT;
          }
          return super.get(paramLong, paramT);
        }
        com.tencent.mm.svg.b.c.d("MicroMsg.SVGLongSparseArray", "Skip svg this time for key %s", new Object[] { Long.valueOf(paramLong) });
      }
    }
    
    public final void remove(long paramLong)
    {
      super.remove(paramLong);
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! remove key %s", new Object[] { Long.valueOf(paramLong) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.a.e
 * JD-Core Version:    0.7.0.1
 */