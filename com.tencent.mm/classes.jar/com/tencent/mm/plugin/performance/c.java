package com.tencent.mm.plugin.performance;

import android.content.Context;
import android.os.Build;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.n.d;

public final class c
{
  private static final String GLn;
  private static int GLo;
  private static final MultiProcessMMKV cQO;
  
  static
  {
    AppMethodBeat.i(200658);
    cQO = MultiProcessMMKV.getMMKV("diagnostic_storage");
    GLn = "KEY_USER_MEM_CAP_INT_" + Build.FINGERPRINT;
    AppMethodBeat.o(200658);
  }
  
  public static String OZ(long paramLong)
  {
    AppMethodBeat.i(200633);
    String str = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(paramLong));
    AppMethodBeat.o(200633);
    return str;
  }
  
  public static void T(q paramq)
  {
    AppMethodBeat.i(200641);
    q localq1 = new q(MMApplicationContext.getContext().getExternalCacheDir() + "/Diagnostic");
    q localq2 = new q(localq1, paramq.getName());
    Log.i("MicroMsg.performance.Utils", "DevEnv: copy [%s] to sdcard [%s]", new Object[] { paramq.bOF(), localq2.bOF() });
    if (!localq1.ifE()) {
      localq1.ifL();
    }
    u.oo(paramq.bOF(), localq2.bOF());
    AppMethodBeat.o(200641);
  }
  
  /* Error */
  private static String a(String paramString, java.nio.charset.Charset paramCharset)
  {
    // Byte code:
    //   0: ldc 146
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 148	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 149	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: new 151	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 154	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore 4
    //   24: aload_0
    //   25: invokevirtual 158	java/io/File:length	()J
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
    //   48: invokevirtual 164	java/io/InputStream:read	([BII)I
    //   51: istore_3
    //   52: iload_3
    //   53: iconst_m1
    //   54: if_icmpeq +10 -> 64
    //   57: iload_2
    //   58: iload_3
    //   59: iadd
    //   60: istore_2
    //   61: goto -27 -> 34
    //   64: new 166	java/lang/String
    //   67: dup
    //   68: aload_0
    //   69: aload_1
    //   70: invokespecial 169	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   73: astore_0
    //   74: aload 4
    //   76: invokevirtual 172	java/io/InputStream:close	()V
    //   79: ldc 146
    //   81: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_0
    //   85: areturn
    //   86: astore_1
    //   87: ldc 146
    //   89: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_1
    //   93: athrow
    //   94: astore_0
    //   95: aload_1
    //   96: ifnull +44 -> 140
    //   99: aload 4
    //   101: invokevirtual 172	java/io/InputStream:close	()V
    //   104: ldc 146
    //   106: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_0
    //   110: athrow
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_0
    //   114: ldc 116
    //   116: aload_1
    //   117: ldc 174
    //   119: iconst_0
    //   120: anewarray 4	java/lang/Object
    //   123: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: goto -47 -> 79
    //   129: astore 4
    //   131: aload_1
    //   132: aload 4
    //   134: invokevirtual 182	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   137: goto -33 -> 104
    //   140: aload 4
    //   142: invokevirtual 172	java/io/InputStream:close	()V
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
  
  public static String aUl(String paramString)
  {
    AppMethodBeat.i(200636);
    paramString = a(paramString, d.UTF_8);
    AppMethodBeat.o(200636);
    return paramString;
  }
  
  /* Error */
  public static java.util.Set<String> fni()
  {
    // Byte code:
    //   0: ldc 208
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 210	java/util/HashSet
    //   8: dup
    //   9: invokespecial 211	java/util/HashSet:<init>	()V
    //   12: astore_2
    //   13: new 213	java/io/BufferedReader
    //   16: dup
    //   17: new 215	java/io/InputStreamReader
    //   20: dup
    //   21: new 151	java/io/FileInputStream
    //   24: dup
    //   25: ldc 217
    //   27: invokespecial 218	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   30: invokespecial 221	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   33: invokespecial 224	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore_3
    //   37: aconst_null
    //   38: astore_1
    //   39: aload_3
    //   40: invokevirtual 227	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore_0
    //   44: aload_0
    //   45: ifnull +88 -> 133
    //   48: aload_0
    //   49: ldc 229
    //   51: invokevirtual 233	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   54: ifeq -15 -> 39
    //   57: aload_0
    //   58: ldc 235
    //   60: invokevirtual 239	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   63: ifeq -24 -> 39
    //   66: aload_0
    //   67: ldc 241
    //   69: invokevirtual 245	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   72: astore_0
    //   73: aload_2
    //   74: aload_0
    //   75: aload_0
    //   76: arraylength
    //   77: iconst_1
    //   78: isub
    //   79: aaload
    //   80: invokeinterface 251 2 0
    //   85: pop
    //   86: goto -47 -> 39
    //   89: astore_1
    //   90: ldc 208
    //   92: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_1
    //   96: athrow
    //   97: astore_0
    //   98: aload_1
    //   99: ifnull +50 -> 149
    //   102: aload_3
    //   103: invokevirtual 252	java/io/BufferedReader:close	()V
    //   106: ldc 208
    //   108: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_0
    //   112: athrow
    //   113: astore_0
    //   114: ldc 116
    //   116: aload_0
    //   117: ldc 174
    //   119: iconst_0
    //   120: anewarray 4	java/lang/Object
    //   123: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: ldc 208
    //   128: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_2
    //   132: areturn
    //   133: aload_3
    //   134: invokevirtual 252	java/io/BufferedReader:close	()V
    //   137: goto -11 -> 126
    //   140: astore_3
    //   141: aload_1
    //   142: aload_3
    //   143: invokevirtual 182	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   146: goto -40 -> 106
    //   149: aload_3
    //   150: invokevirtual 252	java/io/BufferedReader:close	()V
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
  
  public static boolean fnj()
  {
    AppMethodBeat.i(200646);
    int i = cQO.decodeInt(GLn, 0);
    GLo = i;
    if ((i == 0) && (MMApplicationContext.isMainProcess()))
    {
      h.ZvG.bf(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(201210);
          Log.i("MicroMsg.performance.Utils", "[MEM] detectMaps");
          c.access$002(c.access$100());
          c.fnl().encode(c.GLn, c.GLo);
          Log.i("MicroMsg.performance.Utils", "[MEM] detectMaps = %d", new Object[] { Integer.valueOf(c.GLo) });
          AppMethodBeat.o(201210);
        }
      });
      AppMethodBeat.o(200646);
      return true;
    }
    Log.i("MicroMsg.performance.Utils", "[MEM] detect3GUserSpace = %d", new Object[] { Integer.valueOf(GLo) });
    if (GLo == 3)
    {
      AppMethodBeat.o(200646);
      return true;
    }
    AppMethodBeat.o(200646);
    return false;
  }
  
  /* Error */
  private static int fnk()
  {
    // Byte code:
    //   0: ldc_w 285
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 213	java/io/BufferedReader
    //   9: dup
    //   10: new 215	java/io/InputStreamReader
    //   13: dup
    //   14: new 151	java/io/FileInputStream
    //   17: dup
    //   18: ldc 217
    //   20: invokespecial 218	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   23: invokespecial 221	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   26: invokespecial 224	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   29: astore 4
    //   31: aconst_null
    //   32: astore_3
    //   33: aload 4
    //   35: invokevirtual 227	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +117 -> 157
    //   43: aload_2
    //   44: ldc_w 287
    //   47: invokevirtual 233	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   50: ifeq -17 -> 33
    //   53: aload_2
    //   54: ldc_w 289
    //   57: invokevirtual 245	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   60: astore 5
    //   62: aload 5
    //   64: arraylength
    //   65: ifle -32 -> 33
    //   68: aload 5
    //   70: iconst_0
    //   71: aaload
    //   72: ldc_w 291
    //   75: invokevirtual 245	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   78: astore 5
    //   80: aload 5
    //   82: arraylength
    //   83: iconst_2
    //   84: if_icmpne -51 -> 33
    //   87: aload 5
    //   89: iconst_0
    //   90: aaload
    //   91: bipush 16
    //   93: invokestatic 296	java/lang/Long:valueOf	(Ljava/lang/String;I)Ljava/lang/Long;
    //   96: invokevirtual 299	java/lang/Long:longValue	()J
    //   99: lstore_0
    //   100: ldc 116
    //   102: ldc_w 301
    //   105: iconst_2
    //   106: anewarray 4	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: lload_0
    //   112: invokestatic 304	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   115: aastore
    //   116: dup
    //   117: iconst_1
    //   118: aload_2
    //   119: aastore
    //   120: invokestatic 307	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: lload_0
    //   124: ldc2_w 308
    //   127: lcmp
    //   128: ifge +16 -> 144
    //   131: aload 4
    //   133: invokevirtual 252	java/io/BufferedReader:close	()V
    //   136: ldc_w 285
    //   139: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: iconst_3
    //   143: ireturn
    //   144: aload 4
    //   146: invokevirtual 252	java/io/BufferedReader:close	()V
    //   149: ldc_w 285
    //   152: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: iconst_4
    //   156: ireturn
    //   157: aload 4
    //   159: invokevirtual 252	java/io/BufferedReader:close	()V
    //   162: ldc_w 285
    //   165: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: iconst_3
    //   169: ireturn
    //   170: astore_3
    //   171: ldc_w 285
    //   174: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload_3
    //   178: athrow
    //   179: astore_2
    //   180: aload_3
    //   181: ifnull +44 -> 225
    //   184: aload 4
    //   186: invokevirtual 252	java/io/BufferedReader:close	()V
    //   189: ldc_w 285
    //   192: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: aload_2
    //   196: athrow
    //   197: astore_2
    //   198: ldc 116
    //   200: aload_2
    //   201: ldc_w 311
    //   204: iconst_0
    //   205: anewarray 4	java/lang/Object
    //   208: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: goto -49 -> 162
    //   214: astore 4
    //   216: aload_3
    //   217: aload 4
    //   219: invokevirtual 182	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   222: goto -33 -> 189
    //   225: aload 4
    //   227: invokevirtual 252	java/io/BufferedReader:close	()V
    //   230: goto -41 -> 189
    //   233: astore_2
    //   234: goto -54 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   99	25	0	l	long
    //   38	81	2	str	String
    //   179	17	2	localObject1	Object
    //   197	4	2	localThrowable1	java.lang.Throwable
    //   233	1	2	localObject2	Object
    //   32	1	3	localObject3	Object
    //   170	47	3	localThrowable2	java.lang.Throwable
    //   29	156	4	localBufferedReader	java.io.BufferedReader
    //   214	12	4	localThrowable3	java.lang.Throwable
    //   60	28	5	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   33	39	170	java/lang/Throwable
    //   43	123	170	java/lang/Throwable
    //   171	179	179	finally
    //   6	31	197	java/lang/Throwable
    //   131	136	197	java/lang/Throwable
    //   144	149	197	java/lang/Throwable
    //   157	162	197	java/lang/Throwable
    //   189	197	197	java/lang/Throwable
    //   216	222	197	java/lang/Throwable
    //   225	230	197	java/lang/Throwable
    //   184	189	214	java/lang/Throwable
    //   33	39	233	finally
    //   43	123	233	finally
  }
  
  /* Error */
  public static void g(String paramString, q paramq)
  {
    // Byte code:
    //   0: ldc_w 316
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 318
    //   10: iconst_2
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: aload_1
    //   17: invokevirtual 111	com/tencent/mm/vfs/q:getName	()Ljava/lang/String;
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: aload_1
    //   24: invokevirtual 321	com/tencent/mm/vfs/q:lastModified	()J
    //   27: invokestatic 323	com/tencent/mm/plugin/performance/c:OZ	(J)Ljava/lang/String;
    //   30: aastore
    //   31: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aload_1
    //   35: invokevirtual 130	com/tencent/mm/vfs/q:ifE	()Z
    //   38: ifeq +71 -> 109
    //   41: new 213	java/io/BufferedReader
    //   44: dup
    //   45: new 215	java/io/InputStreamReader
    //   48: dup
    //   49: aload_1
    //   50: invokestatic 327	com/tencent/mm/vfs/u:al	(Lcom/tencent/mm/vfs/q;)Ljava/io/InputStream;
    //   53: invokespecial 221	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   56: invokespecial 224	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   59: astore_3
    //   60: aload_3
    //   61: astore_2
    //   62: aload_3
    //   63: invokevirtual 227	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   66: astore 4
    //   68: aload 4
    //   70: ifnull +74 -> 144
    //   73: aload_3
    //   74: astore_2
    //   75: aload_0
    //   76: aload 4
    //   78: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: goto -21 -> 60
    //   84: astore 4
    //   86: aload_3
    //   87: astore_2
    //   88: aload_0
    //   89: aload 4
    //   91: ldc 174
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: aload_3
    //   101: invokestatic 336	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   104: aload_1
    //   105: invokevirtual 339	com/tencent/mm/vfs/q:cFq	()Z
    //   108: pop
    //   109: aload_0
    //   110: ldc_w 341
    //   113: iconst_2
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_1
    //   120: invokevirtual 111	com/tencent/mm/vfs/q:getName	()Ljava/lang/String;
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: aload_1
    //   127: invokevirtual 321	com/tencent/mm/vfs/q:lastModified	()J
    //   130: invokestatic 323	com/tencent/mm/plugin/performance/c:OZ	(J)Ljava/lang/String;
    //   133: aastore
    //   134: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: ldc_w 316
    //   140: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: return
    //   144: aload_3
    //   145: astore_2
    //   146: invokestatic 346	com/tencent/mm/sdk/platformtools/WeChatEnvironment:isMonkeyEnv	()Z
    //   149: ifne +27 -> 176
    //   152: aload_3
    //   153: astore_2
    //   154: invokestatic 349	com/tencent/mm/sdk/platformtools/WeChatEnvironment:hasDebugger	()Z
    //   157: ifne +19 -> 176
    //   160: aload_3
    //   161: astore_2
    //   162: getstatic 355	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   165: ifne +11 -> 176
    //   168: aload_3
    //   169: astore_2
    //   170: getstatic 358	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   173: ifeq +9 -> 182
    //   176: aload_3
    //   177: astore_2
    //   178: aload_1
    //   179: invokestatic 360	com/tencent/mm/plugin/performance/c:T	(Lcom/tencent/mm/vfs/q;)V
    //   182: aload_3
    //   183: invokestatic 336	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   186: aload_1
    //   187: invokevirtual 339	com/tencent/mm/vfs/q:cFq	()Z
    //   190: pop
    //   191: goto -82 -> 109
    //   194: astore_0
    //   195: aconst_null
    //   196: astore_2
    //   197: aload_2
    //   198: invokestatic 336	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   201: aload_1
    //   202: invokevirtual 339	com/tencent/mm/vfs/q:cFq	()Z
    //   205: pop
    //   206: ldc_w 316
    //   209: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload_0
    //   213: athrow
    //   214: astore_0
    //   215: goto -18 -> 197
    //   218: astore 4
    //   220: aconst_null
    //   221: astore_3
    //   222: goto -136 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramString	String
    //   0	225	1	paramq	q
    //   61	137	2	localBufferedReader1	java.io.BufferedReader
    //   59	163	3	localBufferedReader2	java.io.BufferedReader
    //   66	11	4	str	String
    //   84	6	4	localIOException1	java.io.IOException
    //   218	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   62	68	84	java/io/IOException
    //   75	81	84	java/io/IOException
    //   146	152	84	java/io/IOException
    //   154	160	84	java/io/IOException
    //   162	168	84	java/io/IOException
    //   170	176	84	java/io/IOException
    //   178	182	84	java/io/IOException
    //   41	60	194	finally
    //   62	68	214	finally
    //   75	81	214	finally
    //   88	100	214	finally
    //   146	152	214	finally
    //   154	160	214	finally
    //   162	168	214	finally
    //   170	176	214	finally
    //   178	182	214	finally
    //   41	60	218	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c
 * JD-Core Version:    0.7.0.1
 */