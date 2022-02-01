package com.tencent.mm.plugin.story.ui.view.gallery;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GallerySwipeBackConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "galleryView", "Landroid/view/View;", "galleryScaleListener", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "(Landroid/view/View;Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;)V", "consumed", "", "currScrollType", "", "downX", "", "downY", "getGalleryScaleListener", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "getGalleryView", "()Landroid/view/View;", "maxDownX", "moveExitY", "totalMovedX", "totalMovedY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "touchRelease", "touchTranslate", "Companion", "plugin-story_release"})
public final class f
  extends com.tencent.mm.ui.j.a
{
  public static final f.a BuN;
  private static final String TAG = "MicroMsg.GallerySwipeBackConsumer";
  private int BuG;
  private final int BuH;
  private float BuI;
  private float BuJ;
  private boolean BuK;
  private final View BuL;
  private final StoryGalleryView.b BuM;
  private int Bul;
  private float cNQ;
  private float cNR;
  private VelocityTracker oj;
  
  static
  {
    AppMethodBeat.i(120378);
    BuN = new f.a((byte)0);
    TAG = "MicroMsg.GallerySwipeBackConsumer";
    AppMethodBeat.o(120378);
  }
  
  public f(View paramView, StoryGalleryView.b paramb)
  {
    AppMethodBeat.i(120377);
    this.BuL = paramView;
    this.BuM = paramb;
    this.BuG = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 32);
    this.BuH = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 96);
    AppMethodBeat.o(120377);
  }
  
  private final void nn()
  {
    AppMethodBeat.i(120376);
    VelocityTracker localVelocityTracker = this.oj;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    localVelocityTracker = this.oj;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    this.oj = null;
    AppMethodBeat.o(120376);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    int i = 1;
    boolean bool = true;
    AppMethodBeat.i(120375);
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
      AppMethodBeat.o(120375);
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
            break label277;
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
            f1 = f2 / this.BuL.getHeight();
            this.BuM.bG(0.8F - f1);
            break;
            label277:
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
              break label445;
            }
            f1 = paramMotionEvent.getXVelocity();
            label347:
            paramMotionEvent = this.oj;
            if (paramMotionEvent == null) {
              break label451;
            }
            f2 = paramMotionEvent.getYVelocity();
            label362:
            if (this.Bul != 2) {
              break label462;
            }
            paramInt = i;
            if (this.BuJ <= this.BuH)
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
            paramMotionEvent = h.BjR;
            h.SX(13);
            this.BuM.aqN();
          }
          for (;;)
          {
            this.Bul = 0;
            this.BuI = 0.0F;
            this.BuJ = 0.0F;
            this.BuK = false;
            nn();
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
            if (this.BuI > this.BuL.getWidth() / 2) {
              break label396;
            }
            paramInt = i;
            if (f1 > 50.0F) {
              break label396;
            }
            paramInt = 0;
            break label396;
            label499:
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
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.f
 * JD-Core Version:    0.7.0.1
 */