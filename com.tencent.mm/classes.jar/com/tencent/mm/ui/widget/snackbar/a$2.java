package com.tencent.mm.ui.widget.snackbar;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$2
  implements View.OnTouchListener
{
  a$2(a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(112975);
    if ((b.Pk()) && (this.AKw.AKs.isShowing()))
    {
      b.rJ(false);
      this.AKw.mHandler.postDelayed(new a.2.1(this), 100L);
    }
    AppMethodBeat.o(112975);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.a.2
 * JD-Core Version:    0.7.0.1
 */