package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bc
{
  /* Error */
  public static MediaPlayer a(Context paramContext, final int paramInt1, bc.b paramb, int paramInt2, boolean paramBoolean, final a parama)
  {
    // Byte code:
    //   0: ldc 21
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +7 -> 13
    //   9: aload_2
    //   10: ifnonnull +49 -> 59
    //   13: ldc 29
    //   15: ldc 31
    //   17: iconst_5
    //   18: anewarray 4	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: aload_0
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: iload_1
    //   28: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   31: aastore
    //   32: dup
    //   33: iconst_2
    //   34: aload_2
    //   35: aastore
    //   36: dup
    //   37: iconst_3
    //   38: iload 4
    //   40: invokestatic 42	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   43: aastore
    //   44: dup
    //   45: iconst_4
    //   46: aload 5
    //   48: aastore
    //   49: invokestatic 48	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: ldc 21
    //   54: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aconst_null
    //   58: areturn
    //   59: aload_0
    //   60: iload_1
    //   61: invokevirtual 57	android/content/Context:getString	(I)Ljava/lang/String;
    //   64: astore 8
    //   66: new 59	android/media/MediaPlayer
    //   69: dup
    //   70: invokespecial 63	android/media/MediaPlayer:<init>	()V
    //   73: astore 7
    //   75: aload_2
    //   76: getstatic 67	com/tencent/mm/sdk/platformtools/bc$b:Gty	Lcom/tencent/mm/sdk/platformtools/bc$b;
    //   79: if_acmpeq +250 -> 329
    //   82: iconst_m1
    //   83: iload_3
    //   84: if_icmpne +245 -> 329
    //   87: aload_2
    //   88: getstatic 70	com/tencent/mm/sdk/platformtools/bc$b:Gtz	Lcom/tencent/mm/sdk/platformtools/bc$b;
    //   91: if_acmpne +232 -> 323
    //   94: iconst_3
    //   95: istore_3
    //   96: aload 7
    //   98: iload_3
    //   99: invokevirtual 73	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   102: ldc 29
    //   104: ldc 75
    //   106: bipush 7
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload 7
    //   115: invokevirtual 79	java/lang/Object:hashCode	()I
    //   118: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: aload 8
    //   126: aastore
    //   127: dup
    //   128: iconst_2
    //   129: aload_0
    //   130: aastore
    //   131: dup
    //   132: iconst_3
    //   133: iload_1
    //   134: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: aastore
    //   138: dup
    //   139: iconst_4
    //   140: aload_2
    //   141: aastore
    //   142: dup
    //   143: iconst_5
    //   144: iload 4
    //   146: invokestatic 42	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   149: aastore
    //   150: dup
    //   151: bipush 6
    //   153: aload 5
    //   155: aastore
    //   156: invokestatic 81	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   159: aconst_null
    //   160: astore_2
    //   161: aload_0
    //   162: invokevirtual 85	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   165: aload 8
    //   167: invokevirtual 91	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   170: astore_0
    //   171: aload 7
    //   173: aload_0
    //   174: invokevirtual 97	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   177: aload_0
    //   178: invokevirtual 101	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   181: aload_0
    //   182: invokevirtual 104	android/content/res/AssetFileDescriptor:getLength	()J
    //   185: invokevirtual 108	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   188: aload 7
    //   190: iload 4
    //   192: invokevirtual 112	android/media/MediaPlayer:setLooping	(Z)V
    //   195: aload 7
    //   197: new 6	com/tencent/mm/sdk/platformtools/bc$1
    //   200: dup
    //   201: aload 7
    //   203: invokespecial 115	com/tencent/mm/sdk/platformtools/bc$1:<init>	(Landroid/media/MediaPlayer;)V
    //   206: invokevirtual 119	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   209: aload 7
    //   211: new 8	com/tencent/mm/sdk/platformtools/bc$2
    //   214: dup
    //   215: aload 8
    //   217: aload 7
    //   219: aload 5
    //   221: invokespecial 122	com/tencent/mm/sdk/platformtools/bc$2:<init>	(Ljava/lang/String;Landroid/media/MediaPlayer;Lcom/tencent/mm/sdk/platformtools/bc$a;)V
    //   224: invokevirtual 126	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   227: aload 7
    //   229: new 10	com/tencent/mm/sdk/platformtools/bc$3
    //   232: dup
    //   233: aload 8
    //   235: aload 7
    //   237: iload_1
    //   238: invokespecial 129	com/tencent/mm/sdk/platformtools/bc$3:<init>	(Ljava/lang/String;Landroid/media/MediaPlayer;I)V
    //   241: invokevirtual 133	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   244: aload 7
    //   246: invokevirtual 136	android/media/MediaPlayer:prepareAsync	()V
    //   249: aload 7
    //   251: invokevirtual 79	java/lang/Object:hashCode	()I
    //   254: istore_3
    //   255: invokestatic 142	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   258: ifnull +85 -> 343
    //   261: iconst_1
    //   262: istore 4
    //   264: invokestatic 145	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   267: ifnull +82 -> 349
    //   270: iconst_1
    //   271: istore 6
    //   273: ldc 29
    //   275: ldc 147
    //   277: iconst_3
    //   278: anewarray 4	java/lang/Object
    //   281: dup
    //   282: iconst_0
    //   283: iload_3
    //   284: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   287: aastore
    //   288: dup
    //   289: iconst_1
    //   290: iload 4
    //   292: invokestatic 42	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   295: aastore
    //   296: dup
    //   297: iconst_2
    //   298: iload 6
    //   300: invokestatic 42	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   303: aastore
    //   304: invokestatic 81	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   307: aload_0
    //   308: ifnull +7 -> 315
    //   311: aload_0
    //   312: invokevirtual 150	android/content/res/AssetFileDescriptor:close	()V
    //   315: ldc 21
    //   317: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: aload 7
    //   322: areturn
    //   323: bipush 8
    //   325: istore_3
    //   326: goto -230 -> 96
    //   329: iload_3
    //   330: iconst_m1
    //   331: if_icmpeq -229 -> 102
    //   334: aload 7
    //   336: iload_3
    //   337: invokevirtual 73	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   340: goto -238 -> 102
    //   343: iconst_0
    //   344: istore 4
    //   346: goto -82 -> 264
    //   349: iconst_0
    //   350: istore 6
    //   352: goto -79 -> 273
    //   355: astore_0
    //   356: ldc 29
    //   358: aload_0
    //   359: ldc 152
    //   361: iconst_0
    //   362: anewarray 4	java/lang/Object
    //   365: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: goto -53 -> 315
    //   371: astore 5
    //   373: aload_2
    //   374: astore_0
    //   375: aload 5
    //   377: astore_2
    //   378: ldc 29
    //   380: ldc 158
    //   382: iconst_2
    //   383: anewarray 4	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: iload_1
    //   389: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   392: aastore
    //   393: dup
    //   394: iconst_1
    //   395: aload_2
    //   396: invokevirtual 162	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   399: aastore
    //   400: invokestatic 48	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   403: ldc 29
    //   405: aload_2
    //   406: ldc 152
    //   408: iconst_0
    //   409: anewarray 4	java/lang/Object
    //   412: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   415: aload 7
    //   417: invokevirtual 165	android/media/MediaPlayer:release	()V
    //   420: aload_0
    //   421: ifnull +7 -> 428
    //   424: aload_0
    //   425: invokevirtual 150	android/content/res/AssetFileDescriptor:close	()V
    //   428: ldc 21
    //   430: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   433: aconst_null
    //   434: areturn
    //   435: astore_0
    //   436: ldc 29
    //   438: aload_0
    //   439: ldc 152
    //   441: iconst_0
    //   442: anewarray 4	java/lang/Object
    //   445: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   448: goto -20 -> 428
    //   451: astore_2
    //   452: aconst_null
    //   453: astore_0
    //   454: aload_0
    //   455: ifnull +7 -> 462
    //   458: aload_0
    //   459: invokevirtual 150	android/content/res/AssetFileDescriptor:close	()V
    //   462: ldc 21
    //   464: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   467: aload_2
    //   468: athrow
    //   469: astore_0
    //   470: ldc 29
    //   472: aload_0
    //   473: ldc 152
    //   475: iconst_0
    //   476: anewarray 4	java/lang/Object
    //   479: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   482: goto -20 -> 462
    //   485: astore_2
    //   486: goto -32 -> 454
    //   489: astore_2
    //   490: goto -36 -> 454
    //   493: astore_2
    //   494: goto -116 -> 378
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	497	0	paramContext	Context
    //   0	497	1	paramInt1	int
    //   0	497	2	paramb	bc.b
    //   0	497	3	paramInt2	int
    //   0	497	4	paramBoolean	boolean
    //   0	497	5	parama	a
    //   271	80	6	bool	boolean
    //   73	343	7	localMediaPlayer	MediaPlayer
    //   64	170	8	str	String
    // Exception table:
    //   from	to	target	type
    //   311	315	355	java/io/IOException
    //   161	171	371	java/lang/Exception
    //   424	428	435	java/io/IOException
    //   161	171	451	finally
    //   458	462	469	java/io/IOException
    //   171	261	485	finally
    //   264	270	485	finally
    //   273	307	485	finally
    //   378	420	489	finally
    //   171	261	493	java/lang/Exception
    //   264	270	493	java/lang/Exception
    //   273	307	493	java/lang/Exception
  }
  
  public static MediaPlayer a(Context paramContext, int paramInt, bc.b paramb, a parama)
  {
    AppMethodBeat.i(157786);
    paramContext = a(paramContext, paramInt, paramb, -1, false, parama);
    AppMethodBeat.o(157786);
    return paramContext;
  }
  
  public static void a(Context paramContext, int paramInt, a parama)
  {
    AppMethodBeat.i(157789);
    a(paramContext, paramInt, bc.b.Gty, parama);
    AppMethodBeat.o(157789);
  }
  
  public static void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(157788);
    a(paramContext, 2131764379, bc.b.Gtz, parama);
    AppMethodBeat.o(157788);
  }
  
  public static void aF(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(157790);
    a(paramContext, paramInt, bc.b.Gty, null);
    AppMethodBeat.o(157790);
  }
  
  public static void iS(Context paramContext)
  {
    AppMethodBeat.i(157791);
    a(paramContext, 2131755612, bc.b.Gty, 3, false, null);
    AppMethodBeat.o(157791);
  }
  
  public static abstract interface a
  {
    public abstract void onCompletion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bc
 * JD-Core Version:    0.7.0.1
 */