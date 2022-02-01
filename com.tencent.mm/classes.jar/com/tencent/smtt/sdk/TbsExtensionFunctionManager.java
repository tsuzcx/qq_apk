package com.tencent.smtt.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class TbsExtensionFunctionManager
{
  public static final String BUGLY_SWITCH_FILE_NAME = "bugly_switch.txt";
  public static final String COOKIE_SWITCH_FILE_NAME = "cookie_switch.txt";
  public static final String DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME = "disable_get_apk_version_switch.txt";
  public static final String DISABLE_UNPREINIT = "disable_unpreinit.txt";
  public static final String DISABLE_USE_HOST_BACKUP_CORE = "disable_use_host_backup_core.txt";
  public static final String SP_KEY_COOKIE_DB_VERSION = "cookie_db_version";
  public static final String SP_NAME_FOR_COOKIE = "cookie_compatiable";
  public static final int SWITCH_BYTE_COOKIE = 1;
  public static final int SWITCH_BYTE_DISABLE_GET_APK_VERSION = 2;
  public static final int SWITCH_BYTE_DISABLE_UNPREINIT = 4;
  public static final int SWITCH_BYTE_DISABLE_USE_HOST_BACKUPCORE = 8;
  public static final String USEX5_FILE_NAME = "usex5.txt";
  private static TbsExtensionFunctionManager b;
  private boolean a;
  
  public static TbsExtensionFunctionManager getInstance()
  {
    AppMethodBeat.i(54674);
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new TbsExtensionFunctionManager();
      }
      TbsExtensionFunctionManager localTbsExtensionFunctionManager = b;
      AppMethodBeat.o(54674);
      return localTbsExtensionFunctionManager;
    }
    finally
    {
      AppMethodBeat.o(54674);
    }
  }
  
  /* Error */
  public boolean canUseFunction(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 65
    //   4: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 67	java/io/File
    //   10: dup
    //   11: aload_1
    //   12: invokevirtual 73	android/content/Context:getFilesDir	()Ljava/io/File;
    //   15: aload_2
    //   16: invokespecial 76	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   19: astore_1
    //   20: aload_1
    //   21: invokevirtual 80	java/io/File:exists	()Z
    //   24: ifeq +21 -> 45
    //   27: aload_1
    //   28: invokevirtual 83	java/io/File:isFile	()Z
    //   31: ifeq +14 -> 45
    //   34: iconst_1
    //   35: istore_3
    //   36: ldc 65
    //   38: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aload_0
    //   42: monitorexit
    //   43: iload_3
    //   44: ireturn
    //   45: iconst_0
    //   46: istore_3
    //   47: ldc 65
    //   49: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -11 -> 41
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	TbsExtensionFunctionManager
    //   0	60	1	paramContext	Context
    //   0	60	2	paramString	String
    //   35	12	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	34	55	finally
    //   36	41	55	finally
    //   47	52	55	finally
  }
  
  /* Error */
  public int getRomCookieDBVersion(Context paramContext)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 86
    //   6: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 91	android/os/Build$VERSION:SDK_INT	I
    //   12: bipush 11
    //   14: if_icmplt +24 -> 38
    //   17: aload_1
    //   18: ldc 26
    //   20: iconst_4
    //   21: invokevirtual 95	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnonnull +23 -> 49
    //   29: ldc 86
    //   31: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_2
    //   37: ireturn
    //   38: aload_1
    //   39: ldc 26
    //   41: iconst_0
    //   42: invokevirtual 95	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   45: astore_1
    //   46: goto -21 -> 25
    //   49: aload_1
    //   50: ldc 23
    //   52: iconst_m1
    //   53: invokeinterface 101 3 0
    //   58: istore_2
    //   59: ldc 86
    //   61: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: goto -30 -> 34
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	TbsExtensionFunctionManager
    //   0	72	1	paramContext	Context
    //   1	58	2	i	int
    // Exception table:
    //   from	to	target	type
    //   4	25	67	finally
    //   29	34	67	finally
    //   38	46	67	finally
    //   49	64	67	finally
  }
  
  public void initTbsBuglyIfNeed(Context paramContext)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54675);
        if (this.a)
        {
          AppMethodBeat.o(54675);
          return;
        }
        if (!canUseFunction(paramContext, "bugly_switch.txt"))
        {
          TbsLog.i("TbsExtensionFunMana", "bugly is forbiden!!");
          AppMethodBeat.o(54675);
          continue;
        }
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {}
      }
      finally {}
      for (Object localObject1 = TbsShareManager.c(paramContext);; localObject1 = ((File)localObject1).getAbsolutePath())
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label151;
        }
        TbsLog.i("TbsExtensionFunMana", "bugly init ,corePath is null");
        AppMethodBeat.o(54675);
        break;
        localObject1 = q.a().r(paramContext);
        if (localObject1 == null) {
          TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is null");
        }
        if ((((File)localObject1).listFiles() == null) || (((File)localObject1).listFiles().length <= 0))
        {
          TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is empty!");
          AppMethodBeat.o(54675);
          break;
        }
      }
      label151:
      Object localObject4 = q.a().r(paramContext);
      if (localObject4 == null)
      {
        TbsLog.i("TbsExtensionFunMana", "bugly init ,optDir is null");
        AppMethodBeat.o(54675);
      }
      else
      {
        Object localObject3 = new File((String)localObject1, "tbs_bugly_dex.jar");
        TbsLog.d("TbsExtensionFunMana", "optDir:" + localObject4 + ",tbsCorePath:" + (String)localObject1 + ",dexFile:" + ((File)localObject3).getAbsolutePath());
        try
        {
          Object localObject2 = ((File)localObject3).getParent();
          localObject3 = ((File)localObject3).getAbsolutePath();
          localObject4 = ((File)localObject4).getAbsolutePath();
          Map localMap = QbSdk.getSettings();
          localObject2 = new DexLoader((String)localObject2, paramContext, new String[] { localObject3 }, (String)localObject4, localMap).loadClass("com.tencent.smtt.tbs.bugly.TBSBuglyManager");
          int i = WebView.getTbsSDKVersion(paramContext);
          int j = WebView.getTbsCoreVersion(paramContext);
          k.a((Class)localObject2, "initBugly", new Class[] { Context.class, String.class, String.class, String.class }, new Object[] { paramContext, localObject1, String.valueOf(i), String.valueOf(j) });
          this.a = true;
          TbsLog.i("TbsExtensionFunMana", "initTbsBuglyIfNeed success!");
          AppMethodBeat.o(54675);
        }
        catch (Throwable paramContext)
        {
          TbsLog.i("TbsExtensionFunMana", "bugly init ,try init bugly failed(need new core):" + Log.getStackTraceString(paramContext));
          AppMethodBeat.o(54675);
        }
      }
    }
  }
  
  public boolean setFunctionEnable(Context paramContext, String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54676);
        if (paramContext == null)
        {
          AppMethodBeat.o(54676);
          paramBoolean = bool;
          return paramBoolean;
        }
        paramContext = new File(paramContext.getFilesDir(), paramString);
        TbsLog.d("TbsExtensionFunMana", paramContext.getAbsolutePath());
        if (paramBoolean)
        {
          paramBoolean = paramContext.exists();
          if (paramBoolean) {
            break label161;
          }
          try
          {
            paramBoolean = paramContext.createNewFile();
            if (!paramBoolean) {
              break label161;
            }
            AppMethodBeat.o(54676);
            paramBoolean = true;
          }
          catch (IOException paramContext)
          {
            TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,createNewFile fail:".concat(String.valueOf(paramString)));
            AppMethodBeat.o(54676);
            paramBoolean = bool;
          }
          continue;
        }
        if (!paramContext.exists()) {
          break label161;
        }
      }
      finally {}
      if (paramContext.delete())
      {
        AppMethodBeat.o(54676);
        paramBoolean = true;
      }
      else
      {
        TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,file.delete fail:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(54676);
        paramBoolean = bool;
        continue;
        label161:
        AppMethodBeat.o(54676);
        paramBoolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsExtensionFunctionManager
 * JD-Core Version:    0.7.0.1
 */