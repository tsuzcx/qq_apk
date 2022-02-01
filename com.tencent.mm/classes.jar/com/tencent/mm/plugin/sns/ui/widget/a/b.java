package com.tencent.mm.plugin.sns.ui.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends g
{
  protected Rect Hy;
  protected Bitmap mBmp;
  protected Context mContext;
  protected int mHeight;
  protected int mWidth;
  protected boolean pYL;
  protected Scroller xYX;
  protected Scroller xYY;
  
  public b(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(179417);
    this.pYL = true;
    this.mContext = paramContext;
    this.Hy = new Rect();
    this.mBmp = paramBitmap;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    dW();
    AppMethodBeat.o(179417);
  }
  
  private void dW()
  {
    Point localPoint = this.xZe;
    int i = this.mWidth / 2;
    int j = this.mHeight / 2;
    this.Hy.left = (localPoint.x - i);
    this.Hy.right = (i + localPoint.x);
    this.Hy.top = (localPoint.y - j);
    this.Hy.bottom = (localPoint.y + j);
  }
  
  protected final void Oa(int paramInt)
  {
    AppMethodBeat.i(179420);
    if (this.xYY == null) {
      this.xYY = new Scroller(this.mContext);
    }
    setAlpha(0.0F);
    this.xYY.forceFinished(true);
    this.xYY.startScroll(0, 0, 255, 0, paramInt);
    AppMethodBeat.o(179420);
  }
  
  protected final boolean contains(Rect paramRect)
  {
    AppMethodBeat.i(179422);
    boolean bool = this.Hy.intersects(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    AppMethodBeat.o(179422);
    return bool;
  }
  
  protected final void dEs()
  {
    AppMethodBeat.i(179419);
    if (this.xYX == null) {
      this.xYX = new Scroller(this.mContext);
    }
    this.cHQ = 0.0F;
    this.xYX.forceFinished(true);
    this.xYX.startScroll(0, 0, 1000, 0, 1000);
    AppMethodBeat.o(179419);
  }
  
  public final Rect dEt()
  {
    return this.Hy;
  }
  
  public final void g(Point paramPoint)
  {
    AppMethodBeat.i(179418);
    super.g(paramPoint);
    dW();
    AppMethodBeat.o(179418);
  }
  
  protected final void m(Canvas paramCanvas)
  {
    AppMethodBeat.i(179421);
    if ((this.xYX != null) && (this.xYX.computeScrollOffset())) {
      this.cHQ = (this.xYX.getCurrX() / 1000.0F);
    }
    if ((this.xYY != null) && (this.xYY.computeScrollOffset())) {
      setAlpha(this.xYY.getCurrX() / 255.0F);
    }
    if ((this.mPaint != null) && (this.mBmp != null)) {
      paramCanvas.drawBitmap(this.mBmp, null, this.Hy, this.mPaint);
    }
    AppMethodBeat.o(179421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.a.b
 * JD-Core Version:    0.7.0.1
 */