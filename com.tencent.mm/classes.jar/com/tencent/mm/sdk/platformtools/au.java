package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

public final class au
{
  public static void G(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, au.b.uht, null);
  }
  
  /* Error */
  private static MediaPlayer a(Context paramContext, int paramInt1, au.b paramb, int paramInt2, au.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +45 -> 50
    //   8: ldc 28
    //   10: ldc 30
    //   12: iconst_5
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload_0
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: iload_1
    //   23: invokestatic 36	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: dup
    //   28: iconst_2
    //   29: aload_2
    //   30: aastore
    //   31: dup
    //   32: iconst_3
    //   33: iconst_0
    //   34: invokestatic 41	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   37: aastore
    //   38: dup
    //   39: iconst_4
    //   40: aload 4
    //   42: aastore
    //   43: invokestatic 47	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: aconst_null
    //   47: astore_2
    //   48: aload_2
    //   49: areturn
    //   50: aload_0
    //   51: iload_1
    //   52: invokevirtual 53	android/content/Context:getString	(I)Ljava/lang/String;
    //   55: astore 8
    //   57: new 55	android/media/MediaPlayer
    //   60: dup
    //   61: invokespecial 59	android/media/MediaPlayer:<init>	()V
    //   64: astore 7
    //   66: aload_2
    //   67: getstatic 16	com/tencent/mm/sdk/platformtools/au$b:uht	Lcom/tencent/mm/sdk/platformtools/au$b;
    //   70: if_acmpeq +248 -> 318
    //   73: iconst_m1
    //   74: iload_3
    //   75: if_icmpne +243 -> 318
    //   78: aload_2
    //   79: getstatic 62	com/tencent/mm/sdk/platformtools/au$b:uhu	Lcom/tencent/mm/sdk/platformtools/au$b;
    //   82: if_acmpne +230 -> 312
    //   85: iconst_3
    //   86: istore_3
    //   87: aload 7
    //   89: iload_3
    //   90: invokevirtual 66	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   93: ldc 28
    //   95: ldc 68
    //   97: bipush 7
    //   99: anewarray 4	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: aload 7
    //   106: invokevirtual 72	java/lang/Object:hashCode	()I
    //   109: invokestatic 36	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: aload 8
    //   117: aastore
    //   118: dup
    //   119: iconst_2
    //   120: aload_0
    //   121: aastore
    //   122: dup
    //   123: iconst_3
    //   124: iload_1
    //   125: invokestatic 36	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: aastore
    //   129: dup
    //   130: iconst_4
    //   131: aload_2
    //   132: aastore
    //   133: dup
    //   134: iconst_5
    //   135: iconst_0
    //   136: invokestatic 41	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   139: aastore
    //   140: dup
    //   141: bipush 6
    //   143: aload 4
    //   145: aastore
    //   146: invokestatic 75	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: aload_0
    //   150: invokevirtual 79	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   153: aload 8
    //   155: invokevirtual 85	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   158: astore_0
    //   159: aload 7
    //   161: aload_0
    //   162: invokevirtual 91	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   165: aload_0
    //   166: invokevirtual 95	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   169: aload_0
    //   170: invokevirtual 98	android/content/res/AssetFileDescriptor:getLength	()J
    //   173: invokevirtual 102	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   176: aload 7
    //   178: iconst_0
    //   179: invokevirtual 106	android/media/MediaPlayer:setLooping	(Z)V
    //   182: aload 7
    //   184: new 6	com/tencent/mm/sdk/platformtools/au$1
    //   187: dup
    //   188: aload 7
    //   190: invokespecial 109	com/tencent/mm/sdk/platformtools/au$1:<init>	(Landroid/media/MediaPlayer;)V
    //   193: invokevirtual 113	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   196: aload 7
    //   198: new 115	com/tencent/mm/sdk/platformtools/au$2
    //   201: dup
    //   202: aload 8
    //   204: aload 7
    //   206: aload 4
    //   208: invokespecial 118	com/tencent/mm/sdk/platformtools/au$2:<init>	(Ljava/lang/String;Landroid/media/MediaPlayer;Lcom/tencent/mm/sdk/platformtools/au$a;)V
    //   211: invokevirtual 122	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   214: aload 7
    //   216: invokevirtual 125	android/media/MediaPlayer:prepare	()V
    //   219: aload 7
    //   221: invokevirtual 128	android/media/MediaPlayer:start	()V
    //   224: aload 7
    //   226: invokevirtual 72	java/lang/Object:hashCode	()I
    //   229: istore_3
    //   230: invokestatic 134	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   233: ifnull +99 -> 332
    //   236: iconst_1
    //   237: istore 5
    //   239: invokestatic 137	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   242: ifnull +96 -> 338
    //   245: iconst_1
    //   246: istore 6
    //   248: ldc 28
    //   250: ldc 139
    //   252: iconst_3
    //   253: anewarray 4	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: iload_3
    //   259: invokestatic 36	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   262: aastore
    //   263: dup
    //   264: iconst_1
    //   265: iload 5
    //   267: invokestatic 41	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   270: aastore
    //   271: dup
    //   272: iconst_2
    //   273: iload 6
    //   275: invokestatic 41	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   278: aastore
    //   279: invokestatic 75	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: aload 7
    //   284: astore_2
    //   285: aload_0
    //   286: ifnull -238 -> 48
    //   289: aload_0
    //   290: invokevirtual 142	android/content/res/AssetFileDescriptor:close	()V
    //   293: aload 7
    //   295: areturn
    //   296: astore_0
    //   297: ldc 28
    //   299: aload_0
    //   300: ldc 144
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokestatic 148	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   309: aload 7
    //   311: areturn
    //   312: bipush 8
    //   314: istore_3
    //   315: goto -228 -> 87
    //   318: iload_3
    //   319: iconst_m1
    //   320: if_icmpeq -227 -> 93
    //   323: aload 7
    //   325: iload_3
    //   326: invokevirtual 66	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   329: goto -236 -> 93
    //   332: iconst_0
    //   333: istore 5
    //   335: goto -96 -> 239
    //   338: iconst_0
    //   339: istore 6
    //   341: goto -93 -> 248
    //   344: astore_2
    //   345: aconst_null
    //   346: astore_0
    //   347: ldc 28
    //   349: ldc 150
    //   351: iconst_2
    //   352: anewarray 4	java/lang/Object
    //   355: dup
    //   356: iconst_0
    //   357: iload_1
    //   358: invokestatic 36	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   361: aastore
    //   362: dup
    //   363: iconst_1
    //   364: aload_2
    //   365: invokevirtual 154	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   368: aastore
    //   369: invokestatic 47	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   372: ldc 28
    //   374: aload_2
    //   375: ldc 144
    //   377: iconst_0
    //   378: anewarray 4	java/lang/Object
    //   381: invokestatic 148	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   384: aload 7
    //   386: invokevirtual 157	android/media/MediaPlayer:release	()V
    //   389: aload_0
    //   390: ifnull +7 -> 397
    //   393: aload_0
    //   394: invokevirtual 142	android/content/res/AssetFileDescriptor:close	()V
    //   397: aconst_null
    //   398: areturn
    //   399: astore_0
    //   400: ldc 28
    //   402: aload_0
    //   403: ldc 144
    //   405: iconst_0
    //   406: anewarray 4	java/lang/Object
    //   409: invokestatic 148	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   412: goto -15 -> 397
    //   415: astore_2
    //   416: aconst_null
    //   417: astore_0
    //   418: aload_0
    //   419: ifnull +7 -> 426
    //   422: aload_0
    //   423: invokevirtual 142	android/content/res/AssetFileDescriptor:close	()V
    //   426: aload_2
    //   427: athrow
    //   428: astore_0
    //   429: ldc 28
    //   431: aload_0
    //   432: ldc 144
    //   434: iconst_0
    //   435: anewarray 4	java/lang/Object
    //   438: invokestatic 148	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   441: goto -15 -> 426
    //   444: astore_2
    //   445: goto -27 -> 418
    //   448: astore_2
    //   449: goto -31 -> 418
    //   452: astore_2
    //   453: goto -106 -> 347
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	paramContext	Context
    //   0	456	1	paramInt1	int
    //   0	456	2	paramb	au.b
    //   0	456	3	paramInt2	int
    //   0	456	4	parama	au.a
    //   237	97	5	bool1	boolean
    //   246	94	6	bool2	boolean
    //   64	321	7	localMediaPlayer	MediaPlayer
    //   55	148	8	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   289	293	296	java/io/IOException
    //   149	159	344	java/lang/Exception
    //   393	397	399	java/io/IOException
    //   149	159	415	finally
    //   422	426	428	java/io/IOException
    //   159	236	444	finally
    //   239	245	444	finally
    //   248	282	444	finally
    //   347	389	448	finally
    //   159	236	452	java/lang/Exception
    //   239	245	452	java/lang/Exception
    //   248	282	452	java/lang/Exception
  }
  
  public static MediaPlayer a(Context paramContext, int paramInt, au.b paramb, au.a parama)
  {
    return a(paramContext, paramInt, paramb, -1, parama);
  }
  
  public static void a(Context paramContext, int paramInt, au.a parama)
  {
    a(paramContext, paramInt, au.b.uhu, parama);
  }
  
  public static void ak(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, au.b.uht, 3, null);
  }
  
  public static void b(Context paramContext, int paramInt, au.a parama)
  {
    a(paramContext, paramInt, au.b.uht, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.au
 * JD-Core Version:    0.7.0.1
 */