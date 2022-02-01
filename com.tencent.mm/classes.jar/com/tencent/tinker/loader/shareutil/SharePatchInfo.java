package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.io.IOException;

public class SharePatchInfo
{
  public static final String DEFAULT_DIR = "odex";
  public static final String FINGER_PRINT = "print";
  public static final String IS_PROTECTED_APP = "is_protected_app";
  public static final String IS_REMOVE_NEW_VERSION = "is_remove_new_version";
  public static final int MAX_EXTRACT_ATTEMPTS = 2;
  public static final String NEW_VERSION = "new";
  public static final String OAT_DIR = "dir";
  public static final String OLD_VERSION = "old";
  private static final String TAG = "Tinker.PatchInfo";
  public String fingerPrint;
  public boolean isProtectedApp;
  public boolean isRemoveNewVersion;
  public String newVersion;
  public String oatDir;
  public String oldVersion;
  
  public SharePatchInfo(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4)
  {
    this.oldVersion = paramString1;
    this.newVersion = paramString2;
    this.isProtectedApp = paramBoolean1;
    this.isRemoveNewVersion = paramBoolean2;
    this.fingerPrint = paramString3;
    this.oatDir = paramString4;
  }
  
  /* Error */
  private static SharePatchInfo readAndCheckProperty(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 15
    //   3: aconst_null
    //   4: astore 13
    //   6: iconst_0
    //   7: istore_3
    //   8: iconst_0
    //   9: istore 4
    //   11: aconst_null
    //   12: astore 7
    //   14: aconst_null
    //   15: astore 8
    //   17: aconst_null
    //   18: astore 9
    //   20: iconst_0
    //   21: istore_1
    //   22: iconst_0
    //   23: istore_2
    //   24: iload_1
    //   25: iconst_2
    //   26: if_icmpge +464 -> 490
    //   29: iload_2
    //   30: ifne +460 -> 490
    //   33: iload_1
    //   34: iconst_1
    //   35: iadd
    //   36: istore_1
    //   37: new 63	java/util/Properties
    //   40: dup
    //   41: invokespecial 64	java/util/Properties:<init>	()V
    //   44: astore 16
    //   46: new 66	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 69	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore 12
    //   56: aload 12
    //   58: astore 10
    //   60: aload 16
    //   62: aload 12
    //   64: invokevirtual 73	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   67: aload 12
    //   69: astore 10
    //   71: aload 16
    //   73: ldc 29
    //   75: invokevirtual 77	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   78: astore 11
    //   80: aload 11
    //   82: astore 9
    //   84: aload 12
    //   86: astore 10
    //   88: iload 4
    //   90: istore 6
    //   92: iload_3
    //   93: istore 5
    //   95: aload 7
    //   97: astore 11
    //   99: aload 16
    //   101: ldc 23
    //   103: invokevirtual 77	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 14
    //   108: aload 12
    //   110: astore 10
    //   112: aload 14
    //   114: astore 8
    //   116: iload 4
    //   118: istore 6
    //   120: iload_3
    //   121: istore 5
    //   123: aload 7
    //   125: astore 11
    //   127: aload 16
    //   129: ldc 14
    //   131: invokevirtual 77	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   134: astore 17
    //   136: aload 17
    //   138: ifnull +289 -> 427
    //   141: aload 12
    //   143: astore 10
    //   145: aload 14
    //   147: astore 8
    //   149: iload 4
    //   151: istore 6
    //   153: iload_3
    //   154: istore 5
    //   156: aload 7
    //   158: astore 11
    //   160: aload 17
    //   162: invokevirtual 83	java/lang/String:isEmpty	()Z
    //   165: ifne +262 -> 427
    //   168: aload 12
    //   170: astore 10
    //   172: aload 14
    //   174: astore 8
    //   176: iload 4
    //   178: istore 6
    //   180: iload_3
    //   181: istore 5
    //   183: aload 7
    //   185: astore 11
    //   187: ldc 85
    //   189: aload 17
    //   191: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifne +233 -> 427
    //   197: iconst_1
    //   198: istore 4
    //   200: aload 12
    //   202: astore 10
    //   204: aload 14
    //   206: astore 8
    //   208: iload 4
    //   210: istore 6
    //   212: iload_3
    //   213: istore 5
    //   215: aload 7
    //   217: astore 11
    //   219: aload 16
    //   221: ldc 17
    //   223: invokevirtual 77	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   226: astore 17
    //   228: aload 17
    //   230: ifnull +203 -> 433
    //   233: aload 12
    //   235: astore 10
    //   237: aload 14
    //   239: astore 8
    //   241: iload 4
    //   243: istore 6
    //   245: iload_3
    //   246: istore 5
    //   248: aload 7
    //   250: astore 11
    //   252: aload 17
    //   254: invokevirtual 83	java/lang/String:isEmpty	()Z
    //   257: ifne +176 -> 433
    //   260: aload 12
    //   262: astore 10
    //   264: aload 14
    //   266: astore 8
    //   268: iload 4
    //   270: istore 6
    //   272: iload_3
    //   273: istore 5
    //   275: aload 7
    //   277: astore 11
    //   279: ldc 85
    //   281: aload 17
    //   283: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   286: ifne +147 -> 433
    //   289: iconst_1
    //   290: istore_3
    //   291: aload 12
    //   293: astore 10
    //   295: aload 14
    //   297: astore 8
    //   299: iload 4
    //   301: istore 6
    //   303: iload_3
    //   304: istore 5
    //   306: aload 7
    //   308: astore 11
    //   310: aload 16
    //   312: ldc 11
    //   314: invokevirtual 77	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   317: astore 7
    //   319: aload 12
    //   321: astore 10
    //   323: aload 14
    //   325: astore 8
    //   327: iload 4
    //   329: istore 6
    //   331: iload_3
    //   332: istore 5
    //   334: aload 7
    //   336: astore 11
    //   338: aload 16
    //   340: ldc 26
    //   342: invokevirtual 77	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   345: astore 16
    //   347: aload 16
    //   349: astore 13
    //   351: aload 12
    //   353: invokestatic 95	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   356: aload 14
    //   358: astore 8
    //   360: aload 9
    //   362: ifnull +185 -> 547
    //   365: aload 8
    //   367: ifnull +180 -> 547
    //   370: aload 9
    //   372: ldc 97
    //   374: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   377: ifne +11 -> 388
    //   380: aload 9
    //   382: invokestatic 101	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkIfMd5Valid	(Ljava/lang/String;)Z
    //   385: ifeq +11 -> 396
    //   388: aload 8
    //   390: invokestatic 101	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkIfMd5Valid	(Ljava/lang/String;)Z
    //   393: ifne +92 -> 485
    //   396: ldc 32
    //   398: new 103	java/lang/StringBuilder
    //   401: dup
    //   402: ldc 105
    //   404: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   407: aload_0
    //   408: invokevirtual 114	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   411: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: iconst_0
    //   418: anewarray 4	java/lang/Object
    //   421: invokestatic 127	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   424: goto -400 -> 24
    //   427: iconst_0
    //   428: istore 4
    //   430: goto -230 -> 200
    //   433: iconst_0
    //   434: istore_3
    //   435: goto -144 -> 291
    //   438: astore 11
    //   440: aconst_null
    //   441: astore 12
    //   443: aload 12
    //   445: astore 10
    //   447: ldc 32
    //   449: ldc 129
    //   451: aload 11
    //   453: invokestatic 133	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   456: invokevirtual 136	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   459: iconst_0
    //   460: anewarray 4	java/lang/Object
    //   463: invokestatic 127	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   466: aload 12
    //   468: invokestatic 95	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   471: goto -111 -> 360
    //   474: astore_0
    //   475: aconst_null
    //   476: astore 10
    //   478: aload 10
    //   480: invokestatic 95	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   483: aload_0
    //   484: athrow
    //   485: iconst_1
    //   486: istore_2
    //   487: goto -463 -> 24
    //   490: aload 15
    //   492: astore_0
    //   493: iload_2
    //   494: ifeq +22 -> 516
    //   497: new 2	com/tencent/tinker/loader/shareutil/SharePatchInfo
    //   500: dup
    //   501: aload 9
    //   503: aload 8
    //   505: iload 4
    //   507: iload_3
    //   508: aload 7
    //   510: aload 13
    //   512: invokespecial 138	com/tencent/tinker/loader/shareutil/SharePatchInfo:<init>	(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V
    //   515: astore_0
    //   516: aload_0
    //   517: areturn
    //   518: astore_0
    //   519: goto -41 -> 478
    //   522: astore 11
    //   524: goto -81 -> 443
    //   527: astore 10
    //   529: iload 6
    //   531: istore 4
    //   533: iload 5
    //   535: istore_3
    //   536: aload 11
    //   538: astore 7
    //   540: aload 10
    //   542: astore 11
    //   544: goto -101 -> 443
    //   547: goto -523 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	550	0	paramFile	File
    //   21	16	1	i	int
    //   23	471	2	j	int
    //   7	529	3	bool1	boolean
    //   9	523	4	bool2	boolean
    //   93	441	5	bool3	boolean
    //   90	440	6	bool4	boolean
    //   12	527	7	localObject1	Object
    //   15	489	8	localObject2	Object
    //   18	484	9	localObject3	Object
    //   58	421	10	localFileInputStream1	java.io.FileInputStream
    //   527	14	10	localIOException1	IOException
    //   78	259	11	localObject4	Object
    //   438	14	11	localIOException2	IOException
    //   522	15	11	localIOException3	IOException
    //   542	1	11	localIOException4	IOException
    //   54	413	12	localFileInputStream2	java.io.FileInputStream
    //   4	507	13	localObject5	Object
    //   106	251	14	str1	String
    //   1	490	15	localObject6	Object
    //   44	304	16	localObject7	Object
    //   134	148	17	str2	String
    // Exception table:
    //   from	to	target	type
    //   46	56	438	java/io/IOException
    //   46	56	474	finally
    //   60	67	518	finally
    //   71	80	518	finally
    //   99	108	518	finally
    //   127	136	518	finally
    //   160	168	518	finally
    //   187	197	518	finally
    //   219	228	518	finally
    //   252	260	518	finally
    //   279	289	518	finally
    //   310	319	518	finally
    //   338	347	518	finally
    //   447	466	518	finally
    //   60	67	522	java/io/IOException
    //   71	80	522	java/io/IOException
    //   99	108	527	java/io/IOException
    //   127	136	527	java/io/IOException
    //   160	168	527	java/io/IOException
    //   187	197	527	java/io/IOException
    //   219	228	527	java/io/IOException
    //   252	260	527	java/io/IOException
    //   279	289	527	java/io/IOException
    //   310	319	527	java/io/IOException
    //   338	347	527	java/io/IOException
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
    //   17: invokevirtual 146	java/io/File:getParentFile	()Ljava/io/File;
    //   20: astore_2
    //   21: aload_2
    //   22: invokevirtual 149	java/io/File:exists	()Z
    //   25: ifne +8 -> 33
    //   28: aload_2
    //   29: invokevirtual 152	java/io/File:mkdirs	()Z
    //   32: pop
    //   33: aload_1
    //   34: invokestatic 158	com/tencent/tinker/loader/shareutil/ShareFileLockHelper:getFileLock	(Ljava/io/File;)Lcom/tencent/tinker/loader/shareutil/ShareFileLockHelper;
    //   37: astore_1
    //   38: aload_1
    //   39: astore_2
    //   40: aload_0
    //   41: invokestatic 160	com/tencent/tinker/loader/shareutil/SharePatchInfo:readAndCheckProperty	(Ljava/io/File;)Lcom/tencent/tinker/loader/shareutil/SharePatchInfo;
    //   44: astore_0
    //   45: aload_0
    //   46: astore_2
    //   47: aload_1
    //   48: ifnull -34 -> 14
    //   51: aload_1
    //   52: invokevirtual 163	com/tencent/tinker/loader/shareutil/ShareFileLockHelper:close	()V
    //   55: aload_0
    //   56: areturn
    //   57: astore_1
    //   58: ldc 32
    //   60: ldc 165
    //   62: iconst_1
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload_1
    //   69: aastore
    //   70: invokestatic 127	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload_0
    //   74: areturn
    //   75: astore_0
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: astore_2
    //   80: new 167	com/tencent/tinker/loader/TinkerRuntimeException
    //   83: dup
    //   84: ldc 169
    //   86: aload_0
    //   87: invokespecial 172	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: athrow
    //   91: astore_0
    //   92: aload_2
    //   93: ifnull +7 -> 100
    //   96: aload_2
    //   97: invokevirtual 163	com/tencent/tinker/loader/shareutil/ShareFileLockHelper:close	()V
    //   100: aload_0
    //   101: athrow
    //   102: astore_1
    //   103: ldc 32
    //   105: ldc 165
    //   107: iconst_1
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_1
    //   114: aastore
    //   115: invokestatic 127	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   11: getfield 54	com/tencent/tinker/loader/shareutil/SharePatchInfo:fingerPrint	Ljava/lang/String;
    //   14: invokestatic 179	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:isNullOrNil	(Ljava/lang/String;)Z
    //   17: ifeq +10 -> 27
    //   20: aload_1
    //   21: getstatic 184	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   24: putfield 54	com/tencent/tinker/loader/shareutil/SharePatchInfo:fingerPrint	Ljava/lang/String;
    //   27: aload_1
    //   28: getfield 56	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   31: invokestatic 179	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:isNullOrNil	(Ljava/lang/String;)Z
    //   34: ifeq +9 -> 43
    //   37: aload_1
    //   38: ldc 8
    //   40: putfield 56	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   43: new 103	java/lang/StringBuilder
    //   46: dup
    //   47: ldc 186
    //   49: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   52: aload_0
    //   53: invokevirtual 114	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   56: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 188
    //   61: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: getfield 46	com/tencent/tinker/loader/shareutil/SharePatchInfo:oldVersion	Ljava/lang/String;
    //   68: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 190
    //   73: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: getfield 48	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   80: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 192
    //   85: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: astore 4
    //   90: aload_1
    //   91: getfield 50	com/tencent/tinker/loader/shareutil/SharePatchInfo:isProtectedApp	Z
    //   94: ifeq +318 -> 412
    //   97: iconst_1
    //   98: istore_2
    //   99: aload 4
    //   101: iload_2
    //   102: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc 197
    //   107: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: astore 4
    //   112: aload_1
    //   113: getfield 52	com/tencent/tinker/loader/shareutil/SharePatchInfo:isRemoveNewVersion	Z
    //   116: ifeq +301 -> 417
    //   119: iconst_1
    //   120: istore_2
    //   121: ldc 32
    //   123: aload 4
    //   125: iload_2
    //   126: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: ldc 199
    //   131: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_1
    //   135: getfield 54	com/tencent/tinker/loader/shareutil/SharePatchInfo:fingerPrint	Ljava/lang/String;
    //   138: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 201
    //   143: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_1
    //   147: getfield 56	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   150: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: iconst_0
    //   157: anewarray 4	java/lang/Object
    //   160: invokestatic 204	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: aload_0
    //   164: invokevirtual 146	java/io/File:getParentFile	()Ljava/io/File;
    //   167: astore 4
    //   169: aload 4
    //   171: invokevirtual 149	java/io/File:exists	()Z
    //   174: ifne +9 -> 183
    //   177: aload 4
    //   179: invokevirtual 152	java/io/File:mkdirs	()Z
    //   182: pop
    //   183: iconst_0
    //   184: istore_3
    //   185: iconst_0
    //   186: istore_2
    //   187: iload_3
    //   188: iconst_2
    //   189: if_icmpge +299 -> 488
    //   192: iload_2
    //   193: ifne +295 -> 488
    //   196: new 63	java/util/Properties
    //   199: dup
    //   200: invokespecial 64	java/util/Properties:<init>	()V
    //   203: astore 6
    //   205: aload 6
    //   207: ldc 29
    //   209: aload_1
    //   210: getfield 46	com/tencent/tinker/loader/shareutil/SharePatchInfo:oldVersion	Ljava/lang/String;
    //   213: invokevirtual 208	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   216: pop
    //   217: aload 6
    //   219: ldc 23
    //   221: aload_1
    //   222: getfield 48	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   225: invokevirtual 208	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   228: pop
    //   229: aload_1
    //   230: getfield 50	com/tencent/tinker/loader/shareutil/SharePatchInfo:isProtectedApp	Z
    //   233: ifeq +189 -> 422
    //   236: ldc 210
    //   238: astore 4
    //   240: aload 6
    //   242: ldc 14
    //   244: aload 4
    //   246: invokevirtual 208	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   249: pop
    //   250: aload_1
    //   251: getfield 52	com/tencent/tinker/loader/shareutil/SharePatchInfo:isRemoveNewVersion	Z
    //   254: ifeq +175 -> 429
    //   257: ldc 210
    //   259: astore 4
    //   261: aload 6
    //   263: ldc 17
    //   265: aload 4
    //   267: invokevirtual 208	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   270: pop
    //   271: aload 6
    //   273: ldc 11
    //   275: aload_1
    //   276: getfield 54	com/tencent/tinker/loader/shareutil/SharePatchInfo:fingerPrint	Ljava/lang/String;
    //   279: invokevirtual 208	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   282: pop
    //   283: aload 6
    //   285: ldc 26
    //   287: aload_1
    //   288: getfield 56	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   291: invokevirtual 208	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   294: pop
    //   295: new 212	java/io/FileOutputStream
    //   298: dup
    //   299: aload_0
    //   300: iconst_0
    //   301: invokespecial 215	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   304: astore 5
    //   306: aload 5
    //   308: astore 4
    //   310: aload 6
    //   312: aload 5
    //   314: new 103	java/lang/StringBuilder
    //   317: dup
    //   318: ldc 217
    //   320: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   323: aload_1
    //   324: getfield 46	com/tencent/tinker/loader/shareutil/SharePatchInfo:oldVersion	Ljava/lang/String;
    //   327: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc 219
    //   332: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_1
    //   336: getfield 48	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   339: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokevirtual 223	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   348: aload 5
    //   350: invokestatic 95	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   353: aload_0
    //   354: invokestatic 160	com/tencent/tinker/loader/shareutil/SharePatchInfo:readAndCheckProperty	(Ljava/io/File;)Lcom/tencent/tinker/loader/shareutil/SharePatchInfo;
    //   357: astore 4
    //   359: aload 4
    //   361: ifnull +122 -> 483
    //   364: aload 4
    //   366: getfield 46	com/tencent/tinker/loader/shareutil/SharePatchInfo:oldVersion	Ljava/lang/String;
    //   369: aload_1
    //   370: getfield 46	com/tencent/tinker/loader/shareutil/SharePatchInfo:oldVersion	Ljava/lang/String;
    //   373: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   376: ifeq +107 -> 483
    //   379: aload 4
    //   381: getfield 48	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   384: aload_1
    //   385: getfield 48	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   388: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   391: ifeq +92 -> 483
    //   394: iconst_1
    //   395: istore_2
    //   396: iload_2
    //   397: ifne +8 -> 405
    //   400: aload_0
    //   401: invokevirtual 226	java/io/File:delete	()Z
    //   404: pop
    //   405: iload_3
    //   406: iconst_1
    //   407: iadd
    //   408: istore_3
    //   409: goto -222 -> 187
    //   412: iconst_0
    //   413: istore_2
    //   414: goto -315 -> 99
    //   417: iconst_0
    //   418: istore_2
    //   419: goto -298 -> 121
    //   422: ldc 85
    //   424: astore 4
    //   426: goto -186 -> 240
    //   429: ldc 85
    //   431: astore 4
    //   433: goto -172 -> 261
    //   436: astore 6
    //   438: aconst_null
    //   439: astore 5
    //   441: aload 5
    //   443: astore 4
    //   445: ldc 32
    //   447: ldc 228
    //   449: aload 6
    //   451: invokestatic 133	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   454: invokevirtual 136	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   457: iconst_0
    //   458: anewarray 4	java/lang/Object
    //   461: invokestatic 127	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   464: aload 5
    //   466: invokestatic 95	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   469: goto -116 -> 353
    //   472: astore_0
    //   473: aconst_null
    //   474: astore 4
    //   476: aload 4
    //   478: invokestatic 95	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   481: aload_0
    //   482: athrow
    //   483: iconst_0
    //   484: istore_2
    //   485: goto -89 -> 396
    //   488: iload_2
    //   489: ifeq -481 -> 8
    //   492: iconst_1
    //   493: ireturn
    //   494: astore_0
    //   495: goto -19 -> 476
    //   498: astore 6
    //   500: goto -59 -> 441
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	paramFile	File
    //   0	503	1	paramSharePatchInfo	SharePatchInfo
    //   98	391	2	i	int
    //   184	225	3	j	int
    //   88	389	4	localObject	Object
    //   304	161	5	localFileOutputStream	java.io.FileOutputStream
    //   203	108	6	localProperties	java.util.Properties
    //   436	14	6	localException1	Exception
    //   498	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   295	306	436	java/lang/Exception
    //   295	306	472	finally
    //   310	348	494	finally
    //   445	464	494	finally
    //   310	348	498	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.SharePatchInfo
 * JD-Core Version:    0.7.0.1
 */