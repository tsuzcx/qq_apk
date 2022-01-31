package com.tencent.mm.ui.widget.snackbar;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Queue;

final class SnackContainer$3
  implements View.OnTouchListener
{
  SnackContainer$3(SnackContainer paramSnackContainer, SnackContainer.a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(112994);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(112994);
      return true;
      this.AKD.removeCallbacks(SnackContainer.c(this.AKD));
      SnackContainer.d(this.AKE);
      this.AKD.startAnimation(SnackContainer.a(this.AKD));
      if (!SnackContainer.b(this.AKD).isEmpty()) {
        SnackContainer.b(this.AKD).clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackContainer.3
 * JD-Core Version:    0.7.0.1
 */