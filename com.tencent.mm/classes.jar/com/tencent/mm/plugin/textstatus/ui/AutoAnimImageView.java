package com.tencent.mm.plugin.textstatus.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/AutoAnimImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "setAnimator", "(Landroid/animation/ValueAnimator;)V", "durationMsPerDp", "", "autoAnim", "", "dpFromPx", "", "px", "getHorizontalAnimator", "img", "Landroid/widget/ImageView;", "scale", "dwidth", "vwidth", "getScaleAnimator", "getVerticalAnimator", "dheight", "vheight", "onAttachedToWindow", "onDetachedFromWindow", "setDurationMsPerDp", "duration", "AnimType", "plugin-textstatus_release"})
public final class AutoAnimImageView
  extends AppCompatImageView
{
  private int MIZ;
  private final String TAG;
  private ValueAnimator animator;
  
  public AutoAnimImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(236477);
    this.TAG = "MicroMsg.TextStatus.AutoAnimImageView";
    this.MIZ = 50;
    AppMethodBeat.o(236477);
  }
  
  public final ValueAnimator getAnimator()
  {
    return this.animator;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(236471);
    super.onAttachedToWindow();
    ValueAnimator localValueAnimator = this.animator;
    if (localValueAnimator != null)
    {
      localValueAnimator.resume();
      AppMethodBeat.o(236471);
      return;
    }
    AppMethodBeat.o(236471);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(236473);
    super.onDetachedFromWindow();
    ValueAnimator localValueAnimator = this.animator;
    if (localValueAnimator != null)
    {
      localValueAnimator.pause();
      AppMethodBeat.o(236473);
      return;
    }
    AppMethodBeat.o(236473);
  }
  
  public final void setAnimator(ValueAnimator paramValueAnimator)
  {
    this.animator = paramValueAnimator;
  }
  
  public final void setDurationMsPerDp(int paramInt)
  {
    this.MIZ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.AutoAnimImageView
 * JD-Core Version:    0.7.0.1
 */