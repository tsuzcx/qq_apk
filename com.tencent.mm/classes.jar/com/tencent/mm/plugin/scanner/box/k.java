package com.tencent.mm.plugin.scanner.box;

import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl;", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListener;", "session", "", "boxDialogOnShowListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;)V", "createBoxWebViewEnd", "", "createBoxWebViewStart", "initWebViewEnd", "initWebViewStart", "reportInfo", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl$BoxWebViewPreloadReportInfo;", "showEnd", "showStart", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onCreateBoxWebViewEnd", "enablePreloadWebView", "", "enablePreloadFromFindTab", "useCache", "onCreateBoxWebViewStart", "onDismiss", "exitType", "", "onInitWebViewEnd", "onInitWebViewStart", "onShow", "onShowStart", "BoxWebViewPreloadReportInfo", "Companion", "plugin-scan_release"})
public final class k
  implements j
{
  public static final b IHx;
  long IHp;
  private long IHq;
  private long IHr;
  private long IHs;
  private long IHt;
  private long IHu;
  a IHv;
  private final g IHw;
  final String fLj;
  
  static
  {
    AppMethodBeat.i(223101);
    IHx = new b((byte)0);
    AppMethodBeat.o(223101);
  }
  
  public k(String paramString, g paramg)
  {
    AppMethodBeat.i(223100);
    this.fLj = paramString;
    this.IHw = paramg;
    AppMethodBeat.o(223100);
  }
  
  public final void a(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(223096);
    Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onDismiss session: %s", new Object[] { this.fLj });
    g localg = this.IHw;
    if (localg != null)
    {
      localg.a(paramDialogInterface, paramInt);
      AppMethodBeat.o(223096);
      return;
    }
    AppMethodBeat.o(223096);
  }
  
  public final void elM()
  {
    AppMethodBeat.i(223082);
    this.IHr = System.currentTimeMillis();
    Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onCreateBoxWebViewBefore session: %s", new Object[] { this.fLj });
    AppMethodBeat.o(223082);
  }
  
  public final void elP()
  {
    AppMethodBeat.i(223090);
    Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onInitWebViewStart");
    this.IHt = System.currentTimeMillis();
    AppMethodBeat.o(223090);
  }
  
  public final void elQ()
  {
    AppMethodBeat.i(223094);
    this.IHu = System.currentTimeMillis();
    Object localObject = this.IHv;
    if (localObject != null) {
      ((a)localObject).IHA = (this.IHu - this.IHt);
    }
    String str = this.fLj;
    localObject = this.IHv;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((a)localObject).IHA);; localObject = null)
    {
      Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onInitWebViewEnd session: %s, cost: %s", new Object[] { str, localObject });
      localObject = this.IHv;
      if (localObject == null) {
        break;
      }
      ((a)localObject).report();
      AppMethodBeat.o(223094);
      return;
    }
    AppMethodBeat.o(223094);
  }
  
  public final void l(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(223088);
    this.IHs = System.currentTimeMillis();
    Object localObject1 = this.IHv;
    if (localObject1 != null)
    {
      ((a)localObject1).Brd = paramBoolean1;
      ((a)localObject1).IHy = paramBoolean2;
      ((a)localObject1).gaj = paramBoolean3;
      ((a)localObject1).IHz = (this.IHs - this.IHr);
    }
    Object localObject2 = this.fLj;
    localObject1 = this.IHv;
    if (localObject1 != null)
    {
      localObject1 = Long.valueOf(((a)localObject1).IHz);
      Log.i("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onCreateBoxWebViewAfter session: %s, enablePreload: %b, useCache: %b, cost: %s", new Object[] { localObject2, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3), localObject1 });
      localObject1 = this.IHv;
      if (localObject1 == null) {
        break label262;
      }
      localObject2 = h.IzE;
      if (!((a)localObject1).Brd) {
        break label213;
      }
    }
    label213:
    for (int i = 130;; i = 150)
    {
      ((h)localObject2).el(1259, i);
      if (!((a)localObject1).Brd) {
        break label239;
      }
      if (((a)localObject1).gaj) {
        break label221;
      }
      h.IzE.el(1259, 131);
      h.IzE.p(1259L, 133L, ((a)localObject1).IHz);
      AppMethodBeat.o(223088);
      return;
      localObject1 = null;
      break;
    }
    label221:
    h.IzE.el(1259, 132);
    AppMethodBeat.o(223088);
    return;
    label239:
    h.IzE.p(1259L, 151L, ((a)localObject1).IHz);
    AppMethodBeat.o(223088);
    return;
    label262:
    AppMethodBeat.o(223088);
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(223099);
    Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onCancel session: %s", new Object[] { this.fLj });
    g localg = this.IHw;
    if (localg != null)
    {
      localg.onCancel(paramDialogInterface);
      AppMethodBeat.o(223099);
      return;
    }
    AppMethodBeat.o(223099);
  }
  
  public final void onShow(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(223095);
    Object localObject = this.IHw;
    if (localObject != null) {
      ((g)localObject).onShow(paramDialogInterface);
    }
    this.IHq = System.currentTimeMillis();
    paramDialogInterface = this.IHv;
    if (paramDialogInterface != null) {
      paramDialogInterface.IHB = (this.IHq - this.IHp);
    }
    localObject = this.fLj;
    paramDialogInterface = this.IHv;
    if (paramDialogInterface != null) {}
    for (paramDialogInterface = Long.valueOf(paramDialogInterface.IHB);; paramDialogInterface = null)
    {
      Log.i("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onShow session: %s, cost: %s", new Object[] { localObject, paramDialogInterface });
      paramDialogInterface = this.IHv;
      if (paramDialogInterface == null) {
        break;
      }
      paramDialogInterface.report();
      AppMethodBeat.o(223095);
      return;
    }
    AppMethodBeat.o(223095);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl$BoxWebViewPreloadReportInfo;", "", "(Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl;)V", "enablePreloadFromFindTab", "", "getEnablePreloadFromFindTab", "()Z", "setEnablePreloadFromFindTab", "(Z)V", "enablePreloadWebView", "getEnablePreloadWebView", "setEnablePreloadWebView", "getWebViewCost", "", "getGetWebViewCost", "()J", "setGetWebViewCost", "(J)V", "initWebViewCost", "getInitWebViewCost", "setInitWebViewCost", "isReported", "setReported", "showCost", "getShowCost", "setShowCost", "useCache", "getUseCache", "setUseCache", "report", "", "reportWebViewCreate", "plugin-scan_release"})
  final class a
  {
    boolean Brd;
    long IHA = -1L;
    long IHB = -1L;
    boolean IHy;
    long IHz = -1L;
    boolean gaj;
    private boolean iUF;
    
    public final void report()
    {
      int k = 1;
      AppMethodBeat.i(221616);
      if (this.iUF)
      {
        AppMethodBeat.o(221616);
        return;
      }
      h localh;
      int i;
      int j;
      label147:
      long l1;
      long l2;
      long l3;
      if ((this.IHz >= 0L) && (this.IHB > 0L) && (this.IHA > 0L))
      {
        this.iUF = true;
        Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo reportScanGoodsWebViewCreate enablePreloadWebView: %b, enablePreloadFromFindTab: %b, useCache: %b, getWebViewCost: %d, initWebViewCost: %d, showCost: %d", new Object[] { Boolean.valueOf(this.Brd), Boolean.valueOf(this.IHy), Boolean.valueOf(this.gaj), Long.valueOf(this.IHz), Long.valueOf(this.IHA), Long.valueOf(this.IHB) });
        localh = h.IzE;
        if (!this.Brd) {
          break label236;
        }
        i = 1;
        if (!this.gaj) {
          break label241;
        }
        j = 1;
        l1 = this.IHz;
        l2 = this.IHA;
        l3 = this.IHB;
        if (!this.IHy) {
          break label246;
        }
      }
      for (;;)
      {
        localh.a(20835, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(k) });
        AppMethodBeat.o(221616);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.k
 * JD-Core Version:    0.7.0.1
 */