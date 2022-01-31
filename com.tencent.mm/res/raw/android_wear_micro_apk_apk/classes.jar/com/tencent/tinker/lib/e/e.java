package com.tencent.tinker.lib.e;

final class e
{
  String afE;
  String akq;
  
  e(String paramString1, String paramString2)
  {
    this.afE = paramString1;
    this.akq = paramString2;
  }
  
  /* Error */
  static e f(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 23	java/util/Properties
    //   6: dup
    //   7: invokespecial 24	java/util/Properties:<init>	()V
    //   10: astore_2
    //   11: new 26	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 29	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore_3
    //   20: aload_3
    //   21: astore_1
    //   22: aload_2
    //   23: aload_3
    //   24: invokevirtual 33	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   27: aload_3
    //   28: astore_1
    //   29: aload_2
    //   30: ldc 35
    //   32: invokevirtual 39	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_0
    //   36: aload_3
    //   37: astore_1
    //   38: aload_2
    //   39: ldc 41
    //   41: invokevirtual 39	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore_2
    //   45: aload_2
    //   46: astore_1
    //   47: aload_3
    //   48: invokestatic 47	com/tencent/tinker/a/a/a:R	(Ljava/lang/Object;)V
    //   51: new 2	com/tencent/tinker/lib/e/e
    //   54: dup
    //   55: aload_0
    //   56: aload_1
    //   57: invokespecial 49	com/tencent/tinker/lib/e/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: areturn
    //   61: astore_2
    //   62: aconst_null
    //   63: astore_3
    //   64: aconst_null
    //   65: astore_0
    //   66: aload_3
    //   67: astore_1
    //   68: ldc 51
    //   70: new 53	java/lang/StringBuilder
    //   73: dup
    //   74: ldc 55
    //   76: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   79: aload_2
    //   80: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 72	com/tencent/tinker/lib/e/a:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aload_3
    //   94: invokestatic 47	com/tencent/tinker/a/a/a:R	(Ljava/lang/Object;)V
    //   97: aload 4
    //   99: astore_1
    //   100: goto -49 -> 51
    //   103: astore_0
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: invokestatic 47	com/tencent/tinker/a/a/a:R	(Ljava/lang/Object;)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.e.e
 * JD-Core Version:    0.7.0.1
 */