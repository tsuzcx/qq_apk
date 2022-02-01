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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.box.webview.a;
import com.tencent.mm.plugin.box.webview.d;
import com.tencent.mm.protocal.protobuf.oe;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog;", "Landroid/support/v7/app/AppCompatDialog;", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogModel;", "context", "Landroid/content/Context;", "theme", "", "homeContext", "Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;", "(Landroid/content/Context;ILcom/tencent/mm/protocal/protobuf/BoxHomeContext;)V", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;)V", "boxWebData", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebData;", "boxWebView", "Lcom/tencent/mm/plugin/box/webview/BoxWebView;", "boxWebViewJSApi", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi;", "isAttachedToWindow", "", "mContext", "mDialogView", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogView;", "mEventListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogEventListener;", "mExitType", "configFullScreen", "", "dismiss", "dismissDialog", "exitType", "enableFullScreen", "getActivityContext", "getBoxWebData", "Lcom/tencent/mm/plugin/box/webview/IBoxWebData;", "getBoxWebView", "getBoxWebViewJsApi", "Lcom/tencent/mm/plugin/box/webview/BoxWebViewJSApi;", "getHomeContext", "init", "initContentView", "initWebView", "onAttachedToWindow", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "setBackgroundViewModel", "viewModel", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "setBoxDialogEventListener", "listener", "setBoxDialogMoveListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "setDimAmount", "amount", "", "showDialog", "webviewUIReady", "Companion", "plugin-scan_release"})
public final class e
  extends android.support.v7.app.e
  implements com.tencent.mm.plugin.box.c.c, c
{
  public static final a vMY;
  private Context mContext;
  private oe mRE;
  private BoxWebView mRH;
  private h vMS;
  private i vMT;
  b vMU;
  public BoxDialogView vMV;
  private boolean vMW;
  private int vMX;
  
  static
  {
    AppMethodBeat.i(52131);
    vMY = new a((byte)0);
    AppMethodBeat.o(52131);
  }
  
  public e(Context paramContext, oe paramoe)
  {
    super(paramContext, 2131820791);
    AppMethodBeat.i(52130);
    this.mContext = paramContext;
    this.mRE = paramoe;
    AppMethodBeat.o(52130);
  }
  
  public final com.tencent.mm.plugin.box.webview.e bBM()
  {
    return (com.tencent.mm.plugin.box.webview.e)this.vMS;
  }
  
  public final d bBN()
  {
    return (d)this.vMT;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(52125);
    BoxDialogView localBoxDialogView = this.vMV;
    if (localBoxDialogView != null)
    {
      localBoxDialogView.KM(5);
      AppMethodBeat.o(52125);
      return;
    }
    AppMethodBeat.o(52125);
  }
  
  public final void dismissDialog(int paramInt)
  {
    AppMethodBeat.i(52126);
    ad.d("MicroMsg.ScanBoxDialog", "alvinluo dismissDialog isShowing: %b, isAttachedToWindow: %b", new Object[] { Boolean.valueOf(isShowing()), Boolean.valueOf(this.vMW) });
    this.vMX = paramInt;
    if ((isShowing()) && (this.vMW)) {
      super.dismiss();
    }
    AppMethodBeat.o(52126);
  }
  
  public final Context getActivityContext()
  {
    AppMethodBeat.i(52129);
    Context localContext = getContext();
    k.g(localContext, "context");
    AppMethodBeat.o(52129);
    return localContext;
  }
  
  public final BoxWebView getBoxWebView()
  {
    return this.mRH;
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(52127);
    super.onAttachedToWindow();
    ad.v("MicroMsg.ScanBoxDialog", "alvinluo onAttachedToWindow %b", new Object[] { Boolean.valueOf(this.vMW) });
    this.vMW = true;
    AppMethodBeat.o(52127);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(161054);
    if (isShowing())
    {
      BoxDialogView localBoxDialogView = this.vMV;
      if (localBoxDialogView != null)
      {
        if (!localBoxDialogView.isAnimating) {
          localBoxDialogView.KM(5);
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
    ad.i("MicroMsg.ScanBoxDialog", "alvinluo onCreate");
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.addFlags(67109888);
    }
    gl();
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
      k.aPZ("mContext");
    }
    this.vMV = new BoxDialogView(paramBundle);
    paramBundle = this.vMV;
    Object localObject;
    if (paramBundle != null)
    {
      localObject = (c)this;
      k.h(localObject, "dialogModel");
      paramBundle.vMc = ((c)localObject);
    }
    paramBundle = this.vMV;
    if (paramBundle == null) {
      k.fvU();
    }
    setContentView((View)paramBundle, new ViewGroup.LayoutParams(-1, -1));
    paramBundle = this.mRE;
    if (paramBundle == null) {
      k.aPZ("homeContext");
    }
    ad.i("MicroMsg.ScanBoxDialog", "alvinluo initWebView url: %s", new Object[] { paramBundle.Url });
    paramBundle = this.vMV;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getBoxWebView();; paramBundle = null)
    {
      this.mRH = paramBundle;
      this.vMS = new h((com.tencent.mm.plugin.box.c.c)this);
      this.vMT = new i((com.tencent.mm.plugin.box.c.c)this);
      paramBundle = new a();
      localObject = this.mRE;
      if (localObject == null) {
        k.aPZ("homeContext");
      }
      localObject = new com.tencent.mm.plugin.box.webview.c((oe)localObject, (com.tencent.mm.plugin.box.webview.e)this.vMS);
      BoxWebView localBoxWebView = this.mRH;
      if (localBoxWebView != null) {
        localBoxWebView.a(paramBundle, (com.tencent.mm.plugin.box.webview.c)localObject);
      }
      paramBundle = this.mRH;
      if (paramBundle != null) {
        paramBundle.addJavascriptInterface(this.vMT, "boxJSApi");
      }
      paramBundle = this.mRH;
      if (paramBundle != null)
      {
        localObject = this.mRE;
        if (localObject == null) {
          k.aPZ("homeContext");
        }
        paramBundle.loadUrl(((oe)localObject).Url);
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
    ad.v("MicroMsg.ScanBoxDialog", "alvinluo onDetachedFromWindow %b", new Object[] { Boolean.valueOf(this.vMW) });
    this.vMW = false;
    AppMethodBeat.o(52128);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onShow"})
  static final class b
    implements DialogInterface.OnShowListener
  {
    b(e parame) {}
    
    public final void onShow(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(52121);
      paramDialogInterface = e.a(this.vMZ);
      if (paramDialogInterface != null)
      {
        paramDialogInterface.sXO = false;
        paramDialogInterface.isAnimating = true;
        paramDialogInterface.vME = 0;
        Object localObject = paramDialogInterface.vMe;
        if (localObject == null) {
          k.aPZ("dialogContainer");
        }
        ((View)localObject).setTranslationY(paramDialogInterface.getMaxTranslationY());
        localObject = paramDialogInterface.vMe;
        if (localObject == null) {
          k.aPZ("dialogContainer");
        }
        localObject = ((View)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).translationY(paramDialogInterface.vMm);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setInterpolator((TimeInterpolator)paramDialogInterface.vMD);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new BoxDialogView.l(paramDialogInterface));
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new BoxDialogView.m(paramDialogInterface));
                if (localObject != null)
                {
                  localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
                  if (localObject != null) {
                    ((ViewPropertyAnimator)localObject).start();
                  }
                }
              }
            }
          }
        }
        localObject = paramDialogInterface.qT;
        ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
        ((ValueAnimator)localObject).setDuration(300L);
        ((ValueAnimator)localObject).setFloatValues(new float[] { paramDialogInterface.vMB.vMG, paramDialogInterface.vMB.vMH });
        ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new BoxDialogView.e(paramDialogInterface));
        ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new BoxDialogView.f(paramDialogInterface));
        ((ValueAnimator)localObject).setStartDelay(50L);
        ((ValueAnimator)localObject).start();
      }
      paramDialogInterface = e.b(this.vMZ);
      if (paramDialogInterface != null)
      {
        paramDialogInterface.dla();
        AppMethodBeat.o(52121);
        return;
      }
      AppMethodBeat.o(52121);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class c
    implements DialogInterface.OnDismissListener
  {
    c(e parame) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(52122);
      ad.i("MicroMsg.ScanBoxDialog", "dismiss dialog");
      paramDialogInterface = e.c(this.vMZ);
      if (paramDialogInterface != null)
      {
        if (paramDialogInterface.vNc != null) {
          com.tencent.mm.kernel.g.aeS().a((n)paramDialogInterface.vNc);
        }
        com.tencent.mm.kernel.g.aeS().b(1532, (com.tencent.mm.al.g)paramDialogInterface);
      }
      paramDialogInterface = e.d(this.vMZ);
      if (paramDialogInterface != null) {
        paramDialogInterface.destroy();
      }
      e.e(this.vMZ);
      paramDialogInterface = e.b(this.vMZ);
      if (paramDialogInterface != null)
      {
        paramDialogInterface.KL(e.f(this.vMZ));
        AppMethodBeat.o(52122);
        return;
      }
      AppMethodBeat.o(52122);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class d
    implements DialogInterface.OnCancelListener
  {
    d(e parame) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(52123);
      paramDialogInterface = e.b(this.vMZ);
      if (paramDialogInterface != null)
      {
        paramDialogInterface.dlb();
        AppMethodBeat.o(52123);
        return;
      }
      AppMethodBeat.o(52123);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.e
 * JD-Core Version:    0.7.0.1
 */