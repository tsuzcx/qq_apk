package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.a.a;

public class MMVerticalTextView
  extends View
{
  private int direction;
  private TextPaint hB;
  private String mText;
  Rect znf;
  
  public MMVerticalTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106889);
    this.znf = new Rect();
    this.hB = new TextPaint();
    this.hB.setAntiAlias(true);
    this.hB.setTextSize(15.0F);
    this.hB.setColor(-16777216);
    this.hB.setTextAlign(Paint.Align.CENTER);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.verticaltextview);
    int i = paramAttributeSet.getResourceId(0, 0);
    if (i != 0) {
      this.mText = paramContext.getString(i);
    }
    i = paramAttributeSet.getDimensionPixelOffset(2, 15);
    if (i > 0) {
      this.hB.setTextSize(i);
    }
    this.hB.setColor(paramAttributeSet.getColor(1, -16777216));
    this.direction = paramAttributeSet.getInt(3, 0);
    boolean bool = paramAttributeSet.getBoolean(4, false);
    this.hB.setFakeBoldText(bool);
    paramAttributeSet.recycle();
    requestLayout();
    invalidate();
    AppMethodBeat.o(106889);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(106894);
    super.onDraw(paramCanvas);
    int i = getHeight();
    Path localPath = new Path();
    int j;
    if (this.direction == 0)
    {
      j = (getWidth() >> 1) - (this.znf.height() >> 1);
      localPath.moveTo(j, 0.0F);
      localPath.lineTo(j, i);
    }
    for (;;)
    {
      paramCanvas.drawTextOnPath(this.mText, localPath, 0.0F, 0.0F, this.hB);
      AppMethodBeat.o(106894);
      return;
      j = (getWidth() >> 1) + (this.znf.height() >> 1);
      localPath.moveTo(j, i);
      localPath.lineTo(j, 0.0F);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106893);
    this.hB.getTextBounds(this.mText, 0, this.mText.length(), this.znf);
    int j = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (j == 1073741824) {}
    for (;;)
    {
      j = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      if (j == 1073741824) {}
      int i;
      for (;;)
      {
        setMeasuredDimension(paramInt1, paramInt2);
        AppMethodBeat.o(106893);
        return;
        i = this.znf.height();
        if (j != -2147483648) {
          break label138;
        }
        paramInt1 = Math.min(i, paramInt1);
        break;
        i = (int)Math.ceil(this.hB.measureText(this.mText));
        if (j == -2147483648) {
          paramInt2 = Math.min(i, paramInt2);
        } else {
          paramInt2 = i;
        }
      }
      label138:
      paramInt1 = i;
    }
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(106890);
    this.mText = paramString;
    requestLayout();
    invalidate();
    AppMethodBeat.o(106890);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(106892);
    this.hB.setColor(paramInt);
    invalidate();
    AppMethodBeat.o(106892);
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(106891);
    this.hB.setTextSize(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(106891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMVerticalTextView
 * JD-Core Version:    0.7.0.1
 */