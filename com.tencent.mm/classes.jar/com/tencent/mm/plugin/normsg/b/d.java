package com.tencent.mm.plugin.normsg.b;

public final class d
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  /* Error */
  public static String Kd(String paramString)
  {
    // Byte code:
    //   0: new 31	java/lang/StringBuilder
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 37	java/lang/String:length	()I
    //   8: invokespecial 41	java/lang/StringBuilder:<init>	(I)V
    //   11: astore 6
    //   13: iconst_1
    //   14: istore_2
    //   15: iconst_0
    //   16: istore 4
    //   18: iload 4
    //   20: istore_3
    //   21: aload_0
    //   22: iload_2
    //   23: invokevirtual 45	java/lang/String:charAt	(I)C
    //   26: istore 5
    //   28: iload 4
    //   30: istore_3
    //   31: aload_0
    //   32: iload_2
    //   33: iconst_1
    //   34: isub
    //   35: invokevirtual 45	java/lang/String:charAt	(I)C
    //   38: iload 5
    //   40: ixor
    //   41: istore 4
    //   43: iload 4
    //   45: istore_3
    //   46: aload_0
    //   47: invokevirtual 37	java/lang/String:length	()I
    //   50: istore 5
    //   52: iload_2
    //   53: iconst_1
    //   54: iadd
    //   55: iload 5
    //   57: if_icmpne +30 -> 87
    //   60: iload 4
    //   62: i2c
    //   63: istore_1
    //   64: aload 6
    //   66: iload_1
    //   67: invokevirtual 49	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 6
    //   73: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: areturn
    //   77: astore_0
    //   78: aload_0
    //   79: athrow
    //   80: astore_0
    //   81: aload 6
    //   83: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: areturn
    //   87: iload 4
    //   89: i2c
    //   90: istore_1
    //   91: aload 6
    //   93: iload_1
    //   94: invokevirtual 49	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: iload_2
    //   99: iconst_1
    //   100: iadd
    //   101: istore_2
    //   102: goto -87 -> 15
    //   105: astore_0
    //   106: aload_0
    //   107: athrow
    //   108: astore_0
    //   109: iload_3
    //   110: i2c
    //   111: istore_1
    //   112: aload 6
    //   114: iload_1
    //   115: invokevirtual 49	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_0
    //   120: athrow
    //   121: astore_0
    //   122: aload_0
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramString	String
    //   63	52	1	c	char
    //   14	88	2	i	int
    //   20	90	3	j	int
    //   16	72	4	k	int
    //   26	32	5	m	int
    //   11	102	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   64	71	77	finally
    //   78	80	80	finally
    //   106	108	80	finally
    //   119	121	80	finally
    //   122	124	80	finally
    //   91	98	105	finally
    //   21	28	108	finally
    //   31	43	108	finally
    //   46	52	108	finally
    //   112	119	121	finally
  }
  
  public static String s(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[(paramInt2 - paramInt1) * 2];
    int i = 0;
    while (paramInt1 < paramInt2)
    {
      int j = paramArrayOfByte[paramInt1];
      int k = i + 1;
      arrayOfChar[i] = HEX_DIGITS[(j >>> 4 & 0xF)];
      i = k + 1;
      arrayOfChar[k] = HEX_DIGITS[(j & 0xF)];
      paramInt1 += 1;
    }
    return new String(arrayOfChar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.d
 * JD-Core Version:    0.7.0.1
 */