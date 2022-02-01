package com.tencent.mm.pluginsdk.ui.span;

import android.text.style.CharacterStyle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.as;
import com.tencent.neattextview.textview.view.NeatTextView;

public class h
  extends com.tencent.neattextview.textview.view.b
{
  private View.OnTouchListener KqG;
  
  public h(NeatTextView paramNeatTextView, View.OnTouchListener paramOnTouchListener)
  {
    super(paramNeatTextView.getContext(), paramNeatTextView);
    AppMethodBeat.i(223849);
    this.KqG = paramOnTouchListener;
    AppMethodBeat.o(223849);
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(152271);
    if (this.RCi != null)
    {
      CharacterStyle localCharacterStyle = this.RCi.RAM;
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
    if (this.RCi != null)
    {
      paramMotionEvent = this.RCi.RAM;
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
    if ((this.RCi != null) && (this.mView != null)) {
      this.mView.performLongClick();
    }
    super.onLongPress(paramMotionEvent);
    AppMethodBeat.o(152272);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(152269);
    as.d("MMNeatTouchListener", "onTouch", new Object[0]);
    paramView.setTag(2131309367, new int[] { (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY() });
    if ((paramView instanceof NeatTextView))
    {
      NeatTextView localNeatTextView = (NeatTextView)paramView;
      if ((!localNeatTextView.gYM()) || (localNeatTextView.pMM))
      {
        if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
          localNeatTextView.getWrappedTextView().setPressed(false);
        }
        for (;;)
        {
          localNeatTextView.getWrappedTextView().setTag(paramView.getTag());
          bool = this.KqG.onTouch(localNeatTextView.getWrappedTextView(), paramMotionEvent);
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
      this.KqG.onTouch(paramView, paramMotionEvent);
    }
    boolean bool = super.onTouch(paramView, paramMotionEvent);
    AppMethodBeat.o(152269);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.h
 * JD-Core Version:    0.7.0.1
 */