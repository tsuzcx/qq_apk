public class aabe
{
  private static StringBuilder a = new StringBuilder(512);
  
  /* Error */
  public static java.lang.String a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 26	java/io/BufferedReader
    //   5: dup
    //   6: new 28	java/io/InputStreamReader
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 31	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   14: invokespecial 34	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   17: astore_0
    //   18: getstatic 16	aabe:a	Ljava/lang/StringBuilder;
    //   21: iconst_0
    //   22: getstatic 16	aabe:a	Ljava/lang/StringBuilder;
    //   25: invokevirtual 38	java/lang/StringBuilder:length	()I
    //   28: invokevirtual 42	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_0
    //   33: invokevirtual 46	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: astore_1
    //   37: aload_1
    //   38: ifnull +41 -> 79
    //   41: getstatic 16	aabe:a	Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 52
    //   50: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: goto -22 -> 32
    //   57: astore_1
    //   58: aload_0
    //   59: ifnull +7 -> 66
    //   62: aload_0
    //   63: invokevirtual 55	java/io/BufferedReader:close	()V
    //   66: getstatic 16	aabe:a	Ljava/lang/StringBuilder;
    //   69: ifnull +54 -> 123
    //   72: getstatic 16	aabe:a	Ljava/lang/StringBuilder;
    //   75: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: areturn
    //   79: aload_0
    //   80: ifnull -14 -> 66
    //   83: aload_0
    //   84: invokevirtual 55	java/io/BufferedReader:close	()V
    //   87: goto -21 -> 66
    //   90: astore_0
    //   91: goto -25 -> 66
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_0
    //   97: aload_0
    //   98: ifnull -32 -> 66
    //   101: aload_0
    //   102: invokevirtual 55	java/io/BufferedReader:close	()V
    //   105: goto -39 -> 66
    //   108: astore_0
    //   109: goto -43 -> 66
    //   112: astore_0
    //   113: aload_1
    //   114: ifnull +7 -> 121
    //   117: aload_1
    //   118: invokevirtual 55	java/io/BufferedReader:close	()V
    //   121: aload_0
    //   122: athrow
    //   123: ldc 60
    //   125: areturn
    //   126: astore_0
    //   127: goto -61 -> 66
    //   130: astore_1
    //   131: goto -10 -> 121
    //   134: astore_2
    //   135: aload_0
    //   136: astore_1
    //   137: aload_2
    //   138: astore_0
    //   139: goto -26 -> 113
    //   142: astore_1
    //   143: goto -46 -> 97
    //   146: astore_0
    //   147: aconst_null
    //   148: astore_0
    //   149: goto -91 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramInputStream	java.io.InputStream
    //   1	44	1	str	java.lang.String
    //   57	61	1	localException	java.lang.Exception
    //   130	1	1	localIOException	java.io.IOException
    //   136	1	1	localInputStream	java.io.InputStream
    //   142	1	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   134	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	32	57	java/lang/Exception
    //   32	37	57	java/lang/Exception
    //   41	54	57	java/lang/Exception
    //   83	87	90	java/io/IOException
    //   2	18	94	java/lang/OutOfMemoryError
    //   101	105	108	java/io/IOException
    //   2	18	112	finally
    //   62	66	126	java/io/IOException
    //   117	121	130	java/io/IOException
    //   18	32	134	finally
    //   32	37	134	finally
    //   41	54	134	finally
    //   18	32	142	java/lang/OutOfMemoryError
    //   32	37	142	java/lang/OutOfMemoryError
    //   41	54	142	java/lang/OutOfMemoryError
    //   2	18	146	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aabe
 * JD-Core Version:    0.7.0.1
 */