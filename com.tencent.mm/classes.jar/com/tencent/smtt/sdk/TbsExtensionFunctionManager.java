package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
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
  
  /* Error */
  public void initTbsBuglyIfNeed(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 104
    //   4: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 106	com/tencent/smtt/sdk/TbsExtensionFunctionManager:a	Z
    //   11: ifeq +11 -> 22
    //   14: ldc 104
    //   16: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: aload_1
    //   24: ldc 8
    //   26: invokevirtual 108	com/tencent/smtt/sdk/TbsExtensionFunctionManager:canUseFunction	(Landroid/content/Context;Ljava/lang/String;)Z
    //   29: ifne +23 -> 52
    //   32: ldc 110
    //   34: ldc 112
    //   36: invokestatic 117	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: ldc 104
    //   41: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -25 -> 19
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    //   52: aload_1
    //   53: invokestatic 123	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   56: ifeq +32 -> 88
    //   59: aload_1
    //   60: invokestatic 127	com/tencent/smtt/sdk/TbsShareManager:c	(Landroid/content/Context;)Ljava/lang/String;
    //   63: astore 4
    //   65: aload 4
    //   67: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   70: ifeq +81 -> 151
    //   73: ldc 110
    //   75: ldc 135
    //   77: invokestatic 117	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: ldc 104
    //   82: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: goto -66 -> 19
    //   88: invokestatic 140	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   91: aload_1
    //   92: invokevirtual 144	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   95: astore 4
    //   97: aload 4
    //   99: ifnonnull +10 -> 109
    //   102: ldc 110
    //   104: ldc 146
    //   106: invokestatic 117	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload 4
    //   111: invokevirtual 150	java/io/File:listFiles	()[Ljava/io/File;
    //   114: ifnull +12 -> 126
    //   117: aload 4
    //   119: invokevirtual 150	java/io/File:listFiles	()[Ljava/io/File;
    //   122: arraylength
    //   123: ifgt +18 -> 141
    //   126: ldc 110
    //   128: ldc 152
    //   130: invokestatic 117	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: ldc 104
    //   135: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: goto -119 -> 19
    //   141: aload 4
    //   143: invokevirtual 156	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   146: astore 4
    //   148: goto -83 -> 65
    //   151: invokestatic 140	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   154: aload_1
    //   155: invokevirtual 144	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   158: astore 7
    //   160: aload 7
    //   162: ifnonnull +18 -> 180
    //   165: ldc 110
    //   167: ldc 158
    //   169: invokestatic 117	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: ldc 104
    //   174: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: goto -158 -> 19
    //   180: new 67	java/io/File
    //   183: dup
    //   184: aload 4
    //   186: ldc 160
    //   188: invokespecial 162	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: astore 6
    //   193: ldc 110
    //   195: new 164	java/lang/StringBuilder
    //   198: dup
    //   199: ldc 166
    //   201: invokespecial 169	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   204: aload 7
    //   206: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   209: ldc 175
    //   211: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 4
    //   216: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc 180
    //   221: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload 6
    //   226: invokevirtual 156	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   229: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 186	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload 6
    //   240: invokevirtual 189	java/io/File:getParent	()Ljava/lang/String;
    //   243: astore 5
    //   245: aload 6
    //   247: invokevirtual 156	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   250: astore 6
    //   252: aload 7
    //   254: invokevirtual 156	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   257: astore 7
    //   259: invokestatic 195	com/tencent/smtt/sdk/QbSdk:getSettings	()Ljava/util/Map;
    //   262: astore 8
    //   264: new 197	com/tencent/smtt/export/external/DexLoader
    //   267: dup
    //   268: aload 5
    //   270: aload_1
    //   271: iconst_1
    //   272: anewarray 199	java/lang/String
    //   275: dup
    //   276: iconst_0
    //   277: aload 6
    //   279: aastore
    //   280: aload 7
    //   282: aload 8
    //   284: invokespecial 202	com/tencent/smtt/export/external/DexLoader:<init>	(Ljava/lang/String;Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   287: ldc 204
    //   289: invokevirtual 208	com/tencent/smtt/export/external/DexLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   292: astore 5
    //   294: aload_1
    //   295: invokestatic 213	com/tencent/smtt/sdk/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   298: istore_2
    //   299: aload_1
    //   300: invokestatic 216	com/tencent/smtt/sdk/WebView:getTbsCoreVersion	(Landroid/content/Context;)I
    //   303: istore_3
    //   304: aload 5
    //   306: ldc 218
    //   308: iconst_4
    //   309: anewarray 220	java/lang/Class
    //   312: dup
    //   313: iconst_0
    //   314: ldc 69
    //   316: aastore
    //   317: dup
    //   318: iconst_1
    //   319: ldc 199
    //   321: aastore
    //   322: dup
    //   323: iconst_2
    //   324: ldc 199
    //   326: aastore
    //   327: dup
    //   328: iconst_3
    //   329: ldc 199
    //   331: aastore
    //   332: iconst_4
    //   333: anewarray 4	java/lang/Object
    //   336: dup
    //   337: iconst_0
    //   338: aload_1
    //   339: aastore
    //   340: dup
    //   341: iconst_1
    //   342: aload 4
    //   344: aastore
    //   345: dup
    //   346: iconst_2
    //   347: iload_2
    //   348: invokestatic 224	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   351: aastore
    //   352: dup
    //   353: iconst_3
    //   354: iload_3
    //   355: invokestatic 224	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   358: aastore
    //   359: invokestatic 229	com/tencent/smtt/utils/k:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   362: pop
    //   363: aload_0
    //   364: iconst_1
    //   365: putfield 106	com/tencent/smtt/sdk/TbsExtensionFunctionManager:a	Z
    //   368: ldc 110
    //   370: ldc 231
    //   372: invokestatic 117	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: ldc 104
    //   377: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   380: goto -361 -> 19
    //   383: astore_1
    //   384: ldc 110
    //   386: new 164	java/lang/StringBuilder
    //   389: dup
    //   390: ldc 233
    //   392: invokespecial 169	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   395: aload_1
    //   396: invokestatic 239	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   399: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 117	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: ldc 104
    //   410: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   413: goto -394 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	this	TbsExtensionFunctionManager
    //   0	416	1	paramContext	Context
    //   298	50	2	i	int
    //   303	52	3	j	int
    //   63	280	4	localObject1	Object
    //   243	62	5	localObject2	Object
    //   191	87	6	localObject3	Object
    //   158	123	7	localObject4	Object
    //   262	21	8	localMap	java.util.Map
    // Exception table:
    //   from	to	target	type
    //   2	19	47	finally
    //   22	44	47	finally
    //   52	65	47	finally
    //   65	85	47	finally
    //   88	97	47	finally
    //   102	109	47	finally
    //   109	126	47	finally
    //   126	138	47	finally
    //   141	148	47	finally
    //   151	160	47	finally
    //   165	177	47	finally
    //   180	238	47	finally
    //   363	380	47	finally
    //   384	413	47	finally
    //   238	363	383	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsExtensionFunctionManager
 * JD-Core Version:    0.7.0.1
 */