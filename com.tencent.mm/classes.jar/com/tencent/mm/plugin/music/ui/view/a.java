package com.tencent.mm.plugin.music.ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/ui/view/MusicHalfDialog;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mContext", "Landroid/content/Context;", "notDestroy", "", "(Landroid/content/Context;Z)V", "curLandscape", "curRotation", "", "hideNavigationFullScreen", "isLandscape", "()Z", "isShowing", "lightStatusBar", "mAnchorView", "Landroid/view/View;", "mBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "mBottomSheetDialog", "Landroid/app/Dialog;", "mTreeObserver", "Landroid/view/ViewTreeObserver;", "newLandscapeStyle", "onDismissListener", "Lcom/tencent/mm/plugin/music/ui/view/MusicHalfDialog$OnDismissListener;", "rootView", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "rotation", "getRotation", "()I", "initView", "", "context", "onGlobalLayout", "setBottomSheetParams", "setCustomView", "resId", "setLightStatusBar", "setOnDismissListener", "listener", "setStatusBarTransparent", "tryHide", "tryShow", "Companion", "OnDismissListener", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static final a.a LQn;
  public boolean GwR;
  private final boolean GwS;
  private a.b LQo;
  public final Context mContext;
  public View mF;
  public ViewTreeObserver mP;
  public View rootView;
  private final boolean sRA;
  public Dialog sRs;
  public BottomSheetBehavior<?> sRv;
  public boolean sRw;
  public int sRx;
  public final boolean sRz;
  
  static
  {
    AppMethodBeat.i(270997);
    LQn = new a.a((byte)0);
    AppMethodBeat.o(270997);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(270984);
    this.mContext = paramContext;
    this.GwS = true;
    if ((this.mContext instanceof Activity)) {
      this.mF = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(a.e.content);
    }
    Object localObject = this.mContext;
    if (this.sRA) {
      s.checkNotNull(localObject);
    }
    for (paramContext = (Dialog)new b((Context)localObject);; paramContext = (Dialog)new com.google.android.material.bottomsheet.a((Context)localObject, a.i.BottomSheetDialog))
    {
      this.sRs = paramContext;
      this.rootView = View.inflate((Context)localObject, a.g.music_half_dialog_view, null);
      this.sRw = isLandscape();
      paramContext = this.rootView;
      if (paramContext == null) {
        break label248;
      }
      localObject = this.sRs;
      s.checkNotNull(localObject);
      ((Dialog)localObject).setContentView(paramContext);
      paramContext = paramContext.getParent();
      if (paramContext != null) {
        break;
      }
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(270984);
      throw paramContext;
      s.checkNotNull(localObject);
    }
    this.sRv = BottomSheetBehavior.cC((View)paramContext);
    paramContext = this.sRv;
    if (paramContext != null) {
      paramContext.setState(3);
    }
    paramContext = this.sRv;
    if (paramContext != null) {
      paramContext.dqJ = ((BottomSheetBehavior.a)new c());
    }
    paramContext = this.sRs;
    s.checkNotNull(paramContext);
    paramContext.setOnDismissListener(new a..ExternalSyntheticLambda0(this));
    label248:
    AppMethodBeat.o(270984);
  }
  
  private static final void a(a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(270990);
    s.u(parama, "this$0");
    if (parama.mP != null)
    {
      paramDialogInterface = parama.mP;
      s.checkNotNull(paramDialogInterface);
      if (!paramDialogInterface.isAlive())
      {
        paramDialogInterface = parama.mF;
        s.checkNotNull(paramDialogInterface);
        parama.mP = paramDialogInterface.getViewTreeObserver();
      }
      paramDialogInterface = parama.mP;
      s.checkNotNull(paramDialogInterface);
      paramDialogInterface.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)parama);
      parama.mP = null;
    }
    if (!parama.GwS) {
      parama.sRs = null;
    }
    if (parama.LQo != null) {
      s.checkNotNull(parama.LQo);
    }
    AppMethodBeat.o(270990);
  }
  
  public final void cyW()
  {
    AppMethodBeat.i(271019);
    if (this.sRs != null)
    {
      Object localObject;
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed())))
      {
        localObject = this.sRs;
        s.checkNotNull(localObject);
        ((Dialog)localObject).dismiss();
      }
      if (this.sRv != null)
      {
        localObject = this.sRv;
        s.checkNotNull(localObject);
        ((BottomSheetBehavior)localObject).dqC = true;
      }
    }
    AppMethodBeat.o(271019);
  }
  
  public final int getRotation()
  {
    AppMethodBeat.i(271012);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(271012);
    return i;
  }
  
  public final boolean isLandscape()
  {
    AppMethodBeat.i(271032);
    Context localContext = this.mContext;
    s.checkNotNull(localContext);
    if (localContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(271032);
      return true;
    }
    AppMethodBeat.o(271032);
    return false;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(271026);
    if (this.sRs != null)
    {
      Dialog localDialog = this.sRs;
      s.checkNotNull(localDialog);
      if (localDialog.isShowing())
      {
        AppMethodBeat.o(271026);
        return true;
      }
    }
    AppMethodBeat.o(271026);
    return false;
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(271007);
    if (isShowing())
    {
      View localView = this.mF;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        cyW();
        AppMethodBeat.o(271007);
        return;
      }
      if ((isShowing()) && ((this.sRw != isLandscape()) || (this.sRx != getRotation()))) {
        cyW();
      }
    }
    AppMethodBeat.o(271007);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/music/ui/view/MusicHalfDialog$initView$1$1", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends BottomSheetBehavior.a
  {
    public final void cD(View paramView)
    {
      AppMethodBeat.i(271018);
      s.u(paramView, "bottomSheet");
      AppMethodBeat.o(271018);
    }
    
    public final void e(View paramView, int paramInt)
    {
      AppMethodBeat.i(271013);
      s.u(paramView, "bottomSheet");
      AppMethodBeat.o(271013);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.a
 * JD-Core Version:    0.7.0.1
 */