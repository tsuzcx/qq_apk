package com.tencent.mm.pluginsdk.ui.d;

import android.text.style.CharacterStyle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;
import com.tencent.neattextview.textview.view.NeatTextView;

public class f
  extends com.tencent.neattextview.textview.view.b
{
  private m wbW;
  
  public f(NeatTextView paramNeatTextView, m paramm)
  {
    super(paramNeatTextView.getContext(), paramNeatTextView);
    AppMethodBeat.i(79812);
    this.wbW = paramm;
    AppMethodBeat.o(79812);
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(79815);
    if (this.Bcz != null)
    {
      CharacterStyle localCharacterStyle = this.Bcz.Bbj;
      if ((localCharacterStyle instanceof n)) {
        ((n)localCharacterStyle).setIsPressed(false);
      }
    }
    super.cancel(paramInt);
    AppMethodBeat.o(79815);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(79814);
    boolean bool = super.onDown(paramMotionEvent);
    if (this.Bcz != null)
    {
      paramMotionEvent = this.Bcz.Bbj;
      if ((paramMotionEvent instanceof n)) {
        ((n)paramMotionEvent).setIsPressed(true);
      }
      AppMethodBeat.o(79814);
      return true;
    }
    AppMethodBeat.o(79814);
    return bool;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(79816);
    if ((this.Bcz != null) && (this.mView != null)) {
      this.mView.performLongClick();
    }
    super.onLongPress(paramMotionEvent);
    AppMethodBeat.o(79816);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(79813);
    ak.d("MMNeatTouchListener", "onTouch", new Object[0]);
    paramView.setTag(2131820681, new int[] { (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY() });
    if ((paramView instanceof NeatTextView))
    {
      NeatTextView localNeatTextView = (NeatTextView)paramView;
      if ((!localNeatTextView.dOE()) || (localNeatTextView.kji))
      {
        if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
          localNeatTextView.getWrappedTextView().setPressed(false);
        }
        for (;;)
        {
          bool = this.wbW.onTouch(localNeatTextView.getWrappedTextView(), paramMotionEvent);
          AppMethodBeat.o(79813);
          return bool;
          if (paramMotionEvent.getAction() == 0) {
            localNeatTextView.getWrappedTextView().setPressed(true);
          }
        }
      }
    }
    boolean bool = super.onTouch(paramView, paramMotionEvent);
    AppMethodBeat.o(79813);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.f
 * JD-Core Version:    0.7.0.1
 */