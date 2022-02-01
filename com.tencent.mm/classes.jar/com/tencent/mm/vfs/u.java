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

public final class u
{
  public static int F(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(236912);
    int i = e(paramString, paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(236912);
    return i;
  }
  
  public static int H(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(185725);
    int i = f(paramString, paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(185725);
    return i;
  }
  
  public static long H(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(236920);
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
    {
      AppMethodBeat.o(236920);
      return -1L;
    }
    if (paramString1.equals(paramString2))
    {
      AppMethodBeat.o(236920);
      return -1L;
    }
    h.e locale1 = h.iWH().a(ad.parseUri(paramString1), null);
    h.e locale2 = h.iWH().a(ad.parseUri(paramString2), null);
    if ((!locale1.fCF()) || (!locale2.fCF()))
    {
      AppMethodBeat.o(236920);
      return -1L;
    }
    try
    {
      long l = locale2.YCO.a(locale2.path, locale1.YCO, locale1.path, paramBoolean);
      AppMethodBeat.o(236920);
      return l;
    }
    catch (IOException localIOException)
    {
      Log.w("MicroMsg.VFSFileOp", "Failed to copy file " + paramString1 + " -> " + paramString2 + ": " + localIOException.getMessage());
      AppMethodBeat.o(236920);
    }
    return -1L;
  }
  
  public static OutputStream Te(String paramString)
  {
    AppMethodBeat.i(185724);
    paramString = dI(paramString, false);
    AppMethodBeat.o(185724);
    return paramString;
  }
  
  public static InputStream Tf(String paramString)
  {
    AppMethodBeat.i(13264);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = new FileNotFoundException("path is empty");
      AppMethodBeat.o(13264);
      throw paramString;
    }
    paramString = b(ad.parseUri(paramString), null);
    AppMethodBeat.o(13264);
    return paramString;
  }
  
  private static ParcelFileDescriptor a(Uri paramUri, h.e parame, String paramString)
  {
    AppMethodBeat.i(13275);
    parame = h.iWH().a(paramUri, parame);
    if (!parame.fCF())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(13275);
      throw paramUri;
    }
    paramUri = parame.YCO.oh(parame.path, paramString);
    AppMethodBeat.o(13275);
    return paramUri;
  }
  
  static OutputStream a(Uri paramUri, h.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(13271);
    parame = h.iWH().a(paramUri, parame);
    if (!parame.fCF())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(13271);
      throw paramUri;
    }
    paramUri = parame.YCO.dI(parame.path, paramBoolean);
    AppMethodBeat.o(13271);
    return paramUri;
  }
  
  public static RandomAccessFile a(Uri paramUri, boolean paramBoolean)
  {
    AppMethodBeat.i(13273);
    String str = ad.b(paramUri, paramBoolean);
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
  
  private static boolean a(h.e parame1, h.e parame2, boolean paramBoolean)
  {
    AppMethodBeat.i(13292);
    if ((!parame1.fCF()) || (!parame2.fCF()))
    {
      AppMethodBeat.o(13292);
      return false;
    }
    Object localObject = parame1.YCO.dJ(parame1.path, true);
    if (localObject == null)
    {
      AppMethodBeat.o(13292);
      return false;
    }
    HashSet localHashSet = new HashSet();
    parame2.YCO.bBD(parame2.path);
    localHashSet.add(parame2.path);
    Iterator localIterator = ((Iterable)localObject).iterator();
    f localf;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label374;
      }
      localf = (f)localIterator.next();
      int i = parame1.path.length();
      String str = localf.UUr.substring(i);
      localObject = str;
      if (!str.startsWith("/")) {
        localObject = "/".concat(String.valueOf(str));
      }
      localObject = parame2.path + (String)localObject;
      if (localf.YCj)
      {
        if (localHashSet.add(localObject)) {
          parame2.YCO.bBD((String)localObject);
        }
      }
      else
      {
        i = ((String)localObject).lastIndexOf('/');
        if (i > 0)
        {
          str = ((String)localObject).substring(0, i);
          if (localHashSet.add(str)) {
            parame2.YCO.bBD(str);
          }
        }
        if (paramBoolean) {
          try
          {
            parame2.YCO.a((String)localObject, localf.YCk, localf.UUr);
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
      parame2.YCO.a((String)localObject, localf.YCk, localf.UUr, false);
      break;
    }
    label374:
    AppMethodBeat.o(13292);
    return true;
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
    //   23: ldc 236
    //   25: if_icmple +262 -> 287
    //   28: sipush 4096
    //   31: istore_3
    //   32: new 238	java/io/ByteArrayOutputStream
    //   35: dup
    //   36: iload_3
    //   37: invokespecial 240	java/io/ByteArrayOutputStream:<init>	(I)V
    //   40: astore 8
    //   42: aload_0
    //   43: invokestatic 242	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
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
    //   69: invokevirtual 248	java/io/InputStream:skip	(J)J
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
    //   95: ldc 249
    //   97: istore_1
    //   98: aload 7
    //   100: astore 6
    //   102: aload 7
    //   104: aload 9
    //   106: iconst_0
    //   107: iload_1
    //   108: sipush 1024
    //   111: invokestatic 255	java/lang/Math:min	(II)I
    //   114: invokevirtual 259	java/io/InputStream:read	([BII)I
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
    //   137: invokevirtual 263	java/io/ByteArrayOutputStream:write	([BII)V
    //   140: iload_1
    //   141: iload_2
    //   142: isub
    //   143: istore_1
    //   144: goto -46 -> 98
    //   147: aload 7
    //   149: invokestatic 267	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   152: aload 8
    //   154: invokevirtual 271	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   157: astore 6
    //   159: aload 8
    //   161: invokevirtual 274	java/io/ByteArrayOutputStream:close	()V
    //   164: ldc 79
    //   166: ldc_w 276
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
    //   182: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: aastore
    //   186: invokestatic 285	com/tencent/stubs/logger/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: sipush 13280
    //   192: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: aload 6
    //   197: areturn
    //   198: astore 8
    //   200: aconst_null
    //   201: astore 7
    //   203: aload 7
    //   205: astore 6
    //   207: ldc 79
    //   209: new 81	java/lang/StringBuilder
    //   212: dup
    //   213: ldc_w 287
    //   216: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   219: aload_0
    //   220: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: ldc_w 289
    //   226: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload 8
    //   231: invokevirtual 99	java/io/IOException:getMessage	()Ljava/lang/String;
    //   234: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 108	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload 7
    //   245: invokestatic 267	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   248: sipush 13280
    //   251: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: aconst_null
    //   255: areturn
    //   256: astore_0
    //   257: aconst_null
    //   258: astore 6
    //   260: aload 6
    //   262: invokestatic 267	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
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
  
  public static boolean agG(String paramString)
  {
    AppMethodBeat.i(13287);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13287);
      return false;
    }
    paramString = ad.parseUri(paramString);
    paramString = h.iWH().a(paramString, null);
    if (!paramString.fCF())
    {
      AppMethodBeat.o(13287);
      return false;
    }
    boolean bool = paramString.YCO.bBB(paramString.path);
    AppMethodBeat.o(13287);
    return bool;
  }
  
  public static InputStream al(q paramq)
  {
    AppMethodBeat.i(13265);
    paramq = b(paramq.mUri, paramq.ify());
    AppMethodBeat.o(13265);
    return paramq;
  }
  
  public static ReadableByteChannel am(q paramq)
  {
    AppMethodBeat.i(236904);
    paramq = c(paramq.mUri, paramq.ify());
    AppMethodBeat.o(236904);
    return paramq;
  }
  
  public static OutputStream an(q paramq)
  {
    AppMethodBeat.i(13268);
    paramq = a(paramq.mUri, paramq.ify(), false);
    AppMethodBeat.o(13268);
    return paramq;
  }
  
  public static WritableByteChannel ao(q paramq)
  {
    AppMethodBeat.i(236908);
    paramq = d(paramq.mUri, paramq.ify());
    AppMethodBeat.o(236908);
    return paramq;
  }
  
  public static String asq(String paramString)
  {
    AppMethodBeat.i(13298);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(13298);
      return "";
    }
    paramString = new q(paramString).getName();
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
  
  public static ParcelFileDescriptor b(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(236910);
    paramUri = a(paramUri, null, paramString);
    AppMethodBeat.o(236910);
    return paramUri;
  }
  
  static InputStream b(Uri paramUri, h.e parame)
  {
    AppMethodBeat.i(13266);
    parame = h.iWH().a(paramUri, parame);
    if (!parame.fCF())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(13266);
      throw paramUri;
    }
    paramUri = parame.YCO.Tf(parame.path);
    AppMethodBeat.o(13266);
    return paramUri;
  }
  
  public static boolean bBD(String paramString)
  {
    AppMethodBeat.i(13285);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(13285);
      return false;
    }
    paramString = new q(paramString);
    if ((paramString.ifL()) || (paramString.isDirectory()))
    {
      AppMethodBeat.o(13285);
      return true;
    }
    AppMethodBeat.o(13285);
    return false;
  }
  
  public static WritableByteChannel bBP(String paramString)
  {
    AppMethodBeat.i(236907);
    paramString = d(ad.parseUri(paramString), null);
    AppMethodBeat.o(236907);
    return paramString;
  }
  
  public static long bBQ(String paramString)
  {
    AppMethodBeat.i(13278);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13278);
      return 0L;
    }
    paramString = ad.parseUri(paramString);
    paramString = h.iWH().a(paramString, null);
    if (!paramString.fCF())
    {
      AppMethodBeat.o(13278);
      return 0L;
    }
    paramString = paramString.YCO.bBC(paramString.path);
    if (paramString == null)
    {
      AppMethodBeat.o(13278);
      return 0L;
    }
    long l = paramString.size;
    AppMethodBeat.o(13278);
    return l;
  }
  
  public static long bBR(String paramString)
  {
    AppMethodBeat.i(13279);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13279);
      return 0L;
    }
    paramString = ad.parseUri(paramString);
    paramString = h.iWH().a(paramString, null);
    if (!paramString.fCF())
    {
      AppMethodBeat.o(13279);
      return 0L;
    }
    paramString = paramString.YCO.bBC(paramString.path);
    if (paramString == null)
    {
      AppMethodBeat.o(13279);
      return 0L;
    }
    long l = paramString.YCi;
    AppMethodBeat.o(13279);
    return l;
  }
  
  /* Error */
  public static String bBS(String paramString)
  {
    // Byte code:
    //   0: sipush 13281
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 81	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: new 360	java/io/InputStreamReader
    //   18: dup
    //   19: aload_0
    //   20: invokestatic 242	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   23: invokespecial 363	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
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
    //   41: invokevirtual 366	java/io/InputStreamReader:read	([C)I
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
    //   58: invokevirtual 369	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -26 -> 36
    //   65: astore 4
    //   67: aload_3
    //   68: astore_2
    //   69: ldc 79
    //   71: ldc_w 371
    //   74: iconst_2
    //   75: anewarray 4	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: aload_0
    //   81: aastore
    //   82: dup
    //   83: iconst_1
    //   84: aload 4
    //   86: invokevirtual 99	java/io/IOException:getMessage	()Ljava/lang/String;
    //   89: aastore
    //   90: invokestatic 373	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   108: invokestatic 267	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   111: sipush 13281
    //   114: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_0
    //   118: athrow
    //   119: aload_3
    //   120: invokestatic 267	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   123: aload 4
    //   125: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
  
  public static String bBT(String paramString)
  {
    AppMethodBeat.i(13284);
    paramString = new q(paramString).ifG().ifA();
    AppMethodBeat.o(13284);
    return paramString;
  }
  
  public static f bBU(String paramString)
  {
    AppMethodBeat.i(236921);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(236921);
      return null;
    }
    paramString = ad.parseUri(paramString);
    paramString = h.iWH().a(paramString, null);
    if (!paramString.fCF())
    {
      AppMethodBeat.o(236921);
      return null;
    }
    paramString = paramString.YCO.bBC(paramString.path);
    AppMethodBeat.o(236921);
    return paramString;
  }
  
  public static boolean bBV(String paramString)
  {
    AppMethodBeat.i(13297);
    try
    {
      paramString = new q(paramString);
      if ((paramString.ifE()) || (paramString.ifM()))
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
  
  public static String bBW(String paramString)
  {
    AppMethodBeat.i(13299);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(13299);
      return "";
    }
    String str = new q(paramString).getName();
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
  
  public static void bBX(String paramString)
  {
    AppMethodBeat.i(13300);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13300);
      return;
    }
    paramString = ad.parseUri(paramString);
    paramString = h.iWH().a(paramString, null);
    if (!paramString.fCF())
    {
      AppMethodBeat.o(13300);
      return;
    }
    if ((paramString.YCO.ieY() & 0x2) == 0)
    {
      AppMethodBeat.o(13300);
      return;
    }
    if (paramString.YCO.dL(paramString.path, true) == null)
    {
      AppMethodBeat.o(13300);
      return;
    }
    try
    {
      paramString.YCO.dI(paramString.path + "/.nomedia", false).close();
      AppMethodBeat.o(13300);
      return;
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(13300);
    }
  }
  
  /* Error */
  public static byte[] bBY(String paramString)
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
    //   19: invokestatic 242	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore_0
    //   23: ldc_w 410
    //   26: invokestatic 416	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   29: astore_2
    //   30: sipush 2048
    //   33: newarray byte
    //   35: astore_3
    //   36: aload_0
    //   37: aload_3
    //   38: invokevirtual 419	java/io/InputStream:read	([B)I
    //   41: istore_1
    //   42: iload_1
    //   43: iflt +26 -> 69
    //   46: aload_2
    //   47: aload_3
    //   48: iconst_0
    //   49: iload_1
    //   50: invokevirtual 422	java/security/MessageDigest:update	([BII)V
    //   53: goto -17 -> 36
    //   56: astore_2
    //   57: aload_0
    //   58: invokestatic 267	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   61: sipush 13301
    //   64: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aconst_null
    //   68: areturn
    //   69: aload_2
    //   70: invokevirtual 425	java/security/MessageDigest:digest	()[B
    //   73: astore_2
    //   74: aload_0
    //   75: invokestatic 267	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   78: sipush 13301
    //   81: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_2
    //   85: areturn
    //   86: astore_0
    //   87: aconst_null
    //   88: astore_2
    //   89: aload_2
    //   90: invokestatic 267	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
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
  
  public static ReadableByteChannel bBy(String paramString)
  {
    AppMethodBeat.i(236902);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = new FileNotFoundException("path is empty");
      AppMethodBeat.o(236902);
      throw paramString;
    }
    paramString = c(ad.parseUri(paramString), null);
    AppMethodBeat.o(236902);
    return paramString;
  }
  
  public static boolean bj(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(13289);
    boolean bool = op(paramString1 + paramString2, paramString1 + paramString3);
    AppMethodBeat.o(13289);
    return bool;
  }
  
  public static String buc(String paramString)
  {
    AppMethodBeat.i(13302);
    paramString = bBY(paramString);
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
  
  private static ReadableByteChannel c(Uri paramUri, h.e parame)
  {
    AppMethodBeat.i(170165);
    parame = h.iWH().a(paramUri, parame);
    if (!parame.fCF())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(170165);
      throw paramUri;
    }
    paramUri = parame.YCO.bBy(parame.path);
    AppMethodBeat.o(170165);
    return paramUri;
  }
  
  private static WritableByteChannel d(Uri paramUri, h.e parame)
  {
    AppMethodBeat.i(236909);
    parame = h.iWH().a(paramUri, parame);
    if (!parame.fCF())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(236909);
      throw paramUri;
    }
    paramUri = parame.YCO.dH(parame.path, false);
    AppMethodBeat.o(236909);
    return paramUri;
  }
  
  public static OutputStream dI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13269);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = new FileNotFoundException("path is empty");
      AppMethodBeat.o(13269);
      throw paramString;
    }
    paramString = a(ad.parseUri(paramString), null, paramBoolean);
    AppMethodBeat.o(13269);
    return paramString;
  }
  
  public static boolean dK(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13296);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(13296);
      return false;
    }
    paramString = ad.parseUri(paramString);
    paramString = h.iWH().a(paramString, null);
    if (!paramString.fCF())
    {
      AppMethodBeat.o(13296);
      return false;
    }
    paramBoolean = paramString.YCO.dK(paramString.path, paramBoolean);
    AppMethodBeat.o(13296);
    return paramBoolean;
  }
  
  public static RandomAccessFile dO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13272);
    paramString = a(ad.parseUri(paramString), paramBoolean);
    AppMethodBeat.o(13272);
    return paramString;
  }
  
  public static Iterable<f> dP(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13291);
    paramString = ad.parseUri(paramString);
    paramString = h.iWH().a(paramString, null);
    if (!paramString.fCF())
    {
      AppMethodBeat.o(13291);
      return null;
    }
    paramString = paramString.YCO.dJ(paramString.path, paramBoolean);
    AppMethodBeat.o(13291);
    return paramString;
  }
  
  public static boolean deleteDir(String paramString)
  {
    AppMethodBeat.i(185726);
    boolean bool = dK(paramString, true);
    AppMethodBeat.o(185726);
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
    boolean bool = new q(paramString).cFq();
    AppMethodBeat.o(13288);
    return bool;
  }
  
  private static int e(String paramString, byte[] paramArrayOfByte, int paramInt)
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
      OutputStream localOutputStream = dI(paramString, true);
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
      ad.closeQuietly(localObject2);
      AppMethodBeat.o(13277);
    }
  }
  
  public static OutputStream e(q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(170167);
    paramq = a(paramq.mUri, paramq.ify(), paramBoolean);
    AppMethodBeat.o(170167);
    return paramq;
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
      OutputStream localOutputStream = dI(paramString, false);
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
      ad.closeQuietly(localObject2);
      AppMethodBeat.o(13283);
    }
  }
  
  /* Error */
  public static int gj(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 13303
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 489	java/util/zip/ZipInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokestatic 242	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: invokespecial 490	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_3
    //   18: aload_3
    //   19: astore_0
    //   20: new 165	java/util/HashSet
    //   23: dup
    //   24: invokespecial 168	java/util/HashSet:<init>	()V
    //   27: astore 4
    //   29: aload_3
    //   30: astore_0
    //   31: sipush 4096
    //   34: newarray byte
    //   36: astore 5
    //   38: aload_3
    //   39: astore_0
    //   40: aload_3
    //   41: invokevirtual 494	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   44: astore 7
    //   46: aload 7
    //   48: ifnull +328 -> 376
    //   51: aload_3
    //   52: astore_0
    //   53: aload 7
    //   55: invokevirtual 497	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   58: astore 6
    //   60: aload_3
    //   61: astore_0
    //   62: aload 6
    //   64: ldc_w 499
    //   67: invokevirtual 503	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   70: ifne -32 -> 38
    //   73: aload_3
    //   74: astore_0
    //   75: aload 6
    //   77: ldc_w 505
    //   80: invokevirtual 503	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   83: ifne -45 -> 38
    //   86: aload_3
    //   87: astore_0
    //   88: aload 7
    //   90: invokevirtual 506	java/util/zip/ZipEntry:isDirectory	()Z
    //   93: ifeq +96 -> 189
    //   96: aload_3
    //   97: astore_0
    //   98: aload 6
    //   100: iconst_0
    //   101: aload 6
    //   103: invokevirtual 36	java/lang/String:length	()I
    //   106: iconst_1
    //   107: isub
    //   108: invokevirtual 216	java/lang/String:substring	(II)Ljava/lang/String;
    //   111: astore 6
    //   113: aload_3
    //   114: astore_0
    //   115: aload 4
    //   117: aload 6
    //   119: invokevirtual 175	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   122: ifeq -84 -> 38
    //   125: aload_3
    //   126: astore_0
    //   127: new 297	com/tencent/mm/vfs/q
    //   130: dup
    //   131: new 81	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   138: aload_1
    //   139: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc 201
    //   144: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 6
    //   149: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokespecial 326	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   158: invokevirtual 337	com/tencent/mm/vfs/q:ifL	()Z
    //   161: pop
    //   162: goto -124 -> 38
    //   165: astore_1
    //   166: aload_3
    //   167: astore_0
    //   168: ldc 79
    //   170: aload_1
    //   171: ldc_w 325
    //   174: invokestatic 231	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   177: aload_3
    //   178: invokestatic 267	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   181: sipush 13303
    //   184: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: iconst_m1
    //   188: ireturn
    //   189: aload_3
    //   190: astore_0
    //   191: new 297	com/tencent/mm/vfs/q
    //   194: dup
    //   195: new 81	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   202: aload_1
    //   203: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 201
    //   208: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload 6
    //   213: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 326	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   222: astore 7
    //   224: aload_3
    //   225: astore_0
    //   226: aload 6
    //   228: invokestatic 509	com/tencent/mm/vfs/ad:bCc	(Ljava/lang/String;)Ljava/lang/String;
    //   231: astore 6
    //   233: aload 6
    //   235: ifnull +52 -> 287
    //   238: aload_3
    //   239: astore_0
    //   240: aload 4
    //   242: aload 6
    //   244: invokevirtual 175	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   247: ifeq +40 -> 287
    //   250: aload_3
    //   251: astore_0
    //   252: new 297	com/tencent/mm/vfs/q
    //   255: dup
    //   256: new 81	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   263: aload_1
    //   264: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 201
    //   269: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload 6
    //   274: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokespecial 326	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   283: invokevirtual 337	com/tencent/mm/vfs/q:ifL	()Z
    //   286: pop
    //   287: aload_3
    //   288: astore_0
    //   289: aload 7
    //   291: invokestatic 511	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   294: astore 6
    //   296: aload_3
    //   297: astore_0
    //   298: aload_3
    //   299: aload 5
    //   301: invokevirtual 512	java/util/zip/ZipInputStream:read	([B)I
    //   304: istore_2
    //   305: iload_2
    //   306: iconst_m1
    //   307: if_icmpeq +42 -> 349
    //   310: aload_3
    //   311: astore_0
    //   312: aload 6
    //   314: aload 5
    //   316: iconst_0
    //   317: iload_2
    //   318: invokevirtual 467	java/io/OutputStream:write	([BII)V
    //   321: goto -25 -> 296
    //   324: astore_1
    //   325: aload_3
    //   326: astore_0
    //   327: ldc 79
    //   329: aload_1
    //   330: ldc_w 325
    //   333: invokestatic 231	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   336: aload_3
    //   337: invokestatic 267	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   340: sipush 13303
    //   343: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   346: bipush 254
    //   348: ireturn
    //   349: aload_3
    //   350: astore_0
    //   351: aload 6
    //   353: invokevirtual 404	java/io/OutputStream:close	()V
    //   356: goto -318 -> 38
    //   359: astore_3
    //   360: aload_0
    //   361: astore_1
    //   362: aload_3
    //   363: astore_0
    //   364: aload_1
    //   365: invokestatic 267	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   368: sipush 13303
    //   371: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: aload_0
    //   375: athrow
    //   376: aload_3
    //   377: invokestatic 267	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   380: sipush 13303
    //   383: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   386: iconst_0
    //   387: ireturn
    //   388: astore_0
    //   389: aconst_null
    //   390: astore_1
    //   391: goto -27 -> 364
    //   394: astore_1
    //   395: aconst_null
    //   396: astore_3
    //   397: goto -72 -> 325
    //   400: astore_1
    //   401: aconst_null
    //   402: astore_3
    //   403: goto -237 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	paramString1	String
    //   0	406	1	paramString2	String
    //   304	14	2	i	int
    //   17	333	3	localZipInputStream	java.util.zip.ZipInputStream
    //   359	18	3	localCloseable	java.io.Closeable
    //   396	7	3	localObject1	Object
    //   27	214	4	localHashSet	HashSet
    //   36	279	5	arrayOfByte	byte[]
    //   58	294	6	localObject2	Object
    //   44	246	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	29	165	java/io/FileNotFoundException
    //   31	38	165	java/io/FileNotFoundException
    //   40	46	165	java/io/FileNotFoundException
    //   53	60	165	java/io/FileNotFoundException
    //   62	73	165	java/io/FileNotFoundException
    //   75	86	165	java/io/FileNotFoundException
    //   88	96	165	java/io/FileNotFoundException
    //   98	113	165	java/io/FileNotFoundException
    //   115	125	165	java/io/FileNotFoundException
    //   127	162	165	java/io/FileNotFoundException
    //   191	224	165	java/io/FileNotFoundException
    //   226	233	165	java/io/FileNotFoundException
    //   240	250	165	java/io/FileNotFoundException
    //   252	287	165	java/io/FileNotFoundException
    //   289	296	165	java/io/FileNotFoundException
    //   298	305	165	java/io/FileNotFoundException
    //   312	321	165	java/io/FileNotFoundException
    //   351	356	165	java/io/FileNotFoundException
    //   20	29	324	java/io/IOException
    //   31	38	324	java/io/IOException
    //   40	46	324	java/io/IOException
    //   53	60	324	java/io/IOException
    //   62	73	324	java/io/IOException
    //   75	86	324	java/io/IOException
    //   88	96	324	java/io/IOException
    //   98	113	324	java/io/IOException
    //   115	125	324	java/io/IOException
    //   127	162	324	java/io/IOException
    //   191	224	324	java/io/IOException
    //   226	233	324	java/io/IOException
    //   240	250	324	java/io/IOException
    //   252	287	324	java/io/IOException
    //   289	296	324	java/io/IOException
    //   298	305	324	java/io/IOException
    //   312	321	324	java/io/IOException
    //   351	356	324	java/io/IOException
    //   20	29	359	finally
    //   31	38	359	finally
    //   40	46	359	finally
    //   53	60	359	finally
    //   62	73	359	finally
    //   75	86	359	finally
    //   88	96	359	finally
    //   98	113	359	finally
    //   115	125	359	finally
    //   127	162	359	finally
    //   168	177	359	finally
    //   191	224	359	finally
    //   226	233	359	finally
    //   240	250	359	finally
    //   252	287	359	finally
    //   289	296	359	finally
    //   298	305	359	finally
    //   312	321	359	finally
    //   327	336	359	finally
    //   351	356	359	finally
    //   6	18	388	finally
    //   6	18	394	java/io/IOException
    //   6	18	400	java/io/FileNotFoundException
  }
  
  public static ParcelFileDescriptor h(q paramq, String paramString)
  {
    AppMethodBeat.i(236911);
    paramq = a(paramq.mUri, paramq.ify(), paramString);
    AppMethodBeat.o(236911);
    return paramq;
  }
  
  public static String n(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13276);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13276);
      return null;
    }
    paramString = ad.b(ad.parseUri(paramString), paramBoolean);
    AppMethodBeat.o(13276);
    return paramString;
  }
  
  public static ParcelFileDescriptor om(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13274);
    paramString1 = a(ad.parseUri(paramString1), null, paramString2);
    AppMethodBeat.o(13274);
    return paramString1;
  }
  
  public static long on(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13286);
    long l = H(paramString1, paramString2, false);
    AppMethodBeat.o(13286);
    return l;
  }
  
  public static boolean oo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(292980);
    boolean bool = op(paramString1, paramString2);
    AppMethodBeat.o(292980);
    return bool;
  }
  
  private static boolean op(String paramString1, String paramString2)
  {
    AppMethodBeat.i(236923);
    if ((paramString1 == null) || (paramString2 == null) || (paramString1.length() == 0) || (paramString2.length() == 0))
    {
      AppMethodBeat.o(236923);
      return false;
    }
    h.e locale1 = h.iWH().a(ad.parseUri(paramString1), null);
    h.e locale2 = h.iWH().a(ad.parseUri(paramString2), null);
    if ((!locale1.fCF()) || (!locale2.fCF()))
    {
      AppMethodBeat.o(236923);
      return false;
    }
    try
    {
      boolean bool1 = locale2.YCO.a(locale2.path, locale1.YCO, locale1.path);
      boolean bool2 = bool1;
      if (!bool1) {
        if (locale2.YCO.a(locale2.path, locale1.YCO, locale1.path, false) < 0L) {
          break label183;
        }
      }
      label183:
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1)
        {
          locale1.YCO.ho(locale1.path);
          bool2 = bool1;
        }
        AppMethodBeat.o(236923);
        return bool2;
      }
      return false;
    }
    catch (IOException localIOException)
    {
      Log.w("MicroMsg.VFSFileOp", "Failed to move file " + paramString1 + " -> " + paramString2 + ": " + localIOException.getMessage());
      AppMethodBeat.o(236923);
    }
  }
  
  public static boolean oq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13293);
    paramString1 = ad.parseUri(paramString1);
    paramString1 = h.iWH().a(paramString1, null);
    paramString2 = ad.parseUri(paramString2);
    boolean bool = a(paramString1, h.iWH().a(paramString2, null), false);
    AppMethodBeat.o(13293);
    return bool;
  }
  
  public static boolean or(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13294);
    Object localObject1 = ad.parseUri(paramString1);
    localObject1 = h.iWH().a((Uri)localObject1, null);
    paramString2 = ad.parseUri(paramString2);
    paramString2 = h.iWH().a(paramString2, null);
    if ((((h.e)localObject1).fCF()) && (paramString2.fCF()))
    {
      Object localObject3 = ((h.e)localObject1).YCO;
      Object localObject2 = paramString2.YCO;
      if (((((FileSystem.b)localObject3).ieY() & 0xA) == 10) && ((((FileSystem.b)localObject2).ieY() & 0xA) == 10))
      {
        localObject3 = ((FileSystem.b)localObject3).dL(((h.e)localObject1).path, false);
        localObject2 = ((FileSystem.b)localObject2).dL(paramString2.path, true);
        if ((localObject3 != null) && (localObject2 != null) && (new File((String)localObject3).renameTo(new File((String)localObject2))))
        {
          AppMethodBeat.o(13294);
          return true;
        }
      }
    }
    if ((a((h.e)localObject1, paramString2, true)) && (dK(paramString1, false)))
    {
      AppMethodBeat.o(13294);
      return true;
    }
    AppMethodBeat.o(13294);
    return false;
  }
  
  public static boolean os(String paramString1, String paramString2)
  {
    AppMethodBeat.i(170171);
    if ((paramString1 == null) || (paramString1.isEmpty()))
    {
      AppMethodBeat.o(170171);
      return false;
    }
    boolean bool = x(Collections.singletonList(paramString1), paramString2);
    AppMethodBeat.o(170171);
    return bool;
  }
  
  public static InputStream q(Uri paramUri)
  {
    AppMethodBeat.i(292979);
    paramUri = b(paramUri, null);
    AppMethodBeat.o(292979);
    return paramUri;
  }
  
  /* Error */
  private static boolean x(java.util.List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: sipush 13304
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: invokevirtual 120	java/lang/String:isEmpty	()Z
    //   14: ifeq +11 -> 25
    //   17: sipush 13304
    //   20: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_1
    //   26: invokestatic 557	com/tencent/mm/vfs/u:bBT	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokestatic 558	com/tencent/mm/vfs/u:bBD	(Ljava/lang/String;)Z
    //   32: pop
    //   33: sipush 4096
    //   36: newarray byte
    //   38: astore 5
    //   40: new 560	java/util/zip/ZipOutputStream
    //   43: dup
    //   44: aload_1
    //   45: iconst_0
    //   46: invokestatic 115	com/tencent/mm/vfs/u:dI	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   49: invokespecial 563	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   52: astore 4
    //   54: aload_0
    //   55: invokeinterface 566 1 0
    //   60: astore 6
    //   62: aload 6
    //   64: invokeinterface 186 1 0
    //   69: ifeq +305 -> 374
    //   72: aload 6
    //   74: invokeinterface 190 1 0
    //   79: checkcast 32	java/lang/String
    //   82: invokestatic 54	com/tencent/mm/vfs/ad:parseUri	(Ljava/lang/String;)Landroid/net/Uri;
    //   85: astore_0
    //   86: invokestatic 48	com/tencent/mm/vfs/h:iWH	()Lcom/tencent/mm/vfs/h;
    //   89: aload_0
    //   90: aconst_null
    //   91: invokevirtual 58	com/tencent/mm/vfs/h:a	(Landroid/net/Uri;Lcom/tencent/mm/vfs/h$e;)Lcom/tencent/mm/vfs/h$e;
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 64	com/tencent/mm/vfs/h$e:fCF	()Z
    //   99: ifeq -37 -> 62
    //   102: aload_0
    //   103: getfield 68	com/tencent/mm/vfs/h$e:YCO	Lcom/tencent/mm/vfs/FileSystem$b;
    //   106: aload_0
    //   107: getfield 72	com/tencent/mm/vfs/h$e:path	Ljava/lang/String;
    //   110: invokeinterface 349 2 0
    //   115: astore_1
    //   116: aload_1
    //   117: ifnull -55 -> 62
    //   120: aload_1
    //   121: getfield 209	com/tencent/mm/vfs/f:YCj	Z
    //   124: ifeq +190 -> 314
    //   127: aload_0
    //   128: getfield 72	com/tencent/mm/vfs/h$e:path	Ljava/lang/String;
    //   131: invokevirtual 36	java/lang/String:length	()I
    //   134: istore_3
    //   135: aload_0
    //   136: getfield 72	com/tencent/mm/vfs/h$e:path	Ljava/lang/String;
    //   139: ldc 201
    //   141: invokevirtual 569	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   144: ifeq +165 -> 309
    //   147: iconst_0
    //   148: istore_2
    //   149: aload_0
    //   150: getfield 68	com/tencent/mm/vfs/h$e:YCO	Lcom/tencent/mm/vfs/FileSystem$b;
    //   153: aload_0
    //   154: getfield 72	com/tencent/mm/vfs/h$e:path	Ljava/lang/String;
    //   157: iconst_1
    //   158: invokeinterface 163 3 0
    //   163: astore_0
    //   164: aload_0
    //   165: ifnull -103 -> 62
    //   168: iload_2
    //   169: iload_3
    //   170: iadd
    //   171: istore_2
    //   172: aload_0
    //   173: invokeinterface 181 1 0
    //   178: astore 7
    //   180: aload 7
    //   182: invokeinterface 186 1 0
    //   187: ifeq -125 -> 62
    //   190: aload 7
    //   192: invokeinterface 190 1 0
    //   197: checkcast 192	com/tencent/mm/vfs/f
    //   200: astore_0
    //   201: aload_0
    //   202: getfield 209	com/tencent/mm/vfs/f:YCj	Z
    //   205: ifne -25 -> 180
    //   208: aload_0
    //   209: getfield 195	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
    //   212: invokevirtual 36	java/lang/String:length	()I
    //   215: iload_2
    //   216: if_icmpge +120 -> 336
    //   219: aload_0
    //   220: getfield 572	com/tencent/mm/vfs/f:name	Ljava/lang/String;
    //   223: astore_1
    //   224: aload_0
    //   225: getfield 219	com/tencent/mm/vfs/f:YCk	Lcom/tencent/mm/vfs/FileSystem$b;
    //   228: aload_0
    //   229: getfield 195	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
    //   232: invokeinterface 334 2 0
    //   237: astore_0
    //   238: aload 4
    //   240: new 496	java/util/zip/ZipEntry
    //   243: dup
    //   244: aload_1
    //   245: invokespecial 573	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   248: invokevirtual 577	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   251: aload_0
    //   252: aload 5
    //   254: invokevirtual 419	java/io/InputStream:read	([B)I
    //   257: istore_3
    //   258: iload_3
    //   259: iflt +89 -> 348
    //   262: aload 4
    //   264: aload 5
    //   266: iconst_0
    //   267: iload_3
    //   268: invokevirtual 578	java/util/zip/ZipOutputStream:write	([BII)V
    //   271: goto -20 -> 251
    //   274: astore 5
    //   276: aload 4
    //   278: astore_1
    //   279: aload 5
    //   281: astore 4
    //   283: ldc 79
    //   285: aload 4
    //   287: ldc_w 580
    //   290: invokestatic 231	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   293: aload_0
    //   294: invokestatic 267	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   297: aload_1
    //   298: invokestatic 267	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   301: sipush 13304
    //   304: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: iconst_0
    //   308: ireturn
    //   309: iconst_1
    //   310: istore_2
    //   311: goto -162 -> 149
    //   314: aload_0
    //   315: getfield 72	com/tencent/mm/vfs/h$e:path	Ljava/lang/String;
    //   318: bipush 47
    //   320: invokevirtual 213	java/lang/String:lastIndexOf	(I)I
    //   323: istore_2
    //   324: aload_1
    //   325: invokestatic 548	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   328: astore_0
    //   329: iload_2
    //   330: iconst_1
    //   331: iadd
    //   332: istore_2
    //   333: goto -161 -> 172
    //   336: aload_0
    //   337: getfield 195	com/tencent/mm/vfs/f:UUr	Ljava/lang/String;
    //   340: iload_2
    //   341: invokevirtual 199	java/lang/String:substring	(I)Ljava/lang/String;
    //   344: astore_1
    //   345: goto -121 -> 224
    //   348: aload_0
    //   349: invokevirtual 581	java/io/InputStream:close	()V
    //   352: aload 4
    //   354: invokevirtual 584	java/util/zip/ZipOutputStream:closeEntry	()V
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
    //   375: invokestatic 267	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   378: aload 4
    //   380: invokestatic 267	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
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
    //   398: invokestatic 267	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   401: aload 4
    //   403: invokestatic 267	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.u
 * JD-Core Version:    0.7.0.1
 */