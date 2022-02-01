package com.tencent.smtt.sdk;

public class a
{
  public static int a = 600;
  private static int b = 0;
  
  /* Error */
  public static int a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_2
    //   4: ldc 18
    //   6: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 11	com/tencent/smtt/sdk/a:b	I
    //   12: ifle +14 -> 26
    //   15: getstatic 11	com/tencent/smtt/sdk/a:b	I
    //   18: istore_0
    //   19: ldc 18
    //   21: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iload_0
    //   25: ireturn
    //   26: new 29	java/io/BufferedReader
    //   29: dup
    //   30: new 31	java/io/FileReader
    //   33: dup
    //   34: ldc 33
    //   36: invokespecial 37	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   39: sipush 8192
    //   42: invokespecial 40	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   45: astore_3
    //   46: aload_3
    //   47: invokevirtual 44	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore 4
    //   52: iload_2
    //   53: istore_0
    //   54: aload 4
    //   56: ifnull +83 -> 139
    //   59: aload 4
    //   61: ldc 46
    //   63: invokevirtual 52	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   66: istore_0
    //   67: iconst_m1
    //   68: iload_0
    //   69: if_icmpeq -23 -> 46
    //   72: aload 4
    //   74: iload_0
    //   75: bipush 9
    //   77: iadd
    //   78: invokevirtual 56	java/lang/String:substring	(I)Ljava/lang/String;
    //   81: invokevirtual 59	java/lang/String:trim	()Ljava/lang/String;
    //   84: astore 4
    //   86: iload_2
    //   87: istore_0
    //   88: aload 4
    //   90: ifnull +49 -> 139
    //   93: iload_2
    //   94: istore_0
    //   95: aload 4
    //   97: invokevirtual 62	java/lang/String:length	()I
    //   100: ifeq +39 -> 139
    //   103: iload_2
    //   104: istore_0
    //   105: aload 4
    //   107: ldc 64
    //   109: invokevirtual 68	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   112: ifeq +27 -> 139
    //   115: aload 4
    //   117: iconst_0
    //   118: aload 4
    //   120: ldc 64
    //   122: invokevirtual 52	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   125: invokevirtual 71	java/lang/String:substring	(II)Ljava/lang/String;
    //   128: invokevirtual 59	java/lang/String:trim	()Ljava/lang/String;
    //   131: invokestatic 76	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   134: sipush 1024
    //   137: idiv
    //   138: istore_0
    //   139: aload_3
    //   140: invokevirtual 79	java/io/BufferedReader:close	()V
    //   143: iload_0
    //   144: putstatic 11	com/tencent/smtt/sdk/a:b	I
    //   147: ldc 18
    //   149: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: iload_0
    //   153: ireturn
    //   154: astore_3
    //   155: aconst_null
    //   156: astore_3
    //   157: iload_1
    //   158: istore_0
    //   159: aload_3
    //   160: ifnull -17 -> 143
    //   163: aload_3
    //   164: invokevirtual 79	java/io/BufferedReader:close	()V
    //   167: iload_1
    //   168: istore_0
    //   169: goto -26 -> 143
    //   172: astore_3
    //   173: iload_1
    //   174: istore_0
    //   175: goto -32 -> 143
    //   178: astore_3
    //   179: aconst_null
    //   180: astore_3
    //   181: iload_1
    //   182: istore_0
    //   183: aload_3
    //   184: ifnull -41 -> 143
    //   187: aload_3
    //   188: invokevirtual 79	java/io/BufferedReader:close	()V
    //   191: iload_1
    //   192: istore_0
    //   193: goto -50 -> 143
    //   196: astore_3
    //   197: iload_1
    //   198: istore_0
    //   199: goto -56 -> 143
    //   202: astore_3
    //   203: goto -60 -> 143
    //   206: astore 4
    //   208: goto -27 -> 181
    //   211: astore 4
    //   213: goto -56 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	181	0	i	int
    //   1	197	1	j	int
    //   3	101	2	k	int
    //   45	95	3	localBufferedReader	java.io.BufferedReader
    //   154	1	3	localIOException1	java.io.IOException
    //   156	8	3	localObject1	Object
    //   172	1	3	localIOException2	java.io.IOException
    //   178	1	3	localObject2	Object
    //   180	8	3	localObject3	Object
    //   196	1	3	localIOException3	java.io.IOException
    //   202	1	3	localIOException4	java.io.IOException
    //   50	69	4	str	java.lang.String
    //   206	1	4	localObject4	Object
    //   211	1	4	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   26	46	154	java/io/IOException
    //   163	167	172	java/io/IOException
    //   26	46	178	finally
    //   187	191	196	java/io/IOException
    //   139	143	202	java/io/IOException
    //   46	52	206	finally
    //   59	67	206	finally
    //   72	86	206	finally
    //   95	103	206	finally
    //   105	139	206	finally
    //   46	52	211	java/io/IOException
    //   59	67	211	java/io/IOException
    //   72	86	211	java/io/IOException
    //   95	103	211	java/io/IOException
    //   105	139	211	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.a
 * JD-Core Version:    0.7.0.1
 */