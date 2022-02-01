package com.tencent.tbs.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class a
{
  /* Error */
  public static byte[] h(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 7
    //   5: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: invokestatic 17	com/tencent/tbs/a/a/a:oG	(Ljava/lang/String;Ljava/lang/String;)[B
    //   13: astore 5
    //   15: aload 5
    //   17: ifnull +77 -> 94
    //   20: aload_2
    //   21: arraylength
    //   22: aload 5
    //   24: arraylength
    //   25: iadd
    //   26: iconst_2
    //   27: iadd
    //   28: newarray byte
    //   30: astore_0
    //   31: aload_2
    //   32: iconst_0
    //   33: aload_0
    //   34: iconst_0
    //   35: aload_2
    //   36: arraylength
    //   37: invokestatic 23	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   40: aload_2
    //   41: arraylength
    //   42: iconst_0
    //   43: iadd
    //   44: istore_3
    //   45: aload 5
    //   47: iconst_0
    //   48: aload_0
    //   49: iload_3
    //   50: aload 5
    //   52: arraylength
    //   53: invokestatic 23	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   56: aload 5
    //   58: arraylength
    //   59: istore 4
    //   61: iconst_2
    //   62: newarray byte
    //   64: dup
    //   65: iconst_0
    //   66: ldc 24
    //   68: bastore
    //   69: dup
    //   70: iconst_1
    //   71: ldc 24
    //   73: bastore
    //   74: iconst_0
    //   75: aload_0
    //   76: iload 4
    //   78: iload_3
    //   79: iadd
    //   80: iconst_2
    //   81: invokestatic 23	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   84: ldc 7
    //   86: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: ldc 2
    //   91: monitorexit
    //   92: aload_0
    //   93: areturn
    //   94: aload_1
    //   95: invokevirtual 33	java/lang/String:getBytes	()[B
    //   98: astore_0
    //   99: ldc 7
    //   101: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: goto -15 -> 89
    //   107: astore_0
    //   108: ldc 2
    //   110: monitorexit
    //   111: aload_0
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	paramString1	String
    //   0	113	1	paramString2	String
    //   0	113	2	paramArrayOfByte	byte[]
    //   44	36	3	i	int
    //   59	21	4	j	int
    //   13	44	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   3	15	107	finally
    //   20	89	107	finally
    //   94	104	107	finally
  }
  
  private static byte[] oG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(174274);
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      AppMethodBeat.o(174274);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(174274);
    }
    return null;
  }
  
  private static byte[] oH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(174275);
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      AppMethodBeat.o(174275);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(174275);
    }
    return null;
  }
  
  public static byte[] pK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(174276);
    try
    {
      paramString1 = oH(paramString1, paramString2);
      if (paramString1 == null)
      {
        AppMethodBeat.o(174276);
        return null;
      }
      paramString2 = String.format(Locale.US, "%03d", new Object[] { Integer.valueOf(paramString1.length) });
      byte[] arrayOfByte = new byte[paramString1.length + 3];
      arrayOfByte[0] = ((byte)paramString2.charAt(0));
      arrayOfByte[1] = ((byte)paramString2.charAt(1));
      arrayOfByte[2] = ((byte)paramString2.charAt(2));
      System.arraycopy(paramString1, 0, arrayOfByte, 3, paramString1.length);
      AppMethodBeat.o(174276);
      return arrayOfByte;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(174276);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.a.a.a
 * JD-Core Version:    0.7.0.1
 */