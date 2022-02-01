package com.tencent.mm.plugin.mv.model;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "position", "Landroid/graphics/Point;", "size", "Landroid/util/Size;", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/Point;Landroid/util/Size;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getPosition", "()Landroid/graphics/Point;", "getSize", "()Landroid/util/Size;", "attachTo", "", "imageView", "Landroid/widget/ImageView;", "component1", "component2", "component3", "copy", "cv", "", "from", "to", "progress", "equals", "", "other", "hasDrawable", "hashCode", "", "toString", "", "transitionTo", "Landroid/animation/Animator;", "Landroid/view/View;", "animateView", "hide", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public final Size Kz;
  public final Point LXC;
  private final Drawable drawable;
  
  public g(Drawable paramDrawable, Point paramPoint, Size paramSize)
  {
    AppMethodBeat.i(286068);
    this.drawable = paramDrawable;
    this.LXC = paramPoint;
    this.Kz = paramSize;
    AppMethodBeat.o(286068);
  }
  
  private static final void a(g paramg, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, ImageView paramImageView, boolean paramBoolean, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(286092);
    s.u(paramg, "this$0");
    s.u(paramImageView, "$animateView");
    paramg = paramValueAnimator.getAnimatedValue();
    if (paramg == null)
    {
      paramg = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(286092);
      throw paramg;
    }
    float f = ((Float)paramg).floatValue();
    paramImageView.setX((paramFloat2 - paramFloat1) * f + paramFloat1);
    paramImageView.setY((paramFloat4 - paramFloat3) * f + paramFloat3);
    paramg = paramImageView.getLayoutParams();
    paramg.width = ((int)((paramFloat6 - paramFloat5) * f + paramFloat5));
    paramg.height = ((int)((paramFloat8 - paramFloat7) * f + paramFloat7));
    paramValueAnimator = ah.aiuX;
    paramImageView.setLayoutParams(paramg);
    if (paramBoolean) {
      paramImageView.setAlpha(1.0F - f);
    }
    AppMethodBeat.o(286092);
  }
  
  public final Animator a(g paramg, ImageView paramImageView, boolean paramBoolean)
  {
    AppMethodBeat.i(286124);
    s.u(paramg, "to");
    s.u(paramImageView, "animateView");
    q(paramImageView);
    float f1 = this.LXC.x;
    float f2 = paramg.LXC.x;
    float f3 = this.LXC.y;
    float f4 = paramg.LXC.y;
    float f5 = this.Kz.getWidth();
    float f6 = paramg.Kz.getWidth();
    float f7 = this.Kz.getHeight();
    float f8 = paramg.Kz.getHeight();
    paramg = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramg.addUpdateListener(new g..ExternalSyntheticLambda0(this, f1, f2, f3, f4, f5, f6, f7, f8, paramImageView, paramBoolean));
    s.s(paramg, "anim");
    paramg = (Animator)paramg;
    AppMethodBeat.o(286124);
    return paramg;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(286144);
    if (this == paramObject)
    {
      AppMethodBeat.o(286144);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(286144);
      return false;
    }
    paramObject = (g)paramObject;
    if (!s.p(this.drawable, paramObject.drawable))
    {
      AppMethodBeat.o(286144);
      return false;
    }
    if (!s.p(this.LXC, paramObject.LXC))
    {
      AppMethodBeat.o(286144);
      return false;
    }
    if (!s.p(this.Kz, paramObject.Kz))
    {
      AppMethodBeat.o(286144);
      return false;
    }
    AppMethodBeat.o(286144);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(286138);
    if (this.drawable == null) {}
    for (int i = 0;; i = this.drawable.hashCode())
    {
      int j = this.LXC.hashCode();
      int k = this.Kz.hashCode();
      AppMethodBeat.o(286138);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final void q(ImageView paramImageView)
  {
    AppMethodBeat.i(286113);
    s.u(paramImageView, "imageView");
    paramImageView.setAlpha(1.0F);
    paramImageView.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = this.Kz.getWidth();
    localLayoutParams.height = this.Kz.getHeight();
    ah localah = ah.aiuX;
    paramImageView.setLayoutParams(localLayoutParams);
    paramImageView.setX(this.LXC.x);
    paramImageView.setY(this.LXC.y);
    paramImageView.setImageDrawable(this.drawable);
    AppMethodBeat.o(286113);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(286129);
    String str = "MusicMvAnimationInfo(drawable=" + this.drawable + ", position=" + this.LXC + ", size=" + this.Kz + ')';
    AppMethodBeat.o(286129);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.g
 * JD-Core Version:    0.7.0.1
 */