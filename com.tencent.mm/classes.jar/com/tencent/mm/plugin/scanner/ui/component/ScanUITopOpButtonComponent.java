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
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/component/ScanUITopOpButtonComponent;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttonContainer", "Landroid/view/View;", "cancelButton", "Landroid/widget/TextView;", "closeButton", "Landroid/widget/ImageView;", "moreButton", "animateAlpha", "", "view", "show", "", "animateCancelButton", "animateCloseButton", "animateMoreButton", "animateSelf", "init", "onBackPressed", "listenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "setOnCancelClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setOnCloseClickListener", "setOnMoreClickListener", "setShowMoreButton", "switchCloseView", "showCancelButton", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanUITopOpButtonComponent
  extends RelativeLayout
{
  public static final ScanUITopOpButtonComponent.a Pdy;
  ImageView CQi;
  public TextView PdA;
  private ImageView PdB;
  private View Pdz;
  
  static
  {
    AppMethodBeat.i(314459);
    Pdy = new ScanUITopOpButtonComponent.a((byte)0);
    AppMethodBeat.o(314459);
  }
  
  public ScanUITopOpButtonComponent(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(314447);
    AppMethodBeat.o(314447);
  }
  
  public ScanUITopOpButtonComponent(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(314450);
    paramContext = LayoutInflater.from(paramContext).inflate(l.g.OKd, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(l.f.OJO);
    s.s(paramAttributeSet, "view.findViewById(R.id.top_button_container)");
    this.Pdz = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.f.close_button);
    s.s(paramAttributeSet, "view.findViewById(R.id.close_button)");
    this.CQi = ((ImageView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.f.cancel_button);
    s.s(paramAttributeSet, "view.findViewById(R.id.cancel_button)");
    this.PdA = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(l.f.more_button);
    s.s(paramContext, "view.findViewById(R.id.more_button)");
    this.PdB = ((ImageView)paramContext);
    AppMethodBeat.o(314450);
  }
  
  static void iW(View paramView)
  {
    AppMethodBeat.i(314454);
    p.a(paramView, true, null);
    AppMethodBeat.o(314454);
  }
  
  public final void Cl(boolean paramBoolean)
  {
    AppMethodBeat.i(314473);
    ImageView localImageView2 = this.PdB;
    ImageView localImageView1 = localImageView2;
    if (localImageView2 == null)
    {
      s.bIx("moreButton");
      localImageView1 = null;
    }
    p.a((View)localImageView1, paramBoolean, null);
    AppMethodBeat.o(314473);
  }
  
  public final void Cm(boolean paramBoolean)
  {
    AppMethodBeat.i(314476);
    p.a((View)this, paramBoolean, null);
    AppMethodBeat.o(314476);
  }
  
  public final void b(boolean paramBoolean, final Animator.AnimatorListener paramAnimatorListener)
  {
    ImageView localImageView = null;
    Object localObject = null;
    AppMethodBeat.i(314480);
    Log.v("MicroMsg.ScanUITopButtonComponent", "alvinluo switchCloseView showCancelButton: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      localImageView = this.CQi;
      if (localImageView == null) {
        s.bIx("closeButton");
      }
      for (;;)
      {
        p.a((View)localObject, false, (Animator.AnimatorListener)new b(this, paramAnimatorListener));
        AppMethodBeat.o(314480);
        return;
        localObject = localImageView;
      }
    }
    localObject = this.PdA;
    if (localObject == null)
    {
      s.bIx("cancelButton");
      localObject = localImageView;
    }
    for (;;)
    {
      p.a((View)localObject, false, (Animator.AnimatorListener)new c(this, paramAnimatorListener));
      AppMethodBeat.o(314480);
      return;
    }
  }
  
  public final void setOnCancelClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(314462);
    s.u(paramOnClickListener, "onClickListener");
    TextView localTextView2 = this.PdA;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      s.bIx("cancelButton");
      localTextView1 = null;
    }
    localTextView1.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(314462);
  }
  
  public final void setOnCloseClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(314461);
    s.u(paramOnClickListener, "onClickListener");
    ImageView localImageView2 = this.CQi;
    ImageView localImageView1 = localImageView2;
    if (localImageView2 == null)
    {
      s.bIx("closeButton");
      localImageView1 = null;
    }
    localImageView1.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(314461);
  }
  
  public final void setOnMoreClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(314465);
    s.u(paramOnClickListener, "onClickListener");
    ImageView localImageView2 = this.PdB;
    ImageView localImageView1 = localImageView2;
    if (localImageView2 == null)
    {
      s.bIx("moreButton");
      localImageView1 = null;
    }
    localImageView1.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(314465);
  }
  
  public final void setShowMoreButton(boolean paramBoolean)
  {
    AppMethodBeat.i(314470);
    ImageView localImageView = this.PdB;
    if (localImageView == null)
    {
      s.bIx("moreButton");
      localImageView = null;
      if (!paramBoolean) {
        break label41;
      }
    }
    label41:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(314470);
      return;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/component/ScanUITopOpButtonComponent$switchCloseView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(ScanUITopOpButtonComponent paramScanUITopOpButtonComponent, Animator.AnimatorListener paramAnimatorListener) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(314452);
      s.u(paramAnimator, "animation");
      TextView localTextView = ScanUITopOpButtonComponent.a(this.PdC);
      Object localObject = localTextView;
      if (localTextView == null)
      {
        s.bIx("cancelButton");
        localObject = null;
      }
      ((TextView)localObject).setAlpha(0.0F);
      localTextView = this.PdC.PdA;
      localObject = localTextView;
      if (localTextView == null)
      {
        s.bIx("cancelButton");
        localObject = null;
      }
      ScanUITopOpButtonComponent.iW((View)localObject);
      localObject = paramAnimatorListener;
      if (localObject != null) {
        ((Animator.AnimatorListener)localObject).onAnimationEnd(paramAnimator);
      }
      AppMethodBeat.o(314452);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/component/ScanUITopOpButtonComponent$switchCloseView$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(ScanUITopOpButtonComponent paramScanUITopOpButtonComponent, Animator.AnimatorListener paramAnimatorListener) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(314455);
      s.u(paramAnimator, "animation");
      ImageView localImageView = this.PdC.CQi;
      Object localObject = localImageView;
      if (localImageView == null)
      {
        s.bIx("closeButton");
        localObject = null;
      }
      ScanUITopOpButtonComponent.iW((View)localObject);
      localObject = paramAnimatorListener;
      if (localObject != null) {
        ((Animator.AnimatorListener)localObject).onAnimationEnd(paramAnimator);
      }
      AppMethodBeat.o(314455);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.component.ScanUITopOpButtonComponent
 * JD-Core Version:    0.7.0.1
 */