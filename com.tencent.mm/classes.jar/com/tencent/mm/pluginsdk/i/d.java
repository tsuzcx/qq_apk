package com.tencent.mm.pluginsdk.i;

import android.webkit.MimeTypeMap;
import com.tencent.mm.sdk.platformtools.bk;

public final class d
{
  /* Error */
  public static final String a(android.content.ContentResolver paramContentResolver, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 14	android/content/ContentResolver:getType	(Landroid/net/Uri;)Ljava/lang/String;
    //   11: astore 5
    //   13: aload_0
    //   14: aload_1
    //   15: invokestatic 17	com/tencent/mm/pluginsdk/i/d:b	(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/lang/String;
    //   18: astore 4
    //   20: aload 4
    //   22: astore_3
    //   23: aload 4
    //   25: invokestatic 23	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   28: ifeq +24 -> 52
    //   31: new 25	java/lang/StringBuilder
    //   34: dup
    //   35: ldc 27
    //   37: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload 5
    //   42: invokestatic 35	com/tencent/mm/pluginsdk/i/d:wL	(Ljava/lang/String;)Ljava/lang/String;
    //   45: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore_3
    //   52: new 45	com/tencent/mm/vfs/b
    //   55: dup
    //   56: getstatic 51	com/tencent/mm/compatible/util/e:dzB	Ljava/lang/String;
    //   59: aload_3
    //   60: invokespecial 54	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: astore 5
    //   65: aload 5
    //   67: invokevirtual 58	com/tencent/mm/vfs/b:delete	()Z
    //   70: pop
    //   71: aload 5
    //   73: invokestatic 64	com/tencent/mm/vfs/e:p	(Lcom/tencent/mm/vfs/b;)Ljava/io/OutputStream;
    //   76: astore_3
    //   77: aload_0
    //   78: aload_1
    //   79: invokevirtual 68	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   82: astore_0
    //   83: aload_0
    //   84: ifnonnull +13 -> 97
    //   87: aload_0
    //   88: invokestatic 71	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   91: aload_3
    //   92: invokestatic 71	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   95: aconst_null
    //   96: areturn
    //   97: aload_0
    //   98: astore 4
    //   100: aload_3
    //   101: astore_1
    //   102: sipush 1024
    //   105: newarray byte
    //   107: astore 6
    //   109: aload_0
    //   110: astore 4
    //   112: aload_3
    //   113: astore_1
    //   114: aload_0
    //   115: aload 6
    //   117: invokevirtual 77	java/io/InputStream:read	([B)I
    //   120: istore_2
    //   121: iload_2
    //   122: ifle +49 -> 171
    //   125: aload_0
    //   126: astore 4
    //   128: aload_3
    //   129: astore_1
    //   130: aload_3
    //   131: aload 6
    //   133: iconst_0
    //   134: iload_2
    //   135: invokevirtual 83	java/io/OutputStream:write	([BII)V
    //   138: goto -29 -> 109
    //   141: astore 5
    //   143: aload_0
    //   144: astore 4
    //   146: aload_3
    //   147: astore_1
    //   148: ldc 85
    //   150: aload 5
    //   152: ldc 87
    //   154: iconst_0
    //   155: anewarray 4	java/lang/Object
    //   158: invokestatic 93	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: aload_0
    //   162: invokestatic 71	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   165: aload_3
    //   166: invokestatic 71	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   169: aconst_null
    //   170: areturn
    //   171: aload_0
    //   172: astore 4
    //   174: aload_3
    //   175: astore_1
    //   176: aload 5
    //   178: invokevirtual 97	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   181: invokestatic 102	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   184: astore 5
    //   186: aload_0
    //   187: invokestatic 71	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   190: aload_3
    //   191: invokestatic 71	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   194: aload 5
    //   196: areturn
    //   197: astore_0
    //   198: aconst_null
    //   199: astore 4
    //   201: aconst_null
    //   202: astore_1
    //   203: aload 4
    //   205: invokestatic 71	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   208: aload_1
    //   209: invokestatic 71	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   212: aload_0
    //   213: athrow
    //   214: astore_0
    //   215: aconst_null
    //   216: astore 4
    //   218: aload_3
    //   219: astore_1
    //   220: goto -17 -> 203
    //   223: astore_0
    //   224: goto -21 -> 203
    //   227: astore 5
    //   229: aconst_null
    //   230: astore_0
    //   231: aconst_null
    //   232: astore_3
    //   233: goto -90 -> 143
    //   236: astore 5
    //   238: aconst_null
    //   239: astore_0
    //   240: goto -97 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramContentResolver	android.content.ContentResolver
    //   0	243	1	paramUri	android.net.Uri
    //   120	15	2	i	int
    //   22	211	3	localObject1	Object
    //   18	199	4	localObject2	Object
    //   11	61	5	localObject3	Object
    //   141	36	5	localException1	java.lang.Exception
    //   184	11	5	str	String
    //   227	1	5	localException2	java.lang.Exception
    //   236	1	5	localException3	java.lang.Exception
    //   107	25	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   102	109	141	java/lang/Exception
    //   114	121	141	java/lang/Exception
    //   130	138	141	java/lang/Exception
    //   176	186	141	java/lang/Exception
    //   71	77	197	finally
    //   77	83	214	finally
    //   102	109	223	finally
    //   114	121	223	finally
    //   130	138	223	finally
    //   148	161	223	finally
    //   176	186	223	finally
    //   71	77	227	java/lang/Exception
    //   77	83	236	java/lang/Exception
  }
  
  /* Error */
  public static final String a(android.content.ContentResolver paramContentResolver, android.net.Uri paramUri, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 14	android/content/ContentResolver:getType	(Landroid/net/Uri;)Ljava/lang/String;
    //   11: astore_3
    //   12: new 45	com/tencent/mm/vfs/b
    //   15: dup
    //   16: invokestatic 110	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   19: invokevirtual 116	android/content/Context:getCacheDir	()Ljava/io/File;
    //   22: new 25	java/lang/StringBuilder
    //   25: dup
    //   26: ldc 118
    //   28: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   31: iload_2
    //   32: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: aload_3
    //   36: invokestatic 35	com/tencent/mm/pluginsdk/i/d:wL	(Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 124	com/tencent/mm/vfs/b:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   48: astore 5
    //   50: aload 5
    //   52: invokevirtual 58	com/tencent/mm/vfs/b:delete	()Z
    //   55: pop
    //   56: aload 5
    //   58: invokestatic 64	com/tencent/mm/vfs/e:p	(Lcom/tencent/mm/vfs/b;)Ljava/io/OutputStream;
    //   61: astore_3
    //   62: aload_0
    //   63: aload_1
    //   64: invokevirtual 68	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   67: astore_0
    //   68: aload_0
    //   69: ifnonnull +13 -> 82
    //   72: aload_0
    //   73: invokestatic 71	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   76: aload_3
    //   77: invokestatic 71	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   80: aconst_null
    //   81: areturn
    //   82: aload_0
    //   83: astore 4
    //   85: aload_3
    //   86: astore_1
    //   87: sipush 1024
    //   90: newarray byte
    //   92: astore 6
    //   94: aload_0
    //   95: astore 4
    //   97: aload_3
    //   98: astore_1
    //   99: aload_0
    //   100: aload 6
    //   102: invokevirtual 77	java/io/InputStream:read	([B)I
    //   105: istore_2
    //   106: iload_2
    //   107: ifle +49 -> 156
    //   110: aload_0
    //   111: astore 4
    //   113: aload_3
    //   114: astore_1
    //   115: aload_3
    //   116: aload 6
    //   118: iconst_0
    //   119: iload_2
    //   120: invokevirtual 83	java/io/OutputStream:write	([BII)V
    //   123: goto -29 -> 94
    //   126: astore 5
    //   128: aload_0
    //   129: astore 4
    //   131: aload_3
    //   132: astore_1
    //   133: ldc 85
    //   135: aload 5
    //   137: ldc 87
    //   139: iconst_0
    //   140: anewarray 4	java/lang/Object
    //   143: invokestatic 93	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: aload_0
    //   147: invokestatic 71	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   150: aload_3
    //   151: invokestatic 71	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   154: aconst_null
    //   155: areturn
    //   156: aload_0
    //   157: astore 4
    //   159: aload_3
    //   160: astore_1
    //   161: aload 5
    //   163: invokevirtual 97	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   166: invokestatic 102	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   169: astore 5
    //   171: aload_0
    //   172: invokestatic 71	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   175: aload_3
    //   176: invokestatic 71	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   179: aload 5
    //   181: areturn
    //   182: astore_0
    //   183: aconst_null
    //   184: astore 4
    //   186: aconst_null
    //   187: astore_1
    //   188: aload 4
    //   190: invokestatic 71	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   193: aload_1
    //   194: invokestatic 71	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   197: aload_0
    //   198: athrow
    //   199: astore_0
    //   200: aconst_null
    //   201: astore 4
    //   203: aload_3
    //   204: astore_1
    //   205: goto -17 -> 188
    //   208: astore_0
    //   209: goto -21 -> 188
    //   212: astore 5
    //   214: aconst_null
    //   215: astore_0
    //   216: aconst_null
    //   217: astore_3
    //   218: goto -90 -> 128
    //   221: astore 5
    //   223: aconst_null
    //   224: astore_0
    //   225: goto -97 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	paramContentResolver	android.content.ContentResolver
    //   0	228	1	paramUri	android.net.Uri
    //   0	228	2	paramInt	int
    //   11	207	3	localObject	Object
    //   83	119	4	localContentResolver	android.content.ContentResolver
    //   48	9	5	localb	com.tencent.mm.vfs.b
    //   126	36	5	localException1	java.lang.Exception
    //   169	11	5	str	String
    //   212	1	5	localException2	java.lang.Exception
    //   221	1	5	localException3	java.lang.Exception
    //   92	25	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   87	94	126	java/lang/Exception
    //   99	106	126	java/lang/Exception
    //   115	123	126	java/lang/Exception
    //   161	171	126	java/lang/Exception
    //   56	62	182	finally
    //   62	68	199	finally
    //   87	94	208	finally
    //   99	106	208	finally
    //   115	123	208	finally
    //   133	146	208	finally
    //   161	171	208	finally
    //   56	62	212	java/lang/Exception
    //   62	68	221	java/lang/Exception
  }
  
  /* Error */
  private static String b(android.content.ContentResolver paramContentResolver, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iconst_1
    //   3: anewarray 126	java/lang/String
    //   6: dup
    //   7: iconst_0
    //   8: ldc 128
    //   10: aastore
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: invokevirtual 132	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   17: astore_0
    //   18: aload_0
    //   19: ifnull +152 -> 171
    //   22: aload_0
    //   23: astore_2
    //   24: aload_0
    //   25: invokeinterface 137 1 0
    //   30: ifeq +141 -> 171
    //   33: aload_0
    //   34: astore_2
    //   35: new 45	com/tencent/mm/vfs/b
    //   38: dup
    //   39: aload_0
    //   40: iconst_0
    //   41: invokeinterface 141 2 0
    //   46: invokespecial 142	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   49: invokevirtual 145	com/tencent/mm/vfs/b:getName	()Ljava/lang/String;
    //   52: astore_3
    //   53: aload_3
    //   54: astore_1
    //   55: aload_1
    //   56: astore_2
    //   57: aload_0
    //   58: ifnull +11 -> 69
    //   61: aload_0
    //   62: invokeinterface 149 1 0
    //   67: aload_1
    //   68: astore_2
    //   69: aload_2
    //   70: areturn
    //   71: astore_3
    //   72: aconst_null
    //   73: astore_0
    //   74: aload_0
    //   75: astore_2
    //   76: ldc 85
    //   78: aload_3
    //   79: ldc 151
    //   81: iconst_0
    //   82: anewarray 4	java/lang/Object
    //   85: invokestatic 93	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_0
    //   89: astore_2
    //   90: aload_1
    //   91: invokevirtual 154	android/net/Uri:toString	()Ljava/lang/String;
    //   94: ldc 156
    //   96: invokestatic 162	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   99: ldc 164
    //   101: invokevirtual 168	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   104: astore_1
    //   105: aload_0
    //   106: astore_2
    //   107: aload_1
    //   108: aload_1
    //   109: arraylength
    //   110: iconst_1
    //   111: isub
    //   112: aaload
    //   113: astore_1
    //   114: aload_1
    //   115: astore_2
    //   116: aload_0
    //   117: ifnull -48 -> 69
    //   120: aload_0
    //   121: invokeinterface 149 1 0
    //   126: aload_1
    //   127: areturn
    //   128: astore_1
    //   129: aload_0
    //   130: astore_2
    //   131: ldc 85
    //   133: aload_1
    //   134: ldc 170
    //   136: iconst_0
    //   137: anewarray 4	java/lang/Object
    //   140: invokestatic 93	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aconst_null
    //   144: astore_1
    //   145: goto -31 -> 114
    //   148: astore_0
    //   149: aconst_null
    //   150: astore_2
    //   151: aload_2
    //   152: ifnull +9 -> 161
    //   155: aload_2
    //   156: invokeinterface 149 1 0
    //   161: aload_0
    //   162: athrow
    //   163: astore_0
    //   164: goto -13 -> 151
    //   167: astore_3
    //   168: goto -94 -> 74
    //   171: aconst_null
    //   172: astore_1
    //   173: goto -118 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramContentResolver	android.content.ContentResolver
    //   0	176	1	paramUri	android.net.Uri
    //   23	133	2	localObject	Object
    //   52	2	3	str	String
    //   71	8	3	localException1	java.lang.Exception
    //   167	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	18	71	java/lang/Exception
    //   90	105	128	java/lang/Exception
    //   107	114	128	java/lang/Exception
    //   0	18	148	finally
    //   24	33	163	finally
    //   35	53	163	finally
    //   76	88	163	finally
    //   90	105	163	finally
    //   107	114	163	finally
    //   131	143	163	finally
    //   24	33	167	java/lang/Exception
    //   35	53	167	java/lang/Exception
  }
  
  private static String wL(String paramString)
  {
    if (bk.bl(paramString)) {
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
    return "." + str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.d
 * JD-Core Version:    0.7.0.1
 */