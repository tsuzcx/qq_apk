package com.tencent.mm.ui.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import androidx.appcompat.app.e;
import androidx.lifecycle.h;
import androidx.lifecycle.h.b;
import androidx.lifecycle.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.l;
import com.tencent.mm.ui.ar;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/dialog/HalfScreenDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroidx/lifecycle/LifecycleOwner;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "childContentView", "Landroid/view/View;", "getChildContentView", "()Landroid/view/View;", "setChildContentView", "(Landroid/view/View;)V", "dialogView", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "emptyView", "lifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycle$delegate", "Lkotlin/Lazy;", "getEmptyViewHeight", "", "Landroidx/lifecycle/Lifecycle;", "inflateContentView", "initContentView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "setOnDismissListener", "listener", "show", "Companion", "libmmui_release"})
public abstract class a
  extends e
  implements androidx.lifecycle.l
{
  public static final a.a XGA = new a.a((byte)0);
  static a XGz;
  private static boolean cpt;
  private View XGx;
  private final f XGy = g.ar((kotlin.g.a.a)new d(this));
  DialogInterface.OnDismissListener fVb;
  private View mrQ;
  private View sxR;
  
  public a(Context paramContext)
  {
    super(paramContext, a.l.HalfScreenDialog);
    jg().b(h.b.ZP);
  }
  
  public static final void dismissDialog()
  {
    cpt = ar.isDarkMode();
    a locala = XGz;
    if (locala != null) {
      locala.dismiss();
    }
    XGz = null;
  }
  
  public static final boolean hWR()
  {
    a locala;
    if (cpt != ar.isDarkMode())
    {
      locala = XGz;
      if (locala != null) {
        locala.dismiss();
      }
      XGz = null;
    }
    do
    {
      return false;
      locala = XGz;
    } while (locala == null);
    if (locala.isShowing()) {
      return true;
    }
    XGz = null;
    return false;
  }
  
  public abstract View bAI();
  
  public h getLifecycle()
  {
    return (h)jg();
  }
  
  public final View hWQ()
  {
    return this.XGx;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void initContentView()
  {
    Object localObject = getWindow();
    if (localObject != null) {
      ((Window)localObject).setLayout(-1, -1);
    }
    localObject = getWindow();
    if (localObject != null) {
      ((Window)localObject).addFlags(67108864);
    }
    localObject = getWindow();
    if (localObject != null) {
      ((Window)localObject).setDimAmount(0.5F);
    }
    localObject = getWindow();
    if (localObject != null) {
      ((Window)localObject).setWindowAnimations(a.l.BottomToTopSlowAnimation);
    }
    localObject = LayoutInflater.from(getContext()).inflate(a.h.half_screen_dialog, null, false);
    setContentView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
    this.mrQ = ((View)localObject);
    localObject = this.mrQ;
    if (localObject != null) {}
    for (localObject = ((View)localObject).findViewById(a.g.empty_area_view);; localObject = null)
    {
      this.sxR = ((View)localObject);
      localObject = this.sxR;
      if (localObject != null)
      {
        localObject = ((View)localObject).getLayoutParams();
        if (localObject != null)
        {
          ((ViewGroup.LayoutParams)localObject).height = com.tencent.mm.ci.a.fromDPToPix(getContext(), 130);
          localView = this.sxR;
          if (localView != null) {
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
      }
      localObject = this.sxR;
      if (localObject != null) {
        ((View)localObject).setOnTouchListener((View.OnTouchListener)new b(this));
      }
      this.XGx = bAI();
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(3, a.g.empty_area_view);
      View localView = this.mrQ;
      localObject = localView;
      if (!(localView instanceof ViewGroup)) {
        localObject = null;
      }
      localObject = (ViewGroup)localObject;
      if (localObject != null) {
        ((ViewGroup)localObject).addView(this.XGx, (ViewGroup.LayoutParams)localLayoutParams);
      }
      setCancelable(true);
      super.setOnDismissListener((DialogInterface.OnDismissListener)new c(this));
      return;
    }
  }
  
  final m jg()
  {
    return (m)this.XGy.getValue();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    jg().b(h.b.ZQ);
    initContentView();
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.fVb = paramOnDismissListener;
  }
  
  public void show()
  {
    super.show();
    cpt = ar.isDarkMode();
    XGz = (a)this;
    jg().b(h.b.ZS);
    Window localWindow = getWindow();
    if (localWindow != null) {
      localWindow.setLayout(-1, -1);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class b
    implements View.OnTouchListener
  {
    b(a parama) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(224249);
      this.XGB.cancel();
      AppMethodBeat.o(224249);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class c
    implements DialogInterface.OnDismissListener
  {
    c(a parama) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(203574);
      paramDialogInterface = this.XGB;
      paramDialogInterface.jg().b(h.b.ZO);
      DialogInterface.OnDismissListener localOnDismissListener = paramDialogInterface.fVb;
      if (localOnDismissListener != null) {
        localOnDismissListener.onDismiss((DialogInterface)paramDialogInterface);
      }
      a.XGz = null;
      AppMethodBeat.o(203574);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/lifecycle/LifecycleRegistry;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<m>
  {
    d(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.f.a
 * JD-Core Version:    0.7.0.1
 */