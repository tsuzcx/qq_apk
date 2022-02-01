package com.tencent.mm.search.d;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/search/gesture/GallerySwipeBackConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "galleryView", "Landroid/view/View;", "galleryScaleListener", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "(Landroid/view/View;Lcom/tencent/mm/search/gesture/IOnGalleryScale;)V", "consumed", "", "currScrollType", "", "downX", "", "downY", "getGalleryScaleListener", "()Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "getGalleryView", "()Landroid/view/View;", "maxDownX", "moveExitY", "totalMovedX", "totalMovedY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "touchRelease", "touchTranslate", "Companion", "plugin-emojisdk_release"})
public final class a
  extends com.tencent.mm.ui.j.a
{
  public static final a LAq;
  private final b LAp;
  private float cEZ;
  private float cFa;
  private VelocityTracker lr;
  private int yxX;
  private int yys;
  private final int yyt;
  private float yyu;
  private float yyv;
  private boolean yyw;
  private final View yyx;
  
  static
  {
    AppMethodBeat.i(202407);
    LAq = new a((byte)0);
    AppMethodBeat.o(202407);
  }
  
  public a(View paramView, b paramb)
  {
    AppMethodBeat.i(202406);
    this.yyx = paramView;
    this.LAp = paramb;
    this.yys = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 32);
    this.yyt = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 96);
    AppMethodBeat.o(202406);
  }
  
  private final void mL()
  {
    AppMethodBeat.i(202405);
    VelocityTracker localVelocityTracker = this.lr;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    localVelocityTracker = this.lr;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    this.lr = null;
    AppMethodBeat.o(202405);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    int i = 1;
    boolean bool = true;
    AppMethodBeat.i(202404);
    k.h(paramMotionEvent, "event");
    if (this.lr == null) {
      this.lr = VelocityTracker.obtain();
    }
    VelocityTracker localVelocityTracker = this.lr;
    if (localVelocityTracker != null) {
      localVelocityTracker.addMovement(paramMotionEvent);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      paramBoolean = this.yyw;
      AppMethodBeat.o(202404);
      return paramBoolean;
      this.cEZ = paramMotionEvent.getRawX();
      this.cFa = paramMotionEvent.getRawY();
      continue;
      if (paramBoolean)
      {
        this.yxX = paramInt;
        if (paramInt == 8)
        {
          paramBoolean = bool;
          if (this.cEZ < this.yys) {}
        }
        else
        {
          if (paramInt != 2) {
            break label258;
          }
          paramBoolean = bool;
        }
        label154:
        this.yyw = paramBoolean;
        float f1 = paramMotionEvent.getRawX();
        float f2 = paramMotionEvent.getRawY();
        this.yyu = (f1 - this.cEZ);
        this.yyv = (f2 - this.cFa);
        if (this.yyw)
        {
          this.yyx.animate().cancel();
          if (this.yxX == 2) {}
          for (f1 = this.yyv;; f1 = this.yyu * this.yyx.getHeight() / this.yyx.getWidth())
          {
            f2 = f1;
            if (f1 < 0.0F) {
              f2 = 0.0F;
            }
            this.yyx.setTranslationY(f2);
            this.yyx.getHeight();
            break;
            label258:
            paramBoolean = false;
            break label154;
          }
          if (this.yyw)
          {
            paramMotionEvent = this.lr;
            if (paramMotionEvent != null) {
              paramMotionEvent.computeCurrentVelocity(1000);
            }
            paramMotionEvent = this.lr;
            if (paramMotionEvent == null) {
              break label417;
            }
            f1 = paramMotionEvent.getXVelocity();
            label328:
            paramMotionEvent = this.lr;
            if (paramMotionEvent == null) {
              break label423;
            }
            f2 = paramMotionEvent.getYVelocity();
            label343:
            if (this.yxX != 2) {
              break label434;
            }
            paramInt = i;
            if (this.yyv <= this.yyt)
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
            this.LAp.dKU();
          }
          for (;;)
          {
            this.yxX = 0;
            this.yyu = 0.0F;
            this.yyv = 0.0F;
            this.yyw = false;
            mL();
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
            if (this.yyu > this.yyx.getWidth() / 2) {
              break label377;
            }
            paramInt = i;
            if (f1 > 50.0F) {
              break label377;
            }
            paramInt = 0;
            break label377;
            label471:
            this.yyx.animate().translationY(0.0F).start();
          }
          this.yxX = 0;
          this.yyx.setTranslationY(0.0F);
          this.yyu = 0.0F;
          this.yyv = 0.0F;
          this.yyw = false;
          mL();
        }
      }
    }
  }
  
  public final int dLn()
  {
    return 10;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/search/gesture/GallerySwipeBackConsumer$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.search.d.a
 * JD-Core Version:    0.7.0.1
 */