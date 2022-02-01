package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.j.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryOverScrollConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "()V", "currScrollType", "", "downX", "", "downY", "galleryView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "getGalleryView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "setGalleryView", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;)V", "totalScrollY", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "showExitHint", "", "Companion", "plugin-story_release"})
public final class d
  extends a
{
  public static final d.a Bum;
  private static final String TAG = "MicroMsg.GalleryOverScrollConsumer";
  private int AFq;
  StoryGalleryView BlW;
  private int Bul;
  private float cNQ;
  private float cNR;
  
  static
  {
    AppMethodBeat.i(120351);
    Bum = new d.a((byte)0);
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
      this.cNQ = paramMotionEvent.getX();
      this.cNR = paramMotionEvent.getY();
      continue;
      if (paramBoolean)
      {
        this.Bul = paramInt;
        if (paramInt == 1) {}
        for (paramBoolean = bool2;; paramBoolean = false)
        {
          float f = paramMotionEvent.getY() - this.cNR;
          if (f > 0.0F) {
            break label314;
          }
          paramMotionEvent = this.BlW;
          if (paramMotionEvent == null) {
            break label157;
          }
          this.AFq = (-(int)f);
          paramMotionEvent.animate().cancel();
          paramMotionEvent.setTranslationY(f / 2.0F);
          bool1 = paramBoolean;
          break;
        }
        label157:
        bool1 = paramBoolean;
        continue;
        if ((this.AFq > 0) && (this.Bul == 1))
        {
          paramMotionEvent = this.BlW;
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
          this.Bul = 0;
          Context localContext = ak.getContext();
          Object localObject = localContext.getSystemService("vibrator");
          paramMotionEvent = localObject;
          if (!(localObject instanceof Vibrator)) {
            paramMotionEvent = null;
          }
          paramMotionEvent = (Vibrator)paramMotionEvent;
          if (paramMotionEvent != null) {
            paramMotionEvent.vibrate(10L);
          }
          h.cj(localContext, localContext.getString(2131764238));
        }
        this.AFq = 0;
        continue;
        ae.i(TAG, "LogStory: touch cancel");
        this.Bul = 0;
        paramMotionEvent = this.BlW;
        if (paramMotionEvent != null) {
          paramMotionEvent.setTranslationY(0.0F);
        }
        this.AFq = 0;
        continue;
        label314:
        bool1 = paramBoolean;
      }
    }
  }
  
  public final int epL()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.d
 * JD-Core Version:    0.7.0.1
 */