package com.tencent.mm.toolkit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.toolkit.a.a.a;

public final class f
  implements com.tencent.mm.toolkit.a.a.f
{
  private String VOZ;
  
  public f(String paramString)
  {
    this.VOZ = paramString;
  }
  
  /* Error */
  private static boolean i(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: ldc 23
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +154 -> 160
    //   9: aload_0
    //   10: invokevirtual 34	java/io/File:exists	()Z
    //   13: ifeq +147 -> 160
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 4
    //   22: new 36	java/io/BufferedInputStream
    //   25: dup
    //   26: new 38	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 41	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: invokespecial 44	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore_2
    //   38: new 46	java/security/DigestInputStream
    //   41: dup
    //   42: aload_2
    //   43: ldc 48
    //   45: invokestatic 54	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   48: invokespecial 57	java/security/DigestInputStream:<init>	(Ljava/io/InputStream;Ljava/security/MessageDigest;)V
    //   51: astore_3
    //   52: aload_3
    //   53: astore 4
    //   55: aload_3
    //   56: astore 5
    //   58: sipush 4096
    //   61: newarray byte
    //   63: astore_2
    //   64: aload_3
    //   65: astore 4
    //   67: aload_3
    //   68: astore 5
    //   70: aload_3
    //   71: aload_2
    //   72: invokevirtual 61	java/security/DigestInputStream:read	([B)I
    //   75: ifgt -11 -> 64
    //   78: aload_3
    //   79: astore 4
    //   81: aload_3
    //   82: astore 5
    //   84: aload_3
    //   85: invokevirtual 65	java/security/DigestInputStream:getMessageDigest	()Ljava/security/MessageDigest;
    //   88: invokevirtual 69	java/security/MessageDigest:digest	()[B
    //   91: invokestatic 75	com/tencent/mm/toolkit/a/d$a:toHexString	([B)Ljava/lang/String;
    //   94: aload_1
    //   95: invokevirtual 81	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   98: ifeq +58 -> 156
    //   101: aload_3
    //   102: astore 4
    //   104: aload_3
    //   105: astore 5
    //   107: getstatic 87	com/tencent/mm/toolkit/a/e:DEBUG	Z
    //   110: ifeq +35 -> 145
    //   113: aload_3
    //   114: astore 4
    //   116: aload_3
    //   117: astore 5
    //   119: new 89	java/lang/StringBuilder
    //   122: dup
    //   123: ldc 91
    //   125: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload_0
    //   129: invokevirtual 97	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   132: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_3
    //   137: astore 4
    //   139: aload_3
    //   140: astore 5
    //   142: invokestatic 104	com/tencent/mm/toolkit/a/e:hEQ	()V
    //   145: aload_3
    //   146: invokestatic 110	com/tencent/mm/toolkit/a/d$c:closeQuietly	(Ljava/io/Closeable;)V
    //   149: ldc 23
    //   151: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: iconst_1
    //   155: ireturn
    //   156: aload_3
    //   157: invokestatic 110	com/tencent/mm/toolkit/a/d$c:closeQuietly	(Ljava/io/Closeable;)V
    //   160: getstatic 87	com/tencent/mm/toolkit/a/e:DEBUG	Z
    //   163: ifeq +43 -> 206
    //   166: new 89	java/lang/StringBuilder
    //   169: dup
    //   170: ldc 115
    //   172: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   175: astore_2
    //   176: aload_0
    //   177: ifnull +61 -> 238
    //   180: aload_0
    //   181: invokevirtual 97	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   184: astore_0
    //   185: aload_2
    //   186: aload_0
    //   187: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc 117
    //   192: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_1
    //   196: invokestatic 121	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   199: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: invokestatic 124	com/tencent/mm/toolkit/a/e:hER	()V
    //   206: ldc 23
    //   208: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: iconst_0
    //   212: ireturn
    //   213: astore_2
    //   214: aload 4
    //   216: astore_2
    //   217: aload_2
    //   218: invokestatic 110	com/tencent/mm/toolkit/a/d$c:closeQuietly	(Ljava/io/Closeable;)V
    //   221: goto -61 -> 160
    //   224: astore_0
    //   225: aconst_null
    //   226: astore_1
    //   227: aload_1
    //   228: invokestatic 110	com/tencent/mm/toolkit/a/d$c:closeQuietly	(Ljava/io/Closeable;)V
    //   231: ldc 23
    //   233: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload_0
    //   237: athrow
    //   238: ldc 126
    //   240: astore_0
    //   241: goto -56 -> 185
    //   244: astore_0
    //   245: aload_2
    //   246: astore_1
    //   247: goto -20 -> 227
    //   250: astore_0
    //   251: aload_3
    //   252: astore_1
    //   253: goto -26 -> 227
    //   256: astore_3
    //   257: goto -40 -> 217
    //   260: astore_2
    //   261: aload 5
    //   263: astore_2
    //   264: goto -47 -> 217
    //   267: astore_3
    //   268: goto -51 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	paramFile	java.io.File
    //   0	271	1	paramString	String
    //   37	149	2	localObject1	Object
    //   213	1	2	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   216	30	2	localObject2	Object
    //   260	1	2	localIOException1	java.io.IOException
    //   263	1	2	localObject3	Object
    //   51	201	3	localDigestInputStream	java.security.DigestInputStream
    //   256	1	3	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    //   267	1	3	localIOException2	java.io.IOException
    //   20	195	4	localObject4	Object
    //   17	245	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   22	38	213	java/security/NoSuchAlgorithmException
    //   58	64	213	java/security/NoSuchAlgorithmException
    //   70	78	213	java/security/NoSuchAlgorithmException
    //   84	101	213	java/security/NoSuchAlgorithmException
    //   107	113	213	java/security/NoSuchAlgorithmException
    //   119	136	213	java/security/NoSuchAlgorithmException
    //   142	145	213	java/security/NoSuchAlgorithmException
    //   22	38	224	finally
    //   38	52	244	finally
    //   58	64	250	finally
    //   70	78	250	finally
    //   84	101	250	finally
    //   107	113	250	finally
    //   119	136	250	finally
    //   142	145	250	finally
    //   38	52	256	java/security/NoSuchAlgorithmException
    //   22	38	260	java/io/IOException
    //   58	64	260	java/io/IOException
    //   70	78	260	java/io/IOException
    //   84	101	260	java/io/IOException
    //   107	113	260	java/io/IOException
    //   119	136	260	java/io/IOException
    //   142	145	260	java/io/IOException
    //   38	52	267	java/io/IOException
  }
  
  public final void d(c paramc)
  {
    AppMethodBeat.i(220807);
    if (!i(paramc.VOH, this.VOZ))
    {
      paramc = new a(1202, "File MD5 is invalid.");
      AppMethodBeat.o(220807);
      throw paramc;
    }
    AppMethodBeat.o(220807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.f
 * JD-Core Version:    0.7.0.1
 */