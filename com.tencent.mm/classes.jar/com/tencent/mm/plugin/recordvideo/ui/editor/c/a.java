package com.tencent.mm.plugin.recordvideo.ui.editor.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/MatrixChecker;", "", "()V", "bounds", "Landroid/graphics/RectF;", "getBounds", "()Landroid/graphics/RectF;", "setBounds", "(Landroid/graphics/RectF;)V", "maxScale", "", "getMaxScale", "()F", "setMaxScale", "(F)V", "minScale", "getMinScale", "setMinScale", "pivot", "", "getPivot", "()[F", "setPivot", "([F)V", "clamp", "value", "min", "max", "fallback", "interpolate", "from", "to", "input", "resolve", "", "matrix", "Landroid/graphics/Matrix;", "updateCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "animateFinish", "plugin-recordvideo_release"})
public final class a
{
  public float aXE;
  public float aXF;
  public RectF xPV;
  float[] xPW;
  
  public a()
  {
    AppMethodBeat.i(200828);
    this.xPV = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.xPW = new float[2];
    this.aXF = 1.0F;
    this.aXE = 1.0F;
    AppMethodBeat.o(200828);
  }
  
  private static float m(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(200827);
    paramFloat1 = Math.max(paramFloat2, Math.min(paramFloat1, paramFloat3));
    AppMethodBeat.o(200827);
    return paramFloat1;
  }
  
  public final void a(Matrix paramMatrix, final m<? super Matrix, ? super Boolean, z> paramm)
  {
    AppMethodBeat.i(200826);
    p.h(paramMatrix, "matrix");
    final float[] arrayOfFloat1 = new float[2];
    paramMatrix.mapPoints(arrayOfFloat1, this.xPW);
    final float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = m(arrayOfFloat1[0], this.xPV.left, this.xPV.right);
    arrayOfFloat2[1] = m(arrayOfFloat1[1], this.xPV.top, this.xPV.bottom);
    float[] arrayOfFloat3 = new float[9];
    paramMatrix.getValues(arrayOfFloat3);
    double d1 = arrayOfFloat3[0];
    double d2 = arrayOfFloat3[3];
    double d3 = arrayOfFloat3[4];
    final float f1 = (float)Math.sqrt(d1 * d1 + d2 * d2);
    final float f2 = (float)Math.round(Math.atan2(d2, d3) * 57.295779513082323D);
    final float f3 = m(f1, this.aXF, this.aXE);
    if ((f1 == f3) && (arrayOfFloat1[0] == arrayOfFloat2[0]) && (arrayOfFloat1[1] == arrayOfFloat2[1]))
    {
      paramm.p(paramMatrix, Boolean.TRUE);
      AppMethodBeat.o(200826);
      return;
    }
    paramMatrix = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    p.g(paramMatrix, "animator");
    paramMatrix.setDuration(100L);
    paramMatrix.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this, f1, f3, f2, arrayOfFloat1, arrayOfFloat2, paramm));
    paramMatrix.start();
    AppMethodBeat.o(200826);
  }
  
  public final void f(RectF paramRectF)
  {
    AppMethodBeat.i(200824);
    p.h(paramRectF, "<set-?>");
    this.xPV = paramRectF;
    AppMethodBeat.o(200824);
  }
  
  public final void n(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(200825);
    p.h(paramArrayOfFloat, "<set-?>");
    this.xPW = paramArrayOfFloat;
    AppMethodBeat.o(200825);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(a parama, float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, m paramm) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(200823);
      Object localObject = this.xPX;
      p.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(200823);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      paramValueAnimator = new Matrix();
      paramValueAnimator.setTranslate(-localObject.xPW[0], -localObject.xPW[1]);
      paramValueAnimator.postScale(a.n(f1, f3, f), a.n(f1, f3, f));
      paramValueAnimator.postRotate(f2);
      paramValueAnimator.postTranslate(a.n(arrayOfFloat1[0], arrayOfFloat2[0], f), a.n(arrayOfFloat1[1], arrayOfFloat2[1], f));
      localObject = paramm;
      if (localObject != null)
      {
        if (f == 1.0F) {}
        for (boolean bool = true;; bool = false)
        {
          ((m)localObject).p(paramValueAnimator, Boolean.valueOf(bool));
          AppMethodBeat.o(200823);
          return;
        }
      }
      AppMethodBeat.o(200823);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.c.a
 * JD-Core Version:    0.7.0.1
 */