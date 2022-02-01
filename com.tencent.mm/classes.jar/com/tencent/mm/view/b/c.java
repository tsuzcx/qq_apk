package com.tencent.mm.view.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;

public final class c
  extends a
{
  public c(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
  }
  
  protected final boolean fza()
  {
    return false;
  }
  
  public final boolean fzb()
  {
    return false;
  }
  
  public final Rect getAliveRect()
  {
    AppMethodBeat.i(9399);
    if (super.getAliveRect().isEmpty())
    {
      localRect = getBoardRect();
      AppMethodBeat.o(9399);
      return localRect;
    }
    Rect localRect = super.getAliveRect();
    AppMethodBeat.o(9399);
    return localRect;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9400);
    paramCanvas.drawColor(0);
    paramCanvas.setMatrix(this.cOV);
    getPresenter().onDraw(paramCanvas);
    AppMethodBeat.o(9400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.b.c
 * JD-Core Version:    0.7.0.1
 */