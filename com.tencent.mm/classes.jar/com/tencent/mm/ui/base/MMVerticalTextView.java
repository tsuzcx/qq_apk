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
import com.tencent.mm.ae.a.a;

public class MMVerticalTextView
  extends View
{
  Rect OTT;
  private TextPaint ayn;
  private int direction;
  private String mText;
  
  public MMVerticalTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142251);
    this.OTT = new Rect();
    this.ayn = new TextPaint();
    this.ayn.setAntiAlias(true);
    this.ayn.setTextSize(15.0F);
    this.ayn.setColor(-16777216);
    this.ayn.setTextAlign(Paint.Align.CENTER);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.verticaltextview);
    int i = paramAttributeSet.getResourceId(1, 0);
    if (i != 0) {
      this.mText = paramContext.getString(i);
    }
    i = paramAttributeSet.getDimensionPixelOffset(4, 15);
    if (i > 0) {
      this.ayn.setTextSize(i);
    }
    this.ayn.setColor(paramAttributeSet.getColor(3, -16777216));
    this.direction = paramAttributeSet.getInt(0, 0);
    boolean bool = paramAttributeSet.getBoolean(2, false);
    this.ayn.setFakeBoldText(bool);
    paramAttributeSet.recycle();
    requestLayout();
    invalidate();
    AppMethodBeat.o(142251);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142256);
    super.onDraw(paramCanvas);
    int i = getHeight();
    Path localPath = new Path();
    int j;
    if (this.direction == 0)
    {
      j = (getWidth() >> 1) - (this.OTT.height() >> 1);
      localPath.moveTo(j, 0.0F);
      localPath.lineTo(j, i);
    }
    for (;;)
    {
      paramCanvas.drawTextOnPath(this.mText, localPath, 0.0F, 0.0F, this.ayn);
      AppMethodBeat.o(142256);
      return;
      j = (getWidth() >> 1) + (this.OTT.height() >> 1);
      localPath.moveTo(j, i);
      localPath.lineTo(j, 0.0F);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142255);
    this.ayn.getTextBounds(this.mText, 0, this.mText.length(), this.OTT);
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
        AppMethodBeat.o(142255);
        return;
        i = this.OTT.height();
        if (j != -2147483648) {
          break label138;
        }
        paramInt1 = Math.min(i, paramInt1);
        break;
        i = (int)Math.ceil(this.ayn.measureText(this.mText));
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
  
  public void setMediumBold(boolean paramBoolean)
  {
    AppMethodBeat.i(205252);
    this.ayn.setFakeBoldText(paramBoolean);
    AppMethodBeat.o(205252);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(142252);
    this.mText = paramString;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142252);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(142254);
    this.ayn.setColor(paramInt);
    invalidate();
    AppMethodBeat.o(142254);
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(142253);
    this.ayn.setTextSize(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(142253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMVerticalTextView
 * JD-Core Version:    0.7.0.1
 */