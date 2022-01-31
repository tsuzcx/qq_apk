package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.sdk.platformtools.ah;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GallerySwipeBackConsumer;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollConsumer;", "galleryView", "Landroid/view/View;", "galleryScaleListener", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "(Landroid/view/View;Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;)V", "consumed", "", "currScrollType", "", "downX", "", "downY", "getGalleryScaleListener", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "getGalleryView", "()Landroid/view/View;", "maxDownX", "moveExitY", "totalMovedX", "totalMovedY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "touchRelease", "touchTranslate", "Companion", "plugin-story_release"})
public final class h
  extends e
{
  private static final String TAG = "MicroMsg.GallerySwipeBackConsumer";
  public static final h.a sSI;
  private float bTE;
  private float bTF;
  private VelocityTracker gie;
  private int sRV;
  private int sSB;
  private final int sSC;
  private float sSD;
  private float sSE;
  private boolean sSF;
  private final View sSG;
  private final StoryGalleryView.b sSH;
  
  static
  {
    AppMethodBeat.i(110749);
    sSI = new h.a((byte)0);
    TAG = "MicroMsg.GallerySwipeBackConsumer";
    AppMethodBeat.o(110749);
  }
  
  public h(View paramView, StoryGalleryView.b paramb)
  {
    AppMethodBeat.i(110748);
    this.sSG = paramView;
    this.sSH = paramb;
    this.sSB = a.fromDPToPix(ah.getContext(), 32);
    this.sSC = a.fromDPToPix(ah.getContext(), 96);
    AppMethodBeat.o(110748);
  }
  
  private final void ld()
  {
    AppMethodBeat.i(110747);
    VelocityTracker localVelocityTracker = this.gie;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    localVelocityTracker = this.gie;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    this.gie = null;
    AppMethodBeat.o(110747);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    int i = 1;
    boolean bool = true;
    AppMethodBeat.i(110746);
    j.q(paramMotionEvent, "event");
    if (this.gie == null) {
      this.gie = VelocityTracker.obtain();
    }
    VelocityTracker localVelocityTracker = this.gie;
    if (localVelocityTracker != null) {
      localVelocityTracker.addMovement(paramMotionEvent);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      paramBoolean = this.sSF;
      AppMethodBeat.o(110746);
      return paramBoolean;
      this.bTE = paramMotionEvent.getRawX();
      this.bTF = paramMotionEvent.getRawY();
      continue;
      if (paramBoolean)
      {
        this.sRV = paramInt;
        if (paramInt == 8)
        {
          paramBoolean = bool;
          if (this.bTE < this.sSB) {}
        }
        else
        {
          if (paramInt != 2) {
            break label277;
          }
          paramBoolean = bool;
        }
        label154:
        this.sSF = paramBoolean;
        float f1 = paramMotionEvent.getRawX();
        float f2 = paramMotionEvent.getRawY();
        this.sSD = (f1 - this.bTE);
        this.sSE = (f2 - this.bTF);
        if (this.sSF)
        {
          this.sSG.animate().cancel();
          if (this.sRV == 2) {}
          for (f1 = this.sSE;; f1 = this.sSD * this.sSG.getHeight() / this.sSG.getWidth())
          {
            f2 = f1;
            if (f1 < 0.0F) {
              f2 = 0.0F;
            }
            this.sSG.setTranslationY(f2);
            f1 = f2 / this.sSG.getHeight();
            this.sSH.bh(0.8F - f1);
            break;
            label277:
            paramBoolean = false;
            break label154;
          }
          if (this.sSF)
          {
            paramMotionEvent = this.gie;
            if (paramMotionEvent != null) {
              paramMotionEvent.computeCurrentVelocity(1000);
            }
            paramMotionEvent = this.gie;
            if (paramMotionEvent == null) {
              break label445;
            }
            f1 = paramMotionEvent.getXVelocity();
            label347:
            paramMotionEvent = this.gie;
            if (paramMotionEvent == null) {
              break label451;
            }
            f2 = paramMotionEvent.getYVelocity();
            label362:
            if (this.sRV != 2) {
              break label462;
            }
            paramInt = i;
            if (this.sSE <= this.sSC)
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
            paramMotionEvent = i.sFa;
            i.FU(13);
            this.sSH.cFn();
          }
          for (;;)
          {
            this.sRV = 0;
            this.sSD = 0.0F;
            this.sSE = 0.0F;
            this.sSF = false;
            ld();
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
            if (this.sSD > this.sSG.getWidth() / 2) {
              break label396;
            }
            paramInt = i;
            if (f1 > 50.0F) {
              break label396;
            }
            paramInt = 0;
            break label396;
            label499:
            this.sSG.animate().translationY(0.0F).start();
          }
          this.sRV = 0;
          this.sSG.setTranslationY(0.0F);
          this.sSD = 0.0F;
          this.sSE = 0.0F;
          this.sSF = false;
          ld();
        }
      }
    }
  }
  
  public final int cFW()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.h
 * JD-Core Version:    0.7.0.1
 */