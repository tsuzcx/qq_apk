package com.tencent.tmassistantsdk.protocol;

public class ZipUtils
{
  private static final String TAG = "ZipUtils";
  
  /* Error */
  public static byte[] unzip(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 21	java/util/zip/Inflater
    //   3: dup
    //   4: invokespecial 22	java/util/zip/Inflater:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_2
    //   11: new 24	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: aload_0
    //   16: arraylength
    //   17: invokespecial 27	java/io/ByteArrayOutputStream:<init>	(I)V
    //   20: astore_1
    //   21: aload_1
    //   22: astore_2
    //   23: sipush 1024
    //   26: newarray byte
    //   28: astore_3
    //   29: aload_1
    //   30: astore_2
    //   31: aload 4
    //   33: aload_0
    //   34: invokevirtual 31	java/util/zip/Inflater:setInput	([B)V
    //   37: aload_1
    //   38: astore_2
    //   39: aload 4
    //   41: invokevirtual 35	java/util/zip/Inflater:finished	()Z
    //   44: ifne +59 -> 103
    //   47: aload_1
    //   48: astore_2
    //   49: aload_1
    //   50: aload_3
    //   51: iconst_0
    //   52: aload 4
    //   54: aload_3
    //   55: invokevirtual 39	java/util/zip/Inflater:inflate	([B)I
    //   58: invokevirtual 43	java/io/ByteArrayOutputStream:write	([BII)V
    //   61: goto -24 -> 37
    //   64: astore_3
    //   65: aload_1
    //   66: astore_0
    //   67: aload_0
    //   68: astore_2
    //   69: ldc 8
    //   71: aload_3
    //   72: ldc 45
    //   74: iconst_0
    //   75: anewarray 4	java/lang/Object
    //   78: invokestatic 51	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload 4
    //   83: invokevirtual 54	java/util/zip/Inflater:end	()V
    //   86: aload_0
    //   87: astore_1
    //   88: aload_0
    //   89: ifnull +9 -> 98
    //   92: aload_0
    //   93: invokevirtual 57	java/io/ByteArrayOutputStream:close	()V
    //   96: aload_0
    //   97: astore_1
    //   98: aload_1
    //   99: invokevirtual 61	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   102: areturn
    //   103: aload 4
    //   105: invokevirtual 54	java/util/zip/Inflater:end	()V
    //   108: aload_1
    //   109: invokevirtual 57	java/io/ByteArrayOutputStream:close	()V
    //   112: goto -14 -> 98
    //   115: astore_0
    //   116: goto -18 -> 98
    //   119: astore_0
    //   120: aload_2
    //   121: astore_1
    //   122: aload 4
    //   124: invokevirtual 54	java/util/zip/Inflater:end	()V
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 57	java/io/ByteArrayOutputStream:close	()V
    //   135: aload_0
    //   136: athrow
    //   137: astore_1
    //   138: aload_0
    //   139: astore_1
    //   140: goto -42 -> 98
    //   143: astore_1
    //   144: goto -9 -> 135
    //   147: astore_0
    //   148: aload_2
    //   149: astore_1
    //   150: goto -28 -> 122
    //   153: astore_3
    //   154: aconst_null
    //   155: astore_0
    //   156: goto -89 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramArrayOfByte	byte[]
    //   20	112	1	localObject1	Object
    //   137	1	1	localIOException1	java.io.IOException
    //   139	1	1	arrayOfByte1	byte[]
    //   143	1	1	localIOException2	java.io.IOException
    //   149	1	1	localObject2	Object
    //   10	139	2	localObject3	Object
    //   28	27	3	arrayOfByte2	byte[]
    //   64	8	3	localDataFormatException1	java.util.zip.DataFormatException
    //   153	1	3	localDataFormatException2	java.util.zip.DataFormatException
    //   7	116	4	localInflater	java.util.zip.Inflater
    // Exception table:
    //   from	to	target	type
    //   23	29	64	java/util/zip/DataFormatException
    //   31	37	64	java/util/zip/DataFormatException
    //   39	47	64	java/util/zip/DataFormatException
    //   49	61	64	java/util/zip/DataFormatException
    //   108	112	115	java/io/IOException
    //   11	21	119	finally
    //   92	96	137	java/io/IOException
    //   131	135	143	java/io/IOException
    //   23	29	147	finally
    //   31	37	147	finally
    //   39	47	147	finally
    //   49	61	147	finally
    //   69	81	147	finally
    //   11	21	153	java/util/zip/DataFormatException
  }
  
  /* Error */
  public static byte[] zip(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 64	java/util/zip/Deflater
    //   3: dup
    //   4: invokespecial 65	java/util/zip/Deflater:<init>	()V
    //   7: astore_2
    //   8: new 24	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: aload_0
    //   13: arraylength
    //   14: invokespecial 27	java/io/ByteArrayOutputStream:<init>	(I)V
    //   17: astore_1
    //   18: aload_2
    //   19: bipush 9
    //   21: invokevirtual 68	java/util/zip/Deflater:setLevel	(I)V
    //   24: aload_2
    //   25: aload_0
    //   26: invokevirtual 69	java/util/zip/Deflater:setInput	([B)V
    //   29: aload_2
    //   30: invokevirtual 72	java/util/zip/Deflater:finish	()V
    //   33: sipush 1024
    //   36: newarray byte
    //   38: astore_0
    //   39: aload_2
    //   40: invokevirtual 73	java/util/zip/Deflater:finished	()Z
    //   43: ifne +32 -> 75
    //   46: aload_1
    //   47: aload_0
    //   48: iconst_0
    //   49: aload_2
    //   50: aload_0
    //   51: invokevirtual 76	java/util/zip/Deflater:deflate	([B)I
    //   54: invokevirtual 43	java/io/ByteArrayOutputStream:write	([BII)V
    //   57: goto -18 -> 39
    //   60: astore_0
    //   61: aload_2
    //   62: invokevirtual 77	java/util/zip/Deflater:end	()V
    //   65: aload_1
    //   66: ifnull +7 -> 73
    //   69: aload_1
    //   70: invokevirtual 57	java/io/ByteArrayOutputStream:close	()V
    //   73: aload_0
    //   74: athrow
    //   75: aload_2
    //   76: invokevirtual 77	java/util/zip/Deflater:end	()V
    //   79: aload_1
    //   80: invokevirtual 57	java/io/ByteArrayOutputStream:close	()V
    //   83: aload_1
    //   84: invokevirtual 61	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   87: areturn
    //   88: astore_0
    //   89: ldc 8
    //   91: aload_0
    //   92: ldc 45
    //   94: iconst_0
    //   95: anewarray 4	java/lang/Object
    //   98: invokestatic 51	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: goto -18 -> 83
    //   104: astore_1
    //   105: ldc 8
    //   107: aload_1
    //   108: ldc 45
    //   110: iconst_0
    //   111: anewarray 4	java/lang/Object
    //   114: invokestatic 51	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: goto -44 -> 73
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_1
    //   123: goto -62 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramArrayOfByte	byte[]
    //   17	67	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   104	4	1	localIOException	java.io.IOException
    //   122	1	1	localObject	Object
    //   7	69	2	localDeflater	java.util.zip.Deflater
    // Exception table:
    //   from	to	target	type
    //   18	39	60	finally
    //   39	57	60	finally
    //   79	83	88	java/io/IOException
    //   69	73	104	java/io/IOException
    //   8	18	120	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.ZipUtils
 * JD-Core Version:    0.7.0.1
 */