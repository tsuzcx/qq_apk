package com.tencent.tinker.lib.e;

final class e
{
  String ajg;
  String anP;
  
  e(String paramString1, String paramString2)
  {
    this.ajg = paramString1;
    this.anP = paramString2;
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
    //   48: invokestatic 47	com/tencent/tinker/a/a/a:aa	(Ljava/lang/Object;)V
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
    //   70: ldc 53
    //   72: aload_2
    //   73: invokestatic 59	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   76: invokevirtual 62	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   79: iconst_0
    //   80: anewarray 4	java/lang/Object
    //   83: invokestatic 68	com/tencent/tinker/lib/e/a:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload_3
    //   87: invokestatic 47	com/tencent/tinker/a/a/a:aa	(Ljava/lang/Object;)V
    //   90: aload 4
    //   92: astore_1
    //   93: goto -42 -> 51
    //   96: astore_0
    //   97: aconst_null
    //   98: astore_1
    //   99: aload_1
    //   100: invokestatic 47	com/tencent/tinker/a/a/a:aa	(Ljava/lang/Object;)V
    //   103: aload_0
    //   104: athrow
    //   105: astore_0
    //   106: goto -7 -> 99
    //   109: astore_2
    //   110: aconst_null
    //   111: astore_0
    //   112: goto -46 -> 66
    //   115: astore_2
    //   116: goto -50 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramFile	java.io.File
    //   21	79	1	localObject1	Object
    //   10	36	2	localObject2	Object
    //   61	12	2	localIOException1	java.io.IOException
    //   109	1	2	localIOException2	java.io.IOException
    //   115	1	2	localIOException3	java.io.IOException
    //   19	68	3	localFileInputStream	java.io.FileInputStream
    //   1	90	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	20	61	java/io/IOException
    //   11	20	96	finally
    //   22	27	105	finally
    //   29	36	105	finally
    //   38	45	105	finally
    //   68	86	105	finally
    //   22	27	109	java/io/IOException
    //   29	36	109	java/io/IOException
    //   38	45	115	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.e.e
 * JD-Core Version:    0.7.0.1
 */