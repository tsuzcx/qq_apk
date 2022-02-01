package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.o.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryOverScrollConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "()V", "currScrollType", "", "downX", "", "downY", "galleryView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "getGalleryView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "setGalleryView", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;)V", "totalScrollY", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "showExitHint", "", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  public static final d.a SAw;
  private static final String TAG;
  private int SAx;
  StoryGalleryView StB;
  private float fif;
  private float fig;
  private int uiX;
  
  static
  {
    AppMethodBeat.i(120351);
    SAw = new d.a((byte)0);
    TAG = "MicroMsg.GalleryOverScrollConsumer";
    AppMethodBeat.o(120351);
  }
  
  public final boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    AppMethodBeat.i(120350);
    s.u(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(120350);
      return bool1;
      this.fif = paramMotionEvent.getX();
      this.fig = paramMotionEvent.getY();
      continue;
      if (paramBoolean)
      {
        this.SAx = paramInt;
        if (paramInt == 1) {}
        for (paramBoolean = bool2;; paramBoolean = false)
        {
          float f = paramMotionEvent.getY() - this.fig;
          if (f > 0.0F) {
            break label307;
          }
          paramMotionEvent = this.StB;
          if (paramMotionEvent == null) {
            break label307;
          }
          this.uiX = (-(int)f);
          paramMotionEvent.animate().cancel();
          paramMotionEvent.setTranslationY(f / 2.0F);
          bool1 = paramBoolean;
          break;
        }
        Context localContext;
        if ((this.uiX > 0) && (this.SAx == 1))
        {
          paramMotionEvent = this.StB;
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
          this.SAx = 0;
          localContext = MMApplicationContext.getContext();
          paramMotionEvent = localContext.getSystemService("vibrator");
          if (!(paramMotionEvent instanceof Vibrator)) {
            break label267;
          }
        }
        label267:
        for (paramMotionEvent = (Vibrator)paramMotionEvent;; paramMotionEvent = null)
        {
          if (paramMotionEvent != null) {
            paramMotionEvent.vibrate(10L);
          }
          k.cZ(localContext, localContext.getString(a.g.ShA));
          this.uiX = 0;
          break;
        }
        Log.i(TAG, "LogStory: touch cancel");
        this.SAx = 0;
        paramMotionEvent = this.StB;
        if (paramMotionEvent != null) {
          paramMotionEvent.setTranslationY(0.0F);
        }
        this.uiX = 0;
        continue;
        label307:
        bool1 = paramBoolean;
      }
    }
  }
  
  public final int hAc()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.d
 * JD-Core Version:    0.7.0.1
 */