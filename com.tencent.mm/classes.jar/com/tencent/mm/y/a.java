package com.tencent.mm.y;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bo.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/glrender/BitmapFilter;", "", "()V", "TAG", "", "TYPE_ORIGIN", "", "TYPE_STYLE1", "TYPE_STYLE2", "TYPE_STYLE3", "TYPE_STYLE4", "TYPE_STYLE5", "TYPE_STYLE6", "TYPE_STYLE7", "TYPE_STYLE8", "filterRender", "Lcom/tencent/mm/glrender/FilterRender;", "getFilterRender", "()Lcom/tencent/mm/glrender/FilterRender;", "setFilterRender", "(Lcom/tencent/mm/glrender/FilterRender;)V", "localRoot", "getLocalRoot", "()Ljava/lang/String;", "started", "", "getStarted", "()Z", "setStarted", "(Z)V", "typeList", "", "Lcom/tencent/mm/glrender/BitmapFilter$FilterInfo;", "getTypeList", "()Ljava/util/List;", "copyAssets", "", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "filterBitmap", "Landroid/graphics/Bitmap;", "preBitmap", "type", "targetWidth", "targetHeight", "colorWeight", "", "filterToTargetSizeByMatrix", "inputBitmap", "getMatrix", "", "start", "bitmap", "stop", "FilterInfo", "plugin-photoedit-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a muK;
  private static final String muL;
  private static final List<a.a> muM;
  private static b muN;
  private static boolean started;
  
  static
  {
    AppMethodBeat.i(163157);
    muK = new a();
    muL = s.X(com.tencent.mm.loader.i.b.bms(), "photoedit");
    Object localObject1 = MMApplicationContext.getContext().getString(a.h.photo_filter_name_origin);
    s.s(localObject1, "getContext().getString(R…photo_filter_name_origin)");
    localObject1 = new a.a(0, (String)localObject1, "");
    Object localObject2 = MMApplicationContext.getContext().getString(a.h.photo_filter_name_0);
    s.s(localObject2, "getContext().getString(R…ring.photo_filter_name_0)");
    localObject2 = new a.a(1, (String)localObject2, s.X(muL, "/filter_source_0.png"));
    Object localObject3 = MMApplicationContext.getContext().getString(a.h.photo_filter_name_1);
    s.s(localObject3, "getContext().getString(R…ring.photo_filter_name_1)");
    localObject3 = new a.a(2, (String)localObject3, s.X(muL, "/filter_source_1.png"));
    Object localObject4 = MMApplicationContext.getContext().getString(a.h.photo_filter_name_2);
    s.s(localObject4, "getContext().getString(R…ring.photo_filter_name_2)");
    localObject4 = new a.a(3, (String)localObject4, s.X(muL, "/filter_source_2.png"));
    Object localObject5 = MMApplicationContext.getContext().getString(a.h.photo_filter_name_3);
    s.s(localObject5, "getContext().getString(R…ring.photo_filter_name_3)");
    localObject5 = new a.a(4, (String)localObject5, s.X(muL, "/filter_source_3.png"));
    Object localObject6 = MMApplicationContext.getContext().getString(a.h.photo_filter_name_4);
    s.s(localObject6, "getContext().getString(R…ring.photo_filter_name_4)");
    localObject6 = new a.a(5, (String)localObject6, s.X(muL, "/filter_source_4.png"));
    Object localObject7 = MMApplicationContext.getContext().getString(a.h.photo_filter_name_5);
    s.s(localObject7, "getContext().getString(R…ring.photo_filter_name_5)");
    localObject7 = new a.a(6, (String)localObject7, s.X(muL, "/filter_source_5.png"));
    Object localObject8 = MMApplicationContext.getContext().getString(a.h.photo_filter_name_6);
    s.s(localObject8, "getContext().getString(R…ring.photo_filter_name_6)");
    localObject8 = new a.a(7, (String)localObject8, s.X(muL, "/filter_source_6.png"));
    String str = MMApplicationContext.getContext().getString(a.h.photo_filter_name_7);
    s.s(str, "getContext().getString(R…ring.photo_filter_name_7)");
    muM = p.listOf(new a.a[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, new a.a(8, str, s.X(muL, "/filter_source_7.png")) });
    localObject1 = MMApplicationContext.getContext().getAssets();
    s.s(localObject1, "getContext().assets");
    a((AssetManager)localObject1, "photofilters", muL);
    AppMethodBeat.o(163157);
  }
  
  public static void D(Bitmap paramBitmap)
  {
    AppMethodBeat.i(163152);
    s.u(paramBitmap, "bitmap");
    if (!started)
    {
      b localb = new b();
      Context localContext = MMApplicationContext.getContext();
      s.s(localContext, "getContext()");
      localb.a(paramBitmap, localContext);
      muN = localb;
    }
    started = true;
    AppMethodBeat.o(163152);
  }
  
  private static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(163155);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramBitmap.getConfig());
    Canvas localCanvas = new Canvas(localBitmap);
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.set(rW(paramInt3));
    Paint localPaint = new Paint();
    localPaint.setColorFilter((ColorFilter)new ColorMatrixColorFilter(localColorMatrix));
    localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new Rect(0, 0, paramInt1, paramInt2), localPaint);
    s.s(localBitmap, "retBitmap");
    AppMethodBeat.o(163155);
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    Bitmap localBitmap = null;
    StringBuilder localStringBuilder = null;
    AppMethodBeat.i(163154);
    s.u(paramBitmap, "preBitmap");
    if (!started) {
      D(paramBitmap);
    }
    if (muN != null)
    {
      long l = System.currentTimeMillis();
      Object localObject1 = ((Iterable)muM).iterator();
      int i;
      if (((Iterator)localObject1).hasNext())
      {
        paramBitmap = ((Iterator)localObject1).next();
        if (((a.a)paramBitmap).type == paramInt1)
        {
          i = 1;
          label85:
          if (i == 0) {
            break label162;
          }
          label90:
          paramBitmap = (a.a)paramBitmap;
          if (paramBitmap != null) {
            break label169;
          }
        }
      }
      label162:
      label169:
      for (paramBitmap = null;; paramBitmap = paramBitmap.fileName)
      {
        if (!Util.isNullOrNil(paramBitmap)) {
          break label177;
        }
        if (paramInt1 != 0) {
          Log.e("MicroMsg.BitmapFilter", s.X("lut file not exist:", paramBitmap));
        }
        paramBitmap = muN;
        s.checkNotNull(paramBitmap);
        paramBitmap = paramBitmap.aXM();
        s.checkNotNull(paramBitmap);
        paramBitmap = a(paramBitmap, paramInt2, paramInt3, paramInt1);
        AppMethodBeat.o(163154);
        return paramBitmap;
        i = 0;
        break label85;
        break;
        paramBitmap = null;
        break label90;
      }
      label177:
      Object localObject2 = new Object();
      localObject1 = new ah.f();
      b localb = muN;
      s.checkNotNull(localb);
      s.checkNotNull(paramBitmap);
      localb.a(paramBitmap, paramFloat, (kotlin.g.a.b)new a.b(localObject2, (ah.f)localObject1));
      for (;;)
      {
        try
        {
          if (((ah.f)localObject1).aqH == null) {
            localObject2.wait();
          }
          paramBitmap = ah.aiuX;
          paramBitmap = ((ah.f)localObject1).aqH;
          s.checkNotNull(paramBitmap);
          paramBitmap = (Bitmap)paramBitmap;
          if ((paramInt2 == paramBitmap.getWidth()) && (paramInt3 == paramBitmap.getHeight())) {
            break;
          }
          localBitmap = a(paramBitmap, paramInt2, paramInt3, 0);
          localObject1 = new StringBuilder("filterBitmap cost ").append(System.currentTimeMillis() - l).append("ms, bitmap width:");
          paramBitmap = muN;
          s.checkNotNull(paramBitmap);
          paramBitmap = paramBitmap.aXM();
          if (paramBitmap == null)
          {
            paramBitmap = null;
            localObject1 = ((StringBuilder)localObject1).append(paramBitmap).append(", height:");
            paramBitmap = muN;
            s.checkNotNull(paramBitmap);
            paramBitmap = paramBitmap.aXM();
            if (paramBitmap != null) {
              break label441;
            }
            paramBitmap = localStringBuilder;
            Log.i("MicroMsg.BitmapFilter", paramBitmap + ", targetWidth:" + paramInt2 + ", targetHeight:" + paramInt3);
            AppMethodBeat.o(163154);
            return localBitmap;
          }
        }
        finally
        {
          AppMethodBeat.o(163154);
        }
        paramBitmap = Integer.valueOf(paramBitmap.getWidth());
        continue;
        label441:
        paramBitmap = Integer.valueOf(paramBitmap.getHeight());
      }
      localStringBuilder = new StringBuilder("filterBitmap cost ").append(System.currentTimeMillis() - l).append("ms, bitmap width:");
      paramBitmap = muN;
      s.checkNotNull(paramBitmap);
      paramBitmap = paramBitmap.aXM();
      if (paramBitmap == null)
      {
        paramBitmap = null;
        localStringBuilder = localStringBuilder.append(paramBitmap).append(", height:");
        paramBitmap = muN;
        s.checkNotNull(paramBitmap);
        paramBitmap = paramBitmap.aXM();
        if (paramBitmap != null) {
          break label581;
        }
      }
      label581:
      for (paramBitmap = localBitmap;; paramBitmap = Integer.valueOf(paramBitmap.getHeight()))
      {
        Log.i("MicroMsg.BitmapFilter", paramBitmap);
        paramBitmap = ((ah.f)localObject1).aqH;
        s.checkNotNull(paramBitmap);
        paramBitmap = (Bitmap)paramBitmap;
        AppMethodBeat.o(163154);
        return paramBitmap;
        paramBitmap = Integer.valueOf(paramBitmap.getWidth());
        break;
      }
    }
    Log.w("MicroMsg.BitmapFilter", "filter render is null");
    paramBitmap = Bitmap.createBitmap(paramInt2, paramInt3, paramBitmap.getConfig());
    s.s(paramBitmap, "createBitmap(targetWidth…Height, preBitmap.config)");
    AppMethodBeat.o(163154);
    return paramBitmap;
  }
  
  /* Error */
  private static void a(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 424
    //   3: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 425
    //   10: invokestatic 221	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: ldc_w 426
    //   17: invokestatic 221	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: aload_2
    //   21: ldc_w 427
    //   24: invokestatic 221	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   27: aload_0
    //   28: aload_1
    //   29: invokevirtual 433	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   32: astore 5
    //   34: aload 5
    //   36: ifnonnull +10 -> 46
    //   39: ldc_w 424
    //   42: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: return
    //   46: aload 5
    //   48: arraylength
    //   49: ifne +102 -> 151
    //   52: iconst_1
    //   53: istore_3
    //   54: iload_3
    //   55: ifeq +149 -> 204
    //   58: aload_0
    //   59: aload_1
    //   60: invokevirtual 437	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   63: checkcast 439	java/io/Closeable
    //   66: astore_0
    //   67: aload_0
    //   68: checkcast 441	java/io/InputStream
    //   71: astore 5
    //   73: aload_2
    //   74: iconst_0
    //   75: invokestatic 447	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   78: checkcast 439	java/io/Closeable
    //   81: astore_1
    //   82: aload_1
    //   83: checkcast 449	java/io/OutputStream
    //   86: astore_2
    //   87: aload 5
    //   89: ldc_w 451
    //   92: invokestatic 129	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   95: aload_2
    //   96: ldc_w 453
    //   99: invokestatic 129	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   102: aload 5
    //   104: aload_2
    //   105: invokestatic 458	kotlin/f/a:i	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   108: pop2
    //   109: aload_1
    //   110: aconst_null
    //   111: invokestatic 463	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   114: aload_0
    //   115: aconst_null
    //   116: invokestatic 463	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   119: ldc_w 424
    //   122: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: return
    //   126: astore_0
    //   127: ldc_w 328
    //   130: aload_0
    //   131: checkcast 465	java/lang/Throwable
    //   134: ldc_w 466
    //   137: iconst_0
    //   138: anewarray 4	java/lang/Object
    //   141: invokestatic 470	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: ldc_w 424
    //   147: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: return
    //   151: iconst_0
    //   152: istore_3
    //   153: goto -99 -> 54
    //   156: astore_2
    //   157: ldc_w 424
    //   160: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_2
    //   164: athrow
    //   165: astore 5
    //   167: aload_1
    //   168: aload_2
    //   169: invokestatic 463	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   172: ldc_w 424
    //   175: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aload 5
    //   180: athrow
    //   181: astore_1
    //   182: ldc_w 424
    //   185: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_1
    //   189: athrow
    //   190: astore_2
    //   191: aload_0
    //   192: aload_1
    //   193: invokestatic 463	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   196: ldc_w 424
    //   199: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload_2
    //   203: athrow
    //   204: aload_2
    //   205: invokestatic 473	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   208: pop
    //   209: aload 5
    //   211: arraylength
    //   212: istore 4
    //   214: iconst_0
    //   215: istore_3
    //   216: iload_3
    //   217: iload 4
    //   219: if_icmpge +68 -> 287
    //   222: aload 5
    //   224: iload_3
    //   225: aaload
    //   226: astore 6
    //   228: aload_0
    //   229: new 377	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 474	java/lang/StringBuilder:<init>	()V
    //   236: aload_1
    //   237: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: bipush 47
    //   242: invokevirtual 477	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   245: aload 6
    //   247: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 406	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: new 377	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 474	java/lang/StringBuilder:<init>	()V
    //   260: aload_2
    //   261: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: bipush 47
    //   266: invokevirtual 477	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   269: aload 6
    //   271: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 406	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 209	com/tencent/mm/y/a:a	(Landroid/content/res/AssetManager;Ljava/lang/String;Ljava/lang/String;)V
    //   280: iload_3
    //   281: iconst_1
    //   282: iadd
    //   283: istore_3
    //   284: goto -68 -> 216
    //   287: ldc_w 424
    //   290: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   293: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	paramAssetManager	AssetManager
    //   0	294	1	paramString1	String
    //   0	294	2	paramString2	String
    //   53	231	3	i	int
    //   212	8	4	j	int
    //   32	71	5	localObject1	Object
    //   165	58	5	localObject2	Object
    //   226	44	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   27	34	126	java/lang/Exception
    //   39	45	126	java/lang/Exception
    //   46	52	126	java/lang/Exception
    //   58	67	126	java/lang/Exception
    //   114	125	126	java/lang/Exception
    //   191	204	126	java/lang/Exception
    //   204	214	126	java/lang/Exception
    //   228	280	126	java/lang/Exception
    //   82	109	156	finally
    //   157	165	165	finally
    //   67	82	181	finally
    //   109	114	181	finally
    //   167	181	181	finally
    //   182	190	190	finally
  }
  
  public static List<a.a> aXH()
  {
    return muM;
  }
  
  private static float[] rW(int paramInt)
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
    b localb = muN;
    if (localb != null) {
      localb.stop();
    }
    started = false;
    AppMethodBeat.o(163153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.y.a
 * JD-Core Version:    0.7.0.1
 */