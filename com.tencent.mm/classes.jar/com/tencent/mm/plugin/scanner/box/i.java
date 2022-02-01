package com.tencent.mm.plugin.scanner.box;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.scanner.l.j;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.d;
import com.tencent.mm.plugin.webview.core.l;
import com.tencent.mm.plugin.webview.jsapi.g;
import com.tencent.mm.plugin.webview.jsapi.t;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogModel;", "context", "Landroid/content/Context;", "theme", "", "homeContext", "Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;", "(Landroid/content/Context;ILcom/tencent/mm/protocal/protobuf/BoxHomeContext;)V", "dialogView", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;", "listener", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListener;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListener;)V", "boxDialogViewListener", "boxWebData", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebData;", "boxWebView", "Lcom/tencent/mm/plugin/box/webview/BoxWebView;", "boxWebViewJSApi", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi;", "enableCancelOutside", "", "enableDialogScroll", "enableFullScreen", "enableScrollRightClose", "enableWebViewScroll", "fixedDialogHeight", "fixedDialogHeightRate", "", "isAttachedToWindow", "isFixedDialogHeight", "mContext", "mDialogView", "mExitType", "pendingShow", "showAfterWebViewReady", "webViewCallback", "com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewCallback$1", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewCallback$1;", "webViewClientListener", "com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewClientListener$1", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewClientListener$1;", "webViewController", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "webViewControllerListener", "com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewControllerListener$1", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewControllerListener$1;", "webViewReady", "configFullScreen", "", "createWebView", "dismiss", "dismissDialog", "exitType", "getActivityContext", "getBoxWebData", "Lcom/tencent/mm/plugin/box/webview/IBoxWebData;", "getBoxWebView", "getBoxWebViewJsApi", "Lcom/tencent/mm/plugin/box/webview/BoxWebViewJSApi;", "getHomeContext", "init", "initContentView", "initFontSize", "initJsApi", "initWebView", "initWebViewController", "isShowingDialog", "onAttachedToWindow", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "onPause", "onResume", "realShow", "release", "setBackgroundOpView", "opView", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel;", "setBackgroundTouchListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundTouchListener;", "setBackgroundViewModel", "viewModel", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "setBoxDialogMoveListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "setBoxDialogViewListener", "setDimAmount", "amount", "setEnableCancelOutside", "enable", "setEnableDialogScroll", "enableScroll", "setEnableFullScreen", "setEnableScrollRightClose", "setEnableWebViewScroll", "setFixDialogHeight", "fixedHeight", "setFixDialogHeightRate", "rate", "setIsFixDialogHeight", "fixed", "setReportData", "data", "setShowAfterWebViewPageReady", "show", "showDialog", "startLoadUrl", "webviewUIReady", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends androidx.appcompat.app.e
  implements com.tencent.mm.plugin.box.c.b, e
{
  public static final a ONg;
  private boolean GXM;
  private boolean GXN;
  boolean GXO;
  private BaseWebViewController GXZ;
  boolean OMy;
  private e ONh;
  private d ONi;
  private c ONj;
  private p ONk;
  q ONl;
  private j ONm;
  public BaseBoxDialogView ONn;
  private int ONo;
  private boolean ONp;
  boolean ONq;
  boolean ONr;
  private boolean isAttachedToWindow;
  private Context mContext;
  boolean pvC;
  private boolean pvo;
  int pvp;
  float pvr;
  private rx vAe;
  private BoxWebView vAh;
  
  static
  {
    AppMethodBeat.i(52131);
    ONg = new a((byte)0);
    AppMethodBeat.o(52131);
  }
  
  public i(Context paramContext, rx paramrx, BaseBoxDialogView paramBaseBoxDialogView, j paramj)
  {
    super(paramContext, l.j.BoxDialog);
    AppMethodBeat.i(313790);
    this.ONh = new e(this);
    this.ONi = new d(this);
    this.ONj = new c(this);
    this.OMy = true;
    this.ONp = true;
    this.ONq = true;
    this.ONr = true;
    this.ONn = paramBaseBoxDialogView;
    this.ONm = paramj;
    paramBaseBoxDialogView = t.WEP;
    t.a((g)com.tencent.mm.plugin.webview.jsapi.q.WEK);
    this.mContext = paramContext;
    this.vAe = paramrx;
    this.ONl = new q((com.tencent.mm.plugin.box.c.b)this);
    paramContext = this.ONm;
    if (paramContext != null) {
      paramContext.fpP();
    }
    paramContext = this.mContext;
    if (paramContext == null)
    {
      kotlin.g.b.s.bIx("mContext");
      paramContext = null;
    }
    for (;;)
    {
      this.vAh = h.a(paramContext, (kotlin.g.a.q)new b(this));
      this.GXM = false;
      paramContext = (ab)com.tencent.mm.kernel.h.ax(ab.class);
      paramrx = this.vAh;
      kotlin.g.b.s.checkNotNull(paramrx);
      this.GXZ = paramContext.a((MMWebView)paramrx, new BaseWebViewController.d(null, true, false, false, true, false, 105), (g)com.tencent.mm.plugin.webview.jsapi.q.WEK);
      paramContext = this.GXZ;
      if (paramContext != null) {
        paramContext.a((l)this.ONh);
      }
      paramContext = this.GXZ;
      if (paramContext != null) {
        paramContext.a((com.tencent.mm.plugin.webview.core.h)this.ONi);
      }
      paramContext = this.GXZ;
      if (paramContext != null) {
        paramContext.init();
      }
      paramContext = this.ONm;
      if (paramContext != null) {
        paramContext.fpS();
      }
      Log.i("MicroMsg.ScanBoxDialog", "alvinluo initWebView");
      this.ONk = new p((com.tencent.mm.plugin.box.c.b)this);
      com.tencent.threadpool.h.ahAA.bo(new i..ExternalSyntheticLambda4(this));
      AppMethodBeat.o(313790);
      return;
    }
  }
  
  private static final void a(i parami)
  {
    Object localObject2 = null;
    AppMethodBeat.i(313821);
    kotlin.g.b.s.u(parami, "this$0");
    Object localObject3 = parami.vAe;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("homeContext");
      localObject1 = null;
    }
    Log.i("MicroMsg.ScanBoxDialog", "alvinluo startLoadUrl %s", new Object[] { ((rx)localObject1).Url });
    localObject1 = parami.GXZ;
    if (localObject1 != null)
    {
      localObject3 = new Intent();
      parami = parami.vAe;
      if (parami != null) {
        break label123;
      }
      kotlin.g.b.s.bIx("homeContext");
      parami = localObject2;
    }
    label123:
    for (;;)
    {
      ((Intent)localObject3).putExtra("rawUrl", parami.Url);
      ((Intent)localObject3).putExtra("useJs", true);
      parami = ah.aiuX;
      ((BaseWebViewController)localObject1).bJ((Intent)localObject3);
      AppMethodBeat.o(313821);
      return;
    }
  }
  
  private static final void a(i parami, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(313822);
    kotlin.g.b.s.u(parami, "this$0");
    BaseBoxDialogView localBaseBoxDialogView = parami.ONn;
    if (localBaseBoxDialogView != null) {
      localBaseBoxDialogView.show();
    }
    parami = parami.ONm;
    if (parami != null) {
      parami.onShow(paramDialogInterface);
    }
    AppMethodBeat.o(313822);
  }
  
  private static final void b(i parami)
  {
    AppMethodBeat.i(313838);
    kotlin.g.b.s.u(parami, "this$0");
    BoxWebView localBoxWebView = parami.vAh;
    if (localBoxWebView != null) {
      localBoxWebView.a(null, null);
    }
    parami.gPP();
    localBoxWebView = parami.vAh;
    if (localBoxWebView != null) {
      localBoxWebView.addJavascriptInterface(parami.ONl, "boxJSApi");
    }
    parami.gPO();
    parami = parami.ONm;
    if (parami != null) {
      parami.fpT();
    }
    AppMethodBeat.o(313838);
  }
  
  private static final void b(i parami, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(313831);
    kotlin.g.b.s.u(parami, "this$0");
    Log.i("MicroMsg.ScanBoxDialog", "dismiss dialog exitType: %s", new Object[] { Integer.valueOf(parami.ONo) });
    j localj = parami.ONm;
    if (localj != null) {
      localj.L(paramDialogInterface, parami.ONo);
    }
    paramDialogInterface = t.WEP;
    t.b((g)com.tencent.mm.plugin.webview.jsapi.q.WEK);
    paramDialogInterface = parami.ONk;
    if (paramDialogInterface != null)
    {
      if (paramDialogInterface.ONQ != null) {
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramDialogInterface.ONQ);
      }
      com.tencent.mm.kernel.h.aZW().b(1532, (com.tencent.mm.am.h)paramDialogInterface);
    }
    paramDialogInterface = parami.vAh;
    if (paramDialogInterface != null) {
      paramDialogInterface.destroy();
    }
    parami.vAh = null;
    if (parami.ONl != null) {
      q.release();
    }
    parami = parami.GXZ;
    if (parami != null) {
      parami.onDestroy();
    }
    AppMethodBeat.o(313831);
  }
  
  private static final void c(i parami)
  {
    AppMethodBeat.i(313845);
    kotlin.g.b.s.u(parami, "this$0");
    try
    {
      Object localObject = parami.vAh;
      if (localObject != null) {
        ((BoxWebView)localObject).a(null, null);
      }
      parami.gPP();
      localObject = parami.vAh;
      if (localObject != null) {
        ((BoxWebView)localObject).addJavascriptInterface(parami.ONl, "boxJSApi");
      }
      parami.gPO();
      localObject = parami.ONm;
      if (localObject != null)
      {
        ((j)localObject).fpT();
        AppMethodBeat.o(313845);
        return;
      }
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.ScanBoxDialog", localThrowable, "initWebView exception", new Object[0]);
      com.tencent.threadpool.h.ahAA.bk(new i..ExternalSyntheticLambda3(parami));
      AppMethodBeat.o(313845);
    }
  }
  
  private static final void c(i parami, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(313836);
    kotlin.g.b.s.u(parami, "this$0");
    parami = parami.ONm;
    if (parami != null) {
      parami.onCancel(paramDialogInterface);
    }
    AppMethodBeat.o(313836);
  }
  
  private final void fpN()
  {
    AppMethodBeat.i(313814);
    try
    {
      if (((getContext() instanceof Activity)) && (((Activity)getContext()).isFinishing()))
      {
        Log.w("MicroMsg.ScanBoxDialog", "realShowDialog ui is finishing and ignore");
        AppMethodBeat.o(313814);
        return;
      }
      super.show();
      AppMethodBeat.o(313814);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ScanBoxDialog", (Throwable)localException, "realShowDialog exception", new Object[0]);
      AppMethodBeat.o(313814);
    }
  }
  
  private final void gPO()
  {
    AppMethodBeat.i(313796);
    com.tencent.threadpool.h.ahAA.bk(new i..ExternalSyntheticLambda5(this));
    AppMethodBeat.o(313796);
  }
  
  private final void gPP()
  {
    BoxWebView localBoxWebView = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject1 = null;
    AppMethodBeat.i(313808);
    float f = getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", a.md(getContext()));
    if (f >= a.mj(getContext()))
    {
      localBoxWebView = this.vAh;
      if (localBoxWebView == null) {
        if (localObject1 != null) {
          ((ad)localObject1).setTextZoom(148);
        }
      }
    }
    label168:
    label214:
    label472:
    for (;;)
    {
      Log.i("MicroMsg.ScanBoxDialog", "initFontSize, fontSize = %f", new Object[] { Float.valueOf(f) });
      AppMethodBeat.o(313808);
      return;
      localObject1 = localBoxWebView.getSettings();
      break;
      if (f >= a.mi(getContext()))
      {
        localObject1 = this.vAh;
        if (localObject1 == null) {}
        for (localObject1 = localBoxWebView;; localObject1 = ((BoxWebView)localObject1).getSettings())
        {
          if (localObject1 == null) {
            break label168;
          }
          ((ad)localObject1).setTextZoom(140);
          break;
        }
      }
      else if (f >= a.mh(getContext()))
      {
        localObject1 = this.vAh;
        if (localObject1 == null) {}
        for (localObject1 = localObject2;; localObject1 = ((BoxWebView)localObject1).getSettings())
        {
          if (localObject1 == null) {
            break label214;
          }
          ((ad)localObject1).setTextZoom(132);
          break;
        }
      }
      else if (f >= a.mg(getContext()))
      {
        localObject1 = this.vAh;
        if (localObject1 == null) {}
        for (localObject1 = localObject3;; localObject1 = ((BoxWebView)localObject1).getSettings())
        {
          if (localObject1 == null) {
            break label259;
          }
          ((ad)localObject1).setTextZoom(124);
          break;
        }
      }
      else if (f >= a.mf(getContext()))
      {
        localObject1 = this.vAh;
        if (localObject1 == null) {}
        for (localObject1 = localObject4;; localObject1 = ((BoxWebView)localObject1).getSettings())
        {
          if (localObject1 == null) {
            break label304;
          }
          ((ad)localObject1).setTextZoom(116);
          break;
        }
      }
      else if (f >= a.me(getContext()))
      {
        localObject1 = this.vAh;
        if (localObject1 == null) {}
        for (localObject1 = localObject5;; localObject1 = ((BoxWebView)localObject1).getSettings())
        {
          if (localObject1 == null) {
            break label349;
          }
          ((ad)localObject1).setTextZoom(108);
          break;
        }
      }
      else
      {
        label349:
        if (f >= a.md(getContext()))
        {
          localObject1 = this.vAh;
          if (localObject1 == null) {}
          for (localObject1 = localObject6;; localObject1 = ((BoxWebView)localObject1).getSettings())
          {
            if (localObject1 == null) {
              break label394;
            }
            ((ad)localObject1).setTextZoom(100);
            break;
          }
        }
        else if (f >= a.mc(getContext()))
        {
          localObject1 = this.vAh;
          if (localObject1 == null) {}
          for (localObject1 = localObject7;; localObject1 = ((BoxWebView)localObject1).getSettings())
          {
            if (localObject1 == null) {
              break label439;
            }
            ((ad)localObject1).setTextZoom(92);
            break;
          }
        }
        else
        {
          localObject1 = this.vAh;
          if (localObject1 == null) {}
          for (localObject1 = localObject8;; localObject1 = ((BoxWebView)localObject1).getSettings())
          {
            if (localObject1 == null) {
              break label472;
            }
            ((ad)localObject1).setTextZoom(80);
            break;
          }
        }
      }
    }
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(313984);
    kotlin.g.b.s.u(paramf, "listener");
    BaseBoxDialogView localBaseBoxDialogView = this.ONn;
    if (localBaseBoxDialogView != null) {
      localBaseBoxDialogView.setBackgroundListener(paramf);
    }
    AppMethodBeat.o(313984);
  }
  
  public final BoxWebView dbl()
  {
    return this.vAh;
  }
  
  public final com.tencent.mm.plugin.box.webview.e dbm()
  {
    return (com.tencent.mm.plugin.box.webview.e)this.ONk;
  }
  
  public final com.tencent.mm.plugin.box.webview.d dbn()
  {
    return (com.tencent.mm.plugin.box.webview.d)this.ONl;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(52125);
    Log.i("MicroMsg.ScanBoxDialog", "alvinluo dismissDialog isShowing: %s", new Object[] { Boolean.valueOf(isShowing()) });
    this.GXN = false;
    if (isShowing())
    {
      BaseBoxDialogView localBaseBoxDialogView = this.ONn;
      if (localBaseBoxDialogView != null) {
        localBaseBoxDialogView.onBackPressed();
      }
    }
    AppMethodBeat.o(52125);
  }
  
  public final boolean gPQ()
  {
    AppMethodBeat.i(313961);
    if ((isShowing()) || (this.GXN))
    {
      AppMethodBeat.o(313961);
      return true;
    }
    AppMethodBeat.o(313961);
    return false;
  }
  
  public final void gPR()
  {
    AppMethodBeat.i(314000);
    this.pvo = true;
    BaseBoxDialogView localBaseBoxDialogView = this.ONn;
    if (localBaseBoxDialogView != null) {
      localBaseBoxDialogView.setIsFixDialogHeight(true);
    }
    AppMethodBeat.o(314000);
  }
  
  public final Context getActivityContext()
  {
    AppMethodBeat.i(52129);
    Context localContext = this.mContext;
    if (localContext == null)
    {
      kotlin.g.b.s.bIx("mContext");
      AppMethodBeat.o(52129);
      return null;
    }
    AppMethodBeat.o(52129);
    return localContext;
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
    int i = 1;
    AppMethodBeat.i(161054);
    if (isShowing())
    {
      BaseBoxDialogView localBaseBoxDialogView = this.ONn;
      if ((localBaseBoxDialogView != null) && (localBaseBoxDialogView.onBackPressed() == true)) {}
      while (i == 0)
      {
        super.onBackPressed();
        AppMethodBeat.o(161054);
        return;
        i = 0;
      }
    }
    super.onBackPressed();
    AppMethodBeat.o(161054);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(52124);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.ScanBoxDialog", "alvinluo onCreate");
    View localView;
    if (this.OMy)
    {
      paramBundle = getWindow();
      if (paramBundle != null) {
        paramBundle.addFlags(100729856);
      }
      bU();
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
        localView = paramBundle.getDecorView();
        if (localView != null)
        {
          paramBundle = localView.getContext();
          if (paramBundle != null) {
            break label453;
          }
          paramBundle = (Bundle)localObject1;
          label127:
          if (paramBundle != null) {
            break label492;
          }
        }
      }
    }
    label453:
    label492:
    for (int i = a.ms(localView.getContext());; i = paramBundle.intValue())
    {
      localView.setMinimumWidth(i);
      localView.setPadding(0, 0, 0, 0);
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
      paramBundle = this.ONn;
      if (paramBundle != null)
      {
        localObject1 = this.vAh;
        kotlin.g.b.s.checkNotNull(localObject1);
        paramBundle.e((MMWebView)localObject1);
      }
      paramBundle = this.ONn;
      if (paramBundle != null)
      {
        localObject1 = (e)this;
        kotlin.g.b.s.u(localObject1, "dialogModel");
        paramBundle.OMS = ((e)localObject1);
      }
      paramBundle = this.ONn;
      if (paramBundle != null) {
        paramBundle.setIsFixDialogHeight(this.pvo);
      }
      paramBundle = this.ONn;
      if (paramBundle != null) {
        paramBundle.setFixDialogHeight(this.pvp);
      }
      paramBundle = this.ONn;
      if (paramBundle != null) {
        paramBundle.setFixDialogHeightRate(this.pvr);
      }
      paramBundle = this.ONn;
      if (paramBundle != null) {
        paramBundle.setEnableDialogScroll(this.ONq);
      }
      paramBundle = this.ONn;
      if (paramBundle != null) {
        paramBundle.setEnableWebViewScroll(this.ONp);
      }
      paramBundle = this.ONn;
      if (paramBundle != null) {
        paramBundle.setCanceledOnTouchOutside(this.ONr);
      }
      paramBundle = this.ONn;
      if (paramBundle != null) {
        paramBundle.setEnableScrollRightClose(this.pvC);
      }
      paramBundle = this.ONn;
      kotlin.g.b.s.checkNotNull(paramBundle);
      setContentView((View)paramBundle, new ViewGroup.LayoutParams(-1, -1));
      setOnShowListener(new i..ExternalSyntheticLambda2(this));
      setOnDismissListener(new i..ExternalSyntheticLambda1(this));
      setOnCancelListener(new i..ExternalSyntheticLambda0(this));
      setCancelable(true);
      AppMethodBeat.o(52124);
      return;
      paramBundle = getWindow();
      if (paramBundle == null) {
        break;
      }
      paramBundle.addFlags(67108864);
      break;
      Object localObject2 = paramBundle.getResources();
      paramBundle = (Bundle)localObject1;
      if (localObject2 == null) {
        break label127;
      }
      localObject2 = ((Resources)localObject2).getDisplayMetrics();
      paramBundle = (Bundle)localObject1;
      if (localObject2 == null) {
        break label127;
      }
      paramBundle = Integer.valueOf(((DisplayMetrics)localObject2).widthPixels);
      break label127;
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
  
  public final void setBackgroundViewModel(d paramd)
  {
    AppMethodBeat.i(313994);
    kotlin.g.b.s.u(paramd, "viewModel");
    BaseBoxDialogView localBaseBoxDialogView = this.ONn;
    if (localBaseBoxDialogView != null) {
      localBaseBoxDialogView.setBackgroundViewModel(paramd);
    }
    AppMethodBeat.o(313994);
  }
  
  public final void show()
  {
    AppMethodBeat.i(313949);
    Log.i("MicroMsg.ScanBoxDialog", "alvinluo showDialog showAfterWebViewReady: %b, webViewReady: %b", new Object[] { Boolean.valueOf(this.GXO), Boolean.valueOf(this.GXM) });
    if (this.GXO)
    {
      if (!this.GXM)
      {
        this.GXN = true;
        AppMethodBeat.o(313949);
        return;
      }
      fpN();
      AppMethodBeat.o(313949);
      return;
    }
    fpN();
    AppMethodBeat.o(313949);
  }
  
  public final void xM(int paramInt)
  {
    AppMethodBeat.i(52126);
    Log.d("MicroMsg.ScanBoxDialog", "alvinluo dismissDialog isShowing: %b, isAttachedToWindow: %b, exitType: %s", new Object[] { Boolean.valueOf(isShowing()), Boolean.valueOf(this.isAttachedToWindow), Integer.valueOf(paramInt) });
    this.ONo = paramInt;
    this.GXN = false;
    if ((isShowing()) && (this.isAttachedToWindow)) {
      super.dismiss();
    }
    AppMethodBeat.o(52126);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog$Companion;", "", "()V", "TAG", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "enablePreloadWebView", "", "enablePreloadFromFindTab", "useCache"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.q<Boolean, Boolean, Boolean, ah>
  {
    b(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewCallback$1", "Lcom/tencent/mm/plugin/webview/stub/DefaultWebViewStubCallback;", "getCommitUrl", "", "getCurrentUrl", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends com.tencent.mm.plugin.webview.stub.b
  {
    c(i parami) {}
    
    public final String cxY()
    {
      AppMethodBeat.i(313703);
      Log.v("MicroMsg.ScanBoxDialog", "alvinluo getCommitUrl");
      try
      {
        Object localObject = i.e(this.ONs);
        if (localObject == null)
        {
          AppMethodBeat.o(313703);
          return "";
        }
        localObject = ((BaseWebViewController)localObject).Wwz;
        if (localObject == null)
        {
          AppMethodBeat.o(313703);
          return "";
        }
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.ScanBoxDialog", localThrowable, "getCommitUrl exception", new Object[0]);
        AppMethodBeat.o(313703);
        return "";
      }
      AppMethodBeat.o(313703);
      return localThrowable;
    }
    
    public final String getCurrentUrl()
    {
      AppMethodBeat.i(313715);
      Log.v("MicroMsg.ScanBoxDialog", "alvinluo getCurrentUrl");
      try
      {
        Object localObject = i.e(this.ONs);
        if (localObject == null)
        {
          AppMethodBeat.o(313715);
          return "";
        }
        localObject = ((BaseWebViewController)localObject).getCurrentUrl();
        if (localObject == null)
        {
          AppMethodBeat.o(313715);
          return "";
        }
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.ScanBoxDialog", localThrowable, "getCommitUrl exception", new Object[0]);
        AppMethodBeat.o(313715);
        return "";
      }
      AppMethodBeat.o(313715);
      return localThrowable;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewClientListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "onPageCommitVisible", "", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "onPageStarted", "webViewReady", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends com.tencent.mm.plugin.webview.core.h
  {
    d(i parami) {}
    
    private final void fqd()
    {
      AppMethodBeat.i(313705);
      if (i.g(this.ONs))
      {
        AppMethodBeat.o(313705);
        return;
      }
      i.h(this.ONs);
      Log.i("MicroMsg.ScanBoxDialog", "alvinluo webViewReady showAfterWebViewReady: %b, pendingShow: %b", new Object[] { Boolean.valueOf(i.i(this.ONs)), Boolean.valueOf(i.j(this.ONs)) });
      if ((i.i(this.ONs)) && (i.j(this.ONs)))
      {
        i.k(this.ONs);
        this.ONs.show();
      }
      AppMethodBeat.o(313705);
    }
    
    public final void e(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(313713);
      super.e(paramWebView, paramString);
      fqd();
      AppMethodBeat.o(313713);
    }
    
    public final void h(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(313722);
      super.h(paramWebView, paramString);
      fqd();
      AppMethodBeat.o(313722);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewControllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onBinded", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends l
  {
    e(i parami) {}
    
    public final void cxX()
    {
      AppMethodBeat.i(313691);
      try
      {
        Object localObject = i.e(this.ONs);
        if (localObject != null)
        {
          localObject = ((BaseWebViewController)localObject).irJ();
          if (localObject != null)
          {
            com.tencent.mm.plugin.webview.stub.f localf = (com.tencent.mm.plugin.webview.stub.f)i.f(this.ONs);
            BaseWebViewController localBaseWebViewController = i.e(this.ONs);
            if (localBaseWebViewController == null) {}
            for (int i = 0;; i = localBaseWebViewController.irL())
            {
              ((com.tencent.mm.plugin.webview.stub.e)localObject).a(localf, i);
              AppMethodBeat.o(313691);
              return;
            }
          }
        }
        return;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.ScanBoxDialog", localThrowable, "alvinluo initWebViewController exception", new Object[0]);
        AppMethodBeat.o(313691);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.i
 * JD-Core Version:    0.7.0.1
 */