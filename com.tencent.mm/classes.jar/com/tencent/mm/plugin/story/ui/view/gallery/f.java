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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GallerySwipeBackConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "galleryView", "Landroid/view/View;", "galleryScaleListener", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "(Landroid/view/View;Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;)V", "consumed", "", "currScrollType", "", "downX", "", "downY", "getGalleryScaleListener", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "getGalleryView", "()Landroid/view/View;", "maxDownX", "moveExitY", "totalMovedX", "totalMovedY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "touchRelease", "touchTranslate", "Companion", "plugin-story_release"})
public final class f
  extends com.tencent.mm.ui.m.a
{
  public static final f.a FFA;
  private static final String TAG = "MicroMsg.GallerySwipeBackConsumer";
  private int FEY;
  private int FFt;
  private final int FFu;
  private float FFv;
  private float FFw;
  private boolean FFx;
  private final View FFy;
  private final StoryGalleryView.b FFz;
  private float deo;
  private float dep;
  private VelocityTracker ol;
  
  static
  {
    AppMethodBeat.i(120378);
    FFA = new f.a((byte)0);
    TAG = "MicroMsg.GallerySwipeBackConsumer";
    AppMethodBeat.o(120378);
  }
  
  public f(View paramView, StoryGalleryView.b paramb)
  {
    AppMethodBeat.i(120377);
    this.FFy = paramView;
    this.FFz = paramb;
    this.FFt = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 32);
    this.FFu = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 96);
    AppMethodBeat.o(120377);
  }
  
  private final void np()
  {
    AppMethodBeat.i(120376);
    VelocityTracker localVelocityTracker = this.ol;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    localVelocityTracker = this.ol;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    this.ol = null;
    AppMethodBeat.o(120376);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    int i = 1;
    boolean bool = true;
    AppMethodBeat.i(120375);
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
      AppMethodBeat.o(120375);
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
            break label277;
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
            f1 = f2 / this.FFy.getHeight();
            this.FFz.ca(0.8F - f1);
            break;
            label277:
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
              break label445;
            }
            f1 = paramMotionEvent.getXVelocity();
            label347:
            paramMotionEvent = this.ol;
            if (paramMotionEvent == null) {
              break label451;
            }
            f2 = paramMotionEvent.getYVelocity();
            label362:
            if (this.FEY != 2) {
              break label462;
            }
            paramInt = i;
            if (this.FFw <= this.FFu)
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
            paramMotionEvent = h.FuH;
            h.aaT(13);
            this.FFz.aJl();
          }
          for (;;)
          {
            this.FEY = 0;
            this.FFv = 0.0F;
            this.FFw = 0.0F;
            this.FFx = false;
            np();
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
            if (this.FFv > this.FFy.getWidth() / 2) {
              break label396;
            }
            paramInt = i;
            if (f1 > 50.0F) {
              break label396;
            }
            paramInt = 0;
            break label396;
            label499:
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
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.f
 * JD-Core Version:    0.7.0.1
 */