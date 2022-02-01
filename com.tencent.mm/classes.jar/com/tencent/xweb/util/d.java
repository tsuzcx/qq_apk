package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;

public final class d
{
  /* Error */
  public static String C(File paramFile)
  {
    // Byte code:
    //   0: ldc2_w 11
    //   3: lstore_1
    //   4: ldc 13
    //   6: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokevirtual 25	java/io/File:exists	()Z
    //   13: ifne +10 -> 23
    //   16: ldc 13
    //   18: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: new 30	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 34	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_3
    //   32: ldc2_w 11
    //   35: aload_0
    //   36: invokevirtual 38	java/io/File:length	()J
    //   39: lcmp
    //   40: ifgt +25 -> 65
    //   43: aload_3
    //   44: lload_1
    //   45: l2i
    //   46: invokestatic 42	com/tencent/xweb/util/d:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   49: astore_0
    //   50: aload_3
    //   51: invokevirtual 46	java/io/FileInputStream:close	()V
    //   54: aload_3
    //   55: invokevirtual 46	java/io/FileInputStream:close	()V
    //   58: ldc 13
    //   60: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_0
    //   64: areturn
    //   65: aload_0
    //   66: invokevirtual 38	java/io/File:length	()J
    //   69: lstore_1
    //   70: goto -27 -> 43
    //   73: astore_0
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: ifnull +7 -> 84
    //   80: aload_0
    //   81: invokevirtual 46	java/io/FileInputStream:close	()V
    //   84: ldc 13
    //   86: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aconst_null
    //   90: areturn
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_3
    //   94: aload_3
    //   95: ifnull +7 -> 102
    //   98: aload_3
    //   99: invokevirtual 46	java/io/FileInputStream:close	()V
    //   102: ldc 13
    //   104: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_0
    //   108: athrow
    //   109: astore_3
    //   110: goto -52 -> 58
    //   113: astore_0
    //   114: goto -30 -> 84
    //   117: astore_3
    //   118: goto -16 -> 102
    //   121: astore_0
    //   122: goto -28 -> 94
    //   125: astore_0
    //   126: aload_3
    //   127: astore_0
    //   128: goto -52 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramFile	File
    //   3	67	1	l	long
    //   31	68	3	localFileInputStream	java.io.FileInputStream
    //   109	1	3	localIOException1	java.io.IOException
    //   117	10	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   23	32	73	java/lang/Exception
    //   23	32	91	finally
    //   54	58	109	java/io/IOException
    //   80	84	113	java/io/IOException
    //   98	102	117	java/io/IOException
    //   32	43	121	finally
    //   43	54	121	finally
    //   65	70	121	finally
    //   32	43	125	java/lang/Exception
    //   43	54	125	java/lang/Exception
    //   65	70	125	java/lang/Exception
  }
  
  /* Error */
  public static String ag(File paramFile)
  {
    // Byte code:
    //   0: ldc 49
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 25	java/io/File:exists	()Z
    //   9: ifne +10 -> 19
    //   12: ldc 49
    //   14: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: new 30	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 34	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   27: astore_0
    //   28: aload_0
    //   29: invokestatic 53	com/tencent/xweb/util/d:n	(Ljava/io/InputStream;)Ljava/lang/String;
    //   32: astore_1
    //   33: aload_0
    //   34: invokevirtual 46	java/io/FileInputStream:close	()V
    //   37: aload_0
    //   38: invokevirtual 46	java/io/FileInputStream:close	()V
    //   41: ldc 49
    //   43: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_1
    //   47: areturn
    //   48: astore_0
    //   49: aconst_null
    //   50: astore_0
    //   51: aload_0
    //   52: ifnull +7 -> 59
    //   55: aload_0
    //   56: invokevirtual 46	java/io/FileInputStream:close	()V
    //   59: ldc 49
    //   61: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aconst_null
    //   65: areturn
    //   66: astore_1
    //   67: aconst_null
    //   68: astore_0
    //   69: aload_0
    //   70: ifnull +7 -> 77
    //   73: aload_0
    //   74: invokevirtual 46	java/io/FileInputStream:close	()V
    //   77: ldc 49
    //   79: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_1
    //   83: athrow
    //   84: astore_0
    //   85: goto -44 -> 41
    //   88: astore_0
    //   89: goto -30 -> 59
    //   92: astore_0
    //   93: goto -16 -> 77
    //   96: astore_1
    //   97: goto -28 -> 69
    //   100: astore_1
    //   101: goto -50 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramFile	File
    //   32	15	1	str	String
    //   66	17	1	localObject1	Object
    //   96	1	1	localObject2	Object
    //   100	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   19	28	48	java/lang/Exception
    //   19	28	66	finally
    //   37	41	84	java/io/IOException
    //   55	59	88	java/io/IOException
    //   73	77	92	java/io/IOException
    //   28	37	96	finally
    //   28	37	100	java/lang/Exception
  }
  
  private static String b(InputStream paramInputStream, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(157004);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(157004);
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
      AppMethodBeat.o(157004);
      return null;
    }
    paramInt = i;
    while (paramInt < paramInputStream.length)
    {
      localStringBuilder.append(Integer.toString((paramInputStream[paramInt] & 0xFF) + 256, 16).substring(1));
      paramInt += 1;
    }
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(157004);
    return paramInputStream;
  }
  
  public static String getMD5(String paramString)
  {
    AppMethodBeat.i(157005);
    if (paramString == null)
    {
      AppMethodBeat.o(157005);
      return null;
    }
    paramString = new File(paramString);
    if (paramString.exists())
    {
      paramString = C(paramString);
      AppMethodBeat.o(157005);
      return paramString;
    }
    AppMethodBeat.o(157005);
    return null;
  }
  
  public static final String getMessageDigest(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(157002);
    char[] arrayOfChar = new char[16];
    char[] tmp13_11 = arrayOfChar;
    tmp13_11[0] = 48;
    char[] tmp18_13 = tmp13_11;
    tmp18_13[1] = 49;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[2] = 50;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[3] = 51;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[4] = 52;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[5] = 53;
    char[] tmp43_38 = tmp38_33;
    tmp43_38[6] = 54;
    char[] tmp49_43 = tmp43_38;
    tmp49_43[7] = 55;
    char[] tmp55_49 = tmp49_43;
    tmp55_49[8] = 56;
    char[] tmp61_55 = tmp55_49;
    tmp61_55[9] = 57;
    char[] tmp67_61 = tmp61_55;
    tmp67_61[10] = 97;
    char[] tmp73_67 = tmp67_61;
    tmp73_67[11] = 98;
    char[] tmp79_73 = tmp73_67;
    tmp79_73[12] = 99;
    char[] tmp85_79 = tmp79_73;
    tmp85_79[13] = 100;
    char[] tmp91_85 = tmp85_79;
    tmp91_85[14] = 101;
    char[] tmp97_91 = tmp91_85;
    tmp97_91[15] = 102;
    tmp97_91;
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
        AppMethodBeat.o(157002);
        return null;
      }
      paramArrayOfByte = new String((char[])localObject);
      AppMethodBeat.o(157002);
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
  
  public static boolean mJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157007);
    paramString1 = getMD5(paramString1);
    if ((paramString1 != null) && (paramString2 != null) && (paramString2.equalsIgnoreCase(paramString1)))
    {
      AppMethodBeat.o(157007);
      return true;
    }
    AppMethodBeat.o(157007);
    return false;
  }
  
  private static String n(InputStream paramInputStream)
  {
    int j = 0;
    AppMethodBeat.i(157003);
    try
    {
      long l = paramInputStream.skip(0L);
      if (l < 0L)
      {
        AppMethodBeat.o(157003);
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
      AppMethodBeat.o(157003);
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      AppMethodBeat.o(157003);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.util.d
 * JD-Core Version:    0.7.0.1
 */