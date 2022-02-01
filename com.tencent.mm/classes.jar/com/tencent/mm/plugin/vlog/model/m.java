package com.tencent.mm.plugin.vlog.model;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"scaleRect", "", "origin", "Landroid/graphics/Rect;", "target", "getScale", "", "Landroid/graphics/Matrix;", "scaleBy", "scale", "setRectToRectCenterCrop", "src", "Landroid/graphics/RectF;", "dst", "srcLeft", "srcTop", "srcRight", "srcBottom", "dstLeft", "dstTop", "dstRight", "dstBottom", "plugin-vlog_release"})
public final class m
{
  public static final void a(Matrix paramMatrix, RectF paramRectF1, RectF paramRectF2)
  {
    AppMethodBeat.i(191177);
    p.h(paramMatrix, "$this$setRectToRectCenterCrop");
    p.h(paramRectF1, "src");
    p.h(paramRectF2, "dst");
    paramMatrix.reset();
    float f = Math.max(paramRectF2.height() / paramRectF1.height(), paramRectF2.width() / paramRectF1.width());
    paramMatrix.postTranslate(-paramRectF1.centerX(), -paramRectF1.centerY());
    paramMatrix.postScale(f, f);
    paramMatrix.postTranslate(paramRectF2.centerX(), paramRectF2.centerY());
    AppMethodBeat.o(191177);
  }
  
  public static final float e(Matrix paramMatrix)
  {
    AppMethodBeat.i(191176);
    p.h(paramMatrix, "$this$getScale");
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    float f1 = arrayOfFloat[0];
    float f2 = arrayOfFloat[3];
    f1 = (float)Math.sqrt(f2 * f2 + f1 * f1);
    AppMethodBeat.o(191176);
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.m
 * JD-Core Version:    0.7.0.1
 */