package com.tencent.mm.pluginsdk.l;

import android.os.Process;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  private static final String KaM;
  
  static
  {
    AppMethodBeat.i(232186);
    KaM = "/storage/emulated/" + Process.myUid() / 100000 + "/";
    AppMethodBeat.o(232186);
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
    //   24: new 61	com/tencent/mm/vfs/o
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
    //   48: invokestatic 79	com/tencent/mm/pluginsdk/l/e:getExtByMimeType	(Ljava/lang/String;)Ljava/lang/String;
    //   51: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 82	com/tencent/mm/vfs/o:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   60: astore 5
    //   62: aload 5
    //   64: invokevirtual 86	com/tencent/mm/vfs/o:delete	()Z
    //   67: pop
    //   68: aload 5
    //   70: invokestatic 92	com/tencent/mm/vfs/s:ap	(Lcom/tencent/mm/vfs/o;)Ljava/io/OutputStream;
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
    //   187: invokevirtual 128	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   190: invokestatic 133	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   193: astore 5
    //   195: aload_0
    //   196: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   199: aload_3
    //   200: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   203: sipush 31180
    //   206: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: aload 5
    //   211: areturn
    //   212: astore_0
    //   213: aconst_null
    //   214: astore 4
    //   216: aconst_null
    //   217: astore_1
    //   218: aload 4
    //   220: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   223: aload_1
    //   224: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   227: sipush 31180
    //   230: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   60	9	5	localo	com.tencent.mm.vfs.o
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
    //   27: invokestatic 79	com/tencent/mm/pluginsdk/l/e:getExtByMimeType	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 6
    //   32: aload_0
    //   33: aload_1
    //   34: invokestatic 138	com/tencent/mm/pluginsdk/l/e:c	(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/lang/String;
    //   37: astore 4
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: invokestatic 142	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   47: ifeq +24 -> 71
    //   50: new 17	java/lang/StringBuilder
    //   53: dup
    //   54: ldc 144
    //   56: invokespecial 23	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: aload 5
    //   61: invokestatic 79	com/tencent/mm/pluginsdk/l/e:getExtByMimeType	(Ljava/lang/String;)Ljava/lang/String;
    //   64: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore_3
    //   71: new 61	com/tencent/mm/vfs/o
    //   74: dup
    //   75: invokestatic 149	com/tencent/mm/loader/j/b:aKM	()Ljava/lang/String;
    //   78: aload_3
    //   79: invokespecial 152	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: astore 5
    //   84: aload 5
    //   86: invokevirtual 155	com/tencent/mm/vfs/o:exists	()Z
    //   89: ifeq +221 -> 310
    //   92: invokestatic 161	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   95: pop
    //   96: new 61	com/tencent/mm/vfs/o
    //   99: dup
    //   100: invokestatic 166	com/tencent/mm/model/c:aTg	()Ljava/lang/String;
    //   103: aload_3
    //   104: aload 6
    //   106: invokestatic 172	com/tencent/mm/pluginsdk/model/app/m:aB	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   109: invokespecial 173	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   112: astore 5
    //   114: aload 5
    //   116: invokestatic 92	com/tencent/mm/vfs/s:ap	(Lcom/tencent/mm/vfs/o;)Ljava/io/OutputStream;
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
    //   233: invokevirtual 128	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   236: invokestatic 133	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   239: astore 5
    //   241: aload_0
    //   242: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   245: aload_3
    //   246: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   249: sipush 31178
    //   252: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: aload 5
    //   257: areturn
    //   258: astore_0
    //   259: aconst_null
    //   260: astore 4
    //   262: aconst_null
    //   263: astore_1
    //   264: aload 4
    //   266: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   269: aload_1
    //   270: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   273: sipush 31178
    //   276: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: aload_0
    //   280: athrow
    //   281: astore_0
    //   282: aconst_null
    //   283: astore 4
    //   285: aload_3
    //   286: astore_1
    //   287: goto -23 -> 264
    //   290: astore_0
    //   291: goto -27 -> 264
    //   294: astore 5
    //   296: aconst_null
    //   297: astore_0
    //   298: aconst_null
    //   299: astore_3
    //   300: goto -108 -> 192
    //   303: astore 5
    //   305: aconst_null
    //   306: astore_0
    //   307: goto -115 -> 192
    //   310: goto -196 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	paramContentResolver	android.content.ContentResolver
    //   0	313	1	paramUri	android.net.Uri
    //   169	15	2	i	int
    //   41	259	3	localObject1	Object
    //   37	247	4	localObject2	Object
    //   23	92	5	localObject3	Object
    //   190	42	5	localException1	java.lang.Exception
    //   239	17	5	str	String
    //   294	1	5	localException2	java.lang.Exception
    //   303	1	5	localException3	java.lang.Exception
    //   30	151	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   151	158	190	java/lang/Exception
    //   163	170	190	java/lang/Exception
    //   179	187	190	java/lang/Exception
    //   231	241	190	java/lang/Exception
    //   114	120	258	finally
    //   120	126	281	finally
    //   151	158	290	finally
    //   163	170	290	finally
    //   179	187	290	finally
    //   197	210	290	finally
    //   231	241	290	finally
    //   114	120	294	java/lang/Exception
    //   120	126	303	java/lang/Exception
  }
  
  private static String ben(String paramString)
  {
    AppMethodBeat.i(232184);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(232184);
      return paramString;
    }
    if (paramString.startsWith("/sdcard/"))
    {
      paramString = paramString.substring(8);
      AppMethodBeat.o(232184);
      return paramString;
    }
    if (paramString.startsWith(KaM))
    {
      paramString = paramString.substring(KaM.length());
      AppMethodBeat.o(232184);
      return paramString;
    }
    AppMethodBeat.o(232184);
    return paramString;
  }
  
  /* Error */
  public static String beo(String paramString)
  {
    // Byte code:
    //   0: ldc 193
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 142	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +17 -> 26
    //   12: ldc 116
    //   14: ldc 195
    //   16: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 193
    //   21: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aconst_null
    //   25: areturn
    //   26: getstatic 204	android/os/Build$VERSION:SDK_INT	I
    //   29: bipush 29
    //   31: if_icmplt +17 -> 48
    //   34: ldc 116
    //   36: ldc 206
    //   38: invokestatic 209	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: ldc 193
    //   43: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: areturn
    //   48: new 211	java/io/FileInputStream
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 212	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   56: astore_3
    //   57: aload_3
    //   58: invokevirtual 216	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   61: astore_2
    //   62: ldc 218
    //   64: ldc 220
    //   66: iconst_0
    //   67: anewarray 222	java/lang/Class
    //   70: invokevirtual 226	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   73: astore 4
    //   75: aload 4
    //   77: iconst_1
    //   78: invokevirtual 232	java/lang/reflect/Method:setAccessible	(Z)V
    //   81: aload 4
    //   83: aload_2
    //   84: iconst_0
    //   85: anewarray 4	java/lang/Object
    //   88: invokevirtual 236	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   91: checkcast 238	java/lang/Integer
    //   94: invokevirtual 241	java/lang/Integer:intValue	()I
    //   97: istore_1
    //   98: ldc 243
    //   100: iload_1
    //   101: invokestatic 246	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   104: invokevirtual 249	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   107: invokestatic 254	android/system/Os:readlink	(Ljava/lang/String;)Ljava/lang/String;
    //   110: astore_2
    //   111: ldc 116
    //   113: ldc_w 256
    //   116: iconst_2
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_0
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: aload_2
    //   127: aastore
    //   128: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload_0
    //   132: aload_2
    //   133: invokevirtual 262	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   136: ifne +103 -> 239
    //   139: aload_0
    //   140: invokestatic 264	com/tencent/mm/pluginsdk/l/e:ben	(Ljava/lang/String;)Ljava/lang/String;
    //   143: aload_2
    //   144: invokestatic 264	com/tencent/mm/pluginsdk/l/e:ben	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokevirtual 262	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   150: ifne +89 -> 239
    //   153: ldc 116
    //   155: ldc_w 266
    //   158: iconst_2
    //   159: anewarray 4	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: aload_0
    //   165: aastore
    //   166: dup
    //   167: iconst_1
    //   168: aload_2
    //   169: aastore
    //   170: invokestatic 268	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: aconst_null
    //   174: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   177: aload_3
    //   178: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   181: ldc 193
    //   183: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aconst_null
    //   187: areturn
    //   188: astore 4
    //   190: ldc 116
    //   192: aload 4
    //   194: ldc_w 270
    //   197: iconst_0
    //   198: anewarray 4	java/lang/Object
    //   201: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: new 272	java/io/File
    //   207: dup
    //   208: aload_0
    //   209: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   212: invokevirtual 276	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   215: astore_2
    //   216: goto -105 -> 111
    //   219: astore_2
    //   220: ldc 116
    //   222: aload 4
    //   224: ldc_w 278
    //   227: iconst_0
    //   228: anewarray 4	java/lang/Object
    //   231: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: aload_0
    //   235: astore_2
    //   236: goto -125 -> 111
    //   239: aload_2
    //   240: invokestatic 281	com/tencent/mm/sdk/platformtools/Util:isResolvedPathSafeToBeCopySrc	(Ljava/lang/String;)Z
    //   243: ifne +38 -> 281
    //   246: ldc 116
    //   248: ldc_w 283
    //   251: iconst_2
    //   252: anewarray 4	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: aload_2
    //   258: aastore
    //   259: dup
    //   260: iconst_1
    //   261: aload_0
    //   262: aastore
    //   263: invokestatic 268	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: aconst_null
    //   267: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   270: aload_3
    //   271: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   274: ldc 193
    //   276: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: aconst_null
    //   280: areturn
    //   281: new 272	java/io/File
    //   284: dup
    //   285: invokestatic 67	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   288: invokevirtual 73	android/content/Context:getCacheDir	()Ljava/io/File;
    //   291: new 17	java/lang/StringBuilder
    //   294: dup
    //   295: ldc_w 285
    //   298: invokespecial 23	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   301: new 272	java/io/File
    //   304: dup
    //   305: aload_2
    //   306: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   309: invokevirtual 288	java/io/File:getName	()Ljava/lang/String;
    //   312: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokespecial 289	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   321: astore 6
    //   323: aload 6
    //   325: invokevirtual 290	java/io/File:exists	()Z
    //   328: ifne +12 -> 340
    //   331: aload 6
    //   333: invokevirtual 293	java/io/File:getParentFile	()Ljava/io/File;
    //   336: invokevirtual 296	java/io/File:mkdirs	()Z
    //   339: pop
    //   340: sipush 4096
    //   343: newarray byte
    //   345: astore 7
    //   347: new 298	java/io/BufferedOutputStream
    //   350: dup
    //   351: new 300	java/io/FileOutputStream
    //   354: dup
    //   355: aload 6
    //   357: invokespecial 303	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   360: invokespecial 306	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   363: astore_2
    //   364: aload_3
    //   365: astore 5
    //   367: aload_2
    //   368: astore 4
    //   370: new 308	java/io/BufferedInputStream
    //   373: dup
    //   374: aload_3
    //   375: invokespecial 311	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   378: astore 8
    //   380: aload_3
    //   381: astore 5
    //   383: aload_2
    //   384: astore 4
    //   386: aload 8
    //   388: aload 7
    //   390: invokevirtual 312	java/io/BufferedInputStream:read	([B)I
    //   393: istore_1
    //   394: iload_1
    //   395: ifle +61 -> 456
    //   398: aload_3
    //   399: astore 5
    //   401: aload_2
    //   402: astore 4
    //   404: aload_2
    //   405: aload 7
    //   407: iconst_0
    //   408: iload_1
    //   409: invokevirtual 114	java/io/OutputStream:write	([BII)V
    //   412: goto -32 -> 380
    //   415: astore 6
    //   417: aload_3
    //   418: astore 5
    //   420: aload_2
    //   421: astore 4
    //   423: ldc 116
    //   425: aload 6
    //   427: ldc_w 314
    //   430: iconst_1
    //   431: anewarray 4	java/lang/Object
    //   434: dup
    //   435: iconst_0
    //   436: aload_0
    //   437: aastore
    //   438: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   441: aload_2
    //   442: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   445: aload_3
    //   446: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   449: ldc 193
    //   451: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   454: aconst_null
    //   455: areturn
    //   456: aload_3
    //   457: astore 5
    //   459: aload_2
    //   460: astore 4
    //   462: aload 6
    //   464: invokevirtual 317	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   467: astore 6
    //   469: aload_3
    //   470: astore 5
    //   472: aload_2
    //   473: astore 4
    //   475: ldc 116
    //   477: ldc_w 319
    //   480: iconst_2
    //   481: anewarray 4	java/lang/Object
    //   484: dup
    //   485: iconst_0
    //   486: aload_0
    //   487: aastore
    //   488: dup
    //   489: iconst_1
    //   490: aload 6
    //   492: aastore
    //   493: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   496: aload_2
    //   497: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   500: aload_3
    //   501: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   504: ldc 193
    //   506: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   509: aload 6
    //   511: areturn
    //   512: astore_0
    //   513: aconst_null
    //   514: astore_3
    //   515: aconst_null
    //   516: astore 4
    //   518: aload 4
    //   520: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   523: aload_3
    //   524: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   527: ldc 193
    //   529: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   532: aload_0
    //   533: athrow
    //   534: astore_0
    //   535: aconst_null
    //   536: astore 4
    //   538: goto -20 -> 518
    //   541: astore_0
    //   542: aload 5
    //   544: astore_3
    //   545: goto -27 -> 518
    //   548: astore 6
    //   550: aconst_null
    //   551: astore_3
    //   552: aconst_null
    //   553: astore_2
    //   554: goto -137 -> 417
    //   557: astore 6
    //   559: aconst_null
    //   560: astore_2
    //   561: goto -144 -> 417
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	564	0	paramString	String
    //   97	312	1	i	int
    //   61	155	2	localObject1	Object
    //   219	1	2	localThrowable1	java.lang.Throwable
    //   235	326	2	localObject2	Object
    //   56	496	3	localObject3	Object
    //   73	9	4	localMethod	java.lang.reflect.Method
    //   188	35	4	localThrowable2	java.lang.Throwable
    //   368	169	4	localObject4	Object
    //   365	178	5	localObject5	Object
    //   321	35	6	localFile	java.io.File
    //   415	48	6	localThrowable3	java.lang.Throwable
    //   467	43	6	str	String
    //   548	1	6	localThrowable4	java.lang.Throwable
    //   557	1	6	localThrowable5	java.lang.Throwable
    //   345	61	7	arrayOfByte	byte[]
    //   378	9	8	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   98	111	188	java/lang/Throwable
    //   204	216	219	java/lang/Throwable
    //   370	380	415	java/lang/Throwable
    //   386	394	415	java/lang/Throwable
    //   404	412	415	java/lang/Throwable
    //   462	469	415	java/lang/Throwable
    //   475	496	415	java/lang/Throwable
    //   48	57	512	finally
    //   57	98	534	finally
    //   98	111	534	finally
    //   111	173	534	finally
    //   190	204	534	finally
    //   204	216	534	finally
    //   220	234	534	finally
    //   239	266	534	finally
    //   281	340	534	finally
    //   340	364	534	finally
    //   370	380	541	finally
    //   386	394	541	finally
    //   404	412	541	finally
    //   423	441	541	finally
    //   462	469	541	finally
    //   475	496	541	finally
    //   48	57	548	java/lang/Throwable
    //   57	98	557	java/lang/Throwable
    //   111	173	557	java/lang/Throwable
    //   190	204	557	java/lang/Throwable
    //   220	234	557	java/lang/Throwable
    //   239	266	557	java/lang/Throwable
    //   281	340	557	java/lang/Throwable
    //   340	364	557	java/lang/Throwable
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
    //   9: anewarray 179	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: ldc_w 321
    //   17: aastore
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 325	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +170 -> 196
    //   29: aload_0
    //   30: astore_2
    //   31: aload_0
    //   32: invokeinterface 330 1 0
    //   37: ifeq +159 -> 196
    //   40: aload_0
    //   41: astore_2
    //   42: new 61	com/tencent/mm/vfs/o
    //   45: dup
    //   46: aload_0
    //   47: iconst_0
    //   48: invokeinterface 333 2 0
    //   53: invokespecial 173	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   56: invokevirtual 334	com/tencent/mm/vfs/o:getName	()Ljava/lang/String;
    //   59: astore_3
    //   60: aload_3
    //   61: astore_1
    //   62: aload_1
    //   63: astore_2
    //   64: aload_0
    //   65: ifnull +11 -> 76
    //   68: aload_0
    //   69: invokeinterface 337 1 0
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
    //   92: ldc_w 339
    //   95: iconst_0
    //   96: anewarray 4	java/lang/Object
    //   99: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: aload_0
    //   103: astore_2
    //   104: aload_1
    //   105: invokevirtual 342	android/net/Uri:toString	()Ljava/lang/String;
    //   108: ldc_w 344
    //   111: invokestatic 350	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   114: ldc 36
    //   116: invokevirtual 354	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   136: invokeinterface 337 1 0
    //   141: aload_1
    //   142: astore_2
    //   143: goto -67 -> 76
    //   146: astore_1
    //   147: aload_0
    //   148: astore_2
    //   149: ldc 116
    //   151: aload_1
    //   152: ldc_w 356
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
    //   175: invokeinterface 337 1 0
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.e
 * JD-Core Version:    0.7.0.1
 */