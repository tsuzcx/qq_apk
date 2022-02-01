package com.tencent.mm.plugin.recordvideo.ui.editor.view;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "Landroid/graphics/drawable/Drawable;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "basicScale", "", "framePadding", "frameRect", "frameStroke", "paint", "Landroid/graphics/Paint;", "getResources", "()Landroid/content/res/Resources;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "plugin-recordvideo_release"})
public final class a
  extends Drawable
{
  private final Resources aKG;
  private final float pTA;
  private float pTx;
  private final float pTy;
  private final float pTz;
  private final Paint paint;
  
  public a(Resources paramResources)
  {
    AppMethodBeat.i(200853);
    this.aKG = paramResources;
    this.pTx = 2.0F;
    this.paint = new Paint();
    this.paint.setColor(-1);
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.aKG.getDimension(2131166188));
    this.paint.setStyle(Paint.Style.FILL);
    this.pTy = this.aKG.getDimension(2131166188);
    this.pTz = this.aKG.getDimension(2131166186);
    this.pTA = this.aKG.getDimension(2131166187);
    AppMethodBeat.o(200853);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(200852);
    p.h(paramCanvas, "canvas");
    float f1 = getBounds().left - this.pTz / this.pTx;
    float f2 = getBounds().top - this.pTz / this.pTx;
    float f3 = getBounds().right + this.pTz / this.pTx;
    float f4 = getBounds().bottom + this.pTz / this.pTx;
    this.paint.setStrokeWidth(this.pTy / this.pTx);
    this.paint.setAntiAlias(true);
    Paint localPaint = this.paint;
    paramCanvas.drawLines(new float[] { f1, f2, f3, f2, f3, f2, f3, f4, f3, f4, f1, f4, f1, f4, f1, f2 }, localPaint);
    AppMethodBeat.o(200852);
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