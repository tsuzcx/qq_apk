package com.tencent.mm.sdk.h;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
{
  private static Boolean Gwe = null;
  private static Boolean Gwf = null;
  private static Boolean Gwg = null;
  private static Boolean fJX = null;
  private static Boolean fJY = null;
  
  /* Error */
  public static boolean YI()
  {
    // Byte code:
    //   0: ldc 28
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 14	com/tencent/mm/sdk/h/b:fJX	Ljava/lang/Boolean;
    //   8: ifnonnull +71 -> 79
    //   11: aconst_null
    //   12: astore_2
    //   13: aconst_null
    //   14: astore_1
    //   15: new 36	com/tencent/mm/vfs/e
    //   18: dup
    //   19: invokestatic 42	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   22: ldc 44
    //   24: invokespecial 48	com/tencent/mm/vfs/e:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: invokestatic 54	com/tencent/mm/vfs/i:ag	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   30: astore_3
    //   31: aload_3
    //   32: astore_1
    //   33: aload_3
    //   34: astore_2
    //   35: new 56	java/util/Properties
    //   38: dup
    //   39: invokespecial 58	java/util/Properties:<init>	()V
    //   42: astore 4
    //   44: aload_3
    //   45: astore_1
    //   46: aload_3
    //   47: astore_2
    //   48: aload 4
    //   50: aload_3
    //   51: invokevirtual 62	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   54: aload_3
    //   55: astore_1
    //   56: aload_3
    //   57: astore_2
    //   58: aload 4
    //   60: ldc 64
    //   62: invokevirtual 68	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   65: invokestatic 74	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   68: putstatic 14	com/tencent/mm/sdk/h/b:fJX	Ljava/lang/Boolean;
    //   71: aload_3
    //   72: ifnull +7 -> 79
    //   75: aload_3
    //   76: invokevirtual 79	java/io/InputStream:close	()V
    //   79: getstatic 14	com/tencent/mm/sdk/h/b:fJX	Ljava/lang/Boolean;
    //   82: invokevirtual 82	java/lang/Boolean:booleanValue	()Z
    //   85: istore_0
    //   86: ldc 28
    //   88: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: iload_0
    //   92: ireturn
    //   93: astore_3
    //   94: aload_1
    //   95: astore_2
    //   96: ldc 87
    //   98: ldc 89
    //   100: iconst_1
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_3
    //   107: aastore
    //   108: invokestatic 95	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_1
    //   112: astore_2
    //   113: getstatic 98	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   116: putstatic 14	com/tencent/mm/sdk/h/b:fJX	Ljava/lang/Boolean;
    //   119: aload_1
    //   120: ifnull -41 -> 79
    //   123: aload_1
    //   124: invokevirtual 79	java/io/InputStream:close	()V
    //   127: goto -48 -> 79
    //   130: astore_1
    //   131: goto -52 -> 79
    //   134: astore_1
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 79	java/io/InputStream:close	()V
    //   143: ldc 28
    //   145: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  /* Error */
  public static boolean YJ()
  {
    // Byte code:
    //   0: ldc 100
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 16	com/tencent/mm/sdk/h/b:fJY	Ljava/lang/Boolean;
    //   8: ifnonnull +105 -> 113
    //   11: aconst_null
    //   12: astore_2
    //   13: aconst_null
    //   14: astore_1
    //   15: new 36	com/tencent/mm/vfs/e
    //   18: dup
    //   19: invokestatic 42	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   22: ldc 44
    //   24: invokespecial 48	com/tencent/mm/vfs/e:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: invokestatic 54	com/tencent/mm/vfs/i:ag	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   30: astore_3
    //   31: aload_3
    //   32: astore_1
    //   33: aload_3
    //   34: astore_2
    //   35: new 56	java/util/Properties
    //   38: dup
    //   39: invokespecial 58	java/util/Properties:<init>	()V
    //   42: astore 4
    //   44: aload_3
    //   45: astore_1
    //   46: aload_3
    //   47: astore_2
    //   48: aload 4
    //   50: aload_3
    //   51: invokevirtual 62	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   54: aload_3
    //   55: astore_1
    //   56: aload_3
    //   57: astore_2
    //   58: ldc 87
    //   60: ldc 102
    //   62: iconst_1
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload 4
    //   70: ldc 64
    //   72: ldc 104
    //   74: invokevirtual 108	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   77: aastore
    //   78: invokestatic 95	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_3
    //   82: astore_1
    //   83: aload_3
    //   84: astore_2
    //   85: aload 4
    //   87: ldc 64
    //   89: ldc 104
    //   91: invokevirtual 108	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   94: ldc 110
    //   96: invokevirtual 116	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   99: invokestatic 74	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   102: putstatic 16	com/tencent/mm/sdk/h/b:fJY	Ljava/lang/Boolean;
    //   105: aload_3
    //   106: ifnull +7 -> 113
    //   109: aload_3
    //   110: invokevirtual 79	java/io/InputStream:close	()V
    //   113: getstatic 16	com/tencent/mm/sdk/h/b:fJY	Ljava/lang/Boolean;
    //   116: invokevirtual 82	java/lang/Boolean:booleanValue	()Z
    //   119: istore_0
    //   120: ldc 100
    //   122: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: iload_0
    //   126: ireturn
    //   127: astore_3
    //   128: aload_1
    //   129: astore_2
    //   130: ldc 87
    //   132: ldc 89
    //   134: iconst_1
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_3
    //   141: aastore
    //   142: invokestatic 95	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_1
    //   146: astore_2
    //   147: getstatic 98	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   150: putstatic 16	com/tencent/mm/sdk/h/b:fJY	Ljava/lang/Boolean;
    //   153: aload_1
    //   154: ifnull -41 -> 113
    //   157: aload_1
    //   158: invokevirtual 79	java/io/InputStream:close	()V
    //   161: goto -48 -> 113
    //   164: astore_1
    //   165: goto -52 -> 113
    //   168: astore_1
    //   169: aload_2
    //   170: ifnull +7 -> 177
    //   173: aload_2
    //   174: invokevirtual 79	java/io/InputStream:close	()V
    //   177: ldc 100
    //   179: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_1
    //   183: athrow
    //   184: astore_1
    //   185: goto -72 -> 113
    //   188: astore_2
    //   189: goto -12 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   119	7	0	bool	boolean
    //   14	144	1	localObject1	Object
    //   164	1	1	localException1	java.lang.Exception
    //   168	15	1	localObject2	Object
    //   184	1	1	localException2	java.lang.Exception
    //   12	162	2	localObject3	Object
    //   188	1	2	localException3	java.lang.Exception
    //   30	80	3	localInputStream	java.io.InputStream
    //   127	14	3	localException4	java.lang.Exception
    //   42	44	4	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   15	31	127	java/lang/Exception
    //   35	44	127	java/lang/Exception
    //   48	54	127	java/lang/Exception
    //   58	81	127	java/lang/Exception
    //   85	105	127	java/lang/Exception
    //   157	161	164	java/lang/Exception
    //   15	31	168	finally
    //   35	44	168	finally
    //   48	54	168	finally
    //   58	81	168	finally
    //   85	105	168	finally
    //   130	145	168	finally
    //   147	153	168	finally
    //   109	113	184	java/lang/Exception
    //   173	177	188	java/lang/Exception
  }
  
  public static boolean eWJ()
  {
    AppMethodBeat.i(153476);
    if (Gwe == null)
    {
      String str = Build.MANUFACTURER;
      ac.i("Vendor.MIUI", "Build.MANUFACTURER = %s", new Object[] { str });
      if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase("Xiaomi"))) {
        break label88;
      }
      if (!bs.lr(af.get("ro.miui.ui.version.code"), "8")) {
        break label79;
      }
      Gwe = Boolean.TRUE;
    }
    for (;;)
    {
      boolean bool = Gwe.booleanValue();
      AppMethodBeat.o(153476);
      return bool;
      label79:
      Gwe = Boolean.FALSE;
      continue;
      label88:
      Gwe = Boolean.FALSE;
    }
  }
  
  public static boolean eWK()
  {
    AppMethodBeat.i(153477);
    if (Gwf == null)
    {
      String str = Build.MANUFACTURER;
      ac.i("Vendor.MIUI", "Build.MANUFACTURER = %s", new Object[] { str });
      if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase("Xiaomi"))) {
        break label66;
      }
    }
    label66:
    for (Gwf = Boolean.TRUE;; Gwf = Boolean.FALSE)
    {
      boolean bool = Gwf.booleanValue();
      AppMethodBeat.o(153477);
      return bool;
    }
  }
  
  public static boolean eWL()
  {
    AppMethodBeat.i(153478);
    if (Gwg == null)
    {
      String str = Build.MANUFACTURER;
      ac.i("Vendor.MIUI", "Build.MANUFACTURER = %s, Build.MODEL = %s", new Object[] { str, Build.MODEL });
      if ((TextUtils.isEmpty(str)) || (!str.equals("Xiaomi"))) {
        break label144;
      }
      str = getSystemProperty("ro.miui.version.code_time");
      ac.w("Vendor.MIUI", "ifNotificationChannelSupportNativeActionJump() versionCode:%s", new Object[] { str });
      if (Long.valueOf(str).longValue() <= Long.valueOf("1536681600").longValue()) {
        break label135;
      }
      Gwg = Boolean.TRUE;
    }
    for (;;)
    {
      ac.i("Vendor.MIUI", "ifNotificationChannelSupportNativeActionJump() ifNotificationChannelSupportNativeActionJump:%s", new Object[] { Boolean.valueOf(Gwg.booleanValue()) });
      boolean bool = Gwg.booleanValue();
      AppMethodBeat.o(153478);
      return bool;
      label135:
      Gwg = Boolean.FALSE;
      continue;
      label144:
      Gwg = Boolean.FALSE;
    }
  }
  
  /* Error */
  private static String getSystemProperty(String paramString)
  {
    // Byte code:
    //   0: ldc 196
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 202	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   8: ldc 204
    //   10: aload_0
    //   11: invokestatic 207	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   14: invokevirtual 210	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   17: invokevirtual 214	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   20: astore_1
    //   21: aload_1
    //   22: ifnonnull +17 -> 39
    //   25: ldc 87
    //   27: ldc 216
    //   29: invokestatic 219	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: ldc 196
    //   34: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: areturn
    //   39: new 221	java/io/BufferedReader
    //   42: dup
    //   43: new 223	java/io/InputStreamReader
    //   46: dup
    //   47: aload_1
    //   48: invokevirtual 229	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   51: invokespecial 231	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   54: sipush 1024
    //   57: invokespecial 234	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   60: astore_2
    //   61: aload_2
    //   62: astore_1
    //   63: aload_2
    //   64: invokevirtual 238	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: astore_3
    //   68: aload_2
    //   69: astore_1
    //   70: aload_2
    //   71: invokevirtual 239	java/io/BufferedReader:close	()V
    //   74: aload_2
    //   75: invokevirtual 239	java/io/BufferedReader:close	()V
    //   78: ldc 196
    //   80: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_3
    //   84: areturn
    //   85: astore_0
    //   86: ldc 87
    //   88: ldc 241
    //   90: iconst_1
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_0
    //   97: invokevirtual 244	java/io/IOException:getMessage	()Ljava/lang/String;
    //   100: aastore
    //   101: invokestatic 128	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: goto -26 -> 78
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: astore_1
    //   112: ldc 87
    //   114: ldc 246
    //   116: iconst_2
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_0
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: aload_3
    //   127: invokevirtual 247	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   130: aastore
    //   131: invokestatic 128	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: aload_2
    //   135: ifnull +7 -> 142
    //   138: aload_2
    //   139: invokevirtual 239	java/io/BufferedReader:close	()V
    //   142: ldc 196
    //   144: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aconst_null
    //   148: areturn
    //   149: astore_0
    //   150: ldc 87
    //   152: ldc 241
    //   154: iconst_1
    //   155: anewarray 4	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_0
    //   161: invokevirtual 244	java/io/IOException:getMessage	()Ljava/lang/String;
    //   164: aastore
    //   165: invokestatic 128	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: goto -26 -> 142
    //   171: astore_0
    //   172: aconst_null
    //   173: astore_1
    //   174: aload_1
    //   175: ifnull +7 -> 182
    //   178: aload_1
    //   179: invokevirtual 239	java/io/BufferedReader:close	()V
    //   182: ldc 196
    //   184: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload_0
    //   188: athrow
    //   189: astore_1
    //   190: ldc 87
    //   192: ldc 241
    //   194: iconst_1
    //   195: anewarray 4	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: aload_1
    //   201: invokevirtual 244	java/io/IOException:getMessage	()Ljava/lang/String;
    //   204: aastore
    //   205: invokestatic 128	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public static boolean h(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(153479);
    boolean bool1;
    if (paramInt >= Integer.parseInt(paramString1))
    {
      if (!bs.lr(paramString2, "")) {
        break label97;
      }
      bool1 = bool2;
      if (eWK())
      {
        paramString1 = getSystemProperty("ro.miui.version.code_time");
        if (!bs.isNullOrNil(paramString3)) {
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
      AppMethodBeat.o(153479);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.h.b
 * JD-Core Version:    0.7.0.1
 */