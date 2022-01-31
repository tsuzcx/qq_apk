package com.tencent.mm.plugin.normsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$c
{
  static boolean bXx()
  {
    AppMethodBeat.i(10368);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append(d.Wd("Þä¦Ê¡ã¡"));
      String str1;
      return false;
    }
    finally
    {
      String str2 = localStringBuilder.toString();
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append((c.class.hashCode() >>> 31 | 0x1) ^ 0x1);
      if (!localStringBuilder.toString().equals(a.fF(str2, localStringBuilder.toString())))
      {
        AppMethodBeat.o(10368);
        return true;
      }
      AppMethodBeat.o(10368);
    }
    return false;
  }
  
  /* Error */
  public static int bXy()
  {
    // Byte code:
    //   0: sipush 10369
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 22	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc 69
    //   17: invokestatic 31	com/tencent/mm/plugin/normsg/b/d:Wd	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: ldc 2
    //   26: invokevirtual 50	java/lang/Object:hashCode	()I
    //   29: bipush 31
    //   31: iushr
    //   32: iconst_1
    //   33: ior
    //   34: istore_0
    //   35: aload_3
    //   36: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore_2
    //   40: iload_0
    //   41: ifeq +70 -> 111
    //   44: ldc 2
    //   46: invokevirtual 50	java/lang/Object:hashCode	()I
    //   49: istore_1
    //   50: iload_1
    //   51: bipush 31
    //   53: iushr
    //   54: iconst_1
    //   55: ior
    //   56: iconst_1
    //   57: ixor
    //   58: istore_0
    //   59: aload_3
    //   60: iconst_0
    //   61: aload_3
    //   62: invokevirtual 43	java/lang/StringBuilder:length	()I
    //   65: invokevirtual 47	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_3
    //   70: iload_0
    //   71: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_2
    //   76: aload_3
    //   77: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 57	com/tencent/mm/plugin/normsg/b/a:fF	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   83: iload_0
    //   84: invokestatic 75	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   87: istore_0
    //   88: sipush 10369
    //   91: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: iload_0
    //   95: ireturn
    //   96: astore_2
    //   97: aload_3
    //   98: iload_0
    //   99: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: sipush 10369
    //   106: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_2
    //   110: athrow
    //   111: sipush 10369
    //   114: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: iload_0
    //   118: ireturn
    //   119: astore_2
    //   120: ldc 2
    //   122: invokevirtual 50	java/lang/Object:hashCode	()I
    //   125: bipush 31
    //   127: iushr
    //   128: iconst_1
    //   129: ior
    //   130: istore_0
    //   131: aload_3
    //   132: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: astore_2
    //   136: iload_0
    //   137: ifeq +70 -> 207
    //   140: ldc 2
    //   142: invokevirtual 50	java/lang/Object:hashCode	()I
    //   145: istore_1
    //   146: iload_1
    //   147: bipush 31
    //   149: iushr
    //   150: iconst_1
    //   151: ior
    //   152: iconst_1
    //   153: ixor
    //   154: istore_0
    //   155: aload_3
    //   156: iconst_0
    //   157: aload_3
    //   158: invokevirtual 43	java/lang/StringBuilder:length	()I
    //   161: invokevirtual 47	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_3
    //   166: iload_0
    //   167: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_2
    //   172: aload_3
    //   173: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 57	com/tencent/mm/plugin/normsg/b/a:fF	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   179: iload_0
    //   180: invokestatic 75	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   183: istore_0
    //   184: sipush 10369
    //   187: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: iload_0
    //   191: ireturn
    //   192: astore_2
    //   193: aload_3
    //   194: iload_0
    //   195: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: sipush 10369
    //   202: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aload_2
    //   206: athrow
    //   207: sipush 10369
    //   210: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: iload_0
    //   214: ireturn
    //   215: astore_2
    //   216: goto -23 -> 193
    //   219: astore_2
    //   220: goto -123 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	180	0	i	int
    //   49	101	1	j	int
    //   39	37	2	str1	String
    //   96	14	2	localObject1	Object
    //   119	1	2	localObject2	Object
    //   135	37	2	str2	String
    //   192	14	2	localObject3	Object
    //   215	1	2	localObject4	Object
    //   219	1	2	localObject5	Object
    //   13	181	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   44	50	96	finally
    //   14	24	119	finally
    //   140	146	192	finally
    //   155	165	215	finally
    //   59	69	219	finally
  }
  
  static boolean bXz()
  {
    AppMethodBeat.i(10370);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append(d.Wd("Àú¿ÑÄ"));
      String str1;
      return false;
    }
    finally
    {
      String str2 = localStringBuilder.toString();
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append((c.class.hashCode() >>> 31 | 0x1) ^ 0x1);
      if (!localStringBuilder.toString().equals(a.fF(str2, localStringBuilder.toString())))
      {
        AppMethodBeat.o(10370);
        return true;
      }
      AppMethodBeat.o(10370);
    }
    return false;
  }
  
  public static boolean isEnabled()
  {
    AppMethodBeat.i(10367);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append(d.Wd("Úà¯ßºÔ"));
      String str1;
      return false;
    }
    finally
    {
      String str2 = localStringBuilder.toString();
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append((c.class.hashCode() >>> 31 | 0x1) ^ 0x1);
      if (!localStringBuilder.toString().equals(a.fF(str2, localStringBuilder.toString())))
      {
        AppMethodBeat.o(10367);
        return true;
      }
      AppMethodBeat.o(10367);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.a.c
 * JD-Core Version:    0.7.0.1
 */