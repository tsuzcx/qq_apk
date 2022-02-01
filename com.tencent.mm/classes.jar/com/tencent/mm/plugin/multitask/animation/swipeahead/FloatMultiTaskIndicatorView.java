package com.tencent.mm.plugin.multitask.animation.swipeahead;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.f;
import com.tencent.mm.plugin.multitask.j.b;
import com.tencent.mm.plugin.multitask.j.d;
import com.tencent.mm.plugin.multitask.j.e;
import com.tencent.mm.plugin.multitask.j.f;
import com.tencent.mm.plugin.multitask.j.g;
import com.tencent.mm.plugin.multitask.j.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationHandler", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorViewAnimationHandler;", "backgroundImageView", "Landroid/widget/ImageView;", "hasReachFloatBallCountLimit", "", "indicatorImageView", "indicatorTextView", "Landroid/widget/TextView;", "orientationChangedListener", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView$OnOrientationChangedListener;", "vibrator", "Landroid/os/Vibrator;", "zoomInAnimator", "Landroid/animation/Animator;", "zoomOutAnimator", "createZoomInAnimation", "Landroid/animation/AnimatorSet;", "createZoomOutAnimation", "hide", "", "withAnimation", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "init", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDragEnd", "onDragEnter", "onDragExit", "onDragStart", "onFloatBallInfoCountChanged", "onHitChange", "isHit", "setOnOrientationChangedListener", "show", "vibrate", "Companion", "OnOrientationChangedListener", "plugin-multitask_release"})
public final class FloatMultiTaskIndicatorView
  extends FrameLayout
{
  public static final FloatMultiTaskIndicatorView.a FGh;
  private c FGf;
  private b FGg;
  Vibrator rqC;
  ImageView seg;
  ImageView seh;
  private TextView sei;
  Animator sek;
  Animator sel;
  boolean sen;
  
  static
  {
    AppMethodBeat.i(248936);
    FGh = new FloatMultiTaskIndicatorView.a((byte)0);
    AppMethodBeat.o(248936);
  }
  
  public FloatMultiTaskIndicatorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
  }
  
  public FloatMultiTaskIndicatorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(248934);
    View.inflate(paramContext, j.f.layout_multitask_float_indicator_view, (ViewGroup)this);
    this.seg = ((ImageView)findViewById(j.e.backgroundImageView));
    this.seh = ((ImageView)findViewById(j.e.indicatorImageView));
    this.sei = ((TextView)findViewById(j.e.indicatorTextView));
    if (paramContext != null) {}
    for (paramContext = paramContext.getSystemService("vibrator"); paramContext == null; paramContext = null)
    {
      paramContext = new t("null cannot be cast to non-null type android.os.Vibrator");
      AppMethodBeat.o(248934);
      throw paramContext;
    }
    this.rqC = ((Vibrator)paramContext);
    this.FGf = new c((View)this);
    float f = f.saR;
    paramContext = new AnimatorSet();
    paramAttributeSet = ObjectAnimator.ofFloat(this.seg, "scaleX", new float[] { f, 1.0F });
    p.j(paramAttributeSet, "scaleX");
    paramAttributeSet.setDuration(200L);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.seg, "scaleY", new float[] { f, 1.0F });
    p.j(localObjectAnimator, "scaleY");
    localObjectAnimator.setDuration(200L);
    paramContext.playTogether(new Animator[] { (Animator)paramAttributeSet, (Animator)localObjectAnimator });
    this.sek = ((Animator)paramContext);
    f = f.saR;
    paramContext = new AnimatorSet();
    paramAttributeSet = ObjectAnimator.ofFloat(this.seg, "scaleX", new float[] { 1.0F, f });
    p.j(paramAttributeSet, "scaleX");
    paramAttributeSet.setDuration(200L);
    localObjectAnimator = ObjectAnimator.ofFloat(this.seg, "scaleY", new float[] { 1.0F, f });
    p.j(localObjectAnimator, "scaleY");
    localObjectAnimator.setDuration(200L);
    paramContext.playTogether(new Animator[] { (Animator)paramAttributeSet, (Animator)localObjectAnimator });
    this.sel = ((Animator)paramContext);
    AppMethodBeat.o(248934);
  }
  
  public final void faz()
  {
    AppMethodBeat.i(248931);
    Log.i("MicroMsg.FloatMultiTaskIndicatorView", "onFloatBallInfoCountChanged");
    this.sen = false;
    Object localObject = this.sei;
    if (localObject != null) {
      ((TextView)localObject).setText(j.h.enter_multi_task_float_ball);
    }
    localObject = this.sei;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(androidx.core.content.a.w(getContext(), j.b.float_ball_multitask_corner_text_color));
    }
    localObject = this.seg;
    if (localObject != null) {
      ((ImageView)localObject).setImageResource(j.d.background_float_indicator_view);
    }
    localObject = this.seh;
    if (localObject != null)
    {
      ((ImageView)localObject).setImageDrawable(com.tencent.mm.svg.a.a.h(getResources(), j.g.multitask_indicator_icon));
      AppMethodBeat.o(248931);
      return;
    }
    AppMethodBeat.o(248931);
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(248929);
    p.k(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    if (this.FGg != null)
    {
      b localb = this.FGg;
      if (localb != null)
      {
        if (paramConfiguration.orientation == 2) {}
        for (boolean bool = true;; bool = false)
        {
          localb.lj(bool);
          AppMethodBeat.o(248929);
          return;
        }
      }
    }
    AppMethodBeat.o(248929);
  }
  
  public final void setOnOrientationChangedListener(b paramb)
  {
    this.FGg = paramb;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView$OnOrientationChangedListener;", "", "onOrientationChanged", "", "isLandscape", "", "plugin-multitask_release"})
  public static abstract interface b
  {
    public abstract void lj(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.swipeahead.FloatMultiTaskIndicatorView
 * JD-Core Version:    0.7.0.1
 */