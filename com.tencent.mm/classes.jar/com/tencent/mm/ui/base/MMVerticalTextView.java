package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.m;

public class MMVerticalTextView
  extends View
{
  Rect adUu;
  private int adUv;
  private int direction;
  private String mText;
  private TextPaint xe;
  
  public MMVerticalTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142251);
    this.adUu = new Rect();
    this.adUv = 0;
    this.xe = new TextPaint();
    this.xe.setAntiAlias(true);
    this.xe.setTextSize(15.0F);
    this.xe.setColor(-16777216);
    this.xe.setTextAlign(Paint.Align.CENTER);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.verticaltextview);
    int i = paramAttributeSet.getResourceId(a.m.verticaltextview_text, 0);
    if (i != 0) {
      this.mText = paramContext.getString(i);
    }
    i = paramAttributeSet.getDimensionPixelOffset(a.m.verticaltextview_textSize, 15);
    if (i > 0) {
      this.xe.setTextSize(i);
    }
    this.xe.setColor(paramAttributeSet.getColor(a.m.verticaltextview_textColor, -16777216));
    this.direction = paramAttributeSet.getInt(a.m.verticaltextview_direction, 0);
    boolean bool = paramAttributeSet.getBoolean(a.m.verticaltextview_textBold, false);
    this.xe.setFakeBoldText(bool);
    paramAttributeSet.recycle();
    requestLayout();
    invalidate();
    AppMethodBeat.o(142251);
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(251303);
    float f = this.xe.getTextSize();
    AppMethodBeat.o(251303);
    return f;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142256);
    super.onDraw(paramCanvas);
    int i = 0;
    int j = getHeight();
    Path localPath = new Path();
    if (this.direction == 0)
    {
      i = (getWidth() - this.adUu.height()) / 2;
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(0.0F, j);
    }
    for (;;)
    {
      paramCanvas.drawTextOnPath(this.mText, localPath, 0.0F, -i, this.xe);
      AppMethodBeat.o(142256);
      return;
      int k = (getWidth() >> 1) + (this.adUu.height() >> 1);
      localPath.moveTo(k, j);
      localPath.lineTo(k, 0.0F);
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(251315);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if (this.adUv == 0)
    {
      paramAccessibilityNodeInfo.setClassName("android.widget.TextView");
      AppMethodBeat.o(251315);
      return;
    }
    if (this.adUv == 1) {
      paramAccessibilityNodeInfo.setClassName("android.widget.Button");
    }
    AppMethodBeat.o(251315);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142255);
    this.xe.getTextBounds(this.mText, 0, this.mText.length(), this.adUu);
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
        i = (int)(this.xe.getFontMetrics().bottom - this.xe.getFontMetrics().top);
        if (j != -2147483648) {
          break label153;
        }
        paramInt1 = Math.min(i, paramInt1);
        break;
        i = (int)Math.ceil(this.xe.measureText(this.mText));
        if (j == -2147483648) {
          paramInt2 = Math.min(i, paramInt2);
        } else {
          paramInt2 = i;
        }
      }
      label153:
      paramInt1 = i;
    }
  }
  
  public void setAccessibilityViewType(int paramInt)
  {
    this.adUv = paramInt;
  }
  
  public void setMediumBold(boolean paramBoolean)
  {
    AppMethodBeat.i(251305);
    this.xe.setFakeBoldText(paramBoolean);
    AppMethodBeat.o(251305);
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
    this.xe.setColor(paramInt);
    invalidate();
    AppMethodBeat.o(142254);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(251299);
    this.xe.setTextSize(paramFloat);
    requestLayout();
    invalidate();
    AppMethodBeat.o(251299);
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(142253);
    this.xe.setTextSize(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(142253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMVerticalTextView
 * JD-Core Version:    0.7.0.1
 */