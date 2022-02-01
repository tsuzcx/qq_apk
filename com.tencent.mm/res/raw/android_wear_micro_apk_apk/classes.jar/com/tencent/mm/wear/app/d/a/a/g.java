package com.tencent.mm.wear.app.d.a.a;

import com.tencent.mm.wear.app.b.h;
import java.io.File;

public final class g
{
  /* Error */
  private static boolean Q(java.lang.String paramString)
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
    //   124: invokestatic 54	com/tencent/mm/wear/a/c/d:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  private static boolean R(java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 24
    //   2: ldc 58
    //   4: aload_0
    //   5: invokestatic 62	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   8: invokevirtual 66	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 54	com/tencent/mm/wear/a/c/d:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: new 12	java/io/RandomAccessFile
    //   21: dup
    //   22: aload_0
    //   23: ldc 14
    //   25: invokespecial 18	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: astore_3
    //   29: aload_3
    //   30: astore_0
    //   31: bipush 9
    //   33: newarray byte
    //   35: astore 4
    //   37: aload_3
    //   38: astore_0
    //   39: aload_3
    //   40: lconst_1
    //   41: invokevirtual 70	java/io/RandomAccessFile:seek	(J)V
    //   44: aload_3
    //   45: astore_0
    //   46: aload_3
    //   47: aload 4
    //   49: iconst_0
    //   50: bipush 9
    //   52: invokevirtual 22	java/io/RandomAccessFile:read	([BII)I
    //   55: istore_1
    //   56: iload_1
    //   57: iconst_m1
    //   58: if_icmpne +18 -> 76
    //   61: aload_3
    //   62: invokevirtual 36	java/io/RandomAccessFile:close	()V
    //   65: iconst_0
    //   66: ireturn
    //   67: astore_0
    //   68: ldc 24
    //   70: aload_0
    //   71: invokestatic 39	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   74: iconst_0
    //   75: ireturn
    //   76: aload_3
    //   77: astore_0
    //   78: new 41	java/lang/String
    //   81: dup
    //   82: aload 4
    //   84: invokespecial 44	java/lang/String:<init>	([B)V
    //   87: ldc 72
    //   89: invokevirtual 49	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   92: istore_2
    //   93: iload_2
    //   94: ifeq +19 -> 113
    //   97: aload_3
    //   98: invokevirtual 36	java/io/RandomAccessFile:close	()V
    //   101: iconst_1
    //   102: ireturn
    //   103: astore_0
    //   104: ldc 24
    //   106: aload_0
    //   107: invokestatic 39	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   110: goto -9 -> 101
    //   113: aload_3
    //   114: invokevirtual 36	java/io/RandomAccessFile:close	()V
    //   117: iconst_0
    //   118: ireturn
    //   119: astore_0
    //   120: ldc 24
    //   122: aload_0
    //   123: invokestatic 39	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   126: iconst_0
    //   127: ireturn
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_3
    //   131: aload_3
    //   132: astore_0
    //   133: ldc 24
    //   135: ldc 74
    //   137: iconst_0
    //   138: anewarray 4	java/lang/Object
    //   141: invokestatic 54	com/tencent/mm/wear/a/c/d:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: aload_3
    //   145: ifnull -80 -> 65
    //   148: aload_3
    //   149: invokevirtual 36	java/io/RandomAccessFile:close	()V
    //   152: iconst_0
    //   153: ireturn
    //   154: astore_0
    //   155: ldc 24
    //   157: aload_0
    //   158: invokestatic 39	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   161: iconst_0
    //   162: ireturn
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_0
    //   166: aload_0
    //   167: ifnull +7 -> 174
    //   170: aload_0
    //   171: invokevirtual 36	java/io/RandomAccessFile:close	()V
    //   174: aload_3
    //   175: athrow
    //   176: astore_0
    //   177: ldc 24
    //   179: aload_0
    //   180: invokestatic 39	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   183: goto -9 -> 174
    //   186: astore_3
    //   187: goto -21 -> 166
    //   190: astore_0
    //   191: goto -60 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramString	java.lang.String
    //   55	4	1	i	int
    //   92	2	2	bool	boolean
    //   28	121	3	localRandomAccessFile	java.io.RandomAccessFile
    //   163	12	3	localObject1	Object
    //   186	1	3	localObject2	Object
    //   35	48	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   61	65	67	java/io/IOException
    //   97	101	103	java/io/IOException
    //   113	117	119	java/io/IOException
    //   18	29	128	java/lang/Exception
    //   148	152	154	java/io/IOException
    //   18	29	163	finally
    //   170	174	176	java/io/IOException
    //   31	37	186	finally
    //   39	44	186	finally
    //   46	56	186	finally
    //   78	93	186	finally
    //   133	144	186	finally
    //   31	37	190	java/lang/Exception
    //   39	44	190	java/lang/Exception
    //   46	56	190	java/lang/Exception
    //   78	93	190	java/lang/Exception
  }
  
  public static boolean i(long paramLong)
  {
    return Q(new File(h.mU(), paramLong + ".amr").getAbsolutePath());
  }
  
  public static boolean j(long paramLong)
  {
    return R(new File(h.mU(), paramLong + ".amr").getAbsolutePath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a.a.g
 * JD-Core Version:    0.7.0.1
 */