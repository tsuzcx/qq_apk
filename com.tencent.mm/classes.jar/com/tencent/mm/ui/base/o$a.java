package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o$a
  extends FrameLayout
{
  o$a(o paramo, Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(159242);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (getKeyDispatcherState() == null)
      {
        bool = super.dispatchKeyEvent(paramKeyEvent);
        AppMethodBeat.o(159242);
        return bool;
      }
      KeyEvent.DispatcherState localDispatcherState;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.startTracking(paramKeyEvent, this);
        }
        AppMethodBeat.o(159242);
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localDispatcherState = getKeyDispatcherState();
        if ((localDispatcherState != null) && (localDispatcherState.isTracking(paramKeyEvent)) && (!paramKeyEvent.isCanceled()))
        {
          this.JGW.dismiss();
          AppMethodBeat.o(159242);
          return true;
        }
      }
      bool = super.dispatchKeyEvent(paramKeyEvent);
      AppMethodBeat.o(159242);
      return bool;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(159242);
    return bool;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159243);
    if ((o.a(this.JGW) != null) && (o.a(this.JGW).onTouch(this, paramMotionEvent)))
    {
      AppMethodBeat.o(159243);
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(159243);
    return bool;
  }
  
  protected final int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(159241);
    int[] arrayOfInt = super.onCreateDrawableState(paramInt);
    AppMethodBeat.o(159241);
    return arrayOfInt;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159244);
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if ((paramMotionEvent.getAction() == 0) && ((i < 0) || (i >= getWidth()) || (j < 0) || (j >= getHeight())))
    {
      this.JGW.dismiss();
      AppMethodBeat.o(159244);
      return true;
    }
    if (paramMotionEvent.getAction() == 4)
    {
      this.JGW.dismiss();
      AppMethodBeat.o(159244);
      return true;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(159244);
    return bool;
  }
  
  public final void sendAccessibilityEvent(int paramInt)
  {
    AppMethodBeat.i(159245);
    if (getChildCount() == 1) {
      getChildAt(0).sendAccessibilityEvent(paramInt);
    }
    for (;;)
    {
      super.sendAccessibilityEvent(paramInt);
      AppMethodBeat.o(159245);
      return;
      super.sendAccessibilityEvent(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.o.a
 * JD-Core Version:    0.7.0.1
 */