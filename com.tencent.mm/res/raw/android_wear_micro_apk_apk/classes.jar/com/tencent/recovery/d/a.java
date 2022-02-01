package com.tencent.recovery.d;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;

public final class a
{
  private int amF;
  private File amG;
  private File amH;
  private MappedByteBuffer amI;
  private RandomAccessFile amJ;
  private int currentIndex;
  
  /* Error */
  private static void a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: new 22	java/io/DataInputStream
    //   3: dup
    //   4: new 24	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 28	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 31	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore 5
    //   17: aload 5
    //   19: invokevirtual 35	java/io/DataInputStream:readInt	()I
    //   22: istore 4
    //   24: new 37	java/io/FileOutputStream
    //   27: dup
    //   28: aload_1
    //   29: iconst_1
    //   30: invokespecial 40	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   33: astore_0
    //   34: aload_0
    //   35: astore 6
    //   37: aload 5
    //   39: astore_1
    //   40: sipush 1024
    //   43: newarray byte
    //   45: astore 7
    //   47: iconst_0
    //   48: istore_2
    //   49: goto +182 -> 231
    //   52: iload_3
    //   53: ifle +51 -> 104
    //   56: aload_0
    //   57: astore 6
    //   59: aload 5
    //   61: astore_1
    //   62: aload 5
    //   64: aload 7
    //   66: iconst_0
    //   67: iload_3
    //   68: invokevirtual 44	java/io/DataInputStream:read	([BII)I
    //   71: istore_3
    //   72: iload_3
    //   73: ifle +31 -> 104
    //   76: aload_0
    //   77: astore 6
    //   79: aload 5
    //   81: astore_1
    //   82: aload_0
    //   83: aload 7
    //   85: iconst_0
    //   86: iload_3
    //   87: invokevirtual 48	java/io/FileOutputStream:write	([BII)V
    //   90: iload_3
    //   91: iload_2
    //   92: iadd
    //   93: istore_2
    //   94: goto +137 -> 231
    //   97: sipush 1024
    //   100: istore_3
    //   101: goto -49 -> 52
    //   104: aload 5
    //   106: invokevirtual 52	java/io/DataInputStream:close	()V
    //   109: aload_0
    //   110: invokevirtual 53	java/io/FileOutputStream:close	()V
    //   113: return
    //   114: astore 7
    //   116: aconst_null
    //   117: astore_0
    //   118: aconst_null
    //   119: astore 5
    //   121: aload_0
    //   122: astore 6
    //   124: aload 5
    //   126: astore_1
    //   127: ldc 55
    //   129: aload 7
    //   131: ldc 57
    //   133: iconst_0
    //   134: anewarray 4	java/lang/Object
    //   137: invokestatic 62	com/tencent/recovery/a/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload 5
    //   142: ifnull +8 -> 150
    //   145: aload 5
    //   147: invokevirtual 52	java/io/DataInputStream:close	()V
    //   150: aload_0
    //   151: ifnull -38 -> 113
    //   154: aload_0
    //   155: invokevirtual 53	java/io/FileOutputStream:close	()V
    //   158: return
    //   159: astore_0
    //   160: return
    //   161: astore_0
    //   162: aconst_null
    //   163: astore 6
    //   165: aconst_null
    //   166: astore_1
    //   167: aload_1
    //   168: ifnull +7 -> 175
    //   171: aload_1
    //   172: invokevirtual 52	java/io/DataInputStream:close	()V
    //   175: aload 6
    //   177: ifnull +8 -> 185
    //   180: aload 6
    //   182: invokevirtual 53	java/io/FileOutputStream:close	()V
    //   185: aload_0
    //   186: athrow
    //   187: astore_1
    //   188: goto -79 -> 109
    //   191: astore_0
    //   192: return
    //   193: astore_1
    //   194: goto -44 -> 150
    //   197: astore_1
    //   198: goto -23 -> 175
    //   201: astore_1
    //   202: goto -17 -> 185
    //   205: astore_0
    //   206: aconst_null
    //   207: astore 6
    //   209: aload 5
    //   211: astore_1
    //   212: goto -45 -> 167
    //   215: astore_0
    //   216: goto -49 -> 167
    //   219: astore 7
    //   221: aconst_null
    //   222: astore_0
    //   223: goto -102 -> 121
    //   226: astore 7
    //   228: goto -107 -> 121
    //   231: iload_2
    //   232: sipush 1024
    //   235: iadd
    //   236: iload 4
    //   238: if_icmple -141 -> 97
    //   241: iload 4
    //   243: iload_2
    //   244: isub
    //   245: istore_3
    //   246: goto -194 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramFile1	File
    //   0	249	1	paramFile2	File
    //   48	197	2	i	int
    //   52	194	3	j	int
    //   22	223	4	k	int
    //   15	195	5	localDataInputStream	java.io.DataInputStream
    //   35	173	6	localFile	File
    //   45	39	7	arrayOfByte	byte[]
    //   114	16	7	localException1	java.lang.Exception
    //   219	1	7	localException2	java.lang.Exception
    //   226	1	7	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	114	java/lang/Exception
    //   154	158	159	java/io/IOException
    //   0	17	161	finally
    //   104	109	187	java/io/IOException
    //   109	113	191	java/io/IOException
    //   145	150	193	java/io/IOException
    //   171	175	197	java/io/IOException
    //   180	185	201	java/io/IOException
    //   17	34	205	finally
    //   40	47	215	finally
    //   62	72	215	finally
    //   82	90	215	finally
    //   127	140	215	finally
    //   17	34	219	java/lang/Exception
    //   40	47	226	java/lang/Exception
    //   62	72	226	java/lang/Exception
    //   82	90	226	java/lang/Exception
  }
  
  /* Error */
  public final void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 66	com/tencent/recovery/d/a:amJ	Ljava/io/RandomAccessFile;
    //   4: ifnonnull +38 -> 42
    //   7: aload_0
    //   8: getfield 68	com/tencent/recovery/d/a:amH	Ljava/io/File;
    //   11: invokevirtual 74	java/io/File:exists	()Z
    //   14: ifne +11 -> 25
    //   17: aload_0
    //   18: getfield 68	com/tencent/recovery/d/a:amH	Ljava/io/File;
    //   21: invokevirtual 77	java/io/File:createNewFile	()Z
    //   24: pop
    //   25: aload_0
    //   26: new 79	java/io/RandomAccessFile
    //   29: dup
    //   30: aload_0
    //   31: getfield 68	com/tencent/recovery/d/a:amH	Ljava/io/File;
    //   34: ldc 81
    //   36: invokespecial 84	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   39: putfield 66	com/tencent/recovery/d/a:amJ	Ljava/io/RandomAccessFile;
    //   42: aload_0
    //   43: getfield 86	com/tencent/recovery/d/a:amI	Ljava/nio/MappedByteBuffer;
    //   46: ifnonnull +26 -> 72
    //   49: aload_0
    //   50: aload_0
    //   51: getfield 66	com/tencent/recovery/d/a:amJ	Ljava/io/RandomAccessFile;
    //   54: invokevirtual 90	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   57: getstatic 96	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   60: lconst_0
    //   61: aload_0
    //   62: getfield 98	com/tencent/recovery/d/a:amF	I
    //   65: i2l
    //   66: invokevirtual 104	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   69: putfield 86	com/tencent/recovery/d/a:amI	Ljava/nio/MappedByteBuffer;
    //   72: aload_0
    //   73: getfield 68	com/tencent/recovery/d/a:amH	Ljava/io/File;
    //   76: ifnull +209 -> 285
    //   79: aload_0
    //   80: getfield 86	com/tencent/recovery/d/a:amI	Ljava/nio/MappedByteBuffer;
    //   83: ifnonnull +4 -> 87
    //   86: return
    //   87: aload_0
    //   88: getfield 106	com/tencent/recovery/d/a:currentIndex	I
    //   91: aload_1
    //   92: arraylength
    //   93: iadd
    //   94: aload_0
    //   95: getfield 98	com/tencent/recovery/d/a:amF	I
    //   98: if_icmpgt +7 -> 105
    //   101: iload_2
    //   102: ifeq +104 -> 206
    //   105: aload_0
    //   106: getfield 86	com/tencent/recovery/d/a:amI	Ljava/nio/MappedByteBuffer;
    //   109: invokevirtual 112	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   112: pop
    //   113: aload_0
    //   114: getfield 66	com/tencent/recovery/d/a:amJ	Ljava/io/RandomAccessFile;
    //   117: invokevirtual 113	java/io/RandomAccessFile:close	()V
    //   120: aload_0
    //   121: getfield 68	com/tencent/recovery/d/a:amH	Ljava/io/File;
    //   124: aload_0
    //   125: getfield 115	com/tencent/recovery/d/a:amG	Ljava/io/File;
    //   128: invokestatic 117	com/tencent/recovery/d/a:a	(Ljava/io/File;Ljava/io/File;)V
    //   131: aload_0
    //   132: iconst_4
    //   133: putfield 106	com/tencent/recovery/d/a:currentIndex	I
    //   136: aload_0
    //   137: getfield 68	com/tencent/recovery/d/a:amH	Ljava/io/File;
    //   140: invokevirtual 120	java/io/File:delete	()Z
    //   143: pop
    //   144: aload_0
    //   145: getfield 68	com/tencent/recovery/d/a:amH	Ljava/io/File;
    //   148: invokevirtual 77	java/io/File:createNewFile	()Z
    //   151: pop
    //   152: aload_0
    //   153: new 79	java/io/RandomAccessFile
    //   156: dup
    //   157: aload_0
    //   158: getfield 68	com/tencent/recovery/d/a:amH	Ljava/io/File;
    //   161: ldc 81
    //   163: invokespecial 84	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   166: putfield 66	com/tencent/recovery/d/a:amJ	Ljava/io/RandomAccessFile;
    //   169: aload_0
    //   170: aload_0
    //   171: getfield 66	com/tencent/recovery/d/a:amJ	Ljava/io/RandomAccessFile;
    //   174: invokevirtual 90	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   177: getstatic 96	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   180: lconst_0
    //   181: aload_0
    //   182: getfield 98	com/tencent/recovery/d/a:amF	I
    //   185: i2l
    //   186: invokevirtual 104	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   189: putfield 86	com/tencent/recovery/d/a:amI	Ljava/nio/MappedByteBuffer;
    //   192: aload_0
    //   193: getfield 86	com/tencent/recovery/d/a:amI	Ljava/nio/MappedByteBuffer;
    //   196: aload_0
    //   197: getfield 106	com/tencent/recovery/d/a:currentIndex	I
    //   200: iconst_4
    //   201: isub
    //   202: invokevirtual 124	java/nio/MappedByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   205: pop
    //   206: aload_1
    //   207: arraylength
    //   208: iflt +77 -> 285
    //   211: aload_0
    //   212: getfield 86	com/tencent/recovery/d/a:amI	Ljava/nio/MappedByteBuffer;
    //   215: aload_0
    //   216: getfield 106	com/tencent/recovery/d/a:currentIndex	I
    //   219: invokevirtual 128	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   222: pop
    //   223: aload_0
    //   224: getfield 86	com/tencent/recovery/d/a:amI	Ljava/nio/MappedByteBuffer;
    //   227: aload_1
    //   228: invokevirtual 132	java/nio/MappedByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   231: pop
    //   232: aload_0
    //   233: getfield 86	com/tencent/recovery/d/a:amI	Ljava/nio/MappedByteBuffer;
    //   236: iconst_0
    //   237: invokevirtual 128	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   240: pop
    //   241: aload_0
    //   242: aload_0
    //   243: getfield 106	com/tencent/recovery/d/a:currentIndex	I
    //   246: aload_1
    //   247: arraylength
    //   248: iadd
    //   249: putfield 106	com/tencent/recovery/d/a:currentIndex	I
    //   252: aload_0
    //   253: getfield 86	com/tencent/recovery/d/a:amI	Ljava/nio/MappedByteBuffer;
    //   256: aload_0
    //   257: getfield 106	com/tencent/recovery/d/a:currentIndex	I
    //   260: iconst_4
    //   261: isub
    //   262: invokevirtual 124	java/nio/MappedByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   265: pop
    //   266: return
    //   267: astore_1
    //   268: ldc 55
    //   270: aload_1
    //   271: ldc 134
    //   273: iconst_0
    //   274: anewarray 4	java/lang/Object
    //   277: invokestatic 62	com/tencent/recovery/a/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   280: return
    //   281: astore_3
    //   282: goto -162 -> 120
    //   285: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	a
    //   0	286	1	paramArrayOfByte	byte[]
    //   0	286	2	paramBoolean	boolean
    //   281	1	3	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   0	25	267	java/lang/Exception
    //   25	42	267	java/lang/Exception
    //   42	72	267	java/lang/Exception
    //   72	86	267	java/lang/Exception
    //   87	101	267	java/lang/Exception
    //   105	113	267	java/lang/Exception
    //   113	120	267	java/lang/Exception
    //   120	206	267	java/lang/Exception
    //   206	266	267	java/lang/Exception
    //   113	120	281	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.recovery.d.a
 * JD-Core Version:    0.7.0.1
 */