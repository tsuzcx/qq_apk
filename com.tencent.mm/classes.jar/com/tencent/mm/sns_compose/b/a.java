package com.tencent.mm.sns_compose.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import coil.e.c;
import coil.e.d;
import coil.e.e;
import coil.e.i;
import coil.size.PixelSize;
import coil.size.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import j.aa;
import j.f;
import j.h;
import j.q;
import java.io.Closeable;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/coil/MMBitmapFactoryDecoder;", "Lcoil/decode/Decoder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "paint", "Landroid/graphics/Paint;", "applyExifTransformations", "Landroid/graphics/Bitmap;", "pool", "Lcoil/bitmap/BitmapPool;", "inBitmap", "config", "Landroid/graphics/Bitmap$Config;", "isFlipped", "", "rotationDegrees", "", "decode", "Lcoil/decode/DecodeResult;", "source", "Lokio/BufferedSource;", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Lokio/BufferedSource;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decodeInterruptible", "Lokio/Source;", "handles", "mimeType", "", "shouldReadExifData", "computeConfig", "Landroid/graphics/BitmapFactory$Options;", "Companion", "ExceptionCatchingSource", "ExifInterfaceInputStream", "sns-compose_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements e
{
  public static final a.a aczn;
  private static final String[] cmR;
  private final Context context;
  private final Paint paint;
  
  static
  {
    AppMethodBeat.i(235433);
    aczn = new a.a((byte)0);
    cmR = new String[] { "image/jpeg", "image/webp", "image/heic", "image/heif" };
    AppMethodBeat.o(235433);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(235393);
    this.context = paramContext;
    this.paint = new Paint(3);
    AppMethodBeat.o(235393);
  }
  
  private final c a(coil.b.b paramb, aa paramaa, Size paramSize, i parami)
  {
    AppMethodBeat.i(235426);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    b localb = new b(paramaa);
    h localh = q.b((aa)localb);
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeStream(localh.kIz().kIA(), null, localOptions);
    paramaa = localb.exception;
    if (paramaa != null)
    {
      AppMethodBeat.o(235426);
      throw paramaa;
    }
    localOptions.inJustDecodeBounds = false;
    paramaa = localOptions.outMimeType;
    int i;
    if ((paramaa != null) && (kotlin.a.k.contains(cmR, paramaa))) {
      i = 1;
    }
    Object localObject;
    boolean bool1;
    int k;
    label196:
    int j;
    label208:
    label220:
    int m;
    label271:
    boolean bool2;
    while (i != 0)
    {
      paramaa = new androidx.f.a.a((InputStream)new a.c(localh.kIz().kIA()));
      localObject = localb.exception;
      if (localObject != null)
      {
        AppMethodBeat.o(235426);
        throw ((Throwable)localObject);
        i = 0;
      }
      else
      {
        bool1 = paramaa.FK();
        i = paramaa.iB();
        if ((i != 90) && (i != 270)) {
          break label603;
        }
        k = 1;
        if (k == 0) {
          break label609;
        }
        j = localOptions.outHeight;
        if (k == 0) {
          break label619;
        }
        k = localOptions.outWidth;
        localObject = parami.clE;
        if (!bool1)
        {
          paramaa = (aa)localObject;
          if (i <= 0) {}
        }
        else if (localObject != null)
        {
          s.u(localObject, "<this>");
          if ((Build.VERSION.SDK_INT < 26) || (localObject != Bitmap.Config.HARDWARE)) {
            break label629;
          }
          m = 1;
          paramaa = (aa)localObject;
          if (m == 0) {}
        }
        else
        {
          paramaa = Bitmap.Config.ARGB_8888;
        }
        localObject = paramaa;
        if (parami.cns)
        {
          localObject = paramaa;
          if (paramaa == Bitmap.Config.ARGB_8888)
          {
            localObject = paramaa;
            if (s.p(localOptions.outMimeType, "image/jpeg")) {
              localObject = Bitmap.Config.RGB_565;
            }
          }
        }
        paramaa = (aa)localObject;
        if (Build.VERSION.SDK_INT >= 26)
        {
          paramaa = (aa)localObject;
          if (localOptions.outConfig == Bitmap.Config.RGBA_F16)
          {
            paramaa = (aa)localObject;
            if (localObject != Bitmap.Config.HARDWARE) {
              paramaa = Bitmap.Config.RGBA_F16;
            }
          }
        }
        localOptions.inPreferredConfig = paramaa;
        if ((Build.VERSION.SDK_INT >= 26) && (parami.cnq != null)) {
          localOptions.inPreferredColorSpace = parami.cnq;
        }
        if (Build.VERSION.SDK_INT >= 19) {
          localOptions.inPremultiplied = parami.cnt;
        }
        if (Build.VERSION.SDK_INT >= 24) {
          break label635;
        }
        bool2 = true;
        label426:
        localOptions.inMutable = bool2;
        localOptions.inScaled = false;
        if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0)) {
          break label641;
        }
        localOptions.inSampleSize = 1;
        localOptions.inScaled = false;
      }
    }
    label472:
    label477:
    label609:
    label619:
    label629:
    label1527:
    for (;;)
    {
      for (;;)
      {
        paramaa = null;
        paramSize = localOptions;
        paramSize.inBitmap = paramaa;
        localObject = localOptions.inBitmap;
        for (;;)
        {
          try
          {
            paramSize = (Closeable)localh;
          }
          finally
          {
            label635:
            continue;
            if (paramaa != null) {
              continue;
            }
            paramb = (Throwable)new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.".toString());
            AppMethodBeat.o(235426);
            throw paramb;
            paramaa.setDensity(parami.context.getResources().getDisplayMetrics().densityDpi);
            paramSize = localOptions.inPreferredConfig;
            s.s(paramSize, "inPreferredConfig");
            if (i <= 0) {
              continue;
            }
            j = 1;
            if ((bool1) || (j != 0)) {
              continue;
            }
            paramb = this.context.getResources();
            s.s(paramb, "context.resources");
            paramb = (Drawable)new BitmapDrawable(paramb, paramaa);
            if ((localOptions.inSampleSize <= 1) && (!localOptions.inScaled)) {
              continue;
            }
            bool1 = true;
            paramb = new c(paramb, bool1);
            AppMethodBeat.o(235426);
            return paramb;
            j = 0;
            continue;
            parami = new Matrix();
            float f1 = paramaa.getWidth() / 2.0F;
            float f2 = paramaa.getHeight() / 2.0F;
            if (!bool1) {
              continue;
            }
            parami.postScale(-1.0F, 1.0F, f1, f2);
            if (j == 0) {
              continue;
            }
            parami.postRotate(i, f1, f2);
            localObject = new RectF(0.0F, 0.0F, paramaa.getWidth(), paramaa.getHeight());
            parami.mapRect((RectF)localObject);
            if (((RectF)localObject).left != 0.0F) {
              continue;
            }
            j = 1;
            if (j == 0) {
              continue;
            }
            if (((RectF)localObject).top != 0.0F) {
              continue;
            }
            j = 1;
            if (j != 0) {
              continue;
            }
            parami.postTranslate(-((RectF)localObject).left, -((RectF)localObject).top);
            switch (i)
            {
            default: 
              paramSize = paramb.b(paramaa.getWidth(), paramaa.getHeight(), paramSize);
              new Canvas(paramSize).drawBitmap(paramaa, parami, this.paint);
              paramb.n(paramaa);
              paramaa = paramSize;
              continue;
              j = 0;
              continue;
              j = 0;
              break;
            case 90: 
            case 270: 
              paramSize = paramb.b(paramaa.getHeight(), paramaa.getWidth(), paramSize);
              continue;
              bool1 = false;
              continue;
            }
          }
          try
          {
            paramaa = (h)paramSize;
            if ((Build.VERSION.SDK_INT < 19) && (localOptions.outMimeType == null))
            {
              paramaa = paramaa.Ml();
              paramaa = BitmapFactory.decodeByteArray(paramaa, 0, paramaa.length, localOptions);
              kotlin.f.b.a(paramSize, null);
              try
              {
                paramSize = localb.exception;
                if (paramSize == null) {
                  continue;
                }
                AppMethodBeat.o(235426);
                throw paramSize;
              }
              finally
              {
                paramSize = paramaa;
                paramaa = parami;
              }
              if (localObject != null) {
                paramb.n((Bitmap)localObject);
              }
              if ((paramSize != localObject) && (paramSize != null)) {
                paramb.n(paramSize);
              }
              AppMethodBeat.o(235426);
              throw paramaa;
              i = 0;
              bool1 = false;
              break;
              k = 0;
              break label196;
              j = localOptions.outWidth;
              break label208;
              k = localOptions.outHeight;
              break label220;
              m = 0;
              break label271;
              bool2 = false;
              break label426;
              if (!(paramSize instanceof PixelSize))
              {
                localOptions.inSampleSize = 1;
                localOptions.inScaled = false;
                if (!localOptions.inMutable) {
                  break label477;
                }
                j = localOptions.outWidth;
                k = localOptions.outHeight;
                paramaa = localOptions.inPreferredConfig;
                s.s(paramaa, "inPreferredConfig");
                paramaa = paramb.d(j, k, paramaa);
                paramSize = localOptions;
                break label472;
              }
              m = ((PixelSize)paramSize).width;
              int n = ((PixelSize)paramSize).height;
              localOptions.inSampleSize = d.a(j, k, m, n, parami.cmi);
              double d1 = d.a(j / localOptions.inSampleSize, k / localOptions.inSampleSize, m, n, parami.cmi);
              if (parami.cnr)
              {
                d1 = kotlin.k.k.aj(d1);
                if (d1 != 1.0D) {
                  continue;
                }
                j = 1;
                if (j != 0) {
                  continue;
                }
                bool2 = true;
                localOptions.inScaled = bool2;
                if (localOptions.inScaled)
                {
                  if (d1 <= 1.0D) {
                    continue;
                  }
                  localOptions.inDensity = kotlin.h.a.ah(2147483647.0D / d1);
                  localOptions.inTargetDensity = 2147483647;
                }
                if (!localOptions.inMutable) {
                  break label477;
                }
                if ((localOptions.inSampleSize != 1) || (localOptions.inScaled)) {
                  continue;
                }
                j = localOptions.outWidth;
                k = localOptions.outHeight;
                paramaa = localOptions.inPreferredConfig;
                s.s(paramaa, "inPreferredConfig");
                paramaa = paramb.d(j, k, paramaa);
                paramSize = localOptions;
                break label472;
              }
              continue;
              j = 0;
              continue;
              bool2 = false;
              continue;
              localOptions.inDensity = 2147483647;
              localOptions.inTargetDensity = kotlin.h.a.ah(2147483647.0D * d1);
              continue;
              if (Build.VERSION.SDK_INT < 19) {
                break label1527;
              }
              double d2 = localOptions.outWidth / localOptions.inSampleSize;
              double d3 = localOptions.outHeight / localOptions.inSampleSize;
              j = (int)Math.ceil(d2 * d1 + 0.5D);
              k = (int)Math.ceil(d1 * d3 + 0.5D);
              paramaa = localOptions.inPreferredConfig;
              s.s(paramaa, "inPreferredConfig");
              paramaa = paramb.d(j, k, paramaa);
              paramSize = localOptions;
              break label472;
            }
            paramaa = MMBitmapFactory.decodeStream(paramaa.kIA(), null, localOptions);
            continue;
            paramaa = finally;
          }
          finally
          {
            try
            {
              AppMethodBeat.o(235426);
              throw paramaa;
            }
            finally
            {
              kotlin.f.b.a(paramSize, paramaa);
              AppMethodBeat.o(235426);
            }
          }
        }
      }
    }
  }
  
  /* Error */
  public final Object a(coil.b.b paramb, h paramh, Size paramSize, i parami, kotlin.d.d<? super c> paramd)
  {
    // Byte code:
    //   0: ldc_w 433
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 435	kotlinx/coroutines/q
    //   9: dup
    //   10: aload 5
    //   12: invokestatic 441	kotlin/d/a/b:au	(Lkotlin/d/d;)Lkotlin/d/d;
    //   15: iconst_1
    //   16: invokespecial 444	kotlinx/coroutines/q:<init>	(Lkotlin/d/d;I)V
    //   19: astore 6
    //   21: aload 6
    //   23: invokevirtual 447	kotlinx/coroutines/q:kBA	()V
    //   26: aload 6
    //   28: checkcast 449	kotlinx/coroutines/p
    //   31: astore 7
    //   33: new 451	coil/e/h
    //   36: dup
    //   37: aload 7
    //   39: aload_2
    //   40: checkcast 124	j/aa
    //   43: invokespecial 454	coil/e/h:<init>	(Lkotlinx/coroutines/p;Lj/aa;)V
    //   46: astore_2
    //   47: aload 7
    //   49: checkcast 456	kotlin/d/d
    //   52: astore 7
    //   54: aload_0
    //   55: aload_1
    //   56: aload_2
    //   57: checkcast 124	j/aa
    //   60: aload_3
    //   61: aload 4
    //   63: invokespecial 458	com/tencent/mm/sns_compose/b/a:a	(Lcoil/b/b;Lj/aa;Lcoil/size/Size;Lcoil/e/i;)Lcoil/e/c;
    //   66: astore_1
    //   67: getstatic 463	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   70: astore_3
    //   71: aload 7
    //   73: aload_1
    //   74: invokestatic 467	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   77: invokeinterface 471 2 0
    //   82: aload_2
    //   83: invokevirtual 474	coil/e/h:MP	()V
    //   86: aload 6
    //   88: invokevirtual 478	kotlinx/coroutines/q:getResult	()Ljava/lang/Object;
    //   91: astore_1
    //   92: aload_1
    //   93: getstatic 484	kotlin/d/a/a:aiwj	Lkotlin/d/a/a;
    //   96: if_acmpne +11 -> 107
    //   99: aload 5
    //   101: ldc_w 486
    //   104: invokestatic 102	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   107: ldc_w 433
    //   110: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_1
    //   114: areturn
    //   115: astore_1
    //   116: aload_2
    //   117: invokevirtual 474	coil/e/h:MP	()V
    //   120: ldc_w 433
    //   123: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aload_1
    //   130: instanceof 488
    //   133: ifne +10 -> 143
    //   136: aload_1
    //   137: instanceof 490
    //   140: ifeq +36 -> 176
    //   143: new 492	java/util/concurrent/CancellationException
    //   146: dup
    //   147: ldc_w 494
    //   150: invokespecial 495	java/util/concurrent/CancellationException:<init>	(Ljava/lang/String;)V
    //   153: aload_1
    //   154: checkcast 344	java/lang/Throwable
    //   157: invokevirtual 499	java/util/concurrent/CancellationException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   160: astore_1
    //   161: aload_1
    //   162: ldc_w 501
    //   165: invokestatic 278	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   168: ldc_w 433
    //   171: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_1
    //   175: athrow
    //   176: ldc_w 433
    //   179: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_1
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	a
    //   0	184	1	paramb	coil.b.b
    //   0	184	2	paramh	h
    //   0	184	3	paramSize	Size
    //   0	184	4	parami	i
    //   0	184	5	paramd	kotlin.d.d<? super c>
    //   19	68	6	localq	kotlinx.coroutines.q
    //   31	41	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   47	82	115	finally
    //   33	47	128	java/lang/Exception
    //   82	86	128	java/lang/Exception
    //   116	128	128	java/lang/Exception
  }
  
  public final boolean a(h paramh)
  {
    AppMethodBeat.i(235438);
    s.u(paramh, "source");
    AppMethodBeat.o(235438);
    return true;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/coil/MMBitmapFactoryDecoder$ExceptionCatchingSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "(Lokio/Source;)V", "<set-?>", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "getException", "()Ljava/lang/Exception;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "sns-compose_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    extends j.k
  {
    Exception exception;
    
    public b(aa paramaa)
    {
      super();
      AppMethodBeat.i(235385);
      AppMethodBeat.o(235385);
    }
    
    public final long a(f paramf, long paramLong)
    {
      AppMethodBeat.i(235389);
      s.u(paramf, "sink");
      try
      {
        paramLong = super.a(paramf, paramLong);
        AppMethodBeat.o(235389);
        return paramLong;
      }
      catch (Exception paramf)
      {
        this.exception = paramf;
        AppMethodBeat.o(235389);
        throw paramf;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.sns_compose.b.a
 * JD-Core Version:    0.7.0.1
 */