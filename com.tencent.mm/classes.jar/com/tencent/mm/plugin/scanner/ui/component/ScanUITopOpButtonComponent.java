package com.tencent.mm.plugin.scanner.ui.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ui/component/ScanUITopOpButtonComponent;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttonContainer", "Landroid/view/View;", "cancelButton", "Landroid/widget/TextView;", "closeButton", "Landroid/widget/ImageView;", "moreButton", "animateAlpha", "", "view", "show", "", "animateCancelButton", "animateCloseButton", "animateMoreButton", "animateSelf", "init", "onBackPressed", "listenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "setOnCancelClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setOnCloseClickListener", "setOnMoreClickListener", "setShowMoreButton", "switchCloseView", "showCancelButton", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "Companion", "plugin-scan_release"})
public final class ScanUITopOpButtonComponent
  extends RelativeLayout
{
  public static final ScanUITopOpButtonComponent.a CPi;
  private View CPe;
  ImageView CPf;
  public TextView CPg;
  private ImageView CPh;
  
  static
  {
    AppMethodBeat.i(240589);
    CPi = new ScanUITopOpButtonComponent.a((byte)0);
    AppMethodBeat.o(240589);
  }
  
  public ScanUITopOpButtonComponent(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(240587);
    AppMethodBeat.o(240587);
  }
  
  public ScanUITopOpButtonComponent(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(240588);
    paramContext = LayoutInflater.from(paramContext).inflate(2131495193, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(2131309309);
    p.g(paramAttributeSet, "view.findViewById(R.id.top_button_container)");
    this.CPe = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131298771);
    p.g(paramAttributeSet, "view.findViewById(R.id.close_button)");
    this.CPf = ((ImageView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131297964);
    p.g(paramAttributeSet, "view.findViewById(R.id.cancel_button)");
    this.CPg = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131304867);
    p.g(paramContext, "view.findViewById(R.id.more_button)");
    this.CPh = ((ImageView)paramContext);
    AppMethodBeat.o(240588);
  }
  
  static void eR(View paramView)
  {
    AppMethodBeat.i(240586);
    m.a(paramView, true, null);
    AppMethodBeat.o(240586);
  }
  
  public final void b(boolean paramBoolean, final Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(240585);
    Log.v("MicroMsg.ScanUITopButtonComponent", "alvinluo switchCloseView showCancelButton: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      localObject = this.CPf;
      if (localObject == null) {
        p.btv("closeButton");
      }
      m.a((View)localObject, false, (Animator.AnimatorListener)new b(this, paramAnimatorListener));
      AppMethodBeat.o(240585);
      return;
    }
    Object localObject = this.CPg;
    if (localObject == null) {
      p.btv("cancelButton");
    }
    m.a((View)localObject, false, (Animator.AnimatorListener)new c(this, paramAnimatorListener));
    AppMethodBeat.o(240585);
  }
  
  public final void setOnCancelClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(240580);
    p.h(paramOnClickListener, "onClickListener");
    TextView localTextView = this.CPg;
    if (localTextView == null) {
      p.btv("cancelButton");
    }
    localTextView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(240580);
  }
  
  public final void setOnCloseClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(240579);
    p.h(paramOnClickListener, "onClickListener");
    ImageView localImageView = this.CPf;
    if (localImageView == null) {
      p.btv("closeButton");
    }
    localImageView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(240579);
  }
  
  public final void setOnMoreClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(240581);
    p.h(paramOnClickListener, "onClickListener");
    ImageView localImageView = this.CPh;
    if (localImageView == null) {
      p.btv("moreButton");
    }
    localImageView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(240581);
  }
  
  public final void setShowMoreButton(boolean paramBoolean)
  {
    AppMethodBeat.i(240582);
    ImageView localImageView = this.CPh;
    if (localImageView == null) {
      p.btv("moreButton");
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(240582);
      return;
    }
  }
  
  public final void tZ(boolean paramBoolean)
  {
    AppMethodBeat.i(240583);
    ImageView localImageView = this.CPh;
    if (localImageView == null) {
      p.btv("moreButton");
    }
    m.a((View)localImageView, paramBoolean, null);
    AppMethodBeat.o(240583);
  }
  
  public final void ua(boolean paramBoolean)
  {
    AppMethodBeat.i(240584);
    m.a((View)this, paramBoolean, null);
    AppMethodBeat.o(240584);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/component/ScanUITopOpButtonComponent$switchCloseView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-scan_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(Animator.AnimatorListener paramAnimatorListener) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(240577);
      p.h(paramAnimator, "animation");
      ScanUITopOpButtonComponent.a(this.CPj).setAlpha(0.0F);
      Object localObject = this.CPj.CPg;
      if (localObject == null) {
        p.btv("cancelButton");
      }
      ScanUITopOpButtonComponent.eR((View)localObject);
      localObject = paramAnimatorListener;
      if (localObject != null)
      {
        ((Animator.AnimatorListener)localObject).onAnimationEnd(paramAnimator);
        AppMethodBeat.o(240577);
        return;
      }
      AppMethodBeat.o(240577);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/component/ScanUITopOpButtonComponent$switchCloseView$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-scan_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(Animator.AnimatorListener paramAnimatorListener) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(240578);
      p.h(paramAnimator, "animation");
      Object localObject = this.CPj.CPf;
      if (localObject == null) {
        p.btv("closeButton");
      }
      ScanUITopOpButtonComponent.eR((View)localObject);
      localObject = paramAnimatorListener;
      if (localObject != null)
      {
        ((Animator.AnimatorListener)localObject).onAnimationEnd(paramAnimator);
        AppMethodBeat.o(240578);
        return;
      }
      AppMethodBeat.o(240578);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.component.ScanUITopOpButtonComponent
 * JD-Core Version:    0.7.0.1
 */