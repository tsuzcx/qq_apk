package com.tencent.mm.plugin.webview.luggage.d;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.xweb.v;

final class a$7
  extends f
{
  a$7(a parama) {}
  
  public final void computeScroll(View paramView)
  {
    AppMethodBeat.i(6526);
    a.a(this.uUY).aGl();
    super.computeScroll(paramView);
    AppMethodBeat.o(6526);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(6522);
    if ((a.a(this.uUY).B(paramMotionEvent)) || (super.dispatchTouchEvent(paramMotionEvent, paramView)))
    {
      AppMethodBeat.o(6522);
      return true;
    }
    AppMethodBeat.o(6522);
    return false;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(6521);
    if ((a.a(this.uUY).C(paramMotionEvent)) || (super.onInterceptTouchEvent(paramMotionEvent, paramView)))
    {
      AppMethodBeat.o(6521);
      return true;
    }
    AppMethodBeat.o(6521);
    return false;
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(6519);
    paramString = super.onMiscCallBack(paramString, paramBundle);
    AppMethodBeat.o(6519);
    return paramString;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(6525);
    a.a(this.uUY).d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
    AppMethodBeat.o(6525);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(6524);
    a.a(this.uUY).onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(6524);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(6520);
    if ((a.a(this.uUY).A(paramMotionEvent)) || (super.onTouchEvent(paramMotionEvent, paramView)))
    {
      AppMethodBeat.o(6520);
      return true;
    }
    AppMethodBeat.o(6520);
    return false;
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(6523);
    if ((a.a(this.uUY).b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean)) || (super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView)))
    {
      AppMethodBeat.o(6523);
      return true;
    }
    AppMethodBeat.o(6523);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d.a.7
 * JD-Core Version:    0.7.0.1
 */