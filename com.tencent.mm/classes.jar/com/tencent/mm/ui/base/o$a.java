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
    AppMethodBeat.i(112559);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (getKeyDispatcherState() == null)
      {
        bool = super.dispatchKeyEvent(paramKeyEvent);
        AppMethodBeat.o(112559);
        return bool;
      }
      KeyEvent.DispatcherState localDispatcherState;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.startTracking(paramKeyEvent, this);
        }
        AppMethodBeat.o(112559);
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localDispatcherState = getKeyDispatcherState();
        if ((localDispatcherState != null) && (localDispatcherState.isTracking(paramKeyEvent)) && (!paramKeyEvent.isCanceled()))
        {
          this.zld.dismiss();
          AppMethodBeat.o(112559);
          return true;
        }
      }
      bool = super.dispatchKeyEvent(paramKeyEvent);
      AppMethodBeat.o(112559);
      return bool;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(112559);
    return bool;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(112560);
    if ((o.a(this.zld) != null) && (o.a(this.zld).onTouch(this, paramMotionEvent)))
    {
      AppMethodBeat.o(112560);
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(112560);
    return bool;
  }
  
  protected final int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(112558);
    int[] arrayOfInt = super.onCreateDrawableState(paramInt);
    AppMethodBeat.o(112558);
    return arrayOfInt;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(112561);
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if ((paramMotionEvent.getAction() == 0) && ((i < 0) || (i >= getWidth()) || (j < 0) || (j >= getHeight())))
    {
      this.zld.dismiss();
      AppMethodBeat.o(112561);
      return true;
    }
    if (paramMotionEvent.getAction() == 4)
    {
      this.zld.dismiss();
      AppMethodBeat.o(112561);
      return true;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(112561);
    return bool;
  }
  
  public final void sendAccessibilityEvent(int paramInt)
  {
    AppMethodBeat.i(112562);
    if (getChildCount() == 1) {
      getChildAt(0).sendAccessibilityEvent(paramInt);
    }
    for (;;)
    {
      super.sendAccessibilityEvent(paramInt);
      AppMethodBeat.o(112562);
      return;
      super.sendAccessibilityEvent(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.o.a
 * JD-Core Version:    0.7.0.1
 */