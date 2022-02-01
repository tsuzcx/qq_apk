package com.tencent.mm.plugin.vlog.model;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"scaleRect", "", "origin", "Landroid/graphics/Rect;", "target", "getScale", "", "Landroid/graphics/Matrix;", "scaleBy", "scale", "setRectToRectCenterCrop", "src", "Landroid/graphics/RectF;", "dst", "srcLeft", "srcTop", "srcRight", "srcBottom", "dstLeft", "dstTop", "dstRight", "dstBottom", "plugin-vlog_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class t
{
  public static final void a(Matrix paramMatrix, RectF paramRectF1, RectF paramRectF2)
  {
    AppMethodBeat.i(283403);
    s.u(paramMatrix, "<this>");
    s.u(paramRectF1, "src");
    s.u(paramRectF2, "dst");
    paramMatrix.reset();
    float f = Math.max(paramRectF2.height() / paramRectF1.height(), paramRectF2.width() / paramRectF1.width());
    paramMatrix.postTranslate(-paramRectF1.centerX(), -paramRectF1.centerY());
    paramMatrix.postScale(f, f);
    paramMatrix.postTranslate(paramRectF2.centerX(), paramRectF2.centerY());
    AppMethodBeat.o(283403);
  }
  
  public static final float g(Matrix paramMatrix)
  {
    AppMethodBeat.i(283394);
    s.u(paramMatrix, "<this>");
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    float f1 = arrayOfFloat[0];
    float f2 = arrayOfFloat[3];
    f1 = (float)Math.sqrt(f2 * f2 + f1 * f1);
    AppMethodBeat.o(283394);
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.t
 * JD-Core Version:    0.7.0.1
 */