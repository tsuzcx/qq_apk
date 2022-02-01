package com.tencent.mm.pluginsdk.l;

import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public final class e
{
  /* Error */
  public static final String a(android.content.ContentResolver paramContentResolver, android.net.Uri paramUri, int paramInt)
  {
    // Byte code:
    //   0: sipush 31180
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: sipush 31180
    //   13: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 23	android/content/ContentResolver:getType	(Landroid/net/Uri;)Ljava/lang/String;
    //   23: astore_3
    //   24: new 25	com/tencent/mm/vfs/k
    //   27: dup
    //   28: invokestatic 31	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   31: invokevirtual 37	android/content/Context:getCacheDir	()Ljava/io/File;
    //   34: new 39	java/lang/StringBuilder
    //   37: dup
    //   38: ldc 41
    //   40: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: iload_2
    //   44: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: aload_3
    //   48: invokestatic 53	com/tencent/mm/pluginsdk/l/e:aNM	(Ljava/lang/String;)Ljava/lang/String;
    //   51: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 63	com/tencent/mm/vfs/k:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   60: astore 5
    //   62: aload 5
    //   64: invokevirtual 67	com/tencent/mm/vfs/k:delete	()Z
    //   67: pop
    //   68: aload 5
    //   70: invokestatic 73	com/tencent/mm/vfs/o:aj	(Lcom/tencent/mm/vfs/k;)Ljava/io/OutputStream;
    //   73: astore_3
    //   74: aload_0
    //   75: aload_1
    //   76: invokevirtual 77	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   79: astore_0
    //   80: aload_0
    //   81: ifnonnull +19 -> 100
    //   84: aload_0
    //   85: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   88: aload_3
    //   89: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   92: sipush 31180
    //   95: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aconst_null
    //   99: areturn
    //   100: aload_0
    //   101: astore 4
    //   103: aload_3
    //   104: astore_1
    //   105: sipush 1024
    //   108: newarray byte
    //   110: astore 6
    //   112: aload_0
    //   113: astore 4
    //   115: aload_3
    //   116: astore_1
    //   117: aload_0
    //   118: aload 6
    //   120: invokevirtual 89	java/io/InputStream:read	([B)I
    //   123: istore_2
    //   124: iload_2
    //   125: ifle +55 -> 180
    //   128: aload_0
    //   129: astore 4
    //   131: aload_3
    //   132: astore_1
    //   133: aload_3
    //   134: aload 6
    //   136: iconst_0
    //   137: iload_2
    //   138: invokevirtual 95	java/io/OutputStream:write	([BII)V
    //   141: goto -29 -> 112
    //   144: astore 5
    //   146: aload_0
    //   147: astore 4
    //   149: aload_3
    //   150: astore_1
    //   151: ldc 97
    //   153: aload 5
    //   155: ldc 99
    //   157: iconst_0
    //   158: anewarray 4	java/lang/Object
    //   161: invokestatic 105	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: aload_0
    //   165: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   168: aload_3
    //   169: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   172: sipush 31180
    //   175: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aconst_null
    //   179: areturn
    //   180: aload_0
    //   181: astore 4
    //   183: aload_3
    //   184: astore_1
    //   185: aload 5
    //   187: invokevirtual 109	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
    //   190: invokestatic 114	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   193: astore 5
    //   195: aload_0
    //   196: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   199: aload_3
    //   200: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   203: sipush 31180
    //   206: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: aload 5
    //   211: areturn
    //   212: astore_0
    //   213: aconst_null
    //   214: astore 4
    //   216: aconst_null
    //   217: astore_1
    //   218: aload 4
    //   220: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   223: aload_1
    //   224: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   227: sipush 31180
    //   230: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: aload_0
    //   234: athrow
    //   235: astore_0
    //   236: aconst_null
    //   237: astore 4
    //   239: aload_3
    //   240: astore_1
    //   241: goto -23 -> 218
    //   244: astore_0
    //   245: goto -27 -> 218
    //   248: astore 5
    //   250: aconst_null
    //   251: astore_0
    //   252: aconst_null
    //   253: astore_3
    //   254: goto -108 -> 146
    //   257: astore 5
    //   259: aconst_null
    //   260: astore_0
    //   261: goto -115 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramContentResolver	android.content.ContentResolver
    //   0	264	1	paramUri	android.net.Uri
    //   0	264	2	paramInt	int
    //   23	231	3	localObject	Object
    //   101	137	4	localContentResolver	android.content.ContentResolver
    //   60	9	5	localk	com.tencent.mm.vfs.k
    //   144	42	5	localException1	java.lang.Exception
    //   193	17	5	str	String
    //   248	1	5	localException2	java.lang.Exception
    //   257	1	5	localException3	java.lang.Exception
    //   110	25	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   105	112	144	java/lang/Exception
    //   117	124	144	java/lang/Exception
    //   133	141	144	java/lang/Exception
    //   185	195	144	java/lang/Exception
    //   68	74	212	finally
    //   74	80	235	finally
    //   105	112	244	finally
    //   117	124	244	finally
    //   133	141	244	finally
    //   151	164	244	finally
    //   185	195	244	finally
    //   68	74	248	java/lang/Exception
    //   74	80	257	java/lang/Exception
  }
  
  /* Error */
  public static String aNL(String paramString)
  {
    // Byte code:
    //   0: ldc 119
    //   2: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 123	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +17 -> 26
    //   12: ldc 97
    //   14: ldc 125
    //   16: invokestatic 129	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 119
    //   21: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aconst_null
    //   25: areturn
    //   26: getstatic 135	android/os/Build$VERSION:SDK_INT	I
    //   29: bipush 29
    //   31: if_icmplt +17 -> 48
    //   34: ldc 97
    //   36: ldc 137
    //   38: invokestatic 140	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: ldc 119
    //   43: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: areturn
    //   48: new 142	java/io/FileInputStream
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 143	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   56: astore_3
    //   57: aload_3
    //   58: invokevirtual 147	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   61: astore_2
    //   62: ldc 149
    //   64: ldc 151
    //   66: iconst_0
    //   67: anewarray 153	java/lang/Class
    //   70: invokevirtual 157	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   73: astore 4
    //   75: aload 4
    //   77: iconst_1
    //   78: invokevirtual 163	java/lang/reflect/Method:setAccessible	(Z)V
    //   81: aload 4
    //   83: aload_2
    //   84: iconst_0
    //   85: anewarray 4	java/lang/Object
    //   88: invokevirtual 167	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   91: checkcast 169	java/lang/Integer
    //   94: invokevirtual 173	java/lang/Integer:intValue	()I
    //   97: istore_1
    //   98: ldc 175
    //   100: iload_1
    //   101: invokestatic 181	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   104: invokevirtual 184	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   107: invokestatic 189	android/system/Os:readlink	(Ljava/lang/String;)Ljava/lang/String;
    //   110: astore_2
    //   111: ldc 97
    //   113: ldc 191
    //   115: iconst_2
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload_0
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: aload_2
    //   126: aastore
    //   127: invokestatic 194	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: aload_0
    //   131: aload_2
    //   132: invokevirtual 197	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   135: ifne +86 -> 221
    //   138: ldc 97
    //   140: ldc 199
    //   142: iconst_2
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_0
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: aload_2
    //   153: aastore
    //   154: invokestatic 201	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aconst_null
    //   158: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   161: aload_3
    //   162: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   165: ldc 119
    //   167: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: aconst_null
    //   171: areturn
    //   172: astore 4
    //   174: ldc 97
    //   176: aload 4
    //   178: ldc 203
    //   180: iconst_0
    //   181: anewarray 4	java/lang/Object
    //   184: invokestatic 105	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: new 205	java/io/File
    //   190: dup
    //   191: aload_0
    //   192: invokespecial 206	java/io/File:<init>	(Ljava/lang/String;)V
    //   195: invokevirtual 209	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   198: astore_2
    //   199: goto -88 -> 111
    //   202: astore_2
    //   203: ldc 97
    //   205: aload 4
    //   207: ldc 211
    //   209: iconst_0
    //   210: anewarray 4	java/lang/Object
    //   213: invokestatic 105	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: aload_0
    //   217: astore_2
    //   218: goto -107 -> 111
    //   221: aload_2
    //   222: invokestatic 214	com/tencent/mm/sdk/platformtools/bu:aSO	(Ljava/lang/String;)Z
    //   225: ifne +37 -> 262
    //   228: ldc 97
    //   230: ldc 216
    //   232: iconst_2
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: aload_2
    //   239: aastore
    //   240: dup
    //   241: iconst_1
    //   242: aload_0
    //   243: aastore
    //   244: invokestatic 201	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: aconst_null
    //   248: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   251: aload_3
    //   252: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   255: ldc 119
    //   257: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: aconst_null
    //   261: areturn
    //   262: new 205	java/io/File
    //   265: dup
    //   266: invokestatic 31	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   269: invokevirtual 37	android/content/Context:getCacheDir	()Ljava/io/File;
    //   272: new 39	java/lang/StringBuilder
    //   275: dup
    //   276: ldc 218
    //   278: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   281: new 205	java/io/File
    //   284: dup
    //   285: aload_2
    //   286: invokespecial 206	java/io/File:<init>	(Ljava/lang/String;)V
    //   289: invokevirtual 221	java/io/File:getName	()Ljava/lang/String;
    //   292: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokespecial 222	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   301: astore 6
    //   303: aload 6
    //   305: invokevirtual 225	java/io/File:exists	()Z
    //   308: ifne +12 -> 320
    //   311: aload 6
    //   313: invokevirtual 228	java/io/File:getParentFile	()Ljava/io/File;
    //   316: invokevirtual 231	java/io/File:mkdirs	()Z
    //   319: pop
    //   320: sipush 4096
    //   323: newarray byte
    //   325: astore 7
    //   327: new 233	java/io/BufferedOutputStream
    //   330: dup
    //   331: new 235	java/io/FileOutputStream
    //   334: dup
    //   335: aload 6
    //   337: invokespecial 238	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   340: invokespecial 241	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   343: astore_2
    //   344: aload_3
    //   345: astore 5
    //   347: aload_2
    //   348: astore 4
    //   350: new 243	java/io/BufferedInputStream
    //   353: dup
    //   354: aload_3
    //   355: invokespecial 246	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   358: astore 8
    //   360: aload_3
    //   361: astore 5
    //   363: aload_2
    //   364: astore 4
    //   366: aload 8
    //   368: aload 7
    //   370: invokevirtual 247	java/io/BufferedInputStream:read	([B)I
    //   373: istore_1
    //   374: iload_1
    //   375: ifle +60 -> 435
    //   378: aload_3
    //   379: astore 5
    //   381: aload_2
    //   382: astore 4
    //   384: aload_2
    //   385: aload 7
    //   387: iconst_0
    //   388: iload_1
    //   389: invokevirtual 95	java/io/OutputStream:write	([BII)V
    //   392: goto -32 -> 360
    //   395: astore 6
    //   397: aload_3
    //   398: astore 5
    //   400: aload_2
    //   401: astore 4
    //   403: ldc 97
    //   405: aload 6
    //   407: ldc 249
    //   409: iconst_1
    //   410: anewarray 4	java/lang/Object
    //   413: dup
    //   414: iconst_0
    //   415: aload_0
    //   416: aastore
    //   417: invokestatic 105	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   420: aload_2
    //   421: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   424: aload_3
    //   425: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   428: ldc 119
    //   430: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   433: aconst_null
    //   434: areturn
    //   435: aload_3
    //   436: astore 5
    //   438: aload_2
    //   439: astore 4
    //   441: aload 6
    //   443: invokevirtual 252	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   446: astore 6
    //   448: aload_3
    //   449: astore 5
    //   451: aload_2
    //   452: astore 4
    //   454: ldc 97
    //   456: ldc 254
    //   458: iconst_2
    //   459: anewarray 4	java/lang/Object
    //   462: dup
    //   463: iconst_0
    //   464: aload_0
    //   465: aastore
    //   466: dup
    //   467: iconst_1
    //   468: aload 6
    //   470: aastore
    //   471: invokestatic 194	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   474: aload_2
    //   475: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   478: aload_3
    //   479: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   482: ldc 119
    //   484: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   487: aload 6
    //   489: areturn
    //   490: astore_0
    //   491: aconst_null
    //   492: astore_3
    //   493: aconst_null
    //   494: astore 4
    //   496: aload 4
    //   498: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   501: aload_3
    //   502: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   505: ldc 119
    //   507: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   510: aload_0
    //   511: athrow
    //   512: astore_0
    //   513: aconst_null
    //   514: astore 4
    //   516: goto -20 -> 496
    //   519: astore_0
    //   520: aload 5
    //   522: astore_3
    //   523: goto -27 -> 496
    //   526: astore 6
    //   528: aconst_null
    //   529: astore_3
    //   530: aconst_null
    //   531: astore_2
    //   532: goto -135 -> 397
    //   535: astore 6
    //   537: aconst_null
    //   538: astore_2
    //   539: goto -142 -> 397
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	542	0	paramString	String
    //   97	292	1	i	int
    //   61	138	2	localObject1	Object
    //   202	1	2	localThrowable1	java.lang.Throwable
    //   217	322	2	localObject2	Object
    //   56	474	3	localObject3	Object
    //   73	9	4	localMethod	java.lang.reflect.Method
    //   172	34	4	localThrowable2	java.lang.Throwable
    //   348	167	4	localObject4	Object
    //   345	176	5	localObject5	Object
    //   301	35	6	localFile	java.io.File
    //   395	47	6	localThrowable3	java.lang.Throwable
    //   446	42	6	str	String
    //   526	1	6	localThrowable4	java.lang.Throwable
    //   535	1	6	localThrowable5	java.lang.Throwable
    //   325	61	7	arrayOfByte	byte[]
    //   358	9	8	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   98	111	172	java/lang/Throwable
    //   187	199	202	java/lang/Throwable
    //   350	360	395	java/lang/Throwable
    //   366	374	395	java/lang/Throwable
    //   384	392	395	java/lang/Throwable
    //   441	448	395	java/lang/Throwable
    //   454	474	395	java/lang/Throwable
    //   48	57	490	finally
    //   57	98	512	finally
    //   98	111	512	finally
    //   111	157	512	finally
    //   174	187	512	finally
    //   187	199	512	finally
    //   203	216	512	finally
    //   221	247	512	finally
    //   262	320	512	finally
    //   320	344	512	finally
    //   350	360	519	finally
    //   366	374	519	finally
    //   384	392	519	finally
    //   403	420	519	finally
    //   441	448	519	finally
    //   454	474	519	finally
    //   48	57	526	java/lang/Throwable
    //   57	98	535	java/lang/Throwable
    //   111	157	535	java/lang/Throwable
    //   174	187	535	java/lang/Throwable
    //   203	216	535	java/lang/Throwable
    //   221	247	535	java/lang/Throwable
    //   262	320	535	java/lang/Throwable
    //   320	344	535	java/lang/Throwable
  }
  
  private static String aNM(String paramString)
  {
    AppMethodBeat.i(31181);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(31181);
      return "";
    }
    String str2 = MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString);
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      paramString = paramString.split("/");
      str1 = str2;
      if (paramString != null)
      {
        str1 = str2;
        if (paramString.length > 1) {
          str1 = paramString[1];
        }
      }
    }
    paramString = ".".concat(String.valueOf(str1));
    AppMethodBeat.o(31181);
    return paramString;
  }
  
  /* Error */
  public static final String b(android.content.ContentResolver paramContentResolver, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: sipush 31178
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: sipush 31178
    //   13: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 23	android/content/ContentResolver:getType	(Landroid/net/Uri;)Ljava/lang/String;
    //   23: astore 5
    //   25: aload 5
    //   27: invokestatic 53	com/tencent/mm/pluginsdk/l/e:aNM	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 6
    //   32: aload_0
    //   33: aload_1
    //   34: invokestatic 284	com/tencent/mm/pluginsdk/l/e:c	(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/lang/String;
    //   37: astore 4
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: invokestatic 123	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   47: ifeq +25 -> 72
    //   50: new 39	java/lang/StringBuilder
    //   53: dup
    //   54: ldc_w 286
    //   57: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: aload 5
    //   62: invokestatic 53	com/tencent/mm/pluginsdk/l/e:aNM	(Ljava/lang/String;)Ljava/lang/String;
    //   65: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: astore_3
    //   72: new 25	com/tencent/mm/vfs/k
    //   75: dup
    //   76: invokestatic 291	com/tencent/mm/loader/j/b:asm	()Ljava/lang/String;
    //   79: aload_3
    //   80: invokespecial 293	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: astore 5
    //   85: aload 5
    //   87: invokevirtual 294	com/tencent/mm/vfs/k:exists	()Z
    //   90: ifeq +221 -> 311
    //   93: invokestatic 300	com/tencent/mm/model/bc:aCg	()Lcom/tencent/mm/model/c;
    //   96: pop
    //   97: new 25	com/tencent/mm/vfs/k
    //   100: dup
    //   101: invokestatic 305	com/tencent/mm/model/c:azY	()Ljava/lang/String;
    //   104: aload_3
    //   105: aload 6
    //   107: invokestatic 311	com/tencent/mm/pluginsdk/model/app/m:aq	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   110: invokespecial 312	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   113: astore 5
    //   115: aload 5
    //   117: invokestatic 73	com/tencent/mm/vfs/o:aj	(Lcom/tencent/mm/vfs/k;)Ljava/io/OutputStream;
    //   120: astore_3
    //   121: aload_0
    //   122: aload_1
    //   123: invokevirtual 77	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   126: astore_0
    //   127: aload_0
    //   128: ifnonnull +19 -> 147
    //   131: aload_0
    //   132: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   135: aload_3
    //   136: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   139: sipush 31178
    //   142: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aconst_null
    //   146: areturn
    //   147: aload_0
    //   148: astore 4
    //   150: aload_3
    //   151: astore_1
    //   152: sipush 1024
    //   155: newarray byte
    //   157: astore 6
    //   159: aload_0
    //   160: astore 4
    //   162: aload_3
    //   163: astore_1
    //   164: aload_0
    //   165: aload 6
    //   167: invokevirtual 89	java/io/InputStream:read	([B)I
    //   170: istore_2
    //   171: iload_2
    //   172: ifle +55 -> 227
    //   175: aload_0
    //   176: astore 4
    //   178: aload_3
    //   179: astore_1
    //   180: aload_3
    //   181: aload 6
    //   183: iconst_0
    //   184: iload_2
    //   185: invokevirtual 95	java/io/OutputStream:write	([BII)V
    //   188: goto -29 -> 159
    //   191: astore 5
    //   193: aload_0
    //   194: astore 4
    //   196: aload_3
    //   197: astore_1
    //   198: ldc 97
    //   200: aload 5
    //   202: ldc 99
    //   204: iconst_0
    //   205: anewarray 4	java/lang/Object
    //   208: invokestatic 105	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: aload_0
    //   212: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   215: aload_3
    //   216: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   219: sipush 31178
    //   222: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: aconst_null
    //   226: areturn
    //   227: aload_0
    //   228: astore 4
    //   230: aload_3
    //   231: astore_1
    //   232: aload 5
    //   234: invokevirtual 109	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
    //   237: invokestatic 114	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   240: astore 5
    //   242: aload_0
    //   243: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   246: aload_3
    //   247: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   250: sipush 31178
    //   253: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aload 5
    //   258: areturn
    //   259: astore_0
    //   260: aconst_null
    //   261: astore 4
    //   263: aconst_null
    //   264: astore_1
    //   265: aload 4
    //   267: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   270: aload_1
    //   271: invokestatic 83	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   274: sipush 31178
    //   277: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: aload_0
    //   281: athrow
    //   282: astore_0
    //   283: aconst_null
    //   284: astore 4
    //   286: aload_3
    //   287: astore_1
    //   288: goto -23 -> 265
    //   291: astore_0
    //   292: goto -27 -> 265
    //   295: astore 5
    //   297: aconst_null
    //   298: astore_0
    //   299: aconst_null
    //   300: astore_3
    //   301: goto -108 -> 193
    //   304: astore 5
    //   306: aconst_null
    //   307: astore_0
    //   308: goto -115 -> 193
    //   311: goto -196 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	paramContentResolver	android.content.ContentResolver
    //   0	314	1	paramUri	android.net.Uri
    //   170	15	2	i	int
    //   41	260	3	localObject1	Object
    //   37	248	4	localObject2	Object
    //   23	93	5	localObject3	Object
    //   191	42	5	localException1	java.lang.Exception
    //   240	17	5	str	String
    //   295	1	5	localException2	java.lang.Exception
    //   304	1	5	localException3	java.lang.Exception
    //   30	152	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   152	159	191	java/lang/Exception
    //   164	171	191	java/lang/Exception
    //   180	188	191	java/lang/Exception
    //   232	242	191	java/lang/Exception
    //   115	121	259	finally
    //   121	127	282	finally
    //   152	159	291	finally
    //   164	171	291	finally
    //   180	188	291	finally
    //   198	211	291	finally
    //   232	242	291	finally
    //   115	121	295	java/lang/Exception
    //   121	127	304	java/lang/Exception
  }
  
  /* Error */
  private static String c(android.content.ContentResolver paramContentResolver, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: sipush 31179
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: iconst_1
    //   9: anewarray 177	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: ldc_w 314
    //   17: aastore
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 318	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +171 -> 197
    //   29: aload_0
    //   30: astore_2
    //   31: aload_0
    //   32: invokeinterface 323 1 0
    //   37: ifeq +160 -> 197
    //   40: aload_0
    //   41: astore_2
    //   42: new 25	com/tencent/mm/vfs/k
    //   45: dup
    //   46: aload_0
    //   47: iconst_0
    //   48: invokeinterface 326 2 0
    //   53: invokespecial 312	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   56: invokevirtual 327	com/tencent/mm/vfs/k:getName	()Ljava/lang/String;
    //   59: astore_3
    //   60: aload_3
    //   61: astore_1
    //   62: aload_1
    //   63: astore_2
    //   64: aload_0
    //   65: ifnull +11 -> 76
    //   68: aload_0
    //   69: invokeinterface 331 1 0
    //   74: aload_1
    //   75: astore_2
    //   76: sipush 31179
    //   79: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_2
    //   83: areturn
    //   84: astore_3
    //   85: aconst_null
    //   86: astore_0
    //   87: aload_0
    //   88: astore_2
    //   89: ldc 97
    //   91: aload_3
    //   92: ldc_w 333
    //   95: iconst_0
    //   96: anewarray 4	java/lang/Object
    //   99: invokestatic 105	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: aload_0
    //   103: astore_2
    //   104: aload_1
    //   105: invokevirtual 336	android/net/Uri:toString	()Ljava/lang/String;
    //   108: ldc_w 338
    //   111: invokestatic 344	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   114: ldc_w 270
    //   117: invokevirtual 274	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   120: astore_1
    //   121: aload_0
    //   122: astore_2
    //   123: aload_1
    //   124: aload_1
    //   125: arraylength
    //   126: iconst_1
    //   127: isub
    //   128: aaload
    //   129: astore_1
    //   130: aload_1
    //   131: astore_2
    //   132: aload_0
    //   133: ifnull -57 -> 76
    //   136: aload_0
    //   137: invokeinterface 331 1 0
    //   142: aload_1
    //   143: astore_2
    //   144: goto -68 -> 76
    //   147: astore_1
    //   148: aload_0
    //   149: astore_2
    //   150: ldc 97
    //   152: aload_1
    //   153: ldc_w 346
    //   156: iconst_0
    //   157: anewarray 4	java/lang/Object
    //   160: invokestatic 105	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: aconst_null
    //   164: astore_1
    //   165: goto -35 -> 130
    //   168: astore_0
    //   169: aconst_null
    //   170: astore_2
    //   171: aload_2
    //   172: ifnull +9 -> 181
    //   175: aload_2
    //   176: invokeinterface 331 1 0
    //   181: sipush 31179
    //   184: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload_0
    //   188: athrow
    //   189: astore_0
    //   190: goto -19 -> 171
    //   193: astore_3
    //   194: goto -107 -> 87
    //   197: aconst_null
    //   198: astore_1
    //   199: goto -137 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	paramContentResolver	android.content.ContentResolver
    //   0	202	1	paramUri	android.net.Uri
    //   30	146	2	localObject	Object
    //   59	2	3	str	String
    //   84	8	3	localException1	java.lang.Exception
    //   193	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   6	25	84	java/lang/Exception
    //   104	121	147	java/lang/Exception
    //   123	130	147	java/lang/Exception
    //   6	25	168	finally
    //   31	40	189	finally
    //   42	60	189	finally
    //   89	102	189	finally
    //   104	121	189	finally
    //   123	130	189	finally
    //   150	163	189	finally
    //   31	40	193	java/lang/Exception
    //   42	60	193	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.e
 * JD-Core Version:    0.7.0.1
 */