package com.tencent.mm.plugin.vlog.ui.plugin.timecrop;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TimeCropSliderSeekBar$b
  extends Drawable
{
  private Drawable Fdp;
  private Drawable Fdq;
  boolean isPressed = false;
  
  public TimeCropSliderSeekBar$b(TimeCropSliderSeekBar paramTimeCropSliderSeekBar, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this.Fdp = paramDrawable1;
    this.Fdq = paramDrawable2;
    this.isPressed = false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(226512);
    if (this.isPressed) {}
    for (Drawable localDrawable = this.Fdp;; localDrawable = this.Fdq)
    {
      if (!getBounds().equals(localDrawable.getBounds())) {
        localDrawable.setBounds(getBounds());
      }
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(226512);
      return;
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(226513);
    this.Fdp.setAlpha(paramInt);
    this.Fdq.setAlpha(paramInt);
    AppMethodBeat.o(226513);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(226514);
    this.Fdp.setColorFilter(paramColorFilter);
    this.Fdq.setColorFilter(paramColorFilter);
    AppMethodBeat.o(226514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropSliderSeekBar.b
 * JD-Core Version:    0.7.0.1
 */