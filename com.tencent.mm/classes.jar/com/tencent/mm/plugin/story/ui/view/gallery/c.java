package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.j.a;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDragCloseConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "()V", "downX", "", "downY", "lastScrollType", "", "mStoryView", "Landroid/view/View;", "getMStoryView", "()Landroid/view/View;", "setMStoryView", "(Landroid/view/View;)V", "mWrapperView", "Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "getMWrapperView", "()Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "setMWrapperView", "(Lcom/tencent/mm/ui/widget/listview/PullDownListView;)V", "moveUpLimit", "pointerId", "touchConsumed", "", "touchX", "touchY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "scaleBackOverScroll", "offset", "plugin-story_release"})
public final class c
  extends a
{
  PullDownListView BtX;
  View BtY;
  private int BtZ;
  private boolean Bua;
  private int Bub;
  private float cNQ;
  private float cNR;
  private float gpg;
  private float gph;
  private VelocityTracker oj;
  private int wfa;
  
  public c()
  {
    AppMethodBeat.i(120331);
    this.BtZ = aq.fromDPToPix(ak.getContext(), 30);
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
      paramBoolean = this.Bua;
      AppMethodBeat.o(120330);
      return paramBoolean;
    case 0: 
      this.wfa = paramMotionEvent.getPointerId(0);
      this.cNQ = paramMotionEvent.getRawX();
      this.cNR = paramMotionEvent.getRawY();
      this.Bua = false;
    }
    for (;;)
    {
      this.Bub = 0;
      break;
      if (!paramBoolean) {
        break;
      }
      this.Bub = paramInt;
      this.gpg = paramMotionEvent.getRawX();
      this.gph = paramMotionEvent.getRawY();
      float f3 = this.gph - this.cNR;
      localObject = this.oj;
      if (localObject != null) {
        ((VelocityTracker)localObject).computeCurrentVelocity(1000);
      }
      localObject = this.oj;
      if (localObject != null) {}
      for (float f1 = ((VelocityTracker)localObject).getXVelocity(this.wfa);; f1 = 0.0F)
      {
        localObject = this.oj;
        if (localObject != null) {
          f2 = ((VelocityTracker)localObject).getYVelocity(this.wfa);
        }
        if (paramInt != 1) {
          break label294;
        }
        this.Bua = true;
        if ((Math.abs(f3) <= this.BtZ) || (Math.abs(f2) <= Math.abs(f1))) {
          break;
        }
        localObject = this.BtX;
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
      this.Bua = true;
      paramMotionEvent = this.BtY;
      if (paramMotionEvent != null) {}
      for (paramMotionEvent = paramMotionEvent.getLayoutParams();; paramMotionEvent = null)
      {
        paramMotionEvent = (ViewGroup.MarginLayoutParams)paramMotionEvent;
        if ((this.BtX == null) || (paramMotionEvent == null)) {
          break;
        }
        paramMotionEvent.topMargin = ((int)(f3 / 15.0F));
        localObject = this.BtY;
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
      if (this.Bub == 1)
      {
        localObject = this.BtX;
        if (localObject != null) {
          ((PullDownListView)localObject).dispatchTouchEvent(paramMotionEvent);
        }
      }
      else if (this.Bub == 2)
      {
        paramMotionEvent = this.BtX;
        if (paramMotionEvent != null) {
          paramMotionEvent.fQY();
        }
        localObject = ak.getContext().getSystemService("vibrator");
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
  
  public final int epL()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.c
 * JD-Core Version:    0.7.0.1
 */