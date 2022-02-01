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

public final class o
{
  public static int C(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(224167);
    int i = f(paramString, paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(224167);
    return i;
  }
  
  public static OutputStream Db(String paramString)
  {
    AppMethodBeat.i(224166);
    paramString = db(paramString, false);
    AppMethodBeat.o(224166);
    return paramString;
  }
  
  public static ParcelFileDescriptor a(Uri paramUri, e.e parame, String paramString)
  {
    AppMethodBeat.i(13275);
    parame = e.fSU().a(paramUri, parame);
    if (!parame.valid())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(13275);
      throw paramUri;
    }
    paramUri = parame.LGE.mA(parame.path, paramString);
    AppMethodBeat.o(13275);
    return paramUri;
  }
  
  static OutputStream a(Uri paramUri, e.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(13271);
    parame = e.fSU().a(paramUri, parame);
    if (!parame.valid())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(13271);
      throw paramUri;
    }
    paramUri = parame.LGE.db(parame.path, paramBoolean);
    AppMethodBeat.o(13271);
    return paramUri;
  }
  
  public static RandomAccessFile a(Uri paramUri, boolean paramBoolean)
  {
    AppMethodBeat.i(13273);
    String str = w.b(paramUri, paramBoolean);
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
  
  private static boolean a(e.e parame1, e.e parame2, boolean paramBoolean)
  {
    AppMethodBeat.i(13292);
    if ((!parame1.valid()) || (!parame2.valid()))
    {
      AppMethodBeat.o(13292);
      return false;
    }
    Object localObject = parame1.LGE.dc(parame1.path, true);
    if (localObject == null)
    {
      AppMethodBeat.o(13292);
      return false;
    }
    HashSet localHashSet = new HashSet();
    parame2.LGE.aZI(parame2.path);
    localHashSet.add(parame2.path);
    Iterator localIterator = ((Iterable)localObject).iterator();
    c localc;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label373;
      }
      localc = (c)localIterator.next();
      int i = parame1.path.length();
      String str = localc.Itr.substring(i);
      localObject = str;
      if (!str.startsWith("/")) {
        localObject = "/".concat(String.valueOf(str));
      }
      localObject = parame2.path + (String)localObject;
      if (localc.LGd)
      {
        if (localHashSet.add(localObject)) {
          parame2.LGE.aZI((String)localObject);
        }
      }
      else
      {
        i = ((String)localObject).lastIndexOf('/');
        if (i > 0)
        {
          str = ((String)localObject).substring(0, i);
          if (localHashSet.add(str)) {
            parame2.LGE.aZI(str);
          }
        }
        if (paramBoolean) {
          try
          {
            parame2.LGE.a((String)localObject, localc.LGe, localc.Itr);
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
      parame2.LGE.c((String)localObject, localc.LGe, localc.Itr);
      break;
    }
    label373:
    AppMethodBeat.o(13292);
    return true;
  }
  
  public static String aRh(String paramString)
  {
    AppMethodBeat.i(13302);
    paramString = aZY(paramString);
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
  
  public static boolean aZI(String paramString)
  {
    AppMethodBeat.i(13285);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(13285);
      return false;
    }
    paramString = new k(paramString);
    if ((paramString.mkdirs()) || (paramString.isDirectory()))
    {
      AppMethodBeat.o(13285);
      return true;
    }
    AppMethodBeat.o(13285);
    return false;
  }
  
  public static long aZR(String paramString)
  {
    AppMethodBeat.i(13278);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13278);
      return 0L;
    }
    paramString = w.parseUri(paramString);
    paramString = e.fSU().a(paramString, null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(13278);
      return 0L;
    }
    paramString = paramString.LGE.aZH(paramString.path);
    if (paramString == null)
    {
      AppMethodBeat.o(13278);
      return 0L;
    }
    long l = paramString.size;
    AppMethodBeat.o(13278);
    return l;
  }
  
  public static long aZS(String paramString)
  {
    AppMethodBeat.i(13279);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13279);
      return 0L;
    }
    paramString = w.parseUri(paramString);
    paramString = e.fSU().a(paramString, null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(13279);
      return 0L;
    }
    paramString = paramString.LGE.aZH(paramString.path);
    if (paramString == null)
    {
      AppMethodBeat.o(13279);
      return 0L;
    }
    long l = paramString.LGc;
    AppMethodBeat.o(13279);
    return l;
  }
  
  /* Error */
  public static String aZT(String paramString)
  {
    // Byte code:
    //   0: sipush 13281
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 150	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: new 241	java/io/InputStreamReader
    //   18: dup
    //   19: aload_0
    //   20: invokestatic 245	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   23: invokespecial 248	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
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
    //   41: invokevirtual 252	java/io/InputStreamReader:read	([C)I
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
    //   58: invokevirtual 255	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -26 -> 36
    //   65: astore 4
    //   67: aload_3
    //   68: astore_2
    //   69: ldc 183
    //   71: ldc_w 257
    //   74: iconst_2
    //   75: anewarray 4	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: aload_0
    //   81: aastore
    //   82: dup
    //   83: iconst_1
    //   84: aload 4
    //   86: invokevirtual 260	java/io/IOException:getMessage	()Ljava/lang/String;
    //   89: aastore
    //   90: invokestatic 264	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   108: invokestatic 268	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   111: sipush 13281
    //   114: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_0
    //   118: athrow
    //   119: aload_3
    //   120: invokestatic 268	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   123: aload 4
    //   125: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
  
  public static String aZU(String paramString)
  {
    AppMethodBeat.i(13284);
    paramString = new k(paramString).fTi().getParent();
    AppMethodBeat.o(13284);
    return paramString;
  }
  
  public static boolean aZV(String paramString)
  {
    AppMethodBeat.i(13297);
    try
    {
      paramString = new k(paramString);
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
  
  public static final String aZW(String paramString)
  {
    AppMethodBeat.i(13299);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(13299);
      return "";
    }
    String str = new k(paramString).getName();
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
  
  public static void aZX(String paramString)
  {
    AppMethodBeat.i(13300);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13300);
      return;
    }
    paramString = w.parseUri(paramString);
    paramString = e.fSU().a(paramString, null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(13300);
      return;
    }
    if ((paramString.LGE.fSL() & 0x2) == 0)
    {
      AppMethodBeat.o(13300);
      return;
    }
    if (paramString.LGE.de(paramString.path, true) == null)
    {
      AppMethodBeat.o(13300);
      return;
    }
    try
    {
      paramString.LGE.db(paramString.path + "/.nomedia", false).close();
      AppMethodBeat.o(13300);
      return;
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(13300);
    }
  }
  
  /* Error */
  private static byte[] aZY(String paramString)
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
    //   19: invokestatic 245	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore_0
    //   23: ldc_w 308
    //   26: invokestatic 314	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   29: astore_2
    //   30: sipush 2048
    //   33: newarray byte
    //   35: astore_3
    //   36: aload_0
    //   37: aload_3
    //   38: invokevirtual 319	java/io/InputStream:read	([B)I
    //   41: istore_1
    //   42: iload_1
    //   43: iflt +26 -> 69
    //   46: aload_2
    //   47: aload_3
    //   48: iconst_0
    //   49: iload_1
    //   50: invokevirtual 323	java/security/MessageDigest:update	([BII)V
    //   53: goto -17 -> 36
    //   56: astore_2
    //   57: aload_0
    //   58: invokestatic 268	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   61: sipush 13301
    //   64: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aconst_null
    //   68: areturn
    //   69: aload_2
    //   70: invokevirtual 327	java/security/MessageDigest:digest	()[B
    //   73: astore_2
    //   74: aload_0
    //   75: invokestatic 268	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   78: sipush 13301
    //   81: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_2
    //   85: areturn
    //   86: astore_0
    //   87: aconst_null
    //   88: astore_2
    //   89: aload_2
    //   90: invokestatic 268	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
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
  
  public static String aaw(String paramString)
  {
    AppMethodBeat.i(13298);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(13298);
      return "";
    }
    paramString = new k(paramString).getName();
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
  
  public static InputStream ai(k paramk)
  {
    AppMethodBeat.i(13265);
    paramk = b(paramk.mUri, paramk.fTe());
    AppMethodBeat.o(13265);
    return paramk;
  }
  
  public static OutputStream aj(k paramk)
  {
    AppMethodBeat.i(13268);
    paramk = a(paramk.mUri, paramk.fTe(), false);
    AppMethodBeat.o(13268);
    return paramk;
  }
  
  public static InputStream b(Uri paramUri, e.e parame)
  {
    AppMethodBeat.i(13266);
    parame = e.fSU().a(paramUri, parame);
    if (!parame.valid())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(13266);
      throw paramUri;
    }
    paramUri = parame.LGE.openRead(parame.path);
    AppMethodBeat.o(13266);
    return paramUri;
  }
  
  /* Error */
  public static byte[] bb(String paramString, int paramInt1, int paramInt2)
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
    //   19: iflt +10 -> 29
    //   22: iload_2
    //   23: ldc_w 349
    //   26: if_icmple +263 -> 289
    //   29: sipush 4096
    //   32: istore_3
    //   33: new 351	java/io/ByteArrayOutputStream
    //   36: dup
    //   37: iload_3
    //   38: invokespecial 352	java/io/ByteArrayOutputStream:<init>	(I)V
    //   41: astore 8
    //   43: aload_0
    //   44: invokestatic 245	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
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
    //   70: invokevirtual 356	java/io/InputStream:skip	(J)J
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
    //   96: ldc_w 357
    //   99: istore_1
    //   100: aload 7
    //   102: astore 6
    //   104: aload 7
    //   106: aload 9
    //   108: iconst_0
    //   109: iload_1
    //   110: sipush 1024
    //   113: invokestatic 363	java/lang/Math:min	(II)I
    //   116: invokevirtual 366	java/io/InputStream:read	([BII)I
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
    //   139: invokevirtual 369	java/io/ByteArrayOutputStream:write	([BII)V
    //   142: iload_1
    //   143: iload_2
    //   144: isub
    //   145: istore_1
    //   146: goto -46 -> 100
    //   149: aload 7
    //   151: invokestatic 268	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   154: aload 8
    //   156: invokevirtual 372	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   159: astore 6
    //   161: aload 8
    //   163: invokevirtual 373	java/io/ByteArrayOutputStream:close	()V
    //   166: ldc 183
    //   168: ldc_w 375
    //   171: iconst_2
    //   172: anewarray 4	java/lang/Object
    //   175: dup
    //   176: iconst_0
    //   177: aload_0
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: aload 6
    //   183: arraylength
    //   184: invokestatic 378	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   187: aastore
    //   188: invokestatic 381	com/tencent/stubs/logger/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: sipush 13280
    //   194: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: aload 6
    //   199: areturn
    //   200: astore 8
    //   202: aconst_null
    //   203: astore 7
    //   205: aload 7
    //   207: astore 6
    //   209: ldc 183
    //   211: new 150	java/lang/StringBuilder
    //   214: dup
    //   215: ldc_w 383
    //   218: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   221: aload_0
    //   222: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: ldc_w 385
    //   228: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload 8
    //   233: invokevirtual 260	java/io/IOException:getMessage	()Ljava/lang/String;
    //   236: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 387	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload 7
    //   247: invokestatic 268	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   250: sipush 13280
    //   253: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aconst_null
    //   257: areturn
    //   258: astore_0
    //   259: aconst_null
    //   260: astore 6
    //   262: aload 6
    //   264: invokestatic 268	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   267: sipush 13280
    //   270: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: aload_0
    //   274: athrow
    //   275: astore 7
    //   277: goto -111 -> 166
    //   280: astore_0
    //   281: goto -19 -> 262
    //   284: astore 8
    //   286: goto -81 -> 205
    //   289: iload_2
    //   290: istore_3
    //   291: goto -258 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	paramString	String
    //   0	294	1	paramInt1	int
    //   0	294	2	paramInt2	int
    //   32	259	3	i	int
    //   51	24	4	l	long
    //   62	201	6	localObject	Object
    //   47	199	7	localInputStream	InputStream
    //   275	1	7	localIOException1	IOException
    //   41	121	8	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   200	32	8	localIOException2	IOException
    //   284	1	8	localIOException3	IOException
    //   88	48	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   43	49	200	java/io/IOException
    //   43	49	258	finally
    //   161	166	275	java/io/IOException
    //   64	76	280	finally
    //   83	90	280	finally
    //   104	120	280	finally
    //   133	142	280	finally
    //   209	245	280	finally
    //   64	76	284	java/io/IOException
    //   83	90	284	java/io/IOException
    //   104	120	284	java/io/IOException
    //   133	142	284	java/io/IOException
  }
  
  public static boolean bc(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(13289);
    boolean bool = mG(paramString1 + paramString2, paramString1 + paramString3);
    AppMethodBeat.o(13289);
    return bool;
  }
  
  public static ReadableByteChannel c(Uri paramUri, e.e parame)
  {
    AppMethodBeat.i(170165);
    parame = e.fSU().a(paramUri, parame);
    if (!parame.valid())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(170165);
      throw paramUri;
    }
    paramUri = parame.LGE.aZD(parame.path);
    AppMethodBeat.o(170165);
    return paramUri;
  }
  
  public static boolean cx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13294);
    Object localObject1 = w.parseUri(paramString1);
    localObject1 = e.fSU().a((Uri)localObject1, null);
    paramString2 = w.parseUri(paramString2);
    paramString2 = e.fSU().a(paramString2, null);
    if ((((e.e)localObject1).valid()) && (paramString2.valid()))
    {
      Object localObject3 = ((e.e)localObject1).LGE;
      Object localObject2 = paramString2.LGE;
      if (((((FileSystem.b)localObject3).fSL() & 0xA) == 10) && ((((FileSystem.b)localObject2).fSL() & 0xA) == 10))
      {
        localObject3 = ((FileSystem.b)localObject3).de(((e.e)localObject1).path, false);
        localObject2 = ((FileSystem.b)localObject2).de(paramString2.path, true);
        if ((localObject3 != null) && (localObject2 != null) && (new File((String)localObject3).renameTo(new File((String)localObject2))))
        {
          AppMethodBeat.o(13294);
          return true;
        }
      }
    }
    if ((a((e.e)localObject1, paramString2, true)) && (dd(paramString1, false)))
    {
      AppMethodBeat.o(13294);
      return true;
    }
    AppMethodBeat.o(13294);
    return false;
  }
  
  public static OutputStream d(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(170167);
    paramk = a(paramk.mUri, paramk.fTe(), paramBoolean);
    AppMethodBeat.o(170167);
    return paramk;
  }
  
  public static WritableByteChannel d(Uri paramUri, e.e parame)
  {
    AppMethodBeat.i(193449);
    parame = e.fSU().a(paramUri, parame);
    if (!parame.valid())
    {
      paramUri = new FileNotFoundException("Cannot resolve path or URI: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(193449);
      throw paramUri;
    }
    paramUri = parame.LGE.da(parame.path, false);
    AppMethodBeat.o(193449);
    return paramUri;
  }
  
  public static OutputStream db(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13269);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = new FileNotFoundException("path is empty");
      AppMethodBeat.o(13269);
      throw paramString;
    }
    paramString = a(w.parseUri(paramString), null, paramBoolean);
    AppMethodBeat.o(13269);
    return paramString;
  }
  
  public static boolean dd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13296);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(13296);
      return false;
    }
    paramString = w.parseUri(paramString);
    paramString = e.fSU().a(paramString, null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(13296);
      return false;
    }
    paramBoolean = paramString.LGE.dd(paramString.path, paramBoolean);
    AppMethodBeat.o(13296);
    return paramBoolean;
  }
  
  public static boolean deleteDir(String paramString)
  {
    AppMethodBeat.i(224168);
    boolean bool = dd(paramString, true);
    AppMethodBeat.o(224168);
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
    boolean bool = new k(paramString).delete();
    AppMethodBeat.o(13288);
    return bool;
  }
  
  public static RandomAccessFile dg(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13272);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramString = new FileNotFoundException("path is empty");
      AppMethodBeat.o(13272);
      throw paramString;
    }
    paramString = a(w.parseUri(paramString), paramBoolean);
    AppMethodBeat.o(13272);
    return paramString;
  }
  
  public static Iterable<c> dh(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13291);
    paramString = w.parseUri(paramString);
    paramString = e.fSU().a(paramString, null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(13291);
      return null;
    }
    paramString = paramString.LGE.dc(paramString.path, paramBoolean);
    AppMethodBeat.o(13291);
    return paramString;
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
      OutputStream localOutputStream = db(paramString, true);
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
      w.closeQuietly(localObject2);
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
      OutputStream localOutputStream = db(paramString, false);
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
      w.closeQuietly(localObject2);
      AppMethodBeat.o(13283);
    }
  }
  
  public static boolean fB(String paramString)
  {
    AppMethodBeat.i(13287);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13287);
      return false;
    }
    paramString = w.parseUri(paramString);
    paramString = e.fSU().a(paramString, null);
    if (!paramString.valid())
    {
      AppMethodBeat.o(13287);
      return false;
    }
    boolean bool = paramString.LGE.aZG(paramString.path);
    AppMethodBeat.o(13287);
    return bool;
  }
  
  /* Error */
  public static int fD(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 13303
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 462	java/util/zip/ZipInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokestatic 245	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: invokespecial 463	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_3
    //   18: aload_3
    //   19: astore_0
    //   20: aload_3
    //   21: invokevirtual 467	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   24: astore 4
    //   26: aload 4
    //   28: ifnull +256 -> 284
    //   31: aload_3
    //   32: astore_0
    //   33: aload 4
    //   35: invokevirtual 470	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   38: astore 5
    //   40: aload_3
    //   41: astore_0
    //   42: aload 5
    //   44: ldc_w 472
    //   47: invokevirtual 476	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   50: ifne -32 -> 18
    //   53: aload_3
    //   54: astore_0
    //   55: aload 5
    //   57: ldc_w 478
    //   60: invokevirtual 476	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   63: ifne -45 -> 18
    //   66: aload_3
    //   67: astore_0
    //   68: aload 4
    //   70: invokevirtual 479	java/util/zip/ZipEntry:isDirectory	()Z
    //   73: ifeq +84 -> 157
    //   76: aload_3
    //   77: astore_0
    //   78: aload 5
    //   80: iconst_0
    //   81: aload 5
    //   83: invokevirtual 136	java/lang/String:length	()I
    //   86: iconst_1
    //   87: isub
    //   88: invokevirtual 170	java/lang/String:substring	(II)Ljava/lang/String;
    //   91: astore 4
    //   93: aload_3
    //   94: astore_0
    //   95: new 210	com/tencent/mm/vfs/k
    //   98: dup
    //   99: new 150	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   106: aload_1
    //   107: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 145
    //   112: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 4
    //   117: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokespecial 211	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   126: invokevirtual 214	com/tencent/mm/vfs/k:mkdirs	()Z
    //   129: pop
    //   130: goto -112 -> 18
    //   133: astore_1
    //   134: aload_3
    //   135: astore_0
    //   136: ldc 183
    //   138: aload_1
    //   139: ldc_w 286
    //   142: invokestatic 191	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   145: aload_3
    //   146: invokestatic 268	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   149: sipush 13303
    //   152: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: iconst_m1
    //   156: ireturn
    //   157: aload_3
    //   158: astore_0
    //   159: new 210	com/tencent/mm/vfs/k
    //   162: dup
    //   163: new 150	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   170: aload_1
    //   171: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc 145
    //   176: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload 5
    //   181: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokespecial 211	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   190: invokestatic 481	com/tencent/mm/vfs/o:aj	(Lcom/tencent/mm/vfs/k;)Ljava/io/OutputStream;
    //   193: astore 4
    //   195: aload_3
    //   196: astore_0
    //   197: sipush 1024
    //   200: newarray byte
    //   202: astore 5
    //   204: aload_3
    //   205: astore_0
    //   206: aload_3
    //   207: aload 5
    //   209: invokevirtual 482	java/util/zip/ZipInputStream:read	([B)I
    //   212: istore_2
    //   213: iload_2
    //   214: iconst_m1
    //   215: if_icmpeq +42 -> 257
    //   218: aload_3
    //   219: astore_0
    //   220: aload 4
    //   222: aload 5
    //   224: iconst_0
    //   225: iload_2
    //   226: invokevirtual 438	java/io/OutputStream:write	([BII)V
    //   229: goto -25 -> 204
    //   232: astore_1
    //   233: aload_3
    //   234: astore_0
    //   235: ldc 183
    //   237: aload_1
    //   238: ldc_w 286
    //   241: invokestatic 191	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   244: aload_3
    //   245: invokestatic 268	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   248: sipush 13303
    //   251: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: bipush 254
    //   256: ireturn
    //   257: aload_3
    //   258: astore_0
    //   259: aload 4
    //   261: invokevirtual 304	java/io/OutputStream:close	()V
    //   264: goto -246 -> 18
    //   267: astore_3
    //   268: aload_0
    //   269: astore_1
    //   270: aload_3
    //   271: astore_0
    //   272: aload_1
    //   273: invokestatic 268	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   276: sipush 13303
    //   279: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: aload_0
    //   283: athrow
    //   284: aload_3
    //   285: invokestatic 268	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   288: sipush 13303
    //   291: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: iconst_0
    //   295: ireturn
    //   296: astore_0
    //   297: aconst_null
    //   298: astore_1
    //   299: goto -27 -> 272
    //   302: astore_1
    //   303: aconst_null
    //   304: astore_3
    //   305: goto -72 -> 233
    //   308: astore_1
    //   309: aconst_null
    //   310: astore_3
    //   311: goto -177 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	paramString1	String
    //   0	314	1	paramString2	String
    //   212	14	2	i	int
    //   17	241	3	localZipInputStream	java.util.zip.ZipInputStream
    //   267	18	3	localCloseable	java.io.Closeable
    //   304	7	3	localObject1	Object
    //   24	236	4	localObject2	Object
    //   38	185	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	26	133	java/io/FileNotFoundException
    //   33	40	133	java/io/FileNotFoundException
    //   42	53	133	java/io/FileNotFoundException
    //   55	66	133	java/io/FileNotFoundException
    //   68	76	133	java/io/FileNotFoundException
    //   78	93	133	java/io/FileNotFoundException
    //   95	130	133	java/io/FileNotFoundException
    //   159	195	133	java/io/FileNotFoundException
    //   197	204	133	java/io/FileNotFoundException
    //   206	213	133	java/io/FileNotFoundException
    //   220	229	133	java/io/FileNotFoundException
    //   259	264	133	java/io/FileNotFoundException
    //   20	26	232	java/io/IOException
    //   33	40	232	java/io/IOException
    //   42	53	232	java/io/IOException
    //   55	66	232	java/io/IOException
    //   68	76	232	java/io/IOException
    //   78	93	232	java/io/IOException
    //   95	130	232	java/io/IOException
    //   159	195	232	java/io/IOException
    //   197	204	232	java/io/IOException
    //   206	213	232	java/io/IOException
    //   220	229	232	java/io/IOException
    //   259	264	232	java/io/IOException
    //   20	26	267	finally
    //   33	40	267	finally
    //   42	53	267	finally
    //   55	66	267	finally
    //   68	76	267	finally
    //   78	93	267	finally
    //   95	130	267	finally
    //   136	145	267	finally
    //   159	195	267	finally
    //   197	204	267	finally
    //   206	213	267	finally
    //   220	229	267	finally
    //   235	244	267	finally
    //   259	264	267	finally
    //   6	18	296	finally
    //   6	18	302	java/io/IOException
    //   6	18	308	java/io/FileNotFoundException
  }
  
  public static String k(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13276);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(13276);
      return null;
    }
    paramString = w.b(w.parseUri(paramString), paramBoolean);
    AppMethodBeat.o(13276);
    return paramString;
  }
  
  public static ParcelFileDescriptor mE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13274);
    if ((paramString1 == null) || (paramString1.isEmpty()))
    {
      paramString1 = new FileNotFoundException("path is empty");
      AppMethodBeat.o(13274);
      throw paramString1;
    }
    paramString1 = a(w.parseUri(paramString1), null, paramString2);
    AppMethodBeat.o(13274);
    return paramString1;
  }
  
  public static long mF(String paramString1, String paramString2)
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
    e.e locale1 = e.fSU().a(w.parseUri(paramString1), null);
    e.e locale2 = e.fSU().a(w.parseUri(paramString2), null);
    if ((!locale1.valid()) || (!locale2.valid()))
    {
      AppMethodBeat.o(13286);
      return -1L;
    }
    try
    {
      long l = locale2.LGE.c(locale2.path, locale1.LGE, locale1.path);
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
  
  public static boolean mG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13290);
    if ((paramString1 == null) || (paramString2 == null) || (paramString1.length() == 0) || (paramString2.length() == 0))
    {
      AppMethodBeat.o(13290);
      return false;
    }
    e.e locale1 = e.fSU().a(w.parseUri(paramString1), null);
    e.e locale2 = e.fSU().a(w.parseUri(paramString2), null);
    if ((!locale1.valid()) || (!locale2.valid()))
    {
      AppMethodBeat.o(13290);
      return false;
    }
    try
    {
      boolean bool1 = locale2.LGE.a(locale2.path, locale1.LGE, locale1.path);
      boolean bool2 = bool1;
      if (!bool1) {
        if (locale2.LGE.c(locale2.path, locale1.LGE, locale1.path) < 0L) {
          break label182;
        }
      }
      label182:
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1)
        {
          locale1.LGE.Dc(locale1.path);
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
  
  public static boolean mH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13293);
    paramString1 = w.parseUri(paramString1);
    paramString1 = e.fSU().a(paramString1, null);
    paramString2 = w.parseUri(paramString2);
    boolean bool = a(paramString1, e.fSU().a(paramString2, null), false);
    AppMethodBeat.o(13293);
    return bool;
  }
  
  public static boolean mI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(170171);
    if ((paramString1 == null) || (paramString1.isEmpty()))
    {
      AppMethodBeat.o(170171);
      return false;
    }
    boolean bool = t(Collections.singletonList(paramString1), paramString2);
    AppMethodBeat.o(170171);
    return bool;
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
    paramString = b(w.parseUri(paramString), null);
    AppMethodBeat.o(13264);
    return paramString;
  }
  
  /* Error */
  public static boolean t(java.util.List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: sipush 13304
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: invokevirtual 222	java/lang/String:isEmpty	()Z
    //   14: ifeq +11 -> 25
    //   17: sipush 13304
    //   20: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_1
    //   26: invokestatic 519	com/tencent/mm/vfs/o:aZU	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokestatic 520	com/tencent/mm/vfs/o:aZI	(Ljava/lang/String;)Z
    //   32: pop
    //   33: sipush 4096
    //   36: newarray byte
    //   38: astore 5
    //   40: new 522	java/util/zip/ZipOutputStream
    //   43: dup
    //   44: aload_1
    //   45: iconst_0
    //   46: invokestatic 28	com/tencent/mm/vfs/o:db	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   49: invokespecial 525	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   52: astore 4
    //   54: aload_0
    //   55: invokeinterface 528 1 0
    //   60: astore 6
    //   62: aload 6
    //   64: invokeinterface 126 1 0
    //   69: ifeq +305 -> 374
    //   72: aload 6
    //   74: invokeinterface 130 1 0
    //   79: checkcast 51	java/lang/String
    //   82: invokestatic 226	com/tencent/mm/vfs/w:parseUri	(Ljava/lang/String;)Landroid/net/Uri;
    //   85: astore_0
    //   86: invokestatic 36	com/tencent/mm/vfs/e:fSU	()Lcom/tencent/mm/vfs/e;
    //   89: aload_0
    //   90: aconst_null
    //   91: invokevirtual 39	com/tencent/mm/vfs/e:a	(Landroid/net/Uri;Lcom/tencent/mm/vfs/e$e;)Lcom/tencent/mm/vfs/e$e;
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 45	com/tencent/mm/vfs/e$e:valid	()Z
    //   99: ifeq -37 -> 62
    //   102: aload_0
    //   103: getfield 67	com/tencent/mm/vfs/e$e:LGE	Lcom/tencent/mm/vfs/FileSystem$b;
    //   106: aload_0
    //   107: getfield 71	com/tencent/mm/vfs/e$e:path	Ljava/lang/String;
    //   110: invokeinterface 230 2 0
    //   115: astore_1
    //   116: aload_1
    //   117: ifnull -55 -> 62
    //   120: aload_1
    //   121: getfield 163	com/tencent/mm/vfs/c:LGd	Z
    //   124: ifeq +190 -> 314
    //   127: aload_0
    //   128: getfield 71	com/tencent/mm/vfs/e$e:path	Ljava/lang/String;
    //   131: invokevirtual 136	java/lang/String:length	()I
    //   134: istore_3
    //   135: aload_0
    //   136: getfield 71	com/tencent/mm/vfs/e$e:path	Ljava/lang/String;
    //   139: ldc 145
    //   141: invokevirtual 531	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   144: ifeq +165 -> 309
    //   147: iconst_0
    //   148: istore_2
    //   149: aload_0
    //   150: getfield 67	com/tencent/mm/vfs/e$e:LGE	Lcom/tencent/mm/vfs/FileSystem$b;
    //   153: aload_0
    //   154: getfield 71	com/tencent/mm/vfs/e$e:path	Ljava/lang/String;
    //   157: iconst_1
    //   158: invokeinterface 102 3 0
    //   163: astore_0
    //   164: aload_0
    //   165: ifnull -103 -> 62
    //   168: iload_2
    //   169: iload_3
    //   170: iadd
    //   171: istore_2
    //   172: aload_0
    //   173: invokeinterface 121 1 0
    //   178: astore 7
    //   180: aload 7
    //   182: invokeinterface 126 1 0
    //   187: ifeq -125 -> 62
    //   190: aload 7
    //   192: invokeinterface 130 1 0
    //   197: checkcast 132	com/tencent/mm/vfs/c
    //   200: astore_0
    //   201: aload_0
    //   202: getfield 163	com/tencent/mm/vfs/c:LGd	Z
    //   205: ifne -25 -> 180
    //   208: aload_0
    //   209: getfield 139	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
    //   212: invokevirtual 136	java/lang/String:length	()I
    //   215: iload_2
    //   216: if_icmpge +120 -> 336
    //   219: aload_0
    //   220: getfield 534	com/tencent/mm/vfs/c:name	Ljava/lang/String;
    //   223: astore_1
    //   224: aload_0
    //   225: getfield 173	com/tencent/mm/vfs/c:LGe	Lcom/tencent/mm/vfs/FileSystem$b;
    //   228: aload_0
    //   229: getfield 139	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
    //   232: invokeinterface 346 2 0
    //   237: astore_0
    //   238: aload 4
    //   240: new 469	java/util/zip/ZipEntry
    //   243: dup
    //   244: aload_1
    //   245: invokespecial 535	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   248: invokevirtual 539	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   251: aload_0
    //   252: aload 5
    //   254: invokevirtual 319	java/io/InputStream:read	([B)I
    //   257: istore_3
    //   258: iload_3
    //   259: iflt +89 -> 348
    //   262: aload 4
    //   264: aload 5
    //   266: iconst_0
    //   267: iload_3
    //   268: invokevirtual 540	java/util/zip/ZipOutputStream:write	([BII)V
    //   271: goto -20 -> 251
    //   274: astore 5
    //   276: aload 4
    //   278: astore_1
    //   279: aload 5
    //   281: astore 4
    //   283: ldc 183
    //   285: aload 4
    //   287: ldc_w 542
    //   290: invokestatic 191	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   293: aload_0
    //   294: invokestatic 268	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   297: aload_1
    //   298: invokestatic 268	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   301: sipush 13304
    //   304: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: iconst_0
    //   308: ireturn
    //   309: iconst_1
    //   310: istore_2
    //   311: goto -162 -> 149
    //   314: aload_0
    //   315: getfield 71	com/tencent/mm/vfs/e$e:path	Ljava/lang/String;
    //   318: bipush 47
    //   320: invokevirtual 167	java/lang/String:lastIndexOf	(I)I
    //   323: istore_2
    //   324: aload_1
    //   325: invokestatic 513	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   328: astore_0
    //   329: iload_2
    //   330: iconst_1
    //   331: iadd
    //   332: istore_2
    //   333: goto -161 -> 172
    //   336: aload_0
    //   337: getfield 139	com/tencent/mm/vfs/c:Itr	Ljava/lang/String;
    //   340: iload_2
    //   341: invokevirtual 143	java/lang/String:substring	(I)Ljava/lang/String;
    //   344: astore_1
    //   345: goto -121 -> 224
    //   348: aload_0
    //   349: invokevirtual 543	java/io/InputStream:close	()V
    //   352: aload 4
    //   354: invokevirtual 546	java/util/zip/ZipOutputStream:closeEntry	()V
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
    //   375: invokestatic 268	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   378: aload 4
    //   380: invokestatic 268	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
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
    //   398: invokestatic 268	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   401: aload 4
    //   403: invokestatic 268	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
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
 * Qualified Name:     com.tencent.mm.vfs.o
 * JD-Core Version:    0.7.0.1
 */