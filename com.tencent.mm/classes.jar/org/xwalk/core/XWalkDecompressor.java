package org.xwalk.core;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWalkDecompressor
{
  private static final String TAG = "XWalkDecompressor";
  
  /* Error */
  public static boolean decompressDownloadFullZip(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 18
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 8
    //   7: new 26	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 28
    //   13: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 37
    //   22: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_1
    //   26: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 49	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: invokestatic 55	android/os/SystemClock:uptimeMillis	()J
    //   38: lstore_2
    //   39: new 57	java/util/zip/ZipFile
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 58	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   47: astore 4
    //   49: aload 4
    //   51: astore_0
    //   52: aload 4
    //   54: invokevirtual 62	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   57: astore 6
    //   59: aload 4
    //   61: astore_0
    //   62: aload 6
    //   64: invokeinterface 68 1 0
    //   69: ifeq +282 -> 351
    //   72: aload 4
    //   74: astore_0
    //   75: aload 6
    //   77: invokeinterface 72 1 0
    //   82: checkcast 74	java/util/zip/ZipEntry
    //   85: astore 7
    //   87: aload 4
    //   89: astore_0
    //   90: aload 7
    //   92: invokevirtual 77	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   95: ldc 79
    //   97: invokestatic 85	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 8
    //   102: aload 4
    //   104: astore_0
    //   105: aload 8
    //   107: ldc 87
    //   109: invokevirtual 93	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   112: ifne -53 -> 59
    //   115: aload 4
    //   117: astore_0
    //   118: aload 8
    //   120: ldc 95
    //   122: invokevirtual 93	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   125: ifne -66 -> 59
    //   128: aload 4
    //   130: astore_0
    //   131: aload 7
    //   133: invokevirtual 98	java/util/zip/ZipEntry:isDirectory	()Z
    //   136: ifne -77 -> 59
    //   139: aload 4
    //   141: astore_0
    //   142: aload 8
    //   144: ldc 100
    //   146: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   149: ifeq +149 -> 298
    //   152: aload 4
    //   154: astore_0
    //   155: new 106	java/io/File
    //   158: dup
    //   159: iload_1
    //   160: invokestatic 112	org/xwalk/core/XWalkFileUtil:getDownloadApkPath	(I)Ljava/lang/String;
    //   163: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
    //   166: astore 5
    //   168: aload 4
    //   170: astore_0
    //   171: aload 5
    //   173: invokevirtual 116	java/io/File:exists	()Z
    //   176: ifne +163 -> 339
    //   179: aload 4
    //   181: astore_0
    //   182: aload 5
    //   184: invokevirtual 120	java/io/File:getParentFile	()Ljava/io/File;
    //   187: astore 9
    //   189: aload 4
    //   191: astore_0
    //   192: aload 9
    //   194: invokevirtual 116	java/io/File:exists	()Z
    //   197: ifne +12 -> 209
    //   200: aload 4
    //   202: astore_0
    //   203: aload 9
    //   205: invokevirtual 123	java/io/File:mkdirs	()Z
    //   208: pop
    //   209: aload 4
    //   211: astore_0
    //   212: aload 4
    //   214: aload 7
    //   216: invokevirtual 127	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   219: aload 5
    //   221: invokestatic 133	com/tencent/xweb/util/g:b	(Ljava/io/InputStream;Ljava/io/File;)Z
    //   224: pop
    //   225: aload 4
    //   227: astore_0
    //   228: ldc 8
    //   230: new 26	java/lang/StringBuilder
    //   233: dup
    //   234: ldc 135
    //   236: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   239: aload 8
    //   241: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc 137
    //   246: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload 5
    //   251: invokevirtual 140	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   254: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 49	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: goto -204 -> 59
    //   266: astore 5
    //   268: aload 4
    //   270: astore_0
    //   271: ldc 8
    //   273: ldc 142
    //   275: aload 5
    //   277: invokestatic 146	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   280: invokevirtual 150	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   283: invokestatic 153	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: aload 4
    //   288: invokestatic 157	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   291: ldc 18
    //   293: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: iconst_0
    //   297: ireturn
    //   298: aload 4
    //   300: astore_0
    //   301: new 106	java/io/File
    //   304: dup
    //   305: iload_1
    //   306: aload 8
    //   308: invokestatic 164	org/xwalk/core/XWalkFileUtil:getExtractedCoreFile	(ILjava/lang/String;)Ljava/lang/String;
    //   311: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
    //   314: astore 5
    //   316: goto -148 -> 168
    //   319: astore 5
    //   321: aload_0
    //   322: astore 4
    //   324: aload 5
    //   326: astore_0
    //   327: aload 4
    //   329: invokestatic 157	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   332: ldc 18
    //   334: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   337: aload_0
    //   338: athrow
    //   339: aload 4
    //   341: astore_0
    //   342: aload 5
    //   344: invokevirtual 167	java/io/File:delete	()Z
    //   347: pop
    //   348: goto -139 -> 209
    //   351: aload 4
    //   353: invokestatic 157	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   356: invokestatic 172	java/lang/System:gc	()V
    //   359: ldc 8
    //   361: new 26	java/lang/StringBuilder
    //   364: dup
    //   365: ldc 174
    //   367: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   370: invokestatic 55	android/os/SystemClock:uptimeMillis	()J
    //   373: lload_2
    //   374: lsub
    //   375: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   378: ldc 179
    //   380: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 49	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: ldc 18
    //   391: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: iconst_1
    //   395: ireturn
    //   396: astore_0
    //   397: aconst_null
    //   398: astore 4
    //   400: goto -73 -> 327
    //   403: astore 5
    //   405: aconst_null
    //   406: astore 4
    //   408: goto -140 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	paramString	String
    //   0	411	1	paramInt	int
    //   38	336	2	l	long
    //   47	360	4	localObject1	Object
    //   166	84	5	localFile1	java.io.File
    //   266	10	5	localIOException1	java.io.IOException
    //   314	1	5	localFile2	java.io.File
    //   319	24	5	localObject2	Object
    //   403	1	5	localIOException2	java.io.IOException
    //   57	19	6	localEnumeration	java.util.Enumeration
    //   85	130	7	localZipEntry	java.util.zip.ZipEntry
    //   100	207	8	str	String
    //   187	17	9	localFile3	java.io.File
    // Exception table:
    //   from	to	target	type
    //   52	59	266	java/io/IOException
    //   62	72	266	java/io/IOException
    //   75	87	266	java/io/IOException
    //   90	102	266	java/io/IOException
    //   105	115	266	java/io/IOException
    //   118	128	266	java/io/IOException
    //   131	139	266	java/io/IOException
    //   142	152	266	java/io/IOException
    //   155	168	266	java/io/IOException
    //   171	179	266	java/io/IOException
    //   182	189	266	java/io/IOException
    //   192	200	266	java/io/IOException
    //   203	209	266	java/io/IOException
    //   212	225	266	java/io/IOException
    //   228	263	266	java/io/IOException
    //   301	316	266	java/io/IOException
    //   342	348	266	java/io/IOException
    //   52	59	319	finally
    //   62	72	319	finally
    //   75	87	319	finally
    //   90	102	319	finally
    //   105	115	319	finally
    //   118	128	319	finally
    //   131	139	319	finally
    //   142	152	319	finally
    //   155	168	319	finally
    //   171	179	319	finally
    //   182	189	319	finally
    //   192	200	319	finally
    //   203	209	319	finally
    //   212	225	319	finally
    //   228	263	319	finally
    //   271	286	319	finally
    //   301	316	319	finally
    //   342	348	319	finally
    //   39	49	396	finally
    //   39	49	403	java/io/IOException
  }
  
  /* Error */
  public static boolean decompressDownloadPatchZip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 182
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 8
    //   7: new 26	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 184
    //   13: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 186
    //   22: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 49	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: invokestatic 55	android/os/SystemClock:uptimeMillis	()J
    //   38: lstore_2
    //   39: new 57	java/util/zip/ZipFile
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 58	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   47: astore 4
    //   49: aload 4
    //   51: astore_0
    //   52: aload 4
    //   54: invokevirtual 62	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   57: astore 5
    //   59: aload 4
    //   61: astore_0
    //   62: aload 5
    //   64: invokeinterface 68 1 0
    //   69: ifeq +248 -> 317
    //   72: aload 4
    //   74: astore_0
    //   75: aload 5
    //   77: invokeinterface 72 1 0
    //   82: checkcast 74	java/util/zip/ZipEntry
    //   85: astore 6
    //   87: aload 4
    //   89: astore_0
    //   90: aload 6
    //   92: invokevirtual 77	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   95: ldc 79
    //   97: invokestatic 85	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 7
    //   102: aload 4
    //   104: astore_0
    //   105: aload 7
    //   107: ldc 87
    //   109: invokevirtual 93	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   112: ifne -53 -> 59
    //   115: aload 4
    //   117: astore_0
    //   118: aload 7
    //   120: ldc 95
    //   122: invokevirtual 93	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   125: ifne -66 -> 59
    //   128: aload 4
    //   130: astore_0
    //   131: aload 6
    //   133: invokevirtual 98	java/util/zip/ZipEntry:isDirectory	()Z
    //   136: ifne -77 -> 59
    //   139: aload 4
    //   141: astore_0
    //   142: new 106	java/io/File
    //   145: dup
    //   146: aload_1
    //   147: aload 7
    //   149: invokespecial 188	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: astore 8
    //   154: aload 4
    //   156: astore_0
    //   157: aload 8
    //   159: invokevirtual 116	java/io/File:exists	()Z
    //   162: ifne +125 -> 287
    //   165: aload 4
    //   167: astore_0
    //   168: aload 8
    //   170: invokevirtual 120	java/io/File:getParentFile	()Ljava/io/File;
    //   173: astore 9
    //   175: aload 4
    //   177: astore_0
    //   178: aload 9
    //   180: invokevirtual 116	java/io/File:exists	()Z
    //   183: ifne +12 -> 195
    //   186: aload 4
    //   188: astore_0
    //   189: aload 9
    //   191: invokevirtual 123	java/io/File:mkdirs	()Z
    //   194: pop
    //   195: aload 4
    //   197: astore_0
    //   198: aload 4
    //   200: aload 6
    //   202: invokevirtual 127	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   205: aload 8
    //   207: invokestatic 133	com/tencent/xweb/util/g:b	(Ljava/io/InputStream;Ljava/io/File;)Z
    //   210: pop
    //   211: aload 4
    //   213: astore_0
    //   214: ldc 8
    //   216: new 26	java/lang/StringBuilder
    //   219: dup
    //   220: ldc 190
    //   222: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   225: aload 7
    //   227: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc 137
    //   232: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload 8
    //   237: invokevirtual 140	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   240: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 49	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: goto -190 -> 59
    //   252: astore_0
    //   253: aload 4
    //   255: astore_1
    //   256: aload_0
    //   257: astore 4
    //   259: aload_1
    //   260: astore_0
    //   261: ldc 8
    //   263: ldc 192
    //   265: aload 4
    //   267: invokestatic 146	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   270: invokevirtual 150	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   273: invokestatic 153	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload_1
    //   277: invokestatic 157	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   280: ldc 182
    //   282: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: iconst_0
    //   286: ireturn
    //   287: aload 4
    //   289: astore_0
    //   290: aload 8
    //   292: invokevirtual 167	java/io/File:delete	()Z
    //   295: pop
    //   296: goto -101 -> 195
    //   299: astore 4
    //   301: aload_0
    //   302: astore_1
    //   303: aload 4
    //   305: astore_0
    //   306: aload_1
    //   307: invokestatic 157	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   310: ldc 182
    //   312: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: aload_0
    //   316: athrow
    //   317: aload 4
    //   319: invokestatic 157	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   322: invokestatic 172	java/lang/System:gc	()V
    //   325: ldc 8
    //   327: new 26	java/lang/StringBuilder
    //   330: dup
    //   331: ldc 194
    //   333: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   336: invokestatic 55	android/os/SystemClock:uptimeMillis	()J
    //   339: lload_2
    //   340: lsub
    //   341: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   344: ldc 179
    //   346: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 49	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: ldc 182
    //   357: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   360: iconst_1
    //   361: ireturn
    //   362: astore_0
    //   363: aconst_null
    //   364: astore_1
    //   365: goto -59 -> 306
    //   368: astore 4
    //   370: aconst_null
    //   371: astore_1
    //   372: goto -113 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramString1	String
    //   0	375	1	paramString2	String
    //   38	302	2	l	long
    //   47	241	4	localObject	Object
    //   299	19	4	localCloseable	java.io.Closeable
    //   368	1	4	localIOException	java.io.IOException
    //   57	19	5	localEnumeration	java.util.Enumeration
    //   85	116	6	localZipEntry	java.util.zip.ZipEntry
    //   100	126	7	str	String
    //   152	139	8	localFile1	java.io.File
    //   173	17	9	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   52	59	252	java/io/IOException
    //   62	72	252	java/io/IOException
    //   75	87	252	java/io/IOException
    //   90	102	252	java/io/IOException
    //   105	115	252	java/io/IOException
    //   118	128	252	java/io/IOException
    //   131	139	252	java/io/IOException
    //   142	154	252	java/io/IOException
    //   157	165	252	java/io/IOException
    //   168	175	252	java/io/IOException
    //   178	186	252	java/io/IOException
    //   189	195	252	java/io/IOException
    //   198	211	252	java/io/IOException
    //   214	249	252	java/io/IOException
    //   290	296	252	java/io/IOException
    //   52	59	299	finally
    //   62	72	299	finally
    //   75	87	299	finally
    //   90	102	299	finally
    //   105	115	299	finally
    //   118	128	299	finally
    //   131	139	299	finally
    //   142	154	299	finally
    //   157	165	299	finally
    //   168	175	299	finally
    //   178	186	299	finally
    //   189	195	299	finally
    //   198	211	299	finally
    //   214	249	299	finally
    //   261	276	299	finally
    //   290	296	299	finally
    //   39	49	362	finally
    //   39	49	368	java/io/IOException
  }
  
  /* Error */
  public static boolean extractResource(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: ldc 197
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 8
    //   7: new 26	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 199
    //   13: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 186
    //   22: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 49	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: invokestatic 55	android/os/SystemClock:uptimeMillis	()J
    //   38: lstore 5
    //   40: new 57	java/util/zip/ZipFile
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 58	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   48: astore 8
    //   50: aload 8
    //   52: astore_0
    //   53: aload_2
    //   54: arraylength
    //   55: istore 4
    //   57: iconst_0
    //   58: istore_3
    //   59: iload_3
    //   60: iload 4
    //   62: if_icmpge +319 -> 381
    //   65: aload_2
    //   66: iload_3
    //   67: aaload
    //   68: astore 9
    //   70: aload 8
    //   72: astore_0
    //   73: aload 9
    //   75: invokestatic 203	org/xwalk/core/XWalkDecompressor:isNativeLibrary	(Ljava/lang/String;)Z
    //   78: ifeq +96 -> 174
    //   81: aload 8
    //   83: astore_0
    //   84: aload 8
    //   86: new 26	java/lang/StringBuilder
    //   89: dup
    //   90: ldc 205
    //   92: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: getstatic 208	java/io/File:separator	Ljava/lang/String;
    //   98: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc 210
    //   103: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: getstatic 208	java/io/File:separator	Ljava/lang/String;
    //   109: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 9
    //   114: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokevirtual 214	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   123: astore 7
    //   125: aload 7
    //   127: ifnonnull +151 -> 278
    //   130: aload 8
    //   132: astore_0
    //   133: aload 9
    //   135: invokestatic 217	org/xwalk/core/XWalkDecompressor:isClassesDex	(Ljava/lang/String;)Z
    //   138: ifeq +98 -> 236
    //   141: aload 8
    //   143: astore_0
    //   144: ldc 8
    //   146: new 26	java/lang/StringBuilder
    //   149: dup
    //   150: ldc 219
    //   152: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload 9
    //   157: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc 221
    //   162: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 49	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: goto +280 -> 451
    //   174: aload 8
    //   176: astore_0
    //   177: aload 9
    //   179: invokestatic 224	org/xwalk/core/XWalkDecompressor:isAsset	(Ljava/lang/String;)Z
    //   182: ifeq +39 -> 221
    //   185: aload 8
    //   187: astore_0
    //   188: aload 8
    //   190: new 26	java/lang/StringBuilder
    //   193: dup
    //   194: ldc 226
    //   196: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   199: getstatic 208	java/io/File:separator	Ljava/lang/String;
    //   202: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 9
    //   207: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokevirtual 214	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   216: astore 7
    //   218: goto -93 -> 125
    //   221: aload 8
    //   223: astore_0
    //   224: aload 8
    //   226: aload 9
    //   228: invokevirtual 214	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   231: astore 7
    //   233: goto -108 -> 125
    //   236: aload 8
    //   238: astore_0
    //   239: ldc 8
    //   241: new 26	java/lang/StringBuilder
    //   244: dup
    //   245: ldc 219
    //   247: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   250: aload 9
    //   252: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc 228
    //   257: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 153	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload 8
    //   268: invokestatic 157	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   271: ldc 197
    //   273: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: iconst_0
    //   277: ireturn
    //   278: aload 8
    //   280: astore_0
    //   281: new 106	java/io/File
    //   284: dup
    //   285: aload_1
    //   286: aload 9
    //   288: invokespecial 188	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: astore 10
    //   293: aload 8
    //   295: astore_0
    //   296: aload 8
    //   298: aload 7
    //   300: invokevirtual 127	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   303: aload 10
    //   305: invokestatic 133	com/tencent/xweb/util/g:b	(Ljava/io/InputStream;Ljava/io/File;)Z
    //   308: pop
    //   309: aload 8
    //   311: astore_0
    //   312: ldc 8
    //   314: new 26	java/lang/StringBuilder
    //   317: dup
    //   318: ldc 230
    //   320: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   323: aload 9
    //   325: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: ldc 137
    //   330: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload 10
    //   335: invokevirtual 140	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   338: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 49	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: goto +104 -> 451
    //   350: astore_2
    //   351: aload 8
    //   353: astore_1
    //   354: aload_1
    //   355: astore_0
    //   356: ldc 8
    //   358: ldc 232
    //   360: aload_2
    //   361: invokestatic 146	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   364: invokevirtual 150	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   367: invokestatic 153	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: aload_1
    //   371: invokestatic 157	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   374: ldc 197
    //   376: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   379: iconst_0
    //   380: ireturn
    //   381: aload 8
    //   383: invokestatic 157	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   386: invokestatic 172	java/lang/System:gc	()V
    //   389: ldc 8
    //   391: new 26	java/lang/StringBuilder
    //   394: dup
    //   395: ldc 234
    //   397: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   400: invokestatic 55	android/os/SystemClock:uptimeMillis	()J
    //   403: lload 5
    //   405: lsub
    //   406: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   409: ldc 179
    //   411: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 49	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   420: ldc 197
    //   422: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   425: iconst_1
    //   426: ireturn
    //   427: astore_1
    //   428: aconst_null
    //   429: astore_0
    //   430: aload_0
    //   431: invokestatic 157	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   434: ldc 197
    //   436: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   439: aload_1
    //   440: athrow
    //   441: astore_1
    //   442: goto -12 -> 430
    //   445: astore_2
    //   446: aconst_null
    //   447: astore_1
    //   448: goto -94 -> 354
    //   451: iload_3
    //   452: iconst_1
    //   453: iadd
    //   454: istore_3
    //   455: goto -396 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	paramString1	String
    //   0	458	1	paramString2	String
    //   0	458	2	paramArrayOfString	String[]
    //   58	397	3	i	int
    //   55	8	4	j	int
    //   38	366	5	l	long
    //   123	176	7	localZipEntry	java.util.zip.ZipEntry
    //   48	334	8	localZipFile	java.util.zip.ZipFile
    //   68	256	9	str	String
    //   291	43	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   53	57	350	java/io/IOException
    //   73	81	350	java/io/IOException
    //   84	125	350	java/io/IOException
    //   133	141	350	java/io/IOException
    //   144	171	350	java/io/IOException
    //   177	185	350	java/io/IOException
    //   188	218	350	java/io/IOException
    //   224	233	350	java/io/IOException
    //   239	266	350	java/io/IOException
    //   281	293	350	java/io/IOException
    //   296	309	350	java/io/IOException
    //   312	347	350	java/io/IOException
    //   40	50	427	finally
    //   53	57	441	finally
    //   73	81	441	finally
    //   84	125	441	finally
    //   133	141	441	finally
    //   144	171	441	finally
    //   177	185	441	finally
    //   188	218	441	finally
    //   224	233	441	finally
    //   239	266	441	finally
    //   281	293	441	finally
    //   296	309	441	finally
    //   312	347	441	finally
    //   356	370	441	finally
    //   40	50	445	java/io/IOException
  }
  
  private static boolean isAsset(String paramString)
  {
    AppMethodBeat.i(154687);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(154687);
      return false;
    }
    if ((paramString.endsWith(".dat")) || (paramString.endsWith(".pak")) || (paramString.endsWith(".js")))
    {
      AppMethodBeat.o(154687);
      return true;
    }
    AppMethodBeat.o(154687);
    return false;
  }
  
  private static boolean isClassesDex(String paramString)
  {
    AppMethodBeat.i(154688);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(154688);
      return false;
    }
    boolean bool = paramString.endsWith("classes.dex");
    AppMethodBeat.o(154688);
    return bool;
  }
  
  private static boolean isNativeLibrary(String paramString)
  {
    AppMethodBeat.i(154686);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(154686);
      return false;
    }
    boolean bool = paramString.endsWith(".so");
    AppMethodBeat.o(154686);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkDecompressor
 * JD-Core Version:    0.7.0.1
 */