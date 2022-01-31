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
    //   7: invokestatic 41	com/tencent/qqmusic/mediaplayer/CacheBytesManager:getStatic	(I)[B
    //   10: astore 4
    //   12: new 43	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 46	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_0
    //   23: aload 4
    //   25: iconst_0
    //   26: invokestatic 50	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedInt	([BI)I
    //   29: istore_1
    //   30: iload_1
    //   31: ldc 15
    //   33: if_icmpeq +46 -> 79
    //   36: aload_2
    //   37: astore_0
    //   38: ldc 8
    //   40: ldc 52
    //   42: iload_1
    //   43: invokestatic 58	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   46: invokevirtual 62	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   49: invokestatic 67	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_2
    //   53: invokevirtual 72	java/io/InputStream:close	()V
    //   56: aload 4
    //   58: invokestatic 76	com/tencent/qqmusic/mediaplayer/CacheBytesManager:recycle	([B)[B
    //   61: pop
    //   62: ldc 29
    //   64: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: iconst_0
    //   68: ireturn
    //   69: astore_0
    //   70: ldc 8
    //   72: aload_0
    //   73: invokestatic 83	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: goto -20 -> 56
    //   79: aload_2
    //   80: astore_0
    //   81: aload 4
    //   83: bipush 8
    //   85: invokestatic 50	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedInt	([BI)I
    //   88: istore_1
    //   89: iload_1
    //   90: ldc 11
    //   92: if_icmpeq +46 -> 138
    //   95: aload_2
    //   96: astore_0
    //   97: ldc 8
    //   99: ldc 85
    //   101: iload_1
    //   102: invokestatic 58	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   105: invokevirtual 62	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   108: invokestatic 67	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_2
    //   112: invokevirtual 72	java/io/InputStream:close	()V
    //   115: aload 4
    //   117: invokestatic 76	com/tencent/qqmusic/mediaplayer/CacheBytesManager:recycle	([B)[B
    //   120: pop
    //   121: ldc 29
    //   123: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: iconst_0
    //   127: ireturn
    //   128: astore_0
    //   129: ldc 8
    //   131: aload_0
    //   132: invokestatic 83	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: goto -20 -> 115
    //   138: aload_2
    //   139: astore_0
    //   140: aload 4
    //   142: bipush 12
    //   144: invokestatic 50	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedInt	([BI)I
    //   147: istore_1
    //   148: iload_1
    //   149: ldc 13
    //   151: if_icmpeq +46 -> 197
    //   154: aload_2
    //   155: astore_0
    //   156: ldc 8
    //   158: ldc 87
    //   160: iload_1
    //   161: invokestatic 58	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   164: invokevirtual 62	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   167: invokestatic 67	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aload_2
    //   171: invokevirtual 72	java/io/InputStream:close	()V
    //   174: aload 4
    //   176: invokestatic 76	com/tencent/qqmusic/mediaplayer/CacheBytesManager:recycle	([B)[B
    //   179: pop
    //   180: ldc 29
    //   182: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: iconst_0
    //   186: ireturn
    //   187: astore_0
    //   188: ldc 8
    //   190: aload_0
    //   191: invokestatic 83	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   194: goto -20 -> 174
    //   197: aload_2
    //   198: astore_0
    //   199: ldc 8
    //   201: ldc 89
    //   203: aload 4
    //   205: bipush 16
    //   207: invokestatic 92	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedIntLE	([BI)I
    //   210: invokestatic 58	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   213: invokevirtual 62	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   216: invokestatic 67	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_2
    //   220: astore_0
    //   221: ldc 8
    //   223: ldc 94
    //   225: aload 4
    //   227: bipush 20
    //   229: invokestatic 98	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedShortLE	([BI)S
    //   232: invokestatic 58	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   235: invokevirtual 62	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   238: invokestatic 67	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_2
    //   242: invokevirtual 72	java/io/InputStream:close	()V
    //   245: aload 4
    //   247: invokestatic 76	com/tencent/qqmusic/mediaplayer/CacheBytesManager:recycle	([B)[B
    //   250: pop
    //   251: ldc 29
    //   253: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: iconst_1
    //   257: ireturn
    //   258: astore_0
    //   259: ldc 8
    //   261: aload_0
    //   262: invokestatic 83	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   265: goto -20 -> 245
    //   268: astore_3
    //   269: aconst_null
    //   270: astore_2
    //   271: aload_2
    //   272: astore_0
    //   273: ldc 8
    //   275: aload_3
    //   276: invokestatic 83	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   279: aload_2
    //   280: ifnull +7 -> 287
    //   283: aload_2
    //   284: invokevirtual 72	java/io/InputStream:close	()V
    //   287: aload 4
    //   289: invokestatic 76	com/tencent/qqmusic/mediaplayer/CacheBytesManager:recycle	([B)[B
    //   292: pop
    //   293: ldc 29
    //   295: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: iconst_0
    //   299: ireturn
    //   300: astore_0
    //   301: ldc 8
    //   303: aload_0
    //   304: invokestatic 83	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   307: goto -20 -> 287
    //   310: astore_2
    //   311: aconst_null
    //   312: astore_0
    //   313: aload_0
    //   314: ifnull +7 -> 321
    //   317: aload_0
    //   318: invokevirtual 72	java/io/InputStream:close	()V
    //   321: aload 4
    //   323: invokestatic 76	com/tencent/qqmusic/mediaplayer/CacheBytesManager:recycle	([B)[B
    //   326: pop
    //   327: ldc 29
    //   329: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   332: aload_2
    //   333: athrow
    //   334: astore_0
    //   335: ldc 8
    //   337: aload_0
    //   338: invokestatic 83	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   341: goto -20 -> 321
    //   344: astore_2
    //   345: goto -32 -> 313
    //   348: astore_3
    //   349: goto -78 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	paramString	String
    //   29	132	1	i	int
    //   20	264	2	localFileInputStream	java.io.FileInputStream
    //   310	23	2	localObject1	Object
    //   344	1	2	localObject2	Object
    //   268	8	3	localException1	java.lang.Exception
    //   348	1	3	localException2	java.lang.Exception
    //   10	312	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   52	56	69	java/lang/Exception
    //   111	115	128	java/lang/Exception
    //   170	174	187	java/lang/Exception
    //   241	245	258	java/lang/Exception
    //   12	21	268	java/lang/Exception
    //   283	287	300	java/lang/Exception
    //   12	21	310	finally
    //   317	321	334	java/lang/Exception
    //   23	30	344	finally
    //   38	52	344	finally
    //   81	89	344	finally
    //   97	111	344	finally
    //   140	148	344	finally
    //   156	170	344	finally
    //   199	219	344	finally
    //   221	241	344	finally
    //   273	279	344	finally
    //   23	30	348	java/lang/Exception
    //   38	52	348	java/lang/Exception
    //   81	89	348	java/lang/Exception
    //   97	111	348	java/lang/Exception
    //   140	148	348	java/lang/Exception
    //   156	170	348	java/lang/Exception
    //   199	219	348	java/lang/Exception
    //   221	241	348	java/lang/Exception
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
    AppMethodBeat.i(128532);
    if (paramInt + 2 > paramArrayOfByte.length)
    {
      AppMethodBeat.o(128532);
      return -1;
    }
    short s = byteToShortLE(paramArrayOfByte[paramInt], paramArrayOfByte[(paramInt + 1)]);
    AppMethodBeat.o(128532);
    return s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.wav.WaveReader
 * JD-Core Version:    0.7.0.1
 */