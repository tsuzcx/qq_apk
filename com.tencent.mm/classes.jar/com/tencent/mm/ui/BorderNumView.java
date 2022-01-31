package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.b.a;

public class BorderNumView
  extends View
{
  private static int yUE = 22;
  private static int yUF = 105;
  private static int yUG = 100;
  private Context context;
  private Paint mPaint;
  private int yUD;
  
  public BorderNumView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29137);
    this.context = null;
    this.yUD = 100;
    this.context = paramContext;
    init();
    AppMethodBeat.o(29137);
  }
  
  public BorderNumView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29138);
    this.context = null;
    this.yUD = 100;
    this.context = paramContext;
    init();
    AppMethodBeat.o(29138);
  }
  
  private void init()
  {
    AppMethodBeat.i(29139);
    this.mPaint = new Paint();
    AppMethodBeat.o(29139);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(29140);
    super.onDraw(paramCanvas);
    if (this.yUD < 100) {
      yUE += 15;
    }
    if (this.yUD >= 1000) {
      yUG -= 20;
    }
    float f1 = b.a.b(this.context, yUE);
    float f2 = b.a.b(this.context, yUF);
    String str = this.yUD;
    this.mPaint.setAntiAlias(true);
    this.mPaint.setTextSize(yUG);
    this.mPaint.setColor(-11491572);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(8.0F);
    paramCanvas.drawText(str, f1, f2, this.mPaint);
    this.mPaint.setTextSize(yUG);
    this.mPaint.setColor(-1770573);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setStrokeWidth(8.0F);
    paramCanvas.drawText(str, f1, f2, this.mPaint);
    AppMethodBeat.o(29140);
  }
  
  public void setPaintNum(int paramInt)
  {
    this.yUD = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.BorderNumView
 * JD-Core Version:    0.7.0.1
 */