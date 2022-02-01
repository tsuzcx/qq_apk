package com.tencent.qqmusic.mediaplayer.codec.wav;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WaveReader
{
  private static final String TAG = "WaveReader";
  private static final int WAV_FORMAT = 1463899717;
  private static final int WAV_FORMAT_CHUNK_ID = 1718449184;
  private static final int WAV_HEADER_CHUNK_ID = 1380533830;
  private static final int WAV_HEADER_SIZE = 50;
  
  private static short byteToShortLE(byte paramByte1, byte paramByte2)
  {
    return (short)(paramByte1 & 0xFF | (paramByte2 & 0xFF) << 8);
  }
  
  /* Error */
  public static boolean isWavFormat(String paramString)
  {
    // Byte code:
    //   0: ldc 29
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: bipush 50
    //   7: newarray byte
    //   9: astore_3
    //   10: new 37	java/io/FileInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 40	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_0
    //   21: aload_3
    //   22: iconst_0
    //   23: invokestatic 44	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedInt	([BI)I
    //   26: istore_1
    //   27: iload_1
    //   28: ldc 15
    //   30: if_icmpeq +40 -> 70
    //   33: aload_2
    //   34: astore_0
    //   35: ldc 8
    //   37: ldc 46
    //   39: iload_1
    //   40: invokestatic 52	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   43: invokevirtual 56	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   46: invokestatic 61	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_2
    //   50: invokevirtual 66	java/io/InputStream:close	()V
    //   53: ldc 29
    //   55: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: iconst_0
    //   59: ireturn
    //   60: astore_0
    //   61: ldc 8
    //   63: aload_0
    //   64: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   67: goto -14 -> 53
    //   70: aload_2
    //   71: astore_0
    //   72: aload_3
    //   73: bipush 8
    //   75: invokestatic 44	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedInt	([BI)I
    //   78: istore_1
    //   79: iload_1
    //   80: ldc 11
    //   82: if_icmpeq +40 -> 122
    //   85: aload_2
    //   86: astore_0
    //   87: ldc 8
    //   89: ldc 75
    //   91: iload_1
    //   92: invokestatic 52	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   95: invokevirtual 56	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   98: invokestatic 61	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload_2
    //   102: invokevirtual 66	java/io/InputStream:close	()V
    //   105: ldc 29
    //   107: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: iconst_0
    //   111: ireturn
    //   112: astore_0
    //   113: ldc 8
    //   115: aload_0
    //   116: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   119: goto -14 -> 105
    //   122: aload_2
    //   123: astore_0
    //   124: aload_3
    //   125: bipush 12
    //   127: invokestatic 44	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedInt	([BI)I
    //   130: istore_1
    //   131: iload_1
    //   132: ldc 13
    //   134: if_icmpeq +40 -> 174
    //   137: aload_2
    //   138: astore_0
    //   139: ldc 8
    //   141: ldc 77
    //   143: iload_1
    //   144: invokestatic 52	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   147: invokevirtual 56	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   150: invokestatic 61	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_2
    //   154: invokevirtual 66	java/io/InputStream:close	()V
    //   157: ldc 29
    //   159: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: iconst_0
    //   163: ireturn
    //   164: astore_0
    //   165: ldc 8
    //   167: aload_0
    //   168: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   171: goto -14 -> 157
    //   174: aload_2
    //   175: astore_0
    //   176: ldc 8
    //   178: ldc 79
    //   180: aload_3
    //   181: bipush 16
    //   183: invokestatic 82	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedIntLE	([BI)I
    //   186: invokestatic 52	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   189: invokevirtual 56	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   192: invokestatic 61	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: aload_2
    //   196: astore_0
    //   197: ldc 8
    //   199: ldc 84
    //   201: aload_3
    //   202: bipush 20
    //   204: invokestatic 88	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedShortLE	([BI)S
    //   207: invokestatic 52	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   210: invokevirtual 56	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   213: invokestatic 61	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload_2
    //   217: invokevirtual 66	java/io/InputStream:close	()V
    //   220: ldc 29
    //   222: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: iconst_1
    //   226: ireturn
    //   227: astore_0
    //   228: ldc 8
    //   230: aload_0
    //   231: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   234: goto -14 -> 220
    //   237: astore_3
    //   238: aconst_null
    //   239: astore_2
    //   240: aload_2
    //   241: astore_0
    //   242: ldc 8
    //   244: aload_3
    //   245: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   248: aload_2
    //   249: ifnull +7 -> 256
    //   252: aload_2
    //   253: invokevirtual 66	java/io/InputStream:close	()V
    //   256: ldc 29
    //   258: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: iconst_0
    //   262: ireturn
    //   263: astore_0
    //   264: ldc 8
    //   266: aload_0
    //   267: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   270: goto -14 -> 256
    //   273: astore_2
    //   274: aconst_null
    //   275: astore_0
    //   276: aload_0
    //   277: ifnull +7 -> 284
    //   280: aload_0
    //   281: invokevirtual 66	java/io/InputStream:close	()V
    //   284: ldc 29
    //   286: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload_2
    //   290: athrow
    //   291: astore_0
    //   292: ldc 8
    //   294: aload_0
    //   295: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   298: goto -14 -> 284
    //   301: astore_2
    //   302: goto -26 -> 276
    //   305: astore_3
    //   306: goto -66 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	paramString	String
    //   26	118	1	i	int
    //   18	235	2	localFileInputStream	java.io.FileInputStream
    //   273	17	2	localObject1	Object
    //   301	1	2	localObject2	Object
    //   9	193	3	arrayOfByte	byte[]
    //   237	8	3	localException1	java.lang.Exception
    //   305	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   49	53	60	java/lang/Exception
    //   101	105	112	java/lang/Exception
    //   153	157	164	java/lang/Exception
    //   216	220	227	java/lang/Exception
    //   10	19	237	java/lang/Exception
    //   252	256	263	java/lang/Exception
    //   10	19	273	finally
    //   280	284	291	java/lang/Exception
    //   21	27	301	finally
    //   35	49	301	finally
    //   72	79	301	finally
    //   87	101	301	finally
    //   124	131	301	finally
    //   139	153	301	finally
    //   176	195	301	finally
    //   197	216	301	finally
    //   242	248	301	finally
    //   21	27	305	java/lang/Exception
    //   35	49	305	java/lang/Exception
    //   72	79	305	java/lang/Exception
    //   87	101	305	java/lang/Exception
    //   124	131	305	java/lang/Exception
    //   139	153	305	java/lang/Exception
    //   176	195	305	java/lang/Exception
    //   197	216	305	java/lang/Exception
  }
  
  private static int readUnsignedInt(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt + 4 > paramArrayOfByte.length) {
      return -1;
    }
    return (paramArrayOfByte[paramInt] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 3)] & 0xFF;
  }
  
  private static int readUnsignedIntLE(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt + 4 > paramArrayOfByte.length) {
      return -1;
    }
    return paramArrayOfByte[0] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24;
  }
  
  private static short readUnsignedShortLE(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(114316);
    if (paramInt + 2 > paramArrayOfByte.length)
    {
      AppMethodBeat.o(114316);
      return -1;
    }
    short s = byteToShortLE(paramArrayOfByte[paramInt], paramArrayOfByte[(paramInt + 1)]);
    AppMethodBeat.o(114316);
    return s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.wav.WaveReader
 * JD-Core Version:    0.7.0.1
 */