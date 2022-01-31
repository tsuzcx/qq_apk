package com.tencent.mm.plugin.webview.luggage;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.xweb.o;

final class h$8
  implements o
{
  h$8(h paramh) {}
  
  public final void alk()
  {
    this.rcn.cJU();
  }
  
  public final boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return this.rcn.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }
  
  @TargetApi(9)
  public final void d(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.rcn.e(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    this.rcn.F(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final boolean v(MotionEvent paramMotionEvent)
  {
    return this.rcn.L(paramMotionEvent);
  }
  
  public final boolean w(MotionEvent paramMotionEvent)
  {
    return this.rcn.M(paramMotionEvent);
  }
  
  public final boolean x(MotionEvent paramMotionEvent)
  {
    return this.rcn.N(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.h.8
 * JD-Core Version:    0.7.0.1
 */