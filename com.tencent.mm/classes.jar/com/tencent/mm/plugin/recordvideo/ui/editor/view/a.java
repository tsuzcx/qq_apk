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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "Landroid/graphics/drawable/Drawable;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "basicScale", "", "framePadding", "frameRect", "frameStroke", "paint", "Landroid/graphics/Paint;", "getResources", "()Landroid/content/res/Resources;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends Drawable
{
  private final Resources oJY;
  private final Paint paint;
  private float yje;
  private final float yjf;
  private final float yjg;
  private final float yjh;
  
  public a(Resources paramResources)
  {
    AppMethodBeat.i(280010);
    this.oJY = paramResources;
    this.yje = 2.0F;
    this.paint = new Paint();
    this.paint.setColor(-1);
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.oJY.getDimension(a.a.editor_item_frame_stroke));
    this.paint.setStyle(Paint.Style.FILL);
    this.yjf = this.oJY.getDimension(a.a.editor_item_frame_stroke);
    this.yjg = this.oJY.getDimension(a.a.editor_item_frame_padding);
    this.yjh = this.oJY.getDimension(a.a.editor_item_frame_rect);
    AppMethodBeat.o(280010);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(280017);
    s.u(paramCanvas, "canvas");
    float f1 = getBounds().left - this.yjg / this.yje;
    float f2 = getBounds().top - this.yjg / this.yje;
    float f3 = getBounds().right + this.yjg / this.yje;
    float f4 = getBounds().bottom + this.yjg / this.yje;
    this.paint.setStrokeWidth(this.yjf / this.yje);
    this.paint.setAntiAlias(true);
    Paint localPaint = this.paint;
    paramCanvas.drawLines(new float[] { f1, f2, f3, f2, f3, f2, f3, f4, f3, f4, f1, f4, f1, f4, f1, f2 }, localPaint);
    AppMethodBeat.o(280017);
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