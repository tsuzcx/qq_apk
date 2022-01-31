package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryOverScrollConsumer;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollConsumer;", "()V", "currScrollType", "", "downX", "", "downY", "galleryView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "getGalleryView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "setGalleryView", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;)V", "totalScrollY", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "showExitHint", "", "Companion", "plugin-story_release"})
public final class d
  extends e
{
  private static final String TAG = "MicroMsg.GalleryOverScrollConsumer";
  public static final d.a sRW;
  private float bTE;
  private float bTF;
  StoryGalleryView sHi;
  private int sRV;
  private int sbd;
  
  static
  {
    AppMethodBeat.i(110725);
    sRW = new d.a((byte)0);
    TAG = "MicroMsg.GalleryOverScrollConsumer";
    AppMethodBeat.o(110725);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    AppMethodBeat.i(110724);
    j.q(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110724);
      return bool1;
      this.bTE = paramMotionEvent.getX();
      this.bTF = paramMotionEvent.getY();
      continue;
      if (paramBoolean)
      {
        this.sRV = paramInt;
        if (paramInt == 1) {}
        for (paramBoolean = bool2;; paramBoolean = false)
        {
          float f = paramMotionEvent.getY() - this.bTF;
          if (f > 0.0F) {
            break label314;
          }
          paramMotionEvent = this.sHi;
          if (paramMotionEvent == null) {
            break label157;
          }
          this.sbd = (-(int)f);
          paramMotionEvent.animate().cancel();
          paramMotionEvent.setTranslationY(f / 2.0F);
          bool1 = paramBoolean;
          break;
        }
        label157:
        bool1 = paramBoolean;
        continue;
        if ((this.sbd > 0) && (this.sRV == 1))
        {
          paramMotionEvent = this.sHi;
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
          this.sRV = 0;
          Context localContext = ah.getContext();
          Object localObject = localContext.getSystemService("vibrator");
          paramMotionEvent = localObject;
          if (!(localObject instanceof Vibrator)) {
            paramMotionEvent = null;
          }
          paramMotionEvent = (Vibrator)paramMotionEvent;
          if (paramMotionEvent != null) {
            paramMotionEvent.vibrate(10L);
          }
          h.bL(localContext, localContext.getString(2131304137));
        }
        this.sbd = 0;
        continue;
        ab.i(TAG, "LogStory: touch cancel");
        this.sRV = 0;
        paramMotionEvent = this.sHi;
        if (paramMotionEvent != null) {
          paramMotionEvent.setTranslationY(0.0F);
        }
        this.sbd = 0;
        continue;
        label314:
        bool1 = paramBoolean;
      }
    }
  }
  
  public final int cFW()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.d
 * JD-Core Version:    0.7.0.1
 */