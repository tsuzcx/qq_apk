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
  private float Ri;
  private final RectF Rj;
  private final Rect Rk;
  private boolean Rm;
  private boolean Rn;
  private final Paint mPaint;
  
  public a(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(285874);
    this.Rm = false;
    this.Rn = true;
    this.Ri = paramFloat;
    this.mPaint = new Paint(5);
    this.mPaint.setColor(paramInt);
    this.Rj = new RectF();
    this.Rk = new Rect();
    AppMethodBeat.o(285874);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(285878);
    paramCanvas.drawRoundRect(this.Rj, this.Ri, this.Ri, this.mPaint);
    AppMethodBeat.o(285878);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    AppMethodBeat.i(285892);
    paramOutline.setRoundRect(this.Rk, this.Ri);
    AppMethodBeat.o(285892);
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(285884);
    super.onBoundsChange(paramRect);
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = getBounds();
    }
    this.Rj.set(localRect.left, localRect.top, localRect.right, localRect.bottom);
    this.Rk.set(localRect);
    AppMethodBeat.o(285884);
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.bubble.a
 * JD-Core Version:    0.7.0.1
 */