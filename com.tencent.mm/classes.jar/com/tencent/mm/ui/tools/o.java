package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
{
  public static void hp(View paramView)
  {
    AppMethodBeat.i(258468);
    hq(paramView);
    AppMethodBeat.o(258468);
  }
  
  public static void hq(View paramView)
  {
    AppMethodBeat.i(143210);
    if (paramView == null)
    {
      AppMethodBeat.o(143210);
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
          paramAnonymousView.setAlpha(this.QvN);
          continue;
          paramAnonymousView.setAlpha(1.0F);
        }
        AppMethodBeat.o(143208);
        return false;
      }
    });
    AppMethodBeat.o(143210);
  }
  
  public static void hr(View paramView)
  {
    AppMethodBeat.i(205375);
    if (paramView != null) {
      paramView.setOnTouchListener(null);
    }
    AppMethodBeat.o(205375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.o
 * JD-Core Version:    0.7.0.1
 */