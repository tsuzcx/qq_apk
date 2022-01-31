package com.tencent.mm.view.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.mm.bt.b;

public final class c
  extends a
{
  public c(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  protected final boolean cLA()
  {
    return false;
  }
  
  public final boolean cLB()
  {
    return false;
  }
  
  public final Rect getAliveRect()
  {
    if (super.getAliveRect().isEmpty()) {
      return getBoardRect();
    }
    return super.getAliveRect();
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawColor(0);
    paramCanvas.setMatrix(this.bzW);
    getPresenter().onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.b.c
 * JD-Core Version:    0.7.0.1
 */