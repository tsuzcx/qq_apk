package com.tencent.smtt.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.q;
import java.io.File;
import java.io.IOException;

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
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new TbsExtensionFunctionManager();
      }
      return b;
    }
    finally {}
  }
  
  /* Error */
  public boolean canUseFunction(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 56	java/io/File
    //   5: dup
    //   6: aload_1
    //   7: invokevirtual 62	android/content/Context:getFilesDir	()Ljava/io/File;
    //   10: aload_2
    //   11: invokespecial 65	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: invokevirtual 69	java/io/File:exists	()Z
    //   19: ifeq +18 -> 37
    //   22: aload_1
    //   23: invokevirtual 72	java/io/File:isFile	()Z
    //   26: istore_3
    //   27: iload_3
    //   28: ifeq +9 -> 37
    //   31: iconst_1
    //   32: istore_3
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_3
    //   36: ireturn
    //   37: iconst_0
    //   38: istore_3
    //   39: goto -6 -> 33
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	TbsExtensionFunctionManager
    //   0	47	1	paramContext	Context
    //   0	47	2	paramString	String
    //   26	13	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	27	42	finally
  }
  
  /* Error */
  public int getRomCookieDBVersion(Context paramContext)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: getstatic 79	android/os/Build$VERSION:SDK_INT	I
    //   7: bipush 11
    //   9: if_icmplt +19 -> 28
    //   12: aload_1
    //   13: ldc 26
    //   15: iconst_4
    //   16: invokevirtual 83	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnonnull +18 -> 39
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_2
    //   27: ireturn
    //   28: aload_1
    //   29: ldc 26
    //   31: iconst_0
    //   32: invokevirtual 83	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   35: astore_1
    //   36: goto -16 -> 20
    //   39: aload_1
    //   40: ldc 23
    //   42: iconst_m1
    //   43: invokeinterface 89 3 0
    //   48: istore_2
    //   49: goto -25 -> 24
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	TbsExtensionFunctionManager
    //   0	57	1	paramContext	Context
    //   1	48	2	i	int
    // Exception table:
    //   from	to	target	type
    //   4	20	52	finally
    //   28	36	52	finally
    //   39	49	52	finally
  }
  
  public void initTbsBuglyIfNeed(Context paramContext)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.a;
        if (bool) {
          return;
        }
        if (!canUseFunction(paramContext, "bugly_switch.txt"))
        {
          TbsLog.i("TbsExtensionFunMana", "bugly is forbiden!!");
          continue;
        }
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {}
      }
      finally {}
      for (Object localObject1 = TbsShareManager.c(paramContext);; localObject1 = ((File)localObject1).getAbsolutePath())
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label130;
        }
        TbsLog.i("TbsExtensionFunMana", "bugly init ,corePath is null");
        break;
        localObject1 = an.a().r(paramContext);
        if (localObject1 == null) {
          TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is null");
        }
        if ((((File)localObject1).listFiles() == null) || (((File)localObject1).listFiles().length <= 0))
        {
          TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is empty!");
          break;
        }
      }
      label130:
      Object localObject3 = an.a().r(paramContext);
      if (localObject3 == null)
      {
        TbsLog.i("TbsExtensionFunMana", "bugly init ,optDir is null");
      }
      else
      {
        Object localObject4 = new File((String)localObject1, "tbs_bugly_dex.jar");
        try
        {
          Object localObject2 = ((File)localObject4).getParent();
          localObject4 = ((File)localObject4).getAbsolutePath();
          localObject3 = ((File)localObject3).getAbsolutePath();
          localObject2 = new DexLoader((String)localObject2, paramContext, new String[] { localObject4 }, (String)localObject3, null).loadClass("com.tencent.smtt.tbs.bugly.TBSBuglyManager");
          int i = WebView.getTbsSDKVersion(paramContext);
          int j = WebView.getTbsCoreVersion(paramContext);
          q.a((Class)localObject2, "initBugly", new Class[] { Context.class, String.class, String.class, String.class }, new Object[] { paramContext, localObject1, String.valueOf(i), String.valueOf(j) });
          this.a = true;
          TbsLog.i("TbsExtensionFunMana", "initTbsBuglyIfNeed success!");
        }
        catch (Throwable paramContext)
        {
          TbsLog.i("TbsExtensionFunMana", "bugly init ,try init bugly failed(need new core):" + Log.getStackTraceString(paramContext));
        }
      }
    }
  }
  
  public boolean setFunctionEnable(Context paramContext, String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramContext == null) {
      paramBoolean = bool;
    }
    for (;;)
    {
      return paramBoolean;
      try
      {
        paramContext = new File(paramContext.getFilesDir(), paramString);
        if (paramBoolean)
        {
          paramBoolean = paramContext.exists();
          if (paramBoolean) {
            break label135;
          }
          try
          {
            paramBoolean = paramContext.createNewFile();
            if (!paramBoolean) {
              break label135;
            }
            paramBoolean = true;
          }
          catch (IOException paramContext)
          {
            TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,createNewFile fail:" + paramString);
            paramBoolean = bool;
          }
          continue;
        }
      }
      finally {}
      if (paramContext.exists())
      {
        if (paramContext.delete())
        {
          paramBoolean = true;
        }
        else
        {
          TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,file.delete fail:" + paramString);
          paramBoolean = bool;
        }
      }
      else {
        label135:
        paramBoolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsExtensionFunctionManager
 * JD-Core Version:    0.7.0.1
 */