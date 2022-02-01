package com.tencent.mm.ui.base;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LineBackgroundSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.textview.b;
import com.tencent.neattextview.textview.layout.a;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class c
  implements LineBackgroundSpan
{
  private View adOe;
  private final int color;
  private int end;
  private Rect rect;
  private int start;
  
  public c(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159148);
    this.adOe = paramView;
    this.color = paramInt1;
    this.start = paramInt2;
    this.end = paramInt3;
    this.rect = new Rect();
    AppMethodBeat.o(159148);
  }
  
  public final void drawBackground(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(159149);
    if (this.end < paramInt6)
    {
      AppMethodBeat.o(159149);
      return;
    }
    if (this.start > paramInt7)
    {
      AppMethodBeat.o(159149);
      return;
    }
    int i = paramPaint.getColor();
    int k = b.bw(this.adOe, this.start);
    int j = b.bw(this.adOe, this.end);
    paramInt7 = paramInt1;
    paramInt5 = paramInt2;
    float f;
    if (k <= paramInt8)
    {
      paramInt7 = paramInt1;
      paramInt5 = paramInt2;
      if (paramInt8 <= j)
      {
        if (k != paramInt8) {
          break label269;
        }
        f = b.bx(this.adOe, this.start);
        paramInt7 = (int)f;
        if (j != paramInt8) {
          break label360;
        }
      }
    }
    label269:
    label354:
    label360:
    for (paramInt5 = (int)b.bx(this.adOe, this.end);; paramInt5 = (int)b.bA(this.adOe, paramInt8) + paramInt7)
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
      AppMethodBeat.o(159149);
      return;
      paramCharSequence = this.adOe;
      if ((paramCharSequence instanceof NeatTextView))
      {
        paramCharSequence = ((NeatTextView)paramCharSequence).getLayout();
        if (paramCharSequence == null) {
          break label354;
        }
        f = paramCharSequence.dv(paramCharSequence.dk(paramInt8));
        break;
      }
      if ((paramCharSequence instanceof TextView))
      {
        paramCharSequence = ((TextView)paramCharSequence).getLayout();
        if (paramCharSequence != null)
        {
          f = paramCharSequence.getLineLeft(paramInt8);
          break;
        }
      }
      f = 0.0F;
      break;
    }
  }
  
  public final void od(int paramInt1, int paramInt2)
  {
    this.start = paramInt1;
    this.end = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.c
 * JD-Core Version:    0.7.0.1
 */