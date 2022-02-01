package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import java.io.InputStream;

public class BackwardSupportUtil$BitmapFactory
{
  private static final float HDPI_DENSITY = 1.5F;
  private static final float MDPI_DENSITY = 1.0F;
  
  public static Bitmap decodeFile(String paramString, float paramFloat)
  {
    AppMethodBeat.i(156062);
    paramString = BitmapUtil.getBitmapNative(paramString, paramFloat);
    if (paramString != null) {
      paramString.setDensity((int)(160.0F * paramFloat));
    }
    AppMethodBeat.o(156062);
    return paramString;
  }
  
  public static Bitmap decodeFileWithMemLimit(String paramString, int paramInt)
  {
    AppMethodBeat.i(215286);
    BitmapFactory.Options localOptions = BitmapUtil.getImageOptions(paramString);
    if ((localOptions == null) || (TextUtils.isEmpty(localOptions.outMimeType)))
    {
      Log.e("MicroMsg.SDK.BackwardSupportUtil", "[-] [tomys] Fail to get image size: %s", new Object[] { paramString });
      AppMethodBeat.o(215286);
      return null;
    }
    if ((localOptions.outWidth == 0) || (localOptions.outHeight == 0))
    {
      Log.w("MicroMsg.SDK.BackwardSupportUtil", "[!] [tomys] Bad image size: %s x %s, try to decode it directly.", new Object[] { Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) });
      paramString = BitmapUtil.getBitmapNative(paramString);
      AppMethodBeat.o(215286);
      return paramString;
    }
    localOptions.inJustDecodeBounds = false;
    localOptions.inSampleSize = 1;
    long l = localOptions.outWidth * localOptions.outHeight * 8;
    for (;;)
    {
      l = l / localOptions.inSampleSize / localOptions.inSampleSize;
      if (l <= 0L) {
        if (localOptions.inSampleSize > 1) {
          localOptions.inSampleSize -= 1;
        }
      }
      while (l <= paramInt)
      {
        paramString = MMBitmapFactory.decodeFile(paramString, localOptions);
        AppMethodBeat.o(215286);
        return paramString;
      }
      localOptions.inSampleSize += 1;
    }
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream)
  {
    AppMethodBeat.i(215287);
    paramInputStream = BitmapUtil.decodeStream(paramInputStream);
    AppMethodBeat.o(215287);
    return paramInputStream;
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, float paramFloat)
  {
    AppMethodBeat.i(156064);
    paramInputStream = decodeStream(paramInputStream, paramFloat, 0, 0);
    AppMethodBeat.o(156064);
    return paramInputStream;
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215288);
    paramInputStream = BitmapUtil.decodeStream(paramInputStream, paramFloat, paramInt1, paramInt2);
    if (paramInputStream != null) {
      paramInputStream.setDensity((int)(160.0F * paramFloat));
    }
    AppMethodBeat.o(215288);
    return paramInputStream;
  }
  
  public static int fromDPToPix(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(156063);
    int i = Math.round(paramContext.getResources().getDisplayMetrics().densityDpi * paramFloat / 160.0F);
    AppMethodBeat.o(156063);
    return i;
  }
  
  /* Error */
  public static Bitmap getBitmapFromURL(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 146
    //   4: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 61
    //   9: ldc 148
    //   11: aload_0
    //   12: invokestatic 153	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   15: invokevirtual 157	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 161	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: new 163	java/net/URL
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 166	java/net/URL:<init>	(Ljava/lang/String;)V
    //   29: invokevirtual 170	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   32: checkcast 172	java/net/HttpURLConnection
    //   35: astore_0
    //   36: aload_0
    //   37: iconst_1
    //   38: invokevirtual 176	java/net/HttpURLConnection:setDoInput	(Z)V
    //   41: aload_0
    //   42: invokevirtual 179	java/net/HttpURLConnection:connect	()V
    //   45: aload_0
    //   46: invokevirtual 183	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   49: astore_2
    //   50: aload_2
    //   51: invokestatic 107	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   54: astore_1
    //   55: aload_2
    //   56: invokevirtual 188	java/io/InputStream:close	()V
    //   59: aload_0
    //   60: ifnull +14 -> 74
    //   63: aload_0
    //   64: invokevirtual 183	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   67: invokevirtual 188	java/io/InputStream:close	()V
    //   70: aload_0
    //   71: invokevirtual 191	java/net/HttpURLConnection:disconnect	()V
    //   74: ldc 146
    //   76: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: aload_1
    //   80: areturn
    //   81: astore_2
    //   82: ldc 61
    //   84: aload_2
    //   85: invokevirtual 195	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   88: invokestatic 197	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: goto -21 -> 70
    //   94: astore_1
    //   95: aconst_null
    //   96: astore_0
    //   97: ldc 61
    //   99: ldc 199
    //   101: invokestatic 197	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: ldc 61
    //   106: aload_1
    //   107: ldc 201
    //   109: iconst_0
    //   110: anewarray 4	java/lang/Object
    //   113: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_0
    //   117: ifnull +14 -> 131
    //   120: aload_0
    //   121: invokevirtual 183	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   124: invokevirtual 188	java/io/InputStream:close	()V
    //   127: aload_0
    //   128: invokevirtual 191	java/net/HttpURLConnection:disconnect	()V
    //   131: ldc 146
    //   133: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aconst_null
    //   137: areturn
    //   138: astore_1
    //   139: ldc 61
    //   141: aload_1
    //   142: invokevirtual 195	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   145: invokestatic 197	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: goto -21 -> 127
    //   151: astore_0
    //   152: aload_1
    //   153: ifnull +14 -> 167
    //   156: aload_1
    //   157: invokevirtual 183	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   160: invokevirtual 188	java/io/InputStream:close	()V
    //   163: aload_1
    //   164: invokevirtual 191	java/net/HttpURLConnection:disconnect	()V
    //   167: ldc 146
    //   169: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aload_0
    //   173: athrow
    //   174: astore_2
    //   175: ldc 61
    //   177: aload_2
    //   178: invokevirtual 195	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   181: invokestatic 197	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: goto -21 -> 163
    //   187: astore_2
    //   188: aload_0
    //   189: astore_1
    //   190: aload_2
    //   191: astore_0
    //   192: goto -40 -> 152
    //   195: astore_1
    //   196: aload_0
    //   197: astore_2
    //   198: aload_1
    //   199: astore_0
    //   200: aload_2
    //   201: astore_1
    //   202: goto -50 -> 152
    //   205: astore_1
    //   206: goto -109 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramString	String
    //   1	79	1	localBitmap	Bitmap
    //   94	13	1	localIOException1	java.io.IOException
    //   138	26	1	localException1	java.lang.Exception
    //   189	1	1	str1	String
    //   195	4	1	localObject1	Object
    //   201	1	1	localObject2	Object
    //   205	1	1	localIOException2	java.io.IOException
    //   49	7	2	localInputStream	InputStream
    //   81	4	2	localException2	java.lang.Exception
    //   174	4	2	localException3	java.lang.Exception
    //   187	4	2	localObject3	Object
    //   197	4	2	str2	String
    // Exception table:
    //   from	to	target	type
    //   63	70	81	java/lang/Exception
    //   7	36	94	java/io/IOException
    //   120	127	138	java/lang/Exception
    //   7	36	151	finally
    //   156	163	174	java/lang/Exception
    //   36	59	187	finally
    //   97	116	195	finally
    //   36	59	205	java/io/IOException
  }
  
  public static String getDisplayDensityType(Context paramContext)
  {
    AppMethodBeat.i(156066);
    Object localObject = paramContext.getResources().getDisplayMetrics();
    Configuration localConfiguration = paramContext.getResources().getConfiguration();
    if (((DisplayMetrics)localObject).density < 1.0F)
    {
      paramContext = "" + "LDPI";
      localObject = new StringBuilder().append(paramContext);
      if (localConfiguration.orientation != 2) {
        break label148;
      }
    }
    label148:
    for (paramContext = "_L";; paramContext = "_P")
    {
      paramContext = paramContext;
      AppMethodBeat.o(156066);
      return paramContext;
      if (((DisplayMetrics)localObject).density >= 1.5F)
      {
        paramContext = "" + "HDPI";
        break;
      }
      paramContext = "" + "MDPI";
      break;
    }
  }
  
  public static String getDisplaySizeType(Context paramContext)
  {
    AppMethodBeat.i(175899);
    paramContext = paramContext.getResources().getDisplayMetrics();
    paramContext = paramContext.heightPixels + "x" + paramContext.widthPixels;
    AppMethodBeat.o(175899);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory
 * JD-Core Version:    0.7.0.1
 */