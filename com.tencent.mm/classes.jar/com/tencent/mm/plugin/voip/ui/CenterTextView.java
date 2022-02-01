package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/ui/CenterTextView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "myStaticLayout", "Landroid/text/StaticLayout;", "tp", "Landroid/text/TextPaint;", "initView", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "", "h", "oldw", "oldh", "plugin-voip_release"})
public final class CenterTextView
  extends TextView
{
  private StaticLayout NTs;
  private TextPaint NTt;
  
  public CenterTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(235062);
    AppMethodBeat.o(235062);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(235060);
    StaticLayout localStaticLayout = this.NTs;
    if (localStaticLayout != null)
    {
      localStaticLayout.draw(paramCanvas);
      AppMethodBeat.o(235060);
      return;
    }
    AppMethodBeat.o(235060);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(235059);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.NTt = new TextPaint(1);
    TextPaint localTextPaint = this.NTt;
    if (localTextPaint != null) {
      localTextPaint.setTextSize(getTextSize());
    }
    localTextPaint = this.NTt;
    if (localTextPaint != null) {
      localTextPaint.setColor(getCurrentTextColor());
    }
    this.NTs = new StaticLayout(getText(), this.NTt, getWidth(), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
    AppMethodBeat.o(235059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.CenterTextView
 * JD-Core Version:    0.7.0.1
 */