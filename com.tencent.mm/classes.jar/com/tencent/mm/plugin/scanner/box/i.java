package com.tencent.mm.plugin.scanner.box;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.box.webview.d;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.c;
import com.tencent.mm.plugin.webview.d.o;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.e;
import com.tencent.xweb.WebView;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog;", "Landroid/support/v7/app/AppCompatDialog;", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogModel;", "context", "Landroid/content/Context;", "theme", "", "homeContext", "Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;", "(Landroid/content/Context;ILcom/tencent/mm/protocal/protobuf/BoxHomeContext;)V", "dialogView", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;", "listener", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListener;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListener;)V", "boxDialogViewListener", "boxWebData", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebData;", "boxWebView", "Lcom/tencent/mm/plugin/box/webview/BoxWebView;", "boxWebViewJSApi", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi;", "enableCancelOutside", "", "enableDialogScroll", "enableFullScreen", "enableScrollRightClose", "enableWebViewScroll", "fixedDialogHeight", "fixedDialogHeightRate", "", "isAttachedToWindow", "isFixedDialogHeight", "mContext", "mDialogView", "mExitType", "pendingShow", "showAfterWebViewReady", "webViewCallback", "com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewCallback$1", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewCallback$1;", "webViewClientListener", "com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewClientListener$1", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewClientListener$1;", "webViewController", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "webViewControllerListener", "com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewControllerListener$1", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewControllerListener$1;", "webViewReady", "configFullScreen", "", "createWebView", "dismiss", "dismissDialog", "exitType", "getActivityContext", "getBoxWebData", "Lcom/tencent/mm/plugin/box/webview/IBoxWebData;", "getBoxWebView", "getBoxWebViewJsApi", "Lcom/tencent/mm/plugin/box/webview/BoxWebViewJSApi;", "getHomeContext", "init", "initContentView", "initJsApi", "initWebView", "initWebViewController", "isShowingDialog", "onAttachedToWindow", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "onPause", "onResume", "realShow", "release", "setBackgroundOpView", "opView", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel;", "setBackgroundTouchListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundTouchListener;", "setBackgroundViewModel", "viewModel", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "setBoxDialogMoveListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "setBoxDialogViewListener", "setDimAmount", "amount", "setEnableCancelOutside", "enable", "setEnableDialogScroll", "enableScroll", "setEnableFullScreen", "setEnableScrollRightClose", "setEnableWebViewScroll", "setFixDialogHeight", "fixedHeight", "setFixDialogHeightRate", "rate", "setIsFixDialogHeight", "fixed", "setReportData", "data", "setShowAfterWebViewPageReady", "show", "showDialog", "startLoadUrl", "webviewUIReady", "Companion", "plugin-scan_release"})
public final class i
  extends android.support.v7.app.e
  implements com.tencent.mm.plugin.box.c.b, e
{
  public static final a CCM;
  boolean CAK;
  boolean CAL;
  private boolean CBG;
  int CBH;
  float CBJ;
  private h CCA;
  p CCB;
  q CCC;
  private j CCD;
  public BaseBoxDialogView CCE;
  private int CCF;
  private boolean CCG;
  boolean CCH;
  boolean CCI;
  boolean CCJ;
  private boolean CCK;
  private boolean CCL;
  BaseWebViewController CCx;
  private j CCy;
  private i CCz;
  private boolean isAttachedToWindow;
  private Context mContext;
  private qt plO;
  BoxWebView plR;
  
  static
  {
    AppMethodBeat.i(52131);
    CCM = new a((byte)0);
    AppMethodBeat.o(52131);
  }
  
  public i(Context paramContext, qt paramqt, BaseBoxDialogView paramBaseBoxDialogView, j paramj)
  {
    super(paramContext, 2131820794);
    AppMethodBeat.i(240272);
    this.CCy = new j(this);
    this.CCz = new i(this);
    this.CCA = new h(this);
    this.CAK = true;
    this.CCG = true;
    this.CCH = true;
    this.CCI = true;
    this.CCE = paramBaseBoxDialogView;
    this.CCD = paramj;
    paramBaseBoxDialogView = com.tencent.mm.plugin.webview.d.q.ISm;
    com.tencent.mm.plugin.webview.d.q.a((com.tencent.mm.plugin.webview.d.e)o.ISi);
    this.mContext = paramContext;
    this.plO = paramqt;
    this.CCC = new q((com.tencent.mm.plugin.box.c.b)this);
    paramContext = this.CCD;
    if (paramContext != null) {
      paramContext.ePs();
    }
    paramContext = this.mContext;
    if (paramContext == null) {
      kotlin.g.b.p.btv("mContext");
    }
    this.plR = h.a(paramContext, (kotlin.g.a.q)new b(this));
    this.CCK = false;
    paramContext = (aa)g.af(aa.class);
    paramqt = this.plR;
    if (paramqt == null) {
      kotlin.g.b.p.hyc();
    }
    this.CCx = paramContext.a((MMWebView)paramqt, new BaseWebViewController.c(null, true, false, false, true, 41), (com.tencent.mm.plugin.webview.d.e)o.ISi);
    paramContext = this.CCx;
    if (paramContext != null) {
      paramContext.a((com.tencent.mm.plugin.webview.core.j)this.CCy);
    }
    paramContext = this.CCx;
    if (paramContext != null) {
      paramContext.a((com.tencent.mm.plugin.webview.core.f)this.CCz);
    }
    paramContext = this.CCx;
    if (paramContext != null) {
      paramContext.init();
    }
    paramContext = this.CCD;
    if (paramContext != null) {
      paramContext.ePt();
    }
    Log.i("MicroMsg.ScanBoxDialog", "alvinluo initWebView");
    this.CCB = new p((com.tencent.mm.plugin.box.c.b)this);
    com.tencent.f.h.RTc.aZ((Runnable)new f(this));
    AppMethodBeat.o(240272);
  }
  
  private final void ePn()
  {
    AppMethodBeat.i(240268);
    try
    {
      if (!(getContext() instanceof Activity)) {
        break label95;
      }
      Object localObject = getContext();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(240268);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ScanBoxDialog", (Throwable)localException, "realShowDialog exception", new Object[0]);
      AppMethodBeat.o(240268);
      return;
    }
    if (((Activity)localException).isFinishing())
    {
      Log.w("MicroMsg.ScanBoxDialog", "realShowDialog ui is finishing and ignore");
      AppMethodBeat.o(240268);
      return;
    }
    label95:
    super.show();
    AppMethodBeat.o(240268);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(240270);
    kotlin.g.b.p.h(paramf, "listener");
    BaseBoxDialogView localBaseBoxDialogView = this.CCE;
    if (localBaseBoxDialogView != null)
    {
      localBaseBoxDialogView.setBackgroundListener(paramf);
      AppMethodBeat.o(240270);
      return;
    }
    AppMethodBeat.o(240270);
  }
  
  public final BoxWebView ckY()
  {
    return this.plR;
  }
  
  public final com.tencent.mm.plugin.box.webview.e ckZ()
  {
    return (com.tencent.mm.plugin.box.webview.e)this.CCB;
  }
  
  public final d cla()
  {
    return (d)this.CCC;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(52125);
    this.CCL = false;
    if (isShowing())
    {
      BaseBoxDialogView localBaseBoxDialogView = this.CCE;
      if (localBaseBoxDialogView != null)
      {
        localBaseBoxDialogView.Wr(5);
        AppMethodBeat.o(52125);
        return;
      }
    }
    AppMethodBeat.o(52125);
  }
  
  public final void dismissDialog(int paramInt)
  {
    AppMethodBeat.i(52126);
    Log.d("MicroMsg.ScanBoxDialog", "alvinluo dismissDialog isShowing: %b, isAttachedToWindow: %b, exitType: %s", new Object[] { Boolean.valueOf(isShowing()), Boolean.valueOf(this.isAttachedToWindow), Integer.valueOf(paramInt) });
    this.CCF = paramInt;
    this.CCL = false;
    if ((isShowing()) && (this.isAttachedToWindow)) {
      super.dismiss();
    }
    AppMethodBeat.o(52126);
  }
  
  public final void ePo()
  {
    AppMethodBeat.i(240271);
    this.CBG = true;
    BaseBoxDialogView localBaseBoxDialogView = this.CCE;
    if (localBaseBoxDialogView != null)
    {
      localBaseBoxDialogView.setIsFixDialogHeight(true);
      AppMethodBeat.o(240271);
      return;
    }
    AppMethodBeat.o(240271);
  }
  
  public final Context getActivityContext()
  {
    AppMethodBeat.i(52129);
    Context localContext = this.mContext;
    if (localContext == null) {
      kotlin.g.b.p.btv("mContext");
    }
    AppMethodBeat.o(52129);
    return localContext;
  }
  
  public final boolean isShowingDialog()
  {
    AppMethodBeat.i(240269);
    if ((isShowing()) || (this.CCL))
    {
      AppMethodBeat.o(240269);
      return true;
    }
    AppMethodBeat.o(240269);
    return false;
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(52127);
    super.onAttachedToWindow();
    Log.v("MicroMsg.ScanBoxDialog", "alvinluo onAttachedToWindow %b", new Object[] { Boolean.valueOf(this.isAttachedToWindow) });
    this.isAttachedToWindow = true;
    AppMethodBeat.o(52127);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(161054);
    if (isShowing())
    {
      BaseBoxDialogView localBaseBoxDialogView = this.CCE;
      if (localBaseBoxDialogView != null)
      {
        if (!localBaseBoxDialogView.isAnimating) {
          localBaseBoxDialogView.Wr(5);
        }
        AppMethodBeat.o(161054);
        return;
      }
    }
    super.onBackPressed();
    AppMethodBeat.o(161054);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(52124);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.ScanBoxDialog", "alvinluo onCreate");
    Object localObject;
    if (this.CAK)
    {
      paramBundle = getWindow();
      if (paramBundle != null) {
        paramBundle.addFlags(100729856);
      }
      gR();
      paramBundle = getWindow();
      if (paramBundle != null) {
        paramBundle.setLayout(-1, -1);
      }
      paramBundle = getWindow();
      if (paramBundle != null) {
        paramBundle.setDimAmount(0.0F);
      }
      paramBundle = getWindow();
      if (paramBundle != null) {
        paramBundle.setWindowAnimations(2131820795);
      }
      paramBundle = getWindow();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getDecorView();
        if (paramBundle != null)
        {
          kotlin.g.b.p.g(paramBundle, "this");
          localObject = paramBundle.getContext();
          if (localObject == null) {
            break label551;
          }
          localObject = ((Context)localObject).getResources();
          if (localObject == null) {
            break label551;
          }
          localObject = ((Resources)localObject).getDisplayMetrics();
          if (localObject == null) {
            break label551;
          }
        }
      }
    }
    label551:
    for (int i = ((DisplayMetrics)localObject).widthPixels;; i = a.jn(paramBundle.getContext()))
    {
      paramBundle.setMinimumWidth(i);
      paramBundle.setPadding(0, 0, 0, 0);
      paramBundle = getWindow();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getAttributes();
        if (paramBundle != null)
        {
          paramBundle.width = -1;
          paramBundle.height = -1;
          paramBundle.gravity = 80;
        }
      }
      paramBundle = this.CCE;
      if (paramBundle != null)
      {
        localObject = this.plR;
        if (localObject == null) {
          kotlin.g.b.p.hyc();
        }
        localObject = (MMWebView)localObject;
        kotlin.g.b.p.h(localObject, "webView");
        paramBundle.CBn = ((MMWebView)localObject);
        localObject = paramBundle.CBn;
        if (localObject == null) {
          kotlin.g.b.p.hyc();
        }
        ((MMWebView)localObject).a((MMWebView.e)new BaseBoxDialogView.g(paramBundle));
        localObject = paramBundle.CBk;
        if (localObject == null) {
          kotlin.g.b.p.btv("webViewContainer");
        }
        ((BoxWebViewContainer)localObject).addView((View)paramBundle.CBn, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
      }
      paramBundle = this.CCE;
      if (paramBundle != null)
      {
        localObject = (e)this;
        kotlin.g.b.p.h(localObject, "dialogModel");
        paramBundle.CBh = ((e)localObject);
      }
      paramBundle = this.CCE;
      if (paramBundle != null) {
        paramBundle.setIsFixDialogHeight(this.CBG);
      }
      paramBundle = this.CCE;
      if (paramBundle != null) {
        paramBundle.setFixDialogHeight(this.CBH);
      }
      paramBundle = this.CCE;
      if (paramBundle != null) {
        paramBundle.setFixDialogHeightRate(this.CBJ);
      }
      paramBundle = this.CCE;
      if (paramBundle != null) {
        paramBundle.setEnableDialogScroll(this.CCH);
      }
      paramBundle = this.CCE;
      if (paramBundle != null) {
        paramBundle.setEnableWebViewScroll(this.CCG);
      }
      paramBundle = this.CCE;
      if (paramBundle != null) {
        paramBundle.setCanceledOnTouchOutside(this.CCI);
      }
      paramBundle = this.CCE;
      if (paramBundle != null) {
        paramBundle.setEnableScrollRightClose(this.CAL);
      }
      paramBundle = this.CCE;
      if (paramBundle == null) {
        kotlin.g.b.p.hyc();
      }
      setContentView((View)paramBundle, new ViewGroup.LayoutParams(-1, -1));
      setOnShowListener((DialogInterface.OnShowListener)new i.c(this));
      setOnDismissListener((DialogInterface.OnDismissListener)new d(this));
      setOnCancelListener((DialogInterface.OnCancelListener)new e(this));
      setCancelable(true);
      AppMethodBeat.o(52124);
      return;
      paramBundle = getWindow();
      if (paramBundle == null) {
        break;
      }
      paramBundle.addFlags(67108864);
      break;
    }
  }
  
  public final void onDetachedFromWindow()
  {
    AppMethodBeat.i(52128);
    super.onDetachedFromWindow();
    Log.v("MicroMsg.ScanBoxDialog", "alvinluo onDetachedFromWindow %b", new Object[] { Boolean.valueOf(this.isAttachedToWindow) });
    this.isAttachedToWindow = false;
    AppMethodBeat.o(52128);
  }
  
  public final void show()
  {
    AppMethodBeat.i(240267);
    Log.i("MicroMsg.ScanBoxDialog", "alvinluo showDialog showAfterWebViewReady: %b, webViewReady: %b", new Object[] { Boolean.valueOf(this.CCJ), Boolean.valueOf(this.CCK) });
    if (this.CCJ)
    {
      if (!this.CCK)
      {
        this.CCL = true;
        AppMethodBeat.o(240267);
        return;
      }
      ePn();
      AppMethodBeat.o(240267);
      return;
    }
    ePn();
    AppMethodBeat.o(240267);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "enablePreloadWebView", "", "enablePreloadFromFindTab", "useCache", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Boolean, Boolean, Boolean, x>
  {
    b(i parami)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class d
    implements DialogInterface.OnDismissListener
  {
    d(i parami) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(240256);
      Log.i("MicroMsg.ScanBoxDialog", "dismiss dialog");
      Object localObject = i.d(this.CCN);
      if (localObject != null) {
        ((j)localObject).a(paramDialogInterface, i.e(this.CCN));
      }
      paramDialogInterface = this.CCN;
      localObject = com.tencent.mm.plugin.webview.d.q.ISm;
      com.tencent.mm.plugin.webview.d.q.b((com.tencent.mm.plugin.webview.d.e)o.ISi);
      localObject = paramDialogInterface.CCB;
      if (localObject != null)
      {
        if (((p)localObject).CDm != null) {
          g.azz().a((com.tencent.mm.ak.q)((p)localObject).CDm);
        }
        g.azz().b(1532, (com.tencent.mm.ak.i)localObject);
      }
      localObject = paramDialogInterface.plR;
      if (localObject != null) {
        ((BoxWebView)localObject).destroy();
      }
      paramDialogInterface.plR = null;
      if (paramDialogInterface.CCC != null) {
        q.release();
      }
      paramDialogInterface = paramDialogInterface.CCx;
      if (paramDialogInterface != null)
      {
        paramDialogInterface.onDestroy();
        AppMethodBeat.o(240256);
        return;
      }
      AppMethodBeat.o(240256);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class e
    implements DialogInterface.OnCancelListener
  {
    e(i parami) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(240257);
      j localj = i.d(this.CCN);
      if (localj != null)
      {
        localj.onCancel(paramDialogInterface);
        AppMethodBeat.o(240257);
        return;
      }
      AppMethodBeat.o(240257);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(240259);
      try
      {
        Object localObject = i.f(this.CCN);
        if (localObject != null) {
          ((BoxWebView)localObject).a(null, null);
        }
        localObject = i.f(this.CCN);
        if (localObject != null) {
          ((BoxWebView)localObject).addJavascriptInterface(i.g(this.CCN), "boxJSApi");
        }
        i.h(this.CCN);
        localObject = i.d(this.CCN);
        if (localObject != null)
        {
          ((j)localObject).ePu();
          AppMethodBeat.o(240259);
          return;
        }
        AppMethodBeat.o(240259);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.ScanBoxDialog", localThrowable, "initWebView exception", new Object[0]);
        com.tencent.f.h.RTc.aV((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(240258);
            Object localObject = i.f(this.CCO.CCN);
            if (localObject != null) {
              ((BoxWebView)localObject).a(null, null);
            }
            localObject = i.f(this.CCO.CCN);
            if (localObject != null) {
              ((BoxWebView)localObject).addJavascriptInterface(i.g(this.CCO.CCN), "boxJSApi");
            }
            i.h(this.CCO.CCN);
            localObject = i.d(this.CCO.CCN);
            if (localObject != null)
            {
              ((j)localObject).ePu();
              AppMethodBeat.o(240258);
              return;
            }
            AppMethodBeat.o(240258);
          }
        });
        AppMethodBeat.o(240259);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(240260);
      Log.i("MicroMsg.ScanBoxDialog", "alvinluo startLoadUrl %s", new Object[] { i.a(this.CCN).Url });
      BaseWebViewController localBaseWebViewController = i.b(this.CCN);
      if (localBaseWebViewController != null)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", i.a(this.CCN).Url);
        localIntent.putExtra("useJs", true);
        localBaseWebViewController.aB(localIntent);
        AppMethodBeat.o(240260);
        return;
      }
      AppMethodBeat.o(240260);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewCallback$1", "Lcom/tencent/mm/plugin/webview/stub/DefaultWebViewStubCallback;", "getCommitUrl", "", "getCurrentUrl", "plugin-scan_release"})
  public static final class h
    extends com.tencent.mm.plugin.webview.stub.b
  {
    public final String ePp()
    {
      AppMethodBeat.i(240261);
      Log.v("MicroMsg.ScanBoxDialog", "alvinluo getCommitUrl");
      for (;;)
      {
        try
        {
          Object localObject = i.b(this.CCN);
          if (localObject != null)
          {
            String str2 = ((BaseWebViewController)localObject).IJP;
            localObject = str2;
            if (str2 != null)
            {
              AppMethodBeat.o(240261);
              return localObject;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.ScanBoxDialog", localThrowable, "getCommitUrl exception", new Object[0]);
          AppMethodBeat.o(240261);
          return "";
        }
        String str1 = "";
      }
    }
    
    public final String getCurrentUrl()
    {
      AppMethodBeat.i(240262);
      Log.v("MicroMsg.ScanBoxDialog", "alvinluo getCurrentUrl");
      for (;;)
      {
        try
        {
          Object localObject = i.b(this.CCN);
          if (localObject != null)
          {
            String str2 = ((BaseWebViewController)localObject).getCurrentUrl();
            localObject = str2;
            if (str2 != null)
            {
              AppMethodBeat.o(240262);
              return localObject;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.ScanBoxDialog", localThrowable, "getCommitUrl exception", new Object[0]);
          AppMethodBeat.o(240262);
          return "";
        }
        String str1 = "";
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewClientListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "onPageCommitVisible", "", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "onPageStarted", "webViewReady", "plugin-scan_release"})
  public static final class i
    extends com.tencent.mm.plugin.webview.core.f
  {
    private final void ePq()
    {
      AppMethodBeat.i(240265);
      if (i.j(this.CCN))
      {
        AppMethodBeat.o(240265);
        return;
      }
      i.k(this.CCN);
      Log.i("MicroMsg.ScanBoxDialog", "alvinluo webViewReady showAfterWebViewReady: %b, pendingShow: %b", new Object[] { Boolean.valueOf(i.l(this.CCN)), Boolean.valueOf(i.m(this.CCN)) });
      if ((i.l(this.CCN)) && (i.m(this.CCN)))
      {
        i.n(this.CCN);
        this.CCN.show();
      }
      AppMethodBeat.o(240265);
    }
    
    public final void e(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(240263);
      super.e(paramWebView, paramString);
      ePq();
      AppMethodBeat.o(240263);
    }
    
    public final void i(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(240264);
      super.i(paramWebView, paramString);
      ePq();
      AppMethodBeat.o(240264);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewControllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onBinded", "", "plugin-scan_release"})
  public static final class j
    extends com.tencent.mm.plugin.webview.core.j
  {
    public final void ePr()
    {
      AppMethodBeat.i(240266);
      try
      {
        Object localObject = i.b(this.CCN);
        if (localObject != null)
        {
          localObject = ((BaseWebViewController)localObject).fZs();
          if (localObject != null)
          {
            com.tencent.mm.plugin.webview.stub.f localf = (com.tencent.mm.plugin.webview.stub.f)i.i(this.CCN);
            BaseWebViewController localBaseWebViewController = i.b(this.CCN);
            if (localBaseWebViewController != null) {}
            for (int i = localBaseWebViewController.fZu();; i = 0)
            {
              ((com.tencent.mm.plugin.webview.stub.e)localObject).a(localf, i);
              AppMethodBeat.o(240266);
              return;
            }
          }
        }
        AppMethodBeat.o(240266);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.ScanBoxDialog", localThrowable, "alvinluo initWebViewController exception", new Object[0]);
        AppMethodBeat.o(240266);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.i
 * JD-Core Version:    0.7.0.1
 */