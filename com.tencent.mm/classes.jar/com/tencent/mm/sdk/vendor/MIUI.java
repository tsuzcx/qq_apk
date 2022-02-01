package com.tencent.mm.sdk.vendor;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ag;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class MIUI
{
  private static final String TAG = "Vendor.MIUI";
  private static Boolean ifMIUI = null;
  private static Boolean ifNotificationChannelSupportNativeActionJump = null;
  private static Boolean isMIUI = null;
  private static Boolean isMIUIV10;
  private static Boolean isMIUIV8 = null;
  
  static
  {
    isMIUIV10 = null;
  }
  
  /* Error */
  public static String getSystemProperty(String paramString)
  {
    // Byte code:
    //   0: ldc 37
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 49	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   8: ldc 51
    //   10: aload_0
    //   11: invokestatic 57	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   14: invokevirtual 60	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   17: invokevirtual 64	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   20: astore_1
    //   21: aload_1
    //   22: ifnonnull +17 -> 39
    //   25: ldc 8
    //   27: ldc 66
    //   29: invokestatic 71	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: ldc 37
    //   34: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: areturn
    //   39: new 76	java/io/BufferedReader
    //   42: dup
    //   43: new 78	java/io/InputStreamReader
    //   46: dup
    //   47: aload_1
    //   48: invokevirtual 84	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   51: invokespecial 87	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   54: sipush 1024
    //   57: invokespecial 90	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   60: astore_2
    //   61: aload_2
    //   62: astore_1
    //   63: aload_2
    //   64: invokevirtual 94	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: astore_3
    //   68: aload_2
    //   69: astore_1
    //   70: aload_2
    //   71: invokevirtual 97	java/io/BufferedReader:close	()V
    //   74: aload_2
    //   75: invokevirtual 97	java/io/BufferedReader:close	()V
    //   78: ldc 37
    //   80: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_3
    //   84: areturn
    //   85: astore_0
    //   86: ldc 8
    //   88: ldc 99
    //   90: iconst_1
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_0
    //   97: invokevirtual 102	java/io/IOException:getMessage	()Ljava/lang/String;
    //   100: aastore
    //   101: invokestatic 105	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: goto -26 -> 78
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: astore_1
    //   112: ldc 8
    //   114: ldc 107
    //   116: iconst_2
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_0
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: aload_3
    //   127: invokevirtual 108	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   130: aastore
    //   131: invokestatic 105	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: aload_2
    //   135: ifnull +7 -> 142
    //   138: aload_2
    //   139: invokevirtual 97	java/io/BufferedReader:close	()V
    //   142: ldc 37
    //   144: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aconst_null
    //   148: areturn
    //   149: astore_0
    //   150: ldc 8
    //   152: ldc 99
    //   154: iconst_1
    //   155: anewarray 4	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_0
    //   161: invokevirtual 102	java/io/IOException:getMessage	()Ljava/lang/String;
    //   164: aastore
    //   165: invokestatic 105	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: goto -26 -> 142
    //   171: astore_0
    //   172: aconst_null
    //   173: astore_1
    //   174: aload_1
    //   175: ifnull +7 -> 182
    //   178: aload_1
    //   179: invokevirtual 97	java/io/BufferedReader:close	()V
    //   182: ldc 37
    //   184: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload_0
    //   188: athrow
    //   189: astore_1
    //   190: ldc 8
    //   192: ldc 99
    //   194: iconst_1
    //   195: anewarray 4	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: aload_1
    //   201: invokevirtual 102	java/io/IOException:getMessage	()Ljava/lang/String;
    //   204: aastore
    //   205: invokestatic 105	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: goto -26 -> 182
    //   211: astore_0
    //   212: goto -38 -> 174
    //   215: astore_3
    //   216: goto -106 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramString	String
    //   20	159	1	localObject	Object
    //   189	12	1	localIOException	java.io.IOException
    //   60	79	2	localBufferedReader	java.io.BufferedReader
    //   67	17	3	str	String
    //   107	20	3	localException1	java.lang.Exception
    //   215	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   74	78	85	java/io/IOException
    //   5	21	107	java/lang/Exception
    //   25	32	107	java/lang/Exception
    //   39	61	107	java/lang/Exception
    //   138	142	149	java/io/IOException
    //   5	21	171	finally
    //   25	32	171	finally
    //   39	61	171	finally
    //   178	182	189	java/io/IOException
    //   63	68	211	finally
    //   70	74	211	finally
    //   112	134	211	finally
    //   63	68	215	java/lang/Exception
    //   70	74	215	java/lang/Exception
  }
  
  public static boolean ifInMinAndMax(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(153479);
    boolean bool1;
    if (paramInt >= Integer.parseInt(paramString1))
    {
      if (!Util.isEqual(paramString2, "")) {
        break label57;
      }
      bool1 = bool2;
      if (ifMIUI())
      {
        bool1 = bool2;
        if (ifLessThanVersinCode(paramString3)) {}
      }
    }
    else
    {
      bool1 = false;
    }
    for (;;)
    {
      AppMethodBeat.o(153479);
      return bool1;
      label57:
      bool1 = bool2;
      if (paramInt > Integer.parseInt(paramString2)) {
        bool1 = false;
      }
    }
  }
  
  public static boolean ifLessThanVersinCode(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(243221);
    String str = getSystemProperty("ro.miui.version.code_time");
    if (Util.isNullOrNil(paramString)) {}
    for (;;)
    {
      AppMethodBeat.o(243221);
      return bool;
      if (Long.valueOf(str).longValue() >= Long.valueOf(paramString).longValue()) {
        bool = false;
      }
    }
  }
  
  public static boolean ifMIUI()
  {
    AppMethodBeat.i(153477);
    if (ifMIUI == null)
    {
      String str = Build.MANUFACTURER;
      Log.i("Vendor.MIUI", "Build.MANUFACTURER = %s", new Object[] { str });
      if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase("Xiaomi"))) {
        break label66;
      }
    }
    label66:
    for (ifMIUI = Boolean.TRUE;; ifMIUI = Boolean.FALSE)
    {
      boolean bool = ifMIUI.booleanValue();
      AppMethodBeat.o(153477);
      return bool;
    }
  }
  
  public static boolean ifNotificationChannelSupportNativeActionJump()
  {
    AppMethodBeat.i(153478);
    if (ifNotificationChannelSupportNativeActionJump == null)
    {
      String str = Build.MANUFACTURER;
      Log.i("Vendor.MIUI", "Build.MANUFACTURER = %s, Build.MODEL ", new Object[] { str });
      if ((TextUtils.isEmpty(str)) || (!str.equals("Xiaomi"))) {
        break label138;
      }
      str = getSystemProperty("ro.miui.version.code_time");
      Log.w("Vendor.MIUI", "ifNotificationChannelSupportNativeActionJump() versionCode:%s", new Object[] { str });
      if (Long.valueOf(str).longValue() <= Long.valueOf("1536681600").longValue()) {
        break label129;
      }
      ifNotificationChannelSupportNativeActionJump = Boolean.TRUE;
    }
    for (;;)
    {
      Log.i("Vendor.MIUI", "ifNotificationChannelSupportNativeActionJump() ifNotificationChannelSupportNativeActionJump:%s", new Object[] { Boolean.valueOf(ifNotificationChannelSupportNativeActionJump.booleanValue()) });
      boolean bool = ifNotificationChannelSupportNativeActionJump.booleanValue();
      AppMethodBeat.o(153478);
      return bool;
      label129:
      ifNotificationChannelSupportNativeActionJump = Boolean.FALSE;
      continue;
      label138:
      ifNotificationChannelSupportNativeActionJump = Boolean.FALSE;
    }
  }
  
  /* Error */
  public static boolean isMIUI()
  {
    // Byte code:
    //   0: ldc 199
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 18	com/tencent/mm/sdk/vendor/MIUI:isMIUI	Ljava/lang/Boolean;
    //   8: ifnonnull +71 -> 79
    //   11: aconst_null
    //   12: astore_2
    //   13: aconst_null
    //   14: astore_1
    //   15: new 201	com/tencent/mm/vfs/u
    //   18: dup
    //   19: invokestatic 207	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   22: ldc 209
    //   24: invokespecial 212	com/tencent/mm/vfs/u:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: invokestatic 218	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   30: astore_3
    //   31: aload_3
    //   32: astore_1
    //   33: aload_3
    //   34: astore_2
    //   35: new 220	java/util/Properties
    //   38: dup
    //   39: invokespecial 221	java/util/Properties:<init>	()V
    //   42: astore 4
    //   44: aload_3
    //   45: astore_1
    //   46: aload_3
    //   47: astore_2
    //   48: aload 4
    //   50: aload_3
    //   51: invokevirtual 224	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   54: aload_3
    //   55: astore_1
    //   56: aload_3
    //   57: astore_2
    //   58: aload 4
    //   60: ldc 226
    //   62: invokevirtual 229	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   65: invokestatic 198	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   68: putstatic 18	com/tencent/mm/sdk/vendor/MIUI:isMIUI	Ljava/lang/Boolean;
    //   71: aload_3
    //   72: ifnull +7 -> 79
    //   75: aload_3
    //   76: invokevirtual 232	java/io/InputStream:close	()V
    //   79: getstatic 18	com/tencent/mm/sdk/vendor/MIUI:isMIUI	Ljava/lang/Boolean;
    //   82: invokevirtual 176	java/lang/Boolean:booleanValue	()Z
    //   85: istore_0
    //   86: ldc 199
    //   88: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: iload_0
    //   92: ireturn
    //   93: astore_3
    //   94: aload_1
    //   95: astore_2
    //   96: ldc 8
    //   98: ldc 234
    //   100: iconst_1
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_3
    //   107: aastore
    //   108: invokestatic 237	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_1
    //   112: astore_2
    //   113: getstatic 179	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   116: putstatic 18	com/tencent/mm/sdk/vendor/MIUI:isMIUI	Ljava/lang/Boolean;
    //   119: aload_1
    //   120: ifnull -41 -> 79
    //   123: aload_1
    //   124: invokevirtual 232	java/io/InputStream:close	()V
    //   127: goto -48 -> 79
    //   130: astore_1
    //   131: goto -52 -> 79
    //   134: astore_1
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 232	java/io/InputStream:close	()V
    //   143: ldc 199
    //   145: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: aload_1
    //   149: athrow
    //   150: astore_1
    //   151: goto -72 -> 79
    //   154: astore_2
    //   155: goto -12 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   85	7	0	bool	boolean
    //   14	110	1	localObject1	Object
    //   130	1	1	localException1	java.lang.Exception
    //   134	15	1	localObject2	Object
    //   150	1	1	localException2	java.lang.Exception
    //   12	128	2	localObject3	Object
    //   154	1	2	localException3	java.lang.Exception
    //   30	46	3	localInputStream	java.io.InputStream
    //   93	14	3	localException4	java.lang.Exception
    //   42	17	4	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   15	31	93	java/lang/Exception
    //   35	44	93	java/lang/Exception
    //   48	54	93	java/lang/Exception
    //   58	71	93	java/lang/Exception
    //   123	127	130	java/lang/Exception
    //   15	31	134	finally
    //   35	44	134	finally
    //   48	54	134	finally
    //   58	71	134	finally
    //   96	111	134	finally
    //   113	119	134	finally
    //   75	79	150	java/lang/Exception
    //   139	143	154	java/lang/Exception
  }
  
  public static boolean isMIUI10()
  {
    AppMethodBeat.i(153476);
    if (isMIUIV10 == null)
    {
      String str = Build.MANUFACTURER;
      Log.i("Vendor.MIUI", "Build.MANUFACTURER = %s", new Object[] { str });
      if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase("Xiaomi"))) {
        break label88;
      }
      if (!Util.isEqual(ag.get("ro.miui.ui.version.code"), "8")) {
        break label79;
      }
      isMIUIV10 = Boolean.TRUE;
    }
    for (;;)
    {
      boolean bool = isMIUIV10.booleanValue();
      AppMethodBeat.o(153476);
      return bool;
      label79:
      isMIUIV10 = Boolean.FALSE;
      continue;
      label88:
      isMIUIV10 = Boolean.FALSE;
    }
  }
  
  /* Error */
  public static boolean isMIUIV8()
  {
    // Byte code:
    //   0: ldc 249
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 20	com/tencent/mm/sdk/vendor/MIUI:isMIUIV8	Ljava/lang/Boolean;
    //   8: ifnonnull +106 -> 114
    //   11: aconst_null
    //   12: astore_2
    //   13: aconst_null
    //   14: astore_1
    //   15: new 201	com/tencent/mm/vfs/u
    //   18: dup
    //   19: invokestatic 207	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   22: ldc 209
    //   24: invokespecial 212	com/tencent/mm/vfs/u:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: invokestatic 218	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   30: astore_3
    //   31: aload_3
    //   32: astore_1
    //   33: aload_3
    //   34: astore_2
    //   35: new 220	java/util/Properties
    //   38: dup
    //   39: invokespecial 221	java/util/Properties:<init>	()V
    //   42: astore 4
    //   44: aload_3
    //   45: astore_1
    //   46: aload_3
    //   47: astore_2
    //   48: aload 4
    //   50: aload_3
    //   51: invokevirtual 224	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   54: aload_3
    //   55: astore_1
    //   56: aload_3
    //   57: astore_2
    //   58: ldc 8
    //   60: ldc 251
    //   62: iconst_1
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload 4
    //   70: ldc 226
    //   72: ldc 119
    //   74: invokevirtual 255	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   77: aastore
    //   78: invokestatic 237	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_3
    //   82: astore_1
    //   83: aload_3
    //   84: astore_2
    //   85: aload 4
    //   87: ldc 226
    //   89: ldc 119
    //   91: invokevirtual 255	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   94: ldc_w 257
    //   97: invokevirtual 260	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   100: invokestatic 198	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   103: putstatic 20	com/tencent/mm/sdk/vendor/MIUI:isMIUIV8	Ljava/lang/Boolean;
    //   106: aload_3
    //   107: ifnull +7 -> 114
    //   110: aload_3
    //   111: invokevirtual 232	java/io/InputStream:close	()V
    //   114: getstatic 20	com/tencent/mm/sdk/vendor/MIUI:isMIUIV8	Ljava/lang/Boolean;
    //   117: invokevirtual 176	java/lang/Boolean:booleanValue	()Z
    //   120: istore_0
    //   121: ldc 249
    //   123: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: iload_0
    //   127: ireturn
    //   128: astore_3
    //   129: aload_1
    //   130: astore_2
    //   131: ldc 8
    //   133: ldc 234
    //   135: iconst_1
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: aload_3
    //   142: aastore
    //   143: invokestatic 237	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: aload_1
    //   147: astore_2
    //   148: getstatic 179	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   151: putstatic 20	com/tencent/mm/sdk/vendor/MIUI:isMIUIV8	Ljava/lang/Boolean;
    //   154: aload_1
    //   155: ifnull -41 -> 114
    //   158: aload_1
    //   159: invokevirtual 232	java/io/InputStream:close	()V
    //   162: goto -48 -> 114
    //   165: astore_1
    //   166: goto -52 -> 114
    //   169: astore_1
    //   170: aload_2
    //   171: ifnull +7 -> 178
    //   174: aload_2
    //   175: invokevirtual 232	java/io/InputStream:close	()V
    //   178: ldc 249
    //   180: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload_1
    //   184: athrow
    //   185: astore_1
    //   186: goto -72 -> 114
    //   189: astore_2
    //   190: goto -12 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   120	7	0	bool	boolean
    //   14	145	1	localObject1	Object
    //   165	1	1	localException1	java.lang.Exception
    //   169	15	1	localObject2	Object
    //   185	1	1	localException2	java.lang.Exception
    //   12	163	2	localObject3	Object
    //   189	1	2	localException3	java.lang.Exception
    //   30	81	3	localInputStream	java.io.InputStream
    //   128	14	3	localException4	java.lang.Exception
    //   42	44	4	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   15	31	128	java/lang/Exception
    //   35	44	128	java/lang/Exception
    //   48	54	128	java/lang/Exception
    //   58	81	128	java/lang/Exception
    //   85	106	128	java/lang/Exception
    //   158	162	165	java/lang/Exception
    //   15	31	169	finally
    //   35	44	169	finally
    //   48	54	169	finally
    //   58	81	169	finally
    //   85	106	169	finally
    //   131	146	169	finally
    //   148	154	169	finally
    //   110	114	185	java/lang/Exception
    //   174	178	189	java/lang/Exception
  }
  
  public static boolean isXiaoMi()
  {
    AppMethodBeat.i(243202);
    boolean bool2 = false;
    String str = Build.BRAND;
    boolean bool1 = bool2;
    if (!Util.isNullOrNil(str))
    {
      bool1 = bool2;
      if (str.toLowerCase().contains("xiaomi")) {
        bool1 = true;
      }
    }
    AppMethodBeat.o(243202);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.vendor.MIUI
 * JD-Core Version:    0.7.0.1
 */