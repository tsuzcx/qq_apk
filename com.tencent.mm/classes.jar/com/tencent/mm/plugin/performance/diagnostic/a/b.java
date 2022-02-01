package com.tencent.mm.plugin.performance.diagnostic.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.a.d;

public final class b
{
  private static e O(e parame)
  {
    AppMethodBeat.i(176895);
    parame = new e(q.B(parame.fhU()));
    AppMethodBeat.o(176895);
    return parame;
  }
  
  static e P(e parame)
  {
    AppMethodBeat.i(176897);
    if (!parame.canRead())
    {
      parame = new IOException("cannot read file: " + q.B(parame.fhU()));
      AppMethodBeat.o(176897);
      throw parame;
    }
    AppMethodBeat.o(176897);
    return parame;
  }
  
  /* Error */
  public static void a(e parame1, e parame2, com.tencent.mm.vfs.g paramg)
  {
    // Byte code:
    //   0: ldc 58
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 60	java/util/zip/ZipOutputStream
    //   8: dup
    //   9: new 62	java/io/BufferedOutputStream
    //   12: dup
    //   13: aload_1
    //   14: invokestatic 68	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   17: invokespecial 71	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: invokespecial 72	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   23: astore_3
    //   24: new 74	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 77	java/util/ArrayList:<init>	()V
    //   31: astore 4
    //   33: aload_0
    //   34: invokestatic 79	com/tencent/mm/plugin/performance/diagnostic/a/b:O	(Lcom/tencent/mm/vfs/e;)Lcom/tencent/mm/vfs/e;
    //   37: astore 5
    //   39: aload 5
    //   41: invokevirtual 82	com/tencent/mm/vfs/e:isDirectory	()Z
    //   44: ifeq +167 -> 211
    //   47: aload 4
    //   49: aload 5
    //   51: aload_2
    //   52: invokevirtual 85	com/tencent/mm/vfs/e:a	(Lcom/tencent/mm/vfs/g;)[Lcom/tencent/mm/vfs/e;
    //   55: invokestatic 91	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   58: invokeinterface 97 2 0
    //   63: pop
    //   64: aload 4
    //   66: invokeinterface 100 1 0
    //   71: ifne +174 -> 245
    //   74: aload 4
    //   76: iconst_0
    //   77: invokeinterface 104 2 0
    //   82: checkcast 15	com/tencent/mm/vfs/e
    //   85: invokestatic 79	com/tencent/mm/plugin/performance/diagnostic/a/b:O	(Lcom/tencent/mm/vfs/e;)Lcom/tencent/mm/vfs/e;
    //   88: astore 6
    //   90: aload 6
    //   92: invokevirtual 19	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   95: invokestatic 25	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   98: aload 5
    //   100: invokevirtual 19	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   103: invokestatic 25	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   106: invokevirtual 110	java/lang/String:length	()I
    //   109: invokevirtual 114	java/lang/String:substring	(I)Ljava/lang/String;
    //   112: astore_1
    //   113: aload_1
    //   114: astore_0
    //   115: aload_1
    //   116: ldc 116
    //   118: invokevirtual 120	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   121: ifeq +9 -> 130
    //   124: aload_1
    //   125: iconst_1
    //   126: invokevirtual 114	java/lang/String:substring	(I)Ljava/lang/String;
    //   129: astore_0
    //   130: aload_0
    //   131: astore_1
    //   132: aload_0
    //   133: invokevirtual 121	java/lang/String:isEmpty	()Z
    //   136: ifeq +9 -> 145
    //   139: aload 6
    //   141: invokevirtual 124	com/tencent/mm/vfs/e:getName	()Ljava/lang/String;
    //   144: astore_1
    //   145: new 126	java/util/zip/ZipEntry
    //   148: dup
    //   149: aload_1
    //   150: invokespecial 127	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   153: astore_0
    //   154: aload_0
    //   155: bipush 8
    //   157: invokevirtual 130	java/util/zip/ZipEntry:setMethod	(I)V
    //   160: aload_3
    //   161: aload_0
    //   162: invokevirtual 134	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   165: aload 6
    //   167: invokevirtual 82	com/tencent/mm/vfs/e:isDirectory	()Z
    //   170: ifeq +54 -> 224
    //   173: aload 4
    //   175: aload 6
    //   177: aload_2
    //   178: invokevirtual 85	com/tencent/mm/vfs/e:a	(Lcom/tencent/mm/vfs/g;)[Lcom/tencent/mm/vfs/e;
    //   181: invokestatic 91	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   184: invokeinterface 97 2 0
    //   189: pop
    //   190: aload_3
    //   191: invokevirtual 137	java/util/zip/ZipOutputStream:closeEntry	()V
    //   194: goto -130 -> 64
    //   197: astore_0
    //   198: aload_3
    //   199: astore_1
    //   200: aload_1
    //   201: invokestatic 142	org/apache/commons/a/d:e	(Ljava/io/OutputStream;)V
    //   204: ldc 58
    //   206: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: aload_0
    //   210: athrow
    //   211: aload 4
    //   213: aload 5
    //   215: invokeinterface 146 2 0
    //   220: pop
    //   221: goto -157 -> 64
    //   224: aload 6
    //   226: aload_3
    //   227: invokestatic 149	com/tencent/mm/plugin/performance/diagnostic/a/b:a	(Lcom/tencent/mm/vfs/e;Ljava/io/OutputStream;)V
    //   230: goto -40 -> 190
    //   233: astore_0
    //   234: aload_3
    //   235: invokevirtual 137	java/util/zip/ZipOutputStream:closeEntry	()V
    //   238: ldc 58
    //   240: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: aload_0
    //   244: athrow
    //   245: aload_3
    //   246: invokestatic 142	org/apache/commons/a/d:e	(Ljava/io/OutputStream;)V
    //   249: ldc 58
    //   251: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: return
    //   255: astore_0
    //   256: aconst_null
    //   257: astore_1
    //   258: goto -58 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	parame1	e
    //   0	261	1	parame2	e
    //   0	261	2	paramg	com.tencent.mm.vfs.g
    //   23	223	3	localZipOutputStream	java.util.zip.ZipOutputStream
    //   31	181	4	localArrayList	java.util.ArrayList
    //   37	177	5	locale1	e
    //   88	137	6	locale2	e
    // Exception table:
    //   from	to	target	type
    //   24	64	197	finally
    //   64	113	197	finally
    //   115	130	197	finally
    //   132	145	197	finally
    //   145	160	197	finally
    //   190	194	197	finally
    //   211	221	197	finally
    //   234	245	197	finally
    //   160	190	233	finally
    //   224	230	233	finally
    //   5	24	255	finally
  }
  
  private static void a(e parame, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(176898);
    byte[] arrayOfByte = new byte[4096];
    try
    {
      localBufferedInputStream = new BufferedInputStream(i.ah(parame));
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
    d.X(localBufferedInputStream);
    AppMethodBeat.o(176898);
    throw parame;
    paramOutputStream.flush();
    d.X(localBufferedInputStream);
    AppMethodBeat.o(176898);
  }
  
  static String akl(String paramString)
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
  static int akm(String paramString)
  {
    // Byte code:
    //   0: ldc 221
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 227	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   8: ldc 229
    //   10: invokevirtual 235	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   13: checkcast 237	android/app/ActivityManager
    //   16: astore 4
    //   18: aload 4
    //   20: ifnull +71 -> 91
    //   23: aload 4
    //   25: invokevirtual 241	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   28: astore 4
    //   30: aload 4
    //   32: ifnull +59 -> 91
    //   35: aload 4
    //   37: invokeinterface 245 1 0
    //   42: astore 4
    //   44: aload 4
    //   46: invokeinterface 250 1 0
    //   51: ifeq +40 -> 91
    //   54: aload 4
    //   56: invokeinterface 254 1 0
    //   61: checkcast 256	android/app/ActivityManager$RunningAppProcessInfo
    //   64: astore 5
    //   66: aload 5
    //   68: getfield 260	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   71: aload_0
    //   72: invokestatic 188	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   75: ifeq -31 -> 44
    //   78: aload 5
    //   80: getfield 264	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   83: istore_1
    //   84: ldc 221
    //   86: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: iload_1
    //   90: ireturn
    //   91: new 15	com/tencent/mm/vfs/e
    //   94: dup
    //   95: ldc_w 266
    //   98: invokespecial 29	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   101: invokevirtual 270	com/tencent/mm/vfs/e:fhW	()[Lcom/tencent/mm/vfs/e;
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
    //   125: invokevirtual 124	com/tencent/mm/vfs/e:getName	()Ljava/lang/String;
    //   128: invokestatic 274	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   131: ifeq +115 -> 246
    //   134: aload 7
    //   136: invokevirtual 39	com/tencent/mm/vfs/e:canRead	()Z
    //   139: ifeq +107 -> 246
    //   142: new 15	com/tencent/mm/vfs/e
    //   145: dup
    //   146: aload 7
    //   148: ldc_w 276
    //   151: invokespecial 279	com/tencent/mm/vfs/e:<init>	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)V
    //   154: astore 4
    //   156: aload 4
    //   158: invokevirtual 39	com/tencent/mm/vfs/e:canRead	()Z
    //   161: ifeq +85 -> 246
    //   164: aconst_null
    //   165: astore 5
    //   167: new 281	java/io/BufferedReader
    //   170: dup
    //   171: new 283	com/tencent/mm/vfs/k
    //   174: dup
    //   175: aload 4
    //   177: invokespecial 286	com/tencent/mm/vfs/k:<init>	(Lcom/tencent/mm/vfs/e;)V
    //   180: invokespecial 289	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   183: astore 4
    //   185: aload_0
    //   186: aload 4
    //   188: invokevirtual 292	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   191: invokevirtual 295	java/lang/String:trim	()Ljava/lang/String;
    //   194: invokevirtual 297	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   197: istore_3
    //   198: iload_3
    //   199: ifeq +42 -> 241
    //   202: aload 7
    //   204: invokevirtual 124	com/tencent/mm/vfs/e:getName	()Ljava/lang/String;
    //   207: invokevirtual 295	java/lang/String:trim	()Ljava/lang/String;
    //   210: bipush 10
    //   212: invokestatic 303	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   215: istore_1
    //   216: aload 4
    //   218: invokestatic 305	org/apache/commons/a/d:a	(Ljava/io/Reader;)V
    //   221: ldc 221
    //   223: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: iload_1
    //   227: ireturn
    //   228: astore_0
    //   229: aload 4
    //   231: invokestatic 305	org/apache/commons/a/d:a	(Ljava/io/Reader;)V
    //   234: ldc 221
    //   236: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: iconst_0
    //   240: ireturn
    //   241: aload 4
    //   243: invokestatic 305	org/apache/commons/a/d:a	(Ljava/io/Reader;)V
    //   246: iload_1
    //   247: iconst_1
    //   248: iadd
    //   249: istore_1
    //   250: goto -138 -> 112
    //   253: astore 4
    //   255: aload 5
    //   257: astore 4
    //   259: aload 4
    //   261: invokestatic 305	org/apache/commons/a/d:a	(Ljava/io/Reader;)V
    //   264: goto -18 -> 246
    //   267: astore_0
    //   268: aconst_null
    //   269: astore 4
    //   271: aload 4
    //   273: invokestatic 305	org/apache/commons/a/d:a	(Ljava/io/Reader;)V
    //   276: ldc 221
    //   278: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: aload_0
    //   282: athrow
    //   283: ldc 221
    //   285: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   104	14	6	arrayOfe	e[]
    //   121	82	7	locale	e
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.a.b
 * JD-Core Version:    0.7.0.1
 */