package com.tencent.mm.sdk.platformtools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class Util$1
  implements View.OnTouchListener
{
  public final boolean onTouch(final View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(157853);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(157853);
      return false;
      paramView.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(157852);
          paramView.setPressed(false);
          AppMethodBeat.o(157852);
        }
      });
      continue;
      paramView.setPressed(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.Util.1
 * JD-Core Version:    0.7.0.1
 */