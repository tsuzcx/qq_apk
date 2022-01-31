package com.tencent.xweb.xwalk;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class m
{
  private static void a(ZipOutputStream paramZipOutputStream, File paramFile, String paramString)
  {
    int i = 0;
    Object localObject1;
    Object localObject2;
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
            break label95;
          }
          a(paramZipOutputStream, (File)localObject2, paramFile.getName() + File.separator + ((File)localObject2).getName() + File.separator);
        }
        for (;;)
        {
          i += 1;
          break;
          label95:
          a(paramZipOutputStream, (File)localObject2, paramString);
        }
      }
    }
    else
    {
      localObject1 = new byte[2048];
      localObject2 = new BufferedInputStream(new FileInputStream(paramFile));
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
    }
  }
  
  /* Error */
  public static boolean a(File[] paramArrayOfFile, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: new 56	java/util/zip/ZipOutputStream
    //   8: dup
    //   9: new 81	java/io/BufferedOutputStream
    //   12: dup
    //   13: new 83	java/io/FileOutputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 84	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   21: invokespecial 87	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: invokespecial 88	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore_1
    //   28: iconst_0
    //   29: istore_2
    //   30: iload_2
    //   31: ifgt +100 -> 131
    //   34: aload_0
    //   35: iconst_0
    //   36: aaload
    //   37: astore 5
    //   39: aload 5
    //   41: ifnull +143 -> 184
    //   44: iload 4
    //   46: istore_3
    //   47: aload 5
    //   49: invokevirtual 91	java/io/File:exists	()Z
    //   52: ifeq +132 -> 184
    //   55: iload 4
    //   57: istore_3
    //   58: aload 5
    //   60: invokevirtual 12	java/io/File:isDirectory	()Z
    //   63: ifeq +39 -> 102
    //   66: iload 4
    //   68: istore_3
    //   69: aload_1
    //   70: aload 5
    //   72: new 18	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   79: aload 5
    //   81: invokevirtual 26	java/io/File:getName	()Ljava/lang/String;
    //   84: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: getstatic 34	java/io/File:separator	Ljava/lang/String;
    //   90: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 39	com/tencent/xweb/xwalk/m:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   99: goto +85 -> 184
    //   102: iload 4
    //   104: istore_3
    //   105: aload_1
    //   106: aload 5
    //   108: ldc 93
    //   110: invokestatic 39	com/tencent/xweb/xwalk/m:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   113: goto +71 -> 184
    //   116: astore_0
    //   117: aload_1
    //   118: ifnull +11 -> 129
    //   121: aload_1
    //   122: invokevirtual 96	java/util/zip/ZipOutputStream:closeEntry	()V
    //   125: aload_1
    //   126: invokevirtual 97	java/util/zip/ZipOutputStream:close	()V
    //   129: iload_3
    //   130: ireturn
    //   131: iconst_1
    //   132: istore_3
    //   133: aload_1
    //   134: invokevirtual 100	java/util/zip/ZipOutputStream:flush	()V
    //   137: aload_1
    //   138: invokevirtual 96	java/util/zip/ZipOutputStream:closeEntry	()V
    //   141: aload_1
    //   142: invokevirtual 97	java/util/zip/ZipOutputStream:close	()V
    //   145: iconst_1
    //   146: ireturn
    //   147: astore_0
    //   148: iconst_1
    //   149: ireturn
    //   150: astore_0
    //   151: aconst_null
    //   152: astore_1
    //   153: aload_1
    //   154: ifnull +11 -> 165
    //   157: aload_1
    //   158: invokevirtual 96	java/util/zip/ZipOutputStream:closeEntry	()V
    //   161: aload_1
    //   162: invokevirtual 97	java/util/zip/ZipOutputStream:close	()V
    //   165: aload_0
    //   166: athrow
    //   167: astore_1
    //   168: goto -3 -> 165
    //   171: astore_0
    //   172: goto -19 -> 153
    //   175: astore_0
    //   176: iload_3
    //   177: ireturn
    //   178: astore_0
    //   179: aconst_null
    //   180: astore_1
    //   181: goto -64 -> 117
    //   184: iload_2
    //   185: iconst_1
    //   186: iadd
    //   187: istore_2
    //   188: goto -158 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramArrayOfFile	File[]
    //   0	191	1	paramString	String
    //   29	159	2	i	int
    //   1	176	3	bool1	boolean
    //   3	100	4	bool2	boolean
    //   37	70	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   47	55	116	java/lang/Exception
    //   58	66	116	java/lang/Exception
    //   69	99	116	java/lang/Exception
    //   105	113	116	java/lang/Exception
    //   133	137	116	java/lang/Exception
    //   137	145	147	java/io/IOException
    //   5	28	150	finally
    //   157	165	167	java/io/IOException
    //   47	55	171	finally
    //   58	66	171	finally
    //   69	99	171	finally
    //   105	113	171	finally
    //   133	137	171	finally
    //   121	129	175	java/io/IOException
    //   5	28	178	java/lang/Exception
  }
  
  /* Error */
  public static boolean gT(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_0
    //   4: istore 4
    //   6: new 8	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 5
    //   16: aload 5
    //   18: invokevirtual 91	java/io/File:exists	()Z
    //   21: ifne +9 -> 30
    //   24: aload 5
    //   26: invokevirtual 106	java/io/File:mkdirs	()Z
    //   29: pop
    //   30: aload_0
    //   31: ldc 108
    //   33: invokevirtual 114	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   36: ifeq +156 -> 192
    //   39: aload_0
    //   40: astore 6
    //   42: new 116	java/util/zip/ZipInputStream
    //   45: dup
    //   46: new 41	java/io/BufferedInputStream
    //   49: dup
    //   50: new 43	java/io/FileInputStream
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   58: invokespecial 49	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: invokespecial 118	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   64: astore 5
    //   66: sipush 2048
    //   69: newarray byte
    //   71: astore 8
    //   73: aload 7
    //   75: astore_0
    //   76: aload 5
    //   78: invokevirtual 122	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   81: astore_1
    //   82: aload_1
    //   83: ifnull +205 -> 288
    //   86: aload_1
    //   87: invokevirtual 123	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   90: astore 7
    //   92: aload 7
    //   94: ldc 125
    //   96: invokevirtual 129	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   99: ifne -23 -> 76
    //   102: aload 7
    //   104: ldc 131
    //   106: invokevirtual 129	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   109: ifne -33 -> 76
    //   112: aload 7
    //   114: aload 6
    //   116: invokestatic 135	com/tencent/xweb/xwalk/m:gU	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_1
    //   120: invokevirtual 136	java/util/zip/ZipEntry:isDirectory	()Z
    //   123: ifeq +93 -> 216
    //   126: new 8	java/io/File
    //   129: dup
    //   130: new 18	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   137: aload 6
    //   139: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload 7
    //   144: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   153: invokevirtual 106	java/io/File:mkdirs	()Z
    //   156: pop
    //   157: goto -81 -> 76
    //   160: astore_1
    //   161: aload 5
    //   163: ifnull +13 -> 176
    //   166: aload 5
    //   168: invokevirtual 137	java/util/zip/ZipInputStream:closeEntry	()V
    //   171: aload 5
    //   173: invokevirtual 138	java/util/zip/ZipInputStream:close	()V
    //   176: iload 4
    //   178: istore_3
    //   179: aload_0
    //   180: ifnull +10 -> 190
    //   183: aload_0
    //   184: invokevirtual 139	java/io/BufferedOutputStream:close	()V
    //   187: iload 4
    //   189: istore_3
    //   190: iload_3
    //   191: ireturn
    //   192: new 18	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   199: aload_0
    //   200: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: bipush 47
    //   205: invokevirtual 142	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   208: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: astore 6
    //   213: goto -171 -> 42
    //   216: new 81	java/io/BufferedOutputStream
    //   219: dup
    //   220: new 83	java/io/FileOutputStream
    //   223: dup
    //   224: new 18	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   231: aload 6
    //   233: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload 7
    //   238: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokespecial 84	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   247: invokespecial 87	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   250: astore_1
    //   251: aload 5
    //   253: aload 8
    //   255: invokevirtual 143	java/util/zip/ZipInputStream:read	([B)I
    //   258: istore_2
    //   259: iload_2
    //   260: iconst_m1
    //   261: if_icmpeq +14 -> 275
    //   264: aload_1
    //   265: aload 8
    //   267: iconst_0
    //   268: iload_2
    //   269: invokevirtual 144	java/io/BufferedOutputStream:write	([BII)V
    //   272: goto -21 -> 251
    //   275: aload_1
    //   276: invokevirtual 145	java/io/BufferedOutputStream:flush	()V
    //   279: aload_1
    //   280: invokevirtual 139	java/io/BufferedOutputStream:close	()V
    //   283: aload_1
    //   284: astore_0
    //   285: goto -209 -> 76
    //   288: iconst_1
    //   289: istore_3
    //   290: aload 5
    //   292: invokevirtual 137	java/util/zip/ZipInputStream:closeEntry	()V
    //   295: aload 5
    //   297: invokevirtual 138	java/util/zip/ZipInputStream:close	()V
    //   300: aload_0
    //   301: ifnull -111 -> 190
    //   304: aload_0
    //   305: invokevirtual 139	java/io/BufferedOutputStream:close	()V
    //   308: iconst_1
    //   309: ireturn
    //   310: astore_0
    //   311: iconst_1
    //   312: ireturn
    //   313: astore_0
    //   314: aconst_null
    //   315: astore 5
    //   317: aconst_null
    //   318: astore_1
    //   319: aload 5
    //   321: ifnull +13 -> 334
    //   324: aload 5
    //   326: invokevirtual 137	java/util/zip/ZipInputStream:closeEntry	()V
    //   329: aload 5
    //   331: invokevirtual 138	java/util/zip/ZipInputStream:close	()V
    //   334: aload_1
    //   335: ifnull +7 -> 342
    //   338: aload_1
    //   339: invokevirtual 139	java/io/BufferedOutputStream:close	()V
    //   342: aload_0
    //   343: athrow
    //   344: astore_1
    //   345: goto -3 -> 342
    //   348: astore_0
    //   349: aconst_null
    //   350: astore_1
    //   351: goto -32 -> 319
    //   354: astore_0
    //   355: goto -36 -> 319
    //   358: astore 6
    //   360: aload_0
    //   361: astore_1
    //   362: aload 6
    //   364: astore_0
    //   365: goto -46 -> 319
    //   368: astore_0
    //   369: iconst_0
    //   370: ireturn
    //   371: astore_0
    //   372: aconst_null
    //   373: astore 5
    //   375: aconst_null
    //   376: astore_0
    //   377: goto -216 -> 161
    //   380: astore_0
    //   381: aconst_null
    //   382: astore_0
    //   383: goto -222 -> 161
    //   386: astore_0
    //   387: aload_1
    //   388: astore_0
    //   389: goto -228 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	paramString1	String
    //   0	392	1	paramString2	String
    //   258	11	2	i	int
    //   178	112	3	bool1	boolean
    //   4	184	4	bool2	boolean
    //   14	360	5	localObject1	Object
    //   40	192	6	str1	String
    //   358	5	6	localObject2	Object
    //   1	236	7	str2	String
    //   71	195	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   76	82	160	java/io/IOException
    //   86	157	160	java/io/IOException
    //   216	251	160	java/io/IOException
    //   290	300	310	java/io/IOException
    //   304	308	310	java/io/IOException
    //   42	66	313	finally
    //   324	334	344	java/io/IOException
    //   338	342	344	java/io/IOException
    //   66	73	348	finally
    //   251	259	354	finally
    //   264	272	354	finally
    //   275	283	354	finally
    //   76	82	358	finally
    //   86	157	358	finally
    //   216	251	358	finally
    //   166	176	368	java/io/IOException
    //   183	187	368	java/io/IOException
    //   42	66	371	java/io/IOException
    //   66	73	380	java/io/IOException
    //   251	259	386	java/io/IOException
    //   264	272	386	java/io/IOException
    //   275	283	386	java/io/IOException
  }
  
  private static void gU(String paramString1, String paramString2)
  {
    paramString1 = paramString1.split("/");
    if (paramString1.length <= 1) {}
    for (;;)
    {
      return;
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.m
 * JD-Core Version:    0.7.0.1
 */