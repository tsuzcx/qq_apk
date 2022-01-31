package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;

public final class d
{
  private static String b(InputStream paramInputStream, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(4013);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(4013);
      return null;
    }
    StringBuilder localStringBuilder;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localStringBuilder = new StringBuilder(32);
      byte[] arrayOfByte = new byte[paramInt];
      for (;;)
      {
        paramInt = paramInputStream.read(arrayOfByte);
        if (paramInt == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, paramInt);
      }
      paramInputStream = localMessageDigest.digest();
    }
    catch (Exception paramInputStream)
    {
      AppMethodBeat.o(4013);
      return null;
    }
    paramInt = i;
    while (paramInt < paramInputStream.length)
    {
      localStringBuilder.append(Integer.toString((paramInputStream[paramInt] & 0xFF) + 256, 16).substring(1));
      paramInt += 1;
    }
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(4013);
    return paramInputStream;
  }
  
  public static boolean gP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4016);
    paramString1 = getMD5(paramString1);
    if ((paramString1 != null) && (paramString2 != null) && (paramString2.equalsIgnoreCase(paramString1)))
    {
      AppMethodBeat.o(4016);
      return true;
    }
    AppMethodBeat.o(4016);
    return false;
  }
  
  public static String getMD5(String paramString)
  {
    AppMethodBeat.i(4014);
    if (paramString == null)
    {
      AppMethodBeat.o(4014);
      return null;
    }
    paramString = new File(paramString);
    if (paramString.exists())
    {
      paramString = r(paramString);
      AppMethodBeat.o(4014);
      return paramString;
    }
    AppMethodBeat.o(4014);
    return null;
  }
  
  private static String n(InputStream paramInputStream)
  {
    int j = 0;
    AppMethodBeat.i(4012);
    try
    {
      long l = paramInputStream.skip(0L);
      if (l < 0L)
      {
        AppMethodBeat.o(4012);
        return null;
      }
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      StringBuilder localStringBuilder = new StringBuilder(32);
      byte[] arrayOfByte = new byte[102400];
      int i = 0;
      for (;;)
      {
        int k = paramInputStream.read(arrayOfByte);
        if ((k == -1) || (i >= 102400)) {
          break;
        }
        if (i + k <= 102400)
        {
          localMessageDigest.update(arrayOfByte, 0, k);
          i += k;
        }
        else
        {
          localMessageDigest.update(arrayOfByte, 0, 102400 - i);
          i = 102400;
        }
      }
      paramInputStream = localMessageDigest.digest();
      i = j;
      while (i < paramInputStream.length)
      {
        localStringBuilder.append(Integer.toString((paramInputStream[i] & 0xFF) + 256, 16).substring(1));
        i += 1;
      }
      paramInputStream = localStringBuilder.toString();
      AppMethodBeat.o(4012);
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      AppMethodBeat.o(4012);
    }
    return null;
  }
  
  /* Error */
  public static String r(File paramFile)
  {
    // Byte code:
    //   0: ldc2_w 97
    //   3: lstore_1
    //   4: sipush 4015
    //   7: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokevirtual 83	java/io/File:exists	()Z
    //   14: ifne +11 -> 25
    //   17: sipush 4015
    //   20: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aconst_null
    //   24: areturn
    //   25: new 100	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 103	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore_3
    //   34: ldc2_w 97
    //   37: aload_0
    //   38: invokevirtual 107	java/io/File:length	()J
    //   41: lcmp
    //   42: ifgt +26 -> 68
    //   45: aload_3
    //   46: lload_1
    //   47: l2i
    //   48: invokestatic 109	com/tencent/xweb/util/d:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   51: astore_0
    //   52: aload_3
    //   53: invokevirtual 113	java/io/FileInputStream:close	()V
    //   56: aload_3
    //   57: invokevirtual 113	java/io/FileInputStream:close	()V
    //   60: sipush 4015
    //   63: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: areturn
    //   68: aload_0
    //   69: invokevirtual 107	java/io/File:length	()J
    //   72: lstore_1
    //   73: goto -28 -> 45
    //   76: astore_0
    //   77: aconst_null
    //   78: astore_0
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 113	java/io/FileInputStream:close	()V
    //   87: sipush 4015
    //   90: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aconst_null
    //   94: areturn
    //   95: astore_0
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_3
    //   99: ifnull +7 -> 106
    //   102: aload_3
    //   103: invokevirtual 113	java/io/FileInputStream:close	()V
    //   106: sipush 4015
    //   109: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload_0
    //   113: athrow
    //   114: astore_3
    //   115: goto -55 -> 60
    //   118: astore_0
    //   119: goto -32 -> 87
    //   122: astore_3
    //   123: goto -17 -> 106
    //   126: astore_0
    //   127: goto -29 -> 98
    //   130: astore_0
    //   131: aload_3
    //   132: astore_0
    //   133: goto -54 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramFile	File
    //   3	70	1	l	long
    //   33	70	3	localFileInputStream	java.io.FileInputStream
    //   114	1	3	localIOException1	java.io.IOException
    //   122	10	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   25	34	76	java/lang/Exception
    //   25	34	95	finally
    //   56	60	114	java/io/IOException
    //   83	87	118	java/io/IOException
    //   102	106	122	java/io/IOException
    //   34	45	126	finally
    //   45	56	126	finally
    //   68	73	126	finally
    //   34	45	130	java/lang/Exception
    //   45	56	130	java/lang/Exception
    //   68	73	130	java/lang/Exception
  }
  
  /* Error */
  public static String s(File paramFile)
  {
    // Byte code:
    //   0: sipush 4017
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 83	java/io/File:exists	()Z
    //   10: ifne +11 -> 21
    //   13: sipush 4017
    //   16: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: new 100	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 103	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_0
    //   30: aload_0
    //   31: invokestatic 116	com/tencent/xweb/util/d:n	(Ljava/io/InputStream;)Ljava/lang/String;
    //   34: astore_1
    //   35: aload_0
    //   36: invokevirtual 113	java/io/FileInputStream:close	()V
    //   39: aload_0
    //   40: invokevirtual 113	java/io/FileInputStream:close	()V
    //   43: sipush 4017
    //   46: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aload_1
    //   50: areturn
    //   51: astore_0
    //   52: aconst_null
    //   53: astore_0
    //   54: aload_0
    //   55: ifnull +7 -> 62
    //   58: aload_0
    //   59: invokevirtual 113	java/io/FileInputStream:close	()V
    //   62: sipush 4017
    //   65: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aconst_null
    //   69: areturn
    //   70: astore_1
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: ifnull +7 -> 81
    //   77: aload_0
    //   78: invokevirtual 113	java/io/FileInputStream:close	()V
    //   81: sipush 4017
    //   84: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_1
    //   88: athrow
    //   89: astore_0
    //   90: goto -47 -> 43
    //   93: astore_0
    //   94: goto -32 -> 62
    //   97: astore_0
    //   98: goto -17 -> 81
    //   101: astore_1
    //   102: goto -29 -> 73
    //   105: astore_1
    //   106: goto -52 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramFile	File
    //   34	16	1	str	String
    //   70	18	1	localObject1	Object
    //   101	1	1	localObject2	Object
    //   105	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   21	30	51	java/lang/Exception
    //   21	30	70	finally
    //   39	43	89	java/io/IOException
    //   58	62	93	java/io/IOException
    //   77	81	97	java/io/IOException
    //   30	39	101	finally
    //   30	39	105	java/lang/Exception
  }
  
  public static final String w(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(4011);
    char[] arrayOfChar = new char[16];
    char[] tmp14_12 = arrayOfChar;
    tmp14_12[0] = 48;
    char[] tmp19_14 = tmp14_12;
    tmp19_14[1] = 49;
    char[] tmp24_19 = tmp19_14;
    tmp24_19[2] = 50;
    char[] tmp29_24 = tmp24_19;
    tmp29_24[3] = 51;
    char[] tmp34_29 = tmp29_24;
    tmp34_29[4] = 52;
    char[] tmp39_34 = tmp34_29;
    tmp39_34[5] = 53;
    char[] tmp44_39 = tmp39_34;
    tmp44_39[6] = 54;
    char[] tmp50_44 = tmp44_39;
    tmp50_44[7] = 55;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[8] = 56;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[9] = 57;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[10] = 97;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[11] = 98;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[12] = 99;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[13] = 100;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[14] = 101;
    char[] tmp98_92 = tmp92_86;
    tmp98_92[15] = 102;
    tmp98_92;
    for (;;)
    {
      Object localObject;
      int k;
      int i;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        k = paramArrayOfByte.length;
        localObject = new char[k * 2];
        i = 0;
        j = 0;
      }
      catch (Exception paramArrayOfByte)
      {
        AppMethodBeat.o(4011);
        return null;
      }
      paramArrayOfByte = new String((char[])localObject);
      AppMethodBeat.o(4011);
      return paramArrayOfByte;
      while (i < k)
      {
        int n = paramArrayOfByte[i];
        int m = j + 1;
        localObject[j] = arrayOfChar[(n >>> 4 & 0xF)];
        localObject[m] = arrayOfChar[(n & 0xF)];
        i += 1;
        j = m + 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.util.d
 * JD-Core Version:    0.7.0.1
 */