package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import android.view.MotionEvent;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollConsumer;", "", "()V", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "", "getScrollDirection", "onFling", "", "velocityX", "", "velocityY", "onScroll", "scrollX", "scrollY", "consumed", "", "onStopScroll", "plugin-story_release"})
public abstract class e
{
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    j.q(paramMotionEvent, "event");
    return false;
  }
  
  public abstract int cFW();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.e
 * JD-Core Version:    0.7.0.1
 */