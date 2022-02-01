package com.tencent.mm.search.a;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/search/gesture/GallerySwipeBackConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "galleryView", "Landroid/view/View;", "galleryScaleListener", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "(Landroid/view/View;Lcom/tencent/mm/search/gesture/IOnGalleryScale;)V", "consumed", "", "currScrollType", "", "downX", "", "downY", "getGalleryScaleListener", "()Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "getGalleryView", "()Landroid/view/View;", "maxDownX", "moveExitY", "totalMovedX", "totalMovedY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "touchRelease", "touchTranslate", "Companion", "plugin-emojisdk_release"})
public final class a
  extends com.tencent.mm.ui.j.a
{
  public static final a.a Gwr;
  private final b Gwq;
  private float cCh;
  private float cCi;
  private VelocityTracker mq;
  private int zLH;
  private final int zLI;
  private float zLJ;
  private float zLK;
  private boolean zLL;
  private final View zLM;
  private int zLm;
  
  static
  {
    AppMethodBeat.i(209870);
    Gwr = new a.a((byte)0);
    AppMethodBeat.o(209870);
  }
  
  public a(View paramView, b paramb)
  {
    AppMethodBeat.i(209869);
    this.zLM = paramView;
    this.Gwq = paramb;
    this.zLH = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 32);
    this.zLI = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 96);
    AppMethodBeat.o(209869);
  }
  
  private final void mV()
  {
    AppMethodBeat.i(209868);
    VelocityTracker localVelocityTracker = this.mq;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    localVelocityTracker = this.mq;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    this.mq = null;
    AppMethodBeat.o(209868);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    int i = 1;
    boolean bool = true;
    AppMethodBeat.i(209867);
    k.h(paramMotionEvent, "event");
    if (this.mq == null) {
      this.mq = VelocityTracker.obtain();
    }
    VelocityTracker localVelocityTracker = this.mq;
    if (localVelocityTracker != null) {
      localVelocityTracker.addMovement(paramMotionEvent);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      paramBoolean = this.zLL;
      AppMethodBeat.o(209867);
      return paramBoolean;
      this.cCh = paramMotionEvent.getRawX();
      this.cCi = paramMotionEvent.getRawY();
      continue;
      if (paramBoolean)
      {
        this.zLm = paramInt;
        if (paramInt == 8)
        {
          paramBoolean = bool;
          if (this.cCh < this.zLH) {}
        }
        else
        {
          if (paramInt != 2) {
            break label258;
          }
          paramBoolean = bool;
        }
        label154:
        this.zLL = paramBoolean;
        float f1 = paramMotionEvent.getRawX();
        float f2 = paramMotionEvent.getRawY();
        this.zLJ = (f1 - this.cCh);
        this.zLK = (f2 - this.cCi);
        if (this.zLL)
        {
          this.zLM.animate().cancel();
          if (this.zLm == 2) {}
          for (f1 = this.zLK;; f1 = this.zLJ * this.zLM.getHeight() / this.zLM.getWidth())
          {
            f2 = f1;
            if (f1 < 0.0F) {
              f2 = 0.0F;
            }
            this.zLM.setTranslationY(f2);
            this.zLM.getHeight();
            break;
            label258:
            paramBoolean = false;
            break label154;
          }
          if (this.zLL)
          {
            paramMotionEvent = this.mq;
            if (paramMotionEvent != null) {
              paramMotionEvent.computeCurrentVelocity(1000);
            }
            paramMotionEvent = this.mq;
            if (paramMotionEvent == null) {
              break label417;
            }
            f1 = paramMotionEvent.getXVelocity();
            label328:
            paramMotionEvent = this.mq;
            if (paramMotionEvent == null) {
              break label423;
            }
            f2 = paramMotionEvent.getYVelocity();
            label343:
            if (this.zLm != 2) {
              break label434;
            }
            paramInt = i;
            if (this.zLK <= this.zLI)
            {
              if (f2 <= 0.0F) {
                break label429;
              }
              paramInt = i;
            }
            label377:
            if (paramInt == 0) {
              break label471;
            }
            this.Gwq.anM();
          }
          for (;;)
          {
            this.zLm = 0;
            this.zLJ = 0.0F;
            this.zLK = 0.0F;
            this.zLL = false;
            mV();
            break;
            label417:
            f1 = 0.0F;
            break label328;
            label423:
            f2 = 0.0F;
            break label343;
            label429:
            paramInt = 0;
            break label377;
            label434:
            paramInt = i;
            if (this.zLJ > this.zLM.getWidth() / 2) {
              break label377;
            }
            paramInt = i;
            if (f1 > 50.0F) {
              break label377;
            }
            paramInt = 0;
            break label377;
            label471:
            this.zLM.animate().translationY(0.0F).start();
          }
          this.zLm = 0;
          this.zLM.setTranslationY(0.0F);
          this.zLJ = 0.0F;
          this.zLK = 0.0F;
          this.zLL = false;
          mV();
        }
      }
    }
  }
  
  public final int dZN()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.search.a.a
 * JD-Core Version:    0.7.0.1
 */