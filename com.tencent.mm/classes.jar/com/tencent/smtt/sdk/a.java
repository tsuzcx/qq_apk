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
    //   4: ldc 20
    //   6: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 11	com/tencent/smtt/sdk/a:b	I
    //   12: ifle +14 -> 26
    //   15: getstatic 11	com/tencent/smtt/sdk/a:b	I
    //   18: istore_0
    //   19: ldc 20
    //   21: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iload_0
    //   25: ireturn
    //   26: new 31	java/io/BufferedReader
    //   29: dup
    //   30: new 33	java/io/FileReader
    //   33: dup
    //   34: ldc 35
    //   36: invokespecial 39	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   39: sipush 8192
    //   42: invokespecial 42	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   45: astore_3
    //   46: aload_3
    //   47: invokevirtual 46	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore 4
    //   52: iload_2
    //   53: istore_0
    //   54: aload 4
    //   56: ifnull +83 -> 139
    //   59: aload 4
    //   61: ldc 48
    //   63: invokevirtual 54	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   66: istore_0
    //   67: iconst_m1
    //   68: iload_0
    //   69: if_icmpeq -23 -> 46
    //   72: aload 4
    //   74: iload_0
    //   75: bipush 9
    //   77: iadd
    //   78: invokevirtual 58	java/lang/String:substring	(I)Ljava/lang/String;
    //   81: invokevirtual 61	java/lang/String:trim	()Ljava/lang/String;
    //   84: astore 4
    //   86: iload_2
    //   87: istore_0
    //   88: aload 4
    //   90: ifnull +49 -> 139
    //   93: iload_2
    //   94: istore_0
    //   95: aload 4
    //   97: invokevirtual 64	java/lang/String:length	()I
    //   100: ifeq +39 -> 139
    //   103: iload_2
    //   104: istore_0
    //   105: aload 4
    //   107: ldc 66
    //   109: invokevirtual 70	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   112: ifeq +27 -> 139
    //   115: aload 4
    //   117: iconst_0
    //   118: aload 4
    //   120: ldc 66
    //   122: invokevirtual 54	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   125: invokevirtual 73	java/lang/String:substring	(II)Ljava/lang/String;
    //   128: invokevirtual 61	java/lang/String:trim	()Ljava/lang/String;
    //   131: invokestatic 78	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   134: sipush 1024
    //   137: idiv
    //   138: istore_0
    //   139: aload_3
    //   140: invokevirtual 81	java/io/BufferedReader:close	()V
    //   143: iload_0
    //   144: putstatic 11	com/tencent/smtt/sdk/a:b	I
    //   147: ldc 20
    //   149: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   164: invokevirtual 81	java/io/BufferedReader:close	()V
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
    //   188: invokevirtual 81	java/io/BufferedReader:close	()V
    //   191: iload_1
    //   192: istore_0
    //   193: goto -50 -> 143
    //   196: astore_3
    //   197: iload_1
    //   198: istore_0
    //   199: goto -56 -> 143
    //   202: astore 4
    //   204: aconst_null
    //   205: astore_3
    //   206: aload_3
    //   207: ifnull +7 -> 214
    //   210: aload_3
    //   211: invokevirtual 81	java/io/BufferedReader:close	()V
    //   214: ldc 20
    //   216: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload 4
    //   221: athrow
    //   222: astore_3
    //   223: goto -80 -> 143
    //   226: astore_3
    //   227: goto -13 -> 214
    //   230: astore 4
    //   232: goto -26 -> 206
    //   235: astore 4
    //   237: goto -56 -> 181
    //   240: astore 4
    //   242: goto -85 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	181	0	i	int
    //   1	197	1	j	int
    //   3	101	2	k	int
    //   45	95	3	localBufferedReader	java.io.BufferedReader
    //   154	1	3	localIOException1	java.io.IOException
    //   156	8	3	localObject1	Object
    //   172	1	3	localIOException2	java.io.IOException
    //   178	1	3	localThrowable1	java.lang.Throwable
    //   180	8	3	localObject2	Object
    //   196	1	3	localIOException3	java.io.IOException
    //   205	6	3	localObject3	Object
    //   222	1	3	localIOException4	java.io.IOException
    //   226	1	3	localIOException5	java.io.IOException
    //   50	69	4	str	java.lang.String
    //   202	18	4	localObject4	Object
    //   230	1	4	localObject5	Object
    //   235	1	4	localThrowable2	java.lang.Throwable
    //   240	1	4	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   26	46	154	java/io/IOException
    //   163	167	172	java/io/IOException
    //   26	46	178	java/lang/Throwable
    //   187	191	196	java/io/IOException
    //   26	46	202	finally
    //   139	143	222	java/io/IOException
    //   210	214	226	java/io/IOException
    //   46	52	230	finally
    //   59	67	230	finally
    //   72	86	230	finally
    //   95	103	230	finally
    //   105	139	230	finally
    //   46	52	235	java/lang/Throwable
    //   59	67	235	java/lang/Throwable
    //   72	86	235	java/lang/Throwable
    //   95	103	235	java/lang/Throwable
    //   105	139	235	java/lang/Throwable
    //   46	52	240	java/io/IOException
    //   59	67	240	java/io/IOException
    //   72	86	240	java/io/IOException
    //   95	103	240	java/io/IOException
    //   105	139	240	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.a
 * JD-Core Version:    0.7.0.1
 */