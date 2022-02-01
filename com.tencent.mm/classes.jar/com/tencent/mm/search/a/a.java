package com.tencent.mm.search.a;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/search/gesture/GallerySwipeBackConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "galleryView", "Landroid/view/View;", "galleryScaleListener", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "(Landroid/view/View;Lcom/tencent/mm/search/gesture/IOnGalleryScale;)V", "consumed", "", "currScrollType", "", "downX", "", "downY", "getGalleryScaleListener", "()Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "getGalleryView", "()Landroid/view/View;", "maxDownX", "moveExitY", "totalMovedX", "totalMovedY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "touchRelease", "touchTranslate", "Companion", "plugin-emojisdk_release"})
public final class a
  extends com.tencent.mm.ui.o.a
{
  public static final a UWR;
  private int LYZ;
  private int LZt;
  private final int LZu;
  private float LZv;
  private float LZw;
  private boolean LZx;
  private final View LZy;
  private final b UWQ;
  private VelocityTracker bvI;
  private float dit;
  private float diu;
  
  static
  {
    AppMethodBeat.i(225355);
    UWR = new a((byte)0);
    AppMethodBeat.o(225355);
  }
  
  public a(View paramView, b paramb)
  {
    AppMethodBeat.i(225352);
    this.LZy = paramView;
    this.UWQ = paramb;
    this.LZt = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 32);
    this.LZu = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 96);
    AppMethodBeat.o(225352);
  }
  
  private final void ky()
  {
    AppMethodBeat.i(225350);
    VelocityTracker localVelocityTracker = this.bvI;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    localVelocityTracker = this.bvI;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    this.bvI = null;
    AppMethodBeat.o(225350);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    int i = 1;
    boolean bool = true;
    AppMethodBeat.i(225347);
    p.k(paramMotionEvent, "event");
    if (this.bvI == null) {
      this.bvI = VelocityTracker.obtain();
    }
    VelocityTracker localVelocityTracker = this.bvI;
    if (localVelocityTracker != null) {
      localVelocityTracker.addMovement(paramMotionEvent);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      paramBoolean = this.LZx;
      AppMethodBeat.o(225347);
      return paramBoolean;
      this.dit = paramMotionEvent.getRawX();
      this.diu = paramMotionEvent.getRawY();
      continue;
      if (paramBoolean)
      {
        this.LYZ = paramInt;
        if (paramInt == 8)
        {
          paramBoolean = bool;
          if (this.dit < this.LZt) {}
        }
        else
        {
          if (paramInt != 2) {
            break label258;
          }
          paramBoolean = bool;
        }
        label154:
        this.LZx = paramBoolean;
        float f1 = paramMotionEvent.getRawX();
        float f2 = paramMotionEvent.getRawY();
        this.LZv = (f1 - this.dit);
        this.LZw = (f2 - this.diu);
        if (this.LZx)
        {
          this.LZy.animate().cancel();
          if (this.LYZ == 2) {}
          for (f1 = this.LZw;; f1 = this.LZv * this.LZy.getHeight() / this.LZy.getWidth())
          {
            f2 = f1;
            if (f1 < 0.0F) {
              f2 = 0.0F;
            }
            this.LZy.setTranslationY(f2);
            this.LZy.getHeight();
            break;
            label258:
            paramBoolean = false;
            break label154;
          }
          if (this.LZx)
          {
            paramMotionEvent = this.bvI;
            if (paramMotionEvent != null) {
              paramMotionEvent.computeCurrentVelocity(1000);
            }
            paramMotionEvent = this.bvI;
            if (paramMotionEvent == null) {
              break label417;
            }
            f1 = paramMotionEvent.getXVelocity();
            label328:
            paramMotionEvent = this.bvI;
            if (paramMotionEvent == null) {
              break label423;
            }
            f2 = paramMotionEvent.getYVelocity();
            label343:
            if (this.LYZ != 2) {
              break label434;
            }
            paramInt = i;
            if (this.LZw <= this.LZu)
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
            this.UWQ.aRj();
          }
          for (;;)
          {
            this.LYZ = 0;
            this.LZv = 0.0F;
            this.LZw = 0.0F;
            this.LZx = false;
            ky();
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
            if (this.LZv > this.LZy.getWidth() / 2) {
              break label377;
            }
            paramInt = i;
            if (f1 > 50.0F) {
              break label377;
            }
            paramInt = 0;
            break label377;
            label471:
            this.LZy.animate().translationY(0.0F).start();
          }
          this.LYZ = 0;
          this.LZy.setTranslationY(0.0F);
          this.LZv = 0.0F;
          this.LZw = 0.0F;
          this.LZx = false;
          ky();
        }
      }
    }
  }
  
  public final int ggJ()
  {
    return 10;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/search/gesture/GallerySwipeBackConsumer$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.a.a
 * JD-Core Version:    0.7.0.1
 */