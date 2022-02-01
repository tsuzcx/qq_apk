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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationHandler", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorViewAnimationHandler;", "backgroundImageView", "Landroid/widget/ImageView;", "hasReachFloatBallCountLimit", "", "indicatorImageView", "indicatorTextView", "Landroid/widget/TextView;", "orientationChangedListener", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView$OnOrientationChangedListener;", "vibrator", "Landroid/os/Vibrator;", "zoomInAnimator", "Landroid/animation/Animator;", "zoomOutAnimator", "createZoomInAnimation", "Landroid/animation/AnimatorSet;", "createZoomOutAnimation", "hide", "", "withAnimation", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "init", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDragEnd", "onDragEnter", "onDragExit", "onDragStart", "onFloatBallInfoCountChanged", "onHitChange", "isHit", "setOnOrientationChangedListener", "show", "vibrate", "Companion", "OnOrientationChangedListener", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FloatMultiTaskIndicatorView
  extends FrameLayout
{
  public static final FloatMultiTaskIndicatorView.a LBZ;
  private c LCa;
  private b LCb;
  Vibrator uAL;
  ImageView vpW;
  ImageView vpX;
  private TextView vpY;
  Animator vqa;
  Animator vqb;
  boolean vqd;
  
  static
  {
    AppMethodBeat.i(303916);
    LBZ = new FloatMultiTaskIndicatorView.a((byte)0);
    AppMethodBeat.o(303916);
  }
  
  public FloatMultiTaskIndicatorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
  }
  
  public FloatMultiTaskIndicatorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(303904);
    View.inflate(paramContext, j.f.layout_multitask_float_indicator_view, (ViewGroup)this);
    this.vpW = ((ImageView)findViewById(j.e.backgroundImageView));
    this.vpX = ((ImageView)findViewById(j.e.indicatorImageView));
    this.vpY = ((TextView)findViewById(j.e.indicatorTextView));
    if (paramContext == null) {}
    for (paramContext = null; paramContext == null; paramContext = paramContext.getSystemService("vibrator"))
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
      AppMethodBeat.o(303904);
      throw paramContext;
    }
    this.uAL = ((Vibrator)paramContext);
    this.LCa = new c((View)this);
    float f = f.vmj;
    paramContext = new AnimatorSet();
    paramAttributeSet = ObjectAnimator.ofFloat(this.vpW, "scaleX", new float[] { f, 1.0F });
    paramAttributeSet.setDuration(200L);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.vpW, "scaleY", new float[] { f, 1.0F });
    localObjectAnimator.setDuration(200L);
    paramContext.playTogether(new Animator[] { (Animator)paramAttributeSet, (Animator)localObjectAnimator });
    this.vqa = ((Animator)paramContext);
    f = f.vmj;
    paramContext = new AnimatorSet();
    paramAttributeSet = ObjectAnimator.ofFloat(this.vpW, "scaleX", new float[] { 1.0F, f });
    paramAttributeSet.setDuration(200L);
    localObjectAnimator = ObjectAnimator.ofFloat(this.vpW, "scaleY", new float[] { 1.0F, f });
    localObjectAnimator.setDuration(200L);
    paramContext.playTogether(new Animator[] { (Animator)paramAttributeSet, (Animator)localObjectAnimator });
    this.vqb = ((Animator)paramContext);
    AppMethodBeat.o(303904);
  }
  
  public final void gjE()
  {
    AppMethodBeat.i(303934);
    Log.i("MicroMsg.FloatMultiTaskIndicatorView", "onFloatBallInfoCountChanged");
    this.vqd = false;
    Object localObject = this.vpY;
    if (localObject != null) {
      ((TextView)localObject).setText(j.h.enter_multi_task_float_ball);
    }
    localObject = this.vpY;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(androidx.core.content.a.w(getContext(), j.b.float_ball_multitask_corner_text_color));
    }
    localObject = this.vpW;
    if (localObject != null) {
      ((ImageView)localObject).setImageResource(j.d.background_float_indicator_view);
    }
    localObject = this.vpX;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(com.tencent.mm.svg.a.a.i(getResources(), j.g.multitask_indicator_icon));
    }
    AppMethodBeat.o(303934);
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(303923);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    b localb;
    if (this.LCb != null)
    {
      localb = this.LCb;
      if (localb != null) {
        if (paramConfiguration.orientation != 2) {
          break label58;
        }
      }
    }
    label58:
    for (boolean bool = true;; bool = false)
    {
      localb.mw(bool);
      AppMethodBeat.o(303923);
      return;
    }
  }
  
  public final void setOnOrientationChangedListener(b paramb)
  {
    this.LCb = paramb;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView$OnOrientationChangedListener;", "", "onOrientationChanged", "", "isLandscape", "", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void mw(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.swipeahead.FloatMultiTaskIndicatorView
 * JD-Core Version:    0.7.0.1
 */