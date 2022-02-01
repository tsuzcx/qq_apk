package com.tencent.mm.plugin.story.ui.view.gallery;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GallerySwipeBackConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "galleryView", "Landroid/view/View;", "galleryScaleListener", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "(Landroid/view/View;Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;)V", "consumed", "", "currScrollType", "", "downX", "", "downY", "getGalleryScaleListener", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "getGalleryView", "()Landroid/view/View;", "maxDownX", "moveExitY", "totalMovedX", "totalMovedY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "touchRelease", "touchTranslate", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.ui.o.a
{
  public static final f.a SAP;
  private static final String TAG;
  private final View SAQ;
  private final StoryGalleryView.b SAR;
  private int SAS;
  private final int SAT;
  private float SAU;
  private float SAV;
  private boolean SAW;
  private int SAx;
  private VelocityTracker doL;
  private float fif;
  private float fig;
  
  static
  {
    AppMethodBeat.i(120378);
    SAP = new f.a((byte)0);
    TAG = "MicroMsg.GallerySwipeBackConsumer";
    AppMethodBeat.o(120378);
  }
  
  public f(View paramView, StoryGalleryView.b paramb)
  {
    AppMethodBeat.i(120377);
    this.SAQ = paramView;
    this.SAR = paramb;
    this.SAS = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 32);
    this.SAT = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 96);
    AppMethodBeat.o(120377);
  }
  
  private final void Jg()
  {
    AppMethodBeat.i(120376);
    VelocityTracker localVelocityTracker = this.doL;
    if (localVelocityTracker != null) {
      localVelocityTracker.clear();
    }
    localVelocityTracker = this.doL;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    this.doL = null;
    AppMethodBeat.o(120376);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    int i = 1;
    boolean bool = true;
    AppMethodBeat.i(120375);
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
      AppMethodBeat.o(120375);
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
            break label277;
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
            f1 = f2 / this.SAQ.getHeight();
            this.SAR.dv(0.8F - f1);
            break;
            label277:
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
              break label439;
            }
            f1 = 0.0F;
            label344:
            paramMotionEvent = this.doL;
            if (paramMotionEvent != null) {
              break label448;
            }
            f2 = 0.0F;
            label356:
            if (this.SAx != 2) {
              break label462;
            }
            paramInt = i;
            if (this.SAV <= this.SAT)
            {
              if (f2 <= 0.0F) {
                break label457;
              }
              paramInt = i;
            }
            label390:
            if (paramInt == 0) {
              break label499;
            }
            paramMotionEvent = h.SqZ;
            h.ano(13);
            this.SAR.bkW();
          }
          for (;;)
          {
            this.SAx = 0;
            this.SAU = 0.0F;
            this.SAV = 0.0F;
            this.SAW = false;
            Jg();
            break;
            label439:
            f1 = paramMotionEvent.getXVelocity();
            break label344;
            label448:
            f2 = paramMotionEvent.getYVelocity();
            break label356;
            label457:
            paramInt = 0;
            break label390;
            label462:
            paramInt = i;
            if (this.SAU > this.SAQ.getWidth() / 2) {
              break label390;
            }
            paramInt = i;
            if (f1 > 50.0F) {
              break label390;
            }
            paramInt = 0;
            break label390;
            label499:
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
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.f
 * JD-Core Version:    0.7.0.1
 */