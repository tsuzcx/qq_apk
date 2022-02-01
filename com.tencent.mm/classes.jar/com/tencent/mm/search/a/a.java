package com.tencent.mm.search.a;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/search/gesture/GallerySwipeBackConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "galleryView", "Landroid/view/View;", "galleryScaleListener", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "(Landroid/view/View;Lcom/tencent/mm/search/gesture/IOnGalleryScale;)V", "consumed", "", "currScrollType", "", "downX", "", "downY", "getGalleryScaleListener", "()Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "getGalleryView", "()Landroid/view/View;", "maxDownX", "moveExitY", "totalMovedX", "totalMovedY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "touchRelease", "touchTranslate", "Companion", "plugin-emojisdk_release"})
public final class a
  extends com.tencent.mm.ui.j.a
{
  public static final a.a ICw;
  private int BuG;
  private final int BuH;
  private float BuI;
  private float BuJ;
  private boolean BuK;
  private final View BuL;
  private int Bul;
  private final b ICv;
  private float cNQ;
  private float cNR;
  private VelocityTracker oj;
  
  static
  {
    AppMethodBeat.i(188618);
    ICw = new a.a((byte)0);
    AppMethodBeat.o(188618);
  }
  
  public a(View paramView, b paramb)
  {
    AppMethodBeat.i(188617);
    this.BuL = paramView;
    this.ICv = paramb;
    this.BuG = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 32);
    this.BuH = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 96);
    AppMethodBeat.o(188617);
  }
  
  private final void nn()
  {
    AppMethodBeat.i(188616);
    VelocityTracker localVelocityTracker = this.oj;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    localVelocityTracker = this.oj;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    this.oj = null;
    AppMethodBeat.o(188616);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    int i = 1;
    boolean bool = true;
    AppMethodBeat.i(188615);
    p.h(paramMotionEvent, "event");
    if (this.oj == null) {
      this.oj = VelocityTracker.obtain();
    }
    VelocityTracker localVelocityTracker = this.oj;
    if (localVelocityTracker != null) {
      localVelocityTracker.addMovement(paramMotionEvent);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      paramBoolean = this.BuK;
      AppMethodBeat.o(188615);
      return paramBoolean;
      this.cNQ = paramMotionEvent.getRawX();
      this.cNR = paramMotionEvent.getRawY();
      continue;
      if (paramBoolean)
      {
        this.Bul = paramInt;
        if (paramInt == 8)
        {
          paramBoolean = bool;
          if (this.cNQ < this.BuG) {}
        }
        else
        {
          if (paramInt != 2) {
            break label258;
          }
          paramBoolean = bool;
        }
        label154:
        this.BuK = paramBoolean;
        float f1 = paramMotionEvent.getRawX();
        float f2 = paramMotionEvent.getRawY();
        this.BuI = (f1 - this.cNQ);
        this.BuJ = (f2 - this.cNR);
        if (this.BuK)
        {
          this.BuL.animate().cancel();
          if (this.Bul == 2) {}
          for (f1 = this.BuJ;; f1 = this.BuI * this.BuL.getHeight() / this.BuL.getWidth())
          {
            f2 = f1;
            if (f1 < 0.0F) {
              f2 = 0.0F;
            }
            this.BuL.setTranslationY(f2);
            this.BuL.getHeight();
            break;
            label258:
            paramBoolean = false;
            break label154;
          }
          if (this.BuK)
          {
            paramMotionEvent = this.oj;
            if (paramMotionEvent != null) {
              paramMotionEvent.computeCurrentVelocity(1000);
            }
            paramMotionEvent = this.oj;
            if (paramMotionEvent == null) {
              break label417;
            }
            f1 = paramMotionEvent.getXVelocity();
            label328:
            paramMotionEvent = this.oj;
            if (paramMotionEvent == null) {
              break label423;
            }
            f2 = paramMotionEvent.getYVelocity();
            label343:
            if (this.Bul != 2) {
              break label434;
            }
            paramInt = i;
            if (this.BuJ <= this.BuH)
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
            this.ICv.aqN();
          }
          for (;;)
          {
            this.Bul = 0;
            this.BuI = 0.0F;
            this.BuJ = 0.0F;
            this.BuK = false;
            nn();
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
            if (this.BuI > this.BuL.getWidth() / 2) {
              break label377;
            }
            paramInt = i;
            if (f1 > 50.0F) {
              break label377;
            }
            paramInt = 0;
            break label377;
            label471:
            this.BuL.animate().translationY(0.0F).start();
          }
          this.Bul = 0;
          this.BuL.setTranslationY(0.0F);
          this.BuI = 0.0F;
          this.BuJ = 0.0F;
          this.BuK = false;
          nn();
        }
      }
    }
  }
  
  public final int epL()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.a.a
 * JD-Core Version:    0.7.0.1
 */