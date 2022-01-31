package com.tencent.mm.sdk.h;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ad;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
{
  private static Boolean etg = null;
  private static Boolean eth = null;
  private static Boolean ytA = null;
  private static Boolean yty = null;
  private static Boolean ytz = null;
  
  /* Error */
  public static boolean Mn()
  {
    // Byte code:
    //   0: ldc 28
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 14	com/tencent/mm/sdk/h/b:etg	Ljava/lang/Boolean;
    //   8: ifnonnull +58 -> 66
    //   11: new 36	java/io/FileInputStream
    //   14: dup
    //   15: new 38	java/io/File
    //   18: dup
    //   19: invokestatic 44	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   22: ldc 46
    //   24: invokespecial 50	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: invokespecial 53	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: new 55	java/util/Properties
    //   36: dup
    //   37: invokespecial 57	java/util/Properties:<init>	()V
    //   40: astore_3
    //   41: aload_2
    //   42: astore_1
    //   43: aload_3
    //   44: aload_2
    //   45: invokevirtual 61	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   48: aload_2
    //   49: astore_1
    //   50: aload_3
    //   51: ldc 63
    //   53: invokevirtual 67	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   56: invokestatic 73	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   59: putstatic 14	com/tencent/mm/sdk/h/b:etg	Ljava/lang/Boolean;
    //   62: aload_2
    //   63: invokevirtual 76	java/io/FileInputStream:close	()V
    //   66: getstatic 14	com/tencent/mm/sdk/h/b:etg	Ljava/lang/Boolean;
    //   69: invokevirtual 79	java/lang/Boolean:booleanValue	()Z
    //   72: istore_0
    //   73: ldc 28
    //   75: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: iload_0
    //   79: ireturn
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: astore_1
    //   85: ldc 84
    //   87: ldc 86
    //   89: iconst_1
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload_3
    //   96: aastore
    //   97: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: aload_2
    //   101: astore_1
    //   102: getstatic 95	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   105: putstatic 14	com/tencent/mm/sdk/h/b:etg	Ljava/lang/Boolean;
    //   108: aload_2
    //   109: ifnull -43 -> 66
    //   112: aload_2
    //   113: invokevirtual 76	java/io/FileInputStream:close	()V
    //   116: goto -50 -> 66
    //   119: astore_1
    //   120: goto -54 -> 66
    //   123: astore_2
    //   124: aconst_null
    //   125: astore_1
    //   126: aload_1
    //   127: ifnull +7 -> 134
    //   130: aload_1
    //   131: invokevirtual 76	java/io/FileInputStream:close	()V
    //   134: ldc 28
    //   136: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_2
    //   140: athrow
    //   141: astore_1
    //   142: goto -76 -> 66
    //   145: astore_1
    //   146: goto -12 -> 134
    //   149: astore_2
    //   150: goto -24 -> 126
    //   153: astore_3
    //   154: goto -71 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   72	7	0	bool	boolean
    //   32	70	1	localFileInputStream1	java.io.FileInputStream
    //   119	1	1	localException1	java.lang.Exception
    //   125	6	1	localObject1	Object
    //   141	1	1	localException2	java.lang.Exception
    //   145	1	1	localException3	java.lang.Exception
    //   30	83	2	localFileInputStream2	java.io.FileInputStream
    //   123	17	2	localObject2	Object
    //   149	1	2	localObject3	Object
    //   40	11	3	localProperties	java.util.Properties
    //   80	16	3	localException4	java.lang.Exception
    //   153	1	3	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   11	31	80	java/lang/Exception
    //   112	116	119	java/lang/Exception
    //   11	31	123	finally
    //   62	66	141	java/lang/Exception
    //   130	134	145	java/lang/Exception
    //   33	41	149	finally
    //   43	48	149	finally
    //   50	62	149	finally
    //   85	100	149	finally
    //   102	108	149	finally
    //   33	41	153	java/lang/Exception
    //   43	48	153	java/lang/Exception
    //   50	62	153	java/lang/Exception
  }
  
  /* Error */
  public static boolean Mo()
  {
    // Byte code:
    //   0: ldc 97
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 16	com/tencent/mm/sdk/h/b:eth	Ljava/lang/Boolean;
    //   8: ifnonnull +89 -> 97
    //   11: new 36	java/io/FileInputStream
    //   14: dup
    //   15: new 38	java/io/File
    //   18: dup
    //   19: invokestatic 44	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   22: ldc 46
    //   24: invokespecial 50	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: invokespecial 53	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: new 55	java/util/Properties
    //   36: dup
    //   37: invokespecial 57	java/util/Properties:<init>	()V
    //   40: astore_3
    //   41: aload_2
    //   42: astore_1
    //   43: aload_3
    //   44: aload_2
    //   45: invokevirtual 61	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   48: aload_2
    //   49: astore_1
    //   50: ldc 84
    //   52: ldc 99
    //   54: iconst_1
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_3
    //   61: ldc 63
    //   63: ldc 101
    //   65: invokevirtual 105	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   68: aastore
    //   69: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload_2
    //   73: astore_1
    //   74: aload_3
    //   75: ldc 63
    //   77: ldc 101
    //   79: invokevirtual 105	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   82: ldc 107
    //   84: invokevirtual 113	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   87: invokestatic 73	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   90: putstatic 16	com/tencent/mm/sdk/h/b:eth	Ljava/lang/Boolean;
    //   93: aload_2
    //   94: invokevirtual 76	java/io/FileInputStream:close	()V
    //   97: getstatic 16	com/tencent/mm/sdk/h/b:eth	Ljava/lang/Boolean;
    //   100: invokevirtual 79	java/lang/Boolean:booleanValue	()Z
    //   103: istore_0
    //   104: ldc 97
    //   106: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: iload_0
    //   110: ireturn
    //   111: astore_3
    //   112: aconst_null
    //   113: astore_2
    //   114: aload_2
    //   115: astore_1
    //   116: ldc 84
    //   118: ldc 86
    //   120: iconst_1
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: aload_3
    //   127: aastore
    //   128: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload_2
    //   132: astore_1
    //   133: getstatic 95	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   136: putstatic 16	com/tencent/mm/sdk/h/b:eth	Ljava/lang/Boolean;
    //   139: aload_2
    //   140: ifnull -43 -> 97
    //   143: aload_2
    //   144: invokevirtual 76	java/io/FileInputStream:close	()V
    //   147: goto -50 -> 97
    //   150: astore_1
    //   151: goto -54 -> 97
    //   154: astore_2
    //   155: aconst_null
    //   156: astore_1
    //   157: aload_1
    //   158: ifnull +7 -> 165
    //   161: aload_1
    //   162: invokevirtual 76	java/io/FileInputStream:close	()V
    //   165: ldc 97
    //   167: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: aload_2
    //   171: athrow
    //   172: astore_1
    //   173: goto -76 -> 97
    //   176: astore_1
    //   177: goto -12 -> 165
    //   180: astore_2
    //   181: goto -24 -> 157
    //   184: astore_3
    //   185: goto -71 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   103	7	0	bool	boolean
    //   32	101	1	localFileInputStream1	java.io.FileInputStream
    //   150	1	1	localException1	java.lang.Exception
    //   156	6	1	localObject1	Object
    //   172	1	1	localException2	java.lang.Exception
    //   176	1	1	localException3	java.lang.Exception
    //   30	114	2	localFileInputStream2	java.io.FileInputStream
    //   154	17	2	localObject2	Object
    //   180	1	2	localObject3	Object
    //   40	35	3	localProperties	java.util.Properties
    //   111	16	3	localException4	java.lang.Exception
    //   184	1	3	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   11	31	111	java/lang/Exception
    //   143	147	150	java/lang/Exception
    //   11	31	154	finally
    //   93	97	172	java/lang/Exception
    //   161	165	176	java/lang/Exception
    //   33	41	180	finally
    //   43	48	180	finally
    //   50	72	180	finally
    //   74	93	180	finally
    //   116	131	180	finally
    //   133	139	180	finally
    //   33	41	184	java/lang/Exception
    //   43	48	184	java/lang/Exception
    //   50	72	184	java/lang/Exception
    //   74	93	184	java/lang/Exception
  }
  
  public static boolean duN()
  {
    AppMethodBeat.i(65370);
    if (yty == null)
    {
      String str = Build.MANUFACTURER;
      ab.i("Vendor.MIUI", "Build.MANUFACTURER = %s", new Object[] { str });
      if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase("Xiaomi"))) {
        break label88;
      }
      if (!bo.isEqual(ad.get("ro.miui.ui.version.code"), "8")) {
        break label79;
      }
      yty = Boolean.TRUE;
    }
    for (;;)
    {
      boolean bool = yty.booleanValue();
      AppMethodBeat.o(65370);
      return bool;
      label79:
      yty = Boolean.FALSE;
      continue;
      label88:
      yty = Boolean.FALSE;
    }
  }
  
  public static boolean duO()
  {
    AppMethodBeat.i(65371);
    if (ytz == null)
    {
      String str = Build.MANUFACTURER;
      ab.i("Vendor.MIUI", "Build.MANUFACTURER = %s", new Object[] { str });
      if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase("Xiaomi"))) {
        break label66;
      }
    }
    label66:
    for (ytz = Boolean.TRUE;; ytz = Boolean.FALSE)
    {
      boolean bool = ytz.booleanValue();
      AppMethodBeat.o(65371);
      return bool;
    }
  }
  
  public static boolean duP()
  {
    AppMethodBeat.i(65372);
    if (ytA == null)
    {
      String str = Build.MANUFACTURER;
      ab.i("Vendor.MIUI", "Build.MANUFACTURER = %s, Build.MODEL = %s", new Object[] { str, Build.MODEL });
      if ((TextUtils.isEmpty(str)) || (!str.equals("Xiaomi"))) {
        break label144;
      }
      str = getSystemProperty("ro.miui.version.code_time");
      ab.w("Vendor.MIUI", "ifNotificationChannelSupportNativeActionJump() versionCode:%s", new Object[] { str });
      if (Long.valueOf(str).longValue() <= Long.valueOf("1536681600").longValue()) {
        break label135;
      }
      ytA = Boolean.TRUE;
    }
    for (;;)
    {
      ab.i("Vendor.MIUI", "ifNotificationChannelSupportNativeActionJump() ifNotificationChannelSupportNativeActionJump:%s", new Object[] { Boolean.valueOf(ytA.booleanValue()) });
      boolean bool = ytA.booleanValue();
      AppMethodBeat.o(65372);
      return bool;
      label135:
      ytA = Boolean.FALSE;
      continue;
      label144:
      ytA = Boolean.FALSE;
    }
  }
  
  public static boolean g(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(65373);
    boolean bool1;
    if (paramInt >= Integer.parseInt(paramString1))
    {
      if (!bo.isEqual(paramString2, "")) {
        break label97;
      }
      bool1 = bool2;
      if (duO())
      {
        paramString1 = getSystemProperty("ro.miui.version.code_time");
        if (!bo.isNullOrNil(paramString3)) {
          break label69;
        }
        paramInt = 1;
        bool1 = bool2;
        if (paramInt != 0) {}
      }
    }
    else
    {
      bool1 = false;
    }
    for (;;)
    {
      AppMethodBeat.o(65373);
      return bool1;
      label69:
      if (Long.valueOf(paramString1).longValue() < Long.valueOf(paramString3).longValue())
      {
        paramInt = 1;
        break;
      }
      paramInt = 0;
      break;
      label97:
      bool1 = bool2;
      if (paramInt > Integer.parseInt(paramString2)) {
        bool1 = false;
      }
    }
  }
  
  /* Error */
  private static String getSystemProperty(String paramString)
  {
    // Byte code:
    //   0: ldc 207
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 213	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   8: ldc 215
    //   10: aload_0
    //   11: invokestatic 218	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   14: invokevirtual 221	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   17: invokevirtual 225	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   20: astore_1
    //   21: aload_1
    //   22: ifnonnull +17 -> 39
    //   25: ldc 84
    //   27: ldc 227
    //   29: invokestatic 230	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: ldc 207
    //   34: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: areturn
    //   39: new 232	java/io/BufferedReader
    //   42: dup
    //   43: new 234	java/io/InputStreamReader
    //   46: dup
    //   47: aload_1
    //   48: invokevirtual 240	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   51: invokespecial 242	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   54: sipush 1024
    //   57: invokespecial 245	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   60: astore_2
    //   61: aload_2
    //   62: astore_1
    //   63: aload_2
    //   64: invokevirtual 249	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: astore_3
    //   68: aload_2
    //   69: astore_1
    //   70: aload_2
    //   71: invokevirtual 250	java/io/BufferedReader:close	()V
    //   74: aload_2
    //   75: invokevirtual 250	java/io/BufferedReader:close	()V
    //   78: ldc 207
    //   80: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_3
    //   84: areturn
    //   85: astore_0
    //   86: ldc 84
    //   88: ldc 252
    //   90: iconst_1
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_0
    //   97: invokevirtual 255	java/io/IOException:getMessage	()Ljava/lang/String;
    //   100: aastore
    //   101: invokestatic 125	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: goto -26 -> 78
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: astore_1
    //   112: ldc 84
    //   114: ldc_w 257
    //   117: iconst_2
    //   118: anewarray 4	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload_0
    //   124: aastore
    //   125: dup
    //   126: iconst_1
    //   127: aload_3
    //   128: invokevirtual 258	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   131: aastore
    //   132: invokestatic 125	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 250	java/io/BufferedReader:close	()V
    //   143: ldc 207
    //   145: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: aconst_null
    //   149: areturn
    //   150: astore_0
    //   151: ldc 84
    //   153: ldc 252
    //   155: iconst_1
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_0
    //   162: invokevirtual 255	java/io/IOException:getMessage	()Ljava/lang/String;
    //   165: aastore
    //   166: invokestatic 125	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: goto -26 -> 143
    //   172: astore_0
    //   173: aconst_null
    //   174: astore_1
    //   175: aload_1
    //   176: ifnull +7 -> 183
    //   179: aload_1
    //   180: invokevirtual 250	java/io/BufferedReader:close	()V
    //   183: ldc 207
    //   185: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_0
    //   189: athrow
    //   190: astore_1
    //   191: ldc 84
    //   193: ldc 252
    //   195: iconst_1
    //   196: anewarray 4	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: aload_1
    //   202: invokevirtual 255	java/io/IOException:getMessage	()Ljava/lang/String;
    //   205: aastore
    //   206: invokestatic 125	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: goto -26 -> 183
    //   212: astore_0
    //   213: goto -38 -> 175
    //   216: astore_3
    //   217: goto -107 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramString	String
    //   20	160	1	localObject	Object
    //   190	12	1	localIOException	java.io.IOException
    //   60	80	2	localBufferedReader	java.io.BufferedReader
    //   67	17	3	str	String
    //   107	21	3	localException1	java.lang.Exception
    //   216	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   74	78	85	java/io/IOException
    //   5	21	107	java/lang/Exception
    //   25	32	107	java/lang/Exception
    //   39	61	107	java/lang/Exception
    //   139	143	150	java/io/IOException
    //   5	21	172	finally
    //   25	32	172	finally
    //   39	61	172	finally
    //   179	183	190	java/io/IOException
    //   63	68	212	finally
    //   70	74	212	finally
    //   112	135	212	finally
    //   63	68	216	java/lang/Exception
    //   70	74	216	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.h.b
 * JD-Core Version:    0.7.0.1
 */