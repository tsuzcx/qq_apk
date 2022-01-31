package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.ah;

final class TouchImageView$2
  implements View.OnTouchListener
{
  TouchImageView$2(TouchImageView paramTouchImageView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!TouchImageView.a(this.pky)) {}
    for (;;)
    {
      return false;
      TouchImageView localTouchImageView = this.pky;
      switch (paramMotionEvent.getAction())
      {
      }
      while ((!localTouchImageView.isClickable()) && (!localTouchImageView.isLongClickable()))
      {
        return true;
        paramView.setPressed(true);
        paramView.invalidate();
        localTouchImageView.oNg.removeCallbacks(localTouchImageView.oNh);
        continue;
        localTouchImageView.oNg.post(localTouchImageView.oNh);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TouchImageView.2
 * JD-Core Version:    0.7.0.1
 */