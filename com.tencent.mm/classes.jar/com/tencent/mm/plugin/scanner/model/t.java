package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/ScanAssetsManager;", "", "()V", "CENTER_DET_BIN_FILE_NAME", "", "CENTER_DET_PARAM_FILE_NAME", "TAG", "checkDirectory", "", "context", "Landroid/content/Context;", "copyFileFromAssets", "srcFileName", "dstFileName", "getCenterBinFilePath", "getCenterParamFilePath", "getSavedFileDirectory", "init", "plugin-scan_release"})
public final class t
{
  public static final t ILi;
  
  static
  {
    AppMethodBeat.i(52184);
    ILi = new t();
    AppMethodBeat.o(52184);
  }
  
  public static String cC(Context paramContext)
  {
    AppMethodBeat.i(52183);
    p.k(paramContext, "context");
    StringBuilder localStringBuilder = new StringBuilder();
    paramContext = paramContext.getFilesDir();
    p.j(paramContext, "context.filesDir");
    paramContext = paramContext.getParent() + "/scan_goods/";
    AppMethodBeat.o(52183);
    return paramContext;
  }
  
  /* Error */
  public static void j(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 91
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 52
    //   8: invokestatic 58	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: ldc 92
    //   14: invokestatic 58	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_2
    //   18: ldc 93
    //   20: invokestatic 58	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: ldc 95
    //   25: ldc 97
    //   27: iconst_2
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload_1
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: aload_2
    //   38: aastore
    //   39: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: new 105	com/tencent/mm/vfs/q
    //   45: dup
    //   46: aload_2
    //   47: invokespecial 108	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   50: astore 6
    //   52: aload 6
    //   54: invokevirtual 112	com/tencent/mm/vfs/q:ifE	()Z
    //   57: ifne +9 -> 66
    //   60: aload 6
    //   62: invokevirtual 115	com/tencent/mm/vfs/q:ifM	()Z
    //   65: pop
    //   66: aload_0
    //   67: invokevirtual 119	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   70: aload_1
    //   71: invokevirtual 125	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   74: astore_0
    //   75: aload 6
    //   77: invokestatic 131	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   80: astore 5
    //   82: aload 5
    //   84: astore 4
    //   86: aload_0
    //   87: astore_2
    //   88: sipush 1024
    //   91: newarray byte
    //   93: astore 7
    //   95: aload_0
    //   96: ifnonnull +12 -> 108
    //   99: aload 5
    //   101: astore 4
    //   103: aload_0
    //   104: astore_2
    //   105: invokestatic 134	kotlin/g/b/p:iCn	()V
    //   108: aload 5
    //   110: astore 4
    //   112: aload_0
    //   113: astore_2
    //   114: aload_0
    //   115: aload 7
    //   117: invokevirtual 140	java/io/InputStream:read	([B)I
    //   120: istore_3
    //   121: iload_3
    //   122: iconst_m1
    //   123: if_icmpeq +71 -> 194
    //   126: aload 5
    //   128: astore 4
    //   130: aload_0
    //   131: astore_2
    //   132: aload 5
    //   134: aload 7
    //   136: iconst_0
    //   137: iload_3
    //   138: invokevirtual 146	java/io/OutputStream:write	([BII)V
    //   141: goto -46 -> 95
    //   144: astore_2
    //   145: aload 5
    //   147: astore_1
    //   148: aload_2
    //   149: astore 5
    //   151: aload_1
    //   152: astore 4
    //   154: aload_0
    //   155: astore_2
    //   156: ldc 95
    //   158: aload 5
    //   160: checkcast 148	java/lang/Throwable
    //   163: ldc 150
    //   165: iconst_0
    //   166: anewarray 4	java/lang/Object
    //   169: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload_0
    //   173: ifnull +7 -> 180
    //   176: aload_0
    //   177: invokevirtual 157	java/io/InputStream:close	()V
    //   180: aload_1
    //   181: ifnull +89 -> 270
    //   184: aload_1
    //   185: invokevirtual 158	java/io/OutputStream:close	()V
    //   188: ldc 91
    //   190: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: return
    //   194: aload 5
    //   196: astore 4
    //   198: aload_0
    //   199: astore_2
    //   200: aload 5
    //   202: invokevirtual 161	java/io/OutputStream:flush	()V
    //   205: aload 5
    //   207: astore 4
    //   209: aload_0
    //   210: astore_2
    //   211: ldc 95
    //   213: ldc 163
    //   215: iconst_2
    //   216: anewarray 4	java/lang/Object
    //   219: dup
    //   220: iconst_0
    //   221: aload_1
    //   222: aastore
    //   223: dup
    //   224: iconst_1
    //   225: aload 6
    //   227: invokevirtual 167	com/tencent/mm/vfs/q:length	()J
    //   230: invokestatic 173	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   233: aastore
    //   234: invokestatic 175	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: aload_0
    //   238: invokevirtual 157	java/io/InputStream:close	()V
    //   241: aload 5
    //   243: ifnull +21 -> 264
    //   246: aload 5
    //   248: invokevirtual 158	java/io/OutputStream:close	()V
    //   251: ldc 91
    //   253: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: return
    //   257: astore_0
    //   258: ldc 91
    //   260: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: return
    //   264: ldc 91
    //   266: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: return
    //   270: ldc 91
    //   272: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: return
    //   276: astore_0
    //   277: ldc 91
    //   279: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: return
    //   283: astore_1
    //   284: aconst_null
    //   285: astore 4
    //   287: aconst_null
    //   288: astore_0
    //   289: aload_0
    //   290: ifnull +7 -> 297
    //   293: aload_0
    //   294: invokevirtual 157	java/io/InputStream:close	()V
    //   297: aload 4
    //   299: ifnull +8 -> 307
    //   302: aload 4
    //   304: invokevirtual 158	java/io/OutputStream:close	()V
    //   307: ldc 91
    //   309: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: aload_1
    //   313: athrow
    //   314: astore_0
    //   315: goto -8 -> 307
    //   318: astore_1
    //   319: aconst_null
    //   320: astore 4
    //   322: goto -33 -> 289
    //   325: astore_1
    //   326: aload_2
    //   327: astore_0
    //   328: goto -39 -> 289
    //   331: astore 5
    //   333: aconst_null
    //   334: astore_1
    //   335: aconst_null
    //   336: astore_0
    //   337: goto -186 -> 151
    //   340: astore 5
    //   342: aconst_null
    //   343: astore_1
    //   344: goto -193 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	paramContext	Context
    //   0	347	1	paramString1	String
    //   0	347	2	paramString2	String
    //   120	18	3	i	int
    //   84	237	4	localObject1	Object
    //   80	167	5	localObject2	Object
    //   331	1	5	localException1	java.lang.Exception
    //   340	1	5	localException2	java.lang.Exception
    //   50	176	6	localq	com.tencent.mm.vfs.q
    //   93	42	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   88	95	144	java/lang/Exception
    //   105	108	144	java/lang/Exception
    //   114	121	144	java/lang/Exception
    //   132	141	144	java/lang/Exception
    //   200	205	144	java/lang/Exception
    //   211	237	144	java/lang/Exception
    //   237	241	257	java/lang/Exception
    //   246	256	257	java/lang/Exception
    //   176	180	276	java/lang/Exception
    //   184	193	276	java/lang/Exception
    //   42	66	283	finally
    //   66	75	283	finally
    //   293	297	314	java/lang/Exception
    //   302	307	314	java/lang/Exception
    //   75	82	318	finally
    //   88	95	325	finally
    //   105	108	325	finally
    //   114	121	325	finally
    //   132	141	325	finally
    //   156	172	325	finally
    //   200	205	325	finally
    //   211	237	325	finally
    //   42	66	331	java/lang/Exception
    //   66	75	331	java/lang/Exception
    //   75	82	340	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.t
 * JD-Core Version:    0.7.0.1
 */