package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n$b
  extends Drawable
{
  boolean isPressed = false;
  private Drawable oMh;
  private Drawable oMi;
  
  public n$b(n paramn, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this.oMh = paramDrawable1;
    this.oMi = paramDrawable2;
    this.isPressed = false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55013);
    if (this.isPressed) {}
    for (Drawable localDrawable = this.oMh;; localDrawable = this.oMi)
    {
      if (!getBounds().equals(localDrawable.getBounds())) {
        localDrawable.setBounds(getBounds());
      }
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(55013);
      return;
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(55014);
    this.oMh.setAlpha(paramInt);
    this.oMi.setAlpha(paramInt);
    AppMethodBeat.o(55014);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(55015);
    this.oMh.setColorFilter(paramColorFilter);
    this.oMi.setColorFilter(paramColorFilter);
    AppMethodBeat.o(55015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.n.b
 * JD-Core Version:    0.7.0.1
 */