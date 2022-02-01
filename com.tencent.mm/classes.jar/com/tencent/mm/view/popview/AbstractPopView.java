package com.tencent.mm.view.popview;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;

public abstract class AbstractPopView
  extends FrameLayout
{
  protected a YRx;
  protected int YRy = 0;
  
  public AbstractPopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AbstractPopView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void dismiss()
  {
    if (this.YRx != null) {
      this.YRx.onDismiss();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (getKeyDispatcherState() == null) {
        bool = super.dispatchKeyEvent(paramKeyEvent);
      }
      KeyEvent.DispatcherState localDispatcherState;
      do
      {
        return bool;
        if ((paramKeyEvent.getAction() != 0) || (paramKeyEvent.getRepeatCount() != 0)) {
          break;
        }
        localDispatcherState = getKeyDispatcherState();
      } while (localDispatcherState == null);
      localDispatcherState.startTracking(paramKeyEvent, this);
      return true;
      if (paramKeyEvent.getAction() == 1)
      {
        localDispatcherState = getKeyDispatcherState();
        if ((localDispatcherState != null) && (localDispatcherState.isTracking(paramKeyEvent)) && (!paramKeyEvent.isCanceled()))
        {
          dismiss();
          return true;
        }
      }
      return super.dispatchKeyEvent(paramKeyEvent);
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public abstract WindowManager.LayoutParams getWindowLayoutParams();
  
  public abstract void jd(View paramView);
  
  protected final void lK(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {}
    for (paramContext = (Activity)paramContext;; paramContext = null)
    {
      this.YRy = 0;
      if (paramContext != null)
      {
        paramContext = paramContext.findViewById(16908290);
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        paramContext.getLocationOnScreen(arrayOfInt1);
        paramContext.getLocationInWindow(arrayOfInt2);
        this.YRy = (arrayOfInt1[1] - arrayOfInt2[1]);
      }
      return;
      if ((paramContext instanceof ContextThemeWrapper))
      {
        paramContext = ((ContextThemeWrapper)paramContext).getBaseContext();
        break;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if ((paramMotionEvent.getAction() == 0) && ((i < 0) || (i >= getWidth()) || (j < 0) || (j >= getHeight())))
    {
      dismiss();
      return true;
    }
    if (paramMotionEvent.getAction() == 4)
    {
      dismiss();
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnDismissCallback(a parama)
  {
    this.YRx = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.popview.AbstractPopView
 * JD-Core Version:    0.7.0.1
 */