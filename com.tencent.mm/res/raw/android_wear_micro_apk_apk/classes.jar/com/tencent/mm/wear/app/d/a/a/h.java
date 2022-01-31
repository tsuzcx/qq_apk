package com.tencent.mm.wear.app.d.a.a;

import android.media.AudioTrack;

public final class h
  extends a
{
  private static int adA = -1;
  private static Object adx = new Object();
  private static int ady = 0;
  private long adB;
  private String adC;
  private int adD = 16000;
  private int adE = f.adt;
  private AudioTrack adv;
  private i adw;
  private int adz;
  
  public h()
  {
    ady += 1;
    this.adz = ady;
  }
  
  /* Error */
  private void L(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/tencent/mm/wear/app/d/a/a/h:adz	I
    //   4: putstatic 33	com/tencent/mm/wear/app/d/a/a/h:adA	I
    //   7: ldc 52
    //   9: ldc 54
    //   11: iconst_1
    //   12: anewarray 24	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: getfield 46	com/tencent/mm/wear/app/d/a/a/h:adz	I
    //   21: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: invokestatic 66	com/tencent/mm/wear/a/c/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: new 68	java/io/FileInputStream
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 70	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   36: astore_3
    //   37: aload_3
    //   38: astore_1
    //   39: aload_3
    //   40: invokevirtual 74	java/io/FileInputStream:available	()I
    //   43: istore_2
    //   44: aload_3
    //   45: astore_1
    //   46: iload_2
    //   47: newarray byte
    //   49: astore 4
    //   51: aload_3
    //   52: astore_1
    //   53: aload_3
    //   54: aload 4
    //   56: iconst_0
    //   57: iload_2
    //   58: invokevirtual 78	java/io/FileInputStream:read	([BII)I
    //   61: pop
    //   62: aload_3
    //   63: astore_1
    //   64: aload_0
    //   65: iconst_1
    //   66: newarray byte
    //   68: dup
    //   69: iconst_0
    //   70: aload 4
    //   72: iconst_0
    //   73: baload
    //   74: bastore
    //   75: invokestatic 84	com/tencent/mm/modelvoice/MediaRecorder:SilkGetEncSampleRate	([B)I
    //   78: putfield 37	com/tencent/mm/wear/app/d/a/a/h:adD	I
    //   81: aload_3
    //   82: astore_1
    //   83: invokestatic 87	com/tencent/mm/modelvoice/MediaRecorder:SilkDecUnInit	()I
    //   86: pop
    //   87: aload_3
    //   88: astore_1
    //   89: aload_0
    //   90: getfield 37	com/tencent/mm/wear/app/d/a/a/h:adD	I
    //   93: aload 4
    //   95: iload_2
    //   96: invokestatic 91	com/tencent/mm/modelvoice/MediaRecorder:SilkDecInit	(I[BI)I
    //   99: pop
    //   100: aload_3
    //   101: astore_1
    //   102: aload_3
    //   103: invokevirtual 94	java/io/FileInputStream:close	()V
    //   106: aload_3
    //   107: invokestatic 99	com/tencent/mm/wear/a/f/c:c	(Ljava/io/InputStream;)V
    //   110: return
    //   111: astore 4
    //   113: aconst_null
    //   114: astore_3
    //   115: aload_3
    //   116: astore_1
    //   117: ldc 52
    //   119: aload 4
    //   121: invokestatic 103	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload_3
    //   125: invokestatic 99	com/tencent/mm/wear/a/f/c:c	(Ljava/io/InputStream;)V
    //   128: return
    //   129: astore_3
    //   130: aconst_null
    //   131: astore_1
    //   132: aload_1
    //   133: invokestatic 99	com/tencent/mm/wear/a/f/c:c	(Ljava/io/InputStream;)V
    //   136: aload_3
    //   137: athrow
    //   138: astore_3
    //   139: goto -7 -> 132
    //   142: astore 4
    //   144: goto -29 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	h
    //   0	147	1	paramString	String
    //   43	53	2	i	int
    //   36	89	3	localFileInputStream	java.io.FileInputStream
    //   129	8	3	localObject1	Object
    //   138	1	3	localObject2	Object
    //   49	45	4	arrayOfByte	byte[]
    //   111	9	4	localException1	java.lang.Exception
    //   142	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   28	37	111	java/lang/Exception
    //   28	37	129	finally
    //   39	44	138	finally
    //   46	51	138	finally
    //   53	62	138	finally
    //   64	81	138	finally
    //   83	87	138	finally
    //   89	100	138	finally
    //   102	106	138	finally
    //   117	124	138	finally
    //   39	44	142	java/lang/Exception
    //   46	51	142	java/lang/Exception
    //   53	62	142	java/lang/Exception
    //   64	81	142	java/lang/Exception
    //   83	87	142	java/lang/Exception
    //   89	100	142	java/lang/Exception
    //   102	106	142	java/lang/Exception
  }
  
  /* Error */
  public final void h(long paramLong)
  {
    // Byte code:
    //   0: new 139	java/io/File
    //   3: dup
    //   4: invokestatic 145	com/tencent/mm/wear/app/b/h:mi	()Ljava/io/File;
    //   7: new 147	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   14: lload_1
    //   15: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   18: ldc 154
    //   20: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokespecial 164	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   29: invokevirtual 167	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   32: astore 6
    //   34: aload 6
    //   36: invokestatic 173	com/tencent/mm/sdk/platformtools/q:D	(Ljava/lang/String;)Z
    //   39: ifeq +15 -> 54
    //   42: ldc 52
    //   44: ldc 175
    //   46: iconst_0
    //   47: anewarray 24	java/lang/Object
    //   50: invokestatic 177	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: return
    //   54: aload_0
    //   55: getfield 44	com/tencent/mm/wear/app/d/a/a/h:adE	I
    //   58: getstatic 42	com/tencent/mm/wear/app/d/a/a/f:adt	I
    //   61: if_icmpeq +15 -> 76
    //   64: ldc 52
    //   66: ldc 179
    //   68: iconst_0
    //   69: anewarray 24	java/lang/Object
    //   72: invokestatic 177	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: return
    //   76: aload_0
    //   77: lload_1
    //   78: putfield 131	com/tencent/mm/wear/app/d/a/a/h:adB	J
    //   81: aload_0
    //   82: aload 6
    //   84: putfield 113	com/tencent/mm/wear/app/d/a/a/h:adC	Ljava/lang/String;
    //   87: ldc 52
    //   89: ldc 181
    //   91: iconst_1
    //   92: anewarray 24	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload 6
    //   99: aastore
    //   100: invokestatic 66	com/tencent/mm/wear/a/c/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_0
    //   104: aload_0
    //   105: getfield 131	com/tencent/mm/wear/app/d/a/a/h:adB	J
    //   108: invokevirtual 183	com/tencent/mm/wear/app/d/a/a/h:f	(J)V
    //   111: getstatic 29	com/tencent/mm/wear/app/d/a/a/h:adx	Ljava/lang/Object;
    //   114: astore 5
    //   116: aload 5
    //   118: monitorenter
    //   119: aload_0
    //   120: aload 6
    //   122: invokespecial 108	com/tencent/mm/wear/app/d/a/a/h:L	(Ljava/lang/String;)V
    //   125: aload 5
    //   127: monitorexit
    //   128: aload_0
    //   129: getfield 117	com/tencent/mm/wear/app/d/a/a/h:adv	Landroid/media/AudioTrack;
    //   132: ifnull +33 -> 165
    //   135: ldc 52
    //   137: ldc 185
    //   139: iconst_0
    //   140: anewarray 24	java/lang/Object
    //   143: invokestatic 66	com/tencent/mm/wear/a/c/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: aload_0
    //   147: getfield 117	com/tencent/mm/wear/app/d/a/a/h:adv	Landroid/media/AudioTrack;
    //   150: invokevirtual 124	android/media/AudioTrack:stop	()V
    //   153: aload_0
    //   154: getfield 117	com/tencent/mm/wear/app/d/a/a/h:adv	Landroid/media/AudioTrack;
    //   157: invokevirtual 127	android/media/AudioTrack:release	()V
    //   160: aload_0
    //   161: aconst_null
    //   162: putfield 117	com/tencent/mm/wear/app/d/a/a/h:adv	Landroid/media/AudioTrack;
    //   165: aload_0
    //   166: getfield 37	com/tencent/mm/wear/app/d/a/a/h:adD	I
    //   169: istore_3
    //   170: iload_3
    //   171: iconst_2
    //   172: iconst_2
    //   173: invokestatic 189	android/media/AudioTrack:getMinBufferSize	(III)I
    //   176: istore 4
    //   178: ldc 191
    //   180: ldc 193
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
    //   218: new 121	android/media/AudioTrack
    //   221: dup
    //   222: iconst_3
    //   223: iload_3
    //   224: iconst_2
    //   225: iconst_2
    //   226: iload 4
    //   228: bipush 8
    //   230: imul
    //   231: iconst_1
    //   232: invokespecial 196	android/media/AudioTrack:<init>	(IIIIII)V
    //   235: astore 6
    //   237: aload 6
    //   239: astore 5
    //   241: aload 6
    //   243: invokevirtual 199	android/media/AudioTrack:getState	()I
    //   246: ifne +27 -> 273
    //   249: aload 6
    //   251: invokevirtual 127	android/media/AudioTrack:release	()V
    //   254: new 121	android/media/AudioTrack
    //   257: dup
    //   258: iconst_3
    //   259: iload_3
    //   260: iconst_2
    //   261: iconst_2
    //   262: iload 4
    //   264: bipush 8
    //   266: imul
    //   267: iconst_1
    //   268: invokespecial 196	android/media/AudioTrack:<init>	(IIIIII)V
    //   271: astore 5
    //   273: ldc 191
    //   275: new 147	java/lang/StringBuilder
    //   278: dup
    //   279: ldc 201
    //   281: invokespecial 202	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   284: aload 5
    //   286: invokevirtual 199	android/media/AudioTrack:getState	()I
    //   289: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: iconst_0
    //   296: anewarray 24	java/lang/Object
    //   299: invokestatic 66	com/tencent/mm/wear/a/c/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   302: aload_0
    //   303: aload 5
    //   305: putfield 117	com/tencent/mm/wear/app/d/a/a/h:adv	Landroid/media/AudioTrack;
    //   308: aload_0
    //   309: getstatic 208	com/tencent/mm/wear/app/d/a/a/f:ads	I
    //   312: putfield 44	com/tencent/mm/wear/app/d/a/a/h:adE	I
    //   315: aload_0
    //   316: getfield 117	com/tencent/mm/wear/app/d/a/a/h:adv	Landroid/media/AudioTrack;
    //   319: ifnull +10 -> 329
    //   322: aload_0
    //   323: getfield 117	com/tencent/mm/wear/app/d/a/a/h:adv	Landroid/media/AudioTrack;
    //   326: invokevirtual 211	android/media/AudioTrack:play	()V
    //   329: aload_0
    //   330: new 213	com/tencent/mm/wear/app/d/a/a/i
    //   333: dup
    //   334: aload_0
    //   335: iconst_0
    //   336: invokespecial 216	com/tencent/mm/wear/app/d/a/a/i:<init>	(Lcom/tencent/mm/wear/app/d/a/a/h;B)V
    //   339: putfield 218	com/tencent/mm/wear/app/d/a/a/h:adw	Lcom/tencent/mm/wear/app/d/a/a/i;
    //   342: new 220	java/lang/Thread
    //   345: dup
    //   346: aload_0
    //   347: getfield 218	com/tencent/mm/wear/app/d/a/a/h:adw	Lcom/tencent/mm/wear/app/d/a/a/i;
    //   350: invokespecial 223	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   353: invokevirtual 226	java/lang/Thread:start	()V
    //   356: return
    //   357: astore 5
    //   359: ldc 52
    //   361: aload 5
    //   363: invokestatic 103	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   366: return
    //   367: astore 6
    //   369: aload 5
    //   371: monitorexit
    //   372: aload 6
    //   374: athrow
    //   375: astore 5
    //   377: ldc 52
    //   379: ldc 228
    //   381: iconst_1
    //   382: anewarray 24	java/lang/Object
    //   385: dup
    //   386: iconst_0
    //   387: aload 5
    //   389: invokevirtual 231	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   392: aastore
    //   393: invokestatic 177	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final boolean isPlaying()
  {
    return this.adE == f.ads;
  }
  
  public final void mG()
  {
    this.adE = f.adt;
  }
  
  public final long mH()
  {
    return this.adB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a.a.h
 * JD-Core Version:    0.7.0.1
 */