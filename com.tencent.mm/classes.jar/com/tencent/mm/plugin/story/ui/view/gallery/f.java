package com.tencent.mm.plugin.story.ui.view.gallery;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GallerySwipeBackConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "galleryView", "Landroid/view/View;", "galleryScaleListener", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "(Landroid/view/View;Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;)V", "consumed", "", "currScrollType", "", "downX", "", "downY", "getGalleryScaleListener", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "getGalleryView", "()Landroid/view/View;", "maxDownX", "moveExitY", "totalMovedX", "totalMovedY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "touchRelease", "touchTranslate", "Companion", "plugin-story_release"})
public final class f
  extends com.tencent.mm.ui.o.a
{
  public static final a LZA;
  private static final String TAG = "MicroMsg.GallerySwipeBackConsumer";
  private int LYZ;
  private int LZt;
  private final int LZu;
  private float LZv;
  private float LZw;
  private boolean LZx;
  private final View LZy;
  private final StoryGalleryView.b LZz;
  private VelocityTracker bvI;
  private float dit;
  private float diu;
  
  static
  {
    AppMethodBeat.i(120378);
    LZA = new a((byte)0);
    TAG = "MicroMsg.GallerySwipeBackConsumer";
    AppMethodBeat.o(120378);
  }
  
  public f(View paramView, StoryGalleryView.b paramb)
  {
    AppMethodBeat.i(120377);
    this.LZy = paramView;
    this.LZz = paramb;
    this.LZt = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 32);
    this.LZu = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 96);
    AppMethodBeat.o(120377);
  }
  
  private final void ky()
  {
    AppMethodBeat.i(120376);
    VelocityTracker localVelocityTracker = this.bvI;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    localVelocityTracker = this.bvI;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    this.bvI = null;
    AppMethodBeat.o(120376);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    int i = 1;
    boolean bool = true;
    AppMethodBeat.i(120375);
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
      AppMethodBeat.o(120375);
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
            break label277;
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
            f1 = f2 / this.LZy.getHeight();
            this.LZz.cj(0.8F - f1);
            break;
            label277:
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
              break label445;
            }
            f1 = paramMotionEvent.getXVelocity();
            label347:
            paramMotionEvent = this.bvI;
            if (paramMotionEvent == null) {
              break label451;
            }
            f2 = paramMotionEvent.getYVelocity();
            label362:
            if (this.LYZ != 2) {
              break label462;
            }
            paramInt = i;
            if (this.LZw <= this.LZu)
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
            paramMotionEvent = h.LOJ;
            h.aio(13);
            this.LZz.aRj();
          }
          for (;;)
          {
            this.LYZ = 0;
            this.LZv = 0.0F;
            this.LZw = 0.0F;
            this.LZx = false;
            ky();
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
            if (this.LZv > this.LZy.getWidth() / 2) {
              break label396;
            }
            paramInt = i;
            if (f1 > 50.0F) {
              break label396;
            }
            paramInt = 0;
            break label396;
            label499:
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GallerySwipeBackConsumer$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.f
 * JD-Core Version:    0.7.0.1
 */