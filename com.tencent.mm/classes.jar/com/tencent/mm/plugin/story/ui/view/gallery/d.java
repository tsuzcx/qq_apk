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
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryOverScrollConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "()V", "currScrollType", "", "downX", "", "downY", "galleryView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "getGalleryView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "setGalleryView", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;)V", "totalScrollY", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "showExitHint", "", "Companion", "plugin-story_release"})
public final class d
  extends a
{
  private static final String TAG = "MicroMsg.GalleryOverScrollConsumer";
  public static final a yxY;
  private float cEZ;
  private float cFa;
  private int xJD;
  StoryGalleryView ypA;
  private int yxX;
  
  static
  {
    AppMethodBeat.i(120351);
    yxY = new a((byte)0);
    TAG = "MicroMsg.GalleryOverScrollConsumer";
    AppMethodBeat.o(120351);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    AppMethodBeat.i(120350);
    k.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(120350);
      return bool1;
      this.cEZ = paramMotionEvent.getX();
      this.cFa = paramMotionEvent.getY();
      continue;
      if (paramBoolean)
      {
        this.yxX = paramInt;
        if (paramInt == 1) {}
        for (paramBoolean = bool2;; paramBoolean = false)
        {
          float f = paramMotionEvent.getY() - this.cFa;
          if (f > 0.0F) {
            break label314;
          }
          paramMotionEvent = this.ypA;
          if (paramMotionEvent == null) {
            break label157;
          }
          this.xJD = (-(int)f);
          paramMotionEvent.animate().cancel();
          paramMotionEvent.setTranslationY(f / 2.0F);
          bool1 = paramBoolean;
          break;
        }
        label157:
        bool1 = paramBoolean;
        continue;
        if ((this.xJD > 0) && (this.yxX == 1))
        {
          paramMotionEvent = this.ypA;
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
          this.yxX = 0;
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
          h.cc(localContext, localContext.getString(2131764238));
        }
        this.xJD = 0;
        continue;
        ad.i(TAG, "LogStory: touch cancel");
        this.yxX = 0;
        paramMotionEvent = this.ypA;
        if (paramMotionEvent != null) {
          paramMotionEvent.setTranslationY(0.0F);
        }
        this.xJD = 0;
        continue;
        label314:
        bool1 = paramBoolean;
      }
    }
  }
  
  public final int dLn()
  {
    return 1;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryOverScrollConsumer$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.d
 * JD-Core Version:    0.7.0.1
 */