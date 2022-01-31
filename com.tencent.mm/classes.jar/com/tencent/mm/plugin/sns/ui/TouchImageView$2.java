package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class TouchImageView$2
  implements View.OnTouchListener
{
  TouchImageView$2(TouchImageView paramTouchImageView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(39896);
    if (!TouchImageView.a(this.sdb))
    {
      AppMethodBeat.o(39896);
      return false;
    }
    TouchImageView localTouchImageView = this.sdb;
    switch (paramMotionEvent.getAction())
    {
    }
    while ((!localTouchImageView.isClickable()) && (!localTouchImageView.isLongClickable()))
    {
      AppMethodBeat.o(39896);
      return true;
      paramView.setPressed(true);
      paramView.invalidate();
      localTouchImageView.rER.removeCallbacks(localTouchImageView.rES);
      continue;
      localTouchImageView.rER.post(localTouchImageView.rES);
    }
    AppMethodBeat.o(39896);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TouchImageView.2
 * JD-Core Version:    0.7.0.1
 */