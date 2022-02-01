package com.tencent.mm.plugin.vlog.model;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"scaleRect", "", "origin", "Landroid/graphics/Rect;", "target", "getScale", "", "Landroid/graphics/Matrix;", "scaleBy", "scale", "setRectToRectCenterCrop", "src", "Landroid/graphics/RectF;", "dst", "srcLeft", "srcTop", "srcRight", "srcBottom", "dstLeft", "dstTop", "dstRight", "dstBottom", "plugin-vlog_release"})
public final class t
{
  public static final void a(Matrix paramMatrix, RectF paramRectF1, RectF paramRectF2)
  {
    AppMethodBeat.i(190589);
    p.h(paramMatrix, "$this$setRectToRectCenterCrop");
    p.h(paramRectF1, "src");
    p.h(paramRectF2, "dst");
    paramMatrix.reset();
    float f = Math.max(paramRectF2.height() / paramRectF1.height(), paramRectF2.width() / paramRectF1.width());
    paramMatrix.postTranslate(-paramRectF1.centerX(), -paramRectF1.centerY());
    paramMatrix.postScale(f, f);
    paramMatrix.postTranslate(paramRectF2.centerX(), paramRectF2.centerY());
    AppMethodBeat.o(190589);
  }
  
  public static final float e(Matrix paramMatrix)
  {
    AppMethodBeat.i(190588);
    p.h(paramMatrix, "$this$getScale");
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    float f1 = arrayOfFloat[0];
    float f2 = arrayOfFloat[3];
    f1 = (float)Math.sqrt(f2 * f2 + f1 * f1);
    AppMethodBeat.o(190588);
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.t
 * JD-Core Version:    0.7.0.1
 */