package com.tencent.mm.plugin.scanner.box;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.box.webview.d;
import com.tencent.mm.plugin.scanner.l.j;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.d;
import com.tencent.mm.plugin.webview.d.o;
import com.tencent.mm.plugin.webview.d.r;
import com.tencent.mm.protocal.protobuf.qm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.f;
import com.tencent.xweb.WebView;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogModel;", "context", "Landroid/content/Context;", "theme", "", "homeContext", "Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;", "(Landroid/content/Context;ILcom/tencent/mm/protocal/protobuf/BoxHomeContext;)V", "dialogView", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;", "listener", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListener;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListener;)V", "boxDialogViewListener", "boxWebData", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebData;", "boxWebView", "Lcom/tencent/mm/plugin/box/webview/BoxWebView;", "boxWebViewJSApi", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi;", "enableCancelOutside", "", "enableDialogScroll", "enableFullScreen", "enableScrollRightClose", "enableWebViewScroll", "fixedDialogHeight", "fixedDialogHeightRate", "", "isAttachedToWindow", "isFixedDialogHeight", "mContext", "mDialogView", "mExitType", "pendingShow", "showAfterWebViewReady", "webViewCallback", "com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewCallback$1", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewCallback$1;", "webViewClientListener", "com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewClientListener$1", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewClientListener$1;", "webViewController", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "webViewControllerListener", "com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewControllerListener$1", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewControllerListener$1;", "webViewReady", "configFullScreen", "", "createWebView", "dismiss", "dismissDialog", "exitType", "getActivityContext", "getBoxWebData", "Lcom/tencent/mm/plugin/box/webview/IBoxWebData;", "getBoxWebView", "getBoxWebViewJsApi", "Lcom/tencent/mm/plugin/box/webview/BoxWebViewJSApi;", "getHomeContext", "init", "initContentView", "initJsApi", "initWebView", "initWebViewController", "isShowingDialog", "onAttachedToWindow", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "onPause", "onResume", "realShow", "release", "setBackgroundOpView", "opView", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel;", "setBackgroundTouchListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundTouchListener;", "setBackgroundViewModel", "viewModel", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "setBoxDialogMoveListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "setBoxDialogViewListener", "setDimAmount", "amount", "setEnableCancelOutside", "enable", "setEnableDialogScroll", "enableScroll", "setEnableFullScreen", "setEnableScrollRightClose", "setEnableWebViewScroll", "setFixDialogHeight", "fixedHeight", "setFixDialogHeightRate", "rate", "setIsFixDialogHeight", "fixed", "setReportData", "data", "setShowAfterWebViewPageReady", "show", "showDialog", "startLoadUrl", "webviewUIReady", "Companion", "plugin-scan_release"})
public final class i
  extends androidx.appcompat.app.e
  implements com.tencent.mm.plugin.box.c.b, e
{
  public static final a IHm;
  boolean BqI;
  private boolean Bqv;
  int Bqw;
  float Bqy;
  BaseWebViewController BrC;
  private boolean Brm;
  private boolean Brn;
  boolean Bro;
  boolean IGq;
  private j IHb;
  private i IHc;
  private h IHd;
  p IHe;
  q IHf;
  private j IHg;
  public BaseBoxDialogView IHh;
  private int IHi;
  private boolean IHj;
  boolean IHk;
  boolean IHl;
  private boolean isAttachedToWindow;
  private Context mContext;
  private qm sog;
  BoxWebView soj;
  
  static
  {
    AppMethodBeat.i(52131);
    IHm = new a((byte)0);
    AppMethodBeat.o(52131);
  }
  
  public i(Context paramContext, qm paramqm, BaseBoxDialogView paramBaseBoxDialogView, j paramj)
  {
    super(paramContext, l.j.BoxDialog);
    AppMethodBeat.i(221747);
    this.IHb = new j(this);
    this.IHc = new i(this);
    this.IHd = new h(this);
    this.IGq = true;
    this.IHj = true;
    this.IHk = true;
    this.IHl = true;
    this.IHh = paramBaseBoxDialogView;
    this.IHg = paramj;
    paramBaseBoxDialogView = r.POE;
    r.a((com.tencent.mm.plugin.webview.d.e)o.POy);
    this.mContext = paramContext;
    this.sog = paramqm;
    this.IHf = new q((com.tencent.mm.plugin.box.c.b)this);
    paramContext = this.IHg;
    if (paramContext != null) {
      paramContext.elM();
    }
    paramContext = this.mContext;
    if (paramContext == null) {
      kotlin.g.b.p.bGy("mContext");
    }
    this.soj = h.a(paramContext, (kotlin.g.a.q)new b(this));
    this.Brm = false;
    paramContext = (aa)com.tencent.mm.kernel.h.ae(aa.class);
    paramqm = this.soj;
    if (paramqm == null) {
      kotlin.g.b.p.iCn();
    }
    this.BrC = paramContext.a((MMWebView)paramqm, new BaseWebViewController.d(null, true, false, false, true, 41), (com.tencent.mm.plugin.webview.d.e)o.POy);
    paramContext = this.BrC;
    if (paramContext != null) {
      paramContext.a((com.tencent.mm.plugin.webview.core.j)this.IHb);
    }
    paramContext = this.BrC;
    if (paramContext != null) {
      paramContext.a((com.tencent.mm.plugin.webview.core.f)this.IHc);
    }
    paramContext = this.BrC;
    if (paramContext != null) {
      paramContext.init();
    }
    paramContext = this.IHg;
    if (paramContext != null) {
      paramContext.elP();
    }
    Log.i("MicroMsg.ScanBoxDialog", "alvinluo initWebView");
    this.IHe = new p((com.tencent.mm.plugin.box.c.b)this);
    com.tencent.e.h.ZvG.bg((Runnable)new f(this));
    AppMethodBeat.o(221747);
  }
  
  private final void elL()
  {
    AppMethodBeat.i(221707);
    try
    {
      if (!(getContext() instanceof Activity)) {
        break label95;
      }
      Object localObject = getContext();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(221707);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ScanBoxDialog", (Throwable)localException, "realShowDialog exception", new Object[0]);
      AppMethodBeat.o(221707);
      return;
    }
    if (((Activity)localException).isFinishing())
    {
      Log.w("MicroMsg.ScanBoxDialog", "realShowDialog ui is finishing and ignore");
      AppMethodBeat.o(221707);
      return;
    }
    label95:
    super.show();
    AppMethodBeat.o(221707);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(221720);
    kotlin.g.b.p.k(paramf, "listener");
    BaseBoxDialogView localBaseBoxDialogView = this.IHh;
    if (localBaseBoxDialogView != null)
    {
      localBaseBoxDialogView.setBackgroundListener(paramf);
      AppMethodBeat.o(221720);
      return;
    }
    AppMethodBeat.o(221720);
  }
  
  public final void adl(int paramInt)
  {
    AppMethodBeat.i(52126);
    Log.d("MicroMsg.ScanBoxDialog", "alvinluo dismissDialog isShowing: %b, isAttachedToWindow: %b, exitType: %s", new Object[] { Boolean.valueOf(isShowing()), Boolean.valueOf(this.isAttachedToWindow), Integer.valueOf(paramInt) });
    this.IHi = paramInt;
    this.Brn = false;
    if ((isShowing()) && (this.isAttachedToWindow)) {
      super.dismiss();
    }
    AppMethodBeat.o(52126);
  }
  
  public final BoxWebView cyu()
  {
    return this.soj;
  }
  
  public final com.tencent.mm.plugin.box.webview.e cyv()
  {
    return (com.tencent.mm.plugin.box.webview.e)this.IHe;
  }
  
  public final d cyw()
  {
    return (d)this.IHf;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(52125);
    Log.i("MicroMsg.ScanBoxDialog", "alvinluo dismissDialog isShowing: %s", new Object[] { Boolean.valueOf(isShowing()) });
    this.Brn = false;
    if (isShowing())
    {
      BaseBoxDialogView localBaseBoxDialogView = this.IHh;
      if (localBaseBoxDialogView != null)
      {
        localBaseBoxDialogView.Se(5);
        AppMethodBeat.o(52125);
        return;
      }
    }
    AppMethodBeat.o(52125);
  }
  
  public final void fCh()
  {
    AppMethodBeat.i(221723);
    this.Bqv = true;
    BaseBoxDialogView localBaseBoxDialogView = this.IHh;
    if (localBaseBoxDialogView != null)
    {
      localBaseBoxDialogView.setIsFixDialogHeight(true);
      AppMethodBeat.o(221723);
      return;
    }
    AppMethodBeat.o(221723);
  }
  
  public final Context getActivityContext()
  {
    AppMethodBeat.i(52129);
    Context localContext = this.mContext;
    if (localContext == null) {
      kotlin.g.b.p.bGy("mContext");
    }
    AppMethodBeat.o(52129);
    return localContext;
  }
  
  public final boolean isShowingDialog()
  {
    AppMethodBeat.i(221714);
    if ((isShowing()) || (this.Brn))
    {
      AppMethodBeat.o(221714);
      return true;
    }
    AppMethodBeat.o(221714);
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
      BaseBoxDialogView localBaseBoxDialogView = this.IHh;
      if (localBaseBoxDialogView != null)
      {
        if (!localBaseBoxDialogView.isAnimating) {
          localBaseBoxDialogView.Se(5);
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
    if (this.IGq)
    {
      paramBundle = getWindow();
      if (paramBundle != null) {
        paramBundle.addFlags(100729856);
      }
      bb();
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
        paramBundle.setWindowAnimations(l.j.BoxDialogNoAnimation);
      }
      paramBundle = getWindow();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getDecorView();
        if (paramBundle != null)
        {
          kotlin.g.b.p.j(paramBundle, "this");
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
    for (int i = ((DisplayMetrics)localObject).widthPixels;; i = a.kr(paramBundle.getContext()))
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
      paramBundle = this.IHh;
      if (paramBundle != null)
      {
        localObject = this.soj;
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        localObject = (MMWebView)localObject;
        kotlin.g.b.p.k(localObject, "webView");
        paramBundle.Bqc = ((MMWebView)localObject);
        localObject = paramBundle.Bqc;
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        ((MMWebView)localObject).a((MMWebView.f)new BaseBoxDialogView.g(paramBundle));
        localObject = paramBundle.IGK;
        if (localObject == null) {
          kotlin.g.b.p.bGy("webViewContainer");
        }
        ((BoxWebViewContainer)localObject).addView((View)paramBundle.Bqc, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
      }
      paramBundle = this.IHh;
      if (paramBundle != null)
      {
        localObject = (e)this;
        kotlin.g.b.p.k(localObject, "dialogModel");
        paramBundle.IGJ = ((e)localObject);
      }
      paramBundle = this.IHh;
      if (paramBundle != null) {
        paramBundle.setIsFixDialogHeight(this.Bqv);
      }
      paramBundle = this.IHh;
      if (paramBundle != null) {
        paramBundle.setFixDialogHeight(this.Bqw);
      }
      paramBundle = this.IHh;
      if (paramBundle != null) {
        paramBundle.setFixDialogHeightRate(this.Bqy);
      }
      paramBundle = this.IHh;
      if (paramBundle != null) {
        paramBundle.setEnableDialogScroll(this.IHk);
      }
      paramBundle = this.IHh;
      if (paramBundle != null) {
        paramBundle.setEnableWebViewScroll(this.IHj);
      }
      paramBundle = this.IHh;
      if (paramBundle != null) {
        paramBundle.setCanceledOnTouchOutside(this.IHl);
      }
      paramBundle = this.IHh;
      if (paramBundle != null) {
        paramBundle.setEnableScrollRightClose(this.BqI);
      }
      paramBundle = this.IHh;
      if (paramBundle == null) {
        kotlin.g.b.p.iCn();
      }
      setContentView((View)paramBundle, new ViewGroup.LayoutParams(-1, -1));
      setOnShowListener((DialogInterface.OnShowListener)new c(this));
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
    AppMethodBeat.i(221704);
    Log.i("MicroMsg.ScanBoxDialog", "alvinluo showDialog showAfterWebViewReady: %b, webViewReady: %b", new Object[] { Boolean.valueOf(this.Bro), Boolean.valueOf(this.Brm) });
    if (this.Bro)
    {
      if (!this.Brm)
      {
        this.Brn = true;
        AppMethodBeat.o(221704);
        return;
      }
      elL();
      AppMethodBeat.o(221704);
      return;
    }
    elL();
    AppMethodBeat.o(221704);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "enablePreloadWebView", "", "enablePreloadFromFindTab", "useCache", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Boolean, Boolean, Boolean, x>
  {
    b(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onShow"})
  static final class c
    implements DialogInterface.OnShowListener
  {
    c(i parami) {}
    
    public final void onShow(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(217998);
      Object localObject1 = i.c(this.IHn);
      if (localObject1 != null)
      {
        Log.v("MicroMsg.BaseBoxDialogView", "alvinluo showDialog");
        ((BaseBoxDialogView)localObject1).BqB = false;
        ((BaseBoxDialogView)localObject1).isAnimating = true;
        ((BaseBoxDialogView)localObject1).BqN = 0;
        float f1 = ((BaseBoxDialogView)localObject1).getMaxTranslationY();
        float f2 = ((BaseBoxDialogView)localObject1).Bqm;
        Object localObject2 = ((BaseBoxDialogView)localObject1).BpY;
        if (localObject2 == null) {
          kotlin.g.b.p.bGy("dialogContainer");
        }
        ((View)localObject2).setTranslationY(f1);
        localObject2 = ((BaseBoxDialogView)localObject1).BpY;
        if (localObject2 == null) {
          kotlin.g.b.p.bGy("dialogContainer");
        }
        localObject2 = ((View)localObject2).animate();
        if (localObject2 != null)
        {
          localObject2 = ((ViewPropertyAnimator)localObject2).translationY(f2);
          if (localObject2 != null)
          {
            localObject2 = ((ViewPropertyAnimator)localObject2).setInterpolator((TimeInterpolator)((BaseBoxDialogView)localObject1).BqM);
            if (localObject2 != null)
            {
              localObject2 = ((ViewPropertyAnimator)localObject2).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new BaseBoxDialogView.l((BaseBoxDialogView)localObject1));
              if (localObject2 != null)
              {
                localObject2 = ((ViewPropertyAnimator)localObject2).setListener((Animator.AnimatorListener)new BaseBoxDialogView.m((BaseBoxDialogView)localObject1, f1, f2));
                if (localObject2 != null)
                {
                  localObject2 = ((ViewPropertyAnimator)localObject2).setDuration(300L);
                  if (localObject2 != null) {
                    ((ViewPropertyAnimator)localObject2).start();
                  }
                }
              }
            }
          }
        }
        localObject2 = ((BaseBoxDialogView)localObject1).animator;
        ((ValueAnimator)localObject2).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
        ((ValueAnimator)localObject2).setDuration(300L);
        ((ValueAnimator)localObject2).setFloatValues(new float[] { ((BaseBoxDialogView)localObject1).IGP.BqP, ((BaseBoxDialogView)localObject1).IGP.BqQ });
        ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new BaseBoxDialogView.e((BaseBoxDialogView)localObject1));
        ((ValueAnimator)localObject2).addListener((Animator.AnimatorListener)new BaseBoxDialogView.f((BaseBoxDialogView)localObject1));
        ((ValueAnimator)localObject2).setStartDelay(50L);
        ((ValueAnimator)localObject2).start();
      }
      localObject1 = i.d(this.IHn);
      if (localObject1 != null)
      {
        ((j)localObject1).onShow(paramDialogInterface);
        AppMethodBeat.o(217998);
        return;
      }
      AppMethodBeat.o(217998);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class d
    implements DialogInterface.OnDismissListener
  {
    d(i parami) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(221453);
      Log.i("MicroMsg.ScanBoxDialog", "dismiss dialog exitType: %s", new Object[] { Integer.valueOf(i.e(this.IHn)) });
      Object localObject = i.d(this.IHn);
      if (localObject != null) {
        ((j)localObject).a(paramDialogInterface, i.e(this.IHn));
      }
      paramDialogInterface = this.IHn;
      localObject = r.POE;
      r.b((com.tencent.mm.plugin.webview.d.e)o.POy);
      localObject = paramDialogInterface.IHe;
      if (localObject != null)
      {
        if (((p)localObject).IHM != null) {
          com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)((p)localObject).IHM);
        }
        com.tencent.mm.kernel.h.aGY().b(1532, (com.tencent.mm.an.i)localObject);
      }
      localObject = paramDialogInterface.soj;
      if (localObject != null) {
        ((BoxWebView)localObject).destroy();
      }
      paramDialogInterface.soj = null;
      if (paramDialogInterface.IHf != null) {
        q.release();
      }
      paramDialogInterface = paramDialogInterface.BrC;
      if (paramDialogInterface != null)
      {
        paramDialogInterface.onDestroy();
        AppMethodBeat.o(221453);
        return;
      }
      AppMethodBeat.o(221453);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class e
    implements DialogInterface.OnCancelListener
  {
    e(i parami) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(217429);
      j localj = i.d(this.IHn);
      if (localj != null)
      {
        localj.onCancel(paramDialogInterface);
        AppMethodBeat.o(217429);
        return;
      }
      AppMethodBeat.o(217429);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(218176);
      try
      {
        Object localObject = i.f(this.IHn);
        if (localObject != null) {
          ((BoxWebView)localObject).a(null, null);
        }
        localObject = i.f(this.IHn);
        if (localObject != null) {
          ((BoxWebView)localObject).addJavascriptInterface(i.g(this.IHn), "boxJSApi");
        }
        i.h(this.IHn);
        localObject = i.d(this.IHn);
        if (localObject != null)
        {
          ((j)localObject).elQ();
          AppMethodBeat.o(218176);
          return;
        }
        AppMethodBeat.o(218176);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.ScanBoxDialog", localThrowable, "initWebView exception", new Object[0]);
        com.tencent.e.h.ZvG.bc((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(217694);
            Object localObject = i.f(this.IHo.IHn);
            if (localObject != null) {
              ((BoxWebView)localObject).a(null, null);
            }
            localObject = i.f(this.IHo.IHn);
            if (localObject != null) {
              ((BoxWebView)localObject).addJavascriptInterface(i.g(this.IHo.IHn), "boxJSApi");
            }
            i.h(this.IHo.IHn);
            localObject = i.d(this.IHo.IHn);
            if (localObject != null)
            {
              ((j)localObject).elQ();
              AppMethodBeat.o(217694);
              return;
            }
            AppMethodBeat.o(217694);
          }
        });
        AppMethodBeat.o(218176);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(218358);
      Log.i("MicroMsg.ScanBoxDialog", "alvinluo startLoadUrl %s", new Object[] { i.a(this.IHn).Url });
      BaseWebViewController localBaseWebViewController = i.b(this.IHn);
      if (localBaseWebViewController != null)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", i.a(this.IHn).Url);
        localIntent.putExtra("useJs", true);
        localBaseWebViewController.bj(localIntent);
        AppMethodBeat.o(218358);
        return;
      }
      AppMethodBeat.o(218358);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewCallback$1", "Lcom/tencent/mm/plugin/webview/stub/DefaultWebViewStubCallback;", "getCommitUrl", "", "getCurrentUrl", "plugin-scan_release"})
  public static final class h
    extends com.tencent.mm.plugin.webview.stub.b
  {
    public final String bXN()
    {
      AppMethodBeat.i(219027);
      Log.v("MicroMsg.ScanBoxDialog", "alvinluo getCommitUrl");
      for (;;)
      {
        try
        {
          Object localObject = i.b(this.IHn);
          if (localObject != null)
          {
            String str2 = ((BaseWebViewController)localObject).PFN;
            localObject = str2;
            if (str2 != null)
            {
              AppMethodBeat.o(219027);
              return localObject;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.ScanBoxDialog", localThrowable, "getCommitUrl exception", new Object[0]);
          AppMethodBeat.o(219027);
          return "";
        }
        String str1 = "";
      }
    }
    
    public final String getCurrentUrl()
    {
      AppMethodBeat.i(219032);
      Log.v("MicroMsg.ScanBoxDialog", "alvinluo getCurrentUrl");
      for (;;)
      {
        try
        {
          Object localObject = i.b(this.IHn);
          if (localObject != null)
          {
            String str2 = ((BaseWebViewController)localObject).getCurrentUrl();
            localObject = str2;
            if (str2 != null)
            {
              AppMethodBeat.o(219032);
              return localObject;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.ScanBoxDialog", localThrowable, "getCommitUrl exception", new Object[0]);
          AppMethodBeat.o(219032);
          return "";
        }
        String str1 = "";
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewClientListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "onPageCommitVisible", "", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "onPageStarted", "webViewReady", "plugin-scan_release"})
  public static final class i
    extends com.tencent.mm.plugin.webview.core.f
  {
    private final void emb()
    {
      AppMethodBeat.i(216853);
      if (i.j(this.IHn))
      {
        AppMethodBeat.o(216853);
        return;
      }
      i.k(this.IHn);
      Log.i("MicroMsg.ScanBoxDialog", "alvinluo webViewReady showAfterWebViewReady: %b, pendingShow: %b", new Object[] { Boolean.valueOf(i.l(this.IHn)), Boolean.valueOf(i.m(this.IHn)) });
      if ((i.l(this.IHn)) && (i.m(this.IHn)))
      {
        i.n(this.IHn);
        this.IHn.show();
      }
      AppMethodBeat.o(216853);
    }
    
    public final void e(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(216851);
      super.e(paramWebView, paramString);
      emb();
      AppMethodBeat.o(216851);
    }
    
    public final void h(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(216852);
      super.h(paramWebView, paramString);
      emb();
      AppMethodBeat.o(216852);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewControllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onBinded", "", "plugin-scan_release"})
  public static final class j
    extends com.tencent.mm.plugin.webview.core.j
  {
    public final void bXM()
    {
      AppMethodBeat.i(222651);
      try
      {
        Object localObject = i.b(this.IHn);
        if (localObject != null)
        {
          localObject = ((BaseWebViewController)localObject).gSm();
          if (localObject != null)
          {
            com.tencent.mm.plugin.webview.stub.f localf = (com.tencent.mm.plugin.webview.stub.f)i.i(this.IHn);
            BaseWebViewController localBaseWebViewController = i.b(this.IHn);
            if (localBaseWebViewController != null) {}
            for (int i = localBaseWebViewController.gSo();; i = 0)
            {
              ((com.tencent.mm.plugin.webview.stub.e)localObject).a(localf, i);
              AppMethodBeat.o(222651);
              return;
            }
          }
        }
        AppMethodBeat.o(222651);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.ScanBoxDialog", localThrowable, "alvinluo initWebViewController exception", new Object[0]);
        AppMethodBeat.o(222651);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.i
 * JD-Core Version:    0.7.0.1
 */