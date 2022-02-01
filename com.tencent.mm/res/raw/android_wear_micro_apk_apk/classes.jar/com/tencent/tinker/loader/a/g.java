package com.tencent.tinker.loader.a;

import android.util.Log;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.io.IOException;

public final class g
{
  public String apH;
  public String apI;
  public boolean apJ;
  public boolean apK;
  public String apL;
  public String apM;
  
  private g(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4)
  {
    this.apH = paramString1;
    this.apI = paramString2;
    this.apJ = paramBoolean1;
    this.apK = paramBoolean2;
    this.apL = paramString3;
    this.apM = paramString4;
  }
  
  /* Error */
  private static boolean a(File paramFile, g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_1
    //   11: getfield 27	com/tencent/tinker/loader/a/g:apL	Ljava/lang/String;
    //   14: invokestatic 40	com/tencent/tinker/loader/a/k:D	(Ljava/lang/String;)Z
    //   17: ifeq +10 -> 27
    //   20: aload_1
    //   21: getstatic 45	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   24: putfield 27	com/tencent/tinker/loader/a/g:apL	Ljava/lang/String;
    //   27: aload_1
    //   28: getfield 29	com/tencent/tinker/loader/a/g:apM	Ljava/lang/String;
    //   31: invokestatic 40	com/tencent/tinker/loader/a/k:D	(Ljava/lang/String;)Z
    //   34: ifeq +9 -> 43
    //   37: aload_1
    //   38: ldc 47
    //   40: putfield 29	com/tencent/tinker/loader/a/g:apM	Ljava/lang/String;
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
    //   65: getfield 19	com/tencent/tinker/loader/a/g:apH	Ljava/lang/String;
    //   68: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 68
    //   73: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: getfield 21	com/tencent/tinker/loader/a/g:apI	Ljava/lang/String;
    //   80: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 70
    //   85: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: astore 4
    //   90: aload_1
    //   91: getfield 23	com/tencent/tinker/loader/a/g:apJ	Z
    //   94: ifeq +315 -> 409
    //   97: iconst_1
    //   98: istore_2
    //   99: aload 4
    //   101: iload_2
    //   102: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc 75
    //   107: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: astore 4
    //   112: aload_1
    //   113: getfield 25	com/tencent/tinker/loader/a/g:apK	Z
    //   116: ifeq +298 -> 414
    //   119: iconst_1
    //   120: istore_2
    //   121: ldc 77
    //   123: aload 4
    //   125: iload_2
    //   126: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: ldc 79
    //   131: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_1
    //   135: getfield 27	com/tencent/tinker/loader/a/g:apL	Ljava/lang/String;
    //   138: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 81
    //   143: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_1
    //   147: getfield 29	com/tencent/tinker/loader/a/g:apM	Ljava/lang/String;
    //   150: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 90	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   159: pop
    //   160: aload_0
    //   161: invokevirtual 94	java/io/File:getParentFile	()Ljava/io/File;
    //   164: astore 4
    //   166: aload 4
    //   168: invokevirtual 98	java/io/File:exists	()Z
    //   171: ifne +9 -> 180
    //   174: aload 4
    //   176: invokevirtual 101	java/io/File:mkdirs	()Z
    //   179: pop
    //   180: iconst_0
    //   181: istore_3
    //   182: iconst_0
    //   183: istore_2
    //   184: iload_3
    //   185: iconst_2
    //   186: if_icmpge +296 -> 482
    //   189: iload_2
    //   190: ifne +292 -> 482
    //   193: new 103	java/util/Properties
    //   196: dup
    //   197: invokespecial 104	java/util/Properties:<init>	()V
    //   200: astore 6
    //   202: aload 6
    //   204: ldc 106
    //   206: aload_1
    //   207: getfield 19	com/tencent/tinker/loader/a/g:apH	Ljava/lang/String;
    //   210: invokevirtual 110	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   213: pop
    //   214: aload 6
    //   216: ldc 112
    //   218: aload_1
    //   219: getfield 21	com/tencent/tinker/loader/a/g:apI	Ljava/lang/String;
    //   222: invokevirtual 110	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   225: pop
    //   226: aload_1
    //   227: getfield 23	com/tencent/tinker/loader/a/g:apJ	Z
    //   230: ifeq +189 -> 419
    //   233: ldc 114
    //   235: astore 4
    //   237: aload 6
    //   239: ldc 116
    //   241: aload 4
    //   243: invokevirtual 110	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   246: pop
    //   247: aload_1
    //   248: getfield 25	com/tencent/tinker/loader/a/g:apK	Z
    //   251: ifeq +175 -> 426
    //   254: ldc 114
    //   256: astore 4
    //   258: aload 6
    //   260: ldc 118
    //   262: aload 4
    //   264: invokevirtual 110	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   267: pop
    //   268: aload 6
    //   270: ldc 120
    //   272: aload_1
    //   273: getfield 27	com/tencent/tinker/loader/a/g:apL	Ljava/lang/String;
    //   276: invokevirtual 110	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   279: pop
    //   280: aload 6
    //   282: ldc 122
    //   284: aload_1
    //   285: getfield 29	com/tencent/tinker/loader/a/g:apM	Ljava/lang/String;
    //   288: invokevirtual 110	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   291: pop
    //   292: new 124	java/io/FileOutputStream
    //   295: dup
    //   296: aload_0
    //   297: iconst_0
    //   298: invokespecial 127	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   301: astore 5
    //   303: aload 5
    //   305: astore 4
    //   307: aload 6
    //   309: aload 5
    //   311: new 49	java/lang/StringBuilder
    //   314: dup
    //   315: ldc 129
    //   317: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   320: aload_1
    //   321: getfield 19	com/tencent/tinker/loader/a/g:apH	Ljava/lang/String;
    //   324: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc 131
    //   329: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_1
    //   333: getfield 21	com/tencent/tinker/loader/a/g:apI	Ljava/lang/String;
    //   336: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokevirtual 135	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   345: aload 5
    //   347: invokestatic 141	com/tencent/tinker/loader/a/f:aa	(Ljava/lang/Object;)V
    //   350: aload_0
    //   351: invokestatic 145	com/tencent/tinker/loader/a/g:o	(Ljava/io/File;)Lcom/tencent/tinker/loader/a/g;
    //   354: astore 4
    //   356: aload 4
    //   358: ifnull +119 -> 477
    //   361: aload 4
    //   363: getfield 19	com/tencent/tinker/loader/a/g:apH	Ljava/lang/String;
    //   366: aload_1
    //   367: getfield 19	com/tencent/tinker/loader/a/g:apH	Ljava/lang/String;
    //   370: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   373: ifeq +104 -> 477
    //   376: aload 4
    //   378: getfield 21	com/tencent/tinker/loader/a/g:apI	Ljava/lang/String;
    //   381: aload_1
    //   382: getfield 21	com/tencent/tinker/loader/a/g:apI	Ljava/lang/String;
    //   385: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   388: ifeq +89 -> 477
    //   391: iconst_1
    //   392: istore_2
    //   393: iload_2
    //   394: ifne +8 -> 402
    //   397: aload_0
    //   398: invokevirtual 154	java/io/File:delete	()Z
    //   401: pop
    //   402: iload_3
    //   403: iconst_1
    //   404: iadd
    //   405: istore_3
    //   406: goto -222 -> 184
    //   409: iconst_0
    //   410: istore_2
    //   411: goto -312 -> 99
    //   414: iconst_0
    //   415: istore_2
    //   416: goto -295 -> 121
    //   419: ldc 156
    //   421: astore 4
    //   423: goto -186 -> 237
    //   426: ldc 156
    //   428: astore 4
    //   430: goto -172 -> 258
    //   433: astore 6
    //   435: aconst_null
    //   436: astore 5
    //   438: aload 5
    //   440: astore 4
    //   442: ldc 77
    //   444: ldc 158
    //   446: aload 6
    //   448: invokestatic 162	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   451: invokevirtual 166	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   454: invokestatic 169	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   457: pop
    //   458: aload 5
    //   460: invokestatic 141	com/tencent/tinker/loader/a/f:aa	(Ljava/lang/Object;)V
    //   463: goto -113 -> 350
    //   466: astore_0
    //   467: aconst_null
    //   468: astore 4
    //   470: aload 4
    //   472: invokestatic 141	com/tencent/tinker/loader/a/f:aa	(Ljava/lang/Object;)V
    //   475: aload_0
    //   476: athrow
    //   477: iconst_0
    //   478: istore_2
    //   479: goto -86 -> 393
    //   482: iload_2
    //   483: ifeq -475 -> 8
    //   486: iconst_1
    //   487: ireturn
    //   488: astore_0
    //   489: goto -19 -> 470
    //   492: astore 6
    //   494: goto -56 -> 438
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	497	0	paramFile	File
    //   0	497	1	paramg	g
    //   98	385	2	i	int
    //   181	225	3	j	int
    //   88	383	4	localObject	Object
    //   301	158	5	localFileOutputStream	java.io.FileOutputStream
    //   200	108	6	localProperties	java.util.Properties
    //   433	14	6	localException1	Exception
    //   492	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   292	303	433	java/lang/Exception
    //   292	303	466	finally
    //   307	345	488	finally
    //   442	458	488	finally
    //   307	345	492	java/lang/Exception
  }
  
  public static boolean a(File paramFile1, g paramg, File paramFile2)
  {
    if ((paramFile1 == null) || (paramg == null) || (paramFile2 == null)) {
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
      paramFile2 = d.i(paramFile2);
      localFile1 = paramFile2;
      localFile2 = paramFile2;
      boolean bool = a(paramFile1, paramg);
      try
      {
        paramFile2.close();
        return bool;
      }
      catch (IOException paramFile1)
      {
        Log.i("Tinker.PatchInfo", "releaseInfoLock error", paramFile1);
        return bool;
      }
      try
      {
        localFile2.close();
        throw paramFile1;
      }
      catch (IOException paramg)
      {
        for (;;)
        {
          Log.i("Tinker.PatchInfo", "releaseInfoLock error", paramg);
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
  
  /* Error */
  public static g d(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: aconst_null
    //   9: areturn
    //   10: aload_1
    //   11: invokevirtual 94	java/io/File:getParentFile	()Ljava/io/File;
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 98	java/io/File:exists	()Z
    //   19: ifne +8 -> 27
    //   22: aload_2
    //   23: invokevirtual 101	java/io/File:mkdirs	()Z
    //   26: pop
    //   27: aload_1
    //   28: invokestatic 177	com/tencent/tinker/loader/a/d:i	(Ljava/io/File;)Lcom/tencent/tinker/loader/a/d;
    //   31: astore_1
    //   32: aload_1
    //   33: astore_2
    //   34: aload_0
    //   35: invokestatic 145	com/tencent/tinker/loader/a/g:o	(Ljava/io/File;)Lcom/tencent/tinker/loader/a/g;
    //   38: astore_0
    //   39: aload_1
    //   40: invokevirtual 182	com/tencent/tinker/loader/a/d:close	()V
    //   43: aload_0
    //   44: areturn
    //   45: astore_1
    //   46: ldc 77
    //   48: ldc 184
    //   50: aload_1
    //   51: invokestatic 198	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   54: pop
    //   55: aload_0
    //   56: areturn
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: astore_2
    //   62: new 189	com/tencent/tinker/loader/TinkerRuntimeException
    //   65: dup
    //   66: ldc 200
    //   68: aload_0
    //   69: invokespecial 194	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: athrow
    //   73: astore_0
    //   74: aload_2
    //   75: ifnull +7 -> 82
    //   78: aload_2
    //   79: invokevirtual 182	com/tencent/tinker/loader/a/d:close	()V
    //   82: aload_0
    //   83: athrow
    //   84: astore_1
    //   85: ldc 77
    //   87: ldc 184
    //   89: aload_1
    //   90: invokestatic 198	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   93: pop
    //   94: goto -12 -> 82
    //   97: astore_0
    //   98: aconst_null
    //   99: astore_2
    //   100: goto -26 -> 74
    //   103: astore_0
    //   104: goto -44 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramFile1	File
    //   0	107	1	paramFile2	File
    //   14	86	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   39	43	45	java/io/IOException
    //   27	32	57	java/lang/Exception
    //   34	39	73	finally
    //   62	73	73	finally
    //   78	82	84	java/io/IOException
    //   27	32	97	finally
    //   34	39	103	java/lang/Exception
  }
  
  /* Error */
  private static g o(File paramFile)
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
    //   26: if_icmpge +458 -> 484
    //   29: iload_2
    //   30: ifne +454 -> 484
    //   33: iload_1
    //   34: iconst_1
    //   35: iadd
    //   36: istore_1
    //   37: new 103	java/util/Properties
    //   40: dup
    //   41: invokespecial 104	java/util/Properties:<init>	()V
    //   44: astore 16
    //   46: new 202	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 205	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore 12
    //   56: aload 12
    //   58: astore 10
    //   60: aload 16
    //   62: aload 12
    //   64: invokevirtual 209	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   67: aload 12
    //   69: astore 10
    //   71: aload 16
    //   73: ldc 106
    //   75: invokevirtual 212	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
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
    //   101: ldc 112
    //   103: invokevirtual 212	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
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
    //   129: ldc 116
    //   131: invokevirtual 212	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   134: astore 17
    //   136: aload 17
    //   138: ifnull +286 -> 424
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
    //   162: invokevirtual 215	java/lang/String:isEmpty	()Z
    //   165: ifne +259 -> 424
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
    //   187: ldc 156
    //   189: aload 17
    //   191: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifne +230 -> 424
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
    //   221: ldc 118
    //   223: invokevirtual 212	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   226: astore 17
    //   228: aload 17
    //   230: ifnull +200 -> 430
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
    //   254: invokevirtual 215	java/lang/String:isEmpty	()Z
    //   257: ifne +173 -> 430
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
    //   279: ldc 156
    //   281: aload 17
    //   283: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   286: ifne +144 -> 430
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
    //   312: ldc 120
    //   314: invokevirtual 212	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
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
    //   340: ldc 122
    //   342: invokevirtual 212	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   345: astore 16
    //   347: aload 16
    //   349: astore 13
    //   351: aload 12
    //   353: invokestatic 141	com/tencent/tinker/loader/a/f:aa	(Ljava/lang/Object;)V
    //   356: aload 14
    //   358: astore 8
    //   360: aload 9
    //   362: ifnull +179 -> 541
    //   365: aload 8
    //   367: ifnull +174 -> 541
    //   370: aload 9
    //   372: ldc 217
    //   374: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   377: ifne +11 -> 388
    //   380: aload 9
    //   382: invokestatic 220	com/tencent/tinker/loader/a/f:ak	(Ljava/lang/String;)Z
    //   385: ifeq +11 -> 396
    //   388: aload 8
    //   390: invokestatic 220	com/tencent/tinker/loader/a/f:ak	(Ljava/lang/String;)Z
    //   393: ifne +86 -> 479
    //   396: ldc 77
    //   398: new 49	java/lang/StringBuilder
    //   401: dup
    //   402: ldc 222
    //   404: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   407: aload_0
    //   408: invokevirtual 60	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   411: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 169	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   420: pop
    //   421: goto -397 -> 24
    //   424: iconst_0
    //   425: istore 4
    //   427: goto -227 -> 200
    //   430: iconst_0
    //   431: istore_3
    //   432: goto -141 -> 291
    //   435: astore 11
    //   437: aconst_null
    //   438: astore 12
    //   440: aload 12
    //   442: astore 10
    //   444: ldc 77
    //   446: ldc 224
    //   448: aload 11
    //   450: invokestatic 162	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   453: invokevirtual 166	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   456: invokestatic 169	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   459: pop
    //   460: aload 12
    //   462: invokestatic 141	com/tencent/tinker/loader/a/f:aa	(Ljava/lang/Object;)V
    //   465: goto -105 -> 360
    //   468: astore_0
    //   469: aconst_null
    //   470: astore 10
    //   472: aload 10
    //   474: invokestatic 141	com/tencent/tinker/loader/a/f:aa	(Ljava/lang/Object;)V
    //   477: aload_0
    //   478: athrow
    //   479: iconst_1
    //   480: istore_2
    //   481: goto -457 -> 24
    //   484: aload 15
    //   486: astore_0
    //   487: iload_2
    //   488: ifeq +22 -> 510
    //   491: new 2	com/tencent/tinker/loader/a/g
    //   494: dup
    //   495: aload 9
    //   497: aload 8
    //   499: iload 4
    //   501: iload_3
    //   502: aload 7
    //   504: aload 13
    //   506: invokespecial 226	com/tencent/tinker/loader/a/g:<init>	(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V
    //   509: astore_0
    //   510: aload_0
    //   511: areturn
    //   512: astore_0
    //   513: goto -41 -> 472
    //   516: astore 11
    //   518: goto -78 -> 440
    //   521: astore 10
    //   523: iload 6
    //   525: istore 4
    //   527: iload 5
    //   529: istore_3
    //   530: aload 11
    //   532: astore 7
    //   534: aload 10
    //   536: astore 11
    //   538: goto -98 -> 440
    //   541: goto -517 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	544	0	paramFile	File
    //   21	16	1	i	int
    //   23	465	2	j	int
    //   7	523	3	bool1	boolean
    //   9	517	4	bool2	boolean
    //   93	435	5	bool3	boolean
    //   90	434	6	bool4	boolean
    //   12	521	7	localObject1	Object
    //   15	483	8	localObject2	Object
    //   18	478	9	localObject3	Object
    //   58	415	10	localFileInputStream1	java.io.FileInputStream
    //   521	14	10	localIOException1	IOException
    //   78	259	11	localObject4	Object
    //   435	14	11	localIOException2	IOException
    //   516	15	11	localIOException3	IOException
    //   536	1	11	localIOException4	IOException
    //   54	407	12	localFileInputStream2	java.io.FileInputStream
    //   4	501	13	localObject5	Object
    //   106	251	14	str1	String
    //   1	484	15	localObject6	Object
    //   44	304	16	localObject7	Object
    //   134	148	17	str2	String
    // Exception table:
    //   from	to	target	type
    //   46	56	435	java/io/IOException
    //   46	56	468	finally
    //   60	67	512	finally
    //   71	80	512	finally
    //   99	108	512	finally
    //   127	136	512	finally
    //   160	168	512	finally
    //   187	197	512	finally
    //   219	228	512	finally
    //   252	260	512	finally
    //   279	289	512	finally
    //   310	319	512	finally
    //   338	347	512	finally
    //   444	460	512	finally
    //   60	67	516	java/io/IOException
    //   71	80	516	java/io/IOException
    //   99	108	521	java/io/IOException
    //   127	136	521	java/io/IOException
    //   160	168	521	java/io/IOException
    //   187	197	521	java/io/IOException
    //   219	228	521	java/io/IOException
    //   252	260	521	java/io/IOException
    //   279	289	521	java/io/IOException
    //   310	319	521	java/io/IOException
    //   338	347	521	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.a.g
 * JD-Core Version:    0.7.0.1
 */