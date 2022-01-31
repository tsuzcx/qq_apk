package com.tencent.mm.plugin.scanner.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.R.e;

public class StrokedImageView
  extends ImageView
{
  private int color;
  
  public StrokedImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.color = paramContext.getResources().getColor(R.e.scan_product_img_stroke_color);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Rect localRect = paramCanvas.getClipBounds();
    localRect.left += 1;
    localRect.top += 1;
    localRect.bottom -= 1;
    localRect.right -= 1;
    Paint localPaint = new Paint();
    localPaint.setColor(this.color);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setAntiAlias(true);
    localPaint.setStrokeWidth(1.5F);
    paramCanvas.drawRect(localRect, localPaint);
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.color = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.StrokedImageView
 * JD-Core Version:    0.7.0.1
 */