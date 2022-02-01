package com.tencent.mm.plugin.recordvideo.ui.editor.c;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/MatrixInterpolator;", "", "()V", "Companion", "plugin-recordvideo_release"})
public final class b
{
  public static final a CgU;
  
  static
  {
    AppMethodBeat.i(237929);
    CgU = new a((byte)0);
    AppMethodBeat.o(237929);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/MatrixInterpolator$Companion;", "", "()V", "clampScale", "", "matrix", "Landroid/graphics/Matrix;", "pivotSrc", "", "minScale", "", "maxScale", "getScale", "plugin-recordvideo_release"})
  public static final class a
  {
    public static void a(Matrix paramMatrix, float[] paramArrayOfFloat, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(237928);
      p.h(paramMatrix, "matrix");
      p.h(paramArrayOfFloat, "pivotSrc");
      p.h(paramMatrix, "matrix");
      float[] arrayOfFloat = new float[9];
      paramMatrix.getValues(arrayOfFloat);
      double d1 = arrayOfFloat[0];
      double d2 = arrayOfFloat[3];
      float f = (float)Math.sqrt(d2 * d2 + d1 * d1);
      if (f < paramFloat1) {}
      for (;;)
      {
        Object localObject = new Matrix();
        paramMatrix.invert((Matrix)localObject);
        arrayOfFloat = new float[2];
        ((Matrix)localObject).mapPoints(arrayOfFloat, paramArrayOfFloat);
        localObject = new float[9];
        paramMatrix.getValues((float[])localObject);
        d1 = localObject[0];
        d2 = localObject[3];
        double d3 = localObject[4];
        Math.sqrt(d1 * d1 + d2 * d2);
        paramFloat2 = (float)Math.round(Math.atan2(d2, d3) * 57.295779513082323D);
        paramMatrix.setTranslate(-arrayOfFloat[0], -arrayOfFloat[1]);
        paramMatrix.postScale(paramFloat1, paramFloat1);
        paramMatrix.postRotate(paramFloat2);
        paramMatrix.postTranslate(paramArrayOfFloat[0], paramArrayOfFloat[1]);
        AppMethodBeat.o(237928);
        return;
        if (f <= paramFloat2) {
          break;
        }
        paramFloat1 = paramFloat2;
      }
      AppMethodBeat.o(237928);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.c.b
 * JD-Core Version:    0.7.0.1
 */