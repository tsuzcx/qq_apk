package com.tencent.mm.ui.f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import androidx.appcompat.app.e;
import androidx.lifecycle.j.b;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.l;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/dialog/HalfScreenDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroidx/lifecycle/LifecycleOwner;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "childContentBgView", "Landroid/view/View;", "getChildContentBgView", "()Landroid/view/View;", "setChildContentBgView", "(Landroid/view/View;)V", "childContentView", "getChildContentView", "setChildContentView", "dialogView", "getDialogView", "setDialogView", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "emptyView", "getEmptyView", "setEmptyView", "lifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycle$delegate", "Lkotlin/Lazy;", "fixDialogHeight", "", "getEmptyViewHeight", "", "Landroidx/lifecycle/Lifecycle;", "inflateContentView", "initContentView", "isLandscape", "", "onAttachedToWindow", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "onOuterViewClick", "setOnDismissListener", "listener", "show", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  extends e
  implements q
{
  public static final a afuI = new a((byte)0);
  private static a afuL;
  private static boolean ehd;
  private View afuJ;
  private View afuK;
  private final kotlin.j hfL = k.cm((kotlin.g.a.a)new a.b(this));
  private DialogInterface.OnDismissListener iaY;
  private View plv;
  private View vDA;
  
  public a(Context paramContext)
  {
    super(paramContext, a.l.HalfScreenDialog);
    Hj().e(j.b.bHh);
  }
  
  private final androidx.lifecycle.s Hj()
  {
    return (androidx.lifecycle.s)this.hfL.getValue();
  }
  
  private static final void a(a parama, DialogInterface paramDialogInterface)
  {
    kotlin.g.b.s.u(parama, "this$0");
    parama.onDismiss();
  }
  
  private static final boolean a(a parama, View paramView, MotionEvent paramMotionEvent)
  {
    kotlin.g.b.s.u(parama, "this$0");
    parama.iCc();
    return true;
  }
  
  public static final void aDM()
  {
    ehd = aw.isDarkMode();
    try
    {
      a locala = afuL;
      if (locala != null) {
        locala.dismiss();
      }
    }
    catch (Exception localException)
    {
      label18:
      break label18;
    }
    afuL = null;
  }
  
  public static final boolean jBl()
  {
    return a.jBl();
  }
  
  public abstract View bZy();
  
  public int fcr()
  {
    return com.tencent.mm.cd.a.fromDPToPix(getContext(), 130);
  }
  
  public final View getEmptyView()
  {
    return this.vDA;
  }
  
  public androidx.lifecycle.j getLifecycle()
  {
    return (androidx.lifecycle.j)Hj();
  }
  
  protected void iCc()
  {
    cancel();
  }
  
  public void initContentView()
  {
    Object localObject2 = null;
    Object localObject1 = getWindow();
    if (localObject1 != null) {
      ((Window)localObject1).setLayout(-1, -1);
    }
    localObject1 = getWindow();
    if (localObject1 != null) {
      ((Window)localObject1).addFlags(67108864);
    }
    localObject1 = getWindow();
    if (localObject1 != null) {
      ((Window)localObject1).setDimAmount(0.5F);
    }
    localObject1 = getWindow();
    if (localObject1 != null) {
      ((Window)localObject1).setWindowAnimations(a.l.BottomToTopSlowAnimation);
    }
    localObject1 = LayoutInflater.from(getContext()).inflate(a.h.half_screen_dialog, null, false);
    setContentView((View)localObject1, new ViewGroup.LayoutParams(-1, -1));
    Object localObject3 = ah.aiuX;
    this.plv = ((View)localObject1);
    localObject1 = this.plv;
    if (localObject1 == null)
    {
      localObject1 = null;
      this.vDA = ((View)localObject1);
      localObject1 = this.vDA;
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).getLayoutParams();
        if (localObject1 != null)
        {
          ((ViewGroup.LayoutParams)localObject1).height = fcr();
          localObject3 = this.vDA;
          if (localObject3 != null) {
            ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
      localObject1 = this.vDA;
      if (localObject1 != null) {
        ((View)localObject1).setOnTouchListener(new a..ExternalSyntheticLambda1(this));
      }
      localObject1 = this.plv;
      if (localObject1 != null) {
        break label288;
      }
    }
    label288:
    for (localObject1 = null;; localObject1 = ((View)localObject1).findViewById(a.g.content_view))
    {
      this.afuK = ((View)localObject1);
      this.afuJ = bZy();
      localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(3, a.g.empty_area_view);
      View localView = this.plv;
      localObject1 = localObject2;
      if ((localView instanceof ViewGroup)) {
        localObject1 = (ViewGroup)localView;
      }
      if (localObject1 != null) {
        ((ViewGroup)localObject1).addView(this.afuJ, (ViewGroup.LayoutParams)localObject3);
      }
      setCancelable(true);
      super.setOnDismissListener(new a..ExternalSyntheticLambda0(this));
      return;
      localObject1 = ((View)localObject1).findViewById(a.g.empty_area_view);
      break;
    }
  }
  
  public final View jBi()
  {
    return this.plv;
  }
  
  public final View jBj()
  {
    return this.afuJ;
  }
  
  public final View jBk()
  {
    return this.afuK;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.afuJ != null)
    {
      if (getContext().getResources().getConfiguration().orientation != 2) {
        break label110;
      }
      i = 1;
      if (i == 0) {
        if ((!bf.bg(getContext())) || (Build.VERSION.SDK_INT >= 30)) {
          break label128;
        }
      }
    }
    label128:
    for (int i = bf.bk(getContext());; i = 0)
    {
      Object localObject = this.afuJ;
      if (localObject == null)
      {
        localObject = null;
        label71:
        if (!(localObject instanceof RelativeLayout.LayoutParams)) {
          break label123;
        }
      }
      label110:
      label123:
      for (localObject = (RelativeLayout.LayoutParams)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = i;
        }
        View localView = this.afuJ;
        if (localView != null) {
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        return;
        i = 0;
        break;
        localObject = ((View)localObject).getLayoutParams();
        break label71;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Hj().e(j.b.bHi);
    initContentView();
  }
  
  protected void onDismiss()
  {
    Hj().e(j.b.bHg);
    DialogInterface.OnDismissListener localOnDismissListener = this.iaY;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss((DialogInterface)this);
    }
    afuL = null;
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.iaY = paramOnDismissListener;
  }
  
  public void show()
  {
    super.show();
    ehd = aw.isDarkMode();
    afuL = this;
    Hj().e(j.b.bHk);
    Window localWindow = getWindow();
    if (localWindow != null) {
      localWindow.setLayout(-1, -1);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/dialog/HalfScreenDialog$Companion;", "", "()V", "halfScreenDialog", "Lcom/tencent/mm/ui/dialog/HalfScreenDialog;", "getHalfScreenDialog$annotations", "getHalfScreenDialog", "()Lcom/tencent/mm/ui/dialog/HalfScreenDialog;", "setHalfScreenDialog", "(Lcom/tencent/mm/ui/dialog/HalfScreenDialog;)V", "isDarkMode", "", "()Z", "setDarkMode", "(Z)V", "dismissDialog", "", "isDialogShow", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean jBl()
    {
      AppMethodBeat.i(250715);
      if (a.jBo() != aw.isDarkMode()) {}
      try
      {
        localObject = a.jBm();
        if (localObject != null) {
          ((a)localObject).dismiss();
        }
        label26:
        a.jBn();
      }
      catch (Exception localException)
      {
        Object localObject;
        break label26;
      }
      AppMethodBeat.o(250715);
      return false;
      localObject = a.jBm();
      if (localObject != null)
      {
        if (((a)localObject).isShowing())
        {
          AppMethodBeat.o(250715);
          return true;
        }
        localObject = a.afuI;
        a.jBn();
        AppMethodBeat.o(250715);
        return false;
      }
      AppMethodBeat.o(250715);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.f.a
 * JD-Core Version:    0.7.0.1
 */