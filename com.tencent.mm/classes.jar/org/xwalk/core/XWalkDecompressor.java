package org.xwalk.core;

import android.content.Context;
import android.content.res.Resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

class XWalkDecompressor
{
  private static final int LZMA_OUTSIZE = 8;
  private static final int LZMA_PROP_SIZE = 5;
  private static final String[] MANDATORY_LIBRARIES = { "libxwalkcore.so" };
  private static final String[] MANDATORY_RESOURCES = XWalkEnvironment.MANDATORY_RESOURCES;
  private static final int STREAM_BUFFER_SIZE = 1048576;
  private static final String TAG = "XWalkLib";
  
  public static void copyApkToLocal(String paramString1, String paramString2)
  {
    Log.d("XWalkLib", "Copy to local from Apk " + paramString1);
    try
    {
      paramString1 = new FileInputStream(new File(paramString1));
      paramString2 = new File(paramString2);
      if (paramString2.exists()) {
        paramString2.delete();
      }
      paramString2 = new FileOutputStream(paramString2);
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramString1.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramString2.write(arrayOfByte, 0, i);
      }
      paramString1.close();
    }
    catch (Exception paramString1)
    {
      Log.e("copyApkToLocal error:", paramString1.getMessage());
      return;
    }
    paramString2.close();
  }
  
  /* Error */
  public static boolean decompressDownloadFullZip(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 18
    //   2: new 41	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 105
    //   8: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: ldc 107
    //   17: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: iload_1
    //   21: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 113	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: invokestatic 119	android/os/SystemClock:uptimeMillis	()J
    //   33: lstore_3
    //   34: new 121	java/util/zip/ZipFile
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 122	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   42: astore 5
    //   44: aload 5
    //   46: astore_0
    //   47: aload 5
    //   49: invokevirtual 126	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   52: astore 7
    //   54: aload 5
    //   56: astore_0
    //   57: aload 7
    //   59: invokeinterface 131 1 0
    //   64: ifeq +346 -> 410
    //   67: aload 5
    //   69: astore_0
    //   70: aload 7
    //   72: invokeinterface 135 1 0
    //   77: checkcast 137	java/util/zip/ZipEntry
    //   80: astore 8
    //   82: aload 5
    //   84: astore_0
    //   85: aload 8
    //   87: invokevirtual 140	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   90: ldc 142
    //   92: invokestatic 148	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   95: astore 6
    //   97: aload 5
    //   99: astore_0
    //   100: ldc 18
    //   102: new 41	java/lang/StringBuilder
    //   105: dup
    //   106: ldc 150
    //   108: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: aload 6
    //   113: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 113	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload 5
    //   124: astore_0
    //   125: aload 6
    //   127: ldc 152
    //   129: invokevirtual 156	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   132: ifne -78 -> 54
    //   135: aload 5
    //   137: astore_0
    //   138: aload 6
    //   140: ldc 158
    //   142: invokevirtual 156	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   145: ifne -91 -> 54
    //   148: aload 5
    //   150: astore_0
    //   151: aload 8
    //   153: invokevirtual 161	java/util/zip/ZipEntry:isDirectory	()Z
    //   156: ifne -102 -> 54
    //   159: aload 5
    //   161: astore_0
    //   162: aload 5
    //   164: aload 8
    //   166: invokevirtual 165	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   169: astore 8
    //   171: aload 5
    //   173: astore_0
    //   174: aload 6
    //   176: ldc 167
    //   178: invokevirtual 171	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   181: ifeq +125 -> 306
    //   184: aload 5
    //   186: astore_0
    //   187: new 63	java/io/File
    //   190: dup
    //   191: iload_1
    //   192: invokestatic 175	org/xwalk/core/XWalkEnvironment:getDownloadApkPath	(I)Ljava/lang/String;
    //   195: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   198: astore 6
    //   200: aload 5
    //   202: astore_0
    //   203: aload 6
    //   205: invokevirtual 71	java/io/File:exists	()Z
    //   208: ifne +156 -> 364
    //   211: aload 5
    //   213: astore_0
    //   214: aload 6
    //   216: invokevirtual 179	java/io/File:getParentFile	()Ljava/io/File;
    //   219: astore 9
    //   221: aload 5
    //   223: astore_0
    //   224: aload 9
    //   226: invokevirtual 71	java/io/File:exists	()Z
    //   229: ifne +12 -> 241
    //   232: aload 5
    //   234: astore_0
    //   235: aload 9
    //   237: invokevirtual 182	java/io/File:mkdirs	()Z
    //   240: pop
    //   241: aload 5
    //   243: astore_0
    //   244: new 76	java/io/FileOutputStream
    //   247: dup
    //   248: aload 6
    //   250: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   253: astore 6
    //   255: aload 5
    //   257: astore_0
    //   258: ldc 14
    //   260: newarray byte
    //   262: astore 9
    //   264: aload 5
    //   266: astore_0
    //   267: aload 8
    //   269: aload 9
    //   271: invokevirtual 185	java/io/InputStream:read	([B)I
    //   274: istore_2
    //   275: iload_2
    //   276: iconst_m1
    //   277: if_icmpeq +114 -> 391
    //   280: aload 5
    //   282: astore_0
    //   283: aload 6
    //   285: aload 9
    //   287: iconst_0
    //   288: iload_2
    //   289: invokevirtual 188	java/io/OutputStream:write	([BII)V
    //   292: aload 5
    //   294: astore_0
    //   295: aload 8
    //   297: aload 9
    //   299: invokevirtual 185	java/io/InputStream:read	([B)I
    //   302: istore_2
    //   303: goto -28 -> 275
    //   306: aload 5
    //   308: astore_0
    //   309: new 63	java/io/File
    //   312: dup
    //   313: iload_1
    //   314: aload 6
    //   316: invokestatic 192	org/xwalk/core/XWalkEnvironment:getExtractedCoreFile	(ILjava/lang/String;)Ljava/lang/String;
    //   319: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   322: astore 6
    //   324: goto -124 -> 200
    //   327: astore 6
    //   329: aload 5
    //   331: astore_0
    //   332: ldc 18
    //   334: new 41	java/lang/StringBuilder
    //   337: dup
    //   338: ldc 194
    //   340: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   343: aload 6
    //   345: invokevirtual 197	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   348: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 93	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload 5
    //   359: invokevirtual 198	java/util/zip/ZipFile:close	()V
    //   362: iconst_0
    //   363: ireturn
    //   364: aload 5
    //   366: astore_0
    //   367: aload 6
    //   369: invokevirtual 74	java/io/File:delete	()Z
    //   372: pop
    //   373: goto -132 -> 241
    //   376: astore 6
    //   378: aload_0
    //   379: astore 5
    //   381: aload 6
    //   383: astore_0
    //   384: aload 5
    //   386: invokevirtual 198	java/util/zip/ZipFile:close	()V
    //   389: aload_0
    //   390: athrow
    //   391: aload 5
    //   393: astore_0
    //   394: aload 6
    //   396: invokevirtual 199	java/io/OutputStream:close	()V
    //   399: aload 5
    //   401: astore_0
    //   402: aload 8
    //   404: invokevirtual 200	java/io/InputStream:close	()V
    //   407: goto -353 -> 54
    //   410: aload 5
    //   412: invokevirtual 198	java/util/zip/ZipFile:close	()V
    //   415: invokestatic 205	java/lang/System:gc	()V
    //   418: ldc 18
    //   420: new 41	java/lang/StringBuilder
    //   423: dup
    //   424: ldc 207
    //   426: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   429: invokestatic 119	android/os/SystemClock:uptimeMillis	()J
    //   432: lload_3
    //   433: lsub
    //   434: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   437: ldc 212
    //   439: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokestatic 59	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   448: iconst_1
    //   449: ireturn
    //   450: astore_0
    //   451: goto -36 -> 415
    //   454: astore_0
    //   455: goto -40 -> 415
    //   458: astore_0
    //   459: goto -97 -> 362
    //   462: astore_0
    //   463: goto -101 -> 362
    //   466: astore 5
    //   468: goto -79 -> 389
    //   471: astore 5
    //   473: goto -84 -> 389
    //   476: astore_0
    //   477: aconst_null
    //   478: astore 5
    //   480: goto -96 -> 384
    //   483: astore 6
    //   485: aconst_null
    //   486: astore 5
    //   488: goto -159 -> 329
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	491	0	paramString	String
    //   0	491	1	paramInt	int
    //   274	29	2	i	int
    //   33	400	3	l	long
    //   42	369	5	localObject1	Object
    //   466	1	5	localIOException1	java.io.IOException
    //   471	1	5	localNullPointerException	java.lang.NullPointerException
    //   478	9	5	localObject2	Object
    //   95	228	6	localObject3	Object
    //   327	41	6	localIOException2	java.io.IOException
    //   376	19	6	localObject4	Object
    //   483	1	6	localIOException3	java.io.IOException
    //   52	19	7	localEnumeration	java.util.Enumeration
    //   80	323	8	localObject5	Object
    //   219	79	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   47	54	327	java/io/IOException
    //   57	67	327	java/io/IOException
    //   70	82	327	java/io/IOException
    //   85	97	327	java/io/IOException
    //   100	122	327	java/io/IOException
    //   125	135	327	java/io/IOException
    //   138	148	327	java/io/IOException
    //   151	159	327	java/io/IOException
    //   162	171	327	java/io/IOException
    //   174	184	327	java/io/IOException
    //   187	200	327	java/io/IOException
    //   203	211	327	java/io/IOException
    //   214	221	327	java/io/IOException
    //   224	232	327	java/io/IOException
    //   235	241	327	java/io/IOException
    //   244	255	327	java/io/IOException
    //   258	264	327	java/io/IOException
    //   267	275	327	java/io/IOException
    //   283	292	327	java/io/IOException
    //   295	303	327	java/io/IOException
    //   309	324	327	java/io/IOException
    //   367	373	327	java/io/IOException
    //   394	399	327	java/io/IOException
    //   402	407	327	java/io/IOException
    //   47	54	376	finally
    //   57	67	376	finally
    //   70	82	376	finally
    //   85	97	376	finally
    //   100	122	376	finally
    //   125	135	376	finally
    //   138	148	376	finally
    //   151	159	376	finally
    //   162	171	376	finally
    //   174	184	376	finally
    //   187	200	376	finally
    //   203	211	376	finally
    //   214	221	376	finally
    //   224	232	376	finally
    //   235	241	376	finally
    //   244	255	376	finally
    //   258	264	376	finally
    //   267	275	376	finally
    //   283	292	376	finally
    //   295	303	376	finally
    //   309	324	376	finally
    //   332	357	376	finally
    //   367	373	376	finally
    //   394	399	376	finally
    //   402	407	376	finally
    //   410	415	450	java/io/IOException
    //   410	415	454	java/lang/NullPointerException
    //   357	362	458	java/io/IOException
    //   357	362	462	java/lang/NullPointerException
    //   384	389	466	java/io/IOException
    //   384	389	471	java/lang/NullPointerException
    //   34	44	476	finally
    //   34	44	483	java/io/IOException
  }
  
  /* Error */
  public static boolean decompressDownloadPatchZip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 18
    //   2: new 41	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 216
    //   8: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18: invokestatic 59	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: invokestatic 119	android/os/SystemClock:uptimeMillis	()J
    //   24: lstore_3
    //   25: new 121	java/util/zip/ZipFile
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 122	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   33: astore 5
    //   35: aload 5
    //   37: astore_0
    //   38: aload 5
    //   40: invokevirtual 126	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   43: astore 6
    //   45: aload 5
    //   47: astore_0
    //   48: aload 6
    //   50: invokeinterface 131 1 0
    //   55: ifeq +287 -> 342
    //   58: aload 5
    //   60: astore_0
    //   61: aload 6
    //   63: invokeinterface 135 1 0
    //   68: checkcast 137	java/util/zip/ZipEntry
    //   71: astore 7
    //   73: aload 5
    //   75: astore_0
    //   76: aload 7
    //   78: invokevirtual 140	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   81: ldc 142
    //   83: invokestatic 148	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: astore 8
    //   88: aload 5
    //   90: astore_0
    //   91: aload 8
    //   93: ldc 152
    //   95: invokevirtual 156	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   98: ifne -53 -> 45
    //   101: aload 5
    //   103: astore_0
    //   104: aload 8
    //   106: ldc 158
    //   108: invokevirtual 156	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   111: ifne -66 -> 45
    //   114: aload 5
    //   116: astore_0
    //   117: aload 7
    //   119: invokevirtual 161	java/util/zip/ZipEntry:isDirectory	()Z
    //   122: ifne -77 -> 45
    //   125: aload 5
    //   127: astore_0
    //   128: aload 5
    //   130: aload 7
    //   132: invokevirtual 165	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   135: astore 7
    //   137: aload 5
    //   139: astore_0
    //   140: new 63	java/io/File
    //   143: dup
    //   144: aload_1
    //   145: aload 8
    //   147: invokespecial 218	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: astore 8
    //   152: aload 5
    //   154: astore_0
    //   155: aload 8
    //   157: invokevirtual 71	java/io/File:exists	()Z
    //   160: ifne +98 -> 258
    //   163: aload 5
    //   165: astore_0
    //   166: aload 8
    //   168: invokevirtual 179	java/io/File:getParentFile	()Ljava/io/File;
    //   171: astore 9
    //   173: aload 5
    //   175: astore_0
    //   176: aload 9
    //   178: invokevirtual 71	java/io/File:exists	()Z
    //   181: ifne +12 -> 193
    //   184: aload 5
    //   186: astore_0
    //   187: aload 9
    //   189: invokevirtual 182	java/io/File:mkdirs	()Z
    //   192: pop
    //   193: aload 5
    //   195: astore_0
    //   196: new 76	java/io/FileOutputStream
    //   199: dup
    //   200: aload 8
    //   202: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   205: astore 8
    //   207: aload 5
    //   209: astore_0
    //   210: ldc 14
    //   212: newarray byte
    //   214: astore 9
    //   216: aload 5
    //   218: astore_0
    //   219: aload 7
    //   221: aload 9
    //   223: invokevirtual 185	java/io/InputStream:read	([B)I
    //   226: istore_2
    //   227: iload_2
    //   228: iconst_m1
    //   229: if_icmpeq +81 -> 310
    //   232: aload 5
    //   234: astore_0
    //   235: aload 8
    //   237: aload 9
    //   239: iconst_0
    //   240: iload_2
    //   241: invokevirtual 188	java/io/OutputStream:write	([BII)V
    //   244: aload 5
    //   246: astore_0
    //   247: aload 7
    //   249: aload 9
    //   251: invokevirtual 185	java/io/InputStream:read	([B)I
    //   254: istore_2
    //   255: goto -28 -> 227
    //   258: aload 5
    //   260: astore_0
    //   261: aload 8
    //   263: invokevirtual 74	java/io/File:delete	()Z
    //   266: pop
    //   267: goto -74 -> 193
    //   270: astore_0
    //   271: aload 5
    //   273: astore_1
    //   274: aload_0
    //   275: astore 5
    //   277: aload_1
    //   278: astore_0
    //   279: ldc 18
    //   281: new 41	java/lang/StringBuilder
    //   284: dup
    //   285: ldc 194
    //   287: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   290: aload 5
    //   292: invokevirtual 197	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   295: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 93	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload_1
    //   305: invokevirtual 198	java/util/zip/ZipFile:close	()V
    //   308: iconst_0
    //   309: ireturn
    //   310: aload 5
    //   312: astore_0
    //   313: aload 8
    //   315: invokevirtual 199	java/io/OutputStream:close	()V
    //   318: aload 5
    //   320: astore_0
    //   321: aload 7
    //   323: invokevirtual 200	java/io/InputStream:close	()V
    //   326: goto -281 -> 45
    //   329: astore 5
    //   331: aload_0
    //   332: astore_1
    //   333: aload 5
    //   335: astore_0
    //   336: aload_1
    //   337: invokevirtual 198	java/util/zip/ZipFile:close	()V
    //   340: aload_0
    //   341: athrow
    //   342: aload 5
    //   344: invokevirtual 198	java/util/zip/ZipFile:close	()V
    //   347: invokestatic 205	java/lang/System:gc	()V
    //   350: ldc 18
    //   352: new 41	java/lang/StringBuilder
    //   355: dup
    //   356: ldc 207
    //   358: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   361: invokestatic 119	android/os/SystemClock:uptimeMillis	()J
    //   364: lload_3
    //   365: lsub
    //   366: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   369: ldc 212
    //   371: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 59	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: iconst_1
    //   381: ireturn
    //   382: astore_0
    //   383: goto -36 -> 347
    //   386: astore_0
    //   387: goto -40 -> 347
    //   390: astore_0
    //   391: goto -83 -> 308
    //   394: astore_0
    //   395: goto -87 -> 308
    //   398: astore_1
    //   399: goto -59 -> 340
    //   402: astore_1
    //   403: goto -63 -> 340
    //   406: astore_0
    //   407: aconst_null
    //   408: astore_1
    //   409: goto -73 -> 336
    //   412: astore 5
    //   414: aconst_null
    //   415: astore_1
    //   416: goto -139 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	paramString1	String
    //   0	419	1	paramString2	String
    //   226	29	2	i	int
    //   24	341	3	l	long
    //   33	286	5	localObject1	Object
    //   329	14	5	localObject2	Object
    //   412	1	5	localIOException	java.io.IOException
    //   43	19	6	localEnumeration	java.util.Enumeration
    //   71	251	7	localObject3	Object
    //   86	228	8	localObject4	Object
    //   171	79	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   38	45	270	java/io/IOException
    //   48	58	270	java/io/IOException
    //   61	73	270	java/io/IOException
    //   76	88	270	java/io/IOException
    //   91	101	270	java/io/IOException
    //   104	114	270	java/io/IOException
    //   117	125	270	java/io/IOException
    //   128	137	270	java/io/IOException
    //   140	152	270	java/io/IOException
    //   155	163	270	java/io/IOException
    //   166	173	270	java/io/IOException
    //   176	184	270	java/io/IOException
    //   187	193	270	java/io/IOException
    //   196	207	270	java/io/IOException
    //   210	216	270	java/io/IOException
    //   219	227	270	java/io/IOException
    //   235	244	270	java/io/IOException
    //   247	255	270	java/io/IOException
    //   261	267	270	java/io/IOException
    //   313	318	270	java/io/IOException
    //   321	326	270	java/io/IOException
    //   38	45	329	finally
    //   48	58	329	finally
    //   61	73	329	finally
    //   76	88	329	finally
    //   91	101	329	finally
    //   104	114	329	finally
    //   117	125	329	finally
    //   128	137	329	finally
    //   140	152	329	finally
    //   155	163	329	finally
    //   166	173	329	finally
    //   176	184	329	finally
    //   187	193	329	finally
    //   196	207	329	finally
    //   210	216	329	finally
    //   219	227	329	finally
    //   235	244	329	finally
    //   247	255	329	finally
    //   261	267	329	finally
    //   279	304	329	finally
    //   313	318	329	finally
    //   321	326	329	finally
    //   342	347	382	java/io/IOException
    //   342	347	386	java/lang/NullPointerException
    //   304	308	390	java/io/IOException
    //   304	308	394	java/lang/NullPointerException
    //   336	340	398	java/io/IOException
    //   336	340	402	java/lang/NullPointerException
    //   25	35	406	finally
    //   25	35	412	java/io/IOException
  }
  
  /* Error */
  private static void extractLzmaToFile(InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 222	java/io/BufferedInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 225	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   10: astore 6
    //   12: new 227	java/io/BufferedOutputStream
    //   15: dup
    //   16: new 76	java/io/FileOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   24: invokespecial 230	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore_0
    //   28: aload_0
    //   29: astore 7
    //   31: aload 6
    //   33: astore 8
    //   35: iconst_5
    //   36: newarray byte
    //   38: astore 9
    //   40: aload_0
    //   41: astore 7
    //   43: aload 6
    //   45: astore 8
    //   47: aload 6
    //   49: aload 9
    //   51: iconst_0
    //   52: iconst_5
    //   53: invokevirtual 233	java/io/InputStream:read	([BII)I
    //   56: iconst_5
    //   57: if_icmpeq +80 -> 137
    //   60: aload_0
    //   61: astore 7
    //   63: aload 6
    //   65: astore 8
    //   67: new 101	java/io/IOException
    //   70: dup
    //   71: ldc 235
    //   73: invokespecial 236	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   76: athrow
    //   77: astore 9
    //   79: aload_0
    //   80: astore 7
    //   82: aload 6
    //   84: astore 8
    //   86: aload_1
    //   87: invokevirtual 239	java/io/File:isFile	()Z
    //   90: ifeq +15 -> 105
    //   93: aload_0
    //   94: astore 7
    //   96: aload 6
    //   98: astore 8
    //   100: aload_1
    //   101: invokevirtual 74	java/io/File:delete	()Z
    //   104: pop
    //   105: aload_0
    //   106: astore 7
    //   108: aload 6
    //   110: astore 8
    //   112: aload 9
    //   114: athrow
    //   115: astore_0
    //   116: aload 8
    //   118: astore 6
    //   120: aload 7
    //   122: invokevirtual 242	java/io/OutputStream:flush	()V
    //   125: aload 7
    //   127: invokevirtual 199	java/io/OutputStream:close	()V
    //   130: aload 6
    //   132: invokevirtual 200	java/io/InputStream:close	()V
    //   135: aload_0
    //   136: athrow
    //   137: aload_0
    //   138: astore 7
    //   140: aload 6
    //   142: astore 8
    //   144: new 244	f/a/b/a
    //   147: dup
    //   148: invokespecial 245	f/a/b/a:<init>	()V
    //   151: astore 10
    //   153: aload_0
    //   154: astore 7
    //   156: aload 6
    //   158: astore 8
    //   160: aload 10
    //   162: aload 9
    //   164: invokevirtual 249	f/a/b/a:ck	([B)Z
    //   167: ifne +191 -> 358
    //   170: aload_0
    //   171: astore 7
    //   173: aload 6
    //   175: astore 8
    //   177: new 101	java/io/IOException
    //   180: dup
    //   181: ldc 251
    //   183: invokespecial 236	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   186: athrow
    //   187: iload_2
    //   188: bipush 8
    //   190: if_icmpge +38 -> 228
    //   193: aload_0
    //   194: astore 7
    //   196: aload 6
    //   198: astore 8
    //   200: aload 6
    //   202: invokevirtual 254	java/io/InputStream:read	()I
    //   205: istore_3
    //   206: iload_3
    //   207: ifge +157 -> 364
    //   210: aload_0
    //   211: astore 7
    //   213: aload 6
    //   215: astore 8
    //   217: ldc 18
    //   219: ldc_w 256
    //   222: invokestatic 259	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: goto +139 -> 364
    //   228: aload_0
    //   229: astore 7
    //   231: aload 6
    //   233: astore 8
    //   235: aload 10
    //   237: aload 6
    //   239: aload_0
    //   240: lload 4
    //   242: invokevirtual 263	f/a/b/a:a	(Ljava/io/InputStream;Ljava/io/OutputStream;J)Z
    //   245: ifne +21 -> 266
    //   248: aload_0
    //   249: astore 7
    //   251: aload 6
    //   253: astore 8
    //   255: new 101	java/io/IOException
    //   258: dup
    //   259: ldc_w 265
    //   262: invokespecial 236	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   265: athrow
    //   266: aload_0
    //   267: invokevirtual 242	java/io/OutputStream:flush	()V
    //   270: aload_0
    //   271: invokevirtual 199	java/io/OutputStream:close	()V
    //   274: aload 6
    //   276: invokevirtual 200	java/io/InputStream:close	()V
    //   279: return
    //   280: astore_1
    //   281: goto -11 -> 270
    //   284: astore_1
    //   285: goto -15 -> 270
    //   288: astore_0
    //   289: goto -15 -> 274
    //   292: astore_0
    //   293: goto -19 -> 274
    //   296: astore_0
    //   297: return
    //   298: astore_0
    //   299: return
    //   300: astore_1
    //   301: goto -176 -> 125
    //   304: astore_1
    //   305: goto -180 -> 125
    //   308: astore_1
    //   309: goto -179 -> 130
    //   312: astore_1
    //   313: goto -183 -> 130
    //   316: astore_1
    //   317: goto -182 -> 135
    //   320: astore_1
    //   321: goto -186 -> 135
    //   324: astore_0
    //   325: aconst_null
    //   326: astore 7
    //   328: aconst_null
    //   329: astore 6
    //   331: goto -211 -> 120
    //   334: astore_0
    //   335: aconst_null
    //   336: astore 7
    //   338: goto -218 -> 120
    //   341: astore 9
    //   343: aconst_null
    //   344: astore_0
    //   345: aconst_null
    //   346: astore 6
    //   348: goto -269 -> 79
    //   351: astore 9
    //   353: aconst_null
    //   354: astore_0
    //   355: goto -276 -> 79
    //   358: lconst_0
    //   359: lstore 4
    //   361: goto -174 -> 187
    //   364: lload 4
    //   366: iload_3
    //   367: i2l
    //   368: iload_2
    //   369: bipush 8
    //   371: imul
    //   372: lshl
    //   373: lor
    //   374: lstore 4
    //   376: iload_2
    //   377: iconst_1
    //   378: iadd
    //   379: istore_2
    //   380: goto -193 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	paramInputStream	InputStream
    //   0	383	1	paramFile	File
    //   1	379	2	i	int
    //   205	162	3	j	int
    //   240	1	4	localObject1	Object
    //   359	16	4	l	long
    //   10	337	6	localObject2	Object
    //   29	308	7	localInputStream	InputStream
    //   33	221	8	localObject3	Object
    //   38	12	9	arrayOfByte	byte[]
    //   77	86	9	localIOException1	java.io.IOException
    //   341	1	9	localIOException2	java.io.IOException
    //   351	1	9	localIOException3	java.io.IOException
    //   151	85	10	locala	f.a.b.a
    // Exception table:
    //   from	to	target	type
    //   35	40	77	java/io/IOException
    //   47	60	77	java/io/IOException
    //   67	77	77	java/io/IOException
    //   144	153	77	java/io/IOException
    //   160	170	77	java/io/IOException
    //   177	187	77	java/io/IOException
    //   200	206	77	java/io/IOException
    //   217	225	77	java/io/IOException
    //   235	248	77	java/io/IOException
    //   255	266	77	java/io/IOException
    //   35	40	115	finally
    //   47	60	115	finally
    //   67	77	115	finally
    //   86	93	115	finally
    //   100	105	115	finally
    //   112	115	115	finally
    //   144	153	115	finally
    //   160	170	115	finally
    //   177	187	115	finally
    //   200	206	115	finally
    //   217	225	115	finally
    //   235	248	115	finally
    //   255	266	115	finally
    //   266	270	280	java/io/IOException
    //   266	270	284	java/lang/NullPointerException
    //   270	274	288	java/io/IOException
    //   270	274	292	java/lang/NullPointerException
    //   274	279	296	java/io/IOException
    //   274	279	298	java/lang/NullPointerException
    //   120	125	300	java/io/IOException
    //   120	125	304	java/lang/NullPointerException
    //   125	130	308	java/io/IOException
    //   125	130	312	java/lang/NullPointerException
    //   130	135	316	java/io/IOException
    //   130	135	320	java/lang/NullPointerException
    //   2	12	324	finally
    //   12	28	334	finally
    //   2	12	341	java/io/IOException
    //   12	28	351	java/io/IOException
  }
  
  /* Error */
  public static boolean extractResource(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 18
    //   2: new 41	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 268
    //   9: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: invokestatic 113	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: invokestatic 119	android/os/SystemClock:uptimeMillis	()J
    //   25: lstore 4
    //   27: new 121	java/util/zip/ZipFile
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 122	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   35: astore 7
    //   37: aload 7
    //   39: astore_0
    //   40: getstatic 31	org/xwalk/core/XWalkDecompressor:MANDATORY_RESOURCES	[Ljava/lang/String;
    //   43: astore 8
    //   45: aload 7
    //   47: astore_0
    //   48: aload 8
    //   50: arraylength
    //   51: istore_3
    //   52: iconst_0
    //   53: istore_2
    //   54: iload_2
    //   55: iload_3
    //   56: if_icmpge +272 -> 328
    //   59: aload 8
    //   61: iload_2
    //   62: aaload
    //   63: astore 9
    //   65: aload 7
    //   67: astore_0
    //   68: aload 9
    //   70: invokestatic 272	org/xwalk/core/XWalkDecompressor:isNativeLibrary	(Ljava/lang/String;)Z
    //   73: ifeq +90 -> 163
    //   76: aload 7
    //   78: astore_0
    //   79: aload 7
    //   81: new 41	java/lang/StringBuilder
    //   84: dup
    //   85: ldc_w 274
    //   88: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: getstatic 277	java/io/File:separator	Ljava/lang/String;
    //   94: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 279
    //   100: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: getstatic 277	java/io/File:separator	Ljava/lang/String;
    //   106: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 9
    //   111: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokevirtual 283	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   120: astore 6
    //   122: aload 6
    //   124: ifnonnull +102 -> 226
    //   127: aload 7
    //   129: astore_0
    //   130: ldc 18
    //   132: new 41	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   139: aload 9
    //   141: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc_w 286
    //   147: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 93	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload 7
    //   158: invokevirtual 198	java/util/zip/ZipFile:close	()V
    //   161: iconst_0
    //   162: ireturn
    //   163: aload 7
    //   165: astore_0
    //   166: aload 9
    //   168: invokestatic 289	org/xwalk/core/XWalkDecompressor:isAsset	(Ljava/lang/String;)Z
    //   171: ifeq +40 -> 211
    //   174: aload 7
    //   176: astore_0
    //   177: aload 7
    //   179: new 41	java/lang/StringBuilder
    //   182: dup
    //   183: ldc_w 291
    //   186: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   189: getstatic 277	java/io/File:separator	Ljava/lang/String;
    //   192: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 9
    //   197: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokevirtual 283	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   206: astore 6
    //   208: goto -86 -> 122
    //   211: aload 7
    //   213: astore_0
    //   214: aload 7
    //   216: aload 9
    //   218: invokevirtual 283	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   221: astore 6
    //   223: goto -101 -> 122
    //   226: aload 7
    //   228: astore_0
    //   229: ldc 18
    //   231: new 41	java/lang/StringBuilder
    //   234: dup
    //   235: ldc_w 293
    //   238: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   241: aload 9
    //   243: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 59	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload 7
    //   254: astore_0
    //   255: new 63	java/io/File
    //   258: dup
    //   259: aload_1
    //   260: aload 9
    //   262: invokespecial 218	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: astore 10
    //   267: aload 7
    //   269: astore_0
    //   270: aload 10
    //   272: invokevirtual 239	java/io/File:isFile	()Z
    //   275: ifeq +23 -> 298
    //   278: aload 7
    //   280: astore_0
    //   281: aload 10
    //   283: invokevirtual 71	java/io/File:exists	()Z
    //   286: ifeq +12 -> 298
    //   289: aload 7
    //   291: astore_0
    //   292: aload 10
    //   294: invokevirtual 74	java/io/File:delete	()Z
    //   297: pop
    //   298: aload 7
    //   300: astore_0
    //   301: aload 7
    //   303: aload 6
    //   305: invokevirtual 165	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   308: new 63	java/io/File
    //   311: dup
    //   312: aload_1
    //   313: aload 9
    //   315: invokespecial 218	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: invokestatic 296	org/xwalk/core/XWalkDecompressor:extractStreamToFile	(Ljava/io/InputStream;Ljava/io/File;)V
    //   321: iload_2
    //   322: iconst_1
    //   323: iadd
    //   324: istore_2
    //   325: goto -271 -> 54
    //   328: aload 7
    //   330: invokevirtual 198	java/util/zip/ZipFile:close	()V
    //   333: invokestatic 205	java/lang/System:gc	()V
    //   336: ldc 18
    //   338: new 41	java/lang/StringBuilder
    //   341: dup
    //   342: ldc_w 298
    //   345: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   348: invokestatic 119	android/os/SystemClock:uptimeMillis	()J
    //   351: lload 4
    //   353: lsub
    //   354: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   357: ldc 212
    //   359: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 59	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: iconst_1
    //   369: ireturn
    //   370: astore 6
    //   372: aconst_null
    //   373: astore_1
    //   374: aload_1
    //   375: astore_0
    //   376: ldc 18
    //   378: new 41	java/lang/StringBuilder
    //   381: dup
    //   382: ldc_w 300
    //   385: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   388: aload 6
    //   390: invokevirtual 197	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   393: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 93	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: aload_1
    //   403: invokevirtual 198	java/util/zip/ZipFile:close	()V
    //   406: iconst_0
    //   407: ireturn
    //   408: astore_0
    //   409: iconst_0
    //   410: ireturn
    //   411: astore_1
    //   412: aconst_null
    //   413: astore_0
    //   414: aload_0
    //   415: invokevirtual 198	java/util/zip/ZipFile:close	()V
    //   418: aload_1
    //   419: athrow
    //   420: astore_0
    //   421: iconst_0
    //   422: ireturn
    //   423: astore_0
    //   424: iconst_0
    //   425: ireturn
    //   426: astore_0
    //   427: goto -94 -> 333
    //   430: astore_0
    //   431: goto -98 -> 333
    //   434: astore_0
    //   435: iconst_0
    //   436: ireturn
    //   437: astore_0
    //   438: goto -20 -> 418
    //   441: astore_0
    //   442: goto -24 -> 418
    //   445: astore_1
    //   446: goto -32 -> 414
    //   449: astore 6
    //   451: aload 7
    //   453: astore_1
    //   454: goto -80 -> 374
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	paramString1	String
    //   0	457	1	paramString2	String
    //   53	272	2	i	int
    //   51	6	3	j	int
    //   25	327	4	l	long
    //   120	184	6	localZipEntry	java.util.zip.ZipEntry
    //   370	19	6	localIOException1	java.io.IOException
    //   449	1	6	localIOException2	java.io.IOException
    //   35	417	7	localZipFile	java.util.zip.ZipFile
    //   43	17	8	arrayOfString	String[]
    //   63	251	9	str	String
    //   265	28	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   27	37	370	java/io/IOException
    //   402	406	408	java/io/IOException
    //   27	37	411	finally
    //   156	161	420	java/io/IOException
    //   156	161	423	java/lang/NullPointerException
    //   328	333	426	java/io/IOException
    //   328	333	430	java/lang/NullPointerException
    //   402	406	434	java/lang/NullPointerException
    //   414	418	437	java/io/IOException
    //   414	418	441	java/lang/NullPointerException
    //   40	45	445	finally
    //   48	52	445	finally
    //   68	76	445	finally
    //   79	122	445	finally
    //   130	156	445	finally
    //   166	174	445	finally
    //   177	208	445	finally
    //   214	223	445	finally
    //   229	252	445	finally
    //   255	267	445	finally
    //   270	278	445	finally
    //   281	289	445	finally
    //   292	298	445	finally
    //   301	321	445	finally
    //   376	402	445	finally
    //   40	45	449	java/io/IOException
    //   48	52	449	java/io/IOException
    //   68	76	449	java/io/IOException
    //   79	122	449	java/io/IOException
    //   130	156	449	java/io/IOException
    //   166	174	449	java/io/IOException
    //   177	208	449	java/io/IOException
    //   214	223	449	java/io/IOException
    //   229	252	449	java/io/IOException
    //   255	267	449	java/io/IOException
    //   270	278	449	java/io/IOException
    //   281	289	449	java/io/IOException
    //   292	298	449	java/io/IOException
    //   301	321	449	java/io/IOException
  }
  
  /* Error */
  private static void extractStreamToFile(InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 303	java/io/InputStream:available	()I
    //   4: pop
    //   5: new 76	java/io/FileOutputStream
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   13: astore 4
    //   15: aload 4
    //   17: astore_3
    //   18: ldc 14
    //   20: newarray byte
    //   22: astore 5
    //   24: aload 4
    //   26: astore_3
    //   27: aload_0
    //   28: aload 5
    //   30: invokevirtual 185	java/io/InputStream:read	([B)I
    //   33: istore_2
    //   34: iload_2
    //   35: iflt +59 -> 94
    //   38: aload 4
    //   40: astore_3
    //   41: aload 4
    //   43: aload 5
    //   45: iconst_0
    //   46: iload_2
    //   47: invokevirtual 188	java/io/OutputStream:write	([BII)V
    //   50: goto -26 -> 24
    //   53: astore 5
    //   55: aload 4
    //   57: astore_3
    //   58: aload_1
    //   59: invokevirtual 239	java/io/File:isFile	()Z
    //   62: ifeq +11 -> 73
    //   65: aload 4
    //   67: astore_3
    //   68: aload_1
    //   69: invokevirtual 74	java/io/File:delete	()Z
    //   72: pop
    //   73: aload 4
    //   75: astore_3
    //   76: aload 5
    //   78: athrow
    //   79: astore_1
    //   80: aload_3
    //   81: invokevirtual 242	java/io/OutputStream:flush	()V
    //   84: aload_3
    //   85: invokevirtual 199	java/io/OutputStream:close	()V
    //   88: aload_0
    //   89: invokevirtual 200	java/io/InputStream:close	()V
    //   92: aload_1
    //   93: athrow
    //   94: aload 4
    //   96: invokevirtual 242	java/io/OutputStream:flush	()V
    //   99: aload 4
    //   101: invokevirtual 199	java/io/OutputStream:close	()V
    //   104: aload_0
    //   105: invokevirtual 200	java/io/InputStream:close	()V
    //   108: return
    //   109: astore_1
    //   110: goto -11 -> 99
    //   113: astore_1
    //   114: goto -15 -> 99
    //   117: astore_1
    //   118: goto -14 -> 104
    //   121: astore_1
    //   122: goto -18 -> 104
    //   125: astore_0
    //   126: return
    //   127: astore_0
    //   128: return
    //   129: astore 4
    //   131: goto -47 -> 84
    //   134: astore 4
    //   136: goto -52 -> 84
    //   139: astore_3
    //   140: goto -52 -> 88
    //   143: astore_3
    //   144: goto -56 -> 88
    //   147: astore_0
    //   148: goto -56 -> 92
    //   151: astore_0
    //   152: goto -60 -> 92
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_3
    //   158: goto -78 -> 80
    //   161: astore 5
    //   163: aconst_null
    //   164: astore 4
    //   166: goto -111 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramInputStream	InputStream
    //   0	169	1	paramFile	File
    //   33	14	2	i	int
    //   17	68	3	localFileOutputStream1	FileOutputStream
    //   139	1	3	localIOException1	java.io.IOException
    //   143	1	3	localNullPointerException1	java.lang.NullPointerException
    //   157	1	3	localObject1	Object
    //   13	87	4	localFileOutputStream2	FileOutputStream
    //   129	1	4	localIOException2	java.io.IOException
    //   134	1	4	localNullPointerException2	java.lang.NullPointerException
    //   164	1	4	localObject2	Object
    //   22	22	5	arrayOfByte	byte[]
    //   53	24	5	localIOException3	java.io.IOException
    //   161	1	5	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   18	24	53	java/io/IOException
    //   27	34	53	java/io/IOException
    //   41	50	53	java/io/IOException
    //   18	24	79	finally
    //   27	34	79	finally
    //   41	50	79	finally
    //   58	65	79	finally
    //   68	73	79	finally
    //   76	79	79	finally
    //   94	99	109	java/io/IOException
    //   94	99	113	java/lang/NullPointerException
    //   99	104	117	java/io/IOException
    //   99	104	121	java/lang/NullPointerException
    //   104	108	125	java/io/IOException
    //   104	108	127	java/lang/NullPointerException
    //   80	84	129	java/io/IOException
    //   80	84	134	java/lang/NullPointerException
    //   84	88	139	java/io/IOException
    //   84	88	143	java/lang/NullPointerException
    //   88	92	147	java/io/IOException
    //   88	92	151	java/lang/NullPointerException
    //   0	15	155	finally
    //   0	15	161	java/io/IOException
  }
  
  private static boolean isAsset(String paramString)
  {
    return (paramString.endsWith(".dat")) || (paramString.endsWith(".pak")) || (paramString.endsWith(".js"));
  }
  
  private static boolean isNativeLibrary(String paramString)
  {
    return paramString.endsWith(".so");
  }
  
  private static InputStream openRawResource(String paramString)
  {
    Context localContext = XWalkEnvironment.getApplicationContext();
    Resources localResources = localContext.getResources();
    return localResources.openRawResource(localResources.getIdentifier(paramString.split("\\.")[0], "raw", localContext.getPackageName()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     org.xwalk.core.XWalkDecompressor
 * JD-Core Version:    0.7.0.1
 */