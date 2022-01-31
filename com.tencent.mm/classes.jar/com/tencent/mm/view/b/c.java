package com.tencent.mm.view.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.b;

public final class c
  extends a
{
  public c(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  protected final boolean dQR()
  {
    return false;
  }
  
  public final boolean dQS()
  {
    return false;
  }
  
  public final Rect getAliveRect()
  {
    AppMethodBeat.i(116421);
    if (super.getAliveRect().isEmpty())
    {
      localRect = getBoardRect();
      AppMethodBeat.o(116421);
      return localRect;
    }
    Rect localRect = super.getAliveRect();
    AppMethodBeat.o(116421);
    return localRect;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(116422);
    paramCanvas.drawColor(0);
    paramCanvas.setMatrix(this.ccT);
    getPresenter().onDraw(paramCanvas);
    AppMethodBeat.o(116422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.b.c
 * JD-Core Version:    0.7.0.1
 */