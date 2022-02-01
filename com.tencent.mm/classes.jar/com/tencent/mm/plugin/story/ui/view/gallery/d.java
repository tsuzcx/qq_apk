package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.j.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryOverScrollConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "()V", "currScrollType", "", "downX", "", "downY", "galleryView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "getGalleryView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "setGalleryView", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;)V", "totalScrollY", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "showExitHint", "", "Companion", "plugin-story_release"})
public final class d
  extends a
{
  public static final d.a BcO;
  private static final String TAG = "MicroMsg.GalleryOverScrollConsumer";
  StoryGalleryView AUy;
  private int Aod;
  private int BcN;
  private float cNg;
  private float cNh;
  
  static
  {
    AppMethodBeat.i(120351);
    BcO = new d.a((byte)0);
    TAG = "MicroMsg.GalleryOverScrollConsumer";
    AppMethodBeat.o(120351);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    AppMethodBeat.i(120350);
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(120350);
      return bool1;
      this.cNg = paramMotionEvent.getX();
      this.cNh = paramMotionEvent.getY();
      continue;
      if (paramBoolean)
      {
        this.BcN = paramInt;
        if (paramInt == 1) {}
        for (paramBoolean = bool2;; paramBoolean = false)
        {
          float f = paramMotionEvent.getY() - this.cNh;
          if (f > 0.0F) {
            break label314;
          }
          paramMotionEvent = this.AUy;
          if (paramMotionEvent == null) {
            break label157;
          }
          this.Aod = (-(int)f);
          paramMotionEvent.animate().cancel();
          paramMotionEvent.setTranslationY(f / 2.0F);
          bool1 = paramBoolean;
          break;
        }
        label157:
        bool1 = paramBoolean;
        continue;
        if ((this.Aod > 0) && (this.BcN == 1))
        {
          paramMotionEvent = this.AUy;
          if (paramMotionEvent != null)
          {
            paramMotionEvent = paramMotionEvent.animate();
            if (paramMotionEvent != null)
            {
              paramMotionEvent = paramMotionEvent.translationY(0.0F);
              if (paramMotionEvent != null) {
                paramMotionEvent.start();
              }
            }
          }
          this.BcN = 0;
          Context localContext = aj.getContext();
          Object localObject = localContext.getSystemService("vibrator");
          paramMotionEvent = localObject;
          if (!(localObject instanceof Vibrator)) {
            paramMotionEvent = null;
          }
          paramMotionEvent = (Vibrator)paramMotionEvent;
          if (paramMotionEvent != null) {
            paramMotionEvent.vibrate(10L);
          }
          h.ci(localContext, localContext.getString(2131764238));
        }
        this.Aod = 0;
        continue;
        ad.i(TAG, "LogStory: touch cancel");
        this.BcN = 0;
        paramMotionEvent = this.AUy;
        if (paramMotionEvent != null) {
          paramMotionEvent.setTranslationY(0.0F);
        }
        this.Aod = 0;
        continue;
        label314:
        bool1 = paramBoolean;
      }
    }
  }
  
  public final int emc()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.d
 * JD-Core Version:    0.7.0.1
 */