package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MaskImageView$2
  implements View.OnTouchListener
{
  MaskImageView$2(MaskImageView paramMaskImageView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38308);
    if (!MaskImageView.a(this.rIq))
    {
      AppMethodBeat.o(38308);
      return false;
    }
    boolean bool = this.rIq.d(paramView, paramMotionEvent);
    AppMethodBeat.o(38308);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.MaskImageView.2
 * JD-Core Version:    0.7.0.1
 */