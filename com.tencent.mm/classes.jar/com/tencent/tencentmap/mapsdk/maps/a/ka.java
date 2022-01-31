package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ao;
import com.tencent.tencentmap.mapsdk.a.cz;
import com.tencent.tencentmap.mapsdk.a.dr;
import com.tencent.tencentmap.mapsdk.a.u;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ka
{
  private static String A;
  private static String B;
  private static int C;
  private static String D;
  private static int E;
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static float e;
  public static int f;
  public static int g;
  public static int h;
  public static int i;
  public static boolean j;
  public static Bitmap k;
  public static final int l;
  public static String m;
  public static int n;
  public static int o;
  public static int p;
  public static int q;
  public static int r;
  public static int s;
  public static float t;
  public static ao u;
  private static String v;
  private static String w;
  private static String x;
  private static String y;
  private static String z;
  
  static
  {
    AppMethodBeat.i(148939);
    a = null;
    b = "TencentMapSDK";
    v = null;
    w = null;
    x = null;
    y = null;
    z = null;
    A = null;
    B = null;
    c = null;
    C = 0;
    D = null;
    d = "undefined";
    e = 1.0F;
    f = 2;
    g = 0;
    h = 0;
    i = 0;
    j = false;
    k = null;
    l = Color.argb(200, 0, 163, 255);
    m = "tencentmap/mapsdk_vector/mark_location_big.png";
    n = 2;
    o = 4000000;
    p = 53500000;
    q = 73670000;
    r = 135100000;
    E = 0;
    s = 160;
    t = 0.0F;
    u = null;
    AppMethodBeat.o(148939);
  }
  
  public static double a(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(148936);
    paramDouble1 = 6.698324247899813D * paramDouble1 / Math.cos(0.0174532925199433D * paramDouble2);
    AppMethodBeat.o(148936);
    return paramDouble1;
  }
  
  public static Bitmap a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(148929);
    Object localObject = null;
    try
    {
      paramContext = BitmapFactory.decodeResource(paramContext.getResources(), paramInt);
      AppMethodBeat.o(148929);
      return paramContext;
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  /* Error */
  public static final Bitmap a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 162
    //   4: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnull +15 -> 23
    //   11: aload_1
    //   12: invokevirtual 168	java/lang/String:trim	()Ljava/lang/String;
    //   15: invokevirtual 172	java/lang/String:length	()I
    //   18: istore_2
    //   19: iload_2
    //   20: ifne +10 -> 30
    //   23: ldc 162
    //   25: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: aload_1
    //   31: invokevirtual 168	java/lang/String:trim	()Ljava/lang/String;
    //   34: iconst_0
    //   35: invokevirtual 176	java/lang/String:charAt	(I)C
    //   38: bipush 47
    //   40: if_icmpeq +55 -> 95
    //   43: new 178	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   50: aload_0
    //   51: invokevirtual 185	android/content/Context:getFilesDir	()Ljava/io/File;
    //   54: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: ldc 191
    //   59: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_1
    //   63: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: astore_0
    //   70: new 199	java/io/FileInputStream
    //   73: dup
    //   74: aload_0
    //   75: invokespecial 202	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   78: astore_0
    //   79: aload_0
    //   80: invokestatic 206	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   83: astore_1
    //   84: aload_0
    //   85: invokevirtual 211	java/io/InputStream:close	()V
    //   88: ldc 162
    //   90: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_1
    //   94: areturn
    //   95: new 178	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   102: aload_0
    //   103: invokevirtual 185	android/content/Context:getFilesDir	()Ljava/io/File;
    //   106: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: aload_1
    //   110: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore_0
    //   117: goto -47 -> 70
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_0
    //   123: aload_3
    //   124: astore_1
    //   125: aload_0
    //   126: ifnull -38 -> 88
    //   129: aload_0
    //   130: invokevirtual 211	java/io/InputStream:close	()V
    //   133: aload_3
    //   134: astore_1
    //   135: goto -47 -> 88
    //   138: astore_0
    //   139: aload_3
    //   140: astore_1
    //   141: goto -53 -> 88
    //   144: astore_0
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 211	java/io/InputStream:close	()V
    //   155: ldc 162
    //   157: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_0
    //   161: athrow
    //   162: astore_0
    //   163: goto -75 -> 88
    //   166: astore_1
    //   167: goto -12 -> 155
    //   170: astore_1
    //   171: aload_0
    //   172: astore_3
    //   173: aload_1
    //   174: astore_0
    //   175: aload_3
    //   176: astore_1
    //   177: goto -30 -> 147
    //   180: astore_1
    //   181: goto -58 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramContext	Context
    //   0	184	1	paramString	String
    //   18	2	2	i1	int
    //   1	175	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   11	19	120	java/lang/Exception
    //   30	70	120	java/lang/Exception
    //   70	79	120	java/lang/Exception
    //   95	117	120	java/lang/Exception
    //   129	133	138	java/lang/Exception
    //   11	19	144	finally
    //   30	70	144	finally
    //   70	79	144	finally
    //   95	117	144	finally
    //   84	88	162	java/lang/Exception
    //   151	155	166	java/lang/Exception
    //   79	84	170	finally
    //   79	84	180	java/lang/Exception
  }
  
  public static final Bitmap a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(148926);
    Object localObject = null;
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      AppMethodBeat.o(148926);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      for (;;)
      {
        paramBitmap = localObject;
      }
    }
  }
  
  public static GeoPoint a(cz paramcz)
  {
    AppMethodBeat.i(148932);
    if (paramcz == null)
    {
      AppMethodBeat.o(148932);
      return null;
    }
    paramcz = new GeoPoint((int)(paramcz.a * 1000000.0D), (int)(paramcz.b * 1000000.0D));
    AppMethodBeat.o(148932);
    return paramcz;
  }
  
  public static cz a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(148934);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(148934);
      return null;
    }
    paramGeoPoint = new cz(paramGeoPoint.getLatitudeE6() / 1000000.0D, paramGeoPoint.getLongitudeE6() / 1000000.0D);
    AppMethodBeat.o(148934);
    return paramGeoPoint;
  }
  
  public static cz a(cz paramcz1, cz paramcz2)
  {
    AppMethodBeat.i(148938);
    paramcz1 = new cz(paramcz1.a * 2.0D - paramcz2.a, paramcz1.b * 2.0D - paramcz2.b);
    AppMethodBeat.o(148938);
    return paramcz1;
  }
  
  public static String a()
  {
    if (A == null) {
      return "";
    }
    return A;
  }
  
  public static String a(String paramString)
  {
    AppMethodBeat.i(148913);
    paramString = String.format("/fileupdate?sdkver=%s&pf=%s&fr=02001&imei=%s&appsuid=%s&nettp=%s&api_key=%s", new Object[] { "4.2.3", "androidsdk", a(), c, B, paramString });
    AppMethodBeat.o(148913);
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148912);
    if (!StringUtil.isEmpty(paramString1)) {}
    for (;;)
    {
      if (!StringUtil.isEmpty(paramString2)) {}
      for (;;)
      {
        StringBuilder localStringBuilder = new StringBuilder(256);
        localStringBuilder.append("key=").append(a).append("&pid=").append(c).append("&key2=").append(paramString1).append("&pid2=").append(paramString2).append("&hm=").append(D).append("&suid=").append(A).append("&os=").append(C).append("&psv=").append(y).append("&ver=4.2.3.3&dip=").append(z).append("&pf=androidsdk&nt=").append(B).append("&channel=1&output=json&uuid=unknown");
        paramString1 = localStringBuilder.toString();
        AppMethodBeat.o(148912);
        return paramString1;
        paramString2 = "";
      }
      paramString1 = "";
    }
  }
  
  public static List<GeoPoint> a(List<cz> paramList)
  {
    AppMethodBeat.i(148933);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(148933);
      return null;
    }
    int i2 = paramList.size();
    ArrayList localArrayList = new ArrayList(i2);
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = (cz)paramList.get(i1);
      if (localObject != null)
      {
        localObject = a((cz)localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      i1 += 1;
    }
    AppMethodBeat.o(148933);
    return localArrayList;
  }
  
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(148911);
    if (D == null) {}
    try
    {
      String str = Build.MODEL;
      D = str;
      str = d(str);
      D = str;
      D = URLEncoder.encode(str, "utf-8");
      label39:
      if (C == 0) {
        C = Build.VERSION.SDK_INT;
      }
      if (c == null) {}
      try
      {
        str = paramContext.getPackageName();
        c = str;
        str = d(str);
        c = str;
        c = URLEncoder.encode(str, "utf-8");
        label85:
        if (x == null) {}
        try
        {
          str = g(paramContext);
          x = str;
          str = d(str);
          x = str;
          x = URLEncoder.encode(str, "utf-8");
          label119:
          if (y == null) {}
          try
          {
            str = h(paramContext);
            y = str;
            str = d(str);
            y = str;
            y = URLEncoder.encode(str, "utf-8");
            label153:
            if (z == null) {}
            try
            {
              str = i(paramContext);
              z = str;
              str = d(str);
              z = str;
              z = URLEncoder.encode(str, "utf-8");
              label187:
              if (A == null) {}
              try
              {
                str = f(paramContext);
                A = str;
                str = d(str);
                A = str;
                A = URLEncoder.encode(str, "utf-8");
                label221:
                if (B == null) {}
                try
                {
                  str = dr.c(paramContext);
                  B = str;
                  str = d(str);
                  B = str;
                  B = URLEncoder.encode(str, "utf-8");
                  label255:
                  if (w == null) {}
                  try
                  {
                    str = e(paramContext);
                    w = str;
                    str = e(str);
                    w = str;
                    w = URLEncoder.encode(str, "utf-8");
                    label289:
                    if (v == null) {}
                    try
                    {
                      str = d(paramContext);
                      v = str;
                      str = d(str);
                      v = str;
                      v = URLEncoder.encode(str, "utf-8");
                      label323:
                      if (a == null) {}
                      try
                      {
                        str = c(paramContext);
                        a = str;
                        a = URLEncoder.encode(str, "utf-8");
                        label348:
                        if (e == 1.0F) {
                          e = 320.0F / paramContext.getResources().getDisplayMetrics().densityDpi;
                        }
                        t = paramContext.getResources().getDisplayMetrics().density;
                        j = u.a(paramContext).c("worldMapEnabled");
                        AppMethodBeat.o(148911);
                        return;
                      }
                      catch (Exception localException1)
                      {
                        break label348;
                      }
                    }
                    catch (Exception localException2)
                    {
                      break label323;
                    }
                  }
                  catch (Exception localException3)
                  {
                    break label289;
                  }
                }
                catch (Exception localException4)
                {
                  break label255;
                }
              }
              catch (Exception localException5)
              {
                break label221;
              }
            }
            catch (Exception localException6)
            {
              break label187;
            }
          }
          catch (Exception localException7)
          {
            break label153;
          }
        }
        catch (Exception localException8)
        {
          break label119;
        }
      }
      catch (Exception localException9)
      {
        break label85;
      }
    }
    catch (Exception localException10)
    {
      break label39;
    }
  }
  
  private static void a(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(148921);
    Object localObject = null;
    try
    {
      Field localField = paramDisplayMetrics.getClass().getField("densityDpi");
      localObject = localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label21;
    }
    catch (SecurityException localSecurityException)
    {
      label21:
      break label21;
    }
    if (localObject != null) {
      try
      {
        s = localObject.getInt(paramDisplayMetrics);
        c();
        AppMethodBeat.o(148921);
        return;
      }
      catch (IllegalArgumentException paramDisplayMetrics)
      {
        AppMethodBeat.o(148921);
        return;
      }
      catch (IllegalAccessException paramDisplayMetrics)
      {
        AppMethodBeat.o(148921);
        return;
      }
    }
    d();
    AppMethodBeat.o(148921);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean == true)
    {
      q = 73670000;
      r = 135100000;
      p = 53500000;
      o = 4000000;
      return;
    }
    q = -180000000;
    r = 180000000;
    p = 85000000;
    o = -85000000;
  }
  
  public static int b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148937);
    if (StringUtil.isEmpty(paramString2))
    {
      AppMethodBeat.o(148937);
      return 1;
    }
    if (StringUtil.isEmpty(paramString1))
    {
      AppMethodBeat.o(148937);
      return -1;
    }
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int i2 = paramString1.length;
    int i1 = i2;
    if (i2 > paramString2.length) {
      i1 = paramString2.length;
    }
    i2 = 0;
    while (i2 < i1)
    {
      if (Integer.valueOf(paramString2[i2]).intValue() < Integer.valueOf(paramString1[i2]).intValue())
      {
        AppMethodBeat.o(148937);
        return 1;
      }
      if (Integer.valueOf(paramString2[i2]).intValue() > Integer.valueOf(paramString1[i2]).intValue())
      {
        AppMethodBeat.o(148937);
        return -1;
      }
      i2 += 1;
    }
    if (paramString1.length > paramString2.length)
    {
      AppMethodBeat.o(148937);
      return 1;
    }
    if (paramString1.length == paramString2.length)
    {
      AppMethodBeat.o(148937);
      return 0;
    }
    AppMethodBeat.o(148937);
    return -1;
  }
  
  /* Error */
  public static final Bitmap b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc_w 446
    //   6: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 178	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   16: aload_0
    //   17: invokestatic 451	com/tencent/tencentmap/mapsdk/a/p:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/p;
    //   20: invokevirtual 453	com/tencent/tencentmap/mapsdk/a/p:e	()Ljava/lang/String;
    //   23: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 458	com/tencent/tencentmap/mapsdk/a/t:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: ifnonnull +52 -> 92
    //   43: aload_3
    //   44: astore 4
    //   46: aload_3
    //   47: astore 5
    //   49: aload_3
    //   50: astore 6
    //   52: invokestatic 461	com/tencent/tencentmap/mapsdk/a/r:a	()Ljava/lang/String;
    //   55: ifnull +93 -> 148
    //   58: aload_3
    //   59: astore 4
    //   61: aload_3
    //   62: astore 5
    //   64: aload_3
    //   65: astore 6
    //   67: aload_0
    //   68: new 178	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   75: invokestatic 461	com/tencent/tencentmap/mapsdk/a/r:a	()Ljava/lang/String;
    //   78: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_1
    //   82: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 464	com/tencent/tencentmap/mapsdk/a/r:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   91: astore_2
    //   92: aload_2
    //   93: astore_3
    //   94: aload_2
    //   95: ifnonnull +27 -> 122
    //   98: aload_2
    //   99: astore 4
    //   101: aload_2
    //   102: astore 5
    //   104: aload_2
    //   105: astore 6
    //   107: aload_0
    //   108: ldc_w 466
    //   111: aload_1
    //   112: invokestatic 469	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   115: invokevirtual 472	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   118: invokestatic 464	com/tencent/tencentmap/mapsdk/a/r:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   121: astore_3
    //   122: aload_3
    //   123: astore 4
    //   125: aload_3
    //   126: astore 5
    //   128: aload_3
    //   129: astore 6
    //   131: aload_3
    //   132: invokestatic 206	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   135: astore_0
    //   136: aload_3
    //   137: invokestatic 475	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   140: ldc_w 446
    //   143: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload_0
    //   147: areturn
    //   148: aload_3
    //   149: astore_2
    //   150: aload_3
    //   151: astore 4
    //   153: aload_3
    //   154: astore 5
    //   156: aload_3
    //   157: astore 6
    //   159: invokestatic 477	com/tencent/tencentmap/mapsdk/a/r:b	()Ljava/lang/String;
    //   162: ifnull -70 -> 92
    //   165: aload_3
    //   166: astore 4
    //   168: aload_3
    //   169: astore 5
    //   171: aload_3
    //   172: astore 6
    //   174: new 178	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   181: invokestatic 477	com/tencent/tencentmap/mapsdk/a/r:b	()Ljava/lang/String;
    //   184: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_1
    //   188: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 458	com/tencent/tencentmap/mapsdk/a/t:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   197: astore_2
    //   198: goto -106 -> 92
    //   201: astore_0
    //   202: aconst_null
    //   203: astore 6
    //   205: aload 6
    //   207: invokestatic 475	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   210: aload 7
    //   212: astore_0
    //   213: goto -73 -> 140
    //   216: astore_0
    //   217: aconst_null
    //   218: astore 5
    //   220: aload 5
    //   222: invokestatic 475	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   225: aload 7
    //   227: astore_0
    //   228: goto -88 -> 140
    //   231: astore_0
    //   232: aconst_null
    //   233: astore_1
    //   234: aload_1
    //   235: invokestatic 475	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   238: ldc_w 446
    //   241: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: aload_0
    //   245: athrow
    //   246: astore_0
    //   247: aload 4
    //   249: astore_1
    //   250: goto -16 -> 234
    //   253: astore_0
    //   254: goto -34 -> 220
    //   257: astore_0
    //   258: goto -53 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramContext	Context
    //   0	261	1	paramString	String
    //   38	160	2	localObject1	Object
    //   36	136	3	localObject2	Object
    //   44	204	4	localObject3	Object
    //   47	174	5	localObject4	Object
    //   50	156	6	localObject5	Object
    //   1	225	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   9	37	201	java/lang/Exception
    //   9	37	216	java/lang/OutOfMemoryError
    //   9	37	231	finally
    //   52	58	246	finally
    //   67	92	246	finally
    //   107	122	246	finally
    //   131	136	246	finally
    //   159	165	246	finally
    //   174	198	246	finally
    //   52	58	253	java/lang/OutOfMemoryError
    //   67	92	253	java/lang/OutOfMemoryError
    //   107	122	253	java/lang/OutOfMemoryError
    //   131	136	253	java/lang/OutOfMemoryError
    //   159	165	253	java/lang/OutOfMemoryError
    //   174	198	253	java/lang/OutOfMemoryError
    //   52	58	257	java/lang/Exception
    //   67	92	257	java/lang/Exception
    //   107	122	257	java/lang/Exception
    //   131	136	257	java/lang/Exception
    //   159	165	257	java/lang/Exception
    //   174	198	257	java/lang/Exception
  }
  
  public static Bitmap b(Bitmap paramBitmap)
  {
    AppMethodBeat.i(148930);
    Bitmap localBitmap = paramBitmap;
    int i1;
    int i2;
    if (paramBitmap != null)
    {
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      i1 = (int)(f1 / e);
      i2 = (int)(f2 / e);
    }
    try
    {
      localBitmap = Bitmap.createScaledBitmap(paramBitmap, i1, i2, true);
      AppMethodBeat.o(148930);
      return localBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      AppMethodBeat.o(148930);
    }
    return null;
  }
  
  public static final Bitmap b(String paramString)
  {
    AppMethodBeat.i(148927);
    Object localObject = null;
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      AppMethodBeat.o(148927);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        paramString = localObject;
      }
    }
  }
  
  public static String b()
  {
    if (B == null) {
      return "";
    }
    return B;
  }
  
  public static void b(Context paramContext)
  {
    AppMethodBeat.i(148924);
    if (paramContext == null)
    {
      AppMethodBeat.o(148924);
      return;
    }
    paramContext = paramContext.getResources().getDisplayMetrics();
    E = paramContext.widthPixels * paramContext.heightPixels;
    if (Build.VERSION.SDK_INT < 24)
    {
      a(paramContext);
      AppMethodBeat.o(148924);
      return;
    }
    b(paramContext);
    AppMethodBeat.o(148924);
  }
  
  private static void b(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(148922);
    s = paramDisplayMetrics.densityDpi;
    c();
    AppMethodBeat.o(148922);
  }
  
  /* Error */
  public static final Bitmap c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 506
    //   5: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokevirtual 510	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: astore_0
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual 515	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: astore_0
    //   19: aload_0
    //   20: invokestatic 206	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   23: astore_1
    //   24: aload_0
    //   25: invokestatic 475	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   28: ldc_w 506
    //   31: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_1
    //   35: areturn
    //   36: astore_0
    //   37: aconst_null
    //   38: astore_0
    //   39: aload_0
    //   40: invokestatic 475	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   43: ldc_w 506
    //   46: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aconst_null
    //   50: areturn
    //   51: astore_0
    //   52: aconst_null
    //   53: astore_0
    //   54: aload_0
    //   55: invokestatic 475	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   58: aload_2
    //   59: astore_1
    //   60: goto -32 -> 28
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_1
    //   66: aload_1
    //   67: invokestatic 475	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   70: ldc_w 506
    //   73: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: athrow
    //   78: astore_1
    //   79: aload_0
    //   80: astore_2
    //   81: aload_1
    //   82: astore_0
    //   83: aload_2
    //   84: astore_1
    //   85: goto -19 -> 66
    //   88: astore_1
    //   89: goto -35 -> 54
    //   92: astore_1
    //   93: goto -54 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramContext	Context
    //   0	96	1	paramString	String
    //   1	83	2	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   13	19	36	java/lang/Exception
    //   13	19	51	java/lang/OutOfMemoryError
    //   13	19	63	finally
    //   19	24	78	finally
    //   19	24	88	java/lang/OutOfMemoryError
    //   19	24	92	java/lang/Exception
  }
  
  private static String c(Context paramContext)
  {
    AppMethodBeat.i(148914);
    if (paramContext == null)
    {
      AppMethodBeat.o(148914);
      return "";
    }
    String str = paramContext.getPackageName();
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(str, 128);
      if (paramContext == null)
      {
        AppMethodBeat.o(148914);
        return "";
      }
      if (paramContext.metaData == null)
      {
        AppMethodBeat.o(148914);
        return "";
      }
      paramContext = paramContext.metaData.getString(b);
      AppMethodBeat.o(148914);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  public static String c(String paramString)
  {
    AppMethodBeat.i(148935);
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (!TextUtils.isEmpty(A))
    {
      localStringBuilder.append("&deviceid=");
      localStringBuilder.append(A);
    }
    if (!TextUtils.isEmpty(c))
    {
      localStringBuilder.append("&appid=");
      localStringBuilder.append(c);
    }
    if (!TextUtils.isEmpty("4.2.3"))
    {
      localStringBuilder.append("&sdkver=");
      localStringBuilder.append("4.2.3");
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localStringBuilder.append("&ui=");
      localStringBuilder.append(paramString);
    }
    if (!TextUtils.isEmpty(d)) {
      localStringBuilder.append("&appsuid=");
    }
    try
    {
      localStringBuilder.append(URLEncoder.encode(d, "UTF-8"));
      localStringBuilder.append("&api_key=" + a);
      paramString = localStringBuilder.toString();
      AppMethodBeat.o(148935);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        localStringBuilder.append(e(d));
      }
    }
  }
  
  private static void c()
  {
    AppMethodBeat.i(148923);
    if (s <= 120)
    {
      n = 1;
      AppMethodBeat.o(148923);
      return;
    }
    if (s <= 160)
    {
      n = 2;
      AppMethodBeat.o(148923);
      return;
    }
    if (s <= 240)
    {
      n = 3;
      AppMethodBeat.o(148923);
      return;
    }
    d();
    AppMethodBeat.o(148923);
  }
  
  private static String d(Context paramContext)
  {
    AppMethodBeat.i(148915);
    if (paramContext == null)
    {
      AppMethodBeat.o(148915);
      return "";
    }
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null)
    {
      AppMethodBeat.o(148915);
      return "";
    }
    String str = paramContext.getSubscriberId();
    paramContext = str;
    if (str == null) {
      paramContext = "";
    }
    AppMethodBeat.o(148915);
    return paramContext;
  }
  
  private static String d(String paramString)
  {
    AppMethodBeat.i(148909);
    if (paramString == null)
    {
      AppMethodBeat.o(148909);
      return "";
    }
    paramString = paramString.replace("&", "").replace("#", "").replace("?", "");
    AppMethodBeat.o(148909);
    return paramString;
  }
  
  private static void d()
  {
    if (E > 153600)
    {
      n = 3;
      return;
    }
    if (E < 153600)
    {
      n = 1;
      return;
    }
    n = 2;
  }
  
  private static String e(Context paramContext)
  {
    AppMethodBeat.i(148916);
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext == null)
    {
      AppMethodBeat.o(148916);
      return "";
    }
    paramContext = paramContext.getConnectionInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(148916);
      return "";
    }
    String str = paramContext.getMacAddress();
    paramContext = str;
    if (str == null) {
      paramContext = "";
    }
    AppMethodBeat.o(148916);
    return paramContext;
  }
  
  private static String e(String paramString)
  {
    AppMethodBeat.i(148910);
    paramString = Pattern.compile("[^a-zA-Z0-9]").matcher(paramString).replaceAll("").trim();
    AppMethodBeat.o(148910);
    return paramString;
  }
  
  private static String f(Context paramContext)
  {
    AppMethodBeat.i(148917);
    if (paramContext == null)
    {
      AppMethodBeat.o(148917);
      return "";
    }
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null)
    {
      AppMethodBeat.o(148917);
      return "";
    }
    String str = paramContext.getDeviceId();
    paramContext = str;
    if (str == null) {
      paramContext = "";
    }
    AppMethodBeat.o(148917);
    return paramContext;
  }
  
  private static String g(Context paramContext)
  {
    AppMethodBeat.i(148918);
    if (paramContext == null)
    {
      AppMethodBeat.o(148918);
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject = null;
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        paramContext = paramContext.loadLabel(localPackageManager);
        try
        {
          paramContext = URLEncoder.encode(paramContext.toString(), "utf-8");
          AppMethodBeat.o(148918);
          return paramContext;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext = "";
          }
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
        continue;
        paramContext = "can't find app name";
      }
    }
  }
  
  private static String h(Context paramContext)
  {
    AppMethodBeat.i(148919);
    if (paramContext == null)
    {
      AppMethodBeat.o(148919);
      return "";
    }
    String str1 = "";
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      String str2 = paramContext.versionName;
      int i1 = paramContext.versionCode;
      paramContext = str2 + Integer.toString(i1);
      AppMethodBeat.o(148919);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = str1;
      }
    }
  }
  
  private static String i(Context paramContext)
  {
    AppMethodBeat.i(148920);
    if (paramContext == null)
    {
      AppMethodBeat.o(148920);
      return "";
    }
    String str = "";
    try
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      paramContext = Integer.toString(paramContext.widthPixels) + "*" + Integer.toString(paramContext.heightPixels);
      AppMethodBeat.o(148920);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ka
 * JD-Core Version:    0.7.0.1
 */