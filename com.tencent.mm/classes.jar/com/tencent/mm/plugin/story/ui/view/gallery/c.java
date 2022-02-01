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
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.m.a;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDragCloseConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "()V", "downX", "", "downY", "lastScrollType", "", "mStoryView", "Landroid/view/View;", "getMStoryView", "()Landroid/view/View;", "setMStoryView", "(Landroid/view/View;)V", "mWrapperView", "Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "getMWrapperView", "()Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "setMWrapperView", "(Lcom/tencent/mm/ui/widget/listview/PullDownListView;)V", "moveUpLimit", "pointerId", "touchConsumed", "", "touchX", "touchY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "scaleBackOverScroll", "offset", "plugin-story_release"})
public final class c
  extends a
{
  PullDownListView FEK;
  View FEL;
  private int FEM;
  private boolean FEN;
  private int FEO;
  private float deo;
  private float dep;
  private float gZZ;
  private float haa;
  private VelocityTracker ol;
  private int zxS;
  
  public c()
  {
    AppMethodBeat.i(120331);
    this.FEM = at.fromDPToPix(MMApplicationContext.getContext(), 30);
    AppMethodBeat.o(120331);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(120330);
    p.h(paramMotionEvent, "event");
    if (this.ol == null) {
      this.ol = VelocityTracker.obtain();
    }
    Object localObject = this.ol;
    if (localObject != null) {
      ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      paramBoolean = this.FEN;
      AppMethodBeat.o(120330);
      return paramBoolean;
    case 0: 
      this.zxS = paramMotionEvent.getPointerId(0);
      this.deo = paramMotionEvent.getRawX();
      this.dep = paramMotionEvent.getRawY();
      this.FEN = false;
    }
    for (;;)
    {
      this.FEO = 0;
      break;
      if (!paramBoolean) {
        break;
      }
      this.FEO = paramInt;
      this.gZZ = paramMotionEvent.getRawX();
      this.haa = paramMotionEvent.getRawY();
      float f3 = this.haa - this.dep;
      localObject = this.ol;
      if (localObject != null) {
        ((VelocityTracker)localObject).computeCurrentVelocity(1000);
      }
      localObject = this.ol;
      if (localObject != null) {}
      for (float f1 = ((VelocityTracker)localObject).getXVelocity(this.zxS);; f1 = 0.0F)
      {
        localObject = this.ol;
        if (localObject != null) {
          f2 = ((VelocityTracker)localObject).getYVelocity(this.zxS);
        }
        if (paramInt != 1) {
          break label294;
        }
        this.FEN = true;
        if ((Math.abs(f3) <= this.FEM) || (Math.abs(f2) <= Math.abs(f1))) {
          break;
        }
        localObject = this.FEK;
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
      this.FEN = true;
      paramMotionEvent = this.FEL;
      if (paramMotionEvent != null) {}
      for (paramMotionEvent = paramMotionEvent.getLayoutParams();; paramMotionEvent = null)
      {
        paramMotionEvent = (ViewGroup.MarginLayoutParams)paramMotionEvent;
        if ((this.FEK == null) || (paramMotionEvent == null)) {
          break;
        }
        paramMotionEvent.topMargin = ((int)(f3 / 15.0F));
        localObject = this.FEL;
        if (localObject == null) {
          break;
        }
        ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramMotionEvent);
        break;
      }
      localObject = this.ol;
      if (localObject != null) {
        ((VelocityTracker)localObject).clear();
      }
      localObject = this.ol;
      if (localObject != null) {
        ((VelocityTracker)localObject).recycle();
      }
      this.ol = null;
      if (this.FEO == 1)
      {
        localObject = this.FEK;
        if (localObject != null) {
          ((PullDownListView)localObject).dispatchTouchEvent(paramMotionEvent);
        }
      }
      else if (this.FEO == 2)
      {
        paramMotionEvent = this.FEK;
        if (paramMotionEvent != null) {
          paramMotionEvent.hbX();
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
  
  public final int fsk()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.c
 * JD-Core Version:    0.7.0.1
 */