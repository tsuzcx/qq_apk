package com.tencent.xweb.x5;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebViewCallbackClient;
import com.tencent.xweb.v;

public final class a$f
  implements WebViewCallbackClient
{
  v BHS;
  
  public a$f(v paramv)
  {
    this.BHS = paramv;
  }
  
  public final void computeScroll(View paramView)
  {
    AppMethodBeat.i(84791);
    if (this.BHS != null) {
      this.BHS.aGl();
    }
    AppMethodBeat.o(84791);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(84790);
    if (this.BHS != null)
    {
      boolean bool = this.BHS.B(paramMotionEvent);
      AppMethodBeat.o(84790);
      return bool;
    }
    AppMethodBeat.o(84790);
    return false;
  }
  
  public final void invalidate() {}
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(84793);
    if (this.BHS != null)
    {
      boolean bool = this.BHS.C(paramMotionEvent);
      AppMethodBeat.o(84793);
      return bool;
    }
    AppMethodBeat.o(84793);
    return false;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(84792);
    if (this.BHS != null) {
      this.BHS.d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(84792);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(84794);
    if (this.BHS != null) {
      this.BHS.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    }
    AppMethodBeat.o(84794);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(84788);
    if (this.BHS != null)
    {
      boolean bool = this.BHS.A(paramMotionEvent);
      AppMethodBeat.o(84788);
      return bool;
    }
    AppMethodBeat.o(84788);
    return false;
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(84789);
    if (this.BHS != null)
    {
      paramBoolean = this.BHS.b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      AppMethodBeat.o(84789);
      return paramBoolean;
    }
    AppMethodBeat.o(84789);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.x5.a.f
 * JD-Core Version:    0.7.0.1
 */