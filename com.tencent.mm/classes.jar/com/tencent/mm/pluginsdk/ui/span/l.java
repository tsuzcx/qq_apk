package com.tencent.mm.pluginsdk.ui.span;

import android.text.style.CharacterStyle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.ui.bc;
import com.tencent.neattextview.textview.b.b;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.neattextview.textview.view.c;

public class l
  extends c
{
  private View.OnTouchListener Yoe;
  
  public l(NeatTextView paramNeatTextView, View.OnTouchListener paramOnTouchListener)
  {
    super(paramNeatTextView.getContext(), paramNeatTextView);
    AppMethodBeat.i(245175);
    this.Yoe = paramOnTouchListener;
    AppMethodBeat.o(245175);
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(152271);
    if (jQV() != null)
    {
      CharacterStyle localCharacterStyle = jQV().ahaT;
      if ((localCharacterStyle instanceof t)) {
        ((t)localCharacterStyle).setIsPressed(false);
      }
    }
    super.cancel(paramInt);
    AppMethodBeat.o(152271);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(152270);
    boolean bool = super.onDown(paramMotionEvent);
    if (jQV() != null)
    {
      paramMotionEvent = jQV().ahaT;
      if ((paramMotionEvent instanceof t)) {
        ((t)paramMotionEvent).setIsPressed(true);
      }
      AppMethodBeat.o(152270);
      return true;
    }
    AppMethodBeat.o(152270);
    return bool;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(152272);
    if ((jQV() != null) && (getView() != null)) {
      getView().performLongClick();
    }
    super.onLongPress(paramMotionEvent);
    AppMethodBeat.o(152272);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(152269);
    bc.d("MMNeatTouchListener", "onTouch", new Object[0]);
    int i = (int)paramMotionEvent.getRawX();
    int j = (int)paramMotionEvent.getRawY();
    paramView.setTag(c.e.touch_loc, new int[] { i, j });
    if ((paramView instanceof NeatTextView))
    {
      NeatTextView localNeatTextView = (NeatTextView)paramView;
      if ((!localNeatTextView.jEM()) || (localNeatTextView.vZb))
      {
        if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
          localNeatTextView.getWrappedTextView().setPressed(false);
        }
        for (;;)
        {
          localNeatTextView.getWrappedTextView().setTag(paramView.getTag());
          bool = this.Yoe.onTouch(localNeatTextView.getWrappedTextView(), paramMotionEvent);
          AppMethodBeat.o(152269);
          return bool;
          if (paramMotionEvent.getAction() == 0) {
            localNeatTextView.getWrappedTextView().setPressed(true);
          }
        }
      }
    }
    else
    {
      this.Yoe.onTouch(paramView, paramMotionEvent);
    }
    boolean bool = super.onTouch(paramView, paramMotionEvent);
    AppMethodBeat.o(152269);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.l
 * JD-Core Version:    0.7.0.1
 */