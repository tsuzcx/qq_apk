package com.tencent.mm.plugin.performance;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class c
{
  public static String HF(long paramLong)
  {
    AppMethodBeat.i(201014);
    String str = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(paramLong));
    AppMethodBeat.o(201014);
    return str;
  }
  
  public static void T(o paramo)
  {
    AppMethodBeat.i(201016);
    o localo1 = new o(MMApplicationContext.getContext().getExternalCacheDir() + "/Diagnostic");
    o localo2 = new o(localo1, paramo.getName());
    Log.i("MicroMsg.performance.Utils", "DevEnv: copy [%s] to sdcard [%s]", new Object[] { aa.z(paramo.her()), aa.z(localo2.her()) });
    if (!localo1.exists()) {
      localo1.mkdirs();
    }
    s.nx(aa.z(paramo.her()), aa.z(localo2.her()));
    AppMethodBeat.o(201016);
  }
  
  /* Error */
  public static String a(String paramString, java.nio.charset.Charset paramCharset)
  {
    // Byte code:
    //   0: ldc 123
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 125	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: new 128	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore 4
    //   24: aload_0
    //   25: invokevirtual 135	java/io/File:length	()J
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
    //   48: invokevirtual 141	java/io/InputStream:read	([BII)I
    //   51: istore_3
    //   52: iload_3
    //   53: iconst_m1
    //   54: if_icmpeq +10 -> 64
    //   57: iload_2
    //   58: iload_3
    //   59: iadd
    //   60: istore_2
    //   61: goto -27 -> 34
    //   64: new 143	java/lang/String
    //   67: dup
    //   68: aload_0
    //   69: aload_1
    //   70: invokespecial 146	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   73: astore_0
    //   74: aload 4
    //   76: invokevirtual 149	java/io/InputStream:close	()V
    //   79: ldc 123
    //   81: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_0
    //   85: areturn
    //   86: astore_1
    //   87: ldc 123
    //   89: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_1
    //   93: athrow
    //   94: astore_0
    //   95: aload_1
    //   96: ifnull +44 -> 140
    //   99: aload 4
    //   101: invokevirtual 149	java/io/InputStream:close	()V
    //   104: ldc 123
    //   106: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_0
    //   110: athrow
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_0
    //   114: ldc 86
    //   116: aload_1
    //   117: ldc 151
    //   119: iconst_0
    //   120: anewarray 4	java/lang/Object
    //   123: invokestatic 155	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: goto -47 -> 79
    //   129: astore 4
    //   131: aload_1
    //   132: aload 4
    //   134: invokevirtual 159	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   137: goto -33 -> 104
    //   140: aload 4
    //   142: invokevirtual 149	java/io/InputStream:close	()V
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
  public static java.util.Set<String> eBB()
  {
    // Byte code:
    //   0: ldc 162
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 164	java/util/HashSet
    //   8: dup
    //   9: invokespecial 165	java/util/HashSet:<init>	()V
    //   12: astore_2
    //   13: new 167	java/io/BufferedReader
    //   16: dup
    //   17: new 169	java/io/InputStreamReader
    //   20: dup
    //   21: new 128	java/io/FileInputStream
    //   24: dup
    //   25: ldc 171
    //   27: invokespecial 172	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   30: invokespecial 175	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   33: invokespecial 178	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore_3
    //   37: aconst_null
    //   38: astore_1
    //   39: aload_3
    //   40: invokevirtual 181	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore_0
    //   44: aload_0
    //   45: ifnull +88 -> 133
    //   48: aload_0
    //   49: ldc 183
    //   51: invokevirtual 187	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   54: ifeq -15 -> 39
    //   57: aload_0
    //   58: ldc 189
    //   60: invokevirtual 193	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   63: ifeq -24 -> 39
    //   66: aload_0
    //   67: ldc 195
    //   69: invokevirtual 199	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   72: astore_0
    //   73: aload_2
    //   74: aload_0
    //   75: aload_0
    //   76: arraylength
    //   77: iconst_1
    //   78: isub
    //   79: aaload
    //   80: invokeinterface 205 2 0
    //   85: pop
    //   86: goto -47 -> 39
    //   89: astore_1
    //   90: ldc 162
    //   92: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_1
    //   96: athrow
    //   97: astore_0
    //   98: aload_1
    //   99: ifnull +50 -> 149
    //   102: aload_3
    //   103: invokevirtual 206	java/io/BufferedReader:close	()V
    //   106: ldc 162
    //   108: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_0
    //   112: athrow
    //   113: astore_0
    //   114: ldc 86
    //   116: aload_0
    //   117: ldc 151
    //   119: iconst_0
    //   120: anewarray 4	java/lang/Object
    //   123: invokestatic 155	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: ldc 162
    //   128: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_2
    //   132: areturn
    //   133: aload_3
    //   134: invokevirtual 206	java/io/BufferedReader:close	()V
    //   137: goto -11 -> 126
    //   140: astore_3
    //   141: aload_1
    //   142: aload_3
    //   143: invokevirtual 159	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   146: goto -40 -> 106
    //   149: aload_3
    //   150: invokevirtual 206	java/io/BufferedReader:close	()V
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c
 * JD-Core Version:    0.7.0.1
 */