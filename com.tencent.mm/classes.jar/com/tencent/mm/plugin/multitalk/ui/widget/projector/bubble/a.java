package com.tencent.mm.plugin.multitalk.ui.widget.projector.bubble;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends Drawable
{
  private float auL;
  private final RectF auM;
  private final Rect auN;
  private boolean auP;
  private boolean auQ;
  private final Paint mPaint;
  
  public a(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(239504);
    this.auP = false;
    this.auQ = true;
    this.auL = paramFloat;
    this.mPaint = new Paint(5);
    this.mPaint.setColor(paramInt);
    this.auM = new RectF();
    this.auN = new Rect();
    AppMethodBeat.o(239504);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(239505);
    paramCanvas.drawRoundRect(this.auM, this.auL, this.auL, this.mPaint);
    AppMethodBeat.o(239505);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    AppMethodBeat.i(239507);
    paramOutline.setRoundRect(this.auN, this.auL);
    AppMethodBeat.o(239507);
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(239506);
    super.onBoundsChange(paramRect);
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = getBounds();
    }
    this.auM.set(localRect.left, localRect.top, localRect.right, localRect.bottom);
    this.auN.set(localRect);
    AppMethodBeat.o(239506);
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.bubble.a
 * JD-Core Version:    0.7.0.1
 */