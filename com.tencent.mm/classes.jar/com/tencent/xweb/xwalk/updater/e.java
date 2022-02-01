package com.tencent.xweb.xwalk.updater;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.af;
import com.tencent.xweb.util.c;
import com.tencent.xweb.util.g;
import com.tencent.xweb.xwalk.o;
import java.nio.channels.FileLock;
import java.util.HashMap;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.ErrorInfo;

public final class e
  extends AsyncTask<String, Integer, Integer>
{
  static XWalkUpdater IUw;
  private static String IVX = "0";
  static boolean IVY = false;
  static FileLock IVZ = null;
  private HashMap<String, String> IVW;
  
  public e(XWalkUpdater paramXWalkUpdater, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(154573);
    IUw = paramXWalkUpdater;
    this.IVW = paramHashMap;
    if (paramHashMap != null)
    {
      paramXWalkUpdater = (String)paramHashMap.get("UpdaterCheckType");
      IVX = paramXWalkUpdater;
      if ((paramXWalkUpdater == null) || (!IVX.equals("1"))) {
        break label84;
      }
      Scheduler.fts().fty();
    }
    for (;;)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdateChecker notify received !! mNotifyType = " + IVX);
      AppMethodBeat.o(154573);
      return;
      label84:
      if ((IVX != null) && (IVX.equals("2")))
      {
        Scheduler.fts().fty();
        g.xs(93L);
      }
      else if ((IVX != null) && (IVX.equals("3")))
      {
        Scheduler.ftC().IVs = true;
        g.xs(94L);
      }
      else
      {
        IVX = "0";
      }
    }
  }
  
  public static void adv(int paramInt)
  {
    AppMethodBeat.i(204024);
    ftJ();
    Scheduler.adv(paramInt);
    AppMethodBeat.o(204024);
  }
  
  private static boolean b(Scheduler.SchedulerConfig paramSchedulerConfig)
  {
    AppMethodBeat.i(154574);
    if (ftH())
    {
      AppMethodBeat.o(154574);
      return false;
    }
    XWalkUpdater.ErrorInfo localErrorInfo;
    if (!XWalkEnvironment.isSelfProvider())
    {
      ftI();
      localErrorInfo = IUw.updateRuntimeFromProvider(paramSchedulerConfig);
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
          break label269;
        }
        int i = localErrorInfo.errorCode;
        ftJ();
        Scheduler.adv(i);
        AppMethodBeat.o(154574);
        return false;
        ftJ();
      }
      if (localErrorInfo.errorCode == 0)
      {
        ftK();
        AppMethodBeat.o(154574);
        return true;
      }
    }
    label269:
    XWalkInitializer.addXWalkInitializeLog("_doStartUpdate go on");
    if (!NetworkUtil.isNetworkAvailable())
    {
      paramSchedulerConfig = af.fro();
      if (paramSchedulerConfig != null) {
        paramSchedulerConfig.boJ();
      }
      AppMethodBeat.o(154574);
      return false;
    }
    if ((!paramSchedulerConfig.IVs) && (!NetworkUtil.isWifiAvailable()))
    {
      XWalkInitializer.addXWalkInitializeLog("current network is not wifi , this scheduler not support mobile data");
      paramSchedulerConfig = af.fro();
      if (paramSchedulerConfig != null) {
        paramSchedulerConfig.boJ();
      }
      AppMethodBeat.o(154574);
      return false;
    }
    if (IUw.updateXWalkRuntime(paramSchedulerConfig.ftG()))
    {
      ftI();
      AppMethodBeat.o(154574);
      return true;
    }
    AppMethodBeat.o(154574);
    return false;
  }
  
  /* Error */
  public static boolean ftH()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 253
    //   7: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: getstatic 26	com/tencent/xweb/xwalk/updater/e:IVY	Z
    //   13: ifeq +18 -> 31
    //   16: ldc 255
    //   18: invokestatic 89	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   21: ldc 253
    //   23: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: ldc 2
    //   28: monitorexit
    //   29: iload_0
    //   30: ireturn
    //   31: aconst_null
    //   32: astore_2
    //   33: aconst_null
    //   34: astore_1
    //   35: ldc_w 257
    //   38: invokestatic 263	com/tencent/xweb/util/c:aPr	(Ljava/lang/String;)Ljava/nio/channels/FileLock;
    //   41: astore_3
    //   42: aload_3
    //   43: ifnonnull +65 -> 108
    //   46: aload_3
    //   47: astore_1
    //   48: aload_3
    //   49: astore_2
    //   50: ldc_w 265
    //   53: invokestatic 89	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   56: aload_3
    //   57: ifnull +7 -> 64
    //   60: aload_3
    //   61: invokevirtual 270	java/nio/channels/FileLock:release	()V
    //   64: ldc 253
    //   66: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: goto -43 -> 26
    //   72: astore_1
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    //   78: astore_1
    //   79: ldc_w 272
    //   82: new 71	java/lang/StringBuilder
    //   85: dup
    //   86: ldc_w 274
    //   89: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: aload_1
    //   93: invokevirtual 277	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   96: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 279	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: goto -41 -> 64
    //   108: aload_3
    //   109: astore_1
    //   110: aload_3
    //   111: astore_2
    //   112: aload_3
    //   113: invokevirtual 282	java/nio/channels/FileLock:isValid	()Z
    //   116: ifne +59 -> 175
    //   119: aload_3
    //   120: astore_1
    //   121: aload_3
    //   122: astore_2
    //   123: ldc_w 284
    //   126: invokestatic 89	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   129: aload_3
    //   130: ifnull +7 -> 137
    //   133: aload_3
    //   134: invokevirtual 270	java/nio/channels/FileLock:release	()V
    //   137: ldc 253
    //   139: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: goto -116 -> 26
    //   145: astore_1
    //   146: ldc_w 272
    //   149: new 71	java/lang/StringBuilder
    //   152: dup
    //   153: ldc_w 274
    //   156: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   159: aload_1
    //   160: invokevirtual 277	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   163: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 279	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: goto -35 -> 137
    //   175: aload_3
    //   176: ifnull +7 -> 183
    //   179: aload_3
    //   180: invokevirtual 270	java/nio/channels/FileLock:release	()V
    //   183: iconst_0
    //   184: istore_0
    //   185: ldc 253
    //   187: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: goto -164 -> 26
    //   193: astore_1
    //   194: ldc_w 272
    //   197: new 71	java/lang/StringBuilder
    //   200: dup
    //   201: ldc_w 274
    //   204: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   207: aload_1
    //   208: invokevirtual 277	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   211: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 279	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: goto -37 -> 183
    //   223: astore_3
    //   224: aload_1
    //   225: astore_2
    //   226: ldc_w 272
    //   229: new 71	java/lang/StringBuilder
    //   232: dup
    //   233: ldc_w 286
    //   236: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   239: aload_3
    //   240: invokevirtual 277	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   243: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 279	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload_1
    //   253: ifnull -70 -> 183
    //   256: aload_1
    //   257: invokevirtual 270	java/nio/channels/FileLock:release	()V
    //   260: goto -77 -> 183
    //   263: astore_1
    //   264: ldc_w 272
    //   267: new 71	java/lang/StringBuilder
    //   270: dup
    //   271: ldc_w 274
    //   274: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   277: aload_1
    //   278: invokevirtual 277	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   281: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 279	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: goto -107 -> 183
    //   293: astore_1
    //   294: aload_2
    //   295: ifnull +7 -> 302
    //   298: aload_2
    //   299: invokevirtual 270	java/nio/channels/FileLock:release	()V
    //   302: ldc 253
    //   304: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: aload_1
    //   308: athrow
    //   309: astore_2
    //   310: ldc_w 272
    //   313: new 71	java/lang/StringBuilder
    //   316: dup
    //   317: ldc_w 274
    //   320: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   323: aload_2
    //   324: invokevirtual 277	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   327: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 279	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   336: goto -34 -> 302
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	184	0	bool	boolean
    //   34	14	1	localObject1	Object
    //   72	5	1	localObject2	Object
    //   78	15	1	localException1	Exception
    //   109	12	1	localObject3	Object
    //   145	15	1	localException2	Exception
    //   193	64	1	localException3	Exception
    //   263	15	1	localException4	Exception
    //   293	15	1	localObject4	Object
    //   32	267	2	localObject5	Object
    //   309	15	2	localException5	Exception
    //   41	139	3	localFileLock	FileLock
    //   223	17	3	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   5	26	72	finally
    //   60	64	72	finally
    //   64	69	72	finally
    //   79	105	72	finally
    //   133	137	72	finally
    //   137	142	72	finally
    //   146	172	72	finally
    //   179	183	72	finally
    //   185	190	72	finally
    //   194	220	72	finally
    //   256	260	72	finally
    //   264	290	72	finally
    //   298	302	72	finally
    //   302	309	72	finally
    //   310	336	72	finally
    //   60	64	78	java/lang/Exception
    //   133	137	145	java/lang/Exception
    //   179	183	193	java/lang/Exception
    //   35	42	223	java/lang/Exception
    //   50	56	223	java/lang/Exception
    //   112	119	223	java/lang/Exception
    //   123	129	223	java/lang/Exception
    //   256	260	263	java/lang/Exception
    //   35	42	293	finally
    //   50	56	293	finally
    //   112	119	293	finally
    //   123	129	293	finally
    //   226	252	293	finally
    //   298	302	309	java/lang/Exception
  }
  
  public static boolean ftI()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(194722);
        if (IVY)
        {
          XWalkInitializer.addXWalkInitializeLog("current process is in updating progress");
          AppMethodBeat.o(194722);
          return bool;
        }
        FileLock localFileLock = c.aPr("xweb_update.lock");
        if (localFileLock == null)
        {
          XWalkInitializer.addXWalkInitializeLog("other process is in updating progress");
          AppMethodBeat.o(194722);
          continue;
        }
        if (localObject.isValid()) {
          break label87;
        }
      }
      finally {}
      XWalkInitializer.addXWalkInitializeLog("other process is in updating progress filelock is not valid");
      AppMethodBeat.o(194722);
      continue;
      label87:
      IVZ = localObject;
      IVY = true;
      XWalkInitializer.addXWalkInitializeLog("start updating progress");
      AppMethodBeat.o(194722);
      bool = true;
    }
  }
  
  /* Error */
  public static void ftJ()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 294
    //   6: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: iconst_0
    //   10: putstatic 26	com/tencent/xweb/xwalk/updater/e:IVY	Z
    //   13: getstatic 28	com/tencent/xweb/xwalk/updater/e:IVZ	Ljava/nio/channels/FileLock;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +13 -> 31
    //   21: getstatic 28	com/tencent/xweb/xwalk/updater/e:IVZ	Ljava/nio/channels/FileLock;
    //   24: invokevirtual 270	java/nio/channels/FileLock:release	()V
    //   27: aconst_null
    //   28: putstatic 28	com/tencent/xweb/xwalk/updater/e:IVZ	Ljava/nio/channels/FileLock;
    //   31: ldc_w 296
    //   34: invokestatic 89	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   37: ldc_w 294
    //   40: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: ldc 2
    //   45: monitorexit
    //   46: return
    //   47: astore_0
    //   48: ldc_w 298
    //   51: invokestatic 89	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
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
  
  public static void ftK()
  {
    AppMethodBeat.i(154578);
    XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    ftJ();
    Scheduler.a(null);
    AppMethodBeat.o(154578);
  }
  
  static void ftL()
  {
    AppMethodBeat.i(194725);
    if (xO(true))
    {
      XWalkEnvironment.addXWalkInitializeLog("try update after config ");
      if (ftH())
      {
        AppMethodBeat.o(194725);
        return;
      }
      g.az(903L, 160L);
      com.tencent.xweb.xwalk.b localb = af.fro();
      if (localb != null) {
        localb.boI();
      }
      b(Scheduler.ftC());
    }
    AppMethodBeat.o(194725);
  }
  
  private static boolean xO(boolean paramBoolean)
  {
    AppMethodBeat.i(194724);
    if (Scheduler.fts().xM(paramBoolean))
    {
      XWalkInitializer.addXWalkInitializeLog("time to update");
      AppMethodBeat.o(194724);
      return true;
    }
    AppMethodBeat.o(194724);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.e
 * JD-Core Version:    0.7.0.1
 */