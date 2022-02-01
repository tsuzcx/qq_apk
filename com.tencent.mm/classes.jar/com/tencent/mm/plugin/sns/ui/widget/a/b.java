package com.tencent.mm.plugin.sns.ui.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends h
{
  protected Rect Iw;
  protected Bitmap mBmp;
  protected Context mContext;
  protected int mHeight;
  protected int mWidth;
  protected boolean qHs;
  protected Scroller zlU;
  protected Scroller zlV;
  protected int zlW;
  
  public b(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(179417);
    this.qHs = true;
    this.mContext = paramContext;
    this.Iw = new Rect();
    this.mBmp = paramBitmap;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    eh();
    AppMethodBeat.o(179417);
  }
  
  private void eh()
  {
    Point localPoint = this.zme;
    int i = this.mWidth / 2;
    int j = this.mHeight / 2;
    this.Iw.left = (localPoint.x - i);
    this.Iw.right = (i + localPoint.x);
    this.Iw.top = (localPoint.y - j);
    this.Iw.bottom = (localPoint.y + j);
  }
  
  public final void Qe(int paramInt)
  {
    this.zlW = paramInt;
  }
  
  protected final void Qf(int paramInt)
  {
    AppMethodBeat.i(179420);
    if (this.zlV == null) {
      this.zlV = new Scroller(this.mContext);
    }
    setAlpha(0.0F);
    this.zlV.forceFinished(true);
    this.zlV.startScroll(0, 0, 255, 0, paramInt);
    AppMethodBeat.o(179420);
  }
  
  protected final boolean contains(Rect paramRect)
  {
    AppMethodBeat.i(179422);
    boolean bool = this.Iw.intersects(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    AppMethodBeat.o(179422);
    return bool;
  }
  
  public final int dSQ()
  {
    return this.zlW;
  }
  
  protected final void dSR()
  {
    AppMethodBeat.i(179419);
    if (this.zlU == null) {
      this.zlU = new Scroller(this.mContext);
    }
    this.cEY = 0.0F;
    this.zlU.forceFinished(true);
    this.zlU.startScroll(0, 0, 1000, 0, 1000);
    AppMethodBeat.o(179419);
  }
  
  public final Rect dSS()
  {
    return this.Iw;
  }
  
  public final void i(Point paramPoint)
  {
    AppMethodBeat.i(179418);
    super.i(paramPoint);
    eh();
    AppMethodBeat.o(179418);
  }
  
  protected final void m(Canvas paramCanvas)
  {
    AppMethodBeat.i(179421);
    if ((this.zlU != null) && (this.zlU.computeScrollOffset())) {
      this.cEY = (this.zlU.getCurrX() / 1000.0F);
    }
    if ((this.zlV != null) && (this.zlV.computeScrollOffset())) {
      setAlpha(this.zlV.getCurrX() / 255.0F);
    }
    if ((this.mPaint != null) && (this.mBmp != null)) {
      paramCanvas.drawBitmap(this.mBmp, null, this.Iw, this.mPaint);
    }
    AppMethodBeat.o(179421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.a.b
 * JD-Core Version:    0.7.0.1
 */