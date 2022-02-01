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
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.o.a;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDragCloseConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "()V", "downX", "", "downY", "lastScrollType", "", "mStoryView", "Landroid/view/View;", "getMStoryView", "()Landroid/view/View;", "setMStoryView", "(Landroid/view/View;)V", "mWrapperView", "Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "getMWrapperView", "()Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "setMWrapperView", "(Lcom/tencent/mm/ui/widget/listview/PullDownListView;)V", "moveUpLimit", "pointerId", "touchConsumed", "", "touchX", "touchY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "scaleBackOverScroll", "offset", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  private int KYV;
  PullDownListView SAj;
  View SAk;
  private int SAl;
  private boolean SAm;
  private int SAn;
  private VelocityTracker doL;
  private float fif;
  private float fig;
  private float mkm;
  private float mkn;
  
  public c()
  {
    AppMethodBeat.i(120331);
    this.SAl = bd.fromDPToPix(MMApplicationContext.getContext(), 30);
    AppMethodBeat.o(120331);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(120330);
    s.u(paramMotionEvent, "event");
    if (this.doL == null) {
      this.doL = VelocityTracker.obtain();
    }
    Object localObject = this.doL;
    if (localObject != null) {
      ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      paramBoolean = this.SAm;
      AppMethodBeat.o(120330);
      return paramBoolean;
    case 0: 
      this.KYV = paramMotionEvent.getPointerId(0);
      this.fif = paramMotionEvent.getRawX();
      this.fig = paramMotionEvent.getRawY();
      this.SAm = false;
    }
    label515:
    for (;;)
    {
      this.SAn = 0;
      break;
      if (!paramBoolean) {
        break;
      }
      this.SAn = paramInt;
      this.mkm = paramMotionEvent.getRawX();
      this.mkn = paramMotionEvent.getRawY();
      float f3 = this.mkn - this.fig;
      localObject = this.doL;
      if (localObject != null) {
        ((VelocityTracker)localObject).computeCurrentVelocity(1000);
      }
      localObject = this.doL;
      float f1;
      if (localObject == null)
      {
        f1 = 0.0F;
        label199:
        localObject = this.doL;
        if (localObject != null) {
          break label303;
        }
      }
      for (;;)
      {
        switch (paramInt)
        {
        default: 
          break;
        case 1: 
          this.SAm = true;
          if ((Math.abs(f3) <= this.SAl) || (Math.abs(f2) <= Math.abs(f1))) {
            break;
          }
          localObject = this.SAj;
          if (localObject == null) {
            break;
          }
          ((PullDownListView)localObject).dispatchTouchEvent(paramMotionEvent);
          break;
          f1 = ((VelocityTracker)localObject).getXVelocity(this.KYV);
          break label199;
          label303:
          f2 = ((VelocityTracker)localObject).getYVelocity(this.KYV);
        }
      }
      this.SAm = true;
      paramMotionEvent = this.SAk;
      if (paramMotionEvent == null) {}
      for (paramMotionEvent = null;; paramMotionEvent = paramMotionEvent.getLayoutParams())
      {
        paramMotionEvent = (ViewGroup.MarginLayoutParams)paramMotionEvent;
        if ((this.SAj == null) || (paramMotionEvent == null)) {
          break;
        }
        paramMotionEvent.topMargin = ((int)(f3 / 15.0F));
        localObject = this.SAk;
        if (localObject == null) {
          break;
        }
        ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramMotionEvent);
        break;
      }
      localObject = this.doL;
      if (localObject != null) {
        ((VelocityTracker)localObject).clear();
      }
      localObject = this.doL;
      if (localObject != null) {
        ((VelocityTracker)localObject).recycle();
      }
      this.doL = null;
      if (this.SAn == 1)
      {
        localObject = this.SAj;
        if (localObject != null) {
          ((PullDownListView)localObject).dispatchTouchEvent(paramMotionEvent);
        }
      }
      else if (this.SAn == 2)
      {
        paramMotionEvent = this.SAj;
        if (paramMotionEvent != null) {
          paramMotionEvent.jIr();
        }
        paramMotionEvent = MMApplicationContext.getContext().getSystemService("vibrator");
        if ((paramMotionEvent instanceof Vibrator)) {}
        for (paramMotionEvent = (Vibrator)paramMotionEvent;; paramMotionEvent = null)
        {
          if (paramMotionEvent == null) {
            break label515;
          }
          paramMotionEvent.vibrate(10L);
          break;
        }
      }
    }
  }
  
  public final int hAc()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.c
 * JD-Core Version:    0.7.0.1
 */