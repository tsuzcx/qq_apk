package com.tencent.mm.plugin.story.ui.view.gallery;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GallerySwipeBackConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "galleryView", "Landroid/view/View;", "galleryScaleListener", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "(Landroid/view/View;Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;)V", "consumed", "", "currScrollType", "", "downX", "", "downY", "getGalleryScaleListener", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "getGalleryView", "()Landroid/view/View;", "maxDownX", "moveExitY", "totalMovedX", "totalMovedY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "touchRelease", "touchTranslate", "Companion", "plugin-story_release"})
public final class f
  extends com.tencent.mm.ui.j.a
{
  private static final String TAG = "MicroMsg.GallerySwipeBackConsumer";
  public static final f.a zLO;
  private float cCh;
  private float cCi;
  private VelocityTracker mq;
  private int zLH;
  private final int zLI;
  private float zLJ;
  private float zLK;
  private boolean zLL;
  private final View zLM;
  private final StoryGalleryView.b zLN;
  private int zLm;
  
  static
  {
    AppMethodBeat.i(120378);
    zLO = new f.a((byte)0);
    TAG = "MicroMsg.GallerySwipeBackConsumer";
    AppMethodBeat.o(120378);
  }
  
  public f(View paramView, StoryGalleryView.b paramb)
  {
    AppMethodBeat.i(120377);
    this.zLM = paramView;
    this.zLN = paramb;
    this.zLH = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 32);
    this.zLI = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 96);
    AppMethodBeat.o(120377);
  }
  
  private final void mV()
  {
    AppMethodBeat.i(120376);
    VelocityTracker localVelocityTracker = this.mq;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    localVelocityTracker = this.mq;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    this.mq = null;
    AppMethodBeat.o(120376);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    int i = 1;
    boolean bool = true;
    AppMethodBeat.i(120375);
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
      AppMethodBeat.o(120375);
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
            break label277;
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
            f1 = f2 / this.zLM.getHeight();
            this.zLN.bF(0.8F - f1);
            break;
            label277:
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
              break label445;
            }
            f1 = paramMotionEvent.getXVelocity();
            label347:
            paramMotionEvent = this.mq;
            if (paramMotionEvent == null) {
              break label451;
            }
            f2 = paramMotionEvent.getYVelocity();
            label362:
            if (this.zLm != 2) {
              break label462;
            }
            paramInt = i;
            if (this.zLK <= this.zLI)
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
            paramMotionEvent = h.zAU;
            h.QH(13);
            this.zLN.anM();
          }
          for (;;)
          {
            this.zLm = 0;
            this.zLJ = 0.0F;
            this.zLK = 0.0F;
            this.zLL = false;
            mV();
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
            if (this.zLJ > this.zLM.getWidth() / 2) {
              break label396;
            }
            paramInt = i;
            if (f1 > 50.0F) {
              break label396;
            }
            paramInt = 0;
            break label396;
            label499:
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
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.f
 * JD-Core Version:    0.7.0.1
 */