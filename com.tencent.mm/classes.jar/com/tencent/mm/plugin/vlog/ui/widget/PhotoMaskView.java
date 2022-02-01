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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoMaskView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "maskPaint", "Landroid/graphics/Paint;", "visibleRect", "Landroid/graphics/RectF;", "getVisibleRect", "()Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-vlog_release"})
public final class PhotoMaskView
  extends View
{
  private final Paint NGp;
  private final RectF Nmh;
  
  public PhotoMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(227789);
    this.Nmh = new RectF();
    this.NGp = new Paint();
    this.NGp.setColor(-16777216);
    this.NGp.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(227789);
  }
  
  public PhotoMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(227795);
    this.Nmh = new RectF();
    this.NGp = new Paint();
    this.NGp.setColor(-16777216);
    this.NGp.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(227795);
  }
  
  public final RectF getVisibleRect()
  {
    return this.Nmh;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(227784);
    super.onDraw(paramCanvas);
    if (!this.Nmh.isEmpty())
    {
      if (paramCanvas != null) {
        paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.Nmh.top, this.NGp);
      }
      if (paramCanvas != null)
      {
        paramCanvas.drawRect(0.0F, this.Nmh.bottom, getWidth(), getHeight(), this.NGp);
        AppMethodBeat.o(227784);
        return;
      }
    }
    AppMethodBeat.o(227784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.PhotoMaskView
 * JD-Core Version:    0.7.0.1
 */