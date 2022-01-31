package com.tencent.mm.pluginsdk.ui.d;

import android.text.style.CharacterStyle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class f
  extends com.tencent.neattextview.textview.view.b
{
  private m sjq;
  
  public f(NeatTextView paramNeatTextView, m paramm)
  {
    super(paramNeatTextView.getContext(), paramNeatTextView);
    this.sjq = paramm;
  }
  
  protected final void cancel(int paramInt)
  {
    if (this.wEY != null)
    {
      CharacterStyle localCharacterStyle = this.wEY.wDz;
      if ((localCharacterStyle instanceof n)) {
        ((n)localCharacterStyle).mmZ = false;
      }
    }
    super.cancel(paramInt);
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onDown(paramMotionEvent);
    if (this.wEY != null)
    {
      paramMotionEvent = this.wEY.wDz;
      if ((paramMotionEvent instanceof n)) {
        ((n)paramMotionEvent).mmZ = true;
      }
      bool = true;
    }
    return bool;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((this.wEY != null) && (this.mView != null)) {
      this.mView.performLongClick();
    }
    super.onLongPress(paramMotionEvent);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getRawX();
    int j = (int)paramMotionEvent.getRawY();
    paramView.setTag(a.e.touch_loc, new int[] { i, j });
    if ((paramView instanceof NeatTextView))
    {
      NeatTextView localNeatTextView = (NeatTextView)paramView;
      if ((!localNeatTextView.cJN()) || (localNeatTextView.wEG))
      {
        if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
          localNeatTextView.getWrappedTextView().setPressed(false);
        }
        for (;;)
        {
          return this.sjq.onTouch(localNeatTextView.getWrappedTextView(), paramMotionEvent);
          if (paramMotionEvent.getAction() == 0) {
            localNeatTextView.getWrappedTextView().setPressed(true);
          }
        }
      }
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.f
 * JD-Core Version:    0.7.0.1
 */