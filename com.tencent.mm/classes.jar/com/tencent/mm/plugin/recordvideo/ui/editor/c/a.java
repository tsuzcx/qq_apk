package com.tencent.mm.plugin.recordvideo.ui.editor.c;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/MatrixChecker;", "", "()V", "bounds", "Landroid/graphics/RectF;", "getBounds", "()Landroid/graphics/RectF;", "setBounds", "(Landroid/graphics/RectF;)V", "maxScale", "", "getMaxScale", "()F", "setMaxScale", "(F)V", "minScale", "getMinScale", "setMinScale", "pivot", "", "getPivot", "()[F", "setPivot", "([F)V", "clamp", "value", "min", "max", "fallback", "interpolate", "from", "to", "input", "resolve", "", "matrix", "Landroid/graphics/Matrix;", "updateCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "animateFinish", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public RectF NZY;
  private float[] NZZ;
  public float maxScale;
  public float minScale;
  
  public a()
  {
    AppMethodBeat.i(280159);
    this.NZY = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.NZZ = new float[2];
    this.minScale = 1.0F;
    this.maxScale = 1.0F;
    AppMethodBeat.o(280159);
  }
  
  private static final void a(a parama, float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, m paramm, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(280188);
    s.u(parama, "this$0");
    s.u(paramArrayOfFloat1, "$pivotFrom");
    s.u(paramArrayOfFloat2, "$pivotTo");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(280188);
      throw parama;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramValueAnimator = new Matrix();
    paramValueAnimator.setTranslate(-parama.NZZ[0], -parama.NZZ[1]);
    paramValueAnimator.postScale(t(paramFloat1, paramFloat2, f), t(paramFloat1, paramFloat2, f));
    paramValueAnimator.postRotate(paramFloat3);
    paramValueAnimator.postTranslate(t(paramArrayOfFloat1[0], paramArrayOfFloat2[0], f), t(paramArrayOfFloat1[1], paramArrayOfFloat2[1], f));
    if (paramm != null) {
      if (f != 1.0F) {
        break label187;
      }
    }
    label187:
    for (boolean bool = true;; bool = false)
    {
      paramm.invoke(paramValueAnimator, Boolean.valueOf(bool));
      AppMethodBeat.o(280188);
      return;
    }
  }
  
  private static float g(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(280165);
    paramFloat1 = Math.max(paramFloat2, Math.min(paramFloat1, paramFloat3));
    AppMethodBeat.o(280165);
    return paramFloat1;
  }
  
  private static float t(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat2 * paramFloat3 + (1.0F - paramFloat3) * paramFloat1;
  }
  
  public final void a(Matrix paramMatrix, m<? super Matrix, ? super Boolean, ah> paramm)
  {
    AppMethodBeat.i(280232);
    s.u(paramMatrix, "matrix");
    float[] arrayOfFloat1 = new float[2];
    paramMatrix.mapPoints(arrayOfFloat1, this.NZZ);
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = g(arrayOfFloat1[0], this.NZY.left, this.NZY.right);
    arrayOfFloat2[1] = g(arrayOfFloat1[1], this.NZY.top, this.NZY.bottom);
    float[] arrayOfFloat3 = new float[9];
    paramMatrix.getValues(arrayOfFloat3);
    double d1 = arrayOfFloat3[0];
    double d2 = arrayOfFloat3[3];
    double d3 = arrayOfFloat3[4];
    float f1 = (float)Math.sqrt(d1 * d1 + d2 * d2);
    float f2 = (float)Math.round(Math.atan2(d2, d3) * 57.295779513082323D);
    float f3 = g(f1, this.minScale, this.maxScale);
    if (f1 == f3)
    {
      i = 1;
      if (i == 0) {
        break label251;
      }
      if (arrayOfFloat1[0] != arrayOfFloat2[0]) {
        break label239;
      }
      i = 1;
      label191:
      if (i == 0) {
        break label251;
      }
      if (arrayOfFloat1[1] != arrayOfFloat2[1]) {
        break label245;
      }
    }
    label239:
    label245:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label251;
      }
      paramm.invoke(paramMatrix, Boolean.TRUE);
      AppMethodBeat.o(280232);
      return;
      i = 0;
      break;
      i = 0;
      break label191;
    }
    label251:
    paramMatrix = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramMatrix.setDuration(100L);
    paramMatrix.addUpdateListener(new a..ExternalSyntheticLambda0(this, f1, f3, f2, arrayOfFloat1, arrayOfFloat2, paramm));
    paramMatrix.start();
    AppMethodBeat.o(280232);
  }
  
  public final void g(RectF paramRectF)
  {
    AppMethodBeat.i(280208);
    s.u(paramRectF, "<set-?>");
    this.NZY = paramRectF;
    AppMethodBeat.o(280208);
  }
  
  public final void w(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(280216);
    s.u(paramArrayOfFloat, "<set-?>");
    this.NZZ = paramArrayOfFloat;
    AppMethodBeat.o(280216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.c.a
 * JD-Core Version:    0.7.0.1
 */