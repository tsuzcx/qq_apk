package com.tencent.qqmusic.mediaplayer.codec.wav;

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
    //   0: bipush 50
    //   2: invokestatic 34	com/tencent/qqmusic/mediaplayer/CacheBytesManager:getStatic	(I)[B
    //   5: astore 4
    //   7: new 36	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 39	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   15: astore_2
    //   16: aload_2
    //   17: astore_0
    //   18: aload 4
    //   20: iconst_0
    //   21: invokestatic 43	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedInt	([BI)I
    //   24: istore_1
    //   25: iload_1
    //   26: ldc 15
    //   28: if_icmpeq +48 -> 76
    //   31: aload_2
    //   32: astore_0
    //   33: ldc 8
    //   35: new 45	java/lang/StringBuilder
    //   38: dup
    //   39: ldc 47
    //   41: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   44: iload_1
    //   45: invokevirtual 52	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 62	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_2
    //   55: invokevirtual 67	java/io/InputStream:close	()V
    //   58: aload 4
    //   60: invokestatic 71	com/tencent/qqmusic/mediaplayer/CacheBytesManager:recycle	([B)[B
    //   63: pop
    //   64: iconst_0
    //   65: ireturn
    //   66: astore_0
    //   67: ldc 8
    //   69: aload_0
    //   70: invokestatic 75	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   73: goto -15 -> 58
    //   76: aload_2
    //   77: astore_0
    //   78: aload 4
    //   80: bipush 8
    //   82: invokestatic 43	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedInt	([BI)I
    //   85: istore_1
    //   86: iload_1
    //   87: ldc 11
    //   89: if_icmpeq +48 -> 137
    //   92: aload_2
    //   93: astore_0
    //   94: ldc 8
    //   96: new 45	java/lang/StringBuilder
    //   99: dup
    //   100: ldc 77
    //   102: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: iload_1
    //   106: invokevirtual 52	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 62	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_2
    //   116: invokevirtual 67	java/io/InputStream:close	()V
    //   119: aload 4
    //   121: invokestatic 71	com/tencent/qqmusic/mediaplayer/CacheBytesManager:recycle	([B)[B
    //   124: pop
    //   125: iconst_0
    //   126: ireturn
    //   127: astore_0
    //   128: ldc 8
    //   130: aload_0
    //   131: invokestatic 75	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   134: goto -15 -> 119
    //   137: aload_2
    //   138: astore_0
    //   139: aload 4
    //   141: bipush 12
    //   143: invokestatic 43	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedInt	([BI)I
    //   146: istore_1
    //   147: iload_1
    //   148: ldc 13
    //   150: if_icmpeq +48 -> 198
    //   153: aload_2
    //   154: astore_0
    //   155: ldc 8
    //   157: new 45	java/lang/StringBuilder
    //   160: dup
    //   161: ldc 79
    //   163: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: iload_1
    //   167: invokevirtual 52	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 62	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload_2
    //   177: invokevirtual 67	java/io/InputStream:close	()V
    //   180: aload 4
    //   182: invokestatic 71	com/tencent/qqmusic/mediaplayer/CacheBytesManager:recycle	([B)[B
    //   185: pop
    //   186: iconst_0
    //   187: ireturn
    //   188: astore_0
    //   189: ldc 8
    //   191: aload_0
    //   192: invokestatic 75	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   195: goto -15 -> 180
    //   198: aload_2
    //   199: astore_0
    //   200: aload 4
    //   202: bipush 16
    //   204: invokestatic 82	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedIntLE	([BI)I
    //   207: istore_1
    //   208: aload_2
    //   209: astore_0
    //   210: ldc 8
    //   212: new 45	java/lang/StringBuilder
    //   215: dup
    //   216: ldc 84
    //   218: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   221: iload_1
    //   222: invokevirtual 52	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 62	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload_2
    //   232: astore_0
    //   233: aload 4
    //   235: bipush 20
    //   237: invokestatic 88	com/tencent/qqmusic/mediaplayer/codec/wav/WaveReader:readUnsignedShortLE	([BI)S
    //   240: istore_1
    //   241: aload_2
    //   242: astore_0
    //   243: ldc 8
    //   245: new 45	java/lang/StringBuilder
    //   248: dup
    //   249: ldc 90
    //   251: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   254: iload_1
    //   255: invokevirtual 52	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 62	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload_2
    //   265: invokevirtual 67	java/io/InputStream:close	()V
    //   268: aload 4
    //   270: invokestatic 71	com/tencent/qqmusic/mediaplayer/CacheBytesManager:recycle	([B)[B
    //   273: pop
    //   274: iconst_1
    //   275: ireturn
    //   276: astore_0
    //   277: ldc 8
    //   279: aload_0
    //   280: invokestatic 75	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   283: goto -15 -> 268
    //   286: astore_3
    //   287: aconst_null
    //   288: astore_2
    //   289: aload_2
    //   290: astore_0
    //   291: ldc 8
    //   293: aload_3
    //   294: invokestatic 75	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   297: aload_2
    //   298: ifnull +7 -> 305
    //   301: aload_2
    //   302: invokevirtual 67	java/io/InputStream:close	()V
    //   305: aload 4
    //   307: invokestatic 71	com/tencent/qqmusic/mediaplayer/CacheBytesManager:recycle	([B)[B
    //   310: pop
    //   311: iconst_0
    //   312: ireturn
    //   313: astore_0
    //   314: ldc 8
    //   316: aload_0
    //   317: invokestatic 75	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   320: goto -15 -> 305
    //   323: astore_2
    //   324: aconst_null
    //   325: astore_0
    //   326: aload_0
    //   327: ifnull +7 -> 334
    //   330: aload_0
    //   331: invokevirtual 67	java/io/InputStream:close	()V
    //   334: aload 4
    //   336: invokestatic 71	com/tencent/qqmusic/mediaplayer/CacheBytesManager:recycle	([B)[B
    //   339: pop
    //   340: aload_2
    //   341: athrow
    //   342: astore_0
    //   343: ldc 8
    //   345: aload_0
    //   346: invokestatic 75	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   349: goto -15 -> 334
    //   352: astore_2
    //   353: goto -27 -> 326
    //   356: astore_3
    //   357: goto -68 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	paramString	String
    //   24	231	1	i	int
    //   15	287	2	localFileInputStream	java.io.FileInputStream
    //   323	18	2	localObject1	Object
    //   352	1	2	localObject2	Object
    //   286	8	3	localException1	java.lang.Exception
    //   356	1	3	localException2	java.lang.Exception
    //   5	330	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   54	58	66	java/lang/Exception
    //   115	119	127	java/lang/Exception
    //   176	180	188	java/lang/Exception
    //   264	268	276	java/lang/Exception
    //   7	16	286	java/lang/Exception
    //   301	305	313	java/lang/Exception
    //   7	16	323	finally
    //   330	334	342	java/lang/Exception
    //   18	25	352	finally
    //   33	54	352	finally
    //   78	86	352	finally
    //   94	115	352	finally
    //   139	147	352	finally
    //   155	176	352	finally
    //   200	208	352	finally
    //   210	231	352	finally
    //   233	241	352	finally
    //   243	264	352	finally
    //   291	297	352	finally
    //   18	25	356	java/lang/Exception
    //   33	54	356	java/lang/Exception
    //   78	86	356	java/lang/Exception
    //   94	115	356	java/lang/Exception
    //   139	147	356	java/lang/Exception
    //   155	176	356	java/lang/Exception
    //   200	208	356	java/lang/Exception
    //   210	231	356	java/lang/Exception
    //   233	241	356	java/lang/Exception
    //   243	264	356	java/lang/Exception
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
    if (paramInt + 2 > paramArrayOfByte.length) {
      return -1;
    }
    return byteToShortLE(paramArrayOfByte[paramInt], paramArrayOfByte[(paramInt + 1)]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.wav.WaveReader
 * JD-Core Version:    0.7.0.1
 */