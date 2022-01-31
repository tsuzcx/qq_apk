package com.tencent.mm.wear.app.d.a.a;

public final class g
{
  /* Error */
  public static boolean J(java.lang.String paramString)
  {
    // Byte code:
    //   0: new 12	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc 14
    //   7: invokespecial 18	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: astore_0
    //   13: bipush 6
    //   15: newarray byte
    //   17: astore_3
    //   18: aload_2
    //   19: astore_0
    //   20: aload_2
    //   21: aload_3
    //   22: iconst_0
    //   23: bipush 6
    //   25: invokevirtual 22	java/io/RandomAccessFile:read	([BII)I
    //   28: iconst_m1
    //   29: if_icmpne +31 -> 60
    //   32: aload_2
    //   33: astore_0
    //   34: ldc 24
    //   36: ldc 26
    //   38: iconst_0
    //   39: anewarray 4	java/lang/Object
    //   42: invokestatic 32	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   45: aload_2
    //   46: invokevirtual 36	java/io/RandomAccessFile:close	()V
    //   49: iconst_0
    //   50: ireturn
    //   51: astore_0
    //   52: ldc 24
    //   54: aload_0
    //   55: invokestatic 39	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   58: iconst_0
    //   59: ireturn
    //   60: aload_2
    //   61: astore_0
    //   62: new 41	java/lang/String
    //   65: dup
    //   66: aload_3
    //   67: invokespecial 44	java/lang/String:<init>	([B)V
    //   70: ldc 46
    //   72: invokevirtual 49	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   75: istore_1
    //   76: iload_1
    //   77: ifeq +19 -> 96
    //   80: aload_2
    //   81: invokevirtual 36	java/io/RandomAccessFile:close	()V
    //   84: iconst_1
    //   85: ireturn
    //   86: astore_0
    //   87: ldc 24
    //   89: aload_0
    //   90: invokestatic 39	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   93: goto -9 -> 84
    //   96: aload_2
    //   97: invokevirtual 36	java/io/RandomAccessFile:close	()V
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_0
    //   103: ldc 24
    //   105: aload_0
    //   106: invokestatic 39	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   109: iconst_0
    //   110: ireturn
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_2
    //   114: aload_2
    //   115: astore_0
    //   116: ldc 24
    //   118: ldc 51
    //   120: iconst_0
    //   121: anewarray 4	java/lang/Object
    //   124: invokestatic 54	com/tencent/mm/wear/a/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload_2
    //   128: ifnull -79 -> 49
    //   131: aload_2
    //   132: invokevirtual 36	java/io/RandomAccessFile:close	()V
    //   135: iconst_0
    //   136: ireturn
    //   137: astore_0
    //   138: ldc 24
    //   140: aload_0
    //   141: invokestatic 39	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   144: iconst_0
    //   145: ireturn
    //   146: astore_2
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_0
    //   150: ifnull +7 -> 157
    //   153: aload_0
    //   154: invokevirtual 36	java/io/RandomAccessFile:close	()V
    //   157: aload_2
    //   158: athrow
    //   159: astore_0
    //   160: ldc 24
    //   162: aload_0
    //   163: invokestatic 39	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   166: goto -9 -> 157
    //   169: astore_2
    //   170: goto -21 -> 149
    //   173: astore_0
    //   174: goto -60 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramString	java.lang.String
    //   75	2	1	bool	boolean
    //   10	122	2	localRandomAccessFile	java.io.RandomAccessFile
    //   146	12	2	localObject1	Object
    //   169	1	2	localObject2	Object
    //   17	50	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   45	49	51	java/io/IOException
    //   80	84	86	java/io/IOException
    //   96	100	102	java/io/IOException
    //   0	11	111	java/lang/Exception
    //   131	135	137	java/io/IOException
    //   0	11	146	finally
    //   153	157	159	java/io/IOException
    //   13	18	169	finally
    //   20	32	169	finally
    //   34	45	169	finally
    //   62	76	169	finally
    //   116	127	169	finally
    //   13	18	173	java/lang/Exception
    //   20	32	173	java/lang/Exception
    //   34	45	173	java/lang/Exception
    //   62	76	173	java/lang/Exception
  }
  
  /* Error */
  public static boolean K(java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 24
    //   2: new 58	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 60
    //   8: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 54	com/tencent/mm/wear/a/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: new 12	java/io/RandomAccessFile
    //   28: dup
    //   29: aload_0
    //   30: ldc 14
    //   32: invokespecial 18	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: astore_3
    //   36: aload_3
    //   37: astore_0
    //   38: bipush 9
    //   40: newarray byte
    //   42: astore 4
    //   44: aload_3
    //   45: astore_0
    //   46: aload_3
    //   47: lconst_1
    //   48: invokevirtual 75	java/io/RandomAccessFile:seek	(J)V
    //   51: aload_3
    //   52: astore_0
    //   53: aload_3
    //   54: aload 4
    //   56: iconst_0
    //   57: bipush 9
    //   59: invokevirtual 22	java/io/RandomAccessFile:read	([BII)I
    //   62: istore_1
    //   63: iload_1
    //   64: iconst_m1
    //   65: if_icmpne +18 -> 83
    //   68: aload_3
    //   69: invokevirtual 36	java/io/RandomAccessFile:close	()V
    //   72: iconst_0
    //   73: ireturn
    //   74: astore_0
    //   75: ldc 24
    //   77: aload_0
    //   78: invokestatic 39	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   81: iconst_0
    //   82: ireturn
    //   83: aload_3
    //   84: astore_0
    //   85: new 41	java/lang/String
    //   88: dup
    //   89: aload 4
    //   91: invokespecial 44	java/lang/String:<init>	([B)V
    //   94: ldc 77
    //   96: invokevirtual 49	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   99: istore_2
    //   100: iload_2
    //   101: ifeq +19 -> 120
    //   104: aload_3
    //   105: invokevirtual 36	java/io/RandomAccessFile:close	()V
    //   108: iconst_1
    //   109: ireturn
    //   110: astore_0
    //   111: ldc 24
    //   113: aload_0
    //   114: invokestatic 39	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   117: goto -9 -> 108
    //   120: aload_3
    //   121: invokevirtual 36	java/io/RandomAccessFile:close	()V
    //   124: iconst_0
    //   125: ireturn
    //   126: astore_0
    //   127: ldc 24
    //   129: aload_0
    //   130: invokestatic 39	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   133: iconst_0
    //   134: ireturn
    //   135: astore_0
    //   136: aconst_null
    //   137: astore_3
    //   138: aload_3
    //   139: astore_0
    //   140: ldc 24
    //   142: ldc 79
    //   144: iconst_0
    //   145: anewarray 4	java/lang/Object
    //   148: invokestatic 54	com/tencent/mm/wear/a/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aload_3
    //   152: ifnull -80 -> 72
    //   155: aload_3
    //   156: invokevirtual 36	java/io/RandomAccessFile:close	()V
    //   159: iconst_0
    //   160: ireturn
    //   161: astore_0
    //   162: ldc 24
    //   164: aload_0
    //   165: invokestatic 39	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   168: iconst_0
    //   169: ireturn
    //   170: astore_3
    //   171: aconst_null
    //   172: astore_0
    //   173: aload_0
    //   174: ifnull +7 -> 181
    //   177: aload_0
    //   178: invokevirtual 36	java/io/RandomAccessFile:close	()V
    //   181: aload_3
    //   182: athrow
    //   183: astore_0
    //   184: ldc 24
    //   186: aload_0
    //   187: invokestatic 39	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   190: goto -9 -> 181
    //   193: astore_3
    //   194: goto -21 -> 173
    //   197: astore_0
    //   198: goto -60 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	paramString	java.lang.String
    //   62	4	1	i	int
    //   99	2	2	bool	boolean
    //   35	121	3	localRandomAccessFile	java.io.RandomAccessFile
    //   170	12	3	localObject1	Object
    //   193	1	3	localObject2	Object
    //   42	48	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   68	72	74	java/io/IOException
    //   104	108	110	java/io/IOException
    //   120	124	126	java/io/IOException
    //   25	36	135	java/lang/Exception
    //   155	159	161	java/io/IOException
    //   25	36	170	finally
    //   177	181	183	java/io/IOException
    //   38	44	193	finally
    //   46	51	193	finally
    //   53	63	193	finally
    //   85	100	193	finally
    //   140	151	193	finally
    //   38	44	197	java/lang/Exception
    //   46	51	197	java/lang/Exception
    //   53	63	197	java/lang/Exception
    //   85	100	197	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a.a.g
 * JD-Core Version:    0.7.0.1
 */