package com.tencent.tinker.loader.a;

import android.util.Log;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.io.IOException;

public final class g
{
  public String amh;
  public String ami;
  public String amj;
  public String amk;
  
  private g(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.amh = paramString1;
    this.ami = paramString2;
    this.amj = paramString3;
    this.amk = paramString4;
  }
  
  /* Error */
  private static boolean a(File paramFile, g paramg)
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
    //   18: getfield 20	com/tencent/tinker/loader/a/g:amj	Ljava/lang/String;
    //   21: invokestatic 33	com/tencent/tinker/loader/a/k:D	(Ljava/lang/String;)Z
    //   24: ifeq +10 -> 34
    //   27: aload_1
    //   28: getstatic 38	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   31: putfield 20	com/tencent/tinker/loader/a/g:amj	Ljava/lang/String;
    //   34: aload_1
    //   35: getfield 22	com/tencent/tinker/loader/a/g:amk	Ljava/lang/String;
    //   38: invokestatic 33	com/tencent/tinker/loader/a/k:D	(Ljava/lang/String;)Z
    //   41: ifeq +9 -> 50
    //   44: aload_1
    //   45: ldc 40
    //   47: putfield 22	com/tencent/tinker/loader/a/g:amk	Ljava/lang/String;
    //   50: ldc 42
    //   52: new 44	java/lang/StringBuilder
    //   55: dup
    //   56: ldc 46
    //   58: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   61: aload_0
    //   62: invokevirtual 55	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   65: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 61
    //   70: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: getfield 16	com/tencent/tinker/loader/a/g:amh	Ljava/lang/String;
    //   77: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 63
    //   82: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_1
    //   86: getfield 18	com/tencent/tinker/loader/a/g:ami	Ljava/lang/String;
    //   89: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 65
    //   94: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: getfield 20	com/tencent/tinker/loader/a/g:amj	Ljava/lang/String;
    //   101: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 67
    //   106: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_1
    //   110: getfield 22	com/tencent/tinker/loader/a/g:amk	Ljava/lang/String;
    //   113: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 76	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   122: pop
    //   123: aload_0
    //   124: invokevirtual 80	java/io/File:getParentFile	()Ljava/io/File;
    //   127: astore 5
    //   129: aload 5
    //   131: invokevirtual 84	java/io/File:exists	()Z
    //   134: ifne +9 -> 143
    //   137: aload 5
    //   139: invokevirtual 87	java/io/File:mkdirs	()Z
    //   142: pop
    //   143: iconst_0
    //   144: istore_3
    //   145: iconst_0
    //   146: istore_2
    //   147: iload_3
    //   148: iconst_2
    //   149: if_icmpge +237 -> 386
    //   152: iload_2
    //   153: ifne +233 -> 386
    //   156: new 89	java/util/Properties
    //   159: dup
    //   160: invokespecial 90	java/util/Properties:<init>	()V
    //   163: astore 7
    //   165: aload 7
    //   167: ldc 92
    //   169: aload_1
    //   170: getfield 16	com/tencent/tinker/loader/a/g:amh	Ljava/lang/String;
    //   173: invokevirtual 96	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: pop
    //   177: aload 7
    //   179: ldc 98
    //   181: aload_1
    //   182: getfield 18	com/tencent/tinker/loader/a/g:ami	Ljava/lang/String;
    //   185: invokevirtual 96	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: pop
    //   189: aload 7
    //   191: ldc 100
    //   193: aload_1
    //   194: getfield 20	com/tencent/tinker/loader/a/g:amj	Ljava/lang/String;
    //   197: invokevirtual 96	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   200: pop
    //   201: aload 7
    //   203: ldc 102
    //   205: aload_1
    //   206: getfield 22	com/tencent/tinker/loader/a/g:amk	Ljava/lang/String;
    //   209: invokevirtual 96	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   212: pop
    //   213: new 104	java/io/FileOutputStream
    //   216: dup
    //   217: aload_0
    //   218: iconst_0
    //   219: invokespecial 107	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   222: astore 6
    //   224: aload 6
    //   226: astore 5
    //   228: aload 7
    //   230: aload 6
    //   232: new 44	java/lang/StringBuilder
    //   235: dup
    //   236: ldc 109
    //   238: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   241: aload_1
    //   242: getfield 16	com/tencent/tinker/loader/a/g:amh	Ljava/lang/String;
    //   245: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc 111
    //   250: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload_1
    //   254: getfield 18	com/tencent/tinker/loader/a/g:ami	Ljava/lang/String;
    //   257: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokevirtual 115	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   266: aload 6
    //   268: invokestatic 121	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
    //   271: aload_0
    //   272: invokestatic 125	com/tencent/tinker/loader/a/g:o	(Ljava/io/File;)Lcom/tencent/tinker/loader/a/g;
    //   275: astore 5
    //   277: aload 5
    //   279: ifnull +102 -> 381
    //   282: aload 5
    //   284: getfield 16	com/tencent/tinker/loader/a/g:amh	Ljava/lang/String;
    //   287: aload_1
    //   288: getfield 16	com/tencent/tinker/loader/a/g:amh	Ljava/lang/String;
    //   291: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   294: ifeq +87 -> 381
    //   297: aload 5
    //   299: getfield 18	com/tencent/tinker/loader/a/g:ami	Ljava/lang/String;
    //   302: aload_1
    //   303: getfield 18	com/tencent/tinker/loader/a/g:ami	Ljava/lang/String;
    //   306: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   309: ifeq +72 -> 381
    //   312: iconst_1
    //   313: istore_2
    //   314: iload_2
    //   315: ifne +8 -> 323
    //   318: aload_0
    //   319: invokevirtual 134	java/io/File:delete	()Z
    //   322: pop
    //   323: iload_3
    //   324: iconst_1
    //   325: iadd
    //   326: istore_3
    //   327: goto -180 -> 147
    //   330: astore 7
    //   332: aconst_null
    //   333: astore 6
    //   335: aload 6
    //   337: astore 5
    //   339: ldc 42
    //   341: new 44	java/lang/StringBuilder
    //   344: dup
    //   345: ldc 136
    //   347: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   350: aload 7
    //   352: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 142	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   361: pop
    //   362: aload 6
    //   364: invokestatic 121	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
    //   367: goto -96 -> 271
    //   370: astore_0
    //   371: aconst_null
    //   372: astore 5
    //   374: aload 5
    //   376: invokestatic 121	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
    //   379: aload_0
    //   380: athrow
    //   381: iconst_0
    //   382: istore_2
    //   383: goto -69 -> 314
    //   386: iload_2
    //   387: ifne -373 -> 14
    //   390: iconst_0
    //   391: ireturn
    //   392: astore_0
    //   393: goto -19 -> 374
    //   396: astore 7
    //   398: goto -63 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	401	0	paramFile	File
    //   0	401	1	paramg	g
    //   146	241	2	i	int
    //   144	183	3	j	int
    //   1	14	4	bool	boolean
    //   127	248	5	localObject	Object
    //   222	141	6	localFileOutputStream	java.io.FileOutputStream
    //   163	66	7	localProperties	java.util.Properties
    //   330	21	7	localException1	Exception
    //   396	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   213	224	330	java/lang/Exception
    //   213	224	370	finally
    //   228	266	392	finally
    //   339	362	392	finally
    //   228	266	396	java/lang/Exception
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
    //   11: invokevirtual 80	java/io/File:getParentFile	()Ljava/io/File;
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 84	java/io/File:exists	()Z
    //   19: ifne +8 -> 27
    //   22: aload_2
    //   23: invokevirtual 87	java/io/File:mkdirs	()Z
    //   26: pop
    //   27: aload_1
    //   28: invokestatic 150	com/tencent/tinker/loader/a/d:i	(Ljava/io/File;)Lcom/tencent/tinker/loader/a/d;
    //   31: astore_1
    //   32: aload_1
    //   33: astore_2
    //   34: aload_0
    //   35: invokestatic 125	com/tencent/tinker/loader/a/g:o	(Ljava/io/File;)Lcom/tencent/tinker/loader/a/g;
    //   38: astore_0
    //   39: aload_1
    //   40: invokevirtual 155	com/tencent/tinker/loader/a/d:close	()V
    //   43: aload_0
    //   44: areturn
    //   45: astore_1
    //   46: ldc 42
    //   48: ldc 157
    //   50: aload_1
    //   51: invokestatic 171	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   54: pop
    //   55: aload_0
    //   56: areturn
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: astore_2
    //   62: new 162	com/tencent/tinker/loader/TinkerRuntimeException
    //   65: dup
    //   66: ldc 173
    //   68: aload_0
    //   69: invokespecial 167	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: athrow
    //   73: astore_0
    //   74: aload_2
    //   75: ifnull +7 -> 82
    //   78: aload_2
    //   79: invokevirtual 155	com/tencent/tinker/loader/a/d:close	()V
    //   82: aload_0
    //   83: athrow
    //   84: astore_1
    //   85: ldc 42
    //   87: ldc 157
    //   89: aload_1
    //   90: invokestatic 171	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
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
    //   20: if_icmpge +281 -> 301
    //   23: iload_2
    //   24: ifne +277 -> 301
    //   27: iload_1
    //   28: iconst_1
    //   29: iadd
    //   30: istore_1
    //   31: new 89	java/util/Properties
    //   34: dup
    //   35: invokespecial 90	java/util/Properties:<init>	()V
    //   38: astore 12
    //   40: new 175	java/io/FileInputStream
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 178	java/io/FileInputStream:<init>	(Ljava/io/File;)V
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
    //   70: invokevirtual 182	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   73: aload 11
    //   75: astore 7
    //   77: aload 4
    //   79: astore 10
    //   81: aload 5
    //   83: astore 9
    //   85: aload 6
    //   87: astore 8
    //   89: aload 12
    //   91: ldc 92
    //   93: invokevirtual 186	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
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
    //   116: ldc 98
    //   118: invokevirtual 186	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
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
    //   141: ldc 100
    //   143: invokevirtual 186	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
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
    //   166: ldc 102
    //   168: invokevirtual 186	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   171: astore 12
    //   173: aload 12
    //   175: astore_3
    //   176: aload 11
    //   178: invokestatic 121	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
    //   181: aload 6
    //   183: ifnull +163 -> 346
    //   186: aload 5
    //   188: ifnull +158 -> 346
    //   191: aload 6
    //   193: ldc 188
    //   195: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   198: ifne +11 -> 209
    //   201: aload 6
    //   203: invokestatic 191	com/tencent/tinker/loader/a/f:ag	(Ljava/lang/String;)Z
    //   206: ifeq +11 -> 217
    //   209: aload 5
    //   211: invokestatic 191	com/tencent/tinker/loader/a/f:ag	(Ljava/lang/String;)Z
    //   214: ifne +82 -> 296
    //   217: ldc 42
    //   219: new 44	java/lang/StringBuilder
    //   222: dup
    //   223: ldc 193
    //   225: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   228: aload_0
    //   229: invokevirtual 55	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   232: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 142	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   241: pop
    //   242: goto -224 -> 18
    //   245: astore 12
    //   247: aconst_null
    //   248: astore 11
    //   250: aload 11
    //   252: astore 7
    //   254: ldc 42
    //   256: new 44	java/lang/StringBuilder
    //   259: dup
    //   260: ldc 195
    //   262: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   265: aload 12
    //   267: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 142	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   276: pop
    //   277: aload 11
    //   279: invokestatic 121	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
    //   282: goto -101 -> 181
    //   285: astore_0
    //   286: aconst_null
    //   287: astore 7
    //   289: aload 7
    //   291: invokestatic 121	com/tencent/tinker/loader/a/f:R	(Ljava/lang/Object;)V
    //   294: aload_0
    //   295: athrow
    //   296: iconst_1
    //   297: istore_2
    //   298: goto -280 -> 18
    //   301: aload 13
    //   303: astore_0
    //   304: iload_2
    //   305: ifeq +18 -> 323
    //   308: new 2	com/tencent/tinker/loader/a/g
    //   311: dup
    //   312: aload 6
    //   314: aload 5
    //   316: aload 4
    //   318: aload_3
    //   319: invokespecial 197	com/tencent/tinker/loader/a/g:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   322: astore_0
    //   323: aload_0
    //   324: areturn
    //   325: astore_0
    //   326: goto -37 -> 289
    //   329: astore 12
    //   331: aload 10
    //   333: astore 4
    //   335: aload 9
    //   337: astore 5
    //   339: aload 8
    //   341: astore 6
    //   343: goto -93 -> 250
    //   346: goto -328 -> 18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	paramFile	File
    //   15	16	1	i	int
    //   17	288	2	j	int
    //   4	315	3	localObject1	Object
    //   6	328	4	localObject2	Object
    //   9	329	5	localObject3	Object
    //   12	330	6	localObject4	Object
    //   52	238	7	localFileInputStream1	java.io.FileInputStream
    //   64	276	8	localObject5	Object
    //   60	276	9	localObject6	Object
    //   56	276	10	localObject7	Object
    //   48	230	11	localFileInputStream2	java.io.FileInputStream
    //   38	136	12	localObject8	Object
    //   245	21	12	localIOException1	IOException
    //   329	1	12	localIOException2	IOException
    //   1	301	13	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   40	50	245	java/io/IOException
    //   40	50	285	finally
    //   66	73	325	finally
    //   89	98	325	finally
    //   114	123	325	finally
    //   139	148	325	finally
    //   164	173	325	finally
    //   254	277	325	finally
    //   66	73	329	java/io/IOException
    //   89	98	329	java/io/IOException
    //   114	123	329	java/io/IOException
    //   139	148	329	java/io/IOException
    //   164	173	329	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.a.g
 * JD-Core Version:    0.7.0.1
 */