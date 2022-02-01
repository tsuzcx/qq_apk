package com.tencent.shadow.core.b.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class l
{
  private final File a;
  private final String b;
  
  public l(File paramFile, String paramString)
  {
    this.a = new File(new File(paramFile, "ShadowPluginManager"), "UnpackedPlugin");
    this.a.mkdirs();
    this.b = paramString;
  }
  
  j a(File paramFile, String paramString)
  {
    paramString = new BufferedReader(new InputStreamReader(new FileInputStream(new File(paramFile, "config.json"))));
    StringBuilder localStringBuilder = new StringBuilder("");
    try
    {
      for (;;)
      {
        String str = paramString.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
        localStringBuilder.append("\n");
      }
      return j.a(localStringBuilder.toString(), paramFile);
    }
    finally
    {
      paramString.close();
    }
  }
  
  public File a()
  {
    return a.a(this.a, this.b);
  }
  
  File a(String paramString)
  {
    return a.a(this.a, this.b, paramString);
  }
  
  File a(String paramString, File paramFile)
  {
    return new File(a(paramString), paramFile.getName());
  }
  
  boolean a(File paramFile)
  {
    return b(paramFile).exists();
  }
  
  /* Error */
  public j b(String paramString, File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 5
    //   3: aload_1
    //   4: ifnonnull +9 -> 13
    //   7: aload_2
    //   8: invokestatic 106	com/tencent/shadow/core/b/a/h:a	(Ljava/io/File;)Ljava/lang/String;
    //   11: astore 5
    //   13: aload_0
    //   14: aload 5
    //   16: aload_2
    //   17: invokevirtual 108	com/tencent/shadow/core/b/a/l:a	(Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   20: astore 8
    //   22: aload 8
    //   24: invokevirtual 27	java/io/File:mkdirs	()Z
    //   27: pop
    //   28: aload_0
    //   29: aload 8
    //   31: invokevirtual 96	com/tencent/shadow/core/b/a/l:b	(Ljava/io/File;)Ljava/io/File;
    //   34: astore 7
    //   36: aload_0
    //   37: aload 8
    //   39: invokevirtual 110	com/tencent/shadow/core/b/a/l:a	(Ljava/io/File;)Z
    //   42: ifeq +62 -> 104
    //   45: aload_0
    //   46: aload 8
    //   48: aload 5
    //   50: invokevirtual 112	com/tencent/shadow/core/b/a/l:a	(Ljava/io/File;Ljava/lang/String;)Lcom/tencent/shadow/core/b/a/j;
    //   53: astore_1
    //   54: aload_1
    //   55: areturn
    //   56: aload 7
    //   58: invokevirtual 115	java/io/File:delete	()Z
    //   61: ifeq +6 -> 67
    //   64: goto +40 -> 104
    //   67: new 50	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   74: astore_1
    //   75: aload_1
    //   76: ldc 118
    //   78: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_1
    //   83: aload 7
    //   85: invokevirtual 121	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   88: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: new 123	java/io/IOException
    //   95: dup
    //   96: aload_1
    //   97: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokespecial 124	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   103: athrow
    //   104: aload 8
    //   106: invokestatic 126	com/tencent/shadow/core/b/a/h:b	(Ljava/io/File;)V
    //   109: new 128	com/tencent/shadow/core/b/a/k
    //   112: dup
    //   113: new 37	java/io/FileInputStream
    //   116: dup
    //   117: aload_2
    //   118: invokespecial 42	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   121: invokespecial 129	com/tencent/shadow/core/b/a/k:<init>	(Ljava/io/InputStream;)V
    //   124: astore 6
    //   126: aload 6
    //   128: invokevirtual 133	com/tencent/shadow/core/b/a/k:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   131: astore_1
    //   132: aload_1
    //   133: ifnull +114 -> 247
    //   136: aload_1
    //   137: invokevirtual 138	java/util/zip/ZipEntry:isDirectory	()Z
    //   140: istore 4
    //   142: iload 4
    //   144: ifne -18 -> 126
    //   147: aconst_null
    //   148: astore_2
    //   149: new 140	java/io/BufferedOutputStream
    //   152: dup
    //   153: new 142	java/io/FileOutputStream
    //   156: dup
    //   157: new 15	java/io/File
    //   160: dup
    //   161: aload 8
    //   163: aload_1
    //   164: invokevirtual 143	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   167: invokespecial 19	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   170: invokespecial 144	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   173: invokespecial 147	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   176: astore_1
    //   177: new 149	java/io/BufferedInputStream
    //   180: dup
    //   181: aload 6
    //   183: invokespecial 150	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   186: astore_2
    //   187: sipush 8192
    //   190: newarray byte
    //   192: astore 9
    //   194: aload_2
    //   195: aload 9
    //   197: iconst_0
    //   198: sipush 8192
    //   201: invokevirtual 154	java/io/BufferedInputStream:read	([BII)I
    //   204: istore_3
    //   205: iload_3
    //   206: iflt +14 -> 220
    //   209: aload_1
    //   210: aload 9
    //   212: iconst_0
    //   213: iload_3
    //   214: invokevirtual 158	java/io/BufferedOutputStream:write	([BII)V
    //   217: goto -23 -> 194
    //   220: aload 6
    //   222: invokevirtual 161	com/tencent/shadow/core/b/a/k:closeEntry	()V
    //   225: aload_1
    //   226: invokevirtual 162	java/io/BufferedOutputStream:close	()V
    //   229: goto -103 -> 126
    //   232: aload 6
    //   234: invokevirtual 161	com/tencent/shadow/core/b/a/k:closeEntry	()V
    //   237: aload_1
    //   238: ifnull +7 -> 245
    //   241: aload_1
    //   242: invokevirtual 162	java/io/BufferedOutputStream:close	()V
    //   245: aload_2
    //   246: athrow
    //   247: aload_0
    //   248: aload 8
    //   250: aload 5
    //   252: invokevirtual 112	com/tencent/shadow/core/b/a/l:a	(Ljava/io/File;Ljava/lang/String;)Lcom/tencent/shadow/core/b/a/j;
    //   255: astore_1
    //   256: aload 7
    //   258: invokevirtual 165	java/io/File:createNewFile	()Z
    //   261: pop
    //   262: aload 6
    //   264: invokevirtual 166	com/tencent/shadow/core/b/a/k:close	()V
    //   267: aload_1
    //   268: areturn
    //   269: astore_1
    //   270: aload 6
    //   272: invokevirtual 166	com/tencent/shadow/core/b/a/k:close	()V
    //   275: aload_1
    //   276: athrow
    //   277: astore_1
    //   278: goto -222 -> 56
    //   281: astore_2
    //   282: goto -50 -> 232
    //   285: astore 5
    //   287: aload_2
    //   288: astore_1
    //   289: aload 5
    //   291: astore_2
    //   292: goto -60 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	l
    //   0	295	1	paramString	String
    //   0	295	2	paramFile	File
    //   204	10	3	i	int
    //   140	3	4	bool	boolean
    //   1	250	5	str	String
    //   285	5	5	localObject	Object
    //   124	147	6	localk	k
    //   34	223	7	localFile1	File
    //   20	229	8	localFile2	File
    //   192	19	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   126	132	269	finally
    //   136	142	269	finally
    //   220	229	269	finally
    //   232	237	269	finally
    //   241	245	269	finally
    //   245	247	269	finally
    //   247	262	269	finally
    //   45	54	277	java/lang/Exception
    //   177	194	281	finally
    //   194	205	281	finally
    //   209	217	281	finally
    //   149	177	285	finally
  }
  
  File b(File paramFile)
  {
    File localFile = paramFile.getParentFile();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unpacked.");
    localStringBuilder.append(paramFile.getName());
    return new File(localFile, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.b.a.l
 * JD-Core Version:    0.7.0.1
 */