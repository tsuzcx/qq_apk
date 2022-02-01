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
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ui/component/ScanUITopOpButtonComponent;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttonContainer", "Landroid/view/View;", "cancelButton", "Landroid/widget/TextView;", "closeButton", "Landroid/widget/ImageView;", "moreButton", "animateAlpha", "", "view", "show", "", "animateCancelButton", "animateCloseButton", "animateMoreButton", "animateSelf", "init", "onBackPressed", "listenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "setOnCancelClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setOnCloseClickListener", "setOnMoreClickListener", "setShowMoreButton", "switchCloseView", "showCancelButton", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "Companion", "plugin-scan_release"})
public final class ScanUITopOpButtonComponent
  extends RelativeLayout
{
  public static final ScanUITopOpButtonComponent.a IUK;
  private View IUG;
  ImageView IUH;
  public TextView IUI;
  private ImageView IUJ;
  
  static
  {
    AppMethodBeat.i(218581);
    IUK = new ScanUITopOpButtonComponent.a((byte)0);
    AppMethodBeat.o(218581);
  }
  
  public ScanUITopOpButtonComponent(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(218579);
    AppMethodBeat.o(218579);
  }
  
  public ScanUITopOpButtonComponent(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(218580);
    paramContext = LayoutInflater.from(paramContext).inflate(l.g.IEa, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(l.f.IDM);
    p.j(paramAttributeSet, "view.findViewById(R.id.top_button_container)");
    this.IUG = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.f.close_button);
    p.j(paramAttributeSet, "view.findViewById(R.id.close_button)");
    this.IUH = ((ImageView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.f.cancel_button);
    p.j(paramAttributeSet, "view.findViewById(R.id.cancel_button)");
    this.IUI = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(l.f.more_button);
    p.j(paramContext, "view.findViewById(R.id.more_button)");
    this.IUJ = ((ImageView)paramContext);
    AppMethodBeat.o(218580);
  }
  
  static void fV(View paramView)
  {
    AppMethodBeat.i(218578);
    n.a(paramView, true, null);
    AppMethodBeat.o(218578);
  }
  
  public final void b(boolean paramBoolean, final Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(218576);
    Log.v("MicroMsg.ScanUITopButtonComponent", "alvinluo switchCloseView showCancelButton: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      localObject = this.IUH;
      if (localObject == null) {
        p.bGy("closeButton");
      }
      n.a((View)localObject, false, (Animator.AnimatorListener)new b(this, paramAnimatorListener));
      AppMethodBeat.o(218576);
      return;
    }
    Object localObject = this.IUI;
    if (localObject == null) {
      p.bGy("cancelButton");
    }
    n.a((View)localObject, false, (Animator.AnimatorListener)new c(this, paramAnimatorListener));
    AppMethodBeat.o(218576);
  }
  
  public final void setOnCancelClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(218569);
    p.k(paramOnClickListener, "onClickListener");
    TextView localTextView = this.IUI;
    if (localTextView == null) {
      p.bGy("cancelButton");
    }
    localTextView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(218569);
  }
  
  public final void setOnCloseClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(218568);
    p.k(paramOnClickListener, "onClickListener");
    ImageView localImageView = this.IUH;
    if (localImageView == null) {
      p.bGy("closeButton");
    }
    localImageView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(218568);
  }
  
  public final void setOnMoreClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(218570);
    p.k(paramOnClickListener, "onClickListener");
    ImageView localImageView = this.IUJ;
    if (localImageView == null) {
      p.bGy("moreButton");
    }
    localImageView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(218570);
  }
  
  public final void setShowMoreButton(boolean paramBoolean)
  {
    AppMethodBeat.i(218572);
    ImageView localImageView = this.IUJ;
    if (localImageView == null) {
      p.bGy("moreButton");
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(218572);
      return;
    }
  }
  
  public final void xx(boolean paramBoolean)
  {
    AppMethodBeat.i(218573);
    ImageView localImageView = this.IUJ;
    if (localImageView == null) {
      p.bGy("moreButton");
    }
    n.a((View)localImageView, paramBoolean, null);
    AppMethodBeat.o(218573);
  }
  
  public final void xy(boolean paramBoolean)
  {
    AppMethodBeat.i(218574);
    n.a((View)this, paramBoolean, null);
    AppMethodBeat.o(218574);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/component/ScanUITopOpButtonComponent$switchCloseView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-scan_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(Animator.AnimatorListener paramAnimatorListener) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(219223);
      p.k(paramAnimator, "animation");
      ScanUITopOpButtonComponent.a(this.IUL).setAlpha(0.0F);
      Object localObject = this.IUL.IUI;
      if (localObject == null) {
        p.bGy("cancelButton");
      }
      ScanUITopOpButtonComponent.fV((View)localObject);
      localObject = paramAnimatorListener;
      if (localObject != null)
      {
        ((Animator.AnimatorListener)localObject).onAnimationEnd(paramAnimator);
        AppMethodBeat.o(219223);
        return;
      }
      AppMethodBeat.o(219223);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/component/ScanUITopOpButtonComponent$switchCloseView$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-scan_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(Animator.AnimatorListener paramAnimatorListener) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(218793);
      p.k(paramAnimator, "animation");
      Object localObject = this.IUL.IUH;
      if (localObject == null) {
        p.bGy("closeButton");
      }
      ScanUITopOpButtonComponent.fV((View)localObject);
      localObject = paramAnimatorListener;
      if (localObject != null)
      {
        ((Animator.AnimatorListener)localObject).onAnimationEnd(paramAnimator);
        AppMethodBeat.o(218793);
        return;
      }
      AppMethodBeat.o(218793);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.component.ScanUITopOpButtonComponent
 * JD-Core Version:    0.7.0.1
 */