package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
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
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lq
{
  private static String A = null;
  private static String B = null;
  private static int C = 0;
  private static String D = null;
  public static String a = null;
  public static String b = "TencentMapSDK";
  public static String c = "undefined";
  public static float d = 1.0F;
  public static int e = 2;
  public static int f = 0;
  public static int g = 0;
  public static int h = 0;
  public static boolean i = false;
  public static Bitmap j = null;
  public static final int k = Color.argb(200, 0, 163, 255);
  public static String l = "tencentmap/mapsdk_vector/mark_location_big.png";
  public static int m = 2;
  public static int n = 4000000;
  public static int o = 53500000;
  public static int p = 73670000;
  public static int q = 135100000;
  public static int r = 160;
  public static float s = 0.0F;
  public static nu t = null;
  private static String u = null;
  private static String v = null;
  private static String w = null;
  private static String x = null;
  private static String y = null;
  private static String z = null;
  
  public static double a(double paramDouble1, double paramDouble2)
  {
    return 6.698324247899813D * paramDouble1 / Math.cos(0.0174532925199433D * paramDouble2);
  }
  
  public static Bitmap a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = BitmapFactory.decodeResource(paramContext.getResources(), paramInt);
      return paramContext;
    }
    catch (OutOfMemoryError paramContext) {}
    return null;
  }
  
  /* Error */
  public static final Bitmap a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +150 -> 151
    //   4: aload_1
    //   5: invokevirtual 154	java/lang/String:trim	()Ljava/lang/String;
    //   8: invokevirtual 158	java/lang/String:length	()I
    //   11: ifne +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_1
    //   17: invokevirtual 154	java/lang/String:trim	()Ljava/lang/String;
    //   20: iconst_0
    //   21: invokevirtual 162	java/lang/String:charAt	(I)C
    //   24: bipush 47
    //   26: if_icmpeq +53 -> 79
    //   29: new 164	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   36: aload_0
    //   37: invokevirtual 171	android/content/Context:getFilesDir	()Ljava/io/File;
    //   40: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: ldc 177
    //   45: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore_0
    //   56: new 185	java/io/FileInputStream
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 188	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   64: astore_0
    //   65: aload_0
    //   66: invokestatic 192	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   69: astore_1
    //   70: aload_0
    //   71: invokevirtual 197	java/io/InputStream:close	()V
    //   74: aload_1
    //   75: areturn
    //   76: astore_0
    //   77: aload_1
    //   78: areturn
    //   79: new 164	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   86: aload_0
    //   87: invokevirtual 171	android/content/Context:getFilesDir	()Ljava/io/File;
    //   90: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore_0
    //   101: goto -45 -> 56
    //   104: astore_0
    //   105: aconst_null
    //   106: astore_0
    //   107: aload_0
    //   108: ifnull +43 -> 151
    //   111: aload_0
    //   112: invokevirtual 197	java/io/InputStream:close	()V
    //   115: aconst_null
    //   116: areturn
    //   117: astore_0
    //   118: aconst_null
    //   119: areturn
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 197	java/io/InputStream:close	()V
    //   131: aload_0
    //   132: athrow
    //   133: astore_1
    //   134: goto -3 -> 131
    //   137: astore_1
    //   138: aload_0
    //   139: astore_2
    //   140: aload_1
    //   141: astore_0
    //   142: aload_2
    //   143: astore_1
    //   144: goto -21 -> 123
    //   147: astore_1
    //   148: goto -41 -> 107
    //   151: aconst_null
    //   152: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramContext	Context
    //   0	153	1	paramString	String
    //   139	4	2	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   70	74	76	java/lang/Exception
    //   4	14	104	java/lang/Exception
    //   16	56	104	java/lang/Exception
    //   56	65	104	java/lang/Exception
    //   79	101	104	java/lang/Exception
    //   111	115	117	java/lang/Exception
    //   4	14	120	finally
    //   16	56	120	finally
    //   56	65	120	finally
    //   79	101	120	finally
    //   127	131	133	java/lang/Exception
    //   65	70	137	finally
    //   65	70	147	java/lang/Exception
  }
  
  public static final Bitmap a(Bitmap paramBitmap)
  {
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public static GeoPoint a(qc paramqc)
  {
    if (paramqc == null) {
      return null;
    }
    return new GeoPoint((int)(paramqc.a * 1000000.0D), (int)(paramqc.b * 1000000.0D));
  }
  
  public static qc a(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {
      return null;
    }
    return new qc(paramGeoPoint.getLatitudeE6() / 1000000.0D, paramGeoPoint.getLongitudeE6() / 1000000.0D);
  }
  
  public static qc a(qc paramqc1, qc paramqc2)
  {
    return new qc(paramqc1.a * 2.0D - paramqc2.a, paramqc1.b * 2.0D - paramqc2.b);
  }
  
  public static String a()
  {
    if (z == null) {
      return "";
    }
    return z;
  }
  
  public static String a(int paramInt)
  {
    return String.format("key=%s&appid=sdk&logid=ditu&ver=%s&suid=%s&pf=%s&hm=%s&os=%s&nt=%s&dpi=%s&scrn=%s&pname=%s&pid=%s&psv=%s&wtc=%s", new Object[] { a, "4.1.1.2", z, "androidsdk", D, Integer.toString(C), A, Integer.toString(r), y, w, B, x, Integer.toString(paramInt) });
  }
  
  public static String a(String paramString)
  {
    return String.format("/fileupdate?sdkver=%s&pf=%s&fr=02001&imei=%s&appsuid=%s&nettp=%s&api_key=%s", new Object[] { "4.1.1", "androidsdk", a(), B, A, paramString });
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (!StringUtil.isEmpty(paramString1)) {}
    for (;;)
    {
      if (!StringUtil.isEmpty(paramString2)) {}
      for (;;)
      {
        return String.format("https://apikey.map.qq.com/mkey/index.php/mkey/check?key=%s&pid=%s&key2=%s&pid2=%s&channel=1&output=json&uuid=unknown&hm=%s&suid=%s&os=%s&psv=%s&ver=%s&dpi=%s&pf=%s&nt=%s", new Object[] { a, B, paramString1, paramString2, D, z, Integer.valueOf(C), x, "4.1.1.2", y, "androidsdk", A });
        paramString2 = "";
      }
      paramString1 = "";
    }
  }
  
  public static List<qc> a(List<GeoPoint> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((GeoPoint)paramList.next()));
    }
    return localArrayList;
  }
  
  public static void a(Context paramContext)
  {
    if (D == null) {}
    try
    {
      String str = Build.MODEL;
      D = str;
      str = d(str);
      D = str;
      D = URLEncoder.encode(str, "utf-8");
      label33:
      if (C == 0) {
        C = Build.VERSION.SDK_INT;
      }
      if (B == null) {}
      try
      {
        str = paramContext.getPackageName();
        B = str;
        str = d(str);
        B = str;
        B = URLEncoder.encode(str, "utf-8");
        label79:
        if (w == null) {}
        try
        {
          str = g(paramContext);
          w = str;
          str = d(str);
          w = str;
          w = URLEncoder.encode(str, "utf-8");
          label113:
          if (x == null) {}
          try
          {
            str = h(paramContext);
            x = str;
            str = d(str);
            x = str;
            x = URLEncoder.encode(str, "utf-8");
            label147:
            if (y == null) {}
            try
            {
              str = i(paramContext);
              y = str;
              str = d(str);
              y = str;
              y = URLEncoder.encode(str, "utf-8");
              label181:
              if (z == null) {}
              try
              {
                str = f(paramContext);
                z = str;
                str = d(str);
                z = str;
                z = URLEncoder.encode(str, "utf-8");
                label215:
                if (A == null) {}
                try
                {
                  str = qu.c(paramContext);
                  A = str;
                  str = d(str);
                  A = str;
                  A = URLEncoder.encode(str, "utf-8");
                  label249:
                  if (v == null) {}
                  try
                  {
                    str = e(paramContext);
                    v = str;
                    str = e(str);
                    v = str;
                    v = URLEncoder.encode(str, "utf-8");
                    label283:
                    if (u == null) {}
                    try
                    {
                      str = d(paramContext);
                      u = str;
                      str = d(str);
                      u = str;
                      u = URLEncoder.encode(str, "utf-8");
                      label317:
                      if (a == null) {}
                      try
                      {
                        str = c(paramContext);
                        a = str;
                        a = URLEncoder.encode(str, "utf-8");
                        label342:
                        if (d == 1.0F) {
                          d = 320.0F / paramContext.getResources().getDisplayMetrics().densityDpi;
                        }
                        s = paramContext.getResources().getDisplayMetrics().density;
                        i = w.a(paramContext).c("worldMapEnabled");
                        return;
                      }
                      catch (Exception localException1)
                      {
                        break label342;
                      }
                    }
                    catch (Exception localException2)
                    {
                      break label317;
                    }
                  }
                  catch (Exception localException3)
                  {
                    break label283;
                  }
                }
                catch (Exception localException4)
                {
                  break label249;
                }
              }
              catch (Exception localException5)
              {
                break label215;
              }
            }
            catch (Exception localException6)
            {
              break label181;
            }
          }
          catch (Exception localException7)
          {
            break label147;
          }
        }
        catch (Exception localException8)
        {
          break label113;
        }
      }
      catch (Exception localException9)
      {
        break label79;
      }
    }
    catch (Exception localException10)
    {
      break label33;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean == true)
    {
      p = 73670000;
      q = 135100000;
      o = 53500000;
      n = 4000000;
      return;
    }
    p = -180000000;
    q = 180000000;
    o = 85000000;
    n = -85000000;
  }
  
  public static int b(String paramString1, String paramString2)
  {
    if (StringUtil.isEmpty(paramString2)) {
      return 1;
    }
    if (StringUtil.isEmpty(paramString1)) {
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
      if (Integer.valueOf(paramString2[i2]).intValue() < Integer.valueOf(paramString1[i2]).intValue()) {
        return 1;
      }
      if (Integer.valueOf(paramString2[i2]).intValue() > Integer.valueOf(paramString1[i2]).intValue()) {
        return -1;
      }
      i2 += 1;
    }
    if (paramString1.length > paramString2.length) {
      return 1;
    }
    if (paramString1.length == paramString2.length) {
      return 0;
    }
    return -1;
  }
  
  /* Error */
  public static final Bitmap b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 164	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: invokestatic 392	com/tencent/tencentmap/mapsdk/a/r:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/r;
    //   11: invokevirtual 394	com/tencent/tencentmap/mapsdk/a/r:i	()Ljava/lang/String;
    //   14: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 399	com/tencent/tencentmap/mapsdk/a/v:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   27: astore_3
    //   28: aload_3
    //   29: astore_2
    //   30: aload_3
    //   31: ifnonnull +52 -> 83
    //   34: aload_3
    //   35: astore 4
    //   37: aload_3
    //   38: astore 5
    //   40: aload_3
    //   41: astore 6
    //   43: invokestatic 402	com/tencent/tencentmap/mapsdk/a/t:a	()Ljava/lang/String;
    //   46: ifnull +94 -> 140
    //   49: aload_3
    //   50: astore 4
    //   52: aload_3
    //   53: astore 5
    //   55: aload_3
    //   56: astore 6
    //   58: aload_0
    //   59: new 164	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   66: invokestatic 402	com/tencent/tencentmap/mapsdk/a/t:a	()Ljava/lang/String;
    //   69: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_1
    //   73: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 405	com/tencent/tencentmap/mapsdk/a/t:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   82: astore_2
    //   83: aload_2
    //   84: astore_3
    //   85: aload_2
    //   86: ifnonnull +34 -> 120
    //   89: aload_2
    //   90: astore 4
    //   92: aload_2
    //   93: astore 5
    //   95: aload_2
    //   96: astore 6
    //   98: aload_0
    //   99: new 164	java/lang/StringBuilder
    //   102: dup
    //   103: ldc_w 407
    //   106: invokespecial 408	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   109: aload_1
    //   110: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 405	com/tencent/tencentmap/mapsdk/a/t:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   119: astore_3
    //   120: aload_3
    //   121: astore 4
    //   123: aload_3
    //   124: astore 5
    //   126: aload_3
    //   127: astore 6
    //   129: aload_3
    //   130: invokestatic 192	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   133: astore_0
    //   134: aload_3
    //   135: invokestatic 411	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   138: aload_0
    //   139: areturn
    //   140: aload_3
    //   141: astore_2
    //   142: aload_3
    //   143: astore 4
    //   145: aload_3
    //   146: astore 5
    //   148: aload_3
    //   149: astore 6
    //   151: invokestatic 413	com/tencent/tencentmap/mapsdk/a/t:b	()Ljava/lang/String;
    //   154: ifnull -71 -> 83
    //   157: aload_3
    //   158: astore 4
    //   160: aload_3
    //   161: astore 5
    //   163: aload_3
    //   164: astore 6
    //   166: new 164	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   173: invokestatic 413	com/tencent/tencentmap/mapsdk/a/t:b	()Ljava/lang/String;
    //   176: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_1
    //   180: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 399	com/tencent/tencentmap/mapsdk/a/v:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   189: astore_2
    //   190: goto -107 -> 83
    //   193: astore_0
    //   194: aconst_null
    //   195: astore 6
    //   197: aload 6
    //   199: invokestatic 411	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   202: aconst_null
    //   203: areturn
    //   204: astore_0
    //   205: aconst_null
    //   206: astore 5
    //   208: aload 5
    //   210: invokestatic 411	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   213: aconst_null
    //   214: areturn
    //   215: astore_0
    //   216: aconst_null
    //   217: astore_1
    //   218: aload_1
    //   219: invokestatic 411	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   222: aload_0
    //   223: athrow
    //   224: astore_0
    //   225: aload 4
    //   227: astore_1
    //   228: goto -10 -> 218
    //   231: astore_0
    //   232: goto -24 -> 208
    //   235: astore_0
    //   236: goto -39 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	paramContext	Context
    //   0	239	1	paramString	String
    //   29	161	2	localObject1	Object
    //   27	137	3	localObject2	Object
    //   35	191	4	localObject3	Object
    //   38	171	5	localObject4	Object
    //   41	157	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   0	28	193	java/lang/Exception
    //   0	28	204	java/lang/OutOfMemoryError
    //   0	28	215	finally
    //   43	49	224	finally
    //   58	83	224	finally
    //   98	120	224	finally
    //   129	134	224	finally
    //   151	157	224	finally
    //   166	190	224	finally
    //   43	49	231	java/lang/OutOfMemoryError
    //   58	83	231	java/lang/OutOfMemoryError
    //   98	120	231	java/lang/OutOfMemoryError
    //   129	134	231	java/lang/OutOfMemoryError
    //   151	157	231	java/lang/OutOfMemoryError
    //   166	190	231	java/lang/OutOfMemoryError
    //   43	49	235	java/lang/Exception
    //   58	83	235	java/lang/Exception
    //   98	120	235	java/lang/Exception
    //   129	134	235	java/lang/Exception
    //   151	157	235	java/lang/Exception
    //   166	190	235	java/lang/Exception
  }
  
  public static Bitmap b(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    int i1;
    int i2;
    if (paramBitmap != null)
    {
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      i1 = (int)(f1 / d);
      i2 = (int)(f2 / d);
    }
    try
    {
      localBitmap = Bitmap.createScaledBitmap(paramBitmap, i1, i2, true);
      return localBitmap;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public static final Bitmap b(String paramString)
  {
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return null;
  }
  
  public static String b()
  {
    if (A == null) {
      return "";
    }
    return A;
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    paramContext = null;
    try
    {
      Field localField = localDisplayMetrics.getClass().getField("densityDpi");
      paramContext = localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      long l1;
      break label30;
    }
    catch (SecurityException localSecurityException)
    {
      label30:
      break label30;
    }
    if (paramContext != null) {
      l1 = localDisplayMetrics.widthPixels * localDisplayMetrics.heightPixels;
    }
    try
    {
      r = paramContext.getInt(localDisplayMetrics);
      label56:
      if (r <= 120)
      {
        m = 1;
        return;
      }
      if (r > 160)
      {
        if (r <= 240)
        {
          m = 3;
          return;
        }
        if (l1 > 153600L)
        {
          m = 3;
          return;
        }
        if (l1 < 153600L)
        {
          m = 1;
          return;
        }
      }
      m = 2;
      return;
      l1 = localDisplayMetrics.widthPixels * localDisplayMetrics.heightPixels;
      if (l1 > 153600L)
      {
        m = 3;
        return;
      }
      if (l1 < 153600L)
      {
        m = 1;
        return;
      }
      m = 2;
      return;
    }
    catch (IllegalAccessException paramContext)
    {
      break label56;
    }
    catch (IllegalArgumentException paramContext)
    {
      break label56;
    }
  }
  
  public static final Bitmap c(Context paramContext, String paramString)
  {
    paramContext = paramContext.getAssets();
    try
    {
      paramString = paramContext.open(paramString);
      paramContext = BitmapFactory.decodeStream(paramString);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      try
      {
        paramString.close();
        return paramContext;
      }
      catch (OutOfMemoryError paramString) {}
      paramContext = paramContext;
      return null;
    }
    catch (OutOfMemoryError paramContext)
    {
      return null;
    }
  }
  
  private static String c(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    String str = paramContext.getPackageName();
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(str, 128);
      if (paramContext == null) {
        return "";
      }
      if (paramContext.metaData == null) {
        return "";
      }
      return paramContext.metaData.getString(b);
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
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (!TextUtils.isEmpty(z))
    {
      localStringBuilder.append("&deviceid=");
      localStringBuilder.append(z);
    }
    if (!TextUtils.isEmpty(B))
    {
      localStringBuilder.append("&appid=");
      localStringBuilder.append(B);
    }
    if (!TextUtils.isEmpty("4.1.1"))
    {
      localStringBuilder.append("&sdkver=");
      localStringBuilder.append("4.1.1");
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localStringBuilder.append("&ui=");
      localStringBuilder.append(paramString);
    }
    if (!TextUtils.isEmpty(c)) {
      localStringBuilder.append("&appsuid=");
    }
    try
    {
      localStringBuilder.append(URLEncoder.encode(c, "UTF-8"));
      localStringBuilder.append("&api_key=" + a);
      return localStringBuilder.toString();
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        localStringBuilder.append(e(c));
      }
    }
  }
  
  private static String d(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = "";
    }
    String str;
    do
    {
      return paramContext;
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        return "";
      }
      str = paramContext.getSubscriberId();
      paramContext = str;
    } while (str != null);
    return "";
  }
  
  private static String d(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replace("&", "").replace("#", "").replace("?", "");
  }
  
  private static String e(Context paramContext)
  {
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext == null) {
      paramContext = "";
    }
    String str;
    do
    {
      return paramContext;
      paramContext = paramContext.getConnectionInfo();
      if (paramContext == null) {
        return "";
      }
      str = paramContext.getMacAddress();
      paramContext = str;
    } while (str != null);
    return "";
  }
  
  private static String e(String paramString)
  {
    return Pattern.compile("[^a-zA-Z0-9]").matcher(paramString).replaceAll("").trim();
  }
  
  private static String f(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = "";
    }
    String str;
    do
    {
      return paramContext;
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        return "";
      }
      str = paramContext.getDeviceId();
      paramContext = str;
    } while (str != null);
    return "";
  }
  
  private static String g(Context paramContext)
  {
    if (paramContext == null) {
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
          return paramContext;
        }
        catch (Exception paramContext)
        {
          return "";
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
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      String str = paramContext.versionName;
      int i1 = paramContext.versionCode;
      paramContext = str + Integer.toString(i1);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private static String i(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      paramContext = Integer.toString(paramContext.widthPixels) + "*" + Integer.toString(paramContext.heightPixels);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.lq
 * JD-Core Version:    0.7.0.1
 */