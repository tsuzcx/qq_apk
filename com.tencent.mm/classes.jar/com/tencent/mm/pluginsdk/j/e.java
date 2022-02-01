package com.tencent.mm.pluginsdk.j;

import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

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
    //   24: new 25	com/tencent/mm/vfs/e
    //   27: dup
    //   28: invokestatic 31	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   31: invokevirtual 37	android/content/Context:getCacheDir	()Ljava/io/File;
    //   34: new 39	java/lang/StringBuilder
    //   37: dup
    //   38: ldc 41
    //   40: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: iload_2
    //   44: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: aload_3
    //   48: invokestatic 53	com/tencent/mm/pluginsdk/j/e:aGP	(Ljava/lang/String;)Ljava/lang/String;
    //   51: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 63	com/tencent/mm/vfs/e:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   60: astore 5
    //   62: aload 5
    //   64: invokevirtual 67	com/tencent/mm/vfs/e:delete	()Z
    //   67: pop
    //   68: aload 5
    //   70: invokestatic 73	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   73: astore_3
    //   74: aload_0
    //   75: aload_1
    //   76: invokevirtual 77	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   79: astore_0
    //   80: aload_0
    //   81: ifnonnull +19 -> 100
    //   84: aload_0
    //   85: invokestatic 83	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   88: aload_3
    //   89: invokestatic 83	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
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
    //   161: invokestatic 105	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: aload_0
    //   165: invokestatic 83	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   168: aload_3
    //   169: invokestatic 83	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   172: sipush 31180
    //   175: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aconst_null
    //   179: areturn
    //   180: aload_0
    //   181: astore 4
    //   183: aload_3
    //   184: astore_1
    //   185: aload 5
    //   187: invokevirtual 109	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
    //   190: invokestatic 114	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   193: astore 5
    //   195: aload_0
    //   196: invokestatic 83	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   199: aload_3
    //   200: invokestatic 83	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
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
    //   220: invokestatic 83	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   223: aload_1
    //   224: invokestatic 83	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
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
    //   60	9	5	locale	com.tencent.mm.vfs.e
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
  
  private static String aGP(String paramString)
  {
    AppMethodBeat.i(31181);
    if (bs.isNullOrNil(paramString))
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
    //   27: invokestatic 53	com/tencent/mm/pluginsdk/j/e:aGP	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 6
    //   32: aload_0
    //   33: aload_1
    //   34: invokestatic 156	com/tencent/mm/pluginsdk/j/e:c	(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/lang/String;
    //   37: astore 4
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: invokestatic 119	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   47: ifeq +24 -> 71
    //   50: new 39	java/lang/StringBuilder
    //   53: dup
    //   54: ldc 158
    //   56: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: aload 5
    //   61: invokestatic 53	com/tencent/mm/pluginsdk/j/e:aGP	(Ljava/lang/String;)Ljava/lang/String;
    //   64: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore_3
    //   71: new 25	com/tencent/mm/vfs/e
    //   74: dup
    //   75: invokestatic 163	com/tencent/mm/loader/j/b:apj	()Ljava/lang/String;
    //   78: aload_3
    //   79: invokespecial 166	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: astore 5
    //   84: aload 5
    //   86: invokevirtual 169	com/tencent/mm/vfs/e:exists	()Z
    //   89: ifeq +221 -> 310
    //   92: invokestatic 175	com/tencent/mm/model/az:ayM	()Lcom/tencent/mm/model/c;
    //   95: pop
    //   96: new 25	com/tencent/mm/vfs/e
    //   99: dup
    //   100: invokestatic 180	com/tencent/mm/model/c:awT	()Ljava/lang/String;
    //   103: aload_3
    //   104: aload 6
    //   106: invokestatic 186	com/tencent/mm/pluginsdk/model/app/m:aj	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   109: invokespecial 187	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   112: astore 5
    //   114: aload 5
    //   116: invokestatic 73	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   119: astore_3
    //   120: aload_0
    //   121: aload_1
    //   122: invokevirtual 77	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   125: astore_0
    //   126: aload_0
    //   127: ifnonnull +19 -> 146
    //   130: aload_0
    //   131: invokestatic 83	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   134: aload_3
    //   135: invokestatic 83	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   138: sipush 31178
    //   141: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   166: invokevirtual 89	java/io/InputStream:read	([B)I
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
    //   184: invokevirtual 95	java/io/OutputStream:write	([BII)V
    //   187: goto -29 -> 158
    //   190: astore 5
    //   192: aload_0
    //   193: astore 4
    //   195: aload_3
    //   196: astore_1
    //   197: ldc 97
    //   199: aload 5
    //   201: ldc 99
    //   203: iconst_0
    //   204: anewarray 4	java/lang/Object
    //   207: invokestatic 105	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: aload_0
    //   211: invokestatic 83	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   214: aload_3
    //   215: invokestatic 83	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   218: sipush 31178
    //   221: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: aconst_null
    //   225: areturn
    //   226: aload_0
    //   227: astore 4
    //   229: aload_3
    //   230: astore_1
    //   231: aload 5
    //   233: invokevirtual 109	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
    //   236: invokestatic 114	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   239: astore 5
    //   241: aload_0
    //   242: invokestatic 83	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   245: aload_3
    //   246: invokestatic 83	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   249: sipush 31178
    //   252: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: aload 5
    //   257: areturn
    //   258: astore_0
    //   259: aconst_null
    //   260: astore 4
    //   262: aconst_null
    //   263: astore_1
    //   264: aload 4
    //   266: invokestatic 83	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   269: aload_1
    //   270: invokestatic 83	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   273: sipush 31178
    //   276: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  /* Error */
  private static String c(android.content.ContentResolver paramContentResolver, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: sipush 31179
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: iconst_1
    //   9: anewarray 132	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: ldc 189
    //   16: aastore
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokevirtual 193	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_0
    //   24: aload_0
    //   25: ifnull +167 -> 192
    //   28: aload_0
    //   29: astore_2
    //   30: aload_0
    //   31: invokeinterface 198 1 0
    //   36: ifeq +156 -> 192
    //   39: aload_0
    //   40: astore_2
    //   41: new 25	com/tencent/mm/vfs/e
    //   44: dup
    //   45: aload_0
    //   46: iconst_0
    //   47: invokeinterface 202 2 0
    //   52: invokespecial 187	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   55: invokevirtual 205	com/tencent/mm/vfs/e:getName	()Ljava/lang/String;
    //   58: astore_3
    //   59: aload_3
    //   60: astore_1
    //   61: aload_1
    //   62: astore_2
    //   63: aload_0
    //   64: ifnull +11 -> 75
    //   67: aload_0
    //   68: invokeinterface 209 1 0
    //   73: aload_1
    //   74: astore_2
    //   75: sipush 31179
    //   78: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_2
    //   82: areturn
    //   83: astore_3
    //   84: aconst_null
    //   85: astore_0
    //   86: aload_0
    //   87: astore_2
    //   88: ldc 97
    //   90: aload_3
    //   91: ldc 211
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokestatic 105	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: aload_0
    //   101: astore_2
    //   102: aload_1
    //   103: invokevirtual 214	android/net/Uri:toString	()Ljava/lang/String;
    //   106: ldc 216
    //   108: invokestatic 222	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   111: ldc 138
    //   113: invokevirtual 142	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   116: astore_1
    //   117: aload_0
    //   118: astore_2
    //   119: aload_1
    //   120: aload_1
    //   121: arraylength
    //   122: iconst_1
    //   123: isub
    //   124: aaload
    //   125: astore_1
    //   126: aload_1
    //   127: astore_2
    //   128: aload_0
    //   129: ifnull -54 -> 75
    //   132: aload_0
    //   133: invokeinterface 209 1 0
    //   138: aload_1
    //   139: astore_2
    //   140: goto -65 -> 75
    //   143: astore_1
    //   144: aload_0
    //   145: astore_2
    //   146: ldc 97
    //   148: aload_1
    //   149: ldc 224
    //   151: iconst_0
    //   152: anewarray 4	java/lang/Object
    //   155: invokestatic 105	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: aconst_null
    //   159: astore_1
    //   160: goto -34 -> 126
    //   163: astore_0
    //   164: aconst_null
    //   165: astore_2
    //   166: aload_2
    //   167: ifnull +9 -> 176
    //   170: aload_2
    //   171: invokeinterface 209 1 0
    //   176: sipush 31179
    //   179: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_0
    //   183: athrow
    //   184: astore_0
    //   185: goto -19 -> 166
    //   188: astore_3
    //   189: goto -103 -> 86
    //   192: aconst_null
    //   193: astore_1
    //   194: goto -133 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramContentResolver	android.content.ContentResolver
    //   0	197	1	paramUri	android.net.Uri
    //   29	142	2	localObject	Object
    //   58	2	3	str	String
    //   83	8	3	localException1	java.lang.Exception
    //   188	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   6	24	83	java/lang/Exception
    //   102	117	143	java/lang/Exception
    //   119	126	143	java/lang/Exception
    //   6	24	163	finally
    //   30	39	184	finally
    //   41	59	184	finally
    //   88	100	184	finally
    //   102	117	184	finally
    //   119	126	184	finally
    //   146	158	184	finally
    //   30	39	188	java/lang/Exception
    //   41	59	188	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.e
 * JD-Core Version:    0.7.0.1
 */