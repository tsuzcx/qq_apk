package com.tencent.ttpic.util;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.TextWMElement;
import java.util.ArrayList;
import java.util.Iterator;

class WMTextDrawer$TextVerticalLayout
  extends WMTextDrawer.TextLayout
{
  public WMTextDrawer$TextVerticalLayout(WMTextDrawer paramWMTextDrawer, TextWMElement paramTextWMElement, int paramInt1, int paramInt2, String paramString)
  {
    super(paramTextWMElement, paramInt1, paramInt2, paramString);
  }
  
  protected void drawText(Canvas paramCanvas)
  {
    AppMethodBeat.i(84281);
    this.mWMElement.mTextRect.set(this.mWMTokenizer.getTextRect());
    float f2 = this.mWMTokenizer.getFontHeight() / 2.0F;
    float f3 = (Math.abs(this.mPaint.ascent()) - this.mPaint.descent()) / 2.0F;
    paramCanvas.save();
    Iterator localIterator = this.mWMTokenizer.getTokens().iterator();
    while (localIterator.hasNext())
    {
      WMTokenizer.Token localToken = (WMTokenizer.Token)localIterator.next();
      float f4 = localToken.x;
      float f1 = localToken.y + (f2 + f3);
      int i = 0;
      while (i < localToken.text.length())
      {
        draw(paramCanvas, String.valueOf(localToken.text.charAt(i)), f4, f1);
        f1 += this.mWMTokenizer.getFontHeight();
        i += 1;
      }
    }
    paramCanvas.restore();
    AppMethodBeat.o(84281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.WMTextDrawer.TextVerticalLayout
 * JD-Core Version:    0.7.0.1
 */