package com.tencent.xweb.util;

import android.content.res.AssetFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import org.xwalk.core.Log;

public final class b
{
  public static void a(AssetFileDescriptor paramAssetFileDescriptor)
  {
    AppMethodBeat.i(4008);
    if (paramAssetFileDescriptor != null) {
      try
      {
        paramAssetFileDescriptor.close();
        AppMethodBeat.o(4008);
        return;
      }
      catch (Exception paramAssetFileDescriptor)
      {
        Log.e("FileUtils", "tryClose AssetFileDescriptor error: " + paramAssetFileDescriptor.getMessage());
      }
    }
    AppMethodBeat.o(4008);
  }
  
  /* Error */
  public static boolean a(AssetFileDescriptor paramAssetFileDescriptor, File paramFile)
  {
    // Byte code:
    //   0: sipush 4009
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +18 -> 25
    //   10: ldc 25
    //   12: ldc 54
    //   14: invokestatic 50	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: sipush 4009
    //   20: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_1
    //   26: invokevirtual 60	java/io/File:exists	()Z
    //   29: ifeq +8 -> 37
    //   32: aload_1
    //   33: invokevirtual 63	java/io/File:delete	()Z
    //   36: pop
    //   37: new 65	java/io/FileOutputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 68	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   45: astore_3
    //   46: aload_0
    //   47: invokevirtual 72	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   50: astore_1
    //   51: aload_1
    //   52: astore 5
    //   54: aload_3
    //   55: astore 4
    //   57: ldc 73
    //   59: newarray byte
    //   61: astore 6
    //   63: aload_1
    //   64: astore 5
    //   66: aload_3
    //   67: astore 4
    //   69: aload_1
    //   70: aload 6
    //   72: invokevirtual 79	java/io/FileInputStream:read	([B)I
    //   75: istore_2
    //   76: iload_2
    //   77: iconst_m1
    //   78: if_icmpeq +73 -> 151
    //   81: aload_1
    //   82: astore 5
    //   84: aload_3
    //   85: astore 4
    //   87: aload_3
    //   88: aload 6
    //   90: iconst_0
    //   91: iload_2
    //   92: invokevirtual 83	java/io/FileOutputStream:write	([BII)V
    //   95: goto -32 -> 63
    //   98: astore 6
    //   100: aload_1
    //   101: astore 5
    //   103: aload_3
    //   104: astore 4
    //   106: ldc 25
    //   108: new 27	java/lang/StringBuilder
    //   111: dup
    //   112: ldc 85
    //   114: invokespecial 33	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload 6
    //   119: invokevirtual 37	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   122: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 50	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_3
    //   132: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   135: aload_1
    //   136: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   139: aload_0
    //   140: invokestatic 91	com/tencent/xweb/util/b:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   143: sipush 4009
    //   146: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: iconst_0
    //   150: ireturn
    //   151: aload_1
    //   152: astore 5
    //   154: aload_3
    //   155: astore 4
    //   157: aload_3
    //   158: invokevirtual 94	java/io/FileOutputStream:flush	()V
    //   161: aload_3
    //   162: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   165: aload_1
    //   166: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   169: aload_0
    //   170: invokestatic 91	com/tencent/xweb/util/b:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   173: sipush 4009
    //   176: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: iconst_1
    //   180: ireturn
    //   181: astore_1
    //   182: aconst_null
    //   183: astore 5
    //   185: aconst_null
    //   186: astore_3
    //   187: aload_3
    //   188: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   191: aload 5
    //   193: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   196: aload_0
    //   197: invokestatic 91	com/tencent/xweb/util/b:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   200: sipush 4009
    //   203: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_1
    //   207: athrow
    //   208: astore_1
    //   209: aconst_null
    //   210: astore 5
    //   212: goto -25 -> 187
    //   215: astore_1
    //   216: aload 4
    //   218: astore_3
    //   219: goto -32 -> 187
    //   222: astore 6
    //   224: aconst_null
    //   225: astore_1
    //   226: aconst_null
    //   227: astore_3
    //   228: goto -128 -> 100
    //   231: astore 6
    //   233: aconst_null
    //   234: astore_1
    //   235: goto -135 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramAssetFileDescriptor	AssetFileDescriptor
    //   0	238	1	paramFile	File
    //   75	17	2	i	int
    //   45	183	3	localObject1	Object
    //   55	162	4	localObject2	Object
    //   52	159	5	localFile	File
    //   61	28	6	arrayOfByte	byte[]
    //   98	20	6	localException1	Exception
    //   222	1	6	localException2	Exception
    //   231	1	6	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   57	63	98	java/lang/Exception
    //   69	76	98	java/lang/Exception
    //   87	95	98	java/lang/Exception
    //   157	161	98	java/lang/Exception
    //   25	37	181	finally
    //   37	46	181	finally
    //   46	51	208	finally
    //   57	63	215	finally
    //   69	76	215	finally
    //   87	95	215	finally
    //   106	131	215	finally
    //   157	161	215	finally
    //   25	37	222	java/lang/Exception
    //   37	46	222	java/lang/Exception
    //   46	51	231	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(java.io.InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: sipush 4010
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +18 -> 25
    //   10: ldc 25
    //   12: ldc 97
    //   14: invokestatic 50	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: sipush 4010
    //   20: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aconst_null
    //   26: astore 4
    //   28: aconst_null
    //   29: astore 5
    //   31: aload 4
    //   33: astore_3
    //   34: aload_1
    //   35: invokevirtual 60	java/io/File:exists	()Z
    //   38: ifeq +11 -> 49
    //   41: aload 4
    //   43: astore_3
    //   44: aload_1
    //   45: invokevirtual 63	java/io/File:delete	()Z
    //   48: pop
    //   49: aload 4
    //   51: astore_3
    //   52: new 65	java/io/FileOutputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 68	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   60: astore_1
    //   61: ldc 73
    //   63: newarray byte
    //   65: astore_3
    //   66: aload_0
    //   67: aload_3
    //   68: invokevirtual 100	java/io/InputStream:read	([B)I
    //   71: istore_2
    //   72: iload_2
    //   73: iconst_m1
    //   74: if_icmpeq +58 -> 132
    //   77: aload_1
    //   78: aload_3
    //   79: iconst_0
    //   80: iload_2
    //   81: invokevirtual 83	java/io/FileOutputStream:write	([BII)V
    //   84: goto -18 -> 66
    //   87: astore 4
    //   89: aload_1
    //   90: astore_3
    //   91: ldc 25
    //   93: new 27	java/lang/StringBuilder
    //   96: dup
    //   97: ldc 102
    //   99: invokespecial 33	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   102: aload 4
    //   104: invokevirtual 37	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   107: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 50	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_1
    //   117: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   120: aload_0
    //   121: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   124: sipush 4010
    //   127: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: iconst_0
    //   131: ireturn
    //   132: aload_1
    //   133: invokevirtual 94	java/io/FileOutputStream:flush	()V
    //   136: aload_1
    //   137: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   140: aload_0
    //   141: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   144: sipush 4010
    //   147: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: iconst_1
    //   151: ireturn
    //   152: astore_1
    //   153: aload_3
    //   154: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   157: aload_0
    //   158: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   161: sipush 4010
    //   164: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload_1
    //   168: athrow
    //   169: astore 4
    //   171: aload_1
    //   172: astore_3
    //   173: aload 4
    //   175: astore_1
    //   176: goto -23 -> 153
    //   179: astore 4
    //   181: aload 5
    //   183: astore_1
    //   184: goto -95 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	paramInputStream	java.io.InputStream
    //   0	187	1	paramFile	File
    //   71	10	2	i	int
    //   33	140	3	localObject1	Object
    //   26	24	4	localObject2	Object
    //   87	16	4	localException1	Exception
    //   169	5	4	localObject3	Object
    //   179	1	4	localException2	Exception
    //   29	153	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   61	66	87	java/lang/Exception
    //   66	72	87	java/lang/Exception
    //   77	84	87	java/lang/Exception
    //   132	136	87	java/lang/Exception
    //   34	41	152	finally
    //   44	49	152	finally
    //   52	61	152	finally
    //   91	116	152	finally
    //   61	66	169	finally
    //   66	72	169	finally
    //   77	84	169	finally
    //   132	136	169	finally
    //   34	41	179	java/lang/Exception
    //   44	49	179	java/lang/Exception
    //   52	61	179	java/lang/Exception
  }
  
  public static boolean ayf(String paramString)
  {
    AppMethodBeat.i(4005);
    try
    {
      deleteAll(new File(paramString));
      AppMethodBeat.o(4005);
      return true;
    }
    catch (Exception localException)
    {
      Log.i("FileUtils", String.format("delete all files.(%s)", new Object[] { paramString }));
      AppMethodBeat.o(4005);
    }
    return false;
  }
  
  /* Error */
  public static boolean copyFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 4001
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 75	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 123	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 127	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   19: astore 6
    //   21: new 65	java/io/FileOutputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 128	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   29: astore_3
    //   30: aload_3
    //   31: invokevirtual 129	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   34: astore 4
    //   36: aload 4
    //   38: aload 6
    //   40: lconst_0
    //   41: aload 6
    //   43: invokevirtual 135	java/nio/channels/FileChannel:size	()J
    //   46: invokevirtual 139	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   49: pop2
    //   50: aload 4
    //   52: iconst_1
    //   53: invokevirtual 143	java/nio/channels/FileChannel:force	(Z)V
    //   56: aload_2
    //   57: invokevirtual 144	java/io/FileInputStream:close	()V
    //   60: aload_3
    //   61: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   64: aload 6
    //   66: ifnull +8 -> 74
    //   69: aload 6
    //   71: invokevirtual 146	java/nio/channels/FileChannel:close	()V
    //   74: aload 4
    //   76: ifnull +8 -> 84
    //   79: aload 4
    //   81: invokevirtual 146	java/nio/channels/FileChannel:close	()V
    //   84: sipush 4001
    //   87: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: iconst_1
    //   91: ireturn
    //   92: astore 5
    //   94: aconst_null
    //   95: astore_2
    //   96: aconst_null
    //   97: astore 4
    //   99: aconst_null
    //   100: astore_3
    //   101: aconst_null
    //   102: astore 6
    //   104: ldc 25
    //   106: ldc 148
    //   108: iconst_4
    //   109: anewarray 4	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: aload 5
    //   116: invokevirtual 152	java/lang/Object:getClass	()Ljava/lang/Class;
    //   119: invokevirtual 157	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: aload 5
    //   127: invokevirtual 37	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   130: aastore
    //   131: dup
    //   132: iconst_2
    //   133: aload_0
    //   134: aastore
    //   135: dup
    //   136: iconst_3
    //   137: aload_1
    //   138: aastore
    //   139: invokestatic 116	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   142: invokestatic 50	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload 4
    //   147: ifnull +8 -> 155
    //   150: aload 4
    //   152: invokevirtual 144	java/io/FileInputStream:close	()V
    //   155: aload_2
    //   156: ifnull +7 -> 163
    //   159: aload_2
    //   160: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   163: aload 6
    //   165: ifnull +8 -> 173
    //   168: aload 6
    //   170: invokevirtual 146	java/nio/channels/FileChannel:close	()V
    //   173: aload_3
    //   174: ifnull +7 -> 181
    //   177: aload_3
    //   178: invokevirtual 146	java/nio/channels/FileChannel:close	()V
    //   181: sipush 4001
    //   184: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: iconst_0
    //   188: ireturn
    //   189: astore_0
    //   190: aconst_null
    //   191: astore_2
    //   192: aconst_null
    //   193: astore 4
    //   195: aconst_null
    //   196: astore_3
    //   197: aconst_null
    //   198: astore 6
    //   200: aload 4
    //   202: ifnull +8 -> 210
    //   205: aload 4
    //   207: invokevirtual 144	java/io/FileInputStream:close	()V
    //   210: aload_2
    //   211: ifnull +7 -> 218
    //   214: aload_2
    //   215: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   218: aload 6
    //   220: ifnull +8 -> 228
    //   223: aload 6
    //   225: invokevirtual 146	java/nio/channels/FileChannel:close	()V
    //   228: aload_3
    //   229: ifnull +7 -> 236
    //   232: aload_3
    //   233: invokevirtual 146	java/nio/channels/FileChannel:close	()V
    //   236: sipush 4001
    //   239: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: aload_0
    //   243: athrow
    //   244: astore_0
    //   245: goto -185 -> 60
    //   248: astore_0
    //   249: goto -185 -> 64
    //   252: astore_0
    //   253: goto -179 -> 74
    //   256: astore_0
    //   257: goto -173 -> 84
    //   260: astore_0
    //   261: goto -106 -> 155
    //   264: astore_0
    //   265: goto -102 -> 163
    //   268: astore_0
    //   269: goto -96 -> 173
    //   272: astore_0
    //   273: goto -92 -> 181
    //   276: astore_1
    //   277: goto -67 -> 210
    //   280: astore_1
    //   281: goto -63 -> 218
    //   284: astore_1
    //   285: goto -57 -> 228
    //   288: astore_1
    //   289: goto -53 -> 236
    //   292: astore_0
    //   293: aconst_null
    //   294: astore_1
    //   295: aload_2
    //   296: astore 4
    //   298: aconst_null
    //   299: astore_3
    //   300: aconst_null
    //   301: astore 6
    //   303: aload_1
    //   304: astore_2
    //   305: goto -105 -> 200
    //   308: astore_0
    //   309: aconst_null
    //   310: astore_1
    //   311: aload_2
    //   312: astore 4
    //   314: aconst_null
    //   315: astore_3
    //   316: aload_1
    //   317: astore_2
    //   318: goto -118 -> 200
    //   321: astore_0
    //   322: aload_2
    //   323: astore 4
    //   325: aconst_null
    //   326: astore_1
    //   327: aload_3
    //   328: astore_2
    //   329: aload_1
    //   330: astore_3
    //   331: goto -131 -> 200
    //   334: astore_0
    //   335: aload_2
    //   336: astore_1
    //   337: aload 4
    //   339: astore 5
    //   341: aload_3
    //   342: astore_2
    //   343: aload_1
    //   344: astore 4
    //   346: aload 5
    //   348: astore_3
    //   349: goto -149 -> 200
    //   352: astore_0
    //   353: goto -153 -> 200
    //   356: astore 5
    //   358: aconst_null
    //   359: astore 7
    //   361: aload_2
    //   362: astore 4
    //   364: aconst_null
    //   365: astore_3
    //   366: aconst_null
    //   367: astore 6
    //   369: aload 7
    //   371: astore_2
    //   372: goto -268 -> 104
    //   375: astore 5
    //   377: aconst_null
    //   378: astore 7
    //   380: aload_2
    //   381: astore 4
    //   383: aconst_null
    //   384: astore_3
    //   385: aload 7
    //   387: astore_2
    //   388: goto -284 -> 104
    //   391: astore 5
    //   393: aload_2
    //   394: astore 4
    //   396: aconst_null
    //   397: astore 7
    //   399: aload_3
    //   400: astore_2
    //   401: aload 7
    //   403: astore_3
    //   404: goto -300 -> 104
    //   407: astore 5
    //   409: aload_2
    //   410: astore 7
    //   412: aload 4
    //   414: astore 8
    //   416: aload_3
    //   417: astore_2
    //   418: aload 7
    //   420: astore 4
    //   422: aload 8
    //   424: astore_3
    //   425: goto -321 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	paramString1	String
    //   0	428	1	paramString2	String
    //   14	404	2	localObject1	Object
    //   29	396	3	localObject2	Object
    //   34	387	4	localObject3	Object
    //   92	34	5	localException1	Exception
    //   339	8	5	localObject4	Object
    //   356	1	5	localException2	Exception
    //   375	1	5	localException3	Exception
    //   391	1	5	localException4	Exception
    //   407	1	5	localException5	Exception
    //   19	349	6	localFileChannel	java.nio.channels.FileChannel
    //   359	60	7	localObject5	Object
    //   414	9	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   6	15	92	java/lang/Exception
    //   6	15	189	finally
    //   56	60	244	java/lang/Exception
    //   60	64	248	java/lang/Exception
    //   69	74	252	java/io/IOException
    //   79	84	256	java/io/IOException
    //   150	155	260	java/lang/Exception
    //   159	163	264	java/lang/Exception
    //   168	173	268	java/io/IOException
    //   177	181	272	java/io/IOException
    //   205	210	276	java/lang/Exception
    //   214	218	280	java/lang/Exception
    //   223	228	284	java/io/IOException
    //   232	236	288	java/io/IOException
    //   15	21	292	finally
    //   21	30	308	finally
    //   30	36	321	finally
    //   36	56	334	finally
    //   104	145	352	finally
    //   15	21	356	java/lang/Exception
    //   21	30	375	java/lang/Exception
    //   30	36	391	java/lang/Exception
    //   36	56	407	java/lang/Exception
  }
  
  private static void deleteAll(File paramFile)
  {
    AppMethodBeat.i(4006);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(4006);
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
      AppMethodBeat.o(4006);
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
              break label113;
            }
            localFile.delete();
          }
          for (;;)
          {
            i += 1;
            break;
            label113:
            deleteAll(localFile);
          }
        }
      }
      paramFile.delete();
    }
    AppMethodBeat.o(4006);
  }
  
  public static boolean deleteFile(String paramString)
  {
    AppMethodBeat.i(4004);
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isFile()))
    {
      paramString.delete();
      AppMethodBeat.o(4004);
      return true;
    }
    AppMethodBeat.o(4004);
    return false;
  }
  
  public static boolean jd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4003);
    Object localObject = new File(paramString2);
    if ((!((File)localObject).isDirectory()) || (!((File)localObject).exists())) {
      ((File)localObject).mkdirs();
    }
    localObject = new File(paramString1).listFiles();
    if (localObject == null)
    {
      AppMethodBeat.o(4003);
      return false;
    }
    int i = 0;
    while (i < localObject.length)
    {
      if ((localObject[i].isFile()) && (!m(localObject[i], new File(new File(paramString2).getAbsolutePath() + File.separator + localObject[i].getName()))))
      {
        AppMethodBeat.o(4003);
        return false;
      }
      if ((localObject[i].isDirectory()) && (jd(paramString1 + "/" + localObject[i].getName(), paramString2 + "/" + localObject[i].getName())))
      {
        AppMethodBeat.o(4003);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(4003);
    return true;
  }
  
  /* Error */
  public static boolean m(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: sipush 4002
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 75	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 193	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore 5
    //   16: new 195	java/io/BufferedInputStream
    //   19: dup
    //   20: aload 5
    //   22: invokespecial 198	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore 4
    //   27: new 65	java/io/FileOutputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 68	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: astore_3
    //   36: new 200	java/io/BufferedOutputStream
    //   39: dup
    //   40: aload_3
    //   41: invokespecial 203	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   44: astore_0
    //   45: aload_0
    //   46: astore 9
    //   48: aload_3
    //   49: astore 8
    //   51: aload 4
    //   53: astore 7
    //   55: aload 5
    //   57: astore 6
    //   59: sipush 5120
    //   62: newarray byte
    //   64: astore_1
    //   65: aload_0
    //   66: astore 9
    //   68: aload_3
    //   69: astore 8
    //   71: aload 4
    //   73: astore 7
    //   75: aload 5
    //   77: astore 6
    //   79: aload 4
    //   81: aload_1
    //   82: invokevirtual 204	java/io/BufferedInputStream:read	([B)I
    //   85: istore_2
    //   86: iload_2
    //   87: iconst_m1
    //   88: if_icmpeq +92 -> 180
    //   91: aload_0
    //   92: astore 9
    //   94: aload_3
    //   95: astore 8
    //   97: aload 4
    //   99: astore 7
    //   101: aload 5
    //   103: astore 6
    //   105: aload_0
    //   106: aload_1
    //   107: iconst_0
    //   108: iload_2
    //   109: invokevirtual 205	java/io/BufferedOutputStream:write	([BII)V
    //   112: goto -47 -> 65
    //   115: astore_1
    //   116: aload_0
    //   117: astore 9
    //   119: aload_3
    //   120: astore 8
    //   122: aload 4
    //   124: astore 7
    //   126: aload 5
    //   128: astore 6
    //   130: ldc 25
    //   132: new 27	java/lang/StringBuilder
    //   135: dup
    //   136: ldc 207
    //   138: invokespecial 33	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   141: aload_1
    //   142: invokevirtual 37	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   145: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 50	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload 4
    //   156: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   159: aload_0
    //   160: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   163: aload 5
    //   165: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   168: aload_3
    //   169: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   172: sipush 4002
    //   175: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: iconst_0
    //   179: ireturn
    //   180: aload_0
    //   181: astore 9
    //   183: aload_3
    //   184: astore 8
    //   186: aload 4
    //   188: astore 7
    //   190: aload 5
    //   192: astore 6
    //   194: aload_0
    //   195: invokevirtual 208	java/io/BufferedOutputStream:flush	()V
    //   198: aload 4
    //   200: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   203: aload_0
    //   204: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   207: aload 5
    //   209: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   212: aload_3
    //   213: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   216: sipush 4002
    //   219: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: iconst_1
    //   223: ireturn
    //   224: astore_0
    //   225: aconst_null
    //   226: astore_1
    //   227: aconst_null
    //   228: astore_3
    //   229: aconst_null
    //   230: astore 4
    //   232: aconst_null
    //   233: astore 5
    //   235: aload 4
    //   237: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   240: aload_1
    //   241: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   244: aload 5
    //   246: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   249: aload_3
    //   250: invokestatic 89	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   253: sipush 4002
    //   256: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: aload_0
    //   260: athrow
    //   261: astore_0
    //   262: aconst_null
    //   263: astore_1
    //   264: aconst_null
    //   265: astore_3
    //   266: aconst_null
    //   267: astore 4
    //   269: goto -34 -> 235
    //   272: astore_0
    //   273: aconst_null
    //   274: astore_1
    //   275: aconst_null
    //   276: astore_3
    //   277: goto -42 -> 235
    //   280: astore_0
    //   281: aconst_null
    //   282: astore_1
    //   283: goto -48 -> 235
    //   286: astore_0
    //   287: aload 9
    //   289: astore_1
    //   290: aload 8
    //   292: astore_3
    //   293: aload 7
    //   295: astore 4
    //   297: aload 6
    //   299: astore 5
    //   301: goto -66 -> 235
    //   304: astore_1
    //   305: aconst_null
    //   306: astore_0
    //   307: aconst_null
    //   308: astore_3
    //   309: aconst_null
    //   310: astore 4
    //   312: aconst_null
    //   313: astore 5
    //   315: goto -199 -> 116
    //   318: astore_1
    //   319: aconst_null
    //   320: astore_0
    //   321: aconst_null
    //   322: astore_3
    //   323: aconst_null
    //   324: astore 4
    //   326: goto -210 -> 116
    //   329: astore_1
    //   330: aconst_null
    //   331: astore_0
    //   332: aconst_null
    //   333: astore_3
    //   334: goto -218 -> 116
    //   337: astore_1
    //   338: aconst_null
    //   339: astore_0
    //   340: goto -224 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	paramFile1	File
    //   0	343	1	paramFile2	File
    //   85	24	2	i	int
    //   35	299	3	localObject1	Object
    //   25	300	4	localObject2	Object
    //   14	300	5	localObject3	Object
    //   57	241	6	localObject4	Object
    //   53	241	7	localObject5	Object
    //   49	242	8	localObject6	Object
    //   46	242	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   59	65	115	java/lang/Exception
    //   79	86	115	java/lang/Exception
    //   105	112	115	java/lang/Exception
    //   194	198	115	java/lang/Exception
    //   6	16	224	finally
    //   16	27	261	finally
    //   27	36	272	finally
    //   36	45	280	finally
    //   59	65	286	finally
    //   79	86	286	finally
    //   105	112	286	finally
    //   130	154	286	finally
    //   194	198	286	finally
    //   6	16	304	java/lang/Exception
    //   16	27	318	java/lang/Exception
    //   27	36	329	java/lang/Exception
    //   36	45	337	java/lang/Exception
  }
  
  public static void tryClose(Closeable paramCloseable)
  {
    AppMethodBeat.i(4007);
    if (paramCloseable == null)
    {
      AppMethodBeat.o(4007);
      return;
    }
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(4007);
      return;
    }
    catch (Exception paramCloseable)
    {
      Log.e("FileUtils", "closeable close  failed " + paramCloseable.getMessage());
      AppMethodBeat.o(4007);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.util.b
 * JD-Core Version:    0.7.0.1
 */