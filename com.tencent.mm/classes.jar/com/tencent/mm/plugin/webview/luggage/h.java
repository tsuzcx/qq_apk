package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.x5.export.external.extension.proxy.a;

public class h
  extends a
{
  private a WGO;
  
  public h()
  {
    AppMethodBeat.i(78331);
    this.WGO = new a();
    AppMethodBeat.o(78331);
  }
  
  public final void a(a parama)
  {
    if (parama != null) {
      this.WGO = parama;
    }
  }
  
  public void computeScroll(View paramView)
  {
    AppMethodBeat.i(78339);
    this.WGO.computeScroll(paramView);
    AppMethodBeat.o(78339);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(78335);
    boolean bool = this.WGO.dispatchTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(78335);
    return bool;
  }
  
  public void invalidate()
  {
    AppMethodBeat.i(78341);
    this.WGO.invalidate();
    AppMethodBeat.o(78341);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(78334);
    boolean bool = this.WGO.onInterceptTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(78334);
    return bool;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(78332);
    paramString = this.WGO.onMiscCallBack(paramString, paramBundle);
    AppMethodBeat.o(78332);
    return paramString;
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(78338);
    this.WGO.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
    AppMethodBeat.o(78338);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(78337);
    this.WGO.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(78337);
  }
  
  public boolean onShowLongClickPopupMenu()
  {
    AppMethodBeat.i(78340);
    boolean bool = this.WGO.onShowLongClickPopupMenu();
    AppMethodBeat.o(78340);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(78333);
    boolean bool = this.WGO.onTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(78333);
    return bool;
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(78336);
    paramBoolean = this.WGO.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
    AppMethodBeat.o(78336);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.h
 * JD-Core Version:    0.7.0.1
 */