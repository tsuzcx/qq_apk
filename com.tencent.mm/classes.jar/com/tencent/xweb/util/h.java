package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;

public final class h
{
  /* Error */
  public static String A(File paramFile)
  {
    // Byte code:
    //   0: ldc2_w 9
    //   3: lstore_1
    //   4: ldc 11
    //   6: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokevirtual 23	java/io/File:exists	()Z
    //   13: ifne +10 -> 23
    //   16: ldc 11
    //   18: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: new 28	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 32	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_3
    //   32: ldc2_w 9
    //   35: aload_0
    //   36: invokevirtual 36	java/io/File:length	()J
    //   39: lcmp
    //   40: ifgt +25 -> 65
    //   43: aload_3
    //   44: lload_1
    //   45: l2i
    //   46: invokestatic 40	com/tencent/xweb/util/h:e	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   49: astore_0
    //   50: aload_3
    //   51: invokevirtual 44	java/io/FileInputStream:close	()V
    //   54: aload_3
    //   55: invokevirtual 44	java/io/FileInputStream:close	()V
    //   58: ldc 11
    //   60: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_0
    //   64: areturn
    //   65: aload_0
    //   66: invokevirtual 36	java/io/File:length	()J
    //   69: lstore_1
    //   70: goto -27 -> 43
    //   73: astore_0
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: ifnull +7 -> 84
    //   80: aload_0
    //   81: invokevirtual 44	java/io/FileInputStream:close	()V
    //   84: ldc 11
    //   86: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aconst_null
    //   90: areturn
    //   91: astore_3
    //   92: goto -34 -> 58
    //   95: astore_0
    //   96: goto -12 -> 84
    //   99: astore_0
    //   100: aload_3
    //   101: astore_0
    //   102: goto -26 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramFile	File
    //   3	67	1	l	long
    //   31	24	3	localFileInputStream	java.io.FileInputStream
    //   91	10	3	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   23	32	73	finally
    //   54	58	91	java/io/IOException
    //   80	84	95	java/io/IOException
    //   32	43	99	finally
    //   43	54	99	finally
    //   65	70	99	finally
  }
  
  private static String e(InputStream paramInputStream, int paramInt)
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
    finally
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
      paramString = A(paramString);
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
      finally
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
  
  public static boolean rb(String paramString1, String paramString2)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.util.h
 * JD-Core Version:    0.7.0.1
 */