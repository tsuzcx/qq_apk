package com.tencent.shadow.core.b.a;

import java.util.concurrent.ConcurrentHashMap;

public class i
{
  private static ConcurrentHashMap<String, Object> a = new ConcurrentHashMap();
  
  /* Error */
  public static java.io.File a(java.io.File paramFile1, java.io.File paramFile2, java.io.File paramFile3)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 27	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4: astore 5
    //   6: getstatic 16	com/tencent/shadow/core/b/a/i:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   9: aload 5
    //   11: invokevirtual 31	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: astore 4
    //   16: aload 4
    //   18: astore_3
    //   19: aload 4
    //   21: ifnonnull +21 -> 42
    //   24: new 4	java/lang/Object
    //   27: dup
    //   28: invokespecial 18	java/lang/Object:<init>	()V
    //   31: astore_3
    //   32: getstatic 16	com/tencent/shadow/core/b/a/i:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   35: aload 5
    //   37: aload_3
    //   38: invokevirtual 35	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: aload_3
    //   43: monitorenter
    //   44: aload_2
    //   45: invokevirtual 39	java/io/File:exists	()Z
    //   48: ifeq +7 -> 55
    //   51: aload_3
    //   52: monitorexit
    //   53: aload_1
    //   54: areturn
    //   55: aload_1
    //   56: invokevirtual 39	java/io/File:exists	()Z
    //   59: ifeq +56 -> 115
    //   62: aload_1
    //   63: invokevirtual 42	java/io/File:isFile	()Z
    //   66: ifne +6 -> 72
    //   69: goto +46 -> 115
    //   72: new 44	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   79: astore_0
    //   80: aload_0
    //   81: ldc 47
    //   83: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_0
    //   88: aload_1
    //   89: invokevirtual 27	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   92: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_0
    //   97: ldc 53
    //   99: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: new 55	com/tencent/shadow/core/b/a/c
    //   106: dup
    //   107: aload_0
    //   108: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokespecial 61	com/tencent/shadow/core/b/a/c:<init>	(Ljava/lang/String;)V
    //   114: athrow
    //   115: aload_1
    //   116: invokevirtual 64	java/io/File:mkdirs	()Z
    //   119: pop
    //   120: new 66	dalvik/system/DexClassLoader
    //   123: dup
    //   124: aload_0
    //   125: invokevirtual 27	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   128: aload_1
    //   129: invokevirtual 27	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   132: aconst_null
    //   133: ldc 2
    //   135: invokevirtual 72	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   138: invokespecial 75	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   141: pop
    //   142: aload_2
    //   143: invokevirtual 78	java/io/File:createNewFile	()Z
    //   146: pop
    //   147: aload_3
    //   148: monitorexit
    //   149: aload_1
    //   150: areturn
    //   151: astore_0
    //   152: new 44	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   159: astore_1
    //   160: aload_1
    //   161: ldc 80
    //   163: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_1
    //   168: aload_2
    //   169: invokevirtual 27	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   172: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: new 55	com/tencent/shadow/core/b/a/c
    //   179: dup
    //   180: aload_1
    //   181: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: aload_0
    //   185: invokespecial 83	com/tencent/shadow/core/b/a/c:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: athrow
    //   189: astore_0
    //   190: aload_3
    //   191: monitorexit
    //   192: aload_0
    //   193: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramFile1	java.io.File
    //   0	194	1	paramFile2	java.io.File
    //   0	194	2	paramFile3	java.io.File
    //   18	173	3	localObject1	Object
    //   14	6	4	localObject2	Object
    //   4	32	5	str	String
    // Exception table:
    //   from	to	target	type
    //   142	147	151	java/io/IOException
    //   44	53	189	finally
    //   55	69	189	finally
    //   72	115	189	finally
    //   115	142	189	finally
    //   142	147	189	finally
    //   147	149	189	finally
    //   152	189	189	finally
    //   190	192	189	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.b.a.i
 * JD-Core Version:    0.7.0.1
 */