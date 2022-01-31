package com.tencent.neattextview.textview.b;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class c
  extends b<ClickableSpan>
{
  public boolean mmZ;
  
  public c(int paramInt1, int paramInt2, ClickableSpan paramClickableSpan)
  {
    super(paramInt1, paramInt2, paramClickableSpan);
  }
  
  public final void a(Canvas paramCanvas, TextPaint paramTextPaint, List<com.tencent.neattextview.textview.layout.c> paramList)
  {
    ev(paramList);
    if (this.mmZ)
    {
      int i = paramTextPaint.getColor();
      int j = paramTextPaint.bgColor;
      boolean bool = paramTextPaint.isUnderlineText();
      ((ClickableSpan)this.wDz).updateDrawState(paramTextPaint);
      paramTextPaint.setColor(paramTextPaint.bgColor);
      paramList = this.wDy.iterator();
      while (paramList.hasNext()) {
        paramCanvas.drawRect((RectF)paramList.next(), paramTextPaint);
      }
      paramTextPaint.setColor(i);
      paramTextPaint.setUnderlineText(bool);
      paramTextPaint.bgColor = j;
      this.mmZ = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.b.c
 * JD-Core Version:    0.7.0.1
 */