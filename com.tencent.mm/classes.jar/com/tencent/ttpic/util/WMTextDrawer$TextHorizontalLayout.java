package com.tencent.ttpic.util;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.TextWMElement;
import java.util.ArrayList;
import java.util.Iterator;

class WMTextDrawer$TextHorizontalLayout
  extends WMTextDrawer.TextLayout
{
  public WMTextDrawer$TextHorizontalLayout(WMTextDrawer paramWMTextDrawer, TextWMElement paramTextWMElement, int paramInt1, int paramInt2, String paramString)
  {
    super(paramTextWMElement, paramInt1, paramInt2, paramString);
  }
  
  protected void drawText(Canvas paramCanvas)
  {
    AppMethodBeat.i(84280);
    this.mWMElement.mTextRect.set(this.mWMTokenizer.getTextRect());
    float f2 = this.mWMTokenizer.getFontHeight() / 2.0F;
    float f3 = (Math.abs(this.mPaint.ascent()) - this.mPaint.descent()) / 2.0F;
    Iterator localIterator = this.mWMTokenizer.getTokens().iterator();
    while (localIterator.hasNext())
    {
      WMTokenizer.Token localToken = (WMTokenizer.Token)localIterator.next();
      float[] arrayOfFloat = new float[localToken.text.length()];
      this.mPaint.getTextWidths(localToken.text, arrayOfFloat);
      float f1 = localToken.x;
      float f4 = localToken.y;
      int i = 0;
      while (i < localToken.text.length())
      {
        draw(paramCanvas, String.valueOf(localToken.text.charAt(i)), f1, f4 + (f2 + f3));
        f1 += arrayOfFloat[i] + this.mWMElement.kern;
        i += 1;
      }
    }
    AppMethodBeat.o(84280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.WMTextDrawer.TextHorizontalLayout
 * JD-Core Version:    0.7.0.1
 */