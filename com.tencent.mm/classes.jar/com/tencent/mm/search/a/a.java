package com.tencent.mm.search.a;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/search/gesture/GallerySwipeBackConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "galleryView", "Landroid/view/View;", "galleryScaleListener", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "(Landroid/view/View;Lcom/tencent/mm/search/gesture/IOnGalleryScale;)V", "consumed", "", "currScrollType", "", "downX", "", "downY", "getGalleryScaleListener", "()Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "getGalleryView", "()Landroid/view/View;", "maxDownX", "moveExitY", "totalMovedX", "totalMovedY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "touchRelease", "touchTranslate", "Companion", "plugin-emojisdk_release"})
public final class a
  extends com.tencent.mm.ui.j.a
{
  public static final a.a Iil;
  private int BcN;
  private int Bdi;
  private final int Bdj;
  private float Bdk;
  private float Bdl;
  private boolean Bdm;
  private final View Bdn;
  private final b Iik;
  private float cNg;
  private float cNh;
  private VelocityTracker oj;
  
  static
  {
    AppMethodBeat.i(218996);
    Iil = new a.a((byte)0);
    AppMethodBeat.o(218996);
  }
  
  public a(View paramView, b paramb)
  {
    AppMethodBeat.i(218995);
    this.Bdn = paramView;
    this.Iik = paramb;
    this.Bdi = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 32);
    this.Bdj = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 96);
    AppMethodBeat.o(218995);
  }
  
  private final void nn()
  {
    AppMethodBeat.i(218994);
    VelocityTracker localVelocityTracker = this.oj;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    localVelocityTracker = this.oj;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    this.oj = null;
    AppMethodBeat.o(218994);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    int i = 1;
    boolean bool = true;
    AppMethodBeat.i(218993);
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
      paramBoolean = this.Bdm;
      AppMethodBeat.o(218993);
      return paramBoolean;
      this.cNg = paramMotionEvent.getRawX();
      this.cNh = paramMotionEvent.getRawY();
      continue;
      if (paramBoolean)
      {
        this.BcN = paramInt;
        if (paramInt == 8)
        {
          paramBoolean = bool;
          if (this.cNg < this.Bdi) {}
        }
        else
        {
          if (paramInt != 2) {
            break label258;
          }
          paramBoolean = bool;
        }
        label154:
        this.Bdm = paramBoolean;
        float f1 = paramMotionEvent.getRawX();
        float f2 = paramMotionEvent.getRawY();
        this.Bdk = (f1 - this.cNg);
        this.Bdl = (f2 - this.cNh);
        if (this.Bdm)
        {
          this.Bdn.animate().cancel();
          if (this.BcN == 2) {}
          for (f1 = this.Bdl;; f1 = this.Bdk * this.Bdn.getHeight() / this.Bdn.getWidth())
          {
            f2 = f1;
            if (f1 < 0.0F) {
              f2 = 0.0F;
            }
            this.Bdn.setTranslationY(f2);
            this.Bdn.getHeight();
            break;
            label258:
            paramBoolean = false;
            break label154;
          }
          if (this.Bdm)
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
            if (this.BcN != 2) {
              break label434;
            }
            paramInt = i;
            if (this.Bdl <= this.Bdj)
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
            this.Iik.aqy();
          }
          for (;;)
          {
            this.BcN = 0;
            this.Bdk = 0.0F;
            this.Bdl = 0.0F;
            this.Bdm = false;
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
            if (this.Bdk > this.Bdn.getWidth() / 2) {
              break label377;
            }
            paramInt = i;
            if (f1 > 50.0F) {
              break label377;
            }
            paramInt = 0;
            break label377;
            label471:
            this.Bdn.animate().translationY(0.0F).start();
          }
          this.BcN = 0;
          this.Bdn.setTranslationY(0.0F);
          this.Bdk = 0.0F;
          this.Bdl = 0.0F;
          this.Bdm = false;
          nn();
        }
      }
    }
  }
  
  public final int emc()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.a.a
 * JD-Core Version:    0.7.0.1
 */