package com.tencent.recovery.storage;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;

public class MMappedFileStorage
{
  private static final int DEFAULT_MAX_BUFFER_SIZE = 153600;
  private static final int HEADER_OFFSET = 4;
  private static final String TAG = "Recovery.MMappedFileStorage";
  private int currentIndex;
  private int maxTempFileLength;
  private File targetFile;
  private MappedByteBuffer tempBuffer;
  private File tempFile;
  private RandomAccessFile tempRandomAccessFile;
  
  public MMappedFileStorage(String paramString)
  {
    this.targetFile = new File(paramString);
    this.tempFile = new File(this.targetFile.getParentFile(), "temp-" + this.targetFile.getName());
    this.maxTempFileLength = 153600;
    init();
  }
  
  /* Error */
  private void copyAppendTargetFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: new 72	java/io/DataInputStream
    //   3: dup
    //   4: new 74	java/io/FileInputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 80	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore 6
    //   17: aload 6
    //   19: invokevirtual 84	java/io/DataInputStream:readInt	()I
    //   22: istore 5
    //   24: new 86	java/io/FileOutputStream
    //   27: dup
    //   28: aload_2
    //   29: iconst_1
    //   30: invokespecial 89	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   33: astore_1
    //   34: aload_1
    //   35: astore 7
    //   37: aload 6
    //   39: astore_2
    //   40: sipush 1024
    //   43: newarray byte
    //   45: astore 8
    //   47: iconst_0
    //   48: istore_3
    //   49: goto +189 -> 238
    //   52: iload 4
    //   54: ifle +57 -> 111
    //   57: aload_1
    //   58: astore 7
    //   60: aload 6
    //   62: astore_2
    //   63: aload 6
    //   65: aload 8
    //   67: iconst_0
    //   68: iload 4
    //   70: invokevirtual 93	java/io/DataInputStream:read	([BII)I
    //   73: istore 4
    //   75: iload 4
    //   77: ifle +34 -> 111
    //   80: aload_1
    //   81: astore 7
    //   83: aload 6
    //   85: astore_2
    //   86: aload_1
    //   87: aload 8
    //   89: iconst_0
    //   90: iload 4
    //   92: invokevirtual 97	java/io/FileOutputStream:write	([BII)V
    //   95: iload 4
    //   97: iload_3
    //   98: iadd
    //   99: istore_3
    //   100: goto +138 -> 238
    //   103: sipush 1024
    //   106: istore 4
    //   108: goto -56 -> 52
    //   111: aload 6
    //   113: invokevirtual 100	java/io/DataInputStream:close	()V
    //   116: aload_1
    //   117: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   120: return
    //   121: astore 8
    //   123: aconst_null
    //   124: astore_1
    //   125: aconst_null
    //   126: astore 6
    //   128: aload_1
    //   129: astore 7
    //   131: aload 6
    //   133: astore_2
    //   134: ldc 13
    //   136: aload 8
    //   138: ldc 102
    //   140: iconst_0
    //   141: anewarray 4	java/lang/Object
    //   144: invokestatic 108	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: aload 6
    //   149: ifnull +8 -> 157
    //   152: aload 6
    //   154: invokevirtual 100	java/io/DataInputStream:close	()V
    //   157: aload_1
    //   158: ifnull -38 -> 120
    //   161: aload_1
    //   162: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   165: return
    //   166: astore_1
    //   167: return
    //   168: astore_1
    //   169: aconst_null
    //   170: astore 7
    //   172: aconst_null
    //   173: astore_2
    //   174: aload_2
    //   175: ifnull +7 -> 182
    //   178: aload_2
    //   179: invokevirtual 100	java/io/DataInputStream:close	()V
    //   182: aload 7
    //   184: ifnull +8 -> 192
    //   187: aload 7
    //   189: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   192: aload_1
    //   193: athrow
    //   194: astore_2
    //   195: goto -79 -> 116
    //   198: astore_1
    //   199: return
    //   200: astore_2
    //   201: goto -44 -> 157
    //   204: astore_2
    //   205: goto -23 -> 182
    //   208: astore_2
    //   209: goto -17 -> 192
    //   212: astore_1
    //   213: aconst_null
    //   214: astore 7
    //   216: aload 6
    //   218: astore_2
    //   219: goto -45 -> 174
    //   222: astore_1
    //   223: goto -49 -> 174
    //   226: astore 8
    //   228: aconst_null
    //   229: astore_1
    //   230: goto -102 -> 128
    //   233: astore 8
    //   235: goto -107 -> 128
    //   238: iload_3
    //   239: sipush 1024
    //   242: iadd
    //   243: iload 5
    //   245: if_icmple -142 -> 103
    //   248: iload 5
    //   250: iload_3
    //   251: isub
    //   252: istore 4
    //   254: goto -202 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	MMappedFileStorage
    //   0	257	1	paramFile1	File
    //   0	257	2	paramFile2	File
    //   48	204	3	i	int
    //   52	201	4	j	int
    //   22	230	5	k	int
    //   15	202	6	localDataInputStream	java.io.DataInputStream
    //   35	180	7	localFile	File
    //   45	43	8	arrayOfByte	byte[]
    //   121	16	8	localException1	java.lang.Exception
    //   226	1	8	localException2	java.lang.Exception
    //   233	1	8	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	121	java/lang/Exception
    //   161	165	166	java/io/IOException
    //   0	17	168	finally
    //   111	116	194	java/io/IOException
    //   116	120	198	java/io/IOException
    //   152	157	200	java/io/IOException
    //   178	182	204	java/io/IOException
    //   187	192	208	java/io/IOException
    //   17	34	212	finally
    //   40	47	222	finally
    //   63	75	222	finally
    //   86	95	222	finally
    //   134	147	222	finally
    //   17	34	226	java/lang/Exception
    //   40	47	233	java/lang/Exception
    //   63	75	233	java/lang/Exception
    //   86	95	233	java/lang/Exception
  }
  
  private void init()
  {
    if (!this.targetFile.getParentFile().exists()) {
      this.targetFile.getParentFile().mkdirs();
    }
    if (this.tempFile.exists())
    {
      copyAppendTargetFile(this.tempFile, this.targetFile);
      this.tempFile.delete();
    }
  }
  
  /* Error */
  public void appendToBuffer(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 124	com/tencent/recovery/storage/MMappedFileStorage:tempRandomAccessFile	Ljava/io/RandomAccessFile;
    //   6: ifnonnull +38 -> 44
    //   9: aload_0
    //   10: getfield 58	com/tencent/recovery/storage/MMappedFileStorage:tempFile	Ljava/io/File;
    //   13: invokevirtual 112	java/io/File:exists	()Z
    //   16: ifne +11 -> 27
    //   19: aload_0
    //   20: getfield 58	com/tencent/recovery/storage/MMappedFileStorage:tempFile	Ljava/io/File;
    //   23: invokevirtual 127	java/io/File:createNewFile	()Z
    //   26: pop
    //   27: aload_0
    //   28: new 129	java/io/RandomAccessFile
    //   31: dup
    //   32: aload_0
    //   33: getfield 58	com/tencent/recovery/storage/MMappedFileStorage:tempFile	Ljava/io/File;
    //   36: ldc 131
    //   38: invokespecial 132	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   41: putfield 124	com/tencent/recovery/storage/MMappedFileStorage:tempRandomAccessFile	Ljava/io/RandomAccessFile;
    //   44: aload_0
    //   45: getfield 134	com/tencent/recovery/storage/MMappedFileStorage:tempBuffer	Ljava/nio/MappedByteBuffer;
    //   48: ifnonnull +26 -> 74
    //   51: aload_0
    //   52: aload_0
    //   53: getfield 124	com/tencent/recovery/storage/MMappedFileStorage:tempRandomAccessFile	Ljava/io/RandomAccessFile;
    //   56: invokevirtual 138	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   59: getstatic 144	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   62: lconst_0
    //   63: aload_0
    //   64: getfield 60	com/tencent/recovery/storage/MMappedFileStorage:maxTempFileLength	I
    //   67: i2l
    //   68: invokevirtual 150	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   71: putfield 134	com/tencent/recovery/storage/MMappedFileStorage:tempBuffer	Ljava/nio/MappedByteBuffer;
    //   74: aload_0
    //   75: getfield 58	com/tencent/recovery/storage/MMappedFileStorage:tempFile	Ljava/io/File;
    //   78: ifnull +12 -> 90
    //   81: aload_0
    //   82: getfield 134	com/tencent/recovery/storage/MMappedFileStorage:tempBuffer	Ljava/nio/MappedByteBuffer;
    //   85: astore_3
    //   86: aload_3
    //   87: ifnonnull +6 -> 93
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: aload_0
    //   94: getfield 152	com/tencent/recovery/storage/MMappedFileStorage:currentIndex	I
    //   97: aload_1
    //   98: arraylength
    //   99: iadd
    //   100: aload_0
    //   101: getfield 60	com/tencent/recovery/storage/MMappedFileStorage:maxTempFileLength	I
    //   104: if_icmpgt +7 -> 111
    //   107: iload_2
    //   108: ifeq +105 -> 213
    //   111: aload_0
    //   112: getfield 134	com/tencent/recovery/storage/MMappedFileStorage:tempBuffer	Ljava/nio/MappedByteBuffer;
    //   115: invokevirtual 158	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   118: pop
    //   119: aload_0
    //   120: getfield 124	com/tencent/recovery/storage/MMappedFileStorage:tempRandomAccessFile	Ljava/io/RandomAccessFile;
    //   123: invokevirtual 159	java/io/RandomAccessFile:close	()V
    //   126: aload_0
    //   127: aload_0
    //   128: getfield 58	com/tencent/recovery/storage/MMappedFileStorage:tempFile	Ljava/io/File;
    //   131: aload_0
    //   132: getfield 33	com/tencent/recovery/storage/MMappedFileStorage:targetFile	Ljava/io/File;
    //   135: invokespecial 117	com/tencent/recovery/storage/MMappedFileStorage:copyAppendTargetFile	(Ljava/io/File;Ljava/io/File;)V
    //   138: aload_0
    //   139: iconst_4
    //   140: putfield 152	com/tencent/recovery/storage/MMappedFileStorage:currentIndex	I
    //   143: aload_0
    //   144: getfield 58	com/tencent/recovery/storage/MMappedFileStorage:tempFile	Ljava/io/File;
    //   147: invokevirtual 120	java/io/File:delete	()Z
    //   150: pop
    //   151: aload_0
    //   152: getfield 58	com/tencent/recovery/storage/MMappedFileStorage:tempFile	Ljava/io/File;
    //   155: invokevirtual 127	java/io/File:createNewFile	()Z
    //   158: pop
    //   159: aload_0
    //   160: new 129	java/io/RandomAccessFile
    //   163: dup
    //   164: aload_0
    //   165: getfield 58	com/tencent/recovery/storage/MMappedFileStorage:tempFile	Ljava/io/File;
    //   168: ldc 131
    //   170: invokespecial 132	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   173: putfield 124	com/tencent/recovery/storage/MMappedFileStorage:tempRandomAccessFile	Ljava/io/RandomAccessFile;
    //   176: aload_0
    //   177: aload_0
    //   178: getfield 124	com/tencent/recovery/storage/MMappedFileStorage:tempRandomAccessFile	Ljava/io/RandomAccessFile;
    //   181: invokevirtual 138	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   184: getstatic 144	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   187: lconst_0
    //   188: aload_0
    //   189: getfield 60	com/tencent/recovery/storage/MMappedFileStorage:maxTempFileLength	I
    //   192: i2l
    //   193: invokevirtual 150	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   196: putfield 134	com/tencent/recovery/storage/MMappedFileStorage:tempBuffer	Ljava/nio/MappedByteBuffer;
    //   199: aload_0
    //   200: getfield 134	com/tencent/recovery/storage/MMappedFileStorage:tempBuffer	Ljava/nio/MappedByteBuffer;
    //   203: aload_0
    //   204: getfield 152	com/tencent/recovery/storage/MMappedFileStorage:currentIndex	I
    //   207: iconst_4
    //   208: isub
    //   209: invokevirtual 163	java/nio/MappedByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   212: pop
    //   213: aload_1
    //   214: arraylength
    //   215: iflt -125 -> 90
    //   218: aload_0
    //   219: getfield 134	com/tencent/recovery/storage/MMappedFileStorage:tempBuffer	Ljava/nio/MappedByteBuffer;
    //   222: aload_0
    //   223: getfield 152	com/tencent/recovery/storage/MMappedFileStorage:currentIndex	I
    //   226: invokevirtual 167	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   229: pop
    //   230: aload_0
    //   231: getfield 134	com/tencent/recovery/storage/MMappedFileStorage:tempBuffer	Ljava/nio/MappedByteBuffer;
    //   234: aload_1
    //   235: invokevirtual 171	java/nio/MappedByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   238: pop
    //   239: aload_0
    //   240: getfield 134	com/tencent/recovery/storage/MMappedFileStorage:tempBuffer	Ljava/nio/MappedByteBuffer;
    //   243: iconst_0
    //   244: invokevirtual 167	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   247: pop
    //   248: aload_0
    //   249: aload_0
    //   250: getfield 152	com/tencent/recovery/storage/MMappedFileStorage:currentIndex	I
    //   253: aload_1
    //   254: arraylength
    //   255: iadd
    //   256: putfield 152	com/tencent/recovery/storage/MMappedFileStorage:currentIndex	I
    //   259: aload_0
    //   260: getfield 134	com/tencent/recovery/storage/MMappedFileStorage:tempBuffer	Ljava/nio/MappedByteBuffer;
    //   263: aload_0
    //   264: getfield 152	com/tencent/recovery/storage/MMappedFileStorage:currentIndex	I
    //   267: iconst_4
    //   268: isub
    //   269: invokevirtual 163	java/nio/MappedByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   272: pop
    //   273: goto -183 -> 90
    //   276: astore_1
    //   277: ldc 13
    //   279: aload_1
    //   280: ldc 172
    //   282: iconst_0
    //   283: anewarray 4	java/lang/Object
    //   286: invokestatic 108	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: goto -199 -> 90
    //   292: astore_1
    //   293: aload_0
    //   294: monitorexit
    //   295: aload_1
    //   296: athrow
    //   297: astore_3
    //   298: goto -172 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	MMappedFileStorage
    //   0	301	1	paramArrayOfByte	byte[]
    //   0	301	2	paramBoolean	boolean
    //   85	2	3	localMappedByteBuffer	MappedByteBuffer
    //   297	1	3	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	27	276	java/lang/Exception
    //   27	44	276	java/lang/Exception
    //   44	74	276	java/lang/Exception
    //   74	86	276	java/lang/Exception
    //   93	107	276	java/lang/Exception
    //   111	119	276	java/lang/Exception
    //   119	126	276	java/lang/Exception
    //   126	213	276	java/lang/Exception
    //   213	273	276	java/lang/Exception
    //   2	27	292	finally
    //   27	44	292	finally
    //   44	74	292	finally
    //   74	86	292	finally
    //   93	107	292	finally
    //   111	119	292	finally
    //   119	126	292	finally
    //   126	213	292	finally
    //   213	273	292	finally
    //   277	289	292	finally
    //   119	126	297	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.storage.MMappedFileStorage
 * JD-Core Version:    0.7.0.1
 */