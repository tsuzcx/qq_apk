package com.tencent.mm.pluginsdk.l;

import android.os.Process;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  private static final String XXv;
  private static Boolean XXw;
  
  static
  {
    AppMethodBeat.i(244538);
    XXv = "/storage/emulated/" + Process.myUid() / 100000 + "/";
    XXw = null;
    AppMethodBeat.o(244538);
  }
  
  /* Error */
  public static final String a(android.content.ContentResolver paramContentResolver, android.net.Uri paramUri, int paramInt)
  {
    // Byte code:
    //   0: sipush 31180
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: sipush 31180
    //   13: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 63	android/content/ContentResolver:getType	(Landroid/net/Uri;)Ljava/lang/String;
    //   23: astore_3
    //   24: new 65	com/tencent/mm/vfs/u
    //   27: dup
    //   28: invokestatic 71	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   31: invokevirtual 77	android/content/Context:getCacheDir	()Ljava/io/File;
    //   34: new 19	java/lang/StringBuilder
    //   37: dup
    //   38: ldc 79
    //   40: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: iload_2
    //   44: invokevirtual 36	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: aload_3
    //   48: invokestatic 83	com/tencent/mm/pluginsdk/l/e:getExtByMimeType	(Ljava/lang/String;)Ljava/lang/String;
    //   51: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 86	com/tencent/mm/vfs/u:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   60: astore 5
    //   62: aload 5
    //   64: invokevirtual 90	com/tencent/mm/vfs/u:diJ	()Z
    //   67: pop
    //   68: aload 5
    //   70: invokestatic 96	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   73: astore_3
    //   74: aload_0
    //   75: aload_1
    //   76: invokevirtual 100	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   79: astore_0
    //   80: aload_0
    //   81: ifnonnull +19 -> 100
    //   84: aload_0
    //   85: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   88: aload_3
    //   89: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   92: sipush 31180
    //   95: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   120: invokevirtual 112	java/io/InputStream:read	([B)I
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
    //   138: invokevirtual 118	java/io/OutputStream:write	([BII)V
    //   141: goto -29 -> 112
    //   144: astore 5
    //   146: aload_0
    //   147: astore 4
    //   149: aload_3
    //   150: astore_1
    //   151: ldc 120
    //   153: aload 5
    //   155: ldc 122
    //   157: iconst_0
    //   158: anewarray 4	java/lang/Object
    //   161: invokestatic 128	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: aload_0
    //   165: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   168: aload_3
    //   169: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   172: sipush 31180
    //   175: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aconst_null
    //   179: areturn
    //   180: aload_0
    //   181: astore 4
    //   183: aload_3
    //   184: astore_1
    //   185: aload 5
    //   187: invokevirtual 132	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   190: invokestatic 137	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   193: astore 5
    //   195: aload_0
    //   196: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   199: aload_3
    //   200: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   203: sipush 31180
    //   206: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: aload 5
    //   211: areturn
    //   212: astore_0
    //   213: aconst_null
    //   214: astore 4
    //   216: aconst_null
    //   217: astore_1
    //   218: aload 4
    //   220: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   223: aload_1
    //   224: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   227: sipush 31180
    //   230: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   60	9	5	localu	com.tencent.mm.vfs.u
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
  public static String a(android.content.ContentResolver paramContentResolver, String paramString, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: ldc 139
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 143	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifne +50 -> 59
    //   12: new 65	com/tencent/mm/vfs/u
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 144	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   20: astore 9
    //   22: aload 9
    //   24: invokevirtual 147	com/tencent/mm/vfs/u:jKS	()Z
    //   27: ifeq +32 -> 59
    //   30: aload 9
    //   32: invokevirtual 150	com/tencent/mm/vfs/u:jKQ	()Z
    //   35: ifeq +24 -> 59
    //   38: ldc 120
    //   40: ldc 152
    //   42: aload_1
    //   43: invokestatic 158	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   46: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   49: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: ldc 139
    //   54: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_1
    //   58: areturn
    //   59: getstatic 49	com/tencent/mm/pluginsdk/l/e:XXw	Ljava/lang/Boolean;
    //   62: ifnonnull +53 -> 115
    //   65: ldc 166
    //   67: invokestatic 172	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   70: checkcast 166	com/tencent/mm/plugin/expt/b/c
    //   73: getstatic 178	com/tencent/mm/plugin/expt/b/c$a:yWK	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   76: iconst_1
    //   77: invokeinterface 181 3 0
    //   82: iconst_1
    //   83: if_icmpeq +21 -> 104
    //   86: getstatic 187	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   89: ifne +15 -> 104
    //   92: getstatic 190	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   95: ifne +9 -> 104
    //   98: invokestatic 195	com/tencent/mm/sdk/platformtools/WeChatEnvironment:hasDebugger	()Z
    //   101: ifeq +58 -> 159
    //   104: iconst_1
    //   105: istore 4
    //   107: iload 4
    //   109: invokestatic 200	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   112: putstatic 49	com/tencent/mm/pluginsdk/l/e:XXw	Ljava/lang/Boolean;
    //   115: ldc 120
    //   117: new 19	java/lang/StringBuilder
    //   120: dup
    //   121: ldc 202
    //   123: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   126: getstatic 49	com/tencent/mm/pluginsdk/l/e:XXw	Ljava/lang/Boolean;
    //   129: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: getstatic 49	com/tencent/mm/pluginsdk/l/e:XXw	Ljava/lang/Boolean;
    //   141: invokevirtual 208	java/lang/Boolean:booleanValue	()Z
    //   144: ifne +21 -> 165
    //   147: bipush 10
    //   149: invokestatic 213	com/tencent/mm/plugin/base/stub/f:GH	(I)V
    //   152: ldc 139
    //   154: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload_1
    //   158: areturn
    //   159: iconst_0
    //   160: istore 4
    //   162: goto -55 -> 107
    //   165: bipush 11
    //   167: invokestatic 213	com/tencent/mm/plugin/base/stub/f:GH	(I)V
    //   170: aload_0
    //   171: aload_2
    //   172: invokevirtual 100	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   175: astore_2
    //   176: aload_2
    //   177: ifnull +342 -> 519
    //   180: invokestatic 219	java/lang/System:currentTimeMillis	()J
    //   183: lstore 7
    //   185: aload_1
    //   186: invokestatic 143	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   189: ifeq +49 -> 238
    //   192: ldc 221
    //   194: astore 9
    //   196: aload 9
    //   198: invokestatic 143	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   201: ifeq +84 -> 285
    //   204: ldc 120
    //   206: ldc 223
    //   208: aload_1
    //   209: invokestatic 158	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   212: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   215: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: bipush 12
    //   220: invokestatic 213	com/tencent/mm/plugin/base/stub/f:GH	(I)V
    //   223: aload_2
    //   224: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   227: aconst_null
    //   228: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   231: ldc 139
    //   233: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload_1
    //   237: areturn
    //   238: new 19	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   245: invokestatic 233	com/tencent/mm/plugin/openapi/a:gxj	()Ljava/lang/String;
    //   248: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: new 19	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   258: aload_1
    //   259: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokestatic 219	java/lang/System:currentTimeMillis	()J
    //   265: invokevirtual 236	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   268: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 241	com/tencent/mm/sdk/platformtools/MD5Util:getMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   274: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: astore 9
    //   282: goto -86 -> 196
    //   285: new 65	com/tencent/mm/vfs/u
    //   288: dup
    //   289: aload 9
    //   291: invokespecial 144	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   294: astore 10
    //   296: aload 10
    //   298: invokevirtual 147	com/tencent/mm/vfs/u:jKS	()Z
    //   301: ifeq +9 -> 310
    //   304: aload 10
    //   306: invokevirtual 90	com/tencent/mm/vfs/u:diJ	()Z
    //   309: pop
    //   310: aload 9
    //   312: iconst_0
    //   313: invokestatic 245	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   316: astore_0
    //   317: sipush 4096
    //   320: newarray byte
    //   322: astore 11
    //   324: lconst_0
    //   325: lstore 5
    //   327: aload_2
    //   328: aload 11
    //   330: invokevirtual 112	java/io/InputStream:read	([B)I
    //   333: istore_3
    //   334: iload_3
    //   335: iconst_m1
    //   336: if_icmpeq +19 -> 355
    //   339: aload_0
    //   340: aload 11
    //   342: invokevirtual 248	java/io/OutputStream:write	([B)V
    //   345: lload 5
    //   347: iload_3
    //   348: i2l
    //   349: ladd
    //   350: lstore 5
    //   352: goto -25 -> 327
    //   355: ldc 120
    //   357: new 19	java/lang/StringBuilder
    //   360: dup
    //   361: ldc 250
    //   363: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   366: invokestatic 219	java/lang/System:currentTimeMillis	()J
    //   369: lload 7
    //   371: lsub
    //   372: invokevirtual 236	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   375: ldc 252
    //   377: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: lload 5
    //   382: l2f
    //   383: ldc 253
    //   385: fdiv
    //   386: invokevirtual 256	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   389: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload 10
    //   397: invokevirtual 147	com/tencent/mm/vfs/u:jKS	()Z
    //   400: ifeq +50 -> 450
    //   403: aload 10
    //   405: invokevirtual 150	com/tencent/mm/vfs/u:jKQ	()Z
    //   408: ifeq +42 -> 450
    //   411: ldc 120
    //   413: ldc_w 258
    //   416: aload 9
    //   418: invokestatic 158	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   421: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   424: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   427: bipush 13
    //   429: invokestatic 213	com/tencent/mm/plugin/base/stub/f:GH	(I)V
    //   432: aload 9
    //   434: astore_1
    //   435: aload_2
    //   436: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   439: aload_0
    //   440: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   443: ldc 139
    //   445: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   448: aload_1
    //   449: areturn
    //   450: ldc 120
    //   452: ldc_w 260
    //   455: aload_1
    //   456: invokestatic 158	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   459: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   462: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: bipush 14
    //   467: invokestatic 213	com/tencent/mm/plugin/base/stub/f:GH	(I)V
    //   470: goto -35 -> 435
    //   473: astore 9
    //   475: ldc 120
    //   477: aload 9
    //   479: ldc 221
    //   481: iconst_0
    //   482: anewarray 4	java/lang/Object
    //   485: invokestatic 128	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   488: ldc 120
    //   490: ldc_w 265
    //   493: aload_1
    //   494: invokestatic 158	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   497: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   500: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   503: bipush 16
    //   505: invokestatic 213	com/tencent/mm/plugin/base/stub/f:GH	(I)V
    //   508: aload_2
    //   509: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   512: aload_0
    //   513: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   516: goto -73 -> 443
    //   519: ldc 120
    //   521: ldc_w 267
    //   524: aload_1
    //   525: invokestatic 158	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   528: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   531: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   534: bipush 15
    //   536: invokestatic 213	com/tencent/mm/plugin/base/stub/f:GH	(I)V
    //   539: aconst_null
    //   540: astore_0
    //   541: goto -106 -> 435
    //   544: astore_1
    //   545: aconst_null
    //   546: astore_0
    //   547: aconst_null
    //   548: astore_2
    //   549: aload_2
    //   550: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   553: aload_0
    //   554: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   557: ldc 139
    //   559: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   562: aload_1
    //   563: athrow
    //   564: astore_1
    //   565: aconst_null
    //   566: astore_0
    //   567: goto -18 -> 549
    //   570: astore_1
    //   571: goto -22 -> 549
    //   574: astore_1
    //   575: goto -26 -> 549
    //   578: astore 9
    //   580: aconst_null
    //   581: astore_0
    //   582: aconst_null
    //   583: astore_2
    //   584: goto -109 -> 475
    //   587: astore 9
    //   589: aconst_null
    //   590: astore_0
    //   591: goto -116 -> 475
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	paramContentResolver	android.content.ContentResolver
    //   0	594	1	paramString	String
    //   0	594	2	paramUri	android.net.Uri
    //   333	15	3	i	int
    //   105	56	4	bool	boolean
    //   325	56	5	l1	long
    //   183	187	7	l2	long
    //   20	413	9	localObject	Object
    //   473	5	9	localException1	java.lang.Exception
    //   578	1	9	localException2	java.lang.Exception
    //   587	1	9	localException3	java.lang.Exception
    //   294	110	10	localu	com.tencent.mm.vfs.u
    //   322	19	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   317	324	473	java/lang/Exception
    //   327	334	473	java/lang/Exception
    //   339	345	473	java/lang/Exception
    //   355	432	473	java/lang/Exception
    //   450	470	473	java/lang/Exception
    //   170	176	544	finally
    //   180	192	564	finally
    //   196	223	564	finally
    //   238	282	564	finally
    //   285	310	564	finally
    //   310	317	564	finally
    //   519	539	564	finally
    //   317	324	570	finally
    //   327	334	570	finally
    //   339	345	570	finally
    //   355	432	570	finally
    //   450	470	570	finally
    //   475	508	574	finally
    //   170	176	578	java/lang/Exception
    //   180	192	587	java/lang/Exception
    //   196	223	587	java/lang/Exception
    //   238	282	587	java/lang/Exception
    //   285	310	587	java/lang/Exception
    //   310	317	587	java/lang/Exception
    //   519	539	587	java/lang/Exception
  }
  
  /* Error */
  public static final String b(android.content.ContentResolver paramContentResolver, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: sipush 31178
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: sipush 31178
    //   13: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 63	android/content/ContentResolver:getType	(Landroid/net/Uri;)Ljava/lang/String;
    //   23: astore 5
    //   25: aload 5
    //   27: invokestatic 83	com/tencent/mm/pluginsdk/l/e:getExtByMimeType	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 6
    //   32: aload_0
    //   33: aload_1
    //   34: invokestatic 272	com/tencent/mm/pluginsdk/l/e:c	(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/lang/String;
    //   37: astore 4
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: invokestatic 143	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   47: ifeq +25 -> 72
    //   50: new 19	java/lang/StringBuilder
    //   53: dup
    //   54: ldc_w 274
    //   57: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: aload 5
    //   62: invokestatic 83	com/tencent/mm/pluginsdk/l/e:getExtByMimeType	(Ljava/lang/String;)Ljava/lang/String;
    //   65: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: astore_3
    //   72: new 65	com/tencent/mm/vfs/u
    //   75: dup
    //   76: invokestatic 279	com/tencent/mm/loader/i/b:bmC	()Ljava/lang/String;
    //   79: aload_3
    //   80: invokespecial 281	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: astore 5
    //   85: aload 5
    //   87: invokevirtual 147	com/tencent/mm/vfs/u:jKS	()Z
    //   90: ifeq +221 -> 311
    //   93: invokestatic 287	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   96: pop
    //   97: new 65	com/tencent/mm/vfs/u
    //   100: dup
    //   101: invokestatic 292	com/tencent/mm/model/c:bzT	()Ljava/lang/String;
    //   104: aload_3
    //   105: aload 6
    //   107: invokestatic 298	com/tencent/mm/pluginsdk/model/app/n:aK	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   110: invokespecial 144	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   113: astore 5
    //   115: aload 5
    //   117: invokestatic 96	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   120: astore_3
    //   121: aload_0
    //   122: aload_1
    //   123: invokevirtual 100	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   126: astore_0
    //   127: aload_0
    //   128: ifnonnull +19 -> 147
    //   131: aload_0
    //   132: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   135: aload_3
    //   136: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   139: sipush 31178
    //   142: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   167: invokevirtual 112	java/io/InputStream:read	([B)I
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
    //   185: invokevirtual 118	java/io/OutputStream:write	([BII)V
    //   188: goto -29 -> 159
    //   191: astore 5
    //   193: aload_0
    //   194: astore 4
    //   196: aload_3
    //   197: astore_1
    //   198: ldc 120
    //   200: aload 5
    //   202: ldc 122
    //   204: iconst_0
    //   205: anewarray 4	java/lang/Object
    //   208: invokestatic 128	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: aload_0
    //   212: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   215: aload_3
    //   216: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   219: sipush 31178
    //   222: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: aconst_null
    //   226: areturn
    //   227: aload_0
    //   228: astore 4
    //   230: aload_3
    //   231: astore_1
    //   232: aload 5
    //   234: invokevirtual 132	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   237: invokestatic 137	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   240: astore 5
    //   242: aload_0
    //   243: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   246: aload_3
    //   247: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   250: sipush 31178
    //   253: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aload 5
    //   258: areturn
    //   259: astore_0
    //   260: aconst_null
    //   261: astore 4
    //   263: aconst_null
    //   264: astore_1
    //   265: aload 4
    //   267: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   270: aload_1
    //   271: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   274: sipush 31178
    //   277: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private static String bqy(String paramString)
  {
    AppMethodBeat.i(244517);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(244517);
      return paramString;
    }
    if (paramString.startsWith("/sdcard/"))
    {
      paramString = paramString.substring(8);
      AppMethodBeat.o(244517);
      return paramString;
    }
    if (paramString.startsWith(XXv))
    {
      paramString = paramString.substring(XXv.length());
      AppMethodBeat.o(244517);
      return paramString;
    }
    AppMethodBeat.o(244517);
    return paramString;
  }
  
  /* Error */
  public static String bqz(String paramString)
  {
    // Byte code:
    //   0: ldc_w 314
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 143	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 120
    //   15: ldc_w 316
    //   18: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 314
    //   24: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: getstatic 322	android/os/Build$VERSION:SDK_INT	I
    //   32: bipush 29
    //   34: if_icmplt +19 -> 53
    //   37: ldc 120
    //   39: ldc_w 324
    //   42: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: ldc_w 314
    //   48: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_0
    //   52: areturn
    //   53: new 326	java/io/FileInputStream
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 327	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   61: astore 4
    //   63: aload 4
    //   65: invokevirtual 331	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   68: astore_2
    //   69: ldc_w 333
    //   72: ldc_w 335
    //   75: iconst_0
    //   76: anewarray 337	java/lang/Class
    //   79: invokevirtual 341	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   82: astore_3
    //   83: aload_3
    //   84: iconst_1
    //   85: invokevirtual 347	java/lang/reflect/Method:setAccessible	(Z)V
    //   88: aload_3
    //   89: aload_2
    //   90: iconst_0
    //   91: anewarray 4	java/lang/Object
    //   94: invokevirtual 351	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   97: checkcast 353	java/lang/Integer
    //   100: invokevirtual 356	java/lang/Integer:intValue	()I
    //   103: istore_1
    //   104: ldc_w 358
    //   107: iload_1
    //   108: invokestatic 360	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   111: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   114: invokestatic 365	android/system/Os:readlink	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore_2
    //   118: ldc 120
    //   120: ldc_w 367
    //   123: iconst_2
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: aload_0
    //   130: aastore
    //   131: dup
    //   132: iconst_1
    //   133: aload_2
    //   134: aastore
    //   135: invokestatic 370	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: aload_0
    //   139: aload_2
    //   140: invokevirtual 373	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   143: ifne +102 -> 245
    //   146: aload_0
    //   147: invokestatic 375	com/tencent/mm/pluginsdk/l/e:bqy	(Ljava/lang/String;)Ljava/lang/String;
    //   150: aload_2
    //   151: invokestatic 375	com/tencent/mm/pluginsdk/l/e:bqy	(Ljava/lang/String;)Ljava/lang/String;
    //   154: invokevirtual 373	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   157: ifne +88 -> 245
    //   160: ldc 120
    //   162: ldc_w 377
    //   165: iconst_2
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload_0
    //   172: aastore
    //   173: dup
    //   174: iconst_1
    //   175: aload_2
    //   176: aastore
    //   177: invokestatic 379	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: aconst_null
    //   181: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   184: aload 4
    //   186: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   189: ldc_w 314
    //   192: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: aconst_null
    //   196: areturn
    //   197: astore_3
    //   198: ldc 120
    //   200: aload_3
    //   201: ldc_w 381
    //   204: iconst_0
    //   205: anewarray 4	java/lang/Object
    //   208: invokestatic 128	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: new 383	java/io/File
    //   214: dup
    //   215: aload_0
    //   216: invokespecial 384	java/io/File:<init>	(Ljava/lang/String;)V
    //   219: invokevirtual 387	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   222: astore_2
    //   223: goto -105 -> 118
    //   226: astore_2
    //   227: ldc 120
    //   229: aload_3
    //   230: ldc_w 389
    //   233: iconst_0
    //   234: anewarray 4	java/lang/Object
    //   237: invokestatic 128	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   240: aload_0
    //   241: astore_2
    //   242: goto -124 -> 118
    //   245: aload_2
    //   246: invokestatic 392	com/tencent/mm/sdk/platformtools/Util:isResolvedPathSafeToBeCopySrc	(Ljava/lang/String;)Z
    //   249: ifne +40 -> 289
    //   252: ldc 120
    //   254: ldc_w 394
    //   257: iconst_2
    //   258: anewarray 4	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: aload_2
    //   264: aastore
    //   265: dup
    //   266: iconst_1
    //   267: aload_0
    //   268: aastore
    //   269: invokestatic 379	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   272: aconst_null
    //   273: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   276: aload 4
    //   278: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   281: ldc_w 314
    //   284: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   287: aconst_null
    //   288: areturn
    //   289: new 65	com/tencent/mm/vfs/u
    //   292: dup
    //   293: ldc_w 396
    //   296: iconst_0
    //   297: invokestatic 402	com/tencent/mm/vfs/af:eC	(Ljava/lang/String;Z)Lcom/tencent/mm/vfs/u;
    //   300: new 383	java/io/File
    //   303: dup
    //   304: aload_2
    //   305: invokespecial 384	java/io/File:<init>	(Ljava/lang/String;)V
    //   308: invokevirtual 405	java/io/File:getName	()Ljava/lang/String;
    //   311: invokespecial 408	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
    //   314: astore_2
    //   315: aload_2
    //   316: invokestatic 96	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   319: astore_3
    //   320: aload 4
    //   322: aload_3
    //   323: invokestatic 411	com/tencent/mm/vfs/ah:e	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   326: pop2
    //   327: aload_2
    //   328: invokevirtual 132	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   331: invokestatic 137	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   334: iconst_0
    //   335: invokestatic 415	com/tencent/mm/vfs/y:n	(Ljava/lang/String;Z)Ljava/lang/String;
    //   338: astore_2
    //   339: ldc 120
    //   341: ldc_w 417
    //   344: iconst_2
    //   345: anewarray 4	java/lang/Object
    //   348: dup
    //   349: iconst_0
    //   350: aload_0
    //   351: aastore
    //   352: dup
    //   353: iconst_1
    //   354: aload_2
    //   355: aastore
    //   356: invokestatic 370	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   359: aload_3
    //   360: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   363: aload 4
    //   365: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   368: ldc_w 314
    //   371: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: aload_2
    //   375: areturn
    //   376: astore_2
    //   377: aconst_null
    //   378: astore 4
    //   380: aconst_null
    //   381: astore_3
    //   382: ldc 120
    //   384: aload_2
    //   385: ldc_w 419
    //   388: iconst_1
    //   389: anewarray 4	java/lang/Object
    //   392: dup
    //   393: iconst_0
    //   394: aload_0
    //   395: aastore
    //   396: invokestatic 128	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   399: aload_3
    //   400: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   403: aload 4
    //   405: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   408: ldc_w 314
    //   411: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   414: aconst_null
    //   415: areturn
    //   416: astore_0
    //   417: aload_3
    //   418: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   421: aload 4
    //   423: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   426: ldc_w 314
    //   429: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   432: aload_0
    //   433: athrow
    //   434: astore_2
    //   435: aconst_null
    //   436: astore_3
    //   437: goto -55 -> 382
    //   440: astore_2
    //   441: goto -59 -> 382
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	paramString	String
    //   103	5	1	i	int
    //   68	155	2	localObject1	Object
    //   226	1	2	localObject2	Object
    //   241	134	2	localObject3	Object
    //   376	9	2	localThrowable1	java.lang.Throwable
    //   434	1	2	localObject4	Object
    //   440	1	2	localObject5	Object
    //   82	7	3	localMethod	java.lang.reflect.Method
    //   197	33	3	localThrowable2	java.lang.Throwable
    //   319	118	3	localOutputStream	java.io.OutputStream
    //   61	361	4	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   104	118	197	finally
    //   211	223	226	finally
    //   53	63	376	finally
    //   382	399	416	finally
    //   63	104	434	finally
    //   118	180	434	finally
    //   198	211	434	finally
    //   227	240	434	finally
    //   245	272	434	finally
    //   289	320	434	finally
    //   320	359	440	finally
  }
  
  /* Error */
  private static String c(android.content.ContentResolver paramContentResolver, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: sipush 31179
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: iconst_1
    //   9: anewarray 154	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: ldc_w 421
    //   17: aastore
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 425	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +170 -> 196
    //   29: aload_0
    //   30: astore_2
    //   31: aload_0
    //   32: invokeinterface 430 1 0
    //   37: ifeq +159 -> 196
    //   40: aload_0
    //   41: astore_2
    //   42: new 65	com/tencent/mm/vfs/u
    //   45: dup
    //   46: aload_0
    //   47: iconst_0
    //   48: invokeinterface 433 2 0
    //   53: invokespecial 144	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   56: invokevirtual 434	com/tencent/mm/vfs/u:getName	()Ljava/lang/String;
    //   59: astore_3
    //   60: aload_3
    //   61: astore_1
    //   62: aload_1
    //   63: astore_2
    //   64: aload_0
    //   65: ifnull +11 -> 76
    //   68: aload_0
    //   69: invokeinterface 437 1 0
    //   74: aload_1
    //   75: astore_2
    //   76: sipush 31179
    //   79: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_2
    //   83: areturn
    //   84: astore_3
    //   85: aconst_null
    //   86: astore_0
    //   87: aload_0
    //   88: astore_2
    //   89: ldc 120
    //   91: aload_3
    //   92: ldc_w 439
    //   95: iconst_0
    //   96: anewarray 4	java/lang/Object
    //   99: invokestatic 128	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: aload_0
    //   103: astore_2
    //   104: aload_1
    //   105: invokevirtual 442	android/net/Uri:toString	()Ljava/lang/String;
    //   108: ldc_w 444
    //   111: invokestatic 450	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   114: ldc 38
    //   116: invokevirtual 454	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   119: astore_1
    //   120: aload_0
    //   121: astore_2
    //   122: aload_1
    //   123: aload_1
    //   124: arraylength
    //   125: iconst_1
    //   126: isub
    //   127: aaload
    //   128: astore_1
    //   129: aload_1
    //   130: astore_2
    //   131: aload_0
    //   132: ifnull -56 -> 76
    //   135: aload_0
    //   136: invokeinterface 437 1 0
    //   141: aload_1
    //   142: astore_2
    //   143: goto -67 -> 76
    //   146: astore_1
    //   147: aload_0
    //   148: astore_2
    //   149: ldc 120
    //   151: aload_1
    //   152: ldc_w 456
    //   155: iconst_0
    //   156: anewarray 4	java/lang/Object
    //   159: invokestatic 128	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: aconst_null
    //   163: astore_1
    //   164: goto -35 -> 129
    //   167: astore_0
    //   168: aconst_null
    //   169: astore_2
    //   170: aload_2
    //   171: ifnull +9 -> 180
    //   174: aload_2
    //   175: invokeinterface 437 1 0
    //   180: sipush 31179
    //   183: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_0
    //   187: athrow
    //   188: astore_0
    //   189: goto -19 -> 170
    //   192: astore_3
    //   193: goto -106 -> 87
    //   196: aconst_null
    //   197: astore_1
    //   198: goto -136 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	paramContentResolver	android.content.ContentResolver
    //   0	201	1	paramUri	android.net.Uri
    //   30	145	2	localObject	Object
    //   59	2	3	str	String
    //   84	8	3	localException1	java.lang.Exception
    //   192	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   6	25	84	java/lang/Exception
    //   104	120	146	java/lang/Exception
    //   122	129	146	java/lang/Exception
    //   6	25	167	finally
    //   31	40	188	finally
    //   42	60	188	finally
    //   89	102	188	finally
    //   104	120	188	finally
    //   122	129	188	finally
    //   149	162	188	finally
    //   31	40	192	java/lang/Exception
    //   42	60	192	java/lang/Exception
  }
  
  private static String getExtByMimeType(String paramString)
  {
    AppMethodBeat.i(31181);
    if (Util.isNullOrNil(paramString))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.e
 * JD-Core Version:    0.7.0.1
 */