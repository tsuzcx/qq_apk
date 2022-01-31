package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.io.IOException;

public class SharePatchInfo
{
  public String BsZ;
  public String BvV;
  public boolean BvW;
  public boolean BvX;
  public String BvY;
  public String vFR;
  
  public SharePatchInfo(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4)
  {
    this.vFR = paramString1;
    this.BvV = paramString2;
    this.BvW = paramBoolean1;
    this.BvX = paramBoolean2;
    this.BvY = paramString3;
    this.BsZ = paramString4;
  }
  
  /* Error */
  private static boolean a(File paramFile, SharePatchInfo paramSharePatchInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_1
    //   11: getfield 27	com/tencent/tinker/loader/shareutil/SharePatchInfo:BvY	Ljava/lang/String;
    //   14: invokestatic 40	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:isNullOrNil	(Ljava/lang/String;)Z
    //   17: ifeq +10 -> 27
    //   20: aload_1
    //   21: getstatic 45	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   24: putfield 27	com/tencent/tinker/loader/shareutil/SharePatchInfo:BvY	Ljava/lang/String;
    //   27: aload_1
    //   28: getfield 29	com/tencent/tinker/loader/shareutil/SharePatchInfo:BsZ	Ljava/lang/String;
    //   31: invokestatic 40	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:isNullOrNil	(Ljava/lang/String;)Z
    //   34: ifeq +9 -> 43
    //   37: aload_1
    //   38: ldc 47
    //   40: putfield 29	com/tencent/tinker/loader/shareutil/SharePatchInfo:BsZ	Ljava/lang/String;
    //   43: new 49	java/lang/StringBuilder
    //   46: dup
    //   47: ldc 51
    //   49: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   52: aload_0
    //   53: invokevirtual 60	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   56: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 66
    //   61: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: getfield 19	com/tencent/tinker/loader/shareutil/SharePatchInfo:vFR	Ljava/lang/String;
    //   68: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 68
    //   73: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: getfield 21	com/tencent/tinker/loader/shareutil/SharePatchInfo:BvV	Ljava/lang/String;
    //   80: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 70
    //   85: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: astore 4
    //   90: aload_1
    //   91: getfield 23	com/tencent/tinker/loader/shareutil/SharePatchInfo:BvW	Z
    //   94: ifeq +307 -> 401
    //   97: iconst_1
    //   98: istore_2
    //   99: aload 4
    //   101: iload_2
    //   102: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc 75
    //   107: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: astore 4
    //   112: aload_1
    //   113: getfield 25	com/tencent/tinker/loader/shareutil/SharePatchInfo:BvX	Z
    //   116: ifeq +290 -> 406
    //   119: iconst_1
    //   120: istore_2
    //   121: aload 4
    //   123: iload_2
    //   124: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: ldc 77
    //   129: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_1
    //   133: getfield 27	com/tencent/tinker/loader/shareutil/SharePatchInfo:BvY	Ljava/lang/String;
    //   136: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc 79
    //   141: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_1
    //   145: getfield 29	com/tencent/tinker/loader/shareutil/SharePatchInfo:BsZ	Ljava/lang/String;
    //   148: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_0
    //   153: invokevirtual 83	java/io/File:getParentFile	()Ljava/io/File;
    //   156: astore 4
    //   158: aload 4
    //   160: invokevirtual 87	java/io/File:exists	()Z
    //   163: ifne +9 -> 172
    //   166: aload 4
    //   168: invokevirtual 90	java/io/File:mkdirs	()Z
    //   171: pop
    //   172: iconst_0
    //   173: istore_3
    //   174: iconst_0
    //   175: istore_2
    //   176: iload_3
    //   177: iconst_2
    //   178: if_icmpge +295 -> 473
    //   181: iload_2
    //   182: ifne +291 -> 473
    //   185: new 92	java/util/Properties
    //   188: dup
    //   189: invokespecial 93	java/util/Properties:<init>	()V
    //   192: astore 6
    //   194: aload 6
    //   196: ldc 95
    //   198: aload_1
    //   199: getfield 19	com/tencent/tinker/loader/shareutil/SharePatchInfo:vFR	Ljava/lang/String;
    //   202: invokevirtual 99	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   205: pop
    //   206: aload 6
    //   208: ldc 101
    //   210: aload_1
    //   211: getfield 21	com/tencent/tinker/loader/shareutil/SharePatchInfo:BvV	Ljava/lang/String;
    //   214: invokevirtual 99	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   217: pop
    //   218: aload_1
    //   219: getfield 23	com/tencent/tinker/loader/shareutil/SharePatchInfo:BvW	Z
    //   222: ifeq +189 -> 411
    //   225: ldc 103
    //   227: astore 4
    //   229: aload 6
    //   231: ldc 105
    //   233: aload 4
    //   235: invokevirtual 99	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   238: pop
    //   239: aload_1
    //   240: getfield 25	com/tencent/tinker/loader/shareutil/SharePatchInfo:BvX	Z
    //   243: ifeq +175 -> 418
    //   246: ldc 103
    //   248: astore 4
    //   250: aload 6
    //   252: ldc 107
    //   254: aload 4
    //   256: invokevirtual 99	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: pop
    //   260: aload 6
    //   262: ldc 109
    //   264: aload_1
    //   265: getfield 27	com/tencent/tinker/loader/shareutil/SharePatchInfo:BvY	Ljava/lang/String;
    //   268: invokevirtual 99	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   271: pop
    //   272: aload 6
    //   274: ldc 111
    //   276: aload_1
    //   277: getfield 29	com/tencent/tinker/loader/shareutil/SharePatchInfo:BsZ	Ljava/lang/String;
    //   280: invokevirtual 99	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   283: pop
    //   284: new 113	java/io/FileOutputStream
    //   287: dup
    //   288: aload_0
    //   289: iconst_0
    //   290: invokespecial 116	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   293: astore 5
    //   295: aload 5
    //   297: astore 4
    //   299: aload 6
    //   301: aload 5
    //   303: new 49	java/lang/StringBuilder
    //   306: dup
    //   307: ldc 118
    //   309: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   312: aload_1
    //   313: getfield 19	com/tencent/tinker/loader/shareutil/SharePatchInfo:vFR	Ljava/lang/String;
    //   316: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: ldc 120
    //   321: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: aload_1
    //   325: getfield 21	com/tencent/tinker/loader/shareutil/SharePatchInfo:BvV	Ljava/lang/String;
    //   328: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokevirtual 127	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   337: aload 5
    //   339: invokestatic 133	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   342: aload_0
    //   343: invokestatic 137	com/tencent/tinker/loader/shareutil/SharePatchInfo:as	(Ljava/io/File;)Lcom/tencent/tinker/loader/shareutil/SharePatchInfo;
    //   346: astore 4
    //   348: aload 4
    //   350: ifnull +118 -> 468
    //   353: aload 4
    //   355: getfield 19	com/tencent/tinker/loader/shareutil/SharePatchInfo:vFR	Ljava/lang/String;
    //   358: aload_1
    //   359: getfield 19	com/tencent/tinker/loader/shareutil/SharePatchInfo:vFR	Ljava/lang/String;
    //   362: invokevirtual 143	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   365: ifeq +103 -> 468
    //   368: aload 4
    //   370: getfield 21	com/tencent/tinker/loader/shareutil/SharePatchInfo:BvV	Ljava/lang/String;
    //   373: aload_1
    //   374: getfield 21	com/tencent/tinker/loader/shareutil/SharePatchInfo:BvV	Ljava/lang/String;
    //   377: invokevirtual 143	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   380: ifeq +88 -> 468
    //   383: iconst_1
    //   384: istore_2
    //   385: iload_2
    //   386: ifne +8 -> 394
    //   389: aload_0
    //   390: invokevirtual 146	java/io/File:delete	()Z
    //   393: pop
    //   394: iload_3
    //   395: iconst_1
    //   396: iadd
    //   397: istore_3
    //   398: goto -222 -> 176
    //   401: iconst_0
    //   402: istore_2
    //   403: goto -304 -> 99
    //   406: iconst_0
    //   407: istore_2
    //   408: goto -287 -> 121
    //   411: ldc 148
    //   413: astore 4
    //   415: goto -186 -> 229
    //   418: ldc 148
    //   420: astore 4
    //   422: goto -172 -> 250
    //   425: astore 6
    //   427: aconst_null
    //   428: astore 5
    //   430: aload 5
    //   432: astore 4
    //   434: new 49	java/lang/StringBuilder
    //   437: dup
    //   438: ldc 150
    //   440: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   443: aload 6
    //   445: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload 5
    //   451: invokestatic 133	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   454: goto -112 -> 342
    //   457: astore_0
    //   458: aconst_null
    //   459: astore 4
    //   461: aload 4
    //   463: invokestatic 133	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   466: aload_0
    //   467: athrow
    //   468: iconst_0
    //   469: istore_2
    //   470: goto -85 -> 385
    //   473: iload_2
    //   474: ifeq -466 -> 8
    //   477: iconst_1
    //   478: ireturn
    //   479: astore_0
    //   480: goto -19 -> 461
    //   483: astore 6
    //   485: goto -55 -> 430
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	paramFile	File
    //   0	488	1	paramSharePatchInfo	SharePatchInfo
    //   98	376	2	i	int
    //   173	225	3	j	int
    //   88	374	4	localObject	Object
    //   293	157	5	localFileOutputStream	java.io.FileOutputStream
    //   192	108	6	localProperties	java.util.Properties
    //   425	19	6	localException1	Exception
    //   483	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   284	295	425	java/lang/Exception
    //   284	295	457	finally
    //   299	337	479	finally
    //   434	449	479	finally
    //   299	337	483	java/lang/Exception
  }
  
  public static boolean a(File paramFile1, SharePatchInfo paramSharePatchInfo, File paramFile2)
  {
    if ((paramFile1 == null) || (paramSharePatchInfo == null) || (paramFile2 == null)) {
      return false;
    }
    File localFile1 = paramFile2.getParentFile();
    if (!localFile1.exists()) {
      localFile1.mkdirs();
    }
    localFile2 = null;
    localFile1 = null;
    try
    {
      paramFile2 = ShareFileLockHelper.am(paramFile2);
      localFile1 = paramFile2;
      localFile2 = paramFile2;
      boolean bool = a(paramFile1, paramSharePatchInfo);
      try
      {
        paramFile2.close();
        return bool;
      }
      catch (IOException paramFile1)
      {
        return bool;
      }
      try
      {
        localFile2.close();
        throw paramFile1;
      }
      catch (IOException paramSharePatchInfo)
      {
        break label93;
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
  
  /* Error */
  private static SharePatchInfo as(File paramFile)
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
    //   26: if_icmpge +449 -> 475
    //   29: iload_2
    //   30: ifne +445 -> 475
    //   33: iload_1
    //   34: iconst_1
    //   35: iadd
    //   36: istore_1
    //   37: new 92	java/util/Properties
    //   40: dup
    //   41: invokespecial 93	java/util/Properties:<init>	()V
    //   44: astore 16
    //   46: new 176	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 179	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore 12
    //   56: aload 12
    //   58: astore 10
    //   60: aload 16
    //   62: aload 12
    //   64: invokevirtual 183	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   67: aload 12
    //   69: astore 10
    //   71: aload 16
    //   73: ldc 95
    //   75: invokevirtual 187	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
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
    //   101: ldc 101
    //   103: invokevirtual 187	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
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
    //   129: ldc 105
    //   131: invokevirtual 187	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   134: astore 17
    //   136: aload 17
    //   138: ifnull +278 -> 416
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
    //   162: invokevirtual 190	java/lang/String:isEmpty	()Z
    //   165: ifne +251 -> 416
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
    //   187: ldc 148
    //   189: aload 17
    //   191: invokevirtual 143	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifne +222 -> 416
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
    //   221: ldc 107
    //   223: invokevirtual 187	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   226: astore 17
    //   228: aload 17
    //   230: ifnull +192 -> 422
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
    //   254: invokevirtual 190	java/lang/String:isEmpty	()Z
    //   257: ifne +165 -> 422
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
    //   279: ldc 148
    //   281: aload 17
    //   283: invokevirtual 143	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   286: ifne +136 -> 422
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
    //   312: ldc 109
    //   314: invokevirtual 187	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
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
    //   340: ldc 111
    //   342: invokevirtual 187	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   345: astore 16
    //   347: aload 16
    //   349: astore 13
    //   351: aload 12
    //   353: invokestatic 133	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   356: aload 14
    //   358: astore 8
    //   360: aload 9
    //   362: ifnull +170 -> 532
    //   365: aload 8
    //   367: ifnull +165 -> 532
    //   370: aload 9
    //   372: ldc 192
    //   374: invokevirtual 143	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   377: ifne +11 -> 388
    //   380: aload 9
    //   382: invokestatic 195	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:axd	(Ljava/lang/String;)Z
    //   385: ifeq +11 -> 396
    //   388: aload 8
    //   390: invokestatic 195	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:axd	(Ljava/lang/String;)Z
    //   393: ifne +77 -> 470
    //   396: new 49	java/lang/StringBuilder
    //   399: dup
    //   400: ldc 197
    //   402: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   405: aload_0
    //   406: invokevirtual 60	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   409: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: goto -389 -> 24
    //   416: iconst_0
    //   417: istore 4
    //   419: goto -219 -> 200
    //   422: iconst_0
    //   423: istore_3
    //   424: goto -133 -> 291
    //   427: astore 11
    //   429: aconst_null
    //   430: astore 12
    //   432: aload 12
    //   434: astore 10
    //   436: new 49	java/lang/StringBuilder
    //   439: dup
    //   440: ldc 199
    //   442: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   445: aload 11
    //   447: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload 12
    //   453: invokestatic 133	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   456: goto -96 -> 360
    //   459: astore_0
    //   460: aconst_null
    //   461: astore 10
    //   463: aload 10
    //   465: invokestatic 133	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:V	(Ljava/lang/Object;)V
    //   468: aload_0
    //   469: athrow
    //   470: iconst_1
    //   471: istore_2
    //   472: goto -448 -> 24
    //   475: aload 15
    //   477: astore_0
    //   478: iload_2
    //   479: ifeq +22 -> 501
    //   482: new 2	com/tencent/tinker/loader/shareutil/SharePatchInfo
    //   485: dup
    //   486: aload 9
    //   488: aload 8
    //   490: iload 4
    //   492: iload_3
    //   493: aload 7
    //   495: aload 13
    //   497: invokespecial 201	com/tencent/tinker/loader/shareutil/SharePatchInfo:<init>	(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V
    //   500: astore_0
    //   501: aload_0
    //   502: areturn
    //   503: astore_0
    //   504: goto -41 -> 463
    //   507: astore 11
    //   509: goto -77 -> 432
    //   512: astore 10
    //   514: iload 6
    //   516: istore 4
    //   518: iload 5
    //   520: istore_3
    //   521: aload 11
    //   523: astore 7
    //   525: aload 10
    //   527: astore 11
    //   529: goto -97 -> 432
    //   532: goto -508 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	535	0	paramFile	File
    //   21	16	1	i	int
    //   23	456	2	j	int
    //   7	514	3	bool1	boolean
    //   9	508	4	bool2	boolean
    //   93	426	5	bool3	boolean
    //   90	425	6	bool4	boolean
    //   12	512	7	localObject1	Object
    //   15	474	8	localObject2	Object
    //   18	469	9	localObject3	Object
    //   58	406	10	localFileInputStream1	java.io.FileInputStream
    //   512	14	10	localIOException1	IOException
    //   78	259	11	localObject4	Object
    //   427	19	11	localIOException2	IOException
    //   507	15	11	localIOException3	IOException
    //   527	1	11	localIOException4	IOException
    //   54	398	12	localFileInputStream2	java.io.FileInputStream
    //   4	492	13	localObject5	Object
    //   106	251	14	str1	String
    //   1	475	15	localObject6	Object
    //   44	304	16	localObject7	Object
    //   134	148	17	str2	String
    // Exception table:
    //   from	to	target	type
    //   46	56	427	java/io/IOException
    //   46	56	459	finally
    //   60	67	503	finally
    //   71	80	503	finally
    //   99	108	503	finally
    //   127	136	503	finally
    //   160	168	503	finally
    //   187	197	503	finally
    //   219	228	503	finally
    //   252	260	503	finally
    //   279	289	503	finally
    //   310	319	503	finally
    //   338	347	503	finally
    //   436	451	503	finally
    //   60	67	507	java/io/IOException
    //   71	80	507	java/io/IOException
    //   99	108	512	java/io/IOException
    //   127	136	512	java/io/IOException
    //   160	168	512	java/io/IOException
    //   187	197	512	java/io/IOException
    //   219	228	512	java/io/IOException
    //   252	260	512	java/io/IOException
    //   279	289	512	java/io/IOException
    //   310	319	512	java/io/IOException
    //   338	347	512	java/io/IOException
  }
  
  /* Error */
  public static SharePatchInfo l(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: aconst_null
    //   9: areturn
    //   10: aload_1
    //   11: invokevirtual 83	java/io/File:getParentFile	()Ljava/io/File;
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 87	java/io/File:exists	()Z
    //   19: ifne +8 -> 27
    //   22: aload_2
    //   23: invokevirtual 90	java/io/File:mkdirs	()Z
    //   26: pop
    //   27: aload_1
    //   28: invokestatic 162	com/tencent/tinker/loader/shareutil/ShareFileLockHelper:am	(Ljava/io/File;)Lcom/tencent/tinker/loader/shareutil/ShareFileLockHelper;
    //   31: astore_1
    //   32: aload_1
    //   33: astore_2
    //   34: aload_0
    //   35: invokestatic 137	com/tencent/tinker/loader/shareutil/SharePatchInfo:as	(Ljava/io/File;)Lcom/tencent/tinker/loader/shareutil/SharePatchInfo;
    //   38: astore_0
    //   39: aload_1
    //   40: invokevirtual 167	com/tencent/tinker/loader/shareutil/ShareFileLockHelper:close	()V
    //   43: aload_0
    //   44: areturn
    //   45: astore_1
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: aconst_null
    //   50: astore_1
    //   51: aload_1
    //   52: astore_2
    //   53: new 169	com/tencent/tinker/loader/TinkerRuntimeException
    //   56: dup
    //   57: ldc 205
    //   59: aload_0
    //   60: invokespecial 174	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   63: athrow
    //   64: astore_0
    //   65: aload_2
    //   66: ifnull +7 -> 73
    //   69: aload_2
    //   70: invokevirtual 167	com/tencent/tinker/loader/shareutil/ShareFileLockHelper:close	()V
    //   73: aload_0
    //   74: athrow
    //   75: astore_1
    //   76: goto -3 -> 73
    //   79: astore_0
    //   80: aconst_null
    //   81: astore_2
    //   82: goto -17 -> 65
    //   85: astore_0
    //   86: goto -35 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramFile1	File
    //   0	89	1	paramFile2	File
    //   14	68	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   39	43	45	java/io/IOException
    //   27	32	48	java/lang/Exception
    //   34	39	64	finally
    //   53	64	64	finally
    //   69	73	75	java/io/IOException
    //   27	32	79	finally
    //   34	39	85	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.SharePatchInfo
 * JD-Core Version:    0.7.0.1
 */