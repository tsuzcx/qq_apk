package com.tencent.mm.plugin.performance;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class c
{
  public static void N(e parame)
  {
    AppMethodBeat.i(211739);
    e locale1 = new e(Environment.getExternalStorageDirectory().getAbsolutePath(), "tencent/MicroMsg/Diagnostic");
    e locale2 = new e(locale1, parame.getName());
    ad.i("MicroMsg.performance.Utils", "DevEnv: copy [%s] to sdcard [%s]", new Object[] { q.B(parame.fOK()), q.B(locale2.fOK()) });
    if (!locale1.exists()) {
      locale1.mkdirs();
    }
    i.mA(q.B(parame.fOK()), q.B(locale2.fOK()));
    AppMethodBeat.o(211739);
  }
  
  /* Error */
  public static String a(String paramString, java.nio.charset.Charset paramCharset)
  {
    // Byte code:
    //   0: ldc 82
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 23	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: new 87	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore 4
    //   24: aload_0
    //   25: invokevirtual 94	java/io/File:length	()J
    //   28: l2i
    //   29: newarray byte
    //   31: astore_0
    //   32: iconst_0
    //   33: istore_2
    //   34: iload_2
    //   35: aload_0
    //   36: arraylength
    //   37: if_icmpge +27 -> 64
    //   40: aload 4
    //   42: aload_0
    //   43: iload_2
    //   44: aload_0
    //   45: arraylength
    //   46: iload_2
    //   47: isub
    //   48: invokevirtual 100	java/io/InputStream:read	([BII)I
    //   51: istore_3
    //   52: iload_3
    //   53: iconst_m1
    //   54: if_icmpeq +10 -> 64
    //   57: iload_2
    //   58: iload_3
    //   59: iadd
    //   60: istore_2
    //   61: goto -27 -> 34
    //   64: new 102	java/lang/String
    //   67: dup
    //   68: aload_0
    //   69: aload_1
    //   70: invokespecial 105	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   73: astore_0
    //   74: aload 4
    //   76: invokevirtual 109	java/io/InputStream:close	()V
    //   79: ldc 82
    //   81: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_0
    //   85: areturn
    //   86: astore_1
    //   87: ldc 82
    //   89: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_1
    //   93: athrow
    //   94: astore_0
    //   95: aload_1
    //   96: ifnull +44 -> 140
    //   99: aload 4
    //   101: invokevirtual 109	java/io/InputStream:close	()V
    //   104: ldc 82
    //   106: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_0
    //   110: athrow
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_0
    //   114: ldc 41
    //   116: aload_1
    //   117: ldc 111
    //   119: iconst_0
    //   120: anewarray 4	java/lang/Object
    //   123: invokestatic 115	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: goto -47 -> 79
    //   129: astore 4
    //   131: aload_1
    //   132: aload 4
    //   134: invokevirtual 119	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   137: goto -33 -> 104
    //   140: aload 4
    //   142: invokevirtual 109	java/io/InputStream:close	()V
    //   145: goto -41 -> 104
    //   148: astore_1
    //   149: goto -35 -> 114
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_1
    //   155: goto -60 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramString	String
    //   0	158	1	paramCharset	java.nio.charset.Charset
    //   33	28	2	i	int
    //   51	9	3	j	int
    //   22	78	4	localFileInputStream	java.io.FileInputStream
    //   129	12	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   24	32	86	java/lang/Throwable
    //   34	52	86	java/lang/Throwable
    //   64	74	86	java/lang/Throwable
    //   87	94	94	finally
    //   14	24	111	java/io/IOException
    //   99	104	111	java/io/IOException
    //   104	111	111	java/io/IOException
    //   131	137	111	java/io/IOException
    //   140	145	111	java/io/IOException
    //   99	104	129	java/lang/Throwable
    //   74	79	148	java/io/IOException
    //   24	32	152	finally
    //   34	52	152	finally
    //   64	74	152	finally
  }
  
  /* Error */
  public static java.util.Set<String> dyx()
  {
    // Byte code:
    //   0: ldc 122
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 124	java/util/HashSet
    //   8: dup
    //   9: invokespecial 126	java/util/HashSet:<init>	()V
    //   12: astore_2
    //   13: new 128	java/io/BufferedReader
    //   16: dup
    //   17: new 130	java/io/InputStreamReader
    //   20: dup
    //   21: new 87	java/io/FileInputStream
    //   24: dup
    //   25: ldc 132
    //   27: invokespecial 133	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   30: invokespecial 136	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   33: invokespecial 139	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore_3
    //   37: aconst_null
    //   38: astore_1
    //   39: aload_3
    //   40: invokevirtual 142	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore_0
    //   44: aload_0
    //   45: ifnull +88 -> 133
    //   48: aload_0
    //   49: ldc 144
    //   51: invokevirtual 148	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   54: ifeq -15 -> 39
    //   57: aload_0
    //   58: ldc 150
    //   60: invokevirtual 154	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   63: ifeq -24 -> 39
    //   66: aload_0
    //   67: ldc 156
    //   69: invokevirtual 160	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   72: astore_0
    //   73: aload_2
    //   74: aload_0
    //   75: aload_0
    //   76: arraylength
    //   77: iconst_1
    //   78: isub
    //   79: aaload
    //   80: invokeinterface 166 2 0
    //   85: pop
    //   86: goto -47 -> 39
    //   89: astore_1
    //   90: ldc 122
    //   92: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_1
    //   96: athrow
    //   97: astore_0
    //   98: aload_1
    //   99: ifnull +50 -> 149
    //   102: aload_3
    //   103: invokevirtual 167	java/io/BufferedReader:close	()V
    //   106: ldc 122
    //   108: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_0
    //   112: athrow
    //   113: astore_0
    //   114: ldc 41
    //   116: aload_0
    //   117: ldc 111
    //   119: iconst_0
    //   120: anewarray 4	java/lang/Object
    //   123: invokestatic 115	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: ldc 122
    //   128: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_2
    //   132: areturn
    //   133: aload_3
    //   134: invokevirtual 167	java/io/BufferedReader:close	()V
    //   137: goto -11 -> 126
    //   140: astore_3
    //   141: aload_1
    //   142: aload_3
    //   143: invokevirtual 119	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   146: goto -40 -> 106
    //   149: aload_3
    //   150: invokevirtual 167	java/io/BufferedReader:close	()V
    //   153: goto -47 -> 106
    //   156: astore_0
    //   157: goto -59 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   43	33	0	localObject1	Object
    //   97	15	0	localObject2	Object
    //   113	4	0	localIOException	java.io.IOException
    //   156	1	0	localObject3	Object
    //   38	1	1	localObject4	Object
    //   89	53	1	localThrowable1	java.lang.Throwable
    //   12	120	2	localHashSet	java.util.HashSet
    //   36	98	3	localBufferedReader	java.io.BufferedReader
    //   140	10	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   39	44	89	java/lang/Throwable
    //   48	86	89	java/lang/Throwable
    //   90	97	97	finally
    //   13	37	113	java/io/IOException
    //   102	106	113	java/io/IOException
    //   106	113	113	java/io/IOException
    //   133	137	113	java/io/IOException
    //   141	146	113	java/io/IOException
    //   149	153	113	java/io/IOException
    //   102	106	140	java/lang/Throwable
    //   39	44	156	finally
    //   48	86	156	finally
  }
  
  public static String yt(long paramLong)
  {
    AppMethodBeat.i(211737);
    String str = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(paramLong));
    AppMethodBeat.o(211737);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c
 * JD-Core Version:    0.7.0.1
 */