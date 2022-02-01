package com.tencent.mm.plugin.recordvideo.ui.editor.view;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.t.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "Landroid/graphics/drawable/Drawable;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "basicScale", "", "framePadding", "frameRect", "frameStroke", "paint", "Landroid/graphics/Paint;", "getResources", "()Landroid/content/res/Resources;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "plugin-recordvideo_release"})
public final class a
  extends Drawable
{
  private final Resources lRm;
  private final Paint paint;
  private float uWF;
  private final float uWG;
  private final float uWH;
  private final float uWI;
  
  public a(Resources paramResources)
  {
    AppMethodBeat.i(221107);
    this.lRm = paramResources;
    this.uWF = 2.0F;
    this.paint = new Paint();
    this.paint.setColor(-1);
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.lRm.getDimension(a.a.editor_item_frame_stroke));
    this.paint.setStyle(Paint.Style.FILL);
    this.uWG = this.lRm.getDimension(a.a.editor_item_frame_stroke);
    this.uWH = this.lRm.getDimension(a.a.editor_item_frame_padding);
    this.uWI = this.lRm.getDimension(a.a.editor_item_frame_rect);
    AppMethodBeat.o(221107);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(221097);
    p.k(paramCanvas, "canvas");
    float f1 = getBounds().left - this.uWH / this.uWF;
    float f2 = getBounds().top - this.uWH / this.uWF;
    float f3 = getBounds().right + this.uWH / this.uWF;
    float f4 = getBounds().bottom + this.uWH / this.uWF;
    this.paint.setStrokeWidth(this.uWG / this.uWF);
    this.paint.setAntiAlias(true);
    Paint localPaint = this.paint;
    paramCanvas.drawLines(new float[] { f1, f2, f3, f2, f3, f2, f3, f4, f3, f4, f1, f4, f1, f4, f1, f2 }, localPaint);
    AppMethodBeat.o(221097);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.view.a
 * JD-Core Version:    0.7.0.1
 */