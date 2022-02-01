package com.tencent.mm.plugin.performance;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.n.d;

public final class c
{
  private static final String MIi;
  private static int MIj;
  private static final MultiProcessMMKV eMf;
  
  static
  {
    AppMethodBeat.i(300841);
    eMf = MultiProcessMMKV.getMMKV("diagnostic_storage");
    MIi = "KEY_USER_MEM_CAP_INT_" + Build.FINGERPRINT;
    AppMethodBeat.o(300841);
  }
  
  public static void V(u paramu)
  {
    AppMethodBeat.i(300812);
    u localu1 = new u(MMApplicationContext.getContext().getExternalCacheDir() + "/Diagnostic");
    u localu2 = new u(localu1, paramu.getName());
    Log.i("MicroMsg.performance.Utils", "DevEnv: copy [%s] to sdcard [%s]", new Object[] { ah.v(paramu.jKT()), ah.v(localu2.jKT()) });
    if (!localu1.jKS()) {
      localu1.jKY();
    }
    y.qn(ah.v(paramu.jKT()), ah.v(localu2.jKT()));
    AppMethodBeat.o(300812);
  }
  
  /* Error */
  private static String a(String paramString, java.nio.charset.Charset paramCharset)
  {
    // Byte code:
    //   0: ldc 126
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 128	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: new 131	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 134	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore 4
    //   24: aload_0
    //   25: invokevirtual 138	java/io/File:length	()J
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
    //   48: invokevirtual 144	java/io/InputStream:read	([BII)I
    //   51: istore_3
    //   52: iload_3
    //   53: iconst_m1
    //   54: if_icmpeq +10 -> 64
    //   57: iload_2
    //   58: iload_3
    //   59: iadd
    //   60: istore_2
    //   61: goto -27 -> 34
    //   64: new 146	java/lang/String
    //   67: dup
    //   68: aload_0
    //   69: aload_1
    //   70: invokespecial 149	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   73: astore_0
    //   74: aload 4
    //   76: invokevirtual 152	java/io/InputStream:close	()V
    //   79: ldc 126
    //   81: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_0
    //   85: areturn
    //   86: astore_0
    //   87: aload 4
    //   89: invokevirtual 152	java/io/InputStream:close	()V
    //   92: ldc 126
    //   94: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_0
    //   98: athrow
    //   99: astore_1
    //   100: aconst_null
    //   101: astore_0
    //   102: ldc 91
    //   104: aload_1
    //   105: ldc 154
    //   107: iconst_0
    //   108: anewarray 4	java/lang/Object
    //   111: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: goto -35 -> 79
    //   117: astore_1
    //   118: aload_0
    //   119: aload_1
    //   120: invokevirtual 164	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   123: goto -31 -> 92
    //   126: astore_1
    //   127: goto -25 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramString	String
    //   0	130	1	paramCharset	java.nio.charset.Charset
    //   33	28	2	i	int
    //   51	9	3	j	int
    //   22	66	4	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   24	32	86	finally
    //   34	52	86	finally
    //   64	74	86	finally
    //   14	24	99	java/io/IOException
    //   92	99	99	java/io/IOException
    //   118	123	99	java/io/IOException
    //   87	92	117	finally
    //   74	79	126	java/io/IOException
  }
  
  public static String aRp(String paramString)
  {
    AppMethodBeat.i(300801);
    paramString = a(paramString, d.UTF_8);
    AppMethodBeat.o(300801);
    return paramString;
  }
  
  /* Error */
  public static void g(String paramString, u paramu)
  {
    // Byte code:
    //   0: ldc 190
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 192
    //   8: iconst_2
    //   9: anewarray 4	java/lang/Object
    //   12: dup
    //   13: iconst_0
    //   14: aload_1
    //   15: invokevirtual 86	com/tencent/mm/vfs/u:getName	()Ljava/lang/String;
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: aload_1
    //   22: invokevirtual 195	com/tencent/mm/vfs/u:lastModified	()J
    //   25: invokestatic 199	com/tencent/mm/plugin/performance/c:tc	(J)Ljava/lang/String;
    //   28: aastore
    //   29: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: aload_1
    //   33: invokevirtual 112	com/tencent/mm/vfs/u:jKS	()Z
    //   36: ifeq +71 -> 107
    //   39: new 201	java/io/BufferedReader
    //   42: dup
    //   43: new 203	java/io/InputStreamReader
    //   46: dup
    //   47: aload_1
    //   48: invokestatic 207	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   51: invokespecial 210	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   54: invokespecial 213	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   57: astore_3
    //   58: aload_3
    //   59: astore_2
    //   60: aload_3
    //   61: invokevirtual 216	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   64: astore 4
    //   66: aload 4
    //   68: ifnull +72 -> 140
    //   71: aload_3
    //   72: astore_2
    //   73: aload_0
    //   74: aload 4
    //   76: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: goto -21 -> 58
    //   82: astore 4
    //   84: aload_3
    //   85: astore_2
    //   86: aload_0
    //   87: aload 4
    //   89: ldc 154
    //   91: iconst_0
    //   92: anewarray 4	java/lang/Object
    //   95: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: aload_3
    //   99: invokestatic 225	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   102: aload_1
    //   103: invokevirtual 228	com/tencent/mm/vfs/u:diJ	()Z
    //   106: pop
    //   107: aload_0
    //   108: ldc 230
    //   110: iconst_2
    //   111: anewarray 4	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_1
    //   117: invokevirtual 86	com/tencent/mm/vfs/u:getName	()Ljava/lang/String;
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: aload_1
    //   124: invokevirtual 195	com/tencent/mm/vfs/u:lastModified	()J
    //   127: invokestatic 199	com/tencent/mm/plugin/performance/c:tc	(J)Ljava/lang/String;
    //   130: aastore
    //   131: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: ldc 190
    //   136: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: return
    //   140: aload_3
    //   141: astore_2
    //   142: invokestatic 235	com/tencent/mm/sdk/platformtools/WeChatEnvironment:isMonkeyEnv	()Z
    //   145: ifne +27 -> 172
    //   148: aload_3
    //   149: astore_2
    //   150: invokestatic 238	com/tencent/mm/sdk/platformtools/WeChatEnvironment:hasDebugger	()Z
    //   153: ifne +19 -> 172
    //   156: aload_3
    //   157: astore_2
    //   158: getstatic 244	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   161: ifne +11 -> 172
    //   164: aload_3
    //   165: astore_2
    //   166: getstatic 247	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   169: ifeq +9 -> 178
    //   172: aload_3
    //   173: astore_2
    //   174: aload_1
    //   175: invokestatic 249	com/tencent/mm/plugin/performance/c:V	(Lcom/tencent/mm/vfs/u;)V
    //   178: aload_3
    //   179: invokestatic 225	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   182: aload_1
    //   183: invokevirtual 228	com/tencent/mm/vfs/u:diJ	()Z
    //   186: pop
    //   187: goto -80 -> 107
    //   190: astore_0
    //   191: aconst_null
    //   192: astore_2
    //   193: aload_2
    //   194: invokestatic 225	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   197: aload_1
    //   198: invokevirtual 228	com/tencent/mm/vfs/u:diJ	()Z
    //   201: pop
    //   202: ldc 190
    //   204: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: aload_0
    //   208: athrow
    //   209: astore_0
    //   210: goto -17 -> 193
    //   213: astore 4
    //   215: aconst_null
    //   216: astore_3
    //   217: goto -133 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramString	String
    //   0	220	1	paramu	u
    //   59	135	2	localBufferedReader1	java.io.BufferedReader
    //   57	160	3	localBufferedReader2	java.io.BufferedReader
    //   64	11	4	str	String
    //   82	6	4	localIOException1	java.io.IOException
    //   213	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   60	66	82	java/io/IOException
    //   73	79	82	java/io/IOException
    //   142	148	82	java/io/IOException
    //   150	156	82	java/io/IOException
    //   158	164	82	java/io/IOException
    //   166	172	82	java/io/IOException
    //   174	178	82	java/io/IOException
    //   39	58	190	finally
    //   60	66	209	finally
    //   73	79	209	finally
    //   86	98	209	finally
    //   142	148	209	finally
    //   150	156	209	finally
    //   158	164	209	finally
    //   166	172	209	finally
    //   174	178	209	finally
    //   39	58	213	java/io/IOException
  }
  
  /* Error */
  public static java.util.Set<String> gxV()
  {
    // Byte code:
    //   0: ldc 252
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 254	java/util/HashSet
    //   8: dup
    //   9: invokespecial 255	java/util/HashSet:<init>	()V
    //   12: astore_0
    //   13: new 201	java/io/BufferedReader
    //   16: dup
    //   17: new 203	java/io/InputStreamReader
    //   20: dup
    //   21: new 131	java/io/FileInputStream
    //   24: dup
    //   25: ldc_w 257
    //   28: invokespecial 258	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   31: invokespecial 210	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   34: invokespecial 213	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual 216	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull +79 -> 123
    //   47: aload_2
    //   48: ldc_w 260
    //   51: invokevirtual 264	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   54: ifeq -16 -> 38
    //   57: aload_2
    //   58: ldc_w 266
    //   61: invokevirtual 270	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   64: ifeq -26 -> 38
    //   67: aload_2
    //   68: ldc_w 272
    //   71: invokevirtual 276	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   74: astore_2
    //   75: aload_0
    //   76: aload_2
    //   77: aload_2
    //   78: arraylength
    //   79: iconst_1
    //   80: isub
    //   81: aaload
    //   82: invokeinterface 282 2 0
    //   87: pop
    //   88: goto -50 -> 38
    //   91: astore_2
    //   92: aload_1
    //   93: invokevirtual 283	java/io/BufferedReader:close	()V
    //   96: ldc 252
    //   98: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_2
    //   102: athrow
    //   103: astore_1
    //   104: ldc 91
    //   106: aload_1
    //   107: ldc 154
    //   109: iconst_0
    //   110: anewarray 4	java/lang/Object
    //   113: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: ldc 252
    //   118: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_0
    //   122: areturn
    //   123: aload_1
    //   124: invokevirtual 283	java/io/BufferedReader:close	()V
    //   127: goto -11 -> 116
    //   130: astore_1
    //   131: aload_2
    //   132: aload_1
    //   133: invokevirtual 164	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   136: goto -40 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	110	0	localHashSet	java.util.HashSet
    //   37	56	1	localBufferedReader	java.io.BufferedReader
    //   103	21	1	localIOException	java.io.IOException
    //   130	3	1	localThrowable	java.lang.Throwable
    //   42	36	2	localObject1	Object
    //   91	41	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   38	43	91	finally
    //   47	88	91	finally
    //   13	38	103	java/io/IOException
    //   96	103	103	java/io/IOException
    //   123	127	103	java/io/IOException
    //   131	136	103	java/io/IOException
    //   92	96	130	finally
  }
  
  public static boolean gxW()
  {
    AppMethodBeat.i(300819);
    int i = eMf.decodeInt(MIi, 0);
    MIj = i;
    if ((i == 0) && (MMApplicationContext.isMainProcess()))
    {
      h.ahAA.bn(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(300797);
          Log.i("MicroMsg.performance.Utils", "[MEM] detectMaps");
          c.access$002(c.access$100());
          c.gxY().encode(c.MIi, c.MIj);
          Log.i("MicroMsg.performance.Utils", "[MEM] detectMaps = %d", new Object[] { Integer.valueOf(c.MIj) });
          AppMethodBeat.o(300797);
        }
      });
      AppMethodBeat.o(300819);
      return true;
    }
    Log.i("MicroMsg.performance.Utils", "[MEM] detect3GUserSpace = %d", new Object[] { Integer.valueOf(MIj) });
    if (MIj == 3)
    {
      AppMethodBeat.o(300819);
      return true;
    }
    AppMethodBeat.o(300819);
    return false;
  }
  
  /* Error */
  private static int gxX()
  {
    // Byte code:
    //   0: ldc_w 316
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 201	java/io/BufferedReader
    //   9: dup
    //   10: new 203	java/io/InputStreamReader
    //   13: dup
    //   14: new 131	java/io/FileInputStream
    //   17: dup
    //   18: ldc_w 257
    //   21: invokespecial 258	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   24: invokespecial 210	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   27: invokespecial 213	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   30: astore_2
    //   31: aload_2
    //   32: invokevirtual 216	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   35: astore_3
    //   36: aload_3
    //   37: ifnull +115 -> 152
    //   40: aload_3
    //   41: ldc_w 318
    //   44: invokevirtual 264	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   47: ifeq -16 -> 31
    //   50: aload_3
    //   51: ldc_w 320
    //   54: invokevirtual 276	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   57: astore 4
    //   59: aload 4
    //   61: arraylength
    //   62: ifle -31 -> 31
    //   65: aload 4
    //   67: iconst_0
    //   68: aaload
    //   69: ldc_w 322
    //   72: invokevirtual 276	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   75: astore 4
    //   77: aload 4
    //   79: arraylength
    //   80: iconst_2
    //   81: if_icmpne -50 -> 31
    //   84: aload 4
    //   86: iconst_0
    //   87: aaload
    //   88: bipush 16
    //   90: invokestatic 327	java/lang/Long:valueOf	(Ljava/lang/String;I)Ljava/lang/Long;
    //   93: invokevirtual 330	java/lang/Long:longValue	()J
    //   96: lstore_0
    //   97: ldc 91
    //   99: ldc_w 332
    //   102: iconst_2
    //   103: anewarray 4	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: lload_0
    //   109: invokestatic 335	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: aload_3
    //   116: aastore
    //   117: invokestatic 338	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: lload_0
    //   121: ldc2_w 339
    //   124: lcmp
    //   125: ifge +15 -> 140
    //   128: aload_2
    //   129: invokevirtual 283	java/io/BufferedReader:close	()V
    //   132: ldc_w 316
    //   135: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: iconst_3
    //   139: ireturn
    //   140: aload_2
    //   141: invokevirtual 283	java/io/BufferedReader:close	()V
    //   144: ldc_w 316
    //   147: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: iconst_4
    //   151: ireturn
    //   152: aload_2
    //   153: invokevirtual 283	java/io/BufferedReader:close	()V
    //   156: ldc_w 316
    //   159: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: iconst_3
    //   163: ireturn
    //   164: astore_3
    //   165: aload_2
    //   166: invokevirtual 283	java/io/BufferedReader:close	()V
    //   169: ldc_w 316
    //   172: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload_3
    //   176: athrow
    //   177: astore_2
    //   178: ldc 91
    //   180: aload_2
    //   181: ldc_w 342
    //   184: iconst_0
    //   185: anewarray 4	java/lang/Object
    //   188: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: goto -35 -> 156
    //   194: astore_2
    //   195: aload_3
    //   196: aload_2
    //   197: invokevirtual 164	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   200: goto -31 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   96	25	0	l	long
    //   30	136	2	localBufferedReader	java.io.BufferedReader
    //   177	4	2	localThrowable1	java.lang.Throwable
    //   194	3	2	localThrowable2	java.lang.Throwable
    //   35	81	3	str	String
    //   164	32	3	localObject	Object
    //   57	28	4	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   31	36	164	finally
    //   40	120	164	finally
    //   6	31	177	finally
    //   128	132	177	finally
    //   140	144	177	finally
    //   152	156	177	finally
    //   169	177	177	finally
    //   195	200	177	finally
    //   165	169	194	finally
  }
  
  public static String tc(long paramLong)
  {
    AppMethodBeat.i(300795);
    String str = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(paramLong));
    AppMethodBeat.o(300795);
    return str;
  }
  
  public static String v(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(300826);
    if (paramArrayOfObject == null)
    {
      AppMethodBeat.o(300826);
      return "null";
    }
    int j = paramArrayOfObject.length - 1;
    if (j == -1)
    {
      AppMethodBeat.o(300826);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      localStringBuilder.append(String.valueOf(paramArrayOfObject[i]));
      if (i == j)
      {
        paramArrayOfObject = localStringBuilder.toString();
        AppMethodBeat.o(300826);
        return paramArrayOfObject;
      }
      localStringBuilder.append(";");
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c
 * JD-Core Version:    0.7.0.1
 */