package com.tencent.youtu.ytagreflectlivecheck.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class YTReflectLayout
  extends RelativeLayout
{
  private static String TAG = "YTReflectLayout";
  private ColorMatrixColorFilter mColorMatrixColorFilter;
  private Paint mPaint;
  private Rect mRect;
  
  public YTReflectLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(43406);
    this.mRect = new Rect();
    this.mPaint = new Paint(1);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(Color.argb(200, 0, 0, 0));
    this.mColorMatrixColorFilter = new ColorMatrixColorFilter(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
    setWillNotDraw(false);
    AppMethodBeat.o(43406);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(43408);
    super.onDraw(paramCanvas);
    this.mPaint.setColorFilter(this.mColorMatrixColorFilter);
    this.mRect.set(0, 0, getWidth(), getHeight());
    paramCanvas.drawRect(this.mRect, this.mPaint);
    AppMethodBeat.o(43408);
  }
  
  public void setColorMatrixColorFilter(ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    AppMethodBeat.i(43407);
    this.mColorMatrixColorFilter = paramColorMatrixColorFilter;
    invalidate();
    AppMethodBeat.o(43407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout
 * JD-Core Version:    0.7.0.1
 */