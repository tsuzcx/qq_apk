package com.tencent.mm.ui.m;

import android.view.MotionEvent;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "", "()V", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "", "getScrollDirection", "onFling", "", "velocityX", "", "velocityY", "onScroll", "scrollX", "scrollY", "consumed", "", "onStopScroll", "libmmui_release"})
public abstract class a
{
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    p.h(paramMotionEvent, "event");
    return false;
  }
  
  public abstract int fsk();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.m.a
 * JD-Core Version:    0.7.0.1
 */