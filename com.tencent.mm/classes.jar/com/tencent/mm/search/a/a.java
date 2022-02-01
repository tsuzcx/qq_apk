package com.tencent.mm.search.a;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/search/gesture/GallerySwipeBackConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "galleryView", "Landroid/view/View;", "galleryScaleListener", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "(Landroid/view/View;Lcom/tencent/mm/search/gesture/IOnGalleryScale;)V", "consumed", "", "currScrollType", "", "downX", "", "downY", "getGalleryScaleListener", "()Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "getGalleryView", "()Landroid/view/View;", "maxDownX", "moveExitY", "totalMovedX", "totalMovedY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "touchRelease", "touchTranslate", "Companion", "plugin-emojisdk_release"})
public final class a
  extends com.tencent.mm.ui.m.a
{
  public static final a.a NJq;
  private int FEY;
  private int FFt;
  private final int FFu;
  private float FFv;
  private float FFw;
  private boolean FFx;
  private final View FFy;
  private final b NJp;
  private float deo;
  private float dep;
  private VelocityTracker ol;
  
  static
  {
    AppMethodBeat.i(200085);
    NJq = new a.a((byte)0);
    AppMethodBeat.o(200085);
  }
  
  public a(View paramView, b paramb)
  {
    AppMethodBeat.i(200084);
    this.FFy = paramView;
    this.NJp = paramb;
    this.FFt = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 32);
    this.FFu = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 96);
    AppMethodBeat.o(200084);
  }
  
  private final void np()
  {
    AppMethodBeat.i(200083);
    VelocityTracker localVelocityTracker = this.ol;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    localVelocityTracker = this.ol;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    this.ol = null;
    AppMethodBeat.o(200083);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    int i = 1;
    boolean bool = true;
    AppMethodBeat.i(200082);
    p.h(paramMotionEvent, "event");
    if (this.ol == null) {
      this.ol = VelocityTracker.obtain();
    }
    VelocityTracker localVelocityTracker = this.ol;
    if (localVelocityTracker != null) {
      localVelocityTracker.addMovement(paramMotionEvent);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      paramBoolean = this.FFx;
      AppMethodBeat.o(200082);
      return paramBoolean;
      this.deo = paramMotionEvent.getRawX();
      this.dep = paramMotionEvent.getRawY();
      continue;
      if (paramBoolean)
      {
        this.FEY = paramInt;
        if (paramInt == 8)
        {
          paramBoolean = bool;
          if (this.deo < this.FFt) {}
        }
        else
        {
          if (paramInt != 2) {
            break label258;
          }
          paramBoolean = bool;
        }
        label154:
        this.FFx = paramBoolean;
        float f1 = paramMotionEvent.getRawX();
        float f2 = paramMotionEvent.getRawY();
        this.FFv = (f1 - this.deo);
        this.FFw = (f2 - this.dep);
        if (this.FFx)
        {
          this.FFy.animate().cancel();
          if (this.FEY == 2) {}
          for (f1 = this.FFw;; f1 = this.FFv * this.FFy.getHeight() / this.FFy.getWidth())
          {
            f2 = f1;
            if (f1 < 0.0F) {
              f2 = 0.0F;
            }
            this.FFy.setTranslationY(f2);
            this.FFy.getHeight();
            break;
            label258:
            paramBoolean = false;
            break label154;
          }
          if (this.FFx)
          {
            paramMotionEvent = this.ol;
            if (paramMotionEvent != null) {
              paramMotionEvent.computeCurrentVelocity(1000);
            }
            paramMotionEvent = this.ol;
            if (paramMotionEvent == null) {
              break label417;
            }
            f1 = paramMotionEvent.getXVelocity();
            label328:
            paramMotionEvent = this.ol;
            if (paramMotionEvent == null) {
              break label423;
            }
            f2 = paramMotionEvent.getYVelocity();
            label343:
            if (this.FEY != 2) {
              break label434;
            }
            paramInt = i;
            if (this.FFw <= this.FFu)
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
            this.NJp.aJl();
          }
          for (;;)
          {
            this.FEY = 0;
            this.FFv = 0.0F;
            this.FFw = 0.0F;
            this.FFx = false;
            np();
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
            if (this.FFv > this.FFy.getWidth() / 2) {
              break label377;
            }
            paramInt = i;
            if (f1 > 50.0F) {
              break label377;
            }
            paramInt = 0;
            break label377;
            label471:
            this.FFy.animate().translationY(0.0F).start();
          }
          this.FEY = 0;
          this.FFy.setTranslationY(0.0F);
          this.FFv = 0.0F;
          this.FFw = 0.0F;
          this.FFx = false;
          np();
        }
      }
    }
  }
  
  public final int fsk()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.a.a
 * JD-Core Version:    0.7.0.1
 */