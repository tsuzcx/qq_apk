package com.tencent.mm.plugin.vlog.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoMaskView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "maskPaint", "Landroid/graphics/Paint;", "visibleRect", "Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setVisibleRect", "rect", "Landroid/graphics/Rect;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PhotoMaskView
  extends View
{
  private final RectF TZN;
  private final Paint Usu;
  
  public PhotoMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(281808);
    this.TZN = new RectF();
    this.Usu = new Paint();
    this.Usu.setColor(-16777216);
    this.Usu.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(281808);
  }
  
  public PhotoMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(281818);
    this.TZN = new RectF();
    this.Usu = new Paint();
    this.Usu.setColor(-16777216);
    this.Usu.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(281818);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(281840);
    super.onDraw(paramCanvas);
    if (!this.TZN.isEmpty())
    {
      if (paramCanvas != null) {
        paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.TZN.top, this.Usu);
      }
      if (paramCanvas != null) {
        paramCanvas.drawRect(0.0F, this.TZN.bottom, getWidth(), getHeight(), this.Usu);
      }
    }
    AppMethodBeat.o(281840);
  }
  
  public final void setVisibleRect(Rect paramRect)
  {
    AppMethodBeat.i(281835);
    s.u(paramRect, "rect");
    this.TZN.set(paramRect);
    invalidate();
    AppMethodBeat.o(281835);
  }
  
  public final void setVisibleRect(RectF paramRectF)
  {
    AppMethodBeat.i(281826);
    s.u(paramRectF, "rect");
    this.TZN.set(paramRectF);
    invalidate();
    AppMethodBeat.o(281826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.PhotoMaskView
 * JD-Core Version:    0.7.0.1
 */