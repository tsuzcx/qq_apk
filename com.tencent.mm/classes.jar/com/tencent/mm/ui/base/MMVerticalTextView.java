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
import com.tencent.mm.ac.a.m;

public class MMVerticalTextView
  extends View
{
  private int direction;
  private TextPaint gI = new TextPaint();
  private String hnV;
  Rect uYN = new Rect();
  
  public MMVerticalTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.gI.setAntiAlias(true);
    this.gI.setTextSize(15.0F);
    this.gI.setColor(-16777216);
    this.gI.setTextAlign(Paint.Align.CENTER);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.verticaltextview);
    int i = paramAttributeSet.getResourceId(a.m.verticaltextview_text, 0);
    if (i != 0) {
      this.hnV = paramContext.getString(i);
    }
    i = paramAttributeSet.getDimensionPixelOffset(a.m.verticaltextview_textSize, 15);
    if (i > 0) {
      this.gI.setTextSize(i);
    }
    this.gI.setColor(paramAttributeSet.getColor(a.m.verticaltextview_textColor, -16777216));
    this.direction = paramAttributeSet.getInt(a.m.verticaltextview_direction, 0);
    boolean bool = paramAttributeSet.getBoolean(a.m.verticaltextview_textBold, false);
    this.gI.setFakeBoldText(bool);
    paramAttributeSet.recycle();
    requestLayout();
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    Path localPath = new Path();
    int j;
    if (this.direction == 0)
    {
      j = (getWidth() >> 1) - (this.uYN.height() >> 1);
      localPath.moveTo(j, 0.0F);
      localPath.lineTo(j, i);
    }
    for (;;)
    {
      paramCanvas.drawTextOnPath(this.hnV, localPath, 0.0F, 0.0F, this.gI);
      return;
      j = (getWidth() >> 1) + (this.uYN.height() >> 1);
      localPath.moveTo(j, i);
      localPath.lineTo(j, 0.0F);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.gI.getTextBounds(this.hnV, 0, this.hnV.length(), this.uYN);
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
        return;
        i = this.uYN.height();
        if (j != -2147483648) {
          break label119;
        }
        paramInt1 = Math.min(i, paramInt1);
        break;
        i = this.uYN.width();
        if (j == -2147483648) {
          paramInt2 = Math.min(i, paramInt2);
        } else {
          paramInt2 = i;
        }
      }
      label119:
      paramInt1 = i;
    }
  }
  
  public void setText(String paramString)
  {
    this.hnV = paramString;
    requestLayout();
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.gI.setColor(paramInt);
    invalidate();
  }
  
  public void setTextSize(int paramInt)
  {
    this.gI.setTextSize(paramInt);
    requestLayout();
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMVerticalTextView
 * JD-Core Version:    0.7.0.1
 */