package com.tencent.xweb.xwalk.updater;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.ah;
import com.tencent.xweb.xwalk.p;
import java.nio.channels.FileLock;
import java.util.HashMap;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.ErrorInfo;

public final class f
  extends AsyncTask<String, Integer, Integer>
{
  static XWalkUpdater KGY;
  private static String KIC = "0";
  static boolean KID = false;
  static FileLock KIE = null;
  private HashMap<String, String> KIB;
  
  public f(XWalkUpdater paramXWalkUpdater, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(154573);
    KGY = paramXWalkUpdater;
    this.KIB = paramHashMap;
    if (paramHashMap != null)
    {
      paramXWalkUpdater = (String)paramHashMap.get("UpdaterCheckType");
      KIC = paramXWalkUpdater;
      if ((paramXWalkUpdater == null) || (!KIC.equals("1"))) {
        break label84;
      }
      c.fLZ().fMh();
    }
    for (;;)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdateChecker notify received !! mNotifyType = " + KIC);
      AppMethodBeat.o(154573);
      return;
      label84:
      if ((KIC != null) && (KIC.equals("2")))
      {
        c.fLZ().fMh();
        com.tencent.xweb.util.g.Cf(93L);
      }
      else if ((KIC != null) && (KIC.equals("3")))
      {
        c.fLZ().fMm().KHT = true;
        com.tencent.xweb.util.g.Cf(94L);
      }
      else
      {
        KIC = "0";
      }
    }
  }
  
  public static void agq(int paramInt)
  {
    AppMethodBeat.i(186029);
    fMu();
    c.fLZ().agq(paramInt);
    AppMethodBeat.o(186029);
  }
  
  private static boolean f(SchedulerConfig paramSchedulerConfig)
  {
    AppMethodBeat.i(208963);
    if (fMs())
    {
      AppMethodBeat.o(208963);
      return false;
    }
    XWalkUpdater.ErrorInfo localErrorInfo;
    if (!XWalkEnvironment.isSelfProvider())
    {
      fMt();
      localErrorInfo = KGY.updateRuntimeFromProvider(paramSchedulerConfig);
      try
      {
        Object localObject = XWalkEnvironment.getPackageName();
        String str = localErrorInfo.errorCode + "," + (String)localObject + "," + localErrorInfo.targetVer + "," + localErrorInfo.readFileListFailedCount + "," + localErrorInfo.noMatchedVersionCount + "," + localErrorInfo.copyFailedCount + "," + localErrorInfo.md5FailedCount + "," + localErrorInfo.extractFailedCount + "," + localErrorInfo.setVersionFailedCount + "," + localErrorInfo.extractRetryFailedCount;
        ContentResolver localContentResolver = XWalkEnvironment.getContentResolver();
        if (localContentResolver != null)
        {
          localObject = XWebCoreContentProvider.d("com.tencent.mm", (String)localObject, 3, 0, "");
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("15626", str);
          localContentResolver.insert((Uri)localObject, localContentValues);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          XWalkInitializer.addXWalkInitializeLog("_doStartUpdate report error");
        }
        if (localErrorInfo.errorCode != -10) {
          break label261;
        }
        agq(localErrorInfo.errorCode);
        AppMethodBeat.o(208963);
        return false;
        fMu();
      }
      if (localErrorInfo.errorCode == 0)
      {
        fMv();
        AppMethodBeat.o(208963);
        return true;
      }
    }
    label261:
    XWalkInitializer.addXWalkInitializeLog("_doStartUpdate go on");
    if (!NetworkUtil.isNetworkAvailable())
    {
      paramSchedulerConfig = ah.fJQ();
      if (paramSchedulerConfig != null) {
        paramSchedulerConfig.bvE();
      }
      AppMethodBeat.o(208963);
      return false;
    }
    if ((!paramSchedulerConfig.KHT) && (!NetworkUtil.isWifiAvailable()))
    {
      XWalkInitializer.addXWalkInitializeLog("current network is not wifi , this scheduler not support mobile data");
      paramSchedulerConfig = ah.fJQ();
      if (paramSchedulerConfig != null) {
        paramSchedulerConfig.bvE();
      }
      AppMethodBeat.o(208963);
      return false;
    }
    if (KGY.updateXWalkRuntime(g.g(paramSchedulerConfig)))
    {
      fMt();
      AppMethodBeat.o(208963);
      return true;
    }
    AppMethodBeat.o(208963);
    return false;
  }
  
  /* Error */
  public static boolean fMs()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 256
    //   8: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: getstatic 26	com/tencent/xweb/xwalk/updater/f:KID	Z
    //   14: ifeq +20 -> 34
    //   17: ldc_w 258
    //   20: invokestatic 91	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   23: ldc_w 256
    //   26: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: ldc 2
    //   31: monitorexit
    //   32: iload_0
    //   33: ireturn
    //   34: aconst_null
    //   35: astore_2
    //   36: aconst_null
    //   37: astore_1
    //   38: ldc_w 260
    //   41: invokestatic 266	com/tencent/xweb/util/c:aVk	(Ljava/lang/String;)Ljava/nio/channels/FileLock;
    //   44: astore_3
    //   45: aload_3
    //   46: ifnonnull +66 -> 112
    //   49: aload_3
    //   50: astore_1
    //   51: aload_3
    //   52: astore_2
    //   53: ldc_w 268
    //   56: invokestatic 91	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   59: aload_3
    //   60: ifnull +7 -> 67
    //   63: aload_3
    //   64: invokevirtual 273	java/nio/channels/FileLock:release	()V
    //   67: ldc_w 256
    //   70: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: goto -44 -> 29
    //   76: astore_1
    //   77: ldc 2
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    //   82: astore_1
    //   83: ldc_w 275
    //   86: new 73	java/lang/StringBuilder
    //   89: dup
    //   90: ldc_w 277
    //   93: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload_1
    //   97: invokevirtual 280	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   100: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 282	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: goto -42 -> 67
    //   112: aload_3
    //   113: astore_1
    //   114: aload_3
    //   115: astore_2
    //   116: aload_3
    //   117: invokevirtual 285	java/nio/channels/FileLock:isValid	()Z
    //   120: ifne +60 -> 180
    //   123: aload_3
    //   124: astore_1
    //   125: aload_3
    //   126: astore_2
    //   127: ldc_w 287
    //   130: invokestatic 91	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   133: aload_3
    //   134: ifnull +7 -> 141
    //   137: aload_3
    //   138: invokevirtual 273	java/nio/channels/FileLock:release	()V
    //   141: ldc_w 256
    //   144: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: goto -118 -> 29
    //   150: astore_1
    //   151: ldc_w 275
    //   154: new 73	java/lang/StringBuilder
    //   157: dup
    //   158: ldc_w 277
    //   161: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   164: aload_1
    //   165: invokevirtual 280	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   168: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 282	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: goto -36 -> 141
    //   180: aload_3
    //   181: ifnull +7 -> 188
    //   184: aload_3
    //   185: invokevirtual 273	java/nio/channels/FileLock:release	()V
    //   188: iconst_0
    //   189: istore_0
    //   190: ldc_w 256
    //   193: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: goto -167 -> 29
    //   199: astore_1
    //   200: ldc_w 275
    //   203: new 73	java/lang/StringBuilder
    //   206: dup
    //   207: ldc_w 277
    //   210: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   213: aload_1
    //   214: invokevirtual 280	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 282	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: goto -38 -> 188
    //   229: astore_3
    //   230: aload_1
    //   231: astore_2
    //   232: ldc_w 275
    //   235: new 73	java/lang/StringBuilder
    //   238: dup
    //   239: ldc_w 289
    //   242: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   245: aload_3
    //   246: invokevirtual 280	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   249: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 282	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload_1
    //   259: ifnull -71 -> 188
    //   262: aload_1
    //   263: invokevirtual 273	java/nio/channels/FileLock:release	()V
    //   266: goto -78 -> 188
    //   269: astore_1
    //   270: ldc_w 275
    //   273: new 73	java/lang/StringBuilder
    //   276: dup
    //   277: ldc_w 277
    //   280: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: aload_1
    //   284: invokevirtual 280	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   287: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 282	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: goto -108 -> 188
    //   299: astore_1
    //   300: aload_2
    //   301: ifnull +7 -> 308
    //   304: aload_2
    //   305: invokevirtual 273	java/nio/channels/FileLock:release	()V
    //   308: ldc_w 256
    //   311: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   314: aload_1
    //   315: athrow
    //   316: astore_2
    //   317: ldc_w 275
    //   320: new 73	java/lang/StringBuilder
    //   323: dup
    //   324: ldc_w 277
    //   327: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   330: aload_2
    //   331: invokevirtual 280	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   334: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 282	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: goto -35 -> 308
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	189	0	bool	boolean
    //   37	14	1	localObject1	Object
    //   76	5	1	localObject2	Object
    //   82	15	1	localException1	Exception
    //   113	12	1	localObject3	Object
    //   150	15	1	localException2	Exception
    //   199	64	1	localException3	Exception
    //   269	15	1	localException4	Exception
    //   299	16	1	localObject4	Object
    //   35	270	2	localObject5	Object
    //   316	15	2	localException5	Exception
    //   44	141	3	localFileLock	FileLock
    //   229	17	3	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   5	29	76	finally
    //   63	67	76	finally
    //   67	73	76	finally
    //   83	109	76	finally
    //   137	141	76	finally
    //   141	147	76	finally
    //   151	177	76	finally
    //   184	188	76	finally
    //   190	196	76	finally
    //   200	226	76	finally
    //   262	266	76	finally
    //   270	296	76	finally
    //   304	308	76	finally
    //   308	316	76	finally
    //   317	343	76	finally
    //   63	67	82	java/lang/Exception
    //   137	141	150	java/lang/Exception
    //   184	188	199	java/lang/Exception
    //   38	45	229	java/lang/Exception
    //   53	59	229	java/lang/Exception
    //   116	123	229	java/lang/Exception
    //   127	133	229	java/lang/Exception
    //   262	266	269	java/lang/Exception
    //   38	45	299	finally
    //   53	59	299	finally
    //   116	123	299	finally
    //   127	133	299	finally
    //   232	258	299	finally
    //   304	308	316	java/lang/Exception
  }
  
  public static boolean fMt()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(208964);
        if (KID)
        {
          XWalkInitializer.addXWalkInitializeLog("current process is in updating progress");
          AppMethodBeat.o(208964);
          return bool;
        }
        FileLock localFileLock = com.tencent.xweb.util.c.aVk("xweb_update.lock");
        if (localFileLock == null)
        {
          XWalkInitializer.addXWalkInitializeLog("other process is in updating progress");
          AppMethodBeat.o(208964);
          continue;
        }
        if (localObject.isValid()) {
          break label88;
        }
      }
      finally {}
      XWalkInitializer.addXWalkInitializeLog("other process is in updating progress filelock is not valid");
      AppMethodBeat.o(208964);
      continue;
      label88:
      KIE = localObject;
      KID = true;
      XWalkInitializer.addXWalkInitializeLog("start updating progress");
      AppMethodBeat.o(208964);
      bool = true;
    }
  }
  
  /* Error */
  public static void fMu()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 297
    //   6: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: iconst_0
    //   10: putstatic 26	com/tencent/xweb/xwalk/updater/f:KID	Z
    //   13: getstatic 28	com/tencent/xweb/xwalk/updater/f:KIE	Ljava/nio/channels/FileLock;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +13 -> 31
    //   21: getstatic 28	com/tencent/xweb/xwalk/updater/f:KIE	Ljava/nio/channels/FileLock;
    //   24: invokevirtual 273	java/nio/channels/FileLock:release	()V
    //   27: aconst_null
    //   28: putstatic 28	com/tencent/xweb/xwalk/updater/f:KIE	Ljava/nio/channels/FileLock;
    //   31: ldc_w 299
    //   34: invokestatic 91	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   37: ldc_w 297
    //   40: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: ldc 2
    //   45: monitorexit
    //   46: return
    //   47: astore_0
    //   48: ldc_w 301
    //   51: invokestatic 91	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   54: goto -27 -> 27
    //   57: astore_0
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_0
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	2	0	localFileLock	FileLock
    //   47	1	0	localIOException	java.io.IOException
    //   57	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	27	47	java/io/IOException
    //   3	17	57	finally
    //   21	27	57	finally
    //   27	31	57	finally
    //   31	43	57	finally
    //   48	54	57	finally
  }
  
  public static void fMv()
  {
    AppMethodBeat.i(154578);
    XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    fMu();
    c.fLZ().e(null);
    AppMethodBeat.o(154578);
  }
  
  static void fMw()
  {
    AppMethodBeat.i(208966);
    if (zg(true))
    {
      XWalkEnvironment.addXWalkInitializeLog("try update after config ");
      if (fMs())
      {
        AppMethodBeat.o(208966);
        return;
      }
      com.tencent.xweb.util.g.az(903L, 160L);
      com.tencent.xweb.xwalk.c localc = ah.fJQ();
      if (localc != null) {
        localc.bvD();
      }
      f(c.fLZ().fMm());
    }
    AppMethodBeat.o(208966);
  }
  
  private static boolean zg(boolean paramBoolean)
  {
    AppMethodBeat.i(208965);
    if (c.fLZ().zf(paramBoolean))
    {
      XWalkInitializer.addXWalkInitializeLog("time to update");
      AppMethodBeat.o(208965);
      return true;
    }
    AppMethodBeat.o(208965);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.f
 * JD-Core Version:    0.7.0.1
 */