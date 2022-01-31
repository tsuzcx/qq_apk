package com.tencent.mm.plugin.normsg.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.util.Map;

final class c$b
  implements View.OnTouchListener
{
  private final View.OnTouchListener mHW;
  
  c$b(View.OnTouchListener paramOnTouchListener)
  {
    this.mHW = paramOnTouchListener;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      synchronized ()
      {
        if (!c.aiY().containsKey(paramView))
        {
          if (this.mHW == null) {
            break;
          }
          return this.mHW.onTouch(paramView, paramMotionEvent);
        }
      }
      synchronized (c.Qq())
      {
        c.Qq().put(paramView, Boolean.valueOf(true));
        continue;
        paramView = finally;
        throw paramView;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.c.b
 * JD-Core Version:    0.7.0.1
 */