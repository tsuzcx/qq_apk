package com.tencent.worddetect;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class b
{
  private static WordDetectNative aidf;
  private static WordDetectNative.ConfigParam aidg;
  private static com.tencent.mm.plugin.scanner.util.a.i aidh = null;
  private static boolean lYs = false;
  
  /* Error */
  public static void a(Context paramContext, String paramString, long paramLong, b paramb)
  {
    // Byte code:
    //   0: ldc 36
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 44	com/tencent/worddetect/b:aidg	Lcom/tencent/worddetect/WordDetectNative$ConfigParam;
    //   8: ifnonnull +10 -> 18
    //   11: aload_0
    //   12: invokestatic 48	com/tencent/worddetect/b:oN	(Landroid/content/Context;)Lcom/tencent/worddetect/WordDetectNative$ConfigParam;
    //   15: putstatic 44	com/tencent/worddetect/b:aidg	Lcom/tencent/worddetect/WordDetectNative$ConfigParam;
    //   18: getstatic 44	com/tencent/worddetect/b:aidg	Lcom/tencent/worddetect/WordDetectNative$ConfigParam;
    //   21: ifnonnull +16 -> 37
    //   24: ldc 50
    //   26: ldc 52
    //   28: invokestatic 58	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: ldc 36
    //   33: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: return
    //   37: getstatic 63	com/tencent/worddetect/b:aidf	Lcom/tencent/worddetect/WordDetectNative;
    //   40: ifnonnull +91 -> 131
    //   43: ldc 2
    //   45: monitorenter
    //   46: getstatic 63	com/tencent/worddetect/b:aidf	Lcom/tencent/worddetect/WordDetectNative;
    //   49: ifnull +9 -> 58
    //   52: getstatic 24	com/tencent/worddetect/b:lYs	Z
    //   55: ifne +73 -> 128
    //   58: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   61: lstore 8
    //   63: new 71	com/tencent/worddetect/WordDetectNative
    //   66: dup
    //   67: invokespecial 72	com/tencent/worddetect/WordDetectNative:<init>	()V
    //   70: astore_0
    //   71: aload_0
    //   72: putstatic 63	com/tencent/worddetect/b:aidf	Lcom/tencent/worddetect/WordDetectNative;
    //   75: aload_0
    //   76: getstatic 44	com/tencent/worddetect/b:aidg	Lcom/tencent/worddetect/WordDetectNative$ConfigParam;
    //   79: invokevirtual 76	com/tencent/worddetect/WordDetectNative:init	(Lcom/tencent/worddetect/WordDetectNative$ConfigParam;)I
    //   82: istore 5
    //   84: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   87: lstore 10
    //   89: iload 5
    //   91: iflt +65 -> 156
    //   94: iconst_1
    //   95: putstatic 24	com/tencent/worddetect/b:lYs	Z
    //   98: ldc 50
    //   100: ldc 78
    //   102: iconst_2
    //   103: anewarray 4	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: iload 5
    //   110: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: lload 10
    //   118: lload 8
    //   120: lsub
    //   121: invokestatic 89	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   124: aastore
    //   125: invokestatic 92	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: ldc 2
    //   130: monitorexit
    //   131: ldc 2
    //   133: monitorenter
    //   134: getstatic 24	com/tencent/worddetect/b:lYs	Z
    //   137: ifne +42 -> 179
    //   140: ldc 50
    //   142: ldc 94
    //   144: invokestatic 58	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: ldc 2
    //   149: monitorexit
    //   150: ldc 36
    //   152: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: return
    //   156: iconst_0
    //   157: putstatic 24	com/tencent/worddetect/b:lYs	Z
    //   160: iload 5
    //   162: invokestatic 99	com/tencent/worddetect/c:aJq	(I)V
    //   165: goto -67 -> 98
    //   168: astore_0
    //   169: ldc 2
    //   171: monitorexit
    //   172: ldc 36
    //   174: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload_0
    //   178: athrow
    //   179: ldc 2
    //   181: monitorexit
    //   182: aload_1
    //   183: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   186: ifeq +37 -> 223
    //   189: ldc 50
    //   191: ldc 107
    //   193: invokestatic 58	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload 4
    //   198: getstatic 111	com/tencent/worddetect/b$a:aidi	Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;
    //   201: invokeinterface 114 2 0
    //   206: ldc 36
    //   208: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: return
    //   212: astore_0
    //   213: ldc 2
    //   215: monitorexit
    //   216: ldc 36
    //   218: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_0
    //   222: athrow
    //   223: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   226: lstore 8
    //   228: getstatic 26	com/tencent/worddetect/b:aidh	Lcom/tencent/mm/plugin/scanner/util/a/i;
    //   231: ifnonnull +13 -> 244
    //   234: new 116	com/tencent/worddetect/a
    //   237: dup
    //   238: invokespecial 117	com/tencent/worddetect/a:<init>	()V
    //   241: putstatic 26	com/tencent/worddetect/b:aidh	Lcom/tencent/mm/plugin/scanner/util/a/i;
    //   244: new 119	com/tencent/mm/plugin/scanner/util/a/f
    //   247: dup
    //   248: aload_1
    //   249: lload_2
    //   250: invokespecial 122	com/tencent/mm/plugin/scanner/util/a/f:<init>	(Ljava/lang/String;J)V
    //   253: getstatic 26	com/tencent/worddetect/b:aidh	Lcom/tencent/mm/plugin/scanner/util/a/i;
    //   256: invokestatic 127	com/tencent/mm/plugin/scanner/util/a/e:a	(Lcom/tencent/mm/plugin/scanner/util/a/g;Lcom/tencent/mm/plugin/scanner/util/a/i;)Lcom/tencent/mm/plugin/scanner/util/a/h;
    //   259: astore_0
    //   260: aload_0
    //   261: getfield 133	com/tencent/mm/plugin/scanner/util/a/h:bitmap	Landroid/graphics/Bitmap;
    //   264: astore_0
    //   265: aload_0
    //   266: ifnonnull +22 -> 288
    //   269: ldc 50
    //   271: ldc 135
    //   273: invokestatic 58	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload 4
    //   278: aconst_null
    //   279: invokestatic 138	com/tencent/worddetect/b:a	(Lcom/tencent/worddetect/b$b;Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;)V
    //   282: ldc 36
    //   284: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   287: return
    //   288: aload_0
    //   289: invokestatic 142	com/tencent/worddetect/b:bi	(Landroid/graphics/Bitmap;)[B
    //   292: astore_1
    //   293: aload_1
    //   294: invokestatic 145	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   297: ifeq +27 -> 324
    //   300: ldc 50
    //   302: ldc 147
    //   304: invokestatic 58	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload 4
    //   309: getstatic 111	com/tencent/worddetect/b$a:aidi	Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;
    //   312: invokestatic 138	com/tencent/worddetect/b:a	(Lcom/tencent/worddetect/b$b;Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;)V
    //   315: invokestatic 150	com/tencent/worddetect/c:keN	()V
    //   318: ldc 36
    //   320: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   323: return
    //   324: aload_0
    //   325: invokevirtual 156	android/graphics/Bitmap:getWidth	()I
    //   328: istore 5
    //   330: aload_0
    //   331: invokevirtual 159	android/graphics/Bitmap:getHeight	()I
    //   334: istore 6
    //   336: getstatic 63	com/tencent/worddetect/b:aidf	Lcom/tencent/worddetect/WordDetectNative;
    //   339: aload_1
    //   340: iload 5
    //   342: iload 6
    //   344: iconst_3
    //   345: invokevirtual 163	com/tencent/worddetect/WordDetectNative:scanImage	([BIII)I
    //   348: istore 7
    //   350: ldc 50
    //   352: ldc 165
    //   354: iconst_5
    //   355: anewarray 4	java/lang/Object
    //   358: dup
    //   359: iconst_0
    //   360: aload_1
    //   361: arraylength
    //   362: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   365: aastore
    //   366: dup
    //   367: iconst_1
    //   368: iload 5
    //   370: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   373: aastore
    //   374: dup
    //   375: iconst_2
    //   376: iload 6
    //   378: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   381: aastore
    //   382: dup
    //   383: iconst_3
    //   384: iload 7
    //   386: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   389: aastore
    //   390: dup
    //   391: iconst_4
    //   392: lload_2
    //   393: invokestatic 89	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   396: aastore
    //   397: invokestatic 92	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   400: iload 7
    //   402: ifeq +22 -> 424
    //   405: aload 4
    //   407: getstatic 111	com/tencent/worddetect/b$a:aidi	Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;
    //   410: invokestatic 138	com/tencent/worddetect/b:a	(Lcom/tencent/worddetect/b$b;Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;)V
    //   413: iload 7
    //   415: invokestatic 168	com/tencent/worddetect/c:aJr	(I)V
    //   418: ldc 36
    //   420: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   423: return
    //   424: new 170	com/tencent/worddetect/WordDetectNative$WordDetectDetailResult
    //   427: dup
    //   428: invokespecial 171	com/tencent/worddetect/WordDetectNative$WordDetectDetailResult:<init>	()V
    //   431: astore_0
    //   432: getstatic 63	com/tencent/worddetect/b:aidf	Lcom/tencent/worddetect/WordDetectNative;
    //   435: aload_0
    //   436: invokevirtual 175	com/tencent/worddetect/WordDetectNative:getDetailResult	(Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;)I
    //   439: istore 5
    //   441: iload 5
    //   443: ifeq +22 -> 465
    //   446: aload 4
    //   448: getstatic 111	com/tencent/worddetect/b$a:aidi	Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;
    //   451: invokestatic 138	com/tencent/worddetect/b:a	(Lcom/tencent/worddetect/b$b;Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;)V
    //   454: iload 5
    //   456: invokestatic 178	com/tencent/worddetect/c:aJs	(I)V
    //   459: ldc 36
    //   461: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   464: return
    //   465: ldc 50
    //   467: ldc 180
    //   469: iconst_5
    //   470: anewarray 4	java/lang/Object
    //   473: dup
    //   474: iconst_0
    //   475: aload_0
    //   476: getfield 184	com/tencent/worddetect/WordDetectNative$WordDetectDetailResult:rate_lang	[F
    //   479: aastore
    //   480: dup
    //   481: iconst_1
    //   482: aload_0
    //   483: getfield 188	com/tencent/worddetect/WordDetectNative$WordDetectDetailResult:width	I
    //   486: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   489: aastore
    //   490: dup
    //   491: iconst_2
    //   492: aload_0
    //   493: getfield 191	com/tencent/worddetect/WordDetectNative$WordDetectDetailResult:height	I
    //   496: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   499: aastore
    //   500: dup
    //   501: iconst_3
    //   502: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   505: lload 8
    //   507: lsub
    //   508: invokestatic 89	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   511: aastore
    //   512: dup
    //   513: iconst_4
    //   514: lload_2
    //   515: invokestatic 89	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   518: aastore
    //   519: invokestatic 92	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   522: aload 4
    //   524: aload_0
    //   525: invokestatic 138	com/tencent/worddetect/b:a	(Lcom/tencent/worddetect/b$b;Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;)V
    //   528: ldc 36
    //   530: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   533: return
    //   534: astore_0
    //   535: invokestatic 194	com/tencent/worddetect/c:keO	()V
    //   538: ldc 50
    //   540: aload_0
    //   541: ldc 196
    //   543: iconst_0
    //   544: anewarray 4	java/lang/Object
    //   547: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   550: aload 4
    //   552: getstatic 111	com/tencent/worddetect/b$a:aidi	Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;
    //   555: invokestatic 138	com/tencent/worddetect/b:a	(Lcom/tencent/worddetect/b$b;Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;)V
    //   558: ldc 36
    //   560: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   563: return
    //   564: astore_0
    //   565: invokestatic 194	com/tencent/worddetect/c:keO	()V
    //   568: ldc 50
    //   570: aload_0
    //   571: ldc 202
    //   573: iconst_0
    //   574: anewarray 4	java/lang/Object
    //   577: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   580: goto -30 -> 550
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	paramContext	Context
    //   0	583	1	paramString	String
    //   0	583	2	paramLong	long
    //   0	583	4	paramb	b
    //   82	373	5	i	int
    //   334	43	6	j	int
    //   348	66	7	k	int
    //   61	445	8	l1	long
    //   87	30	10	l2	long
    // Exception table:
    //   from	to	target	type
    //   46	58	168	finally
    //   58	89	168	finally
    //   94	98	168	finally
    //   98	128	168	finally
    //   128	131	168	finally
    //   156	165	168	finally
    //   134	150	212	finally
    //   260	265	534	java/lang/Exception
    //   269	282	534	java/lang/Exception
    //   288	318	534	java/lang/Exception
    //   324	400	534	java/lang/Exception
    //   405	418	534	java/lang/Exception
    //   424	441	534	java/lang/Exception
    //   446	459	534	java/lang/Exception
    //   465	528	534	java/lang/Exception
    //   260	265	564	java/lang/Error
    //   269	282	564	java/lang/Error
    //   288	318	564	java/lang/Error
    //   324	400	564	java/lang/Error
    //   405	418	564	java/lang/Error
    //   424	441	564	java/lang/Error
    //   446	459	564	java/lang/Error
    //   465	528	564	java/lang/Error
  }
  
  private static void a(b paramb, WordDetectNative.WordDetectDetailResult paramWordDetectDetailResult)
  {
    AppMethodBeat.i(210679);
    if (paramb != null) {
      paramb.a(paramWordDetectDetailResult);
    }
    AppMethodBeat.o(210679);
  }
  
  private static byte[] bi(Bitmap paramBitmap)
  {
    AppMethodBeat.i(91187);
    try
    {
      Object localObject = ByteBuffer.allocate(paramBitmap.getByteCount());
      paramBitmap.copyPixelsToBuffer((Buffer)localObject);
      paramBitmap = ((ByteBuffer)localObject).array();
      localObject = new byte[paramBitmap.length / 4 * 3];
      int i = 0;
      while (i < paramBitmap.length / 4)
      {
        localObject[(i * 3)] = paramBitmap[(i * 4 + 2)];
        localObject[(i * 3 + 1)] = paramBitmap[(i * 4 + 1)];
        localObject[(i * 3 + 2)] = paramBitmap[(i * 4)];
        i += 1;
      }
      AppMethodBeat.o(91187);
      return localObject;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      AppMethodBeat.o(91187);
    }
    return null;
  }
  
  private static WordDetectNative.ConfigParam oN(Context paramContext)
  {
    AppMethodBeat.i(91186);
    try
    {
      String str1 = paramContext.getFilesDir().getAbsolutePath();
      Object localObject = new u(str1, "word_detect");
      if (!((u)localObject).jKS()) {
        ((u)localObject).jKY();
      }
      String str3 = ah.v(((u)localObject).jKT());
      localObject = str3 + "/net_fc.bin";
      String str2 = str3 + "/net_fc.param";
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("word_detect_mode_lib");
      boolean bool = localMultiProcessMMKV.getBoolean("word_detect_mode_version_2", false);
      Log.i("MicroMsg.WordDetectModHelper", "getWordDetectParam rootPath: %s, qBarRootPath: %s, version: %s, isCopy: %s", new Object[] { str1, str3, "word_detect_mode_version_2", Boolean.valueOf(bool) });
      if (!bool)
      {
        y.deleteFile((String)localObject);
        y.deleteFile(str2);
        localMultiProcessMMKV.putBoolean("word_detect_mode_version_2", true);
      }
      if ((!bool) || (!y.ZC((String)localObject)))
      {
        Log.i("MicroMsg.WordDetectModHelper", "getWordDetectParam copy model file from assets");
        FilesCopy.copyAssets(paramContext, "qbar/net_fc.bin", (String)localObject);
        FilesCopy.copyAssets(paramContext, "qbar/net_fc.param", str2);
      }
      paramContext = new WordDetectNative.ConfigParam();
      paramContext.detect_model_bin = ((String)localObject);
      paramContext.detect_model_param = str2;
      AppMethodBeat.o(91186);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.w("MicroMsg.WordDetectModHelper", "getWordDetectParam err %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(91186);
    }
    return null;
  }
  
  public static void release()
  {
    AppMethodBeat.i(210681);
    h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210632);
        try
        {
          if ((b.lYs) && (b.keL() != null))
          {
            Log.i("MicroMsg.WordDetectModHelper", "releaseWordDetect");
            b.keL().release();
            b.keM();
            b.aAs();
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(210632);
        }
      }
    }, "WordDetectThread");
    AppMethodBeat.o(210681);
  }
  
  public static abstract interface a
  {
    public static final WordDetectNative.WordDetectDetailResult aidi = new WordDetectNative.WordDetectDetailResult();
  }
  
  public static abstract interface b
  {
    public abstract void a(WordDetectNative.WordDetectDetailResult paramWordDetectDetailResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.worddetect.b
 * JD-Core Version:    0.7.0.1
 */