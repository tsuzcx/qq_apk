package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.j.a;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDragCloseConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "()V", "downX", "", "downY", "lastScrollType", "", "mStoryView", "Landroid/view/View;", "getMStoryView", "()Landroid/view/View;", "setMStoryView", "(Landroid/view/View;)V", "mWrapperView", "Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "getMWrapperView", "()Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "setMWrapperView", "(Lcom/tencent/mm/ui/widget/listview/PullDownListView;)V", "moveUpLimit", "pointerId", "touchConsumed", "", "touchX", "touchY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "scaleBackOverScroll", "offset", "plugin-story_release"})
public final class c
  extends a
{
  private float cEZ;
  private float cFa;
  private float fPl;
  private float fPm;
  private VelocityTracker lr;
  private int tHq;
  PullDownListView yxJ;
  View yxK;
  private int yxL;
  private boolean yxM;
  private int yxN;
  
  public c()
  {
    AppMethodBeat.i(120331);
    this.yxL = ao.fromDPToPix(aj.getContext(), 30);
    AppMethodBeat.o(120331);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(120330);
    k.h(paramMotionEvent, "event");
    if (this.lr == null) {
      this.lr = VelocityTracker.obtain();
    }
    Object localObject = this.lr;
    if (localObject != null) {
      ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      paramBoolean = this.yxM;
      AppMethodBeat.o(120330);
      return paramBoolean;
    case 0: 
      this.tHq = paramMotionEvent.getPointerId(0);
      this.cEZ = paramMotionEvent.getRawX();
      this.cFa = paramMotionEvent.getRawY();
      this.yxM = false;
    }
    for (;;)
    {
      this.yxN = 0;
      break;
      if (!paramBoolean) {
        break;
      }
      this.yxN = paramInt;
      this.fPl = paramMotionEvent.getRawX();
      this.fPm = paramMotionEvent.getRawY();
      float f3 = this.fPm - this.cFa;
      localObject = this.lr;
      if (localObject != null) {
        ((VelocityTracker)localObject).computeCurrentVelocity(1000);
      }
      localObject = this.lr;
      if (localObject != null) {}
      for (float f1 = ((VelocityTracker)localObject).getXVelocity(this.tHq);; f1 = 0.0F)
      {
        localObject = this.lr;
        if (localObject != null) {
          f2 = ((VelocityTracker)localObject).getYVelocity(this.tHq);
        }
        if (paramInt != 1) {
          break label294;
        }
        this.yxM = true;
        if ((Math.abs(f3) <= this.yxL) || (Math.abs(f2) <= Math.abs(f1))) {
          break;
        }
        localObject = this.yxJ;
        if (localObject == null) {
          break;
        }
        ((PullDownListView)localObject).dispatchTouchEvent(paramMotionEvent);
        break;
      }
      label294:
      if (paramInt != 2) {
        break;
      }
      this.yxM = true;
      paramMotionEvent = this.yxK;
      if (paramMotionEvent != null) {}
      for (paramMotionEvent = paramMotionEvent.getLayoutParams();; paramMotionEvent = null)
      {
        paramMotionEvent = (ViewGroup.MarginLayoutParams)paramMotionEvent;
        if ((this.yxJ == null) || (paramMotionEvent == null)) {
          break;
        }
        paramMotionEvent.topMargin = ((int)(f3 / 15.0F));
        localObject = this.yxK;
        if (localObject == null) {
          break;
        }
        ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramMotionEvent);
        break;
      }
      localObject = this.lr;
      if (localObject != null) {
        ((VelocityTracker)localObject).clear();
      }
      localObject = this.lr;
      if (localObject != null) {
        ((VelocityTracker)localObject).recycle();
      }
      this.lr = null;
      if (this.yxN == 1)
      {
        localObject = this.yxJ;
        if (localObject != null) {
          ((PullDownListView)localObject).dispatchTouchEvent(paramMotionEvent);
        }
      }
      else if (this.yxN == 2)
      {
        paramMotionEvent = this.yxJ;
        if (paramMotionEvent != null) {
          paramMotionEvent.ffR();
        }
        localObject = aj.getContext().getSystemService("vibrator");
        paramMotionEvent = (MotionEvent)localObject;
        if (!(localObject instanceof Vibrator)) {
          paramMotionEvent = null;
        }
        paramMotionEvent = (Vibrator)paramMotionEvent;
        if (paramMotionEvent != null) {
          paramMotionEvent.vibrate(10L);
        }
      }
    }
  }
  
  public final int dLn()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.c
 * JD-Core Version:    0.7.0.1
 */