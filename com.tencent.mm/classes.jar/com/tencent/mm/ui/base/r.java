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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.av;

public class r
  extends PopupWindow
{
  private View.OnTouchListener Wla;
  private Context mContext;
  
  public r(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159247);
    this.mContext = null;
    this.mContext = paramContext;
    super.setBackgroundDrawable(null);
    setContentView(new a(this.mContext));
    AppMethodBeat.o(159247);
  }
  
  public r(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(159248);
    this.mContext = null;
    super.setBackgroundDrawable(null);
    AppMethodBeat.o(159248);
  }
  
  public r(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    AppMethodBeat.i(159249);
    this.mContext = null;
    super.setBackgroundDrawable(null);
    AppMethodBeat.o(159249);
  }
  
  public r(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.i(159250);
    this.mContext = null;
    super.setBackgroundDrawable(null);
    AppMethodBeat.o(159250);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(159251);
    try
    {
      super.dismiss();
      AppMethodBeat.o(159251);
      return;
    }
    catch (Exception localException)
    {
      av.e("MicroMsg.MMPopupWindow", "dismiss exception, e = " + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(159251);
    }
  }
  
  public Drawable getBackground()
  {
    AppMethodBeat.i(159252);
    Object localObject = getContentView();
    if (localObject == null)
    {
      AppMethodBeat.o(159252);
      return null;
    }
    if ((localObject instanceof a))
    {
      localObject = ((View)localObject).getBackground();
      AppMethodBeat.o(159252);
      return localObject;
    }
    AppMethodBeat.o(159252);
    return null;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    int i = -2;
    AppMethodBeat.i(159254);
    View localView = getContentView();
    if (localView == null)
    {
      AppMethodBeat.o(159254);
      return;
    }
    Object localObject1 = localView.getContext();
    if ((localView instanceof a))
    {
      localView.setBackgroundDrawable(paramDrawable);
      AppMethodBeat.o(159254);
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
      AppMethodBeat.o(159254);
      return;
      i = -1;
    }
  }
  
  public void setContentView(View paramView)
  {
    int i = -2;
    AppMethodBeat.i(159253);
    Object localObject = getContentView();
    if (localObject == null) {
      super.setContentView(paramView);
    }
    while (!(localObject instanceof a))
    {
      super.setContentView(paramView);
      AppMethodBeat.o(159253);
      return;
    }
    localObject = (a)localObject;
    ((a)localObject).removeAllViews();
    if (paramView == null)
    {
      super.setContentView((View)localObject);
      AppMethodBeat.o(159253);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height == -2)) {}
    for (;;)
    {
      ((a)localObject).addView(paramView, new FrameLayout.LayoutParams(-1, i));
      super.setContentView((View)localObject);
      AppMethodBeat.o(159253);
      return;
      i = -1;
    }
  }
  
  public void setTouchInterceptor(View.OnTouchListener paramOnTouchListener)
  {
    this.Wla = paramOnTouchListener;
  }
  
  final class a
    extends FrameLayout
  {
    a(Context paramContext)
    {
      super();
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
            r.this.dismiss();
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
      if ((r.a(r.this) != null) && (r.a(r.this).onTouch(this, paramMotionEvent)))
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
        r.this.dismiss();
        AppMethodBeat.o(159244);
        return true;
      }
      if (paramMotionEvent.getAction() == 4)
      {
        r.this.dismiss();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.r
 * JD-Core Version:    0.7.0.1
 */