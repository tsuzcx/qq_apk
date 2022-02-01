package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanAssetsManager;", "", "()V", "CENTER_DET_BIN_FILE_NAME", "", "CENTER_DET_PARAM_FILE_NAME", "SHUFFLENETV2_0X5_OP_PARAM_FILE_NAME", "SHUFFLENETV2_REID_BIN_FILE_NAME", "SHUFFLENETV2_REID_PARAM_FILE_NAME", "SHUFFLENETV_0X5_OP_BIN_FILE_NAME", "TAG", "checkDirectory", "", "context", "Landroid/content/Context;", "copyFileFromAssets", "srcFileName", "dstFileName", "getCenterBinFilePath", "getCenterParamFilePath", "getSavedFileDirectory", "getShufflenetv2ReidBinFilePath", "getShufflenetv2ReidParamFilePath", "getShufflenetvOPBinFilePath", "getShufflenetvOPParamFilePath", "init", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
{
  public static final aa OSf;
  
  static
  {
    AppMethodBeat.i(52184);
    OSf = new aa();
    AppMethodBeat.o(52184);
  }
  
  public static String dq(Context paramContext)
  {
    AppMethodBeat.i(52183);
    s.u(paramContext, "context");
    paramContext = s.X(paramContext.getFilesDir().getParent(), "/scan_goods/");
    AppMethodBeat.o(52183);
    return paramContext;
  }
  
  public static String jA(Context paramContext)
  {
    AppMethodBeat.i(314237);
    s.u(paramContext, "context");
    paramContext = s.X(dq(paramContext), "shufflenet_0x5_op.param");
    AppMethodBeat.o(314237);
    return paramContext;
  }
  
  public static String jv(Context paramContext)
  {
    AppMethodBeat.i(314215);
    s.u(paramContext, "context");
    paramContext = s.X(dq(paramContext), "center_det.bin");
    AppMethodBeat.o(314215);
    return paramContext;
  }
  
  public static String jw(Context paramContext)
  {
    AppMethodBeat.i(314219);
    s.u(paramContext, "context");
    paramContext = s.X(dq(paramContext), "center_det.param");
    AppMethodBeat.o(314219);
    return paramContext;
  }
  
  public static String jx(Context paramContext)
  {
    AppMethodBeat.i(314224);
    s.u(paramContext, "context");
    paramContext = s.X(dq(paramContext), "shufflenetv2_reid.bin");
    AppMethodBeat.o(314224);
    return paramContext;
  }
  
  public static String jy(Context paramContext)
  {
    AppMethodBeat.i(314228);
    s.u(paramContext, "context");
    paramContext = s.X(dq(paramContext), "shufflenetv2_reid.param");
    AppMethodBeat.o(314228);
    return paramContext;
  }
  
  public static String jz(Context paramContext)
  {
    AppMethodBeat.i(314233);
    s.u(paramContext, "context");
    paramContext = s.X(dq(paramContext), "shufflenet_0x5_op.bin");
    AppMethodBeat.o(314233);
    return paramContext;
  }
  
  /* Error */
  public static void n(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 118
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 63
    //   8: invokestatic 69	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: ldc 119
    //   14: invokestatic 69	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_2
    //   18: ldc 120
    //   20: invokestatic 69	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: ldc 122
    //   25: ldc 124
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
    //   39: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: new 132	com/tencent/mm/vfs/u
    //   45: dup
    //   46: aload_2
    //   47: invokespecial 135	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   50: astore 6
    //   52: aload 6
    //   54: invokevirtual 139	com/tencent/mm/vfs/u:jKS	()Z
    //   57: ifne +9 -> 66
    //   60: aload 6
    //   62: invokevirtual 142	com/tencent/mm/vfs/u:jKZ	()Z
    //   65: pop
    //   66: aload_0
    //   67: invokevirtual 146	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   70: aload_1
    //   71: invokevirtual 152	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   74: astore_0
    //   75: aload 6
    //   77: invokestatic 158	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   80: astore 5
    //   82: aload 5
    //   84: astore 4
    //   86: aload_0
    //   87: astore_2
    //   88: sipush 1024
    //   91: newarray byte
    //   93: astore 7
    //   95: aload 5
    //   97: astore 4
    //   99: aload_0
    //   100: astore_2
    //   101: aload_0
    //   102: invokestatic 162	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   105: aload 5
    //   107: astore 4
    //   109: aload_0
    //   110: astore_2
    //   111: aload_0
    //   112: aload 7
    //   114: invokevirtual 168	java/io/InputStream:read	([B)I
    //   117: istore_3
    //   118: iload_3
    //   119: iconst_m1
    //   120: if_icmpeq +71 -> 191
    //   123: aload 5
    //   125: astore 4
    //   127: aload_0
    //   128: astore_2
    //   129: aload 5
    //   131: aload 7
    //   133: iconst_0
    //   134: iload_3
    //   135: invokevirtual 174	java/io/OutputStream:write	([BII)V
    //   138: goto -43 -> 95
    //   141: astore_2
    //   142: aload 5
    //   144: astore_1
    //   145: aload_2
    //   146: astore 5
    //   148: aload_1
    //   149: astore 4
    //   151: aload_0
    //   152: astore_2
    //   153: ldc 122
    //   155: aload 5
    //   157: checkcast 176	java/lang/Throwable
    //   160: ldc 178
    //   162: iconst_0
    //   163: anewarray 4	java/lang/Object
    //   166: invokestatic 182	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_0
    //   170: ifnull +7 -> 177
    //   173: aload_0
    //   174: invokevirtual 185	java/io/InputStream:close	()V
    //   177: aload_1
    //   178: ifnull +84 -> 262
    //   181: aload_1
    //   182: invokevirtual 186	java/io/OutputStream:close	()V
    //   185: ldc 118
    //   187: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: return
    //   191: aload 5
    //   193: astore 4
    //   195: aload_0
    //   196: astore_2
    //   197: aload 5
    //   199: invokevirtual 189	java/io/OutputStream:flush	()V
    //   202: aload 5
    //   204: astore 4
    //   206: aload_0
    //   207: astore_2
    //   208: ldc 122
    //   210: ldc 191
    //   212: iconst_2
    //   213: anewarray 4	java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: aload_1
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload 6
    //   224: invokevirtual 195	com/tencent/mm/vfs/u:length	()J
    //   227: invokestatic 201	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   230: aastore
    //   231: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: aload_0
    //   235: invokevirtual 185	java/io/InputStream:close	()V
    //   238: aload 5
    //   240: ifnull +15 -> 255
    //   243: aload 5
    //   245: invokevirtual 186	java/io/OutputStream:close	()V
    //   248: ldc 118
    //   250: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: return
    //   254: astore_0
    //   255: ldc 118
    //   257: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: return
    //   261: astore_0
    //   262: ldc 118
    //   264: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: return
    //   268: astore_1
    //   269: aconst_null
    //   270: astore 4
    //   272: aconst_null
    //   273: astore_0
    //   274: aload_0
    //   275: ifnull +7 -> 282
    //   278: aload_0
    //   279: invokevirtual 185	java/io/InputStream:close	()V
    //   282: aload 4
    //   284: ifnull +8 -> 292
    //   287: aload 4
    //   289: invokevirtual 186	java/io/OutputStream:close	()V
    //   292: ldc 118
    //   294: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   297: aload_1
    //   298: athrow
    //   299: astore_0
    //   300: goto -8 -> 292
    //   303: astore_1
    //   304: aconst_null
    //   305: astore 4
    //   307: goto -33 -> 274
    //   310: astore_1
    //   311: aload_2
    //   312: astore_0
    //   313: goto -39 -> 274
    //   316: astore 5
    //   318: aconst_null
    //   319: astore_1
    //   320: aconst_null
    //   321: astore_0
    //   322: goto -174 -> 148
    //   325: astore 5
    //   327: aconst_null
    //   328: astore_1
    //   329: goto -181 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	paramContext	Context
    //   0	332	1	paramString1	String
    //   0	332	2	paramString2	String
    //   117	18	3	i	int
    //   84	222	4	localObject1	Object
    //   80	164	5	localObject2	Object
    //   316	1	5	localException1	java.lang.Exception
    //   325	1	5	localException2	java.lang.Exception
    //   50	173	6	localu	com.tencent.mm.vfs.u
    //   93	39	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   88	95	141	java/lang/Exception
    //   101	105	141	java/lang/Exception
    //   111	118	141	java/lang/Exception
    //   129	138	141	java/lang/Exception
    //   197	202	141	java/lang/Exception
    //   208	234	141	java/lang/Exception
    //   234	238	254	java/lang/Exception
    //   243	248	254	java/lang/Exception
    //   173	177	261	java/lang/Exception
    //   181	185	261	java/lang/Exception
    //   42	66	268	finally
    //   66	75	268	finally
    //   278	282	299	java/lang/Exception
    //   287	292	299	java/lang/Exception
    //   75	82	303	finally
    //   88	95	310	finally
    //   101	105	310	finally
    //   111	118	310	finally
    //   129	138	310	finally
    //   153	169	310	finally
    //   197	202	310	finally
    //   208	234	310	finally
    //   42	66	316	java/lang/Exception
    //   66	75	316	java/lang/Exception
    //   75	82	325	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.aa
 * JD-Core Version:    0.7.0.1
 */