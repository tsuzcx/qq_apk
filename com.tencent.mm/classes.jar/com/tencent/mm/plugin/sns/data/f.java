package com.tencent.mm.plugin.sns.data;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.io.File;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

public final class f
{
  private static long ba(Context paramContext, String paramString)
  {
    AppMethodBeat.i(95074);
    try
    {
      long l = paramContext.getPackageManager().getPackageInfo(paramString, 0).firstInstallTime;
      AppMethodBeat.o(95074);
      return l;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(95074);
    }
    return -1L;
  }
  
  private static long bb(Context paramContext, String paramString)
  {
    AppMethodBeat.i(95075);
    try
    {
      long l = paramContext.getPackageManager().getPackageInfo(paramString, 0).lastUpdateTime;
      AppMethodBeat.o(95075);
      return l;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(95075);
    }
    return -1L;
  }
  
  public static String drW()
  {
    AppMethodBeat.i(95068);
    try
    {
      long l1 = System.currentTimeMillis();
      Object localObject = aj.getContext();
      String str1 = Build.VERSION.RELEASE;
      Pair localPair = fS((Context)localObject);
      String str2 = drY();
      String str3 = fT((Context)localObject);
      String str4 = drX();
      String str5 = Locale.getDefault().getLanguage();
      String str6 = ((Context)localObject).getApplicationContext().getResources().getConfiguration().locale.getCountry();
      String str7 = getTimeZone();
      String str8 = ba((Context)localObject, "com.tencent.mm");
      localObject = bb((Context)localObject, "com.tencent.mm");
      String str9 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sys_version", str1);
      localJSONObject.put("language", str5);
      localJSONObject.put("country_code", str6);
      localJSONObject.put("time_zone", str7);
      localJSONObject.put("scree_size", localPair.first + "_" + localPair.second);
      localJSONObject.put("kernel_version", str2);
      localJSONObject.put("memory_size", str3);
      localJSONObject.put("disk_size", str4);
      localJSONObject.put("mm_install_time", str8);
      localJSONObject.put("mm_update_time", localObject);
      localJSONObject.put("sys_boot_time", str9);
      localJSONObject.put("imei", q.WT());
      long l2 = System.currentTimeMillis();
      ad.i("QADIDInfoHelper", "timeCost=" + (l2 - l1) + ", ret=" + localJSONObject.toString());
      str1 = localJSONObject.toString();
      AppMethodBeat.o(95068);
      return str1;
    }
    catch (Throwable localThrowable)
    {
      ad.e("QADIDInfoHelper", "getDeviceInfoJson exp=" + localThrowable.toString());
      AppMethodBeat.o(95068);
    }
    return "";
  }
  
  private static long drX()
  {
    AppMethodBeat.i(95072);
    for (long l1 = 0L;; l1 = i * l2)
    {
      try
      {
        localStatFs = new StatFs(Environment.getDataDirectory().getPath());
        if (Build.VERSION.SDK_INT < 18) {
          break label55;
        }
        l2 = localStatFs.getBlockSizeLong();
        long l3 = localStatFs.getBlockCountLong();
        l1 = l3 * l2;
      }
      catch (Exception localException)
      {
        StatFs localStatFs;
        long l2;
        label48:
        label55:
        int i;
        break label48;
      }
      AppMethodBeat.o(95072);
      return l1;
      l2 = localStatFs.getBlockSize();
      i = localStatFs.getBlockCount();
    }
  }
  
  /* Error */
  private static String drY()
  {
    // Byte code:
    //   0: ldc 252
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 254
    //   7: invokestatic 258	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_2
    //   11: new 260	com/tencent/mm/vfs/k
    //   14: dup
    //   15: ldc_w 262
    //   18: invokespecial 263	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   21: astore_0
    //   22: new 265	java/io/BufferedReader
    //   25: dup
    //   26: aload_0
    //   27: sipush 8192
    //   30: invokespecial 268	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual 271	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull +5 -> 45
    //   43: aload_3
    //   44: astore_2
    //   45: aload_1
    //   46: invokevirtual 274	java/io/BufferedReader:close	()V
    //   49: aload_0
    //   50: invokevirtual 275	com/tencent/mm/vfs/k:close	()V
    //   53: aload_2
    //   54: astore_1
    //   55: ldc 252
    //   57: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_1
    //   61: areturn
    //   62: astore_0
    //   63: aconst_null
    //   64: astore_1
    //   65: aconst_null
    //   66: astore_0
    //   67: aload_1
    //   68: ifnull +7 -> 75
    //   71: aload_1
    //   72: invokevirtual 274	java/io/BufferedReader:close	()V
    //   75: aload_2
    //   76: astore_1
    //   77: aload_0
    //   78: ifnull -23 -> 55
    //   81: aload_0
    //   82: invokevirtual 275	com/tencent/mm/vfs/k:close	()V
    //   85: aload_2
    //   86: astore_1
    //   87: goto -32 -> 55
    //   90: astore_0
    //   91: aload_2
    //   92: astore_1
    //   93: goto -38 -> 55
    //   96: astore_0
    //   97: aconst_null
    //   98: astore_1
    //   99: aconst_null
    //   100: astore_0
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 274	java/io/BufferedReader:close	()V
    //   109: aload_2
    //   110: astore_1
    //   111: aload_0
    //   112: ifnull -57 -> 55
    //   115: aload_0
    //   116: invokevirtual 275	com/tencent/mm/vfs/k:close	()V
    //   119: aload_2
    //   120: astore_1
    //   121: goto -66 -> 55
    //   124: astore_0
    //   125: aload_2
    //   126: astore_1
    //   127: goto -72 -> 55
    //   130: astore_2
    //   131: aconst_null
    //   132: astore_1
    //   133: aconst_null
    //   134: astore_0
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 274	java/io/BufferedReader:close	()V
    //   143: aload_0
    //   144: ifnull +7 -> 151
    //   147: aload_0
    //   148: invokevirtual 275	com/tencent/mm/vfs/k:close	()V
    //   151: ldc 252
    //   153: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_2
    //   157: athrow
    //   158: astore_1
    //   159: goto -110 -> 49
    //   162: astore_0
    //   163: aload_2
    //   164: astore_1
    //   165: goto -110 -> 55
    //   168: astore_1
    //   169: goto -94 -> 75
    //   172: astore_1
    //   173: goto -64 -> 109
    //   176: astore_1
    //   177: goto -34 -> 143
    //   180: astore_0
    //   181: goto -30 -> 151
    //   184: astore_2
    //   185: aconst_null
    //   186: astore_1
    //   187: goto -52 -> 135
    //   190: astore_2
    //   191: goto -56 -> 135
    //   194: astore_1
    //   195: aconst_null
    //   196: astore_1
    //   197: goto -96 -> 101
    //   200: astore_3
    //   201: goto -100 -> 101
    //   204: astore_1
    //   205: aconst_null
    //   206: astore_1
    //   207: goto -140 -> 67
    //   210: astore_3
    //   211: goto -144 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	29	0	localk	com.tencent.mm.vfs.k
    //   62	1	0	localFileNotFoundException1	java.io.FileNotFoundException
    //   66	16	0	localObject1	Object
    //   90	1	0	localIOException1	java.io.IOException
    //   96	1	0	localIOException2	java.io.IOException
    //   100	16	0	localObject2	Object
    //   124	1	0	localIOException3	java.io.IOException
    //   134	14	0	localObject3	Object
    //   162	1	0	localIOException4	java.io.IOException
    //   180	1	0	localIOException5	java.io.IOException
    //   33	107	1	localObject4	Object
    //   158	1	1	localIOException6	java.io.IOException
    //   164	1	1	localObject5	Object
    //   168	1	1	localIOException7	java.io.IOException
    //   172	1	1	localIOException8	java.io.IOException
    //   176	1	1	localIOException9	java.io.IOException
    //   186	1	1	localObject6	Object
    //   194	1	1	localIOException10	java.io.IOException
    //   196	1	1	localObject7	Object
    //   204	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   206	1	1	localObject8	Object
    //   10	116	2	localObject9	Object
    //   130	34	2	localObject10	Object
    //   184	1	2	localObject11	Object
    //   190	1	2	localObject12	Object
    //   38	6	3	str	String
    //   200	1	3	localIOException11	java.io.IOException
    //   210	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   11	22	62	java/io/FileNotFoundException
    //   81	85	90	java/io/IOException
    //   11	22	96	java/io/IOException
    //   115	119	124	java/io/IOException
    //   11	22	130	finally
    //   45	49	158	java/io/IOException
    //   49	53	162	java/io/IOException
    //   71	75	168	java/io/IOException
    //   105	109	172	java/io/IOException
    //   139	143	176	java/io/IOException
    //   147	151	180	java/io/IOException
    //   22	34	184	finally
    //   34	39	190	finally
    //   22	34	194	java/io/IOException
    //   34	39	200	java/io/IOException
    //   22	34	204	java/io/FileNotFoundException
    //   34	39	210	java/io/FileNotFoundException
  }
  
  private static Pair<Integer, Integer> fS(Context paramContext)
  {
    AppMethodBeat.i(95070);
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext = (WindowManager)paramContext.getSystemService("window");
      if (paramContext != null)
      {
        if (Build.VERSION.SDK_INT < 17) {
          break label91;
        }
        paramContext.getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      }
      for (;;)
      {
        paramContext = new Pair(Integer.valueOf(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels)), Integer.valueOf(Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels)));
        AppMethodBeat.o(95070);
        return paramContext;
        label91:
        paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext = new Pair(Integer.valueOf(0), Integer.valueOf(0));
      AppMethodBeat.o(95070);
    }
  }
  
  /* Error */
  private static long fT(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 327
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: lconst_0
    //   7: lstore_3
    //   8: getstatic 234	android/os/Build$VERSION:SDK_INT	I
    //   11: bipush 16
    //   13: if_icmplt +47 -> 60
    //   16: aload_0
    //   17: ldc_w 329
    //   20: invokevirtual 285	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: checkcast 331	android/app/ActivityManager
    //   26: astore_0
    //   27: new 333	android/app/ActivityManager$MemoryInfo
    //   30: dup
    //   31: invokespecial 334	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   34: astore 5
    //   36: aload_0
    //   37: ifnull +299 -> 336
    //   40: aload_0
    //   41: aload 5
    //   43: invokevirtual 338	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   46: aload 5
    //   48: getfield 341	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   51: lstore_1
    //   52: ldc_w 327
    //   55: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: lload_1
    //   59: lreturn
    //   60: new 260	com/tencent/mm/vfs/k
    //   63: dup
    //   64: ldc_w 343
    //   67: invokespecial 263	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   70: astore_0
    //   71: new 265	java/io/BufferedReader
    //   74: dup
    //   75: aload_0
    //   76: sipush 4096
    //   79: invokespecial 268	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   82: astore 5
    //   84: aload 5
    //   86: invokevirtual 271	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   89: astore 6
    //   91: aload 6
    //   93: ifnull +14 -> 107
    //   96: aload 6
    //   98: ldc_w 345
    //   101: invokevirtual 351	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   104: ifeq -20 -> 84
    //   107: lload_3
    //   108: lstore_1
    //   109: aload 6
    //   111: ifnull +26 -> 137
    //   114: aload 6
    //   116: ldc_w 353
    //   119: invokevirtual 357	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   122: iconst_1
    //   123: aaload
    //   124: invokestatic 362	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   127: invokevirtual 365	java/lang/Long:longValue	()J
    //   130: lstore_1
    //   131: lload_1
    //   132: ldc2_w 366
    //   135: lmul
    //   136: lstore_1
    //   137: aload 5
    //   139: invokevirtual 274	java/io/BufferedReader:close	()V
    //   142: aload_0
    //   143: invokevirtual 275	com/tencent/mm/vfs/k:close	()V
    //   146: goto -94 -> 52
    //   149: astore_0
    //   150: goto -98 -> 52
    //   153: astore_0
    //   154: aconst_null
    //   155: astore 5
    //   157: aconst_null
    //   158: astore_0
    //   159: aload 5
    //   161: ifnull +8 -> 169
    //   164: aload 5
    //   166: invokevirtual 274	java/io/BufferedReader:close	()V
    //   169: lload_3
    //   170: lstore_1
    //   171: aload_0
    //   172: ifnull -120 -> 52
    //   175: aload_0
    //   176: invokevirtual 275	com/tencent/mm/vfs/k:close	()V
    //   179: lload_3
    //   180: lstore_1
    //   181: goto -129 -> 52
    //   184: astore_0
    //   185: lload_3
    //   186: lstore_1
    //   187: goto -135 -> 52
    //   190: astore_0
    //   191: aconst_null
    //   192: astore 5
    //   194: aconst_null
    //   195: astore_0
    //   196: aload 5
    //   198: ifnull +8 -> 206
    //   201: aload 5
    //   203: invokevirtual 274	java/io/BufferedReader:close	()V
    //   206: lload_3
    //   207: lstore_1
    //   208: aload_0
    //   209: ifnull -157 -> 52
    //   212: aload_0
    //   213: invokevirtual 275	com/tencent/mm/vfs/k:close	()V
    //   216: lload_3
    //   217: lstore_1
    //   218: goto -166 -> 52
    //   221: astore_0
    //   222: lload_3
    //   223: lstore_1
    //   224: goto -172 -> 52
    //   227: astore 5
    //   229: aconst_null
    //   230: astore 6
    //   232: aconst_null
    //   233: astore_0
    //   234: aload 6
    //   236: ifnull +8 -> 244
    //   239: aload 6
    //   241: invokevirtual 274	java/io/BufferedReader:close	()V
    //   244: aload_0
    //   245: ifnull +7 -> 252
    //   248: aload_0
    //   249: invokevirtual 275	com/tencent/mm/vfs/k:close	()V
    //   252: ldc_w 327
    //   255: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: aload 5
    //   260: athrow
    //   261: astore 5
    //   263: goto -121 -> 142
    //   266: astore 5
    //   268: goto -99 -> 169
    //   271: astore 5
    //   273: goto -67 -> 206
    //   276: astore 6
    //   278: goto -34 -> 244
    //   281: astore_0
    //   282: goto -30 -> 252
    //   285: astore 5
    //   287: aconst_null
    //   288: astore 6
    //   290: goto -56 -> 234
    //   293: astore 6
    //   295: aload 5
    //   297: astore 7
    //   299: aload 6
    //   301: astore 5
    //   303: aload 7
    //   305: astore 6
    //   307: goto -73 -> 234
    //   310: astore 5
    //   312: aconst_null
    //   313: astore 5
    //   315: goto -119 -> 196
    //   318: astore 6
    //   320: goto -124 -> 196
    //   323: astore 5
    //   325: aconst_null
    //   326: astore 5
    //   328: goto -169 -> 159
    //   331: astore 6
    //   333: goto -174 -> 159
    //   336: lconst_0
    //   337: lstore_1
    //   338: goto -286 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramContext	Context
    //   51	287	1	l1	long
    //   7	216	3	l2	long
    //   34	168	5	localObject1	Object
    //   227	32	5	localObject2	Object
    //   261	1	5	localIOException1	java.io.IOException
    //   266	1	5	localIOException2	java.io.IOException
    //   271	1	5	localIOException3	java.io.IOException
    //   285	11	5	localObject3	Object
    //   301	1	5	localObject4	Object
    //   310	1	5	localIOException4	java.io.IOException
    //   313	1	5	localObject5	Object
    //   323	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   326	1	5	localObject6	Object
    //   89	151	6	str	String
    //   276	1	6	localIOException5	java.io.IOException
    //   288	1	6	localObject7	Object
    //   293	7	6	localObject8	Object
    //   305	1	6	localObject9	Object
    //   318	1	6	localIOException6	java.io.IOException
    //   331	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   297	7	7	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   142	146	149	java/io/IOException
    //   60	71	153	java/io/FileNotFoundException
    //   175	179	184	java/io/IOException
    //   60	71	190	java/io/IOException
    //   212	216	221	java/io/IOException
    //   60	71	227	finally
    //   137	142	261	java/io/IOException
    //   164	169	266	java/io/IOException
    //   201	206	271	java/io/IOException
    //   239	244	276	java/io/IOException
    //   248	252	281	java/io/IOException
    //   71	84	285	finally
    //   84	91	293	finally
    //   96	107	293	finally
    //   114	131	293	finally
    //   71	84	310	java/io/IOException
    //   84	91	318	java/io/IOException
    //   96	107	318	java/io/IOException
    //   114	131	318	java/io/IOException
    //   71	84	323	java/io/FileNotFoundException
    //   84	91	331	java/io/FileNotFoundException
    //   96	107	331	java/io/FileNotFoundException
    //   114	131	331	java/io/FileNotFoundException
  }
  
  private static String getTimeZone()
  {
    AppMethodBeat.i(95069);
    Object localObject = "";
    try
    {
      String str = TimeZone.getDefault().getDisplayName(false, 0);
      localObject = str;
    }
    catch (Exception localException)
    {
      break label20;
    }
    catch (AssertionError localAssertionError)
    {
      label20:
      break label20;
    }
    AppMethodBeat.o(95069);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.f
 * JD-Core Version:    0.7.0.1
 */