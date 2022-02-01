package com.tencent.mm.plugin.vlog.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/widget/FinderPreviewView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "borderPaint", "Landroid/graphics/Paint;", "linePaint", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-vlog_release"})
public final class FinderPreviewView
  extends View
{
  private final Paint GQi;
  private final Paint borderPaint;
  
  public FinderPreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192170);
    this.borderPaint = new Paint();
    this.GQi = new Paint();
    this.borderPaint.setColor(-1);
    this.borderPaint.setAntiAlias(true);
    this.borderPaint.setStrokeWidth(a.fromDPToPix(getContext(), 2));
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.GQi.setColor(Color.parseColor("#4DFFFFFF"));
    this.GQi.setAntiAlias(true);
    this.GQi.setStrokeWidth(a.fromDPToPix(getContext(), 1));
    this.GQi.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(192170);
  }
  
  public FinderPreviewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192171);
    this.borderPaint = new Paint();
    this.GQi = new Paint();
    this.borderPaint.setColor(-1);
    this.borderPaint.setAntiAlias(true);
    this.borderPaint.setStrokeWidth(a.fromDPToPix(getContext(), 2));
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.GQi.setColor(Color.parseColor("#4DFFFFFF"));
    this.GQi.setAntiAlias(true);
    this.GQi.setStrokeWidth(a.fromDPToPix(getContext(), 1));
    this.GQi.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(192171);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(192169);
    p.h(paramCanvas, "canvas");
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.borderPaint);
    int i = 1;
    while (i <= 2)
    {
      float f1 = getHeight() * i / 3.0F;
      float f2 = getWidth() * i / 3.0F;
      paramCanvas.drawLine(0.0F, f1, getWidth(), f1, this.GQi);
      paramCanvas.drawLine(f2, 0.0F, f2, getHeight(), this.GQi);
      i += 1;
    }
    AppMethodBeat.o(192169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.FinderPreviewView
 * JD-Core Version:    0.7.0.1
 */