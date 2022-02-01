package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public final class o
{
  public static void gY(View paramView)
  {
    AppMethodBeat.i(224386);
    gZ(paramView);
    AppMethodBeat.o(224386);
  }
  
  public static void gZ(View paramView)
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
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/ui/tools/PressAlphaUtil$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        switch (paramAnonymousMotionEvent.getAction())
        {
        case 2: 
        default: 
          if ((paramAnonymousView.isClickable()) || (paramAnonymousView.isLongClickable())) {
            break;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          a.a(bool, this, "com/tencent/mm/ui/tools/PressAlphaUtil$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143208);
          return bool;
          paramAnonymousView.setAlpha(this.LgP);
          break;
          paramAnonymousView.setAlpha(1.0F);
          break;
        }
      }
    });
    AppMethodBeat.o(143210);
  }
  
  public static void ha(View paramView)
  {
    AppMethodBeat.i(193757);
    if (paramView != null) {
      paramView.setOnTouchListener(null);
    }
    AppMethodBeat.o(193757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.o
 * JD-Core Version:    0.7.0.1
 */