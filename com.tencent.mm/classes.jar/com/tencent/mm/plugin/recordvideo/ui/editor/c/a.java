package com.tencent.mm.plugin.recordvideo.ui.editor.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/MatrixChecker;", "", "()V", "bounds", "Landroid/graphics/RectF;", "getBounds", "()Landroid/graphics/RectF;", "setBounds", "(Landroid/graphics/RectF;)V", "maxScale", "", "getMaxScale", "()F", "setMaxScale", "(F)V", "minScale", "getMinScale", "setMinScale", "pivot", "", "getPivot", "()[F", "setPivot", "([F)V", "clamp", "value", "min", "max", "fallback", "interpolate", "from", "to", "input", "resolve", "", "matrix", "Landroid/graphics/Matrix;", "updateCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "animateFinish", "plugin-recordvideo_release"})
public final class a
{
  public RectF CgM;
  float[] CgN;
  public float aXt;
  public float aXu;
  
  public a()
  {
    AppMethodBeat.i(237927);
    this.CgM = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.CgN = new float[2];
    this.aXu = 1.0F;
    this.aXt = 1.0F;
    AppMethodBeat.o(237927);
  }
  
  private static float p(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(237926);
    paramFloat1 = Math.max(paramFloat2, Math.min(paramFloat1, paramFloat3));
    AppMethodBeat.o(237926);
    return paramFloat1;
  }
  
  public final void a(Matrix paramMatrix, final m<? super Matrix, ? super Boolean, x> paramm)
  {
    AppMethodBeat.i(237925);
    p.h(paramMatrix, "matrix");
    final float[] arrayOfFloat1 = new float[2];
    paramMatrix.mapPoints(arrayOfFloat1, this.CgN);
    final float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = p(arrayOfFloat1[0], this.CgM.left, this.CgM.right);
    arrayOfFloat2[1] = p(arrayOfFloat1[1], this.CgM.top, this.CgM.bottom);
    float[] arrayOfFloat3 = new float[9];
    paramMatrix.getValues(arrayOfFloat3);
    double d1 = arrayOfFloat3[0];
    double d2 = arrayOfFloat3[3];
    double d3 = arrayOfFloat3[4];
    final float f1 = (float)Math.sqrt(d1 * d1 + d2 * d2);
    final float f2 = (float)Math.round(Math.atan2(d2, d3) * 57.295779513082323D);
    final float f3 = p(f1, this.aXu, this.aXt);
    if ((f1 == f3) && (arrayOfFloat1[0] == arrayOfFloat2[0]) && (arrayOfFloat1[1] == arrayOfFloat2[1]))
    {
      paramm.invoke(paramMatrix, Boolean.TRUE);
      AppMethodBeat.o(237925);
      return;
    }
    paramMatrix = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    p.g(paramMatrix, "animator");
    paramMatrix.setDuration(100L);
    paramMatrix.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this, f1, f3, f2, arrayOfFloat1, arrayOfFloat2, paramm));
    paramMatrix.start();
    AppMethodBeat.o(237925);
  }
  
  public final void f(RectF paramRectF)
  {
    AppMethodBeat.i(237923);
    p.h(paramRectF, "<set-?>");
    this.CgM = paramRectF;
    AppMethodBeat.o(237923);
  }
  
  public final void n(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(237924);
    p.h(paramArrayOfFloat, "<set-?>");
    this.CgN = paramArrayOfFloat;
    AppMethodBeat.o(237924);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(a parama, float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, m paramm) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(237922);
      Object localObject = this.CgO;
      p.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(237922);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      paramValueAnimator = new Matrix();
      paramValueAnimator.setTranslate(-localObject.CgN[0], -localObject.CgN[1]);
      paramValueAnimator.postScale(a.q(f1, f3, f), a.q(f1, f3, f));
      paramValueAnimator.postRotate(f2);
      paramValueAnimator.postTranslate(a.q(arrayOfFloat1[0], arrayOfFloat2[0], f), a.q(arrayOfFloat1[1], arrayOfFloat2[1], f));
      localObject = paramm;
      if (localObject != null)
      {
        if (f == 1.0F) {}
        for (boolean bool = true;; bool = false)
        {
          ((m)localObject).invoke(paramValueAnimator, Boolean.valueOf(bool));
          AppMethodBeat.o(237922);
          return;
        }
      }
      AppMethodBeat.o(237922);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.c.a
 * JD-Core Version:    0.7.0.1
 */