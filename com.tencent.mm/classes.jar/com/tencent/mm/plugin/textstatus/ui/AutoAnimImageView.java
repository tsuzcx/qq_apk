package com.tencent.mm.plugin.textstatus.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/AutoAnimImageView;", "Landroid/support/v7/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "setAnimator", "(Landroid/animation/ValueAnimator;)V", "durationMsPerDp", "", "autoAnim", "", "dpFromPx", "", "px", "getHorizontalAnimator", "img", "Landroid/widget/ImageView;", "scale", "dwidth", "vwidth", "getScaleAnimator", "getVerticalAnimator", "dheight", "vheight", "onAttachedToWindow", "onDetachedFromWindow", "setDurationMsPerDp", "duration", "AnimType", "plugin-textstatus_release"})
public final class AutoAnimImageView
  extends AppCompatImageView
{
  private int Gcr;
  private final String TAG;
  private ValueAnimator animator;
  
  public AutoAnimImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(216346);
    this.TAG = "MicroMsg.TxtStatus.AutoAnimImageView";
    this.Gcr = 50;
    AppMethodBeat.o(216346);
  }
  
  public final ValueAnimator getAnimator()
  {
    return this.animator;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(216344);
    super.onAttachedToWindow();
    ValueAnimator localValueAnimator = this.animator;
    if (localValueAnimator != null)
    {
      localValueAnimator.resume();
      AppMethodBeat.o(216344);
      return;
    }
    AppMethodBeat.o(216344);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(216345);
    super.onDetachedFromWindow();
    ValueAnimator localValueAnimator = this.animator;
    if (localValueAnimator != null)
    {
      localValueAnimator.pause();
      AppMethodBeat.o(216345);
      return;
    }
    AppMethodBeat.o(216345);
  }
  
  public final void setAnimator(ValueAnimator paramValueAnimator)
  {
    this.animator = paramValueAnimator;
  }
  
  public final void setDurationMsPerDp(int paramInt)
  {
    this.Gcr = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.AutoAnimImageView
 * JD-Core Version:    0.7.0.1
 */