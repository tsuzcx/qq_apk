package com.tencent.mm.pluginsdk.ui.span;

import android.text.style.CharacterStyle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.an;
import com.tencent.neattextview.textview.view.NeatTextView;

public class g
  extends com.tencent.neattextview.textview.view.b
{
  private n DBZ;
  
  public g(NeatTextView paramNeatTextView, n paramn)
  {
    super(paramNeatTextView.getContext(), paramNeatTextView);
    AppMethodBeat.i(152268);
    this.DBZ = paramn;
    AppMethodBeat.o(152268);
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(152271);
    if (this.JLg != null)
    {
      CharacterStyle localCharacterStyle = this.JLg.JJH;
      if ((localCharacterStyle instanceof o)) {
        ((o)localCharacterStyle).setIsPressed(false);
      }
    }
    super.cancel(paramInt);
    AppMethodBeat.o(152271);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(152270);
    boolean bool = super.onDown(paramMotionEvent);
    if (this.JLg != null)
    {
      paramMotionEvent = this.JLg.JJH;
      if ((paramMotionEvent instanceof o)) {
        ((o)paramMotionEvent).setIsPressed(true);
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
    if ((this.JLg != null) && (this.mView != null)) {
      this.mView.performLongClick();
    }
    super.onLongPress(paramMotionEvent);
    AppMethodBeat.o(152272);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(152269);
    an.d("MMNeatTouchListener", "onTouch", new Object[0]);
    paramView.setTag(2131306044, new int[] { (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY() });
    if ((paramView instanceof NeatTextView))
    {
      NeatTextView localNeatTextView = (NeatTextView)paramView;
      if ((!localNeatTextView.fuD()) || (localNeatTextView.nPV))
      {
        if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
          localNeatTextView.getWrappedTextView().setPressed(false);
        }
        for (;;)
        {
          localNeatTextView.getWrappedTextView().setTag(paramView.getTag());
          bool = this.DBZ.onTouch(localNeatTextView.getWrappedTextView(), paramMotionEvent);
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
      this.DBZ.onTouch(paramView, paramMotionEvent);
    }
    boolean bool = super.onTouch(paramView, paramMotionEvent);
    AppMethodBeat.o(152269);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.g
 * JD-Core Version:    0.7.0.1
 */