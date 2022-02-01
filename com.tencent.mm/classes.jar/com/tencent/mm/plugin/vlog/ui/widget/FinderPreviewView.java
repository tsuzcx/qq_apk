package com.tencent.mm.plugin.vlog.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/widget/FinderPreviewView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "borderPaint", "Landroid/graphics/Paint;", "linePaint", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-vlog_release"})
public final class FinderPreviewView
  extends View
{
  private final Paint NFZ;
  private final Paint borderPaint;
  
  public FinderPreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(227168);
    this.borderPaint = new Paint();
    this.NFZ = new Paint();
    this.borderPaint.setColor(-1);
    this.borderPaint.setAntiAlias(true);
    this.borderPaint.setStrokeWidth(a.fromDPToPix(getContext(), 2));
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.NFZ.setColor(Color.parseColor("#4DFFFFFF"));
    this.NFZ.setAntiAlias(true);
    this.NFZ.setStrokeWidth(a.fromDPToPix(getContext(), 1));
    this.NFZ.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(227168);
  }
  
  public FinderPreviewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(227176);
    this.borderPaint = new Paint();
    this.NFZ = new Paint();
    this.borderPaint.setColor(-1);
    this.borderPaint.setAntiAlias(true);
    this.borderPaint.setStrokeWidth(a.fromDPToPix(getContext(), 2));
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.NFZ.setColor(Color.parseColor("#4DFFFFFF"));
    this.NFZ.setAntiAlias(true);
    this.NFZ.setStrokeWidth(a.fromDPToPix(getContext(), 1));
    this.NFZ.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(227176);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(227159);
    p.k(paramCanvas, "canvas");
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.borderPaint);
    int i = 1;
    while (i <= 2)
    {
      float f1 = getHeight() * i / 3.0F;
      float f2 = getWidth() * i / 3.0F;
      paramCanvas.drawLine(0.0F, f1, getWidth(), f1, this.NFZ);
      paramCanvas.drawLine(f2, 0.0F, f2, getHeight(), this.NFZ);
      i += 1;
    }
    AppMethodBeat.o(227159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.FinderPreviewView
 * JD-Core Version:    0.7.0.1
 */