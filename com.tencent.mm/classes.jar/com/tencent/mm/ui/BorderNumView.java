package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class BorderNumView
  extends View
{
  private static int FHu = 22;
  private static int FHv = 105;
  private static int FHw = 100;
  private int FHt;
  private Context context;
  private Paint mPaint;
  
  public BorderNumView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(32961);
    this.context = null;
    this.FHt = 100;
    this.context = paramContext;
    init();
    AppMethodBeat.o(32961);
  }
  
  public BorderNumView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(32962);
    this.context = null;
    this.FHt = 100;
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
    if (this.FHt < 100) {
      FHu += 15;
    }
    if (this.FHt >= 1000) {
      FHw -= 20;
    }
    float f1 = BackwardSupportUtil.b.g(this.context, FHu);
    float f2 = BackwardSupportUtil.b.g(this.context, FHv);
    String str = this.FHt;
    this.mPaint.setAntiAlias(true);
    this.mPaint.setTextSize(FHw);
    this.mPaint.setColor(-11491572);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(8.0F);
    paramCanvas.drawText(str, f1, f2, this.mPaint);
    this.mPaint.setTextSize(FHw);
    this.mPaint.setColor(-1770573);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setStrokeWidth(8.0F);
    paramCanvas.drawText(str, f1, f2, this.mPaint);
    AppMethodBeat.o(32964);
  }
  
  public void setPaintNum(int paramInt)
  {
    this.FHt = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.BorderNumView
 * JD-Core Version:    0.7.0.1
 */