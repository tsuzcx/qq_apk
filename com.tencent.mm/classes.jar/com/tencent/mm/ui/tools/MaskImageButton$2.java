package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.ah;

final class MaskImageButton$2
  implements View.OnTouchListener
{
  MaskImageButton$2(MaskImageButton paramMaskImageButton) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while ((!this.wdG.isClickable()) && (!this.wdG.isLongClickable()))
    {
      return true;
      paramView.setPressed(true);
      paramView.invalidate();
      MaskImageButton.b(this.wdG).removeCallbacks(MaskImageButton.a(this.wdG));
      continue;
      MaskImageButton.b(this.wdG).post(MaskImageButton.a(this.wdG));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MaskImageButton.2
 * JD-Core Version:    0.7.0.1
 */