package com.tencent.mm.pluginsdk.m;

import android.os.Process;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  private static final String Rbp;
  
  static
  {
    AppMethodBeat.i(280081);
    Rbp = "/storage/emulated/" + Process.myUid() / 100000 + "/";
    AppMethodBeat.o(280081);
  }
  
  /* Error */
  public static final String a(android.content.ContentResolver paramContentResolver, android.net.Uri paramUri, int paramInt)
  {
    // Byte code:
    //   0: sipush 31180
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: sipush 31180
    //   13: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 59	android/content/ContentResolver:getType	(Landroid/net/Uri;)Ljava/lang/String;
    //   23: astore_3
    //   24: new 61	com/tencent/mm/vfs/q
    //   27: dup
    //   28: invokestatic 67	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   31: invokevirtual 73	android/content/Context:getCacheDir	()Ljava/io/File;
    //   34: new 17	java/lang/StringBuilder
    //   37: dup
    //   38: ldc 75
    //   40: invokespecial 23	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: iload_2
    //   44: invokevirtual 34	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: aload_3
    //   48: invokestatic 79	com/tencent/mm/pluginsdk/m/e:getExtByMimeType	(Ljava/lang/String;)Ljava/lang/String;
    //   51: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 82	com/tencent/mm/vfs/q:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   60: astore 5
    //   62: aload 5
    //   64: invokevirtual 86	com/tencent/mm/vfs/q:cFq	()Z
    //   67: pop
    //   68: aload 5
    //   70: invokestatic 92	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   73: astore_3
    //   74: aload_0
    //   75: aload_1
    //   76: invokevirtual 96	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   79: astore_0
    //   80: aload_0
    //   81: ifnonnull +19 -> 100
    //   84: aload_0
    //   85: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   88: aload_3
    //   89: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   92: sipush 31180
    //   95: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   120: invokevirtual 108	java/io/InputStream:read	([B)I
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
    //   138: invokevirtual 114	java/io/OutputStream:write	([BII)V
    //   141: goto -29 -> 112
    //   144: astore 5
    //   146: aload_0
    //   147: astore 4
    //   149: aload_3
    //   150: astore_1
    //   151: ldc 116
    //   153: aload 5
    //   155: ldc 118
    //   157: iconst_0
    //   158: anewarray 4	java/lang/Object
    //   161: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: aload_0
    //   165: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   168: aload_3
    //   169: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   172: sipush 31180
    //   175: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aconst_null
    //   179: areturn
    //   180: aload_0
    //   181: astore 4
    //   183: aload_3
    //   184: astore_1
    //   185: aload 5
    //   187: invokevirtual 127	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   190: astore 5
    //   192: aload_0
    //   193: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   196: aload_3
    //   197: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   200: sipush 31180
    //   203: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload 5
    //   208: areturn
    //   209: astore_0
    //   210: aconst_null
    //   211: astore 4
    //   213: aconst_null
    //   214: astore_1
    //   215: aload 4
    //   217: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   220: aload_1
    //   221: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   224: sipush 31180
    //   227: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: aload_0
    //   231: athrow
    //   232: astore_0
    //   233: aconst_null
    //   234: astore 4
    //   236: aload_3
    //   237: astore_1
    //   238: goto -23 -> 215
    //   241: astore_0
    //   242: goto -27 -> 215
    //   245: astore 5
    //   247: aconst_null
    //   248: astore_0
    //   249: aconst_null
    //   250: astore_3
    //   251: goto -105 -> 146
    //   254: astore 5
    //   256: aconst_null
    //   257: astore_0
    //   258: goto -112 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramContentResolver	android.content.ContentResolver
    //   0	261	1	paramUri	android.net.Uri
    //   0	261	2	paramInt	int
    //   23	228	3	localObject	Object
    //   101	134	4	localContentResolver	android.content.ContentResolver
    //   60	9	5	localq	com.tencent.mm.vfs.q
    //   144	42	5	localException1	java.lang.Exception
    //   190	17	5	str	String
    //   245	1	5	localException2	java.lang.Exception
    //   254	1	5	localException3	java.lang.Exception
    //   110	25	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   105	112	144	java/lang/Exception
    //   117	124	144	java/lang/Exception
    //   133	141	144	java/lang/Exception
    //   185	192	144	java/lang/Exception
    //   68	74	209	finally
    //   74	80	232	finally
    //   105	112	241	finally
    //   117	124	241	finally
    //   133	141	241	finally
    //   151	164	241	finally
    //   185	192	241	finally
    //   68	74	245	java/lang/Exception
    //   74	80	254	java/lang/Exception
  }
  
  /* Error */
  public static final String b(android.content.ContentResolver paramContentResolver, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: sipush 31178
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: sipush 31178
    //   13: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 59	android/content/ContentResolver:getType	(Landroid/net/Uri;)Ljava/lang/String;
    //   23: astore 5
    //   25: aload 5
    //   27: invokestatic 79	com/tencent/mm/pluginsdk/m/e:getExtByMimeType	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 6
    //   32: aload_0
    //   33: aload_1
    //   34: invokestatic 132	com/tencent/mm/pluginsdk/m/e:c	(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/lang/String;
    //   37: astore 4
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: invokestatic 136	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   47: ifeq +24 -> 71
    //   50: new 17	java/lang/StringBuilder
    //   53: dup
    //   54: ldc 138
    //   56: invokespecial 23	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: aload 5
    //   61: invokestatic 79	com/tencent/mm/pluginsdk/m/e:getExtByMimeType	(Ljava/lang/String;)Ljava/lang/String;
    //   64: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore_3
    //   71: new 61	com/tencent/mm/vfs/q
    //   74: dup
    //   75: invokestatic 143	com/tencent/mm/loader/j/b:aSO	()Ljava/lang/String;
    //   78: aload_3
    //   79: invokespecial 146	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: astore 5
    //   84: aload 5
    //   86: invokevirtual 149	com/tencent/mm/vfs/q:ifE	()Z
    //   89: ifeq +218 -> 307
    //   92: invokestatic 155	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   95: pop
    //   96: new 61	com/tencent/mm/vfs/q
    //   99: dup
    //   100: invokestatic 160	com/tencent/mm/model/c:bce	()Ljava/lang/String;
    //   103: aload_3
    //   104: aload 6
    //   106: invokestatic 166	com/tencent/mm/pluginsdk/model/app/m:aw	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   109: invokespecial 167	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   112: astore 5
    //   114: aload 5
    //   116: invokestatic 92	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   119: astore_3
    //   120: aload_0
    //   121: aload_1
    //   122: invokevirtual 96	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   125: astore_0
    //   126: aload_0
    //   127: ifnonnull +19 -> 146
    //   130: aload_0
    //   131: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   134: aload_3
    //   135: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   138: sipush 31178
    //   141: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aconst_null
    //   145: areturn
    //   146: aload_0
    //   147: astore 4
    //   149: aload_3
    //   150: astore_1
    //   151: sipush 1024
    //   154: newarray byte
    //   156: astore 6
    //   158: aload_0
    //   159: astore 4
    //   161: aload_3
    //   162: astore_1
    //   163: aload_0
    //   164: aload 6
    //   166: invokevirtual 108	java/io/InputStream:read	([B)I
    //   169: istore_2
    //   170: iload_2
    //   171: ifle +55 -> 226
    //   174: aload_0
    //   175: astore 4
    //   177: aload_3
    //   178: astore_1
    //   179: aload_3
    //   180: aload 6
    //   182: iconst_0
    //   183: iload_2
    //   184: invokevirtual 114	java/io/OutputStream:write	([BII)V
    //   187: goto -29 -> 158
    //   190: astore 5
    //   192: aload_0
    //   193: astore 4
    //   195: aload_3
    //   196: astore_1
    //   197: ldc 116
    //   199: aload 5
    //   201: ldc 118
    //   203: iconst_0
    //   204: anewarray 4	java/lang/Object
    //   207: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: aload_0
    //   211: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   214: aload_3
    //   215: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   218: sipush 31178
    //   221: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: aconst_null
    //   225: areturn
    //   226: aload_0
    //   227: astore 4
    //   229: aload_3
    //   230: astore_1
    //   231: aload 5
    //   233: invokevirtual 127	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   236: astore 5
    //   238: aload_0
    //   239: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   242: aload_3
    //   243: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   246: sipush 31178
    //   249: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload 5
    //   254: areturn
    //   255: astore_0
    //   256: aconst_null
    //   257: astore 4
    //   259: aconst_null
    //   260: astore_1
    //   261: aload 4
    //   263: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   266: aload_1
    //   267: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   270: sipush 31178
    //   273: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload_0
    //   277: athrow
    //   278: astore_0
    //   279: aconst_null
    //   280: astore 4
    //   282: aload_3
    //   283: astore_1
    //   284: goto -23 -> 261
    //   287: astore_0
    //   288: goto -27 -> 261
    //   291: astore 5
    //   293: aconst_null
    //   294: astore_0
    //   295: aconst_null
    //   296: astore_3
    //   297: goto -105 -> 192
    //   300: astore 5
    //   302: aconst_null
    //   303: astore_0
    //   304: goto -112 -> 192
    //   307: goto -193 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	paramContentResolver	android.content.ContentResolver
    //   0	310	1	paramUri	android.net.Uri
    //   169	15	2	i	int
    //   41	256	3	localObject1	Object
    //   37	244	4	localObject2	Object
    //   23	92	5	localObject3	Object
    //   190	42	5	localException1	java.lang.Exception
    //   236	17	5	str	String
    //   291	1	5	localException2	java.lang.Exception
    //   300	1	5	localException3	java.lang.Exception
    //   30	151	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   151	158	190	java/lang/Exception
    //   163	170	190	java/lang/Exception
    //   179	187	190	java/lang/Exception
    //   231	238	190	java/lang/Exception
    //   114	120	255	finally
    //   120	126	278	finally
    //   151	158	287	finally
    //   163	170	287	finally
    //   179	187	287	finally
    //   197	210	287	finally
    //   231	238	287	finally
    //   114	120	291	java/lang/Exception
    //   120	126	300	java/lang/Exception
  }
  
  private static String bqJ(String paramString)
  {
    AppMethodBeat.i(280079);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(280079);
      return paramString;
    }
    if (paramString.startsWith("/sdcard/"))
    {
      paramString = paramString.substring(8);
      AppMethodBeat.o(280079);
      return paramString;
    }
    if (paramString.startsWith(Rbp))
    {
      paramString = paramString.substring(Rbp.length());
      AppMethodBeat.o(280079);
      return paramString;
    }
    AppMethodBeat.o(280079);
    return paramString;
  }
  
  /* Error */
  public static String bqK(String paramString)
  {
    // Byte code:
    //   0: ldc 187
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 136	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +17 -> 26
    //   12: ldc 116
    //   14: ldc 189
    //   16: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 187
    //   21: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aconst_null
    //   25: areturn
    //   26: getstatic 198	android/os/Build$VERSION:SDK_INT	I
    //   29: bipush 29
    //   31: if_icmplt +17 -> 48
    //   34: ldc 116
    //   36: ldc 200
    //   38: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: ldc 187
    //   43: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: areturn
    //   48: new 205	java/io/FileInputStream
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 206	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   56: astore_2
    //   57: aload_2
    //   58: invokevirtual 210	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   61: astore_3
    //   62: ldc 212
    //   64: ldc 214
    //   66: iconst_0
    //   67: anewarray 216	java/lang/Class
    //   70: invokevirtual 220	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   73: astore 4
    //   75: aload 4
    //   77: iconst_1
    //   78: invokevirtual 226	java/lang/reflect/Method:setAccessible	(Z)V
    //   81: aload 4
    //   83: aload_3
    //   84: iconst_0
    //   85: anewarray 4	java/lang/Object
    //   88: invokevirtual 230	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   91: checkcast 232	java/lang/Integer
    //   94: invokevirtual 235	java/lang/Integer:intValue	()I
    //   97: istore_1
    //   98: ldc 237
    //   100: iload_1
    //   101: invokestatic 240	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   104: invokevirtual 243	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   107: invokestatic 248	android/system/Os:readlink	(Ljava/lang/String;)Ljava/lang/String;
    //   110: astore_3
    //   111: ldc 116
    //   113: ldc 250
    //   115: iconst_2
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload_0
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: aload_3
    //   126: aastore
    //   127: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: aload_0
    //   131: aload_3
    //   132: invokevirtual 256	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   135: ifne +103 -> 238
    //   138: aload_0
    //   139: invokestatic 258	com/tencent/mm/pluginsdk/m/e:bqJ	(Ljava/lang/String;)Ljava/lang/String;
    //   142: aload_3
    //   143: invokestatic 258	com/tencent/mm/pluginsdk/m/e:bqJ	(Ljava/lang/String;)Ljava/lang/String;
    //   146: invokevirtual 256	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   149: ifne +89 -> 238
    //   152: ldc 116
    //   154: ldc_w 260
    //   157: iconst_2
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_0
    //   164: aastore
    //   165: dup
    //   166: iconst_1
    //   167: aload_3
    //   168: aastore
    //   169: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aconst_null
    //   173: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   176: aload_2
    //   177: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   180: ldc 187
    //   182: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aconst_null
    //   186: areturn
    //   187: astore 4
    //   189: ldc 116
    //   191: aload 4
    //   193: ldc_w 264
    //   196: iconst_0
    //   197: anewarray 4	java/lang/Object
    //   200: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   203: new 266	java/io/File
    //   206: dup
    //   207: aload_0
    //   208: invokespecial 267	java/io/File:<init>	(Ljava/lang/String;)V
    //   211: invokevirtual 270	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   214: astore_3
    //   215: goto -104 -> 111
    //   218: astore_3
    //   219: ldc 116
    //   221: aload 4
    //   223: ldc_w 272
    //   226: iconst_0
    //   227: anewarray 4	java/lang/Object
    //   230: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   233: aload_0
    //   234: astore_3
    //   235: goto -124 -> 111
    //   238: aload_3
    //   239: invokestatic 275	com/tencent/mm/sdk/platformtools/Util:isResolvedPathSafeToBeCopySrc	(Ljava/lang/String;)Z
    //   242: ifne +38 -> 280
    //   245: ldc 116
    //   247: ldc_w 277
    //   250: iconst_2
    //   251: anewarray 4	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: aload_3
    //   257: aastore
    //   258: dup
    //   259: iconst_1
    //   260: aload_0
    //   261: aastore
    //   262: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: aconst_null
    //   266: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   269: aload_2
    //   270: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   273: ldc 187
    //   275: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: aconst_null
    //   279: areturn
    //   280: new 61	com/tencent/mm/vfs/q
    //   283: dup
    //   284: ldc_w 279
    //   287: invokestatic 285	com/tencent/mm/vfs/ab:bCa	(Ljava/lang/String;)Lcom/tencent/mm/vfs/q;
    //   290: new 266	java/io/File
    //   293: dup
    //   294: aload_3
    //   295: invokespecial 267	java/io/File:<init>	(Ljava/lang/String;)V
    //   298: invokevirtual 288	java/io/File:getName	()Ljava/lang/String;
    //   301: invokespecial 291	com/tencent/mm/vfs/q:<init>	(Lcom/tencent/mm/vfs/q;Ljava/lang/String;)V
    //   304: astore 6
    //   306: aload 6
    //   308: invokestatic 92	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   311: astore 5
    //   313: aload_2
    //   314: astore 4
    //   316: aload 5
    //   318: astore_3
    //   319: aload_2
    //   320: aload 5
    //   322: invokestatic 296	com/tencent/mm/vfs/ad:c	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   325: pop2
    //   326: aload_2
    //   327: astore 4
    //   329: aload 5
    //   331: astore_3
    //   332: aload 6
    //   334: invokevirtual 127	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   337: iconst_0
    //   338: invokestatic 300	com/tencent/mm/vfs/u:n	(Ljava/lang/String;Z)Ljava/lang/String;
    //   341: astore 6
    //   343: aload_2
    //   344: astore 4
    //   346: aload 5
    //   348: astore_3
    //   349: ldc 116
    //   351: ldc_w 302
    //   354: iconst_2
    //   355: anewarray 4	java/lang/Object
    //   358: dup
    //   359: iconst_0
    //   360: aload_0
    //   361: aastore
    //   362: dup
    //   363: iconst_1
    //   364: aload 6
    //   366: aastore
    //   367: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   370: aload 5
    //   372: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   375: aload_2
    //   376: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   379: ldc 187
    //   381: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   384: aload 6
    //   386: areturn
    //   387: astore 6
    //   389: aconst_null
    //   390: astore 7
    //   392: aconst_null
    //   393: astore_2
    //   394: aload 7
    //   396: astore 4
    //   398: aload_2
    //   399: astore_3
    //   400: ldc 116
    //   402: aload 6
    //   404: ldc_w 304
    //   407: iconst_1
    //   408: anewarray 4	java/lang/Object
    //   411: dup
    //   412: iconst_0
    //   413: aload_0
    //   414: aastore
    //   415: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   418: aload_2
    //   419: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   422: aload 7
    //   424: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   427: ldc 187
    //   429: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   432: aconst_null
    //   433: areturn
    //   434: astore_0
    //   435: aconst_null
    //   436: astore_2
    //   437: aconst_null
    //   438: astore_3
    //   439: aload_3
    //   440: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   443: aload_2
    //   444: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   447: ldc 187
    //   449: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: aload_0
    //   453: athrow
    //   454: astore_0
    //   455: aconst_null
    //   456: astore_3
    //   457: goto -18 -> 439
    //   460: astore_0
    //   461: aload 4
    //   463: astore_2
    //   464: goto -25 -> 439
    //   467: astore 6
    //   469: aconst_null
    //   470: astore_3
    //   471: aload_2
    //   472: astore 7
    //   474: aload_3
    //   475: astore_2
    //   476: goto -82 -> 394
    //   479: astore 6
    //   481: aload_2
    //   482: astore 7
    //   484: aload 5
    //   486: astore_2
    //   487: goto -93 -> 394
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	paramString	String
    //   97	4	1	i	int
    //   56	431	2	localObject1	Object
    //   61	154	3	localObject2	Object
    //   218	1	3	localThrowable1	java.lang.Throwable
    //   234	241	3	localObject3	Object
    //   73	9	4	localMethod	java.lang.reflect.Method
    //   187	35	4	localThrowable2	java.lang.Throwable
    //   314	148	4	localObject4	Object
    //   311	174	5	localOutputStream	java.io.OutputStream
    //   304	81	6	localObject5	Object
    //   387	16	6	localThrowable3	java.lang.Throwable
    //   467	1	6	localThrowable4	java.lang.Throwable
    //   479	1	6	localThrowable5	java.lang.Throwable
    //   390	93	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   98	111	187	java/lang/Throwable
    //   203	215	218	java/lang/Throwable
    //   48	57	387	java/lang/Throwable
    //   48	57	434	finally
    //   57	98	454	finally
    //   98	111	454	finally
    //   111	172	454	finally
    //   189	203	454	finally
    //   203	215	454	finally
    //   219	233	454	finally
    //   238	265	454	finally
    //   280	313	454	finally
    //   319	326	460	finally
    //   332	343	460	finally
    //   349	370	460	finally
    //   400	418	460	finally
    //   57	98	467	java/lang/Throwable
    //   111	172	467	java/lang/Throwable
    //   189	203	467	java/lang/Throwable
    //   219	233	467	java/lang/Throwable
    //   238	265	467	java/lang/Throwable
    //   280	313	467	java/lang/Throwable
    //   319	326	479	java/lang/Throwable
    //   332	343	479	java/lang/Throwable
    //   349	370	479	java/lang/Throwable
  }
  
  /* Error */
  private static String c(android.content.ContentResolver paramContentResolver, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: sipush 31179
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: iconst_1
    //   9: anewarray 173	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: ldc_w 306
    //   17: aastore
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 310	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +170 -> 196
    //   29: aload_0
    //   30: astore_2
    //   31: aload_0
    //   32: invokeinterface 315 1 0
    //   37: ifeq +159 -> 196
    //   40: aload_0
    //   41: astore_2
    //   42: new 61	com/tencent/mm/vfs/q
    //   45: dup
    //   46: aload_0
    //   47: iconst_0
    //   48: invokeinterface 318 2 0
    //   53: invokespecial 167	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   56: invokevirtual 319	com/tencent/mm/vfs/q:getName	()Ljava/lang/String;
    //   59: astore_3
    //   60: aload_3
    //   61: astore_1
    //   62: aload_1
    //   63: astore_2
    //   64: aload_0
    //   65: ifnull +11 -> 76
    //   68: aload_0
    //   69: invokeinterface 322 1 0
    //   74: aload_1
    //   75: astore_2
    //   76: sipush 31179
    //   79: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_2
    //   83: areturn
    //   84: astore_3
    //   85: aconst_null
    //   86: astore_0
    //   87: aload_0
    //   88: astore_2
    //   89: ldc 116
    //   91: aload_3
    //   92: ldc_w 324
    //   95: iconst_0
    //   96: anewarray 4	java/lang/Object
    //   99: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: aload_0
    //   103: astore_2
    //   104: aload_1
    //   105: invokevirtual 327	android/net/Uri:toString	()Ljava/lang/String;
    //   108: ldc_w 329
    //   111: invokestatic 335	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   114: ldc 36
    //   116: invokevirtual 339	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   136: invokeinterface 322 1 0
    //   141: aload_1
    //   142: astore_2
    //   143: goto -67 -> 76
    //   146: astore_1
    //   147: aload_0
    //   148: astore_2
    //   149: ldc 116
    //   151: aload_1
    //   152: ldc_w 341
    //   155: iconst_0
    //   156: anewarray 4	java/lang/Object
    //   159: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: aconst_null
    //   163: astore_1
    //   164: goto -35 -> 129
    //   167: astore_0
    //   168: aconst_null
    //   169: astore_2
    //   170: aload_2
    //   171: ifnull +9 -> 180
    //   174: aload_2
    //   175: invokeinterface 322 1 0
    //   180: sipush 31179
    //   183: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.m.e
 * JD-Core Version:    0.7.0.1
 */