package com.tencent.mm.plugin.mv.model;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "position", "Landroid/graphics/Point;", "size", "Landroid/util/Size;", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/Point;Landroid/util/Size;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getPosition", "()Landroid/graphics/Point;", "getSize", "()Landroid/util/Size;", "attachTo", "", "imageView", "Landroid/widget/ImageView;", "component1", "component2", "component3", "copy", "cv", "", "from", "to", "progress", "equals", "", "other", "hasDrawable", "hashCode", "", "toString", "", "transitionTo", "Landroid/animation/Animator;", "Landroid/view/View;", "animateView", "hide", "plugin-mv_release"})
public final class g
{
  public final Point GbG;
  public final Size GbH;
  private final Drawable drawable;
  
  public g(Drawable paramDrawable, Point paramPoint, Size paramSize)
  {
    AppMethodBeat.i(228659);
    this.drawable = paramDrawable;
    this.GbG = paramPoint;
    this.GbH = paramSize;
    AppMethodBeat.o(228659);
  }
  
  public final Animator a(g paramg, final ImageView paramImageView, final boolean paramBoolean)
  {
    AppMethodBeat.i(228654);
    p.k(paramg, "to");
    p.k(paramImageView, "animateView");
    j(paramImageView);
    final float f1 = this.GbG.x;
    final float f2 = paramg.GbG.x;
    final float f3 = this.GbG.y;
    final float f4 = paramg.GbG.y;
    final float f5 = this.GbH.getWidth();
    final float f6 = paramg.GbH.getWidth();
    final float f7 = this.GbH.getHeight();
    final float f8 = paramg.GbH.getHeight();
    paramg = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramg.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this, f1, f2, f3, f4, f5, f6, f7, f8, paramImageView, paramBoolean));
    p.j(paramg, "anim");
    paramg = (Animator)paramg;
    AppMethodBeat.o(228654);
    return paramg;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(228670);
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if ((!p.h(this.drawable, paramObject.drawable)) || (!p.h(this.GbG, paramObject.GbG)) || (!p.h(this.GbH, paramObject.GbH))) {}
      }
    }
    else
    {
      AppMethodBeat.o(228670);
      return true;
    }
    AppMethodBeat.o(228670);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(228666);
    Object localObject = this.drawable;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.GbG;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.GbH;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(228666);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final void j(ImageView paramImageView)
  {
    AppMethodBeat.i(228649);
    p.k(paramImageView, "imageView");
    paramImageView.setAlpha(1.0F);
    paramImageView.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = this.GbH.getWidth();
    localLayoutParams.height = this.GbH.getHeight();
    paramImageView.setLayoutParams(localLayoutParams);
    paramImageView.setX(this.GbG.x);
    paramImageView.setY(this.GbG.y);
    paramImageView.setImageDrawable(this.drawable);
    AppMethodBeat.o(228649);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(228663);
    String str = "MusicMvAnimationInfo(drawable=" + this.drawable + ", position=" + this.GbG + ", size=" + this.GbH + ")";
    AppMethodBeat.o(228663);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(g paramg, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, ImageView paramImageView, boolean paramBoolean) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(242947);
      p.j(paramValueAnimator, "animator");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(242947);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      float f2 = g.o(f1, f2, f1);
      float f3 = g.o(f3, f4, f1);
      float f4 = g.o(f5, f6, f1);
      float f5 = g.o(f7, f8, f1);
      paramImageView.setX(f2);
      paramImageView.setY(f3);
      paramValueAnimator = paramImageView;
      ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
      localLayoutParams.width = ((int)f4);
      localLayoutParams.height = ((int)f5);
      paramValueAnimator.setLayoutParams(localLayoutParams);
      if (paramBoolean) {
        paramImageView.setAlpha(1.0F - f1);
      }
      AppMethodBeat.o(242947);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.g
 * JD-Core Version:    0.7.0.1
 */