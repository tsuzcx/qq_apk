package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.xweb.o;

final class h$7
  extends f
{
  h$7(h paramh) {}
  
  public final void computeScroll(View paramView)
  {
    h.b(this.rcn).alk();
    super.computeScroll(paramView);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return (h.b(this.rcn).w(paramMotionEvent)) || (super.dispatchTouchEvent(paramMotionEvent, paramView));
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return (h.b(this.rcn).x(paramMotionEvent)) || (super.onInterceptTouchEvent(paramMotionEvent, paramView));
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    return super.onMiscCallBack(paramString, paramBundle);
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    h.b(this.rcn).d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    h.b(this.rcn).onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return (h.b(this.rcn).v(paramMotionEvent)) || (super.onTouchEvent(paramMotionEvent, paramView));
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    return (h.b(this.rcn).b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean)) || (super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.h.7
 * JD-Core Version:    0.7.0.1
 */