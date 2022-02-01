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
  private final Paint mPaint;
  private float yT;
  private final RectF yU;
  private final Rect yV;
  private boolean yX;
  private boolean yY;
  
  public a(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(199383);
    this.yX = false;
    this.yY = true;
    this.yT = paramFloat;
    this.mPaint = new Paint(5);
    this.mPaint.setColor(paramInt);
    this.yU = new RectF();
    this.yV = new Rect();
    AppMethodBeat.o(199383);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(199385);
    paramCanvas.drawRoundRect(this.yU, this.yT, this.yT, this.mPaint);
    AppMethodBeat.o(199385);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    AppMethodBeat.i(199391);
    paramOutline.setRoundRect(this.yV, this.yT);
    AppMethodBeat.o(199391);
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(199389);
    super.onBoundsChange(paramRect);
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = getBounds();
    }
    this.yU.set(localRect.left, localRect.top, localRect.right, localRect.bottom);
    this.yV.set(localRect);
    AppMethodBeat.o(199389);
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.bubble.a
 * JD-Core Version:    0.7.0.1
 */