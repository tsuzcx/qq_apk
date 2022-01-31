package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s$g
  implements View.OnTouchListener
{
  private int[] zzX;
  
  public s$g()
  {
    AppMethodBeat.i(30724);
    this.zzX = new int[2];
    AppMethodBeat.o(30724);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(30725);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30725);
      return false;
      this.zzX[0] = ((int)paramMotionEvent.getRawX());
      this.zzX[1] = ((int)paramMotionEvent.getRawY());
      paramView.setTag(2131820681, this.zzX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.g
 * JD-Core Version:    0.7.0.1
 */