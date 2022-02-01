package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
{
  public static void F(View paramView, float paramFloat)
  {
    AppMethodBeat.i(251053);
    if ((paramView == null) || (paramFloat <= 0.0F) || (paramFloat >= 1.0F))
    {
      AppMethodBeat.o(251053);
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
          paramAnonymousView.setAlpha(this.afKd);
          continue;
          paramAnonymousView.setAlpha(1.0F);
        }
        AppMethodBeat.o(143208);
        return false;
      }
    });
    AppMethodBeat.o(251053);
  }
  
  public static void mb(View paramView)
  {
    AppMethodBeat.i(251056);
    if (paramView != null) {
      paramView.setOnTouchListener(null);
    }
    AppMethodBeat.o(251056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.o
 * JD-Core Version:    0.7.0.1
 */