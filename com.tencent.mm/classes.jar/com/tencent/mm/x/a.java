package com.tencent.mm.x;

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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.j;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/glrender/BitmapFilter;", "", "()V", "TAG", "", "TYPE_ORIGIN", "", "TYPE_STYLE1", "TYPE_STYLE2", "TYPE_STYLE3", "TYPE_STYLE4", "TYPE_STYLE5", "TYPE_STYLE6", "TYPE_STYLE7", "TYPE_STYLE8", "filterRender", "Lcom/tencent/mm/glrender/FilterRender;", "getFilterRender", "()Lcom/tencent/mm/glrender/FilterRender;", "setFilterRender", "(Lcom/tencent/mm/glrender/FilterRender;)V", "localRoot", "getLocalRoot", "()Ljava/lang/String;", "started", "", "getStarted", "()Z", "setStarted", "(Z)V", "typeList", "", "Lcom/tencent/mm/glrender/BitmapFilter$FilterInfo;", "getTypeList", "()Ljava/util/List;", "copyAssets", "", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "filterBitmap", "Landroid/graphics/Bitmap;", "preBitmap", "type", "targetWidth", "targetHeight", "colorWeight", "", "filterToTargetSizeByMatrix", "inputBitmap", "getMatrix", "", "start", "bitmap", "stop", "FilterInfo", "plugin-photoedit-sdk_release"})
public final class a
{
  private static final String gvG;
  private static final List<a.a> gvH;
  private static b gvI;
  public static final a gvJ;
  private static boolean started;
  
  static
  {
    AppMethodBeat.i(163157);
    gvJ = new a();
    gvG = com.tencent.mm.loader.j.b.asc() + "photoedit";
    Object localObject1 = ak.getContext().getString(2131761910);
    p.g(localObject1, "MMApplicationContext.get…photo_filter_name_origin)");
    localObject1 = new a.a(0, (String)localObject1, "");
    Object localObject2 = ak.getContext().getString(2131761902);
    p.g(localObject2, "MMApplicationContext.get…ring.photo_filter_name_0)");
    localObject2 = new a.a(1, (String)localObject2, gvG + "/filter_source_0.png");
    Object localObject3 = ak.getContext().getString(2131761903);
    p.g(localObject3, "MMApplicationContext.get…ring.photo_filter_name_1)");
    localObject3 = new a.a(2, (String)localObject3, gvG + "/filter_source_1.png");
    Object localObject4 = ak.getContext().getString(2131761904);
    p.g(localObject4, "MMApplicationContext.get…ring.photo_filter_name_2)");
    localObject4 = new a.a(3, (String)localObject4, gvG + "/filter_source_2.png");
    Object localObject5 = ak.getContext().getString(2131761905);
    p.g(localObject5, "MMApplicationContext.get…ring.photo_filter_name_3)");
    localObject5 = new a.a(4, (String)localObject5, gvG + "/filter_source_3.png");
    Object localObject6 = ak.getContext().getString(2131761906);
    p.g(localObject6, "MMApplicationContext.get…ring.photo_filter_name_4)");
    localObject6 = new a.a(5, (String)localObject6, gvG + "/filter_source_4.png");
    Object localObject7 = ak.getContext().getString(2131761907);
    p.g(localObject7, "MMApplicationContext.get…ring.photo_filter_name_5)");
    localObject7 = new a.a(6, (String)localObject7, gvG + "/filter_source_5.png");
    Object localObject8 = ak.getContext().getString(2131761908);
    p.g(localObject8, "MMApplicationContext.get…ring.photo_filter_name_6)");
    localObject8 = new a.a(7, (String)localObject8, gvG + "/filter_source_6.png");
    String str = ak.getContext().getString(2131761909);
    p.g(str, "MMApplicationContext.get…ring.photo_filter_name_7)");
    gvH = j.listOf(new a.a[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, new a.a(8, str, gvG + "/filter_source_7.png") });
    localObject1 = ak.getContext();
    p.g(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getAssets();
    p.g(localObject1, "MMApplicationContext.getContext().assets");
    a((AssetManager)localObject1, "photofilters", gvG);
    AppMethodBeat.o(163157);
  }
  
  private static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(163155);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramBitmap.getConfig());
    Canvas localCanvas = new Canvas(localBitmap);
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.set(ml(paramInt3));
    Paint localPaint = new Paint();
    localPaint.setColorFilter((ColorFilter)new ColorMatrixColorFilter(localColorMatrix));
    localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new Rect(0, 0, paramInt1, paramInt2), localPaint);
    p.g(localBitmap, "retBitmap");
    AppMethodBeat.o(163155);
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    AppMethodBeat.i(163154);
    p.h(paramBitmap, "preBitmap");
    if (!started) {
      w(paramBitmap);
    }
    if (gvI != null)
    {
      long l = System.currentTimeMillis();
      Object localObject1 = ((Iterable)gvH).iterator();
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
        if (!bu.isNullOrNil(paramBitmap)) {
          break label180;
        }
        if (paramInt1 != 0) {
          ae.e("MicroMsg.BitmapFilter", "lut file not exist:".concat(String.valueOf(paramBitmap)));
        }
        paramBitmap = gvI;
        if (paramBitmap == null) {
          p.gkB();
        }
        paramBitmap = paramBitmap.agY();
        if (paramBitmap == null) {
          p.gkB();
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
      localObject1 = new y.f();
      ((y.f)localObject1).NiY = null;
      b localb = gvI;
      if (localb == null) {
        p.gkB();
      }
      if (paramBitmap == null) {
        p.gkB();
      }
      d.g.a.b localb1 = (d.g.a.b)new a.b(localObject2, (y.f)localObject1);
      p.h(paramBitmap, "lutFilePath");
      p.h(localb1, "callback");
      localb.handler.post((Runnable)new b.a(localb, localb1, paramBitmap, paramFloat));
      for (;;)
      {
        try
        {
          if ((Bitmap)((y.f)localObject1).NiY == null) {
            localObject2.wait();
          }
          paramBitmap = z.Nhr;
          paramBitmap = (Bitmap)((y.f)localObject1).NiY;
          if (paramBitmap == null) {
            p.gkB();
          }
          if ((paramInt2 == paramBitmap.getWidth()) && (paramInt3 == paramBitmap.getHeight())) {
            break;
          }
          localObject1 = a(paramBitmap, paramInt2, paramInt3, 0);
          localObject2 = new StringBuilder("filterBitmap cost ").append(System.currentTimeMillis() - l).append("ms, bitmap width:");
          paramBitmap = gvI;
          if (paramBitmap == null) {
            p.gkB();
          }
          paramBitmap = paramBitmap.agY();
          if (paramBitmap != null)
          {
            paramBitmap = Integer.valueOf(paramBitmap.getWidth());
            localObject2 = ((StringBuilder)localObject2).append(paramBitmap.intValue()).append(", height:");
            paramBitmap = gvI;
            if (paramBitmap == null) {
              p.gkB();
            }
            paramBitmap = paramBitmap.agY();
            if (paramBitmap == null) {
              break label512;
            }
            paramBitmap = Integer.valueOf(paramBitmap.getHeight());
            ae.i("MicroMsg.BitmapFilter", paramBitmap.intValue() + ", targetWidth:" + paramInt2 + ", targetHeight:" + paramInt3);
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
      paramBitmap = gvI;
      if (paramBitmap == null) {
        p.gkB();
      }
      paramBitmap = paramBitmap.agY();
      if (paramBitmap != null)
      {
        paramBitmap = Integer.valueOf(paramBitmap.getWidth());
        localObject2 = ((StringBuilder)localObject2).append(paramBitmap.intValue()).append(", height:");
        paramBitmap = gvI;
        if (paramBitmap == null) {
          p.gkB();
        }
        paramBitmap = paramBitmap.agY();
        if (paramBitmap == null) {
          break label664;
        }
      }
      label664:
      for (paramBitmap = Integer.valueOf(paramBitmap.getHeight());; paramBitmap = null)
      {
        ae.i("MicroMsg.BitmapFilter", paramBitmap.intValue());
        paramBitmap = (Bitmap)((y.f)localObject1).NiY;
        if (paramBitmap == null) {
          p.gkB();
        }
        AppMethodBeat.o(163154);
        return paramBitmap;
        paramBitmap = null;
        break;
      }
    }
    ae.w("MicroMsg.BitmapFilter", "filter render is null");
    paramBitmap = Bitmap.createBitmap(paramInt2, paramInt3, paramBitmap.getConfig());
    p.g(paramBitmap, "Bitmap.createBitmap(targ…Height, preBitmap.config)");
    AppMethodBeat.o(163154);
    return paramBitmap;
  }
  
  /* Error */
  private static void a(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 419
    //   6: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ldc_w 420
    //   13: invokestatic 264	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   16: aload_1
    //   17: ldc_w 421
    //   20: invokestatic 264	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: aload_2
    //   24: ldc_w 422
    //   27: invokestatic 264	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   30: aload_0
    //   31: aload_1
    //   32: invokevirtual 428	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   35: astore 6
    //   37: aload 6
    //   39: ifnonnull +10 -> 49
    //   42: ldc_w 419
    //   45: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: return
    //   49: aload 6
    //   51: arraylength
    //   52: ifne +101 -> 153
    //   55: iconst_1
    //   56: istore_3
    //   57: iload_3
    //   58: ifeq +147 -> 205
    //   61: aload_0
    //   62: aload_1
    //   63: invokevirtual 432	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   66: checkcast 434	java/io/Closeable
    //   69: astore 6
    //   71: aload 6
    //   73: checkcast 436	java/io/InputStream
    //   76: astore_0
    //   77: aload_2
    //   78: invokestatic 442	com/tencent/mm/vfs/o:Db	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   81: checkcast 434	java/io/Closeable
    //   84: astore_2
    //   85: aload_2
    //   86: checkcast 444	java/io/OutputStream
    //   89: astore_1
    //   90: aload_0
    //   91: ldc_w 446
    //   94: invokestatic 127	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   97: aload_1
    //   98: ldc_w 448
    //   101: invokestatic 127	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   104: aload_0
    //   105: aload_1
    //   106: invokestatic 454	d/f/a:f	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   109: pop2
    //   110: aload_2
    //   111: aconst_null
    //   112: invokestatic 459	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   115: aload 6
    //   117: aconst_null
    //   118: invokestatic 459	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   121: ldc_w 419
    //   124: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: return
    //   128: astore_0
    //   129: ldc_w 306
    //   132: aload_0
    //   133: checkcast 418	java/lang/Throwable
    //   136: ldc_w 460
    //   139: iconst_0
    //   140: anewarray 4	java/lang/Object
    //   143: invokestatic 464	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: ldc_w 419
    //   149: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: return
    //   153: iconst_0
    //   154: istore_3
    //   155: goto -98 -> 57
    //   158: astore_1
    //   159: ldc_w 419
    //   162: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload_1
    //   166: athrow
    //   167: astore_0
    //   168: aload_2
    //   169: aload_1
    //   170: invokestatic 459	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   173: ldc_w 419
    //   176: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload_0
    //   180: athrow
    //   181: astore_1
    //   182: ldc_w 419
    //   185: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_1
    //   189: athrow
    //   190: astore_0
    //   191: aload 6
    //   193: aload_1
    //   194: invokestatic 459	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   197: ldc_w 419
    //   200: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: aload_0
    //   204: athrow
    //   205: aload_2
    //   206: invokestatic 467	com/tencent/mm/vfs/o:aZI	(Ljava/lang/String;)Z
    //   209: pop
    //   210: aload 6
    //   212: arraylength
    //   213: istore 4
    //   215: iconst_0
    //   216: istore_3
    //   217: iload_3
    //   218: iload 4
    //   220: if_icmpge +68 -> 288
    //   223: aload 6
    //   225: iload_3
    //   226: aaload
    //   227: astore 5
    //   229: aload_0
    //   230: new 89	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   237: aload_1
    //   238: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: bipush 47
    //   243: invokevirtual 470	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   246: aload 5
    //   248: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: new 89	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   261: aload_2
    //   262: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: bipush 47
    //   267: invokevirtual 470	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   270: aload 5
    //   272: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 193	com/tencent/mm/x/a:a	(Landroid/content/res/AssetManager;Ljava/lang/String;Ljava/lang/String;)V
    //   281: iload_3
    //   282: iconst_1
    //   283: iadd
    //   284: istore_3
    //   285: goto -68 -> 217
    //   288: ldc_w 419
    //   291: invokestatic 196	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: return
    //   295: astore_0
    //   296: aload 5
    //   298: astore_1
    //   299: goto -108 -> 191
    //   302: astore_0
    //   303: aconst_null
    //   304: astore_1
    //   305: goto -137 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	paramAssetManager	AssetManager
    //   0	308	1	paramString1	String
    //   0	308	2	paramString2	String
    //   56	229	3	i	int
    //   213	8	4	j	int
    //   1	296	5	str	String
    //   35	189	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	37	128	java/lang/Exception
    //   42	48	128	java/lang/Exception
    //   49	55	128	java/lang/Exception
    //   61	71	128	java/lang/Exception
    //   115	127	128	java/lang/Exception
    //   191	205	128	java/lang/Exception
    //   205	215	128	java/lang/Exception
    //   229	281	128	java/lang/Exception
    //   85	110	158	java/lang/Throwable
    //   159	167	167	finally
    //   71	85	181	java/lang/Throwable
    //   110	115	181	java/lang/Throwable
    //   168	181	181	java/lang/Throwable
    //   182	190	190	finally
    //   71	85	295	finally
    //   110	115	295	finally
    //   168	181	295	finally
    //   85	110	302	finally
  }
  
  public static List<a.a> agV()
  {
    return gvH;
  }
  
  private static float[] ml(int paramInt)
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
    b localb = gvI;
    if (localb != null)
    {
      localb.handler.removeCallbacksAndMessages(null);
      Handler localHandler = localb.callbackHandler;
      if (localHandler == null) {
        p.bdF("callbackHandler");
      }
      localHandler.removeCallbacksAndMessages(null);
      localb.handler.post((Runnable)new b.c(localb));
    }
    started = false;
    AppMethodBeat.o(163153);
  }
  
  public static void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(163152);
    p.h(paramBitmap, "bitmap");
    if (!started)
    {
      b localb = new b();
      Context localContext = ak.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      p.h(paramBitmap, "originBitmap");
      p.h(localContext, "context");
      localb.gvP = paramBitmap;
      localb.gvT = paramBitmap.getWidth();
      localb.gvU = paramBitmap.getHeight();
      localb.handler.post((Runnable)new b.b(localb));
      gvI = localb;
    }
    started = true;
    AppMethodBeat.o(163152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.x.a
 * JD-Core Version:    0.7.0.1
 */