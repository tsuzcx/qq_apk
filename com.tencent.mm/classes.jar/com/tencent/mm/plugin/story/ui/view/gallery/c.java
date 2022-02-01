package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.o.a;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDragCloseConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "()V", "downX", "", "downY", "lastScrollType", "", "mStoryView", "Landroid/view/View;", "getMStoryView", "()Landroid/view/View;", "setMStoryView", "(Landroid/view/View;)V", "mWrapperView", "Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "getMWrapperView", "()Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "setMWrapperView", "(Lcom/tencent/mm/ui/widget/listview/PullDownListView;)V", "moveUpLimit", "pointerId", "touchConsumed", "", "touchX", "touchY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "scaleBackOverScroll", "offset", "plugin-story_release"})
public final class c
  extends a
{
  private int Fdm;
  PullDownListView LYL;
  View LYM;
  private int LYN;
  private boolean LYO;
  private int LYP;
  private VelocityTracker bvI;
  private float dit;
  private float diu;
  private float jLa;
  private float jLb;
  
  public c()
  {
    AppMethodBeat.i(120331);
    this.LYN = aw.fromDPToPix(MMApplicationContext.getContext(), 30);
    AppMethodBeat.o(120331);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(120330);
    p.k(paramMotionEvent, "event");
    if (this.bvI == null) {
      this.bvI = VelocityTracker.obtain();
    }
    Object localObject = this.bvI;
    if (localObject != null) {
      ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      paramBoolean = this.LYO;
      AppMethodBeat.o(120330);
      return paramBoolean;
    case 0: 
      this.Fdm = paramMotionEvent.getPointerId(0);
      this.dit = paramMotionEvent.getRawX();
      this.diu = paramMotionEvent.getRawY();
      this.LYO = false;
    }
    for (;;)
    {
      this.LYP = 0;
      break;
      if (!paramBoolean) {
        break;
      }
      this.LYP = paramInt;
      this.jLa = paramMotionEvent.getRawX();
      this.jLb = paramMotionEvent.getRawY();
      float f3 = this.jLb - this.diu;
      localObject = this.bvI;
      if (localObject != null) {
        ((VelocityTracker)localObject).computeCurrentVelocity(1000);
      }
      localObject = this.bvI;
      if (localObject != null) {}
      for (float f1 = ((VelocityTracker)localObject).getXVelocity(this.Fdm);; f1 = 0.0F)
      {
        localObject = this.bvI;
        if (localObject != null) {
          f2 = ((VelocityTracker)localObject).getYVelocity(this.Fdm);
        }
        if (paramInt != 1) {
          break label294;
        }
        this.LYO = true;
        if ((Math.abs(f3) <= this.LYN) || (Math.abs(f2) <= Math.abs(f1))) {
          break;
        }
        localObject = this.LYL;
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
      this.LYO = true;
      paramMotionEvent = this.LYM;
      if (paramMotionEvent != null) {}
      for (paramMotionEvent = paramMotionEvent.getLayoutParams();; paramMotionEvent = null)
      {
        paramMotionEvent = (ViewGroup.MarginLayoutParams)paramMotionEvent;
        if ((this.LYL == null) || (paramMotionEvent == null)) {
          break;
        }
        paramMotionEvent.topMargin = ((int)(f3 / 15.0F));
        localObject = this.LYM;
        if (localObject == null) {
          break;
        }
        ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramMotionEvent);
        break;
      }
      localObject = this.bvI;
      if (localObject != null) {
        ((VelocityTracker)localObject).clear();
      }
      localObject = this.bvI;
      if (localObject != null) {
        ((VelocityTracker)localObject).recycle();
      }
      this.bvI = null;
      if (this.LYP == 1)
      {
        localObject = this.LYL;
        if (localObject != null) {
          ((PullDownListView)localObject).dispatchTouchEvent(paramMotionEvent);
        }
      }
      else if (this.LYP == 2)
      {
        paramMotionEvent = this.LYL;
        if (paramMotionEvent != null) {
          paramMotionEvent.idf();
        }
        localObject = MMApplicationContext.getContext().getSystemService("vibrator");
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
  
  public final int ggJ()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.c
 * JD-Core Version:    0.7.0.1
 */