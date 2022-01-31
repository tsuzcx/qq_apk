package com.tencent.mm.vfs;

import android.net.Uri;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.List;

public final class e
{
  public static OutputStream I(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      throw new FileNotFoundException("path is empty");
    }
    return a(j.aeZ(paramString), null, paramBoolean);
  }
  
  public static boolean K(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return false;
      paramString = j.aeZ(paramString);
      paramString = FileSystemManager.cVw().a(paramString, null);
    } while (!paramString.valid());
    return paramString.wva.K(paramString.path, paramBoolean);
  }
  
  public static int a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramArrayOfByte.length < paramInt + 0)) {
      i = -2;
    }
    for (;;)
    {
      return i;
      localObject3 = null;
      Object localObject1 = null;
      try
      {
        OutputStream localOutputStream = I(paramString, true);
        localObject1 = localOutputStream;
        localObject3 = localOutputStream;
        localOutputStream.write(paramArrayOfByte, 0, paramInt);
        if (localOutputStream == null) {
          continue;
        }
        try
        {
          localOutputStream.close();
          return 0;
        }
        catch (IOException localIOException1)
        {
          com.tencent.e.a.b.c("MicroMsg.VFSFileOp", localIOException1, "");
          com.tencent.e.a.b.w("MicroMsg.VFSFileOp", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", new Object[] { localIOException1.getClass().getSimpleName(), localIOException1.getMessage(), paramString, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(0), Integer.valueOf(paramInt) });
          return 0;
        }
        try
        {
          localObject3.close();
          throw localObject2;
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            com.tencent.e.a.b.c("MicroMsg.VFSFileOp", localIOException3, "");
            com.tencent.e.a.b.w("MicroMsg.VFSFileOp", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", new Object[] { localIOException3.getClass().getSimpleName(), localIOException3.getMessage(), paramString, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(0), Integer.valueOf(paramInt) });
          }
        }
      }
      catch (Exception localException)
      {
        localObject3 = localIOException1;
        com.tencent.e.a.b.c("MicroMsg.VFSFileOp", localException, "");
        localObject3 = localIOException1;
        com.tencent.e.a.b.w("MicroMsg.VFSFileOp", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", new Object[] { localException.getClass().getSimpleName(), localException.getMessage(), paramString, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(0), Integer.valueOf(paramInt) });
        if (localIOException1 != null) {}
        try
        {
          localIOException1.close();
          return -1;
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            com.tencent.e.a.b.c("MicroMsg.VFSFileOp", localIOException2, "");
            com.tencent.e.a.b.w("MicroMsg.VFSFileOp", "file op appendToFile close e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", new Object[] { localIOException2.getClass().getSimpleName(), localIOException2.getMessage(), paramString, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(0), Integer.valueOf(paramInt) });
          }
        }
      }
      finally
      {
        if (localObject3 == null) {}
      }
    }
  }
  
  static OutputStream a(Uri paramUri, FileSystemManager.d paramd, boolean paramBoolean)
  {
    paramd = FileSystemManager.cVw().a(paramUri, paramd);
    if (!paramd.valid()) {
      throw new FileNotFoundException("Cannot resolve path or URI: " + paramUri);
    }
    try
    {
      paramUri = paramd.wva.I(paramd.path, paramBoolean);
      return paramUri;
    }
    catch (IOException paramUri)
    {
      throw ((FileNotFoundException)new FileNotFoundException(paramUri.getMessage()).initCause(paramUri));
    }
  }
  
  /* Error */
  private static boolean a(FileSystemManager.d paramd1, FileSystemManager.d paramd2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 51	com/tencent/mm/vfs/FileSystemManager$d:valid	()Z
    //   4: ifeq +10 -> 14
    //   7: aload_1
    //   8: invokevirtual 51	com/tencent/mm/vfs/FileSystemManager$d:valid	()Z
    //   11: ifne +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 55	com/tencent/mm/vfs/FileSystemManager$d:wva	Lcom/tencent/mm/vfs/FileSystem;
    //   20: aload_0
    //   21: getfield 59	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   24: iconst_1
    //   25: invokeinterface 140 3 0
    //   30: astore 4
    //   32: aload 4
    //   34: ifnonnull +5 -> 39
    //   37: iconst_0
    //   38: ireturn
    //   39: new 142	java/util/HashSet
    //   42: dup
    //   43: invokespecial 144	java/util/HashSet:<init>	()V
    //   46: astore 7
    //   48: aload_1
    //   49: getfield 55	com/tencent/mm/vfs/FileSystemManager$d:wva	Lcom/tencent/mm/vfs/FileSystem;
    //   52: aload_1
    //   53: getfield 59	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   56: invokeinterface 148 2 0
    //   61: pop
    //   62: aload 7
    //   64: aload_1
    //   65: getfield 59	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   68: invokevirtual 152	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   71: pop
    //   72: aload 4
    //   74: invokeinterface 158 1 0
    //   79: astore 8
    //   81: aload 8
    //   83: invokeinterface 163 1 0
    //   88: ifeq +315 -> 403
    //   91: aload 8
    //   93: invokeinterface 167 1 0
    //   98: checkcast 169	com/tencent/mm/vfs/FileSystem$a
    //   101: astore 6
    //   103: aload_0
    //   104: getfield 59	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   107: invokevirtual 37	java/lang/String:length	()I
    //   110: istore_3
    //   111: iload_3
    //   112: istore_2
    //   113: aload_0
    //   114: getfield 59	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   117: ldc 171
    //   119: invokevirtual 174	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   122: ifeq +7 -> 129
    //   125: iload_3
    //   126: iconst_1
    //   127: isub
    //   128: istore_2
    //   129: new 120	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   136: aload_1
    //   137: getfield 59	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   140: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload 6
    //   145: getfield 181	com/tencent/mm/vfs/FileSystem$a:wus	Ljava/lang/String;
    //   148: iload_2
    //   149: invokevirtual 185	java/lang/String:substring	(I)Ljava/lang/String;
    //   152: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: astore 5
    //   160: aload 6
    //   162: getfield 189	com/tencent/mm/vfs/FileSystem$a:wuv	Z
    //   165: ifeq +28 -> 193
    //   168: aload 7
    //   170: aload 5
    //   172: invokevirtual 152	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   175: ifeq -94 -> 81
    //   178: aload_1
    //   179: getfield 55	com/tencent/mm/vfs/FileSystemManager$d:wva	Lcom/tencent/mm/vfs/FileSystem;
    //   182: aload 5
    //   184: invokeinterface 148 2 0
    //   189: pop
    //   190: goto -109 -> 81
    //   193: aload 5
    //   195: bipush 47
    //   197: invokevirtual 193	java/lang/String:lastIndexOf	(I)I
    //   200: istore_2
    //   201: iload_2
    //   202: ifle +34 -> 236
    //   205: aload 5
    //   207: iconst_0
    //   208: iload_2
    //   209: invokevirtual 196	java/lang/String:substring	(II)Ljava/lang/String;
    //   212: astore 4
    //   214: aload 7
    //   216: aload 4
    //   218: invokevirtual 152	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   221: ifeq +15 -> 236
    //   224: aload_1
    //   225: getfield 55	com/tencent/mm/vfs/FileSystemManager$d:wva	Lcom/tencent/mm/vfs/FileSystem;
    //   228: aload 4
    //   230: invokeinterface 148 2 0
    //   235: pop
    //   236: aload 6
    //   238: invokevirtual 200	com/tencent/mm/vfs/FileSystem$a:cLi	()Ljava/io/InputStream;
    //   241: astore 4
    //   243: aload_1
    //   244: getfield 55	com/tencent/mm/vfs/FileSystemManager$d:wva	Lcom/tencent/mm/vfs/FileSystem;
    //   247: aload 5
    //   249: iconst_0
    //   250: invokeinterface 131 3 0
    //   255: astore 5
    //   257: sipush 4096
    //   260: newarray byte
    //   262: astore 9
    //   264: aload 4
    //   266: aload 9
    //   268: invokevirtual 206	java/io/InputStream:read	([B)I
    //   271: istore_2
    //   272: iload_2
    //   273: iflt +76 -> 349
    //   276: aload 5
    //   278: aload 9
    //   280: iconst_0
    //   281: iload_2
    //   282: invokevirtual 76	java/io/OutputStream:write	([BII)V
    //   285: goto -21 -> 264
    //   288: astore_1
    //   289: aload 5
    //   291: astore_0
    //   292: ldc 82
    //   294: new 120	java/lang/StringBuilder
    //   297: dup
    //   298: ldc 208
    //   300: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   303: aload 6
    //   305: getfield 181	com/tencent/mm/vfs/FileSystem$a:wus	Ljava/lang/String;
    //   308: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc 210
    //   313: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload_1
    //   317: invokevirtual 105	java/io/IOException:getMessage	()Ljava/lang/String;
    //   320: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 214	com/tencent/e/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   329: aload 4
    //   331: ifnull +8 -> 339
    //   334: aload 4
    //   336: invokevirtual 215	java/io/InputStream:close	()V
    //   339: aload_0
    //   340: ifnull +7 -> 347
    //   343: aload_0
    //   344: invokevirtual 80	java/io/OutputStream:close	()V
    //   347: iconst_0
    //   348: ireturn
    //   349: aload 4
    //   351: ifnull +8 -> 359
    //   354: aload 4
    //   356: invokevirtual 215	java/io/InputStream:close	()V
    //   359: aload 5
    //   361: ifnull -280 -> 81
    //   364: aload 5
    //   366: invokevirtual 80	java/io/OutputStream:close	()V
    //   369: goto -288 -> 81
    //   372: astore 4
    //   374: goto -293 -> 81
    //   377: astore_1
    //   378: aconst_null
    //   379: astore_0
    //   380: aconst_null
    //   381: astore 4
    //   383: aload 4
    //   385: ifnull +8 -> 393
    //   388: aload 4
    //   390: invokevirtual 215	java/io/InputStream:close	()V
    //   393: aload_0
    //   394: ifnull +7 -> 401
    //   397: aload_0
    //   398: invokevirtual 80	java/io/OutputStream:close	()V
    //   401: aload_1
    //   402: athrow
    //   403: iconst_1
    //   404: ireturn
    //   405: astore 4
    //   407: goto -48 -> 359
    //   410: astore_1
    //   411: goto -72 -> 339
    //   414: astore_0
    //   415: goto -68 -> 347
    //   418: astore 4
    //   420: goto -27 -> 393
    //   423: astore_0
    //   424: goto -23 -> 401
    //   427: astore_1
    //   428: aconst_null
    //   429: astore_0
    //   430: goto -47 -> 383
    //   433: astore_1
    //   434: aload 5
    //   436: astore_0
    //   437: goto -54 -> 383
    //   440: astore_1
    //   441: goto -58 -> 383
    //   444: astore_1
    //   445: aconst_null
    //   446: astore_0
    //   447: aconst_null
    //   448: astore 4
    //   450: goto -158 -> 292
    //   453: astore_1
    //   454: aconst_null
    //   455: astore_0
    //   456: goto -164 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	paramd1	FileSystemManager.d
    //   0	459	1	paramd2	FileSystemManager.d
    //   112	170	2	i	int
    //   110	18	3	j	int
    //   30	325	4	localObject1	Object
    //   372	1	4	localException1	Exception
    //   381	8	4	localObject2	Object
    //   405	1	4	localException2	Exception
    //   418	1	4	localException3	Exception
    //   448	1	4	localObject3	Object
    //   158	277	5	localObject4	Object
    //   101	203	6	locala	FileSystem.a
    //   46	169	7	localHashSet	java.util.HashSet
    //   79	13	8	localIterator	java.util.Iterator
    //   262	17	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   257	264	288	java/io/IOException
    //   264	272	288	java/io/IOException
    //   276	285	288	java/io/IOException
    //   364	369	372	java/lang/Exception
    //   236	243	377	finally
    //   354	359	405	java/lang/Exception
    //   334	339	410	java/lang/Exception
    //   343	347	414	java/lang/Exception
    //   388	393	418	java/lang/Exception
    //   397	401	423	java/lang/Exception
    //   243	257	427	finally
    //   257	264	433	finally
    //   264	272	433	finally
    //   276	285	433	finally
    //   292	329	440	finally
    //   236	243	444	java/io/IOException
    //   243	257	453	java/io/IOException
  }
  
  public static boolean aA(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((paramString1 == null) || (paramString2 == null) || (paramString1.length() == 0) || (paramString2.length() == 0)) {
      bool = false;
    }
    while (new b(paramString1).n(new b(paramString2))) {
      return bool;
    }
    if (r(paramString1, paramString2) < 0L) {
      return false;
    }
    deleteFile(paramString1);
    return true;
  }
  
  public static Uri aeP(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {}
    do
    {
      do
      {
        return null;
        paramString = FileSystemManager.cVw().a(j.aeZ(paramString), null);
      } while (!paramString.valid());
      paramString = FileSystemManager.a(paramString, false, true);
    } while (paramString == null);
    return Uri.fromFile(new File(paramString));
  }
  
  public static long aeQ(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {}
    do
    {
      do
      {
        return 0L;
        paramString = j.aeZ(paramString);
        paramString = FileSystemManager.cVw().a(paramString, null);
      } while (!paramString.valid());
      paramString = paramString.wva.na(paramString.path);
    } while (paramString == null);
    return paramString.size;
  }
  
  public static long aeR(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {}
    do
    {
      do
      {
        return 0L;
        paramString = j.aeZ(paramString);
        paramString = FileSystemManager.cVw().a(paramString, null);
      } while (!paramString.valid());
      paramString = paramString.wva.na(paramString.path);
    } while (paramString == null);
    return paramString.wuu;
  }
  
  public static String aeS(String paramString)
  {
    return new b(paramString).cLs().getParent();
  }
  
  public static List<FileSystem.a> aeT(String paramString)
  {
    paramString = j.aeZ(paramString);
    paramString = FileSystemManager.cVw().a(paramString, null);
    if (!paramString.valid()) {
      return null;
    }
    return paramString.wva.J(paramString.path, false);
  }
  
  public static boolean aeU(String paramString)
  {
    boolean bool1 = false;
    try
    {
      paramString = new b(paramString);
      if (!paramString.exists())
      {
        boolean bool2 = paramString.createNewFile();
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (IOException paramString) {}
    return false;
  }
  
  public static final String aeV(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      paramString = "";
    }
    String str;
    int i;
    do
    {
      return paramString;
      str = new b(paramString).getName();
      i = str.lastIndexOf('.');
    } while (i < 0);
    if (i == 0) {
      return "";
    }
    return str.substring(0, i);
  }
  
  public static void aeW(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {}
    do
    {
      return;
      paramString = j.aeZ(paramString);
      paramString = FileSystemManager.cVw().a(paramString, null);
    } while ((!paramString.valid()) || ((paramString.wva.Qd() & 0x4) == 0) || (paramString.wva.L(paramString.path, true) == null));
    try
    {
      paramString.wva.I(paramString.path + "/.nomedia", false).close();
      return;
    }
    catch (IOException paramString) {}
  }
  
  /* Error */
  private static byte[] aeX(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: aload_2
    //   7: areturn
    //   8: aload_0
    //   9: invokestatic 297	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore_0
    //   13: ldc_w 299
    //   16: invokestatic 305	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   19: astore_3
    //   20: sipush 2048
    //   23: newarray byte
    //   25: astore 4
    //   27: aload_0
    //   28: aload 4
    //   30: invokevirtual 206	java/io/InputStream:read	([B)I
    //   33: istore_1
    //   34: iload_1
    //   35: iflt +28 -> 63
    //   38: aload_3
    //   39: aload 4
    //   41: iconst_0
    //   42: iload_1
    //   43: invokevirtual 308	java/security/MessageDigest:update	([BII)V
    //   46: goto -19 -> 27
    //   49: astore_3
    //   50: aload_0
    //   51: ifnull -45 -> 6
    //   54: aload_0
    //   55: invokevirtual 215	java/io/InputStream:close	()V
    //   58: aconst_null
    //   59: areturn
    //   60: astore_0
    //   61: aconst_null
    //   62: areturn
    //   63: aload_3
    //   64: invokevirtual 312	java/security/MessageDigest:digest	()[B
    //   67: astore_3
    //   68: aload_3
    //   69: astore_2
    //   70: aload_0
    //   71: ifnull -65 -> 6
    //   74: aload_0
    //   75: invokevirtual 215	java/io/InputStream:close	()V
    //   78: aload_3
    //   79: areturn
    //   80: astore_0
    //   81: aload_3
    //   82: areturn
    //   83: astore_0
    //   84: aconst_null
    //   85: astore_2
    //   86: aload_2
    //   87: ifnull +7 -> 94
    //   90: aload_2
    //   91: invokevirtual 215	java/io/InputStream:close	()V
    //   94: aload_0
    //   95: athrow
    //   96: astore_2
    //   97: goto -3 -> 94
    //   100: astore_2
    //   101: aload_0
    //   102: astore_3
    //   103: aload_2
    //   104: astore_0
    //   105: aload_3
    //   106: astore_2
    //   107: goto -21 -> 86
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_0
    //   113: goto -63 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramString	String
    //   33	10	1	i	int
    //   1	90	2	localObject1	Object
    //   96	1	2	localIOException	IOException
    //   100	4	2	localObject2	Object
    //   106	1	2	localObject3	Object
    //   19	20	3	localMessageDigest	java.security.MessageDigest
    //   49	15	3	localException	Exception
    //   67	39	3	localObject4	Object
    //   25	15	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   13	27	49	java/lang/Exception
    //   27	34	49	java/lang/Exception
    //   38	46	49	java/lang/Exception
    //   63	68	49	java/lang/Exception
    //   54	58	60	java/io/IOException
    //   74	78	80	java/io/IOException
    //   8	13	83	finally
    //   90	94	96	java/io/IOException
    //   13	27	100	finally
    //   27	34	100	finally
    //   38	46	100	finally
    //   63	68	100	finally
    //   8	13	110	java/lang/Exception
  }
  
  public static String aeY(String paramString)
  {
    paramString = aeX(paramString);
    if (paramString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(32);
    int i = 0;
    while (i < paramString.length)
    {
      localStringBuilder.append(Integer.toString((paramString[i] & 0xFF) + 256, 16).substring(1));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static int b(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: ifnonnull +8 -> 11
    //   6: bipush 254
    //   8: istore_2
    //   9: iload_2
    //   10: ireturn
    //   11: aload_1
    //   12: arraylength
    //   13: iload_2
    //   14: iconst_0
    //   15: iadd
    //   16: if_icmpge +6 -> 22
    //   19: bipush 253
    //   21: ireturn
    //   22: aconst_null
    //   23: astore 5
    //   25: aconst_null
    //   26: astore 4
    //   28: aload_0
    //   29: iconst_0
    //   30: invokestatic 70	com/tencent/mm/vfs/e:I	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   33: astore 6
    //   35: aload 6
    //   37: astore 4
    //   39: aload 6
    //   41: astore 5
    //   43: aload 6
    //   45: aload_1
    //   46: iconst_0
    //   47: iload_2
    //   48: invokevirtual 76	java/io/OutputStream:write	([BII)V
    //   51: iload_3
    //   52: istore_2
    //   53: aload 6
    //   55: ifnull -46 -> 9
    //   58: aload 6
    //   60: invokevirtual 80	java/io/OutputStream:close	()V
    //   63: iconst_0
    //   64: ireturn
    //   65: astore_0
    //   66: iconst_0
    //   67: ireturn
    //   68: astore_1
    //   69: aload 4
    //   71: astore 5
    //   73: ldc 82
    //   75: ldc_w 323
    //   78: iconst_2
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload_0
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload_1
    //   89: invokevirtual 105	java/io/IOException:getMessage	()Ljava/lang/String;
    //   92: aastore
    //   93: invokestatic 325	com/tencent/e/a/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: aload 4
    //   98: ifnull +8 -> 106
    //   101: aload 4
    //   103: invokevirtual 80	java/io/OutputStream:close	()V
    //   106: iconst_m1
    //   107: ireturn
    //   108: astore_0
    //   109: aload 5
    //   111: ifnull +8 -> 119
    //   114: aload 5
    //   116: invokevirtual 80	java/io/OutputStream:close	()V
    //   119: aload_0
    //   120: athrow
    //   121: astore_0
    //   122: goto -16 -> 106
    //   125: astore_1
    //   126: goto -7 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramString	String
    //   0	129	1	paramArrayOfByte	byte[]
    //   0	129	2	paramInt	int
    //   1	51	3	i	int
    //   26	76	4	localObject1	Object
    //   23	92	5	localObject2	Object
    //   33	26	6	localOutputStream	OutputStream
    // Exception table:
    //   from	to	target	type
    //   58	63	65	java/io/IOException
    //   28	35	68	java/io/IOException
    //   43	51	68	java/io/IOException
    //   28	35	108	finally
    //   43	51	108	finally
    //   73	96	108	finally
    //   101	106	121	java/io/IOException
    //   114	119	125	java/io/IOException
  }
  
  public static InputStream b(Uri paramUri, FileSystemManager.d paramd)
  {
    paramd = FileSystemManager.cVw().a(paramUri, paramd);
    if (!paramd.valid()) {
      throw new FileNotFoundException("Cannot resolve path or URI: " + paramUri);
    }
    try
    {
      paramUri = paramd.wva.openRead(paramd.path);
      return paramUri;
    }
    catch (IOException paramUri)
    {
      throw ((FileNotFoundException)new FileNotFoundException(paramUri.getMessage()).initCause(paramUri));
    }
  }
  
  public static boolean bK(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {}
    do
    {
      return false;
      paramString = j.aeZ(paramString);
      paramString = FileSystemManager.cVw().a(paramString, null);
    } while (!paramString.valid());
    return paramString.wva.exists(paramString.path);
  }
  
  public static boolean bL(String paramString)
  {
    return K(paramString, true);
  }
  
  public static String bM(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    paramString = new b(paramString).getName();
    int i = paramString.lastIndexOf('.');
    if ((i <= 0) || (i == paramString.length() - 1)) {
      return "";
    }
    return paramString.substring(i + 1);
  }
  
  public static RandomAccessFile bP(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      throw new FileNotFoundException("path is empty");
    }
    paramString = j.aeZ(paramString);
    Object localObject = FileSystemManager.cVw().a(paramString, null);
    if (!((FileSystemManager.d)localObject).valid()) {
      throw new FileNotFoundException("Cannot resolve path or URI: " + paramString);
    }
    localObject = FileSystemManager.a((FileSystemManager.d)localObject, paramBoolean, false);
    if (localObject == null) {
      return null;
    }
    if (paramBoolean) {}
    for (paramString = "rw";; paramString = "r") {
      return new RandomAccessFile((String)localObject, paramString);
    }
  }
  
  /* Error */
  public static String bP(String paramString)
  {
    // Byte code:
    //   0: new 120	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: new 344	java/io/InputStreamReader
    //   12: dup
    //   13: aload_0
    //   14: invokestatic 297	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: invokespecial 347	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: astore_3
    //   21: aload_3
    //   22: astore_2
    //   23: sipush 512
    //   26: newarray char
    //   28: astore 5
    //   30: aload_3
    //   31: astore_2
    //   32: aload_3
    //   33: aload 5
    //   35: invokevirtual 350	java/io/InputStreamReader:read	([C)I
    //   38: istore_1
    //   39: iload_1
    //   40: iconst_m1
    //   41: if_icmpeq +62 -> 103
    //   44: aload_3
    //   45: astore_2
    //   46: aload 4
    //   48: aload 5
    //   50: iconst_0
    //   51: iload_1
    //   52: invokevirtual 353	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: goto -26 -> 30
    //   59: astore 4
    //   61: aload_3
    //   62: astore_2
    //   63: ldc 82
    //   65: ldc_w 355
    //   68: iconst_2
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_0
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: aload 4
    //   80: invokevirtual 105	java/io/IOException:getMessage	()Ljava/lang/String;
    //   83: aastore
    //   84: invokestatic 325	com/tencent/e/a/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: aload_3
    //   88: astore_2
    //   89: aload 4
    //   91: athrow
    //   92: astore_0
    //   93: aload_2
    //   94: ifnull +7 -> 101
    //   97: aload_2
    //   98: invokevirtual 356	java/io/InputStreamReader:close	()V
    //   101: aload_0
    //   102: athrow
    //   103: aload_3
    //   104: invokevirtual 356	java/io/InputStreamReader:close	()V
    //   107: aload 4
    //   109: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: areturn
    //   113: astore_0
    //   114: goto -7 -> 107
    //   117: astore_2
    //   118: goto -17 -> 101
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_2
    //   124: goto -31 -> 93
    //   127: astore 4
    //   129: aconst_null
    //   130: astore_3
    //   131: goto -70 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramString	String
    //   38	14	1	i	int
    //   22	76	2	localInputStreamReader1	java.io.InputStreamReader
    //   117	1	2	localIOException1	IOException
    //   123	1	2	localObject	Object
    //   20	111	3	localInputStreamReader2	java.io.InputStreamReader
    //   7	40	4	localStringBuilder	StringBuilder
    //   59	49	4	localIOException2	IOException
    //   127	1	4	localIOException3	IOException
    //   28	21	5	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   23	30	59	java/io/IOException
    //   32	39	59	java/io/IOException
    //   46	56	59	java/io/IOException
    //   23	30	92	finally
    //   32	39	92	finally
    //   46	56	92	finally
    //   63	87	92	finally
    //   89	92	92	finally
    //   103	107	113	java/io/IOException
    //   97	101	117	java/io/IOException
    //   9	21	121	finally
    //   9	21	127	java/io/IOException
  }
  
  /* Error */
  public static byte[] c(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: iload_2
    //   7: iflt +10 -> 17
    //   10: iload_2
    //   11: ldc_w 358
    //   14: if_icmple +274 -> 288
    //   17: sipush 4096
    //   20: istore_3
    //   21: new 360	java/io/ByteArrayOutputStream
    //   24: dup
    //   25: iload_3
    //   26: invokespecial 361	java/io/ByteArrayOutputStream:<init>	(I)V
    //   29: astore 8
    //   31: aload_0
    //   32: invokestatic 297	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   35: astore 7
    //   37: iload_1
    //   38: i2l
    //   39: lstore 4
    //   41: lload 4
    //   43: lconst_0
    //   44: lcmp
    //   45: ifle +22 -> 67
    //   48: aload 7
    //   50: astore 6
    //   52: lload 4
    //   54: aload 7
    //   56: lload 4
    //   58: invokevirtual 365	java/io/InputStream:skip	(J)J
    //   61: lsub
    //   62: lstore 4
    //   64: goto -23 -> 41
    //   67: aload 7
    //   69: astore 6
    //   71: sipush 1024
    //   74: newarray byte
    //   76: astore 9
    //   78: iload_2
    //   79: istore_1
    //   80: iload_2
    //   81: ifge +7 -> 88
    //   84: ldc_w 366
    //   87: istore_1
    //   88: aload 7
    //   90: astore 6
    //   92: aload 7
    //   94: aload 9
    //   96: iconst_0
    //   97: iload_1
    //   98: sipush 1024
    //   101: invokestatic 372	java/lang/Math:min	(II)I
    //   104: invokevirtual 375	java/io/InputStream:read	([BII)I
    //   107: istore_2
    //   108: iload_2
    //   109: iconst_m1
    //   110: if_icmpeq +27 -> 137
    //   113: iload_1
    //   114: ifle +23 -> 137
    //   117: aload 7
    //   119: astore 6
    //   121: aload 8
    //   123: aload 9
    //   125: iconst_0
    //   126: iload_2
    //   127: invokevirtual 376	java/io/ByteArrayOutputStream:write	([BII)V
    //   130: iload_1
    //   131: iload_2
    //   132: isub
    //   133: istore_1
    //   134: goto -46 -> 88
    //   137: aload 7
    //   139: ifnull +8 -> 147
    //   142: aload 7
    //   144: invokevirtual 215	java/io/InputStream:close	()V
    //   147: aload 8
    //   149: invokevirtual 379	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   152: astore 6
    //   154: aload 8
    //   156: invokevirtual 380	java/io/ByteArrayOutputStream:close	()V
    //   159: ldc 82
    //   161: ldc_w 382
    //   164: iconst_2
    //   165: anewarray 4	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: aload_0
    //   171: aastore
    //   172: dup
    //   173: iconst_1
    //   174: aload 6
    //   176: arraylength
    //   177: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: aastore
    //   181: invokestatic 385	com/tencent/e/a/b:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: aload 6
    //   186: areturn
    //   187: astore 8
    //   189: aconst_null
    //   190: astore 7
    //   192: aload 7
    //   194: astore 6
    //   196: ldc 82
    //   198: new 120	java/lang/StringBuilder
    //   201: dup
    //   202: ldc_w 387
    //   205: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   208: aload_0
    //   209: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc_w 389
    //   215: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload 8
    //   220: invokevirtual 105	java/io/IOException:getMessage	()Ljava/lang/String;
    //   223: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 391	com/tencent/e/a/b:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload 7
    //   234: ifnull +8 -> 242
    //   237: aload 7
    //   239: invokevirtual 215	java/io/InputStream:close	()V
    //   242: aconst_null
    //   243: areturn
    //   244: astore_0
    //   245: aconst_null
    //   246: astore 6
    //   248: aload 6
    //   250: ifnull +8 -> 258
    //   253: aload 6
    //   255: invokevirtual 215	java/io/InputStream:close	()V
    //   258: aload_0
    //   259: athrow
    //   260: astore 6
    //   262: goto -115 -> 147
    //   265: astore_0
    //   266: goto -24 -> 242
    //   269: astore 6
    //   271: goto -13 -> 258
    //   274: astore 7
    //   276: goto -117 -> 159
    //   279: astore_0
    //   280: goto -32 -> 248
    //   283: astore 8
    //   285: goto -93 -> 192
    //   288: iload_2
    //   289: istore_3
    //   290: goto -269 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramString	String
    //   0	293	1	paramInt1	int
    //   0	293	2	paramInt2	int
    //   20	270	3	i	int
    //   39	24	4	l	long
    //   50	204	6	localObject	Object
    //   260	1	6	localIOException1	IOException
    //   269	1	6	localIOException2	IOException
    //   35	203	7	localInputStream	InputStream
    //   274	1	7	localIOException3	IOException
    //   29	126	8	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   187	32	8	localIOException4	IOException
    //   283	1	8	localIOException5	IOException
    //   76	48	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   31	37	187	java/io/IOException
    //   31	37	244	finally
    //   142	147	260	java/io/IOException
    //   237	242	265	java/io/IOException
    //   253	258	269	java/io/IOException
    //   154	159	274	java/io/IOException
    //   52	64	279	finally
    //   71	78	279	finally
    //   92	108	279	finally
    //   121	130	279	finally
    //   196	232	279	finally
    //   52	64	283	java/io/IOException
    //   71	78	283	java/io/IOException
    //   92	108	283	java/io/IOException
    //   121	130	283	java/io/IOException
  }
  
  public static boolean deleteFile(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    return new b(paramString).delete();
  }
  
  public static boolean f(String paramString1, String paramString2, String paramString3)
  {
    return aA(paramString1 + paramString2, paramString1 + paramString3);
  }
  
  public static boolean gC(String paramString1, String paramString2)
  {
    paramString1 = j.aeZ(paramString1);
    paramString1 = FileSystemManager.cVw().a(paramString1, null);
    paramString2 = j.aeZ(paramString2);
    return a(paramString1, FileSystemManager.cVw().a(paramString2, null));
  }
  
  public static boolean gD(String paramString1, String paramString2)
  {
    Object localObject1 = j.aeZ(paramString1);
    localObject1 = FileSystemManager.cVw().a((Uri)localObject1, null);
    Object localObject2 = j.aeZ(paramString2);
    localObject2 = FileSystemManager.cVw().a((Uri)localObject2, null);
    if ((((FileSystemManager.d)localObject1).valid()) && (((FileSystemManager.d)localObject1).wva == ((FileSystemManager.d)localObject2).wva) && ((((FileSystemManager.d)localObject1).wva.Qd() & 0x20) != 0) && (((FileSystemManager.d)localObject1).wva.aC(paramString1, paramString2))) {}
    while ((a((FileSystemManager.d)localObject1, (FileSystemManager.d)localObject2)) && (K(paramString1, false))) {
      return true;
    }
    return false;
  }
  
  /* Error */
  public static int gE(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 409	java/util/zip/ZipInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokestatic 297	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: invokespecial 410	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   11: astore_3
    //   12: aload_3
    //   13: astore_0
    //   14: aload_3
    //   15: invokevirtual 414	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   18: astore 4
    //   20: aload 4
    //   22: ifnull +248 -> 270
    //   25: aload_3
    //   26: astore_0
    //   27: aload 4
    //   29: invokevirtual 417	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   32: astore 5
    //   34: aload_3
    //   35: astore_0
    //   36: aload 5
    //   38: ldc_w 419
    //   41: invokevirtual 423	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   44: ifne -32 -> 12
    //   47: aload_3
    //   48: astore_0
    //   49: aload 5
    //   51: ldc_w 425
    //   54: invokevirtual 423	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   57: ifne -45 -> 12
    //   60: aload_3
    //   61: astore_0
    //   62: aload 4
    //   64: invokevirtual 428	java/util/zip/ZipEntry:isDirectory	()Z
    //   67: ifeq +81 -> 148
    //   70: aload_3
    //   71: astore_0
    //   72: aload 5
    //   74: iconst_0
    //   75: aload 5
    //   77: invokevirtual 37	java/lang/String:length	()I
    //   80: iconst_1
    //   81: isub
    //   82: invokevirtual 196	java/lang/String:substring	(II)Ljava/lang/String;
    //   85: astore 4
    //   87: aload_3
    //   88: astore_0
    //   89: new 219	com/tencent/mm/vfs/b
    //   92: dup
    //   93: new 120	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   100: aload_1
    //   101: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 171
    //   106: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 4
    //   111: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokespecial 220	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   120: invokevirtual 431	com/tencent/mm/vfs/b:mkdirs	()Z
    //   123: pop
    //   124: goto -112 -> 12
    //   127: astore_1
    //   128: aload_3
    //   129: astore_0
    //   130: ldc 82
    //   132: aload_1
    //   133: ldc 84
    //   135: invokestatic 90	com/tencent/e/a/b:c	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   138: aload_3
    //   139: ifnull +7 -> 146
    //   142: aload_3
    //   143: invokevirtual 432	java/util/zip/ZipInputStream:close	()V
    //   146: iconst_m1
    //   147: ireturn
    //   148: aload_3
    //   149: astore_0
    //   150: new 219	com/tencent/mm/vfs/b
    //   153: dup
    //   154: new 120	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   161: aload_1
    //   162: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc 171
    //   167: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 5
    //   172: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokespecial 220	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   181: invokestatic 436	com/tencent/mm/vfs/e:p	(Lcom/tencent/mm/vfs/b;)Ljava/io/OutputStream;
    //   184: astore 4
    //   186: aload_3
    //   187: astore_0
    //   188: sipush 1024
    //   191: newarray byte
    //   193: astore 5
    //   195: aload_3
    //   196: astore_0
    //   197: aload_3
    //   198: aload 5
    //   200: invokevirtual 437	java/util/zip/ZipInputStream:read	([B)I
    //   203: istore_2
    //   204: iload_2
    //   205: iconst_m1
    //   206: if_icmpeq +39 -> 245
    //   209: aload_3
    //   210: astore_0
    //   211: aload 4
    //   213: aload 5
    //   215: iconst_0
    //   216: iload_2
    //   217: invokevirtual 76	java/io/OutputStream:write	([BII)V
    //   220: goto -25 -> 195
    //   223: astore_1
    //   224: aload_3
    //   225: astore_0
    //   226: ldc 82
    //   228: aload_1
    //   229: ldc 84
    //   231: invokestatic 90	com/tencent/e/a/b:c	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   234: aload_3
    //   235: ifnull +7 -> 242
    //   238: aload_3
    //   239: invokevirtual 432	java/util/zip/ZipInputStream:close	()V
    //   242: bipush 254
    //   244: ireturn
    //   245: aload_3
    //   246: astore_0
    //   247: aload 4
    //   249: invokevirtual 80	java/io/OutputStream:close	()V
    //   252: goto -240 -> 12
    //   255: astore_3
    //   256: aload_0
    //   257: astore_1
    //   258: aload_3
    //   259: astore_0
    //   260: aload_1
    //   261: ifnull +7 -> 268
    //   264: aload_1
    //   265: invokevirtual 432	java/util/zip/ZipInputStream:close	()V
    //   268: aload_0
    //   269: athrow
    //   270: aload_3
    //   271: invokevirtual 432	java/util/zip/ZipInputStream:close	()V
    //   274: iconst_0
    //   275: ireturn
    //   276: astore_0
    //   277: ldc 82
    //   279: ldc_w 439
    //   282: invokestatic 214	com/tencent/e/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: iconst_0
    //   286: ireturn
    //   287: astore_0
    //   288: ldc 82
    //   290: ldc_w 439
    //   293: invokestatic 214	com/tencent/e/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: goto -150 -> 146
    //   299: astore_0
    //   300: ldc 82
    //   302: ldc_w 439
    //   305: invokestatic 214	com/tencent/e/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: goto -66 -> 242
    //   311: astore_1
    //   312: ldc 82
    //   314: ldc_w 439
    //   317: invokestatic 214	com/tencent/e/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: goto -52 -> 268
    //   323: astore_0
    //   324: aconst_null
    //   325: astore_1
    //   326: goto -66 -> 260
    //   329: astore_1
    //   330: aconst_null
    //   331: astore_3
    //   332: goto -108 -> 224
    //   335: astore_1
    //   336: aconst_null
    //   337: astore_3
    //   338: goto -210 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramString1	String
    //   0	341	1	paramString2	String
    //   203	14	2	i	int
    //   11	235	3	localZipInputStream	java.util.zip.ZipInputStream
    //   255	16	3	localObject1	Object
    //   331	7	3	localObject2	Object
    //   18	230	4	localObject3	Object
    //   32	182	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   14	20	127	java/io/FileNotFoundException
    //   27	34	127	java/io/FileNotFoundException
    //   36	47	127	java/io/FileNotFoundException
    //   49	60	127	java/io/FileNotFoundException
    //   62	70	127	java/io/FileNotFoundException
    //   72	87	127	java/io/FileNotFoundException
    //   89	124	127	java/io/FileNotFoundException
    //   150	186	127	java/io/FileNotFoundException
    //   188	195	127	java/io/FileNotFoundException
    //   197	204	127	java/io/FileNotFoundException
    //   211	220	127	java/io/FileNotFoundException
    //   247	252	127	java/io/FileNotFoundException
    //   14	20	223	java/io/IOException
    //   27	34	223	java/io/IOException
    //   36	47	223	java/io/IOException
    //   49	60	223	java/io/IOException
    //   62	70	223	java/io/IOException
    //   72	87	223	java/io/IOException
    //   89	124	223	java/io/IOException
    //   150	186	223	java/io/IOException
    //   188	195	223	java/io/IOException
    //   197	204	223	java/io/IOException
    //   211	220	223	java/io/IOException
    //   247	252	223	java/io/IOException
    //   14	20	255	finally
    //   27	34	255	finally
    //   36	47	255	finally
    //   49	60	255	finally
    //   62	70	255	finally
    //   72	87	255	finally
    //   89	124	255	finally
    //   130	138	255	finally
    //   150	186	255	finally
    //   188	195	255	finally
    //   197	204	255	finally
    //   211	220	255	finally
    //   226	234	255	finally
    //   247	252	255	finally
    //   270	274	276	java/io/IOException
    //   142	146	287	java/io/IOException
    //   238	242	299	java/io/IOException
    //   264	268	311	java/io/IOException
    //   0	12	323	finally
    //   0	12	329	java/io/IOException
    //   0	12	335	java/io/FileNotFoundException
  }
  
  /* Error */
  public static boolean m(List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 12	java/lang/String:isEmpty	()Z
    //   8: ifeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: invokestatic 443	com/tencent/mm/vfs/e:aeS	(Ljava/lang/String;)Ljava/lang/String;
    //   17: invokestatic 444	com/tencent/mm/vfs/e:nb	(Ljava/lang/String;)Z
    //   20: pop
    //   21: sipush 4096
    //   24: newarray byte
    //   26: astore 5
    //   28: new 446	java/util/zip/ZipOutputStream
    //   31: dup
    //   32: aload_1
    //   33: iconst_0
    //   34: invokestatic 70	com/tencent/mm/vfs/e:I	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   37: invokespecial 449	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   40: astore_1
    //   41: aload_0
    //   42: invokeinterface 158 1 0
    //   47: astore 6
    //   49: aload 6
    //   51: invokeinterface 163 1 0
    //   56: ifeq +305 -> 361
    //   59: aload 6
    //   61: invokeinterface 167 1 0
    //   66: checkcast 8	java/lang/String
    //   69: invokestatic 26	com/tencent/mm/vfs/j:aeZ	(Ljava/lang/String;)Landroid/net/Uri;
    //   72: astore_0
    //   73: invokestatic 43	com/tencent/mm/vfs/FileSystemManager:cVw	()Lcom/tencent/mm/vfs/FileSystemManager;
    //   76: aload_0
    //   77: aconst_null
    //   78: invokevirtual 46	com/tencent/mm/vfs/FileSystemManager:a	(Landroid/net/Uri;Lcom/tencent/mm/vfs/FileSystemManager$d;)Lcom/tencent/mm/vfs/FileSystemManager$d;
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 51	com/tencent/mm/vfs/FileSystemManager$d:valid	()Z
    //   86: ifeq -37 -> 49
    //   89: aload_0
    //   90: getfield 55	com/tencent/mm/vfs/FileSystemManager$d:wva	Lcom/tencent/mm/vfs/FileSystem;
    //   93: aload_0
    //   94: getfield 59	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   97: invokeinterface 250 2 0
    //   102: astore 4
    //   104: aload 4
    //   106: ifnull -57 -> 49
    //   109: aload 4
    //   111: getfield 189	com/tencent/mm/vfs/FileSystem$a:wuv	Z
    //   114: ifeq +190 -> 304
    //   117: aload_0
    //   118: getfield 59	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   121: invokevirtual 37	java/lang/String:length	()I
    //   124: istore_3
    //   125: aload_0
    //   126: getfield 59	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   129: ldc 171
    //   131: invokevirtual 174	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   134: ifeq +165 -> 299
    //   137: iconst_0
    //   138: istore_2
    //   139: aload_0
    //   140: getfield 55	com/tencent/mm/vfs/FileSystemManager$d:wva	Lcom/tencent/mm/vfs/FileSystem;
    //   143: aload_0
    //   144: getfield 59	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   147: iconst_1
    //   148: invokeinterface 140 3 0
    //   153: astore_0
    //   154: aload_0
    //   155: ifnull -106 -> 49
    //   158: iload_2
    //   159: iload_3
    //   160: iadd
    //   161: istore_2
    //   162: aload_0
    //   163: invokeinterface 158 1 0
    //   168: astore 7
    //   170: aload 7
    //   172: invokeinterface 163 1 0
    //   177: ifeq -128 -> 49
    //   180: aload 7
    //   182: invokeinterface 167 1 0
    //   187: checkcast 169	com/tencent/mm/vfs/FileSystem$a
    //   190: astore 4
    //   192: aload 4
    //   194: getfield 189	com/tencent/mm/vfs/FileSystem$a:wuv	Z
    //   197: ifne -27 -> 170
    //   200: aload 4
    //   202: getfield 181	com/tencent/mm/vfs/FileSystem$a:wus	Ljava/lang/String;
    //   205: invokevirtual 37	java/lang/String:length	()I
    //   208: iload_2
    //   209: if_icmpge +118 -> 327
    //   212: aload 4
    //   214: getfield 452	com/tencent/mm/vfs/FileSystem$a:name	Ljava/lang/String;
    //   217: astore_0
    //   218: aload 4
    //   220: invokevirtual 200	com/tencent/mm/vfs/FileSystem$a:cLi	()Ljava/io/InputStream;
    //   223: astore 4
    //   225: aload_1
    //   226: new 416	java/util/zip/ZipEntry
    //   229: dup
    //   230: aload_0
    //   231: invokespecial 453	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   234: invokevirtual 457	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   237: aload 4
    //   239: aload 5
    //   241: invokevirtual 206	java/io/InputStream:read	([B)I
    //   244: istore_3
    //   245: iload_3
    //   246: iflt +94 -> 340
    //   249: aload_1
    //   250: aload 5
    //   252: iconst_0
    //   253: iload_3
    //   254: invokevirtual 458	java/util/zip/ZipOutputStream:write	([BII)V
    //   257: goto -20 -> 237
    //   260: astore 5
    //   262: aload_1
    //   263: astore_0
    //   264: aload 4
    //   266: astore_1
    //   267: aload 5
    //   269: astore 4
    //   271: ldc 82
    //   273: aload 4
    //   275: ldc_w 460
    //   278: invokestatic 90	com/tencent/e/a/b:c	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   281: aload_1
    //   282: ifnull +7 -> 289
    //   285: aload_1
    //   286: invokevirtual 215	java/io/InputStream:close	()V
    //   289: aload_0
    //   290: ifnull +7 -> 297
    //   293: aload_0
    //   294: invokevirtual 461	java/util/zip/ZipOutputStream:close	()V
    //   297: iconst_0
    //   298: ireturn
    //   299: iconst_1
    //   300: istore_2
    //   301: goto -162 -> 139
    //   304: aload_0
    //   305: getfield 59	com/tencent/mm/vfs/FileSystemManager$d:path	Ljava/lang/String;
    //   308: bipush 47
    //   310: invokevirtual 193	java/lang/String:lastIndexOf	(I)I
    //   313: istore_2
    //   314: aload 4
    //   316: invokestatic 467	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   319: astore_0
    //   320: iload_2
    //   321: iconst_1
    //   322: iadd
    //   323: istore_2
    //   324: goto -162 -> 162
    //   327: aload 4
    //   329: getfield 181	com/tencent/mm/vfs/FileSystem$a:wus	Ljava/lang/String;
    //   332: iload_2
    //   333: invokevirtual 185	java/lang/String:substring	(I)Ljava/lang/String;
    //   336: astore_0
    //   337: goto -119 -> 218
    //   340: aload 4
    //   342: invokevirtual 215	java/io/InputStream:close	()V
    //   345: aload_1
    //   346: invokevirtual 470	java/util/zip/ZipOutputStream:closeEntry	()V
    //   349: goto -179 -> 170
    //   352: astore 4
    //   354: aload_1
    //   355: astore_0
    //   356: aconst_null
    //   357: astore_1
    //   358: goto -87 -> 271
    //   361: aload_1
    //   362: invokevirtual 461	java/util/zip/ZipOutputStream:close	()V
    //   365: iconst_1
    //   366: ireturn
    //   367: astore_0
    //   368: aconst_null
    //   369: astore 5
    //   371: aconst_null
    //   372: astore_1
    //   373: aload_1
    //   374: ifnull +7 -> 381
    //   377: aload_1
    //   378: invokevirtual 215	java/io/InputStream:close	()V
    //   381: aload 5
    //   383: ifnull +8 -> 391
    //   386: aload 5
    //   388: invokevirtual 461	java/util/zip/ZipOutputStream:close	()V
    //   391: aload_0
    //   392: athrow
    //   393: astore_0
    //   394: goto -29 -> 365
    //   397: astore_1
    //   398: goto -109 -> 289
    //   401: astore_0
    //   402: goto -105 -> 297
    //   405: astore_1
    //   406: goto -25 -> 381
    //   409: astore_1
    //   410: goto -19 -> 391
    //   413: astore_0
    //   414: aconst_null
    //   415: astore 4
    //   417: aload_1
    //   418: astore 5
    //   420: aload 4
    //   422: astore_1
    //   423: goto -50 -> 373
    //   426: astore_0
    //   427: aload_1
    //   428: astore 5
    //   430: aload 4
    //   432: astore_1
    //   433: goto -60 -> 373
    //   436: astore 4
    //   438: aload_0
    //   439: astore 5
    //   441: aload 4
    //   443: astore_0
    //   444: goto -71 -> 373
    //   447: astore 4
    //   449: aconst_null
    //   450: astore_0
    //   451: aconst_null
    //   452: astore_1
    //   453: goto -182 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	paramList	List<String>
    //   0	456	1	paramString	String
    //   138	195	2	i	int
    //   124	130	3	j	int
    //   102	239	4	localObject1	Object
    //   352	1	4	localIOException1	IOException
    //   415	16	4	localObject2	Object
    //   436	6	4	localObject3	Object
    //   447	1	4	localIOException2	IOException
    //   26	225	5	arrayOfByte	byte[]
    //   260	8	5	localIOException3	IOException
    //   369	71	5	localObject4	Object
    //   47	13	6	localIterator1	java.util.Iterator
    //   168	13	7	localIterator2	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   225	237	260	java/io/IOException
    //   237	245	260	java/io/IOException
    //   249	257	260	java/io/IOException
    //   340	345	260	java/io/IOException
    //   41	49	352	java/io/IOException
    //   49	104	352	java/io/IOException
    //   109	137	352	java/io/IOException
    //   139	154	352	java/io/IOException
    //   162	170	352	java/io/IOException
    //   170	218	352	java/io/IOException
    //   218	225	352	java/io/IOException
    //   304	320	352	java/io/IOException
    //   327	337	352	java/io/IOException
    //   345	349	352	java/io/IOException
    //   28	41	367	finally
    //   361	365	393	java/io/IOException
    //   285	289	397	java/io/IOException
    //   293	297	401	java/io/IOException
    //   377	381	405	java/io/IOException
    //   386	391	409	java/io/IOException
    //   41	49	413	finally
    //   49	104	413	finally
    //   109	137	413	finally
    //   139	154	413	finally
    //   162	170	413	finally
    //   170	218	413	finally
    //   218	225	413	finally
    //   304	320	413	finally
    //   327	337	413	finally
    //   345	349	413	finally
    //   225	237	426	finally
    //   237	245	426	finally
    //   249	257	426	finally
    //   340	345	426	finally
    //   271	281	436	finally
    //   28	41	447	java/io/IOException
  }
  
  public static boolean nb(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    paramString = new b(paramString);
    if ((paramString.exists()) && (paramString.isDirectory())) {
      return true;
    }
    return paramString.mkdirs();
  }
  
  public static InputStream o(b paramb)
  {
    return b(paramb.mUri, paramb.cLo());
  }
  
  public static InputStream openRead(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      throw new FileNotFoundException("path is empty");
    }
    return b(j.aeZ(paramString), null);
  }
  
  public static OutputStream p(b paramb)
  {
    return a(paramb.mUri, paramb.cLo(), false);
  }
  
  public static OutputStream q(b paramb)
  {
    return a(paramb.mUri, paramb.cLo(), false);
  }
  
  /* Error */
  public static long r(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +21 -> 22
    //   4: aload_0
    //   5: invokevirtual 37	java/lang/String:length	()I
    //   8: ifeq +14 -> 22
    //   11: aload_1
    //   12: ifnull +10 -> 22
    //   15: aload_1
    //   16: invokevirtual 37	java/lang/String:length	()I
    //   19: ifne +7 -> 26
    //   22: ldc2_w 486
    //   25: lreturn
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 490	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifne -9 -> 22
    //   34: lconst_0
    //   35: lstore_3
    //   36: aload_0
    //   37: invokestatic 297	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   40: astore 6
    //   42: aload_1
    //   43: iconst_0
    //   44: invokestatic 70	com/tencent/mm/vfs/e:I	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   47: astore 5
    //   49: sipush 1024
    //   52: newarray byte
    //   54: astore 7
    //   56: aload 6
    //   58: aload 7
    //   60: invokevirtual 206	java/io/InputStream:read	([B)I
    //   63: istore_2
    //   64: iload_2
    //   65: iconst_m1
    //   66: if_icmpeq +20 -> 86
    //   69: aload 5
    //   71: aload 7
    //   73: iconst_0
    //   74: iload_2
    //   75: invokevirtual 76	java/io/OutputStream:write	([BII)V
    //   78: lload_3
    //   79: iload_2
    //   80: i2l
    //   81: ladd
    //   82: lstore_3
    //   83: goto -27 -> 56
    //   86: ldc 82
    //   88: ldc_w 492
    //   91: iconst_2
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload_0
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: aload_1
    //   102: aastore
    //   103: invokestatic 385	com/tencent/e/a/b:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload 6
    //   108: ifnull +8 -> 116
    //   111: aload 6
    //   113: invokevirtual 215	java/io/InputStream:close	()V
    //   116: aload 5
    //   118: ifnull +8 -> 126
    //   121: aload 5
    //   123: invokevirtual 80	java/io/OutputStream:close	()V
    //   126: lload_3
    //   127: lreturn
    //   128: astore 7
    //   130: aconst_null
    //   131: astore 5
    //   133: aconst_null
    //   134: astore 6
    //   136: ldc 82
    //   138: ldc_w 494
    //   141: iconst_3
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_0
    //   148: aastore
    //   149: dup
    //   150: iconst_1
    //   151: aload_1
    //   152: aastore
    //   153: dup
    //   154: iconst_2
    //   155: aload 7
    //   157: invokevirtual 105	java/io/IOException:getMessage	()Ljava/lang/String;
    //   160: aastore
    //   161: invokestatic 325	com/tencent/e/a/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: aload 6
    //   166: ifnull +8 -> 174
    //   169: aload 6
    //   171: invokevirtual 215	java/io/InputStream:close	()V
    //   174: aload 5
    //   176: ifnull -154 -> 22
    //   179: aload 5
    //   181: invokevirtual 80	java/io/OutputStream:close	()V
    //   184: ldc2_w 486
    //   187: lreturn
    //   188: astore_0
    //   189: ldc2_w 486
    //   192: lreturn
    //   193: astore_0
    //   194: aconst_null
    //   195: astore 5
    //   197: aconst_null
    //   198: astore 6
    //   200: aload 6
    //   202: ifnull +8 -> 210
    //   205: aload 6
    //   207: invokevirtual 215	java/io/InputStream:close	()V
    //   210: aload 5
    //   212: ifnull +8 -> 220
    //   215: aload 5
    //   217: invokevirtual 80	java/io/OutputStream:close	()V
    //   220: aload_0
    //   221: athrow
    //   222: astore_0
    //   223: goto -107 -> 116
    //   226: astore_0
    //   227: goto -101 -> 126
    //   230: astore_0
    //   231: goto -57 -> 174
    //   234: astore_1
    //   235: goto -25 -> 210
    //   238: astore_1
    //   239: goto -19 -> 220
    //   242: astore_0
    //   243: aconst_null
    //   244: astore 5
    //   246: goto -46 -> 200
    //   249: astore_0
    //   250: goto -50 -> 200
    //   253: astore_0
    //   254: goto -54 -> 200
    //   257: astore 7
    //   259: aconst_null
    //   260: astore 5
    //   262: goto -126 -> 136
    //   265: astore 7
    //   267: goto -131 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	paramString1	String
    //   0	270	1	paramString2	String
    //   63	17	2	i	int
    //   35	92	3	l	long
    //   47	214	5	localOutputStream	OutputStream
    //   40	166	6	localInputStream	InputStream
    //   54	18	7	arrayOfByte	byte[]
    //   128	28	7	localIOException1	IOException
    //   257	1	7	localIOException2	IOException
    //   265	1	7	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   36	42	128	java/io/IOException
    //   179	184	188	java/io/IOException
    //   36	42	193	finally
    //   111	116	222	java/io/IOException
    //   121	126	226	java/io/IOException
    //   169	174	230	java/io/IOException
    //   205	210	234	java/io/IOException
    //   215	220	238	java/io/IOException
    //   42	49	242	finally
    //   49	56	249	finally
    //   56	64	249	finally
    //   69	78	249	finally
    //   86	106	249	finally
    //   136	164	253	finally
    //   42	49	257	java/io/IOException
    //   49	56	265	java/io/IOException
    //   56	64	265	java/io/IOException
    //   69	78	265	java/io/IOException
    //   86	106	265	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.e
 * JD-Core Version:    0.7.0.1
 */