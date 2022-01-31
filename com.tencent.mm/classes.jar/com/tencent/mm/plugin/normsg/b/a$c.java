package com.tencent.mm.plugin.normsg.b;

public final class a$c
{
  static boolean boV()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append(d.Kd("Þä¦Ê¡ã¡"));
      String str1 = localStringBuilder.toString();
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append((c.class.hashCode() >>> 31 | 0x1) ^ 0x1);
      if (localStringBuilder.toString().equals(a.ek(str1, localStringBuilder.toString()))) {
        break label70;
      }
    }
    finally
    {
      String str2;
      do
      {
        str2 = localStringBuilder.toString();
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append((c.class.hashCode() >>> 31 | 0x1) ^ 0x1);
      } while (!localStringBuilder.toString().equals(a.ek(str2, localStringBuilder.toString())));
    }
    return true;
    label70:
    return false;
    return false;
  }
  
  /* Error */
  public static int boW()
  {
    // Byte code:
    //   0: new 16	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 17	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc 60
    //   11: invokestatic 25	com/tencent/mm/plugin/normsg/b/d:Kd	(Ljava/lang/String;)Ljava/lang/String;
    //   14: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: ldc 2
    //   20: invokevirtual 44	java/lang/Object:hashCode	()I
    //   23: bipush 31
    //   25: iushr
    //   26: iconst_1
    //   27: ior
    //   28: istore_1
    //   29: aload_3
    //   30: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore_2
    //   34: iload_1
    //   35: istore_0
    //   36: iload_1
    //   37: ifeq +47 -> 84
    //   40: ldc 2
    //   42: invokevirtual 44	java/lang/Object:hashCode	()I
    //   45: istore_0
    //   46: iload_0
    //   47: bipush 31
    //   49: iushr
    //   50: iconst_1
    //   51: ior
    //   52: iconst_1
    //   53: ixor
    //   54: istore_1
    //   55: aload_3
    //   56: iconst_0
    //   57: aload_3
    //   58: invokevirtual 37	java/lang/StringBuilder:length	()I
    //   61: invokevirtual 41	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_3
    //   66: iload_1
    //   67: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_2
    //   72: aload_3
    //   73: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 51	com/tencent/mm/plugin/normsg/b/a:ek	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   79: iload_1
    //   80: invokestatic 66	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   83: istore_0
    //   84: iload_0
    //   85: ireturn
    //   86: astore_2
    //   87: aload_3
    //   88: iload_1
    //   89: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_2
    //   94: athrow
    //   95: astore_2
    //   96: ldc 2
    //   98: invokevirtual 44	java/lang/Object:hashCode	()I
    //   101: bipush 31
    //   103: iushr
    //   104: iconst_1
    //   105: ior
    //   106: istore_1
    //   107: aload_3
    //   108: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: astore_2
    //   112: iload_1
    //   113: istore_0
    //   114: iload_1
    //   115: ifeq -31 -> 84
    //   118: ldc 2
    //   120: invokevirtual 44	java/lang/Object:hashCode	()I
    //   123: istore_0
    //   124: iload_0
    //   125: bipush 31
    //   127: iushr
    //   128: iconst_1
    //   129: ior
    //   130: iconst_1
    //   131: ixor
    //   132: istore_1
    //   133: aload_3
    //   134: iconst_0
    //   135: aload_3
    //   136: invokevirtual 37	java/lang/StringBuilder:length	()I
    //   139: invokevirtual 41	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_3
    //   144: iload_1
    //   145: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_2
    //   150: aload_3
    //   151: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 51	com/tencent/mm/plugin/normsg/b/a:ek	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   157: iload_1
    //   158: invokestatic 66	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   161: ireturn
    //   162: astore_2
    //   163: aload_3
    //   164: iload_1
    //   165: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_2
    //   170: athrow
    //   171: astore_2
    //   172: goto -9 -> 163
    //   175: astore_2
    //   176: goto -89 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   35	93	0	i	int
    //   28	137	1	j	int
    //   33	39	2	str1	String
    //   86	8	2	localObject1	Object
    //   95	1	2	localObject2	Object
    //   111	39	2	str2	String
    //   162	8	2	localObject3	Object
    //   171	1	2	localObject4	Object
    //   175	1	2	localObject5	Object
    //   7	157	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   40	46	86	finally
    //   8	18	95	finally
    //   118	124	162	finally
    //   133	143	171	finally
    //   55	65	175	finally
  }
  
  static boolean boX()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append(d.Kd("Àú¿ÑÄ"));
      String str1 = localStringBuilder.toString();
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append((c.class.hashCode() >>> 31 | 0x1) ^ 0x1);
      if (localStringBuilder.toString().equals(a.ek(str1, localStringBuilder.toString()))) {
        break label70;
      }
    }
    finally
    {
      String str2;
      do
      {
        str2 = localStringBuilder.toString();
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append((c.class.hashCode() >>> 31 | 0x1) ^ 0x1);
      } while (!localStringBuilder.toString().equals(a.ek(str2, localStringBuilder.toString())));
    }
    return true;
    label70:
    return false;
    return false;
  }
  
  public static boolean isEnabled()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append(d.Kd("Úà¯ßºÔ"));
      String str1 = localStringBuilder.toString();
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append((c.class.hashCode() >>> 31 | 0x1) ^ 0x1);
      if (localStringBuilder.toString().equals(a.ek(str1, localStringBuilder.toString()))) {
        break label70;
      }
    }
    finally
    {
      String str2;
      do
      {
        str2 = localStringBuilder.toString();
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append((c.class.hashCode() >>> 31 | 0x1) ^ 0x1);
      } while (!localStringBuilder.toString().equals(a.ek(str2, localStringBuilder.toString())));
    }
    return true;
    label70:
    return false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.a.c
 * JD-Core Version:    0.7.0.1
 */