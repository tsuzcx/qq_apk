package com.tencent.mm.plugin.music.ui.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.music.a.g;
import com.tencent.mm.plugin.music.a.i;
import com.tencent.mm.ui.widget.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/ui/view/MusicHalfDialog;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mContext", "Landroid/content/Context;", "notDestroy", "", "(Landroid/content/Context;Z)V", "curLandscape", "curRotation", "", "hideNavigationFullScreen", "isLandscape", "()Z", "isShowing", "lightStatusBar", "mAnchorView", "Landroid/view/View;", "mBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "mBottomSheetDialog", "Landroid/app/Dialog;", "mTreeObserver", "Landroid/view/ViewTreeObserver;", "newLandscapeStyle", "onDismissListener", "Lcom/tencent/mm/plugin/music/ui/view/MusicHalfDialog$OnDismissListener;", "rootView", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "rotation", "getRotation", "()I", "initView", "", "context", "onGlobalLayout", "setBottomSheetParams", "setCustomView", "resId", "setLightStatusBar", "setOnDismissListener", "listener", "setStatusBarTransparent", "tryHide", "tryShow", "Companion", "OnDismissListener", "plugin-music_release"})
public final class a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static final a.a FVo;
  public boolean AUA;
  private final boolean AUB;
  private b FVn;
  public View lJ;
  public ViewTreeObserver lS;
  public final Context mContext;
  public View oFW;
  public BottomSheetBehavior<?> pMC;
  public boolean pMD;
  public int pME;
  public final boolean pMG;
  private final boolean pMH;
  public Dialog pMz;
  
  static
  {
    AppMethodBeat.i(259819);
    FVo = new a.a((byte)0);
    AppMethodBeat.o(259819);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(259818);
    this.mContext = paramContext;
    this.AUB = true;
    if ((this.mContext instanceof Activity))
    {
      paramContext = ((Activity)this.mContext).getWindow();
      p.j(paramContext, "mContext.window");
      paramContext = paramContext.getDecorView();
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(259818);
        throw paramContext;
      }
      this.lJ = ((ViewGroup)paramContext).findViewById(a.e.content);
    }
    Object localObject = this.mContext;
    if (this.pMH) {
      if (localObject == null) {
        p.iCn();
      }
    }
    for (paramContext = (Dialog)new b((Context)localObject);; paramContext = (Dialog)new com.google.android.material.bottomsheet.a((Context)localObject, a.i.BottomSheetDialog))
    {
      this.pMz = paramContext;
      this.oFW = View.inflate((Context)localObject, a.g.music_half_dialog_view, null);
      this.pMD = isLandscape();
      paramContext = this.oFW;
      if (paramContext == null) {
        break label300;
      }
      localObject = this.pMz;
      if (localObject == null) {
        p.iCn();
      }
      ((Dialog)localObject).setContentView(paramContext);
      paramContext = paramContext.getParent();
      if (paramContext != null) {
        break;
      }
      paramContext = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(259818);
      throw paramContext;
      if (localObject == null) {
        p.iCn();
      }
    }
    this.pMC = BottomSheetBehavior.cg((View)paramContext);
    paramContext = this.pMC;
    if (paramContext != null) {
      paramContext.setState(3);
    }
    paramContext = this.pMC;
    if (paramContext != null) {
      paramContext.a((BottomSheetBehavior.a)new a.d());
    }
    paramContext = this.pMz;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.setOnDismissListener((DialogInterface.OnDismissListener)new c(this));
    AppMethodBeat.o(259818);
    return;
    label300:
    AppMethodBeat.o(259818);
  }
  
  public final void bYF()
  {
    AppMethodBeat.i(259814);
    Object localObject;
    if (this.pMz != null)
    {
      if (!(this.mContext instanceof Activity)) {
        break label101;
      }
      if ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))
      {
        localObject = this.pMz;
        if (localObject == null) {
          p.iCn();
        }
        ((Dialog)localObject).dismiss();
      }
    }
    for (;;)
    {
      if (this.pMC != null)
      {
        localObject = this.pMC;
        if (localObject == null) {
          p.iCn();
        }
        ((BottomSheetBehavior)localObject).bd(true);
      }
      AppMethodBeat.o(259814);
      return;
      label101:
      localObject = this.pMz;
      if (localObject == null) {
        p.iCn();
      }
      ((Dialog)localObject).dismiss();
    }
  }
  
  @SuppressLint({"WrongConstant"})
  public final int getRotation()
  {
    AppMethodBeat.i(259812);
    int i = 0;
    if ((this.mContext instanceof Activity))
    {
      Object localObject = ((Activity)this.mContext).getWindow();
      p.j(localObject, "mContext.window");
      localObject = ((Window)localObject).getWindowManager();
      p.j(localObject, "mContext.window.windowManager");
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      p.j(localObject, "mContext.window.windowManager.defaultDisplay");
      i = ((Display)localObject).getRotation();
    }
    AppMethodBeat.o(259812);
    return i;
  }
  
  public final boolean isLandscape()
  {
    AppMethodBeat.i(259816);
    Object localObject = this.mContext;
    if (localObject == null) {
      p.iCn();
    }
    localObject = ((Context)localObject).getResources();
    p.j(localObject, "mContext!!.resources");
    if (((Resources)localObject).getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(259816);
      return true;
    }
    AppMethodBeat.o(259816);
    return false;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(259815);
    if (this.pMz != null)
    {
      Dialog localDialog = this.pMz;
      if (localDialog == null) {
        p.iCn();
      }
      if (localDialog.isShowing())
      {
        AppMethodBeat.o(259815);
        return true;
      }
    }
    AppMethodBeat.o(259815);
    return false;
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(259809);
    if (isShowing())
    {
      View localView = this.lJ;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bYF();
        AppMethodBeat.o(259809);
        return;
      }
      if ((isShowing()) && ((this.pMD != isLandscape()) || (this.pME != getRotation()))) {
        bYF();
      }
    }
    AppMethodBeat.o(259809);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/ui/view/MusicHalfDialog$OnDismissListener;", "", "onDismiss", "", "plugin-music_release"})
  public static abstract interface b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss", "com/tencent/mm/plugin/music/ui/view/MusicHalfDialog$initView$1$2"})
  static final class c
    implements DialogInterface.OnDismissListener
  {
    c(a parama) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(259911);
      if (a.a(this.FVp) != null)
      {
        paramDialogInterface = a.a(this.FVp);
        if (paramDialogInterface == null) {
          p.iCn();
        }
        if (!paramDialogInterface.isAlive())
        {
          paramDialogInterface = this.FVp;
          View localView = a.b(this.FVp);
          if (localView == null) {
            p.iCn();
          }
          a.a(paramDialogInterface, localView.getViewTreeObserver());
        }
        paramDialogInterface = a.a(this.FVp);
        if (paramDialogInterface == null) {
          p.iCn();
        }
        paramDialogInterface.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this.FVp);
        a.a(this.FVp, null);
      }
      if (!a.c(this.FVp)) {
        a.d(this.FVp);
      }
      if ((a.e(this.FVp) != null) && (a.e(this.FVp) == null)) {
        p.iCn();
      }
      AppMethodBeat.o(259911);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.a
 * JD-Core Version:    0.7.0.1
 */