package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.vfs.y;
import java.io.InputStream;

public class BackwardSupportUtil
{
  public static final int ANDROID_API_LEVEL_16 = 16;
  private static final int ANDROID_API_LEVEL_8 = 8;
  private static final String TAG = "MicroMsg.SDK.BackwardSupportUtil";
  
  public static BackwardSupportUtil.ExifHelper.LatLongData getVideoLatLong(String paramString)
  {
    AppMethodBeat.i(156076);
    Object localObject = new d();
    try
    {
      ((MediaMetadataRetriever)localObject).setDataSource(paramString);
      paramString = ((MediaMetadataRetriever)localObject).extractMetadata(23);
      ((MediaMetadataRetriever)localObject).release();
      Log.i("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong locationString ".concat(String.valueOf(paramString)));
      if (TextUtils.isEmpty(paramString)) {
        break label227;
      }
      paramString = paramString.toCharArray();
      localObject = new StringBuilder();
      j = paramString.length;
      i = 0;
      while (i < j)
      {
        char c = paramString[i];
        if ((c == '+') || (c == '-') || (c == '.') || (TextUtils.isDigitsOnly(String.valueOf(c)))) {
          ((StringBuilder)localObject).append(c);
        }
        i += 1;
      }
      paramString = ((StringBuilder)localObject).toString();
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong setDataSource failure: " + paramString.getMessage());
      AppMethodBeat.o(156076);
      return null;
    }
    int j = paramString.lastIndexOf('+');
    int i = j;
    if (-1 == j) {
      i = paramString.lastIndexOf('-');
    }
    localObject = new BackwardSupportUtil.ExifHelper.LatLongData();
    ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).latitude = Util.safeParseFloat(paramString.substring(0, i));
    ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).longtitude = Util.safeParseFloat(paramString.substring(i));
    AppMethodBeat.o(156076);
    return localObject;
    label227:
    AppMethodBeat.o(156076);
    return null;
  }
  
  public static String getVideoTakeTime(String paramString)
  {
    AppMethodBeat.i(156077);
    d locald = new d();
    try
    {
      locald.setDataSource(paramString);
      paramString = locald.extractMetadata(5);
      locald.release();
      Log.i("MicroMsg.SDK.BackwardSupportUtil", "getVideoTakeTime timeString ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(156077);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong setDataSource failure: " + paramString.getMessage());
      AppMethodBeat.o(156077);
    }
    return null;
  }
  
  public static class BitmapFactory
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
      AppMethodBeat.i(243708);
      BitmapFactory.Options localOptions = BitmapUtil.getImageOptions(paramString);
      if ((localOptions == null) || (TextUtils.isEmpty(localOptions.outMimeType)))
      {
        Log.e("MicroMsg.SDK.BackwardSupportUtil", "[-] [tomys] Fail to get image size: %s", new Object[] { paramString });
        AppMethodBeat.o(243708);
        return null;
      }
      if ((localOptions.outWidth == 0) || (localOptions.outHeight == 0))
      {
        Log.w("MicroMsg.SDK.BackwardSupportUtil", "[!] [tomys] Bad image size: %s x %s, try to decode it directly.", new Object[] { Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) });
        paramString = BitmapUtil.getBitmapNative(paramString);
        AppMethodBeat.o(243708);
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
          AppMethodBeat.o(243708);
          return paramString;
        }
        localOptions.inSampleSize += 1;
      }
    }
    
    public static Bitmap decodeStream(InputStream paramInputStream)
    {
      AppMethodBeat.i(243714);
      paramInputStream = BitmapUtil.decodeStream(paramInputStream);
      AppMethodBeat.o(243714);
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
      AppMethodBeat.i(243720);
      paramInputStream = BitmapUtil.decodeStream(paramInputStream, paramFloat, paramInt1, paramInt2);
      if (paramInputStream != null) {
        paramInputStream.setDensity((int)(160.0F * paramFloat));
      }
      AppMethodBeat.o(243720);
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
      //   138	26	1	localException1	Exception
      //   189	1	1	str1	String
      //   195	4	1	localObject1	Object
      //   201	1	1	localObject2	Object
      //   205	1	1	localIOException2	java.io.IOException
      //   49	7	2	localInputStream	InputStream
      //   81	4	2	localException2	Exception
      //   174	4	2	localException3	Exception
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
  
  public static class ExifHelper
  {
    public static LatLongData getExifLatLong(String paramString)
    {
      AppMethodBeat.i(156072);
      if (Util.isNullOrNil(paramString))
      {
        Log.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
        AppMethodBeat.o(156072);
        return null;
      }
      if (!y.ZC(paramString))
      {
        Log.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", new Object[] { paramString });
        AppMethodBeat.o(156072);
        return null;
      }
      paramString = Exif.fromFile(paramString).getLocation();
      if (paramString != null)
      {
        LatLongData localLatLongData = new LatLongData();
        localLatLongData.latitude = ((float)paramString.latitude);
        localLatLongData.longtitude = ((float)paramString.longitude);
        AppMethodBeat.o(156072);
        return localLatLongData;
      }
      AppMethodBeat.o(156072);
      return null;
    }
    
    public static int getExifOrientation(String paramString)
    {
      AppMethodBeat.i(156071);
      if (Util.isNullOrNil(paramString))
      {
        Log.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
        AppMethodBeat.o(156071);
        return 0;
      }
      if (!y.ZC(paramString))
      {
        Log.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", new Object[] { paramString });
        AppMethodBeat.o(156071);
        return 0;
      }
      int i = Exif.fromFile(paramString).getOrientationInDegree();
      AppMethodBeat.o(156071);
      return i;
    }
    
    public static String getExifTime(String paramString)
    {
      AppMethodBeat.i(244173);
      if (Util.isNullOrNil(paramString))
      {
        Log.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
        AppMethodBeat.o(244173);
        return null;
      }
      if (!y.ZC(paramString))
      {
        Log.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", new Object[] { paramString });
        AppMethodBeat.o(244173);
        return null;
      }
      paramString = Exif.fromFile(paramString).dateTime;
      AppMethodBeat.o(244173);
      return paramString;
    }
    
    public static class LatLongData
      implements Parcelable
    {
      public static final Parcelable.Creator<LatLongData> CREATOR;
      private static final float PRECISION = 1.0E-006F;
      public float latitude;
      public float longtitude;
      
      static
      {
        AppMethodBeat.i(156070);
        CREATOR = new Parcelable.Creator()
        {
          public BackwardSupportUtil.ExifHelper.LatLongData createFromParcel(Parcel paramAnonymousParcel)
          {
            AppMethodBeat.i(244114);
            BackwardSupportUtil.ExifHelper.LatLongData localLatLongData = new BackwardSupportUtil.ExifHelper.LatLongData();
            localLatLongData.latitude = paramAnonymousParcel.readFloat();
            localLatLongData.longtitude = paramAnonymousParcel.readFloat();
            AppMethodBeat.o(244114);
            return localLatLongData;
          }
          
          public BackwardSupportUtil.ExifHelper.LatLongData[] newArray(int paramAnonymousInt)
          {
            return new BackwardSupportUtil.ExifHelper.LatLongData[paramAnonymousInt];
          }
        };
        AppMethodBeat.o(156070);
      }
      
      public LatLongData()
      {
        this.latitude = 0.0F;
        this.longtitude = 0.0F;
      }
      
      public LatLongData(float paramFloat1, float paramFloat2)
      {
        this.latitude = paramFloat1;
        this.longtitude = paramFloat2;
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public boolean equals(Object paramObject)
      {
        AppMethodBeat.i(156068);
        if (!(paramObject instanceof LatLongData))
        {
          AppMethodBeat.o(156068);
          return false;
        }
        paramObject = (LatLongData)paramObject;
        if ((Math.abs(this.latitude - paramObject.latitude) < 1.0E-006F) && (Math.abs(this.longtitude - paramObject.longtitude) < 1.0E-006F))
        {
          AppMethodBeat.o(156068);
          return true;
        }
        AppMethodBeat.o(156068);
        return false;
      }
      
      public int hashCode()
      {
        return (int)(this.latitude * 10000.0F) + (int)(this.longtitude * 10000.0F);
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(156069);
        paramParcel.writeFloat(this.latitude);
        paramParcel.writeFloat(this.longtitude);
        AppMethodBeat.o(156069);
      }
    }
  }
  
  public static class SmoothScrollFactory
  {
    public static void scrollTo(ListView paramListView, int paramInt)
    {
      AppMethodBeat.i(156074);
      if (paramListView == null)
      {
        AppMethodBeat.o(156074);
        return;
      }
      if (Build.VERSION.SDK_INT >= 8)
      {
        new SmoothScrollToPosition22().doScroll(paramListView, paramInt);
        AppMethodBeat.o(156074);
        return;
      }
      new SmoothScrollToPosition21below().doScroll(paramListView, paramInt);
      AppMethodBeat.o(156074);
    }
    
    public static void scrollToFromTop(ListView paramListView, int paramInt)
    {
      AppMethodBeat.i(156075);
      if (paramListView == null)
      {
        AppMethodBeat.o(156075);
        return;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        new SmoothScrollToPosition22().doScrollFromTop(paramListView, paramInt);
        AppMethodBeat.o(156075);
        return;
      }
      new SmoothScrollToPosition21below().doScrollFromTop(paramListView, paramInt);
      AppMethodBeat.o(156075);
    }
    
    public static void scrollToTop(ListView paramListView)
    {
      AppMethodBeat.i(156073);
      if (paramListView == null)
      {
        AppMethodBeat.o(156073);
        return;
      }
      if (Build.VERSION.SDK_INT >= 8)
      {
        new SmoothScrollToPosition22().doScroll(paramListView);
        AppMethodBeat.o(156073);
        return;
      }
      new SmoothScrollToPosition21below().doScroll(paramListView);
      AppMethodBeat.o(156073);
    }
    
    public static abstract interface IScroll
    {
      public abstract void doScroll(ListView paramListView);
      
      public abstract void doScroll(ListView paramListView, int paramInt);
      
      public abstract void doScrollFromTop(ListView paramListView, int paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil
 * JD-Core Version:    0.7.0.1
 */