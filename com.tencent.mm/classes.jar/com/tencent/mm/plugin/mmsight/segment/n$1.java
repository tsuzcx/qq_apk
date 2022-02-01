package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n$1
  implements Runnable
{
  n$1(SliderSeekBar paramSliderSeekBar, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    AppMethodBeat.i(94444);
    if (this.tHk <= SliderSeekBar.a(this.tHn) * 2)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
      AppMethodBeat.o(94444);
      throw localIllegalStateException;
    }
    SliderSeekBar.b(this.tHn);
    SliderSeekBar.a(this.tHn, this.tHl);
    SliderSeekBar.b(this.tHn, Math.min(this.tHk, this.tHn.getWidth() - this.tHl * 2));
    SliderSeekBar.c(this.tHn, Math.max(this.tHm, SliderSeekBar.a(this.tHn) * 2));
    SliderSeekBar.c(this.tHn).setBounds(this.tHl, 0, this.tHl + SliderSeekBar.a(this.tHn), this.tHn.getHeight());
    SliderSeekBar.e(this.tHn).setBounds(this.tHl + SliderSeekBar.d(this.tHn) - SliderSeekBar.a(this.tHn), 0, SliderSeekBar.d(this.tHn) + this.tHl, this.tHn.getHeight());
    if ((SliderSeekBar.f(this.tHn) == null) && (SliderSeekBar.g(this.tHn) == null))
    {
      SliderSeekBar.a(this.tHn, new Rect(SliderSeekBar.c(this.tHn).getBounds().left, SliderSeekBar.c(this.tHn).getBounds().top, SliderSeekBar.c(this.tHn).getBounds().right, SliderSeekBar.c(this.tHn).getBounds().bottom));
      SliderSeekBar.b(this.tHn, new Rect(SliderSeekBar.e(this.tHn).getBounds().left, SliderSeekBar.e(this.tHn).getBounds().top, SliderSeekBar.e(this.tHn).getBounds().right, SliderSeekBar.e(this.tHn).getBounds().bottom));
    }
    this.tHn.invalidate();
    AppMethodBeat.o(94444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.n.1
 * JD-Core Version:    0.7.0.1
 */