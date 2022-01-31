package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class m
  implements LeadingMarginSpan, f<Boolean>, g<Boolean>
{
  public static float vBh = 0.0F;
  private float mWidth;
  private float nEC;
  private final int vAX;
  public boolean vAY;
  private final int vBg;
  
  private m(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.nEC = 10.0F;
    this.vBg = paramInt1;
    this.vAX = paramInt2;
    this.vAY = paramBoolean;
  }
  
  public m(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(26954);
    this.nEC = 10.0F;
    this.vBg = paramInt1;
    this.vAX = paramInt2;
    if ((paramBoolean1) && (paramBoolean3) && (!paramBoolean2)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.vAY = paramBoolean1;
      AppMethodBeat.o(26954);
      return;
    }
  }
  
  public void drawLeadingMargin(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, boolean paramBoolean, Layout paramLayout)
  {
    AppMethodBeat.i(26956);
    paramCharSequence = (Spanned)paramCharSequence;
    if ((!this.vAY) && (paramCharSequence.getSpanStart(this) == paramInt6))
    {
      paramCharSequence = paramPaint.getStyle();
      float f = paramPaint.getTextSize();
      paramPaint.setStyle(Paint.Style.FILL);
      this.nEC = (paramInt4 - paramInt3);
      this.mWidth = paramPaint.measureText(this.vBg + ".");
      paramCanvas.drawText(this.vBg + ".", paramInt1, paramInt4, paramPaint);
      paramPaint.setStyle(paramCharSequence);
      paramPaint.setTextSize(f);
    }
    AppMethodBeat.o(26956);
  }
  
  public int getLeadingMargin(boolean paramBoolean)
  {
    AppMethodBeat.i(26955);
    if (this.mWidth + 2.0F > vBh) {}
    for (float f = this.mWidth + 2.0F;; f = vBh)
    {
      vBh = Math.max(Math.round(f), this.vAX);
      if (!this.vAY) {
        break;
      }
      AppMethodBeat.o(26955);
      return 0;
    }
    int i = (int)vBh;
    AppMethodBeat.o(26955);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.m
 * JD-Core Version:    0.7.0.1
 */