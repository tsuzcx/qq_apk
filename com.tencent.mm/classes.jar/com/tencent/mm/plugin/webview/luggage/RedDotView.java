package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RedDotView
  extends View
{
  private Paint mPaint;
  
  public RedDotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(182687);
    this.mPaint = new Paint();
    AppMethodBeat.o(182687);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(182688);
    super.onDraw(paramCanvas);
    this.mPaint.setColor(-65536);
    paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, getWidth() / 2, this.mPaint);
    AppMethodBeat.o(182688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.RedDotView
 * JD-Core Version:    0.7.0.1
 */