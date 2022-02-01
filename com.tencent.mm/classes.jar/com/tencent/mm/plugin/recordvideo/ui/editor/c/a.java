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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/MatrixChecker;", "", "()V", "bounds", "Landroid/graphics/RectF;", "getBounds", "()Landroid/graphics/RectF;", "setBounds", "(Landroid/graphics/RectF;)V", "maxScale", "", "getMaxScale", "()F", "setMaxScale", "(F)V", "minScale", "getMinScale", "setMinScale", "pivot", "", "getPivot", "()[F", "setPivot", "([F)V", "clamp", "value", "min", "max", "fallback", "interpolate", "from", "to", "input", "resolve", "", "matrix", "Landroid/graphics/Matrix;", "updateCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "animateFinish", "plugin-recordvideo_release"})
public final class a
{
  public RectF IdC;
  float[] IdD;
  public float aGN;
  public float aGO;
  
  public a()
  {
    AppMethodBeat.i(219916);
    this.IdC = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.IdD = new float[2];
    this.aGO = 1.0F;
    this.aGN = 1.0F;
    AppMethodBeat.o(219916);
  }
  
  private static float c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(219914);
    paramFloat1 = Math.max(paramFloat2, Math.min(paramFloat1, paramFloat3));
    AppMethodBeat.o(219914);
    return paramFloat1;
  }
  
  public final void a(Matrix paramMatrix, final m<? super Matrix, ? super Boolean, x> paramm)
  {
    AppMethodBeat.i(219912);
    p.k(paramMatrix, "matrix");
    final float[] arrayOfFloat1 = new float[2];
    paramMatrix.mapPoints(arrayOfFloat1, this.IdD);
    final float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = c(arrayOfFloat1[0], this.IdC.left, this.IdC.right);
    arrayOfFloat2[1] = c(arrayOfFloat1[1], this.IdC.top, this.IdC.bottom);
    float[] arrayOfFloat3 = new float[9];
    paramMatrix.getValues(arrayOfFloat3);
    double d1 = arrayOfFloat3[0];
    double d2 = arrayOfFloat3[3];
    double d3 = arrayOfFloat3[4];
    final float f1 = (float)Math.sqrt(d1 * d1 + d2 * d2);
    final float f2 = (float)Math.round(Math.atan2(d2, d3) * 57.295779513082323D);
    final float f3 = c(f1, this.aGO, this.aGN);
    if ((f1 == f3) && (arrayOfFloat1[0] == arrayOfFloat2[0]) && (arrayOfFloat1[1] == arrayOfFloat2[1]))
    {
      paramm.invoke(paramMatrix, Boolean.TRUE);
      AppMethodBeat.o(219912);
      return;
    }
    paramMatrix = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    p.j(paramMatrix, "animator");
    paramMatrix.setDuration(100L);
    paramMatrix.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this, f1, f3, f2, arrayOfFloat1, arrayOfFloat2, paramm));
    paramMatrix.start();
    AppMethodBeat.o(219912);
  }
  
  public final void f(RectF paramRectF)
  {
    AppMethodBeat.i(219909);
    p.k(paramRectF, "<set-?>");
    this.IdC = paramRectF;
    AppMethodBeat.o(219909);
  }
  
  public final void o(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(219910);
    p.k(paramArrayOfFloat, "<set-?>");
    this.IdD = paramArrayOfFloat;
    AppMethodBeat.o(219910);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(a parama, float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, m paramm) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(225379);
      Object localObject = this.IdE;
      p.j(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(225379);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      paramValueAnimator = new Matrix();
      paramValueAnimator.setTranslate(-localObject.IdD[0], -localObject.IdD[1]);
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
          AppMethodBeat.o(225379);
          return;
        }
      }
      AppMethodBeat.o(225379);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.c.a
 * JD-Core Version:    0.7.0.1
 */