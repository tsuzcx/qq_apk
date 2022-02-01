package com.tencent.mm.plugin.scanner.box;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.box.webview.a;
import com.tencent.mm.plugin.box.webview.d;
import com.tencent.mm.protocal.protobuf.ps;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog;", "Landroid/support/v7/app/AppCompatDialog;", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogModel;", "context", "Landroid/content/Context;", "theme", "", "homeContext", "Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;", "(Landroid/content/Context;ILcom/tencent/mm/protocal/protobuf/BoxHomeContext;)V", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;)V", "boxWebData", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebData;", "boxWebView", "Lcom/tencent/mm/plugin/box/webview/BoxWebView;", "boxWebViewJSApi", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi;", "fixedWebViewHeight", "isAttachedToWindow", "", "isFixedWebViewHeight", "mContext", "mDialogView", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogView;", "mEventListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogEventListener;", "mExitType", "configFullScreen", "", "dismiss", "dismissDialog", "exitType", "enableFullScreen", "getActivityContext", "getBoxWebData", "Lcom/tencent/mm/plugin/box/webview/IBoxWebData;", "getBoxWebView", "getBoxWebViewJsApi", "Lcom/tencent/mm/plugin/box/webview/BoxWebViewJSApi;", "getHomeContext", "init", "initContentView", "initWebView", "onAttachedToWindow", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "onPause", "onResume", "setBackgroundViewModel", "viewModel", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "setBoxDialogEventListener", "listener", "setBoxDialogMoveListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "setDimAmount", "amount", "", "setFixWebViewHeight", "fixedHeight", "setIsFixWebViewHeight", "fixed", "setWebViewEnableScroll", "enableScroll", "showDialog", "webviewUIReady", "Companion", "plugin-scan_release"})
public final class e
  extends android.support.v7.app.e
  implements com.tencent.mm.plugin.box.c.c, c
{
  public static final e.a yAZ;
  private boolean isAttachedToWindow;
  private Context mContext;
  private ps oaR;
  private BoxWebView oaU;
  private h yAU;
  private i yAV;
  b yAW;
  public BoxDialogView yAX;
  private int yAY;
  boolean yAu;
  int yAv;
  
  static
  {
    AppMethodBeat.i(52131);
    yAZ = new e.a((byte)0);
    AppMethodBeat.o(52131);
  }
  
  public e(Context paramContext, ps paramps)
  {
    super(paramContext, 2131820791);
    AppMethodBeat.i(52130);
    this.mContext = paramContext;
    this.oaR = paramps;
    AppMethodBeat.o(52130);
  }
  
  public final com.tencent.mm.plugin.box.webview.e bNY()
  {
    return (com.tencent.mm.plugin.box.webview.e)this.yAU;
  }
  
  public final d bNZ()
  {
    return (d)this.yAV;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(52125);
    BoxDialogView localBoxDialogView = this.yAX;
    if (localBoxDialogView != null)
    {
      localBoxDialogView.OV(5);
      AppMethodBeat.o(52125);
      return;
    }
    AppMethodBeat.o(52125);
  }
  
  public final void dismissDialog(int paramInt)
  {
    AppMethodBeat.i(52126);
    ae.d("MicroMsg.ScanBoxDialog", "alvinluo dismissDialog isShowing: %b, isAttachedToWindow: %b", new Object[] { Boolean.valueOf(isShowing()), Boolean.valueOf(this.isAttachedToWindow) });
    this.yAY = paramInt;
    if ((isShowing()) && (this.isAttachedToWindow)) {
      super.dismiss();
    }
    AppMethodBeat.o(52126);
  }
  
  public final Context getActivityContext()
  {
    AppMethodBeat.i(52129);
    Context localContext = getContext();
    p.g(localContext, "context");
    AppMethodBeat.o(52129);
    return localContext;
  }
  
  public final BoxWebView getBoxWebView()
  {
    return this.oaU;
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(52127);
    super.onAttachedToWindow();
    ae.v("MicroMsg.ScanBoxDialog", "alvinluo onAttachedToWindow %b", new Object[] { Boolean.valueOf(this.isAttachedToWindow) });
    this.isAttachedToWindow = true;
    AppMethodBeat.o(52127);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(161054);
    if (isShowing())
    {
      BoxDialogView localBoxDialogView = this.yAX;
      if (localBoxDialogView != null)
      {
        if (!localBoxDialogView.isAnimating) {
          localBoxDialogView.OV(5);
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
    ae.i("MicroMsg.ScanBoxDialog", "alvinluo onCreate");
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.addFlags(100729856);
    }
    gK();
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
      paramBundle.setWindowAnimations(2131820792);
    }
    paramBundle = this.mContext;
    if (paramBundle == null) {
      p.bdF("mContext");
    }
    this.yAX = new BoxDialogView(paramBundle);
    paramBundle = this.yAX;
    Object localObject;
    if (paramBundle != null)
    {
      localObject = (c)this;
      p.h(localObject, "dialogModel");
      paramBundle.yzZ = ((c)localObject);
    }
    paramBundle = this.yAX;
    if (paramBundle != null) {
      paramBundle.setIsFixWebViewHeight(this.yAu);
    }
    paramBundle = this.yAX;
    if (paramBundle != null) {
      paramBundle.setFixWebViewHeight(this.yAv);
    }
    paramBundle = this.yAX;
    if (paramBundle == null) {
      p.gkB();
    }
    setContentView((View)paramBundle, new ViewGroup.LayoutParams(-1, -1));
    paramBundle = this.oaR;
    if (paramBundle == null) {
      p.bdF("homeContext");
    }
    ae.i("MicroMsg.ScanBoxDialog", "alvinluo initWebView url: %s", new Object[] { paramBundle.Url });
    paramBundle = this.yAX;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getBoxWebView();; paramBundle = null)
    {
      this.oaU = paramBundle;
      this.yAU = new h((com.tencent.mm.plugin.box.c.c)this);
      this.yAV = new i((com.tencent.mm.plugin.box.c.c)this);
      paramBundle = new a();
      localObject = this.oaR;
      if (localObject == null) {
        p.bdF("homeContext");
      }
      localObject = new com.tencent.mm.plugin.box.webview.c((ps)localObject, (com.tencent.mm.plugin.box.webview.e)this.yAU);
      BoxWebView localBoxWebView = this.oaU;
      if (localBoxWebView != null) {
        localBoxWebView.a(paramBundle, (com.tencent.mm.plugin.box.webview.c)localObject);
      }
      paramBundle = this.oaU;
      if (paramBundle != null) {
        paramBundle.addJavascriptInterface(this.yAV, "boxJSApi");
      }
      paramBundle = this.oaU;
      if (paramBundle != null)
      {
        localObject = this.oaR;
        if (localObject == null) {
          p.bdF("homeContext");
        }
        paramBundle.loadUrl(((ps)localObject).Url);
      }
      setOnShowListener((DialogInterface.OnShowListener)new b(this));
      setOnDismissListener((DialogInterface.OnDismissListener)new c(this));
      setOnCancelListener((DialogInterface.OnCancelListener)new d(this));
      setCancelable(true);
      AppMethodBeat.o(52124);
      return;
    }
  }
  
  public final void onDetachedFromWindow()
  {
    AppMethodBeat.i(52128);
    super.onDetachedFromWindow();
    ae.v("MicroMsg.ScanBoxDialog", "alvinluo onDetachedFromWindow %b", new Object[] { Boolean.valueOf(this.isAttachedToWindow) });
    this.isAttachedToWindow = false;
    AppMethodBeat.o(52128);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onShow"})
  static final class b
    implements DialogInterface.OnShowListener
  {
    b(e parame) {}
    
    public final void onShow(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(52121);
      Object localObject1 = e.a(this.yBa);
      if (localObject1 != null)
      {
        ae.v("MicroMsg.BoxDialogView", "alvinluo showDialog");
        ((BoxDialogView)localObject1).vuQ = false;
        ((BoxDialogView)localObject1).isAnimating = true;
        ((BoxDialogView)localObject1).yAG = 0;
        Object localObject2 = ((BoxDialogView)localObject1).yAb;
        if (localObject2 == null) {
          p.bdF("dialogContainer");
        }
        ((View)localObject2).setTranslationY(((BoxDialogView)localObject1).getMaxTranslationY());
        localObject2 = ((BoxDialogView)localObject1).yAb;
        if (localObject2 == null) {
          p.bdF("dialogContainer");
        }
        localObject2 = ((View)localObject2).animate();
        if (localObject2 != null)
        {
          localObject2 = ((ViewPropertyAnimator)localObject2).translationY(((BoxDialogView)localObject1).yAl);
          if (localObject2 != null)
          {
            localObject2 = ((ViewPropertyAnimator)localObject2).setInterpolator((TimeInterpolator)((BoxDialogView)localObject1).yAF);
            if (localObject2 != null)
            {
              localObject2 = ((ViewPropertyAnimator)localObject2).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new BoxDialogView.l((BoxDialogView)localObject1));
              if (localObject2 != null)
              {
                localObject2 = ((ViewPropertyAnimator)localObject2).setListener((Animator.AnimatorListener)new BoxDialogView.m((BoxDialogView)localObject1));
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
        localObject2 = ((BoxDialogView)localObject1).animator;
        ((ValueAnimator)localObject2).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
        ((ValueAnimator)localObject2).setDuration(300L);
        ((ValueAnimator)localObject2).setFloatValues(new float[] { ((BoxDialogView)localObject1).yAD.yAI, ((BoxDialogView)localObject1).yAD.yAJ });
        ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new BoxDialogView.e((BoxDialogView)localObject1));
        ((ValueAnimator)localObject2).addListener((Animator.AnimatorListener)new BoxDialogView.f((BoxDialogView)localObject1));
        ((ValueAnimator)localObject2).setStartDelay(50L);
        ((ValueAnimator)localObject2).start();
      }
      localObject1 = e.b(this.yBa);
      if (localObject1 != null)
      {
        ((b)localObject1).onShow(paramDialogInterface);
        AppMethodBeat.o(52121);
        return;
      }
      AppMethodBeat.o(52121);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class c
    implements DialogInterface.OnDismissListener
  {
    c(e parame) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(52122);
      ae.i("MicroMsg.ScanBoxDialog", "dismiss dialog");
      Object localObject = e.c(this.yBa);
      if (localObject != null)
      {
        if (((h)localObject).yBe != null) {
          g.ajj().a((n)((h)localObject).yBe);
        }
        g.ajj().b(1532, (f)localObject);
      }
      localObject = e.d(this.yBa);
      if (localObject != null) {
        ((BoxWebView)localObject).destroy();
      }
      e.e(this.yBa);
      localObject = e.b(this.yBa);
      if (localObject != null)
      {
        ((b)localObject).a(paramDialogInterface, e.f(this.yBa));
        AppMethodBeat.o(52122);
        return;
      }
      AppMethodBeat.o(52122);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class d
    implements DialogInterface.OnCancelListener
  {
    d(e parame) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(52123);
      b localb = e.b(this.yBa);
      if (localb != null)
      {
        localb.onCancel(paramDialogInterface);
        AppMethodBeat.o(52123);
        return;
      }
      AppMethodBeat.o(52123);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.e
 * JD-Core Version:    0.7.0.1
 */