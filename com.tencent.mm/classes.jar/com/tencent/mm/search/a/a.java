package com.tencent.mm.search.a;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/search/gesture/GallerySwipeBackConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "galleryView", "Landroid/view/View;", "galleryScaleListener", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "(Landroid/view/View;Lcom/tencent/mm/search/gesture/IOnGalleryScale;)V", "consumed", "", "currScrollType", "", "downX", "", "downY", "getGalleryScaleListener", "()Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "getGalleryView", "()Landroid/view/View;", "maxDownX", "moveExitY", "totalMovedX", "totalMovedY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "touchRelease", "touchTranslate", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.ui.o.a
{
  public static final a.a acsc;
  private final View SAQ;
  private int SAS;
  private final int SAT;
  private float SAU;
  private float SAV;
  private boolean SAW;
  private int SAx;
  private final b acsd;
  private VelocityTracker doL;
  private float fif;
  private float fig;
  
  static
  {
    AppMethodBeat.i(236865);
    acsc = new a.a((byte)0);
    AppMethodBeat.o(236865);
  }
  
  public a(View paramView, b paramb)
  {
    AppMethodBeat.i(236858);
    this.SAQ = paramView;
    this.acsd = paramb;
    this.SAS = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 32);
    this.SAT = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 96);
    AppMethodBeat.o(236858);
  }
  
  private final void Jg()
  {
    AppMethodBeat.i(236862);
    VelocityTracker localVelocityTracker = this.doL;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    localVelocityTracker = this.doL;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    this.doL = null;
    AppMethodBeat.o(236862);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    int i = 1;
    boolean bool = true;
    AppMethodBeat.i(236872);
    s.u(paramMotionEvent, "event");
    if (this.doL == null) {
      this.doL = VelocityTracker.obtain();
    }
    VelocityTracker localVelocityTracker = this.doL;
    if (localVelocityTracker != null) {
      localVelocityTracker.addMovement(paramMotionEvent);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      paramBoolean = this.SAW;
      AppMethodBeat.o(236872);
      return paramBoolean;
      this.fif = paramMotionEvent.getRawX();
      this.fig = paramMotionEvent.getRawY();
      continue;
      if (paramBoolean)
      {
        this.SAx = paramInt;
        if (paramInt == 8)
        {
          paramBoolean = bool;
          if (this.fif < this.SAS) {}
        }
        else
        {
          if (paramInt != 2) {
            break label258;
          }
          paramBoolean = bool;
        }
        label154:
        this.SAW = paramBoolean;
        float f1 = paramMotionEvent.getRawX();
        float f2 = paramMotionEvent.getRawY();
        this.SAU = (f1 - this.fif);
        this.SAV = (f2 - this.fig);
        if (this.SAW)
        {
          this.SAQ.animate().cancel();
          if (this.SAx == 2) {}
          for (f1 = this.SAV;; f1 = this.SAU * this.SAQ.getHeight() / this.SAQ.getWidth())
          {
            f2 = f1;
            if (f1 < 0.0F) {
              f2 = 0.0F;
            }
            this.SAQ.setTranslationY(f2);
            this.SAQ.getHeight();
            break;
            label258:
            paramBoolean = false;
            break label154;
          }
          if (this.SAW)
          {
            paramMotionEvent = this.doL;
            if (paramMotionEvent != null) {
              paramMotionEvent.computeCurrentVelocity(1000);
            }
            paramMotionEvent = this.doL;
            if (paramMotionEvent != null) {
              break label411;
            }
            f1 = 0.0F;
            label325:
            paramMotionEvent = this.doL;
            if (paramMotionEvent != null) {
              break label420;
            }
            f2 = 0.0F;
            label337:
            if (this.SAx != 2) {
              break label434;
            }
            paramInt = i;
            if (this.SAV <= this.SAT)
            {
              if (f2 <= 0.0F) {
                break label429;
              }
              paramInt = i;
            }
            label371:
            if (paramInt == 0) {
              break label471;
            }
            this.acsd.bkW();
          }
          for (;;)
          {
            this.SAx = 0;
            this.SAU = 0.0F;
            this.SAV = 0.0F;
            this.SAW = false;
            Jg();
            break;
            label411:
            f1 = paramMotionEvent.getXVelocity();
            break label325;
            label420:
            f2 = paramMotionEvent.getYVelocity();
            break label337;
            label429:
            paramInt = 0;
            break label371;
            label434:
            paramInt = i;
            if (this.SAU > this.SAQ.getWidth() / 2) {
              break label371;
            }
            paramInt = i;
            if (f1 > 50.0F) {
              break label371;
            }
            paramInt = 0;
            break label371;
            label471:
            this.SAQ.animate().translationY(0.0F).start();
          }
          this.SAx = 0;
          this.SAQ.setTranslationY(0.0F);
          this.SAU = 0.0F;
          this.SAV = 0.0F;
          this.SAW = false;
          Jg();
        }
      }
    }
  }
  
  public final int hAc()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.a.a
 * JD-Core Version:    0.7.0.1
 */