package com.tencent.xweb.util;

import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;

public final class c
{
  private static String b(InputStream paramInputStream, int paramInt)
  {
    int i = 0;
    if (paramInt <= 0) {
      return null;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      StringBuilder localStringBuilder = new StringBuilder(32);
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
      paramInt = i;
      while (paramInt < paramInputStream.length)
      {
        localStringBuilder.append(Integer.toString((paramInputStream[paramInt] & 0xFF) + 256, 16).substring(1));
        paramInt += 1;
      }
      paramInputStream = localStringBuilder.toString();
      return paramInputStream;
    }
    catch (Exception paramInputStream) {}
    return null;
  }
  
  public static String bQ(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = new File(paramString);
    } while (!paramString.exists());
    return m(paramString);
  }
  
  public static boolean gR(String paramString1, String paramString2)
  {
    paramString1 = bQ(paramString1);
    return (paramString1 != null) && (paramString2 != null) && (paramString2.equalsIgnoreCase(paramString1));
  }
  
  private static String l(InputStream paramInputStream)
  {
    int j = 0;
    try
    {
      if (paramInputStream.skip(0L) < 0L) {
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
      return paramInputStream;
    }
    catch (Exception paramInputStream) {}
    return null;
  }
  
  /* Error */
  public static String m(File paramFile)
  {
    // Byte code:
    //   0: ldc2_w 89
    //   3: lstore_1
    //   4: aload_0
    //   5: invokevirtual 67	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 92	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: astore_3
    //   22: ldc2_w 89
    //   25: aload_0
    //   26: invokevirtual 99	java/io/File:length	()J
    //   29: lcmp
    //   30: ifgt +20 -> 50
    //   33: aload_3
    //   34: lload_1
    //   35: l2i
    //   36: invokestatic 101	com/tencent/xweb/util/c:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   39: astore_0
    //   40: aload_3
    //   41: invokevirtual 105	java/io/FileInputStream:close	()V
    //   44: aload_3
    //   45: invokevirtual 105	java/io/FileInputStream:close	()V
    //   48: aload_0
    //   49: areturn
    //   50: aload_0
    //   51: invokevirtual 99	java/io/File:length	()J
    //   54: lstore_1
    //   55: goto -22 -> 33
    //   58: astore_0
    //   59: aconst_null
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull -51 -> 11
    //   65: aload_0
    //   66: invokevirtual 105	java/io/FileInputStream:close	()V
    //   69: aconst_null
    //   70: areturn
    //   71: astore_0
    //   72: aconst_null
    //   73: areturn
    //   74: astore_0
    //   75: aconst_null
    //   76: astore_3
    //   77: aload_3
    //   78: ifnull +7 -> 85
    //   81: aload_3
    //   82: invokevirtual 105	java/io/FileInputStream:close	()V
    //   85: aload_0
    //   86: athrow
    //   87: astore_3
    //   88: goto -40 -> 48
    //   91: astore_3
    //   92: goto -7 -> 85
    //   95: astore_0
    //   96: goto -19 -> 77
    //   99: astore_0
    //   100: aload_3
    //   101: astore_0
    //   102: goto -41 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramFile	File
    //   3	52	1	l	long
    //   21	61	3	localFileInputStream	java.io.FileInputStream
    //   87	1	3	localIOException1	java.io.IOException
    //   91	10	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   13	22	58	java/lang/Exception
    //   65	69	71	java/io/IOException
    //   13	22	74	finally
    //   44	48	87	java/io/IOException
    //   81	85	91	java/io/IOException
    //   22	33	95	finally
    //   33	44	95	finally
    //   50	55	95	finally
    //   22	33	99	java/lang/Exception
    //   33	44	99	java/lang/Exception
    //   50	55	99	java/lang/Exception
  }
  
  /* Error */
  public static String n(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 67	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 92	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore_0
    //   18: aload_0
    //   19: invokestatic 108	com/tencent/xweb/util/c:l	(Ljava/io/InputStream;)Ljava/lang/String;
    //   22: astore_1
    //   23: aload_0
    //   24: invokevirtual 105	java/io/FileInputStream:close	()V
    //   27: aload_0
    //   28: invokevirtual 105	java/io/FileInputStream:close	()V
    //   31: aload_1
    //   32: areturn
    //   33: astore_0
    //   34: aconst_null
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull -30 -> 7
    //   40: aload_0
    //   41: invokevirtual 105	java/io/FileInputStream:close	()V
    //   44: aconst_null
    //   45: areturn
    //   46: astore_0
    //   47: aconst_null
    //   48: areturn
    //   49: astore_1
    //   50: aconst_null
    //   51: astore_0
    //   52: aload_0
    //   53: ifnull +7 -> 60
    //   56: aload_0
    //   57: invokevirtual 105	java/io/FileInputStream:close	()V
    //   60: aload_1
    //   61: athrow
    //   62: astore_0
    //   63: goto -32 -> 31
    //   66: astore_0
    //   67: goto -7 -> 60
    //   70: astore_1
    //   71: goto -19 -> 52
    //   74: astore_1
    //   75: goto -39 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramFile	File
    //   22	10	1	str	String
    //   49	12	1	localObject1	Object
    //   70	1	1	localObject2	Object
    //   74	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	18	33	java/lang/Exception
    //   40	44	46	java/io/IOException
    //   9	18	49	finally
    //   27	31	62	java/io/IOException
    //   56	60	66	java/io/IOException
    //   18	27	70	finally
    //   18	27	74	java/lang/Exception
  }
  
  public static final String o(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp8_6 = arrayOfChar;
    tmp8_6[0] = 48;
    char[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 49;
    char[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 50;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 51;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 52;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 53;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 54;
    char[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 55;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 56;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 57;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 97;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 98;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 99;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 100;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 101;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 102;
    tmp92_86;
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
        return null;
      }
      paramArrayOfByte = new String((char[])localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.util.c
 * JD-Core Version:    0.7.0.1
 */