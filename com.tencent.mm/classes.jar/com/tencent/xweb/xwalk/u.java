package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class u
{
  private static void a(ZipOutputStream paramZipOutputStream, File paramFile, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(154505);
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
      AppMethodBeat.o(154505);
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
    AppMethodBeat.o(154505);
  }
  
  /* Error */
  public static boolean a(File[] paramArrayOfFile, String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: ldc 90
    //   8: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: ifnonnull +20 -> 32
    //   15: new 92	java/lang/NullPointerException
    //   18: dup
    //   19: ldc 94
    //   21: invokespecial 95	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: ldc 90
    //   27: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: athrow
    //   32: new 66	java/util/zip/ZipOutputStream
    //   35: dup
    //   36: new 97	java/io/BufferedOutputStream
    //   39: dup
    //   40: new 99	java/io/FileOutputStream
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 100	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   48: invokespecial 103	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   51: invokespecial 104	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore_1
    //   55: iload 5
    //   57: istore 4
    //   59: aload_1
    //   60: iload_2
    //   61: invokevirtual 107	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   64: iload 5
    //   66: istore 4
    //   68: aload_0
    //   69: arraylength
    //   70: istore_3
    //   71: iconst_0
    //   72: istore_2
    //   73: iload_2
    //   74: iload_3
    //   75: if_icmpge +118 -> 193
    //   78: aload_0
    //   79: iload_2
    //   80: aaload
    //   81: astore 6
    //   83: aload 6
    //   85: ifnull +177 -> 262
    //   88: iload 5
    //   90: istore 4
    //   92: aload 6
    //   94: invokevirtual 110	java/io/File:exists	()Z
    //   97: ifeq +165 -> 262
    //   100: iload 5
    //   102: istore 4
    //   104: aload 6
    //   106: invokevirtual 19	java/io/File:isDirectory	()Z
    //   109: ifeq +40 -> 149
    //   112: iload 5
    //   114: istore 4
    //   116: aload_1
    //   117: aload 6
    //   119: new 25	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   126: aload 6
    //   128: invokevirtual 33	java/io/File:getName	()Ljava/lang/String;
    //   131: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: getstatic 41	java/io/File:separator	Ljava/lang/String;
    //   137: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 46	com/tencent/xweb/xwalk/u:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   146: goto +116 -> 262
    //   149: iload 5
    //   151: istore 4
    //   153: aload_1
    //   154: aload 6
    //   156: ldc 112
    //   158: invokestatic 46	com/tencent/xweb/xwalk/u:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   161: goto +101 -> 262
    //   164: astore_0
    //   165: iload 4
    //   167: istore 5
    //   169: aload_1
    //   170: ifnull +15 -> 185
    //   173: aload_1
    //   174: invokevirtual 115	java/util/zip/ZipOutputStream:closeEntry	()V
    //   177: aload_1
    //   178: invokevirtual 116	java/util/zip/ZipOutputStream:close	()V
    //   181: iload 4
    //   183: istore 5
    //   185: ldc 90
    //   187: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: iload 5
    //   192: ireturn
    //   193: iconst_1
    //   194: istore 5
    //   196: iconst_1
    //   197: istore 4
    //   199: aload_1
    //   200: invokevirtual 119	java/util/zip/ZipOutputStream:flush	()V
    //   203: aload_1
    //   204: invokevirtual 115	java/util/zip/ZipOutputStream:closeEntry	()V
    //   207: aload_1
    //   208: invokevirtual 116	java/util/zip/ZipOutputStream:close	()V
    //   211: goto -26 -> 185
    //   214: astore_0
    //   215: goto -30 -> 185
    //   218: astore_0
    //   219: aconst_null
    //   220: astore_1
    //   221: aload_1
    //   222: ifnull +11 -> 233
    //   225: aload_1
    //   226: invokevirtual 115	java/util/zip/ZipOutputStream:closeEntry	()V
    //   229: aload_1
    //   230: invokevirtual 116	java/util/zip/ZipOutputStream:close	()V
    //   233: ldc 90
    //   235: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload_0
    //   239: athrow
    //   240: astore_1
    //   241: goto -8 -> 233
    //   244: astore_0
    //   245: goto -24 -> 221
    //   248: astore_0
    //   249: iload 4
    //   251: istore 5
    //   253: goto -68 -> 185
    //   256: astore_0
    //   257: aconst_null
    //   258: astore_1
    //   259: goto -94 -> 165
    //   262: iload_2
    //   263: iconst_1
    //   264: iadd
    //   265: istore_2
    //   266: goto -193 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	paramArrayOfFile	File[]
    //   0	269	1	paramString	String
    //   0	269	2	paramInt	int
    //   70	6	3	i	int
    //   1	249	4	bool1	boolean
    //   4	248	5	bool2	boolean
    //   81	74	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   59	64	164	java/lang/Exception
    //   68	71	164	java/lang/Exception
    //   92	100	164	java/lang/Exception
    //   104	112	164	java/lang/Exception
    //   116	146	164	java/lang/Exception
    //   153	161	164	java/lang/Exception
    //   199	203	164	java/lang/Exception
    //   203	211	214	java/io/IOException
    //   32	55	218	finally
    //   225	233	240	java/io/IOException
    //   59	64	244	finally
    //   68	71	244	finally
    //   92	100	244	finally
    //   104	112	244	finally
    //   116	146	244	finally
    //   153	161	244	finally
    //   199	203	244	finally
    //   173	181	248	java/io/IOException
    //   32	55	256	java/lang/Exception
  }
  
  /* Error */
  public static boolean i(File paramFile, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: ldc 121
    //   7: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: new 66	java/util/zip/ZipOutputStream
    //   13: dup
    //   14: new 97	java/io/BufferedOutputStream
    //   17: dup
    //   18: new 99	java/io/FileOutputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 100	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   26: invokespecial 103	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   29: invokespecial 104	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore_1
    //   33: iload 4
    //   35: istore_3
    //   36: aload_1
    //   37: iconst_0
    //   38: invokevirtual 107	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   41: aload_0
    //   42: ifnull +17 -> 59
    //   45: iload 4
    //   47: istore_3
    //   48: aload_0
    //   49: invokevirtual 110	java/io/File:exists	()Z
    //   52: istore 5
    //   54: iload 5
    //   56: ifne +18 -> 74
    //   59: aload_1
    //   60: invokevirtual 115	java/util/zip/ZipOutputStream:closeEntry	()V
    //   63: aload_1
    //   64: invokevirtual 116	java/util/zip/ZipOutputStream:close	()V
    //   67: ldc 121
    //   69: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: iconst_0
    //   73: ireturn
    //   74: iload 4
    //   76: istore_3
    //   77: aload_0
    //   78: invokevirtual 19	java/io/File:isDirectory	()Z
    //   81: istore 5
    //   83: iload 5
    //   85: ifeq +18 -> 103
    //   88: aload_1
    //   89: invokevirtual 115	java/util/zip/ZipOutputStream:closeEntry	()V
    //   92: aload_1
    //   93: invokevirtual 116	java/util/zip/ZipOutputStream:close	()V
    //   96: ldc 121
    //   98: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iconst_0
    //   102: ireturn
    //   103: iload 4
    //   105: istore_3
    //   106: sipush 2048
    //   109: newarray byte
    //   111: astore 6
    //   113: iload 4
    //   115: istore_3
    //   116: new 51	java/io/BufferedInputStream
    //   119: dup
    //   120: new 53	java/io/FileInputStream
    //   123: dup
    //   124: aload_0
    //   125: invokespecial 56	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   128: invokespecial 59	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   131: astore 7
    //   133: iload 4
    //   135: istore_3
    //   136: new 61	java/util/zip/ZipEntry
    //   139: dup
    //   140: aload_0
    //   141: invokevirtual 33	java/io/File:getName	()Ljava/lang/String;
    //   144: invokespecial 64	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   147: astore 8
    //   149: iload 4
    //   151: istore_3
    //   152: aload 8
    //   154: iconst_0
    //   155: invokevirtual 124	java/util/zip/ZipEntry:setMethod	(I)V
    //   158: iload 4
    //   160: istore_3
    //   161: aload 8
    //   163: aload_0
    //   164: invokevirtual 128	java/io/File:length	()J
    //   167: invokevirtual 132	java/util/zip/ZipEntry:setCompressedSize	(J)V
    //   170: iload 4
    //   172: istore_3
    //   173: aload 8
    //   175: aload_0
    //   176: invokevirtual 128	java/io/File:length	()J
    //   179: invokevirtual 135	java/util/zip/ZipEntry:setSize	(J)V
    //   182: iload 4
    //   184: istore_3
    //   185: aload_1
    //   186: new 61	java/util/zip/ZipEntry
    //   189: dup
    //   190: aload_0
    //   191: invokevirtual 33	java/io/File:getName	()Ljava/lang/String;
    //   194: invokespecial 64	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   197: invokevirtual 70	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   200: iload 4
    //   202: istore_3
    //   203: aload 7
    //   205: aload 6
    //   207: invokevirtual 76	java/io/InputStream:read	([B)I
    //   210: istore_2
    //   211: iload_2
    //   212: iconst_m1
    //   213: if_icmpeq +44 -> 257
    //   216: iload 4
    //   218: istore_3
    //   219: aload_1
    //   220: aload 6
    //   222: iconst_0
    //   223: iload_2
    //   224: invokevirtual 80	java/util/zip/ZipOutputStream:write	([BII)V
    //   227: goto -27 -> 200
    //   230: astore_0
    //   231: iload_3
    //   232: istore 4
    //   234: aload_1
    //   235: ifnull +14 -> 249
    //   238: aload_1
    //   239: invokevirtual 115	java/util/zip/ZipOutputStream:closeEntry	()V
    //   242: aload_1
    //   243: invokevirtual 116	java/util/zip/ZipOutputStream:close	()V
    //   246: iload_3
    //   247: istore 4
    //   249: ldc 121
    //   251: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: iload 4
    //   256: ireturn
    //   257: iload 4
    //   259: istore_3
    //   260: aload 7
    //   262: invokevirtual 83	java/io/InputStream:close	()V
    //   265: iconst_1
    //   266: istore 4
    //   268: iconst_1
    //   269: istore_3
    //   270: aload_1
    //   271: invokevirtual 119	java/util/zip/ZipOutputStream:flush	()V
    //   274: aload_1
    //   275: invokevirtual 115	java/util/zip/ZipOutputStream:closeEntry	()V
    //   278: aload_1
    //   279: invokevirtual 116	java/util/zip/ZipOutputStream:close	()V
    //   282: goto -33 -> 249
    //   285: astore_0
    //   286: goto -37 -> 249
    //   289: astore_0
    //   290: aconst_null
    //   291: astore_1
    //   292: aload_1
    //   293: ifnull +11 -> 304
    //   296: aload_1
    //   297: invokevirtual 115	java/util/zip/ZipOutputStream:closeEntry	()V
    //   300: aload_1
    //   301: invokevirtual 116	java/util/zip/ZipOutputStream:close	()V
    //   304: ldc 121
    //   306: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: aload_0
    //   310: athrow
    //   311: astore_1
    //   312: goto -8 -> 304
    //   315: astore_0
    //   316: goto -24 -> 292
    //   319: astore_0
    //   320: iload_3
    //   321: istore 4
    //   323: goto -74 -> 249
    //   326: astore_0
    //   327: aconst_null
    //   328: astore_1
    //   329: goto -98 -> 231
    //   332: astore_0
    //   333: goto -237 -> 96
    //   336: astore_0
    //   337: goto -270 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	paramFile	File
    //   0	340	1	paramString	String
    //   210	14	2	i	int
    //   1	320	3	bool1	boolean
    //   3	319	4	bool2	boolean
    //   52	32	5	bool3	boolean
    //   111	110	6	arrayOfByte	byte[]
    //   131	130	7	localBufferedInputStream	BufferedInputStream
    //   147	27	8	localZipEntry	ZipEntry
    // Exception table:
    //   from	to	target	type
    //   36	41	230	java/lang/Exception
    //   48	54	230	java/lang/Exception
    //   77	83	230	java/lang/Exception
    //   106	113	230	java/lang/Exception
    //   116	133	230	java/lang/Exception
    //   136	149	230	java/lang/Exception
    //   152	158	230	java/lang/Exception
    //   161	170	230	java/lang/Exception
    //   173	182	230	java/lang/Exception
    //   185	200	230	java/lang/Exception
    //   203	211	230	java/lang/Exception
    //   219	227	230	java/lang/Exception
    //   260	265	230	java/lang/Exception
    //   270	274	230	java/lang/Exception
    //   274	282	285	java/io/IOException
    //   10	33	289	finally
    //   296	304	311	java/io/IOException
    //   36	41	315	finally
    //   48	54	315	finally
    //   77	83	315	finally
    //   106	113	315	finally
    //   116	133	315	finally
    //   136	149	315	finally
    //   152	158	315	finally
    //   161	170	315	finally
    //   173	182	315	finally
    //   185	200	315	finally
    //   203	211	315	finally
    //   219	227	315	finally
    //   260	265	315	finally
    //   270	274	315	finally
    //   238	246	319	java/io/IOException
    //   10	33	326	java/lang/Exception
    //   88	96	332	java/io/IOException
    //   59	67	336	java/io/IOException
  }
  
  /* Error */
  public static boolean np(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_0
    //   4: istore 4
    //   6: ldc 138
    //   8: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: new 15	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore 5
    //   21: aload 5
    //   23: invokevirtual 110	java/io/File:exists	()Z
    //   26: ifne +9 -> 35
    //   29: aload 5
    //   31: invokevirtual 142	java/io/File:mkdirs	()Z
    //   34: pop
    //   35: aload_0
    //   36: ldc 144
    //   38: invokevirtual 150	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   41: ifeq +161 -> 202
    //   44: aload_0
    //   45: astore 6
    //   47: new 152	java/util/zip/ZipInputStream
    //   50: dup
    //   51: new 51	java/io/BufferedInputStream
    //   54: dup
    //   55: new 53	java/io/FileInputStream
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 153	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   63: invokespecial 59	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: invokespecial 154	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   69: astore 5
    //   71: sipush 2048
    //   74: newarray byte
    //   76: astore 8
    //   78: aload 7
    //   80: astore_0
    //   81: aload 5
    //   83: invokevirtual 158	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   86: astore_1
    //   87: aload_1
    //   88: ifnull +210 -> 298
    //   91: aload_1
    //   92: invokevirtual 159	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   95: astore 7
    //   97: aload 7
    //   99: ldc 161
    //   101: invokevirtual 165	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   104: ifne -23 -> 81
    //   107: aload 7
    //   109: ldc 167
    //   111: invokevirtual 165	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   114: ifne -33 -> 81
    //   117: aload 7
    //   119: aload 6
    //   121: invokestatic 171	com/tencent/xweb/xwalk/u:nq	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_1
    //   125: invokevirtual 172	java/util/zip/ZipEntry:isDirectory	()Z
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
    //   155: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: invokevirtual 142	java/io/File:mkdirs	()Z
    //   161: pop
    //   162: goto -81 -> 81
    //   165: astore_1
    //   166: aload 5
    //   168: ifnull +13 -> 181
    //   171: aload 5
    //   173: invokevirtual 173	java/util/zip/ZipInputStream:closeEntry	()V
    //   176: aload 5
    //   178: invokevirtual 174	java/util/zip/ZipInputStream:close	()V
    //   181: iload 4
    //   183: istore_3
    //   184: aload_0
    //   185: ifnull +10 -> 195
    //   188: aload_0
    //   189: invokevirtual 175	java/io/BufferedOutputStream:close	()V
    //   192: iload 4
    //   194: istore_3
    //   195: ldc 138
    //   197: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: iload_3
    //   201: ireturn
    //   202: new 25	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   209: aload_0
    //   210: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: bipush 47
    //   215: invokevirtual 178	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   218: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: astore 6
    //   223: goto -176 -> 47
    //   226: new 97	java/io/BufferedOutputStream
    //   229: dup
    //   230: new 99	java/io/FileOutputStream
    //   233: dup
    //   234: new 25	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   241: aload 6
    //   243: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload 7
    //   248: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokespecial 100	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   257: invokespecial 103	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   260: astore_1
    //   261: aload 5
    //   263: aload 8
    //   265: invokevirtual 179	java/util/zip/ZipInputStream:read	([B)I
    //   268: istore_2
    //   269: iload_2
    //   270: iconst_m1
    //   271: if_icmpeq +14 -> 285
    //   274: aload_1
    //   275: aload 8
    //   277: iconst_0
    //   278: iload_2
    //   279: invokevirtual 180	java/io/BufferedOutputStream:write	([BII)V
    //   282: goto -21 -> 261
    //   285: aload_1
    //   286: invokevirtual 181	java/io/BufferedOutputStream:flush	()V
    //   289: aload_1
    //   290: invokevirtual 175	java/io/BufferedOutputStream:close	()V
    //   293: aload_1
    //   294: astore_0
    //   295: goto -214 -> 81
    //   298: iconst_1
    //   299: istore 4
    //   301: aload 5
    //   303: invokevirtual 173	java/util/zip/ZipInputStream:closeEntry	()V
    //   306: aload 5
    //   308: invokevirtual 174	java/util/zip/ZipInputStream:close	()V
    //   311: iload 4
    //   313: istore_3
    //   314: aload_0
    //   315: ifnull -120 -> 195
    //   318: aload_0
    //   319: invokevirtual 175	java/io/BufferedOutputStream:close	()V
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
    //   348: invokevirtual 173	java/util/zip/ZipInputStream:closeEntry	()V
    //   351: aload 5
    //   353: invokevirtual 174	java/util/zip/ZipInputStream:close	()V
    //   356: aload_1
    //   357: ifnull +7 -> 364
    //   360: aload_1
    //   361: invokevirtual 175	java/io/BufferedOutputStream:close	()V
    //   364: ldc 138
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
  
  private static void nq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(154507);
    paramString1 = paramString1.split("/");
    if (paramString1.length <= 1)
    {
      AppMethodBeat.o(154507);
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
    AppMethodBeat.o(154507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.u
 * JD-Core Version:    0.7.0.1
 */