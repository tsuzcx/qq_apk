package com.tencent.wework.api.util;

public class OpenDataUtils
{
  /* Error */
  public static java.lang.String ai(android.content.Context paramContext, java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: ldc 9
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 17	java/io/File
    //   8: dup
    //   9: aload_2
    //   10: invokespecial 21	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: new 23	android/net/Uri$Builder
    //   17: dup
    //   18: invokespecial 26	android/net/Uri$Builder:<init>	()V
    //   21: ldc 28
    //   23: invokevirtual 32	android/net/Uri$Builder:scheme	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   26: new 34	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   33: aload_1
    //   34: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 41
    //   39: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokevirtual 48	android/net/Uri$Builder:authority	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   48: ldc 50
    //   50: invokevirtual 53	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   53: ldc 55
    //   55: aload_3
    //   56: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   59: invokevirtual 62	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   62: ldc 64
    //   64: aload_2
    //   65: invokevirtual 62	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   68: invokevirtual 68	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   71: astore_1
    //   72: aload_0
    //   73: invokevirtual 74	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   76: aload_1
    //   77: invokevirtual 80	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   80: astore_0
    //   81: new 82	java/io/FileInputStream
    //   84: dup
    //   85: aload_3
    //   86: invokespecial 85	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: astore_1
    //   90: sipush 1024
    //   93: newarray byte
    //   95: astore_2
    //   96: aload_1
    //   97: aload_2
    //   98: invokevirtual 89	java/io/FileInputStream:read	([B)I
    //   101: ifle +35 -> 136
    //   104: aload_0
    //   105: aload_2
    //   106: invokevirtual 95	java/io/OutputStream:write	([B)V
    //   109: goto -13 -> 96
    //   112: astore_2
    //   113: aload_1
    //   114: ifnull +7 -> 121
    //   117: aload_1
    //   118: invokevirtual 98	java/io/FileInputStream:close	()V
    //   121: aload_0
    //   122: ifnull +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 99	java/io/OutputStream:close	()V
    //   129: ldc 9
    //   131: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aconst_null
    //   135: areturn
    //   136: aload_3
    //   137: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   140: astore_2
    //   141: aload_1
    //   142: invokevirtual 98	java/io/FileInputStream:close	()V
    //   145: aload_0
    //   146: ifnull +7 -> 153
    //   149: aload_0
    //   150: invokevirtual 99	java/io/OutputStream:close	()V
    //   153: ldc 9
    //   155: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aload_2
    //   159: areturn
    //   160: astore_0
    //   161: aconst_null
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_2
    //   165: aload_2
    //   166: ifnull +7 -> 173
    //   169: aload_2
    //   170: invokevirtual 98	java/io/FileInputStream:close	()V
    //   173: aload_1
    //   174: ifnull +7 -> 181
    //   177: aload_1
    //   178: invokevirtual 99	java/io/OutputStream:close	()V
    //   181: ldc 9
    //   183: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_0
    //   187: athrow
    //   188: astore_1
    //   189: goto -44 -> 145
    //   192: astore_0
    //   193: goto -40 -> 153
    //   196: astore_1
    //   197: goto -76 -> 121
    //   200: astore_0
    //   201: goto -72 -> 129
    //   204: astore_2
    //   205: goto -32 -> 173
    //   208: astore_1
    //   209: goto -28 -> 181
    //   212: astore_1
    //   213: aload_0
    //   214: astore_2
    //   215: aconst_null
    //   216: astore_3
    //   217: aload_1
    //   218: astore_0
    //   219: aload_2
    //   220: astore_1
    //   221: aload_3
    //   222: astore_2
    //   223: goto -58 -> 165
    //   226: astore_2
    //   227: aload_0
    //   228: astore_3
    //   229: aload_1
    //   230: astore 4
    //   232: aload_2
    //   233: astore_0
    //   234: aload_3
    //   235: astore_1
    //   236: aload 4
    //   238: astore_2
    //   239: goto -74 -> 165
    //   242: astore_0
    //   243: aconst_null
    //   244: astore_0
    //   245: aconst_null
    //   246: astore_1
    //   247: goto -134 -> 113
    //   250: astore_1
    //   251: aconst_null
    //   252: astore_1
    //   253: goto -140 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	paramContext	android.content.Context
    //   0	256	1	paramString1	java.lang.String
    //   0	256	2	paramString2	java.lang.String
    //   13	222	3	localObject	Object
    //   230	7	4	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   90	96	112	java/lang/Throwable
    //   96	109	112	java/lang/Throwable
    //   136	141	112	java/lang/Throwable
    //   5	81	160	finally
    //   141	145	188	java/lang/Throwable
    //   149	153	192	java/lang/Throwable
    //   117	121	196	java/lang/Throwable
    //   125	129	200	java/lang/Throwable
    //   169	173	204	java/lang/Throwable
    //   177	181	208	java/lang/Throwable
    //   81	90	212	finally
    //   90	96	226	finally
    //   96	109	226	finally
    //   136	141	226	finally
    //   5	81	242	java/lang/Throwable
    //   81	90	250	java/lang/Throwable
  }
  
  /* Error */
  public static long c(android.content.Context paramContext, java.lang.String paramString1, java.lang.String paramString2, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 106
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 23	android/net/Uri$Builder
    //   8: dup
    //   9: invokespecial 26	android/net/Uri$Builder:<init>	()V
    //   12: ldc 28
    //   14: invokevirtual 32	android/net/Uri$Builder:scheme	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   17: new 34	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   24: aload_2
    //   25: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 41
    //   30: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokevirtual 48	android/net/Uri$Builder:authority	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   39: ldc 108
    //   41: invokevirtual 53	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   44: ldc 110
    //   46: aload_1
    //   47: invokevirtual 62	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   50: invokevirtual 68	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   53: astore_1
    //   54: new 112	android/content/ContentValues
    //   57: dup
    //   58: invokespecial 113	android/content/ContentValues:<init>	()V
    //   61: astore_2
    //   62: invokestatic 119	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   65: astore 6
    //   67: aload_3
    //   68: aload 6
    //   70: iconst_0
    //   71: invokeinterface 125 3 0
    //   76: aload 6
    //   78: invokevirtual 129	android/os/Parcel:marshall	()[B
    //   81: astore_3
    //   82: aload 6
    //   84: invokevirtual 132	android/os/Parcel:recycle	()V
    //   87: aload_2
    //   88: ldc 134
    //   90: aload_3
    //   91: invokevirtual 138	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   94: aload_0
    //   95: invokevirtual 74	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   98: aload_1
    //   99: aload_2
    //   100: invokevirtual 142	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   103: invokestatic 148	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   106: lstore 4
    //   108: ldc 106
    //   110: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: lload 4
    //   115: lreturn
    //   116: astore_0
    //   117: ldc 106
    //   119: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_0
    //   123: athrow
    //   124: astore_0
    //   125: ldc 106
    //   127: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: ldc2_w 149
    //   133: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramContext	android.content.Context
    //   0	134	1	paramString1	java.lang.String
    //   0	134	2	paramString2	java.lang.String
    //   0	134	3	paramBundle	android.os.Bundle
    //   106	8	4	l	long
    //   65	18	6	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   5	108	116	finally
    //   5	108	124	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wework.api.util.OpenDataUtils
 * JD-Core Version:    0.7.0.1
 */