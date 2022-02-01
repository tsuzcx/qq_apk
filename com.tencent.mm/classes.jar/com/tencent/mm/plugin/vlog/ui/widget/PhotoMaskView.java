package com.tencent.mm.plugin.vlog.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoMaskView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "maskPaint", "Landroid/graphics/Paint;", "visibleRect", "Landroid/graphics/RectF;", "getVisibleRect", "()Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-vlog_release"})
public final class PhotoMaskView
  extends View
{
  private final Paint GQz;
  private final RectF GyF;
  
  public PhotoMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192214);
    this.GyF = new RectF();
    this.GQz = new Paint();
    this.GQz.setColor(-16777216);
    this.GQz.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(192214);
  }
  
  public PhotoMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192215);
    this.GyF = new RectF();
    this.GQz = new Paint();
    this.GQz.setColor(-16777216);
    this.GQz.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(192215);
  }
  
  public final RectF getVisibleRect()
  {
    return this.GyF;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(192213);
    super.onDraw(paramCanvas);
    if (!this.GyF.isEmpty())
    {
      if (paramCanvas != null) {
        paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.GyF.top, this.GQz);
      }
      if (paramCanvas != null)
      {
        paramCanvas.drawRect(0.0F, this.GyF.bottom, getWidth(), getHeight(), this.GQz);
        AppMethodBeat.o(192213);
        return;
      }
    }
    AppMethodBeat.o(192213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.PhotoMaskView
 * JD-Core Version:    0.7.0.1
 */