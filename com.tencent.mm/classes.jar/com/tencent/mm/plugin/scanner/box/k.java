package com.tencent.mm.plugin.scanner.box;

import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl;", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListener;", "session", "", "boxDialogOnShowListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;)V", "createBoxWebViewEnd", "", "createBoxWebViewStart", "initWebViewEnd", "initWebViewStart", "reportInfo", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl$BoxWebViewPreloadReportInfo;", "showEnd", "showStart", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onCreateBoxWebViewEnd", "enablePreloadWebView", "", "enablePreloadFromFindTab", "useCache", "onCreateBoxWebViewStart", "onDismiss", "exitType", "", "onInitWebViewEnd", "onInitWebViewStart", "onShow", "onShowStart", "BoxWebViewPreloadReportInfo", "Companion", "plugin-scan_release"})
public final class k
  implements j
{
  public static final b CCX;
  long CCP;
  private long CCQ;
  private long CCR;
  private long CCS;
  private long CCT;
  private long CCU;
  a CCV;
  private final g CCW;
  final String dRM;
  
  static
  {
    AppMethodBeat.i(240284);
    CCX = new b((byte)0);
    AppMethodBeat.o(240284);
  }
  
  public k(String paramString, g paramg)
  {
    AppMethodBeat.i(240283);
    this.dRM = paramString;
    this.CCW = paramg;
    AppMethodBeat.o(240283);
  }
  
  public final void a(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(240281);
    Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onDismiss session: %s", new Object[] { this.dRM });
    g localg = this.CCW;
    if (localg != null)
    {
      localg.a(paramDialogInterface, paramInt);
      AppMethodBeat.o(240281);
      return;
    }
    AppMethodBeat.o(240281);
  }
  
  public final void ePs()
  {
    AppMethodBeat.i(240276);
    this.CCR = System.currentTimeMillis();
    Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onCreateBoxWebViewBefore session: %s", new Object[] { this.dRM });
    AppMethodBeat.o(240276);
  }
  
  public final void ePt()
  {
    AppMethodBeat.i(240278);
    Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onInitWebViewStart");
    this.CCT = System.currentTimeMillis();
    AppMethodBeat.o(240278);
  }
  
  public final void ePu()
  {
    AppMethodBeat.i(240279);
    this.CCU = System.currentTimeMillis();
    Object localObject = this.CCV;
    if (localObject != null) {
      ((a)localObject).CDa = (this.CCU - this.CCT);
    }
    String str = this.dRM;
    localObject = this.CCV;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((a)localObject).CDa);; localObject = null)
    {
      Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onInitWebViewEnd session: %s, cost: %s", new Object[] { str, localObject });
      localObject = this.CCV;
      if (localObject == null) {
        break;
      }
      ((a)localObject).report();
      AppMethodBeat.o(240279);
      return;
    }
    AppMethodBeat.o(240279);
  }
  
  public final void n(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(240277);
    this.CCS = System.currentTimeMillis();
    Object localObject1 = this.CCV;
    if (localObject1 != null)
    {
      ((a)localObject1).CCq = paramBoolean1;
      ((a)localObject1).CCY = paramBoolean2;
      ((a)localObject1).efT = paramBoolean3;
      ((a)localObject1).CCZ = (this.CCS - this.CCR);
    }
    Object localObject2 = this.dRM;
    localObject1 = this.CCV;
    if (localObject1 != null)
    {
      localObject1 = Long.valueOf(((a)localObject1).CCZ);
      Log.i("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onCreateBoxWebViewAfter session: %s, enablePreload: %b, useCache: %b, cost: %s", new Object[] { localObject2, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3), localObject1 });
      localObject1 = this.CCV;
      if (localObject1 == null) {
        break label262;
      }
      localObject2 = h.CyF;
      if (!((a)localObject1).CCq) {
        break label213;
      }
    }
    label213:
    for (int i = 130;; i = 150)
    {
      ((h)localObject2).dN(1259, i);
      if (!((a)localObject1).CCq) {
        break label239;
      }
      if (((a)localObject1).efT) {
        break label221;
      }
      h.CyF.dN(1259, 131);
      h.CyF.n(1259L, 133L, ((a)localObject1).CCZ);
      AppMethodBeat.o(240277);
      return;
      localObject1 = null;
      break;
    }
    label221:
    h.CyF.dN(1259, 132);
    AppMethodBeat.o(240277);
    return;
    label239:
    h.CyF.n(1259L, 151L, ((a)localObject1).CCZ);
    AppMethodBeat.o(240277);
    return;
    label262:
    AppMethodBeat.o(240277);
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(240282);
    Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onCancel session: %s", new Object[] { this.dRM });
    g localg = this.CCW;
    if (localg != null)
    {
      localg.onCancel(paramDialogInterface);
      AppMethodBeat.o(240282);
      return;
    }
    AppMethodBeat.o(240282);
  }
  
  public final void onShow(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(240280);
    Object localObject = this.CCW;
    if (localObject != null) {
      ((g)localObject).onShow(paramDialogInterface);
    }
    this.CCQ = System.currentTimeMillis();
    paramDialogInterface = this.CCV;
    if (paramDialogInterface != null) {
      paramDialogInterface.CDb = (this.CCQ - this.CCP);
    }
    localObject = this.dRM;
    paramDialogInterface = this.CCV;
    if (paramDialogInterface != null) {}
    for (paramDialogInterface = Long.valueOf(paramDialogInterface.CDb);; paramDialogInterface = null)
    {
      Log.i("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onShow session: %s, cost: %s", new Object[] { localObject, paramDialogInterface });
      paramDialogInterface = this.CCV;
      if (paramDialogInterface == null) {
        break;
      }
      paramDialogInterface.report();
      AppMethodBeat.o(240280);
      return;
    }
    AppMethodBeat.o(240280);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl$BoxWebViewPreloadReportInfo;", "", "(Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl;)V", "enablePreloadFromFindTab", "", "getEnablePreloadFromFindTab", "()Z", "setEnablePreloadFromFindTab", "(Z)V", "enablePreloadWebView", "getEnablePreloadWebView", "setEnablePreloadWebView", "getWebViewCost", "", "getGetWebViewCost", "()J", "setGetWebViewCost", "(J)V", "initWebViewCost", "getInitWebViewCost", "setInitWebViewCost", "isReported", "setReported", "showCost", "getShowCost", "setShowCost", "useCache", "getUseCache", "setUseCache", "report", "", "reportWebViewCreate", "plugin-scan_release"})
  final class a
  {
    boolean CCY;
    long CCZ = -1L;
    boolean CCq;
    long CDa = -1L;
    long CDb = -1L;
    boolean efT;
    private boolean gqx;
    
    public final void report()
    {
      int k = 1;
      AppMethodBeat.i(240275);
      if (this.gqx)
      {
        AppMethodBeat.o(240275);
        return;
      }
      h localh;
      int i;
      int j;
      label147:
      long l1;
      long l2;
      long l3;
      if ((this.CCZ >= 0L) && (this.CDb > 0L) && (this.CDa > 0L))
      {
        this.gqx = true;
        Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo reportScanGoodsWebViewCreate enablePreloadWebView: %b, enablePreloadFromFindTab: %b, useCache: %b, getWebViewCost: %d, initWebViewCost: %d, showCost: %d", new Object[] { Boolean.valueOf(this.CCq), Boolean.valueOf(this.CCY), Boolean.valueOf(this.efT), Long.valueOf(this.CCZ), Long.valueOf(this.CDa), Long.valueOf(this.CDb) });
        localh = h.CyF;
        if (!this.CCq) {
          break label236;
        }
        i = 1;
        if (!this.efT) {
          break label241;
        }
        j = 1;
        l1 = this.CCZ;
        l2 = this.CDa;
        l3 = this.CDb;
        if (!this.CCY) {
          break label246;
        }
      }
      for (;;)
      {
        localh.a(20835, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(k) });
        AppMethodBeat.o(240275);
        return;
        label236:
        i = 0;
        break;
        label241:
        j = 0;
        break label147;
        label246:
        k = 0;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.k
 * JD-Core Version:    0.7.0.1
 */