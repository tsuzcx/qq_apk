package com.tencent.worddetect;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class b
{
  private static WordDetectNative ZYB;
  private static WordDetectNative.ConfigParam ZYC;
  private static com.tencent.mm.plugin.scanner.util.a.i ZYD = null;
  private static boolean jvb = false;
  
  /* Error */
  public static void a(Context paramContext, String paramString, long paramLong, b.b paramb)
  {
    // Byte code:
    //   0: ldc 37
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 45	com/tencent/worddetect/b:ZYC	Lcom/tencent/worddetect/WordDetectNative$ConfigParam;
    //   8: ifnonnull +10 -> 18
    //   11: aload_0
    //   12: invokestatic 49	com/tencent/worddetect/b:mx	(Landroid/content/Context;)Lcom/tencent/worddetect/WordDetectNative$ConfigParam;
    //   15: putstatic 45	com/tencent/worddetect/b:ZYC	Lcom/tencent/worddetect/WordDetectNative$ConfigParam;
    //   18: getstatic 45	com/tencent/worddetect/b:ZYC	Lcom/tencent/worddetect/WordDetectNative$ConfigParam;
    //   21: ifnonnull +16 -> 37
    //   24: ldc 51
    //   26: ldc 53
    //   28: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: ldc 37
    //   33: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: return
    //   37: getstatic 64	com/tencent/worddetect/b:ZYB	Lcom/tencent/worddetect/WordDetectNative;
    //   40: ifnonnull +91 -> 131
    //   43: ldc 2
    //   45: monitorenter
    //   46: getstatic 64	com/tencent/worddetect/b:ZYB	Lcom/tencent/worddetect/WordDetectNative;
    //   49: ifnull +9 -> 58
    //   52: getstatic 23	com/tencent/worddetect/b:jvb	Z
    //   55: ifne +73 -> 128
    //   58: invokestatic 70	java/lang/System:currentTimeMillis	()J
    //   61: lstore 8
    //   63: new 72	com/tencent/worddetect/WordDetectNative
    //   66: dup
    //   67: invokespecial 73	com/tencent/worddetect/WordDetectNative:<init>	()V
    //   70: astore_0
    //   71: aload_0
    //   72: putstatic 64	com/tencent/worddetect/b:ZYB	Lcom/tencent/worddetect/WordDetectNative;
    //   75: aload_0
    //   76: getstatic 45	com/tencent/worddetect/b:ZYC	Lcom/tencent/worddetect/WordDetectNative$ConfigParam;
    //   79: invokevirtual 77	com/tencent/worddetect/WordDetectNative:init	(Lcom/tencent/worddetect/WordDetectNative$ConfigParam;)I
    //   82: istore 5
    //   84: invokestatic 70	java/lang/System:currentTimeMillis	()J
    //   87: lstore 10
    //   89: iload 5
    //   91: iflt +65 -> 156
    //   94: iconst_1
    //   95: putstatic 23	com/tencent/worddetect/b:jvb	Z
    //   98: ldc 51
    //   100: ldc 79
    //   102: iconst_2
    //   103: anewarray 4	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: iload 5
    //   110: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: lload 10
    //   118: lload 8
    //   120: lsub
    //   121: invokestatic 90	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   124: aastore
    //   125: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: ldc 2
    //   130: monitorexit
    //   131: ldc 2
    //   133: monitorenter
    //   134: getstatic 23	com/tencent/worddetect/b:jvb	Z
    //   137: ifne +42 -> 179
    //   140: ldc 51
    //   142: ldc 95
    //   144: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: ldc 2
    //   149: monitorexit
    //   150: ldc 37
    //   152: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: return
    //   156: iconst_0
    //   157: putstatic 23	com/tencent/worddetect/b:jvb	Z
    //   160: iload 5
    //   162: invokestatic 100	com/tencent/worddetect/c:aCD	(I)V
    //   165: goto -67 -> 98
    //   168: astore_0
    //   169: ldc 2
    //   171: monitorexit
    //   172: ldc 37
    //   174: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload_0
    //   178: athrow
    //   179: ldc 2
    //   181: monitorexit
    //   182: aload_1
    //   183: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   186: ifeq +37 -> 223
    //   189: ldc 51
    //   191: ldc 108
    //   193: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload 4
    //   198: getstatic 112	com/tencent/worddetect/b$a:ZYE	Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;
    //   201: invokeinterface 115 2 0
    //   206: ldc 37
    //   208: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: return
    //   212: astore_0
    //   213: ldc 2
    //   215: monitorexit
    //   216: ldc 37
    //   218: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_0
    //   222: athrow
    //   223: invokestatic 70	java/lang/System:currentTimeMillis	()J
    //   226: lstore 8
    //   228: getstatic 25	com/tencent/worddetect/b:ZYD	Lcom/tencent/mm/plugin/scanner/util/a/i;
    //   231: ifnonnull +13 -> 244
    //   234: new 117	com/tencent/worddetect/a
    //   237: dup
    //   238: invokespecial 118	com/tencent/worddetect/a:<init>	()V
    //   241: putstatic 25	com/tencent/worddetect/b:ZYD	Lcom/tencent/mm/plugin/scanner/util/a/i;
    //   244: new 120	com/tencent/mm/plugin/scanner/util/a/f
    //   247: dup
    //   248: aload_1
    //   249: lload_2
    //   250: invokespecial 123	com/tencent/mm/plugin/scanner/util/a/f:<init>	(Ljava/lang/String;J)V
    //   253: getstatic 25	com/tencent/worddetect/b:ZYD	Lcom/tencent/mm/plugin/scanner/util/a/i;
    //   256: invokestatic 128	com/tencent/mm/plugin/scanner/util/a/e:a	(Lcom/tencent/mm/plugin/scanner/util/a/g;Lcom/tencent/mm/plugin/scanner/util/a/i;)Lcom/tencent/mm/plugin/scanner/util/a/h;
    //   259: astore_0
    //   260: aload_0
    //   261: getfield 134	com/tencent/mm/plugin/scanner/util/a/h:bitmap	Landroid/graphics/Bitmap;
    //   264: astore_0
    //   265: aload_0
    //   266: ifnonnull +22 -> 288
    //   269: ldc 51
    //   271: ldc 136
    //   273: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload 4
    //   278: aconst_null
    //   279: invokestatic 139	com/tencent/worddetect/b:a	(Lcom/tencent/worddetect/b$b;Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;)V
    //   282: ldc 37
    //   284: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   287: return
    //   288: aload_0
    //   289: invokestatic 143	com/tencent/worddetect/b:aO	(Landroid/graphics/Bitmap;)[B
    //   292: astore_1
    //   293: aload_1
    //   294: invokestatic 146	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   297: ifeq +27 -> 324
    //   300: ldc 51
    //   302: ldc 148
    //   304: invokestatic 59	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload 4
    //   309: getstatic 112	com/tencent/worddetect/b$a:ZYE	Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;
    //   312: invokestatic 139	com/tencent/worddetect/b:a	(Lcom/tencent/worddetect/b$b;Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;)V
    //   315: invokestatic 151	com/tencent/worddetect/c:ivq	()V
    //   318: ldc 37
    //   320: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   323: return
    //   324: aload_0
    //   325: invokevirtual 157	android/graphics/Bitmap:getWidth	()I
    //   328: istore 5
    //   330: aload_0
    //   331: invokevirtual 160	android/graphics/Bitmap:getHeight	()I
    //   334: istore 6
    //   336: getstatic 64	com/tencent/worddetect/b:ZYB	Lcom/tencent/worddetect/WordDetectNative;
    //   339: aload_1
    //   340: iload 5
    //   342: iload 6
    //   344: iconst_3
    //   345: invokevirtual 164	com/tencent/worddetect/WordDetectNative:scanImage	([BIII)I
    //   348: istore 7
    //   350: ldc 51
    //   352: ldc 166
    //   354: iconst_5
    //   355: anewarray 4	java/lang/Object
    //   358: dup
    //   359: iconst_0
    //   360: aload_1
    //   361: arraylength
    //   362: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   365: aastore
    //   366: dup
    //   367: iconst_1
    //   368: iload 5
    //   370: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   373: aastore
    //   374: dup
    //   375: iconst_2
    //   376: iload 6
    //   378: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   381: aastore
    //   382: dup
    //   383: iconst_3
    //   384: iload 7
    //   386: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   389: aastore
    //   390: dup
    //   391: iconst_4
    //   392: lload_2
    //   393: invokestatic 90	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   396: aastore
    //   397: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   400: iload 7
    //   402: ifeq +22 -> 424
    //   405: aload 4
    //   407: getstatic 112	com/tencent/worddetect/b$a:ZYE	Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;
    //   410: invokestatic 139	com/tencent/worddetect/b:a	(Lcom/tencent/worddetect/b$b;Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;)V
    //   413: iload 7
    //   415: invokestatic 169	com/tencent/worddetect/c:aCE	(I)V
    //   418: ldc 37
    //   420: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   423: return
    //   424: new 171	com/tencent/worddetect/WordDetectNative$WordDetectDetailResult
    //   427: dup
    //   428: invokespecial 172	com/tencent/worddetect/WordDetectNative$WordDetectDetailResult:<init>	()V
    //   431: astore_0
    //   432: getstatic 64	com/tencent/worddetect/b:ZYB	Lcom/tencent/worddetect/WordDetectNative;
    //   435: aload_0
    //   436: invokevirtual 176	com/tencent/worddetect/WordDetectNative:getDetailResult	(Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;)I
    //   439: istore 5
    //   441: iload 5
    //   443: ifeq +22 -> 465
    //   446: aload 4
    //   448: getstatic 112	com/tencent/worddetect/b$a:ZYE	Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;
    //   451: invokestatic 139	com/tencent/worddetect/b:a	(Lcom/tencent/worddetect/b$b;Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;)V
    //   454: iload 5
    //   456: invokestatic 179	com/tencent/worddetect/c:aCF	(I)V
    //   459: ldc 37
    //   461: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   464: return
    //   465: ldc 51
    //   467: ldc 181
    //   469: iconst_5
    //   470: anewarray 4	java/lang/Object
    //   473: dup
    //   474: iconst_0
    //   475: aload_0
    //   476: getfield 185	com/tencent/worddetect/WordDetectNative$WordDetectDetailResult:rate_lang	[F
    //   479: aastore
    //   480: dup
    //   481: iconst_1
    //   482: aload_0
    //   483: getfield 189	com/tencent/worddetect/WordDetectNative$WordDetectDetailResult:width	I
    //   486: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   489: aastore
    //   490: dup
    //   491: iconst_2
    //   492: aload_0
    //   493: getfield 192	com/tencent/worddetect/WordDetectNative$WordDetectDetailResult:height	I
    //   496: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   499: aastore
    //   500: dup
    //   501: iconst_3
    //   502: invokestatic 70	java/lang/System:currentTimeMillis	()J
    //   505: lload 8
    //   507: lsub
    //   508: invokestatic 90	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   511: aastore
    //   512: dup
    //   513: iconst_4
    //   514: lload_2
    //   515: invokestatic 90	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   518: aastore
    //   519: invokestatic 93	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   522: aload 4
    //   524: aload_0
    //   525: invokestatic 139	com/tencent/worddetect/b:a	(Lcom/tencent/worddetect/b$b;Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;)V
    //   528: ldc 37
    //   530: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   533: return
    //   534: astore_0
    //   535: invokestatic 195	com/tencent/worddetect/c:ivr	()V
    //   538: ldc 51
    //   540: aload_0
    //   541: ldc 197
    //   543: iconst_0
    //   544: anewarray 4	java/lang/Object
    //   547: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   550: aload 4
    //   552: getstatic 112	com/tencent/worddetect/b$a:ZYE	Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;
    //   555: invokestatic 139	com/tencent/worddetect/b:a	(Lcom/tencent/worddetect/b$b;Lcom/tencent/worddetect/WordDetectNative$WordDetectDetailResult;)V
    //   558: ldc 37
    //   560: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   563: return
    //   564: astore_0
    //   565: invokestatic 195	com/tencent/worddetect/c:ivr	()V
    //   568: ldc 51
    //   570: aload_0
    //   571: ldc 203
    //   573: iconst_0
    //   574: anewarray 4	java/lang/Object
    //   577: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   580: goto -30 -> 550
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	paramContext	Context
    //   0	583	1	paramString	String
    //   0	583	2	paramLong	long
    //   0	583	4	paramb	b.b
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
  
  private static void a(b.b paramb, WordDetectNative.WordDetectDetailResult paramWordDetectDetailResult)
  {
    AppMethodBeat.i(193484);
    if (paramb != null) {
      paramb.a(paramWordDetectDetailResult);
    }
    AppMethodBeat.o(193484);
  }
  
  private static byte[] aO(Bitmap paramBitmap)
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
  
  private static WordDetectNative.ConfigParam mx(Context paramContext)
  {
    AppMethodBeat.i(91186);
    try
    {
      String str1 = paramContext.getFilesDir().getAbsolutePath();
      Object localObject = new q(str1, "word_detect");
      if (!((q)localObject).ifE()) {
        ((q)localObject).ifL();
      }
      String str3 = ((q)localObject).bOF();
      localObject = str3 + "/net_fc.bin";
      String str2 = str3 + "/net_fc.param";
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("word_detect_mode_lib");
      boolean bool = localMultiProcessMMKV.getBoolean("word_detect_mode_version_2", false);
      Log.i("MicroMsg.WordDetectModHelper", "getWordDetectParam rootPath: %s, qBarRootPath: %s, version: %s, isCopy: %s", new Object[] { str1, str3, "word_detect_mode_version_2", Boolean.valueOf(bool) });
      if (!bool)
      {
        u.deleteFile((String)localObject);
        u.deleteFile(str2);
        localMultiProcessMMKV.putBoolean("word_detect_mode_version_2", true);
      }
      if ((!bool) || (!u.agG((String)localObject)))
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
    AppMethodBeat.i(193485);
    h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193177);
        try
        {
          if ((b.jvb) && (b.ivo() != null))
          {
            Log.i("MicroMsg.WordDetectModHelper", "releaseWordDetect");
            b.ivo().release();
            b.ivp();
            b.Yy();
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(193177);
        }
      }
    }, "WordDetectThread");
    AppMethodBeat.o(193485);
  }
  
  public static abstract interface a
  {
    public static final WordDetectNative.WordDetectDetailResult ZYE = new WordDetectNative.WordDetectDetailResult();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.worddetect.b
 * JD-Core Version:    0.7.0.1
 */