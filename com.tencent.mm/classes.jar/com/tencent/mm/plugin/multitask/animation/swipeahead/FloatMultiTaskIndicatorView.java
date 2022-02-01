package com.tencent.mm.plugin.multitask.animation.swipeahead;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Vibrator;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.svg.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationHandler", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorViewAnimationHandler;", "backgroundImageView", "Landroid/widget/ImageView;", "hasReachFloatBallCountLimit", "", "indicatorImageView", "indicatorTextView", "Landroid/widget/TextView;", "orientationChangedListener", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView$OnOrientationChangedListener;", "vibrator", "Landroid/os/Vibrator;", "zoomInAnimator", "Landroid/animation/Animator;", "zoomOutAnimator", "createZoomInAnimation", "Landroid/animation/AnimatorSet;", "createZoomOutAnimation", "hide", "", "withAnimation", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "init", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDragEnd", "onDragEnter", "onDragExit", "onDragStart", "onFloatBallInfoCountChanged", "onHitChange", "isHit", "setOnOrientationChangedListener", "show", "vibrate", "Companion", "OnOrientationChangedListener", "plugin-multitask_release"})
public final class FloatMultiTaskIndicatorView
  extends FrameLayout
{
  public static final FloatMultiTaskIndicatorView.a Aaq;
  private c Aao;
  private b Aap;
  Vibrator paT;
  ImageView pcg;
  ImageView pch;
  private TextView pci;
  Animator pck;
  Animator pcl;
  boolean pcn;
  
  static
  {
    AppMethodBeat.i(200453);
    Aaq = new FloatMultiTaskIndicatorView.a((byte)0);
    AppMethodBeat.o(200453);
  }
  
  public FloatMultiTaskIndicatorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 4, (byte)0);
  }
  
  public FloatMultiTaskIndicatorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200451);
    View.inflate(paramContext, 2131495180, (ViewGroup)this);
    this.pcg = ((ImageView)findViewById(2131297172));
    this.pch = ((ImageView)findViewById(2131302643));
    this.pci = ((TextView)findViewById(2131302644));
    if (paramContext != null) {}
    for (paramContext = paramContext.getSystemService("vibrator"); paramContext == null; paramContext = null)
    {
      paramContext = new t("null cannot be cast to non-null type android.os.Vibrator");
      AppMethodBeat.o(200451);
      throw paramContext;
    }
    this.paT = ((Vibrator)paramContext);
    this.Aao = new c((View)this);
    float f = f.oYQ;
    paramContext = new AnimatorSet();
    paramAttributeSet = ObjectAnimator.ofFloat(this.pcg, "scaleX", new float[] { f, 1.0F });
    p.g(paramAttributeSet, "scaleX");
    paramAttributeSet.setDuration(200L);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.pcg, "scaleY", new float[] { f, 1.0F });
    p.g(localObjectAnimator, "scaleY");
    localObjectAnimator.setDuration(200L);
    paramContext.playTogether(new Animator[] { (Animator)paramAttributeSet, (Animator)localObjectAnimator });
    this.pck = ((Animator)paramContext);
    f = f.oYQ;
    paramContext = new AnimatorSet();
    paramAttributeSet = ObjectAnimator.ofFloat(this.pcg, "scaleX", new float[] { 1.0F, f });
    p.g(paramAttributeSet, "scaleX");
    paramAttributeSet.setDuration(200L);
    localObjectAnimator = ObjectAnimator.ofFloat(this.pcg, "scaleY", new float[] { 1.0F, f });
    p.g(localObjectAnimator, "scaleY");
    localObjectAnimator.setDuration(200L);
    paramContext.playTogether(new Animator[] { (Animator)paramAttributeSet, (Animator)localObjectAnimator });
    this.pcl = ((Animator)paramContext);
    AppMethodBeat.o(200451);
  }
  
  public final void eqI()
  {
    AppMethodBeat.i(200450);
    Log.i("MicroMsg.FloatMultiTaskIndicatorView", "onFloatBallInfoCountChanged");
    this.pcn = false;
    Object localObject = this.pci;
    if (localObject != null) {
      ((TextView)localObject).setText(2131758719);
    }
    localObject = this.pci;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(b.n(getContext(), 2131100476));
    }
    localObject = this.pcg;
    if (localObject != null) {
      ((ImageView)localObject).setImageResource(2131231133);
    }
    localObject = this.pch;
    if (localObject != null)
    {
      ((ImageView)localObject).setImageDrawable(a.h(getResources(), 2131691196));
      AppMethodBeat.o(200450);
      return;
    }
    AppMethodBeat.o(200450);
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(200449);
    p.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    if (this.Aap != null)
    {
      b localb = this.Aap;
      if (localb != null)
      {
        if (paramConfiguration.orientation == 2) {}
        for (boolean bool = true;; bool = false)
        {
          localb.jY(bool);
          AppMethodBeat.o(200449);
          return;
        }
      }
    }
    AppMethodBeat.o(200449);
  }
  
  public final void setOnOrientationChangedListener(b paramb)
  {
    this.Aap = paramb;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView$OnOrientationChangedListener;", "", "onOrientationChanged", "", "isLandscape", "", "plugin-multitask_release"})
  public static abstract interface b
  {
    public abstract void jY(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.swipeahead.FloatMultiTaskIndicatorView
 * JD-Core Version:    0.7.0.1
 */