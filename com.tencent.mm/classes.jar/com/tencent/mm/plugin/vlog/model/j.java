package com.tencent.mm.plugin.vlog.model;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"scaleRect", "", "origin", "Landroid/graphics/Rect;", "target", "getScale", "", "Landroid/graphics/Matrix;", "scaleBy", "scale", "setRectToRectCenterCrop", "src", "Landroid/graphics/RectF;", "dst", "srcLeft", "srcTop", "srcRight", "srcBottom", "dstLeft", "dstTop", "dstRight", "dstBottom", "plugin-vlog_release"})
public final class j
{
  public static final void a(Matrix paramMatrix, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    AppMethodBeat.i(207516);
    k.h(paramMatrix, "$this$setRectToRectCenterCrop");
    a(paramMatrix, new RectF(0.0F, 0.0F, paramFloat1, paramFloat2), new RectF(paramFloat3, paramFloat4, paramFloat5, paramFloat6));
    AppMethodBeat.o(207516);
  }
  
  public static final void a(Matrix paramMatrix, RectF paramRectF1, RectF paramRectF2)
  {
    AppMethodBeat.i(207515);
    k.h(paramMatrix, "$this$setRectToRectCenterCrop");
    k.h(paramRectF1, "src");
    k.h(paramRectF2, "dst");
    paramMatrix.reset();
    float f = Math.max(paramRectF2.height() / paramRectF1.height(), paramRectF2.width() / paramRectF1.width());
    paramMatrix.postTranslate(-paramRectF1.centerX(), -paramRectF1.centerY());
    paramMatrix.postScale(f, f);
    paramMatrix.postTranslate(paramRectF2.centerX(), paramRectF2.centerY());
    AppMethodBeat.o(207515);
  }
  
  public static final void b(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(207517);
    k.h(paramRect, "$this$scaleBy");
    paramRect.left = Math.round(paramRect.left * paramFloat);
    paramRect.top = Math.round(paramRect.top * paramFloat);
    paramRect.right = Math.round(paramRect.right * paramFloat);
    paramRect.bottom = Math.round(paramRect.bottom * paramFloat);
    AppMethodBeat.o(207517);
  }
  
  public static final float e(Matrix paramMatrix)
  {
    AppMethodBeat.i(207514);
    k.h(paramMatrix, "$this$getScale");
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    float f1 = arrayOfFloat[0];
    float f2 = arrayOfFloat[3];
    f1 = (float)Math.sqrt(f2 * f2 + f1 * f1);
    AppMethodBeat.o(207514);
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.j
 * JD-Core Version:    0.7.0.1
 */