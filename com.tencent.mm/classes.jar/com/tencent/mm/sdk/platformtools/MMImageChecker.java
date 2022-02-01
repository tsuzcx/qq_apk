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
    AppMethodBeat.i(243803);
    sCheckers = new IImageChecker[] { new BmpBadAllocChecker(104857600) };
    AppMethodBeat.o(243803);
  }
  
  private MMImageChecker()
  {
    AppMethodBeat.i(243793);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(243793);
    throw localUnsupportedOperationException;
  }
  
  public static boolean isLegalImage(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(243784);
    if ((paramFileDescriptor == null) || (!paramFileDescriptor.valid()))
    {
      AppMethodBeat.o(243784);
      return false;
    }
    IImageChecker[] arrayOfIImageChecker = sCheckers;
    int j = arrayOfIImageChecker.length;
    int i = 0;
    while (i < j)
    {
      if (!arrayOfIImageChecker[i].isLegalImage(paramFileDescriptor))
      {
        AppMethodBeat.o(243784);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(243784);
    return true;
  }
  
  public static boolean isLegalImage(InputStream paramInputStream)
  {
    AppMethodBeat.i(243771);
    if (paramInputStream == null)
    {
      AppMethodBeat.o(243771);
      return false;
    }
    IImageChecker[] arrayOfIImageChecker = sCheckers;
    int j = arrayOfIImageChecker.length;
    int i = 0;
    while (i < j)
    {
      if (!arrayOfIImageChecker[i].isLegalImage(paramInputStream))
      {
        AppMethodBeat.o(243771);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(243771);
    return true;
  }
  
  public static boolean isLegalImage(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(243779);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(243779);
      return false;
    }
    IImageChecker[] arrayOfIImageChecker = sCheckers;
    int j = arrayOfIImageChecker.length;
    int i = 0;
    while (i < j)
    {
      if (!arrayOfIImageChecker[i].isLegalImage(paramArrayOfByte))
      {
        AppMethodBeat.o(243779);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(243779);
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
      AppMethodBeat.i(243483);
      this.mImageSizeLimit = paramInt;
      AppMethodBeat.o(243483);
    }
    
    /* Error */
    private boolean isLegalImageInMarkableStream(InputStream paramInputStream)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 4
      //   3: ldc 38
      //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_1
      //   9: invokevirtual 44	java/io/InputStream:markSupported	()Z
      //   12: ifne +20 -> 32
      //   15: new 46	java/lang/IllegalArgumentException
      //   18: dup
      //   19: ldc 48
      //   21: invokespecial 51	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
      //   24: astore_1
      //   25: ldc 38
      //   27: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   30: aload_1
      //   31: athrow
      //   32: aload_1
      //   33: bipush 32
      //   35: invokevirtual 54	java/io/InputStream:mark	(I)V
      //   38: new 56	java/io/DataInputStream
      //   41: dup
      //   42: aload_1
      //   43: invokespecial 59	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
      //   46: astore 9
      //   48: aload 9
      //   50: invokevirtual 63	java/io/DataInputStream:readByte	()B
      //   53: istore_2
      //   54: aload 9
      //   56: invokevirtual 63	java/io/DataInputStream:readByte	()B
      //   59: istore_3
      //   60: iload_2
      //   61: bipush 66
      //   63: if_icmpne +9 -> 72
      //   66: iload_3
      //   67: bipush 77
      //   69: if_icmpeq +14 -> 83
      //   72: aload_1
      //   73: invokevirtual 66	java/io/InputStream:reset	()V
      //   76: ldc 38
      //   78: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   81: iconst_1
      //   82: ireturn
      //   83: aload 9
      //   85: ldc2_w 67
      //   88: invokevirtual 72	java/io/DataInputStream:skip	(J)J
      //   91: pop2
      //   92: iconst_4
      //   93: newarray byte
      //   95: astore 10
      //   97: aload 9
      //   99: aload 10
      //   101: invokevirtual 76	java/io/DataInputStream:read	([B)I
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
      //   160: ldc2_w 77
      //   163: land
      //   164: lload 7
      //   166: lcmp
      //   167: ifgt +15 -> 182
      //   170: aload_1
      //   171: invokevirtual 66	java/io/InputStream:reset	()V
      //   174: ldc 38
      //   176: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   179: iload 4
      //   181: ireturn
      //   182: iconst_0
      //   183: istore 4
      //   185: goto -15 -> 170
      //   188: astore 9
      //   190: ldc 17
      //   192: aload 9
      //   194: ldc 80
      //   196: iconst_0
      //   197: anewarray 4	java/lang/Object
      //   200: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   203: aload_1
      //   204: invokevirtual 66	java/io/InputStream:reset	()V
      //   207: ldc 38
      //   209: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   212: iconst_0
      //   213: ireturn
      //   214: astore 9
      //   216: aload_1
      //   217: invokevirtual 66	java/io/InputStream:reset	()V
      //   220: ldc 38
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
      //   188	5	9	localThrowable	java.lang.Throwable
      //   214	12	9	localObject	Object
      //   95	46	10	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   38	60	188	finally
      //   83	105	188	finally
      //   152	158	188	finally
      //   190	203	214	finally
      //   72	76	228	finally
      //   170	174	232	finally
      //   203	207	236	finally
      //   216	220	240	finally
    }
    
    /* Error */
    public boolean isLegalImage(FileDescriptor paramFileDescriptor)
    {
      // Byte code:
      //   0: ldc 89
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 91	java/io/BufferedInputStream
      //   8: dup
      //   9: new 93	java/io/FileInputStream
      //   12: dup
      //   13: aload_1
      //   14: invokespecial 96	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
      //   17: invokespecial 97	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokespecial 99	com/tencent/mm/sdk/platformtools/MMImageChecker$BmpBadAllocChecker:isLegalImageInMarkableStream	(Ljava/io/InputStream;)Z
      //   26: istore_2
      //   27: aload_1
      //   28: invokevirtual 102	java/io/InputStream:close	()V
      //   31: ldc 89
      //   33: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: iload_2
      //   37: ireturn
      //   38: astore_3
      //   39: aconst_null
      //   40: astore_1
      //   41: ldc 17
      //   43: aload_3
      //   44: ldc 80
      //   46: iconst_0
      //   47: anewarray 4	java/lang/Object
      //   50: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   53: aload_1
      //   54: ifnull +7 -> 61
      //   57: aload_1
      //   58: invokevirtual 102	java/io/InputStream:close	()V
      //   61: ldc 89
      //   63: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   66: iconst_0
      //   67: ireturn
      //   68: astore_3
      //   69: aload_1
      //   70: ifnull +7 -> 77
      //   73: aload_1
      //   74: invokevirtual 102	java/io/InputStream:close	()V
      //   77: ldc 89
      //   79: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   82: aload_3
      //   83: athrow
      //   84: astore_1
      //   85: goto -54 -> 31
      //   88: astore_1
      //   89: goto -28 -> 61
      //   92: astore_1
      //   93: goto -16 -> 77
      //   96: astore_3
      //   97: goto -56 -> 41
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	100	0	this	BmpBadAllocChecker
      //   0	100	1	paramFileDescriptor	FileDescriptor
      //   26	11	2	bool	boolean
      //   38	6	3	localThrowable	java.lang.Throwable
      //   68	15	3	localObject1	Object
      //   96	1	3	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   5	21	38	finally
      //   41	53	68	finally
      //   27	31	84	finally
      //   57	61	88	finally
      //   73	77	92	finally
      //   21	27	96	finally
    }
    
    public boolean isLegalImage(InputStream paramInputStream)
    {
      AppMethodBeat.i(243496);
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
        AppMethodBeat.o(243496);
        return bool;
      }
    }
    
    public boolean isLegalImage(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(243500);
      if (paramArrayOfByte.length < 14L)
      {
        AppMethodBeat.o(243500);
        return true;
      }
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      boolean bool = isLegalImageInMarkableStream(paramArrayOfByte);
      try
      {
        paramArrayOfByte.close();
        label41:
        AppMethodBeat.o(243500);
        return bool;
      }
      finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMImageChecker
 * JD-Core Version:    0.7.0.1
 */