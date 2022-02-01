package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class MMNativeWebP
{
  public static final String TAG = "MMWEBP.JAVA";
  public static final int WEBP_MIN_HEADER_SIZE = 256;
  
  /* Error */
  public static Bitmap DecodeWebPFile(String paramString)
  {
    // Byte code:
    //   0: ldc 25
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 33	com/tencent/mm/vfs/o
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 36	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 40	com/tencent/mm/vfs/o:exists	()Z
    //   18: ifne +25 -> 43
    //   21: ldc 8
    //   23: ldc 42
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: aastore
    //   33: invokestatic 48	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: ldc 25
    //   38: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aconst_null
    //   42: areturn
    //   43: aload_2
    //   44: invokevirtual 55	com/tencent/mm/vfs/o:length	()J
    //   47: ldc2_w 56
    //   50: lcmp
    //   51: ifgt +25 -> 76
    //   54: ldc 8
    //   56: ldc 59
    //   58: iconst_1
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_0
    //   65: aastore
    //   66: invokestatic 48	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: ldc 25
    //   71: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aconst_null
    //   75: areturn
    //   76: new 61	java/io/ByteArrayOutputStream
    //   79: dup
    //   80: aload_2
    //   81: invokevirtual 55	com/tencent/mm/vfs/o:length	()J
    //   84: l2i
    //   85: invokespecial 63	java/io/ByteArrayOutputStream:<init>	(I)V
    //   88: astore_0
    //   89: new 65	java/io/BufferedInputStream
    //   92: dup
    //   93: aload_2
    //   94: invokestatic 71	com/tencent/mm/vfs/s:ao	(Lcom/tencent/mm/vfs/o;)Ljava/io/InputStream;
    //   97: invokespecial 74	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   100: astore 4
    //   102: aload 4
    //   104: astore_3
    //   105: aload_0
    //   106: astore_2
    //   107: sipush 4096
    //   110: newarray byte
    //   112: astore 5
    //   114: aload 4
    //   116: astore_3
    //   117: aload_0
    //   118: astore_2
    //   119: aload 4
    //   121: aload 5
    //   123: iconst_0
    //   124: sipush 4096
    //   127: invokevirtual 78	java/io/BufferedInputStream:read	([BII)I
    //   130: istore_1
    //   131: iload_1
    //   132: iconst_m1
    //   133: if_icmpeq +36 -> 169
    //   136: aload 4
    //   138: astore_3
    //   139: aload_0
    //   140: astore_2
    //   141: aload_0
    //   142: aload 5
    //   144: iconst_0
    //   145: iload_1
    //   146: invokevirtual 82	java/io/ByteArrayOutputStream:write	([BII)V
    //   149: aload 4
    //   151: astore_3
    //   152: aload_0
    //   153: astore_2
    //   154: aload 4
    //   156: aload 5
    //   158: iconst_0
    //   159: sipush 4096
    //   162: invokevirtual 78	java/io/BufferedInputStream:read	([BII)I
    //   165: istore_1
    //   166: goto -35 -> 131
    //   169: aload 4
    //   171: astore_3
    //   172: aload_0
    //   173: astore_2
    //   174: aload_0
    //   175: invokevirtual 86	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   178: aconst_null
    //   179: invokestatic 90	com/tencent/mm/sdk/platformtools/MMNativeWebP:nativeDecodeByteArray	([BLandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   182: astore 5
    //   184: aload_0
    //   185: invokevirtual 93	java/io/ByteArrayOutputStream:close	()V
    //   188: aload 4
    //   190: invokevirtual 94	java/io/BufferedInputStream:close	()V
    //   193: ldc 25
    //   195: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload 5
    //   200: areturn
    //   201: astore 5
    //   203: aconst_null
    //   204: astore 4
    //   206: aconst_null
    //   207: astore_0
    //   208: aload 4
    //   210: astore_3
    //   211: aload_0
    //   212: astore_2
    //   213: ldc 8
    //   215: aload 5
    //   217: invokestatic 98	com/tencent/mm/sdk/platformtools/MMNativeWebP:exception2String	(Ljava/lang/Exception;)Ljava/lang/String;
    //   220: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_0
    //   224: ifnull +7 -> 231
    //   227: aload_0
    //   228: invokevirtual 93	java/io/ByteArrayOutputStream:close	()V
    //   231: aload 4
    //   233: ifnull +8 -> 241
    //   236: aload 4
    //   238: invokevirtual 94	java/io/BufferedInputStream:close	()V
    //   241: ldc 25
    //   243: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aconst_null
    //   247: areturn
    //   248: astore 5
    //   250: aconst_null
    //   251: astore 4
    //   253: aconst_null
    //   254: astore_0
    //   255: aload 4
    //   257: astore_3
    //   258: aload_0
    //   259: astore_2
    //   260: ldc 8
    //   262: aload 5
    //   264: invokestatic 98	com/tencent/mm/sdk/platformtools/MMNativeWebP:exception2String	(Ljava/lang/Exception;)Ljava/lang/String;
    //   267: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload_0
    //   271: ifnull +7 -> 278
    //   274: aload_0
    //   275: invokevirtual 93	java/io/ByteArrayOutputStream:close	()V
    //   278: aload 4
    //   280: ifnull +8 -> 288
    //   283: aload 4
    //   285: invokevirtual 94	java/io/BufferedInputStream:close	()V
    //   288: ldc 25
    //   290: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   293: aconst_null
    //   294: areturn
    //   295: astore 5
    //   297: aconst_null
    //   298: astore 4
    //   300: aconst_null
    //   301: astore_0
    //   302: aload 4
    //   304: astore_3
    //   305: aload_0
    //   306: astore_2
    //   307: ldc 8
    //   309: aload 5
    //   311: invokestatic 98	com/tencent/mm/sdk/platformtools/MMNativeWebP:exception2String	(Ljava/lang/Exception;)Ljava/lang/String;
    //   314: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload_0
    //   318: ifnull +7 -> 325
    //   321: aload_0
    //   322: invokevirtual 93	java/io/ByteArrayOutputStream:close	()V
    //   325: aload 4
    //   327: ifnull +8 -> 335
    //   330: aload 4
    //   332: invokevirtual 94	java/io/BufferedInputStream:close	()V
    //   335: ldc 25
    //   337: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: aconst_null
    //   341: areturn
    //   342: astore 4
    //   344: aconst_null
    //   345: astore_3
    //   346: aconst_null
    //   347: astore_0
    //   348: aload_0
    //   349: ifnull +7 -> 356
    //   352: aload_0
    //   353: invokevirtual 93	java/io/ByteArrayOutputStream:close	()V
    //   356: aload_3
    //   357: ifnull +7 -> 364
    //   360: aload_3
    //   361: invokevirtual 94	java/io/BufferedInputStream:close	()V
    //   364: ldc 25
    //   366: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   369: aload 4
    //   371: athrow
    //   372: astore_0
    //   373: goto -185 -> 188
    //   376: astore_0
    //   377: goto -184 -> 193
    //   380: astore_0
    //   381: goto -150 -> 231
    //   384: astore_0
    //   385: goto -144 -> 241
    //   388: astore_0
    //   389: goto -111 -> 278
    //   392: astore_0
    //   393: goto -105 -> 288
    //   396: astore_0
    //   397: goto -72 -> 325
    //   400: astore_0
    //   401: goto -66 -> 335
    //   404: astore_0
    //   405: goto -49 -> 356
    //   408: astore_0
    //   409: goto -45 -> 364
    //   412: astore 4
    //   414: aconst_null
    //   415: astore_3
    //   416: goto -68 -> 348
    //   419: astore 4
    //   421: aload_2
    //   422: astore_0
    //   423: goto -75 -> 348
    //   426: astore 5
    //   428: aconst_null
    //   429: astore 4
    //   431: goto -129 -> 302
    //   434: astore 5
    //   436: goto -134 -> 302
    //   439: astore 5
    //   441: aconst_null
    //   442: astore 4
    //   444: goto -189 -> 255
    //   447: astore 5
    //   449: goto -194 -> 255
    //   452: astore 5
    //   454: aconst_null
    //   455: astore 4
    //   457: goto -249 -> 208
    //   460: astore 5
    //   462: goto -254 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	paramString	String
    //   130	36	1	i	int
    //   13	409	2	localObject1	Object
    //   104	312	3	localBufferedInputStream1	java.io.BufferedInputStream
    //   100	231	4	localBufferedInputStream2	java.io.BufferedInputStream
    //   342	28	4	localObject2	Object
    //   412	1	4	localObject3	Object
    //   419	1	4	localObject4	Object
    //   429	27	4	localObject5	Object
    //   112	87	5	localObject6	Object
    //   201	15	5	localIOException1	java.io.IOException
    //   248	15	5	localNullPointerException1	java.lang.NullPointerException
    //   295	15	5	localRuntimeException1	java.lang.RuntimeException
    //   426	1	5	localRuntimeException2	java.lang.RuntimeException
    //   434	1	5	localRuntimeException3	java.lang.RuntimeException
    //   439	1	5	localNullPointerException2	java.lang.NullPointerException
    //   447	1	5	localNullPointerException3	java.lang.NullPointerException
    //   452	1	5	localIOException2	java.io.IOException
    //   460	1	5	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   76	89	201	java/io/IOException
    //   76	89	248	java/lang/NullPointerException
    //   76	89	295	java/lang/RuntimeException
    //   76	89	342	finally
    //   184	188	372	java/io/IOException
    //   188	193	376	java/io/IOException
    //   227	231	380	java/io/IOException
    //   236	241	384	java/io/IOException
    //   274	278	388	java/io/IOException
    //   283	288	392	java/io/IOException
    //   321	325	396	java/io/IOException
    //   330	335	400	java/io/IOException
    //   352	356	404	java/io/IOException
    //   360	364	408	java/io/IOException
    //   89	102	412	finally
    //   107	114	419	finally
    //   119	131	419	finally
    //   141	149	419	finally
    //   154	166	419	finally
    //   174	184	419	finally
    //   213	223	419	finally
    //   260	270	419	finally
    //   307	317	419	finally
    //   89	102	426	java/lang/RuntimeException
    //   107	114	434	java/lang/RuntimeException
    //   119	131	434	java/lang/RuntimeException
    //   141	149	434	java/lang/RuntimeException
    //   154	166	434	java/lang/RuntimeException
    //   174	184	434	java/lang/RuntimeException
    //   89	102	439	java/lang/NullPointerException
    //   107	114	447	java/lang/NullPointerException
    //   119	131	447	java/lang/NullPointerException
    //   141	149	447	java/lang/NullPointerException
    //   154	166	447	java/lang/NullPointerException
    //   174	184	447	java/lang/NullPointerException
    //   89	102	452	java/io/IOException
    //   107	114	460	java/io/IOException
    //   119	131	460	java/io/IOException
    //   141	149	460	java/io/IOException
    //   154	166	460	java/io/IOException
    //   174	184	460	java/io/IOException
  }
  
  /* Error */
  public static boolean IsWebPImageFile(String paramString)
  {
    // Byte code:
    //   0: ldc 105
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 33	com/tencent/mm/vfs/o
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 36	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 40	com/tencent/mm/vfs/o:exists	()Z
    //   18: ifne +25 -> 43
    //   21: ldc 8
    //   23: ldc 42
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: aastore
    //   33: invokestatic 48	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: ldc 105
    //   38: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: iconst_0
    //   42: ireturn
    //   43: aload_3
    //   44: invokevirtual 55	com/tencent/mm/vfs/o:length	()J
    //   47: ldc2_w 56
    //   50: lcmp
    //   51: ifgt +25 -> 76
    //   54: ldc 8
    //   56: ldc 59
    //   58: iconst_1
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_0
    //   65: aastore
    //   66: invokestatic 48	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: ldc 105
    //   71: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: iconst_0
    //   75: ireturn
    //   76: aconst_null
    //   77: astore_2
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_3
    //   81: invokestatic 71	com/tencent/mm/vfs/s:ao	(Lcom/tencent/mm/vfs/o;)Ljava/io/InputStream;
    //   84: astore_3
    //   85: aload_3
    //   86: astore_0
    //   87: aload_3
    //   88: astore_2
    //   89: sipush 256
    //   92: newarray byte
    //   94: astore 4
    //   96: aload_3
    //   97: astore_0
    //   98: aload_3
    //   99: astore_2
    //   100: aload_3
    //   101: aload 4
    //   103: invokevirtual 110	java/io/InputStream:read	([B)I
    //   106: pop
    //   107: aload_3
    //   108: ifnull +7 -> 115
    //   111: aload_3
    //   112: invokevirtual 111	java/io/InputStream:close	()V
    //   115: aload 4
    //   117: invokestatic 115	com/tencent/mm/sdk/platformtools/MMNativeWebP:nativeIsWebPImage	([B)Z
    //   120: istore_1
    //   121: ldc 105
    //   123: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: iload_1
    //   127: ireturn
    //   128: astore_3
    //   129: aload_0
    //   130: astore_2
    //   131: ldc 8
    //   133: aload_3
    //   134: invokestatic 98	com/tencent/mm/sdk/platformtools/MMNativeWebP:exception2String	(Ljava/lang/Exception;)Ljava/lang/String;
    //   137: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload_0
    //   141: ifnull +7 -> 148
    //   144: aload_0
    //   145: invokevirtual 111	java/io/InputStream:close	()V
    //   148: ldc 105
    //   150: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: iconst_0
    //   154: ireturn
    //   155: astore_0
    //   156: aload_2
    //   157: ifnull +7 -> 164
    //   160: aload_2
    //   161: invokevirtual 111	java/io/InputStream:close	()V
    //   164: ldc 105
    //   166: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_0
    //   170: athrow
    //   171: astore_0
    //   172: ldc 8
    //   174: ldc 117
    //   176: iconst_1
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload_0
    //   183: invokestatic 98	com/tencent/mm/sdk/platformtools/MMNativeWebP:exception2String	(Ljava/lang/Exception;)Ljava/lang/String;
    //   186: aastore
    //   187: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: ldc 105
    //   192: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: iconst_0
    //   196: ireturn
    //   197: astore_0
    //   198: ldc 8
    //   200: ldc 117
    //   202: iconst_1
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload_0
    //   209: invokestatic 98	com/tencent/mm/sdk/platformtools/MMNativeWebP:exception2String	(Ljava/lang/Exception;)Ljava/lang/String;
    //   212: aastore
    //   213: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: ldc 105
    //   218: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: iconst_0
    //   222: ireturn
    //   223: astore_0
    //   224: goto -109 -> 115
    //   227: astore_0
    //   228: goto -80 -> 148
    //   231: astore_2
    //   232: goto -68 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	paramString	String
    //   120	7	1	bool	boolean
    //   77	84	2	localObject1	Object
    //   231	1	2	localIOException1	java.io.IOException
    //   13	99	3	localObject2	Object
    //   128	6	3	localIOException2	java.io.IOException
    //   94	22	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   80	85	128	java/io/IOException
    //   89	96	128	java/io/IOException
    //   100	107	128	java/io/IOException
    //   80	85	155	finally
    //   89	96	155	finally
    //   100	107	155	finally
    //   131	140	155	finally
    //   115	121	171	java/lang/NullPointerException
    //   115	121	197	java/lang/RuntimeException
    //   111	115	223	java/io/IOException
    //   144	148	227	java/io/IOException
    //   160	164	231	java/io/IOException
  }
  
  /* Error */
  public static boolean SaveToWebPFile(Bitmap paramBitmap, int paramInt, String paramString)
  {
    // Byte code:
    //   0: ldc 122
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +10 -> 16
    //   9: aload_2
    //   10: invokevirtual 127	java/lang/String:length	()I
    //   13: ifne +10 -> 23
    //   16: ldc 122
    //   18: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: iconst_0
    //   22: ireturn
    //   23: aconst_null
    //   24: astore 8
    //   26: aconst_null
    //   27: astore 9
    //   29: aconst_null
    //   30: astore 10
    //   32: aconst_null
    //   33: astore 7
    //   35: aload 7
    //   37: astore 4
    //   39: aload 8
    //   41: astore 5
    //   43: aload 9
    //   45: astore 6
    //   47: aload 10
    //   49: astore_3
    //   50: aload_0
    //   51: iload_1
    //   52: invokestatic 131	com/tencent/mm/sdk/platformtools/MMNativeWebP:nativeEncodeBitmap	(Landroid/graphics/Bitmap;I)[B
    //   55: astore 11
    //   57: aload 11
    //   59: ifnull +77 -> 136
    //   62: aload 7
    //   64: astore 4
    //   66: aload 8
    //   68: astore 5
    //   70: aload 9
    //   72: astore 6
    //   74: aload 10
    //   76: astore_3
    //   77: new 33	com/tencent/mm/vfs/o
    //   80: dup
    //   81: aload_2
    //   82: invokespecial 36	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   85: invokestatic 135	com/tencent/mm/vfs/s:ap	(Lcom/tencent/mm/vfs/o;)Ljava/io/OutputStream;
    //   88: astore_0
    //   89: aload_0
    //   90: astore 4
    //   92: aload_0
    //   93: astore 5
    //   95: aload_0
    //   96: astore 6
    //   98: aload_0
    //   99: astore_3
    //   100: aload_0
    //   101: aload 11
    //   103: invokevirtual 140	java/io/OutputStream:write	([B)V
    //   106: aload_0
    //   107: astore 4
    //   109: aload_0
    //   110: astore 5
    //   112: aload_0
    //   113: astore 6
    //   115: aload_0
    //   116: astore_3
    //   117: aload_0
    //   118: invokevirtual 141	java/io/OutputStream:close	()V
    //   121: aload_0
    //   122: ifnull +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 141	java/io/OutputStream:close	()V
    //   129: ldc 122
    //   131: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: iconst_1
    //   135: ireturn
    //   136: ldc 122
    //   138: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: iconst_0
    //   142: ireturn
    //   143: astore_0
    //   144: aload 4
    //   146: astore_3
    //   147: ldc 8
    //   149: aload_0
    //   150: invokestatic 98	com/tencent/mm/sdk/platformtools/MMNativeWebP:exception2String	(Ljava/lang/Exception;)Ljava/lang/String;
    //   153: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload 4
    //   158: ifnull +8 -> 166
    //   161: aload 4
    //   163: invokevirtual 141	java/io/OutputStream:close	()V
    //   166: ldc 122
    //   168: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: iconst_0
    //   172: ireturn
    //   173: astore_0
    //   174: aload 5
    //   176: astore_3
    //   177: ldc 8
    //   179: aload_0
    //   180: invokestatic 98	com/tencent/mm/sdk/platformtools/MMNativeWebP:exception2String	(Ljava/lang/Exception;)Ljava/lang/String;
    //   183: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload 5
    //   188: ifnull +8 -> 196
    //   191: aload 5
    //   193: invokevirtual 141	java/io/OutputStream:close	()V
    //   196: ldc 122
    //   198: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: iconst_0
    //   202: ireturn
    //   203: astore_0
    //   204: aload 6
    //   206: astore_3
    //   207: ldc 8
    //   209: aload_0
    //   210: invokestatic 98	com/tencent/mm/sdk/platformtools/MMNativeWebP:exception2String	(Ljava/lang/Exception;)Ljava/lang/String;
    //   213: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload 6
    //   218: ifnull +8 -> 226
    //   221: aload 6
    //   223: invokevirtual 141	java/io/OutputStream:close	()V
    //   226: ldc 122
    //   228: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: iconst_0
    //   232: ireturn
    //   233: astore_0
    //   234: aload_3
    //   235: ifnull +7 -> 242
    //   238: aload_3
    //   239: invokevirtual 141	java/io/OutputStream:close	()V
    //   242: ldc 122
    //   244: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: aload_0
    //   248: athrow
    //   249: astore_0
    //   250: goto -121 -> 129
    //   253: astore_0
    //   254: goto -88 -> 166
    //   257: astore_0
    //   258: goto -62 -> 196
    //   261: astore_0
    //   262: goto -36 -> 226
    //   265: astore_2
    //   266: goto -24 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	paramBitmap	Bitmap
    //   0	269	1	paramInt	int
    //   0	269	2	paramString	String
    //   49	190	3	localObject1	Object
    //   37	125	4	localObject2	Object
    //   41	151	5	localObject3	Object
    //   45	177	6	localObject4	Object
    //   33	30	7	localObject5	Object
    //   24	43	8	localObject6	Object
    //   27	44	9	localObject7	Object
    //   30	45	10	localObject8	Object
    //   55	47	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   50	57	143	java/io/IOException
    //   77	89	143	java/io/IOException
    //   100	106	143	java/io/IOException
    //   117	121	143	java/io/IOException
    //   50	57	173	java/lang/NullPointerException
    //   77	89	173	java/lang/NullPointerException
    //   100	106	173	java/lang/NullPointerException
    //   117	121	173	java/lang/NullPointerException
    //   50	57	203	java/lang/RuntimeException
    //   77	89	203	java/lang/RuntimeException
    //   100	106	203	java/lang/RuntimeException
    //   117	121	203	java/lang/RuntimeException
    //   50	57	233	finally
    //   77	89	233	finally
    //   100	106	233	finally
    //   117	121	233	finally
    //   147	156	233	finally
    //   177	186	233	finally
    //   207	216	233	finally
    //   125	129	249	java/io/IOException
    //   161	166	253	java/io/IOException
    //   191	196	257	java/io/IOException
    //   221	226	261	java/io/IOException
    //   238	242	265	java/io/IOException
  }
  
  private static String exception2String(Exception paramException)
  {
    AppMethodBeat.i(215384);
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    paramException = localStringWriter.toString();
    AppMethodBeat.o(215384);
    return paramException;
  }
  
  public static native Bitmap nativeDecodeByteArray(byte[] paramArrayOfByte, BitmapFactory.Options paramOptions);
  
  public static native byte[] nativeEncodeBitmap(Bitmap paramBitmap, int paramInt);
  
  public static native boolean nativeIsWebPImage(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMNativeWebP
 * JD-Core Version:    0.7.0.1
 */