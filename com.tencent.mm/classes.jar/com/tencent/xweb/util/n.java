package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.xwalk.core.Log;

public final class n
{
  private static void a(ZipOutputStream paramZipOutputStream, File paramFile, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(212620);
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
      AppMethodBeat.o(212620);
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
    AppMethodBeat.o(212620);
  }
  
  /* Error */
  public static boolean a(File[] paramArrayOfFile, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: ldc 88
    //   7: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: new 66	java/util/zip/ZipOutputStream
    //   13: dup
    //   14: new 90	java/io/BufferedOutputStream
    //   17: dup
    //   18: new 92	java/io/FileOutputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   26: invokespecial 96	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   29: invokespecial 97	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore_1
    //   33: iload 4
    //   35: istore_3
    //   36: aload_1
    //   37: iconst_m1
    //   38: invokevirtual 100	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   41: iconst_0
    //   42: istore_2
    //   43: iload_2
    //   44: ifgt +132 -> 176
    //   47: aload_0
    //   48: iconst_0
    //   49: aaload
    //   50: astore 5
    //   52: aload 5
    //   54: ifnull +225 -> 279
    //   57: iload 4
    //   59: istore_3
    //   60: aload 5
    //   62: invokevirtual 103	java/io/File:exists	()Z
    //   65: ifeq +214 -> 279
    //   68: iload 4
    //   70: istore_3
    //   71: aload 5
    //   73: invokevirtual 19	java/io/File:isDirectory	()Z
    //   76: ifeq +39 -> 115
    //   79: iload 4
    //   81: istore_3
    //   82: aload_1
    //   83: aload 5
    //   85: new 25	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   92: aload 5
    //   94: invokevirtual 33	java/io/File:getName	()Ljava/lang/String;
    //   97: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: getstatic 41	java/io/File:separator	Ljava/lang/String;
    //   103: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 46	com/tencent/xweb/util/n:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   112: goto +167 -> 279
    //   115: iload 4
    //   117: istore_3
    //   118: aload_1
    //   119: aload 5
    //   121: ldc 105
    //   123: invokestatic 46	com/tencent/xweb/util/n:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   126: goto +153 -> 279
    //   129: astore 5
    //   131: aload_1
    //   132: astore_0
    //   133: aload 5
    //   135: astore_1
    //   136: ldc 107
    //   138: ldc 109
    //   140: aload_1
    //   141: invokestatic 115	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   144: invokevirtual 119	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokestatic 125	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: iload_3
    //   151: istore 4
    //   153: aload_0
    //   154: ifnull +14 -> 168
    //   157: aload_0
    //   158: invokevirtual 128	java/util/zip/ZipOutputStream:closeEntry	()V
    //   161: aload_0
    //   162: invokevirtual 129	java/util/zip/ZipOutputStream:close	()V
    //   165: iload_3
    //   166: istore 4
    //   168: ldc 88
    //   170: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: iload 4
    //   175: ireturn
    //   176: iconst_1
    //   177: istore 4
    //   179: iconst_1
    //   180: istore_3
    //   181: aload_1
    //   182: invokevirtual 132	java/util/zip/ZipOutputStream:flush	()V
    //   185: aload_1
    //   186: invokevirtual 128	java/util/zip/ZipOutputStream:closeEntry	()V
    //   189: aload_1
    //   190: invokevirtual 129	java/util/zip/ZipOutputStream:close	()V
    //   193: goto -25 -> 168
    //   196: astore_0
    //   197: ldc 107
    //   199: ldc 109
    //   201: aload_0
    //   202: invokestatic 115	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   205: invokevirtual 119	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   208: invokestatic 125	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: goto -43 -> 168
    //   214: astore_0
    //   215: ldc 107
    //   217: ldc 109
    //   219: aload_0
    //   220: invokestatic 115	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   223: invokevirtual 119	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   226: invokestatic 125	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: iload_3
    //   230: istore 4
    //   232: goto -64 -> 168
    //   235: astore_1
    //   236: aload_0
    //   237: ifnull +11 -> 248
    //   240: aload_0
    //   241: invokevirtual 128	java/util/zip/ZipOutputStream:closeEntry	()V
    //   244: aload_0
    //   245: invokevirtual 129	java/util/zip/ZipOutputStream:close	()V
    //   248: ldc 88
    //   250: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: aload_1
    //   254: athrow
    //   255: astore_0
    //   256: ldc 107
    //   258: ldc 109
    //   260: aload_0
    //   261: invokestatic 115	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   264: invokevirtual 119	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   267: invokestatic 125	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: goto -22 -> 248
    //   273: astore_1
    //   274: aconst_null
    //   275: astore_0
    //   276: goto -140 -> 136
    //   279: iload_2
    //   280: iconst_1
    //   281: iadd
    //   282: istore_2
    //   283: goto -240 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramArrayOfFile	File[]
    //   0	286	1	paramString	String
    //   42	241	2	i	int
    //   1	229	3	bool1	boolean
    //   3	228	4	bool2	boolean
    //   50	70	5	localFile	File
    //   129	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   36	41	129	finally
    //   60	68	129	finally
    //   71	79	129	finally
    //   82	112	129	finally
    //   118	126	129	finally
    //   181	185	129	finally
    //   185	193	196	java/io/IOException
    //   157	165	214	java/io/IOException
    //   136	150	235	finally
    //   240	248	255	java/io/IOException
    //   10	33	273	finally
  }
  
  /* Error */
  public static boolean cB(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_0
    //   4: istore 4
    //   6: ldc 135
    //   8: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: new 15	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore 5
    //   21: aload 5
    //   23: invokevirtual 103	java/io/File:exists	()Z
    //   26: ifne +9 -> 35
    //   29: aload 5
    //   31: invokevirtual 139	java/io/File:mkdirs	()Z
    //   34: pop
    //   35: aload_0
    //   36: ldc 141
    //   38: invokevirtual 145	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   41: ifeq +185 -> 226
    //   44: aload_0
    //   45: astore 9
    //   47: new 147	java/util/zip/ZipInputStream
    //   50: dup
    //   51: new 51	java/io/BufferedInputStream
    //   54: dup
    //   55: new 53	java/io/FileInputStream
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   63: invokespecial 59	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: invokespecial 149	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   69: astore 5
    //   71: sipush 2048
    //   74: newarray byte
    //   76: astore_1
    //   77: aload 6
    //   79: astore_0
    //   80: aload 5
    //   82: invokevirtual 153	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   85: astore 6
    //   87: aload 6
    //   89: ifnull +268 -> 357
    //   92: aload 6
    //   94: invokevirtual 154	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   97: astore 7
    //   99: aload 7
    //   101: ldc 156
    //   103: invokevirtual 160	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   106: ifne -26 -> 80
    //   109: aload 7
    //   111: ldc 162
    //   113: invokevirtual 160	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   116: ifne -36 -> 80
    //   119: aload 7
    //   121: aload 9
    //   123: invokestatic 165	com/tencent/xweb/util/n:cC	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload 6
    //   128: invokevirtual 166	java/util/zip/ZipEntry:isDirectory	()Z
    //   131: ifeq +119 -> 250
    //   134: new 15	java/io/File
    //   137: dup
    //   138: new 25	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   145: aload 9
    //   147: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload 7
    //   152: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   161: invokevirtual 139	java/io/File:mkdirs	()Z
    //   164: pop
    //   165: goto -85 -> 80
    //   168: astore_1
    //   169: aload 5
    //   171: astore 7
    //   173: aload_0
    //   174: astore 6
    //   176: ldc 107
    //   178: ldc 168
    //   180: aload_1
    //   181: invokestatic 115	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   184: invokevirtual 119	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   187: invokestatic 125	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload 5
    //   192: ifnull +13 -> 205
    //   195: aload 5
    //   197: invokevirtual 169	java/util/zip/ZipInputStream:closeEntry	()V
    //   200: aload 5
    //   202: invokevirtual 170	java/util/zip/ZipInputStream:close	()V
    //   205: iload 4
    //   207: istore_3
    //   208: aload_0
    //   209: ifnull +10 -> 219
    //   212: aload_0
    //   213: invokevirtual 171	java/io/BufferedOutputStream:close	()V
    //   216: iload 4
    //   218: istore_3
    //   219: ldc 135
    //   221: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: iload_3
    //   225: ireturn
    //   226: new 25	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   233: aload_0
    //   234: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: bipush 47
    //   239: invokevirtual 174	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   242: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: astore 9
    //   247: goto -200 -> 47
    //   250: new 90	java/io/BufferedOutputStream
    //   253: dup
    //   254: new 92	java/io/FileOutputStream
    //   257: dup
    //   258: new 25	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   265: aload 9
    //   267: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload 7
    //   272: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   281: invokespecial 96	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   284: astore 8
    //   286: aload 5
    //   288: astore 7
    //   290: aload 8
    //   292: astore 6
    //   294: aload 5
    //   296: aload_1
    //   297: invokevirtual 175	java/util/zip/ZipInputStream:read	([B)I
    //   300: istore_2
    //   301: iload_2
    //   302: iconst_m1
    //   303: if_icmpeq +22 -> 325
    //   306: aload 5
    //   308: astore 7
    //   310: aload 8
    //   312: astore 6
    //   314: aload 8
    //   316: aload_1
    //   317: iconst_0
    //   318: iload_2
    //   319: invokevirtual 176	java/io/BufferedOutputStream:write	([BII)V
    //   322: goto -36 -> 286
    //   325: aload 5
    //   327: astore 7
    //   329: aload 8
    //   331: astore 6
    //   333: aload 8
    //   335: invokevirtual 177	java/io/BufferedOutputStream:flush	()V
    //   338: aload 5
    //   340: astore 7
    //   342: aload 8
    //   344: astore 6
    //   346: aload 8
    //   348: invokevirtual 171	java/io/BufferedOutputStream:close	()V
    //   351: aload 8
    //   353: astore_0
    //   354: goto -274 -> 80
    //   357: iconst_1
    //   358: istore 4
    //   360: aload 5
    //   362: invokevirtual 169	java/util/zip/ZipInputStream:closeEntry	()V
    //   365: aload 5
    //   367: invokevirtual 170	java/util/zip/ZipInputStream:close	()V
    //   370: iload 4
    //   372: istore_3
    //   373: aload_0
    //   374: ifnull -155 -> 219
    //   377: aload_0
    //   378: invokevirtual 171	java/io/BufferedOutputStream:close	()V
    //   381: iload 4
    //   383: istore_3
    //   384: goto -165 -> 219
    //   387: astore_0
    //   388: ldc 107
    //   390: ldc 168
    //   392: aload_0
    //   393: invokestatic 115	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   396: invokevirtual 119	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   399: invokestatic 125	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: iload 4
    //   404: istore_3
    //   405: goto -186 -> 219
    //   408: astore_0
    //   409: ldc 107
    //   411: ldc 168
    //   413: aload_0
    //   414: invokestatic 115	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   417: invokevirtual 119	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   420: invokestatic 125	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   423: iload 4
    //   425: istore_3
    //   426: goto -207 -> 219
    //   429: astore_0
    //   430: aconst_null
    //   431: astore 5
    //   433: aconst_null
    //   434: astore_1
    //   435: aload 5
    //   437: ifnull +13 -> 450
    //   440: aload 5
    //   442: invokevirtual 169	java/util/zip/ZipInputStream:closeEntry	()V
    //   445: aload 5
    //   447: invokevirtual 170	java/util/zip/ZipInputStream:close	()V
    //   450: aload_1
    //   451: ifnull +7 -> 458
    //   454: aload_1
    //   455: invokevirtual 171	java/io/BufferedOutputStream:close	()V
    //   458: ldc 135
    //   460: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   463: aload_0
    //   464: athrow
    //   465: astore_1
    //   466: ldc 107
    //   468: ldc 168
    //   470: aload_1
    //   471: invokestatic 115	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   474: invokevirtual 119	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   477: invokestatic 125	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: goto -22 -> 458
    //   483: astore_0
    //   484: aconst_null
    //   485: astore_1
    //   486: goto -51 -> 435
    //   489: astore_0
    //   490: aload 7
    //   492: astore 5
    //   494: aload 6
    //   496: astore_1
    //   497: goto -62 -> 435
    //   500: astore 6
    //   502: aload_0
    //   503: astore_1
    //   504: aload 6
    //   506: astore_0
    //   507: goto -72 -> 435
    //   510: astore_1
    //   511: aconst_null
    //   512: astore 5
    //   514: aconst_null
    //   515: astore_0
    //   516: goto -347 -> 169
    //   519: astore_1
    //   520: aconst_null
    //   521: astore_0
    //   522: goto -353 -> 169
    //   525: astore_1
    //   526: aload 8
    //   528: astore_0
    //   529: goto -360 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	532	0	paramString1	String
    //   0	532	1	paramString2	String
    //   300	19	2	i	int
    //   207	219	3	bool1	boolean
    //   4	420	4	bool2	boolean
    //   19	494	5	localObject1	Object
    //   1	494	6	localObject2	Object
    //   500	5	6	localObject3	Object
    //   97	394	7	localObject4	Object
    //   284	243	8	localBufferedOutputStream	BufferedOutputStream
    //   45	221	9	str	String
    // Exception table:
    //   from	to	target	type
    //   80	87	168	java/io/IOException
    //   92	165	168	java/io/IOException
    //   250	286	168	java/io/IOException
    //   360	370	387	java/io/IOException
    //   377	381	387	java/io/IOException
    //   195	205	408	java/io/IOException
    //   212	216	408	java/io/IOException
    //   47	71	429	finally
    //   440	450	465	java/io/IOException
    //   454	458	465	java/io/IOException
    //   71	77	483	finally
    //   176	190	489	finally
    //   294	301	489	finally
    //   314	322	489	finally
    //   333	338	489	finally
    //   346	351	489	finally
    //   80	87	500	finally
    //   92	165	500	finally
    //   250	286	500	finally
    //   47	71	510	java/io/IOException
    //   71	77	519	java/io/IOException
    //   294	301	525	java/io/IOException
    //   314	322	525	java/io/IOException
    //   333	338	525	java/io/IOException
    //   346	351	525	java/io/IOException
  }
  
  private static void cC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212634);
    paramString1 = paramString1.split("/");
    if (paramString1.length <= 1)
    {
      AppMethodBeat.o(212634);
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
    AppMethodBeat.o(212634);
  }
  
  public static boolean k(File paramFile, String paramString)
  {
    bool1 = false;
    bool2 = false;
    AppMethodBeat.i(212600);
    for (;;)
    {
      try
      {
        localZipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(paramString)));
      }
      finally
      {
        ZipOutputStream localZipOutputStream;
        boolean bool3;
        byte[] arrayOfByte;
        continue;
      }
      try
      {
        localZipOutputStream.setLevel(0);
        if (paramFile != null)
        {
          bool3 = paramFile.exists();
          if (bool3) {}
        }
        else
        {
          try
          {
            localZipOutputStream.closeEntry();
            localZipOutputStream.close();
            AppMethodBeat.o(212600);
            return false;
          }
          catch (IOException paramFile)
          {
            Log.e("ZipUtil", "zipFileEx, error:".concat(String.valueOf(paramFile)));
            continue;
          }
        }
        bool3 = paramFile.isDirectory();
        if (bool3) {
          try
          {
            localZipOutputStream.closeEntry();
            localZipOutputStream.close();
            AppMethodBeat.o(212600);
            return false;
          }
          catch (IOException paramFile)
          {
            Log.e("ZipUtil", "zipFileEx, error:".concat(String.valueOf(paramFile)));
            continue;
          }
        }
        arrayOfByte = new byte[2048];
        paramString = new BufferedInputStream(new FileInputStream(paramFile));
        bool1 = bool2;
        try
        {
          ZipEntry localZipEntry = new ZipEntry(paramFile.getName());
          bool1 = bool2;
          localZipEntry.setMethod(0);
          bool1 = bool2;
          localZipEntry.setCompressedSize(paramFile.length());
          bool1 = bool2;
          localZipEntry.setSize(paramFile.length());
          bool1 = bool2;
          localZipOutputStream.putNextEntry(new ZipEntry(paramFile.getName()));
          bool1 = bool2;
          int i = paramString.read(arrayOfByte);
          if (i != -1)
          {
            bool1 = bool2;
            localZipOutputStream.write(arrayOfByte, 0, i);
            continue;
          }
          try
          {
            Log.e("ZipUtil", "zipFileEx, error:".concat(String.valueOf(paramFile)));
            return bool2;
          }
          finally
          {
            if (paramString == null) {
              continue;
            }
            try
            {
              paramString.close();
              if (localZipOutputStream != null)
              {
                localZipOutputStream.closeEntry();
                localZipOutputStream.close();
              }
            }
            catch (IOException paramString)
            {
              Log.e("ZipUtil", "zipFileEx, error:".concat(String.valueOf(paramString)));
              continue;
            }
            AppMethodBeat.o(212600);
          }
        }
        finally {}
      }
      finally
      {
        paramString = null;
        continue;
      }
      bool2 = true;
      bool1 = true;
      localZipOutputStream.flush();
      try
      {
        paramString.close();
        localZipOutputStream.closeEntry();
        localZipOutputStream.close();
      }
      catch (IOException paramFile)
      {
        Log.e("ZipUtil", "zipFileEx, error:".concat(String.valueOf(paramFile)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.util.n
 * JD-Core Version:    0.7.0.1
 */