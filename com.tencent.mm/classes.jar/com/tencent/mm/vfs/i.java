package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public final class i
{
  public static int C(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(221182);
    int i = f(paramString, paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(221182);
    return i;
  }
  
  public static OutputStream Cz(String paramString)
  {
    AppMethodBeat.i(221181);
    paramString = cX(paramString, false);
    AppMethodBeat.o(221181);
    return paramString;
  }
  
  public static String ZF(String paramString)
  {
    AppMethodBeat.i(13298);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(13298);
      return "";
    }
    paramString = new e(paramString).getName();
    int i = paramString.lastIndexOf('.');
    if ((i <= 0) || (i == paramString.length() - 1))
    {
      AppMethodBeat.o(13298);
      return "";
    }
    paramString = paramString.substring(i + 1);
    AppMethodBeat.o(13298);
    return paramString;
  }
  
  public static ParcelFileDescriptor a(Uri paramUri, a.e parame, String paramString)
  {
    AppMethodBeat.i(13275);
    parame = a.gzU().a(paramUri, parame);
    if (!parame.valid())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(13275);
      throw paramUri;
    }
    paramUri = parame.LjM.mt(parame.path, paramString);
    AppMethodBeat.o(13275);
    return paramUri;
  }
  
  static OutputStream a(Uri paramUri, a.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(13271);
    parame = a.gzU().a(paramUri, parame);
    if (!parame.valid())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(13271);
      throw paramUri;
    }
    paramUri = parame.LjM.cX(parame.path, paramBoolean);
    AppMethodBeat.o(13271);
    return paramUri;
  }
  
  public static RandomAccessFile a(Uri paramUri, boolean paramBoolean)
  {
    AppMethodBeat.i(13273);
    String str = q.b(paramUri, paramBoolean);
    if (str == null)
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(13273);
      throw paramUri;
    }
    if (paramBoolean) {}
    for (paramUri = "rw";; paramUri = "r")
    {
      paramUri = new RandomAccessFile(str, paramUri);
      AppMethodBeat.o(13273);
      return paramUri;
    }
  }
  
  private static boolean a(a.e parame1, a.e parame2, boolean paramBoolean)
  {
    AppMethodBeat.i(13292);
    if ((!parame1.valid()) || (!parame2.valid()))
    {
      AppMethodBeat.o(13292);
      return false;
    }
    Object localObject = parame1.LjM.cY(parame1.path, true);
    if (localObject == null)
    {
      AppMethodBeat.o(13292);
      return false;
    }
    HashSet localHashSet = new HashSet();
    parame2.LjM.aYg(parame2.path);
    localHashSet.add(parame2.path);
    Iterator localIterator = ((Iterable)localObject).iterator();
    FileSystem.a locala;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label373;
      }
      locala = (FileSystem.a)localIterator.next();
      int i = parame1.path.length();
      String str = locala.HZk.substring(i);
      localObject = str;
      if (!str.startsWith("/")) {
        localObject = "/".concat(String.valueOf(str));
      }
      localObject = parame2.path + (String)localObject;
      if (locala.LjL)
      {
        if (localHashSet.add(localObject)) {
          parame2.LjM.aYg((String)localObject);
        }
      }
      else
      {
        i = ((String)localObject).lastIndexOf('/');
        if (i > 0)
        {
          str = ((String)localObject).substring(0, i);
          if (localHashSet.add(str)) {
            parame2.LjM.aYg(str);
          }
        }
        if (paramBoolean) {
          try
          {
            parame2.LjM.a((String)localObject, locala.LjM, locala.HZk);
          }
          catch (IOException parame2)
          {
            localObject = new StringBuilder("Failed to ");
            if (!paramBoolean) {}
          }
        }
      }
    }
    for (parame1 = "move";; parame1 = "copy")
    {
      Log.w("MicroMsg.VFSFileOp", parame2, parame1 + " files.");
      AppMethodBeat.o(13292);
      return false;
      parame2.LjM.c((String)localObject, locala.LjM, locala.HZk);
      break;
    }
    label373:
    AppMethodBeat.o(13292);
    return true;
  }
  
  public static String aPK(String paramString)
  {
    AppMethodBeat.i(13302);
    paramString = aYv(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(13302);
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
    AppMethodBeat.o(13302);
    return paramString;
  }
  
  /* Error */
  public static byte[] aY(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: sipush 13280
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +11 -> 18
    //   10: sipush 13280
    //   13: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: iload_2
    //   19: iflt +9 -> 28
    //   22: iload_2
    //   23: ldc 218
    //   25: if_icmple +262 -> 287
    //   28: sipush 4096
    //   31: istore_3
    //   32: new 220	java/io/ByteArrayOutputStream
    //   35: dup
    //   36: iload_3
    //   37: invokespecial 221	java/io/ByteArrayOutputStream:<init>	(I)V
    //   40: astore 8
    //   42: aload_0
    //   43: invokestatic 225	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   46: astore 7
    //   48: iload_1
    //   49: i2l
    //   50: lstore 4
    //   52: lload 4
    //   54: lconst_0
    //   55: lcmp
    //   56: ifle +22 -> 78
    //   59: aload 7
    //   61: astore 6
    //   63: lload 4
    //   65: aload 7
    //   67: lload 4
    //   69: invokevirtual 231	java/io/InputStream:skip	(J)J
    //   72: lsub
    //   73: lstore 4
    //   75: goto -23 -> 52
    //   78: aload 7
    //   80: astore 6
    //   82: sipush 1024
    //   85: newarray byte
    //   87: astore 9
    //   89: iload_2
    //   90: istore_1
    //   91: iload_2
    //   92: ifge +6 -> 98
    //   95: ldc 232
    //   97: istore_1
    //   98: aload 7
    //   100: astore 6
    //   102: aload 7
    //   104: aload 9
    //   106: iconst_0
    //   107: iload_1
    //   108: sipush 1024
    //   111: invokestatic 238	java/lang/Math:min	(II)I
    //   114: invokevirtual 242	java/io/InputStream:read	([BII)I
    //   117: istore_2
    //   118: iload_2
    //   119: iconst_m1
    //   120: if_icmpeq +27 -> 147
    //   123: iload_1
    //   124: ifle +23 -> 147
    //   127: aload 7
    //   129: astore 6
    //   131: aload 8
    //   133: aload 9
    //   135: iconst_0
    //   136: iload_2
    //   137: invokevirtual 246	java/io/ByteArrayOutputStream:write	([BII)V
    //   140: iload_1
    //   141: iload_2
    //   142: isub
    //   143: istore_1
    //   144: goto -46 -> 98
    //   147: aload 7
    //   149: invokestatic 250	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   152: aload 8
    //   154: invokevirtual 254	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   157: astore 6
    //   159: aload 8
    //   161: invokevirtual 257	java/io/ByteArrayOutputStream:close	()V
    //   164: ldc 190
    //   166: ldc_w 259
    //   169: iconst_2
    //   170: anewarray 4	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload_0
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: aload 6
    //   181: arraylength
    //   182: invokestatic 262	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: aastore
    //   186: invokestatic 266	com/tencent/stubs/logger/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: sipush 13280
    //   192: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: aload 6
    //   197: areturn
    //   198: astore 8
    //   200: aconst_null
    //   201: astore 7
    //   203: aload 7
    //   205: astore 6
    //   207: ldc 190
    //   209: new 164	java/lang/StringBuilder
    //   212: dup
    //   213: ldc_w 268
    //   216: invokespecial 186	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   219: aload_0
    //   220: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: ldc_w 270
    //   226: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload 8
    //   231: invokevirtual 273	java/io/IOException:getMessage	()Ljava/lang/String;
    //   234: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 275	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload 7
    //   245: invokestatic 250	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   248: sipush 13280
    //   251: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: aconst_null
    //   255: areturn
    //   256: astore_0
    //   257: aconst_null
    //   258: astore 6
    //   260: aload 6
    //   262: invokestatic 250	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   265: sipush 13280
    //   268: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: aload_0
    //   272: athrow
    //   273: astore 7
    //   275: goto -111 -> 164
    //   278: astore_0
    //   279: goto -19 -> 260
    //   282: astore 8
    //   284: goto -81 -> 203
    //   287: iload_2
    //   288: istore_3
    //   289: goto -257 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	paramString	String
    //   0	292	1	paramInt1	int
    //   0	292	2	paramInt2	int
    //   31	258	3	i	int
    //   50	24	4	l	long
    //   61	200	6	localObject	Object
    //   46	198	7	localInputStream	InputStream
    //   273	1	7	localIOException1	IOException
    //   40	120	8	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   198	32	8	localIOException2	IOException
    //   282	1	8	localIOException3	IOException
    //   87	47	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   42	48	198	java/io/IOException
    //   42	48	256	finally
    //   159	164	273	java/io/IOException
    //   63	75	278	finally
    //   82	89	278	finally
    //   102	118	278	finally
    //   131	140	278	finally
    //   207	243	278	finally
    //   63	75	282	java/io/IOException
    //   82	89	282	java/io/IOException
    //   102	118	282	java/io/IOException
    //   131	140	282	java/io/IOException
  }
  
  public static boolean aYg(String paramString)
  {
    AppMethodBeat.i(13285);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(13285);
      return false;
    }
    paramString = new e(paramString);
    if ((paramString.mkdirs()) || (paramString.isDirectory()))
    {
      AppMethodBeat.o(13285);
      return true;
    }
    AppMethodBeat.o(13285);
    return false;
  }
  
  public static long aYo(String paramString)
  {
    AppMethodBeat.i(13278);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13278);
      return 0L;
    }
    paramString = q.parseUri(paramString);
    paramString = a.gzU().a(paramString, null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(13278);
      return 0L;
    }
    paramString = paramString.LjM.aYf(paramString.path);
    if (paramString == null)
    {
      AppMethodBeat.o(13278);
      return 0L;
    }
    long l = paramString.size;
    AppMethodBeat.o(13278);
    return l;
  }
  
  public static long aYp(String paramString)
  {
    AppMethodBeat.i(13279);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13279);
      return 0L;
    }
    paramString = q.parseUri(paramString);
    paramString = a.gzU().a(paramString, null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(13279);
      return 0L;
    }
    paramString = paramString.LjM.aYf(paramString.path);
    if (paramString == null)
    {
      AppMethodBeat.o(13279);
      return 0L;
    }
    long l = paramString.LjK;
    AppMethodBeat.o(13279);
    return l;
  }
  
  /* Error */
  public static String aYq(String paramString)
  {
    // Byte code:
    //   0: sipush 13281
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 164	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: new 305	java/io/InputStreamReader
    //   18: dup
    //   19: aload_0
    //   20: invokestatic 225	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   23: invokespecial 308	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
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
    //   41: invokevirtual 311	java/io/InputStreamReader:read	([C)I
    //   44: istore_1
    //   45: iload_1
    //   46: iconst_m1
    //   47: if_icmpeq +72 -> 119
    //   50: aload_3
    //   51: astore_2
    //   52: aload 4
    //   54: aload 5
    //   56: iconst_0
    //   57: iload_1
    //   58: invokevirtual 314	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -26 -> 36
    //   65: astore 4
    //   67: aload_3
    //   68: astore_2
    //   69: ldc 190
    //   71: ldc_w 316
    //   74: iconst_2
    //   75: anewarray 4	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: aload_0
    //   81: aastore
    //   82: dup
    //   83: iconst_1
    //   84: aload 4
    //   86: invokevirtual 273	java/io/IOException:getMessage	()Ljava/lang/String;
    //   89: aastore
    //   90: invokestatic 319	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aload_3
    //   94: astore_2
    //   95: sipush 13281
    //   98: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_3
    //   102: astore_2
    //   103: aload 4
    //   105: athrow
    //   106: astore_0
    //   107: aload_2
    //   108: invokestatic 250	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   111: sipush 13281
    //   114: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_0
    //   118: athrow
    //   119: aload_3
    //   120: invokestatic 250	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   123: aload 4
    //   125: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: astore_0
    //   129: sipush 13281
    //   132: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_0
    //   136: areturn
    //   137: astore_0
    //   138: aconst_null
    //   139: astore_2
    //   140: goto -33 -> 107
    //   143: astore 4
    //   145: aconst_null
    //   146: astore_3
    //   147: goto -80 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramString	String
    //   44	14	1	i	int
    //   28	112	2	localInputStreamReader1	java.io.InputStreamReader
    //   26	121	3	localInputStreamReader2	java.io.InputStreamReader
    //   13	40	4	localStringBuilder	StringBuilder
    //   65	59	4	localIOException1	IOException
    //   143	1	4	localIOException2	IOException
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
    //   15	27	137	finally
    //   15	27	143	java/io/IOException
  }
  
  public static String aYr(String paramString)
  {
    AppMethodBeat.i(13284);
    paramString = new e(paramString).fOL().getParent();
    AppMethodBeat.o(13284);
    return paramString;
  }
  
  public static boolean aYs(String paramString)
  {
    AppMethodBeat.i(13297);
    try
    {
      paramString = new e(paramString);
      if ((paramString.exists()) || (paramString.createNewFile()))
      {
        AppMethodBeat.o(13297);
        return true;
      }
      AppMethodBeat.o(13297);
      return false;
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(13297);
    }
    return false;
  }
  
  public static final String aYt(String paramString)
  {
    AppMethodBeat.i(13299);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(13299);
      return "";
    }
    String str = new e(paramString).getName();
    int i = str.lastIndexOf('.');
    if (i < 0)
    {
      AppMethodBeat.o(13299);
      return paramString;
    }
    if (i == 0)
    {
      AppMethodBeat.o(13299);
      return "";
    }
    paramString = str.substring(0, i);
    AppMethodBeat.o(13299);
    return paramString;
  }
  
  public static void aYu(String paramString)
  {
    AppMethodBeat.i(13300);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13300);
      return;
    }
    paramString = q.parseUri(paramString);
    paramString = a.gzU().a(paramString, null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(13300);
      return;
    }
    if ((paramString.LjM.fOp() & 0x2) == 0)
    {
      AppMethodBeat.o(13300);
      return;
    }
    if (paramString.LjM.da(paramString.path, true) == null)
    {
      AppMethodBeat.o(13300);
      return;
    }
    try
    {
      paramString.LjM.cX(paramString.path + "/.nomedia", false).close();
      AppMethodBeat.o(13300);
      return;
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(13300);
    }
  }
  
  /* Error */
  private static byte[] aYv(String paramString)
  {
    // Byte code:
    //   0: sipush 13301
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +11 -> 18
    //   10: sipush 13301
    //   13: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: invokestatic 225	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore_0
    //   23: ldc_w 352
    //   26: invokestatic 358	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   29: astore_2
    //   30: sipush 2048
    //   33: newarray byte
    //   35: astore_3
    //   36: aload_0
    //   37: aload_3
    //   38: invokevirtual 361	java/io/InputStream:read	([B)I
    //   41: istore_1
    //   42: iload_1
    //   43: iflt +26 -> 69
    //   46: aload_2
    //   47: aload_3
    //   48: iconst_0
    //   49: iload_1
    //   50: invokevirtual 364	java/security/MessageDigest:update	([BII)V
    //   53: goto -17 -> 36
    //   56: astore_2
    //   57: aload_0
    //   58: invokestatic 250	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   61: sipush 13301
    //   64: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aconst_null
    //   68: areturn
    //   69: aload_2
    //   70: invokevirtual 367	java/security/MessageDigest:digest	()[B
    //   73: astore_2
    //   74: aload_0
    //   75: invokestatic 250	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   78: sipush 13301
    //   81: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_2
    //   85: areturn
    //   86: astore_0
    //   87: aconst_null
    //   88: astore_2
    //   89: aload_2
    //   90: invokestatic 250	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   93: sipush 13301
    //   96: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_0
    //   100: athrow
    //   101: astore_2
    //   102: aload_0
    //   103: astore_3
    //   104: aload_2
    //   105: astore_0
    //   106: aload_3
    //   107: astore_2
    //   108: goto -19 -> 89
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_0
    //   114: goto -57 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramString	String
    //   41	9	1	i	int
    //   29	18	2	localMessageDigest	java.security.MessageDigest
    //   56	14	2	localException	Exception
    //   73	17	2	arrayOfByte	byte[]
    //   101	4	2	localObject1	Object
    //   107	1	2	localObject2	Object
    //   35	72	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   23	36	56	java/lang/Exception
    //   36	42	56	java/lang/Exception
    //   46	53	56	java/lang/Exception
    //   69	74	56	java/lang/Exception
    //   18	23	86	finally
    //   23	36	101	finally
    //   36	42	101	finally
    //   46	53	101	finally
    //   69	74	101	finally
    //   18	23	111	java/lang/Exception
  }
  
  public static InputStream ai(e parame)
  {
    AppMethodBeat.i(13265);
    parame = b(parame.mUri, parame.fOH());
    AppMethodBeat.o(13265);
    return parame;
  }
  
  public static OutputStream aj(e parame)
  {
    AppMethodBeat.i(13268);
    parame = a(parame.mUri, parame.fOH(), false);
    AppMethodBeat.o(13268);
    return parame;
  }
  
  public static InputStream b(Uri paramUri, a.e parame)
  {
    AppMethodBeat.i(13266);
    parame = a.gzU().a(paramUri, parame);
    if (!parame.valid())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(13266);
      throw paramUri;
    }
    paramUri = parame.LjM.openRead(parame.path);
    AppMethodBeat.o(13266);
    return paramUri;
  }
  
  public static boolean bb(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(13289);
    boolean bool = mA(paramString1 + paramString2, paramString1 + paramString3);
    AppMethodBeat.o(13289);
    return bool;
  }
  
  public static ReadableByteChannel c(Uri paramUri, a.e parame)
  {
    AppMethodBeat.i(170165);
    parame = a.gzU().a(paramUri, parame);
    if (!parame.valid())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(170165);
      throw paramUri;
    }
    paramUri = parame.LjM.aYb(parame.path);
    AppMethodBeat.o(170165);
    return paramUri;
  }
  
  public static OutputStream cX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13269);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = new FileNotFoundException("path is empty");
      AppMethodBeat.o(13269);
      throw paramString;
    }
    paramString = a(q.parseUri(paramString), null, paramBoolean);
    AppMethodBeat.o(13269);
    return paramString;
  }
  
  public static boolean cZ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13296);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(13296);
      return false;
    }
    paramString = q.parseUri(paramString);
    paramString = a.gzU().a(paramString, null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(13296);
      return false;
    }
    paramBoolean = paramString.LjM.cZ(paramString.path, paramBoolean);
    AppMethodBeat.o(13296);
    return paramBoolean;
  }
  
  public static boolean cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13294);
    Object localObject1 = q.parseUri(paramString1);
    localObject1 = a.gzU().a((Uri)localObject1, null);
    paramString2 = q.parseUri(paramString2);
    paramString2 = a.gzU().a(paramString2, null);
    if ((((a.e)localObject1).valid()) && (paramString2.valid()))
    {
      Object localObject3 = ((a.e)localObject1).LjM;
      Object localObject2 = paramString2.LjM;
      if (((((FileSystem)localObject3).fOp() & 0xA) == 10) && ((((FileSystem)localObject2).fOp() & 0xA) == 10))
      {
        localObject3 = ((FileSystem)localObject3).da(((a.e)localObject1).path, false);
        localObject2 = ((FileSystem)localObject2).da(paramString2.path, true);
        if ((localObject3 != null) && (localObject2 != null) && (new File((String)localObject3).renameTo(new File((String)localObject2))))
        {
          AppMethodBeat.o(13294);
          return true;
        }
      }
    }
    if ((a((a.e)localObject1, paramString2, true)) && (cZ(paramString1, false)))
    {
      AppMethodBeat.o(13294);
      return true;
    }
    AppMethodBeat.o(13294);
    return false;
  }
  
  public static OutputStream d(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(170167);
    parame = a(parame.mUri, parame.fOH(), paramBoolean);
    AppMethodBeat.o(170167);
    return parame;
  }
  
  public static WritableByteChannel d(Uri paramUri, a.e parame)
  {
    AppMethodBeat.i(190392);
    parame = a.gzU().a(paramUri, parame);
    if (!parame.valid())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(190392);
      throw paramUri;
    }
    paramUri = parame.LjM.cW(parame.path, false);
    AppMethodBeat.o(190392);
    return paramUri;
  }
  
  public static RandomAccessFile dd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13272);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = new FileNotFoundException("path is empty");
      AppMethodBeat.o(13272);
      throw paramString;
    }
    paramString = a(q.parseUri(paramString), paramBoolean);
    AppMethodBeat.o(13272);
    return paramString;
  }
  
  public static Iterable<FileSystem.a> de(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13291);
    paramString = q.parseUri(paramString);
    paramString = a.gzU().a(paramString, null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(13291);
      return null;
    }
    paramString = paramString.LjM.cY(paramString.path, paramBoolean);
    AppMethodBeat.o(13291);
    return paramString;
  }
  
  public static boolean deleteDir(String paramString)
  {
    AppMethodBeat.i(221183);
    boolean bool = cZ(paramString, true);
    AppMethodBeat.o(221183);
    return bool;
  }
  
  public static boolean deleteFile(String paramString)
  {
    AppMethodBeat.i(13288);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(13288);
      return false;
    }
    boolean bool = new e(paramString).delete();
    AppMethodBeat.o(13288);
    return bool;
  }
  
  public static int e(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(13277);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramArrayOfByte.length < paramInt + 0))
    {
      AppMethodBeat.o(13277);
      return -2;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      OutputStream localOutputStream = cX(paramString, true);
      localObject1 = localOutputStream;
      localObject2 = localOutputStream;
      localOutputStream.write(paramArrayOfByte, 0, paramInt);
      return 0;
    }
    catch (Exception localException)
    {
      localObject2 = localObject1;
      Log.w("MicroMsg.VFSFileOp", localException, "");
      localObject2 = localObject1;
      Log.w("MicroMsg.VFSFileOp", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", new Object[] { localException.getClass().getSimpleName(), localException.getMessage(), paramString, Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(0), Integer.valueOf(paramInt) });
      return -1;
    }
    finally
    {
      q.closeQuietly(localObject2);
      AppMethodBeat.o(13277);
    }
  }
  
  public static int f(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(13283);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(13283);
      return -2;
    }
    if (paramArrayOfByte.length < paramInt + 0)
    {
      AppMethodBeat.o(13283);
      return -3;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      OutputStream localOutputStream = cX(paramString, false);
      localObject1 = localOutputStream;
      localObject2 = localOutputStream;
      localOutputStream.write(paramArrayOfByte, 0, paramInt);
      return 0;
    }
    catch (IOException paramArrayOfByte)
    {
      localObject2 = localObject1;
      Log.e("MicroMsg.VFSFileOp", "writeFile '%s' Failed: %s", new Object[] { paramString, paramArrayOfByte.getMessage() });
      return -1;
    }
    finally
    {
      q.closeQuietly(localObject2);
      AppMethodBeat.o(13283);
    }
  }
  
  public static boolean fv(String paramString)
  {
    AppMethodBeat.i(13287);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13287);
      return false;
    }
    paramString = q.parseUri(paramString);
    paramString = a.gzU().a(paramString, null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(13287);
      return false;
    }
    boolean bool = paramString.LjM.aYe(paramString.path);
    AppMethodBeat.o(13287);
    return bool;
  }
  
  /* Error */
  public static int fz(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 13303
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 460	java/util/zip/ZipInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokestatic 225	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: invokespecial 461	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_3
    //   18: aload_3
    //   19: astore_0
    //   20: aload_3
    //   21: invokevirtual 465	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   24: astore 4
    //   26: aload 4
    //   28: ifnull +254 -> 282
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
    //   70: invokevirtual 477	java/util/zip/ZipEntry:isDirectory	()Z
    //   73: ifeq +83 -> 156
    //   76: aload_3
    //   77: astore_0
    //   78: aload 5
    //   80: iconst_0
    //   81: aload 5
    //   83: invokevirtual 36	java/lang/String:length	()I
    //   86: iconst_1
    //   87: isub
    //   88: invokevirtual 179	java/lang/String:substring	(II)Ljava/lang/String;
    //   91: astore 4
    //   93: aload_3
    //   94: astore_0
    //   95: new 40	com/tencent/mm/vfs/e
    //   98: dup
    //   99: new 164	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   106: aload_1
    //   107: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 159
    //   112: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 4
    //   117: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokespecial 44	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   126: invokevirtual 278	com/tencent/mm/vfs/e:mkdirs	()Z
    //   129: pop
    //   130: goto -112 -> 18
    //   133: astore_1
    //   134: aload_3
    //   135: astore_0
    //   136: ldc 190
    //   138: aload_1
    //   139: ldc 38
    //   141: invokestatic 198	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   144: aload_3
    //   145: invokestatic 250	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   148: sipush 13303
    //   151: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: iconst_m1
    //   155: ireturn
    //   156: aload_3
    //   157: astore_0
    //   158: new 40	com/tencent/mm/vfs/e
    //   161: dup
    //   162: new 164	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   169: aload_1
    //   170: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc 159
    //   175: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 5
    //   180: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokespecial 44	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   189: invokestatic 479	com/tencent/mm/vfs/i:aj	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   192: astore 4
    //   194: aload_3
    //   195: astore_0
    //   196: sipush 1024
    //   199: newarray byte
    //   201: astore 5
    //   203: aload_3
    //   204: astore_0
    //   205: aload_3
    //   206: aload 5
    //   208: invokevirtual 480	java/util/zip/ZipInputStream:read	([B)I
    //   211: istore_2
    //   212: iload_2
    //   213: iconst_m1
    //   214: if_icmpeq +41 -> 255
    //   217: aload_3
    //   218: astore_0
    //   219: aload 4
    //   221: aload 5
    //   223: iconst_0
    //   224: iload_2
    //   225: invokevirtual 436	java/io/OutputStream:write	([BII)V
    //   228: goto -25 -> 203
    //   231: astore_1
    //   232: aload_3
    //   233: astore_0
    //   234: ldc 190
    //   236: aload_1
    //   237: ldc 38
    //   239: invokestatic 198	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   242: aload_3
    //   243: invokestatic 250	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   246: sipush 13303
    //   249: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: bipush 254
    //   254: ireturn
    //   255: aload_3
    //   256: astore_0
    //   257: aload 4
    //   259: invokevirtual 348	java/io/OutputStream:close	()V
    //   262: goto -244 -> 18
    //   265: astore_3
    //   266: aload_0
    //   267: astore_1
    //   268: aload_3
    //   269: astore_0
    //   270: aload_1
    //   271: invokestatic 250	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   274: sipush 13303
    //   277: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: aload_0
    //   281: athrow
    //   282: aload_3
    //   283: invokestatic 250	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   286: sipush 13303
    //   289: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: iconst_0
    //   293: ireturn
    //   294: astore_0
    //   295: aconst_null
    //   296: astore_1
    //   297: goto -27 -> 270
    //   300: astore_1
    //   301: aconst_null
    //   302: astore_3
    //   303: goto -71 -> 232
    //   306: astore_1
    //   307: aconst_null
    //   308: astore_3
    //   309: goto -175 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramString1	String
    //   0	312	1	paramString2	String
    //   211	14	2	i	int
    //   17	239	3	localZipInputStream	java.util.zip.ZipInputStream
    //   265	18	3	localCloseable	java.io.Closeable
    //   302	7	3	localObject1	Object
    //   24	234	4	localObject2	Object
    //   38	184	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	26	133	java/io/FileNotFoundException
    //   33	40	133	java/io/FileNotFoundException
    //   42	53	133	java/io/FileNotFoundException
    //   55	66	133	java/io/FileNotFoundException
    //   68	76	133	java/io/FileNotFoundException
    //   78	93	133	java/io/FileNotFoundException
    //   95	130	133	java/io/FileNotFoundException
    //   158	194	133	java/io/FileNotFoundException
    //   196	203	133	java/io/FileNotFoundException
    //   205	212	133	java/io/FileNotFoundException
    //   219	228	133	java/io/FileNotFoundException
    //   257	262	133	java/io/FileNotFoundException
    //   20	26	231	java/io/IOException
    //   33	40	231	java/io/IOException
    //   42	53	231	java/io/IOException
    //   55	66	231	java/io/IOException
    //   68	76	231	java/io/IOException
    //   78	93	231	java/io/IOException
    //   95	130	231	java/io/IOException
    //   158	194	231	java/io/IOException
    //   196	203	231	java/io/IOException
    //   205	212	231	java/io/IOException
    //   219	228	231	java/io/IOException
    //   257	262	231	java/io/IOException
    //   20	26	265	finally
    //   33	40	265	finally
    //   42	53	265	finally
    //   55	66	265	finally
    //   68	76	265	finally
    //   78	93	265	finally
    //   95	130	265	finally
    //   136	144	265	finally
    //   158	194	265	finally
    //   196	203	265	finally
    //   205	212	265	finally
    //   219	228	265	finally
    //   234	242	265	finally
    //   257	262	265	finally
    //   6	18	294	finally
    //   6	18	300	java/io/IOException
    //   6	18	306	java/io/FileNotFoundException
  }
  
  public static String k(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13276);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13276);
      return null;
    }
    paramString = q.b(q.parseUri(paramString), paramBoolean);
    AppMethodBeat.o(13276);
    return paramString;
  }
  
  public static boolean mA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13290);
    if ((paramString1 == null) || (paramString2 == null) || (paramString1.length() == 0) || (paramString2.length() == 0))
    {
      AppMethodBeat.o(13290);
      return false;
    }
    a.e locale1 = a.gzU().a(q.parseUri(paramString1), null);
    a.e locale2 = a.gzU().a(q.parseUri(paramString2), null);
    if ((!locale1.valid()) || (!locale2.valid()))
    {
      AppMethodBeat.o(13290);
      return false;
    }
    try
    {
      boolean bool1 = locale2.LjM.a(locale2.path, locale1.LjM, locale1.path);
      boolean bool2 = bool1;
      if (!bool1) {
        if (locale2.LjM.c(locale2.path, locale1.LjM, locale1.path) < 0L) {
          break label182;
        }
      }
      label182:
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1)
        {
          locale1.LjM.CA(locale1.path);
          bool2 = bool1;
        }
        AppMethodBeat.o(13290);
        return bool2;
      }
      return false;
    }
    catch (IOException localIOException)
    {
      Log.w("MicroMsg.VFSFileOp", "Failed to move file " + paramString1 + " -> " + paramString2 + ": " + localIOException.getMessage());
      AppMethodBeat.o(13290);
    }
  }
  
  public static boolean mB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13293);
    paramString1 = q.parseUri(paramString1);
    paramString1 = a.gzU().a(paramString1, null);
    paramString2 = q.parseUri(paramString2);
    boolean bool = a(paramString1, a.gzU().a(paramString2, null), false);
    AppMethodBeat.o(13293);
    return bool;
  }
  
  public static boolean mC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(170171);
    if ((paramString1 == null) || (paramString1.isEmpty()))
    {
      AppMethodBeat.o(170171);
      return false;
    }
    boolean bool = u(Collections.singletonList(paramString1), paramString2);
    AppMethodBeat.o(170171);
    return bool;
  }
  
  public static ParcelFileDescriptor my(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13274);
    if ((paramString1 == null) || (paramString1.isEmpty()))
    {
      paramString1 = new FileNotFoundException("path is empty");
      AppMethodBeat.o(13274);
      throw paramString1;
    }
    paramString1 = a(q.parseUri(paramString1), null, paramString2);
    AppMethodBeat.o(13274);
    return paramString1;
  }
  
  public static long mz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13286);
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
    {
      AppMethodBeat.o(13286);
      return -1L;
    }
    if (paramString1.equals(paramString2))
    {
      AppMethodBeat.o(13286);
      return -1L;
    }
    a.e locale1 = a.gzU().a(q.parseUri(paramString1), null);
    a.e locale2 = a.gzU().a(q.parseUri(paramString2), null);
    if ((!locale1.valid()) || (!locale2.valid()))
    {
      AppMethodBeat.o(13286);
      return -1L;
    }
    try
    {
      long l = locale2.LjM.c(locale2.path, locale1.LjM, locale1.path);
      AppMethodBeat.o(13286);
      return l;
    }
    catch (IOException localIOException)
    {
      Log.w("MicroMsg.VFSFileOp", "Failed to copy file " + paramString1 + " -> " + paramString2 + ": " + localIOException.getMessage());
      AppMethodBeat.o(13286);
    }
    return -1L;
  }
  
  public static InputStream openRead(String paramString)
  {
    AppMethodBeat.i(13264);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = new FileNotFoundException("path is empty");
      AppMethodBeat.o(13264);
      throw paramString;
    }
    paramString = b(q.parseUri(paramString), null);
    AppMethodBeat.o(13264);
    return paramString;
  }
  
  /* Error */
  public static boolean u(java.util.List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: sipush 13304
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: invokevirtual 286	java/lang/String:isEmpty	()Z
    //   14: ifeq +11 -> 25
    //   17: sipush 13304
    //   20: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_1
    //   26: invokestatic 517	com/tencent/mm/vfs/i:aYr	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokestatic 518	com/tencent/mm/vfs/i:aYg	(Ljava/lang/String;)Z
    //   32: pop
    //   33: sipush 4096
    //   36: newarray byte
    //   38: astore 5
    //   40: new 520	java/util/zip/ZipOutputStream
    //   43: dup
    //   44: aload_1
    //   45: iconst_0
    //   46: invokestatic 28	com/tencent/mm/vfs/i:cX	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   49: invokespecial 523	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   52: astore 4
    //   54: aload_0
    //   55: invokeinterface 526 1 0
    //   60: astore 6
    //   62: aload 6
    //   64: invokeinterface 148 1 0
    //   69: ifeq +305 -> 374
    //   72: aload 6
    //   74: invokeinterface 152 1 0
    //   79: checkcast 32	java/lang/String
    //   82: invokestatic 290	com/tencent/mm/vfs/q:parseUri	(Ljava/lang/String;)Landroid/net/Uri;
    //   85: astore_0
    //   86: invokestatic 64	com/tencent/mm/vfs/a:gzU	()Lcom/tencent/mm/vfs/a;
    //   89: aload_0
    //   90: aconst_null
    //   91: invokevirtual 67	com/tencent/mm/vfs/a:a	(Landroid/net/Uri;Lcom/tencent/mm/vfs/a$e;)Lcom/tencent/mm/vfs/a$e;
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 73	com/tencent/mm/vfs/a$e:valid	()Z
    //   99: ifeq -37 -> 62
    //   102: aload_0
    //   103: getfield 89	com/tencent/mm/vfs/a$e:LjM	Lcom/tencent/mm/vfs/FileSystem;
    //   106: aload_0
    //   107: getfield 93	com/tencent/mm/vfs/a$e:path	Ljava/lang/String;
    //   110: invokeinterface 294 2 0
    //   115: astore_1
    //   116: aload_1
    //   117: ifnull -55 -> 62
    //   120: aload_1
    //   121: getfield 176	com/tencent/mm/vfs/FileSystem$a:LjL	Z
    //   124: ifeq +190 -> 314
    //   127: aload_0
    //   128: getfield 93	com/tencent/mm/vfs/a$e:path	Ljava/lang/String;
    //   131: invokevirtual 36	java/lang/String:length	()I
    //   134: istore_3
    //   135: aload_0
    //   136: getfield 93	com/tencent/mm/vfs/a$e:path	Ljava/lang/String;
    //   139: ldc 159
    //   141: invokevirtual 529	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   144: ifeq +165 -> 309
    //   147: iconst_0
    //   148: istore_2
    //   149: aload_0
    //   150: getfield 89	com/tencent/mm/vfs/a$e:LjM	Lcom/tencent/mm/vfs/FileSystem;
    //   153: aload_0
    //   154: getfield 93	com/tencent/mm/vfs/a$e:path	Ljava/lang/String;
    //   157: iconst_1
    //   158: invokeinterface 124 3 0
    //   163: astore_0
    //   164: aload_0
    //   165: ifnull -103 -> 62
    //   168: iload_2
    //   169: iload_3
    //   170: iadd
    //   171: istore_2
    //   172: aload_0
    //   173: invokeinterface 143 1 0
    //   178: astore 7
    //   180: aload 7
    //   182: invokeinterface 148 1 0
    //   187: ifeq -125 -> 62
    //   190: aload 7
    //   192: invokeinterface 152 1 0
    //   197: checkcast 154	com/tencent/mm/vfs/FileSystem$a
    //   200: astore_0
    //   201: aload_0
    //   202: getfield 176	com/tencent/mm/vfs/FileSystem$a:LjL	Z
    //   205: ifne -25 -> 180
    //   208: aload_0
    //   209: getfield 157	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   212: invokevirtual 36	java/lang/String:length	()I
    //   215: iload_2
    //   216: if_icmpge +120 -> 336
    //   219: aload_0
    //   220: getfield 532	com/tencent/mm/vfs/FileSystem$a:name	Ljava/lang/String;
    //   223: astore_1
    //   224: aload_0
    //   225: getfield 180	com/tencent/mm/vfs/FileSystem$a:LjM	Lcom/tencent/mm/vfs/FileSystem;
    //   228: aload_0
    //   229: getfield 157	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   232: invokeinterface 385 2 0
    //   237: astore_0
    //   238: aload 4
    //   240: new 467	java/util/zip/ZipEntry
    //   243: dup
    //   244: aload_1
    //   245: invokespecial 533	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   248: invokevirtual 537	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   251: aload_0
    //   252: aload 5
    //   254: invokevirtual 361	java/io/InputStream:read	([B)I
    //   257: istore_3
    //   258: iload_3
    //   259: iflt +89 -> 348
    //   262: aload 4
    //   264: aload 5
    //   266: iconst_0
    //   267: iload_3
    //   268: invokevirtual 538	java/util/zip/ZipOutputStream:write	([BII)V
    //   271: goto -20 -> 251
    //   274: astore 5
    //   276: aload 4
    //   278: astore_1
    //   279: aload 5
    //   281: astore 4
    //   283: ldc 190
    //   285: aload 4
    //   287: ldc_w 540
    //   290: invokestatic 198	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   293: aload_0
    //   294: invokestatic 250	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   297: aload_1
    //   298: invokestatic 250	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   301: sipush 13304
    //   304: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: iconst_0
    //   308: ireturn
    //   309: iconst_1
    //   310: istore_2
    //   311: goto -162 -> 149
    //   314: aload_0
    //   315: getfield 93	com/tencent/mm/vfs/a$e:path	Ljava/lang/String;
    //   318: bipush 47
    //   320: invokevirtual 52	java/lang/String:lastIndexOf	(I)I
    //   323: istore_2
    //   324: aload_1
    //   325: invokestatic 499	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   328: astore_0
    //   329: iload_2
    //   330: iconst_1
    //   331: iadd
    //   332: istore_2
    //   333: goto -161 -> 172
    //   336: aload_0
    //   337: getfield 157	com/tencent/mm/vfs/FileSystem$a:HZk	Ljava/lang/String;
    //   340: iload_2
    //   341: invokevirtual 56	java/lang/String:substring	(I)Ljava/lang/String;
    //   344: astore_1
    //   345: goto -121 -> 224
    //   348: aload_0
    //   349: invokevirtual 541	java/io/InputStream:close	()V
    //   352: aload 4
    //   354: invokevirtual 544	java/util/zip/ZipOutputStream:closeEntry	()V
    //   357: goto -177 -> 180
    //   360: astore 5
    //   362: aload 4
    //   364: astore_1
    //   365: aconst_null
    //   366: astore_0
    //   367: aload 5
    //   369: astore 4
    //   371: goto -88 -> 283
    //   374: aconst_null
    //   375: invokestatic 250	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   378: aload 4
    //   380: invokestatic 250	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   383: sipush 13304
    //   386: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   389: iconst_1
    //   390: ireturn
    //   391: astore_1
    //   392: aconst_null
    //   393: astore 4
    //   395: aconst_null
    //   396: astore_0
    //   397: aload_0
    //   398: invokestatic 250	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   401: aload 4
    //   403: invokestatic 250	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   406: sipush 13304
    //   409: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   412: aload_1
    //   413: athrow
    //   414: astore_1
    //   415: aconst_null
    //   416: astore_0
    //   417: goto -20 -> 397
    //   420: astore_1
    //   421: goto -24 -> 397
    //   424: astore 5
    //   426: aload_1
    //   427: astore 4
    //   429: aload 5
    //   431: astore_1
    //   432: goto -35 -> 397
    //   435: astore 4
    //   437: aconst_null
    //   438: astore_1
    //   439: aconst_null
    //   440: astore_0
    //   441: goto -158 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	paramList	java.util.List<String>
    //   0	444	1	paramString	String
    //   148	193	2	i	int
    //   134	134	3	j	int
    //   52	376	4	localObject1	Object
    //   435	1	4	localIOException1	IOException
    //   38	227	5	arrayOfByte	byte[]
    //   274	6	5	localIOException2	IOException
    //   360	8	5	localIOException3	IOException
    //   424	6	5	localObject2	Object
    //   60	13	6	localIterator1	Iterator
    //   178	13	7	localIterator2	Iterator
    // Exception table:
    //   from	to	target	type
    //   238	251	274	java/io/IOException
    //   251	258	274	java/io/IOException
    //   262	271	274	java/io/IOException
    //   348	352	274	java/io/IOException
    //   54	62	360	java/io/IOException
    //   62	116	360	java/io/IOException
    //   120	147	360	java/io/IOException
    //   149	164	360	java/io/IOException
    //   172	180	360	java/io/IOException
    //   180	224	360	java/io/IOException
    //   224	238	360	java/io/IOException
    //   314	329	360	java/io/IOException
    //   336	345	360	java/io/IOException
    //   352	357	360	java/io/IOException
    //   40	54	391	finally
    //   54	62	414	finally
    //   62	116	414	finally
    //   120	147	414	finally
    //   149	164	414	finally
    //   172	180	414	finally
    //   180	224	414	finally
    //   224	238	414	finally
    //   314	329	414	finally
    //   336	345	414	finally
    //   352	357	414	finally
    //   238	251	420	finally
    //   251	258	420	finally
    //   262	271	420	finally
    //   348	352	420	finally
    //   283	293	424	finally
    //   40	54	435	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.i
 * JD-Core Version:    0.7.0.1
 */