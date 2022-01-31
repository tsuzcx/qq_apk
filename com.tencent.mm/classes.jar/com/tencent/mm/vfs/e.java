package com.tencent.mm.vfs;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.List;

public final class e
{
  /* Error */
  public static long C(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 9
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: invokevirtual 21	java/lang/String:length	()I
    //   13: ifeq +14 -> 27
    //   16: aload_1
    //   17: ifnull +10 -> 27
    //   20: aload_1
    //   21: invokevirtual 21	java/lang/String:length	()I
    //   24: ifne +12 -> 36
    //   27: ldc 9
    //   29: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: ldc2_w 25
    //   35: lreturn
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 30	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +12 -> 53
    //   44: ldc 9
    //   46: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: ldc2_w 25
    //   52: lreturn
    //   53: aconst_null
    //   54: astore 7
    //   56: aconst_null
    //   57: astore 6
    //   59: aconst_null
    //   60: astore 9
    //   62: aload_0
    //   63: invokestatic 34	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   66: astore 5
    //   68: aload 6
    //   70: astore 7
    //   72: aload 5
    //   74: astore 6
    //   76: aload_1
    //   77: iconst_0
    //   78: invokestatic 38	com/tencent/mm/vfs/e:M	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   81: astore 8
    //   83: sipush 1024
    //   86: newarray byte
    //   88: astore 6
    //   90: lconst_0
    //   91: lstore_3
    //   92: aload 5
    //   94: aload 6
    //   96: invokevirtual 44	java/io/InputStream:read	([B)I
    //   99: istore_2
    //   100: iload_2
    //   101: iconst_m1
    //   102: if_icmpeq +20 -> 122
    //   105: aload 8
    //   107: aload 6
    //   109: iconst_0
    //   110: iload_2
    //   111: invokevirtual 50	java/io/OutputStream:write	([BII)V
    //   114: lload_3
    //   115: iload_2
    //   116: i2l
    //   117: ladd
    //   118: lstore_3
    //   119: goto -27 -> 92
    //   122: ldc 52
    //   124: ldc 54
    //   126: iconst_2
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_0
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: aload_1
    //   137: aastore
    //   138: invokestatic 60	com/tencent/f/a/b:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload 5
    //   143: ifnull +8 -> 151
    //   146: aload 5
    //   148: invokevirtual 64	java/io/InputStream:close	()V
    //   151: aload 8
    //   153: ifnull +8 -> 161
    //   156: aload 8
    //   158: invokevirtual 65	java/io/OutputStream:close	()V
    //   161: ldc 9
    //   163: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: lload_3
    //   167: lreturn
    //   168: astore 8
    //   170: aconst_null
    //   171: astore 5
    //   173: aload 9
    //   175: astore 7
    //   177: aload 5
    //   179: astore 6
    //   181: ldc 52
    //   183: ldc 67
    //   185: iconst_3
    //   186: anewarray 4	java/lang/Object
    //   189: dup
    //   190: iconst_0
    //   191: aload_0
    //   192: aastore
    //   193: dup
    //   194: iconst_1
    //   195: aload_1
    //   196: aastore
    //   197: dup
    //   198: iconst_2
    //   199: aload 8
    //   201: invokevirtual 71	java/io/IOException:getMessage	()Ljava/lang/String;
    //   204: aastore
    //   205: invokestatic 74	com/tencent/f/a/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: aload 5
    //   210: ifnull +8 -> 218
    //   213: aload 5
    //   215: invokevirtual 64	java/io/InputStream:close	()V
    //   218: aload 9
    //   220: ifnull +8 -> 228
    //   223: aload 9
    //   225: invokevirtual 65	java/io/OutputStream:close	()V
    //   228: ldc 9
    //   230: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: ldc2_w 25
    //   236: lreturn
    //   237: astore_0
    //   238: aconst_null
    //   239: astore 5
    //   241: aload 5
    //   243: ifnull +8 -> 251
    //   246: aload 5
    //   248: invokevirtual 64	java/io/InputStream:close	()V
    //   251: aload 7
    //   253: ifnull +8 -> 261
    //   256: aload 7
    //   258: invokevirtual 65	java/io/OutputStream:close	()V
    //   261: ldc 9
    //   263: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aload_0
    //   267: athrow
    //   268: astore_0
    //   269: goto -118 -> 151
    //   272: astore_0
    //   273: goto -112 -> 161
    //   276: astore_0
    //   277: goto -59 -> 218
    //   280: astore_0
    //   281: goto -53 -> 228
    //   284: astore_1
    //   285: goto -34 -> 251
    //   288: astore_1
    //   289: goto -28 -> 261
    //   292: astore_0
    //   293: aload 6
    //   295: astore 5
    //   297: goto -56 -> 241
    //   300: astore_0
    //   301: aload 8
    //   303: astore 7
    //   305: goto -64 -> 241
    //   308: astore 8
    //   310: goto -137 -> 173
    //   313: astore 6
    //   315: aload 8
    //   317: astore 9
    //   319: aload 6
    //   321: astore 8
    //   323: goto -150 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramString1	String
    //   0	326	1	paramString2	String
    //   99	17	2	i	int
    //   91	76	3	l	long
    //   66	230	5	localObject1	Object
    //   57	237	6	localObject2	Object
    //   313	7	6	localIOException1	IOException
    //   54	250	7	localObject3	Object
    //   81	76	8	localOutputStream	OutputStream
    //   168	134	8	localIOException2	IOException
    //   308	8	8	localIOException3	IOException
    //   321	1	8	localIOException4	IOException
    //   60	258	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   62	68	168	java/io/IOException
    //   62	68	237	finally
    //   146	151	268	java/io/IOException
    //   156	161	272	java/io/IOException
    //   213	218	276	java/io/IOException
    //   223	228	280	java/io/IOException
    //   246	251	284	java/io/IOException
    //   256	261	288	java/io/IOException
    //   76	83	292	finally
    //   181	208	292	finally
    //   83	90	300	finally
    //   92	100	300	finally
    //   105	114	300	finally
    //   122	141	300	finally
    //   76	83	308	java/io/IOException
    //   83	90	313	java/io/IOException
    //   92	100	313	java/io/IOException
    //   105	114	313	java/io/IOException
    //   122	141	313	java/io/IOException
  }
  
  public static OutputStream M(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54630);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = new FileNotFoundException("path is empty");
      AppMethodBeat.o(54630);
      throw paramString;
    }
    paramString = a(j.parseUri(paramString), null, paramBoolean);
    AppMethodBeat.o(54630);
    return paramString;
  }
  
  public static boolean O(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54655);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(54655);
      return false;
    }
    paramString = j.parseUri(paramString);
    paramString = FileSystemManager.dQE().a(paramString, null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(54655);
      return false;
    }
    paramBoolean = paramString.AQb.O(paramString.path, paramBoolean);
    AppMethodBeat.o(54655);
    return paramBoolean;
  }
  
  public static int a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(54636);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramArrayOfByte.length < paramInt + 0))
    {
      AppMethodBeat.o(54636);
      return -2;
    }
    localObject3 = null;
    Object localObject1 = null;
    try
    {
      OutputStream localOutputStream = M(paramString, true);
      localObject1 = localOutputStream;
      localObject3 = localOutputStream;
      localOutputStream.write(paramArrayOfByte, 0, paramInt);
      if (localOutputStream != null) {}
      try
      {
        localOutputStream.close();
        AppMethodBeat.o(54636);
        return 0;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          com.tencent.f.a.b.c("MicroMsg.VFSFileOp", localIOException1, "");
          com.tencent.f.a.b.w("MicroMsg.VFSFileOp", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", new Object[] { localIOException1.getClass().getSimpleName(), localIOException1.getMessage(), paramString, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(0), Integer.valueOf(paramInt) });
        }
      }
      try
      {
        localObject3.close();
        AppMethodBeat.o(54636);
        throw localObject2;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          com.tencent.f.a.b.c("MicroMsg.VFSFileOp", localIOException3, "");
          com.tencent.f.a.b.w("MicroMsg.VFSFileOp", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", new Object[] { localIOException3.getClass().getSimpleName(), localIOException3.getMessage(), paramString, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(0), Integer.valueOf(paramInt) });
        }
      }
    }
    catch (Exception localException)
    {
      localObject3 = localIOException1;
      com.tencent.f.a.b.c("MicroMsg.VFSFileOp", localException, "");
      localObject3 = localIOException1;
      com.tencent.f.a.b.w("MicroMsg.VFSFileOp", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", new Object[] { localException.getClass().getSimpleName(), localException.getMessage(), paramString, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(0), Integer.valueOf(paramInt) });
      if (localIOException1 != null) {}
      try
      {
        localIOException1.close();
        AppMethodBeat.o(54636);
        return -1;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          com.tencent.f.a.b.c("MicroMsg.VFSFileOp", localIOException2, "");
          com.tencent.f.a.b.w("MicroMsg.VFSFileOp", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", new Object[] { localIOException2.getClass().getSimpleName(), localIOException2.getMessage(), paramString, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(0), Integer.valueOf(paramInt) });
        }
      }
    }
    finally
    {
      if (localObject3 == null) {}
    }
  }
  
  static OutputStream a(Uri paramUri, FileSystemManager.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(54632);
    paramd = FileSystemManager.dQE().a(paramUri, paramd);
    if (!paramd.valid())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(54632);
      throw paramUri;
    }
    try
    {
      paramUri = paramd.AQb.M(paramd.path, paramBoolean);
      AppMethodBeat.o(54632);
      return paramUri;
    }
    catch (IOException paramUri)
    {
      paramUri = (FileNotFoundException)new FileNotFoundException(paramUri.getMessage()).initCause(paramUri);
      AppMethodBeat.o(54632);
      throw paramUri;
    }
  }
  
  private static RandomAccessFile a(Uri paramUri, boolean paramBoolean)
  {
    AppMethodBeat.i(54634);
    FileSystemManager.d locald = FileSystemManager.dQE().a(paramUri, null);
    if (!locald.valid())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(54634);
      throw paramUri;
    }
    paramUri = FileSystemManager.a(locald, paramBoolean);
    AppMethodBeat.o(54634);
    return paramUri;
  }
  
  /* Error */
  private static boolean a(FileSystemManager.d paramd1, FileSystemManager.d paramd2)
  {
    // Byte code:
    //   0: ldc 182
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 115	com/tencent/mm/vfs/FileSystemManager$d:valid	()Z
    //   9: ifeq +10 -> 19
    //   12: aload_1
    //   13: invokevirtual 115	com/tencent/mm/vfs/FileSystemManager$d:valid	()Z
    //   16: ifne +10 -> 26
    //   19: ldc 182
    //   21: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: getfield 119	com/tencent/mm/vfs/FileSystemManager$d:AQb	Lcom/tencent/mm/vfs/FileSystem;
    //   30: aload_0
    //   31: getfield 123	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   34: iconst_1
    //   35: invokeinterface 186 3 0
    //   40: astore 4
    //   42: aload 4
    //   44: ifnonnull +10 -> 54
    //   47: ldc 182
    //   49: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: iconst_0
    //   53: ireturn
    //   54: new 188	java/util/HashSet
    //   57: dup
    //   58: invokespecial 190	java/util/HashSet:<init>	()V
    //   61: astore 7
    //   63: aload_1
    //   64: getfield 119	com/tencent/mm/vfs/FileSystemManager$d:AQb	Lcom/tencent/mm/vfs/FileSystem;
    //   67: aload_1
    //   68: getfield 123	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   71: invokeinterface 194 2 0
    //   76: pop
    //   77: aload 7
    //   79: aload_1
    //   80: getfield 123	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   83: invokevirtual 197	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   86: pop
    //   87: aload 4
    //   89: invokeinterface 203 1 0
    //   94: astore 8
    //   96: aload 8
    //   98: invokeinterface 208 1 0
    //   103: ifeq +326 -> 429
    //   106: aload 8
    //   108: invokeinterface 212 1 0
    //   113: checkcast 214	com/tencent/mm/vfs/FileSystem$a
    //   116: astore 6
    //   118: aload_0
    //   119: getfield 123	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   122: invokevirtual 21	java/lang/String:length	()I
    //   125: istore_3
    //   126: iload_3
    //   127: istore_2
    //   128: aload_0
    //   129: getfield 123	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   132: ldc 216
    //   134: invokevirtual 219	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   137: ifeq +7 -> 144
    //   140: iload_3
    //   141: iconst_1
    //   142: isub
    //   143: istore_2
    //   144: new 221	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   151: aload_1
    //   152: getfield 123	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   155: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload 6
    //   160: getfield 229	com/tencent/mm/vfs/FileSystem$a:APr	Ljava/lang/String;
    //   163: iload_2
    //   164: invokevirtual 233	java/lang/String:substring	(I)Ljava/lang/String;
    //   167: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: astore 5
    //   175: aload 6
    //   177: getfield 240	com/tencent/mm/vfs/FileSystem$a:APu	Z
    //   180: ifeq +28 -> 208
    //   183: aload 7
    //   185: aload 5
    //   187: invokevirtual 197	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   190: ifeq -94 -> 96
    //   193: aload_1
    //   194: getfield 119	com/tencent/mm/vfs/FileSystemManager$d:AQb	Lcom/tencent/mm/vfs/FileSystem;
    //   197: aload 5
    //   199: invokeinterface 194 2 0
    //   204: pop
    //   205: goto -109 -> 96
    //   208: aload 5
    //   210: bipush 47
    //   212: invokevirtual 244	java/lang/String:lastIndexOf	(I)I
    //   215: istore_2
    //   216: iload_2
    //   217: ifle +34 -> 251
    //   220: aload 5
    //   222: iconst_0
    //   223: iload_2
    //   224: invokevirtual 247	java/lang/String:substring	(II)Ljava/lang/String;
    //   227: astore 4
    //   229: aload 7
    //   231: aload 4
    //   233: invokevirtual 197	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   236: ifeq +15 -> 251
    //   239: aload_1
    //   240: getfield 119	com/tencent/mm/vfs/FileSystemManager$d:AQb	Lcom/tencent/mm/vfs/FileSystem;
    //   243: aload 4
    //   245: invokeinterface 194 2 0
    //   250: pop
    //   251: aload 6
    //   253: invokevirtual 251	com/tencent/mm/vfs/FileSystem$a:dQA	()Ljava/io/InputStream;
    //   256: astore 4
    //   258: aload_1
    //   259: getfield 119	com/tencent/mm/vfs/FileSystemManager$d:AQb	Lcom/tencent/mm/vfs/FileSystem;
    //   262: aload 5
    //   264: iconst_0
    //   265: invokeinterface 171 3 0
    //   270: astore 5
    //   272: sipush 4096
    //   275: newarray byte
    //   277: astore 9
    //   279: aload 4
    //   281: aload 9
    //   283: invokevirtual 44	java/io/InputStream:read	([B)I
    //   286: istore_2
    //   287: iload_2
    //   288: iflt +82 -> 370
    //   291: aload 5
    //   293: aload 9
    //   295: iconst_0
    //   296: iload_2
    //   297: invokevirtual 50	java/io/OutputStream:write	([BII)V
    //   300: goto -21 -> 279
    //   303: astore_1
    //   304: aload 5
    //   306: astore_0
    //   307: ldc 52
    //   309: new 221	java/lang/StringBuilder
    //   312: dup
    //   313: ldc 253
    //   315: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   318: aload 6
    //   320: getfield 229	com/tencent/mm/vfs/FileSystem$a:APr	Ljava/lang/String;
    //   323: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc_w 256
    //   329: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_1
    //   333: invokevirtual 71	java/io/IOException:getMessage	()Ljava/lang/String;
    //   336: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 259	com/tencent/f/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload 4
    //   347: ifnull +8 -> 355
    //   350: aload 4
    //   352: invokevirtual 64	java/io/InputStream:close	()V
    //   355: aload_0
    //   356: ifnull +7 -> 363
    //   359: aload_0
    //   360: invokevirtual 65	java/io/OutputStream:close	()V
    //   363: ldc 182
    //   365: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: iconst_0
    //   369: ireturn
    //   370: aload 4
    //   372: ifnull +8 -> 380
    //   375: aload 4
    //   377: invokevirtual 64	java/io/InputStream:close	()V
    //   380: aload 5
    //   382: ifnull -286 -> 96
    //   385: aload 5
    //   387: invokevirtual 65	java/io/OutputStream:close	()V
    //   390: goto -294 -> 96
    //   393: astore 4
    //   395: goto -299 -> 96
    //   398: astore_1
    //   399: aconst_null
    //   400: astore_0
    //   401: aconst_null
    //   402: astore 4
    //   404: aload 4
    //   406: ifnull +8 -> 414
    //   409: aload 4
    //   411: invokevirtual 64	java/io/InputStream:close	()V
    //   414: aload_0
    //   415: ifnull +7 -> 422
    //   418: aload_0
    //   419: invokevirtual 65	java/io/OutputStream:close	()V
    //   422: ldc 182
    //   424: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   427: aload_1
    //   428: athrow
    //   429: ldc 182
    //   431: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   434: iconst_1
    //   435: ireturn
    //   436: astore 4
    //   438: goto -58 -> 380
    //   441: astore_1
    //   442: goto -87 -> 355
    //   445: astore_0
    //   446: goto -83 -> 363
    //   449: astore 4
    //   451: goto -37 -> 414
    //   454: astore_0
    //   455: goto -33 -> 422
    //   458: astore_1
    //   459: aconst_null
    //   460: astore_0
    //   461: goto -57 -> 404
    //   464: astore_1
    //   465: aload 5
    //   467: astore_0
    //   468: goto -64 -> 404
    //   471: astore_1
    //   472: goto -68 -> 404
    //   475: astore_1
    //   476: aconst_null
    //   477: astore_0
    //   478: aconst_null
    //   479: astore 4
    //   481: goto -174 -> 307
    //   484: astore_1
    //   485: aconst_null
    //   486: astore_0
    //   487: goto -180 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	paramd1	FileSystemManager.d
    //   0	490	1	paramd2	FileSystemManager.d
    //   127	170	2	i	int
    //   125	18	3	j	int
    //   40	336	4	localObject1	Object
    //   393	1	4	localException1	Exception
    //   402	8	4	localObject2	Object
    //   436	1	4	localException2	Exception
    //   449	1	4	localException3	Exception
    //   479	1	4	localObject3	Object
    //   173	293	5	localObject4	Object
    //   116	203	6	locala	FileSystem.a
    //   61	169	7	localHashSet	java.util.HashSet
    //   94	13	8	localIterator	java.util.Iterator
    //   277	17	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   272	279	303	java/io/IOException
    //   279	287	303	java/io/IOException
    //   291	300	303	java/io/IOException
    //   385	390	393	java/lang/Exception
    //   251	258	398	finally
    //   375	380	436	java/lang/Exception
    //   350	355	441	java/lang/Exception
    //   359	363	445	java/lang/Exception
    //   409	414	449	java/lang/Exception
    //   418	422	454	java/lang/Exception
    //   258	272	458	finally
    //   272	279	464	finally
    //   279	287	464	finally
    //   291	300	464	finally
    //   307	345	471	finally
    //   251	258	475	java/io/IOException
    //   258	272	484	java/io/IOException
  }
  
  public static boolean aT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(54649);
    if ((paramString1 == null) || (paramString2 == null) || (paramString1.length() == 0) || (paramString2.length() == 0))
    {
      AppMethodBeat.o(54649);
      return false;
    }
    if (new b(paramString1).p(new b(paramString2)))
    {
      AppMethodBeat.o(54649);
      return true;
    }
    if (C(paramString1, paramString2) < 0L)
    {
      AppMethodBeat.o(54649);
      return false;
    }
    deleteFile(paramString1);
    AppMethodBeat.o(54649);
    return true;
  }
  
  public static Uri avH(String paramString)
  {
    AppMethodBeat.i(54635);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(54635);
      return null;
    }
    paramString = FileSystemManager.dQE().a(j.parseUri(paramString), null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(54635);
      return null;
    }
    paramString = FileSystemManager.a(paramString, false, true);
    if (paramString == null)
    {
      AppMethodBeat.o(54635);
      return null;
    }
    paramString = Uri.fromFile(new File(paramString));
    AppMethodBeat.o(54635);
    return paramString;
  }
  
  public static long avI(String paramString)
  {
    AppMethodBeat.i(54637);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(54637);
      return 0L;
    }
    paramString = j.parseUri(paramString);
    paramString = FileSystemManager.dQE().a(paramString, null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(54637);
      return 0L;
    }
    paramString = paramString.AQb.ul(paramString.path);
    if (paramString == null)
    {
      AppMethodBeat.o(54637);
      return 0L;
    }
    long l = paramString.size;
    AppMethodBeat.o(54637);
    return l;
  }
  
  public static long avJ(String paramString)
  {
    AppMethodBeat.i(54638);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(54638);
      return 0L;
    }
    paramString = j.parseUri(paramString);
    paramString = FileSystemManager.dQE().a(paramString, null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(54638);
      return 0L;
    }
    paramString = paramString.AQb.ul(paramString.path);
    if (paramString == null)
    {
      AppMethodBeat.o(54638);
      return 0L;
    }
    long l = paramString.APt;
    AppMethodBeat.o(54638);
    return l;
  }
  
  public static String avK(String paramString)
  {
    AppMethodBeat.i(54643);
    paramString = new b(paramString).dQK().getParent();
    AppMethodBeat.o(54643);
    return paramString;
  }
  
  public static boolean avL(String paramString)
  {
    AppMethodBeat.i(54656);
    try
    {
      paramString = new b(paramString);
      if ((paramString.exists()) || (paramString.createNewFile()))
      {
        AppMethodBeat.o(54656);
        return true;
      }
      AppMethodBeat.o(54656);
      return false;
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(54656);
    }
    return false;
  }
  
  public static final String avM(String paramString)
  {
    AppMethodBeat.i(54658);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(54658);
      return "";
    }
    String str = new b(paramString).getName();
    int i = str.lastIndexOf('.');
    if (i < 0)
    {
      AppMethodBeat.o(54658);
      return paramString;
    }
    if (i == 0)
    {
      AppMethodBeat.o(54658);
      return "";
    }
    paramString = str.substring(0, i);
    AppMethodBeat.o(54658);
    return paramString;
  }
  
  public static void avN(String paramString)
  {
    AppMethodBeat.i(54659);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(54659);
      return;
    }
    paramString = j.parseUri(paramString);
    paramString = FileSystemManager.dQE().a(paramString, null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(54659);
      return;
    }
    if ((paramString.AQb.ajj() & 0x4) == 0)
    {
      AppMethodBeat.o(54659);
      return;
    }
    if (paramString.AQb.P(paramString.path, true) == null)
    {
      AppMethodBeat.o(54659);
      return;
    }
    try
    {
      paramString.AQb.M(paramString.path + "/.nomedia", false).close();
      AppMethodBeat.o(54659);
      return;
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(54659);
    }
  }
  
  /* Error */
  private static byte[] avO(String paramString)
  {
    // Byte code:
    //   0: ldc_w 340
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 340
    //   13: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: invokestatic 34	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore_0
    //   23: ldc_w 342
    //   26: invokestatic 348	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   29: astore_2
    //   30: sipush 2048
    //   33: newarray byte
    //   35: astore_3
    //   36: aload_0
    //   37: aload_3
    //   38: invokevirtual 44	java/io/InputStream:read	([B)I
    //   41: istore_1
    //   42: iload_1
    //   43: iflt +30 -> 73
    //   46: aload_2
    //   47: aload_3
    //   48: iconst_0
    //   49: iload_1
    //   50: invokevirtual 351	java/security/MessageDigest:update	([BII)V
    //   53: goto -17 -> 36
    //   56: astore_2
    //   57: aload_0
    //   58: ifnull +7 -> 65
    //   61: aload_0
    //   62: invokevirtual 64	java/io/InputStream:close	()V
    //   65: ldc_w 340
    //   68: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aconst_null
    //   72: areturn
    //   73: aload_2
    //   74: invokevirtual 355	java/security/MessageDigest:digest	()[B
    //   77: astore_2
    //   78: aload_0
    //   79: ifnull +7 -> 86
    //   82: aload_0
    //   83: invokevirtual 64	java/io/InputStream:close	()V
    //   86: ldc_w 340
    //   89: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_2
    //   93: areturn
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: ifnull +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 64	java/io/InputStream:close	()V
    //   105: ldc_w 340
    //   108: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_0
    //   112: athrow
    //   113: astore_0
    //   114: goto -28 -> 86
    //   117: astore_0
    //   118: goto -53 -> 65
    //   121: astore_2
    //   122: goto -17 -> 105
    //   125: astore_2
    //   126: aload_0
    //   127: astore_3
    //   128: aload_2
    //   129: astore_0
    //   130: aload_3
    //   131: astore_2
    //   132: goto -35 -> 97
    //   135: astore_0
    //   136: aconst_null
    //   137: astore_0
    //   138: goto -81 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramString	String
    //   41	9	1	i	int
    //   29	18	2	localMessageDigest	java.security.MessageDigest
    //   56	18	2	localException	Exception
    //   77	25	2	arrayOfByte	byte[]
    //   121	1	2	localIOException	IOException
    //   125	4	2	localObject1	Object
    //   131	1	2	localObject2	Object
    //   35	96	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   23	36	56	java/lang/Exception
    //   36	42	56	java/lang/Exception
    //   46	53	56	java/lang/Exception
    //   73	78	56	java/lang/Exception
    //   18	23	94	finally
    //   82	86	113	java/io/IOException
    //   61	65	117	java/io/IOException
    //   101	105	121	java/io/IOException
    //   23	36	125	finally
    //   36	42	125	finally
    //   46	53	125	finally
    //   73	78	125	finally
    //   18	23	135	java/lang/Exception
  }
  
  public static String avP(String paramString)
  {
    AppMethodBeat.i(54661);
    paramString = avO(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(54661);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(32);
    int i = 0;
    while (i < paramString.length)
    {
      localStringBuilder.append(Integer.toString((paramString[i] & 0xFF) + 256, 16).substring(1));
      i += 1;
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(54661);
    return paramString;
  }
  
  /* Error */
  public static int b(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 365
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +12 -> 19
    //   10: ldc_w 365
    //   13: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: bipush 254
    //   18: ireturn
    //   19: aload_1
    //   20: arraylength
    //   21: iload_2
    //   22: iconst_0
    //   23: iadd
    //   24: if_icmpge +12 -> 36
    //   27: ldc_w 365
    //   30: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: bipush 253
    //   35: ireturn
    //   36: aconst_null
    //   37: astore 4
    //   39: aconst_null
    //   40: astore_3
    //   41: aload_0
    //   42: iconst_0
    //   43: invokestatic 38	com/tencent/mm/vfs/e:M	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   46: astore 5
    //   48: aload 5
    //   50: astore_3
    //   51: aload 5
    //   53: astore 4
    //   55: aload 5
    //   57: aload_1
    //   58: iconst_0
    //   59: iload_2
    //   60: invokevirtual 50	java/io/OutputStream:write	([BII)V
    //   63: aload 5
    //   65: ifnull +8 -> 73
    //   68: aload 5
    //   70: invokevirtual 65	java/io/OutputStream:close	()V
    //   73: ldc_w 365
    //   76: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: iconst_0
    //   80: ireturn
    //   81: astore_1
    //   82: aload_3
    //   83: astore 4
    //   85: ldc 52
    //   87: ldc_w 367
    //   90: iconst_2
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_0
    //   97: aastore
    //   98: dup
    //   99: iconst_1
    //   100: aload_1
    //   101: invokevirtual 71	java/io/IOException:getMessage	()Ljava/lang/String;
    //   104: aastore
    //   105: invokestatic 74	com/tencent/f/a/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_3
    //   109: ifnull +7 -> 116
    //   112: aload_3
    //   113: invokevirtual 65	java/io/OutputStream:close	()V
    //   116: ldc_w 365
    //   119: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: iconst_m1
    //   123: ireturn
    //   124: astore_0
    //   125: aload 4
    //   127: ifnull +8 -> 135
    //   130: aload 4
    //   132: invokevirtual 65	java/io/OutputStream:close	()V
    //   135: ldc_w 365
    //   138: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_0
    //   142: athrow
    //   143: astore_0
    //   144: goto -71 -> 73
    //   147: astore_0
    //   148: goto -32 -> 116
    //   151: astore_1
    //   152: goto -17 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramString	String
    //   0	155	1	paramArrayOfByte	byte[]
    //   0	155	2	paramInt	int
    //   40	73	3	localObject1	Object
    //   37	94	4	localObject2	Object
    //   46	23	5	localOutputStream	OutputStream
    // Exception table:
    //   from	to	target	type
    //   41	48	81	java/io/IOException
    //   55	63	81	java/io/IOException
    //   41	48	124	finally
    //   55	63	124	finally
    //   85	108	124	finally
    //   68	73	143	java/io/IOException
    //   112	116	147	java/io/IOException
    //   130	135	151	java/io/IOException
  }
  
  public static InputStream b(Uri paramUri, FileSystemManager.d paramd)
  {
    AppMethodBeat.i(54627);
    paramd = FileSystemManager.dQE().a(paramUri, paramd);
    if (!paramd.valid())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(54627);
      throw paramUri;
    }
    try
    {
      paramUri = paramd.AQb.openRead(paramd.path);
      AppMethodBeat.o(54627);
      return paramUri;
    }
    catch (IOException paramUri)
    {
      paramUri = (FileNotFoundException)new FileNotFoundException(paramUri.getMessage()).initCause(paramUri);
      AppMethodBeat.o(54627);
      throw paramUri;
    }
  }
  
  public static boolean cN(String paramString)
  {
    AppMethodBeat.i(54646);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(54646);
      return false;
    }
    paramString = j.parseUri(paramString);
    paramString = FileSystemManager.dQE().a(paramString, null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(54646);
      return false;
    }
    boolean bool = paramString.AQb.exists(paramString.path);
    AppMethodBeat.o(54646);
    return bool;
  }
  
  public static boolean cO(String paramString)
  {
    AppMethodBeat.i(156751);
    boolean bool = O(paramString, true);
    AppMethodBeat.o(156751);
    return bool;
  }
  
  public static String cP(String paramString)
  {
    AppMethodBeat.i(54657);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(54657);
      return "";
    }
    paramString = new b(paramString).getName();
    int i = paramString.lastIndexOf('.');
    if ((i <= 0) || (i == paramString.length() - 1))
    {
      AppMethodBeat.o(54657);
      return "";
    }
    paramString = paramString.substring(i + 1);
    AppMethodBeat.o(54657);
    return paramString;
  }
  
  /* Error */
  public static String cS(String paramString)
  {
    // Byte code:
    //   0: ldc_w 381
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 221	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: new 383	java/io/InputStreamReader
    //   18: dup
    //   19: aload_0
    //   20: invokestatic 34	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   23: invokespecial 386	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   26: astore_3
    //   27: aload_3
    //   28: astore_2
    //   29: sipush 512
    //   32: newarray char
    //   34: astore 5
    //   36: aload_3
    //   37: astore_2
    //   38: aload_3
    //   39: aload 5
    //   41: invokevirtual 389	java/io/InputStreamReader:read	([C)I
    //   44: istore_1
    //   45: iload_1
    //   46: iconst_m1
    //   47: if_icmpeq +76 -> 123
    //   50: aload_3
    //   51: astore_2
    //   52: aload 4
    //   54: aload 5
    //   56: iconst_0
    //   57: iload_1
    //   58: invokevirtual 392	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -26 -> 36
    //   65: astore 4
    //   67: aload_3
    //   68: astore_2
    //   69: ldc 52
    //   71: ldc_w 394
    //   74: iconst_2
    //   75: anewarray 4	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: aload_0
    //   81: aastore
    //   82: dup
    //   83: iconst_1
    //   84: aload 4
    //   86: invokevirtual 71	java/io/IOException:getMessage	()Ljava/lang/String;
    //   89: aastore
    //   90: invokestatic 74	com/tencent/f/a/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aload_3
    //   94: astore_2
    //   95: ldc_w 381
    //   98: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_3
    //   102: astore_2
    //   103: aload 4
    //   105: athrow
    //   106: astore_0
    //   107: aload_2
    //   108: ifnull +7 -> 115
    //   111: aload_2
    //   112: invokevirtual 395	java/io/InputStreamReader:close	()V
    //   115: ldc_w 381
    //   118: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_0
    //   122: athrow
    //   123: aload_3
    //   124: invokevirtual 395	java/io/InputStreamReader:close	()V
    //   127: aload 4
    //   129: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore_0
    //   133: ldc_w 381
    //   136: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_0
    //   140: areturn
    //   141: astore_0
    //   142: goto -15 -> 127
    //   145: astore_2
    //   146: goto -31 -> 115
    //   149: astore_0
    //   150: aconst_null
    //   151: astore_2
    //   152: goto -45 -> 107
    //   155: astore 4
    //   157: aconst_null
    //   158: astore_3
    //   159: goto -92 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramString	String
    //   44	14	1	i	int
    //   28	84	2	localInputStreamReader1	java.io.InputStreamReader
    //   145	1	2	localIOException1	IOException
    //   151	1	2	localObject	Object
    //   26	133	3	localInputStreamReader2	java.io.InputStreamReader
    //   13	40	4	localStringBuilder	StringBuilder
    //   65	63	4	localIOException2	IOException
    //   155	1	4	localIOException3	IOException
    //   34	21	5	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   29	36	65	java/io/IOException
    //   38	45	65	java/io/IOException
    //   52	62	65	java/io/IOException
    //   29	36	106	finally
    //   38	45	106	finally
    //   52	62	106	finally
    //   69	93	106	finally
    //   95	101	106	finally
    //   103	106	106	finally
    //   123	127	141	java/io/IOException
    //   111	115	145	java/io/IOException
    //   15	27	149	finally
    //   15	27	155	java/io/IOException
  }
  
  public static RandomAccessFile cr(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54633);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = new FileNotFoundException("path is empty");
      AppMethodBeat.o(54633);
      throw paramString;
    }
    paramString = a(j.parseUri(paramString), paramBoolean);
    AppMethodBeat.o(54633);
    return paramString;
  }
  
  public static List<FileSystem.a> cs(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54650);
    paramString = j.parseUri(paramString);
    paramString = FileSystemManager.dQE().a(paramString, null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(54650);
      return null;
    }
    paramString = paramString.AQb.N(paramString.path, paramBoolean);
    AppMethodBeat.o(54650);
    return paramString;
  }
  
  public static boolean deleteFile(String paramString)
  {
    AppMethodBeat.i(54647);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(54647);
      return false;
    }
    boolean bool = new b(paramString).delete();
    AppMethodBeat.o(54647);
    return bool;
  }
  
  public static boolean h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(54648);
    boolean bool = aT(paramString1 + paramString2, paramString1 + paramString3);
    AppMethodBeat.o(54648);
    return bool;
  }
  
  /* Error */
  public static byte[] i(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 415
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 415
    //   13: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: iload_2
    //   19: iflt +10 -> 29
    //   22: iload_2
    //   23: ldc_w 416
    //   26: if_icmple +292 -> 318
    //   29: sipush 4096
    //   32: istore_3
    //   33: new 418	java/io/ByteArrayOutputStream
    //   36: dup
    //   37: iload_3
    //   38: invokespecial 419	java/io/ByteArrayOutputStream:<init>	(I)V
    //   41: astore 8
    //   43: aload_0
    //   44: invokestatic 34	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   47: astore 7
    //   49: iload_1
    //   50: i2l
    //   51: lstore 4
    //   53: lload 4
    //   55: lconst_0
    //   56: lcmp
    //   57: ifle +22 -> 79
    //   60: aload 7
    //   62: astore 6
    //   64: lload 4
    //   66: aload 7
    //   68: lload 4
    //   70: invokevirtual 423	java/io/InputStream:skip	(J)J
    //   73: lsub
    //   74: lstore 4
    //   76: goto -23 -> 53
    //   79: aload 7
    //   81: astore 6
    //   83: sipush 1024
    //   86: newarray byte
    //   88: astore 9
    //   90: iload_2
    //   91: istore_1
    //   92: iload_2
    //   93: ifge +7 -> 100
    //   96: ldc_w 424
    //   99: istore_1
    //   100: aload 7
    //   102: astore 6
    //   104: aload 7
    //   106: aload 9
    //   108: iconst_0
    //   109: iload_1
    //   110: sipush 1024
    //   113: invokestatic 430	java/lang/Math:min	(II)I
    //   116: invokevirtual 433	java/io/InputStream:read	([BII)I
    //   119: istore_2
    //   120: iload_2
    //   121: iconst_m1
    //   122: if_icmpeq +27 -> 149
    //   125: iload_1
    //   126: ifle +23 -> 149
    //   129: aload 7
    //   131: astore 6
    //   133: aload 8
    //   135: aload 9
    //   137: iconst_0
    //   138: iload_2
    //   139: invokevirtual 434	java/io/ByteArrayOutputStream:write	([BII)V
    //   142: iload_1
    //   143: iload_2
    //   144: isub
    //   145: istore_1
    //   146: goto -46 -> 100
    //   149: aload 7
    //   151: ifnull +8 -> 159
    //   154: aload 7
    //   156: invokevirtual 64	java/io/InputStream:close	()V
    //   159: aload 8
    //   161: invokevirtual 437	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   164: astore 6
    //   166: aload 8
    //   168: invokevirtual 438	java/io/ByteArrayOutputStream:close	()V
    //   171: ldc 52
    //   173: ldc_w 440
    //   176: iconst_2
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload_0
    //   183: aastore
    //   184: dup
    //   185: iconst_1
    //   186: aload 6
    //   188: arraylength
    //   189: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   192: aastore
    //   193: invokestatic 60	com/tencent/f/a/b:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: ldc_w 415
    //   199: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload 6
    //   204: areturn
    //   205: astore 8
    //   207: aconst_null
    //   208: astore 7
    //   210: aload 7
    //   212: astore 6
    //   214: ldc 52
    //   216: new 221	java/lang/StringBuilder
    //   219: dup
    //   220: ldc_w 442
    //   223: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: aload_0
    //   227: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc_w 444
    //   233: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload 8
    //   238: invokevirtual 71	java/io/IOException:getMessage	()Ljava/lang/String;
    //   241: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 446	com/tencent/f/a/b:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload 7
    //   252: ifnull +8 -> 260
    //   255: aload 7
    //   257: invokevirtual 64	java/io/InputStream:close	()V
    //   260: ldc_w 415
    //   263: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aconst_null
    //   267: areturn
    //   268: astore_0
    //   269: aconst_null
    //   270: astore 6
    //   272: aload 6
    //   274: ifnull +8 -> 282
    //   277: aload 6
    //   279: invokevirtual 64	java/io/InputStream:close	()V
    //   282: ldc_w 415
    //   285: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   288: aload_0
    //   289: athrow
    //   290: astore 6
    //   292: goto -133 -> 159
    //   295: astore_0
    //   296: goto -36 -> 260
    //   299: astore 6
    //   301: goto -19 -> 282
    //   304: astore 7
    //   306: goto -135 -> 171
    //   309: astore_0
    //   310: goto -38 -> 272
    //   313: astore 8
    //   315: goto -105 -> 210
    //   318: iload_2
    //   319: istore_3
    //   320: goto -287 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	paramString	String
    //   0	323	1	paramInt1	int
    //   0	323	2	paramInt2	int
    //   32	288	3	i	int
    //   51	24	4	l	long
    //   62	216	6	localObject	Object
    //   290	1	6	localIOException1	IOException
    //   299	1	6	localIOException2	IOException
    //   47	209	7	localInputStream	InputStream
    //   304	1	7	localIOException3	IOException
    //   41	126	8	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   205	32	8	localIOException4	IOException
    //   313	1	8	localIOException5	IOException
    //   88	48	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   43	49	205	java/io/IOException
    //   43	49	268	finally
    //   154	159	290	java/io/IOException
    //   255	260	295	java/io/IOException
    //   277	282	299	java/io/IOException
    //   166	171	304	java/io/IOException
    //   64	76	309	finally
    //   83	90	309	finally
    //   104	120	309	finally
    //   133	142	309	finally
    //   214	250	309	finally
    //   64	76	313	java/io/IOException
    //   83	90	313	java/io/IOException
    //   104	120	313	java/io/IOException
    //   133	142	313	java/io/IOException
  }
  
  public static boolean iF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(54651);
    paramString1 = j.parseUri(paramString1);
    paramString1 = FileSystemManager.dQE().a(paramString1, null);
    paramString2 = j.parseUri(paramString2);
    boolean bool = a(paramString1, FileSystemManager.dQE().a(paramString2, null));
    AppMethodBeat.o(54651);
    return bool;
  }
  
  public static boolean iG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(54653);
    Object localObject1 = j.parseUri(paramString1);
    localObject1 = FileSystemManager.dQE().a((Uri)localObject1, null);
    Object localObject2 = j.parseUri(paramString2);
    localObject2 = FileSystemManager.dQE().a((Uri)localObject2, null);
    if ((((FileSystemManager.d)localObject1).valid()) && (((FileSystemManager.d)localObject1).AQb == ((FileSystemManager.d)localObject2).AQb) && ((((FileSystemManager.d)localObject1).AQb.ajj() & 0x20) != 0) && (((FileSystemManager.d)localObject1).AQb.aV(paramString1, paramString2)))
    {
      AppMethodBeat.o(54653);
      return true;
    }
    if ((a((FileSystemManager.d)localObject1, (FileSystemManager.d)localObject2)) && (O(paramString1, false)))
    {
      AppMethodBeat.o(54653);
      return true;
    }
    AppMethodBeat.o(54653);
    return false;
  }
  
  /* Error */
  public static int iH(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 458
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 460	java/util/zip/ZipInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokestatic 34	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: invokespecial 461	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_3
    //   18: aload_3
    //   19: astore_0
    //   20: aload_3
    //   21: invokevirtual 465	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   24: astore 4
    //   26: aload 4
    //   28: ifnull +266 -> 294
    //   31: aload_3
    //   32: astore_0
    //   33: aload 4
    //   35: invokevirtual 468	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   38: astore 5
    //   40: aload_3
    //   41: astore_0
    //   42: aload 5
    //   44: ldc_w 470
    //   47: invokevirtual 474	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   50: ifne -32 -> 18
    //   53: aload_3
    //   54: astore_0
    //   55: aload 5
    //   57: ldc_w 476
    //   60: invokevirtual 474	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   63: ifne -45 -> 18
    //   66: aload_3
    //   67: astore_0
    //   68: aload 4
    //   70: invokevirtual 479	java/util/zip/ZipEntry:isDirectory	()Z
    //   73: ifeq +87 -> 160
    //   76: aload_3
    //   77: astore_0
    //   78: aload 5
    //   80: iconst_0
    //   81: aload 5
    //   83: invokevirtual 21	java/lang/String:length	()I
    //   86: iconst_1
    //   87: isub
    //   88: invokevirtual 247	java/lang/String:substring	(II)Ljava/lang/String;
    //   91: astore 4
    //   93: aload_3
    //   94: astore_0
    //   95: new 264	com/tencent/mm/vfs/b
    //   98: dup
    //   99: new 221	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   106: aload_1
    //   107: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 216
    //   112: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 4
    //   117: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokespecial 265	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   126: invokevirtual 482	com/tencent/mm/vfs/b:mkdirs	()Z
    //   129: pop
    //   130: goto -112 -> 18
    //   133: astore_1
    //   134: aload_3
    //   135: astore_0
    //   136: ldc 52
    //   138: aload_1
    //   139: ldc 133
    //   141: invokestatic 137	com/tencent/f/a/b:c	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   144: aload_3
    //   145: ifnull +7 -> 152
    //   148: aload_3
    //   149: invokevirtual 483	java/util/zip/ZipInputStream:close	()V
    //   152: ldc_w 458
    //   155: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: iconst_m1
    //   159: ireturn
    //   160: aload_3
    //   161: astore_0
    //   162: new 264	com/tencent/mm/vfs/b
    //   165: dup
    //   166: new 221	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   173: aload_1
    //   174: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc 216
    //   179: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload 5
    //   184: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokespecial 265	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   193: invokestatic 487	com/tencent/mm/vfs/e:r	(Lcom/tencent/mm/vfs/b;)Ljava/io/OutputStream;
    //   196: astore 4
    //   198: aload_3
    //   199: astore_0
    //   200: sipush 1024
    //   203: newarray byte
    //   205: astore 5
    //   207: aload_3
    //   208: astore_0
    //   209: aload_3
    //   210: aload 5
    //   212: invokevirtual 488	java/util/zip/ZipInputStream:read	([B)I
    //   215: istore_2
    //   216: iload_2
    //   217: iconst_m1
    //   218: if_icmpeq +45 -> 263
    //   221: aload_3
    //   222: astore_0
    //   223: aload 4
    //   225: aload 5
    //   227: iconst_0
    //   228: iload_2
    //   229: invokevirtual 50	java/io/OutputStream:write	([BII)V
    //   232: goto -25 -> 207
    //   235: astore_1
    //   236: aload_3
    //   237: astore_0
    //   238: ldc 52
    //   240: aload_1
    //   241: ldc 133
    //   243: invokestatic 137	com/tencent/f/a/b:c	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   246: aload_3
    //   247: ifnull +7 -> 254
    //   250: aload_3
    //   251: invokevirtual 483	java/util/zip/ZipInputStream:close	()V
    //   254: ldc_w 458
    //   257: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: bipush 254
    //   262: ireturn
    //   263: aload_3
    //   264: astore_0
    //   265: aload 4
    //   267: invokevirtual 65	java/io/OutputStream:close	()V
    //   270: goto -252 -> 18
    //   273: astore_3
    //   274: aload_0
    //   275: astore_1
    //   276: aload_3
    //   277: astore_0
    //   278: aload_1
    //   279: ifnull +7 -> 286
    //   282: aload_1
    //   283: invokevirtual 483	java/util/zip/ZipInputStream:close	()V
    //   286: ldc_w 458
    //   289: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aload_0
    //   293: athrow
    //   294: aload_3
    //   295: invokevirtual 483	java/util/zip/ZipInputStream:close	()V
    //   298: ldc_w 458
    //   301: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: iconst_0
    //   305: ireturn
    //   306: astore_0
    //   307: ldc 52
    //   309: ldc_w 490
    //   312: invokestatic 259	com/tencent/f/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: goto -17 -> 298
    //   318: astore_0
    //   319: ldc 52
    //   321: ldc_w 490
    //   324: invokestatic 259	com/tencent/f/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: goto -175 -> 152
    //   330: astore_0
    //   331: ldc 52
    //   333: ldc_w 490
    //   336: invokestatic 259	com/tencent/f/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: goto -85 -> 254
    //   342: astore_1
    //   343: ldc 52
    //   345: ldc_w 490
    //   348: invokestatic 259	com/tencent/f/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: goto -65 -> 286
    //   354: astore_0
    //   355: aconst_null
    //   356: astore_1
    //   357: goto -79 -> 278
    //   360: astore_1
    //   361: aconst_null
    //   362: astore_3
    //   363: goto -127 -> 236
    //   366: astore_1
    //   367: aconst_null
    //   368: astore_3
    //   369: goto -235 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	paramString1	String
    //   0	372	1	paramString2	String
    //   215	14	2	i	int
    //   17	247	3	localZipInputStream	java.util.zip.ZipInputStream
    //   273	22	3	localObject1	Object
    //   362	7	3	localObject2	Object
    //   24	242	4	localObject3	Object
    //   38	188	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   20	26	133	java/io/FileNotFoundException
    //   33	40	133	java/io/FileNotFoundException
    //   42	53	133	java/io/FileNotFoundException
    //   55	66	133	java/io/FileNotFoundException
    //   68	76	133	java/io/FileNotFoundException
    //   78	93	133	java/io/FileNotFoundException
    //   95	130	133	java/io/FileNotFoundException
    //   162	198	133	java/io/FileNotFoundException
    //   200	207	133	java/io/FileNotFoundException
    //   209	216	133	java/io/FileNotFoundException
    //   223	232	133	java/io/FileNotFoundException
    //   265	270	133	java/io/FileNotFoundException
    //   20	26	235	java/io/IOException
    //   33	40	235	java/io/IOException
    //   42	53	235	java/io/IOException
    //   55	66	235	java/io/IOException
    //   68	76	235	java/io/IOException
    //   78	93	235	java/io/IOException
    //   95	130	235	java/io/IOException
    //   162	198	235	java/io/IOException
    //   200	207	235	java/io/IOException
    //   209	216	235	java/io/IOException
    //   223	232	235	java/io/IOException
    //   265	270	235	java/io/IOException
    //   20	26	273	finally
    //   33	40	273	finally
    //   42	53	273	finally
    //   55	66	273	finally
    //   68	76	273	finally
    //   78	93	273	finally
    //   95	130	273	finally
    //   136	144	273	finally
    //   162	198	273	finally
    //   200	207	273	finally
    //   209	216	273	finally
    //   223	232	273	finally
    //   238	246	273	finally
    //   265	270	273	finally
    //   294	298	306	java/io/IOException
    //   148	152	318	java/io/IOException
    //   250	254	330	java/io/IOException
    //   282	286	342	java/io/IOException
    //   6	18	354	finally
    //   6	18	360	java/io/IOException
    //   6	18	366	java/io/FileNotFoundException
  }
  
  /* Error */
  public static boolean n(List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: ldc_w 493
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: invokevirtual 80	java/lang/String:isEmpty	()Z
    //   14: ifeq +11 -> 25
    //   17: ldc_w 493
    //   20: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_1
    //   26: invokestatic 495	com/tencent/mm/vfs/e:avK	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokestatic 496	com/tencent/mm/vfs/e:um	(Ljava/lang/String;)Z
    //   32: pop
    //   33: sipush 4096
    //   36: newarray byte
    //   38: astore 5
    //   40: new 498	java/util/zip/ZipOutputStream
    //   43: dup
    //   44: aload_1
    //   45: iconst_0
    //   46: invokestatic 38	com/tencent/mm/vfs/e:M	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   49: invokespecial 501	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   52: astore_1
    //   53: aload_0
    //   54: invokeinterface 203 1 0
    //   59: astore 6
    //   61: aload 6
    //   63: invokeinterface 208 1 0
    //   68: ifeq +311 -> 379
    //   71: aload 6
    //   73: invokeinterface 212 1 0
    //   78: checkcast 17	java/lang/String
    //   81: invokestatic 94	com/tencent/mm/vfs/j:parseUri	(Ljava/lang/String;)Landroid/net/Uri;
    //   84: astore_0
    //   85: invokestatic 107	com/tencent/mm/vfs/FileSystemManager:dQE	()Lcom/tencent/mm/vfs/FileSystemManager;
    //   88: aload_0
    //   89: aconst_null
    //   90: invokevirtual 110	com/tencent/mm/vfs/FileSystemManager:a	(Landroid/net/Uri;Lcom/tencent/mm/vfs/FileSystemManager$d;)Lcom/tencent/mm/vfs/FileSystemManager$d;
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 115	com/tencent/mm/vfs/FileSystemManager$d:valid	()Z
    //   98: ifeq -37 -> 61
    //   101: aload_0
    //   102: getfield 119	com/tencent/mm/vfs/FileSystemManager$d:AQb	Lcom/tencent/mm/vfs/FileSystem;
    //   105: aload_0
    //   106: getfield 123	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   109: invokeinterface 295 2 0
    //   114: astore 4
    //   116: aload 4
    //   118: ifnull -57 -> 61
    //   121: aload 4
    //   123: getfield 240	com/tencent/mm/vfs/FileSystem$a:APu	Z
    //   126: ifeq +196 -> 322
    //   129: aload_0
    //   130: getfield 123	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   133: invokevirtual 21	java/lang/String:length	()I
    //   136: istore_3
    //   137: aload_0
    //   138: getfield 123	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   141: ldc 216
    //   143: invokevirtual 219	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   146: ifeq +171 -> 317
    //   149: iconst_0
    //   150: istore_2
    //   151: aload_0
    //   152: getfield 119	com/tencent/mm/vfs/FileSystemManager$d:AQb	Lcom/tencent/mm/vfs/FileSystem;
    //   155: aload_0
    //   156: getfield 123	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   159: iconst_1
    //   160: invokeinterface 186 3 0
    //   165: astore_0
    //   166: aload_0
    //   167: ifnull -106 -> 61
    //   170: iload_2
    //   171: iload_3
    //   172: iadd
    //   173: istore_2
    //   174: aload_0
    //   175: invokeinterface 203 1 0
    //   180: astore 7
    //   182: aload 7
    //   184: invokeinterface 208 1 0
    //   189: ifeq -128 -> 61
    //   192: aload 7
    //   194: invokeinterface 212 1 0
    //   199: checkcast 214	com/tencent/mm/vfs/FileSystem$a
    //   202: astore 4
    //   204: aload 4
    //   206: getfield 240	com/tencent/mm/vfs/FileSystem$a:APu	Z
    //   209: ifne -27 -> 182
    //   212: aload 4
    //   214: getfield 229	com/tencent/mm/vfs/FileSystem$a:APr	Ljava/lang/String;
    //   217: invokevirtual 21	java/lang/String:length	()I
    //   220: iload_2
    //   221: if_icmpge +124 -> 345
    //   224: aload 4
    //   226: getfield 504	com/tencent/mm/vfs/FileSystem$a:name	Ljava/lang/String;
    //   229: astore_0
    //   230: aload 4
    //   232: invokevirtual 251	com/tencent/mm/vfs/FileSystem$a:dQA	()Ljava/io/InputStream;
    //   235: astore 4
    //   237: aload_1
    //   238: new 467	java/util/zip/ZipEntry
    //   241: dup
    //   242: aload_0
    //   243: invokespecial 505	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   246: invokevirtual 509	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   249: aload 4
    //   251: aload 5
    //   253: invokevirtual 44	java/io/InputStream:read	([B)I
    //   256: istore_3
    //   257: iload_3
    //   258: iflt +100 -> 358
    //   261: aload_1
    //   262: aload 5
    //   264: iconst_0
    //   265: iload_3
    //   266: invokevirtual 510	java/util/zip/ZipOutputStream:write	([BII)V
    //   269: goto -20 -> 249
    //   272: astore 5
    //   274: aload_1
    //   275: astore_0
    //   276: aload 4
    //   278: astore_1
    //   279: aload 5
    //   281: astore 4
    //   283: ldc 52
    //   285: aload 4
    //   287: ldc_w 512
    //   290: invokestatic 137	com/tencent/f/a/b:c	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   293: aload_1
    //   294: ifnull +7 -> 301
    //   297: aload_1
    //   298: invokevirtual 64	java/io/InputStream:close	()V
    //   301: aload_0
    //   302: ifnull +7 -> 309
    //   305: aload_0
    //   306: invokevirtual 513	java/util/zip/ZipOutputStream:close	()V
    //   309: ldc_w 493
    //   312: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: iconst_0
    //   316: ireturn
    //   317: iconst_1
    //   318: istore_2
    //   319: goto -168 -> 151
    //   322: aload_0
    //   323: getfield 123	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   326: bipush 47
    //   328: invokevirtual 244	java/lang/String:lastIndexOf	(I)I
    //   331: istore_2
    //   332: aload 4
    //   334: invokestatic 519	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   337: astore_0
    //   338: iload_2
    //   339: iconst_1
    //   340: iadd
    //   341: istore_2
    //   342: goto -168 -> 174
    //   345: aload 4
    //   347: getfield 229	com/tencent/mm/vfs/FileSystem$a:APr	Ljava/lang/String;
    //   350: iload_2
    //   351: invokevirtual 233	java/lang/String:substring	(I)Ljava/lang/String;
    //   354: astore_0
    //   355: goto -125 -> 230
    //   358: aload 4
    //   360: invokevirtual 64	java/io/InputStream:close	()V
    //   363: aload_1
    //   364: invokevirtual 522	java/util/zip/ZipOutputStream:closeEntry	()V
    //   367: goto -185 -> 182
    //   370: astore 4
    //   372: aload_1
    //   373: astore_0
    //   374: aconst_null
    //   375: astore_1
    //   376: goto -93 -> 283
    //   379: aload_1
    //   380: invokevirtual 513	java/util/zip/ZipOutputStream:close	()V
    //   383: ldc_w 493
    //   386: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   389: iconst_1
    //   390: ireturn
    //   391: astore_0
    //   392: aconst_null
    //   393: astore 5
    //   395: aconst_null
    //   396: astore_1
    //   397: aload_1
    //   398: ifnull +7 -> 405
    //   401: aload_1
    //   402: invokevirtual 64	java/io/InputStream:close	()V
    //   405: aload 5
    //   407: ifnull +8 -> 415
    //   410: aload 5
    //   412: invokevirtual 513	java/util/zip/ZipOutputStream:close	()V
    //   415: ldc_w 493
    //   418: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   421: aload_0
    //   422: athrow
    //   423: astore_0
    //   424: goto -41 -> 383
    //   427: astore_1
    //   428: goto -127 -> 301
    //   431: astore_0
    //   432: goto -123 -> 309
    //   435: astore_1
    //   436: goto -31 -> 405
    //   439: astore_1
    //   440: goto -25 -> 415
    //   443: astore_0
    //   444: aconst_null
    //   445: astore 4
    //   447: aload_1
    //   448: astore 5
    //   450: aload 4
    //   452: astore_1
    //   453: goto -56 -> 397
    //   456: astore_0
    //   457: aload_1
    //   458: astore 5
    //   460: aload 4
    //   462: astore_1
    //   463: goto -66 -> 397
    //   466: astore 4
    //   468: aload_0
    //   469: astore 5
    //   471: aload 4
    //   473: astore_0
    //   474: goto -77 -> 397
    //   477: astore 4
    //   479: aconst_null
    //   480: astore_0
    //   481: aconst_null
    //   482: astore_1
    //   483: goto -200 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	486	0	paramList	List<String>
    //   0	486	1	paramString	String
    //   150	201	2	i	int
    //   136	130	3	j	int
    //   114	245	4	localObject1	Object
    //   370	1	4	localIOException1	IOException
    //   445	16	4	localObject2	Object
    //   466	6	4	localObject3	Object
    //   477	1	4	localIOException2	IOException
    //   38	225	5	arrayOfByte	byte[]
    //   272	8	5	localIOException3	IOException
    //   393	77	5	localObject4	Object
    //   59	13	6	localIterator1	java.util.Iterator
    //   180	13	7	localIterator2	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   237	249	272	java/io/IOException
    //   249	257	272	java/io/IOException
    //   261	269	272	java/io/IOException
    //   358	363	272	java/io/IOException
    //   53	61	370	java/io/IOException
    //   61	116	370	java/io/IOException
    //   121	149	370	java/io/IOException
    //   151	166	370	java/io/IOException
    //   174	182	370	java/io/IOException
    //   182	230	370	java/io/IOException
    //   230	237	370	java/io/IOException
    //   322	338	370	java/io/IOException
    //   345	355	370	java/io/IOException
    //   363	367	370	java/io/IOException
    //   40	53	391	finally
    //   379	383	423	java/io/IOException
    //   297	301	427	java/io/IOException
    //   305	309	431	java/io/IOException
    //   401	405	435	java/io/IOException
    //   410	415	439	java/io/IOException
    //   53	61	443	finally
    //   61	116	443	finally
    //   121	149	443	finally
    //   151	166	443	finally
    //   174	182	443	finally
    //   182	230	443	finally
    //   230	237	443	finally
    //   322	338	443	finally
    //   345	355	443	finally
    //   363	367	443	finally
    //   237	249	456	finally
    //   249	257	456	finally
    //   261	269	456	finally
    //   358	363	456	finally
    //   283	293	466	finally
    //   40	53	477	java/io/IOException
  }
  
  public static InputStream openRead(String paramString)
  {
    AppMethodBeat.i(54625);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = new FileNotFoundException("path is empty");
      AppMethodBeat.o(54625);
      throw paramString;
    }
    paramString = b(j.parseUri(paramString), null);
    AppMethodBeat.o(54625);
    return paramString;
  }
  
  public static int q(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(156750);
    int i = b(paramString, paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(156750);
    return i;
  }
  
  public static InputStream q(b paramb)
  {
    AppMethodBeat.i(54626);
    paramb = b(paramb.mUri, paramb.dQG());
    AppMethodBeat.o(54626);
    return paramb;
  }
  
  public static OutputStream qC(String paramString)
  {
    AppMethodBeat.i(156749);
    paramString = M(paramString, false);
    AppMethodBeat.o(156749);
    return paramString;
  }
  
  public static OutputStream r(b paramb)
  {
    AppMethodBeat.i(54629);
    paramb = a(paramb.mUri, paramb.dQG(), false);
    AppMethodBeat.o(54629);
    return paramb;
  }
  
  public static OutputStream s(b paramb)
  {
    AppMethodBeat.i(54631);
    paramb = a(paramb.mUri, paramb.dQG(), false);
    AppMethodBeat.o(54631);
    return paramb;
  }
  
  public static boolean um(String paramString)
  {
    AppMethodBeat.i(54644);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(54644);
      return false;
    }
    paramString = new b(paramString);
    if ((paramString.mkdirs()) || (paramString.isDirectory()))
    {
      AppMethodBeat.o(54644);
      return true;
    }
    AppMethodBeat.o(54644);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.e
 * JD-Core Version:    0.7.0.1
 */