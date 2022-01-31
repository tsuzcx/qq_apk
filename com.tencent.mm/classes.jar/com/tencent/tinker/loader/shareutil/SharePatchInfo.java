package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.io.IOException;

public class SharePatchInfo
{
  public String wWw;
  public String wZr;
  public String wZs;
  public String wZt;
  
  public SharePatchInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.wZr = paramString1;
    this.wZs = paramString2;
    this.wZt = paramString3;
    this.wWw = paramString4;
  }
  
  /* Error */
  private static boolean a(File paramFile, SharePatchInfo paramSharePatchInfo)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: ifnull +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +9 -> 17
    //   11: iconst_0
    //   12: istore 4
    //   14: iload 4
    //   16: ireturn
    //   17: aload_1
    //   18: getfield 20	com/tencent/tinker/loader/shareutil/SharePatchInfo:wZt	Ljava/lang/String;
    //   21: invokestatic 33	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:bl	(Ljava/lang/String;)Z
    //   24: ifeq +10 -> 34
    //   27: aload_1
    //   28: getstatic 38	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   31: putfield 20	com/tencent/tinker/loader/shareutil/SharePatchInfo:wZt	Ljava/lang/String;
    //   34: aload_1
    //   35: getfield 22	com/tencent/tinker/loader/shareutil/SharePatchInfo:wWw	Ljava/lang/String;
    //   38: invokestatic 33	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:bl	(Ljava/lang/String;)Z
    //   41: ifeq +9 -> 50
    //   44: aload_1
    //   45: ldc 40
    //   47: putfield 22	com/tencent/tinker/loader/shareutil/SharePatchInfo:wWw	Ljava/lang/String;
    //   50: new 42	java/lang/StringBuilder
    //   53: dup
    //   54: ldc 44
    //   56: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: aload_0
    //   60: invokevirtual 53	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   63: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 59
    //   68: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_1
    //   72: getfield 16	com/tencent/tinker/loader/shareutil/SharePatchInfo:wZr	Ljava/lang/String;
    //   75: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc 61
    //   80: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_1
    //   84: getfield 18	com/tencent/tinker/loader/shareutil/SharePatchInfo:wZs	Ljava/lang/String;
    //   87: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc 63
    //   92: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_1
    //   96: getfield 20	com/tencent/tinker/loader/shareutil/SharePatchInfo:wZt	Ljava/lang/String;
    //   99: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc 65
    //   104: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: getfield 22	com/tencent/tinker/loader/shareutil/SharePatchInfo:wWw	Ljava/lang/String;
    //   111: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_0
    //   116: invokevirtual 69	java/io/File:getParentFile	()Ljava/io/File;
    //   119: astore 5
    //   121: aload 5
    //   123: invokevirtual 73	java/io/File:exists	()Z
    //   126: ifne +9 -> 135
    //   129: aload 5
    //   131: invokevirtual 76	java/io/File:mkdirs	()Z
    //   134: pop
    //   135: iconst_0
    //   136: istore_3
    //   137: iconst_0
    //   138: istore_2
    //   139: iload_3
    //   140: iconst_2
    //   141: if_icmpge +229 -> 370
    //   144: iload_2
    //   145: ifne +225 -> 370
    //   148: new 78	java/util/Properties
    //   151: dup
    //   152: invokespecial 79	java/util/Properties:<init>	()V
    //   155: astore 7
    //   157: aload 7
    //   159: ldc 81
    //   161: aload_1
    //   162: getfield 16	com/tencent/tinker/loader/shareutil/SharePatchInfo:wZr	Ljava/lang/String;
    //   165: invokevirtual 85	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   168: pop
    //   169: aload 7
    //   171: ldc 87
    //   173: aload_1
    //   174: getfield 18	com/tencent/tinker/loader/shareutil/SharePatchInfo:wZs	Ljava/lang/String;
    //   177: invokevirtual 85	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   180: pop
    //   181: aload 7
    //   183: ldc 89
    //   185: aload_1
    //   186: getfield 20	com/tencent/tinker/loader/shareutil/SharePatchInfo:wZt	Ljava/lang/String;
    //   189: invokevirtual 85	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   192: pop
    //   193: aload 7
    //   195: ldc 91
    //   197: aload_1
    //   198: getfield 22	com/tencent/tinker/loader/shareutil/SharePatchInfo:wWw	Ljava/lang/String;
    //   201: invokevirtual 85	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   204: pop
    //   205: new 93	java/io/FileOutputStream
    //   208: dup
    //   209: aload_0
    //   210: iconst_0
    //   211: invokespecial 96	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   214: astore 6
    //   216: aload 6
    //   218: astore 5
    //   220: aload 7
    //   222: aload 6
    //   224: new 42	java/lang/StringBuilder
    //   227: dup
    //   228: ldc 98
    //   230: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   233: aload_1
    //   234: getfield 16	com/tencent/tinker/loader/shareutil/SharePatchInfo:wZr	Ljava/lang/String;
    //   237: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc 100
    //   242: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_1
    //   246: getfield 18	com/tencent/tinker/loader/shareutil/SharePatchInfo:wZs	Ljava/lang/String;
    //   249: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokevirtual 107	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   258: aload 6
    //   260: invokestatic 113	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:S	(Ljava/lang/Object;)V
    //   263: aload_0
    //   264: invokestatic 117	com/tencent/tinker/loader/shareutil/SharePatchInfo:ak	(Ljava/io/File;)Lcom/tencent/tinker/loader/shareutil/SharePatchInfo;
    //   267: astore 5
    //   269: aload 5
    //   271: ifnull +94 -> 365
    //   274: aload 5
    //   276: getfield 16	com/tencent/tinker/loader/shareutil/SharePatchInfo:wZr	Ljava/lang/String;
    //   279: aload_1
    //   280: getfield 16	com/tencent/tinker/loader/shareutil/SharePatchInfo:wZr	Ljava/lang/String;
    //   283: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   286: ifeq +79 -> 365
    //   289: aload 5
    //   291: getfield 18	com/tencent/tinker/loader/shareutil/SharePatchInfo:wZs	Ljava/lang/String;
    //   294: aload_1
    //   295: getfield 18	com/tencent/tinker/loader/shareutil/SharePatchInfo:wZs	Ljava/lang/String;
    //   298: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   301: ifeq +64 -> 365
    //   304: iconst_1
    //   305: istore_2
    //   306: iload_2
    //   307: ifne +8 -> 315
    //   310: aload_0
    //   311: invokevirtual 126	java/io/File:delete	()Z
    //   314: pop
    //   315: iload_3
    //   316: iconst_1
    //   317: iadd
    //   318: istore_3
    //   319: goto -180 -> 139
    //   322: astore 7
    //   324: aconst_null
    //   325: astore 6
    //   327: aload 6
    //   329: astore 5
    //   331: new 42	java/lang/StringBuilder
    //   334: dup
    //   335: ldc 128
    //   337: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   340: aload 7
    //   342: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 6
    //   348: invokestatic 113	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:S	(Ljava/lang/Object;)V
    //   351: goto -88 -> 263
    //   354: astore_0
    //   355: aconst_null
    //   356: astore 5
    //   358: aload 5
    //   360: invokestatic 113	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:S	(Ljava/lang/Object;)V
    //   363: aload_0
    //   364: athrow
    //   365: iconst_0
    //   366: istore_2
    //   367: goto -61 -> 306
    //   370: iload_2
    //   371: ifne -357 -> 14
    //   374: iconst_0
    //   375: ireturn
    //   376: astore_0
    //   377: goto -19 -> 358
    //   380: astore 7
    //   382: goto -55 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	paramFile	File
    //   0	385	1	paramSharePatchInfo	SharePatchInfo
    //   138	233	2	i	int
    //   136	183	3	j	int
    //   1	14	4	bool	boolean
    //   119	240	5	localObject	Object
    //   214	133	6	localFileOutputStream	java.io.FileOutputStream
    //   155	66	7	localProperties	java.util.Properties
    //   322	19	7	localException1	Exception
    //   380	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   205	216	322	java/lang/Exception
    //   205	216	354	finally
    //   220	258	376	finally
    //   331	346	376	finally
    //   220	258	380	java/lang/Exception
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
      paramFile2 = ShareFileLockHelper.ad(paramFile2);
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
  private static SharePatchInfo ak(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore 5
    //   11: aconst_null
    //   12: astore 6
    //   14: iconst_0
    //   15: istore_1
    //   16: iconst_0
    //   17: istore_2
    //   18: iload_1
    //   19: iconst_2
    //   20: if_icmpge +265 -> 285
    //   23: iload_2
    //   24: ifne +261 -> 285
    //   27: iload_1
    //   28: iconst_1
    //   29: iadd
    //   30: istore_1
    //   31: new 78	java/util/Properties
    //   34: dup
    //   35: invokespecial 79	java/util/Properties:<init>	()V
    //   38: astore 12
    //   40: new 154	java/io/FileInputStream
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 157	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: astore 11
    //   50: aload 11
    //   52: astore 7
    //   54: aload 4
    //   56: astore 10
    //   58: aload 5
    //   60: astore 9
    //   62: aload 6
    //   64: astore 8
    //   66: aload 12
    //   68: aload 11
    //   70: invokevirtual 161	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   73: aload 11
    //   75: astore 7
    //   77: aload 4
    //   79: astore 10
    //   81: aload 5
    //   83: astore 9
    //   85: aload 6
    //   87: astore 8
    //   89: aload 12
    //   91: ldc 81
    //   93: invokevirtual 165	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 6
    //   98: aload 11
    //   100: astore 7
    //   102: aload 4
    //   104: astore 10
    //   106: aload 5
    //   108: astore 9
    //   110: aload 6
    //   112: astore 8
    //   114: aload 12
    //   116: ldc 87
    //   118: invokevirtual 165	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   121: astore 5
    //   123: aload 11
    //   125: astore 7
    //   127: aload 4
    //   129: astore 10
    //   131: aload 5
    //   133: astore 9
    //   135: aload 6
    //   137: astore 8
    //   139: aload 12
    //   141: ldc 89
    //   143: invokevirtual 165	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   146: astore 4
    //   148: aload 11
    //   150: astore 7
    //   152: aload 4
    //   154: astore 10
    //   156: aload 5
    //   158: astore 9
    //   160: aload 6
    //   162: astore 8
    //   164: aload 12
    //   166: ldc 91
    //   168: invokevirtual 165	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   171: astore 12
    //   173: aload 12
    //   175: astore_3
    //   176: aload 11
    //   178: invokestatic 113	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:S	(Ljava/lang/Object;)V
    //   181: aload 6
    //   183: ifnull +147 -> 330
    //   186: aload 5
    //   188: ifnull +142 -> 330
    //   191: aload 6
    //   193: ldc 167
    //   195: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   198: ifne +11 -> 209
    //   201: aload 6
    //   203: invokestatic 170	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:agm	(Ljava/lang/String;)Z
    //   206: ifeq +11 -> 217
    //   209: aload 5
    //   211: invokestatic 170	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:agm	(Ljava/lang/String;)Z
    //   214: ifne +66 -> 280
    //   217: new 42	java/lang/StringBuilder
    //   220: dup
    //   221: ldc 172
    //   223: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: aload_0
    //   227: invokevirtual 53	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   230: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: goto -216 -> 18
    //   237: astore 12
    //   239: aconst_null
    //   240: astore 11
    //   242: aload 11
    //   244: astore 7
    //   246: new 42	java/lang/StringBuilder
    //   249: dup
    //   250: ldc 174
    //   252: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   255: aload 12
    //   257: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 11
    //   263: invokestatic 113	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:S	(Ljava/lang/Object;)V
    //   266: goto -85 -> 181
    //   269: astore_0
    //   270: aconst_null
    //   271: astore 7
    //   273: aload 7
    //   275: invokestatic 113	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:S	(Ljava/lang/Object;)V
    //   278: aload_0
    //   279: athrow
    //   280: iconst_1
    //   281: istore_2
    //   282: goto -264 -> 18
    //   285: aload 13
    //   287: astore_0
    //   288: iload_2
    //   289: ifeq +18 -> 307
    //   292: new 2	com/tencent/tinker/loader/shareutil/SharePatchInfo
    //   295: dup
    //   296: aload 6
    //   298: aload 5
    //   300: aload 4
    //   302: aload_3
    //   303: invokespecial 176	com/tencent/tinker/loader/shareutil/SharePatchInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   306: astore_0
    //   307: aload_0
    //   308: areturn
    //   309: astore_0
    //   310: goto -37 -> 273
    //   313: astore 12
    //   315: aload 10
    //   317: astore 4
    //   319: aload 9
    //   321: astore 5
    //   323: aload 8
    //   325: astore 6
    //   327: goto -85 -> 242
    //   330: goto -312 -> 18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	paramFile	File
    //   15	16	1	i	int
    //   17	272	2	j	int
    //   4	299	3	localObject1	Object
    //   6	312	4	localObject2	Object
    //   9	313	5	localObject3	Object
    //   12	314	6	localObject4	Object
    //   52	222	7	localFileInputStream1	java.io.FileInputStream
    //   64	260	8	localObject5	Object
    //   60	260	9	localObject6	Object
    //   56	260	10	localObject7	Object
    //   48	214	11	localFileInputStream2	java.io.FileInputStream
    //   38	136	12	localObject8	Object
    //   237	19	12	localIOException1	IOException
    //   313	1	12	localIOException2	IOException
    //   1	285	13	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   40	50	237	java/io/IOException
    //   40	50	269	finally
    //   66	73	309	finally
    //   89	98	309	finally
    //   114	123	309	finally
    //   139	148	309	finally
    //   164	173	309	finally
    //   246	261	309	finally
    //   66	73	313	java/io/IOException
    //   89	98	313	java/io/IOException
    //   114	123	313	java/io/IOException
    //   139	148	313	java/io/IOException
    //   164	173	313	java/io/IOException
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
    //   11: invokevirtual 69	java/io/File:getParentFile	()Ljava/io/File;
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 73	java/io/File:exists	()Z
    //   19: ifne +8 -> 27
    //   22: aload_2
    //   23: invokevirtual 76	java/io/File:mkdirs	()Z
    //   26: pop
    //   27: aload_1
    //   28: invokestatic 140	com/tencent/tinker/loader/shareutil/ShareFileLockHelper:ad	(Ljava/io/File;)Lcom/tencent/tinker/loader/shareutil/ShareFileLockHelper;
    //   31: astore_1
    //   32: aload_1
    //   33: astore_2
    //   34: aload_0
    //   35: invokestatic 117	com/tencent/tinker/loader/shareutil/SharePatchInfo:ak	(Ljava/io/File;)Lcom/tencent/tinker/loader/shareutil/SharePatchInfo;
    //   38: astore_0
    //   39: aload_1
    //   40: invokevirtual 145	com/tencent/tinker/loader/shareutil/ShareFileLockHelper:close	()V
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
    //   53: new 147	com/tencent/tinker/loader/TinkerRuntimeException
    //   56: dup
    //   57: ldc 180
    //   59: aload_0
    //   60: invokespecial 152	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   63: athrow
    //   64: astore_0
    //   65: aload_2
    //   66: ifnull +7 -> 73
    //   69: aload_2
    //   70: invokevirtual 145	com/tencent/tinker/loader/shareutil/ShareFileLockHelper:close	()V
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