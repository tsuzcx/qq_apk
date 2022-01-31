package com.tencent.mm.ui.base;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LineBackgroundSpan;
import android.widget.TextView;

public final class c
  implements LineBackgroundSpan
{
  public int end;
  private final int mColor;
  private TextView mTE;
  private Rect rect;
  public int start;
  
  public c(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mColor = paramInt1;
    this.start = paramInt2;
    this.end = paramInt3;
    this.rect = new Rect();
    this.mTE = paramTextView;
  }
  
  public final void drawBackground(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.end < paramInt6) {}
    while (this.start > paramInt7) {
      return;
    }
    int i = paramPaint.getColor();
    paramCharSequence = this.mTE.getLayout();
    int k = paramCharSequence.getLineForOffset(this.start);
    int j = paramCharSequence.getLineForOffset(this.end);
    paramInt7 = paramInt1;
    paramInt5 = paramInt2;
    if (k <= paramInt8)
    {
      paramInt7 = paramInt1;
      paramInt5 = paramInt2;
      if (paramInt8 <= j)
      {
        if (k == paramInt8) {
          paramInt1 = (int)paramCharSequence.getPrimaryHorizontal(this.start);
        }
        if (j != paramInt8) {
          break label247;
        }
        paramInt5 = (int)paramCharSequence.getPrimaryHorizontal(this.end);
      }
    }
    for (paramInt7 = paramInt1;; paramInt7 = paramInt1)
    {
      paramInt1 = (int)(paramInt4 + paramPaint.descent());
      this.rect.left = paramInt7;
      if (this.start == paramInt6)
      {
        paramCharSequence = this.rect;
        paramCharSequence.left -= 4;
      }
      this.rect.right = paramInt5;
      if (this.end == paramInt5)
      {
        paramCharSequence = this.rect;
        paramCharSequence.right += 4;
      }
      this.rect.top = paramInt3;
      this.rect.bottom = paramInt1;
      paramPaint.setColor(this.mColor);
      paramCanvas.drawRect(this.rect, paramPaint);
      paramPaint.setColor(i);
      return;
      label247:
      paramInt5 = (int)paramCharSequence.getLineWidth(paramInt8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.c
 * JD-Core Version:    0.7.0.1
 */