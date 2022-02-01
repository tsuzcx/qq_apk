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
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.j.a;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDragCloseConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "()V", "downX", "", "downY", "lastScrollType", "", "mStoryView", "Landroid/view/View;", "getMStoryView", "()Landroid/view/View;", "setMStoryView", "(Landroid/view/View;)V", "mWrapperView", "Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "getMWrapperView", "()Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "setMWrapperView", "(Lcom/tencent/mm/ui/widget/listview/PullDownListView;)V", "moveUpLimit", "pointerId", "touchConsumed", "", "touchX", "touchY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "scaleBackOverScroll", "offset", "plugin-story_release"})
public final class c
  extends a
{
  View BcA;
  private int BcB;
  private boolean BcC;
  private int BcD;
  PullDownListView Bcz;
  private float cNg;
  private float cNh;
  private float gmK;
  private float gmL;
  private VelocityTracker oj;
  private int vSW;
  
  public c()
  {
    AppMethodBeat.i(120331);
    this.BcB = aq.fromDPToPix(aj.getContext(), 30);
    AppMethodBeat.o(120331);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(120330);
    p.h(paramMotionEvent, "event");
    if (this.oj == null) {
      this.oj = VelocityTracker.obtain();
    }
    Object localObject = this.oj;
    if (localObject != null) {
      ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      paramBoolean = this.BcC;
      AppMethodBeat.o(120330);
      return paramBoolean;
    case 0: 
      this.vSW = paramMotionEvent.getPointerId(0);
      this.cNg = paramMotionEvent.getRawX();
      this.cNh = paramMotionEvent.getRawY();
      this.BcC = false;
    }
    for (;;)
    {
      this.BcD = 0;
      break;
      if (!paramBoolean) {
        break;
      }
      this.BcD = paramInt;
      this.gmK = paramMotionEvent.getRawX();
      this.gmL = paramMotionEvent.getRawY();
      float f3 = this.gmL - this.cNh;
      localObject = this.oj;
      if (localObject != null) {
        ((VelocityTracker)localObject).computeCurrentVelocity(1000);
      }
      localObject = this.oj;
      if (localObject != null) {}
      for (float f1 = ((VelocityTracker)localObject).getXVelocity(this.vSW);; f1 = 0.0F)
      {
        localObject = this.oj;
        if (localObject != null) {
          f2 = ((VelocityTracker)localObject).getYVelocity(this.vSW);
        }
        if (paramInt != 1) {
          break label294;
        }
        this.BcC = true;
        if ((Math.abs(f3) <= this.BcB) || (Math.abs(f2) <= Math.abs(f1))) {
          break;
        }
        localObject = this.Bcz;
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
      this.BcC = true;
      paramMotionEvent = this.BcA;
      if (paramMotionEvent != null) {}
      for (paramMotionEvent = paramMotionEvent.getLayoutParams();; paramMotionEvent = null)
      {
        paramMotionEvent = (ViewGroup.MarginLayoutParams)paramMotionEvent;
        if ((this.Bcz == null) || (paramMotionEvent == null)) {
          break;
        }
        paramMotionEvent.topMargin = ((int)(f3 / 15.0F));
        localObject = this.BcA;
        if (localObject == null) {
          break;
        }
        ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramMotionEvent);
        break;
      }
      localObject = this.oj;
      if (localObject != null) {
        ((VelocityTracker)localObject).clear();
      }
      localObject = this.oj;
      if (localObject != null) {
        ((VelocityTracker)localObject).recycle();
      }
      this.oj = null;
      if (this.BcD == 1)
      {
        localObject = this.Bcz;
        if (localObject != null) {
          ((PullDownListView)localObject).dispatchTouchEvent(paramMotionEvent);
        }
      }
      else if (this.BcD == 2)
      {
        paramMotionEvent = this.Bcz;
        if (paramMotionEvent != null) {
          paramMotionEvent.fME();
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
  
  public final int emc()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.c
 * JD-Core Version:    0.7.0.1
 */