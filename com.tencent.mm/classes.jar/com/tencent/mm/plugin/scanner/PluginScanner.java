package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dg;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.scanner.model.aa;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.af;
import com.tencent.mm.vfs.u;
import com.tencent.qbar.a.a;
import com.tencent.qbar.e.b;
import com.tencent.qbar.e.d;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.g.b.s;

public class PluginScanner
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, g
{
  private static final IListener<dg> OHB;
  
  static
  {
    AppMethodBeat.i(313300);
    OHB = new IListener(com.tencent.mm.app.f.hfK)
    {
      /* Error */
      private boolean a(dg paramAnonymousdg)
      {
        // Byte code:
        //   0: ldc 45
        //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_1
        //   6: getfield 49	com/tencent/mm/autogen/a/dg:hDh	Lcom/tencent/mm/autogen/a/dg$a;
        //   9: getfield 55	com/tencent/mm/autogen/a/dg$a:path	Ljava/lang/String;
        //   12: invokestatic 61	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   15: ifeq +25 -> 40
        //   18: ldc 63
        //   20: ldc 65
        //   22: invokestatic 71	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   25: aload_1
        //   26: getfield 75	com/tencent/mm/autogen/a/dg:hDi	Lcom/tencent/mm/autogen/a/dg$b;
        //   29: aconst_null
        //   30: putfield 81	com/tencent/mm/autogen/a/dg$b:hDj	[Ljava/lang/String;
        //   33: ldc 45
        //   35: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   38: iconst_0
        //   39: ireturn
        //   40: new 83	java/util/concurrent/CountDownLatch
        //   43: dup
        //   44: iconst_1
        //   45: invokespecial 85	java/util/concurrent/CountDownLatch:<init>	(I)V
        //   48: astore_3
        //   49: iconst_1
        //   50: anewarray 86	[Ljava/lang/String;
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
        //   65: invokespecial 89	com/tencent/mm/plugin/scanner/PluginScanner$1$1:<init>	(Lcom/tencent/mm/plugin/scanner/PluginScanner$1;[[Ljava/lang/String;Ljava/util/concurrent/CountDownLatch;)V
        //   68: astore 4
        //   70: invokestatic 95	com/tencent/qbar/e:jWN	()Lcom/tencent/qbar/e;
        //   73: invokestatic 101	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
        //   76: invokestatic 107	java/lang/System:currentTimeMillis	()J
        //   79: aload_1
        //   80: getfield 49	com/tencent/mm/autogen/a/dg:hDh	Lcom/tencent/mm/autogen/a/dg$a;
        //   83: getfield 55	com/tencent/mm/autogen/a/dg$a:path	Ljava/lang/String;
        //   86: aload 4
        //   88: invokevirtual 110	com/tencent/qbar/e:a	(Landroid/content/Context;JLjava/lang/String;Lcom/tencent/qbar/e$b;)V
        //   91: aload_3
        //   92: ldc2_w 111
        //   95: getstatic 118	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
        //   98: invokevirtual 122	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
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
        //   118: getfield 75	com/tencent/mm/autogen/a/dg:hDi	Lcom/tencent/mm/autogen/a/dg$b;
        //   121: aload_2
        //   122: iconst_0
        //   123: aaload
        //   124: putfield 81	com/tencent/mm/autogen/a/dg$b:hDj	[Ljava/lang/String;
        //   127: aload_2
        //   128: monitorexit
        //   129: ldc 45
        //   131: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   134: iconst_0
        //   135: ireturn
        //   136: astore_3
        //   137: ldc 63
        //   139: aload_3
        //   140: ldc 124
        //   142: iconst_0
        //   143: anewarray 126	java/lang/Object
        //   146: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   149: aload_1
        //   150: getfield 75	com/tencent/mm/autogen/a/dg:hDi	Lcom/tencent/mm/autogen/a/dg$b;
        //   153: iconst_1
        //   154: anewarray 30	java/lang/String
        //   157: dup
        //   158: iconst_0
        //   159: ldc 132
        //   161: aastore
        //   162: putfield 81	com/tencent/mm/autogen/a/dg$b:hDj	[Ljava/lang/String;
        //   165: aload_1
        //   166: getfield 75	com/tencent/mm/autogen/a/dg:hDi	Lcom/tencent/mm/autogen/a/dg$b;
        //   169: iconst_1
        //   170: putfield 136	com/tencent/mm/autogen/a/dg$b:isTimeout	Z
        //   173: goto -71 -> 102
        //   176: aload_1
        //   177: getfield 75	com/tencent/mm/autogen/a/dg:hDi	Lcom/tencent/mm/autogen/a/dg$b;
        //   180: aconst_null
        //   181: putfield 81	com/tencent/mm/autogen/a/dg$b:hDj	[Ljava/lang/String;
        //   184: goto -57 -> 127
        //   187: astore_1
        //   188: aload_2
        //   189: monitorexit
        //   190: ldc 45
        //   192: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   195: aload_1
        //   196: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	197	0	this	1
        //   0	197	1	paramAnonymousdg	dg
        //   53	136	2	arrayOfString;	String[][]
        //   48	44	3	localCountDownLatch	CountDownLatch
        //   136	4	3	localThrowable	java.lang.Throwable
        //   68	19	4	local1	1
        // Exception table:
        //   from	to	target	type
        //   91	102	136	finally
        //   110	127	187	finally
        //   127	129	187	finally
        //   176	184	187	finally
      }
    };
    AppMethodBeat.o(313300);
  }
  
  public PluginScanner()
  {
    AppMethodBeat.i(51554);
    AppMethodBeat.o(51554);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(313303);
    OHB.alive();
    af.a("ImageSearchFilePath", "image_search_temp/", 259200000L, 70);
    AppMethodBeat.o(313303);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(51555);
    com.tencent.mm.br.b.bsa("scanner");
    pin(new y(o.class));
    if (paramg.bbA())
    {
      paramg = aa.OSf;
      paramg = MMApplicationContext.getContext();
      s.u(paramg, "context");
      u localu = new u(aa.dq(paramg));
      if (!localu.jKS()) {
        localu.jKY();
      }
      aa.n(paramg, "scan_goods/center_det.bin", aa.jv(paramg));
      aa.n(paramg, "scan_goods/center_det.param", aa.jw(paramg));
      aa.n(paramg, "scan_goods/version/shufflenetv2_125_reid_cat8_rm_noise_wxcode_patch480_ep8.bin", aa.jx(paramg));
      aa.n(paramg, "scan_goods/version/shufflenetv2_125_reid_cat8_rm_noise_wxcode_patch480_ep8.param", aa.jy(paramg));
      aa.n(paramg, "scan_goods/version/shufflenet_0x5_op.bin", aa.jz(paramg));
      aa.n(paramg, "scan_goods/version/shufflenet_0x5_op.param", aa.jA(paramg));
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.scanner.api.c.class, new com.tencent.mm.plugin.scanner.h.b());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.scanner.api.b.class, new com.tencent.mm.plugin.scanner.h.a());
      paramg = com.tencent.mm.plugin.scanner.util.h.PiL;
      com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new com.tencent.mm.plugin.scanner.util.h(), new String[] { "//scan" });
      paramg = com.tencent.mm.plugin.scanner.box.a.a.a.OOg;
      paramg = com.tencent.mm.plugin.webview.jsapi.q.WEK;
      com.tencent.mm.plugin.webview.jsapi.q.ck(com.tencent.mm.plugin.scanner.box.a.a.a.gPY());
      AppMethodBeat.o(51555);
      return;
    }
    if (paramg.FH(":tools"))
    {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.scanner.api.c.class, new com.tencent.mm.plugin.scanner.h.b());
      AppMethodBeat.o(51555);
      return;
    }
    if (paramg.FI(":appbrand")) {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.scanner.api.c.class, new com.tencent.mm.plugin.scanner.h.b());
    }
    AppMethodBeat.o(51555);
  }
  
  public String genScanCaptureImgPath(String paramString)
  {
    AppMethodBeat.i(51558);
    o.gPw();
    paramString = o.getScanImageSaveDir() + String.format("%s_%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(51558);
    return paramString;
  }
  
  public String genScanTmpImgPath(String paramString)
  {
    AppMethodBeat.i(51559);
    o.gPw();
    paramString = o.getScanImageSaveDir() + String.format("%s_%d.%s", new Object[] { "tmp", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(51559);
    return paramString;
  }
  
  public String genScanTmpImgPath(String paramString1, String paramString2)
  {
    AppMethodBeat.i(313335);
    o.gPw();
    paramString1 = o.getScanImageSaveDir() + String.format("%s_%s.%s", new Object[] { "tmp", paramString1, paramString2 });
    AppMethodBeat.o(313335);
    return paramString1;
  }
  
  public String getAccScannerPath()
  {
    AppMethodBeat.i(51556);
    o.gPw();
    String str = o.getAccScannerPath();
    AppMethodBeat.o(51556);
    return str;
  }
  
  public String getScanImageSaveDir()
  {
    AppMethodBeat.i(51557);
    o.gPw();
    String str = o.getScanImageSaveDir();
    AppMethodBeat.o(51557);
    return str;
  }
  
  public m getScanTranslateCdnService()
  {
    return m.Pjn;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(313340);
    o.gPw();
    o.gPx();
    AppMethodBeat.o(313340);
  }
  
  public void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.PluginScanner
 * JD-Core Version:    0.7.0.1
 */