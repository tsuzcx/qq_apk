package com.tencent.tmassistantsdk.protocol;

public class ZipUtils
{
  private static final String TAG = "ZipUtils";
  
  /* Error */
  public static byte[] unzip(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 20
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 28	java/util/zip/Inflater
    //   8: dup
    //   9: invokespecial 29	java/util/zip/Inflater:<init>	()V
    //   12: astore 4
    //   14: aconst_null
    //   15: astore_2
    //   16: new 31	java/io/ByteArrayOutputStream
    //   19: dup
    //   20: aload_0
    //   21: arraylength
    //   22: invokespecial 33	java/io/ByteArrayOutputStream:<init>	(I)V
    //   25: astore_1
    //   26: aload_1
    //   27: astore_2
    //   28: sipush 1024
    //   31: newarray byte
    //   33: astore_3
    //   34: aload_1
    //   35: astore_2
    //   36: aload 4
    //   38: aload_0
    //   39: invokevirtual 37	java/util/zip/Inflater:setInput	([B)V
    //   42: aload_1
    //   43: astore_2
    //   44: aload 4
    //   46: invokevirtual 41	java/util/zip/Inflater:finished	()Z
    //   49: ifne +66 -> 115
    //   52: aload_1
    //   53: astore_2
    //   54: aload_1
    //   55: aload_3
    //   56: iconst_0
    //   57: aload 4
    //   59: aload_3
    //   60: invokevirtual 45	java/util/zip/Inflater:inflate	([B)I
    //   63: invokevirtual 49	java/io/ByteArrayOutputStream:write	([BII)V
    //   66: goto -24 -> 42
    //   69: astore_3
    //   70: aload_1
    //   71: astore_0
    //   72: aload_0
    //   73: astore_2
    //   74: ldc 8
    //   76: aload_3
    //   77: ldc 51
    //   79: iconst_0
    //   80: anewarray 4	java/lang/Object
    //   83: invokestatic 57	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload 4
    //   88: invokevirtual 60	java/util/zip/Inflater:end	()V
    //   91: aload_0
    //   92: astore_1
    //   93: aload_0
    //   94: ifnull +9 -> 103
    //   97: aload_0
    //   98: invokevirtual 63	java/io/ByteArrayOutputStream:close	()V
    //   101: aload_0
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 67	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   107: astore_0
    //   108: ldc 20
    //   110: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_0
    //   114: areturn
    //   115: aload 4
    //   117: invokevirtual 60	java/util/zip/Inflater:end	()V
    //   120: aload_1
    //   121: invokevirtual 63	java/io/ByteArrayOutputStream:close	()V
    //   124: goto -21 -> 103
    //   127: astore_0
    //   128: goto -25 -> 103
    //   131: astore_0
    //   132: aload_2
    //   133: astore_1
    //   134: aload 4
    //   136: invokevirtual 60	java/util/zip/Inflater:end	()V
    //   139: aload_1
    //   140: ifnull +7 -> 147
    //   143: aload_1
    //   144: invokevirtual 63	java/io/ByteArrayOutputStream:close	()V
    //   147: ldc 20
    //   149: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_0
    //   153: athrow
    //   154: astore_1
    //   155: aload_0
    //   156: astore_1
    //   157: goto -54 -> 103
    //   160: astore_1
    //   161: goto -14 -> 147
    //   164: astore_0
    //   165: aload_2
    //   166: astore_1
    //   167: goto -33 -> 134
    //   170: astore_3
    //   171: aconst_null
    //   172: astore_0
    //   173: goto -101 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramArrayOfByte	byte[]
    //   25	119	1	localObject1	Object
    //   154	1	1	localIOException1	java.io.IOException
    //   156	1	1	arrayOfByte1	byte[]
    //   160	1	1	localIOException2	java.io.IOException
    //   166	1	1	localObject2	Object
    //   15	151	2	localObject3	Object
    //   33	27	3	arrayOfByte2	byte[]
    //   69	8	3	localDataFormatException1	java.util.zip.DataFormatException
    //   170	1	3	localDataFormatException2	java.util.zip.DataFormatException
    //   12	123	4	localInflater	java.util.zip.Inflater
    // Exception table:
    //   from	to	target	type
    //   28	34	69	java/util/zip/DataFormatException
    //   36	42	69	java/util/zip/DataFormatException
    //   44	52	69	java/util/zip/DataFormatException
    //   54	66	69	java/util/zip/DataFormatException
    //   120	124	127	java/io/IOException
    //   16	26	131	finally
    //   97	101	154	java/io/IOException
    //   143	147	160	java/io/IOException
    //   28	34	164	finally
    //   36	42	164	finally
    //   44	52	164	finally
    //   54	66	164	finally
    //   74	86	164	finally
    //   16	26	170	java/util/zip/DataFormatException
  }
  
  /* Error */
  public static byte[] zip(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 72
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 74	java/util/zip/Deflater
    //   8: dup
    //   9: invokespecial 75	java/util/zip/Deflater:<init>	()V
    //   12: astore_2
    //   13: new 31	java/io/ByteArrayOutputStream
    //   16: dup
    //   17: aload_0
    //   18: arraylength
    //   19: invokespecial 33	java/io/ByteArrayOutputStream:<init>	(I)V
    //   22: astore_1
    //   23: aload_2
    //   24: bipush 9
    //   26: invokevirtual 78	java/util/zip/Deflater:setLevel	(I)V
    //   29: aload_2
    //   30: aload_0
    //   31: invokevirtual 79	java/util/zip/Deflater:setInput	([B)V
    //   34: aload_2
    //   35: invokevirtual 82	java/util/zip/Deflater:finish	()V
    //   38: sipush 1024
    //   41: newarray byte
    //   43: astore_0
    //   44: aload_2
    //   45: invokevirtual 83	java/util/zip/Deflater:finished	()Z
    //   48: ifne +37 -> 85
    //   51: aload_1
    //   52: aload_0
    //   53: iconst_0
    //   54: aload_2
    //   55: aload_0
    //   56: invokevirtual 86	java/util/zip/Deflater:deflate	([B)I
    //   59: invokevirtual 49	java/io/ByteArrayOutputStream:write	([BII)V
    //   62: goto -18 -> 44
    //   65: astore_0
    //   66: aload_2
    //   67: invokevirtual 87	java/util/zip/Deflater:end	()V
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 63	java/io/ByteArrayOutputStream:close	()V
    //   78: ldc 72
    //   80: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_0
    //   84: athrow
    //   85: aload_2
    //   86: invokevirtual 87	java/util/zip/Deflater:end	()V
    //   89: aload_1
    //   90: invokevirtual 63	java/io/ByteArrayOutputStream:close	()V
    //   93: aload_1
    //   94: invokevirtual 67	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   97: astore_0
    //   98: ldc 72
    //   100: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_0
    //   104: areturn
    //   105: astore_0
    //   106: ldc 8
    //   108: aload_0
    //   109: ldc 51
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokestatic 57	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: goto -25 -> 93
    //   121: astore_1
    //   122: ldc 8
    //   124: aload_1
    //   125: ldc 51
    //   127: iconst_0
    //   128: anewarray 4	java/lang/Object
    //   131: invokestatic 57	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: goto -56 -> 78
    //   137: astore_0
    //   138: aconst_null
    //   139: astore_1
    //   140: goto -74 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramArrayOfByte	byte[]
    //   22	72	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   121	4	1	localIOException	java.io.IOException
    //   139	1	1	localObject	Object
    //   12	74	2	localDeflater	java.util.zip.Deflater
    // Exception table:
    //   from	to	target	type
    //   23	44	65	finally
    //   44	62	65	finally
    //   89	93	105	java/io/IOException
    //   74	78	121	java/io/IOException
    //   13	23	137	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.ZipUtils
 * JD-Core Version:    0.7.0.1
 */