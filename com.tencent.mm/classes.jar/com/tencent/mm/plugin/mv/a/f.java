package com.tencent.mm.plugin.mv.a;

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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "position", "Landroid/graphics/Point;", "size", "Landroid/util/Size;", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/Point;Landroid/util/Size;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getPosition", "()Landroid/graphics/Point;", "getSize", "()Landroid/util/Size;", "attachTo", "", "imageView", "Landroid/widget/ImageView;", "component1", "component2", "component3", "copy", "cv", "", "from", "to", "progress", "equals", "", "other", "hasDrawable", "hashCode", "", "toString", "", "transitionTo", "Landroid/animation/Animator;", "Landroid/view/View;", "animateView", "hide", "plugin-mv_release"})
public final class f
{
  public final Point ApS;
  public final Size ApT;
  private final Drawable drawable;
  
  public f(Drawable paramDrawable, Point paramPoint, Size paramSize)
  {
    AppMethodBeat.i(256791);
    this.drawable = paramDrawable;
    this.ApS = paramPoint;
    this.ApT = paramSize;
    AppMethodBeat.o(256791);
  }
  
  public final Animator a(f paramf, final ImageView paramImageView, final boolean paramBoolean)
  {
    AppMethodBeat.i(256790);
    p.h(paramf, "to");
    p.h(paramImageView, "animateView");
    i(paramImageView);
    final float f1 = this.ApS.x;
    final float f2 = paramf.ApS.x;
    final float f3 = this.ApS.y;
    final float f4 = paramf.ApS.y;
    final float f5 = this.ApT.getWidth();
    final float f6 = paramf.ApT.getWidth();
    final float f7 = this.ApT.getHeight();
    final float f8 = paramf.ApT.getHeight();
    paramf = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramf.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this, f1, f2, f3, f4, f5, f6, f7, f8, paramImageView, paramBoolean));
    p.g(paramf, "anim");
    paramf = (Animator)paramf;
    AppMethodBeat.o(256790);
    return paramf;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(256794);
    if (this != paramObject)
    {
      if ((paramObject instanceof f))
      {
        paramObject = (f)paramObject;
        if ((!p.j(this.drawable, paramObject.drawable)) || (!p.j(this.ApS, paramObject.ApS)) || (!p.j(this.ApT, paramObject.ApT))) {}
      }
    }
    else
    {
      AppMethodBeat.o(256794);
      return true;
    }
    AppMethodBeat.o(256794);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(256793);
    Object localObject = this.drawable;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.ApS;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.ApT;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(256793);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final void i(ImageView paramImageView)
  {
    AppMethodBeat.i(256789);
    p.h(paramImageView, "imageView");
    paramImageView.setAlpha(1.0F);
    paramImageView.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = this.ApT.getWidth();
    localLayoutParams.height = this.ApT.getHeight();
    paramImageView.setLayoutParams(localLayoutParams);
    paramImageView.setX(this.ApS.x);
    paramImageView.setY(this.ApS.y);
    paramImageView.setImageDrawable(this.drawable);
    AppMethodBeat.o(256789);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(256792);
    String str = "MusicMvAnimationInfo(drawable=" + this.drawable + ", position=" + this.ApS + ", size=" + this.ApT + ")";
    AppMethodBeat.o(256792);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(f paramf, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, ImageView paramImageView, boolean paramBoolean) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(256788);
      p.g(paramValueAnimator, "animator");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(256788);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      float f2 = f.n(f1, f2, f1);
      float f3 = f.n(f3, f4, f1);
      float f4 = f.n(f5, f6, f1);
      float f5 = f.n(f7, f8, f1);
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
      AppMethodBeat.o(256788);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.f
 * JD-Core Version:    0.7.0.1
 */