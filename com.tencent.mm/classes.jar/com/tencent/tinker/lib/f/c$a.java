package com.tencent.tinker.lib.f;

public final class c$a
{
  public String bIW;
  public String wWS;
  
  public c$a(String paramString1, String paramString2)
  {
    this.bIW = paramString1;
    this.wWS = paramString2;
  }
  
  /* Error */
  public static void a(java.io.File paramFile, a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: invokevirtual 29	java/io/File:getParentFile	()Ljava/io/File;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 33	java/io/File:exists	()Z
    //   14: ifne +8 -> 22
    //   17: aload_2
    //   18: invokevirtual 36	java/io/File:mkdirs	()Z
    //   21: pop
    //   22: new 38	java/util/Properties
    //   25: dup
    //   26: invokespecial 39	java/util/Properties:<init>	()V
    //   29: astore_2
    //   30: aload_2
    //   31: ldc 41
    //   33: aload_1
    //   34: getfield 17	com/tencent/tinker/lib/f/c$a:bIW	Ljava/lang/String;
    //   37: invokevirtual 45	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: pop
    //   41: aload_2
    //   42: ldc 47
    //   44: aload_1
    //   45: getfield 19	com/tencent/tinker/lib/f/c$a:wWS	Ljava/lang/String;
    //   48: invokevirtual 45	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: pop
    //   52: new 49	java/io/FileOutputStream
    //   55: dup
    //   56: aload_0
    //   57: iconst_0
    //   58: invokespecial 52	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   61: astore_1
    //   62: aload_1
    //   63: astore_0
    //   64: aload_2
    //   65: aload_1
    //   66: aconst_null
    //   67: invokevirtual 56	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   70: aload_1
    //   71: invokestatic 62	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   74: return
    //   75: astore_2
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: astore_0
    //   80: ldc 64
    //   82: aload_2
    //   83: ldc 66
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 72	com/tencent/tinker/lib/f/a:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: aload_1
    //   93: invokestatic 62	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   96: return
    //   97: astore_1
    //   98: aconst_null
    //   99: astore_0
    //   100: aload_0
    //   101: invokestatic 62	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   104: aload_1
    //   105: athrow
    //   106: astore_1
    //   107: goto -7 -> 100
    //   110: astore_2
    //   111: goto -33 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramFile	java.io.File
    //   0	114	1	parama	a
    //   9	56	2	localObject	Object
    //   75	8	2	localException1	java.lang.Exception
    //   110	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   52	62	75	java/lang/Exception
    //   52	62	97	finally
    //   64	70	106	finally
    //   80	92	106	finally
    //   64	70	110	java/lang/Exception
  }
  
  /* Error */
  public static a ab(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 38	java/util/Properties
    //   6: dup
    //   7: invokespecial 39	java/util/Properties:<init>	()V
    //   10: astore_2
    //   11: new 78	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 81	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore_3
    //   20: aload_3
    //   21: astore_1
    //   22: aload_2
    //   23: aload_3
    //   24: invokevirtual 85	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   27: aload_3
    //   28: astore_1
    //   29: aload_2
    //   30: ldc 41
    //   32: invokevirtual 89	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_0
    //   36: aload_3
    //   37: astore_1
    //   38: aload_2
    //   39: ldc 47
    //   41: invokevirtual 89	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore_2
    //   45: aload_2
    //   46: astore_1
    //   47: aload_3
    //   48: invokestatic 62	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   51: new 2	com/tencent/tinker/lib/f/c$a
    //   54: dup
    //   55: aload_0
    //   56: aload_1
    //   57: invokespecial 91	com/tencent/tinker/lib/f/c$a:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: areturn
    //   61: astore_2
    //   62: aconst_null
    //   63: astore_3
    //   64: aconst_null
    //   65: astore_0
    //   66: aload_3
    //   67: astore_1
    //   68: ldc 64
    //   70: new 93	java/lang/StringBuilder
    //   73: dup
    //   74: ldc 95
    //   76: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   79: aload_2
    //   80: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 110	com/tencent/tinker/lib/f/a:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aload_3
    //   94: invokestatic 62	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   97: aload 4
    //   99: astore_1
    //   100: goto -49 -> 51
    //   103: astore_0
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: invokestatic 62	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   110: aload_0
    //   111: athrow
    //   112: astore_0
    //   113: goto -7 -> 106
    //   116: astore_2
    //   117: aconst_null
    //   118: astore_0
    //   119: goto -53 -> 66
    //   122: astore_2
    //   123: goto -57 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramFile	java.io.File
    //   21	86	1	localObject1	Object
    //   10	36	2	localObject2	Object
    //   61	19	2	localIOException1	java.io.IOException
    //   116	1	2	localIOException2	java.io.IOException
    //   122	1	2	localIOException3	java.io.IOException
    //   19	75	3	localFileInputStream	java.io.FileInputStream
    //   1	97	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	20	61	java/io/IOException
    //   11	20	103	finally
    //   22	27	112	finally
    //   29	36	112	finally
    //   38	45	112	finally
    //   68	93	112	finally
    //   22	27	116	java/io/IOException
    //   29	36	116	java/io/IOException
    //   38	45	122	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tinker.lib.f.c.a
 * JD-Core Version:    0.7.0.1
 */