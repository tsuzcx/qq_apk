package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.io.IOException;

public class SharePatchInfo
{
  public static final String DEFAULT_DIR = "odex";
  public static final String FINGER_PRINT = "print";
  public static final String IS_PROTECTED_APP = "is_protected_app";
  public static final String IS_REMOVE_INTERPRET_OAT_DIR = "is_remove_interpret_oat_dir";
  public static final String IS_REMOVE_NEW_VERSION = "is_remove_new_version";
  public static final int MAX_EXTRACT_ATTEMPTS = 2;
  public static final String NEW_VERSION = "new";
  public static final String OAT_DIR = "dir";
  public static final String OLD_VERSION = "old";
  private static final String TAG = "Tinker.PatchInfo";
  public String fingerPrint;
  public boolean isProtectedApp;
  public boolean isRemoveInterpretOATDir;
  public boolean isRemoveNewVersion;
  public String newVersion;
  public String oatDir;
  public String oldVersion;
  
  public SharePatchInfo(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4, boolean paramBoolean3)
  {
    this.oldVersion = paramString1;
    this.newVersion = paramString2;
    this.isProtectedApp = paramBoolean1;
    this.isRemoveNewVersion = paramBoolean2;
    this.fingerPrint = paramString3;
    this.oatDir = paramString4;
    this.isRemoveInterpretOATDir = paramBoolean3;
  }
  
  /* Error */
  private static SharePatchInfo readAndCheckProperty(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore 12
    //   5: aconst_null
    //   6: astore 11
    //   8: aconst_null
    //   9: astore 10
    //   11: iconst_0
    //   12: istore_3
    //   13: iconst_0
    //   14: istore 4
    //   16: aconst_null
    //   17: astore 9
    //   19: iconst_0
    //   20: istore 7
    //   22: iconst_0
    //   23: istore_2
    //   24: iload_1
    //   25: iconst_2
    //   26: if_icmpge +725 -> 751
    //   29: iload_2
    //   30: ifne +721 -> 751
    //   33: iload_1
    //   34: iconst_1
    //   35: iadd
    //   36: istore_1
    //   37: new 69	java/util/Properties
    //   40: dup
    //   41: invokespecial 70	java/util/Properties:<init>	()V
    //   44: astore 19
    //   46: new 72	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 75	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore 18
    //   56: aload 12
    //   58: astore 14
    //   60: aload 11
    //   62: astore 15
    //   64: iload_3
    //   65: istore 5
    //   67: iload 4
    //   69: istore 6
    //   71: aload 10
    //   73: astore 16
    //   75: aload 9
    //   77: astore 17
    //   79: aload 18
    //   81: astore 13
    //   83: aload 19
    //   85: aload 18
    //   87: invokevirtual 79	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   90: aload 12
    //   92: astore 14
    //   94: aload 11
    //   96: astore 15
    //   98: iload_3
    //   99: istore 5
    //   101: iload 4
    //   103: istore 6
    //   105: aload 10
    //   107: astore 16
    //   109: aload 9
    //   111: astore 17
    //   113: aload 18
    //   115: astore 13
    //   117: aload 19
    //   119: ldc 32
    //   121: invokevirtual 83	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   124: astore 12
    //   126: aload 12
    //   128: astore 14
    //   130: aload 11
    //   132: astore 15
    //   134: iload_3
    //   135: istore 5
    //   137: iload 4
    //   139: istore 6
    //   141: aload 10
    //   143: astore 16
    //   145: aload 9
    //   147: astore 17
    //   149: aload 18
    //   151: astore 13
    //   153: aload 19
    //   155: ldc 26
    //   157: invokevirtual 83	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   160: astore 11
    //   162: aload 12
    //   164: astore 14
    //   166: aload 11
    //   168: astore 15
    //   170: iload_3
    //   171: istore 5
    //   173: iload 4
    //   175: istore 6
    //   177: aload 10
    //   179: astore 16
    //   181: aload 9
    //   183: astore 17
    //   185: aload 18
    //   187: astore 13
    //   189: aload 19
    //   191: ldc 14
    //   193: invokevirtual 83	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   196: astore 20
    //   198: aload 20
    //   200: ifnull +461 -> 661
    //   203: aload 12
    //   205: astore 14
    //   207: aload 11
    //   209: astore 15
    //   211: iload_3
    //   212: istore 5
    //   214: iload 4
    //   216: istore 6
    //   218: aload 10
    //   220: astore 16
    //   222: aload 9
    //   224: astore 17
    //   226: aload 18
    //   228: astore 13
    //   230: aload 20
    //   232: invokevirtual 89	java/lang/String:isEmpty	()Z
    //   235: ifne +426 -> 661
    //   238: aload 12
    //   240: astore 14
    //   242: aload 11
    //   244: astore 15
    //   246: iload_3
    //   247: istore 5
    //   249: iload 4
    //   251: istore 6
    //   253: aload 10
    //   255: astore 16
    //   257: aload 9
    //   259: astore 17
    //   261: aload 18
    //   263: astore 13
    //   265: ldc 91
    //   267: aload 20
    //   269: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   272: ifne +389 -> 661
    //   275: iconst_1
    //   276: istore_3
    //   277: aload 12
    //   279: astore 14
    //   281: aload 11
    //   283: astore 15
    //   285: iload_3
    //   286: istore 5
    //   288: iload 4
    //   290: istore 6
    //   292: aload 10
    //   294: astore 16
    //   296: aload 9
    //   298: astore 17
    //   300: aload 18
    //   302: astore 13
    //   304: aload 19
    //   306: ldc 20
    //   308: invokevirtual 83	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   311: astore 20
    //   313: aload 20
    //   315: ifnull +351 -> 666
    //   318: aload 12
    //   320: astore 14
    //   322: aload 11
    //   324: astore 15
    //   326: iload_3
    //   327: istore 5
    //   329: iload 4
    //   331: istore 6
    //   333: aload 10
    //   335: astore 16
    //   337: aload 9
    //   339: astore 17
    //   341: aload 18
    //   343: astore 13
    //   345: aload 20
    //   347: invokevirtual 89	java/lang/String:isEmpty	()Z
    //   350: ifne +316 -> 666
    //   353: aload 12
    //   355: astore 14
    //   357: aload 11
    //   359: astore 15
    //   361: iload_3
    //   362: istore 5
    //   364: iload 4
    //   366: istore 6
    //   368: aload 10
    //   370: astore 16
    //   372: aload 9
    //   374: astore 17
    //   376: aload 18
    //   378: astore 13
    //   380: ldc 91
    //   382: aload 20
    //   384: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   387: ifne +279 -> 666
    //   390: iconst_1
    //   391: istore 4
    //   393: aload 12
    //   395: astore 14
    //   397: aload 11
    //   399: astore 15
    //   401: iload_3
    //   402: istore 5
    //   404: iload 4
    //   406: istore 6
    //   408: aload 10
    //   410: astore 16
    //   412: aload 9
    //   414: astore 17
    //   416: aload 18
    //   418: astore 13
    //   420: aload 19
    //   422: ldc 11
    //   424: invokevirtual 83	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   427: astore 10
    //   429: aload 12
    //   431: astore 14
    //   433: aload 11
    //   435: astore 15
    //   437: iload_3
    //   438: istore 5
    //   440: iload 4
    //   442: istore 6
    //   444: aload 10
    //   446: astore 16
    //   448: aload 9
    //   450: astore 17
    //   452: aload 18
    //   454: astore 13
    //   456: aload 19
    //   458: ldc 29
    //   460: invokevirtual 83	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   463: astore 9
    //   465: aload 12
    //   467: astore 14
    //   469: aload 11
    //   471: astore 15
    //   473: iload_3
    //   474: istore 5
    //   476: iload 4
    //   478: istore 6
    //   480: aload 10
    //   482: astore 16
    //   484: aload 9
    //   486: astore 17
    //   488: aload 18
    //   490: astore 13
    //   492: aload 19
    //   494: ldc 17
    //   496: invokevirtual 83	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   499: astore 19
    //   501: aload 19
    //   503: ifnull +169 -> 672
    //   506: aload 12
    //   508: astore 14
    //   510: aload 11
    //   512: astore 15
    //   514: iload_3
    //   515: istore 5
    //   517: iload 4
    //   519: istore 6
    //   521: aload 10
    //   523: astore 16
    //   525: aload 9
    //   527: astore 17
    //   529: aload 18
    //   531: astore 13
    //   533: aload 19
    //   535: invokevirtual 89	java/lang/String:isEmpty	()Z
    //   538: ifne +134 -> 672
    //   541: aload 12
    //   543: astore 14
    //   545: aload 11
    //   547: astore 15
    //   549: iload_3
    //   550: istore 5
    //   552: iload 4
    //   554: istore 6
    //   556: aload 10
    //   558: astore 16
    //   560: aload 9
    //   562: astore 17
    //   564: aload 18
    //   566: astore 13
    //   568: ldc 91
    //   570: aload 19
    //   572: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   575: istore 8
    //   577: iload 8
    //   579: ifne +93 -> 672
    //   582: iconst_1
    //   583: istore 5
    //   585: aload 18
    //   587: invokestatic 101	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   590: iload 5
    //   592: istore 7
    //   594: aload 12
    //   596: ifnull +197 -> 793
    //   599: aload 11
    //   601: ifnull +192 -> 793
    //   604: aload 12
    //   606: ldc 103
    //   608: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   611: ifne +11 -> 622
    //   614: aload 12
    //   616: invokestatic 107	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkIfMd5Valid	(Ljava/lang/String;)Z
    //   619: ifeq +11 -> 630
    //   622: aload 11
    //   624: invokestatic 107	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkIfMd5Valid	(Ljava/lang/String;)Z
    //   627: ifne +119 -> 746
    //   630: ldc 35
    //   632: new 109	java/lang/StringBuilder
    //   635: dup
    //   636: ldc 111
    //   638: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   641: aload_0
    //   642: invokevirtual 120	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   645: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: iconst_0
    //   652: anewarray 4	java/lang/Object
    //   655: invokestatic 133	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   658: goto -634 -> 24
    //   661: iconst_0
    //   662: istore_3
    //   663: goto -386 -> 277
    //   666: iconst_0
    //   667: istore 4
    //   669: goto -276 -> 393
    //   672: iconst_0
    //   673: istore 5
    //   675: goto -90 -> 585
    //   678: astore 13
    //   680: aload 17
    //   682: astore 9
    //   684: aload 16
    //   686: astore 10
    //   688: iload 6
    //   690: istore 4
    //   692: iload 5
    //   694: istore_3
    //   695: aload 15
    //   697: astore 11
    //   699: aload 14
    //   701: astore 12
    //   703: aload 13
    //   705: astore 14
    //   707: aload 18
    //   709: astore 13
    //   711: ldc 35
    //   713: ldc 135
    //   715: aload 14
    //   717: invokestatic 139	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   720: invokevirtual 142	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   723: iconst_0
    //   724: anewarray 4	java/lang/Object
    //   727: invokestatic 133	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   730: aload 18
    //   732: invokestatic 101	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   735: goto -141 -> 594
    //   738: astore_0
    //   739: aload 13
    //   741: invokestatic 101	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   744: aload_0
    //   745: athrow
    //   746: iconst_1
    //   747: istore_2
    //   748: goto -724 -> 24
    //   751: iload_2
    //   752: ifeq +24 -> 776
    //   755: new 2	com/tencent/tinker/loader/shareutil/SharePatchInfo
    //   758: dup
    //   759: aload 12
    //   761: aload 11
    //   763: iload_3
    //   764: iload 4
    //   766: aload 10
    //   768: aload 9
    //   770: iload 7
    //   772: invokespecial 144	com/tencent/tinker/loader/shareutil/SharePatchInfo:<init>	(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Z)V
    //   775: areturn
    //   776: aconst_null
    //   777: areturn
    //   778: astore_0
    //   779: aconst_null
    //   780: astore 13
    //   782: goto -43 -> 739
    //   785: astore 14
    //   787: aconst_null
    //   788: astore 18
    //   790: goto -83 -> 707
    //   793: goto -769 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	796	0	paramFile	File
    //   1	36	1	i	int
    //   23	729	2	j	int
    //   12	752	3	bool1	boolean
    //   14	751	4	bool2	boolean
    //   65	628	5	bool3	boolean
    //   69	620	6	bool4	boolean
    //   20	751	7	bool5	boolean
    //   575	3	8	bool6	boolean
    //   17	752	9	localObject1	Object
    //   9	758	10	localObject2	Object
    //   6	756	11	localObject3	Object
    //   3	757	12	localObject4	Object
    //   81	486	13	localFileInputStream1	java.io.FileInputStream
    //   678	26	13	localIOException1	IOException
    //   709	72	13	localFileInputStream2	java.io.FileInputStream
    //   58	658	14	localObject5	Object
    //   785	1	14	localIOException2	IOException
    //   62	634	15	localObject6	Object
    //   73	612	16	localObject7	Object
    //   77	604	17	localObject8	Object
    //   54	735	18	localFileInputStream3	java.io.FileInputStream
    //   44	527	19	localObject9	Object
    //   196	187	20	str	String
    // Exception table:
    //   from	to	target	type
    //   83	90	678	java/io/IOException
    //   117	126	678	java/io/IOException
    //   153	162	678	java/io/IOException
    //   189	198	678	java/io/IOException
    //   230	238	678	java/io/IOException
    //   265	275	678	java/io/IOException
    //   304	313	678	java/io/IOException
    //   345	353	678	java/io/IOException
    //   380	390	678	java/io/IOException
    //   420	429	678	java/io/IOException
    //   456	465	678	java/io/IOException
    //   492	501	678	java/io/IOException
    //   533	541	678	java/io/IOException
    //   568	577	678	java/io/IOException
    //   83	90	738	finally
    //   117	126	738	finally
    //   153	162	738	finally
    //   189	198	738	finally
    //   230	238	738	finally
    //   265	275	738	finally
    //   304	313	738	finally
    //   345	353	738	finally
    //   380	390	738	finally
    //   420	429	738	finally
    //   456	465	738	finally
    //   492	501	738	finally
    //   533	541	738	finally
    //   568	577	738	finally
    //   711	730	738	finally
    //   46	56	778	finally
    //   46	56	785	java/io/IOException
  }
  
  /* Error */
  public static SharePatchInfo readAndCheckPropertyWithLock(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_3
    //   3: astore_2
    //   4: aload_0
    //   5: ifnull +9 -> 14
    //   8: aload_1
    //   9: ifnonnull +7 -> 16
    //   12: aload_3
    //   13: astore_2
    //   14: aload_2
    //   15: areturn
    //   16: aload_1
    //   17: invokevirtual 152	java/io/File:getParentFile	()Ljava/io/File;
    //   20: astore_2
    //   21: aload_2
    //   22: invokevirtual 155	java/io/File:exists	()Z
    //   25: ifne +8 -> 33
    //   28: aload_2
    //   29: invokevirtual 158	java/io/File:mkdirs	()Z
    //   32: pop
    //   33: aload_1
    //   34: invokestatic 164	com/tencent/tinker/loader/shareutil/ShareFileLockHelper:getFileLock	(Ljava/io/File;)Lcom/tencent/tinker/loader/shareutil/ShareFileLockHelper;
    //   37: astore_1
    //   38: aload_1
    //   39: astore_2
    //   40: aload_0
    //   41: invokestatic 166	com/tencent/tinker/loader/shareutil/SharePatchInfo:readAndCheckProperty	(Ljava/io/File;)Lcom/tencent/tinker/loader/shareutil/SharePatchInfo;
    //   44: astore_0
    //   45: aload_0
    //   46: astore_2
    //   47: aload_1
    //   48: ifnull -34 -> 14
    //   51: aload_1
    //   52: invokevirtual 169	com/tencent/tinker/loader/shareutil/ShareFileLockHelper:close	()V
    //   55: aload_0
    //   56: areturn
    //   57: astore_1
    //   58: ldc 35
    //   60: ldc 171
    //   62: iconst_1
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload_1
    //   69: aastore
    //   70: invokestatic 133	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload_0
    //   74: areturn
    //   75: astore_0
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: astore_2
    //   80: new 173	com/tencent/tinker/loader/TinkerRuntimeException
    //   83: dup
    //   84: ldc 175
    //   86: aload_0
    //   87: invokespecial 178	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: athrow
    //   91: astore_0
    //   92: aload_2
    //   93: ifnull +7 -> 100
    //   96: aload_2
    //   97: invokevirtual 169	com/tencent/tinker/loader/shareutil/ShareFileLockHelper:close	()V
    //   100: aload_0
    //   101: athrow
    //   102: astore_1
    //   103: ldc 35
    //   105: ldc 171
    //   107: iconst_1
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_1
    //   114: aastore
    //   115: invokestatic 133	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: goto -18 -> 100
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_2
    //   124: goto -32 -> 92
    //   127: astore_0
    //   128: goto -50 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramFile1	File
    //   0	131	1	paramFile2	File
    //   3	121	2	localObject1	Object
    //   1	12	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   51	55	57	java/io/IOException
    //   33	38	75	java/lang/Exception
    //   40	45	91	finally
    //   80	91	91	finally
    //   96	100	102	java/io/IOException
    //   33	38	121	finally
    //   40	45	127	java/lang/Exception
  }
  
  /* Error */
  private static boolean rewritePatchInfoFile(File paramFile, SharePatchInfo paramSharePatchInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_1
    //   11: getfield 58	com/tencent/tinker/loader/shareutil/SharePatchInfo:fingerPrint	Ljava/lang/String;
    //   14: invokestatic 185	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:isNullOrNil	(Ljava/lang/String;)Z
    //   17: ifeq +10 -> 27
    //   20: aload_1
    //   21: getstatic 190	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   24: putfield 58	com/tencent/tinker/loader/shareutil/SharePatchInfo:fingerPrint	Ljava/lang/String;
    //   27: aload_1
    //   28: getfield 60	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   31: invokestatic 185	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:isNullOrNil	(Ljava/lang/String;)Z
    //   34: ifeq +9 -> 43
    //   37: aload_1
    //   38: ldc 8
    //   40: putfield 60	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   43: new 109	java/lang/StringBuilder
    //   46: dup
    //   47: ldc 192
    //   49: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   52: aload_0
    //   53: invokevirtual 120	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   56: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 194
    //   61: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: getfield 50	com/tencent/tinker/loader/shareutil/SharePatchInfo:oldVersion	Ljava/lang/String;
    //   68: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 196
    //   73: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: getfield 52	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   80: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 198
    //   85: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: astore 4
    //   90: aload_1
    //   91: getfield 54	com/tencent/tinker/loader/shareutil/SharePatchInfo:isProtectedApp	Z
    //   94: ifeq +379 -> 473
    //   97: iconst_1
    //   98: istore_2
    //   99: aload 4
    //   101: iload_2
    //   102: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc 203
    //   107: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: astore 4
    //   112: aload_1
    //   113: getfield 56	com/tencent/tinker/loader/shareutil/SharePatchInfo:isRemoveNewVersion	Z
    //   116: ifeq +362 -> 478
    //   119: iconst_1
    //   120: istore_2
    //   121: aload 4
    //   123: iload_2
    //   124: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: ldc 205
    //   129: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_1
    //   133: getfield 58	com/tencent/tinker/loader/shareutil/SharePatchInfo:fingerPrint	Ljava/lang/String;
    //   136: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc 207
    //   141: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_1
    //   145: getfield 60	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   148: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc 209
    //   153: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: astore 4
    //   158: aload_1
    //   159: getfield 62	com/tencent/tinker/loader/shareutil/SharePatchInfo:isRemoveInterpretOATDir	Z
    //   162: ifeq +321 -> 483
    //   165: iconst_1
    //   166: istore_2
    //   167: ldc 35
    //   169: aload 4
    //   171: iload_2
    //   172: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   175: ldc 211
    //   177: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: new 213	java/lang/Throwable
    //   183: dup
    //   184: invokespecial 214	java/lang/Throwable:<init>	()V
    //   187: invokestatic 220	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   190: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: iconst_0
    //   197: anewarray 4	java/lang/Object
    //   200: invokestatic 223	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   203: aload_0
    //   204: invokevirtual 152	java/io/File:getParentFile	()Ljava/io/File;
    //   207: astore 4
    //   209: aload 4
    //   211: invokevirtual 155	java/io/File:exists	()Z
    //   214: ifne +9 -> 223
    //   217: aload 4
    //   219: invokevirtual 158	java/io/File:mkdirs	()Z
    //   222: pop
    //   223: iconst_0
    //   224: istore_2
    //   225: iconst_0
    //   226: istore_3
    //   227: iload_2
    //   228: iconst_2
    //   229: if_icmpge +332 -> 561
    //   232: iload_3
    //   233: ifne +328 -> 561
    //   236: new 69	java/util/Properties
    //   239: dup
    //   240: invokespecial 70	java/util/Properties:<init>	()V
    //   243: astore 6
    //   245: aload 6
    //   247: ldc 32
    //   249: aload_1
    //   250: getfield 50	com/tencent/tinker/loader/shareutil/SharePatchInfo:oldVersion	Ljava/lang/String;
    //   253: invokevirtual 227	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   256: pop
    //   257: aload 6
    //   259: ldc 26
    //   261: aload_1
    //   262: getfield 52	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   265: invokevirtual 227	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   268: pop
    //   269: aload_1
    //   270: getfield 54	com/tencent/tinker/loader/shareutil/SharePatchInfo:isProtectedApp	Z
    //   273: ifeq +215 -> 488
    //   276: ldc 229
    //   278: astore 4
    //   280: aload 6
    //   282: ldc 14
    //   284: aload 4
    //   286: invokevirtual 227	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   289: pop
    //   290: aload_1
    //   291: getfield 56	com/tencent/tinker/loader/shareutil/SharePatchInfo:isRemoveNewVersion	Z
    //   294: ifeq +201 -> 495
    //   297: ldc 229
    //   299: astore 4
    //   301: aload 6
    //   303: ldc 20
    //   305: aload 4
    //   307: invokevirtual 227	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   310: pop
    //   311: aload 6
    //   313: ldc 11
    //   315: aload_1
    //   316: getfield 58	com/tencent/tinker/loader/shareutil/SharePatchInfo:fingerPrint	Ljava/lang/String;
    //   319: invokevirtual 227	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   322: pop
    //   323: aload 6
    //   325: ldc 29
    //   327: aload_1
    //   328: getfield 60	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   331: invokevirtual 227	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   334: pop
    //   335: aload_1
    //   336: getfield 62	com/tencent/tinker/loader/shareutil/SharePatchInfo:isRemoveInterpretOATDir	Z
    //   339: ifeq +163 -> 502
    //   342: ldc 229
    //   344: astore 4
    //   346: aload 6
    //   348: ldc 17
    //   350: aload 4
    //   352: invokevirtual 227	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   355: pop
    //   356: new 231	java/io/FileOutputStream
    //   359: dup
    //   360: aload_0
    //   361: iconst_0
    //   362: invokespecial 234	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   365: astore 5
    //   367: aload 5
    //   369: astore 4
    //   371: aload 6
    //   373: aload 5
    //   375: new 109	java/lang/StringBuilder
    //   378: dup
    //   379: ldc 236
    //   381: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   384: aload_1
    //   385: getfield 50	com/tencent/tinker/loader/shareutil/SharePatchInfo:oldVersion	Ljava/lang/String;
    //   388: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: ldc 238
    //   393: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_1
    //   397: getfield 52	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   400: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokevirtual 242	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   409: aload 5
    //   411: invokestatic 101	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   414: aload_0
    //   415: invokestatic 166	com/tencent/tinker/loader/shareutil/SharePatchInfo:readAndCheckProperty	(Ljava/io/File;)Lcom/tencent/tinker/loader/shareutil/SharePatchInfo;
    //   418: astore 4
    //   420: aload 4
    //   422: ifnull +134 -> 556
    //   425: aload 4
    //   427: getfield 50	com/tencent/tinker/loader/shareutil/SharePatchInfo:oldVersion	Ljava/lang/String;
    //   430: aload_1
    //   431: getfield 50	com/tencent/tinker/loader/shareutil/SharePatchInfo:oldVersion	Ljava/lang/String;
    //   434: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   437: ifeq +119 -> 556
    //   440: aload 4
    //   442: getfield 52	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   445: aload_1
    //   446: getfield 52	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   449: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   452: ifeq +104 -> 556
    //   455: iconst_1
    //   456: istore_3
    //   457: iload_3
    //   458: ifne +8 -> 466
    //   461: aload_0
    //   462: invokevirtual 245	java/io/File:delete	()Z
    //   465: pop
    //   466: iload_2
    //   467: iconst_1
    //   468: iadd
    //   469: istore_2
    //   470: goto -243 -> 227
    //   473: iconst_0
    //   474: istore_2
    //   475: goto -376 -> 99
    //   478: iconst_0
    //   479: istore_2
    //   480: goto -359 -> 121
    //   483: iconst_0
    //   484: istore_2
    //   485: goto -318 -> 167
    //   488: ldc 91
    //   490: astore 4
    //   492: goto -212 -> 280
    //   495: ldc 91
    //   497: astore 4
    //   499: goto -198 -> 301
    //   502: ldc 91
    //   504: astore 4
    //   506: goto -160 -> 346
    //   509: astore 6
    //   511: aconst_null
    //   512: astore 5
    //   514: aload 5
    //   516: astore 4
    //   518: ldc 35
    //   520: ldc 247
    //   522: aload 6
    //   524: invokestatic 139	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   527: invokevirtual 142	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   530: iconst_0
    //   531: anewarray 4	java/lang/Object
    //   534: invokestatic 133	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   537: aload 5
    //   539: invokestatic 101	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   542: goto -128 -> 414
    //   545: astore_0
    //   546: aconst_null
    //   547: astore 4
    //   549: aload 4
    //   551: invokestatic 101	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   554: aload_0
    //   555: athrow
    //   556: iconst_0
    //   557: istore_3
    //   558: goto -101 -> 457
    //   561: iload_3
    //   562: ireturn
    //   563: astore_0
    //   564: goto -15 -> 549
    //   567: astore 6
    //   569: goto -55 -> 514
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	572	0	paramFile	File
    //   0	572	1	paramSharePatchInfo	SharePatchInfo
    //   98	387	2	i	int
    //   226	336	3	bool	boolean
    //   88	462	4	localObject	Object
    //   365	173	5	localFileOutputStream	java.io.FileOutputStream
    //   243	129	6	localProperties	java.util.Properties
    //   509	14	6	localException1	Exception
    //   567	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   356	367	509	java/lang/Exception
    //   356	367	545	finally
    //   371	409	563	finally
    //   518	537	563	finally
    //   371	409	567	java/lang/Exception
  }
  
  public static boolean rewritePatchInfoFileWithLock(File paramFile1, SharePatchInfo paramSharePatchInfo, File paramFile2)
  {
    boolean bool1;
    if ((paramFile1 == null) || (paramSharePatchInfo == null) || (paramFile2 == null)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      File localFile1 = paramFile2.getParentFile();
      if (!localFile1.exists()) {
        localFile1.mkdirs();
      }
      localFile2 = null;
      localFile1 = null;
      try
      {
        paramFile2 = ShareFileLockHelper.getFileLock(paramFile2);
        localFile1 = paramFile2;
        localFile2 = paramFile2;
        boolean bool2 = rewritePatchInfoFile(paramFile1, paramSharePatchInfo);
        bool1 = bool2;
        if (paramFile2 == null) {
          continue;
        }
        try
        {
          paramFile2.close();
          return bool2;
        }
        catch (IOException paramFile1)
        {
          ShareTinkerLog.i("Tinker.PatchInfo", "releaseInfoLock error", new Object[] { paramFile1 });
          return bool2;
        }
        try
        {
          localFile2.close();
          throw paramFile1;
        }
        catch (IOException paramSharePatchInfo)
        {
          for (;;)
          {
            ShareTinkerLog.i("Tinker.PatchInfo", "releaseInfoLock error", new Object[] { paramSharePatchInfo });
          }
        }
      }
      catch (Exception paramFile1)
      {
        localFile2 = localFile1;
        throw new TinkerRuntimeException("rewritePatchInfoFileWithLock fail", paramFile1);
      }
      finally
      {
        if (localFile2 == null) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.SharePatchInfo
 * JD-Core Version:    0.7.0.1
 */