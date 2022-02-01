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
  private Drawable tHs;
  private Drawable tHt;
  
  public n$b(SliderSeekBar paramSliderSeekBar, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this.tHs = paramDrawable1;
    this.tHt = paramDrawable2;
    this.isPressed = false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94446);
    if (this.isPressed) {}
    for (Drawable localDrawable = this.tHs;; localDrawable = this.tHt)
    {
      if (!getBounds().equals(localDrawable.getBounds())) {
        localDrawable.setBounds(getBounds());
      }
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(94446);
      return;
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(94447);
    this.tHs.setAlpha(paramInt);
    this.tHt.setAlpha(paramInt);
    AppMethodBeat.o(94447);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(94448);
    this.tHs.setColorFilter(paramColorFilter);
    this.tHt.setColorFilter(paramColorFilter);
    AppMethodBeat.o(94448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.n.b
 * JD-Core Version:    0.7.0.1
 */