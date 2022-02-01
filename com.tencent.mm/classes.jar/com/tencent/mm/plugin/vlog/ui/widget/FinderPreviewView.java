package com.tencent.mm.plugin.vlog.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/widget/FinderPreviewView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "borderPaint", "Landroid/graphics/Paint;", "linePaint", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderPreviewView
  extends View
{
  private final Paint Usf;
  private final Paint uMn;
  
  public FinderPreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(281813);
    this.uMn = new Paint();
    this.Usf = new Paint();
    this.uMn.setColor(-1);
    this.uMn.setAntiAlias(true);
    this.uMn.setStrokeWidth(a.fromDPToPix(getContext(), 2));
    this.uMn.setStyle(Paint.Style.STROKE);
    this.Usf.setColor(Color.parseColor("#4DFFFFFF"));
    this.Usf.setAntiAlias(true);
    this.Usf.setStrokeWidth(a.fromDPToPix(getContext(), 1));
    this.Usf.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(281813);
  }
  
  public FinderPreviewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(281823);
    this.uMn = new Paint();
    this.Usf = new Paint();
    this.uMn.setColor(-1);
    this.uMn.setAntiAlias(true);
    this.uMn.setStrokeWidth(a.fromDPToPix(getContext(), 2));
    this.uMn.setStyle(Paint.Style.STROKE);
    this.Usf.setColor(Color.parseColor("#4DFFFFFF"));
    this.Usf.setAntiAlias(true);
    this.Usf.setStrokeWidth(a.fromDPToPix(getContext(), 1));
    this.Usf.setStyle(Paint.Style.STROKE);
    AppMethodBeat.o(281823);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(281834);
    s.u(paramCanvas, "canvas");
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.uMn);
    int j;
    for (int i = 1;; i = j)
    {
      j = i + 1;
      float f1 = getHeight() * i / 3.0F;
      float f2 = getWidth();
      f2 = i * f2 / 3.0F;
      paramCanvas.drawLine(0.0F, f1, getWidth(), f1, this.Usf);
      paramCanvas.drawLine(f2, 0.0F, f2, getHeight(), this.Usf);
      if (j > 2)
      {
        AppMethodBeat.o(281834);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.FinderPreviewView
 * JD-Core Version:    0.7.0.1
 */