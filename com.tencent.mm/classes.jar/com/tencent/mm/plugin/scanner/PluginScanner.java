package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.scanner.model.t;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.k;
import com.tencent.qbar.a.a;
import com.tencent.qbar.e.b;
import com.tencent.qbar.e.d;
import d.g.b.p;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class PluginScanner
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, f
{
  private static final com.tencent.mm.sdk.b.c<cp> yyU;
  private m yyT;
  
  static
  {
    AppMethodBeat.i(189440);
    yyU = new com.tencent.mm.sdk.b.c()
    {
      /* Error */
      private boolean a(cp paramAnonymouscp)
      {
        // Byte code:
        //   0: ldc 47
        //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_1
        //   6: getfield 51	com/tencent/mm/g/a/cp:doA	Lcom/tencent/mm/g/a/cp$a;
        //   9: getfield 57	com/tencent/mm/g/a/cp$a:path	Ljava/lang/String;
        //   12: invokestatic 63	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
        //   15: ifeq +25 -> 40
        //   18: ldc 65
        //   20: ldc 67
        //   22: invokestatic 73	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   25: aload_1
        //   26: getfield 77	com/tencent/mm/g/a/cp:doB	Lcom/tencent/mm/g/a/cp$b;
        //   29: aconst_null
        //   30: putfield 83	com/tencent/mm/g/a/cp$b:doC	[Ljava/lang/String;
        //   33: ldc 47
        //   35: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   38: iconst_0
        //   39: ireturn
        //   40: new 85	java/util/concurrent/CountDownLatch
        //   43: dup
        //   44: iconst_1
        //   45: invokespecial 87	java/util/concurrent/CountDownLatch:<init>	(I)V
        //   48: astore_3
        //   49: iconst_1
        //   50: anewarray 88	[Ljava/lang/String;
        //   53: astore_2
        //   54: aload_2
        //   55: iconst_0
        //   56: aconst_null
        //   57: aastore
        //   58: new 9	com/tencent/mm/plugin/scanner/PluginScanner$1$1
        //   61: dup
        //   62: aload_0
        //   63: aload_2
        //   64: aload_3
        //   65: invokespecial 91	com/tencent/mm/plugin/scanner/PluginScanner$1$1:<init>	(Lcom/tencent/mm/plugin/scanner/PluginScanner$1;[[Ljava/lang/String;Ljava/util/concurrent/CountDownLatch;)V
        //   68: astore 4
        //   70: invokestatic 97	com/tencent/qbar/e:fXW	()Lcom/tencent/qbar/e;
        //   73: invokestatic 103	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
        //   76: invokestatic 109	java/lang/System:currentTimeMillis	()J
        //   79: aload_1
        //   80: getfield 51	com/tencent/mm/g/a/cp:doA	Lcom/tencent/mm/g/a/cp$a;
        //   83: getfield 57	com/tencent/mm/g/a/cp$a:path	Ljava/lang/String;
        //   86: aload 4
        //   88: invokevirtual 112	com/tencent/qbar/e:a	(Landroid/content/Context;JLjava/lang/String;Lcom/tencent/qbar/e$b;)V
        //   91: aload_3
        //   92: ldc2_w 113
        //   95: getstatic 120	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
        //   98: invokevirtual 124	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
        //   101: pop
        //   102: aload_2
        //   103: monitorenter
        //   104: aload_2
        //   105: iconst_0
        //   106: aaload
        //   107: ifnull +69 -> 176
        //   110: aload_2
        //   111: iconst_0
        //   112: aaload
        //   113: arraylength
        //   114: ifle +62 -> 176
        //   117: aload_1
        //   118: getfield 77	com/tencent/mm/g/a/cp:doB	Lcom/tencent/mm/g/a/cp$b;
        //   121: aload_2
        //   122: iconst_0
        //   123: aaload
        //   124: putfield 83	com/tencent/mm/g/a/cp$b:doC	[Ljava/lang/String;
        //   127: aload_2
        //   128: monitorexit
        //   129: ldc 47
        //   131: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   134: iconst_0
        //   135: ireturn
        //   136: astore_3
        //   137: ldc 65
        //   139: aload_3
        //   140: ldc 126
        //   142: iconst_0
        //   143: anewarray 128	java/lang/Object
        //   146: invokestatic 132	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   149: aload_1
        //   150: getfield 77	com/tencent/mm/g/a/cp:doB	Lcom/tencent/mm/g/a/cp$b;
        //   153: iconst_1
        //   154: anewarray 30	java/lang/String
        //   157: dup
        //   158: iconst_0
        //   159: ldc 134
        //   161: aastore
        //   162: putfield 83	com/tencent/mm/g/a/cp$b:doC	[Ljava/lang/String;
        //   165: aload_1
        //   166: getfield 77	com/tencent/mm/g/a/cp:doB	Lcom/tencent/mm/g/a/cp$b;
        //   169: iconst_1
        //   170: putfield 138	com/tencent/mm/g/a/cp$b:cYg	Z
        //   173: goto -71 -> 102
        //   176: aload_1
        //   177: getfield 77	com/tencent/mm/g/a/cp:doB	Lcom/tencent/mm/g/a/cp$b;
        //   180: aconst_null
        //   181: putfield 83	com/tencent/mm/g/a/cp$b:doC	[Ljava/lang/String;
        //   184: goto -57 -> 127
        //   187: astore_1
        //   188: aload_2
        //   189: monitorexit
        //   190: ldc 47
        //   192: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   195: aload_1
        //   196: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	197	0	this	1
        //   0	197	1	paramAnonymouscp	cp
        //   53	136	2	arrayOfString;	String[][]
        //   48	44	3	localCountDownLatch	CountDownLatch
        //   136	4	3	localThrowable	java.lang.Throwable
        //   68	19	4	local1	1
        // Exception table:
        //   from	to	target	type
        //   91	102	136	java/lang/Throwable
        //   110	127	187	finally
        //   127	129	187	finally
        //   176	184	187	finally
        //   188	190	187	finally
      }
    };
    AppMethodBeat.o(189440);
  }
  
  public PluginScanner()
  {
    AppMethodBeat.i(51554);
    this.yyT = new m();
    AppMethodBeat.o(51554);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(189439);
    com.tencent.mm.sdk.b.a.IvT.b(yyU);
    AppMethodBeat.o(189439);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(51555);
    com.tencent.mm.br.c.aPn("scanner");
    pin(new u(j.class));
    if (paramg.akL())
    {
      paramg = t.yDh;
      paramg = ak.getContext();
      p.h(paramg, "context");
      k localk = new k(t.cl(paramg));
      if (!localk.exists()) {
        localk.mkdirs();
      }
      t.i(paramg, "scan_goods/center_det.bin", t.cl(paramg) + "center_det.bin");
      t.i(paramg, "scan_goods/center_det.param", t.cl(paramg) + "center_det.param");
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.scanner.api.b.class, new com.tencent.mm.plugin.scanner.e.a());
      paramg = com.tencent.mm.plugin.scanner.util.f.yPG;
      com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new com.tencent.mm.plugin.scanner.util.f(), new String[] { "//scan" });
      AppMethodBeat.o(51555);
      return;
    }
    if (paramg.xO(":tools"))
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.scanner.api.b.class, new com.tencent.mm.plugin.scanner.e.a());
      AppMethodBeat.o(51555);
      return;
    }
    if (paramg.xP(":appbrand")) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.scanner.api.b.class, new com.tencent.mm.plugin.scanner.e.a());
    }
    AppMethodBeat.o(51555);
  }
  
  public String genScanCaptureImgPath(String paramString)
  {
    AppMethodBeat.i(51558);
    j.dNQ();
    paramString = j.getScanImageSaveDir() + String.format("%s_%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(51558);
    return paramString;
  }
  
  public String genScanTmpImgPath(String paramString)
  {
    AppMethodBeat.i(51559);
    j.dNQ();
    paramString = j.genScanTmpImgPath(paramString);
    AppMethodBeat.o(51559);
    return paramString;
  }
  
  public String getAccScannerPath()
  {
    AppMethodBeat.i(51556);
    j.dNQ();
    String str = j.getAccScannerPath();
    AppMethodBeat.o(51556);
    return str;
  }
  
  public m getScanCdnService()
  {
    return this.yyT;
  }
  
  public String getScanImageSaveDir()
  {
    AppMethodBeat.i(51557);
    j.dNQ();
    String str = j.getScanImageSaveDir();
    AppMethodBeat.o(51557);
    return str;
  }
  
  public void onAccountInitialized(e.c paramc) {}
  
  public void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.PluginScanner
 * JD-Core Version:    0.7.0.1
 */