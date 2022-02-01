package com.tencent.mm.plugin.story.ui.view.gallery;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GallerySwipeBackConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "galleryView", "Landroid/view/View;", "galleryScaleListener", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "(Landroid/view/View;Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;)V", "consumed", "", "currScrollType", "", "downX", "", "downY", "getGalleryScaleListener", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "getGalleryView", "()Landroid/view/View;", "maxDownX", "moveExitY", "totalMovedX", "totalMovedY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "touchRelease", "touchTranslate", "Companion", "plugin-story_release"})
public final class f
  extends com.tencent.mm.ui.j.a
{
  private static final String TAG = "MicroMsg.GallerySwipeBackConsumer";
  public static final a yyz;
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
  private final StoryGalleryView.b yyy;
  
  static
  {
    AppMethodBeat.i(120378);
    yyz = new a((byte)0);
    TAG = "MicroMsg.GallerySwipeBackConsumer";
    AppMethodBeat.o(120378);
  }
  
  public f(View paramView, StoryGalleryView.b paramb)
  {
    AppMethodBeat.i(120377);
    this.yyx = paramView;
    this.yyy = paramb;
    this.yys = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 32);
    this.yyt = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 96);
    AppMethodBeat.o(120377);
  }
  
  private final void mL()
  {
    AppMethodBeat.i(120376);
    VelocityTracker localVelocityTracker = this.lr;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    localVelocityTracker = this.lr;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    this.lr = null;
    AppMethodBeat.o(120376);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    int i = 1;
    boolean bool = true;
    AppMethodBeat.i(120375);
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
      AppMethodBeat.o(120375);
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
            break label277;
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
            f1 = f2 / this.yyx.getHeight();
            this.yyy.bx(0.8F - f1);
            break;
            label277:
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
              break label445;
            }
            f1 = paramMotionEvent.getXVelocity();
            label347:
            paramMotionEvent = this.lr;
            if (paramMotionEvent == null) {
              break label451;
            }
            f2 = paramMotionEvent.getYVelocity();
            label362:
            if (this.yxX != 2) {
              break label462;
            }
            paramInt = i;
            if (this.yyv <= this.yyt)
            {
              if (f2 <= 0.0F) {
                break label457;
              }
              paramInt = i;
            }
            label396:
            if (paramInt == 0) {
              break label499;
            }
            paramMotionEvent = h.ynv;
            h.OB(13);
            this.yyy.dKU();
          }
          for (;;)
          {
            this.yxX = 0;
            this.yyu = 0.0F;
            this.yyv = 0.0F;
            this.yyw = false;
            mL();
            break;
            label445:
            f1 = 0.0F;
            break label347;
            label451:
            f2 = 0.0F;
            break label362;
            label457:
            paramInt = 0;
            break label396;
            label462:
            paramInt = i;
            if (this.yyu > this.yyx.getWidth() / 2) {
              break label396;
            }
            paramInt = i;
            if (f1 > 50.0F) {
              break label396;
            }
            paramInt = 0;
            break label396;
            label499:
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GallerySwipeBackConsumer$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.f
 * JD-Core Version:    0.7.0.1
 */