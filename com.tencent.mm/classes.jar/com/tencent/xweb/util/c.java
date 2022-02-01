package com.tencent.xweb.util;

import android.content.res.AssetFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import org.xwalk.core.Log;

public final class c
{
  public static void a(AssetFileDescriptor paramAssetFileDescriptor)
  {
    AppMethodBeat.i(156999);
    if (paramAssetFileDescriptor != null) {
      try
      {
        paramAssetFileDescriptor.close();
        AppMethodBeat.o(156999);
        return;
      }
      catch (Exception paramAssetFileDescriptor)
      {
        Log.e("FileUtils", "tryClose AssetFileDescriptor error: " + paramAssetFileDescriptor.getMessage());
      }
    }
    AppMethodBeat.o(156999);
  }
  
  /* Error */
  public static boolean a(AssetFileDescriptor paramAssetFileDescriptor, File paramFile)
  {
    // Byte code:
    //   0: ldc 54
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +17 -> 23
    //   9: ldc 26
    //   11: ldc 56
    //   13: invokestatic 51	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: ldc 54
    //   18: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_1
    //   24: invokevirtual 62	java/io/File:exists	()Z
    //   27: ifeq +8 -> 35
    //   30: aload_1
    //   31: invokevirtual 65	java/io/File:delete	()Z
    //   34: pop
    //   35: new 67	java/io/FileOutputStream
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 70	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   43: astore_3
    //   44: aload_0
    //   45: invokevirtual 74	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   48: astore_1
    //   49: aload_1
    //   50: astore 5
    //   52: aload_3
    //   53: astore 4
    //   55: ldc 75
    //   57: newarray byte
    //   59: astore 6
    //   61: aload_1
    //   62: astore 5
    //   64: aload_3
    //   65: astore 4
    //   67: aload_1
    //   68: aload 6
    //   70: invokevirtual 81	java/io/FileInputStream:read	([B)I
    //   73: istore_2
    //   74: iload_2
    //   75: iconst_m1
    //   76: if_icmpeq +72 -> 148
    //   79: aload_1
    //   80: astore 5
    //   82: aload_3
    //   83: astore 4
    //   85: aload_3
    //   86: aload 6
    //   88: iconst_0
    //   89: iload_2
    //   90: invokevirtual 85	java/io/FileOutputStream:write	([BII)V
    //   93: goto -32 -> 61
    //   96: astore 6
    //   98: aload_1
    //   99: astore 5
    //   101: aload_3
    //   102: astore 4
    //   104: ldc 26
    //   106: new 28	java/lang/StringBuilder
    //   109: dup
    //   110: ldc 87
    //   112: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: aload 6
    //   117: invokevirtual 38	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   120: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 51	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_3
    //   130: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   133: aload_1
    //   134: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   137: aload_0
    //   138: invokestatic 93	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   141: ldc 54
    //   143: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iconst_0
    //   147: ireturn
    //   148: aload_1
    //   149: astore 5
    //   151: aload_3
    //   152: astore 4
    //   154: aload_3
    //   155: invokevirtual 96	java/io/FileOutputStream:flush	()V
    //   158: aload_3
    //   159: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   162: aload_1
    //   163: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   166: aload_0
    //   167: invokestatic 93	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   170: ldc 54
    //   172: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: iconst_1
    //   176: ireturn
    //   177: astore_1
    //   178: aconst_null
    //   179: astore 5
    //   181: aconst_null
    //   182: astore_3
    //   183: aload_3
    //   184: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   187: aload 5
    //   189: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   192: aload_0
    //   193: invokestatic 93	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   196: ldc 54
    //   198: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: aload_1
    //   202: athrow
    //   203: astore_1
    //   204: aconst_null
    //   205: astore 5
    //   207: goto -24 -> 183
    //   210: astore_1
    //   211: aload 4
    //   213: astore_3
    //   214: goto -31 -> 183
    //   217: astore 6
    //   219: aconst_null
    //   220: astore_1
    //   221: aconst_null
    //   222: astore_3
    //   223: goto -125 -> 98
    //   226: astore 6
    //   228: aconst_null
    //   229: astore_1
    //   230: goto -132 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	paramAssetFileDescriptor	AssetFileDescriptor
    //   0	233	1	paramFile	File
    //   73	17	2	i	int
    //   43	180	3	localObject1	Object
    //   53	159	4	localObject2	Object
    //   50	156	5	localFile	File
    //   59	28	6	arrayOfByte	byte[]
    //   96	20	6	localException1	Exception
    //   217	1	6	localException2	Exception
    //   226	1	6	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   55	61	96	java/lang/Exception
    //   67	74	96	java/lang/Exception
    //   85	93	96	java/lang/Exception
    //   154	158	96	java/lang/Exception
    //   23	35	177	finally
    //   35	44	177	finally
    //   44	49	203	finally
    //   55	61	210	finally
    //   67	74	210	finally
    //   85	93	210	finally
    //   104	129	210	finally
    //   154	158	210	finally
    //   23	35	217	java/lang/Exception
    //   35	44	217	java/lang/Exception
    //   44	49	226	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(java.io.InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: ldc 98
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +17 -> 23
    //   9: ldc 26
    //   11: ldc 100
    //   13: invokestatic 51	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: ldc 98
    //   18: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: iconst_0
    //   22: ireturn
    //   23: aconst_null
    //   24: astore 4
    //   26: aconst_null
    //   27: astore 5
    //   29: aload 4
    //   31: astore_3
    //   32: aload_1
    //   33: invokevirtual 62	java/io/File:exists	()Z
    //   36: ifeq +11 -> 47
    //   39: aload 4
    //   41: astore_3
    //   42: aload_1
    //   43: invokevirtual 65	java/io/File:delete	()Z
    //   46: pop
    //   47: aload 4
    //   49: astore_3
    //   50: new 67	java/io/FileOutputStream
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 70	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   58: astore_1
    //   59: ldc 75
    //   61: newarray byte
    //   63: astore_3
    //   64: aload_0
    //   65: aload_3
    //   66: invokevirtual 103	java/io/InputStream:read	([B)I
    //   69: istore_2
    //   70: iload_2
    //   71: iconst_m1
    //   72: if_icmpeq +57 -> 129
    //   75: aload_1
    //   76: aload_3
    //   77: iconst_0
    //   78: iload_2
    //   79: invokevirtual 85	java/io/FileOutputStream:write	([BII)V
    //   82: goto -18 -> 64
    //   85: astore 4
    //   87: aload_1
    //   88: astore_3
    //   89: ldc 26
    //   91: new 28	java/lang/StringBuilder
    //   94: dup
    //   95: ldc 105
    //   97: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload 4
    //   102: invokevirtual 38	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   105: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 51	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: aload_1
    //   115: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   118: aload_0
    //   119: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   122: ldc 98
    //   124: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: iconst_0
    //   128: ireturn
    //   129: aload_1
    //   130: invokevirtual 96	java/io/FileOutputStream:flush	()V
    //   133: aload_1
    //   134: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   137: aload_0
    //   138: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   141: ldc 98
    //   143: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iconst_1
    //   147: ireturn
    //   148: astore_1
    //   149: aload_3
    //   150: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   153: aload_0
    //   154: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   157: ldc 98
    //   159: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload_1
    //   163: athrow
    //   164: astore 4
    //   166: aload_1
    //   167: astore_3
    //   168: aload 4
    //   170: astore_1
    //   171: goto -22 -> 149
    //   174: astore 4
    //   176: aload 5
    //   178: astore_1
    //   179: goto -92 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramInputStream	java.io.InputStream
    //   0	182	1	paramFile	File
    //   69	10	2	i	int
    //   31	137	3	localObject1	Object
    //   24	24	4	localObject2	Object
    //   85	16	4	localException1	Exception
    //   164	5	4	localObject3	Object
    //   174	1	4	localException2	Exception
    //   27	150	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   59	64	85	java/lang/Exception
    //   64	70	85	java/lang/Exception
    //   75	82	85	java/lang/Exception
    //   129	133	85	java/lang/Exception
    //   32	39	148	finally
    //   42	47	148	finally
    //   50	59	148	finally
    //   89	114	148	finally
    //   59	64	164	finally
    //   64	70	164	finally
    //   75	82	164	finally
    //   129	133	164	finally
    //   32	39	174	java/lang/Exception
    //   42	47	174	java/lang/Exception
    //   50	59	174	java/lang/Exception
  }
  
  public static boolean ae(File paramFile)
  {
    AppMethodBeat.i(196483);
    try
    {
      deleteAll(paramFile);
      AppMethodBeat.o(196483);
      return true;
    }
    catch (Exception localException)
    {
      Log.i("FileUtils", String.format("safeDeleteAll all files.(%s)", new Object[] { paramFile.getAbsolutePath() }));
      AppMethodBeat.o(196483);
    }
    return false;
  }
  
  public static boolean bFA(String paramString)
  {
    AppMethodBeat.i(156996);
    try
    {
      deleteAll(new File(paramString));
      AppMethodBeat.o(156996);
      return true;
    }
    catch (Exception localException)
    {
      Log.i("FileUtils", String.format("delete all files.(%s)", new Object[] { paramString }));
      AppMethodBeat.o(156996);
    }
    return false;
  }
  
  /* Error */
  public static boolean copyFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 135
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 77	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 136	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 140	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   18: astore 6
    //   20: new 67	java/io/FileOutputStream
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   28: astore_3
    //   29: aload_3
    //   30: invokevirtual 142	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   33: astore 4
    //   35: aload 4
    //   37: aload 6
    //   39: lconst_0
    //   40: aload 6
    //   42: invokevirtual 148	java/nio/channels/FileChannel:size	()J
    //   45: invokevirtual 152	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   48: pop2
    //   49: aload 4
    //   51: iconst_1
    //   52: invokevirtual 156	java/nio/channels/FileChannel:force	(Z)V
    //   55: aload_2
    //   56: invokevirtual 157	java/io/FileInputStream:close	()V
    //   59: aload_3
    //   60: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   63: aload 6
    //   65: ifnull +8 -> 73
    //   68: aload 6
    //   70: invokevirtual 159	java/nio/channels/FileChannel:close	()V
    //   73: aload 4
    //   75: ifnull +8 -> 83
    //   78: aload 4
    //   80: invokevirtual 159	java/nio/channels/FileChannel:close	()V
    //   83: ldc 135
    //   85: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: iconst_1
    //   89: ireturn
    //   90: astore 5
    //   92: aconst_null
    //   93: astore_2
    //   94: aconst_null
    //   95: astore 4
    //   97: aconst_null
    //   98: astore_3
    //   99: aconst_null
    //   100: astore 6
    //   102: ldc 26
    //   104: ldc 161
    //   106: iconst_4
    //   107: anewarray 4	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload 5
    //   114: invokevirtual 165	java/lang/Object:getClass	()Ljava/lang/Class;
    //   117: invokevirtual 170	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: aload 5
    //   125: invokevirtual 38	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   128: aastore
    //   129: dup
    //   130: iconst_2
    //   131: aload_0
    //   132: aastore
    //   133: dup
    //   134: iconst_3
    //   135: aload_1
    //   136: aastore
    //   137: invokestatic 122	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   140: invokestatic 51	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload 4
    //   145: ifnull +8 -> 153
    //   148: aload 4
    //   150: invokevirtual 157	java/io/FileInputStream:close	()V
    //   153: aload_2
    //   154: ifnull +7 -> 161
    //   157: aload_2
    //   158: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   161: aload 6
    //   163: ifnull +8 -> 171
    //   166: aload 6
    //   168: invokevirtual 159	java/nio/channels/FileChannel:close	()V
    //   171: aload_3
    //   172: ifnull +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 159	java/nio/channels/FileChannel:close	()V
    //   179: ldc 135
    //   181: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: iconst_0
    //   185: ireturn
    //   186: astore_0
    //   187: aconst_null
    //   188: astore_2
    //   189: aconst_null
    //   190: astore 4
    //   192: aconst_null
    //   193: astore_3
    //   194: aconst_null
    //   195: astore 6
    //   197: aload 4
    //   199: ifnull +8 -> 207
    //   202: aload 4
    //   204: invokevirtual 157	java/io/FileInputStream:close	()V
    //   207: aload_2
    //   208: ifnull +7 -> 215
    //   211: aload_2
    //   212: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   215: aload 6
    //   217: ifnull +8 -> 225
    //   220: aload 6
    //   222: invokevirtual 159	java/nio/channels/FileChannel:close	()V
    //   225: aload_3
    //   226: ifnull +7 -> 233
    //   229: aload_3
    //   230: invokevirtual 159	java/nio/channels/FileChannel:close	()V
    //   233: ldc 135
    //   235: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload_0
    //   239: athrow
    //   240: astore_0
    //   241: goto -182 -> 59
    //   244: astore_0
    //   245: goto -182 -> 63
    //   248: astore_0
    //   249: goto -176 -> 73
    //   252: astore_0
    //   253: goto -170 -> 83
    //   256: astore_0
    //   257: goto -104 -> 153
    //   260: astore_0
    //   261: goto -100 -> 161
    //   264: astore_0
    //   265: goto -94 -> 171
    //   268: astore_0
    //   269: goto -90 -> 179
    //   272: astore_1
    //   273: goto -66 -> 207
    //   276: astore_1
    //   277: goto -62 -> 215
    //   280: astore_1
    //   281: goto -56 -> 225
    //   284: astore_1
    //   285: goto -52 -> 233
    //   288: astore_0
    //   289: aconst_null
    //   290: astore_1
    //   291: aload_2
    //   292: astore 4
    //   294: aconst_null
    //   295: astore_3
    //   296: aconst_null
    //   297: astore 6
    //   299: aload_1
    //   300: astore_2
    //   301: goto -104 -> 197
    //   304: astore_0
    //   305: aconst_null
    //   306: astore_1
    //   307: aload_2
    //   308: astore 4
    //   310: aconst_null
    //   311: astore_3
    //   312: aload_1
    //   313: astore_2
    //   314: goto -117 -> 197
    //   317: astore_0
    //   318: aload_2
    //   319: astore 4
    //   321: aconst_null
    //   322: astore_1
    //   323: aload_3
    //   324: astore_2
    //   325: aload_1
    //   326: astore_3
    //   327: goto -130 -> 197
    //   330: astore_0
    //   331: aload_2
    //   332: astore_1
    //   333: aload 4
    //   335: astore 5
    //   337: aload_3
    //   338: astore_2
    //   339: aload_1
    //   340: astore 4
    //   342: aload 5
    //   344: astore_3
    //   345: goto -148 -> 197
    //   348: astore_0
    //   349: goto -152 -> 197
    //   352: astore 5
    //   354: aconst_null
    //   355: astore 7
    //   357: aload_2
    //   358: astore 4
    //   360: aconst_null
    //   361: astore_3
    //   362: aconst_null
    //   363: astore 6
    //   365: aload 7
    //   367: astore_2
    //   368: goto -266 -> 102
    //   371: astore 5
    //   373: aconst_null
    //   374: astore 7
    //   376: aload_2
    //   377: astore 4
    //   379: aconst_null
    //   380: astore_3
    //   381: aload 7
    //   383: astore_2
    //   384: goto -282 -> 102
    //   387: astore 5
    //   389: aload_2
    //   390: astore 4
    //   392: aconst_null
    //   393: astore 7
    //   395: aload_3
    //   396: astore_2
    //   397: aload 7
    //   399: astore_3
    //   400: goto -298 -> 102
    //   403: astore 5
    //   405: aload_2
    //   406: astore 7
    //   408: aload 4
    //   410: astore 8
    //   412: aload_3
    //   413: astore_2
    //   414: aload 7
    //   416: astore 4
    //   418: aload 8
    //   420: astore_3
    //   421: goto -319 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	paramString1	String
    //   0	424	1	paramString2	String
    //   13	401	2	localObject1	Object
    //   28	393	3	localObject2	Object
    //   33	384	4	localObject3	Object
    //   90	34	5	localException1	Exception
    //   335	8	5	localObject4	Object
    //   352	1	5	localException2	Exception
    //   371	1	5	localException3	Exception
    //   387	1	5	localException4	Exception
    //   403	1	5	localException5	Exception
    //   18	346	6	localFileChannel	java.nio.channels.FileChannel
    //   355	60	7	localObject5	Object
    //   410	9	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   5	14	90	java/lang/Exception
    //   5	14	186	finally
    //   55	59	240	java/lang/Exception
    //   59	63	244	java/lang/Exception
    //   68	73	248	java/io/IOException
    //   78	83	252	java/io/IOException
    //   148	153	256	java/lang/Exception
    //   157	161	260	java/lang/Exception
    //   166	171	264	java/io/IOException
    //   175	179	268	java/io/IOException
    //   202	207	272	java/lang/Exception
    //   211	215	276	java/lang/Exception
    //   220	225	280	java/io/IOException
    //   229	233	284	java/io/IOException
    //   14	20	288	finally
    //   20	29	304	finally
    //   29	35	317	finally
    //   35	55	330	finally
    //   102	143	348	finally
    //   14	20	352	java/lang/Exception
    //   20	29	371	java/lang/Exception
    //   29	35	387	java/lang/Exception
    //   35	55	403	java/lang/Exception
  }
  
  public static void deleteAll(File paramFile)
  {
    AppMethodBeat.i(156997);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(156997);
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
      AppMethodBeat.o(156997);
      return;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int j = arrayOfFile.length;
        int i = 0;
        if (i < j)
        {
          File localFile = arrayOfFile[i];
          if ((localFile != null) && (localFile.exists()))
          {
            if (!localFile.isFile()) {
              break label110;
            }
            localFile.delete();
          }
          for (;;)
          {
            i += 1;
            break;
            label110:
            deleteAll(localFile);
          }
        }
      }
      paramFile.delete();
    }
    AppMethodBeat.o(156997);
  }
  
  public static boolean deleteFile(String paramString)
  {
    AppMethodBeat.i(156995);
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isFile()))
    {
      paramString.delete();
      AppMethodBeat.o(156995);
      return true;
    }
    AppMethodBeat.o(156995);
    return false;
  }
  
  /* Error */
  private static boolean f(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: ldc 186
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 77	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 187	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   13: astore 5
    //   15: new 189	java/io/BufferedInputStream
    //   18: dup
    //   19: aload 5
    //   21: invokespecial 192	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore 4
    //   26: new 67	java/io/FileOutputStream
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 70	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   34: astore_3
    //   35: new 194	java/io/BufferedOutputStream
    //   38: dup
    //   39: aload_3
    //   40: invokespecial 197	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   43: astore_0
    //   44: aload_0
    //   45: astore 9
    //   47: aload_3
    //   48: astore 8
    //   50: aload 4
    //   52: astore 7
    //   54: aload 5
    //   56: astore 6
    //   58: sipush 5120
    //   61: newarray byte
    //   63: astore_1
    //   64: aload_0
    //   65: astore 9
    //   67: aload_3
    //   68: astore 8
    //   70: aload 4
    //   72: astore 7
    //   74: aload 5
    //   76: astore 6
    //   78: aload 4
    //   80: aload_1
    //   81: invokevirtual 198	java/io/BufferedInputStream:read	([B)I
    //   84: istore_2
    //   85: iload_2
    //   86: iconst_m1
    //   87: if_icmpeq +91 -> 178
    //   90: aload_0
    //   91: astore 9
    //   93: aload_3
    //   94: astore 8
    //   96: aload 4
    //   98: astore 7
    //   100: aload 5
    //   102: astore 6
    //   104: aload_0
    //   105: aload_1
    //   106: iconst_0
    //   107: iload_2
    //   108: invokevirtual 199	java/io/BufferedOutputStream:write	([BII)V
    //   111: goto -47 -> 64
    //   114: astore_1
    //   115: aload_0
    //   116: astore 9
    //   118: aload_3
    //   119: astore 8
    //   121: aload 4
    //   123: astore 7
    //   125: aload 5
    //   127: astore 6
    //   129: ldc 26
    //   131: new 28	java/lang/StringBuilder
    //   134: dup
    //   135: ldc 201
    //   137: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   140: aload_1
    //   141: invokevirtual 38	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   144: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 51	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload 4
    //   155: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   158: aload_0
    //   159: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   162: aload 5
    //   164: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   167: aload_3
    //   168: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   171: ldc 186
    //   173: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: iconst_0
    //   177: ireturn
    //   178: aload_0
    //   179: astore 9
    //   181: aload_3
    //   182: astore 8
    //   184: aload 4
    //   186: astore 7
    //   188: aload 5
    //   190: astore 6
    //   192: aload_0
    //   193: invokevirtual 202	java/io/BufferedOutputStream:flush	()V
    //   196: aload 4
    //   198: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   201: aload_0
    //   202: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   205: aload 5
    //   207: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   210: aload_3
    //   211: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   214: ldc 186
    //   216: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: iconst_1
    //   220: ireturn
    //   221: astore_0
    //   222: aconst_null
    //   223: astore_1
    //   224: aconst_null
    //   225: astore_3
    //   226: aconst_null
    //   227: astore 4
    //   229: aconst_null
    //   230: astore 5
    //   232: aload 4
    //   234: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   237: aload_1
    //   238: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   241: aload 5
    //   243: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   246: aload_3
    //   247: invokestatic 91	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   250: ldc 186
    //   252: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: aload_0
    //   256: athrow
    //   257: astore_0
    //   258: aconst_null
    //   259: astore_1
    //   260: aconst_null
    //   261: astore_3
    //   262: aconst_null
    //   263: astore 4
    //   265: goto -33 -> 232
    //   268: astore_0
    //   269: aconst_null
    //   270: astore_1
    //   271: aconst_null
    //   272: astore_3
    //   273: goto -41 -> 232
    //   276: astore_0
    //   277: aconst_null
    //   278: astore_1
    //   279: goto -47 -> 232
    //   282: astore_0
    //   283: aload 9
    //   285: astore_1
    //   286: aload 8
    //   288: astore_3
    //   289: aload 7
    //   291: astore 4
    //   293: aload 6
    //   295: astore 5
    //   297: goto -65 -> 232
    //   300: astore_1
    //   301: aconst_null
    //   302: astore_0
    //   303: aconst_null
    //   304: astore_3
    //   305: aconst_null
    //   306: astore 4
    //   308: aconst_null
    //   309: astore 5
    //   311: goto -196 -> 115
    //   314: astore_1
    //   315: aconst_null
    //   316: astore_0
    //   317: aconst_null
    //   318: astore_3
    //   319: aconst_null
    //   320: astore 4
    //   322: goto -207 -> 115
    //   325: astore_1
    //   326: aconst_null
    //   327: astore_0
    //   328: aconst_null
    //   329: astore_3
    //   330: goto -215 -> 115
    //   333: astore_1
    //   334: aconst_null
    //   335: astore_0
    //   336: goto -221 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramFile1	File
    //   0	339	1	paramFile2	File
    //   84	24	2	i	int
    //   34	296	3	localObject1	Object
    //   24	297	4	localObject2	Object
    //   13	297	5	localObject3	Object
    //   56	238	6	localObject4	Object
    //   52	238	7	localObject5	Object
    //   48	239	8	localObject6	Object
    //   45	239	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   58	64	114	java/lang/Exception
    //   78	85	114	java/lang/Exception
    //   104	111	114	java/lang/Exception
    //   192	196	114	java/lang/Exception
    //   5	15	221	finally
    //   15	26	257	finally
    //   26	35	268	finally
    //   35	44	276	finally
    //   58	64	282	finally
    //   78	85	282	finally
    //   104	111	282	finally
    //   129	153	282	finally
    //   192	196	282	finally
    //   5	15	300	java/lang/Exception
    //   15	26	314	java/lang/Exception
    //   26	35	325	java/lang/Exception
    //   35	44	333	java/lang/Exception
  }
  
  public static boolean pc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156993);
    File localFile = new File(paramString2);
    if ((!localFile.isDirectory()) || (!localFile.exists())) {
      localFile.mkdirs();
    }
    paramString1 = new File(paramString1).listFiles();
    if (paramString1 == null)
    {
      AppMethodBeat.o(156993);
      return false;
    }
    int i = 0;
    while (i < paramString1.length)
    {
      if ((paramString1[i].isFile()) && (!f(paramString1[i], new File(new File(paramString2).getAbsolutePath() + File.separator + paramString1[i].getName()))))
      {
        AppMethodBeat.o(156993);
        return false;
      }
      paramString1[i].isDirectory();
      i += 1;
    }
    AppMethodBeat.o(156993);
    return true;
  }
  
  public static boolean pd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156994);
    Object localObject = new File(paramString2);
    if ((!((File)localObject).isDirectory()) || (!((File)localObject).exists())) {
      ((File)localObject).mkdirs();
    }
    localObject = new File(paramString1).listFiles();
    if (localObject == null)
    {
      AppMethodBeat.o(156994);
      return false;
    }
    int i = 0;
    while (i < localObject.length)
    {
      if ((localObject[i].isFile()) && (!f(localObject[i], new File(new File(paramString2).getAbsolutePath() + File.separator + localObject[i].getName()))))
      {
        AppMethodBeat.o(156994);
        return false;
      }
      if ((localObject[i].isDirectory()) && (!pd(paramString1 + "/" + localObject[i].getName(), paramString2 + "/" + localObject[i].getName())))
      {
        AppMethodBeat.o(156994);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(156994);
    return true;
  }
  
  public static void tryClose(Closeable paramCloseable)
  {
    AppMethodBeat.i(156998);
    if (paramCloseable == null)
    {
      AppMethodBeat.o(156998);
      return;
    }
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(156998);
      return;
    }
    catch (Exception paramCloseable)
    {
      Log.e("FileUtils", "closeable close  failed " + paramCloseable.getMessage());
      AppMethodBeat.o(156998);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.util.c
 * JD-Core Version:    0.7.0.1
 */