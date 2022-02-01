package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.xweb.util.BSpatch;
import com.tencent.xweb.util.c;
import com.tencent.xweb.util.g;
import com.tencent.xweb.xwalk.updater.SchedulerConfig;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public abstract class f
{
  public int MxJ = -1;
  
  public f()
  {
    gdk();
  }
  
  private String aiN(int paramInt)
  {
    Object localObject = aiK(paramInt);
    if (((String)localObject).isEmpty())
    {
      Log.e(getPluginName(), "getPatchDir, versionDir is empty");
      localObject = "";
    }
    String str;
    File localFile;
    do
    {
      return localObject;
      str = (String)localObject + File.separator + "patch_temp";
      localFile = new File(str);
      localObject = str;
    } while (localFile.exists());
    localFile.mkdirs();
    return str;
  }
  
  private String de(int paramInt, String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e(getPluginName(), "getPatchFile, fileName is empty");
      return "";
    }
    String str = aiN(paramInt);
    if (str.isEmpty())
    {
      Log.e(getPluginName(), "getPatchFile, patchDir is null");
      return "";
    }
    return str + File.separator + paramString;
  }
  
  public abstract int a(SchedulerConfig paramSchedulerConfig);
  
  public final boolean aiJ(int paramInt)
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(getPluginName(), "setVer, context is null");
      return false;
    }
    Object localObject = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(getPluginName());
    if (localObject == null)
    {
      Log.e(getPluginName(), "setVer, sp is null");
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("availableVersion", paramInt);
    boolean bool = ((SharedPreferences.Editor)localObject).commit();
    if (bool) {
      this.MxJ = paramInt;
    }
    Log.i(getPluginName(), "setVer, version = " + paramInt + ", isNow = true, ret = " + bool);
    return bool;
  }
  
  public final String aiK(int paramInt)
  {
    Object localObject;
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(getPluginName(), "getVersionDir, context is null");
      localObject = "";
    }
    String str;
    File localFile;
    do
    {
      return localObject;
      localObject = XWalkEnvironment.getPluginBaseDir();
      if (((String)localObject).isEmpty())
      {
        Log.e(getPluginName(), "getVersionDir, pluginBaseDir is null");
        return "";
      }
      str = (String)localObject + File.separator + getPluginName() + "_" + paramInt;
      localFile = new File(str);
      localObject = str;
    } while (localFile.exists());
    localFile.mkdirs();
    return str;
  }
  
  public final String aiL(int paramInt)
  {
    Object localObject = aiK(paramInt);
    if ((localObject == null) || (((String)localObject).isEmpty()))
    {
      Log.e(getPluginName(), "getPrivateCacheDir, versionDir is empty");
      localObject = "";
    }
    String str;
    File localFile;
    do
    {
      return localObject;
      str = (String)localObject + File.separator + "cache";
      localFile = new File(str);
      localObject = str;
    } while (localFile.exists());
    localFile.mkdirs();
    return str;
  }
  
  public final String aiM(int paramInt)
  {
    Object localObject = aiK(paramInt);
    if (((String)localObject).isEmpty())
    {
      Log.e(getPluginName(), "getExtractDir, versionDir is empty");
      localObject = "";
    }
    String str;
    File localFile;
    do
    {
      return localObject;
      str = (String)localObject + File.separator + "extracted";
      localFile = new File(str);
      localObject = str;
    } while (localFile.exists());
    localFile.mkdirs();
    return str;
  }
  
  public final void aiO(int paramInt)
  {
    int i = this.MxJ;
    if (i <= 0) {
      Log.e(getPluginName(), "reportUsingVersion, not installed");
    }
    for (;;)
    {
      return;
      Object localObject = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(getPluginName());
      if (localObject == null)
      {
        Log.e(getPluginName(), "reportUsingVersion, sp is null");
        return;
      }
      int j = ((SharedPreferences)localObject).getInt("lastReportVersion", -1);
      String str2 = ((SharedPreferences)localObject).getString("lastReportDate", "");
      try
      {
        String str1 = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if ((j != i) || (!str2.equals(str1)))
        {
          j = i % 50 + 100;
          Log.d(getPluginName(), "reportUsingVersion, id:" + paramInt + ", key:" + j);
          g.t(paramInt, j, 1L);
          localObject = ((SharedPreferences)localObject).edit();
          if (localObject != null)
          {
            ((SharedPreferences.Editor)localObject).putInt("lastReportVersion", i);
            ((SharedPreferences.Editor)localObject).putString("lastReportDate", str1);
            ((SharedPreferences.Editor)localObject).commit();
            return;
          }
        }
      }
      catch (Exception localException)
      {
        Log.e(getPluginName(), "reportUsingVersion, get cur date error: " + localException.getMessage());
        return;
      }
    }
    Log.e(getPluginName(), "reportUsingVersion, editor is null");
  }
  
  /* Error */
  protected final boolean b(SchedulerConfig paramSchedulerConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 31	com/tencent/xweb/xwalk/a/f:getPluginName	()Ljava/lang/String;
    //   4: new 43	java/lang/StringBuilder
    //   7: dup
    //   8: ldc 208
    //   10: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: aload_1
    //   14: getfield 213	com/tencent/xweb/xwalk/updater/SchedulerConfig:version	I
    //   17: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokestatic 125	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: new 50	java/io/File
    //   29: dup
    //   30: aload_1
    //   31: getfield 216	com/tencent/xweb/xwalk/updater/SchedulerConfig:path	Ljava/lang/String;
    //   34: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore 5
    //   39: aload_1
    //   40: getfield 216	com/tencent/xweb/xwalk/updater/SchedulerConfig:path	Ljava/lang/String;
    //   43: aload_1
    //   44: getfield 219	com/tencent/xweb/xwalk/updater/SchedulerConfig:Mys	Ljava/lang/String;
    //   47: invokestatic 225	com/tencent/xweb/util/d:nh	(Ljava/lang/String;Ljava/lang/String;)Z
    //   50: ifne +32 -> 82
    //   53: aload_0
    //   54: invokevirtual 31	com/tencent/xweb/xwalk/a/f:getPluginName	()Ljava/lang/String;
    //   57: ldc 227
    //   59: invokestatic 125	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aconst_null
    //   63: invokestatic 233	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   66: aload 5
    //   68: invokevirtual 65	java/io/File:exists	()Z
    //   71: ifeq +9 -> 80
    //   74: aload 5
    //   76: invokevirtual 236	java/io/File:delete	()Z
    //   79: pop
    //   80: iconst_0
    //   81: ireturn
    //   82: new 238	java/util/zip/ZipFile
    //   85: dup
    //   86: aload_1
    //   87: getfield 216	com/tencent/xweb/xwalk/updater/SchedulerConfig:path	Ljava/lang/String;
    //   90: invokespecial 239	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   93: astore_3
    //   94: aload_3
    //   95: invokevirtual 243	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   98: astore 6
    //   100: aload 6
    //   102: invokeinterface 248 1 0
    //   107: ifeq +208 -> 315
    //   110: aload 6
    //   112: invokeinterface 252 1 0
    //   117: checkcast 254	java/util/zip/ZipEntry
    //   120: astore 7
    //   122: aload 7
    //   124: invokevirtual 257	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   127: ldc_w 259
    //   130: invokestatic 264	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   133: astore 4
    //   135: aload 4
    //   137: ldc_w 266
    //   140: invokevirtual 270	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   143: ifne -43 -> 100
    //   146: aload 4
    //   148: ldc_w 272
    //   151: invokevirtual 270	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   154: ifne -54 -> 100
    //   157: aload 7
    //   159: invokevirtual 275	java/util/zip/ZipEntry:isDirectory	()Z
    //   162: ifne -62 -> 100
    //   165: aload_3
    //   166: aload 7
    //   168: invokevirtual 279	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   171: astore 7
    //   173: aload_1
    //   174: getfield 283	com/tencent/xweb/xwalk/updater/SchedulerConfig:MyT	Z
    //   177: ifeq +62 -> 239
    //   180: new 50	java/io/File
    //   183: dup
    //   184: aload_0
    //   185: aload_1
    //   186: getfield 213	com/tencent/xweb/xwalk/updater/SchedulerConfig:version	I
    //   189: aload 4
    //   191: invokespecial 285	com/tencent/xweb/xwalk/a/f:de	(ILjava/lang/String;)Ljava/lang/String;
    //   194: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   197: astore 4
    //   199: aload 7
    //   201: aload 4
    //   203: invokestatic 288	com/tencent/xweb/util/c:b	(Ljava/io/InputStream;Ljava/io/File;)Z
    //   206: ifne -106 -> 100
    //   209: aload_0
    //   210: invokevirtual 31	com/tencent/xweb/xwalk/a/f:getPluginName	()Ljava/lang/String;
    //   213: ldc_w 290
    //   216: invokestatic 39	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_3
    //   220: invokestatic 233	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   223: aload 5
    //   225: invokevirtual 65	java/io/File:exists	()Z
    //   228: ifeq +9 -> 237
    //   231: aload 5
    //   233: invokevirtual 236	java/io/File:delete	()Z
    //   236: pop
    //   237: iconst_0
    //   238: ireturn
    //   239: new 50	java/io/File
    //   242: dup
    //   243: aload_0
    //   244: aload_1
    //   245: getfield 213	com/tencent/xweb/xwalk/updater/SchedulerConfig:version	I
    //   248: aload 4
    //   250: invokevirtual 293	com/tencent/xweb/xwalk/a/f:dd	(ILjava/lang/String;)Ljava/lang/String;
    //   253: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   256: astore 4
    //   258: goto -59 -> 199
    //   261: astore 4
    //   263: aload_3
    //   264: astore_1
    //   265: aload 4
    //   267: astore_3
    //   268: aload_0
    //   269: invokevirtual 31	com/tencent/xweb/xwalk/a/f:getPluginName	()Ljava/lang/String;
    //   272: new 43	java/lang/StringBuilder
    //   275: dup
    //   276: ldc_w 295
    //   279: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   282: aload_3
    //   283: invokevirtual 202	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   286: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 39	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload_1
    //   296: invokestatic 233	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   299: aload 5
    //   301: invokevirtual 65	java/io/File:exists	()Z
    //   304: ifeq +9 -> 313
    //   307: aload 5
    //   309: invokevirtual 236	java/io/File:delete	()Z
    //   312: pop
    //   313: iconst_0
    //   314: ireturn
    //   315: aload_1
    //   316: getfield 298	com/tencent/xweb/xwalk/updater/SchedulerConfig:Mzc	Z
    //   319: ifne +12 -> 331
    //   322: aload_1
    //   323: getfield 283	com/tencent/xweb/xwalk/updater/SchedulerConfig:MyT	Z
    //   326: istore_2
    //   327: iload_2
    //   328: ifeq +23 -> 351
    //   331: aload_3
    //   332: invokestatic 233	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   335: aload 5
    //   337: invokevirtual 65	java/io/File:exists	()Z
    //   340: ifeq +9 -> 349
    //   343: aload 5
    //   345: invokevirtual 236	java/io/File:delete	()Z
    //   348: pop
    //   349: iconst_1
    //   350: ireturn
    //   351: aload_0
    //   352: aload_1
    //   353: getfield 213	com/tencent/xweb/xwalk/updater/SchedulerConfig:version	I
    //   356: iconst_0
    //   357: invokevirtual 302	com/tencent/xweb/xwalk/a/f:br	(IZ)Z
    //   360: ifne +33 -> 393
    //   363: aload_0
    //   364: invokevirtual 31	com/tencent/xweb/xwalk/a/f:getPluginName	()Ljava/lang/String;
    //   367: ldc_w 304
    //   370: invokestatic 39	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: aload_3
    //   374: invokestatic 233	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   377: aload 5
    //   379: invokevirtual 65	java/io/File:exists	()Z
    //   382: ifeq +9 -> 391
    //   385: aload 5
    //   387: invokevirtual 236	java/io/File:delete	()Z
    //   390: pop
    //   391: iconst_0
    //   392: ireturn
    //   393: aload_3
    //   394: invokestatic 233	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   397: aload 5
    //   399: invokevirtual 65	java/io/File:exists	()Z
    //   402: ifeq +9 -> 411
    //   405: aload 5
    //   407: invokevirtual 236	java/io/File:delete	()Z
    //   410: pop
    //   411: iconst_1
    //   412: ireturn
    //   413: astore_1
    //   414: aconst_null
    //   415: astore_3
    //   416: aload_3
    //   417: invokestatic 233	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   420: aload 5
    //   422: invokevirtual 65	java/io/File:exists	()Z
    //   425: ifeq +9 -> 434
    //   428: aload 5
    //   430: invokevirtual 236	java/io/File:delete	()Z
    //   433: pop
    //   434: aload_1
    //   435: athrow
    //   436: astore_1
    //   437: goto -21 -> 416
    //   440: astore 4
    //   442: aload_1
    //   443: astore_3
    //   444: aload 4
    //   446: astore_1
    //   447: goto -31 -> 416
    //   450: astore_3
    //   451: aconst_null
    //   452: astore_1
    //   453: goto -185 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	f
    //   0	456	1	paramSchedulerConfig	SchedulerConfig
    //   326	2	2	bool	boolean
    //   93	351	3	localObject1	Object
    //   450	1	3	localException1	Exception
    //   133	124	4	localObject2	Object
    //   261	5	4	localException2	Exception
    //   440	5	4	localObject3	Object
    //   37	392	5	localFile	File
    //   98	13	6	localEnumeration	java.util.Enumeration
    //   120	80	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   94	100	261	java/lang/Exception
    //   100	199	261	java/lang/Exception
    //   199	219	261	java/lang/Exception
    //   239	258	261	java/lang/Exception
    //   315	327	261	java/lang/Exception
    //   351	373	261	java/lang/Exception
    //   39	62	413	finally
    //   82	94	413	finally
    //   94	100	436	finally
    //   100	199	436	finally
    //   199	219	436	finally
    //   239	258	436	finally
    //   315	327	436	finally
    //   351	373	436	finally
    //   268	295	440	finally
    //   39	62	450	java/lang/Exception
    //   82	94	450	java/lang/Exception
  }
  
  public abstract String bq(int paramInt, boolean paramBoolean);
  
  /* Error */
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 31	com/tencent/xweb/xwalk/a/f:getPluginName	()Ljava/lang/String;
    //   4: ldc_w 308
    //   7: iload_1
    //   8: invokestatic 311	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   11: invokevirtual 315	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   14: invokestatic 125	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: iload_1
    //   18: ifge +15 -> 33
    //   21: aload_0
    //   22: invokevirtual 31	com/tencent/xweb/xwalk/a/f:getPluginName	()Ljava/lang/String;
    //   25: ldc_w 317
    //   28: invokestatic 125	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: iconst_0
    //   32: ireturn
    //   33: new 50	java/io/File
    //   36: dup
    //   37: aload_0
    //   38: iload_1
    //   39: ldc_w 319
    //   42: invokevirtual 293	com/tencent/xweb/xwalk/a/f:dd	(ILjava/lang/String;)Ljava/lang/String;
    //   45: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore_3
    //   49: aload_3
    //   50: invokevirtual 65	java/io/File:exists	()Z
    //   53: ifne +31 -> 84
    //   56: iload_2
    //   57: ifeq +15 -> 72
    //   60: aload_0
    //   61: invokevirtual 31	com/tencent/xweb/xwalk/a/f:getPluginName	()Ljava/lang/String;
    //   64: ldc_w 321
    //   67: invokestatic 125	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: iconst_1
    //   71: ireturn
    //   72: aload_0
    //   73: invokevirtual 31	com/tencent/xweb/xwalk/a/f:getPluginName	()Ljava/lang/String;
    //   76: ldc_w 323
    //   79: invokestatic 39	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: iconst_0
    //   83: ireturn
    //   84: new 325	java/io/BufferedReader
    //   87: dup
    //   88: new 327	java/io/FileReader
    //   91: dup
    //   92: aload_3
    //   93: invokespecial 330	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   96: invokespecial 333	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   99: astore 4
    //   101: aload 4
    //   103: astore_3
    //   104: aload 4
    //   106: invokevirtual 336	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   109: astore 5
    //   111: aload 5
    //   113: ifnull +135 -> 248
    //   116: aload 4
    //   118: astore_3
    //   119: aload 5
    //   121: invokevirtual 27	java/lang/String:isEmpty	()Z
    //   124: ifne -23 -> 101
    //   127: aload 4
    //   129: astore_3
    //   130: aload 5
    //   132: ldc_w 338
    //   135: invokevirtual 342	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   138: astore 6
    //   140: aload 4
    //   142: astore_3
    //   143: aload 6
    //   145: arraylength
    //   146: iconst_2
    //   147: if_icmpne -46 -> 101
    //   150: aload 6
    //   152: iconst_0
    //   153: aaload
    //   154: ifnull -53 -> 101
    //   157: aload 4
    //   159: astore_3
    //   160: aload 6
    //   162: iconst_0
    //   163: aaload
    //   164: invokevirtual 27	java/lang/String:isEmpty	()Z
    //   167: ifne -66 -> 101
    //   170: aload 6
    //   172: iconst_1
    //   173: aaload
    //   174: ifnull -73 -> 101
    //   177: aload 4
    //   179: astore_3
    //   180: aload 6
    //   182: iconst_1
    //   183: aaload
    //   184: invokevirtual 27	java/lang/String:isEmpty	()Z
    //   187: ifne -86 -> 101
    //   190: aload 6
    //   192: iconst_0
    //   193: aaload
    //   194: astore 5
    //   196: aload 6
    //   198: iconst_1
    //   199: aaload
    //   200: astore 6
    //   202: aload 4
    //   204: astore_3
    //   205: aload_0
    //   206: iload_1
    //   207: aload 5
    //   209: invokevirtual 293	com/tencent/xweb/xwalk/a/f:dd	(ILjava/lang/String;)Ljava/lang/String;
    //   212: aload 6
    //   214: invokestatic 225	com/tencent/xweb/util/d:nh	(Ljava/lang/String;Ljava/lang/String;)Z
    //   217: ifne -116 -> 101
    //   220: aload 4
    //   222: astore_3
    //   223: aload_0
    //   224: invokevirtual 31	com/tencent/xweb/xwalk/a/f:getPluginName	()Ljava/lang/String;
    //   227: ldc_w 344
    //   230: aload 5
    //   232: invokestatic 347	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   235: invokevirtual 315	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   238: invokestatic 39	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload 4
    //   243: invokestatic 233	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   246: iconst_0
    //   247: ireturn
    //   248: aload 4
    //   250: astore_3
    //   251: aload_0
    //   252: invokevirtual 31	com/tencent/xweb/xwalk/a/f:getPluginName	()Ljava/lang/String;
    //   255: ldc_w 349
    //   258: invokestatic 125	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload 4
    //   263: invokestatic 233	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   266: iconst_1
    //   267: ireturn
    //   268: astore 5
    //   270: aconst_null
    //   271: astore 4
    //   273: aload 4
    //   275: astore_3
    //   276: aload_0
    //   277: invokevirtual 31	com/tencent/xweb/xwalk/a/f:getPluginName	()Ljava/lang/String;
    //   280: new 43	java/lang/StringBuilder
    //   283: dup
    //   284: ldc_w 351
    //   287: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   290: aload 5
    //   292: invokevirtual 202	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   295: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 39	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload 4
    //   306: invokestatic 233	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   309: iconst_0
    //   310: ireturn
    //   311: astore 4
    //   313: aconst_null
    //   314: astore_3
    //   315: aload_3
    //   316: invokestatic 233	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   319: aload 4
    //   321: athrow
    //   322: astore 4
    //   324: goto -9 -> 315
    //   327: astore 5
    //   329: goto -56 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	f
    //   0	332	1	paramInt	int
    //   0	332	2	paramBoolean	boolean
    //   48	268	3	localObject1	Object
    //   99	206	4	localBufferedReader	java.io.BufferedReader
    //   311	9	4	localObject2	Object
    //   322	1	4	localObject3	Object
    //   109	122	5	str	String
    //   268	23	5	localException1	Exception
    //   327	1	5	localException2	Exception
    //   138	75	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   84	101	268	java/lang/Exception
    //   84	101	311	finally
    //   104	111	322	finally
    //   119	127	322	finally
    //   130	140	322	finally
    //   143	150	322	finally
    //   160	170	322	finally
    //   180	190	322	finally
    //   205	220	322	finally
    //   223	241	322	finally
    //   251	261	322	finally
    //   276	304	322	finally
    //   104	111	327	java/lang/Exception
    //   119	127	327	java/lang/Exception
    //   130	140	327	java/lang/Exception
    //   143	150	327	java/lang/Exception
    //   160	170	327	java/lang/Exception
    //   180	190	327	java/lang/Exception
    //   205	220	327	java/lang/Exception
    //   223	241	327	java/lang/Exception
    //   251	261	327	java/lang/Exception
  }
  
  protected final boolean c(SchedulerConfig paramSchedulerConfig)
  {
    Log.i(getPluginName(), "doPatch new version = " + paramSchedulerConfig.version);
    if (this.MxJ < 0)
    {
      Log.e(getPluginName(), "doPatch, current version invalid");
      return false;
    }
    if (!paramSchedulerConfig.MyT)
    {
      Log.e(getPluginName(), "doPatch, current download config is not patch");
      return false;
    }
    Object localObject = new File(de(paramSchedulerConfig.version, "patch.config"));
    if (!((File)localObject).exists())
    {
      Log.e(getPluginName(), "doPatch, can not find patch config file");
      return false;
    }
    localObject = h.al((File)localObject);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      Log.e(getPluginName(), "doPatch, patchConfigList = null");
      return false;
    }
    if (!c.ng(aiM(this.MxJ), aiM(paramSchedulerConfig.version)))
    {
      Log.e(getPluginName(), "doPatch, copy files failed");
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      h.a locala = (h.a)((Iterator)localObject).next();
      int i;
      if (locala.type == 1) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          if (!c.lL(de(paramSchedulerConfig.version, locala.originalFileName), dd(paramSchedulerConfig.version, locala.originalFileName)))
          {
            Log.e(getPluginName(), "doPatch, add file error: ".concat(String.valueOf(locala)));
            return false;
            i = 0;
          }
          else
          {
            Log.i(getPluginName(), "doPatch, add file:".concat(String.valueOf(locala)));
            break;
          }
        }
      }
      if (locala.type == 3) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          if (!c.deleteFile(dd(paramSchedulerConfig.version, locala.originalFileName)))
          {
            Log.e(getPluginName(), "doPatch, delete file error:".concat(String.valueOf(locala)));
            break;
            i = 0;
            continue;
          }
          Log.i(getPluginName(), "doPatch, delete file:".concat(String.valueOf(locala)));
          break;
        }
      }
      if (locala.type == 2) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          if (BSpatch.bm(dd(paramSchedulerConfig.version, locala.originalFileName), de(paramSchedulerConfig.version, locala.patchFileName), dd(paramSchedulerConfig.version, locala.originalFileName)) < 0)
          {
            Log.e(getPluginName(), "doPatch, patch file error:".concat(String.valueOf(locala)));
            return false;
            i = 0;
          }
          else
          {
            Log.i(getPluginName(), "doPatch, patch file:".concat(String.valueOf(locala)));
            break;
          }
        }
      }
      Log.e(getPluginName(), "doPatch, unknown op".concat(String.valueOf(locala)));
      return false;
    }
    c.deleteFile(dd(paramSchedulerConfig.version, "filelist.config"));
    if (!c.lL(de(paramSchedulerConfig.version, "filelist.config"), dd(paramSchedulerConfig.version, "filelist.config")))
    {
      Log.e(getPluginName(), "doPatch, copy filelist.config error");
      return false;
    }
    if (!br(paramSchedulerConfig.version, false))
    {
      Log.e(getPluginName(), "doPatch, check md5 failed");
      return false;
    }
    paramSchedulerConfig = aiN(paramSchedulerConfig.version);
    if (!paramSchedulerConfig.isEmpty()) {
      c.bbn(paramSchedulerConfig);
    }
    return true;
  }
  
  public final String dd(int paramInt, String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e(getPluginName(), "getExtractFile, fileName is empty");
      return "";
    }
    String str = aiM(paramInt);
    if (str.isEmpty())
    {
      Log.e(getPluginName(), "getExtractFile, extractDir is empty");
      return "";
    }
    return str + File.separator + paramString;
  }
  
  public abstract boolean gdi();
  
  public abstract void gdj();
  
  public final void gdk()
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(getPluginName(), "loadVer, context is null");
      return;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(getPluginName());
    if (localSharedPreferences == null)
    {
      Log.e(getPluginName(), "loadVer, sp is null");
      return;
    }
    this.MxJ = localSharedPreferences.getInt("availableVersion", -1);
    Log.i(getPluginName(), "loadVer, version = " + this.MxJ);
  }
  
  public abstract String getPluginName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.f
 * JD-Core Version:    0.7.0.1
 */