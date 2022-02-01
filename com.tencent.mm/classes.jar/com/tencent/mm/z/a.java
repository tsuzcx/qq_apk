package com.tencent.mm.z;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/glrender/BitmapFilter;", "", "()V", "TAG", "", "TYPE_ORIGIN", "", "TYPE_STYLE1", "TYPE_STYLE2", "TYPE_STYLE3", "TYPE_STYLE4", "TYPE_STYLE5", "TYPE_STYLE6", "TYPE_STYLE7", "TYPE_STYLE8", "filterRender", "Lcom/tencent/mm/glrender/FilterRender;", "getFilterRender", "()Lcom/tencent/mm/glrender/FilterRender;", "setFilterRender", "(Lcom/tencent/mm/glrender/FilterRender;)V", "localRoot", "getLocalRoot", "()Ljava/lang/String;", "started", "", "getStarted", "()Z", "setStarted", "(Z)V", "typeList", "", "Lcom/tencent/mm/glrender/BitmapFilter$FilterInfo;", "getTypeList", "()Ljava/util/List;", "copyAssets", "", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "filterBitmap", "Landroid/graphics/Bitmap;", "preBitmap", "type", "targetWidth", "targetHeight", "colorWeight", "", "filterToTargetSizeByMatrix", "inputBitmap", "getMatrix", "", "start", "bitmap", "stop", "FilterInfo", "plugin-photoedit-sdk_release"})
public final class a
{
  private static final String jUt;
  private static final List<a.a> jUu;
  private static b jUv;
  public static final a jUw;
  private static boolean started;
  
  static
  {
    AppMethodBeat.i(163157);
    jUw = new a();
    jUt = com.tencent.mm.loader.j.b.aSE() + "photoedit";
    Object localObject1 = MMApplicationContext.getContext().getString(a.h.photo_filter_name_origin);
    p.j(localObject1, "MMApplicationContext.get…photo_filter_name_origin)");
    localObject1 = new a.a(0, (String)localObject1, "");
    Object localObject2 = MMApplicationContext.getContext().getString(a.h.photo_filter_name_0);
    p.j(localObject2, "MMApplicationContext.get…ring.photo_filter_name_0)");
    localObject2 = new a.a(1, (String)localObject2, jUt + "/filter_source_0.png");
    Object localObject3 = MMApplicationContext.getContext().getString(a.h.photo_filter_name_1);
    p.j(localObject3, "MMApplicationContext.get…ring.photo_filter_name_1)");
    localObject3 = new a.a(2, (String)localObject3, jUt + "/filter_source_1.png");
    Object localObject4 = MMApplicationContext.getContext().getString(a.h.photo_filter_name_2);
    p.j(localObject4, "MMApplicationContext.get…ring.photo_filter_name_2)");
    localObject4 = new a.a(3, (String)localObject4, jUt + "/filter_source_2.png");
    Object localObject5 = MMApplicationContext.getContext().getString(a.h.photo_filter_name_3);
    p.j(localObject5, "MMApplicationContext.get…ring.photo_filter_name_3)");
    localObject5 = new a.a(4, (String)localObject5, jUt + "/filter_source_3.png");
    Object localObject6 = MMApplicationContext.getContext().getString(a.h.photo_filter_name_4);
    p.j(localObject6, "MMApplicationContext.get…ring.photo_filter_name_4)");
    localObject6 = new a.a(5, (String)localObject6, jUt + "/filter_source_4.png");
    Object localObject7 = MMApplicationContext.getContext().getString(a.h.photo_filter_name_5);
    p.j(localObject7, "MMApplicationContext.get…ring.photo_filter_name_5)");
    localObject7 = new a.a(6, (String)localObject7, jUt + "/filter_source_5.png");
    Object localObject8 = MMApplicationContext.getContext().getString(a.h.photo_filter_name_6);
    p.j(localObject8, "MMApplicationContext.get…ring.photo_filter_name_6)");
    localObject8 = new a.a(7, (String)localObject8, jUt + "/filter_source_6.png");
    String str = MMApplicationContext.getContext().getString(a.h.photo_filter_name_7);
    p.j(str, "MMApplicationContext.get…ring.photo_filter_name_7)");
    jUu = j.listOf(new a.a[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, new a.a(8, str, jUt + "/filter_source_7.png") });
    localObject1 = MMApplicationContext.getContext();
    p.j(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getAssets();
    p.j(localObject1, "MMApplicationContext.getContext().assets");
    a((AssetManager)localObject1, "photofilters", jUt);
    AppMethodBeat.o(163157);
  }
  
  private static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(163155);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramBitmap.getConfig());
    Canvas localCanvas = new Canvas(localBitmap);
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.set(rU(paramInt3));
    Paint localPaint = new Paint();
    localPaint.setColorFilter((ColorFilter)new ColorMatrixColorFilter(localColorMatrix));
    localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new Rect(0, 0, paramInt1, paramInt2), localPaint);
    p.j(localBitmap, "retBitmap");
    AppMethodBeat.o(163155);
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    AppMethodBeat.i(163154);
    p.k(paramBitmap, "preBitmap");
    if (!started) {
      v(paramBitmap);
    }
    if (jUv != null)
    {
      long l = System.currentTimeMillis();
      Object localObject1 = ((Iterable)jUu).iterator();
      int i;
      if (((Iterator)localObject1).hasNext())
      {
        paramBitmap = ((Iterator)localObject1).next();
        if (((a.a)paramBitmap).type == paramInt1)
        {
          i = 1;
          label79:
          if (i == 0) {
            break label168;
          }
          label84:
          paramBitmap = (a.a)paramBitmap;
          if (paramBitmap == null) {
            break label175;
          }
        }
      }
      label168:
      label175:
      for (paramBitmap = paramBitmap.fileName;; paramBitmap = null)
      {
        if (!Util.isNullOrNil(paramBitmap)) {
          break label180;
        }
        if (paramInt1 != 0) {
          Log.e("MicroMsg.BitmapFilter", "lut file not exist:".concat(String.valueOf(paramBitmap)));
        }
        paramBitmap = jUv;
        if (paramBitmap == null) {
          p.iCn();
        }
        paramBitmap = paramBitmap.aEH();
        if (paramBitmap == null) {
          p.iCn();
        }
        paramBitmap = a(paramBitmap, paramInt2, paramInt3, paramInt1);
        AppMethodBeat.o(163154);
        return paramBitmap;
        i = 0;
        break label79;
        break;
        paramBitmap = null;
        break label84;
      }
      label180:
      Object localObject2 = new Object();
      localObject1 = new aa.f();
      ((aa.f)localObject1).aaBC = null;
      b localb = jUv;
      if (localb == null) {
        p.iCn();
      }
      if (paramBitmap == null) {
        p.iCn();
      }
      kotlin.g.a.b localb1 = (kotlin.g.a.b)new a.b(localObject2, (aa.f)localObject1);
      p.k(paramBitmap, "lutFilePath");
      p.k(localb1, "callback");
      localb.handler.post((Runnable)new b.a(localb, localb1, paramBitmap, paramFloat));
      for (;;)
      {
        try
        {
          if ((Bitmap)((aa.f)localObject1).aaBC == null) {
            localObject2.wait();
          }
          paramBitmap = x.aazN;
          paramBitmap = (Bitmap)((aa.f)localObject1).aaBC;
          if (paramBitmap == null) {
            p.iCn();
          }
          if ((paramInt2 == paramBitmap.getWidth()) && (paramInt3 == paramBitmap.getHeight())) {
            break;
          }
          localObject1 = a(paramBitmap, paramInt2, paramInt3, 0);
          localObject2 = new StringBuilder("filterBitmap cost ").append(System.currentTimeMillis() - l).append("ms, bitmap width:");
          paramBitmap = jUv;
          if (paramBitmap == null) {
            p.iCn();
          }
          paramBitmap = paramBitmap.aEH();
          if (paramBitmap != null)
          {
            paramBitmap = Integer.valueOf(paramBitmap.getWidth());
            localObject2 = ((StringBuilder)localObject2).append(paramBitmap.intValue()).append(", height:");
            paramBitmap = jUv;
            if (paramBitmap == null) {
              p.iCn();
            }
            paramBitmap = paramBitmap.aEH();
            if (paramBitmap == null) {
              break label512;
            }
            paramBitmap = Integer.valueOf(paramBitmap.getHeight());
            Log.i("MicroMsg.BitmapFilter", paramBitmap.intValue() + ", targetWidth:" + paramInt2 + ", targetHeight:" + paramInt3);
            AppMethodBeat.o(163154);
            return localObject1;
          }
        }
        finally
        {
          AppMethodBeat.o(163154);
        }
        paramBitmap = null;
        continue;
        label512:
        paramBitmap = null;
      }
      localObject2 = new StringBuilder("filterBitmap cost ").append(System.currentTimeMillis() - l).append("ms, bitmap width:");
      paramBitmap = jUv;
      if (paramBitmap == null) {
        p.iCn();
      }
      paramBitmap = paramBitmap.aEH();
      if (paramBitmap != null)
      {
        paramBitmap = Integer.valueOf(paramBitmap.getWidth());
        localObject2 = ((StringBuilder)localObject2).append(paramBitmap.intValue()).append(", height:");
        paramBitmap = jUv;
        if (paramBitmap == null) {
          p.iCn();
        }
        paramBitmap = paramBitmap.aEH();
        if (paramBitmap == null) {
          break label664;
        }
      }
      label664:
      for (paramBitmap = Integer.valueOf(paramBitmap.getHeight());; paramBitmap = null)
      {
        Log.i("MicroMsg.BitmapFilter", paramBitmap.intValue());
        paramBitmap = (Bitmap)((aa.f)localObject1).aaBC;
        if (paramBitmap == null) {
          p.iCn();
        }
        AppMethodBeat.o(163154);
        return paramBitmap;
        paramBitmap = null;
        break;
      }
    }
    Log.w("MicroMsg.BitmapFilter", "filter render is null");
    paramBitmap = Bitmap.createBitmap(paramInt2, paramInt3, paramBitmap.getConfig());
    p.j(paramBitmap, "Bitmap.createBitmap(targ…Height, preBitmap.config)");
    AppMethodBeat.o(163154);
    return paramBitmap;
  }
  
  /* Error */
  private static void a(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 440
    //   6: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ldc_w 441
    //   13: invokestatic 285	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   16: aload_1
    //   17: ldc_w 442
    //   20: invokestatic 285	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: aload_2
    //   24: ldc_w 443
    //   27: invokestatic 285	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   30: aload_0
    //   31: aload_1
    //   32: invokevirtual 449	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   35: astore 6
    //   37: aload 6
    //   39: ifnonnull +10 -> 49
    //   42: ldc_w 440
    //   45: invokestatic 217	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: return
    //   49: aload 6
    //   51: ldc_w 451
    //   54: invokestatic 132	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   57: aload 6
    //   59: arraylength
    //   60: ifne +101 -> 161
    //   63: iconst_1
    //   64: istore_3
    //   65: iload_3
    //   66: ifeq +147 -> 213
    //   69: aload_0
    //   70: aload_1
    //   71: invokevirtual 455	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   74: checkcast 457	java/io/Closeable
    //   77: astore 6
    //   79: aload 6
    //   81: checkcast 459	java/io/InputStream
    //   84: astore_0
    //   85: aload_2
    //   86: invokestatic 465	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   89: checkcast 457	java/io/Closeable
    //   92: astore_2
    //   93: aload_2
    //   94: checkcast 467	java/io/OutputStream
    //   97: astore_1
    //   98: aload_0
    //   99: ldc_w 469
    //   102: invokestatic 132	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   105: aload_1
    //   106: ldc_w 471
    //   109: invokestatic 132	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   112: aload_0
    //   113: aload_1
    //   114: invokestatic 477	kotlin/f/a:f	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   117: pop2
    //   118: aload_2
    //   119: aconst_null
    //   120: invokestatic 482	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   123: aload 6
    //   125: aconst_null
    //   126: invokestatic 482	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   129: ldc_w 440
    //   132: invokestatic 217	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: return
    //   136: astore_0
    //   137: ldc_w 326
    //   140: aload_0
    //   141: checkcast 439	java/lang/Throwable
    //   144: ldc_w 483
    //   147: iconst_0
    //   148: anewarray 4	java/lang/Object
    //   151: invokestatic 487	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: ldc_w 440
    //   157: invokestatic 217	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: return
    //   161: iconst_0
    //   162: istore_3
    //   163: goto -98 -> 65
    //   166: astore_1
    //   167: ldc_w 440
    //   170: invokestatic 217	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: aload_1
    //   174: athrow
    //   175: astore_0
    //   176: aload_2
    //   177: aload_1
    //   178: invokestatic 482	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   181: ldc_w 440
    //   184: invokestatic 217	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload_0
    //   188: athrow
    //   189: astore_1
    //   190: ldc_w 440
    //   193: invokestatic 217	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload_1
    //   197: athrow
    //   198: astore_0
    //   199: aload 6
    //   201: aload_1
    //   202: invokestatic 482	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   205: ldc_w 440
    //   208: invokestatic 217	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload_0
    //   212: athrow
    //   213: aload_2
    //   214: invokestatic 490	com/tencent/mm/vfs/u:bBD	(Ljava/lang/String;)Z
    //   217: pop
    //   218: aload 6
    //   220: arraylength
    //   221: istore 4
    //   223: iconst_0
    //   224: istore_3
    //   225: iload_3
    //   226: iload 4
    //   228: if_icmpge +68 -> 296
    //   231: aload 6
    //   233: iload_3
    //   234: aaload
    //   235: astore 5
    //   237: aload_0
    //   238: new 89	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   245: aload_1
    //   246: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: bipush 47
    //   251: invokevirtual 493	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   254: aload 5
    //   256: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: new 89	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   269: aload_2
    //   270: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: bipush 47
    //   275: invokevirtual 493	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   278: aload 5
    //   280: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 214	com/tencent/mm/z/a:a	(Landroid/content/res/AssetManager;Ljava/lang/String;Ljava/lang/String;)V
    //   289: iload_3
    //   290: iconst_1
    //   291: iadd
    //   292: istore_3
    //   293: goto -68 -> 225
    //   296: ldc_w 440
    //   299: invokestatic 217	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: return
    //   303: astore_0
    //   304: aload 5
    //   306: astore_1
    //   307: goto -108 -> 199
    //   310: astore_0
    //   311: aconst_null
    //   312: astore_1
    //   313: goto -137 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	paramAssetManager	AssetManager
    //   0	316	1	paramString1	String
    //   0	316	2	paramString2	String
    //   64	229	3	i	int
    //   221	8	4	j	int
    //   1	304	5	str	String
    //   35	197	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	37	136	java/lang/Exception
    //   42	48	136	java/lang/Exception
    //   49	63	136	java/lang/Exception
    //   69	79	136	java/lang/Exception
    //   123	135	136	java/lang/Exception
    //   199	213	136	java/lang/Exception
    //   213	223	136	java/lang/Exception
    //   237	289	136	java/lang/Exception
    //   93	118	166	java/lang/Throwable
    //   167	175	175	finally
    //   79	93	189	java/lang/Throwable
    //   118	123	189	java/lang/Throwable
    //   176	189	189	java/lang/Throwable
    //   190	198	198	finally
    //   79	93	303	finally
    //   118	123	303	finally
    //   176	189	303	finally
    //   93	118	310	finally
  }
  
  public static List<a.a> aEE()
  {
    return jUu;
  }
  
  private static float[] rU(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    case 0: 
      return new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    case 1: 
      return new float[] { 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    case 2: 
      return new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    case 3: 
      return new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    case 4: 
      return new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 100.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    }
    return new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 100.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  }
  
  public static void stop()
  {
    AppMethodBeat.i(163153);
    b localb = jUv;
    if (localb != null)
    {
      localb.handler.removeCallbacksAndMessages(null);
      Handler localHandler = localb.callbackHandler;
      if (localHandler == null) {
        p.bGy("callbackHandler");
      }
      localHandler.removeCallbacksAndMessages(null);
      localb.handler.post((Runnable)new b.c(localb));
    }
    started = false;
    AppMethodBeat.o(163153);
  }
  
  public static void v(Bitmap paramBitmap)
  {
    AppMethodBeat.i(163152);
    p.k(paramBitmap, "bitmap");
    if (!started)
    {
      b localb = new b();
      Context localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      p.k(paramBitmap, "originBitmap");
      p.k(localContext, "context");
      localb.jUC = paramBitmap;
      localb.jUG = paramBitmap.getWidth();
      localb.jUH = paramBitmap.getHeight();
      localb.handler.post((Runnable)new b.b(localb));
      jUv = localb;
    }
    started = true;
    AppMethodBeat.o(163152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.z.a
 * JD-Core Version:    0.7.0.1
 */