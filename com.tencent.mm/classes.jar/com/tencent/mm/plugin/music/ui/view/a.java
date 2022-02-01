package com.tencent.mm.plugin.music.ui.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.a;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/ui/view/MusicHalfDialog;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mContext", "Landroid/content/Context;", "notDestroy", "", "(Landroid/content/Context;Z)V", "curLandscape", "curRotation", "", "hideNavigationFullScreen", "isLandscape", "()Z", "isShowing", "lightStatusBar", "mAnchorView", "Landroid/view/View;", "mBehavior", "Landroid/support/design/widget/BottomSheetBehavior;", "mBottomSheetDialog", "Landroid/app/Dialog;", "mTreeObserver", "Landroid/view/ViewTreeObserver;", "newLandscapeStyle", "onDismissListener", "Lcom/tencent/mm/plugin/music/ui/view/MusicHalfDialog$OnDismissListener;", "rootView", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "rotation", "getRotation", "()I", "initView", "", "context", "onGlobalLayout", "setBottomSheetParams", "setCustomView", "resId", "setLightStatusBar", "setOnDismissListener", "listener", "setStatusBarTransparent", "tryHide", "tryShow", "Companion", "OnDismissListener", "plugin-music_release"})
public final class a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static final a.a Aoi;
  private b Aoh;
  private ViewTreeObserver afI;
  public View lJI;
  private final Context mContext;
  private Dialog mLH;
  private BottomSheetBehavior<?> mLK;
  private boolean mLL;
  private int mLM;
  private final boolean mLO;
  private final boolean mLP;
  private View qK;
  private boolean wjM;
  private final boolean wjN;
  
  static
  {
    AppMethodBeat.i(220034);
    Aoi = new a.a((byte)0);
    AppMethodBeat.o(220034);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(220033);
    this.mContext = paramContext;
    this.wjN = true;
    if ((this.mContext instanceof Activity))
    {
      paramContext = ((Activity)this.mContext).getWindow();
      p.g(paramContext, "mContext.window");
      paramContext = paramContext.getDecorView();
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(220033);
        throw paramContext;
      }
      this.qK = ((ViewGroup)paramContext).findViewById(2131299180);
    }
    Object localObject = this.mContext;
    if (this.mLP) {
      if (localObject == null) {
        p.hyc();
      }
    }
    for (paramContext = (Dialog)new b((Context)localObject);; paramContext = (Dialog)new android.support.design.widget.a((Context)localObject, 2131820791))
    {
      this.mLH = paramContext;
      this.lJI = View.inflate((Context)localObject, 2131495771, null);
      this.mLL = isLandscape();
      paramContext = this.lJI;
      if (paramContext == null) {
        break label297;
      }
      localObject = this.mLH;
      if (localObject == null) {
        p.hyc();
      }
      ((Dialog)localObject).setContentView(paramContext);
      paramContext = paramContext.getParent();
      if (paramContext != null) {
        break;
      }
      paramContext = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(220033);
      throw paramContext;
      if (localObject == null) {
        p.hyc();
      }
    }
    this.mLK = BottomSheetBehavior.l((View)paramContext);
    paramContext = this.mLK;
    if (paramContext != null) {
      paramContext.setState(3);
    }
    paramContext = this.mLK;
    if (paramContext != null) {
      paramContext.a((BottomSheetBehavior.a)new d());
    }
    paramContext = this.mLH;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.setOnDismissListener((DialogInterface.OnDismissListener)new c(this));
    AppMethodBeat.o(220033);
    return;
    label297:
    AppMethodBeat.o(220033);
  }
  
  @SuppressLint({"WrongConstant"})
  private final int getRotation()
  {
    AppMethodBeat.i(220028);
    int i = 0;
    if ((this.mContext instanceof Activity))
    {
      Object localObject = ((Activity)this.mContext).getWindow();
      p.g(localObject, "mContext.window");
      localObject = ((Window)localObject).getWindowManager();
      p.g(localObject, "mContext.window.windowManager");
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      p.g(localObject, "mContext.window.windowManager.defaultDisplay");
      i = ((Display)localObject).getRotation();
    }
    AppMethodBeat.o(220028);
    return i;
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(220032);
    Object localObject = this.mContext;
    if (localObject == null) {
      p.hyc();
    }
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "mContext!!.resources");
    if (((Resources)localObject).getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(220032);
      return true;
    }
    AppMethodBeat.o(220032);
    return false;
  }
  
  public final void bMo()
  {
    AppMethodBeat.i(220030);
    Object localObject;
    if (this.mLH != null)
    {
      if (!(this.mContext instanceof Activity)) {
        break label103;
      }
      if ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))
      {
        localObject = this.mLH;
        if (localObject == null) {
          p.hyc();
        }
        ((Dialog)localObject).dismiss();
      }
    }
    for (;;)
    {
      if (this.mLK != null)
      {
        localObject = this.mLK;
        if (localObject == null) {
          p.hyc();
        }
        ((BottomSheetBehavior)localObject).u(true);
      }
      AppMethodBeat.o(220030);
      return;
      label103:
      localObject = this.mLH;
      if (localObject == null) {
        p.hyc();
      }
      ((Dialog)localObject).dismiss();
    }
  }
  
  public final void dGm()
  {
    AppMethodBeat.i(220029);
    this.mLL = isLandscape();
    this.mLM = getRotation();
    Object localObject1;
    if (this.mLH != null)
    {
      localObject1 = this.lJI;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((View)localObject1).getParent();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(220029);
        throw ((Throwable)localObject1);
      }
      ((ViewGroup)localObject1).setVisibility(0);
      localObject1 = this.lJI;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(220029);
        throw ((Throwable)localObject1);
      }
      localObject1 = (FrameLayout.LayoutParams)localObject1;
      if ((this.mLL) && (this.qK != null))
      {
        localObject2 = new Rect();
        View localView = this.qK;
        if (localView == null) {
          p.hyc();
        }
        localView.getWindowVisibleDisplayFrame((Rect)localObject2);
        ((FrameLayout.LayoutParams)localObject1).width = ((Rect)localObject2).right;
      }
      Object localObject2 = this.lJI;
      if (localObject2 == null) {
        p.hyc();
      }
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject1 = this.mLH;
        if (localObject1 == null) {
          p.hyc();
        }
        localObject1 = ((Dialog)localObject1).getWindow();
        if (localObject1 == null) {
          p.hyc();
        }
        ((Window)localObject1).addFlags(-2147483648);
      }
      if ((this.wjM) && (Build.VERSION.SDK_INT >= 23) && (this.mLH != null))
      {
        localObject1 = this.mLH;
        if (localObject1 == null) {
          p.hyc();
        }
        localObject1 = ((Dialog)localObject1).getWindow();
        if (localObject1 == null) {
          p.hyc();
        }
        p.g(localObject1, "mBottomSheetDialog!!.window!!");
        localObject1 = ((Window)localObject1).getDecorView();
        p.g(localObject1, "mBottomSheetDialog!!.window!!.decorView");
        ((View)localObject1).setSystemUiVisibility(9216);
        localObject1 = this.mLH;
        if (localObject1 == null) {
          p.hyc();
        }
        localObject1 = ((Dialog)localObject1).getWindow();
        if (localObject1 == null) {
          p.hyc();
        }
        p.g(localObject1, "mBottomSheetDialog!!.window!!");
        ((Window)localObject1).setStatusBarColor(0);
      }
      if (!this.mLO) {
        break label587;
      }
      localObject1 = this.mLH;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((Dialog)localObject1).getWindow();
      if (localObject1 == null) {
        p.hyc();
      }
      ((Window)localObject1).setFlags(8, 8);
      localObject1 = this.mLH;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((Dialog)localObject1).getWindow();
      if (localObject1 == null) {
        p.hyc();
      }
      ((Window)localObject1).addFlags(131200);
      localObject1 = this.mLH;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((Dialog)localObject1).getWindow();
      if (localObject1 == null) {
        p.hyc();
      }
      p.g(localObject1, "mBottomSheetDialog!!.window!!");
      localObject1 = ((Window)localObject1).getDecorView();
      p.g(localObject1, "mBottomSheetDialog!!.window!!.decorView");
      ((View)localObject1).setSystemUiVisibility(6);
      if (this.qK != null) {
        if (this.afI != null) {
          break label730;
        }
      }
    }
    label587:
    label730:
    for (int i = 1;; i = 0)
    {
      localObject1 = this.qK;
      if (localObject1 == null) {
        p.hyc();
      }
      this.afI = ((View)localObject1).getViewTreeObserver();
      if (i != 0)
      {
        localObject1 = this.afI;
        if (localObject1 == null) {
          p.hyc();
        }
        ((ViewTreeObserver)localObject1).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing()))
      {
        localObject1 = this.mLH;
        if (localObject1 == null) {
          p.hyc();
        }
        ((Dialog)localObject1).show();
      }
      if (this.mLK != null)
      {
        localObject1 = this.mLK;
        if (localObject1 == null) {
          p.hyc();
        }
        ((BottomSheetBehavior)localObject1).u(false);
      }
      AppMethodBeat.o(220029);
      return;
      localObject1 = this.mLH;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((Dialog)localObject1).getWindow();
      if (localObject1 == null) {
        p.hyc();
      }
      ((Window)localObject1).clearFlags(8);
      localObject1 = this.mLH;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((Dialog)localObject1).getWindow();
      if (localObject1 == null) {
        p.hyc();
      }
      ((Window)localObject1).clearFlags(131072);
      localObject1 = this.mLH;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((Dialog)localObject1).getWindow();
      if (localObject1 == null) {
        p.hyc();
      }
      ((Window)localObject1).clearFlags(128);
      localObject1 = this.mLH;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((Dialog)localObject1).getWindow();
      if (localObject1 == null) {
        p.hyc();
      }
      p.g(localObject1, "mBottomSheetDialog!!.window!!");
      localObject1 = ((Window)localObject1).getDecorView();
      p.g(localObject1, "mBottomSheetDialog!!.window!!.decorView");
      ((View)localObject1).setSystemUiVisibility(0);
      break;
    }
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(220031);
    if (this.mLH != null)
    {
      Dialog localDialog = this.mLH;
      if (localDialog == null) {
        p.hyc();
      }
      if (localDialog.isShowing())
      {
        AppMethodBeat.o(220031);
        return true;
      }
    }
    AppMethodBeat.o(220031);
    return false;
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(220027);
    if (isShowing())
    {
      View localView = this.qK;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bMo();
        AppMethodBeat.o(220027);
        return;
      }
      if ((isShowing()) && ((this.mLL != isLandscape()) || (this.mLM != getRotation()))) {
        bMo();
      }
    }
    AppMethodBeat.o(220027);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/ui/view/MusicHalfDialog$OnDismissListener;", "", "onDismiss", "", "plugin-music_release"})
  public static abstract interface b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss", "com/tencent/mm/plugin/music/ui/view/MusicHalfDialog$initView$1$2"})
  static final class c
    implements DialogInterface.OnDismissListener
  {
    c(a parama) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(220024);
      if (a.a(this.Aoj) != null)
      {
        paramDialogInterface = a.a(this.Aoj);
        if (paramDialogInterface == null) {
          p.hyc();
        }
        if (!paramDialogInterface.isAlive())
        {
          paramDialogInterface = this.Aoj;
          View localView = a.b(this.Aoj);
          if (localView == null) {
            p.hyc();
          }
          a.a(paramDialogInterface, localView.getViewTreeObserver());
        }
        paramDialogInterface = a.a(this.Aoj);
        if (paramDialogInterface == null) {
          p.hyc();
        }
        paramDialogInterface.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this.Aoj);
        a.a(this.Aoj, null);
      }
      if (!a.c(this.Aoj)) {
        a.d(this.Aoj);
      }
      if ((a.e(this.Aoj) != null) && (a.e(this.Aoj) == null)) {
        p.hyc();
      }
      AppMethodBeat.o(220024);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/music/ui/view/MusicHalfDialog$initView$1$1", "Landroid/support/design/widget/BottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-music_release"})
  public static final class d
    extends BottomSheetBehavior.a
  {
    public final void f(View paramView, int paramInt)
    {
      AppMethodBeat.i(220025);
      p.h(paramView, "bottomSheet");
      AppMethodBeat.o(220025);
    }
    
    public final void m(View paramView)
    {
      AppMethodBeat.i(220026);
      p.h(paramView, "bottomSheet");
      AppMethodBeat.o(220026);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.a
 * JD-Core Version:    0.7.0.1
 */