package com.tencent.mm.plugin.recordvideo.ui.editor.view;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "Landroid/graphics/drawable/Drawable;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "basicScale", "", "framePadding", "frameRect", "frameStroke", "paint", "Landroid/graphics/Paint;", "getResources", "()Landroid/content/res/Resources;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "plugin-recordvideo_release"})
public final class a
  extends Drawable
{
  private final Resources aKy;
  private final Paint paint;
  private float rqZ;
  private final float rra;
  private final float rrb;
  private final float rrc;
  
  public a(Resources paramResources)
  {
    AppMethodBeat.i(237952);
    this.aKy = paramResources;
    this.rqZ = 2.0F;
    this.paint = new Paint();
    this.paint.setColor(-1);
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.aKy.getDimension(2131166229));
    this.paint.setStyle(Paint.Style.FILL);
    this.rra = this.aKy.getDimension(2131166229);
    this.rrb = this.aKy.getDimension(2131166227);
    this.rrc = this.aKy.getDimension(2131166228);
    AppMethodBeat.o(237952);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(237951);
    p.h(paramCanvas, "canvas");
    float f1 = getBounds().left - this.rrb / this.rqZ;
    float f2 = getBounds().top - this.rrb / this.rqZ;
    float f3 = getBounds().right + this.rrb / this.rqZ;
    float f4 = getBounds().bottom + this.rrb / this.rqZ;
    this.paint.setStrokeWidth(this.rra / this.rqZ);
    this.paint.setAntiAlias(true);
    Paint localPaint = this.paint;
    paramCanvas.drawLines(new float[] { f1, f2, f3, f2, f3, f2, f3, f4, f3, f4, f1, f4, f1, f4, f1, f2 }, localPaint);
    AppMethodBeat.o(237951);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.view.a
 * JD-Core Version:    0.7.0.1
 */