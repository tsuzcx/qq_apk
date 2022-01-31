package com.tencent.mm.ui.base;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.LineBackgroundSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.textview.b;

public final class c
  implements LineBackgroundSpan
{
  private final int color;
  private int end;
  private Rect rect;
  private int start;
  private View zhl;
  
  public c(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112502);
    this.zhl = paramView;
    this.color = paramInt1;
    this.start = paramInt2;
    this.end = paramInt3;
    this.rect = new Rect();
    AppMethodBeat.o(112502);
  }
  
  public final void drawBackground(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(112503);
    if (this.end < paramInt6)
    {
      AppMethodBeat.o(112503);
      return;
    }
    if (this.start > paramInt7)
    {
      AppMethodBeat.o(112503);
      return;
    }
    int i = paramPaint.getColor();
    int k = b.av(this.zhl, this.start);
    int j = b.av(this.zhl, this.end);
    paramInt7 = paramInt1;
    paramInt5 = paramInt2;
    if (k <= paramInt8)
    {
      paramInt7 = paramInt1;
      paramInt5 = paramInt2;
      if (paramInt8 <= j)
      {
        if (k == paramInt8) {
          paramInt1 = (int)b.aw(this.zhl, this.start);
        }
        if (j != paramInt8) {
          break label267;
        }
        paramInt5 = (int)b.aw(this.zhl, this.end);
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
      paramPaint.setColor(this.color);
      paramCanvas.drawRect(this.rect, paramPaint);
      paramPaint.setColor(i);
      AppMethodBeat.o(112503);
      return;
      label267:
      paramInt5 = (int)b.az(this.zhl, paramInt8);
    }
  }
  
  public final void setPosition(int paramInt1, int paramInt2)
  {
    this.start = paramInt1;
    this.end = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.c
 * JD-Core Version:    0.7.0.1
 */