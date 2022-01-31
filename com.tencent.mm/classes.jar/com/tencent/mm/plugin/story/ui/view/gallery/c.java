package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.listview.PullDownListView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDragCloseConsumer;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollConsumer;", "()V", "downX", "", "downY", "lastScrollType", "", "mStoryView", "Landroid/view/View;", "getMStoryView", "()Landroid/view/View;", "setMStoryView", "(Landroid/view/View;)V", "mWrapperView", "Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "getMWrapperView", "()Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "setMWrapperView", "(Lcom/tencent/mm/ui/widget/listview/PullDownListView;)V", "moveUpLimit", "pointerId", "touchConsumed", "", "touchX", "touchY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "scaleBackOverScroll", "offset", "plugin-story_release"})
public final class c
  extends e
{
  private float bTE;
  private float bTF;
  private float fac;
  private float fad;
  private VelocityTracker gie;
  private int oMf;
  PullDownListView sRH;
  View sRI;
  private int sRJ;
  private boolean sRK;
  private int sRL;
  
  public c()
  {
    AppMethodBeat.i(110709);
    this.sRJ = al.fromDPToPix(ah.getContext(), 30);
    AppMethodBeat.o(110709);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(110708);
    j.q(paramMotionEvent, "event");
    if (this.gie == null) {
      this.gie = VelocityTracker.obtain();
    }
    Object localObject = this.gie;
    if (localObject != null) {
      ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      paramBoolean = this.sRK;
      AppMethodBeat.o(110708);
      return paramBoolean;
      this.oMf = paramMotionEvent.getPointerId(0);
      this.bTE = paramMotionEvent.getRawX();
      this.bTF = paramMotionEvent.getRawY();
      this.sRK = false;
      this.sRL = 0;
      continue;
      if (paramBoolean)
      {
        this.sRL = paramInt;
        this.fac = paramMotionEvent.getRawX();
        this.fad = paramMotionEvent.getRawY();
        float f3 = this.fad - this.bTF;
        localObject = this.gie;
        if (localObject != null) {
          ((VelocityTracker)localObject).computeCurrentVelocity(1000);
        }
        localObject = this.gie;
        if (localObject != null) {}
        for (float f1 = ((VelocityTracker)localObject).getXVelocity(this.oMf);; f1 = 0.0F)
        {
          localObject = this.gie;
          if (localObject != null) {
            f2 = ((VelocityTracker)localObject).getYVelocity(this.oMf);
          }
          if (paramInt != 1) {
            break label294;
          }
          this.sRK = true;
          if ((Math.abs(f3) <= this.sRJ) || (Math.abs(f2) <= Math.abs(f1))) {
            break;
          }
          localObject = this.sRH;
          if (localObject == null) {
            break;
          }
          ((PullDownListView)localObject).dispatchTouchEvent(paramMotionEvent);
          break;
        }
        label294:
        if (paramInt == 2)
        {
          this.sRK = true;
          paramMotionEvent = this.sRI;
          if (paramMotionEvent != null) {}
          for (paramMotionEvent = paramMotionEvent.getLayoutParams();; paramMotionEvent = null)
          {
            paramMotionEvent = (ViewGroup.MarginLayoutParams)paramMotionEvent;
            if ((this.sRH == null) || (paramMotionEvent == null)) {
              break;
            }
            paramMotionEvent.topMargin = ((int)(f3 / 15.0F));
            localObject = this.sRI;
            if (localObject == null) {
              break;
            }
            ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramMotionEvent);
            break;
          }
          localObject = this.gie;
          if (localObject != null) {
            ((VelocityTracker)localObject).clear();
          }
          localObject = this.gie;
          if (localObject != null) {
            ((VelocityTracker)localObject).recycle();
          }
          this.gie = null;
          if (this.sRL == 1)
          {
            localObject = this.sRH;
            if (localObject != null) {
              ((PullDownListView)localObject).dispatchTouchEvent(paramMotionEvent);
            }
          }
          else if (this.sRL == 2)
          {
            paramMotionEvent = this.sRH;
            if (paramMotionEvent != null) {
              paramMotionEvent.dPi();
            }
            localObject = ah.getContext().getSystemService("vibrator");
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
    }
  }
  
  public final int cFW()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.c
 * JD-Core Version:    0.7.0.1
 */