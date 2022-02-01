package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  public static void E(View paramView, float paramFloat)
  {
    AppMethodBeat.i(211047);
    if ((paramView == null) || (paramFloat <= 0.0F) || (paramFloat >= 1.0F))
    {
      AppMethodBeat.o(211047);
      return;
    }
    paramView.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143208);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        while ((!paramAnonymousView.isClickable()) && (!paramAnonymousView.isLongClickable()))
        {
          AppMethodBeat.o(143208);
          return true;
          paramAnonymousView.setAlpha(this.XTP);
          continue;
          paramAnonymousView.setAlpha(1.0F);
        }
        AppMethodBeat.o(143208);
        return false;
      }
    });
    AppMethodBeat.o(211047);
  }
  
  public static void iF(View paramView)
  {
    AppMethodBeat.i(293213);
    E(paramView, 0.7F);
    AppMethodBeat.o(293213);
  }
  
  public static void iG(View paramView)
  {
    AppMethodBeat.i(211050);
    if (paramView != null) {
      paramView.setOnTouchListener(null);
    }
    AppMethodBeat.o(211050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.p
 * JD-Core Version:    0.7.0.1
 */