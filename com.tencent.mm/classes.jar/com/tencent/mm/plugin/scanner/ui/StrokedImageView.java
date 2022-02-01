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
import com.tencent.matrix.trace.core.AppMethodBeat;

public class StrokedImageView
  extends ImageView
{
  private int color;
  
  public StrokedImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51997);
    this.color = paramContext.getResources().getColor(2131100825);
    AppMethodBeat.o(51997);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(51998);
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
    AppMethodBeat.o(51998);
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.color = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.StrokedImageView
 * JD-Core Version:    0.7.0.1
 */