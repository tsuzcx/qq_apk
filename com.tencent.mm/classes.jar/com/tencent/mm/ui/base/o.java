package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.mm.ui.ao;

public class o
  extends PopupWindow
{
  private Context mContext = null;
  private View.OnTouchListener uWJ;
  
  public o(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    super.setBackgroundDrawable(null);
    setContentView(new a(this.mContext));
  }
  
  public o(View paramView)
  {
    super(paramView);
    super.setBackgroundDrawable(null);
  }
  
  public o(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    super.setBackgroundDrawable(null);
  }
  
  public o(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
    super.setBackgroundDrawable(null);
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      ao.v("dismiss exception, e = " + localException.getMessage(), new Object[0]);
    }
  }
  
  public Drawable getBackground()
  {
    View localView = getContentView();
    if (localView == null) {}
    while (!(localView instanceof a)) {
      return null;
    }
    return localView.getBackground();
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    int i = -2;
    View localView = getContentView();
    if (localView == null) {
      return;
    }
    Object localObject1 = localView.getContext();
    if ((localView instanceof a))
    {
      localView.setBackgroundDrawable(paramDrawable);
      return;
    }
    Object localObject2 = localView.getLayoutParams();
    if ((localObject2 != null) && (((ViewGroup.LayoutParams)localObject2).height == -2)) {}
    for (;;)
    {
      localObject1 = new a((Context)localObject1);
      localObject2 = new FrameLayout.LayoutParams(-1, i);
      ((a)localObject1).setBackgroundDrawable(paramDrawable);
      ((a)localObject1).addView(localView, (ViewGroup.LayoutParams)localObject2);
      super.setContentView((View)localObject1);
      return;
      i = -1;
    }
  }
  
  public void setContentView(View paramView)
  {
    int i = -2;
    Object localObject = getContentView();
    if (localObject == null) {
      super.setContentView(paramView);
    }
    while (!(localObject instanceof a))
    {
      super.setContentView(paramView);
      return;
    }
    localObject = (a)localObject;
    ((a)localObject).removeAllViews();
    if (paramView == null)
    {
      super.setContentView((View)localObject);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height == -2)) {}
    for (;;)
    {
      ((a)localObject).addView(paramView, new FrameLayout.LayoutParams(-1, i));
      super.setContentView((View)localObject);
      return;
      i = -1;
    }
  }
  
  public void setTouchInterceptor(View.OnTouchListener paramOnTouchListener)
  {
    this.uWJ = paramOnTouchListener;
  }
  
  private final class a
    extends FrameLayout
  {
    a(Context paramContext)
    {
      super();
    }
    
    public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
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
            o.this.dismiss();
            return true;
          }
        }
        return super.dispatchKeyEvent(paramKeyEvent);
      }
      return super.dispatchKeyEvent(paramKeyEvent);
    }
    
    public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      if ((o.a(o.this) != null) && (o.a(o.this).onTouch(this, paramMotionEvent))) {
        return true;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    
    protected final int[] onCreateDrawableState(int paramInt)
    {
      return super.onCreateDrawableState(paramInt);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((paramMotionEvent.getAction() == 0) && ((i < 0) || (i >= getWidth()) || (j < 0) || (j >= getHeight())))
      {
        o.this.dismiss();
        return true;
      }
      if (paramMotionEvent.getAction() == 4)
      {
        o.this.dismiss();
        return true;
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    
    public final void sendAccessibilityEvent(int paramInt)
    {
      if (getChildCount() == 1) {
        getChildAt(0).sendAccessibilityEvent(paramInt);
      }
      for (;;)
      {
        super.sendAccessibilityEvent(paramInt);
        return;
        super.sendAccessibilityEvent(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.o
 * JD-Core Version:    0.7.0.1
 */