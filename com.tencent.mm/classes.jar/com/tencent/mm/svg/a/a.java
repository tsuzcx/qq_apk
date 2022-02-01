package com.tencent.mm.svg.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.svg.WeChatSVG;
import com.tencent.mm.svg.b.b;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.util.EncodingUtils;

public final class a
{
  private static String adot;
  protected static int adou;
  private static String adov;
  private static Map<Integer, com.tencent.mm.svg.c> adow;
  private static Map<Integer, Picture> adox;
  private static Map<String, Picture> adoy;
  private static Float adoz;
  private TypedValue ador;
  private byte[] ados;
  
  static
  {
    AppMethodBeat.i(148716);
    adot = ".svg.code.drawable";
    adou = 3;
    adov = "";
    adow = new ConcurrentHashMap();
    adox = new ConcurrentHashMap();
    adoy = new ConcurrentHashMap();
    AppMethodBeat.o(148716);
  }
  
  public a()
  {
    AppMethodBeat.i(148701);
    this.ador = new TypedValue();
    this.ados = new byte[0];
    AppMethodBeat.o(148701);
  }
  
  protected static View S(Drawable paramDrawable)
  {
    AppMethodBeat.i(148710);
    for (;;)
    {
      paramDrawable = paramDrawable.getCallback();
      if (paramDrawable == null) {
        break;
      }
      if ((paramDrawable instanceof View))
      {
        paramDrawable = (View)paramDrawable;
        AppMethodBeat.o(148710);
        return paramDrawable;
      }
      if (!(paramDrawable instanceof Drawable)) {
        break;
      }
      paramDrawable = (Drawable)paramDrawable;
    }
    AppMethodBeat.o(148710);
    return null;
  }
  
  private static Picture a(float paramFloat1, com.tencent.mm.svg.c paramc, float paramFloat2)
  {
    AppMethodBeat.i(148715);
    Picture localPicture = new Picture();
    if (paramc == null)
    {
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "fromCodeToPicture code is null!", new Object[0]);
      AppMethodBeat.o(148715);
      return localPicture;
    }
    paramFloat1 = dI(paramFloat1) * paramFloat2;
    paramFloat2 = com.tencent.mm.svg.c.getWidth(paramc);
    float f = com.tencent.mm.svg.c.getHeight(paramc);
    Canvas localCanvas = localPicture.beginRecording((int)(paramFloat2 * paramFloat1), (int)(f * paramFloat1));
    localCanvas.save();
    localCanvas.scale(paramFloat1, paramFloat1);
    com.tencent.mm.svg.c.render(paramc, localCanvas, Looper.myLooper());
    localCanvas.restore();
    localPicture.endRecording();
    AppMethodBeat.o(148715);
    return localPicture;
  }
  
  public static Drawable a(Resources paramResources, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(148704);
    if (paramInt == 0)
    {
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "getSVGDrawable a invalid resource!!! %s", new Object[] { Integer.valueOf(paramInt) });
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Why no log??", new Object[0]);
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "The stack : %s", new Object[] { jek() });
      paramResources = new c(new Picture(), paramInt);
      AppMethodBeat.o(148704);
      return paramResources;
    }
    if (b.jev())
    {
      paramResources = c(paramResources, paramInt, paramFloat);
      AppMethodBeat.o(148704);
      return paramResources;
    }
    paramResources = a(paramResources, paramInt, adov + adot, paramFloat);
    AppMethodBeat.o(148704);
    return paramResources;
  }
  
  private static Drawable a(Resources paramResources, int paramInt, String paramString, float paramFloat)
  {
    AppMethodBeat.i(148713);
    float f2 = paramResources.getDisplayMetrics().density;
    float f1;
    Picture localPicture2;
    Picture localPicture1;
    if (paramFloat > 0.0F)
    {
      f1 = paramFloat;
      if (paramFloat <= 0.0F) {
        break label130;
      }
      String str = paramInt + "_scale_" + paramFloat;
      localPicture2 = (Picture)adoy.get(str);
      localPicture1 = localPicture2;
      if (localPicture2 == null)
      {
        localPicture1 = a(f2, a(paramResources, paramInt, paramString), f1);
        adoy.put(str, localPicture1);
      }
    }
    for (paramResources = new c(localPicture1, paramInt);; paramResources = new c(localPicture1, paramInt))
    {
      AppMethodBeat.o(148713);
      return paramResources;
      f1 = 1.0F;
      break;
      label130:
      localPicture2 = (Picture)adox.get(Integer.valueOf(paramInt));
      localPicture1 = localPicture2;
      if (localPicture2 == null)
      {
        localPicture1 = a(f2, a(paramResources, paramInt, paramString), f1);
        adox.put(Integer.valueOf(paramInt), localPicture1);
      }
    }
  }
  
  private static com.tencent.mm.svg.c a(Resources paramResources, int paramInt, String paramString)
  {
    AppMethodBeat.i(148714);
    String str = "";
    Object localObject1 = str;
    Object localObject2 = str;
    Object localObject3 = str;
    for (;;)
    {
      try
      {
        if (adow.containsKey(Integer.valueOf(paramInt)))
        {
          localObject1 = str;
          localObject2 = str;
          localObject3 = str;
          paramResources = (com.tencent.mm.svg.c)adow.get(Integer.valueOf(paramInt));
          AppMethodBeat.o(148714);
          return paramResources;
        }
        localObject1 = str;
        localObject2 = str;
        localObject3 = str;
        paramResources = paramResources.getResourceName(paramInt);
        if (paramResources == null)
        {
          localObject1 = str;
          localObject2 = str;
          localObject3 = str;
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : resource not found", new Object[0]);
          AppMethodBeat.o(148714);
          return null;
        }
        localObject1 = str;
        localObject2 = str;
        localObject3 = str;
        int i = paramResources.indexOf("/");
        if (i <= 0) {
          continue;
        }
        localObject1 = str;
        localObject2 = str;
        localObject3 = str;
        paramResources = paramString + "." + paramResources.substring(i + 1);
      }
      catch (ClassNotFoundException paramResources)
      {
        Log.printErrStackTrace("MicroMsg.SVGCompat", paramResources, "", new Object[0]);
        com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : ClassNotFoundException %s", new Object[] { localObject1 });
        AppMethodBeat.o(148714);
        return null;
        localObject1 = str;
        localObject2 = str;
        localObject3 = str;
        paramResources = paramString + "." + paramResources;
        continue;
      }
      catch (InstantiationException paramResources)
      {
        com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : InstantiationException %s", new Object[] { localObject2 });
        Log.printErrStackTrace("MicroMsg.SVGCompat", paramResources, "", new Object[0]);
        AppMethodBeat.o(148714);
        return null;
      }
      catch (IllegalAccessException paramResources)
      {
        com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : IllegalAccessException %s", new Object[] { localObject3 });
        Log.printErrStackTrace("MicroMsg.SVGCompat", paramResources, "", new Object[0]);
        AppMethodBeat.o(148714);
      }
      localObject1 = paramResources;
      localObject2 = paramResources;
      localObject3 = paramResources;
      paramString = (com.tencent.mm.svg.c)Class.forName(paramResources).newInstance();
      localObject1 = paramResources;
      localObject2 = paramResources;
      localObject3 = paramResources;
      adow.put(Integer.valueOf(paramInt), paramString);
      paramResources = paramString;
    }
    return null;
  }
  
  public static Bitmap b(Resources paramResources, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(148706);
    paramResources = a(paramResources, paramInt, paramFloat);
    if (paramResources == null)
    {
      AppMethodBeat.o(148706);
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramResources.getIntrinsicWidth(), paramResources.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    paramResources.draw(new Canvas(localBitmap));
    AppMethodBeat.o(148706);
    return localBitmap;
  }
  
  protected static boolean b(View paramView, Paint paramPaint)
  {
    AppMethodBeat.i(148708);
    if (Build.VERSION.SDK_INT > 10)
    {
      boolean bool = c(paramView, paramPaint);
      AppMethodBeat.o(148708);
      return bool;
    }
    AppMethodBeat.o(148708);
    return false;
  }
  
  private static Drawable c(Resources paramResources, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(148711);
    com.tencent.mm.svg.b.c.d("MicroMsg.SVGCompat", "Using wechat svg library.", new Object[0]);
    InputStream localInputStream = paramResources.openRawResource(paramInt);
    try
    {
      byte[] arrayOfByte = new byte[localInputStream.available()];
      localInputStream.read(arrayOfByte);
      if (localInputStream != null) {}
      long l;
      try
      {
        localInputStream.close();
        l = WeChatSVG.parse(EncodingUtils.getString(arrayOfByte, "UTF-8").toString());
        if (l == 0L)
        {
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Parse SVG failed.", new Object[0]);
          AppMethodBeat.o(148711);
          return null;
        }
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SVGCompat", localIOException1, "", new Object[0]);
        }
      }
      float[] arrayOfFloat;
      float f2;
      float f3;
      float f1;
      int i;
      label363:
      label368:
      return paramResources;
    }
    catch (IOException paramResources)
    {
      Log.printErrStackTrace("MicroMsg.SVGCompat", paramResources, "", new Object[0]);
      com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGPictureDrawable failed. Reason : IOException", new Object[0]);
      if (localIOException1 != null) {}
      try
      {
        localIOException1.close();
        AppMethodBeat.o(148711);
        return null;
      }
      catch (IOException paramResources)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SVGCompat", paramResources, "", new Object[0]);
        }
      }
    }
    finally
    {
      if (localIOException1 != null) {}
      try
      {
        localIOException1.close();
        AppMethodBeat.o(148711);
        throw paramResources;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SVGCompat", localIOException2, "", new Object[0]);
        }
      }
      arrayOfFloat = WeChatSVG.getViewPort(l);
      f2 = paramResources.getDisplayMetrics().density;
      f3 = arrayOfFloat[0] / adou;
      if (paramFloat > 0.0F)
      {
        f1 = paramFloat;
        f1 *= f3 * f2;
        f3 = arrayOfFloat[1] / adou;
        if (paramFloat <= 0.0F) {
          break label363;
        }
      }
      for (;;)
      {
        paramFloat = f3 * f2 * paramFloat;
        paramResources = new Picture();
        i = WeChatSVG.renderViewPort(l, paramResources.beginRecording((int)f1, (int)paramFloat), (int)f1, (int)paramFloat);
        paramResources.endRecording();
        WeChatSVG.release(l);
        paramResources = new c(paramResources, paramInt);
        if (i >= 0) {
          break label368;
        }
        com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Render SVG failed. Reason : %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(148711);
        return null;
        f1 = 1.0F;
        break;
        paramFloat = 1.0F;
      }
      AppMethodBeat.o(148711);
    }
  }
  
  private static boolean c(View paramView, Paint paramPaint)
  {
    AppMethodBeat.i(148709);
    if (paramView != null) {
      try
      {
        if (paramView.getLayerType() != 1) {
          paramView.setLayerType(1, paramPaint);
        }
        if (paramView.willNotCacheDrawing())
        {
          paramView.setWillNotCacheDrawing(false);
          if (paramView.getWindowToken() != null) {
            paramView.buildLayer();
          }
        }
        AppMethodBeat.o(148709);
        return true;
      }
      catch (NullPointerException paramPaint)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SVGCompat", paramPaint, "", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(148709);
    return false;
  }
  
  private static float dI(float paramFloat)
  {
    AppMethodBeat.i(148712);
    if (adoz == null) {
      adoz = Float.valueOf(paramFloat / adou);
    }
    paramFloat = adoz.floatValue();
    AppMethodBeat.o(148712);
    return paramFloat;
  }
  
  public static Drawable i(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(148702);
    paramResources = a(paramResources, paramInt, 0.0F);
    AppMethodBeat.o(148702);
    return paramResources;
  }
  
  public static Bitmap j(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(148705);
    paramResources = b(paramResources, paramInt, 0.0F);
    AppMethodBeat.o(148705);
    return paramResources;
  }
  
  private static String jek()
  {
    AppMethodBeat.i(148703);
    Object localObject = new Throwable().getStackTrace();
    if ((localObject == null) || (localObject.length < 4))
    {
      AppMethodBeat.o(148703);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 3;
    while (i < localObject.length)
    {
      if ((localObject[i].getClassName().contains("com.tencent.mm")) && (!localObject[i].getClassName().contains("sdk.platformtools.Log")))
      {
        localStringBuilder.append("[");
        localStringBuilder.append(localObject[i].getClassName().substring(15));
        localStringBuilder.append(":");
        localStringBuilder.append(localObject[i].getMethodName());
        localStringBuilder.append("(" + localObject[i].getLineNumber() + ")]");
      }
      i += 1;
    }
    localObject = localStringBuilder.toString();
    AppMethodBeat.o(148703);
    return localObject;
  }
  
  public static Map<Integer, com.tencent.mm.svg.c> jel()
  {
    return adow;
  }
  
  public static void setPackageName(String paramString)
  {
    adov = paramString;
  }
  
  /* Error */
  public final boolean k(Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 455
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: iload_2
    //   8: invokevirtual 458	android/content/res/Resources:getResourceTypeName	(I)Ljava/lang/String;
    //   11: astore_3
    //   12: aload_3
    //   13: ldc_w 460
    //   16: invokevirtual 463	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   19: ifeq +111 -> 130
    //   22: aload_0
    //   23: getfield 65	com/tencent/mm/svg/a/a:ados	[B
    //   26: astore 5
    //   28: aload 5
    //   30: monitorenter
    //   31: aload_0
    //   32: getfield 63	com/tencent/mm/svg/a/a:ador	Landroid/util/TypedValue;
    //   35: astore 4
    //   37: aload 4
    //   39: astore_3
    //   40: aload 4
    //   42: ifnonnull +16 -> 58
    //   45: new 60	android/util/TypedValue
    //   48: dup
    //   49: invokespecial 61	android/util/TypedValue:<init>	()V
    //   52: astore_3
    //   53: aload_0
    //   54: aload_3
    //   55: putfield 63	com/tencent/mm/svg/a/a:ador	Landroid/util/TypedValue;
    //   58: aload_1
    //   59: iload_2
    //   60: aload_3
    //   61: iconst_1
    //   62: invokevirtual 467	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   65: aload_3
    //   66: getfield 471	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   69: invokeinterface 474 1 0
    //   74: astore_1
    //   75: aload 5
    //   77: monitorexit
    //   78: aload_1
    //   79: ldc_w 476
    //   82: invokevirtual 480	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   85: ifeq +45 -> 130
    //   88: ldc_w 455
    //   91: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: iconst_1
    //   95: ireturn
    //   96: astore_1
    //   97: ldc 84
    //   99: aload_1
    //   100: ldc_w 482
    //   103: iconst_0
    //   104: anewarray 4	java/lang/Object
    //   107: invokestatic 483	com/tencent/mm/svg/b/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: ldc_w 455
    //   113: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: iconst_0
    //   117: ireturn
    //   118: astore_1
    //   119: aload 5
    //   121: monitorexit
    //   122: ldc_w 455
    //   125: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_1
    //   129: athrow
    //   130: ldc_w 455
    //   133: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: iconst_0
    //   137: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	a
    //   0	138	1	paramResources	Resources
    //   0	138	2	paramInt	int
    //   11	55	3	localObject	Object
    //   35	6	4	localTypedValue	TypedValue
    // Exception table:
    //   from	to	target	type
    //   6	12	96	android/content/res/Resources$NotFoundException
    //   31	37	118	finally
    //   45	58	118	finally
    //   58	78	118	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.svg.a.a
 * JD-Core Version:    0.7.0.1
 */