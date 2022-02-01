package com.tencent.mm.plugin.scanner.box;

import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl;", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListener;", "session", "", "boxDialogOnShowListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;)V", "createBoxWebViewEnd", "", "createBoxWebViewStart", "initWebViewEnd", "initWebViewStart", "reportInfo", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl$BoxWebViewPreloadReportInfo;", "showEnd", "showStart", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onCreateBoxWebViewEnd", "enablePreloadWebView", "", "enablePreloadFromFindTab", "useCache", "onCreateBoxWebViewStart", "onDismiss", "exitType", "", "onInitWebViewEnd", "onInitWebViewStart", "onShow", "onShowStart", "BoxWebViewPreloadReportInfo", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  implements j
{
  public static final b ONt;
  private long ONA;
  a ONB;
  private final g ONu;
  long ONv;
  private long ONw;
  private long ONx;
  private long ONy;
  private long ONz;
  final String hQR;
  
  static
  {
    AppMethodBeat.i(313737);
    ONt = new b((byte)0);
    AppMethodBeat.o(313737);
  }
  
  public k(String paramString, g paramg)
  {
    AppMethodBeat.i(313733);
    this.hQR = paramString;
    this.ONu = paramg;
    AppMethodBeat.o(313733);
  }
  
  public final void L(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(313771);
    Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onDismiss session: %s", new Object[] { this.hQR });
    g localg = this.ONu;
    if (localg != null) {
      localg.L(paramDialogInterface, paramInt);
    }
    AppMethodBeat.o(313771);
  }
  
  public final void fpP()
  {
    AppMethodBeat.i(313743);
    this.ONx = System.currentTimeMillis();
    Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onCreateBoxWebViewBefore session: %s", new Object[] { this.hQR });
    AppMethodBeat.o(313743);
  }
  
  public final void fpS()
  {
    AppMethodBeat.i(313754);
    Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onInitWebViewStart");
    this.ONz = System.currentTimeMillis();
    AppMethodBeat.o(313754);
  }
  
  public final void fpT()
  {
    AppMethodBeat.i(313761);
    this.ONA = System.currentTimeMillis();
    Object localObject = this.ONB;
    if (localObject != null) {
      ((a)localObject).ONE = (this.ONA - this.ONz);
    }
    String str = this.hQR;
    localObject = this.ONB;
    if (localObject == null) {}
    for (localObject = null;; localObject = Long.valueOf(((a)localObject).ONE))
    {
      Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onInitWebViewEnd session: %s, cost: %s", new Object[] { str, localObject });
      localObject = this.ONB;
      if (localObject != null) {
        ((a)localObject).report();
      }
      AppMethodBeat.o(313761);
      return;
    }
  }
  
  public final void n(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(313751);
    this.ONy = System.currentTimeMillis();
    Object localObject1 = this.ONB;
    if (localObject1 != null)
    {
      ((a)localObject1).GXw = paramBoolean1;
      ((a)localObject1).ONC = paramBoolean2;
      ((a)localObject1).igs = paramBoolean3;
      ((a)localObject1).OND = (this.ONy - this.ONx);
    }
    Object localObject2 = this.hQR;
    localObject1 = this.ONB;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onCreateBoxWebViewAfter session: %s, enablePreload: %b, useCache: %b, cost: %s", new Object[] { localObject2, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3), localObject1 });
      localObject1 = this.ONB;
      if (localObject1 == null) {
        break label256;
      }
      localObject2 = h.OAn;
      if (!((a)localObject1).GXw) {
        break label213;
      }
    }
    label213:
    for (int i = 130;; i = 150)
    {
      ((h)localObject2).kJ(1259, i);
      if (!((a)localObject1).GXw) {
        break label239;
      }
      if (((a)localObject1).igs) {
        break label221;
      }
      h.OAn.kJ(1259, 131);
      h.OAn.p(1259L, 133L, ((a)localObject1).OND);
      AppMethodBeat.o(313751);
      return;
      localObject1 = Long.valueOf(((a)localObject1).OND);
      break;
    }
    label221:
    h.OAn.kJ(1259, 132);
    AppMethodBeat.o(313751);
    return;
    label239:
    h.OAn.p(1259L, 151L, ((a)localObject1).OND);
    label256:
    AppMethodBeat.o(313751);
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(313777);
    Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onCancel session: %s", new Object[] { this.hQR });
    g localg = this.ONu;
    if (localg != null) {
      localg.onCancel(paramDialogInterface);
    }
    AppMethodBeat.o(313777);
  }
  
  public final void onShow(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(313766);
    Object localObject = this.ONu;
    if (localObject != null) {
      ((g)localObject).onShow(paramDialogInterface);
    }
    this.ONw = System.currentTimeMillis();
    paramDialogInterface = this.ONB;
    if (paramDialogInterface != null) {
      paramDialogInterface.ONF = (this.ONw - this.ONv);
    }
    localObject = this.hQR;
    paramDialogInterface = this.ONB;
    if (paramDialogInterface == null) {}
    for (paramDialogInterface = null;; paramDialogInterface = Long.valueOf(paramDialogInterface.ONF))
    {
      Log.i("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onShow session: %s, cost: %s", new Object[] { localObject, paramDialogInterface });
      paramDialogInterface = this.ONB;
      if (paramDialogInterface != null) {
        paramDialogInterface.report();
      }
      AppMethodBeat.o(313766);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl$BoxWebViewPreloadReportInfo;", "", "(Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl;)V", "enablePreloadFromFindTab", "", "getEnablePreloadFromFindTab", "()Z", "setEnablePreloadFromFindTab", "(Z)V", "enablePreloadWebView", "getEnablePreloadWebView", "setEnablePreloadWebView", "getWebViewCost", "", "getGetWebViewCost", "()J", "setGetWebViewCost", "(J)V", "initWebViewCost", "getInitWebViewCost", "setInitWebViewCost", "isReported", "setReported", "showCost", "getShowCost", "setShowCost", "useCache", "getUseCache", "setUseCache", "report", "", "reportWebViewCreate", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class a
  {
    boolean GXw;
    boolean ONC;
    long OND;
    long ONE;
    long ONF;
    boolean igs;
    private boolean lwK;
    
    public a()
    {
      AppMethodBeat.i(313704);
      this.OND = -1L;
      this.ONE = -1L;
      this.ONF = -1L;
      AppMethodBeat.o(313704);
    }
    
    public final void report()
    {
      int k = 1;
      AppMethodBeat.i(313718);
      if (this.lwK)
      {
        AppMethodBeat.o(313718);
        return;
      }
      h localh;
      int i;
      int j;
      label147:
      long l1;
      long l2;
      long l3;
      if ((this.OND >= 0L) && (this.ONF > 0L) && (this.ONE > 0L))
      {
        this.lwK = true;
        Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo reportScanGoodsWebViewCreate enablePreloadWebView: %b, enablePreloadFromFindTab: %b, useCache: %b, getWebViewCost: %d, initWebViewCost: %d, showCost: %d", new Object[] { Boolean.valueOf(this.GXw), Boolean.valueOf(this.ONC), Boolean.valueOf(this.igs), Long.valueOf(this.OND), Long.valueOf(this.ONE), Long.valueOf(this.ONF) });
        localh = h.OAn;
        if (!this.GXw) {
          break label236;
        }
        i = 1;
        if (!this.igs) {
          break label241;
        }
        j = 1;
        l1 = this.OND;
        l2 = this.ONE;
        l3 = this.ONF;
        if (!this.ONC) {
          break label246;
        }
      }
      for (;;)
      {
        localh.b(20835, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(k) });
        AppMethodBeat.o(313718);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl$Companion;", "", "()V", "TAG", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.k
 * JD-Core Version:    0.7.0.1
 */