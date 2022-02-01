package com.tencent.mm.wear.a.c;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;

public final class f
{
  private int amF;
  private File amG;
  private volatile File amH;
  private MappedByteBuffer amI;
  private RandomAccessFile amJ;
  private int currentIndex;
  
  public f(String paramString)
  {
    this.amG = new File(paramString);
    this.amH = new File(this.amG.getParentFile(), "temp-" + this.amG.getName());
    this.amF = 153600;
    if (!this.amG.getParentFile().exists()) {
      this.amG.getParentFile().mkdirs();
    }
    if (this.amH.exists())
    {
      a(this.amH, this.amG);
      this.amH.delete();
    }
  }
  
  /* Error */
  private static void a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: new 74	java/io/DataInputStream
    //   3: dup
    //   4: new 76	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 82	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore 5
    //   17: aload 5
    //   19: invokevirtual 86	java/io/DataInputStream:readInt	()I
    //   22: istore 4
    //   24: new 88	java/io/FileOutputStream
    //   27: dup
    //   28: aload_1
    //   29: iconst_1
    //   30: invokespecial 91	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
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
    //   68: invokevirtual 95	java/io/DataInputStream:read	([BII)I
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
    //   87: invokevirtual 99	java/io/FileOutputStream:write	([BII)V
    //   90: iload_3
    //   91: iload_2
    //   92: iadd
    //   93: istore_2
    //   94: goto +137 -> 231
    //   97: sipush 1024
    //   100: istore_3
    //   101: goto -49 -> 52
    //   104: aload 5
    //   106: invokevirtual 102	java/io/DataInputStream:close	()V
    //   109: aload_0
    //   110: invokevirtual 103	java/io/FileOutputStream:close	()V
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
    //   127: ldc 105
    //   129: aload 7
    //   131: ldc 107
    //   133: iconst_0
    //   134: anewarray 4	java/lang/Object
    //   137: invokestatic 112	com/tencent/recovery/a/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload 5
    //   142: ifnull +8 -> 150
    //   145: aload 5
    //   147: invokevirtual 102	java/io/DataInputStream:close	()V
    //   150: aload_0
    //   151: ifnull -38 -> 113
    //   154: aload_0
    //   155: invokevirtual 103	java/io/FileOutputStream:close	()V
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
    //   172: invokevirtual 102	java/io/DataInputStream:close	()V
    //   175: aload 6
    //   177: ifnull +8 -> 185
    //   180: aload 6
    //   182: invokevirtual 103	java/io/FileOutputStream:close	()V
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
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 115	com/tencent/mm/wear/a/c/f:amJ	Ljava/io/RandomAccessFile;
    //   6: ifnonnull +38 -> 44
    //   9: aload_0
    //   10: getfield 50	com/tencent/mm/wear/a/c/f:amH	Ljava/io/File;
    //   13: invokevirtual 57	java/io/File:exists	()Z
    //   16: ifne +11 -> 27
    //   19: aload_0
    //   20: getfield 50	com/tencent/mm/wear/a/c/f:amH	Ljava/io/File;
    //   23: invokevirtual 118	java/io/File:createNewFile	()Z
    //   26: pop
    //   27: aload_0
    //   28: new 120	java/io/RandomAccessFile
    //   31: dup
    //   32: aload_0
    //   33: getfield 50	com/tencent/mm/wear/a/c/f:amH	Ljava/io/File;
    //   36: ldc 122
    //   38: invokespecial 123	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   41: putfield 115	com/tencent/mm/wear/a/c/f:amJ	Ljava/io/RandomAccessFile;
    //   44: aload_0
    //   45: getfield 125	com/tencent/mm/wear/a/c/f:amI	Ljava/nio/MappedByteBuffer;
    //   48: ifnonnull +26 -> 74
    //   51: aload_0
    //   52: aload_0
    //   53: getfield 115	com/tencent/mm/wear/a/c/f:amJ	Ljava/io/RandomAccessFile;
    //   56: invokevirtual 129	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   59: getstatic 135	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   62: lconst_0
    //   63: aload_0
    //   64: getfield 53	com/tencent/mm/wear/a/c/f:amF	I
    //   67: i2l
    //   68: invokevirtual 141	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   71: putfield 125	com/tencent/mm/wear/a/c/f:amI	Ljava/nio/MappedByteBuffer;
    //   74: aload_0
    //   75: getfield 50	com/tencent/mm/wear/a/c/f:amH	Ljava/io/File;
    //   78: ifnull +12 -> 90
    //   81: aload_0
    //   82: getfield 125	com/tencent/mm/wear/a/c/f:amI	Ljava/nio/MappedByteBuffer;
    //   85: astore_3
    //   86: aload_3
    //   87: ifnonnull +6 -> 93
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: aload_0
    //   94: getfield 143	com/tencent/mm/wear/a/c/f:currentIndex	I
    //   97: aload_1
    //   98: arraylength
    //   99: iadd
    //   100: aload_0
    //   101: getfield 53	com/tencent/mm/wear/a/c/f:amF	I
    //   104: if_icmpgt +7 -> 111
    //   107: iload_2
    //   108: ifeq +104 -> 212
    //   111: aload_0
    //   112: getfield 125	com/tencent/mm/wear/a/c/f:amI	Ljava/nio/MappedByteBuffer;
    //   115: invokevirtual 149	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   118: pop
    //   119: aload_0
    //   120: getfield 115	com/tencent/mm/wear/a/c/f:amJ	Ljava/io/RandomAccessFile;
    //   123: invokevirtual 150	java/io/RandomAccessFile:close	()V
    //   126: aload_0
    //   127: getfield 50	com/tencent/mm/wear/a/c/f:amH	Ljava/io/File;
    //   130: aload_0
    //   131: getfield 25	com/tencent/mm/wear/a/c/f:amG	Ljava/io/File;
    //   134: invokestatic 64	com/tencent/mm/wear/a/c/f:a	(Ljava/io/File;Ljava/io/File;)V
    //   137: aload_0
    //   138: iconst_4
    //   139: putfield 143	com/tencent/mm/wear/a/c/f:currentIndex	I
    //   142: aload_0
    //   143: getfield 50	com/tencent/mm/wear/a/c/f:amH	Ljava/io/File;
    //   146: invokevirtual 67	java/io/File:delete	()Z
    //   149: pop
    //   150: aload_0
    //   151: getfield 50	com/tencent/mm/wear/a/c/f:amH	Ljava/io/File;
    //   154: invokevirtual 118	java/io/File:createNewFile	()Z
    //   157: pop
    //   158: aload_0
    //   159: new 120	java/io/RandomAccessFile
    //   162: dup
    //   163: aload_0
    //   164: getfield 50	com/tencent/mm/wear/a/c/f:amH	Ljava/io/File;
    //   167: ldc 122
    //   169: invokespecial 123	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   172: putfield 115	com/tencent/mm/wear/a/c/f:amJ	Ljava/io/RandomAccessFile;
    //   175: aload_0
    //   176: aload_0
    //   177: getfield 115	com/tencent/mm/wear/a/c/f:amJ	Ljava/io/RandomAccessFile;
    //   180: invokevirtual 129	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   183: getstatic 135	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   186: lconst_0
    //   187: aload_0
    //   188: getfield 53	com/tencent/mm/wear/a/c/f:amF	I
    //   191: i2l
    //   192: invokevirtual 141	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   195: putfield 125	com/tencent/mm/wear/a/c/f:amI	Ljava/nio/MappedByteBuffer;
    //   198: aload_0
    //   199: getfield 125	com/tencent/mm/wear/a/c/f:amI	Ljava/nio/MappedByteBuffer;
    //   202: aload_0
    //   203: getfield 143	com/tencent/mm/wear/a/c/f:currentIndex	I
    //   206: iconst_4
    //   207: isub
    //   208: invokevirtual 154	java/nio/MappedByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   211: pop
    //   212: aload_1
    //   213: arraylength
    //   214: iflt -124 -> 90
    //   217: aload_0
    //   218: getfield 125	com/tencent/mm/wear/a/c/f:amI	Ljava/nio/MappedByteBuffer;
    //   221: aload_0
    //   222: getfield 143	com/tencent/mm/wear/a/c/f:currentIndex	I
    //   225: invokevirtual 158	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   228: pop
    //   229: aload_0
    //   230: getfield 125	com/tencent/mm/wear/a/c/f:amI	Ljava/nio/MappedByteBuffer;
    //   233: aload_1
    //   234: invokevirtual 162	java/nio/MappedByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   237: pop
    //   238: aload_0
    //   239: getfield 125	com/tencent/mm/wear/a/c/f:amI	Ljava/nio/MappedByteBuffer;
    //   242: iconst_0
    //   243: invokevirtual 158	java/nio/MappedByteBuffer:position	(I)Ljava/nio/Buffer;
    //   246: pop
    //   247: aload_0
    //   248: aload_0
    //   249: getfield 143	com/tencent/mm/wear/a/c/f:currentIndex	I
    //   252: aload_1
    //   253: arraylength
    //   254: iadd
    //   255: putfield 143	com/tencent/mm/wear/a/c/f:currentIndex	I
    //   258: aload_0
    //   259: getfield 125	com/tencent/mm/wear/a/c/f:amI	Ljava/nio/MappedByteBuffer;
    //   262: aload_0
    //   263: getfield 143	com/tencent/mm/wear/a/c/f:currentIndex	I
    //   266: iconst_4
    //   267: isub
    //   268: invokevirtual 154	java/nio/MappedByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   271: pop
    //   272: goto -182 -> 90
    //   275: astore_1
    //   276: ldc 105
    //   278: aload_1
    //   279: ldc 164
    //   281: iconst_0
    //   282: anewarray 4	java/lang/Object
    //   285: invokestatic 112	com/tencent/recovery/a/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   288: goto -198 -> 90
    //   291: astore_1
    //   292: aload_0
    //   293: monitorexit
    //   294: aload_1
    //   295: athrow
    //   296: astore_3
    //   297: goto -171 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	f
    //   0	300	1	paramArrayOfByte	byte[]
    //   0	300	2	paramBoolean	boolean
    //   85	2	3	localMappedByteBuffer	MappedByteBuffer
    //   296	1	3	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	27	275	java/lang/Exception
    //   27	44	275	java/lang/Exception
    //   44	74	275	java/lang/Exception
    //   74	86	275	java/lang/Exception
    //   93	107	275	java/lang/Exception
    //   111	119	275	java/lang/Exception
    //   119	126	275	java/lang/Exception
    //   126	212	275	java/lang/Exception
    //   212	272	275	java/lang/Exception
    //   2	27	291	finally
    //   27	44	291	finally
    //   44	74	291	finally
    //   74	86	291	finally
    //   93	107	291	finally
    //   111	119	291	finally
    //   119	126	291	finally
    //   126	212	291	finally
    //   212	272	291	finally
    //   276	288	291	finally
    //   119	126	296	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.a.c.f
 * JD-Core Version:    0.7.0.1
 */