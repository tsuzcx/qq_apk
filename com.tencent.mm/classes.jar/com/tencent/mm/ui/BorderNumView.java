package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;

public class BorderNumView
  extends View
{
  private static int Oyu = 22;
  private static int Oyv = 105;
  private static int Oyw = 100;
  private int Oyt;
  private Context context;
  private Paint mPaint;
  
  public BorderNumView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(32961);
    this.context = null;
    this.Oyt = 100;
    this.context = paramContext;
    init();
    AppMethodBeat.o(32961);
  }
  
  public BorderNumView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(32962);
    this.context = null;
    this.Oyt = 100;
    this.context = paramContext;
    init();
    AppMethodBeat.o(32962);
  }
  
  private void init()
  {
    AppMethodBeat.i(32963);
    this.mPaint = new Paint();
    AppMethodBeat.o(32963);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(32964);
    super.onDraw(paramCanvas);
    if (this.Oyt < 100) {
      Oyu += 15;
    }
    if (this.Oyt >= 1000) {
      Oyw -= 20;
    }
    float f1 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, Oyu);
    float f2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, Oyv);
    String str = this.Oyt;
    this.mPaint.setAntiAlias(true);
    this.mPaint.setTextSize(Oyw);
    this.mPaint.setColor(-11491572);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(8.0F);
    paramCanvas.drawText(str, f1, f2, this.mPaint);
    this.mPaint.setTextSize(Oyw);
    this.mPaint.setColor(-1770573);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setStrokeWidth(8.0F);
    paramCanvas.drawText(str, f1, f2, this.mPaint);
    AppMethodBeat.o(32964);
  }
  
  public void setPaintNum(int paramInt)
  {
    this.Oyt = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.BorderNumView
 * JD-Core Version:    0.7.0.1
 */