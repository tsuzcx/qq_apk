package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.platformtools.b.a;

public class BorderNumView
  extends View
{
  private static int uHt = 22;
  private static int uHu = 105;
  private static int uHv = 100;
  private Context context = null;
  private Paint mPaint;
  private int uHs = 100;
  
  public BorderNumView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    init();
  }
  
  public BorderNumView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    init();
  }
  
  private void init()
  {
    this.mPaint = new Paint();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.uHs < 100) {
      uHt += 15;
    }
    if (this.uHs >= 1000) {
      uHv -= 20;
    }
    float f1 = b.a.b(this.context, uHt);
    float f2 = b.a.b(this.context, uHu);
    String str = this.uHs;
    this.mPaint.setAntiAlias(true);
    this.mPaint.setTextSize(uHv);
    this.mPaint.setColor(-11491572);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(8.0F);
    paramCanvas.drawText(str, f1, f2, this.mPaint);
    this.mPaint.setTextSize(uHv);
    this.mPaint.setColor(-1770573);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setStrokeWidth(8.0F);
    paramCanvas.drawText(str, f1, f2, this.mPaint);
  }
  
  public void setPaintNum(int paramInt)
  {
    this.uHs = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.BorderNumView
 * JD-Core Version:    0.7.0.1
 */