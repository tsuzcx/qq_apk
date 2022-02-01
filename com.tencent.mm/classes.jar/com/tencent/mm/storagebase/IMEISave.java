package com.tencent.mm.storagebase;

public class IMEISave
{
  /* Error */
  public static java.util.Collection<java.lang.String> ftK()
  {
    // Byte code:
    //   0: ldc 14
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 26	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   8: astore_1
    //   9: new 28	java/util/LinkedHashSet
    //   12: dup
    //   13: invokespecial 29	java/util/LinkedHashSet:<init>	()V
    //   16: astore_3
    //   17: aload_3
    //   18: iconst_1
    //   19: invokestatic 35	com/tencent/mm/compatible/deviceinfo/q:cH	(Z)Ljava/lang/String;
    //   22: invokevirtual 39	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   25: pop
    //   26: aload_3
    //   27: iconst_0
    //   28: invokestatic 35	com/tencent/mm/compatible/deviceinfo/q:cH	(Z)Ljava/lang/String;
    //   31: invokevirtual 39	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   34: pop
    //   35: aconst_null
    //   36: astore_0
    //   37: new 41	javax/crypto/spec/SecretKeySpec
    //   40: dup
    //   41: ldc 43
    //   43: invokevirtual 49	java/lang/String:getBytes	()[B
    //   46: ldc 51
    //   48: invokespecial 54	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   51: astore_2
    //   52: ldc 51
    //   54: invokestatic 60	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   57: astore 4
    //   59: aload 4
    //   61: iconst_2
    //   62: aload_2
    //   63: invokevirtual 64	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   66: new 66	java/io/BufferedReader
    //   69: dup
    //   70: new 68	java/io/InputStreamReader
    //   73: dup
    //   74: new 70	javax/crypto/CipherInputStream
    //   77: dup
    //   78: aload_1
    //   79: ldc 72
    //   81: invokevirtual 78	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   84: aload 4
    //   86: invokespecial 81	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   89: invokespecial 84	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   92: invokespecial 87	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   95: astore_1
    //   96: aload_1
    //   97: astore_0
    //   98: aload_1
    //   99: invokevirtual 91	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   102: astore_2
    //   103: aload_2
    //   104: ifnull +47 -> 151
    //   107: aload_1
    //   108: astore_0
    //   109: aload_3
    //   110: aload_2
    //   111: invokevirtual 39	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   114: pop
    //   115: goto -19 -> 96
    //   118: astore_2
    //   119: aload_1
    //   120: astore_0
    //   121: ldc 93
    //   123: aload_2
    //   124: ldc 95
    //   126: iconst_0
    //   127: anewarray 4	java/lang/Object
    //   130: invokestatic 101	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: aload_1
    //   134: invokestatic 107	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   137: aload_3
    //   138: ldc 109
    //   140: invokevirtual 39	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   143: pop
    //   144: ldc 14
    //   146: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_3
    //   150: areturn
    //   151: aload_1
    //   152: invokestatic 107	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   155: goto -18 -> 137
    //   158: astore_2
    //   159: aload_0
    //   160: astore_1
    //   161: aload_2
    //   162: astore_0
    //   163: aload_1
    //   164: invokestatic 107	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   167: ldc 14
    //   169: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aload_0
    //   173: athrow
    //   174: astore_2
    //   175: aload_0
    //   176: astore_1
    //   177: aload_2
    //   178: astore_0
    //   179: goto -16 -> 163
    //   182: astore_2
    //   183: aconst_null
    //   184: astore_1
    //   185: goto -66 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	143	0	localObject1	Object
    //   8	177	1	localObject2	Object
    //   51	60	2	localObject3	Object
    //   118	6	2	localException1	java.lang.Exception
    //   158	4	2	localObject4	Object
    //   174	4	2	localObject5	Object
    //   182	1	2	localException2	java.lang.Exception
    //   16	134	3	localLinkedHashSet	java.util.LinkedHashSet
    //   57	28	4	localCipher	javax.crypto.Cipher
    // Exception table:
    //   from	to	target	type
    //   98	103	118	java/lang/Exception
    //   109	115	118	java/lang/Exception
    //   37	96	158	finally
    //   98	103	174	finally
    //   109	115	174	finally
    //   121	133	174	finally
    //   37	96	182	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.IMEISave
 * JD-Core Version:    0.7.0.1
 */