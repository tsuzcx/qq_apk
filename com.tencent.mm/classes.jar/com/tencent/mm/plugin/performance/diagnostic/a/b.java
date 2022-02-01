package com.tencent.mm.plugin.performance.diagnostic.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.a.d;

public final class b
{
  private static q U(q paramq)
  {
    AppMethodBeat.i(176895);
    paramq = new q(paramq.bOF());
    AppMethodBeat.o(176895);
    return paramq;
  }
  
  static q V(q paramq)
  {
    AppMethodBeat.i(176897);
    if (!paramq.ifC())
    {
      paramq = new IOException("cannot read file: " + paramq.bOF());
      AppMethodBeat.o(176897);
      throw paramq;
    }
    AppMethodBeat.o(176897);
    return paramq;
  }
  
  /* Error */
  public static void a(q paramq1, q paramq2, com.tencent.mm.vfs.s params)
  {
    // Byte code:
    //   0: ldc 51
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 53	java/util/zip/ZipOutputStream
    //   8: dup
    //   9: new 55	java/io/BufferedOutputStream
    //   12: dup
    //   13: aload_1
    //   14: invokestatic 61	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   17: invokespecial 64	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: invokespecial 65	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   23: astore_3
    //   24: new 67	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 70	java/util/ArrayList:<init>	()V
    //   31: astore 4
    //   33: aload_0
    //   34: invokestatic 72	com/tencent/mm/plugin/performance/diagnostic/a/b:U	(Lcom/tencent/mm/vfs/q;)Lcom/tencent/mm/vfs/q;
    //   37: astore 5
    //   39: aload 5
    //   41: invokevirtual 75	com/tencent/mm/vfs/q:isDirectory	()Z
    //   44: ifeq +161 -> 205
    //   47: aload 4
    //   49: aload 5
    //   51: aload_2
    //   52: invokevirtual 78	com/tencent/mm/vfs/q:a	(Lcom/tencent/mm/vfs/s;)[Lcom/tencent/mm/vfs/q;
    //   55: invokestatic 84	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   58: invokeinterface 90 2 0
    //   63: pop
    //   64: aload 4
    //   66: invokeinterface 93 1 0
    //   71: ifne +168 -> 239
    //   74: aload 4
    //   76: iconst_0
    //   77: invokeinterface 97 2 0
    //   82: checkcast 15	com/tencent/mm/vfs/q
    //   85: invokestatic 72	com/tencent/mm/plugin/performance/diagnostic/a/b:U	(Lcom/tencent/mm/vfs/q;)Lcom/tencent/mm/vfs/q;
    //   88: astore 6
    //   90: aload 6
    //   92: invokevirtual 19	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   95: aload 5
    //   97: invokevirtual 19	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   100: invokevirtual 103	java/lang/String:length	()I
    //   103: invokevirtual 107	java/lang/String:substring	(I)Ljava/lang/String;
    //   106: astore_1
    //   107: aload_1
    //   108: astore_0
    //   109: aload_1
    //   110: ldc 109
    //   112: invokevirtual 113	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   115: ifeq +9 -> 124
    //   118: aload_1
    //   119: iconst_1
    //   120: invokevirtual 107	java/lang/String:substring	(I)Ljava/lang/String;
    //   123: astore_0
    //   124: aload_0
    //   125: astore_1
    //   126: aload_0
    //   127: invokevirtual 114	java/lang/String:isEmpty	()Z
    //   130: ifeq +9 -> 139
    //   133: aload 6
    //   135: invokevirtual 117	com/tencent/mm/vfs/q:getName	()Ljava/lang/String;
    //   138: astore_1
    //   139: new 119	java/util/zip/ZipEntry
    //   142: dup
    //   143: aload_1
    //   144: invokespecial 120	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   147: astore_0
    //   148: aload_0
    //   149: bipush 8
    //   151: invokevirtual 123	java/util/zip/ZipEntry:setMethod	(I)V
    //   154: aload_3
    //   155: aload_0
    //   156: invokevirtual 127	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   159: aload 6
    //   161: invokevirtual 75	com/tencent/mm/vfs/q:isDirectory	()Z
    //   164: ifeq +54 -> 218
    //   167: aload 4
    //   169: aload 6
    //   171: aload_2
    //   172: invokevirtual 78	com/tencent/mm/vfs/q:a	(Lcom/tencent/mm/vfs/s;)[Lcom/tencent/mm/vfs/q;
    //   175: invokestatic 84	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   178: invokeinterface 90 2 0
    //   183: pop
    //   184: aload_3
    //   185: invokevirtual 130	java/util/zip/ZipOutputStream:closeEntry	()V
    //   188: goto -124 -> 64
    //   191: astore_0
    //   192: aload_3
    //   193: astore_1
    //   194: aload_1
    //   195: invokestatic 135	org/apache/commons/a/d:e	(Ljava/io/OutputStream;)V
    //   198: ldc 51
    //   200: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: aload_0
    //   204: athrow
    //   205: aload 4
    //   207: aload 5
    //   209: invokeinterface 139 2 0
    //   214: pop
    //   215: goto -151 -> 64
    //   218: aload 6
    //   220: aload_3
    //   221: invokestatic 142	com/tencent/mm/plugin/performance/diagnostic/a/b:a	(Lcom/tencent/mm/vfs/q;Ljava/io/OutputStream;)V
    //   224: goto -40 -> 184
    //   227: astore_0
    //   228: aload_3
    //   229: invokevirtual 130	java/util/zip/ZipOutputStream:closeEntry	()V
    //   232: ldc 51
    //   234: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload_0
    //   238: athrow
    //   239: aload_3
    //   240: invokestatic 135	org/apache/commons/a/d:e	(Ljava/io/OutputStream;)V
    //   243: ldc 51
    //   245: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: return
    //   249: astore_0
    //   250: aconst_null
    //   251: astore_1
    //   252: goto -58 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	paramq1	q
    //   0	255	1	paramq2	q
    //   0	255	2	params	com.tencent.mm.vfs.s
    //   23	217	3	localZipOutputStream	java.util.zip.ZipOutputStream
    //   31	175	4	localArrayList	java.util.ArrayList
    //   37	171	5	localq1	q
    //   88	131	6	localq2	q
    // Exception table:
    //   from	to	target	type
    //   24	64	191	finally
    //   64	107	191	finally
    //   109	124	191	finally
    //   126	139	191	finally
    //   139	154	191	finally
    //   184	188	191	finally
    //   205	215	191	finally
    //   228	239	191	finally
    //   154	184	227	finally
    //   218	224	227	finally
    //   5	24	249	finally
  }
  
  private static void a(q paramq, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(176898);
    byte[] arrayOfByte = new byte[4096];
    try
    {
      localBufferedInputStream = new BufferedInputStream(u.al(paramq));
      try
      {
        for (;;)
        {
          int i = localBufferedInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          paramOutputStream.write(arrayOfByte, 0, i);
        }
        paramOutputStream.flush();
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        BufferedInputStream localBufferedInputStream = null;
      }
    }
    d.T(localBufferedInputStream);
    AppMethodBeat.o(176898);
    throw paramq;
    paramOutputStream.flush();
    d.T(localBufferedInputStream);
    AppMethodBeat.o(176898);
  }
  
  static String aUo(String paramString)
  {
    AppMethodBeat.i(124914);
    if (TextUtils.equals(paramString, "armeabi"))
    {
      AppMethodBeat.o(124914);
      return "arm";
    }
    if (TextUtils.equals(paramString, "armeabi-v7a"))
    {
      AppMethodBeat.o(124914);
      return "arm";
    }
    if (TextUtils.equals(paramString, "arm64-v8a"))
    {
      AppMethodBeat.o(124914);
      return "arm64";
    }
    if (TextUtils.equals(paramString, "mips"))
    {
      AppMethodBeat.o(124914);
      return "mips";
    }
    if (TextUtils.equals(paramString, "mips64"))
    {
      AppMethodBeat.o(124914);
      return "mips64";
    }
    if (TextUtils.equals(paramString, "x86"))
    {
      AppMethodBeat.o(124914);
      return "x86";
    }
    if (TextUtils.equals(paramString, "x86_64"))
    {
      AppMethodBeat.o(124914);
      return "x86_64";
    }
    paramString = new IllegalArgumentException("unknown abi: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(124914);
    throw paramString;
  }
  
  /* Error */
  static int aUp(String paramString)
  {
    // Byte code:
    //   0: ldc 214
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 220	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   8: ldc 222
    //   10: invokevirtual 228	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   13: checkcast 230	android/app/ActivityManager
    //   16: astore 4
    //   18: aload 4
    //   20: ifnull +71 -> 91
    //   23: aload 4
    //   25: invokevirtual 234	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   28: astore 4
    //   30: aload 4
    //   32: ifnull +59 -> 91
    //   35: aload 4
    //   37: invokeinterface 238 1 0
    //   42: astore 4
    //   44: aload 4
    //   46: invokeinterface 243 1 0
    //   51: ifeq +40 -> 91
    //   54: aload 4
    //   56: invokeinterface 247 1 0
    //   61: checkcast 249	android/app/ActivityManager$RunningAppProcessInfo
    //   64: astore 5
    //   66: aload 5
    //   68: getfield 253	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   71: aload_0
    //   72: invokestatic 181	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   75: ifeq -31 -> 44
    //   78: aload 5
    //   80: getfield 257	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   83: istore_1
    //   84: ldc 214
    //   86: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: iload_1
    //   90: ireturn
    //   91: new 15	com/tencent/mm/vfs/q
    //   94: dup
    //   95: ldc_w 259
    //   98: invokespecial 23	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   101: invokevirtual 263	com/tencent/mm/vfs/q:ifJ	()[Lcom/tencent/mm/vfs/q;
    //   104: astore 6
    //   106: aload 6
    //   108: arraylength
    //   109: istore_2
    //   110: iconst_0
    //   111: istore_1
    //   112: iload_1
    //   113: iload_2
    //   114: if_icmpge +169 -> 283
    //   117: aload 6
    //   119: iload_1
    //   120: aaload
    //   121: astore 7
    //   123: aload 7
    //   125: invokevirtual 117	com/tencent/mm/vfs/q:getName	()Ljava/lang/String;
    //   128: invokestatic 267	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   131: ifeq +115 -> 246
    //   134: aload 7
    //   136: invokevirtual 33	com/tencent/mm/vfs/q:ifC	()Z
    //   139: ifeq +107 -> 246
    //   142: new 15	com/tencent/mm/vfs/q
    //   145: dup
    //   146: aload 7
    //   148: ldc_w 269
    //   151: invokespecial 272	com/tencent/mm/vfs/q:<init>	(Lcom/tencent/mm/vfs/q;Ljava/lang/String;)V
    //   154: astore 4
    //   156: aload 4
    //   158: invokevirtual 33	com/tencent/mm/vfs/q:ifC	()Z
    //   161: ifeq +85 -> 246
    //   164: aconst_null
    //   165: astore 5
    //   167: new 274	java/io/BufferedReader
    //   170: dup
    //   171: new 276	com/tencent/mm/vfs/x
    //   174: dup
    //   175: aload 4
    //   177: invokespecial 279	com/tencent/mm/vfs/x:<init>	(Lcom/tencent/mm/vfs/q;)V
    //   180: invokespecial 282	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   183: astore 4
    //   185: aload_0
    //   186: aload 4
    //   188: invokevirtual 285	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   191: invokevirtual 288	java/lang/String:trim	()Ljava/lang/String;
    //   194: invokevirtual 290	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   197: istore_3
    //   198: iload_3
    //   199: ifeq +42 -> 241
    //   202: aload 7
    //   204: invokevirtual 117	com/tencent/mm/vfs/q:getName	()Ljava/lang/String;
    //   207: invokevirtual 288	java/lang/String:trim	()Ljava/lang/String;
    //   210: bipush 10
    //   212: invokestatic 296	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   215: istore_1
    //   216: aload 4
    //   218: invokestatic 299	org/apache/commons/a/d:b	(Ljava/io/Reader;)V
    //   221: ldc 214
    //   223: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: iload_1
    //   227: ireturn
    //   228: astore_0
    //   229: aload 4
    //   231: invokestatic 299	org/apache/commons/a/d:b	(Ljava/io/Reader;)V
    //   234: ldc 214
    //   236: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: iconst_0
    //   240: ireturn
    //   241: aload 4
    //   243: invokestatic 299	org/apache/commons/a/d:b	(Ljava/io/Reader;)V
    //   246: iload_1
    //   247: iconst_1
    //   248: iadd
    //   249: istore_1
    //   250: goto -138 -> 112
    //   253: astore 4
    //   255: aload 5
    //   257: astore 4
    //   259: aload 4
    //   261: invokestatic 299	org/apache/commons/a/d:b	(Ljava/io/Reader;)V
    //   264: goto -18 -> 246
    //   267: astore_0
    //   268: aconst_null
    //   269: astore 4
    //   271: aload 4
    //   273: invokestatic 299	org/apache/commons/a/d:b	(Ljava/io/Reader;)V
    //   276: ldc 214
    //   278: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: aload_0
    //   282: athrow
    //   283: ldc 214
    //   285: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   288: iconst_0
    //   289: ireturn
    //   290: astore_0
    //   291: goto -20 -> 271
    //   294: astore 5
    //   296: goto -37 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	paramString	String
    //   83	167	1	i	int
    //   109	6	2	j	int
    //   197	2	3	bool	boolean
    //   16	226	4	localObject1	Object
    //   253	1	4	localThrowable1	java.lang.Throwable
    //   257	15	4	localObject2	Object
    //   64	192	5	localRunningAppProcessInfo	android.app.ActivityManager.RunningAppProcessInfo
    //   294	1	5	localThrowable2	java.lang.Throwable
    //   104	14	6	arrayOfq	q[]
    //   121	82	7	localq	q
    // Exception table:
    //   from	to	target	type
    //   202	216	228	java/lang/Throwable
    //   167	185	253	java/lang/Throwable
    //   167	185	267	finally
    //   185	198	290	finally
    //   202	216	290	finally
    //   185	198	294	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.a.b
 * JD-Core Version:    0.7.0.1
 */