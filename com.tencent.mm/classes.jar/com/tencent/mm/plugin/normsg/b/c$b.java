package com.tencent.mm.plugin.normsg.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class c$b
  implements View.OnTouchListener
{
  private final View.OnTouchListener pic;
  
  c$b(View.OnTouchListener paramOnTouchListener)
  {
    this.pic = paramOnTouchListener;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(10433);
    for (;;)
    {
      synchronized (c.access$000())
      {
        if (!c.access$000().containsKey(paramView))
        {
          if (this.pic == null) {
            break;
          }
          boolean bool = this.pic.onTouch(paramView, paramMotionEvent);
          AppMethodBeat.o(10433);
          return bool;
        }
      }
      synchronized (c.ajx())
      {
        c.ajx().put(paramView, Boolean.TRUE);
        continue;
        paramView = finally;
        AppMethodBeat.o(10433);
        throw paramView;
      }
    }
    AppMethodBeat.o(10433);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.c.b
 * JD-Core Version:    0.7.0.1
 */