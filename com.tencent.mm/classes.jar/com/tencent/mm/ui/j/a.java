package com.tencent.mm.ui.j;

import android.view.MotionEvent;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "", "()V", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "", "getScrollDirection", "onFling", "", "velocityX", "", "velocityY", "onScroll", "scrollX", "scrollY", "consumed", "", "onStopScroll", "libmmui_release"})
public abstract class a
{
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    p.h(paramMotionEvent, "event");
    return false;
  }
  
  public abstract int epL();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.j.a
 * JD-Core Version:    0.7.0.1
 */