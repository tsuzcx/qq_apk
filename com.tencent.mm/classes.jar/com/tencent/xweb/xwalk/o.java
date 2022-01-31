package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class o
{
  private static void a(ZipOutputStream paramZipOutputStream, File paramFile, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(85415);
    if (paramFile.isDirectory())
    {
      localObject1 = paramFile.listFiles();
      int j = localObject1.length;
      if (i < j)
      {
        localObject2 = localObject1[i];
        if (localObject2 != null)
        {
          if (!((File)localObject2).isDirectory()) {
            break label100;
          }
          a(paramZipOutputStream, (File)localObject2, paramFile.getName() + File.separator + ((File)localObject2).getName() + File.separator);
        }
        for (;;)
        {
          i += 1;
          break;
          label100:
          a(paramZipOutputStream, (File)localObject2, paramString);
        }
      }
      AppMethodBeat.o(85415);
      return;
    }
    Object localObject1 = new byte[2048];
    Object localObject2 = new BufferedInputStream(new FileInputStream(paramFile));
    paramZipOutputStream.putNextEntry(new ZipEntry(paramString + paramFile.getName()));
    for (;;)
    {
      i = ((InputStream)localObject2).read((byte[])localObject1);
      if (i == -1) {
        break;
      }
      paramZipOutputStream.write((byte[])localObject1, 0, i);
    }
    ((InputStream)localObject2).close();
    AppMethodBeat.o(85415);
  }
  
  /* Error */
  public static boolean a(File[] paramArrayOfFile, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: ldc 90
    //   7: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: new 66	java/util/zip/ZipOutputStream
    //   13: dup
    //   14: new 92	java/io/BufferedOutputStream
    //   17: dup
    //   18: new 94	java/io/FileOutputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   26: invokespecial 98	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   29: invokespecial 99	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore_1
    //   33: iconst_0
    //   34: istore_2
    //   35: iload_2
    //   36: ifgt +112 -> 148
    //   39: aload_0
    //   40: iconst_0
    //   41: aaload
    //   42: astore 5
    //   44: aload 5
    //   46: ifnull +169 -> 215
    //   49: iload 4
    //   51: istore_3
    //   52: aload 5
    //   54: invokevirtual 102	java/io/File:exists	()Z
    //   57: ifeq +158 -> 215
    //   60: iload 4
    //   62: istore_3
    //   63: aload 5
    //   65: invokevirtual 19	java/io/File:isDirectory	()Z
    //   68: ifeq +39 -> 107
    //   71: iload 4
    //   73: istore_3
    //   74: aload_1
    //   75: aload 5
    //   77: new 25	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   84: aload 5
    //   86: invokevirtual 33	java/io/File:getName	()Ljava/lang/String;
    //   89: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: getstatic 41	java/io/File:separator	Ljava/lang/String;
    //   95: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 46	com/tencent/xweb/xwalk/o:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   104: goto +111 -> 215
    //   107: iload 4
    //   109: istore_3
    //   110: aload_1
    //   111: aload 5
    //   113: ldc 104
    //   115: invokestatic 46	com/tencent/xweb/xwalk/o:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   118: goto +97 -> 215
    //   121: astore_0
    //   122: iload_3
    //   123: istore 4
    //   125: aload_1
    //   126: ifnull +14 -> 140
    //   129: aload_1
    //   130: invokevirtual 107	java/util/zip/ZipOutputStream:closeEntry	()V
    //   133: aload_1
    //   134: invokevirtual 108	java/util/zip/ZipOutputStream:close	()V
    //   137: iload_3
    //   138: istore 4
    //   140: ldc 90
    //   142: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: iload 4
    //   147: ireturn
    //   148: iconst_1
    //   149: istore 4
    //   151: iconst_1
    //   152: istore_3
    //   153: aload_1
    //   154: invokevirtual 111	java/util/zip/ZipOutputStream:flush	()V
    //   157: aload_1
    //   158: invokevirtual 107	java/util/zip/ZipOutputStream:closeEntry	()V
    //   161: aload_1
    //   162: invokevirtual 108	java/util/zip/ZipOutputStream:close	()V
    //   165: goto -25 -> 140
    //   168: astore_0
    //   169: goto -29 -> 140
    //   172: astore_0
    //   173: aconst_null
    //   174: astore_1
    //   175: aload_1
    //   176: ifnull +11 -> 187
    //   179: aload_1
    //   180: invokevirtual 107	java/util/zip/ZipOutputStream:closeEntry	()V
    //   183: aload_1
    //   184: invokevirtual 108	java/util/zip/ZipOutputStream:close	()V
    //   187: ldc 90
    //   189: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aload_0
    //   193: athrow
    //   194: astore_1
    //   195: goto -8 -> 187
    //   198: astore_0
    //   199: goto -24 -> 175
    //   202: astore_0
    //   203: iload_3
    //   204: istore 4
    //   206: goto -66 -> 140
    //   209: astore_0
    //   210: aconst_null
    //   211: astore_1
    //   212: goto -90 -> 122
    //   215: iload_2
    //   216: iconst_1
    //   217: iadd
    //   218: istore_2
    //   219: goto -184 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramArrayOfFile	File[]
    //   0	222	1	paramString	String
    //   34	185	2	i	int
    //   1	203	3	bool1	boolean
    //   3	202	4	bool2	boolean
    //   42	70	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   52	60	121	java/lang/Exception
    //   63	71	121	java/lang/Exception
    //   74	104	121	java/lang/Exception
    //   110	118	121	java/lang/Exception
    //   153	157	121	java/lang/Exception
    //   157	165	168	java/io/IOException
    //   10	33	172	finally
    //   179	187	194	java/io/IOException
    //   52	60	198	finally
    //   63	71	198	finally
    //   74	104	198	finally
    //   110	118	198	finally
    //   153	157	198	finally
    //   129	137	202	java/io/IOException
    //   10	33	209	java/lang/Exception
  }
  
  /* Error */
  public static boolean jf(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_0
    //   4: istore 4
    //   6: ldc 114
    //   8: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: new 15	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore 5
    //   21: aload 5
    //   23: invokevirtual 102	java/io/File:exists	()Z
    //   26: ifne +9 -> 35
    //   29: aload 5
    //   31: invokevirtual 118	java/io/File:mkdirs	()Z
    //   34: pop
    //   35: aload_0
    //   36: ldc 120
    //   38: invokevirtual 126	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   41: ifeq +161 -> 202
    //   44: aload_0
    //   45: astore 6
    //   47: new 128	java/util/zip/ZipInputStream
    //   50: dup
    //   51: new 51	java/io/BufferedInputStream
    //   54: dup
    //   55: new 53	java/io/FileInputStream
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 129	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   63: invokespecial 59	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: invokespecial 130	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   69: astore 5
    //   71: sipush 2048
    //   74: newarray byte
    //   76: astore 8
    //   78: aload 7
    //   80: astore_0
    //   81: aload 5
    //   83: invokevirtual 134	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   86: astore_1
    //   87: aload_1
    //   88: ifnull +210 -> 298
    //   91: aload_1
    //   92: invokevirtual 135	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   95: astore 7
    //   97: aload 7
    //   99: ldc 137
    //   101: invokevirtual 141	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   104: ifne -23 -> 81
    //   107: aload 7
    //   109: ldc 143
    //   111: invokevirtual 141	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   114: ifne -33 -> 81
    //   117: aload 7
    //   119: aload 6
    //   121: invokestatic 147	com/tencent/xweb/xwalk/o:jg	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_1
    //   125: invokevirtual 148	java/util/zip/ZipEntry:isDirectory	()Z
    //   128: ifeq +98 -> 226
    //   131: new 15	java/io/File
    //   134: dup
    //   135: new 25	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   142: aload 6
    //   144: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 7
    //   149: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: invokevirtual 118	java/io/File:mkdirs	()Z
    //   161: pop
    //   162: goto -81 -> 81
    //   165: astore_1
    //   166: aload 5
    //   168: ifnull +13 -> 181
    //   171: aload 5
    //   173: invokevirtual 149	java/util/zip/ZipInputStream:closeEntry	()V
    //   176: aload 5
    //   178: invokevirtual 150	java/util/zip/ZipInputStream:close	()V
    //   181: iload 4
    //   183: istore_3
    //   184: aload_0
    //   185: ifnull +10 -> 195
    //   188: aload_0
    //   189: invokevirtual 151	java/io/BufferedOutputStream:close	()V
    //   192: iload 4
    //   194: istore_3
    //   195: ldc 114
    //   197: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: iload_3
    //   201: ireturn
    //   202: new 25	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   209: aload_0
    //   210: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: bipush 47
    //   215: invokevirtual 154	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   218: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: astore 6
    //   223: goto -176 -> 47
    //   226: new 92	java/io/BufferedOutputStream
    //   229: dup
    //   230: new 94	java/io/FileOutputStream
    //   233: dup
    //   234: new 25	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   241: aload 6
    //   243: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload 7
    //   248: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   257: invokespecial 98	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   260: astore_1
    //   261: aload 5
    //   263: aload 8
    //   265: invokevirtual 155	java/util/zip/ZipInputStream:read	([B)I
    //   268: istore_2
    //   269: iload_2
    //   270: iconst_m1
    //   271: if_icmpeq +14 -> 285
    //   274: aload_1
    //   275: aload 8
    //   277: iconst_0
    //   278: iload_2
    //   279: invokevirtual 156	java/io/BufferedOutputStream:write	([BII)V
    //   282: goto -21 -> 261
    //   285: aload_1
    //   286: invokevirtual 157	java/io/BufferedOutputStream:flush	()V
    //   289: aload_1
    //   290: invokevirtual 151	java/io/BufferedOutputStream:close	()V
    //   293: aload_1
    //   294: astore_0
    //   295: goto -214 -> 81
    //   298: iconst_1
    //   299: istore 4
    //   301: aload 5
    //   303: invokevirtual 149	java/util/zip/ZipInputStream:closeEntry	()V
    //   306: aload 5
    //   308: invokevirtual 150	java/util/zip/ZipInputStream:close	()V
    //   311: iload 4
    //   313: istore_3
    //   314: aload_0
    //   315: ifnull -120 -> 195
    //   318: aload_0
    //   319: invokevirtual 151	java/io/BufferedOutputStream:close	()V
    //   322: iload 4
    //   324: istore_3
    //   325: goto -130 -> 195
    //   328: astore_0
    //   329: iload 4
    //   331: istore_3
    //   332: goto -137 -> 195
    //   335: astore_0
    //   336: aconst_null
    //   337: astore 5
    //   339: aconst_null
    //   340: astore_1
    //   341: aload 5
    //   343: ifnull +13 -> 356
    //   346: aload 5
    //   348: invokevirtual 149	java/util/zip/ZipInputStream:closeEntry	()V
    //   351: aload 5
    //   353: invokevirtual 150	java/util/zip/ZipInputStream:close	()V
    //   356: aload_1
    //   357: ifnull +7 -> 364
    //   360: aload_1
    //   361: invokevirtual 151	java/io/BufferedOutputStream:close	()V
    //   364: ldc 114
    //   366: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   369: aload_0
    //   370: athrow
    //   371: astore_1
    //   372: goto -8 -> 364
    //   375: astore_0
    //   376: aconst_null
    //   377: astore_1
    //   378: goto -37 -> 341
    //   381: astore_0
    //   382: goto -41 -> 341
    //   385: astore 6
    //   387: aload_0
    //   388: astore_1
    //   389: aload 6
    //   391: astore_0
    //   392: goto -51 -> 341
    //   395: astore_0
    //   396: iload 4
    //   398: istore_3
    //   399: goto -204 -> 195
    //   402: astore_0
    //   403: aconst_null
    //   404: astore 5
    //   406: aconst_null
    //   407: astore_0
    //   408: goto -242 -> 166
    //   411: astore_0
    //   412: aconst_null
    //   413: astore_0
    //   414: goto -248 -> 166
    //   417: astore_0
    //   418: aload_1
    //   419: astore_0
    //   420: goto -254 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	paramString1	String
    //   0	423	1	paramString2	String
    //   268	11	2	i	int
    //   183	216	3	bool1	boolean
    //   4	393	4	bool2	boolean
    //   19	386	5	localObject1	Object
    //   45	197	6	str1	String
    //   385	5	6	localObject2	Object
    //   1	246	7	str2	String
    //   76	200	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   81	87	165	java/io/IOException
    //   91	162	165	java/io/IOException
    //   226	261	165	java/io/IOException
    //   301	311	328	java/io/IOException
    //   318	322	328	java/io/IOException
    //   47	71	335	finally
    //   346	356	371	java/io/IOException
    //   360	364	371	java/io/IOException
    //   71	78	375	finally
    //   261	269	381	finally
    //   274	282	381	finally
    //   285	293	381	finally
    //   81	87	385	finally
    //   91	162	385	finally
    //   226	261	385	finally
    //   171	181	395	java/io/IOException
    //   188	192	395	java/io/IOException
    //   47	71	402	java/io/IOException
    //   71	78	411	java/io/IOException
    //   261	269	417	java/io/IOException
    //   274	282	417	java/io/IOException
    //   285	293	417	java/io/IOException
  }
  
  private static void jg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(85417);
    paramString1 = paramString1.split("/");
    if (paramString1.length <= 1)
    {
      AppMethodBeat.o(85417);
      return;
    }
    int i = 0;
    while (i < paramString1.length - 1)
    {
      paramString2 = paramString2 + paramString1[i] + "/";
      File localFile = new File(paramString2);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      i += 1;
    }
    AppMethodBeat.o(85417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.o
 * JD-Core Version:    0.7.0.1
 */