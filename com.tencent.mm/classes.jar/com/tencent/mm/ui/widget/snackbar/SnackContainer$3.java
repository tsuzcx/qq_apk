package com.tencent.mm.ui.widget.snackbar;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.util.Queue;

final class SnackContainer$3
  implements View.OnTouchListener
{
  SnackContainer$3(SnackContainer paramSnackContainer, SnackContainer.a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.wqa.removeCallbacks(SnackContainer.c(this.wqa));
      SnackContainer.c(this.wqb);
      this.wqa.startAnimation(SnackContainer.a(this.wqa));
      if (!SnackContainer.b(this.wqa).isEmpty()) {
        SnackContainer.b(this.wqa).clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackContainer.3
 * JD-Core Version:    0.7.0.1
 */