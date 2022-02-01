package com.tencent.mm.pluginsdk.ui.span;

import android.text.style.CharacterStyle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.ui.av;
import com.tencent.neattextview.textview.b.b;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.neattextview.textview.view.c;

public class h
  extends c
{
  private View.OnTouchListener RrN;
  
  public h(NeatTextView paramNeatTextView, View.OnTouchListener paramOnTouchListener)
  {
    super(paramNeatTextView.getContext(), paramNeatTextView);
    AppMethodBeat.i(222778);
    this.RrN = paramOnTouchListener;
    AppMethodBeat.o(222778);
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(152271);
    if (ikE() != null)
    {
      CharacterStyle localCharacterStyle = ikE().Zcp;
      if ((localCharacterStyle instanceof p)) {
        ((p)localCharacterStyle).setIsPressed(false);
      }
    }
    super.cancel(paramInt);
    AppMethodBeat.o(152271);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(152270);
    boolean bool = super.onDown(paramMotionEvent);
    if (ikE() != null)
    {
      paramMotionEvent = ikE().Zcp;
      if ((paramMotionEvent instanceof p)) {
        ((p)paramMotionEvent).setIsPressed(true);
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
    if ((ikE() != null) && (getView() != null)) {
      getView().performLongClick();
    }
    super.onLongPress(paramMotionEvent);
    AppMethodBeat.o(152272);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(152269);
    av.d("MMNeatTouchListener", "onTouch", new Object[0]);
    int i = (int)paramMotionEvent.getRawX();
    int j = (int)paramMotionEvent.getRawY();
    paramView.setTag(c.e.touch_loc, new int[] { i, j });
    if ((paramView instanceof NeatTextView))
    {
      NeatTextView localNeatTextView = (NeatTextView)paramView;
      if ((!localNeatTextView.hZE()) || (localNeatTextView.sTK))
      {
        if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
          localNeatTextView.getWrappedTextView().setPressed(false);
        }
        for (;;)
        {
          localNeatTextView.getWrappedTextView().setTag(paramView.getTag());
          bool = this.RrN.onTouch(localNeatTextView.getWrappedTextView(), paramMotionEvent);
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
      this.RrN.onTouch(paramView, paramMotionEvent);
    }
    boolean bool = super.onTouch(paramView, paramMotionEvent);
    AppMethodBeat.o(152269);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.h
 * JD-Core Version:    0.7.0.1
 */