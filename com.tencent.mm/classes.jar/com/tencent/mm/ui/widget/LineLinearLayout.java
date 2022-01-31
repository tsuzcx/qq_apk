package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public class LineLinearLayout
  extends LinearLayout
{
  private int ACm;
  private Paint mPaint;
  private Rect mRect;
  
  public LineLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LineLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107861);
    setWillNotDraw(false);
    this.mRect = new Rect();
    this.mPaint = new Paint();
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setColor(-571543826);
    this.mPaint.setStrokeWidth(Math.round(a.getDensity(getContext()) * 0.5F));
    this.ACm = a.fromDPToPix(paramContext, 44);
    AppMethodBeat.o(107861);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(107862);
    int j = getMeasuredHeight();
    Paint localPaint = this.mPaint;
    int i = 1;
    while (this.ACm * i < j)
    {
      paramCanvas.drawLine(0.0F, this.ACm * i, getMeasuredWidth(), this.ACm * i, localPaint);
      i += 1;
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(107862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.LineLinearLayout
 * JD-Core Version:    0.7.0.1
 */