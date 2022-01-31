package com.tencent.xweb.x5;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.smtt.sdk.WebViewCallbackClient;
import com.tencent.xweb.o;

public final class a$f
  implements WebViewCallbackClient
{
  o xkn;
  
  public a$f(o paramo)
  {
    this.xkn = paramo;
  }
  
  public final void computeScroll(View paramView)
  {
    if (this.xkn != null) {
      this.xkn.alk();
    }
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    if (this.xkn != null) {
      return this.xkn.w(paramMotionEvent);
    }
    return false;
  }
  
  public final void invalidate() {}
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    if (this.xkn != null) {
      return this.xkn.x(paramMotionEvent);
    }
    return false;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    if (this.xkn != null) {
      this.xkn.d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    }
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (this.xkn != null) {
      this.xkn.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    if (this.xkn != null) {
      return this.xkn.v(paramMotionEvent);
    }
    return false;
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    if (this.xkn != null) {
      return this.xkn.b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.x5.a.f
 * JD-Core Version:    0.7.0.1
 */