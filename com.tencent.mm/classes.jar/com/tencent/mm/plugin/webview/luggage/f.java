package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.x5.a.a.a.a.b;

public class f
  extends b
{
  private b uSa;
  
  public f()
  {
    AppMethodBeat.i(6095);
    this.uSa = new b();
    AppMethodBeat.o(6095);
  }
  
  public final void a(b paramb)
  {
    if (paramb != null) {
      this.uSa = paramb;
    }
  }
  
  public void computeScroll(View paramView)
  {
    AppMethodBeat.i(6103);
    this.uSa.computeScroll(paramView);
    AppMethodBeat.o(6103);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(6099);
    boolean bool = this.uSa.dispatchTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(6099);
    return bool;
  }
  
  public void invalidate()
  {
    AppMethodBeat.i(6105);
    this.uSa.invalidate();
    AppMethodBeat.o(6105);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(6098);
    boolean bool = this.uSa.onInterceptTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(6098);
    return bool;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(6096);
    paramString = this.uSa.onMiscCallBack(paramString, paramBundle);
    AppMethodBeat.o(6096);
    return paramString;
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(6102);
    this.uSa.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
    AppMethodBeat.o(6102);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(6101);
    this.uSa.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(6101);
  }
  
  public boolean onShowLongClickPopupMenu()
  {
    AppMethodBeat.i(6104);
    boolean bool = this.uSa.onShowLongClickPopupMenu();
    AppMethodBeat.o(6104);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(6097);
    boolean bool = this.uSa.onTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(6097);
    return bool;
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(6100);
    paramBoolean = this.uSa.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
    AppMethodBeat.o(6100);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.f
 * JD-Core Version:    0.7.0.1
 */