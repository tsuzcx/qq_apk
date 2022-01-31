package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class PressImageView$2
  implements View.OnTouchListener
{
  PressImageView$2(PressImageView paramPressImageView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107747);
    switch (paramMotionEvent.getAction())
    {
    }
    while ((!this.AwN.isClickable()) && (!this.AwN.isLongClickable()))
    {
      AppMethodBeat.o(107747);
      return true;
      paramView.setPressed(true);
      paramView.invalidate();
      PressImageView.b(this.AwN).removeCallbacks(PressImageView.a(this.AwN));
      continue;
      PressImageView.b(this.AwN).post(PressImageView.a(this.AwN));
    }
    AppMethodBeat.o(107747);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.PressImageView.2
 * JD-Core Version:    0.7.0.1
 */