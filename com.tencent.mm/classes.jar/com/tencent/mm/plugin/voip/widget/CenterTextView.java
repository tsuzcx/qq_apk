package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/widget/CenterTextView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "myStaticLayout", "Landroid/text/StaticLayout;", "tp", "Landroid/text/TextPaint;", "initView", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "", "h", "oldw", "oldh", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CenterTextView
  extends TextView
{
  private StaticLayout UUT;
  private TextPaint UUU;
  
  public CenterTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(293477);
    AppMethodBeat.o(293477);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(293489);
    StaticLayout localStaticLayout = this.UUT;
    if (localStaticLayout != null) {
      localStaticLayout.draw(paramCanvas);
    }
    AppMethodBeat.o(293489);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(293484);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.UUU = new TextPaint(1);
    TextPaint localTextPaint = this.UUU;
    if (localTextPaint != null) {
      localTextPaint.setTextSize(getTextSize());
    }
    localTextPaint = this.UUU;
    if (localTextPaint != null) {
      localTextPaint.setColor(getCurrentTextColor());
    }
    this.UUT = new StaticLayout(getText(), this.UUU, getWidth(), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
    AppMethodBeat.o(293484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.CenterTextView
 * JD-Core Version:    0.7.0.1
 */