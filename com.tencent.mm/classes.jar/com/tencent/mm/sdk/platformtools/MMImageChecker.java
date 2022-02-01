package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.InputStream;

public final class MMImageChecker
{
  private static final IImageChecker[] sCheckers;
  
  static
  {
    AppMethodBeat.i(261489);
    sCheckers = new IImageChecker[] { new BmpBadAllocChecker(104857600) };
    AppMethodBeat.o(261489);
  }
  
  private MMImageChecker()
  {
    AppMethodBeat.i(261488);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(261488);
    throw localUnsupportedOperationException;
  }
  
  public static boolean isLegalImage(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(261486);
    if ((paramFileDescriptor == null) || (!paramFileDescriptor.valid()))
    {
      AppMethodBeat.o(261486);
      return false;
    }
    IImageChecker[] arrayOfIImageChecker = sCheckers;
    int j = arrayOfIImageChecker.length;
    int i = 0;
    while (i < j)
    {
      if (!arrayOfIImageChecker[i].isLegalImage(paramFileDescriptor))
      {
        AppMethodBeat.o(261486);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(261486);
    return true;
  }
  
  public static boolean isLegalImage(InputStream paramInputStream)
  {
    AppMethodBeat.i(261481);
    if (paramInputStream == null)
    {
      AppMethodBeat.o(261481);
      return false;
    }
    IImageChecker[] arrayOfIImageChecker = sCheckers;
    int j = arrayOfIImageChecker.length;
    int i = 0;
    while (i < j)
    {
      if (!arrayOfIImageChecker[i].isLegalImage(paramInputStream))
      {
        AppMethodBeat.o(261481);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(261481);
    return true;
  }
  
  public static boolean isLegalImage(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(261484);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(261484);
      return false;
    }
    IImageChecker[] arrayOfIImageChecker = sCheckers;
    int j = arrayOfIImageChecker.length;
    int i = 0;
    while (i < j)
    {
      if (!arrayOfIImageChecker[i].isLegalImage(paramArrayOfByte))
      {
        AppMethodBeat.o(261484);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(261484);
    return true;
  }
  
  static class BmpBadAllocChecker
    implements MMImageChecker.IImageChecker
  {
    private static final long BMP_SECOND_HEADER_SIZE_OFFSET = 14L;
    private static final String TAG = "MicroMsg.BmpBadAllocChecker";
    private final long mImageSizeLimit;
    
    BmpBadAllocChecker(int paramInt)
    {
      AppMethodBeat.i(262773);
      this.mImageSizeLimit = paramInt;
      AppMethodBeat.o(262773);
    }
    
    /* Error */
    private boolean isLegalImageInMarkableStream(InputStream paramInputStream)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 4
      //   3: ldc 40
      //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_1
      //   9: invokevirtual 46	java/io/InputStream:markSupported	()Z
      //   12: ifne +20 -> 32
      //   15: new 48	java/lang/IllegalArgumentException
      //   18: dup
      //   19: ldc 50
      //   21: invokespecial 53	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
      //   24: astore_1
      //   25: ldc 40
      //   27: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   30: aload_1
      //   31: athrow
      //   32: aload_1
      //   33: bipush 32
      //   35: invokevirtual 56	java/io/InputStream:mark	(I)V
      //   38: new 58	java/io/DataInputStream
      //   41: dup
      //   42: aload_1
      //   43: invokespecial 61	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
      //   46: astore 9
      //   48: aload 9
      //   50: invokevirtual 65	java/io/DataInputStream:readByte	()B
      //   53: istore_2
      //   54: aload 9
      //   56: invokevirtual 65	java/io/DataInputStream:readByte	()B
      //   59: istore_3
      //   60: iload_2
      //   61: bipush 66
      //   63: if_icmpne +9 -> 72
      //   66: iload_3
      //   67: bipush 77
      //   69: if_icmpeq +14 -> 83
      //   72: aload_1
      //   73: invokevirtual 68	java/io/InputStream:reset	()V
      //   76: ldc 40
      //   78: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   81: iconst_1
      //   82: ireturn
      //   83: aload 9
      //   85: ldc2_w 69
      //   88: invokevirtual 74	java/io/DataInputStream:skip	(J)J
      //   91: pop2
      //   92: iconst_4
      //   93: newarray byte
      //   95: astore 10
      //   97: aload 9
      //   99: aload 10
      //   101: invokevirtual 78	java/io/DataInputStream:read	([B)I
      //   104: pop
      //   105: aload 10
      //   107: iconst_3
      //   108: baload
      //   109: sipush 255
      //   112: iand
      //   113: bipush 24
      //   115: ishl
      //   116: aload 10
      //   118: iconst_2
      //   119: baload
      //   120: sipush 255
      //   123: iand
      //   124: bipush 16
      //   126: ishl
      //   127: ior
      //   128: aload 10
      //   130: iconst_1
      //   131: baload
      //   132: sipush 255
      //   135: iand
      //   136: bipush 8
      //   138: ishl
      //   139: ior
      //   140: aload 10
      //   142: iconst_0
      //   143: baload
      //   144: sipush 255
      //   147: iand
      //   148: ior
      //   149: i2l
      //   150: lstore 5
      //   152: aload_0
      //   153: getfield 31	com/tencent/mm/sdk/platformtools/MMImageChecker$BmpBadAllocChecker:mImageSizeLimit	J
      //   156: lstore 7
      //   158: lload 5
      //   160: ldc2_w 79
      //   163: land
      //   164: lload 7
      //   166: lcmp
      //   167: ifgt +15 -> 182
      //   170: aload_1
      //   171: invokevirtual 68	java/io/InputStream:reset	()V
      //   174: ldc 40
      //   176: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   179: iload 4
      //   181: ireturn
      //   182: iconst_0
      //   183: istore 4
      //   185: goto -15 -> 170
      //   188: astore 9
      //   190: ldc 17
      //   192: aload 9
      //   194: ldc 82
      //   196: iconst_0
      //   197: anewarray 4	java/lang/Object
      //   200: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   203: aload_1
      //   204: invokevirtual 68	java/io/InputStream:reset	()V
      //   207: ldc 40
      //   209: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   212: iconst_0
      //   213: ireturn
      //   214: astore 9
      //   216: aload_1
      //   217: invokevirtual 68	java/io/InputStream:reset	()V
      //   220: ldc 40
      //   222: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   225: aload 9
      //   227: athrow
      //   228: astore_1
      //   229: goto -153 -> 76
      //   232: astore_1
      //   233: goto -59 -> 174
      //   236: astore_1
      //   237: goto -30 -> 207
      //   240: astore_1
      //   241: goto -21 -> 220
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	244	0	this	BmpBadAllocChecker
      //   0	244	1	paramInputStream	InputStream
      //   53	11	2	i	int
      //   59	11	3	j	int
      //   1	183	4	bool	boolean
      //   150	9	5	l1	long
      //   156	9	7	l2	long
      //   46	52	9	localDataInputStream	java.io.DataInputStream
      //   188	5	9	localThrowable	Throwable
      //   214	12	9	localObject	Object
      //   95	46	10	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   38	60	188	java/lang/Throwable
      //   83	105	188	java/lang/Throwable
      //   152	158	188	java/lang/Throwable
      //   38	60	214	finally
      //   83	105	214	finally
      //   152	158	214	finally
      //   190	203	214	finally
      //   72	76	228	java/lang/Throwable
      //   170	174	232	java/lang/Throwable
      //   203	207	236	java/lang/Throwable
      //   216	220	240	java/lang/Throwable
    }
    
    /* Error */
    public boolean isLegalImage(FileDescriptor paramFileDescriptor)
    {
      // Byte code:
      //   0: ldc 91
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 93	java/io/BufferedInputStream
      //   8: dup
      //   9: new 95	java/io/FileInputStream
      //   12: dup
      //   13: aload_1
      //   14: invokespecial 98	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
      //   17: invokespecial 99	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   20: astore_3
      //   21: aload_3
      //   22: astore_1
      //   23: aload_0
      //   24: aload_3
      //   25: invokespecial 101	com/tencent/mm/sdk/platformtools/MMImageChecker$BmpBadAllocChecker:isLegalImageInMarkableStream	(Ljava/io/InputStream;)Z
      //   28: istore_2
      //   29: aload_3
      //   30: invokevirtual 104	java/io/InputStream:close	()V
      //   33: ldc 91
      //   35: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   38: iload_2
      //   39: ireturn
      //   40: astore 4
      //   42: aconst_null
      //   43: astore_3
      //   44: aload_3
      //   45: astore_1
      //   46: ldc 17
      //   48: aload 4
      //   50: ldc 82
      //   52: iconst_0
      //   53: anewarray 4	java/lang/Object
      //   56: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   59: aload_3
      //   60: ifnull +7 -> 67
      //   63: aload_3
      //   64: invokevirtual 104	java/io/InputStream:close	()V
      //   67: ldc 91
      //   69: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   72: iconst_0
      //   73: ireturn
      //   74: astore_3
      //   75: aconst_null
      //   76: astore_1
      //   77: aload_1
      //   78: ifnull +7 -> 85
      //   81: aload_1
      //   82: invokevirtual 104	java/io/InputStream:close	()V
      //   85: ldc 91
      //   87: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   90: aload_3
      //   91: athrow
      //   92: astore_1
      //   93: goto -60 -> 33
      //   96: astore_1
      //   97: goto -30 -> 67
      //   100: astore_1
      //   101: goto -16 -> 85
      //   104: astore_3
      //   105: goto -28 -> 77
      //   108: astore 4
      //   110: goto -66 -> 44
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	113	0	this	BmpBadAllocChecker
      //   0	113	1	paramFileDescriptor	FileDescriptor
      //   28	11	2	bool	boolean
      //   20	44	3	localBufferedInputStream	BufferedInputStream
      //   74	17	3	localObject1	Object
      //   104	1	3	localObject2	Object
      //   40	9	4	localThrowable1	Throwable
      //   108	1	4	localThrowable2	Throwable
      // Exception table:
      //   from	to	target	type
      //   5	21	40	java/lang/Throwable
      //   5	21	74	finally
      //   29	33	92	java/lang/Throwable
      //   63	67	96	java/lang/Throwable
      //   81	85	100	java/lang/Throwable
      //   23	29	104	finally
      //   46	59	104	finally
      //   23	29	108	java/lang/Throwable
    }
    
    public boolean isLegalImage(InputStream paramInputStream)
    {
      AppMethodBeat.i(262774);
      Object localObject = paramInputStream;
      if (!paramInputStream.markSupported()) {
        if (!(paramInputStream instanceof FileInputStream)) {
          break label46;
        }
      }
      label46:
      for (localObject = new FileSeekingInputStream((FileInputStream)paramInputStream);; localObject = new BufferedInputStream(paramInputStream))
      {
        boolean bool = isLegalImageInMarkableStream((InputStream)localObject);
        AppMethodBeat.o(262774);
        return bool;
      }
    }
    
    public boolean isLegalImage(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(262775);
      if (paramArrayOfByte.length < 14L)
      {
        AppMethodBeat.o(262775);
        return true;
      }
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      boolean bool = isLegalImageInMarkableStream(paramArrayOfByte);
      try
      {
        paramArrayOfByte.close();
        label41:
        AppMethodBeat.o(262775);
        return bool;
      }
      catch (Throwable paramArrayOfByte)
      {
        break label41;
      }
    }
  }
  
  static abstract interface IImageChecker
  {
    public abstract boolean isLegalImage(FileDescriptor paramFileDescriptor);
    
    public abstract boolean isLegalImage(InputStream paramInputStream);
    
    public abstract boolean isLegalImage(byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMImageChecker
 * JD-Core Version:    0.7.0.1
 */