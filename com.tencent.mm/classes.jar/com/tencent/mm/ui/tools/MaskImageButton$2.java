package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class MaskImageButton$2
  implements View.OnTouchListener
{
  MaskImageButton$2(MaskImageButton paramMaskImageButton) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107742);
    switch (paramMotionEvent.getAction())
    {
    }
    while ((!this.Awq.isClickable()) && (!this.Awq.isLongClickable()))
    {
      AppMethodBeat.o(107742);
      return true;
      paramView.setPressed(true);
      paramView.invalidate();
      MaskImageButton.b(this.Awq).removeCallbacks(MaskImageButton.a(this.Awq));
      continue;
      MaskImageButton.b(this.Awq).post(MaskImageButton.a(this.Awq));
    }
    AppMethodBeat.o(107742);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MaskImageButton.2
 * JD-Core Version:    0.7.0.1
 */