package com.tencent.mm.wear.app.d.a.a;

import android.media.AudioTrack;

public final class h
  extends a
{
  private static Object agZ = new Object();
  private static int aha = 0;
  private static int ahc = -1;
  private AudioTrack agX;
  private i agY;
  private int ahb;
  private long ahd;
  private String ahe;
  private int ahf = 16000;
  private int ahg = f.agV;
  
  public h()
  {
    aha += 1;
    this.ahb = aha;
  }
  
  /* Error */
  private void S(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/tencent/mm/wear/app/d/a/a/h:ahb	I
    //   4: putstatic 33	com/tencent/mm/wear/app/d/a/a/h:ahc	I
    //   7: ldc 52
    //   9: ldc 54
    //   11: iconst_1
    //   12: anewarray 24	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: getfield 46	com/tencent/mm/wear/app/d/a/a/h:ahb	I
    //   21: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: invokestatic 66	com/tencent/mm/wear/a/c/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: new 68	java/io/FileInputStream
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 70	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   36: astore 6
    //   38: aload 6
    //   40: astore_1
    //   41: aload 6
    //   43: invokevirtual 74	java/io/FileInputStream:available	()I
    //   46: istore_3
    //   47: aload 6
    //   49: astore_1
    //   50: iload_3
    //   51: newarray byte
    //   53: astore 7
    //   55: aload 6
    //   57: astore_1
    //   58: aload 6
    //   60: aload 7
    //   62: iconst_0
    //   63: iload_3
    //   64: invokevirtual 78	java/io/FileInputStream:read	([BII)I
    //   67: pop
    //   68: aload 7
    //   70: iconst_0
    //   71: baload
    //   72: istore_2
    //   73: aload 6
    //   75: astore_1
    //   76: getstatic 83	com/tencent/mm/modelvoice/MediaRecorder:WZ	J
    //   79: lstore 4
    //   81: aload 6
    //   83: astore_1
    //   84: aload_0
    //   85: iconst_1
    //   86: newarray byte
    //   88: dup
    //   89: iconst_0
    //   90: iload_2
    //   91: bastore
    //   92: lload 4
    //   94: invokestatic 87	com/tencent/mm/modelvoice/MediaRecorder:SilkGetEncSampleRate	([BJ)I
    //   97: putfield 37	com/tencent/mm/wear/app/d/a/a/h:ahf	I
    //   100: aload 6
    //   102: astore_1
    //   103: getstatic 90	com/tencent/mm/modelvoice/MediaRecorder:Xa	J
    //   106: invokestatic 94	com/tencent/mm/modelvoice/MediaRecorder:SilkDecUnInit	(J)I
    //   109: pop
    //   110: aload 6
    //   112: astore_1
    //   113: aload_0
    //   114: getfield 37	com/tencent/mm/wear/app/d/a/a/h:ahf	I
    //   117: aload 7
    //   119: iload_3
    //   120: getstatic 90	com/tencent/mm/modelvoice/MediaRecorder:Xa	J
    //   123: invokestatic 98	com/tencent/mm/modelvoice/MediaRecorder:SilkDecInit	(I[BIJ)J
    //   126: pop2
    //   127: aload 6
    //   129: astore_1
    //   130: aload 6
    //   132: invokevirtual 101	java/io/FileInputStream:close	()V
    //   135: aload 6
    //   137: invokestatic 106	com/tencent/mm/wear/a/f/c:c	(Ljava/io/InputStream;)V
    //   140: return
    //   141: astore 7
    //   143: aconst_null
    //   144: astore 6
    //   146: aload 6
    //   148: astore_1
    //   149: ldc 52
    //   151: aload 7
    //   153: invokestatic 110	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   156: aload 6
    //   158: invokestatic 106	com/tencent/mm/wear/a/f/c:c	(Ljava/io/InputStream;)V
    //   161: return
    //   162: astore 6
    //   164: aconst_null
    //   165: astore_1
    //   166: aload_1
    //   167: invokestatic 106	com/tencent/mm/wear/a/f/c:c	(Ljava/io/InputStream;)V
    //   170: aload 6
    //   172: athrow
    //   173: astore 6
    //   175: goto -9 -> 166
    //   178: astore 7
    //   180: goto -34 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	h
    //   0	183	1	paramString	String
    //   72	19	2	i	int
    //   46	74	3	j	int
    //   79	14	4	l	long
    //   36	121	6	localFileInputStream	java.io.FileInputStream
    //   162	9	6	localObject1	Object
    //   173	1	6	localObject2	Object
    //   53	65	7	arrayOfByte	byte[]
    //   141	11	7	localException1	java.lang.Exception
    //   178	1	7	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   28	38	141	java/lang/Exception
    //   28	38	162	finally
    //   41	47	173	finally
    //   50	55	173	finally
    //   58	68	173	finally
    //   76	81	173	finally
    //   84	100	173	finally
    //   103	110	173	finally
    //   113	127	173	finally
    //   130	135	173	finally
    //   149	156	173	finally
    //   41	47	178	java/lang/Exception
    //   50	55	178	java/lang/Exception
    //   58	68	178	java/lang/Exception
    //   76	81	178	java/lang/Exception
    //   84	100	178	java/lang/Exception
    //   103	110	178	java/lang/Exception
    //   113	127	178	java/lang/Exception
    //   130	135	178	java/lang/Exception
  }
  
  public final boolean isPlaying()
  {
    return this.ahg == f.agU;
  }
  
  /* Error */
  public final void k(long paramLong)
  {
    // Byte code:
    //   0: new 151	java/io/File
    //   3: dup
    //   4: invokestatic 157	com/tencent/mm/wear/app/b/h:mU	()Ljava/io/File;
    //   7: new 159	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   14: lload_1
    //   15: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   18: ldc 166
    //   20: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokespecial 176	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   29: invokevirtual 179	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   32: astore 6
    //   34: aload 6
    //   36: invokestatic 185	com/tencent/mm/sdk/platformtools/q:D	(Ljava/lang/String;)Z
    //   39: ifeq +15 -> 54
    //   42: ldc 52
    //   44: ldc 187
    //   46: iconst_0
    //   47: anewarray 24	java/lang/Object
    //   50: invokestatic 189	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: return
    //   54: aload_0
    //   55: getfield 44	com/tencent/mm/wear/app/d/a/a/h:ahg	I
    //   58: getstatic 42	com/tencent/mm/wear/app/d/a/a/f:agV	I
    //   61: if_icmpeq +15 -> 76
    //   64: ldc 52
    //   66: ldc 191
    //   68: iconst_0
    //   69: anewarray 24	java/lang/Object
    //   72: invokestatic 189	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: return
    //   76: aload_0
    //   77: lload_1
    //   78: putfield 138	com/tencent/mm/wear/app/d/a/a/h:ahd	J
    //   81: aload_0
    //   82: aload 6
    //   84: putfield 120	com/tencent/mm/wear/app/d/a/a/h:ahe	Ljava/lang/String;
    //   87: ldc 52
    //   89: ldc 193
    //   91: iconst_1
    //   92: anewarray 24	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload 6
    //   99: aastore
    //   100: invokestatic 66	com/tencent/mm/wear/a/c/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_0
    //   104: aload_0
    //   105: getfield 138	com/tencent/mm/wear/app/d/a/a/h:ahd	J
    //   108: invokevirtual 195	com/tencent/mm/wear/app/d/a/a/h:g	(J)V
    //   111: getstatic 29	com/tencent/mm/wear/app/d/a/a/h:agZ	Ljava/lang/Object;
    //   114: astore 5
    //   116: aload 5
    //   118: monitorenter
    //   119: aload_0
    //   120: aload 6
    //   122: invokespecial 115	com/tencent/mm/wear/app/d/a/a/h:S	(Ljava/lang/String;)V
    //   125: aload 5
    //   127: monitorexit
    //   128: aload_0
    //   129: getfield 124	com/tencent/mm/wear/app/d/a/a/h:agX	Landroid/media/AudioTrack;
    //   132: ifnull +33 -> 165
    //   135: ldc 52
    //   137: ldc 197
    //   139: iconst_0
    //   140: anewarray 24	java/lang/Object
    //   143: invokestatic 66	com/tencent/mm/wear/a/c/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: aload_0
    //   147: getfield 124	com/tencent/mm/wear/app/d/a/a/h:agX	Landroid/media/AudioTrack;
    //   150: invokevirtual 131	android/media/AudioTrack:stop	()V
    //   153: aload_0
    //   154: getfield 124	com/tencent/mm/wear/app/d/a/a/h:agX	Landroid/media/AudioTrack;
    //   157: invokevirtual 134	android/media/AudioTrack:release	()V
    //   160: aload_0
    //   161: aconst_null
    //   162: putfield 124	com/tencent/mm/wear/app/d/a/a/h:agX	Landroid/media/AudioTrack;
    //   165: aload_0
    //   166: getfield 37	com/tencent/mm/wear/app/d/a/a/h:ahf	I
    //   169: istore_3
    //   170: iload_3
    //   171: iconst_2
    //   172: iconst_2
    //   173: invokestatic 201	android/media/AudioTrack:getMinBufferSize	(III)I
    //   176: istore 4
    //   178: ldc 203
    //   180: ldc 205
    //   182: iconst_4
    //   183: anewarray 24	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: iconst_3
    //   189: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   192: aastore
    //   193: dup
    //   194: iconst_1
    //   195: iload_3
    //   196: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   199: aastore
    //   200: dup
    //   201: iconst_2
    //   202: iconst_2
    //   203: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   206: aastore
    //   207: dup
    //   208: iconst_3
    //   209: iload 4
    //   211: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: aastore
    //   215: invokestatic 66	com/tencent/mm/wear/a/c/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: new 128	android/media/AudioTrack
    //   221: dup
    //   222: iconst_3
    //   223: iload_3
    //   224: iconst_2
    //   225: iconst_2
    //   226: iload 4
    //   228: bipush 8
    //   230: imul
    //   231: iconst_1
    //   232: invokespecial 208	android/media/AudioTrack:<init>	(IIIIII)V
    //   235: astore 6
    //   237: aload 6
    //   239: astore 5
    //   241: aload 6
    //   243: invokevirtual 211	android/media/AudioTrack:getState	()I
    //   246: ifne +27 -> 273
    //   249: aload 6
    //   251: invokevirtual 134	android/media/AudioTrack:release	()V
    //   254: new 128	android/media/AudioTrack
    //   257: dup
    //   258: iconst_3
    //   259: iload_3
    //   260: iconst_2
    //   261: iconst_2
    //   262: iload 4
    //   264: bipush 8
    //   266: imul
    //   267: iconst_1
    //   268: invokespecial 208	android/media/AudioTrack:<init>	(IIIIII)V
    //   271: astore 5
    //   273: ldc 203
    //   275: new 159	java/lang/StringBuilder
    //   278: dup
    //   279: ldc 213
    //   281: invokespecial 214	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   284: aload 5
    //   286: invokevirtual 211	android/media/AudioTrack:getState	()I
    //   289: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: iconst_0
    //   296: anewarray 24	java/lang/Object
    //   299: invokestatic 66	com/tencent/mm/wear/a/c/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   302: aload_0
    //   303: aload 5
    //   305: putfield 124	com/tencent/mm/wear/app/d/a/a/h:agX	Landroid/media/AudioTrack;
    //   308: aload_0
    //   309: getstatic 147	com/tencent/mm/wear/app/d/a/a/f:agU	I
    //   312: putfield 44	com/tencent/mm/wear/app/d/a/a/h:ahg	I
    //   315: aload_0
    //   316: getfield 124	com/tencent/mm/wear/app/d/a/a/h:agX	Landroid/media/AudioTrack;
    //   319: ifnull +10 -> 329
    //   322: aload_0
    //   323: getfield 124	com/tencent/mm/wear/app/d/a/a/h:agX	Landroid/media/AudioTrack;
    //   326: invokevirtual 220	android/media/AudioTrack:play	()V
    //   329: aload_0
    //   330: new 222	com/tencent/mm/wear/app/d/a/a/i
    //   333: dup
    //   334: aload_0
    //   335: iconst_0
    //   336: invokespecial 225	com/tencent/mm/wear/app/d/a/a/i:<init>	(Lcom/tencent/mm/wear/app/d/a/a/h;B)V
    //   339: putfield 227	com/tencent/mm/wear/app/d/a/a/h:agY	Lcom/tencent/mm/wear/app/d/a/a/i;
    //   342: new 229	java/lang/Thread
    //   345: dup
    //   346: aload_0
    //   347: getfield 227	com/tencent/mm/wear/app/d/a/a/h:agY	Lcom/tencent/mm/wear/app/d/a/a/i;
    //   350: invokespecial 232	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   353: invokevirtual 235	java/lang/Thread:start	()V
    //   356: return
    //   357: astore 5
    //   359: ldc 52
    //   361: aload 5
    //   363: invokestatic 110	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   366: return
    //   367: astore 6
    //   369: aload 5
    //   371: monitorexit
    //   372: aload 6
    //   374: athrow
    //   375: astore 5
    //   377: ldc 52
    //   379: ldc 237
    //   381: iconst_1
    //   382: anewarray 24	java/lang/Object
    //   385: dup
    //   386: iconst_0
    //   387: aload 5
    //   389: invokevirtual 240	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   392: aastore
    //   393: invokestatic 189	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   396: goto -236 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	this	h
    //   0	399	1	paramLong	long
    //   169	91	3	i	int
    //   176	91	4	j	int
    //   114	190	5	localObject1	Object
    //   357	13	5	localException1	java.lang.Exception
    //   375	13	5	localException2	java.lang.Exception
    //   32	218	6	localObject2	Object
    //   367	6	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   128	146	357	java/lang/Exception
    //   160	165	357	java/lang/Exception
    //   165	237	357	java/lang/Exception
    //   241	273	357	java/lang/Exception
    //   273	329	357	java/lang/Exception
    //   329	356	357	java/lang/Exception
    //   377	396	357	java/lang/Exception
    //   119	128	367	finally
    //   369	372	367	finally
    //   146	160	375	java/lang/Exception
  }
  
  public final void ns()
  {
    this.ahg = f.agV;
  }
  
  public final long nt()
  {
    return this.ahd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a.a.h
 * JD-Core Version:    0.7.0.1
 */